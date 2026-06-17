package defpackage;

import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class qc {
    public final int a;
    public final AudioManager.OnAudioFocusChangeListener b;
    public final Handler c;
    public final yb d;
    public final boolean e;
    public final boolean f;
    public final Object g;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c implements AudioManager.OnAudioFocusChangeListener {
        public final Handler a;
        public final AudioManager.OnAudioFocusChangeListener b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler) {
            this.b = onAudioFocusChangeListener;
            this.a = fy4.D(handler.getLooper(), null);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            fy4.o1(this.a, new Runnable() { // from class: rc
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.b.onAudioFocusChange(i);
                }
            });
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public qc(int i, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler, yb ybVar, boolean z, boolean z2) {
        this.a = i;
        this.c = handler;
        this.d = ybVar;
        this.e = z;
        this.f = z2;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 26) {
            this.b = new c(onAudioFocusChangeListener, handler);
        } else {
            this.b = onAudioFocusChangeListener;
        }
        if (i2 >= 26) {
            this.g = oc.a(i).setAudioAttributes(ybVar.c()).setWillPauseWhenDucked(z).setOnAudioFocusChangeListener(onAudioFocusChangeListener, handler).setAcceptsDelayedFocusGain(z2).build();
        } else {
            this.g = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public b a() {
        return new b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public yb b() {
        return this.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AudioFocusRequest c() {
        return pc.a(gg3.q(this.g));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Handler d() {
        return this.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int e() {
        return this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qc)) {
            return false;
        }
        qc qcVar = (qc) obj;
        return this.a == qcVar.a && this.e == qcVar.e && Objects.equals(this.b, qcVar.b) && Objects.equals(this.c, qcVar.c) && Objects.equals(this.d, qcVar.d);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AudioManager.OnAudioFocusChangeListener f() {
        return this.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean g() {
        return this.e;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.a), this.b, this.c, this.d, Boolean.valueOf(this.e));
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public int a;
        public AudioManager.OnAudioFocusChangeListener b;
        public Handler c;
        public yb d;
        public boolean e;
        public boolean f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(qc qcVar) {
            this.a = qcVar.e();
            this.b = qcVar.f();
            this.c = qcVar.d();
            this.d = qcVar.b();
            this.e = qcVar.g();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public qc a() {
            AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.b;
            if (onAudioFocusChangeListener != null) {
                return new qc(this.a, onAudioFocusChangeListener, (Handler) gg3.q(this.c), this.d, this.e, this.f);
            }
            e04.a("Can't build an AudioFocusRequestCompat instance without a listener");
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b b(boolean z) {
            this.f = z;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b c(yb ybVar) {
            gg3.q(ybVar);
            this.d = ybVar;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b d(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler) {
            gg3.q(onAudioFocusChangeListener);
            gg3.q(handler);
            this.b = onAudioFocusChangeListener;
            this.c = handler;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b e(boolean z) {
            this.e = z;
            return this;
        }

        public b(int i) {
            this.d = yb.i;
            this.a = i;
        }
    }
}
