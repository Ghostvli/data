package defpackage;

import android.util.SparseArray;
import defpackage.wt4;
import defpackage.yz3;
import okio.internal.Buffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class vi3 implements hz0 {
    public static final pz0 l = new pz0() { // from class: ui3
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.pz0
        public final hz0[] d() {
            return vi3.g();
        }
    };
    public final yo4 a;
    public final SparseArray b;
    public final r73 c;
    public final ti3 d;
    public boolean e;
    public boolean f;
    public boolean g;
    public long h;
    public si3 i;
    public mz0 j;
    public boolean k;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final cr0 a;
        public final yo4 b;
        public final q73 c = new q73(new byte[64]);
        public boolean d;
        public boolean e;
        public boolean f;
        public int g;
        public long h;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(cr0 cr0Var, yo4 yo4Var) {
            this.a = cr0Var;
            this.b = yo4Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a(r73 r73Var) {
            r73Var.u(this.c.a, 0, 3);
            this.c.p(0);
            b();
            r73Var.u(this.c.a, 0, this.g);
            this.c.p(0);
            c();
            this.a.e(this.h, 4);
            this.a.a(r73Var);
            this.a.d(false);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void b() {
            this.c.r(8);
            this.d = this.c.g();
            this.e = this.c.g();
            this.c.r(6);
            this.g = this.c.h(8);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void c() {
            this.h = 0L;
            if (this.d) {
                this.c.r(4);
                long jH = ((long) this.c.h(3)) << 30;
                this.c.r(1);
                long jH2 = jH | ((long) (this.c.h(15) << 15));
                this.c.r(1);
                long jH3 = jH2 | ((long) this.c.h(15));
                this.c.r(1);
                if (!this.f && this.e) {
                    this.c.r(4);
                    long jH4 = ((long) this.c.h(3)) << 30;
                    this.c.r(1);
                    long jH5 = jH4 | ((long) (this.c.h(15) << 15));
                    this.c.r(1);
                    long jH6 = jH5 | ((long) this.c.h(15));
                    this.c.r(1);
                    this.b.b(jH6);
                    this.f = true;
                }
                this.h = this.b.b(jH3);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void d() {
            this.f = false;
            this.a.c();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public vi3(yo4 yo4Var) {
        this.a = yo4Var;
        this.c = new r73(Buffer.SEGMENTING_THRESHOLD);
        this.b = new SparseArray();
        this.d = new ti3();
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0006: FILLED_NEW_ARRAY (wrap:vi3:0x0002: CONSTRUCTOR  A[MD:():void (m), WRAPPED] (LINE:3) call: vi3.<init>():void type: CONSTRUCTOR) (LINE:7) elemType: hz0 */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ hz0[] g() {
        return new hz0[]{new vi3()};
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public void a(long j, long j2) {
        boolean z = this.a.f() == -9223372036854775807L;
        if (!z) {
            long jD = this.a.d();
            z = (jD == -9223372036854775807L || jD == 0 || jD == j2) ? false : true;
        }
        if (z) {
            this.a.i(j2);
        }
        si3 si3Var = this.i;
        if (si3Var != null) {
            si3Var.h(j2);
        }
        for (int i = 0; i < this.b.size(); i++) {
            ((a) this.b.valueAt(i)).d();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public void b(mz0 mz0Var) {
        this.j = mz0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public int d(jz0 jz0Var, yf3 yf3Var) {
        cr0 tb1Var;
        gg3.q(this.j);
        long length = jz0Var.getLength();
        if (length != -1 && !this.d.e()) {
            return this.d.g(jz0Var, yf3Var);
        }
        h(length);
        si3 si3Var = this.i;
        if (si3Var != null && si3Var.d()) {
            return this.i.c(jz0Var, yf3Var);
        }
        jz0Var.p();
        long jK = length != -1 ? length - jz0Var.k() : -1L;
        if ((jK != -1 && jK < 4) || !jz0Var.j(this.c.f(), 0, 4, true)) {
            return -1;
        }
        this.c.f0(0);
        int iZ = this.c.z();
        if (iZ == 441) {
            return -1;
        }
        if (iZ == 442) {
            jz0Var.s(this.c.f(), 0, 10);
            this.c.f0(9);
            jz0Var.q((this.c.Q() & 7) + 14);
            return 0;
        }
        if (iZ == 443) {
            jz0Var.s(this.c.f(), 0, 2);
            this.c.f0(0);
            jz0Var.q(this.c.Y() + 6);
            return 0;
        }
        if (((iZ & (-256)) >> 8) != 1) {
            jz0Var.q(1);
            return 0;
        }
        int i = iZ & 255;
        a aVar = (a) this.b.get(i);
        if (!this.e) {
            if (aVar == null) {
                if (i == 189) {
                    tb1Var = new k1("video/mp2p");
                    this.f = true;
                    this.h = jz0Var.getPosition();
                } else if ((iZ & 224) == 192) {
                    tb1Var = new cv2("video/mp2p");
                    this.f = true;
                    this.h = jz0Var.getPosition();
                } else if ((iZ & 240) == 224) {
                    tb1Var = new tb1("video/mp2p");
                    this.g = true;
                    this.h = jz0Var.getPosition();
                } else {
                    tb1Var = null;
                }
                if (tb1Var != null) {
                    tb1Var.f(this.j, new wt4.d(i, com.hierynomus.protocol.commons.buffer.Buffer.DEFAULT_SIZE));
                    aVar = new a(tb1Var, this.a);
                    this.b.put(i, aVar);
                }
            }
            if (jz0Var.getPosition() > ((this.f && this.g) ? this.h + 8192 : 1048576L)) {
                this.e = true;
                this.j.o();
            }
        }
        jz0Var.s(this.c.f(), 0, 2);
        this.c.f0(0);
        int iY = this.c.Y() + 6;
        if (aVar == null) {
            jz0Var.q(iY);
        } else {
            this.c.b0(iY);
            jz0Var.readFully(this.c.f(), 0, iY);
            this.c.f0(6);
            aVar.a(this.c);
            r73 r73Var = this.c;
            r73Var.e0(r73Var.b());
        }
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public boolean e(jz0 jz0Var) {
        byte[] bArr = new byte[14];
        jz0Var.s(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        jz0Var.m(bArr[13] & 7);
        jz0Var.s(bArr, 0, 3);
        return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h(long j) {
        if (this.k) {
            return;
        }
        this.k = true;
        if (this.d.c() == -9223372036854775807L) {
            this.j.u(new yz3.b(this.d.c()));
            return;
        }
        si3 si3Var = new si3(this.d.d(), this.d.c(), j);
        this.i = si3Var;
        this.j.u(si3Var.b());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public void release() {
    }

    public vi3() {
        this(new yo4(0L));
    }
}
