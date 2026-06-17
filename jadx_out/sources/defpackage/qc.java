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

        public c(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler) {
            this.b = onAudioFocusChangeListener;
            this.a = fy4.D(handler.getLooper(), null);
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            fy4.o1(this.a, new Runnable() { // from class: rc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.b.onAudioFocusChange(i);
                }
            });
        }
    }

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

    public b a() {
        return new b();
    }

    public yb b() {
        return this.d;
    }

    public AudioFocusRequest c() {
        return pc.a(gg3.q(this.g));
    }

    public Handler d() {
        return this.c;
    }

    public int e() {
        return this.a;
    }

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

    public AudioManager.OnAudioFocusChangeListener f() {
        return this.b;
    }

    public boolean g() {
        return this.e;
    }

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

        public b(qc qcVar) {
            this.a = qcVar.e();
            this.b = qcVar.f();
            this.c = qcVar.d();
            this.d = qcVar.b();
            this.e = qcVar.g();
        }

        public qc a() {
            AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.b;
            if (onAudioFocusChangeListener != null) {
                return new qc(this.a, onAudioFocusChangeListener, (Handler) gg3.q(this.c), this.d, this.e, this.f);
            }
            e04.a("Can't build an AudioFocusRequestCompat instance without a listener");
            return null;
        }

        public b b(boolean z) {
            this.f = z;
            return this;
        }

        public b c(yb ybVar) {
            gg3.q(ybVar);
            this.d = ybVar;
            return this;
        }

        public b d(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler) {
            gg3.q(onAudioFocusChangeListener);
            gg3.q(handler);
            this.b = onAudioFocusChangeListener;
            this.c = handler;
            return this;
        }

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
