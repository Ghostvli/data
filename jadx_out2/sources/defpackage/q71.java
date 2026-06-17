package defpackage;

import android.util.Pair;
import android.util.SparseArray;
import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.ki4;
import defpackage.mq3;
import defpackage.oo0;
import defpackage.su2;
import defpackage.t41;
import defpackage.yz3;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.jupnp.support.model.dlna.DLNAProfiles;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class q71 implements hz0 {
    public static final pz0 P = new pz0() { // from class: o71
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.pz0
        public final hz0[] d() {
            return q71.g();
        }
    };
    public static final byte[] Q = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    public static final t41 R = new t41.b().A0("application/x-emsg").Q();
    public long A;
    public long B;
    public long C;
    public b D;
    public int E;
    public int F;
    public int G;
    public boolean H;
    public boolean I;
    public mz0 J;
    public gr4[] K;
    public gr4[] L;
    public boolean M;
    public boolean N;
    public long O;
    public final ki4.a a;
    public final int b;
    public final iq4 c;
    public final List d;
    public final SparseArray e;
    public final r73 f;
    public final r73 g;
    public final r73 h;
    public final byte[] i;
    public final r73 j;
    public final yo4 k;
    public final fv0 l;
    public final r73 m;
    public final ArrayDeque n;
    public final ArrayDeque o;
    public final mq3 p;
    public final gr4 q;
    public final tt r;
    public xi1 s;
    public int t;
    public int u;
    public long v;
    public int w;
    public r73 x;
    public long y;
    public int z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final long a;
        public final boolean b;
        public final int c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(long j, boolean z, int i) {
            this.a = j;
            this.b = z;
            this.c = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final gr4 a;
        public hr4 d;
        public eh0 e;
        public int f;
        public int g;
        public int h;
        public int i;
        public final t41 j;
        public boolean m;
        public final zq4 b = new zq4();
        public final r73 c = new r73();
        public final r73 k = new r73(1);
        public final r73 l = new r73();

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(gr4 gr4Var, hr4 hr4Var, eh0 eh0Var, t41 t41Var) {
            this.a = gr4Var;
            this.d = hr4Var;
            this.e = eh0Var;
            this.j = t41Var;
            j(hr4Var, eh0Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int c() {
            int i = !this.m ? this.d.g[this.f] : this.b.k[this.f] ? 1 : 0;
            return g() != null ? 1073741824 | i : i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public long d() {
            return !this.m ? this.d.c[this.f] : this.b.g[this.h];
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public long e() {
            return !this.m ? this.d.f[this.f] : this.b.c(this.f);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int f() {
            return !this.m ? this.d.d[this.f] : this.b.i[this.f];
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public yq4 g() {
            if (!this.m) {
                return null;
            }
            int i = ((eh0) fy4.l(this.b.a)).a;
            yq4 yq4VarB = this.b.n;
            if (yq4VarB == null) {
                yq4VarB = this.d.a.b(i);
            }
            if (yq4VarB == null || !yq4VarB.a) {
                return null;
            }
            return yq4VarB;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean h() {
            this.f++;
            if (!this.m) {
                return false;
            }
            int i = this.g + 1;
            this.g = i;
            int[] iArr = this.b.h;
            int i2 = this.h;
            if (i != iArr[i2]) {
                return true;
            }
            this.h = i2 + 1;
            this.g = 0;
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int i(int i, int i2) {
            r73 r73Var;
            yq4 yq4VarG = g();
            if (yq4VarG == null) {
                return 0;
            }
            int length = yq4VarG.d;
            if (length != 0) {
                r73Var = this.b.o;
            } else {
                byte[] bArr = (byte[]) fy4.l(yq4VarG.e);
                this.l.d0(bArr, bArr.length);
                r73 r73Var2 = this.l;
                length = bArr.length;
                r73Var = r73Var2;
            }
            boolean zG = this.b.g(this.f);
            boolean z = zG || i2 != 0;
            this.k.f()[0] = (byte) ((z ? 128 : 0) | length);
            this.k.f0(0);
            this.a.c(this.k, 1, 1);
            this.a.c(r73Var, length, 1);
            if (!z) {
                return length + 1;
            }
            if (!zG) {
                this.c.b0(8);
                byte[] bArrF = this.c.f();
                bArrF[0] = 0;
                bArrF[1] = 1;
                bArrF[2] = (byte) ((i2 >> 8) & 255);
                bArrF[3] = (byte) (i2 & 255);
                bArrF[4] = (byte) ((i >> 24) & 255);
                bArrF[5] = (byte) ((i >> 16) & 255);
                bArrF[6] = (byte) ((i >> 8) & 255);
                bArrF[7] = (byte) (i & 255);
                this.a.c(this.c, 8, 1);
                return length + 9;
            }
            r73 r73Var3 = this.b.o;
            int iY = r73Var3.Y();
            r73Var3.g0(-2);
            int i3 = (iY * 6) + 2;
            if (i2 != 0) {
                this.c.b0(i3);
                byte[] bArrF2 = this.c.f();
                r73Var3.u(bArrF2, 0, i3);
                int i4 = (((bArrF2[2] & 255) << 8) | (bArrF2[3] & 255)) + i2;
                bArrF2[2] = (byte) ((i4 >> 8) & 255);
                bArrF2[3] = (byte) (i4 & 255);
                r73Var3 = this.c;
            }
            this.a.c(r73Var3, i3, 1);
            return length + 1 + i3;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void j(hr4 hr4Var, eh0 eh0Var) {
            this.d = hr4Var;
            this.e = eh0Var;
            this.a.g(this.j);
            k();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void k() {
            this.b.f();
            this.f = 0;
            this.h = 0;
            this.g = 0;
            this.i = 0;
            this.m = false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void l(long j) {
            int i = this.f;
            while (true) {
                zq4 zq4Var = this.b;
                if (i >= zq4Var.f || zq4Var.c(i) > j) {
                    return;
                }
                if (this.b.k[i]) {
                    this.i = i;
                }
                i++;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void m() {
            yq4 yq4VarG = g();
            if (yq4VarG == null) {
                return;
            }
            r73 r73Var = this.b.o;
            int i = yq4VarG.d;
            if (i != 0) {
                r73Var.g0(i);
            }
            if (this.b.g(this.f)) {
                r73Var.g0(r73Var.Y() * 6);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void n(oo0 oo0Var) {
            yq4 yq4VarB = this.d.a.b(((eh0) fy4.l(this.b.a)).a);
            this.a.g(this.j.b().d0(oo0Var.s(yq4VarB != null ? yq4VarB.b : null)).Q());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public q71(ki4.a aVar, int i, yo4 yo4Var, iq4 iq4Var, List list, gr4 gr4Var) {
        this.a = aVar;
        this.b = i;
        this.k = yo4Var;
        this.c = iq4Var;
        this.d = Collections.unmodifiableList(list);
        this.q = gr4Var;
        this.l = new fv0();
        this.m = new r73(16);
        this.f = new r73(dx2.a);
        this.g = new r73(6);
        this.h = new r73();
        byte[] bArr = new byte[16];
        this.i = bArr;
        this.j = new r73(bArr);
        this.n = new ArrayDeque();
        this.o = new ArrayDeque();
        this.e = new SparseArray();
        this.s = xi1.u();
        this.B = -9223372036854775807L;
        this.A = -9223372036854775807L;
        this.C = -9223372036854775807L;
        this.J = mz0.d;
        this.K = new gr4[0];
        this.L = new gr4[0];
        this.p = new mq3(new mq3.b() { // from class: p71
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // mq3.b
            public final void a(long j, r73 r73Var) {
                fr.a(j, r73Var, this.a.L);
            }
        });
        this.r = new tt();
        this.O = -1L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long A(r73 r73Var) {
        r73Var.f0(8);
        return gl.q(r73Var.z()) == 0 ? r73Var.S() : r73Var.X();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void B(su2.b bVar, SparseArray sparseArray, boolean z, int i, byte[] bArr) throws r83 {
        int size = bVar.d.size();
        for (int i2 = 0; i2 < size; i2++) {
            su2.b bVar2 = (su2.b) bVar.d.get(i2);
            if (bVar2.a == 1953653094) {
                K(bVar2, sparseArray, z, i, bArr);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void C(r73 r73Var, zq4 zq4Var) throws r83 {
        r73Var.f0(8);
        int iZ = r73Var.z();
        if ((gl.p(iZ) & 1) == 1) {
            r73Var.g0(8);
        }
        int iU = r73Var.U();
        if (iU == 1) {
            zq4Var.d += gl.q(iZ) == 0 ? r73Var.S() : r73Var.X();
        } else {
            throw r83.a("Unexpected saio entry count: " + iU, null);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void D(yq4 yq4Var, r73 r73Var, zq4 zq4Var) throws r83 {
        int i;
        int i2 = yq4Var.d;
        r73Var.f0(8);
        if ((gl.p(r73Var.z()) & 1) == 1) {
            r73Var.g0(8);
        }
        int iQ = r73Var.Q();
        int iU = r73Var.U();
        if (iU > zq4Var.f) {
            throw r83.a("Saiz sample count " + iU + " is greater than fragment sample count" + zq4Var.f, null);
        }
        if (iQ == 0) {
            boolean[] zArr = zq4Var.m;
            i = 0;
            for (int i3 = 0; i3 < iU; i3++) {
                int iQ2 = r73Var.Q();
                i += iQ2;
                zArr[i3] = iQ2 > i2;
            }
        } else {
            i = iQ * iU;
            Arrays.fill(zq4Var.m, 0, iU, iQ > i2);
        }
        Arrays.fill(zq4Var.m, iU, zq4Var.f, false);
        if (i > 0) {
            zq4Var.d(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void E(su2.b bVar, String str, zq4 zq4Var) throws r83 {
        byte[] bArr = null;
        r73 r73Var = null;
        r73 r73Var2 = null;
        for (int i = 0; i < bVar.c.size(); i++) {
            su2.c cVar = (su2.c) bVar.c.get(i);
            r73 r73Var3 = cVar.b;
            int i2 = cVar.a;
            if (i2 == 1935828848) {
                r73Var3.f0(12);
                if (r73Var3.z() == 1936025959) {
                    r73Var = r73Var3;
                }
            } else if (i2 == 1936158820) {
                r73Var3.f0(12);
                if (r73Var3.z() == 1936025959) {
                    r73Var2 = r73Var3;
                }
            }
        }
        if (r73Var == null || r73Var2 == null) {
            return;
        }
        r73Var.f0(8);
        int iQ = gl.q(r73Var.z());
        r73Var.g0(4);
        if (iQ == 1) {
            r73Var.g0(4);
        }
        if (r73Var.z() != 1) {
            throw r83.e("Entry count in sbgp != 1 (unsupported).");
        }
        r73Var2.f0(8);
        int iQ2 = gl.q(r73Var2.z());
        r73Var2.g0(4);
        if (iQ2 == 1) {
            if (r73Var2.S() == 0) {
                throw r83.e("Variable length description in sgpd found (unsupported)");
            }
        } else if (iQ2 >= 2) {
            r73Var2.g0(4);
        }
        if (r73Var2.S() != 1) {
            throw r83.e("Entry count in sgpd != 1 (unsupported).");
        }
        r73Var2.g0(1);
        int iQ3 = r73Var2.Q();
        int i3 = (iQ3 & 240) >> 4;
        int i4 = iQ3 & 15;
        boolean z = r73Var2.Q() == 1;
        if (z) {
            int iQ4 = r73Var2.Q();
            byte[] bArr2 = new byte[16];
            r73Var2.u(bArr2, 0, 16);
            if (iQ4 == 0) {
                int iQ5 = r73Var2.Q();
                bArr = new byte[iQ5];
                r73Var2.u(bArr, 0, iQ5);
            }
            zq4Var.l = true;
            zq4Var.n = new yq4(z, str, iQ4, bArr2, i3, i4, bArr);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void F(r73 r73Var, int i, zq4 zq4Var) throws r83 {
        r73Var.f0(i + 8);
        int iP = gl.p(r73Var.z());
        if ((iP & 1) != 0) {
            throw r83.e("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (iP & 2) != 0;
        int iU = r73Var.U();
        if (iU == 0) {
            Arrays.fill(zq4Var.m, 0, zq4Var.f, false);
            return;
        }
        if (iU == zq4Var.f) {
            Arrays.fill(zq4Var.m, 0, iU, z);
            zq4Var.d(r73Var.a());
            zq4Var.b(r73Var);
        } else {
            throw r83.a("Senc sample count " + iU + " is different from fragment sample count" + zq4Var.f, null);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void G(r73 r73Var, zq4 zq4Var) throws r83 {
        F(r73Var, 0, zq4Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Pair H(r73 r73Var, long j) throws r83 {
        long jX;
        long jX2;
        r73Var.f0(8);
        int iQ = gl.q(r73Var.z());
        r73Var.g0(4);
        long jS = r73Var.S();
        if (iQ == 0) {
            jX = r73Var.S();
            jX2 = r73Var.S();
        } else {
            jX = r73Var.X();
            jX2 = r73Var.X();
        }
        long j2 = j + jX2;
        long jU1 = fy4.u1(jX, 1000000L, jS);
        r73Var.g0(2);
        int iY = r73Var.Y();
        int[] iArr = new int[iY];
        long[] jArr = new long[iY];
        long[] jArr2 = new long[iY];
        long[] jArr3 = new long[iY];
        long j3 = j2;
        long jU12 = jU1;
        int i = 0;
        while (i < iY) {
            int iZ = r73Var.z();
            if ((Integer.MIN_VALUE & iZ) != 0) {
                throw r83.a("Unhandled indirect reference", null);
            }
            long jS2 = r73Var.S();
            iArr[i] = iZ & Integer.MAX_VALUE;
            jArr[i] = j3;
            jArr3[i] = jU12;
            jX += jS2;
            long[] jArr4 = jArr3;
            jU12 = fy4.u1(jX, 1000000L, jS);
            jArr2[i] = jU12 - jArr4[i];
            r73Var.g0(4);
            j3 += (long) iArr[i];
            i++;
            jArr3 = jArr4;
        }
        return Pair.create(Long.valueOf(jU1), new st(iArr, jArr, jArr2, jArr3));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long I(r73 r73Var) {
        r73Var.f0(8);
        return gl.q(r73Var.z()) == 1 ? r73Var.X() : r73Var.S();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static b J(r73 r73Var, SparseArray sparseArray, boolean z) {
        r73Var.f0(8);
        int iP = gl.p(r73Var.z());
        b bVar = (b) (z ? sparseArray.valueAt(0) : sparseArray.get(r73Var.z()));
        if (bVar == null) {
            return null;
        }
        if ((iP & 1) != 0) {
            long jX = r73Var.X();
            zq4 zq4Var = bVar.b;
            zq4Var.c = jX;
            zq4Var.d = jX;
        }
        eh0 eh0Var = bVar.e;
        bVar.b.a = new eh0((iP & 2) != 0 ? r73Var.z() - 1 : eh0Var.a, (iP & 8) != 0 ? r73Var.z() : eh0Var.b, (iP & 16) != 0 ? r73Var.z() : eh0Var.c, (iP & 32) != 0 ? r73Var.z() : eh0Var.d);
        return bVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void K(su2.b bVar, SparseArray sparseArray, boolean z, int i, byte[] bArr) throws r83 {
        b bVarJ = J(((su2.c) gg3.q(bVar.e(1952868452))).b, sparseArray, z);
        if (bVarJ == null) {
            return;
        }
        zq4 zq4Var = bVarJ.b;
        long j = zq4Var.q;
        boolean z2 = zq4Var.r;
        bVarJ.k();
        bVarJ.m = true;
        su2.c cVarE = bVar.e(1952867444);
        if (cVarE == null || (i & 2) != 0) {
            zq4Var.q = j;
            zq4Var.r = z2;
        } else {
            zq4Var.q = I(cVarE.b);
            zq4Var.r = true;
        }
        N(bVar, bVarJ, i);
        yq4 yq4VarB = bVarJ.d.a.b(((eh0) gg3.q(zq4Var.a)).a);
        su2.c cVarE2 = bVar.e(1935763834);
        if (cVarE2 != null) {
            D((yq4) gg3.q(yq4VarB), cVarE2.b, zq4Var);
        }
        su2.c cVarE3 = bVar.e(1935763823);
        if (cVarE3 != null) {
            C(cVarE3.b, zq4Var);
        }
        su2.c cVarE4 = bVar.e(1936027235);
        if (cVarE4 != null) {
            G(cVarE4.b, zq4Var);
        }
        E(bVar, yq4VarB != null ? yq4VarB.b : null, zq4Var);
        int size = bVar.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            su2.c cVar = (su2.c) bVar.c.get(i2);
            if (cVar.a == 1970628964) {
                O(cVar.b, zq4Var, bArr);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Pair L(r73 r73Var) {
        r73Var.f0(12);
        return Pair.create(Integer.valueOf(r73Var.z()), new eh0(r73Var.z() - 1, r73Var.z(), r73Var.z(), r73Var.z()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int M(b bVar, int i, int i2, r73 r73Var, int i3) throws r83 {
        boolean z;
        int iZ;
        int i4;
        int iZ2;
        int i5;
        int iZ3;
        int i6;
        int iZ4;
        r73Var.f0(8);
        int iP = gl.p(r73Var.z());
        iq4 iq4Var = bVar.d.a;
        zq4 zq4Var = bVar.b;
        eh0 eh0Var = (eh0) fy4.l(zq4Var.a);
        zq4Var.h[i] = r73Var.U();
        long[] jArr = zq4Var.g;
        long j = zq4Var.c;
        jArr[i] = j;
        if ((iP & 1) != 0) {
            jArr[i] = j + ((long) r73Var.z());
        }
        boolean z2 = (iP & 4) != 0;
        int iZ5 = eh0Var.d;
        if (z2) {
            iZ5 = r73Var.z();
        }
        boolean z3 = (iP & Buffer.DEFAULT_SIZE) != 0;
        boolean z4 = (iP & 512) != 0;
        boolean z5 = (iP & 1024) != 0;
        boolean z6 = (iP & 2048) != 0;
        long j2 = r(iq4Var) ? ((long[]) fy4.l(iq4Var.j))[0] : 0L;
        int[] iArr = zq4Var.i;
        long[] jArr2 = zq4Var.j;
        boolean[] zArr = zq4Var.k;
        boolean z7 = z6;
        boolean z8 = iq4Var.b == 2 && (i2 & 1) != 0;
        int i7 = i3 + zq4Var.h[i];
        boolean z9 = z2;
        long j3 = iq4Var.c;
        long j4 = zq4Var.q;
        int i8 = i3;
        while (i8 < i7) {
            if (z3) {
                iZ = r73Var.z();
                z = z8;
            } else {
                z = z8;
                iZ = eh0Var.b;
            }
            int iJ = j(iZ);
            if (z4) {
                iZ2 = r73Var.z();
                i4 = i7;
            } else {
                i4 = i7;
                iZ2 = eh0Var.c;
            }
            int iJ2 = j(iZ2);
            if (z5) {
                i5 = iJ2;
                iZ3 = r73Var.z();
            } else if (i8 == 0 && z9) {
                i5 = iJ2;
                iZ3 = iZ5;
            } else {
                i5 = iJ2;
                iZ3 = eh0Var.d;
            }
            if (z7) {
                i6 = iZ3;
                iZ4 = r73Var.z();
            } else {
                i6 = iZ3;
                iZ4 = 0;
            }
            int i9 = i8;
            long jU1 = fy4.u1((((long) iZ4) + j4) - j2, 1000000L, j3);
            jArr2[i9] = jU1;
            if (!zq4Var.r) {
                jArr2[i9] = jU1 + bVar.d.i;
            }
            iArr[i9] = i5;
            zArr[i9] = ((i6 >> 16) & 1) == 0 && (!z || i9 == 0);
            j4 += (long) iJ;
            i8 = i9 + 1;
            i7 = i4;
            z8 = z;
        }
        int i10 = i7;
        zq4Var.q = j4;
        return i10;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void N(su2.b bVar, b bVar2, int i) throws r83 {
        List list = bVar.c;
        int size = list.size();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            su2.c cVar = (su2.c) list.get(i4);
            if (cVar.a == 1953658222) {
                r73 r73Var = cVar.b;
                r73Var.f0(12);
                int iU = r73Var.U();
                if (iU > 0) {
                    i3 += iU;
                    i2++;
                }
            }
        }
        bVar2.h = 0;
        bVar2.g = 0;
        bVar2.f = 0;
        bVar2.b.e(i2, i3);
        int i5 = 0;
        int iM = 0;
        for (int i6 = 0; i6 < size; i6++) {
            su2.c cVar2 = (su2.c) list.get(i6);
            if (cVar2.a == 1953658222) {
                iM = M(bVar2, i5, i, cVar2.b, iM);
                i5++;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void O(r73 r73Var, zq4 zq4Var, byte[] bArr) throws r83 {
        r73Var.f0(8);
        r73Var.u(bArr, 0, 16);
        if (Arrays.equals(bArr, Q)) {
            F(r73Var, 16, zq4Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean Q(jz0 jz0Var) throws r83 {
        if (this.w == 0) {
            if (!jz0Var.d(this.m.f(), 0, 8, true)) {
                return false;
            }
            this.w = 8;
            this.m.f0(0);
            this.v = this.m.S();
            this.u = this.m.z();
        }
        long j = this.v;
        if (j == 1) {
            jz0Var.readFully(this.m.f(), 8, 8);
            this.w += 8;
            this.v = this.m.X();
        } else if (j == 0) {
            long length = jz0Var.getLength();
            if (length == -1 && !this.n.isEmpty()) {
                length = ((su2.b) this.n.peek()).b;
            }
            if (length != -1) {
                this.v = (length - jz0Var.getPosition()) + ((long) this.w);
            }
        }
        long j2 = this.v;
        int i = this.w;
        if (j2 < i) {
            if (this.u != 1718773093 || i != 8) {
                throw r83.e("Atom size less than header length (unsupported).");
            }
            this.v = i;
        }
        if (this.O != -1) {
            if (this.u == 1936286840) {
                this.j.b0((int) this.v);
                System.arraycopy(this.m.f(), 0, this.j.f(), 0, 8);
                jz0Var.readFully(this.j.f(), 8, (int) (this.v - ((long) this.w)));
                this.r.a((st) H(new su2.c(1936286840, this.j).b, jz0Var.k()).second);
            } else {
                jz0Var.i((int) (this.v - ((long) i)), true);
            }
            l();
            return true;
        }
        long position = jz0Var.getPosition() - ((long) this.w);
        int i2 = this.u;
        if ((i2 == 1836019558 || i2 == 1835295092) && !this.M) {
            this.J.u(new yz3.b(this.B, position));
            this.M = true;
        }
        if (this.u == 1836019558) {
            int size = this.e.size();
            for (int i3 = 0; i3 < size; i3++) {
                zq4 zq4Var = ((b) this.e.valueAt(i3)).b;
                zq4Var.b = position;
                zq4Var.d = position;
                zq4Var.c = position;
            }
        }
        int i4 = this.u;
        if (i4 == 1835295092) {
            this.D = null;
            this.y = position + this.v;
            this.t = 2;
            return true;
        }
        if (U(i4)) {
            long position2 = jz0Var.getPosition();
            long j3 = this.v;
            long j4 = (position2 + j3) - 8;
            if (j3 != this.w && this.u == 1835365473) {
                s(jz0Var);
            }
            this.n.push(new su2.b(this.u, j4));
            if (this.v == this.w) {
                P(j4);
            } else {
                l();
            }
        } else if (V(this.u)) {
            if (this.w != 8) {
                throw r83.e("Leaf atom defines extended atom size (unsupported).");
            }
            if (this.v > 2147483647L) {
                throw r83.e("Leaf atom with length > 2147483647 (unsupported).");
            }
            r73 r73Var = new r73((int) this.v);
            System.arraycopy(this.m.f(), 0, r73Var.f(), 0, 8);
            this.x = r73Var;
            this.t = 1;
        } else {
            if (this.v > 2147483647L) {
                throw r83.e("Skipping atom with length > 2147483647 (unsupported).");
            }
            this.x = null;
            this.t = 1;
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void R(jz0 jz0Var) throws r83 {
        int i = (int) (this.v - ((long) this.w));
        r73 r73Var = this.x;
        if (r73Var != null) {
            jz0Var.readFully(r73Var.f(), 8, i);
            w(new su2.c(this.u, r73Var), jz0Var);
        } else {
            jz0Var.q(i);
        }
        P(jz0Var.getPosition());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean U(int i) {
        return i == 1836019574 || i == 1953653099 || i == 1835297121 || i == 1835626086 || i == 1937007212 || i == 1836019558 || i == 1953653094 || i == 1836475768 || i == 1701082227 || i == 1835365473;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean V(int i) {
        return i == 1751411826 || i == 1835296868 || i == 1836476516 || i == 1936286840 || i == 1937011556 || i == 1937011827 || i == 1668576371 || i == 1937011555 || i == 1937011578 || i == 1937013298 || i == 1937007471 || i == 1668232756 || i == 1937011571 || i == 1952867444 || i == 1952868452 || i == 1953196132 || i == 1953654136 || i == 1953658222 || i == 1886614376 || i == 1935763834 || i == 1935763823 || i == 1936027235 || i == 1970628964 || i == 1935828848 || i == 1936158820 || i == 1701606260 || i == 1835362404 || i == 1701671783 || i == 1969517665 || i == 1801812339 || i == 1768715124;
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x000a: FILLED_NEW_ARRAY 
      (wrap:q71:0x0006: CONSTRUCTOR (wrap:ki4$a:0x0002: SGET  A[WRAPPED] (LINE:3) ki4.a.a ki4$a), (32 int) A[MD:(ki4$a, int):void (m), WRAPPED] (LINE:7) call: q71.<init>(ki4$a, int):void type: CONSTRUCTOR)
     (LINE:11) elemType: hz0 */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ hz0[] g() {
        return new hz0[]{new q71(ki4.a.a, 32)};
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int j(int i) throws r83 {
        if (i >= 0) {
            return i;
        }
        throw r83.a("Unexpected negative value: " + i, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int k(int i) {
        int i2 = (i & 1) != 0 ? 64 : 0;
        return (i & 2) != 0 ? i2 | 128 : i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static oo0 n(List list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            su2.c cVar = (su2.c) list.get(i);
            if (cVar.a == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArrF = cVar.b.f();
                UUID uuidF = xi3.f(bArrF);
                if (uuidF == null) {
                    xz1.i("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new oo0.b(uuidF, DLNAProfiles.DLNAMimeTypes.MIME_VIDEO_MPEG_4, bArrF));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new oo0(arrayList);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static b o(SparseArray sparseArray) {
        int size = sparseArray.size();
        b bVar = null;
        long j = Long.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            b bVar2 = (b) sparseArray.valueAt(i);
            if ((bVar2.m || bVar2.f != bVar2.d.b) && (!bVar2.m || bVar2.h != bVar2.b.e)) {
                long jD = bVar2.d();
                if (jD < j) {
                    bVar = bVar2;
                    j = jD;
                }
            }
        }
        return bVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean r(iq4 iq4Var) {
        long[] jArr = iq4Var.i;
        if (jArr != null && jArr.length == 1 && iq4Var.j != null) {
            long j = jArr[0];
            if (j == 0 || fy4.u1(j, 1000000L, iq4Var.d) + fy4.u1(iq4Var.j[0], 1000000L, iq4Var.c) >= iq4Var.e) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void P(long j) throws r83 {
        while (!this.n.isEmpty() && ((su2.b) this.n.peek()).b == j) {
            u((su2.b) this.n.pop());
        }
        l();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void S(jz0 jz0Var) throws r83 {
        int size = this.e.size();
        long j = Long.MAX_VALUE;
        b bVar = null;
        for (int i = 0; i < size; i++) {
            zq4 zq4Var = ((b) this.e.valueAt(i)).b;
            if (zq4Var.p) {
                long j2 = zq4Var.d;
                if (j2 < j) {
                    bVar = (b) this.e.valueAt(i);
                    j = j2;
                }
            }
        }
        if (bVar == null) {
            this.t = 3;
            return;
        }
        int position = (int) (j - jz0Var.getPosition());
        if (position < 0) {
            throw r83.a("Offset to encryption data was negative.", null);
        }
        jz0Var.q(position);
        bVar.b.a(jz0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean T(jz0 jz0Var) throws r83 {
        int iD;
        b bVarO = this.D;
        if (bVarO == null) {
            bVarO = o(this.e);
            if (bVarO == null) {
                int position = (int) (this.y - jz0Var.getPosition());
                if (position < 0) {
                    throw r83.a("Offset to end of mdat was negative.", null);
                }
                jz0Var.q(position);
                l();
                return false;
            }
            int iD2 = (int) (bVarO.d() - jz0Var.getPosition());
            if (iD2 < 0) {
                xz1.i("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                iD2 = 0;
            }
            jz0Var.q(iD2);
            this.D = bVarO;
        }
        if (this.t == 3) {
            this.E = bVarO.f();
            this.H = !i(bVarO.d.a.g);
            if (bVarO.f < bVarO.i) {
                jz0Var.q(this.E);
                bVarO.m();
                if (!bVarO.h()) {
                    this.D = null;
                }
                this.t = 3;
                return true;
            }
            if (bVarO.d.a.h == 1) {
                this.E -= 8;
                jz0Var.q(8);
            }
            boolean zEquals = "audio/ac4".equals(bVarO.d.a.g.p);
            int i = this.E;
            if (zEquals) {
                this.F = bVarO.i(i, 7);
                p1.b(this.E, this.j);
                bVarO.a.a(this.j, 7);
                this.F += 7;
            } else {
                this.F = bVarO.i(i, 0);
            }
            this.E += this.F;
            this.t = 4;
            this.G = 0;
        }
        iq4 iq4Var = bVarO.d.a;
        gr4 gr4Var = bVarO.a;
        long jE = bVarO.e();
        yo4 yo4Var = this.k;
        if (yo4Var != null) {
            jE = yo4Var.a(jE);
        }
        if (iq4Var.k == 0) {
            while (true) {
                int i2 = this.F;
                int i3 = this.E;
                if (i2 >= i3) {
                    break;
                }
                this.F += gr4Var.d(jz0Var, i3 - i2, false);
            }
        } else {
            byte[] bArrF = this.g.f();
            bArrF[0] = 0;
            bArrF[1] = 0;
            bArrF[2] = 0;
            int i4 = 4 - iq4Var.k;
            while (this.F < this.E) {
                int i5 = this.G;
                if (i5 != 0) {
                    if (this.I) {
                        this.h.b0(i5);
                        jz0Var.readFully(this.h.f(), 0, this.G);
                        gr4Var.a(this.h, this.G);
                        iD = this.G;
                        int iM = dx2.M(this.h.f(), this.h.j());
                        this.h.f0(0);
                        this.h.e0(iM);
                        int i6 = iq4Var.g.r;
                        mq3 mq3Var = this.p;
                        if (i6 != -1) {
                            int iF = mq3Var.f();
                            int i7 = iq4Var.g.r;
                            if (iF != i7) {
                                this.p.g(i7);
                            }
                        } else if (mq3Var.f() != 0) {
                            this.p.g(0);
                        }
                        this.p.a(jE, this.h);
                        if ((bVarO.c() & 4) != 0) {
                            this.p.d();
                        }
                    } else {
                        iD = gr4Var.d(jz0Var, i5, false);
                    }
                    this.F += iD;
                    this.G -= iD;
                } else if (this.L.length > 0 || !this.H) {
                    int iP = dx2.p(iq4Var.g);
                    if (iq4Var.k + iP > this.E - this.F) {
                        iP = 0;
                    }
                    jz0Var.readFully(bArrF, i4, iq4Var.k + iP);
                    this.g.f0(0);
                    int iZ = this.g.z();
                    if (iZ < 0) {
                        throw r83.a("Invalid NAL length", null);
                    }
                    this.G = iZ - iP;
                    this.f.f0(0);
                    gr4Var.a(this.f, 4);
                    this.F += 4;
                    this.E += i4;
                    this.I = this.L.length > 0 && iP > 0 && dx2.o(iq4Var.g, bArrF, 4);
                    gr4Var.a(this.g, iP);
                    this.F += iP;
                    if (iP > 0 && !this.H && dx2.l(bArrF, 4, iP, iq4Var.g)) {
                        this.H = true;
                    }
                }
            }
        }
        int iC = bVarO.c();
        if (!this.H) {
            iC |= 67108864;
        }
        int i8 = iC;
        yq4 yq4VarG = bVarO.g();
        gr4Var.b(jE, i8, this.E, 0, yq4VarG != null ? yq4VarG.c : null);
        z(jE);
        if (!bVarO.h()) {
            this.D = null;
        }
        this.t = 3;
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public void a(long j, long j2) {
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            ((b) this.e.valueAt(i)).k();
        }
        this.o.clear();
        this.z = 0;
        this.p.b();
        this.A = j2;
        this.n.clear();
        l();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public void b(mz0 mz0Var) {
        this.J = (this.b & 32) == 0 ? new li4(mz0Var, this.a) : mz0Var;
        l();
        q();
        iq4 iq4Var = this.c;
        if (iq4Var != null) {
            t41.b bVarB = iq4Var.g.b();
            bVarB.X(mt2.a(this.c.g));
            this.e.put(0, new b(this.J.e(0, this.c.b), new hr4(this.c, new long[0], new int[0], 0, new long[0], new int[0], new int[0], false, 0L, 0), new eh0(0, 0, 0, 0), bVarB.Q()));
            this.J.o();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public int d(jz0 jz0Var, yf3 yf3Var) throws r83 {
        while (true) {
            int i = this.t;
            if (i != 0) {
                if (i == 1) {
                    R(jz0Var);
                } else if (i == 2) {
                    S(jz0Var);
                } else if (T(jz0Var)) {
                    return 0;
                }
            } else if (!Q(jz0Var)) {
                long j = this.O;
                if (j == -1) {
                    this.p.d();
                    return -1;
                }
                yf3Var.a = j;
                this.O = -1L;
                this.J.u(this.r.b());
                this.N = true;
                return 1;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public boolean e(jz0 jz0Var) {
        s94 s94VarB = t94.b(jz0Var);
        this.s = s94VarB != null ? xi1.w(s94VarB) : xi1.u();
        return s94VarB == null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean i(t41 t41Var) {
        return Objects.equals(t41Var.p, "video/avc") ? (this.b & 64) != 0 : Objects.equals(t41Var.p, "video/hevc") && (this.b & 128) != 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l() {
        this.t = 0;
        this.w = 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final eh0 m(SparseArray sparseArray, int i) {
        return sparseArray.size() == 1 ? (eh0) sparseArray.valueAt(0) : (eh0) gg3.q((eh0) sparseArray.get(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: f()Ljava/util/List; */
    @Override // defpackage.hz0
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public xi1 f() {
        return this.s;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void q() {
        int i;
        gr4[] gr4VarArr = new gr4[2];
        this.K = gr4VarArr;
        gr4 gr4Var = this.q;
        int i2 = 0;
        if (gr4Var != null) {
            gr4VarArr[0] = gr4Var;
            i = 1;
        } else {
            i = 0;
        }
        int i3 = 100;
        if ((this.b & 4) != 0) {
            gr4VarArr[i] = this.J.e(100, 5);
            i3 = 101;
            i++;
        }
        gr4[] gr4VarArr2 = (gr4[]) fy4.i1(this.K, i);
        this.K = gr4VarArr2;
        for (gr4 gr4Var2 : gr4VarArr2) {
            gr4Var2.g(R);
        }
        this.L = new gr4[this.d.size()];
        while (i2 < this.L.length) {
            gr4 gr4VarE = this.J.e(i3, 3);
            gr4VarE.g((t41) this.d.get(i2));
            this.L[i2] = gr4VarE;
            i2++;
            i3++;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hz0
    public void release() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void s(jz0 jz0Var) {
        this.j.b0(8);
        jz0Var.s(this.j.f(), 0, 8);
        gl.g(this.j);
        jz0Var.q(this.j.g());
        jz0Var.p();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public iq4 t(iq4 iq4Var) {
        return iq4Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void u(su2.b bVar) throws r83 {
        int i = bVar.a;
        if (i == 1836019574) {
            y(bVar);
        } else if (i == 1836019558) {
            x(bVar);
        } else {
            if (this.n.isEmpty()) {
                return;
            }
            ((su2.b) this.n.peek()).b(bVar);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void v(r73 r73Var) {
        String str;
        String str2;
        long jU1;
        long jU12;
        long jS;
        long jA;
        if (this.K.length == 0) {
            return;
        }
        r73Var.f0(8);
        int iQ = gl.q(r73Var.z());
        if (iQ == 0) {
            str = (String) gg3.q(r73Var.K());
            str2 = (String) gg3.q(r73Var.K());
            long jS2 = r73Var.S();
            jU1 = fy4.u1(r73Var.S(), 1000000L, jS2);
            long j = this.C;
            long j2 = j != -9223372036854775807L ? j + jU1 : -9223372036854775807L;
            jU12 = fy4.u1(r73Var.S(), 1000L, jS2);
            jS = r73Var.S();
            jA = j2;
        } else {
            if (iQ != 1) {
                xz1.i("FragmentedMp4Extractor", "Skipping unsupported emsg version: " + iQ);
                return;
            }
            long jS3 = r73Var.S();
            jA = fy4.u1(r73Var.X(), 1000000L, jS3);
            long jU13 = fy4.u1(r73Var.S(), 1000L, jS3);
            long jS4 = r73Var.S();
            str = (String) gg3.q(r73Var.K());
            str2 = (String) gg3.q(r73Var.K());
            jU12 = jU13;
            jS = jS4;
            jU1 = -9223372036854775807L;
        }
        String str3 = str;
        String str4 = str2;
        byte[] bArr = new byte[r73Var.a()];
        r73Var.u(bArr, 0, r73Var.a());
        r73 r73Var2 = new r73(this.l.a(new dv0(str3, str4, jU12, jS, bArr)));
        int iA = r73Var2.a();
        for (gr4 gr4Var : this.K) {
            r73Var2.f0(0);
            gr4Var.a(r73Var2, iA);
        }
        ArrayDeque arrayDeque = this.o;
        if (jA == -9223372036854775807L) {
            arrayDeque.addLast(new a(jU1, true, iA));
            this.z += iA;
            return;
        }
        if (!arrayDeque.isEmpty()) {
            this.o.addLast(new a(jA, false, iA));
            this.z += iA;
            return;
        }
        yo4 yo4Var = this.k;
        if (yo4Var != null && !yo4Var.g()) {
            this.o.addLast(new a(jA, false, iA));
            this.z += iA;
            return;
        }
        yo4 yo4Var2 = this.k;
        if (yo4Var2 != null) {
            jA = yo4Var2.a(jA);
        }
        long j3 = jA;
        for (gr4 gr4Var2 : this.K) {
            gr4Var2.b(j3, 1, iA, 0, null);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void w(su2.c cVar, jz0 jz0Var) throws r83 {
        if (!this.n.isEmpty()) {
            ((su2.b) this.n.peek()).c(cVar);
            return;
        }
        int i = cVar.a;
        if (i != 1936286840) {
            if (i == 1701671783) {
                v(cVar.b);
                return;
            }
            return;
        }
        Pair pairH = H(cVar.b, jz0Var.getPosition());
        this.r.a((st) pairH.second);
        this.C = ((Long) pairH.first).longValue();
        if (!this.M) {
            this.J.u((yz3) pairH.second);
            this.M = true;
        } else {
            if ((this.b & Buffer.DEFAULT_SIZE) == 0 || this.N || this.r.c() <= 1) {
                return;
            }
            this.O = jz0Var.getPosition();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void x(su2.b bVar) throws r83 {
        B(bVar, this.e, this.c != null, this.b, this.i);
        oo0 oo0VarN = n(bVar.c);
        if (oo0VarN != null) {
            int size = this.e.size();
            for (int i = 0; i < size; i++) {
                ((b) this.e.valueAt(i)).n(oo0VarN);
            }
        }
        if (this.A != -9223372036854775807L) {
            int size2 = this.e.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((b) this.e.valueAt(i2)).l(this.A);
            }
            this.A = -9223372036854775807L;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void y(su2.b bVar) {
        long j;
        boolean z;
        int i = 0;
        gg3.w(this.c == null, "Unexpected moov box.");
        oo0 oo0VarN = n(bVar.c);
        su2.b bVar2 = (su2.b) gg3.q(bVar.d(1836475768));
        SparseArray sparseArray = new SparseArray();
        int size = bVar2.c.size();
        long jA = -9223372036854775807L;
        for (int i2 = 0; i2 < size; i2++) {
            su2.c cVar = (su2.c) bVar2.c.get(i2);
            int i3 = cVar.a;
            if (i3 == 1953654136) {
                Pair pairL = L(cVar.b);
                sparseArray.put(((Integer) pairL.first).intValue(), (eh0) pairL.second);
            } else if (i3 == 1835362404) {
                jA = A(cVar.b);
            }
        }
        su2.b bVarD = bVar.d(1835365473);
        xs2 xs2VarI = null;
        xs2 xs2VarU = bVarD != null ? gl.u(bVarD) : null;
        f91 f91Var = new f91();
        su2.c cVarE = bVar.e(1969517665);
        if (cVarE != null) {
            xs2VarI = gl.I(cVarE);
            f91Var.e(xs2VarI);
        }
        xs2 xs2Var = xs2VarI;
        xs2 xs2Var2 = new xs2(gl.w(((su2.c) gg3.q(bVar.e(1836476516))).b));
        if ((this.b & 16) != 0) {
            j = jA;
            z = true;
        } else {
            j = jA;
            z = false;
        }
        List listH = gl.H(bVar, f91Var, j, oo0VarN, z, false, new p81() { // from class: n71
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return this.f.t((iq4) obj);
            }
        }, false);
        int size2 = listH.size();
        if (this.e.size() != 0) {
            gg3.v(this.e.size() == size2);
            while (i < size2) {
                hr4 hr4Var = (hr4) listH.get(i);
                iq4 iq4Var = hr4Var.a;
                ((b) this.e.get(iq4Var.a)).j(hr4Var, m(sparseArray, iq4Var.a));
                i++;
            }
            return;
        }
        String strB = mt2.b(listH);
        while (i < size2) {
            hr4 hr4Var2 = (hr4) listH.get(i);
            iq4 iq4Var2 = hr4Var2.a;
            gr4 gr4VarE = this.J.e(i, iq4Var2.b);
            gr4VarE.e(iq4Var2.e);
            t41.b bVarB = iq4Var2.g.b();
            bVarB.X(strB);
            gt2.k(iq4Var2.b, f91Var, bVarB);
            gt2.l(iq4Var2.b, xs2VarU, bVarB, iq4Var2.g.l, xs2Var, xs2Var2);
            this.e.put(iq4Var2.a, new b(gr4VarE, hr4Var2, m(sparseArray, iq4Var2.a), bVarB.Q()));
            this.B = Math.max(this.B, iq4Var2.e);
            i++;
            f91Var = f91Var;
        }
        this.J.o();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void z(long j) {
        while (!this.o.isEmpty()) {
            a aVar = (a) this.o.removeFirst();
            this.z -= aVar.c;
            long jA = aVar.a;
            if (aVar.b) {
                jA += j;
            }
            yo4 yo4Var = this.k;
            if (yo4Var != null) {
                jA = yo4Var.a(jA);
            }
            long j2 = jA;
            for (gr4 gr4Var : this.K) {
                gr4Var.b(j2, 1, aVar.c, this.z, null);
            }
        }
    }

    public q71(ki4.a aVar, int i) {
        this(aVar, i, null, null, xi1.u(), null);
    }
}
