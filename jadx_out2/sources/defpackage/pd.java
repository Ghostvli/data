package defpackage;

import android.media.AudioDeviceInfo;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface pd {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final int a;
        public final int b;
        public final int c;
        public final boolean d;
        public final boolean e;
        public final int f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(int i, int i2, int i3, boolean z, boolean z2, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = z;
            this.e = z2;
            this.f = i4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface d {
        void a(long j);

        void b(a aVar);

        void c(a aVar);

        void d(Exception exc);

        void e();

        void f();

        void g(int i, long j, long j2);

        void h();

        void i();

        void j();

        void onAudioSessionIdChanged(int i);

        void onSkipSilenceEnabledChanged(boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e extends Exception {
        public final long f;
        public final long g;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(long j, long j2) {
            super("Unexpected audio track timestamp discontinuity: expected " + j2 + ", got " + j);
            this.f = j;
            this.g = j2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class f extends Exception {
        public final int f;
        public final boolean g;
        public final t41 h;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public f(int i, t41 t41Var, boolean z) {
            super("AudioTrack write failed: " + i);
            this.g = z;
            this.f = i;
            this.h = t41Var;
        }
    }

    boolean a(t41 t41Var);

    boolean b();

    void c(int i, int i2);

    void d(ie3 ie3Var);

    void e(zu zuVar);

    void f();

    void flush();

    boolean g();

    dc3 getPlaybackParameters();

    void h(int i);

    long i();

    void j(wc wcVar);

    int k(t41 t41Var);

    uc l(t41 t41Var);

    void m(int i);

    long n(boolean z);

    void o();

    void p(yb ybVar);

    void pause();

    void play();

    void q(d dVar);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    default void r(long j) {
    }

    void release();

    void reset();

    void s();

    void setPlaybackParameters(dc3 dc3Var);

    void setPreferredDevice(AudioDeviceInfo audioDeviceInfo);

    void setVolume(float f2);

    void t();

    ec u();

    void v(af afVar);

    void w(int i);

    void x(t41 t41Var, int i, int[] iArr);

    boolean y(ByteBuffer byteBuffer, long j, int i);

    void z(boolean z);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends Exception {
        public final t41 f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(Throwable th, t41 t41Var) {
            super(th);
            this.f = t41Var;
        }

        public b(String str, t41 t41Var) {
            super(str);
            this.f = t41Var;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends Exception {
        public final int f;
        public final boolean g;
        public final t41 h;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(int i, int i2, int i3, int i4, int i5, t41 t41Var, boolean z, Exception exc) {
            StringBuilder sb = new StringBuilder("AudioTrack init failed ");
            sb.append(i);
            sb.append(" Config(");
            sb.append(i2);
            sb.append(", ");
            sb.append(i3);
            sb.append(", ");
            sb.append(i4);
            sb.append(", ");
            sb.append(i5);
            sb.append(") ");
            sb.append(t41Var);
            sb.append(z ? " (recoverable)" : "");
            this(sb.toString(), i, t41Var, z, exc);
        }

        public c(String str, int i, t41 t41Var, boolean z, Throwable th) {
            super(str, th);
            this.f = i;
            this.g = z;
            this.h = t41Var;
        }
    }
}
