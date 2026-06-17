package is.xyz.mpv;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import defpackage.we0;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseMPVView extends SurfaceView implements SurfaceHolder.Callback {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "mpv";
    private String filePath;
    private final MPV mpv;
    private String voInUse;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseMPVView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context.getClass();
        this.mpv = new MPV();
        this.voInUse = "gpu";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void destroy() {
        getHolder().removeCallback(this);
        this.mpv.destroy();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final MPV getMpv() {
        return this.mpv;
    }

    public abstract void initOptions();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void initialize(String str, String str2) {
        str.getClass();
        str2.getClass();
        MPV mpv = this.mpv;
        Context context = getContext();
        context.getClass();
        mpv.create(context);
        this.mpv.setOptionString("config", "yes");
        this.mpv.setOptionString("config-dir", str);
        String[] strArr = {"gpu-shader-cache-dir", "icc-cache-dir"};
        for (int i = 0; i < 2; i++) {
            this.mpv.setOptionString(strArr[i], str2);
        }
        initOptions();
        this.mpv.init();
        postInitOptions();
        this.mpv.setOptionString("force-window", "no");
        this.mpv.setOptionString("idle", "once");
        getHolder().addCallback(this);
        observeProperties();
    }

    public abstract void observeProperties();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void playFile(String str) {
        str.getClass();
        this.filePath = str;
    }

    public abstract void postInitOptions();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void setVo(String str) {
        str.getClass();
        this.voInUse = str;
        this.mpv.setOptionString("vo", str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        surfaceHolder.getClass();
        this.mpv.setPropertyString("android-surface-size", i2 + "x" + i3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        surfaceHolder.getClass();
        Log.w(TAG, "attaching surface");
        MPV mpv = this.mpv;
        Surface surface = surfaceHolder.getSurface();
        surface.getClass();
        mpv.attachSurface(surface);
        this.mpv.setOptionString("force-window", "yes");
        String str = this.filePath;
        MPV mpv2 = this.mpv;
        if (str == null) {
            mpv2.setPropertyString("vo", this.voInUse);
            return;
        }
        str.getClass();
        mpv2.command("loadfile", str);
        this.filePath = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        surfaceHolder.getClass();
        Log.w(TAG, "detaching surface");
        this.mpv.setPropertyString("vo", "null");
        this.mpv.setPropertyString("force-window", "no");
        this.mpv.detachSurface();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Companion {
        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: is.xyz.mpv.BaseMPVView.Companion.<init>():void type: THIS */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public /* synthetic */ Companion(we0 we0Var) {
            this();
        }

        private Companion() {
        }
    }
}
