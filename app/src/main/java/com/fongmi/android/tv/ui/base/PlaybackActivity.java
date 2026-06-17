package com.fongmi.android.tv.ui.base;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import is.xyz.mpv.BaseMPVView;
import com.fongmi.android.tv.player.engine.MpvPlayerEngine;
import androidx.core.content.ContextCompat;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Player;
import androidx.media3.common.VideoSize;
import androidx.media3.exoplayer.drm.FrameworkMediaDrm;
import androidx.media3.session.MediaController;
import androidx.media3.session.SessionToken;
import androidx.media3.ui.PlayerView;

import com.fongmi.android.tv.R;
import com.fongmi.android.tv.Setting;
import com.fongmi.android.tv.bean.Result;
import com.fongmi.android.tv.player.PlayerManager;
import com.fongmi.android.tv.player.engine.PlaySpec;
import com.fongmi.android.tv.player.exo.ExoUtil;
import com.fongmi.android.tv.service.PlaybackService;
import com.fongmi.android.tv.ui.custom.CustomSeekView;
import com.fongmi.android.tv.utils.ResUtil;
import com.google.common.util.concurrent.ListenableFuture;

public abstract class PlaybackActivity extends BaseActivity implements MediaController.Listener, Player.Listener, ServiceConnection {

    private ListenableFuture<MediaController> mControllerFuture;
    private MediaController mController;
    private PlaybackService mService;
    private boolean audioOnly;
    private boolean redirect;
    private boolean bound;
    private boolean stop;
    private boolean lock;
    private boolean mSurfaceAttached;
    private android.view.View mBlackOverlay;

    protected MediaController controller() {
        return mController;
    }

    protected PlaybackService service() {
        return mService;
    }

    protected PlayerManager player() {
        return mService.player();
    }

    protected boolean isRedirect() {
        return redirect;
    }

    protected void setRedirect(boolean redirect) {
        this.redirect = redirect;
        if (mService != null) mService.setNavigationCallback(redirect ? null : getNavigationCallback(), getPlaybackKey());
    }

    protected boolean isAudioOnly() {
        return audioOnly;
    }

    protected void setAudioOnly(boolean audioOnly) {
        this.audioOnly = audioOnly;
    }

    protected boolean isStop() {
        return stop;
    }

    protected void setStop(boolean stop) {
        this.stop = stop;
    }

    protected boolean isLock() {
        return lock;
    }

    protected void setLock(boolean lock) {
        this.lock = lock;
    }

    protected abstract PlaybackService.NavigationCallback getNavigationCallback();

    protected abstract CustomSeekView getSeekView();

    protected abstract PlayerView getExoView();

    protected abstract String getPlaybackKey();

    protected boolean isOwner() {
        String key = getPlaybackKey();
        return key == null || (mService != null && key.equals(player().getKey()));
    }

    protected boolean isIdle() {
        return mController.getPlaybackState() == Player.STATE_IDLE;
    }

    protected boolean isEnded() {
        return mController.getPlaybackState() == Player.STATE_ENDED;
    }

    protected boolean isBuffering() {
        return mController.getPlaybackState() == Player.STATE_BUFFERING;
    }

    protected boolean isPaused() {
        return !isBuffering() && !isIdle();
    }

    protected void onServiceConnected() {
    }

    protected void onPrepare() {
    }

    protected void onTracksChanged() {
    }

    protected void onTitlesChanged() {
    }

    protected void onError(String msg) {
    }

    protected void onPlayingChanged(boolean isPlaying) {
    }

    protected void onStateChanged(int state) {
    }

    protected void onSizeChanged(VideoSize size) {
    }

    protected void onReclaim() {
    }

    protected void showOverlay() {
        showOverlay(500);
    }

    protected void showOverlay(int delayMs) {
        if (mBlackOverlay != null) {
            mBlackOverlay.setVisibility(android.view.View.VISIBLE);
            getExoView().postDelayed(() -> mBlackOverlay.setVisibility(android.view.View.GONE), delayMs);
        }
    }

    protected void seekTo(long time) {
        mController.seekTo(player().getPosition() + time);
        mController.play();
    }

    protected void startPlayer(String key, Result result, boolean useParse, long timeout, MediaMetadata metadata) {
        if (result.getDrm() != null && !FrameworkMediaDrm.isCryptoSchemeSupported(result.getDrm().getUUID())) {
            onError(ResUtil.getString(R.string.error_play_drm));
        } else if (result.hasMsg()) {
            onError(result.getMsg());
        } else if (result.needParse() || useParse) {
            attachSurface();
            player().parse(key, result, useParse, metadata);
        } else {
            attachSurface();
            player().start(PlaySpec.from(result, key, metadata), timeout);
        }
    }

    private void bindPlaybackService() {
        startService(new Intent(this, PlaybackService.class));
        bindService(new Intent(this, PlaybackService.class).setAction(PlaybackService.LOCAL_BIND_ACTION), this, BIND_AUTO_CREATE);
        buildControllerAsync();
        bound = true;
    }

    private void buildControllerAsync() {
        SessionToken token = new SessionToken(this, new ComponentName(this, PlaybackService.class));
        mControllerFuture = new MediaController.Builder(this, token).setListener(this).buildAsync();
        mControllerFuture.addListener(this::onControllerConnected, ContextCompat.getMainExecutor(this));
    }

    private void onControllerConnected() {
        try {
            mController = mControllerFuture.get();
            getSeekView().setPlayer(mController);
            mController.addListener(this);
        } catch (Exception ignored) {
        }
    }

    private PendingIntent buildSessionIntent() {
        Intent intent = new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        Bundle extras = getIntent().getExtras();
        if (extras != null) intent.putExtras(extras);
        return PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE | PendingIntent.FLAG_UPDATE_CURRENT);
    }

    private boolean shouldReclaim() {
        return mService != null && !isOwner();
    }

    private void closePiP() {
        if (!isInPictureInPictureMode()) return;
        detach();
        finish();
    }

    private void attachSurface() {
        updatePlayerView();
        mSurfaceAttached = true;
    }

    private void detachSurface() {
        if (mpvView != null) {
            try { clearSurface(mpvView); } catch (Throwable ignored) {}
            try { mpvView.setVisibility(android.view.View.GONE); } catch (Throwable ignored) {}
            try { ((android.view.ViewGroup) mpvView.getParent()).removeView(mpvView); } catch (Throwable ignored) {}
            mpvView = null;
        }
        mBlackOverlay.setVisibility(android.view.View.VISIBLE);
        getExoView().setPlayer(null);
        mSurfaceAttached = false;
    }

    private void setRender() {
        if (!mSurfaceAttached) {
            attachSurface();
            return;
        }
        detachSurface();
        attachSurface();
    }

    private void releasePlaybackService() {
        if (mService != null) releaseService(isOwner());
        detach();
    }

    private void releaseService(boolean owner) {
        mService.removePlayerCallback(mPlayerCallback);
        if (owner) mService.setNavigationCallback(null, null);
        if (mService.hasExternalClient() || mService.hasPlayerCallback()) {
            if (owner) mService.suspend();
            mService.resetSessionActivity();
        } else if (owner) {
            mService.shutdown();
        }
    }

    private void detach() {
        releaseController();
        releaseBinding();
    }

    private void releaseController() {
        if (mControllerFuture != null) MediaController.releaseFuture(mControllerFuture);
        if (mController != null) mController.removeListener(this);
        mControllerFuture = null;
        mController = null;
    }

    private void releaseBinding() {
        if (!bound) return;
        bound = false;
        if (mService != null) mService.removePlayerCallback(mPlayerCallback);
        unbindService(this);
        mService = null;
    }

    private final PlaybackService.PlayerCallback mPlayerCallback = new PlaybackService.PlayerCallback() {

        @Override
        public void onPrepare() {
            if (isOwner()) PlaybackActivity.this.onPrepare();
        }

        @Override
        public void onTracksChanged() {
            if (isOwner()) PlaybackActivity.this.onTracksChanged();
        }

        @Override
        public void onTitlesChanged() {
            if (isOwner()) PlaybackActivity.this.onTitlesChanged();
        }

        @Override
        public void onError(String msg) {
            if (isOwner()) PlaybackActivity.this.onError(msg);
        }

        @Override
        public void onPlayerRebuild(Player player) {
            if (isOwner()) setRender();
        }
    };

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        ExoUtil.setPlayerView(getExoView());
        mBlackOverlay = new android.view.View(this);
        mBlackOverlay.setLayoutParams(new android.widget.FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mBlackOverlay.setBackgroundColor(android.graphics.Color.BLACK);
        ((ViewGroup) getExoView().getParent()).addView(mBlackOverlay);
        bindPlaybackService();
    }

    @Override
    public void onIsPlayingChanged(boolean isPlaying) {
        if (!isOwner()) return;
        if (isPlaying) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        } else if (!isBuffering()) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        }
        onPlayingChanged(isPlaying);
    }

    @Override
    public void onPlaybackStateChanged(int state) {
        if (isOwner()) onStateChanged(state);
        if (state == Player.STATE_READY && mBlackOverlay != null) {
            getExoView().postDelayed(() -> mBlackOverlay.setVisibility(android.view.View.GONE), 400);
        }
    }

    @Override
    public void onVideoSizeChanged(@NonNull VideoSize size) {
        if (isOwner()) onSizeChanged(size);
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder binder) {
        mService = ((PlaybackService.LocalBinder) binder).getService();
        mService.replaceBinding(this::closePiP);
        mService.setSessionActivity(buildSessionIntent());
        mService.setNavigationCallback(getNavigationCallback(), getPlaybackKey());
        mService.addPlayerCallback(mPlayerCallback);
        onServiceConnected();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        mService = null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        setRedirect(false);
        if (shouldReclaim()) {
            detachSurface();
            onReclaim();
        }
        if (mBlackOverlay != null) {
            // MPV播放器从PiP恢复时不显示黑屏，避免短暂黑屏
            if (mService != null && player().isMpv()) {
                mBlackOverlay.setVisibility(android.view.View.GONE);
            } else {
                mBlackOverlay.setVisibility(android.view.View.VISIBLE);
                getExoView().postDelayed(() -> mBlackOverlay.setVisibility(android.view.View.GONE), 500);
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isRedirect() && mController != null) mController.pause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (isOwner() && Setting.isBackgroundOff() && mController != null) mController.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releasePlaybackService();
    }

    private void updatePlayerView() {
        if (mService != null && player().isMpv()) {
            mBlackOverlay.setVisibility(android.view.View.VISIBLE);
            clearSurface(getExoView().getVideoSurfaceView());
            if (getExoView().getVideoSurfaceView() != null) {
                getExoView().getVideoSurfaceView().setVisibility(android.view.View.GONE);
            }
            android.view.View shutter = getExoView().findViewById(androidx.media3.ui.R.id.exo_shutter);
            if (shutter != null) {
                shutter.setVisibility(android.view.View.GONE);
            }
            getExoView().setVisibility(android.view.View.VISIBLE);
            getExoView().setPlayer(player().getPlayer());
            getExoView().setBackgroundColor(android.graphics.Color.BLACK);
            if (mpvView == null) {
                setupMpvSurface();
            } else {
                mpvView.setVisibility(android.view.View.VISIBLE);
                ((com.fongmi.android.tv.player.engine.MpvPlayerEngine) player().getEngine()).setMpvView(mpvView);
            }
            getExoView().postDelayed(() -> mBlackOverlay.setVisibility(android.view.View.GONE), 500);
        } else {
            if (mpvView != null) {
                try { clearSurface(mpvView); } catch (Throwable ignored) {}
                try { mpvView.setVisibility(android.view.View.GONE); } catch (Throwable ignored) {}
                try { ((android.view.ViewGroup) mpvView.getParent()).removeView(mpvView); } catch (Throwable ignored) {}
                mpvView = null;
            }
            mBlackOverlay.setVisibility(android.view.View.VISIBLE);
            if (getExoView().getVideoSurfaceView() != null) {
                getExoView().getVideoSurfaceView().setVisibility(android.view.View.VISIBLE);
            }
            getExoView().setVisibility(android.view.View.VISIBLE);
            getExoView().setBackgroundColor(android.graphics.Color.BLACK);
            ExoUtil.setPlayerView(getExoView());
            getExoView().setPlayer(mService != null ? player().getPlayer() : null);
            android.view.View shutter = getExoView().findViewById(androidx.media3.ui.R.id.exo_shutter);
            if (shutter != null) {
                shutter.setVisibility(android.view.View.GONE);
            }
            getExoView().postDelayed(() -> mBlackOverlay.setVisibility(android.view.View.GONE), 500);
        }
    }

    private void clearSurface(android.view.View view) {
        if (!(view instanceof SurfaceView)) return;
        SurfaceView sv = (SurfaceView) view;
        try {
            android.view.SurfaceHolder holder = sv.getHolder();
            if (holder != null && holder.getSurface() != null && holder.getSurface().isValid()) {
                android.graphics.Canvas canvas = holder.lockCanvas();
                if (canvas != null) {
                    canvas.drawColor(android.graphics.Color.BLACK);
                    holder.unlockCanvasAndPost(canvas);
                }
            }
        } catch (Throwable ignored) {}
    }

    private is.xyz.mpv.BaseMPVView mpvView;

    private void setupMpvSurface() {
        if (mpvView != null) return;
        mpvView = new is.xyz.mpv.BaseMPVView(this);
        ViewGroup parent = getExoView();
        android.widget.FrameLayout.LayoutParams lp = new android.widget.FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        lp.gravity = android.view.Gravity.CENTER;
        parent.addView(mpvView, 0, lp);
        com.fongmi.android.tv.player.engine.MpvPlayerEngine eng = (com.fongmi.android.tv.player.engine.MpvPlayerEngine) player().getEngine();
        mpvView.setInitOptions(eng.getInitOptions());
        mpvView.initialize();
        eng.setMpvView(mpvView);
    }
}
