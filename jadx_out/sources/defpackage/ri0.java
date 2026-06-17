package defpackage;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.accessibility.CaptioningManager;
import androidx.media3.exoplayer.o;
import androidx.media3.exoplayer.p;
import defpackage.a5;
import defpackage.dj1;
import defpackage.jq2;
import defpackage.jy0;
import defpackage.lr4;
import defpackage.r42;
import defpackage.ri0;
import defpackage.xi1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ri0 extends r42 implements p.a {
    public static final x63 l = x63.b(new Comparator() { // from class: gi0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ri0.w((Integer) obj, (Integer) obj2);
        }
    });
    public final Object d;
    public final Context e;
    public final jy0.b f;
    public e g;
    public Thread h;
    public pb4 i;
    public yb j;
    public Boolean k;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends h implements Comparable {
        public final int A;
        public final boolean B;
        public final boolean C;
        public final boolean D;
        public final int j;
        public final boolean k;
        public final String l;
        public final e m;
        public final boolean n;
        public final int o;
        public final int p;
        public final int q;
        public final int r;
        public final boolean s;
        public final boolean t;
        public final int u;
        public final int v;
        public final boolean w;
        public final int x;
        public final int y;
        public final int z;

        public b(int i, br4 br4Var, int i2, e eVar, int i3, boolean z, ig3 ig3Var, int i4) {
            int i5;
            int iM;
            int iM2;
            super(i, br4Var, i2);
            this.m = eVar;
            int i6 = eVar.G0 ? 24 : 16;
            this.s = eVar.C0 && (i4 & i6) != 0;
            this.l = ri0.a0(this.i.d);
            this.n = p.n(i3, false);
            int i7 = 0;
            while (true) {
                i5 = Integer.MAX_VALUE;
                if (i7 >= eVar.q.size()) {
                    iM = 0;
                    i7 = Integer.MAX_VALUE;
                    break;
                } else {
                    iM = ri0.M(this.i, (String) eVar.q.get(i7), false);
                    if (iM > 0) {
                        break;
                    } else {
                        i7++;
                    }
                }
            }
            this.p = i7;
            this.o = iM;
            this.q = ri0.Q(this.i.f, eVar.s);
            this.r = ri0.L(this.i, eVar.r);
            t41 t41Var = this.i;
            int i8 = t41Var.f;
            this.t = i8 == 0 || (i8 & 1) != 0;
            this.w = (t41Var.e & 1) != 0;
            this.D = ri0.V(t41Var);
            t41 t41Var2 = this.i;
            int i9 = t41Var2.H;
            this.x = i9;
            this.y = t41Var2.I;
            int i10 = t41Var2.j;
            this.z = i10;
            this.k = (i10 == -1 || i10 <= eVar.u) && (i9 == -1 || i9 <= eVar.t) && ig3Var.apply(t41Var2);
            String[] strArrZ0 = fy4.z0();
            int i11 = 0;
            while (true) {
                if (i11 >= strArrZ0.length) {
                    iM2 = 0;
                    i11 = Integer.MAX_VALUE;
                    break;
                } else {
                    iM2 = ri0.M(this.i, strArrZ0[i11], false);
                    if (iM2 > 0) {
                        break;
                    } else {
                        i11++;
                    }
                }
            }
            this.u = i11;
            this.v = iM2;
            int i12 = 0;
            while (true) {
                if (i12 < eVar.v.size()) {
                    String str = this.i.p;
                    if (str != null && str.equals(eVar.v.get(i12))) {
                        i5 = i12;
                        break;
                    }
                    i12++;
                } else {
                    break;
                }
            }
            this.A = i5;
            this.B = p.k(i3) == 128;
            this.C = p.s(i3) == 64;
            this.j = h(i3, z, i6);
        }

        public static int e(List list, List list2) {
            return ((b) Collections.max(list)).compareTo((b) Collections.max(list2));
        }

        public static xi1 g(int i, br4 br4Var, e eVar, int[] iArr, boolean z, ig3 ig3Var, int i2) {
            xi1.a aVarM = xi1.m();
            for (int i3 = 0; i3 < br4Var.a; i3++) {
                aVarM.a(new b(i, br4Var, i3, eVar, iArr[i3], z, ig3Var, i2));
            }
            return aVarM.k();
        }

        @Override // ri0.h
        public int a() {
            return this.j;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            x63 x63VarG = (this.k && this.n) ? ri0.l : ri0.l.g();
            rx rxVarG = rx.k().h(this.n, bVar.n).g(Integer.valueOf(this.p), Integer.valueOf(bVar.p), x63.d().g()).d(this.o, bVar.o).d(this.q, bVar.q).g(Integer.valueOf(this.r), Integer.valueOf(bVar.r), x63.d().g()).h(this.w, bVar.w).h(this.t, bVar.t).g(Integer.valueOf(this.u), Integer.valueOf(bVar.u), x63.d().g()).d(this.v, bVar.v).h(this.k, bVar.k).g(Integer.valueOf(this.A), Integer.valueOf(bVar.A), x63.d().g());
            if (this.m.F) {
                rxVarG = rxVarG.g(Integer.valueOf(this.z), Integer.valueOf(bVar.z), ri0.l.g());
            }
            rx rxVarG2 = rxVarG.h(this.B, bVar.B).h(this.C, bVar.C).h(this.D, bVar.D).g(Integer.valueOf(this.x), Integer.valueOf(bVar.x), x63VarG).g(Integer.valueOf(this.y), Integer.valueOf(bVar.y), x63VarG);
            if (Objects.equals(this.l, bVar.l)) {
                rxVarG2 = rxVarG2.g(Integer.valueOf(this.z), Integer.valueOf(bVar.z), x63VarG);
            }
            return rxVarG2.j();
        }

        public final int h(int i, boolean z, int i2) {
            if (!p.n(i, this.m.I0)) {
                return 0;
            }
            if (!this.k && !this.m.B0) {
                return 0;
            }
            e eVar = this.m;
            if (eVar.w.a == 2 && !ri0.b0(eVar, i, this.i)) {
                return 0;
            }
            if (!p.n(i, false) || !this.k || this.i.j == -1) {
                return 1;
            }
            e eVar2 = this.m;
            if (eVar2.G || eVar2.F) {
                return 1;
            }
            return ((!eVar2.K0 && z) || eVar2.w.a == 2 || (i & i2) == 0) ? 1 : 2;
        }

        @Override // ri0.h
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public boolean b(b bVar) {
            int i;
            String str;
            int i2;
            if (!this.m.E0 && ((i2 = this.i.H) == -1 || i2 != bVar.i.H)) {
                return false;
            }
            if (!this.s && ((str = this.i.p) == null || !TextUtils.equals(str, bVar.i.p))) {
                return false;
            }
            e eVar = this.m;
            if (!eVar.D0 && ((i = this.i.I) == -1 || i != bVar.i.I)) {
                return false;
            }
            if (eVar.F0) {
                return true;
            }
            return this.B == bVar.B && this.C == bVar.C;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends h implements Comparable {
        public final int j;
        public final int k;

        public c(int i, br4 br4Var, int i2, e eVar, int i3) {
            super(i, br4Var, i2);
            this.j = p.n(i3, eVar.I0) ? 1 : 0;
            this.k = this.i.g();
        }

        public static int e(List list, List list2) {
            return ((c) list.get(0)).compareTo((c) list2.get(0));
        }

        public static xi1 g(int i, br4 br4Var, e eVar, int[] iArr) {
            xi1.a aVarM = xi1.m();
            for (int i2 = 0; i2 < br4Var.a; i2++) {
                aVarM.a(new c(i, br4Var, i2, eVar, iArr[i2]));
            }
            return aVarM.k();
        }

        @Override // ri0.h
        public int a() {
            return this.j;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            return Integer.compare(this.k, cVar.k);
        }

        @Override // ri0.h
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public boolean b(c cVar) {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d implements Comparable {
        public final boolean f;
        public final boolean g;

        public d(t41 t41Var, int i) {
            this.f = (t41Var.e & 1) != 0;
            this.g = p.n(i, false);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            return rx.k().h(this.g, dVar.g).h(this.f, dVar.f).j();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class f {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class g extends h implements Comparable {
        public final int j;
        public final boolean k;
        public final boolean l;
        public final boolean m;
        public final int n;
        public final int o;
        public final int p;
        public final int q;
        public final int r;
        public final boolean s;

        public g(int i, br4 br4Var, int i2, e eVar, int i3, String str, String str2) {
            int iM;
            super(i, br4Var, i2);
            int i4 = 0;
            this.k = p.n(i3, false);
            int i5 = this.i.e & (~eVar.C);
            this.l = (i5 & 1) != 0;
            this.m = (i5 & 2) != 0;
            xi1 xi1VarW = str2 != null ? xi1.w(str2) : eVar.y.isEmpty() ? xi1.w("") : eVar.y;
            int i6 = 0;
            while (true) {
                if (i6 >= xi1VarW.size()) {
                    iM = 0;
                    i6 = Integer.MAX_VALUE;
                    break;
                } else {
                    iM = ri0.M(this.i, (String) xi1VarW.get(i6), eVar.D);
                    if (iM > 0) {
                        break;
                    } else {
                        i6++;
                    }
                }
            }
            this.n = i6;
            this.o = iM;
            int iQ = ri0.Q(this.i.f, str2 != null ? 1088 : eVar.A);
            this.p = iQ;
            t41 t41Var = this.i;
            this.s = (1088 & t41Var.f) != 0;
            int iL = ri0.L(t41Var, eVar.z);
            this.q = iL;
            int iM2 = ri0.M(this.i, str, ri0.a0(str) == null);
            this.r = iM2;
            boolean z = iM > 0 || (eVar.y.isEmpty() && iQ > 0) || ((eVar.y.isEmpty() && iL != Integer.MAX_VALUE) || this.l || ((this.m && iM2 > 0) || eVar.x));
            if (p.n(i3, eVar.I0) && z) {
                i4 = 1;
            }
            this.j = i4;
        }

        public static int e(List list, List list2) {
            return ((g) list.get(0)).compareTo((g) list2.get(0));
        }

        public static xi1 g(int i, br4 br4Var, e eVar, int[] iArr, String str, String str2) {
            xi1.a aVarM = xi1.m();
            for (int i2 = 0; i2 < br4Var.a; i2++) {
                aVarM.a(new g(i, br4Var, i2, eVar, iArr[i2], str, str2));
            }
            return aVarM.k();
        }

        @Override // ri0.h
        public int a() {
            return this.j;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public int compareTo(g gVar) {
            rx rxVarD = rx.k().h(this.k, gVar.k).g(Integer.valueOf(this.n), Integer.valueOf(gVar.n), x63.d().g()).d(this.o, gVar.o).d(this.p, gVar.p).g(Integer.valueOf(this.q), Integer.valueOf(gVar.q), x63.d().g()).h(this.l, gVar.l).g(Boolean.valueOf(this.m), Boolean.valueOf(gVar.m), this.o == 0 ? x63.d() : x63.d().g()).d(this.r, gVar.r);
            if (this.p == 0) {
                rxVarD = rxVarD.i(this.s, gVar.s);
            }
            return rxVarD.j();
        }

        @Override // ri0.h
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public boolean b(g gVar) {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class h {
        public final int f;
        public final br4 g;
        public final int h;
        public final t41 i;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public interface a {
            List a(int i, br4 br4Var, int[] iArr);
        }

        public h(int i, br4 br4Var, int i2) {
            this.f = i;
            this.g = br4Var;
            this.h = i2;
            this.i = br4Var.c(i2);
        }

        public abstract int a();

        public abstract boolean b(h hVar);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class i extends h {
        public final boolean A;
        public final int B;
        public final boolean j;
        public final e k;
        public final boolean l;
        public final boolean m;
        public final boolean n;
        public final int o;
        public final int p;
        public final int q;
        public final int r;
        public final int s;
        public final int t;
        public final int u;
        public final boolean v;
        public final int w;
        public final boolean x;
        public final int y;
        public final boolean z;

        /* JADX WARN: Removed duplicated region for block: B:31:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0079  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public i(int r5, defpackage.br4 r6, int r7, ri0.e r8, int r9, java.lang.String r10, int r11, boolean r12) {
            /*
                Method dump skipped, instruction units count: 327
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ri0.i.<init>(int, br4, int, ri0$e, int, java.lang.String, int, boolean):void");
        }

        public static int g(i iVar, i iVar2) {
            rx rxVarH = rx.k().h(iVar.m, iVar2.m).g(Integer.valueOf(iVar.r), Integer.valueOf(iVar2.r), x63.d().g()).d(iVar.s, iVar2.s).d(iVar.t, iVar2.t).g(Integer.valueOf(iVar.u), Integer.valueOf(iVar2.u), x63.d().g()).h(iVar.v, iVar2.v).d(iVar.w, iVar2.w).h(iVar.n, iVar2.n).h(iVar.j, iVar2.j).h(iVar.l, iVar2.l).g(Integer.valueOf(iVar.q), Integer.valueOf(iVar2.q), x63.d().g()).h(iVar.z, iVar2.z).h(iVar.A, iVar2.A);
            if (iVar.z && iVar.A) {
                rxVarH = rxVarH.d(iVar.B, iVar2.B);
            }
            return rxVarH.j();
        }

        public static int h(i iVar, i iVar2) {
            x63 x63VarG = (iVar.j && iVar.m) ? ri0.l : ri0.l.g();
            rx rxVarK = rx.k();
            if (iVar.k.F) {
                rxVarK = rxVarK.g(Integer.valueOf(iVar.o), Integer.valueOf(iVar2.o), ri0.l.g());
            }
            return rxVarK.g(Integer.valueOf(iVar.p), Integer.valueOf(iVar2.p), x63VarG).g(Integer.valueOf(iVar.o), Integer.valueOf(iVar2.o), x63VarG).j();
        }

        public static int i(List list, List list2) {
            return rx.k().g((i) Collections.max(list, new Comparator() { // from class: ui0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ri0.i.g((ri0.i) obj, (ri0.i) obj2);
                }
            }), (i) Collections.max(list2, new Comparator() { // from class: ui0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ri0.i.g((ri0.i) obj, (ri0.i) obj2);
                }
            }), new Comparator() { // from class: ui0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ri0.i.g((ri0.i) obj, (ri0.i) obj2);
                }
            }).d(list.size(), list2.size()).g((i) Collections.max(list, new Comparator() { // from class: vi0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ri0.i.h((ri0.i) obj, (ri0.i) obj2);
                }
            }), (i) Collections.max(list2, new Comparator() { // from class: vi0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ri0.i.h((ri0.i) obj, (ri0.i) obj2);
                }
            }), new Comparator() { // from class: vi0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ri0.i.h((ri0.i) obj, (ri0.i) obj2);
                }
            }).j();
        }

        public static xi1 j(int i, br4 br4Var, e eVar, int[] iArr, String str, int i2, Point point) {
            int iN = ri0.N(br4Var, point != null ? point.x : eVar.i, point != null ? point.y : eVar.j, eVar.l);
            xi1.a aVarM = xi1.m();
            for (int i3 = 0; i3 < br4Var.a; i3++) {
                int iG = br4Var.c(i3).g();
                aVarM.a(new i(i, br4Var, i3, eVar, iArr[i3], str, i2, iN == Integer.MAX_VALUE || (iG != -1 && iG <= iN)));
            }
            return aVarM.k();
        }

        @Override // ri0.h
        public int a() {
            return this.y;
        }

        public final int k(int i, int i2) {
            if ((this.i.f & Http2.INITIAL_MAX_FRAME_SIZE) != 0 || !p.n(i, this.k.I0)) {
                return 0;
            }
            if (!this.j && !this.k.x0) {
                return 0;
            }
            if (!p.n(i, false) || !this.l || !this.j || this.i.j == -1) {
                return 1;
            }
            e eVar = this.k;
            return (eVar.G || eVar.F || (i & i2) == 0) ? 1 : 2;
        }

        @Override // ri0.h
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public boolean b(i iVar) {
            if (!this.x && !Objects.equals(this.i.p, iVar.i.p)) {
                return false;
            }
            if (this.k.A0) {
                return true;
            }
            return this.z == iVar.z && this.A == iVar.A;
        }
    }

    public ri0(lr4 lr4Var, jy0.b bVar, Context context) {
        this.d = new Object();
        this.e = context != null ? context.getApplicationContext() : null;
        this.f = bVar;
        if (lr4Var instanceof e) {
            this.g = (e) lr4Var;
        } else {
            this.g = e.O0.M().y0(lr4Var).K();
        }
        this.j = yb.i;
        if (this.g.H0 && context == null) {
            xz1.i("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }

    public static void F(r42.a aVar, e eVar, jy0.a[] aVarArr) {
        int iD = aVar.d();
        for (int i2 = 0; i2 < iD; i2++) {
            er4 er4VarF = aVar.f(i2);
            if (eVar.Y(i2, er4VarF)) {
                eVar.X(i2, er4VarF);
                aVarArr[i2] = null;
            }
        }
    }

    public static void G(r42.a aVar, e eVar, jy0.a[] aVarArr) {
        for (int i2 = 0; i2 < aVar.d(); i2++) {
            int iE = aVar.e(i2);
            if (eVar.W(i2) || eVar.I.contains(Integer.valueOf(iE))) {
                aVarArr[i2] = null;
            }
        }
    }

    public static void H(r42.a aVar, lr4 lr4Var, jy0.a[] aVarArr) {
        int iD = aVar.d();
        HashMap map = new HashMap();
        for (int i2 = 0; i2 < iD; i2++) {
            J(aVar.f(i2), lr4Var, map);
        }
        J(aVar.h(), lr4Var, map);
        for (int i3 = 0; i3 < iD; i3++) {
            jr4 jr4Var = (jr4) map.get(Integer.valueOf(aVar.e(i3)));
            if (jr4Var != null) {
                aVarArr[i3] = (jr4Var.b.isEmpty() || aVar.f(i3).d(jr4Var.a) == -1) ? null : new jy0.a(jr4Var.a, ll1.n(jr4Var.b));
            }
        }
    }

    public static void J(er4 er4Var, lr4 lr4Var, Map map) {
        jr4 jr4Var;
        for (int i2 = 0; i2 < er4Var.a; i2++) {
            jr4 jr4Var2 = (jr4) lr4Var.H.get(er4Var.b(i2));
            if (jr4Var2 != null && ((jr4Var = (jr4) map.get(Integer.valueOf(jr4Var2.b()))) == null || (jr4Var.b.isEmpty() && !jr4Var2.b.isEmpty()))) {
                map.put(Integer.valueOf(jr4Var2.b()), jr4Var2);
            }
        }
    }

    public static Pair K(jy0.a[] aVarArr, int i2) {
        for (int i3 = 0; i3 < aVarArr.length; i3++) {
            jy0.a aVar = aVarArr[i3];
            if (aVar != null && aVar.a.c == i2) {
                return Pair.create(aVar, Integer.valueOf(i3));
            }
        }
        return null;
    }

    public static int L(t41 t41Var, xi1 xi1Var) {
        for (int i2 = 0; i2 < xi1Var.size(); i2++) {
            for (int i3 = 0; i3 < t41Var.c.size(); i3++) {
                if (((rr1) t41Var.c.get(i3)).b.equals(xi1Var.get(i2))) {
                    return i2;
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static int M(t41 t41Var, String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(t41Var.d)) {
            return 4;
        }
        String strA0 = a0(str);
        String strA02 = a0(t41Var.d);
        if (strA02 == null || strA0 == null) {
            return (z && strA02 == null) ? 1 : 0;
        }
        if (strA02.startsWith(strA0) || strA0.startsWith(strA02)) {
            return 3;
        }
        return fy4.H1(strA02, "-")[0].equals(fy4.H1(strA0, "-")[0]) ? 2 : 0;
    }

    public static int N(br4 br4Var, int i2, int i3, boolean z) {
        int i4;
        int i5 = Integer.MAX_VALUE;
        if (i2 != Integer.MAX_VALUE && i3 != Integer.MAX_VALUE) {
            for (int i6 = 0; i6 < br4Var.a; i6++) {
                t41 t41VarC = br4Var.c(i6);
                int i7 = t41VarC.w;
                if (i7 > 0 && (i4 = t41VarC.x) > 0) {
                    Point pointC = nr4.c(z, i2, i3, i7, i4);
                    int i8 = t41VarC.w;
                    int i9 = t41VarC.x;
                    int i10 = i8 * i9;
                    if (i8 >= ((int) (pointC.x * 0.98f)) && i9 >= ((int) (pointC.y * 0.98f)) && i10 < i5) {
                        i5 = i10;
                    }
                }
            }
        }
        return i5;
    }

    public static String P(Context context) {
        CaptioningManager captioningManager;
        Locale locale;
        if (context == null || (captioningManager = (CaptioningManager) context.getSystemService("captioning")) == null || !captioningManager.isEnabled() || (locale = captioningManager.getLocale()) == null) {
            return null;
        }
        return fy4.n0(locale);
    }

    public static int Q(int i2, int i3) {
        if (i2 == 0 || i2 != i3) {
            return Integer.bitCount(i2 & i3);
        }
        return Integer.MAX_VALUE;
    }

    public static dj1 R(jy0.a[] aVarArr, e eVar) {
        dj1.a aVarM = dj1.m();
        for (int i2 = 0; i2 < aVarArr.length; i2++) {
            jy0.a aVar = aVarArr[i2];
            if (aVar != null && !eVar.W(i2) && !eVar.I.contains(Integer.valueOf(aVar.a.c))) {
                aVarM.a(aVar.a.b);
                int i3 = 0;
                while (true) {
                    int[] iArr = aVar.b;
                    if (i3 < iArr.length) {
                        String str = aVar.a.c(iArr[i3]).n;
                        if (str != null) {
                            aVarM.a(str);
                        }
                        i3++;
                    }
                }
            }
        }
        return aVarM.k();
    }

    public static int S(String str) {
        if (str == null) {
            return 0;
        }
        switch (str) {
        }
        return 0;
    }

    public static boolean U(t41 t41Var) {
        String str = t41Var.p;
        if (str == null) {
            return false;
        }
        str.getClass();
        switch (str) {
        }
        return false;
    }

    public static boolean V(t41 t41Var) {
        String str = t41Var.p;
        if (str == null) {
            return false;
        }
        str.getClass();
        switch (str) {
        }
        return false;
    }

    public static void W(e eVar, r42.a aVar, int[][][] iArr, jq3[] jq3VarArr, jy0[] jy0VarArr) {
        int i2 = -1;
        boolean z = false;
        int i3 = 0;
        for (int i4 = 0; i4 < aVar.d(); i4++) {
            int iE = aVar.e(i4);
            jy0 jy0Var = jy0VarArr[i4];
            if (iE != 1 && jy0Var != null) {
                return;
            }
            if (iE == 1 && jy0Var != null && jy0Var.length() == 1) {
                if (b0(eVar, iArr[i4][aVar.f(i4).d(jy0Var.c())][jy0Var.i(0)], jy0Var.l())) {
                    i3++;
                    i2 = i4;
                }
            }
        }
        if (i3 == 1) {
            int i5 = eVar.w.b ? 1 : 2;
            jq3 jq3Var = jq3VarArr[i2];
            if (jq3Var != null && jq3Var.b) {
                z = true;
            }
            jq3VarArr[i2] = new jq3(i5, z);
        }
    }

    public static void X(r42.a aVar, int[][][] iArr, jq3[] jq3VarArr, jy0[] jy0VarArr) {
        boolean z;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < aVar.d(); i4++) {
            int iE = aVar.e(i4);
            jy0 jy0Var = jy0VarArr[i4];
            if ((iE == 1 || iE == 2) && jy0Var != null && c0(iArr[i4], aVar.f(i4), jy0Var)) {
                if (iE == 1) {
                    if (i3 != -1) {
                        z = false;
                        break;
                    }
                    i3 = i4;
                } else {
                    if (i2 != -1) {
                        z = false;
                        break;
                    }
                    i2 = i4;
                }
            }
        }
        z = true;
        if (z && ((i3 == -1 || i2 == -1) ? false : true)) {
            jq3 jq3Var = new jq3(0, true);
            jq3VarArr[i3] = jq3Var;
            jq3VarArr[i2] = jq3Var;
        }
    }

    public static String a0(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    public static boolean b0(e eVar, int i2, t41 t41Var) {
        if (p.J(i2) == 0) {
            return false;
        }
        if (eVar.w.c && (p.J(i2) & 2048) == 0) {
            return false;
        }
        if (eVar.w.b) {
            boolean z = (t41Var.K == 0 && t41Var.L == 0) ? false : true;
            boolean z2 = (p.J(i2) & 1024) != 0;
            if (z && !z2) {
                return false;
            }
        }
        return true;
    }

    public static boolean c0(int[][] iArr, er4 er4Var, jy0 jy0Var) {
        if (jy0Var == null) {
            return false;
        }
        int iD = er4Var.d(jy0Var.c());
        for (int i2 = 0; i2 < jy0Var.length(); i2++) {
            if (p.v(iArr[iD][jy0Var.i(i2)]) != 32) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ List r(final ri0 ri0Var, final e eVar, boolean z, int[] iArr, int i2, br4 br4Var, int[] iArr2) {
        ri0Var.getClass();
        return b.g(i2, br4Var, eVar, iArr2, z, new ig3() { // from class: hi0
            @Override // defpackage.ig3
            public final boolean apply(Object obj) {
                return this.f.T((t41) obj, eVar);
            }
        }, iArr[i2]);
    }

    public static /* synthetic */ int w(Integer num, Integer num2) {
        if (num.intValue() == -1) {
            return num2.intValue() == -1 ? 0 : -1;
        }
        if (num2.intValue() == -1) {
            return 1;
        }
        return num.intValue() - num2.intValue();
    }

    public e.a I() {
        return c().M();
    }

    @Override // defpackage.or4
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public e c() {
        e eVar;
        synchronized (this.d) {
            eVar = this.g;
        }
        return eVar;
    }

    public final boolean T(t41 t41Var, e eVar) {
        int i2;
        pb4 pb4Var;
        pb4 pb4Var2;
        if (!eVar.H0) {
            return true;
        }
        Boolean bool = this.k;
        if ((bool != null && bool.booleanValue()) || (i2 = t41Var.H) == -1 || i2 <= 2) {
            return true;
        }
        if (!U(t41Var) || (Build.VERSION.SDK_INT >= 32 && (pb4Var2 = this.i) != null && pb4Var2.e())) {
            return Build.VERSION.SDK_INT >= 32 && (pb4Var = this.i) != null && pb4Var.e() && this.i.c() && this.i.d() && this.i.a(this.j, t41Var);
        }
        return true;
    }

    public final void Y() {
        boolean z;
        pb4 pb4Var;
        synchronized (this.d) {
            try {
                z = this.g.H0 && Build.VERSION.SDK_INT >= 32 && (pb4Var = this.i) != null && pb4Var.e();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            f();
        }
    }

    public final void Z(o oVar) {
        boolean z;
        synchronized (this.d) {
            z = this.g.L0;
        }
        if (z) {
            g(oVar);
        }
    }

    @Override // androidx.media3.exoplayer.p.a
    public void a(o oVar) {
        Z(oVar);
    }

    @Override // defpackage.or4
    public p.a d() {
        return this;
    }

    public void d0(jy0.a[] aVarArr, r42.a aVar, int[][][] iArr, int[] iArr2, e eVar) {
        String str;
        String str2;
        Pair pairI0;
        int iD = aVar.d();
        Pair pairK = K(aVarArr, 1);
        if (pairK == null && (pairK = e0(aVar, iArr, iArr2, eVar)) != null) {
            aVarArr[((Integer) pairK.second).intValue()] = (jy0.a) pairK.first;
        }
        if (pairK == null) {
            str = null;
        } else {
            Object obj = pairK.first;
            str = ((jy0.a) obj).a.c(((jy0.a) obj).b[0]).d;
        }
        Pair pairK2 = K(aVarArr, 2);
        Pair pairK3 = K(aVarArr, 4);
        if (pairK2 == null && pairK3 == null) {
            str2 = str;
            Pair pairK0 = k0(aVar, iArr, iArr2, eVar, str2);
            Pair pairF0 = (eVar.E || pairK0 == null) ? f0(aVar, iArr, eVar) : null;
            if (pairF0 != null) {
                aVarArr[((Integer) pairF0.second).intValue()] = (jy0.a) pairF0.first;
            } else if (pairK0 != null) {
                aVarArr[((Integer) pairK0.second).intValue()] = (jy0.a) pairK0.first;
            }
        } else {
            str2 = str;
        }
        if (K(aVarArr, 3) == null && (pairI0 = i0(aVar, iArr, eVar, str2)) != null) {
            aVarArr[((Integer) pairI0.second).intValue()] = (jy0.a) pairI0.first;
        }
        g0(aVarArr, aVar, iArr, eVar);
        for (int i2 = 0; i2 < iD; i2++) {
            int iE = aVar.e(i2);
            if (iE != 2 && iE != 1 && iE != 3 && iE != 4 && iE != 5 && aVarArr[i2] == null) {
                aVarArr[i2] = h0(iE, aVar.f(i2), iArr[i2], eVar);
            }
        }
    }

    public Pair e0(r42.a aVar, int[][][] iArr, final int[] iArr2, final e eVar) {
        final boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 < aVar.d()) {
                if (2 == aVar.e(i2) && aVar.f(i2).a > 0) {
                    z = true;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        return j0(1, aVar, iArr, new h.a() { // from class: ni0
            @Override // ri0.h.a
            public final List a(int i3, br4 br4Var, int[] iArr3) {
                return ri0.r(this.a, eVar, z, iArr2, i3, br4Var, iArr3);
            }
        }, new Comparator() { // from class: oi0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ri0.b.e((List) obj, (List) obj2);
            }
        });
    }

    public Pair f0(r42.a aVar, int[][][] iArr, final e eVar) {
        if (eVar.w.a == 2) {
            return null;
        }
        return j0(4, aVar, iArr, new h.a() { // from class: ji0
            @Override // ri0.h.a
            public final List a(int i2, br4 br4Var, int[] iArr2) {
                return ri0.c.g(i2, br4Var, eVar, iArr2);
            }
        }, new Comparator() { // from class: ki0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ri0.c.e((List) obj, (List) obj2);
            }
        });
    }

    public void g0(jy0.a[] aVarArr, r42.a aVar, int[][][] iArr, e eVar) {
        if (eVar.w.a == 2) {
            return;
        }
        dj1 dj1VarR = R(aVarArr, eVar);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < aVar.d(); i2++) {
            if (aVar.e(i2) == 5) {
                er4 er4VarF = aVar.f(i2);
                for (int i3 = 0; i3 < er4VarF.a; i3++) {
                    br4 br4VarB = er4VarF.b(i3);
                    arrayList.add(br4VarB);
                    int[] iArr2 = (int[]) iArr[i2][i3].clone();
                    for (int i4 = 0; i4 < iArr2.length; i4++) {
                        String str = br4VarB.c(i4).n;
                        if (str != null && !dj1VarR.contains(str)) {
                            iArr2[i4] = p.C(0);
                        }
                    }
                    arrayList2.add(iArr2);
                }
            }
        }
        br4[] br4VarArr = new br4[arrayList.size()];
        fy4.k1(arrayList, br4VarArr);
        er4 er4Var = new er4(br4VarArr);
        int[][] iArr3 = new int[arrayList2.size()][];
        fy4.k1(arrayList2, iArr3);
        for (int i5 = 0; i5 < aVar.d(); i5++) {
            if (aVar.e(i5) == 5) {
                jy0.a aVarH0 = h0(5, er4Var, iArr3, eVar);
                aVarArr[i5] = aVarH0;
                if (aVarH0 == null) {
                    return;
                } else {
                    Arrays.fill(iArr3[er4Var.d(aVarH0.a)], p.C(0));
                }
            }
        }
    }

    @Override // defpackage.or4
    public boolean h() {
        return true;
    }

    public jy0.a h0(int i2, er4 er4Var, int[][] iArr, e eVar) {
        if (eVar.w.a == 2) {
            return null;
        }
        int i3 = 0;
        br4 br4Var = null;
        d dVar = null;
        for (int i4 = 0; i4 < er4Var.a; i4++) {
            br4 br4VarB = er4Var.b(i4);
            int[] iArr2 = iArr[i4];
            for (int i5 = 0; i5 < br4VarB.a; i5++) {
                if (p.n(iArr2[i5], eVar.I0)) {
                    d dVar2 = new d(br4VarB.c(i5), iArr2[i5]);
                    if (dVar == null || dVar2.compareTo(dVar) > 0) {
                        br4Var = br4VarB;
                        i3 = i5;
                        dVar = dVar2;
                    }
                }
            }
        }
        if (br4Var == null) {
            return null;
        }
        return new jy0.a(br4Var, i3);
    }

    public Pair i0(r42.a aVar, int[][][] iArr, final e eVar, final String str) {
        if (eVar.w.a == 2) {
            return null;
        }
        final String strP = eVar.B ? P(this.e) : null;
        return j0(3, aVar, iArr, new h.a() { // from class: pi0
            @Override // ri0.h.a
            public final List a(int i2, br4 br4Var, int[] iArr2) {
                return ri0.g.g(i2, br4Var, eVar, iArr2, str, strP);
            }
        }, new Comparator() { // from class: qi0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ri0.g.e((List) obj, (List) obj2);
            }
        });
    }

    @Override // defpackage.or4
    public void j() {
        pb4 pb4Var;
        synchronized (this.d) {
            try {
                Thread thread = this.h;
                if (thread != null) {
                    gg3.w(thread == Thread.currentThread(), "DefaultTrackSelector is accessed on the wrong thread.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (Build.VERSION.SDK_INT >= 32 && (pb4Var = this.i) != null) {
            pb4Var.g();
            this.i = null;
        }
        super.j();
    }

    public final Pair j0(int i2, r42.a aVar, int[][][] iArr, h.a aVar2, Comparator comparator) {
        int i3;
        RandomAccess randomAccessW;
        r42.a aVar3 = aVar;
        ArrayList arrayList = new ArrayList();
        int iD = aVar3.d();
        int i4 = 0;
        while (i4 < iD) {
            if (i2 == aVar3.e(i4)) {
                er4 er4VarF = aVar3.f(i4);
                for (int i5 = 0; i5 < er4VarF.a; i5++) {
                    br4 br4VarB = er4VarF.b(i5);
                    List listA = aVar2.a(i4, br4VarB, iArr[i4][i5]);
                    boolean[] zArr = new boolean[br4VarB.a];
                    int i6 = 0;
                    while (i6 < br4VarB.a) {
                        h hVar = (h) listA.get(i6);
                        int iA = hVar.a();
                        if (zArr[i6] || iA == 0) {
                            i3 = iD;
                        } else {
                            if (iA == 1) {
                                randomAccessW = xi1.w(hVar);
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(hVar);
                                int i7 = i6 + 1;
                                while (i7 < br4VarB.a) {
                                    h hVar2 = (h) listA.get(i7);
                                    int i8 = iD;
                                    if (hVar2.a() == 2 && hVar.b(hVar2)) {
                                        arrayList2.add(hVar2);
                                        zArr[i7] = true;
                                    }
                                    i7++;
                                    iD = i8;
                                }
                                randomAccessW = arrayList2;
                            }
                            i3 = iD;
                            arrayList.add(randomAccessW);
                        }
                        i6++;
                        iD = i3;
                    }
                }
            }
            i4++;
            aVar3 = aVar;
            iD = iD;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i9 = 0; i9 < list.size(); i9++) {
            iArr2[i9] = ((h) list.get(i9)).h;
        }
        h hVar3 = (h) list.get(0);
        return Pair.create(new jy0.a(hVar3.g, iArr2), Integer.valueOf(hVar3.f));
    }

    public Pair k0(r42.a aVar, int[][][] iArr, final int[] iArr2, final e eVar, final String str) {
        Context context;
        final Point pointD0 = null;
        if (eVar.w.a == 2) {
            return null;
        }
        if (eVar.k && (context = this.e) != null) {
            pointD0 = fy4.d0(context);
        }
        return j0(2, aVar, iArr, new h.a() { // from class: li0
            @Override // ri0.h.a
            public final List a(int i2, br4 br4Var, int[] iArr3) {
                return ri0.i.j(i2, br4Var, eVar, iArr3, str, iArr2[i2], pointD0);
            }
        }, new Comparator() { // from class: mi0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ri0.i.i((List) obj, (List) obj2);
            }
        });
    }

    @Override // defpackage.or4
    public void l(yb ybVar) {
        if (this.j.equals(ybVar)) {
            return;
        }
        this.j = ybVar;
        Y();
    }

    public final void l0(e eVar) {
        boolean zEquals;
        gg3.q(eVar);
        synchronized (this.d) {
            zEquals = this.g.equals(eVar);
            this.g = eVar;
        }
        if (zEquals) {
            return;
        }
        if (eVar.H0 && this.e == null) {
            xz1.i("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
        f();
    }

    @Override // defpackage.or4
    public void m(lr4 lr4Var) {
        if (lr4Var instanceof e) {
            l0((e) lr4Var);
        }
        l0(new e.a().y0(lr4Var).K());
    }

    @Override // defpackage.r42
    public final Pair q(r42.a aVar, int[][][] iArr, int[] iArr2, jq2.b bVar, no4 no4Var) {
        e eVar;
        Context context;
        synchronized (this.d) {
            this.h = Thread.currentThread();
            eVar = this.g;
        }
        if (this.k == null && (context = this.e) != null) {
            this.k = Boolean.valueOf(fy4.W0(context));
        }
        if (eVar.H0 && Build.VERSION.SDK_INT >= 32 && this.i == null) {
            this.i = new pb4(this.e, new Runnable() { // from class: ii0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.Y();
                }
            }, this.k);
        }
        int iD = aVar.d();
        jy0.a[] aVarArr = new jy0.a[iD];
        H(aVar, eVar, aVarArr);
        F(aVar, eVar, aVarArr);
        G(aVar, eVar, aVarArr);
        d0(aVarArr, aVar, iArr, iArr2, eVar);
        H(aVar, eVar, aVarArr);
        F(aVar, eVar, aVarArr);
        G(aVar, eVar, aVarArr);
        jy0[] jy0VarArrA = this.f.a(aVarArr, b(), bVar, no4Var);
        jq3[] jq3VarArr = new jq3[iD];
        for (int i2 = 0; i2 < iD; i2++) {
            jq3VarArr[i2] = (eVar.W(i2) || eVar.I.contains(Integer.valueOf(aVar.e(i2))) || (aVar.e(i2) != -2 && jy0VarArrA[i2] == null)) ? null : jq3.c;
        }
        if (eVar.J0) {
            X(aVar, iArr, jq3VarArr, jy0VarArrA);
        }
        if (eVar.w.a != 0) {
            W(eVar, aVar, iArr, jq3VarArr, jy0VarArrA);
        }
        return Pair.create(jq3VarArr, jy0VarArrA);
    }

    public ri0(Context context, jy0.b bVar) {
        this(context, e.O0, bVar);
    }

    public ri0(Context context, lr4 lr4Var, jy0.b bVar) {
        this(lr4Var, bVar, context);
    }

    public ri0(Context context) {
        this(context, new a5.b());
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e extends lr4 {
        public static final e O0;
        public static final e P0;
        public static final String Q0;
        public static final String R0;
        public static final String S0;
        public static final String T0;
        public static final String U0;
        public static final String V0;
        public static final String W0;
        public static final String X0;
        public static final String Y0;
        public static final String Z0;
        public static final String a1;
        public static final String b1;
        public static final String c1;
        public static final String d1;
        public static final String e1;
        public static final String f1;
        public static final String g1;
        public static final String h1;
        public static final String i1;
        public final boolean A0;
        public final boolean B0;
        public final boolean C0;
        public final boolean D0;
        public final boolean E0;
        public final boolean F0;
        public final boolean G0;
        public final boolean H0;
        public final boolean I0;
        public final boolean J0;
        public final boolean K0;
        public final boolean L0;
        public final SparseArray M0;
        public final SparseBooleanArray N0;
        public final boolean x0;
        public final boolean y0;
        public final boolean z0;

        static {
            e eVarK = new a().K();
            O0 = eVarK;
            P0 = eVarK;
            Q0 = fy4.N0(1000);
            R0 = fy4.N0(WebSocketProtocol.CLOSE_CLIENT_GOING_AWAY);
            S0 = fy4.N0(1002);
            T0 = fy4.N0(1003);
            U0 = fy4.N0(1004);
            V0 = fy4.N0(WebSocketProtocol.CLOSE_NO_STATUS_CODE);
            W0 = fy4.N0(1006);
            X0 = fy4.N0(1007);
            Y0 = fy4.N0(1008);
            Z0 = fy4.N0(1009);
            a1 = fy4.N0(1010);
            b1 = fy4.N0(1011);
            c1 = fy4.N0(1012);
            d1 = fy4.N0(1013);
            e1 = fy4.N0(1014);
            f1 = fy4.N0(1015);
            g1 = fy4.N0(1016);
            h1 = fy4.N0(1017);
            i1 = fy4.N0(1018);
        }

        public e(a aVar) {
            super(aVar);
            this.x0 = aVar.J;
            this.y0 = aVar.K;
            this.z0 = aVar.L;
            this.A0 = aVar.M;
            this.B0 = aVar.N;
            this.C0 = aVar.O;
            this.D0 = aVar.P;
            this.E0 = aVar.Q;
            this.F0 = aVar.R;
            this.G0 = aVar.S;
            this.H0 = aVar.T;
            this.I0 = aVar.U;
            this.J0 = aVar.V;
            this.K0 = aVar.W;
            this.L0 = aVar.X;
            this.M0 = aVar.Y;
            this.N0 = aVar.Z;
        }

        public static boolean R(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) < 0) {
                    return false;
                }
            }
            return true;
        }

        public static boolean S(SparseArray sparseArray, SparseArray sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                int iIndexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i));
                if (iIndexOfKey < 0 || !T((Map) sparseArray.valueAt(i), (Map) sparseArray2.valueAt(iIndexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        public static boolean T(Map map, Map map2) {
            if (map2.size() != map.size()) {
                return false;
            }
            for (Map.Entry entry : map.entrySet()) {
                er4 er4Var = (er4) entry.getKey();
                if (!map2.containsKey(er4Var) || !Objects.equals(entry.getValue(), map2.get(er4Var))) {
                    return false;
                }
            }
            return true;
        }

        public static int[] V(SparseBooleanArray sparseBooleanArray) {
            int[] iArr = new int[sparseBooleanArray.size()];
            for (int i = 0; i < sparseBooleanArray.size(); i++) {
                iArr[i] = sparseBooleanArray.keyAt(i);
            }
            return iArr;
        }

        public static void Z(Bundle bundle, SparseArray sparseArray) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            SparseArray sparseArray2 = new SparseArray();
            for (int i = 0; i < sparseArray.size(); i++) {
                int iKeyAt = sparseArray.keyAt(i);
                for (Map.Entry entry : ((Map) sparseArray.valueAt(i)).entrySet()) {
                    w82.a(entry.getValue());
                    arrayList2.add((er4) entry.getKey());
                    arrayList.add(Integer.valueOf(iKeyAt));
                }
                bundle.putIntArray(a1, ll1.n(arrayList));
                bundle.putParcelableArrayList(b1, fm.h(arrayList2, new p81() { // from class: si0
                    @Override // defpackage.p81
                    public final Object apply(Object obj) {
                        return ((er4) obj).e();
                    }
                }));
                bundle.putSparseParcelableArray(c1, fm.j(sparseArray2, new p81() { // from class: ti0
                    @Override // defpackage.p81
                    public final Object apply(Object obj) {
                        w82.a(obj);
                        throw null;
                    }
                }));
            }
        }

        @Override // defpackage.lr4
        public Bundle O() {
            Bundle bundleO = super.O();
            bundleO.putBoolean(Q0, this.x0);
            bundleO.putBoolean(R0, this.y0);
            bundleO.putBoolean(S0, this.z0);
            bundleO.putBoolean(e1, this.A0);
            bundleO.putBoolean(T0, this.B0);
            bundleO.putBoolean(U0, this.C0);
            bundleO.putBoolean(V0, this.D0);
            bundleO.putBoolean(W0, this.E0);
            bundleO.putBoolean(f1, this.F0);
            bundleO.putBoolean(i1, this.G0);
            bundleO.putBoolean(g1, this.H0);
            bundleO.putBoolean(X0, this.I0);
            bundleO.putBoolean(Y0, this.J0);
            bundleO.putBoolean(Z0, this.K0);
            bundleO.putBoolean(h1, this.L0);
            Z(bundleO, this.M0);
            bundleO.putIntArray(d1, V(this.N0));
            return bundleO;
        }

        @Override // defpackage.lr4
        /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
        public a M() {
            return new a();
        }

        public boolean W(int i) {
            return this.N0.get(i);
        }

        public f X(int i, er4 er4Var) {
            Map map = (Map) this.M0.get(i);
            if (map != null) {
                w82.a(map.get(er4Var));
            }
            return null;
        }

        public boolean Y(int i, er4 er4Var) {
            Map map = (Map) this.M0.get(i);
            return map != null && map.containsKey(er4Var);
        }

        @Override // defpackage.lr4
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && e.class == obj.getClass()) {
                e eVar = (e) obj;
                if (super.equals(eVar) && this.x0 == eVar.x0 && this.y0 == eVar.y0 && this.z0 == eVar.z0 && this.A0 == eVar.A0 && this.B0 == eVar.B0 && this.C0 == eVar.C0 && this.D0 == eVar.D0 && this.E0 == eVar.E0 && this.F0 == eVar.F0 && this.G0 == eVar.G0 && this.H0 == eVar.H0 && this.I0 == eVar.I0 && this.J0 == eVar.J0 && this.K0 == eVar.K0 && this.L0 == eVar.L0 && R(this.N0, eVar.N0) && S(this.M0, eVar.M0)) {
                    return true;
                }
            }
            return false;
        }

        @Override // defpackage.lr4
        public int hashCode() {
            return ((((((((((((((((((((((((((((((super.hashCode() + 31) * 31) + (this.x0 ? 1 : 0)) * 31) + (this.y0 ? 1 : 0)) * 31) + (this.z0 ? 1 : 0)) * 31) + (this.A0 ? 1 : 0)) * 31) + (this.B0 ? 1 : 0)) * 31) + (this.C0 ? 1 : 0)) * 31) + (this.D0 ? 1 : 0)) * 31) + (this.E0 ? 1 : 0)) * 31) + (this.F0 ? 1 : 0)) * 31) + (this.G0 ? 1 : 0)) * 31) + (this.H0 ? 1 : 0)) * 31) + (this.I0 ? 1 : 0)) * 31) + (this.J0 ? 1 : 0)) * 31) + (this.K0 ? 1 : 0)) * 31) + (this.L0 ? 1 : 0);
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class a extends lr4.c {
            public boolean J;
            public boolean K;
            public boolean L;
            public boolean M;
            public boolean N;
            public boolean O;
            public boolean P;
            public boolean Q;
            public boolean R;
            public boolean S;
            public boolean T;
            public boolean U;
            public boolean V;
            public boolean W;
            public boolean X;
            public final SparseArray Y;
            public final SparseBooleanArray Z;

            public a(e eVar) {
                super(eVar);
                this.J = eVar.x0;
                this.K = eVar.y0;
                this.L = eVar.z0;
                this.M = eVar.A0;
                this.N = eVar.B0;
                this.O = eVar.C0;
                this.P = eVar.D0;
                this.Q = eVar.E0;
                this.R = eVar.F0;
                this.S = eVar.G0;
                this.T = eVar.H0;
                this.U = eVar.I0;
                this.V = eVar.J0;
                this.W = eVar.K0;
                this.X = eVar.L0;
                this.Y = w0(eVar.M0);
                this.Z = eVar.N0.clone();
            }

            public static SparseArray w0(SparseArray sparseArray) {
                SparseArray sparseArray2 = new SparseArray();
                for (int i = 0; i < sparseArray.size(); i++) {
                    sparseArray2.put(sparseArray.keyAt(i), new HashMap((Map) sparseArray.valueAt(i)));
                }
                return sparseArray2;
            }

            public a A0(boolean z) {
                super.S(z);
                return this;
            }

            @Override // lr4.c
            /* JADX INFO: renamed from: B0, reason: merged with bridge method [inline-methods] */
            public a T(int i) {
                super.T(i);
                return this;
            }

            @Override // lr4.c
            /* JADX INFO: renamed from: C0, reason: merged with bridge method [inline-methods] */
            public a U(jr4 jr4Var) {
                super.U(jr4Var);
                return this;
            }

            public a D0(String str) {
                super.V(str);
                return this;
            }

            @Override // lr4.c
            /* JADX INFO: renamed from: E0, reason: merged with bridge method [inline-methods] */
            public a W(String... strArr) {
                super.W(strArr);
                return this;
            }

            @Override // lr4.c
            /* JADX INFO: renamed from: F0, reason: merged with bridge method [inline-methods] */
            public a X(String str) {
                super.X(str);
                return this;
            }

            @Override // lr4.c
            /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
            public a Y(String... strArr) {
                super.Y(strArr);
                return this;
            }

            @Override // lr4.c
            /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
            public a Z(int i) {
                super.Z(i);
                return this;
            }

            @Override // lr4.c
            /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
            public a a0(int i, boolean z) {
                super.a0(i, z);
                return this;
            }

            public a J0(boolean z) {
                this.V = z;
                return this;
            }

            @Override // lr4.c
            /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
            public a J(jr4 jr4Var) {
                super.J(jr4Var);
                return this;
            }

            @Override // lr4.c
            /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
            public e K() {
                return new e(this);
            }

            @Override // lr4.c
            /* JADX INFO: renamed from: u0, reason: merged with bridge method [inline-methods] */
            public a L() {
                super.L();
                return this;
            }

            @Override // lr4.c
            /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
            public a M(int i) {
                super.M(i);
                return this;
            }

            public final void x0() {
                this.J = true;
                this.K = false;
                this.L = true;
                this.M = false;
                this.N = true;
                this.O = false;
                this.P = false;
                this.Q = false;
                this.R = false;
                this.S = true;
                this.T = true;
                this.U = true;
                this.V = false;
                this.W = true;
                this.X = false;
            }

            public a y0(lr4 lr4Var) {
                super.Q(lr4Var);
                return this;
            }

            @Override // lr4.c
            /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] */
            public a R(Set set) {
                super.R(set);
                return this;
            }

            public a() {
                this.Y = new SparseArray();
                this.Z = new SparseBooleanArray();
                x0();
            }
        }
    }
}
