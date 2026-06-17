package defpackage;

import defpackage.ef4;
import defpackage.f21;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class d21 extends ef4 {
    public f21 n;
    public a o;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements h53 {
        public f21 a;
        public f21.a b;
        public long c = -1;
        public long d = -1;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(f21 f21Var, f21.a aVar) {
            this.a = f21Var;
            this.b = aVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.h53
        public long a(jz0 jz0Var) {
            long j = this.d;
            if (j < 0) {
                return -1L;
            }
            long j2 = -(j + 2);
            this.d = -1L;
            return j2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.h53
        public yz3 b() {
            gg3.v(this.c != -1);
            return new e21(this.a, this.c);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.h53
        public void c(long j) {
            long[] jArr = this.b.a;
            this.d = jArr[fy4.k(jArr, j, true, true)];
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void d(long j) {
            this.c = j;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean o(byte[] bArr) {
        return bArr[0] == -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean p(r73 r73Var) {
        return r73Var.a() >= 5 && r73Var.Q() == 127 && r73Var.S() == 1179402563;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ef4
    public long f(r73 r73Var) {
        if (o(r73Var.f())) {
            return n(r73Var);
        }
        return -1L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ef4
    public boolean i(r73 r73Var, long j, ef4.b bVar) {
        byte[] bArrF = r73Var.f();
        f21 f21Var = this.n;
        if (f21Var == null) {
            f21 f21Var2 = new f21(bArrF, 17);
            this.n = f21Var2;
            bVar.a = f21Var2.g(Arrays.copyOfRange(bArrF, 9, r73Var.j()), null).b().X("audio/ogg").Q();
            return true;
        }
        if ((bArrF[0] & 127) == 3) {
            f21.a aVarG = c21.g(r73Var);
            f21 f21VarB = f21Var.b(aVarG);
            this.n = f21VarB;
            this.o = new a(f21VarB, aVarG);
            return true;
        }
        if (!o(bArrF)) {
            return true;
        }
        a aVar = this.o;
        if (aVar != null) {
            aVar.d(j);
            bVar.b = this.o;
        }
        gg3.q(bVar.a);
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ef4
    public void l(boolean z) {
        super.l(z);
        if (z) {
            this.n = null;
            this.o = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int n(r73 r73Var) {
        int i = (r73Var.f()[2] & 255) >> 4;
        if (i == 6 || i == 7) {
            r73Var.g0(4);
            r73Var.Z();
        }
        int iK = b21.k(r73Var, i);
        r73Var.f0(0);
        return iK;
    }
}
