package defpackage;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.xunlei.downloadlib.parameter.XLConstant;
import defpackage.ki4;
import defpackage.wt4;
import defpackage.yz3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class vt4 implements hz0 {
    public static final pz0 v = new pz0() { // from class: ut4
        @Override // defpackage.pz0
        public final hz0[] d() {
            return vt4.g();
        }
    };
    public final int a;
    public final int b;
    public final int c;
    public final List d;
    public final r73 e;
    public final SparseIntArray f;
    public final wt4.c g;
    public final ki4.a h;
    public final SparseArray i;
    public final SparseBooleanArray j;
    public final SparseBooleanArray k;
    public final tt4 l;
    public st4 m;
    public mz0 n;
    public int o;
    public boolean p;
    public boolean q;
    public boolean r;
    public wt4 s;
    public int t;
    public int u;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements vz3 {
        public final q73 a = new q73(new byte[4]);

        public a() {
        }

        @Override // defpackage.vz3
        public void a(r73 r73Var) {
            if (r73Var.Q() == 0 && (r73Var.Q() & 128) != 0) {
                r73Var.g0(6);
                int iA = r73Var.a() / 4;
                for (int i = 0; i < iA; i++) {
                    r73Var.t(this.a, 4);
                    int iH = this.a.h(16);
                    this.a.r(3);
                    q73 q73Var = this.a;
                    if (iH == 0) {
                        q73Var.r(13);
                    } else {
                        int iH2 = q73Var.h(13);
                        if (vt4.this.i.get(iH2) == null) {
                            vt4.this.i.put(iH2, new wz3(vt4.this.new b(iH2)));
                            vt4.m(vt4.this);
                        }
                    }
                }
                if (vt4.this.a != 2) {
                    vt4.this.i.remove(0);
                }
            }
        }

        @Override // defpackage.vz3
        public void b(yo4 yo4Var, mz0 mz0Var, wt4.d dVar) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements vz3 {
        public final q73 a = new q73(new byte[5]);
        public final SparseArray b = new SparseArray();
        public final SparseIntArray c = new SparseIntArray();
        public final int d;

        public b(int i) {
            this.d = i;
        }

        @Override // defpackage.vz3
        public void a(r73 r73Var) {
            yo4 yo4Var;
            if (r73Var.Q() != 2) {
                return;
            }
            if (vt4.this.a == 1 || vt4.this.a == 2 || vt4.this.o == 1) {
                yo4Var = (yo4) vt4.this.d.get(0);
            } else {
                yo4Var = new yo4(((yo4) vt4.this.d.get(0)).d());
                vt4.this.d.add(yo4Var);
            }
            if ((r73Var.Q() & 128) == 0) {
                return;
            }
            r73Var.g0(1);
            int iY = r73Var.Y();
            int i = 3;
            r73Var.g0(3);
            r73Var.t(this.a, 2);
            this.a.r(3);
            int i2 = 13;
            vt4.this.u = this.a.h(13);
            r73Var.t(this.a, 2);
            int i3 = 4;
            this.a.r(4);
            r73Var.g0(this.a.h(12));
            if (vt4.this.a == 2 && vt4.this.s == null) {
                wt4.b bVar = new wt4.b(21, null, 0, null, fy4.f);
                vt4 vt4Var = vt4.this;
                vt4Var.s = vt4Var.g.b(21, bVar);
                if (vt4.this.s != null) {
                    vt4.this.s.b(yo4Var, vt4.this.n, new wt4.d(iY, 21, 8192));
                }
            }
            this.b.clear();
            this.c.clear();
            int iA = r73Var.a();
            while (iA > 0) {
                r73Var.t(this.a, 5);
                int iH = this.a.h(8);
                this.a.r(i);
                int iH2 = this.a.h(i2);
                this.a.r(i3);
                int iH3 = this.a.h(12);
                wt4.b bVarC = c(r73Var, iH3);
                if (iH == 6 || iH == 5) {
                    iH = bVarC.a;
                }
                iA -= iH3 + 5;
                int i4 = vt4.this.a == 2 ? iH : iH2;
                if (!vt4.this.j.get(i4)) {
                    wt4 wt4VarB = (vt4.this.a == 2 && iH == 21) ? vt4.this.s : vt4.this.g.b(iH, bVarC);
                    if (vt4.this.a != 2 || iH2 < this.c.get(i4, 8192)) {
                        this.c.put(i4, iH2);
                        this.b.put(i4, wt4VarB);
                    }
                }
                i = 3;
                i3 = 4;
                i2 = 13;
            }
            int size = this.c.size();
            for (int i5 = 0; i5 < size; i5++) {
                int iKeyAt = this.c.keyAt(i5);
                int iValueAt = this.c.valueAt(i5);
                vt4.this.j.put(iKeyAt, true);
                vt4.this.k.put(iValueAt, true);
                wt4 wt4Var = (wt4) this.b.valueAt(i5);
                if (wt4Var != null) {
                    if (wt4Var != vt4.this.s) {
                        wt4Var.b(yo4Var, vt4.this.n, new wt4.d(iY, iKeyAt, 8192));
                    }
                    vt4.this.i.put(iValueAt, wt4Var);
                }
            }
            int i6 = vt4.this.a;
            vt4 vt4Var2 = vt4.this;
            if (i6 == 2) {
                if (vt4Var2.p) {
                    return;
                }
                vt4.this.n.o();
                vt4.this.o = 0;
                vt4.this.p = true;
                return;
            }
            vt4Var2.i.remove(this.d);
            vt4 vt4Var3 = vt4.this;
            vt4Var3.o = vt4Var3.a == 1 ? 0 : vt4.this.o - 1;
            if (vt4.this.o == 0) {
                vt4.this.n.o();
                vt4.this.p = true;
            }
        }

        @Override // defpackage.vz3
        public void b(yo4 yo4Var, mz0 mz0Var, wt4.d dVar) {
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0059  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0060  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final wt4.b c(defpackage.r73 r14, int r15) {
            /*
                Method dump skipped, instruction units count: 232
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: vt4.b.c(r73, int):wt4$b");
        }
    }

    public vt4(int i, int i2, ki4.a aVar, yo4 yo4Var, wt4.c cVar, int i3) {
        this.g = (wt4.c) gg3.q(cVar);
        this.c = i3;
        this.a = i;
        this.b = i2;
        this.h = aVar;
        if (i == 1 || i == 2) {
            this.d = Collections.singletonList(yo4Var);
        } else {
            ArrayList arrayList = new ArrayList();
            this.d = arrayList;
            arrayList.add(yo4Var);
        }
        this.e = new r73(new byte[XLConstant.XLErrorCode.HTTP_SERVER_NOT_START], 0);
        this.j = new SparseBooleanArray();
        this.k = new SparseBooleanArray();
        this.i = new SparseArray();
        this.f = new SparseIntArray();
        this.l = new tt4(i3);
        this.n = mz0.d;
        this.u = -1;
        z();
    }

    public static /* synthetic */ hz0[] g() {
        return new hz0[]{new vt4(1, ki4.a.a)};
    }

    public static /* synthetic */ int m(vt4 vt4Var) {
        int i = vt4Var.o;
        vt4Var.o = i + 1;
        return i;
    }

    private void y(long j) {
        if (this.q) {
            return;
        }
        this.q = true;
        if (this.l.b() == -9223372036854775807L) {
            this.n.u(new yz3.b(this.l.b()));
            return;
        }
        st4 st4Var = new st4(this.l.c(), this.l.b(), j, this.u, this.c);
        this.m = st4Var;
        this.n.u(st4Var.b());
    }

    public final boolean A(int i) {
        return this.a == 2 || this.p || !this.k.get(i, false);
    }

    @Override // defpackage.hz0
    public void a(long j, long j2) {
        st4 st4Var;
        gg3.v(this.a != 2);
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            yo4 yo4Var = (yo4) this.d.get(i);
            boolean z = yo4Var.f() == -9223372036854775807L;
            if (!z) {
                long jD = yo4Var.d();
                z = (jD == -9223372036854775807L || jD == 0 || jD == j2) ? false : true;
            }
            if (z) {
                yo4Var.i(j2);
            }
        }
        if (j2 != 0 && (st4Var = this.m) != null) {
            st4Var.h(j2);
        }
        this.e.b0(0);
        this.f.clear();
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            ((wt4) this.i.valueAt(i2)).c();
        }
        this.t = 0;
    }

    @Override // defpackage.hz0
    public void b(mz0 mz0Var) {
        if ((this.b & 1) == 0) {
            mz0Var = new li4(mz0Var, this.h);
        }
        this.n = mz0Var;
    }

    @Override // defpackage.hz0
    public int d(jz0 jz0Var, yf3 yf3Var) throws r83 {
        int i;
        long length = jz0Var.getLength();
        boolean z = this.a == 2;
        if (this.p) {
            if (length != -1 && !z && !this.l.d()) {
                return this.l.e(jz0Var, yf3Var, this.u);
            }
            y(length);
            if (this.r) {
                this.r = false;
                a(0L, 0L);
                if (jz0Var.getPosition() != 0) {
                    yf3Var.a = 0L;
                    return 1;
                }
            }
            st4 st4Var = this.m;
            if (st4Var != null && st4Var.d()) {
                return this.m.c(jz0Var, yf3Var);
            }
        }
        if (!w(jz0Var)) {
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                wt4 wt4Var = (wt4) this.i.valueAt(i2);
                if (wt4Var instanceof wa3) {
                    wa3 wa3Var = (wa3) wt4Var;
                    if (wa3Var.d(z)) {
                        wa3Var.a(new r73(), 1);
                    }
                }
            }
            return -1;
        }
        int iX = x();
        int iJ = this.e.j();
        if (iX > iJ) {
            return 0;
        }
        int iZ = this.e.z();
        if ((8388608 & iZ) != 0) {
            this.e.f0(iX);
            return 0;
        }
        int i3 = (4194304 & iZ) != 0 ? 1 : 0;
        int i4 = (2096896 & iZ) >> 8;
        boolean z2 = (iZ & 32) != 0;
        wt4 wt4Var2 = (iZ & 16) != 0 ? (wt4) this.i.get(i4) : null;
        if (wt4Var2 == null) {
            this.e.f0(iX);
            return 0;
        }
        if (this.a != 2) {
            int i5 = iZ & 15;
            i = 0;
            int i6 = this.f.get(i4, i5 - 1);
            this.f.put(i4, i5);
            if (i6 == i5) {
                this.e.f0(iX);
                return 0;
            }
            if (i5 != ((i6 + 1) & 15)) {
                wt4Var2.c();
            }
        } else {
            i = 0;
        }
        if (z2) {
            int iQ = this.e.Q();
            i3 |= (this.e.Q() & 64) != 0 ? 2 : i;
            this.e.g0(iQ - 1);
        }
        boolean z3 = this.p;
        if (A(i4)) {
            this.e.e0(iX);
            wt4Var2.a(this.e, i3);
            this.e.e0(iJ);
        }
        if (this.a != 2 && !z3 && this.p && length != -1) {
            this.r = true;
        }
        this.e.f0(iX);
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
    
        r0 = r0 + 1;
     */
    @Override // defpackage.hz0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean e(defpackage.jz0 r6) {
        /*
            r5 = this;
            r73 r5 = r5.e
            byte[] r5 = r5.f()
            r0 = 940(0x3ac, float:1.317E-42)
            r1 = 0
            r6.s(r5, r1, r0)
            r0 = r1
        Ld:
            r2 = 188(0xbc, float:2.63E-43)
            if (r0 >= r2) goto L29
            r2 = r1
        L12:
            r3 = 5
            if (r2 >= r3) goto L24
            int r3 = r2 * 188
            int r3 = r3 + r0
            r3 = r5[r3]
            r4 = 71
            if (r3 == r4) goto L21
            int r0 = r0 + 1
            goto Ld
        L21:
            int r2 = r2 + 1
            goto L12
        L24:
            r6.q(r0)
            r5 = 1
            return r5
        L29:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vt4.e(jz0):boolean");
    }

    @Override // defpackage.hz0
    public void release() {
    }

    public final boolean w(jz0 jz0Var) {
        byte[] bArrF = this.e.f();
        if (9400 - this.e.g() < 188) {
            int iA = this.e.a();
            if (iA > 0) {
                System.arraycopy(bArrF, this.e.g(), bArrF, 0, iA);
            }
            this.e.d0(bArrF, iA);
        }
        while (this.e.a() < 188) {
            int iJ = this.e.j();
            int i = jz0Var.read(bArrF, iJ, 9400 - iJ);
            if (i == -1) {
                return false;
            }
            this.e.e0(iJ + i);
        }
        return true;
    }

    public final int x() throws r83 {
        int iG = this.e.g();
        int iJ = this.e.j();
        int iA = yt4.a(this.e.f(), iG, iJ);
        this.e.f0(iA);
        int i = iA + 188;
        if (i <= iJ) {
            this.t = 0;
            return i;
        }
        int i2 = this.t + (iA - iG);
        this.t = i2;
        if (this.a != 2 || i2 <= 376) {
            return i;
        }
        throw r83.a("Cannot find sync byte. Most likely not a Transport Stream.", null);
    }

    public final void z() {
        this.j.clear();
        this.i.clear();
        SparseArray sparseArrayA = this.g.a();
        int size = sparseArrayA.size();
        int i = 0;
        while (true) {
            SparseArray sparseArray = this.i;
            if (i >= size) {
                sparseArray.put(0, new wz3(new a()));
                this.s = null;
                return;
            } else {
                sparseArray.put(sparseArrayA.keyAt(i), (wt4) sparseArrayA.valueAt(i));
                i++;
            }
        }
    }

    public vt4(int i, ki4.a aVar) {
        this(1, i, aVar, new yo4(0L), new wi0(0), 112800);
    }
}
