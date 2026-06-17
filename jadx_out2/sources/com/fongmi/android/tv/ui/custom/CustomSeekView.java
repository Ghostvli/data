package com.fongmi.android.tv.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.media3.session.x;
import androidx.media3.ui.DefaultTimeBar;
import androidx.media3.ui.d;
import defpackage.fg2;
import defpackage.fm3;
import defpackage.fy4;
import defpackage.hd3;
import defpackage.me3;
import defpackage.nl3;
import java.util.Formatter;
import java.util.Locale;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class CustomSeekView extends FrameLayout implements hd3.d, d.a {
    public final StringBuilder f;
    public final Formatter g;
    public final TextView h;
    public final TextView i;
    public final DefaultTimeBar j;
    public final Runnable k;
    public long l;
    public long m;
    public long n;
    public boolean o;
    public boolean p;
    public hd3 q;
    public me3 r;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public CustomSeekView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        StringBuilder sb = new StringBuilder();
        this.f = sb;
        this.g = new Formatter(sb, Locale.getDefault());
        LayoutInflater.from(context).inflate(fm3.o0, this);
        this.h = (TextView) findViewById(nl3.f1);
        this.i = (TextView) findViewById(nl3.Y);
        DefaultTimeBar defaultTimeBar = (DefaultTimeBar) findViewById(nl3.k2);
        this.j = defaultTimeBar;
        this.k = new Runnable() { // from class: t60
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.C();
            }
        };
        defaultTimeBar.a(this);
        z();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void setKeyTimeIncrement(long j) {
        if (j > 10800000) {
            this.j.setKeyTimeIncrement(300000L);
            return;
        }
        if (j > 1800000) {
            this.j.setKeyTimeIncrement(RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS);
            return;
        }
        if (j > 900000) {
            this.j.setKeyTimeIncrement(30000L);
        } else if (j > x.DEFAULT_FOREGROUND_SERVICE_TIMEOUT_MS) {
            this.j.setKeyTimeIncrement(15000L);
        } else if (j > 0) {
            this.j.setKeyTimeIncrement(10000L);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void A(long j) {
        if (G()) {
            this.r.f0(j);
            this.r.Y();
            C();
        } else {
            hd3 hd3Var = this.q;
            if (hd3Var != null) {
                hd3Var.seekTo(j);
                C();
                this.q.play();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String B(long j) {
        return fy4.y0(this.f, this.g, j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void C() {
        removeCallbacks(this.k);
        if (this.p) {
            if (G()) {
                D();
            } else if (this.q != null) {
                E();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void D() {
        long jE = this.r.E();
        long jZ = this.r.z();
        if (jZ < 0) {
            jZ = 0;
        }
        if (jZ != this.l) {
            this.l = jZ;
            setKeyTimeIncrement(jZ);
            this.j.setDuration(jZ);
            this.i.setText(B(jZ));
        }
        if (jE != this.m) {
            this.m = jE;
            if (!this.o) {
                this.j.setPosition(jE);
                this.h.setText(B(jE));
            }
        }
        this.j.setBufferedPosition(jE);
        postDelayed(this.k, this.r.S() ? y(jE) : 1000L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void E() {
        long currentPosition = this.q.getCurrentPosition();
        long bufferedPosition = this.q.getBufferedPosition();
        long duration = this.q.getDuration();
        if (duration < 0) {
            duration = 0;
        }
        if (duration != this.l) {
            this.l = duration;
            setKeyTimeIncrement(duration);
            this.j.setDuration(duration);
            this.i.setText(B(duration));
        }
        if (currentPosition != this.m) {
            this.m = currentPosition;
            if (!this.o) {
                this.j.setPosition(currentPosition);
                this.h.setText(B(currentPosition));
            }
        }
        if (bufferedPosition != this.n) {
            this.n = bufferedPosition;
            this.j.setBufferedPosition(bufferedPosition);
        }
        boolean zIsPlaying = this.q.isPlaying();
        Runnable runnable = this.k;
        if (zIsPlaying) {
            postDelayed(runnable, y(currentPosition));
        } else {
            postDelayed(runnable, 1000L);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void F() {
        long j;
        if (this.p) {
            if (G()) {
                long jZ = this.r.z();
                j = jZ >= 0 ? jZ : 0L;
                this.l = j;
                setKeyTimeIncrement(j);
                this.j.setDuration(j);
                this.i.setText(B(j));
                C();
                return;
            }
            hd3 hd3Var = this.q;
            if (hd3Var != null) {
                long duration = hd3Var.getDuration();
                j = duration >= 0 ? duration : 0L;
                this.l = j;
                setKeyTimeIncrement(j);
                this.j.setDuration(j);
                this.i.setText(B(j));
                C();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean G() {
        me3 me3Var = this.r;
        return me3Var != null && me3Var.Q();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.ui.d.a
    public void a(d dVar, long j) {
        this.o = true;
        this.h.setText(B(j));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.p = true;
        F();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.p = false;
        removeCallbacks(this.k);
        super.onDetachedFromWindow();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public void onMediaItemTransition(fg2 fg2Var, int i) {
        z();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.ui.d.a
    public void s(d dVar, long j) {
        this.h.setText(B(j));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setPlayer(hd3 hd3Var) {
        this.q = hd3Var;
        hd3Var.addListener(this);
        if (this.p) {
            F();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setPlayerManager(me3 me3Var) {
        this.r = me3Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.ui.d.a
    public void v(d dVar, long j, boolean z) {
        this.o = false;
        if (z) {
            return;
        }
        A(j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long y(long j) {
        return fy4.t((long) (Math.min(this.j.getPreferredUpdateDelay(), 1000 - (j % 1000)) / Math.max(G() ? this.r.G() : this.q.getPlaybackParameters().a, 0.1f)), 200L, 1000L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void z() {
        this.h.setText("00:00");
        this.i.setText("00:00");
        DefaultTimeBar defaultTimeBar = this.j;
        this.m = 0L;
        defaultTimeBar.setPosition(0L);
        DefaultTimeBar defaultTimeBar2 = this.j;
        this.l = 0L;
        defaultTimeBar2.setDuration(0L);
        DefaultTimeBar defaultTimeBar3 = this.j;
        this.n = 0L;
        defaultTimeBar3.setBufferedPosition(0L);
    }

    public CustomSeekView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomSeekView(Context context) {
        this(context, null);
    }
}
