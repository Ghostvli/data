package defpackage;

import android.media.AudioTrack;
import android.os.Build;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ie {
    public boolean A;
    public long B;
    public final a a;
    public final zu b;
    public final long[] c;
    public final AudioTrack d;
    public final int e;
    public final long f;
    public final boolean g;
    public sd h;
    public float i;
    public long j;
    public long k;
    public long l;
    public Method m;
    public long n;
    public long o;
    public long p;
    public long q;
    public long r;
    public int s;
    public int t;
    public long u;
    public long v;
    public long w;
    public long x;
    public long y;
    public long z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void a(long j);

        void b(long j);

        void c(long j, long j2, long j3, long j4);

        void d(long j, long j2, long j3, long j4);
    }

    public ie(a aVar, zu zuVar, AudioTrack audioTrack, int i, int i2, int i3) {
        this.a = (a) gg3.q(aVar);
        this.b = zuVar;
        this.d = audioTrack;
        try {
            this.m = AudioTrack.class.getMethod("getLatency", null);
        } catch (NoSuchMethodException unused) {
        }
        this.c = new long[10];
        this.z = -9223372036854775807L;
        this.y = -9223372036854775807L;
        this.h = new sd(audioTrack, aVar);
        int sampleRate = audioTrack.getSampleRate();
        this.e = sampleRate;
        boolean zR0 = fy4.R0(i);
        this.g = zR0;
        this.f = zR0 ? fy4.t1(i3 / i2, sampleRate) : -9223372036854775807L;
        this.q = 0L;
        this.r = 0L;
        this.A = false;
        this.B = 0L;
        this.u = -9223372036854775807L;
        this.v = -9223372036854775807L;
        this.o = 0L;
        this.n = 0L;
        this.i = 1.0f;
        this.j = -9223372036854775807L;
    }

    public void a() {
        this.A = true;
        this.h.d();
    }

    public long b() {
        AudioTrack audioTrack = (AudioTrack) gg3.q(this.d);
        if (audioTrack.getPlayState() == 3) {
            j();
        }
        long jNanoTime = this.b.nanoTime() / 1000;
        boolean zF = this.h.f();
        long jE = zF ? this.h.e(jNanoTime, this.i) : d(jNanoTime);
        int playState = audioTrack.getPlayState();
        if (playState != 3) {
            if (playState == 1) {
                k(jE);
            }
            return jE;
        }
        if (zF || !this.h.h()) {
            k(jE);
        }
        long j = this.z;
        if (j != -9223372036854775807L) {
            long j2 = jE - this.y;
            long jP0 = fy4.p0(jNanoTime - j, this.i);
            long j3 = this.y + jP0;
            long jAbs = Math.abs(j3 - jE);
            if (j2 != 0 && jAbs < 1000000) {
                long j4 = (jP0 * 10) / 100;
                jE = fy4.t(jE, j3 - j4, j3 + j4);
            }
        }
        this.z = jNanoTime;
        this.y = jE;
        return jE;
    }

    public final long c() {
        if (this.u != -9223372036854775807L) {
            return Math.min(this.x, f());
        }
        long jE = this.b.e();
        if (jE - this.p >= 5) {
            q(jE);
            this.p = jE;
        }
        return this.q + this.B + (this.r << 32);
    }

    public final long d(long j) {
        long jMax = Math.max(0L, (this.t == 0 ? this.u != -9223372036854775807L ? fy4.t1(f(), this.e) : e() : fy4.p0(j + this.k, this.i)) - this.n);
        return this.u != -9223372036854775807L ? Math.min(fy4.t1(this.x, this.e), jMax) : jMax;
    }

    public final long e() {
        return fy4.t1(c(), this.e);
    }

    public final long f() {
        if (((AudioTrack) gg3.q(this.d)).getPlayState() == 2) {
            return this.w;
        }
        return this.w + fy4.J(fy4.p0(fy4.c1(this.b.e()) - this.u, this.i), this.e);
    }

    public void g(long j) {
        this.w = c();
        this.u = fy4.c1(this.b.e());
        this.x = j;
    }

    public boolean h() {
        return ((AudioTrack) gg3.q(this.d)).getPlayState() == 3;
    }

    public boolean i(long j) {
        return this.v != -9223372036854775807L && j > 0 && this.b.e() - this.v >= 200;
    }

    public final void j() {
        long jNanoTime = this.b.nanoTime() / 1000;
        if (jNanoTime - this.l >= 30000) {
            long jE = e();
            if (jE != 0) {
                this.c[this.s] = fy4.v0(jE, this.i) - jNanoTime;
                this.s = (this.s + 1) % 10;
                int i = this.t;
                if (i < 10) {
                    this.t = i + 1;
                }
                this.l = jNanoTime;
                this.k = 0L;
                int i2 = 0;
                while (true) {
                    int i3 = this.t;
                    if (i2 >= i3) {
                        break;
                    }
                    this.k += this.c[i2] / ((long) i3);
                    i2++;
                }
            } else {
                return;
            }
        }
        this.h.i(jNanoTime, this.i, d(jNanoTime), l(jNanoTime));
    }

    public final void k(long j) {
        long j2 = this.j;
        if (j2 == -9223372036854775807L || j < j2) {
            return;
        }
        long jA = this.b.a() - fy4.S1(fy4.v0(j - j2, this.i));
        this.j = -9223372036854775807L;
        this.a.a(jA);
    }

    public final boolean l(long j) {
        Method method;
        long j2 = this.n;
        if (this.g && (method = this.m) != null && j - this.o >= 500000) {
            try {
                long jIntValue = (((long) ((Integer) fy4.l((Integer) method.invoke(gg3.q(this.d), null))).intValue()) * 1000) - this.f;
                this.n = jIntValue;
                long jMax = Math.max(jIntValue, 0L);
                this.n = jMax;
                if (jMax > 10000000) {
                    this.a.b(jMax);
                    this.n = 0L;
                }
            } catch (Exception unused) {
                this.m = null;
            }
            this.o = j;
        }
        return j2 != this.n;
    }

    public void m() {
        n();
        if (this.u == -9223372036854775807L) {
            this.h.j();
        }
        this.w = c();
    }

    public final void n() {
        this.k = 0L;
        this.t = 0;
        this.s = 0;
        this.l = 0L;
        this.y = -9223372036854775807L;
        this.z = -9223372036854775807L;
    }

    public void o(float f) {
        this.i = f;
        this.h.j();
        n();
    }

    public void p() {
        if (this.u != -9223372036854775807L) {
            this.u = fy4.c1(this.b.e());
        }
        this.j = e();
        this.h.j();
    }

    public final void q(long j) {
        AudioTrack audioTrack = (AudioTrack) gg3.q(this.d);
        int playState = audioTrack.getPlayState();
        if (playState == 1) {
            return;
        }
        long playbackHeadPosition = ((long) audioTrack.getPlaybackHeadPosition()) & 4294967295L;
        if (Build.VERSION.SDK_INT <= 29) {
            if (playbackHeadPosition == 0 && this.q > 0 && playState == 3) {
                if (this.v == -9223372036854775807L) {
                    this.v = j;
                    return;
                }
                return;
            }
            this.v = -9223372036854775807L;
        }
        long j2 = this.q;
        if (j2 > playbackHeadPosition) {
            if (this.A) {
                this.B += j2;
                this.A = false;
            } else {
                this.r++;
            }
        }
        this.q = playbackHeadPosition;
    }
}
