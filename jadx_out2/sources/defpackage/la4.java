package defpackage;

import defpackage.yc;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class la4 implements yc {
    public final boolean b;
    public int c;
    public float d;
    public float e;
    public yc.a f;
    public yc.a g;
    public yc.a h;
    public yc.a i;
    public boolean j;
    public ka4 k;
    public ByteBuffer l;
    public ByteBuffer m;
    public long n;
    public long o;
    public boolean p;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public la4(boolean z) {
        this.d = 1.0f;
        this.e = 1.0f;
        yc.a aVar = yc.a.e;
        this.f = aVar;
        this.g = aVar;
        this.h = aVar;
        this.i = aVar;
        ByteBuffer byteBuffer = yc.a;
        this.l = byteBuffer;
        this.m = byteBuffer;
        this.c = -1;
        this.b = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean a() {
        return Math.abs(this.d - 1.0f) < 1.0E-4f && Math.abs(this.e - 1.0f) < 1.0E-4f && this.g.a == this.f.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yc
    public boolean b() {
        if (!this.p) {
            return false;
        }
        ka4 ka4Var = this.k;
        return ka4Var == null || ka4Var.p() == 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yc
    public boolean c() {
        if (this.g.a != -1) {
            return this.b || !a();
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yc
    public ByteBuffer d() {
        int iP;
        ka4 ka4Var = this.k;
        if (ka4Var != null && (iP = ka4Var.p()) > 0) {
            if (this.l.capacity() < iP) {
                this.l = ByteBuffer.allocateDirect(iP).order(ByteOrder.nativeOrder());
            } else {
                this.l.clear();
            }
            ka4Var.o(this.l);
            this.l.flip();
            this.o += (long) iP;
            this.m = this.l;
        }
        ByteBuffer byteBuffer = this.m;
        this.m = yc.a;
        return byteBuffer;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yc
    public void e(yc.b bVar) {
        if (c()) {
            yc.a aVar = this.f;
            this.h = aVar;
            yc.a aVar2 = this.g;
            this.i = aVar2;
            if (this.j) {
                this.k = new ka4(aVar.a, aVar.b, this.d, this.e, aVar2.a, aVar.c == 4);
            } else {
                ka4 ka4Var = this.k;
                if (ka4Var != null) {
                    ka4Var.n();
                }
            }
        }
        this.m = yc.a;
        this.n = 0L;
        this.o = 0L;
        this.p = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yc
    public void f(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ka4 ka4Var = (ka4) gg3.q(this.k);
            this.n += (long) byteBuffer.remaining();
            ka4Var.v(byteBuffer);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yc
    public yc.a g(yc.a aVar) throws yc.c {
        int i = aVar.c;
        if (i != 2 && i != 4) {
            throw new yc.c(aVar);
        }
        int i2 = this.c;
        if (i2 == -1) {
            i2 = aVar.a;
        }
        this.f = aVar;
        yc.a aVar2 = new yc.a(i2, aVar.b, aVar.c);
        this.g = aVar2;
        this.j = true;
        return aVar2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yc
    public void h() {
        ka4 ka4Var = this.k;
        if (ka4Var != null) {
            ka4Var.u();
        }
        this.p = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yc
    public long i(long j) {
        return k(j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long j(long j) {
        if (this.o < RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) {
            return (long) (((double) this.d) * j);
        }
        long jQ = this.n - ((long) ((ka4) gg3.q(this.k)).q());
        int i = this.i.a;
        int i2 = this.h.a;
        long j2 = this.o;
        return i == i2 ? fy4.u1(j, jQ, j2) : fy4.u1(j, jQ * ((long) i), j2 * ((long) i2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long k(long j) {
        if (this.o < RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) {
            return (long) (j / ((double) this.d));
        }
        long jQ = this.n - ((long) ((ka4) gg3.q(this.k)).q());
        int i = this.i.a;
        int i2 = this.h.a;
        long j2 = this.o;
        return i == i2 ? fy4.u1(j, j2, jQ) : fy4.u1(j, j2 * ((long) i2), jQ * ((long) i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void l(float f) {
        gg3.d(f > 0.0f);
        if (this.e != f) {
            this.e = f;
            this.j = true;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void m(float f) {
        gg3.d(f > 0.0f);
        if (this.d != f) {
            this.d = f;
            this.j = true;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yc
    public void reset() {
        this.d = 1.0f;
        this.e = 1.0f;
        yc.a aVar = yc.a.e;
        this.f = aVar;
        this.g = aVar;
        this.h = aVar;
        this.i = aVar;
        ByteBuffer byteBuffer = yc.a;
        this.l = byteBuffer;
        this.m = byteBuffer;
        this.c = -1;
        this.j = false;
        this.k = null;
        this.n = 0L;
        this.o = 0L;
        this.p = false;
    }

    public la4() {
        this(false);
    }
}
