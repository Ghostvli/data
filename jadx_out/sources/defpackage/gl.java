package defpackage;

import android.util.Pair;
import com.hierynomus.msdtyp.FileTime;
import defpackage.bx;
import defpackage.su2;
import defpackage.t41;
import defpackage.xs2;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jupnp.support.model.dlna.DLNAProfiles;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class gl {
    public static final byte[] a = fy4.F0("OpusHead");

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final long a;
        public final long b;

        public a(long j, long j2) {
            this.a = j;
            this.b = j2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final int a;
        public int b;
        public int c;
        public long d;
        public final boolean e;
        public final r73 f;
        public final r73 g;
        public int h;
        public int i;

        public b(r73 r73Var, r73 r73Var2, boolean z) throws r83 {
            this.g = r73Var;
            this.f = r73Var2;
            this.e = z;
            r73Var2.f0(12);
            this.a = r73Var2.U();
            r73Var.f0(12);
            this.i = r73Var.U();
            nz0.a(r73Var.z() == 1, "first_chunk must be 1");
            this.b = -1;
        }

        public boolean a() {
            int i = this.b + 1;
            this.b = i;
            if (i == this.a) {
                return false;
            }
            boolean z = this.e;
            r73 r73Var = this.f;
            this.d = z ? r73Var.X() : r73Var.S();
            if (this.b == this.h) {
                this.c = this.g.U();
                this.g.g0(4);
                int i2 = this.i - 1;
                this.i = i2;
                this.h = i2 > 0 ? this.g.U() - 1 : -1;
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c {
        public final String a;
        public final byte[] b;
        public final long c;
        public final long d;

        public c(String str, byte[] bArr, long j, long j2) {
            this.a = str;
            this.b = bArr;
            this.c = j;
            this.d = j2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d {
        public final g a;

        public d(g gVar) {
            this.a = gVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e {
        public final long a;
        public final long b;
        public final String c;

        public e(long j, long j2, String str) {
            this.a = j;
            this.b = j2;
            this.c = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface f {
        int a();

        int b();

        int c();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class g {
        public final boolean a;
        public final boolean b;
        public final boolean c;

        public g(boolean z, boolean z2, boolean z3) {
            this.a = z;
            this.b = z2;
            this.c = z3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class h {
        public final yq4[] a;
        public t41 b;
        public int c;
        public int d = 0;

        public h(int i) {
            this.a = new yq4[i];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class i implements f {
        public final int a;
        public final int b;
        public final r73 c;

        public i(su2.c cVar, t41 t41Var) {
            r73 r73Var = cVar.b;
            this.c = r73Var;
            r73Var.f0(12);
            int iU = r73Var.U();
            if ("audio/raw".equals(t41Var.p)) {
                int iU0 = fy4.u0(t41Var.J, t41Var.H);
                if (iU % iU0 != 0) {
                    xz1.i("BoxParsers", "Audio sample size mismatch. stsd sample size: " + iU0 + ", stsz sample size: " + iU);
                    iU = iU0;
                }
            }
            this.a = iU == 0 ? -1 : iU;
            this.b = r73Var.U();
        }

        @Override // gl.f
        public int a() {
            return this.a;
        }

        @Override // gl.f
        public int b() {
            return this.b;
        }

        @Override // gl.f
        public int c() {
            int i = this.a;
            return i == -1 ? this.c.U() : i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class j implements f {
        public final r73 a;
        public final int b;
        public final int c;
        public int d;
        public int e;

        public j(su2.c cVar) {
            r73 r73Var = cVar.b;
            this.a = r73Var;
            r73Var.f0(12);
            this.c = r73Var.U() & 255;
            this.b = r73Var.U();
        }

        @Override // gl.f
        public int a() {
            return -1;
        }

        @Override // gl.f
        public int b() {
            return this.b;
        }

        @Override // gl.f
        public int c() {
            int i = this.c;
            if (i == 8) {
                return this.a.Q();
            }
            if (i == 16) {
                return this.a.Y();
            }
            int i2 = this.d;
            this.d = i2 + 1;
            if (i2 % 2 != 0) {
                return this.e & 15;
            }
            int iQ = this.a.Q();
            this.e = iQ;
            return (iQ & 240) >> 4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class k {
        public final int a;
        public final long b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

        public k(int i, long j, int i2, int i3, int i4, int i5) {
            this.a = i;
            this.b = j;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class l {
        public final d a;

        public l(d dVar) {
            this.a = dVar;
        }

        public boolean b() {
            d dVar = this.a;
            return dVar != null && dVar.a.a && this.a.a.b;
        }
    }

    public static yq4 A(r73 r73Var, int i2, int i3, String str) {
        int i4;
        int i5;
        int i6 = i2 + 8;
        while (true) {
            byte[] bArr = null;
            if (i6 - i2 >= i3) {
                return null;
            }
            r73Var.f0(i6);
            int iZ = r73Var.z();
            if (r73Var.z() == 1952804451) {
                int iQ = q(r73Var.z());
                r73Var.g0(1);
                if (iQ == 0) {
                    r73Var.g0(1);
                    i5 = 0;
                    i4 = 0;
                } else {
                    int iQ2 = r73Var.Q();
                    i4 = iQ2 & 15;
                    i5 = (iQ2 & 240) >> 4;
                }
                boolean z = r73Var.Q() == 1;
                int iQ3 = r73Var.Q();
                byte[] bArr2 = new byte[16];
                r73Var.u(bArr2, 0, 16);
                if (z && iQ3 == 0) {
                    int iQ4 = r73Var.Q();
                    bArr = new byte[iQ4];
                    r73Var.u(bArr, 0, iQ4);
                }
                return new yq4(z, str, iQ3, bArr2, i5, i4, bArr);
            }
            i6 += iZ;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x020c, code lost:
    
        r4 = r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0187  */
    /* JADX WARN: Type inference failed for: r26v2 */
    /* JADX WARN: Type inference failed for: r26v3 */
    /* JADX WARN: Type inference failed for: r26v4 */
    /* JADX WARN: Type inference failed for: r26v7, types: [boolean] */
    /* JADX WARN: Type inference failed for: r26v8 */
    /* JADX WARN: Type inference failed for: r29v0 */
    /* JADX WARN: Type inference failed for: r29v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r29v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.hr4 B(defpackage.iq4 r43, su2.b r44, defpackage.f91 r45, boolean r46) throws defpackage.r83 {
        /*
            Method dump skipped, instruction units count: 1652
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gl.B(iq4, su2$b, f91, boolean):hr4");
    }

    public static d C(r73 r73Var, int i2, int i3) throws r83 {
        r73Var.f0(i2 + 8);
        int iG = r73Var.g();
        while (iG - i2 < i3) {
            r73Var.f0(iG);
            int iZ = r73Var.z();
            nz0.a(iZ > 0, "childAtomSize must be positive");
            if (r73Var.z() == 1937011305) {
                r73Var.g0(4);
                int iQ = r73Var.Q();
                return new d(new g((iQ & 1) == 1, (iQ & 2) == 2, (iQ & 8) == 8));
            }
            iG += iZ;
        }
        return null;
    }

    public static h D(r73 r73Var, k kVar, String str, oo0 oo0Var, boolean z) throws r83 {
        r73Var.f0(12);
        int iZ = r73Var.z();
        h hVar = new h(iZ);
        for (int i2 = 0; i2 < iZ; i2++) {
            int iG = r73Var.g();
            int iZ2 = r73Var.z();
            nz0.a(iZ2 > 0, "childAtomSize must be positive");
            int iZ3 = r73Var.z();
            if (iZ3 == 1635148593 || iZ3 == 1635148595 || iZ3 == 1701733238 || iZ3 == 1831958048 || iZ3 == 1836070006 || iZ3 == 1752589105 || iZ3 == 1751479857 || iZ3 == 1987470129 || iZ3 == 1987471665 || iZ3 == 1932670515 || iZ3 == 1211250227 || iZ3 == 1748121139 || iZ3 == 1987063864 || iZ3 == 1987063865 || iZ3 == 1635135537 || iZ3 == 1685479798 || iZ3 == 1685479729 || iZ3 == 1685481573 || iZ3 == 1685481521 || iZ3 == 1634760241 || iZ3 == 1684108849) {
                L(r73Var, iZ3, iG, iZ2, kVar.a, str, kVar.d, oo0Var, hVar, i2);
            } else if (iZ3 == 1836069985 || iZ3 == 1701733217 || iZ3 == 1633889587 || iZ3 == 1700998451 || iZ3 == 1633889588 || iZ3 == 1835823201 || iZ3 == 1685353315 || iZ3 == 1685353317 || iZ3 == 1685353320 || iZ3 == 1685353324 || iZ3 == 1685353336 || iZ3 == 1935764850 || iZ3 == 1935767394 || iZ3 == 1819304813 || iZ3 == 1936684916 || iZ3 == 1953984371 || iZ3 == 778924082 || iZ3 == 778924083 || iZ3 == 1835557169 || iZ3 == 1835560241 || iZ3 == 1634492771 || iZ3 == 1634492791 || iZ3 == 1970037111 || iZ3 == 1332770163 || iZ3 == 1716281667 || iZ3 == 1767992678 || iZ3 == 1768973165 || iZ3 == 1718641517) {
                i(r73Var, iZ3, iG, iZ2, kVar.a, str, z, oo0Var, hVar, i2);
            } else if (iZ3 == 1414810956 || iZ3 == 1954034535 || iZ3 == 2004251764 || iZ3 == 1937010800 || iZ3 == 1664495672 || iZ3 == 1836070003) {
                h hVar2 = hVar;
                E(r73Var, iZ3, iG, iZ2, kVar, str, hVar2);
                hVar = hVar2;
            } else if (iZ3 == 1835365492) {
                v(r73Var, iZ3, iG, kVar.a, hVar);
            } else if (iZ3 == 1667329389) {
                hVar.b = new t41.b().j0(kVar.a).A0("application/x-camera-motion").Q();
            }
            r73Var.f0(iG + iZ2);
        }
        return hVar;
    }

    public static void E(r73 r73Var, int i2, int i3, int i4, k kVar, String str, h hVar) {
        r73Var.f0(i3 + 16);
        String str2 = "application/ttml+xml";
        xi1 xi1VarW = null;
        long j2 = Long.MAX_VALUE;
        if (i2 != 1414810956) {
            if (i2 == 1954034535) {
                int i5 = i4 - 16;
                byte[] bArr = new byte[i5];
                r73Var.u(bArr, 0, i5);
                xi1VarW = xi1.w(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i2 == 2004251764) {
                str2 = "application/x-mp4-vtt";
            } else if (i2 == 1937010800) {
                j2 = 0;
            } else if (i2 == 1664495672) {
                hVar.d = 1;
                str2 = "application/x-mp4-cea-608";
            } else {
                if (i2 != 1836070003) {
                    z20.a();
                    return;
                }
                int iG = r73Var.g();
                r73Var.g0(4);
                if (r73Var.z() == 1702061171) {
                    c cVarN = n(r73Var, iG);
                    if (cVarN.b == null || cVarN.b.length != 64) {
                        return;
                    }
                    xi1VarW = xi1.w(fy4.F0(d(cVarN.b, kVar.e, kVar.f)));
                    str2 = "application/vobsub";
                } else {
                    str2 = null;
                }
            }
        }
        if (str2 != null) {
            hVar.b = new t41.b().j0(kVar.a).A0(str2).o0(str).E0(j2).l0(xi1VarW).Q();
        }
    }

    public static k F(r73 r73Var) {
        long j2;
        r73Var.f0(8);
        int iQ = q(r73Var.z());
        r73Var.g0(iQ == 0 ? 8 : 16);
        int iZ = r73Var.z();
        r73Var.g0(4);
        int iG = r73Var.g();
        int i2 = iQ == 0 ? 4 : 8;
        int i3 = 0;
        while (true) {
            j2 = -9223372036854775807L;
            if (i3 >= i2) {
                r73Var.g0(i2);
                break;
            }
            if (r73Var.f()[iG + i3] != -1) {
                long jS = iQ == 0 ? r73Var.S() : r73Var.X();
                if (jS != 0) {
                    j2 = jS;
                }
            } else {
                i3++;
            }
        }
        r73Var.g0(10);
        int i4 = 0;
        long j3 = j2;
        int iY = r73Var.Y();
        r73Var.g0(4);
        int iZ2 = r73Var.z();
        int iZ3 = r73Var.z();
        r73Var.g0(4);
        int iZ4 = r73Var.z();
        int iZ5 = r73Var.z();
        if (iZ2 == 0 && iZ3 == 65536 && ((iZ4 == -65536 || iZ4 == 65536) && iZ5 == 0)) {
            i4 = 90;
        } else if (iZ2 == 0 && iZ3 == -65536 && ((iZ4 == 65536 || iZ4 == -65536) && iZ5 == 0)) {
            i4 = 270;
        } else if ((iZ2 == -65536 || iZ2 == 65536) && iZ3 == 0 && iZ4 == 0 && iZ5 == -65536) {
            i4 = 180;
        }
        int i5 = i4;
        r73Var.g0(16);
        short sM = r73Var.M();
        r73Var.g0(2);
        return new k(iZ, j3, iY, i5, sM, r73Var.M());
    }

    public static iq4 G(su2.b bVar, su2.c cVar, long j2, oo0 oo0Var, boolean z, boolean z2) throws r83 {
        long[] jArr;
        long[] jArr2;
        t41 t41VarQ;
        su2.b bVarD;
        Pair pairM;
        su2.b bVar2 = (su2.b) gg3.q(bVar.d(1835297121));
        int iF = f(r(((su2.c) gg3.q(bVar2.e(1751411826))).b));
        if (iF == -1) {
            return null;
        }
        k kVarF = F(((su2.c) gg3.q(bVar.e(1953196132))).b);
        long j3 = j2 == -9223372036854775807L ? kVarF.b : j2;
        long j4 = w(cVar.b).c;
        long jU1 = j3 != -9223372036854775807L ? fy4.u1(j3, 1000000L, j4) : -9223372036854775807L;
        su2.b bVar3 = (su2.b) gg3.q(((su2.b) gg3.q(bVar2.d(1835626086))).d(1937007212));
        e eVarT = t(((su2.c) gg3.q(bVar2.e(1835296868))).b);
        su2.c cVarE = bVar3.e(1937011556);
        if (cVarE == null) {
            xz1.i("BoxParsers", "Ignoring track where sample table (stbl) box is missing a sample description (stsd).");
            return null;
        }
        h hVarD = D(cVarE.b, kVarF, eVarT.c, oo0Var, z2);
        if (z || (bVarD = bVar.d(1701082227)) == null || (pairM = m(bVarD)) == null) {
            jArr = null;
            jArr2 = null;
        } else {
            long[] jArr3 = (long[]) pairM.first;
            jArr2 = (long[]) pairM.second;
            jArr = jArr3;
        }
        if (hVarD.b == null) {
            return null;
        }
        if (kVarF.c != 0) {
            ru2 ru2Var = new ru2(kVarF.c);
            t41.b bVarB = hVarD.b.b();
            xs2 xs2Var = hVarD.b.l;
            t41VarQ = bVarB.s0(xs2Var != null ? xs2Var.a(ru2Var) : new xs2(ru2Var)).Q();
        } else {
            t41VarQ = hVarD.b;
        }
        return new iq4(kVarF.a, iF, eVarT.a, j4, jU1, eVarT.b, t41VarQ, hVarD.d, hVarD.a, hVarD.c, jArr, jArr2);
    }

    public static List H(su2.b bVar, f91 f91Var, long j2, oo0 oo0Var, boolean z, boolean z2, p81 p81Var, boolean z3) {
        iq4 iq4Var;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < bVar.d.size(); i2++) {
            su2.b bVar2 = (su2.b) bVar.d.get(i2);
            if (bVar2.a == 1953653099 && (iq4Var = (iq4) p81Var.apply(G(bVar2, (su2.c) gg3.q(bVar.e(1836476516)), j2, oo0Var, z, z2))) != null) {
                arrayList.add(B(iq4Var, (su2.b) gg3.q(((su2.b) gg3.q(((su2.b) gg3.q(bVar2.d(1835297121))).d(1835626086))).d(1937007212)), f91Var, z3));
            }
        }
        return arrayList;
    }

    public static xs2 I(su2.c cVar) {
        r73 r73Var = cVar.b;
        r73Var.f0(8);
        xs2 xs2Var = new xs2(new xs2.a[0]);
        while (r73Var.a() >= 8) {
            int iG = r73Var.g();
            int iZ = r73Var.z();
            int iZ2 = r73Var.z();
            if (iZ2 == 1835365473) {
                r73Var.f0(iG);
                xs2Var = xs2Var.b(J(r73Var, iG + iZ));
            } else if (iZ2 == 1936553057) {
                r73Var.f0(iG);
                xs2Var = xs2Var.b(p94.b(r73Var, iG + iZ));
            } else if (iZ2 == -1451722374) {
                xs2Var = xs2Var.b(M(r73Var));
            }
            r73Var.f0(iG + iZ);
        }
        return xs2Var;
    }

    public static xs2 J(r73 r73Var, int i2) {
        r73Var.g0(8);
        g(r73Var);
        while (r73Var.g() < i2) {
            int iG = r73Var.g();
            int iZ = r73Var.z();
            if (r73Var.z() == 1768715124) {
                r73Var.f0(iG);
                return s(r73Var, iG + iZ);
            }
            r73Var.f0(iG + iZ);
        }
        return null;
    }

    public static l K(r73 r73Var, int i2, int i3) throws r83 {
        r73Var.f0(i2 + 8);
        int iG = r73Var.g();
        d dVarC = null;
        while (iG - i2 < i3) {
            r73Var.f0(iG);
            int iZ = r73Var.z();
            nz0.a(iZ > 0, "childAtomSize must be positive");
            if (r73Var.z() == 1702454643) {
                dVarC = C(r73Var, iG, iZ);
            }
            iG += iZ;
        }
        if (dVarC == null) {
            return null;
        }
        return new l(dVarC);
    }

    /* JADX WARN: Removed duplicated region for block: B:220:0x0540  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void L(defpackage.r73 r45, int r46, int r47, int r48, int r49, java.lang.String r50, int r51, defpackage.oo0 r52, gl.h r53, int r54) throws defpackage.r83 {
        /*
            Method dump skipped, instruction units count: 1808
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gl.L(r73, int, int, int, int, java.lang.String, int, oo0, gl$h, int):void");
    }

    public static xs2 M(r73 r73Var) {
        short sM = r73Var.M();
        r73Var.g0(2);
        String strN = r73Var.N(sM);
        int iMax = Math.max(strN.lastIndexOf(43), strN.lastIndexOf(45));
        try {
            return new xs2(new zu2(Float.parseFloat(strN.substring(0, iMax)), Float.parseFloat(strN.substring(iMax, strN.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            return null;
        }
    }

    public static int N(int i2) {
        int i3 = (i2 >> 16) & 255;
        int i4 = ((i2 >> 8) & 255) - 128;
        int i5 = ((i4 * 14075) / FileTime.NANO100_TO_MILLI) + i3;
        int i6 = (i2 & 255) - 128;
        int i7 = (i3 - ((i6 * 3455) / FileTime.NANO100_TO_MILLI)) - ((i4 * 7169) / FileTime.NANO100_TO_MILLI);
        return fy4.s(i3 + ((i6 * 17790) / FileTime.NANO100_TO_MILLI), 0, 255) | (fy4.s(i5, 0, 255) << 16) | (fy4.s(i7, 0, 255) << 8);
    }

    public static ByteBuffer a() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    public static boolean b(long[] jArr, long j2, long j3, long j4) {
        int length = jArr.length - 1;
        return jArr[0] <= j3 && j3 < jArr[fy4.s(4, 0, length)] && jArr[fy4.s(jArr.length - 4, 0, length)] < j4 && j4 <= j2 + 2;
    }

    public static int c(r73 r73Var, int i2, int i3, int i4) throws r83 {
        int iG = r73Var.g();
        nz0.a(iG >= i3, null);
        while (iG - i3 < i4) {
            r73Var.f0(iG);
            int iZ = r73Var.z();
            nz0.a(iZ > 0, "childAtomSize must be positive");
            if (r73Var.z() == i2) {
                return iG;
            }
            iG += iZ;
        }
        return -1;
    }

    public static String d(byte[] bArr, int i2, int i3) {
        gg3.v(bArr.length == 64);
        ArrayList arrayList = new ArrayList(16);
        for (int i4 = 0; i4 < bArr.length - 3; i4 += 4) {
            arrayList.add(String.format("%06x", Integer.valueOf(N(ll1.i(bArr[i4], bArr[i4 + 1], bArr[i4 + 2], bArr[i4 + 3])))));
        }
        return "size: " + i2 + "x" + i3 + "\npalette: " + wn1.h(", ").e(arrayList) + "\n";
    }

    public static String e(int i2) {
        char[] cArr = {(char) (((i2 >> 10) & 31) + 96), (char) (((i2 >> 5) & 31) + 96), (char) ((i2 & 31) + 96)};
        for (int i3 = 0; i3 < 3; i3++) {
            char c2 = cArr[i3];
            if (c2 < 'a' || c2 > 'z') {
                return null;
            }
        }
        return new String(cArr);
    }

    public static int f(int i2) {
        if (i2 == 1936684398) {
            return 1;
        }
        if (i2 == 1986618469) {
            return 2;
        }
        if (i2 == 1952807028 || i2 == 1935832172 || i2 == 1937072756 || i2 == 1668047728 || i2 == 1937072752) {
            return 3;
        }
        return i2 == 1835365473 ? 5 : -1;
    }

    public static void g(r73 r73Var) {
        int iG = r73Var.g();
        r73Var.g0(4);
        if (r73Var.z() != 1751411826) {
            iG += 4;
        }
        r73Var.f0(iG);
    }

    public static bx h(r73 r73Var) {
        bx.b bVar = new bx.b();
        q73 q73Var = new q73(r73Var.f());
        q73Var.p(r73Var.g() * 8);
        q73Var.s(1);
        int iH = q73Var.h(8);
        for (int i2 = 0; i2 < iH; i2++) {
            q73Var.s(1);
            int iH2 = q73Var.h(8);
            for (int i3 = 0; i3 < iH2; i3++) {
                q73Var.r(6);
                boolean zG = q73Var.g();
                q73Var.q();
                q73Var.s(11);
                q73Var.r(4);
                int iH3 = q73Var.h(4) + 8;
                bVar.g(iH3);
                bVar.b(iH3);
                q73Var.s(1);
                if (zG) {
                    int iH4 = q73Var.h(8);
                    int iH5 = q73Var.h(8);
                    q73Var.s(1);
                    bVar.d(bx.k(iH4)).c(q73Var.g() ? 1 : 2).e(bx.l(iH5));
                }
            }
        }
        return bVar.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:142:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x03aa A[PHI: r2 r8 r9 r11 r16 r23
      0x03aa: PHI (r2v17 java.util.List) = (r2v2 java.util.List), (r2v2 java.util.List), (r2v16 java.util.List), (r2v2 java.util.List), (r2v26 java.util.List) binds: [B:241:0x045c, B:243:0x046a, B:246:0x0474, B:234:0x0420, B:207:0x037a] A[DONT_GENERATE, DONT_INLINE]
      0x03aa: PHI (r8v11 int) = (r8v8 int), (r8v8 int), (r8v8 int), (r8v8 int), (r8v15 int) binds: [B:241:0x045c, B:243:0x046a, B:246:0x0474, B:234:0x0420, B:207:0x037a] A[DONT_GENERATE, DONT_INLINE]
      0x03aa: PHI (r9v8 int) = (r9v5 int), (r9v5 int), (r9v5 int), (r9v5 int), (r9v10 int) binds: [B:241:0x045c, B:243:0x046a, B:246:0x0474, B:234:0x0420, B:207:0x037a] A[DONT_GENERATE, DONT_INLINE]
      0x03aa: PHI (r11v11 java.lang.String) = 
      (r11v9 java.lang.String)
      (r11v10 java.lang.String)
      (r11v10 java.lang.String)
      (r11v12 java.lang.String)
      (r11v9 java.lang.String)
     binds: [B:241:0x045c, B:243:0x046a, B:246:0x0474, B:234:0x0420, B:207:0x037a] A[DONT_GENERATE, DONT_INLINE]
      0x03aa: PHI (r16v3 gl$c) = (r16v1 gl$c), (r16v2 gl$c), (r16v2 gl$c), (r16v1 gl$c), (r16v1 gl$c) binds: [B:241:0x045c, B:243:0x046a, B:246:0x0474, B:234:0x0420, B:207:0x037a] A[DONT_GENERATE, DONT_INLINE]
      0x03aa: PHI (r23v2 int) = (r23v1 int), (r23v1 int), (r23v1 int), (r23v3 int), (r23v4 int) binds: [B:241:0x045c, B:243:0x046a, B:246:0x0474, B:234:0x0420, B:207:0x037a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x015a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void i(defpackage.r73 r26, int r27, int r28, int r29, int r30, java.lang.String r31, boolean r32, defpackage.oo0 r33, gl.h r34, int r35) throws defpackage.r83 {
        /*
            Method dump skipped, instruction units count: 1295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gl.i(r73, int, int, int, int, java.lang.String, boolean, oo0, gl$h, int):void");
    }

    public static bx j(r73 r73Var) {
        bx.b bVar = new bx.b();
        q73 q73Var = new q73(r73Var.f());
        q73Var.p(r73Var.g() * 8);
        q73Var.s(1);
        int iH = q73Var.h(3);
        q73Var.r(6);
        boolean zG = q73Var.g();
        boolean zG2 = q73Var.g();
        if (iH == 2 && zG) {
            bVar.g(zG2 ? 12 : 10);
            bVar.b(zG2 ? 12 : 10);
        } else if (iH <= 2) {
            bVar.g(zG ? 10 : 8);
            bVar.b(zG ? 10 : 8);
        }
        q73Var.r(13);
        q73Var.q();
        int iH2 = q73Var.h(4);
        if (iH2 != 1) {
            xz1.g("BoxParsers", "Unsupported obu_type: " + iH2);
            return bVar.a();
        }
        if (q73Var.g()) {
            xz1.g("BoxParsers", "Unsupported obu_extension_flag");
            return bVar.a();
        }
        boolean zG3 = q73Var.g();
        q73Var.q();
        if (zG3 && q73Var.h(8) > 127) {
            xz1.g("BoxParsers", "Excessive obu_size");
            return bVar.a();
        }
        int iH3 = q73Var.h(3);
        q73Var.q();
        if (q73Var.g()) {
            xz1.g("BoxParsers", "Unsupported reduced_still_picture_header");
            return bVar.a();
        }
        if (q73Var.g()) {
            xz1.g("BoxParsers", "Unsupported timing_info_present_flag");
            return bVar.a();
        }
        if (q73Var.g()) {
            xz1.g("BoxParsers", "Unsupported initial_display_delay_present_flag");
            return bVar.a();
        }
        int iH4 = q73Var.h(5);
        boolean z = false;
        for (int i2 = 0; i2 <= iH4; i2++) {
            q73Var.r(12);
            if (q73Var.h(5) > 7) {
                q73Var.q();
            }
        }
        int iH5 = q73Var.h(4);
        int iH6 = q73Var.h(4);
        q73Var.r(iH5 + 1);
        q73Var.r(iH6 + 1);
        if (q73Var.g()) {
            q73Var.r(7);
        }
        q73Var.r(7);
        boolean zG4 = q73Var.g();
        if (zG4) {
            q73Var.r(2);
        }
        if ((q73Var.g() ? 2 : q73Var.h(1)) > 0 && !q73Var.g()) {
            q73Var.r(1);
        }
        if (zG4) {
            q73Var.r(3);
        }
        q73Var.r(3);
        boolean zG5 = q73Var.g();
        if (iH3 == 2 && zG5) {
            q73Var.q();
        }
        if (iH3 != 1 && q73Var.g()) {
            z = true;
        }
        if (q73Var.g()) {
            int iH7 = q73Var.h(8);
            int iH8 = q73Var.h(8);
            bVar.d(bx.k(iH7)).c(((z || iH7 != 1 || iH8 != 13 || q73Var.h(8) != 0) ? q73Var.h(1) : 1) != 1 ? 2 : 1).e(bx.l(iH8));
        }
        return bVar.a();
    }

    public static a k(r73 r73Var, int i2) {
        r73Var.f0(i2 + 8);
        r73Var.g0(4);
        return new a(r73Var.S(), r73Var.S());
    }

    public static Pair l(r73 r73Var, int i2, int i3) throws r83 {
        int i4 = i2 + 8;
        int i5 = -1;
        int i6 = 0;
        String strN = null;
        Integer numValueOf = null;
        while (i4 - i2 < i3) {
            r73Var.f0(i4);
            int iZ = r73Var.z();
            int iZ2 = r73Var.z();
            if (iZ2 == 1718775137) {
                numValueOf = Integer.valueOf(r73Var.z());
            } else if (iZ2 == 1935894637) {
                r73Var.g0(4);
                strN = r73Var.N(4);
            } else if (iZ2 == 1935894633) {
                i5 = i4;
                i6 = iZ;
            }
            i4 += iZ;
        }
        if (!"cenc".equals(strN) && !"cbc1".equals(strN) && !"cens".equals(strN) && !"cbcs".equals(strN)) {
            return null;
        }
        nz0.a(numValueOf != null, "frma atom is mandatory");
        nz0.a(i5 != -1, "schi atom is mandatory");
        yq4 yq4VarA = A(r73Var, i5, i6, strN);
        nz0.a(yq4VarA != null, "tenc atom is mandatory");
        return Pair.create(numValueOf, (yq4) fy4.l(yq4VarA));
    }

    public static Pair m(su2.b bVar) {
        su2.c cVarE = bVar.e(1701606260);
        if (cVarE == null) {
            return null;
        }
        r73 r73Var = cVarE.b;
        r73Var.f0(8);
        int iQ = q(r73Var.z());
        int iU = r73Var.U();
        long[] jArr = new long[iU];
        long[] jArr2 = new long[iU];
        for (int i2 = 0; i2 < iU; i2++) {
            jArr[i2] = iQ == 1 ? r73Var.X() : r73Var.S();
            jArr2[i2] = iQ == 1 ? r73Var.J() : r73Var.z();
            if (r73Var.M() != 1) {
                jl.a("Unsupported media rate.");
                return null;
            }
            r73Var.g0(2);
        }
        return Pair.create(jArr, jArr2);
    }

    public static c n(r73 r73Var, int i2) {
        r73Var.f0(i2 + 12);
        r73Var.g0(1);
        o(r73Var);
        r73Var.g0(2);
        int iQ = r73Var.Q();
        if ((iQ & 128) != 0) {
            r73Var.g0(2);
        }
        if ((iQ & 64) != 0) {
            r73Var.g0(r73Var.Q());
        }
        if ((iQ & 32) != 0) {
            r73Var.g0(2);
        }
        r73Var.g0(1);
        o(r73Var);
        String strH = nt2.h(r73Var.Q());
        if (DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_MPEG.equals(strH) || "audio/vnd.dts".equals(strH) || "audio/vnd.dts.hd".equals(strH)) {
            return new c(strH, null, -1L, -1L);
        }
        r73Var.g0(4);
        long jS = r73Var.S();
        long jS2 = r73Var.S();
        r73Var.g0(1);
        int iO = o(r73Var);
        long j2 = jS2;
        byte[] bArr = new byte[iO];
        r73Var.u(bArr, 0, iO);
        if (j2 <= 0) {
            j2 = -1;
        }
        return new c(strH, bArr, j2, jS > 0 ? jS : -1L);
    }

    public static int o(r73 r73Var) {
        int iQ = r73Var.Q();
        int i2 = iQ & 127;
        while ((iQ & 128) == 128) {
            iQ = r73Var.Q();
            i2 = (i2 << 7) | (iQ & 127);
        }
        return i2;
    }

    public static int p(int i2) {
        return i2 & 16777215;
    }

    public static int q(int i2) {
        return (i2 >> 24) & 255;
    }

    public static int r(r73 r73Var) {
        r73Var.f0(16);
        return r73Var.z();
    }

    public static xs2 s(r73 r73Var, int i2) {
        r73Var.g0(8);
        ArrayList arrayList = new ArrayList();
        while (r73Var.g() < i2) {
            xs2.a aVarC = gt2.c(r73Var);
            if (aVarC != null) {
                arrayList.add(aVarC);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new xs2(arrayList);
    }

    public static e t(r73 r73Var) {
        long j2;
        r73Var.f0(8);
        int iQ = q(r73Var.z());
        r73Var.g0(iQ == 0 ? 8 : 16);
        long jS = r73Var.S();
        int iG = r73Var.g();
        int i2 = iQ == 0 ? 4 : 8;
        int i3 = 0;
        while (true) {
            j2 = -9223372036854775807L;
            if (i3 >= i2) {
                r73Var.g0(i2);
                break;
            }
            if (r73Var.f()[iG + i3] != -1) {
                long jS2 = iQ == 0 ? r73Var.S() : r73Var.X();
                if (jS2 != 0) {
                    long jU1 = fy4.u1(jS2, 1000000L, jS);
                    jS = jS;
                    j2 = jU1;
                }
            } else {
                i3++;
            }
        }
        return new e(jS, j2, e(r73Var.Y()));
    }

    public static xs2 u(su2.b bVar) {
        su2.c cVarE = bVar.e(1751411826);
        su2.c cVarE2 = bVar.e(1801812339);
        su2.c cVarE3 = bVar.e(1768715124);
        if (cVarE == null || cVarE2 == null || cVarE3 == null || r(cVarE.b) != 1835299937) {
            return null;
        }
        r73 r73Var = cVarE2.b;
        r73Var.f0(12);
        int iZ = r73Var.z();
        String[] strArr = new String[iZ];
        for (int i2 = 0; i2 < iZ; i2++) {
            int iZ2 = r73Var.z();
            r73Var.g0(4);
            strArr[i2] = r73Var.N(iZ2 - 8);
        }
        r73 r73Var2 = cVarE3.b;
        r73Var2.f0(8);
        ArrayList arrayList = new ArrayList();
        while (r73Var2.a() > 8) {
            int iG = r73Var2.g();
            int iZ3 = r73Var2.z();
            int iZ4 = r73Var2.z() - 1;
            if (iZ4 < 0 || iZ4 >= iZ) {
                xz1.i("BoxParsers", "Skipped metadata with unknown key index: " + iZ4);
            } else {
                w62 w62VarH = gt2.h(r73Var2, iG + iZ3, strArr[iZ4]);
                if (w62VarH != null) {
                    arrayList.add(w62VarH);
                }
            }
            r73Var2.f0(iG + iZ3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new xs2(arrayList);
    }

    public static void v(r73 r73Var, int i2, int i3, int i4, h hVar) {
        r73Var.f0(i3 + 16);
        if (i2 == 1835365492) {
            r73Var.K();
            String strK = r73Var.K();
            if (strK != null) {
                hVar.b = new t41.b().j0(i4).A0(strK).Q();
            }
        }
    }

    public static av2 w(r73 r73Var) {
        long J;
        long J2;
        r73Var.f0(8);
        if (q(r73Var.z()) == 0) {
            J = r73Var.S();
            J2 = r73Var.S();
        } else {
            J = r73Var.J();
            J2 = r73Var.J();
        }
        return new av2(J, J2, r73Var.S());
    }

    public static float x(r73 r73Var, int i2) {
        r73Var.f0(i2 + 8);
        return r73Var.U() / r73Var.U();
    }

    public static byte[] y(r73 r73Var, int i2, int i3) {
        int i4 = i2 + 8;
        while (i4 - i2 < i3) {
            r73Var.f0(i4);
            int iZ = r73Var.z();
            if (r73Var.z() == 1886547818) {
                return Arrays.copyOfRange(r73Var.f(), i4, iZ + i4);
            }
            i4 += iZ;
        }
        return null;
    }

    public static Pair z(r73 r73Var, int i2, int i3) throws r83 {
        Pair pairL;
        int iG = r73Var.g();
        while (iG - i2 < i3) {
            r73Var.f0(iG);
            int iZ = r73Var.z();
            nz0.a(iZ > 0, "childAtomSize must be positive");
            if (r73Var.z() == 1936289382 && (pairL = l(r73Var, iG, iZ)) != null) {
                return pairL;
            }
            iG += iZ;
        }
        return null;
    }
}
