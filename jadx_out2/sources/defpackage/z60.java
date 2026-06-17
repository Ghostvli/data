package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;
import defpackage.c00;
import java.io.File;
import java.io.IOException;
import org.greenrobot.eventbus.ThreadMode;
import pl.droidsonroids.gif.a;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class z60 extends FrameLayout implements hg0 {
    public n55 f;
    public a g;
    public PlayerView h;
    public ExoPlayer i;
    public Drawable j;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public z60(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void a() {
        if (this.i != null) {
            return;
        }
        ExoPlayer exoPlayerI = new ExoPlayer.b(getContext()).i();
        this.i = exoPlayerI;
        exoPlayerI.setRepeatMode(2);
        this.i.setPlayWhenReady(true);
        this.i.mute();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void b() {
        if (this.h != null) {
            return;
        }
        PlayerView playerView = (PlayerView) LayoutInflater.from(getContext()).inflate(fm3.s0, (ViewGroup) this, false);
        this.h = playerView;
        addView(playerView, new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final a d(File file) {
        try {
            return new a(file);
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void e() {
        this.f = n55.c(LayoutInflater.from(getContext()), this, true);
        ((iy) getContext()).getLifecycle().a(this);
        n();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f() {
        int iT = q24.t();
        File fileK = w01.k(iT);
        this.j = Drawable.createFromPath(w01.l().getAbsolutePath());
        if (q24.u() == 0 && iT != 0) {
            k(iT);
            return;
        }
        if (q24.u() == 2) {
            m(fileK);
        } else if (q24.u() == 1) {
            g(fileK);
        } else {
            j();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g(File file) {
        this.f.b.setImageDrawable(this.j);
        ImageView imageView = this.f.b;
        a aVarD = d(file);
        this.g = aVarD;
        imageView.setImageDrawable(aVarD);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hg0
    public void h(bt1 bt1Var) {
        PlayerView playerView;
        a aVar = this.g;
        if (aVar != null) {
            aVar.pause();
        }
        if (this.i == null || (playerView = this.h) == null || playerView.getVisibility() != 0 || this.i.getMediaItemCount() == 0) {
            return;
        }
        this.h.setPlayer(null);
        this.i.pause();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hg0
    public void i(bt1 bt1Var) {
        PlayerView playerView;
        a aVar = this.g;
        if (aVar != null) {
            aVar.start();
        }
        if (this.i == null || (playerView = this.h) == null || playerView.getVisibility() != 0 || this.i.getMediaItemCount() == 0) {
            return;
        }
        this.h.setPlayer(this.i);
        this.i.play();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j() {
        Drawable drawable = this.j;
        n55 n55Var = this.f;
        if (drawable != null) {
            n55Var.b.setImageDrawable(drawable);
        } else {
            n55Var.b.setImageResource(fl3.C);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k(int i) {
        if (i == 1) {
            this.f.b.setImageResource(fl3.C);
            return;
        }
        if (i == 2) {
            this.f.b.setImageResource(fl3.D);
        } else if (i == 3) {
            this.f.b.setImageResource(fl3.E);
        } else if (i == 4) {
            this.f.b.setImageResource(fl3.F);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hg0
    public void l(bt1 bt1Var) {
        uu0.d().p(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void m(File file) {
        a();
        b();
        this.h.setPlayer(this.i);
        this.h.setVisibility(0);
        this.f.b.setImageDrawable(this.j);
        this.i.setMediaItem(fg2.c(Uri.fromFile(file)));
        this.i.prepare();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void n() {
        o();
        f();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void o() {
        ExoPlayer exoPlayer = this.i;
        if (exoPlayer != null && exoPlayer.isPlaying()) {
            this.i.stop();
            this.i.clearMediaItems();
        }
        PlayerView playerView = this.h;
        if (playerView != null) {
            playerView.setPlayer(null);
            this.h.setVisibility(8);
        }
        a aVar = this.g;
        if (aVar != null) {
            aVar.stop();
            this.g.f();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode()) {
            return;
        }
        e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @lh4(threadMode = ThreadMode.MAIN)
    public void onConfigEvent(c00 c00Var) {
        if (c00Var.h() == c00.a.WALL) {
            n();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hg0
    public void onDestroy(bt1 bt1Var) {
        uu0.d().r(this);
        a aVar = this.g;
        if (aVar != null) {
            aVar.f();
        }
        PlayerView playerView = this.h;
        if (playerView != null) {
            removeView(playerView);
        }
        ExoPlayer exoPlayer = this.i;
        if (exoPlayer != null) {
            exoPlayer.release();
        }
        this.g = null;
        this.f = null;
        this.i = null;
        this.j = null;
        this.h = null;
    }
}
