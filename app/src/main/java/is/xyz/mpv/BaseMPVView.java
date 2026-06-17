package is.xyz.mpv;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class BaseMPVView extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = "mpv";

    private final MPV mpv;
    private String voInUse = "gpu";
    private String pendingFile;
    private boolean initialized;

    public BaseMPVView(Context context) {
        super(context);
        this.mpv = new MPV();
        setZOrderOnTop(false);
        setZOrderMediaOverlay(true);
        setAlpha(0f);
    }

    public BaseMPVView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mpv = new MPV();
        setZOrderOnTop(false);
        setZOrderMediaOverlay(true);
        setAlpha(0f);
    }

    private String[] initOptions;

    public void setInitOptions(String... options) {
        this.initOptions = options;
    }

    public String[] getInitOptions() {
        return initOptions;
    }

    public MPV getMpv() {
        return mpv;
    }

    public void initialize(String configDir, String cacheDir) {
        mpv.create(getContext());
        mpv.setOptionString("config", "yes");
        mpv.setOptionString("config-dir", configDir);
        mpv.setOptionString("gpu-shader-cache-dir", cacheDir);
        mpv.setOptionString("icc-cache-dir", cacheDir);
        mpv.setOptionString("keepaspect", "no");
        if (initOptions != null) {
            for (int i = 0; i < initOptions.length; i += 2) mpv.setOptionString(initOptions[i], initOptions[i + 1]);
        }
        onInitOptions();
        mpv.init();
        onPostInitOptions();
        mpv.setOptionString("force-window", "no");
        mpv.setOptionString("idle", "once");
        getHolder().addCallback(this);
        onObserveProperties();
        initialized = true;
    }

    public void initialize() {
        initialize("/dev/null", "/dev/null");
    }

    protected void onInitOptions() {
    }

    protected void onPostInitOptions() {
    }

    protected void onObserveProperties() {
    }

    public void playFile(String filePath) {
        this.pendingFile = filePath;
        if (getHolder().getSurface() != null && getHolder().getSurface().isValid()) {
            final String file = pendingFile;
            this.pendingFile = null;
            new Thread(() -> {
                mpv.command("loadfile", file);
            }, "MPV-LoadFile").start();
        }
    }

    public void setVo(String vo) {
        this.voInUse = vo;
        mpv.setOptionString("vo", vo);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.w(TAG, "attaching surface");
        Surface surface = holder.getSurface();
        if (surface == null) return;
        mpv.attachSurface(surface);
        mpv.setOptionString("force-window", "yes");
        if (pendingFile != null) {
            final String file = pendingFile;
            this.pendingFile = null;
            new Thread(() -> {
                mpv.command("loadfile", file);
            }, "MPV-LoadFile").start();
        } else {
            mpv.setPropertyString("vo", voInUse);
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        if (mpv != null) {
            mpv.setPropertyString("android-surface-size", width + "x" + height);
            
            try {
                Boolean paused = mpv.getPropertyBoolean("pause");
                if (paused != null && paused) {
                    Double duration = mpv.getPropertyDouble("duration");
                    boolean isLive = duration == null || duration <= 0;
                    if (!isLive) {
                        new Thread(() -> {
                            try {
                                mpv.command("frame-step");
                                mpv.command("frame-back-step");
                            } catch (Throwable ignored) {}
                        }, "MPV-FrameStep").start();
                    }
                }
            } catch (Throwable ignored) {}
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.w(TAG, "detaching surface");
        mpv.setPropertyString("vo", "null");
        mpv.setPropertyString("force-window", "no");
        mpv.detachSurface();
    }

    private int videoWidth = 16, videoHeight = 9;

    public void setVideoSize(int w, int h) {
        this.videoWidth = w;
        this.videoHeight = h;
        if (w > 0 && h > 0) {
            post(() -> {
                requestLayout();
                post(() -> setAlpha(1f));
            });
        } else {
            post(this::requestLayout);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (videoWidth > 0 && videoHeight > 0) {
            int width = getMeasuredWidth();
            int height = getMeasuredHeight();
            if (width > 0 && height > 0) {
                float viewAspectRatio = (float) width / height;
                float videoAspectRatio = (float) videoWidth / videoHeight;
                float MAX_RATIO_DEFORMATION_FRACTION = 0.01f;
                if (videoAspectRatio / viewAspectRatio - 1 > MAX_RATIO_DEFORMATION_FRACTION) {
                    height = (int) (width / videoAspectRatio);
                } else if (viewAspectRatio / videoAspectRatio - 1 > MAX_RATIO_DEFORMATION_FRACTION) {
                    width = (int) (height * videoAspectRatio);
                }
                setMeasuredDimension(width, height);
            }
        }
    }

    public void destroy() {
        getHolder().removeCallback(this);
        mpv.destroy();
    }
}
