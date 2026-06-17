package defpackage;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Pair;
import defpackage.fg2;
import defpackage.no4;
import defpackage.x3;
import defpackage.xi1;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class no4 {
    public static final no4 a = new a();
    public static final String b = fy4.N0(0);
    public static final String c = fy4.N0(1);
    public static final String d = fy4.N0(2);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends no4 {
        @Override // defpackage.no4
        public int h(Object obj) {
            return -1;
        }

        @Override // defpackage.no4
        public b m(int i, b bVar, boolean z) {
            throw new IndexOutOfBoundsException();
        }

        @Override // defpackage.no4
        public int o() {
            return 0;
        }

        @Override // defpackage.no4
        public Object s(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // defpackage.no4
        public d u(int i, d dVar, long j) {
            throw new IndexOutOfBoundsException();
        }

        @Override // defpackage.no4
        public int v() {
            return 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public static final String h = fy4.N0(0);
        public static final String i = fy4.N0(1);
        public static final String j = fy4.N0(2);
        public static final String k = fy4.N0(3);
        public static final String l = fy4.N0(4);
        public Object a;
        public Object b;
        public int c;
        public long d;
        public long e;
        public boolean f;
        public x3 g = x3.g;

        public static b a(Bundle bundle, int i2) {
            int i3 = bundle.getInt(h, 0);
            long j2 = bundle.getLong(i, -9223372036854775807L);
            long j3 = bundle.getLong(j, 0L);
            boolean z = bundle.getBoolean(k, false);
            Bundle bundle2 = bundle.getBundle(l);
            x3 x3VarA = bundle2 != null ? x3.a(bundle2, i2) : x3.g;
            b bVar = new b();
            bVar.v(null, null, i3, j2, j3, x3VarA, z);
            return bVar;
        }

        public int b(int i2) {
            return this.g.b(i2).b;
        }

        public long c(int i2, int i3) {
            x3.a aVarB = this.g.b(i2);
            if (aVarB.b != -1) {
                return aVarB.g[i3];
            }
            return -9223372036854775807L;
        }

        public int d() {
            return this.g.b;
        }

        public int e(long j2) {
            return this.g.c(j2, this.d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && b.class.equals(obj.getClass())) {
                b bVar = (b) obj;
                if (Objects.equals(this.a, bVar.a) && Objects.equals(this.b, bVar.b) && this.c == bVar.c && this.d == bVar.d && this.e == bVar.e && this.f == bVar.f && Objects.equals(this.g, bVar.g)) {
                    return true;
                }
            }
            return false;
        }

        public int f(long j2) {
            return this.g.d(j2, this.d);
        }

        public long g(int i2) {
            return this.g.b(i2).a;
        }

        public long h() {
            return this.g.c;
        }

        public int hashCode() {
            Object obj = this.a;
            int iHashCode = (217 + (obj == null ? 0 : obj.hashCode())) * 31;
            Object obj2 = this.b;
            int iHashCode2 = (((iHashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.c) * 31;
            long j2 = this.d;
            int i2 = (iHashCode2 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.e;
            return ((((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.f ? 1 : 0)) * 31) + this.g.hashCode();
        }

        public int i(int i2, int i3) {
            x3.a aVarB = this.g.b(i2);
            if (aVarB.b != -1) {
                return aVarB.f[i3];
            }
            return 0;
        }

        public long j(int i2) {
            return this.g.b(i2).j;
        }

        public long k() {
            return fy4.S1(this.d);
        }

        public long l() {
            return this.d;
        }

        public int m(int i2) {
            return this.g.b(i2).e();
        }

        public int n(int i2, int i3) {
            return this.g.b(i2).h(i3);
        }

        public long o() {
            return fy4.S1(this.e);
        }

        public long p() {
            return this.e;
        }

        public int q() {
            return this.g.e;
        }

        public boolean r(int i2) {
            return !this.g.b(i2).k();
        }

        public boolean s(int i2) {
            return i2 == d() - 1 && this.g.e(i2);
        }

        public boolean t(int i2) {
            return this.g.b(i2).k;
        }

        public b u(Object obj, Object obj2, int i2, long j2, long j3) {
            return v(obj, obj2, i2, j2, j3, x3.g, false);
        }

        public b v(Object obj, Object obj2, int i2, long j2, long j3, x3 x3Var, boolean z) {
            this.a = obj;
            this.b = obj2;
            this.c = i2;
            this.d = j2;
            this.e = j3;
            this.g = x3Var;
            this.f = z;
            return this;
        }

        public Bundle w(int i2) {
            Bundle bundle = new Bundle();
            int i3 = this.c;
            if (i3 != 0) {
                bundle.putInt(h, i3);
            }
            long j2 = this.d;
            if (j2 != -9223372036854775807L) {
                bundle.putLong(i, j2);
            }
            long j3 = this.e;
            if (j3 != 0) {
                bundle.putLong(j, j3);
            }
            boolean z = this.f;
            if (z) {
                bundle.putBoolean(k, z);
            }
            if (!this.g.equals(x3.g)) {
                bundle.putBundle(l, this.g.g(i2));
            }
            return bundle;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends no4 {
        public final xi1 e;
        public final xi1 f;
        public final int[] g;
        public final int[] h;

        public c(xi1 xi1Var, xi1 xi1Var2, int[] iArr) {
            gg3.d(xi1Var.size() == iArr.length);
            this.e = xi1Var;
            this.f = xi1Var2;
            this.g = iArr;
            this.h = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.h[iArr[i]] = i;
            }
        }

        @Override // defpackage.no4
        public int g(boolean z) {
            if (w()) {
                return -1;
            }
            if (z) {
                return this.g[0];
            }
            return 0;
        }

        @Override // defpackage.no4
        public int h(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // defpackage.no4
        public int i(boolean z) {
            if (w()) {
                return -1;
            }
            return z ? this.g[v() - 1] : v() - 1;
        }

        @Override // defpackage.no4
        public int k(int i, int i2, boolean z) {
            if (i2 == 1) {
                return i;
            }
            if (i != i(z)) {
                return z ? this.g[this.h[i] + 1] : i + 1;
            }
            if (i2 == 2) {
                return g(z);
            }
            return -1;
        }

        @Override // defpackage.no4
        public b m(int i, b bVar, boolean z) {
            b bVar2 = (b) this.f.get(i);
            bVar.v(bVar2.a, bVar2.b, bVar2.c, bVar2.d, bVar2.e, bVar2.g, bVar2.f);
            return bVar;
        }

        @Override // defpackage.no4
        public int o() {
            return this.f.size();
        }

        @Override // defpackage.no4
        public int r(int i, int i2, boolean z) {
            if (i2 == 1) {
                return i;
            }
            if (i != g(z)) {
                return z ? this.g[this.h[i] - 1] : i - 1;
            }
            if (i2 == 2) {
                return i(z);
            }
            return -1;
        }

        @Override // defpackage.no4
        public Object s(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // defpackage.no4
        public d u(int i, d dVar, long j) {
            d dVar2 = (d) this.e.get(i);
            dVar.h(dVar2.a, dVar2.c, dVar2.d, dVar2.e, dVar2.f, dVar2.g, dVar2.h, dVar2.i, dVar2.j, dVar2.l, dVar2.m, dVar2.n, dVar2.o, dVar2.p);
            dVar.k = dVar2.k;
            return dVar;
        }

        @Override // defpackage.no4
        public int v() {
            return this.e.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d {
        public Object b;
        public Object d;
        public long e;
        public long f;
        public long g;
        public boolean h;
        public boolean i;
        public fg2.g j;
        public boolean k;
        public long l;
        public long m;
        public int n;
        public int o;
        public long p;
        public static final Object q = new Object();
        public static final Object r = new Object();
        public static final fg2 s = new fg2.c().e("androidx.media3.common.Timeline").k(Uri.EMPTY).a();
        public static final String t = fy4.N0(1);
        public static final String u = fy4.N0(2);
        public static final String v = fy4.N0(3);
        public static final String w = fy4.N0(4);
        public static final String x = fy4.N0(5);
        public static final String y = fy4.N0(6);
        public static final String z = fy4.N0(7);
        public static final String A = fy4.N0(8);
        public static final String B = fy4.N0(9);
        public static final String C = fy4.N0(10);
        public static final String D = fy4.N0(11);
        public static final String E = fy4.N0(12);
        public static final String F = fy4.N0(13);
        public Object a = q;
        public fg2 c = s;

        public static d a(Bundle bundle, int i) {
            Bundle bundle2 = bundle.getBundle(t);
            fg2 fg2VarB = bundle2 != null ? fg2.b(bundle2, i) : fg2.i;
            long j = bundle.getLong(u, -9223372036854775807L);
            long j2 = bundle.getLong(v, -9223372036854775807L);
            long j3 = bundle.getLong(w, -9223372036854775807L);
            boolean z2 = bundle.getBoolean(x, false);
            boolean z3 = bundle.getBoolean(y, false);
            Bundle bundle3 = bundle.getBundle(z);
            fg2.g gVarB = bundle3 != null ? fg2.g.b(bundle3) : null;
            boolean z4 = bundle.getBoolean(A, false);
            long j4 = bundle.getLong(B, 0L);
            long j5 = bundle.getLong(C, -9223372036854775807L);
            int i2 = bundle.getInt(D, 0);
            int i3 = bundle.getInt(E, 0);
            long j6 = bundle.getLong(F, 0L);
            d dVar = new d();
            dVar.h(r, fg2VarB, null, j, j2, j3, z2, z3, gVarB, j4, j5, i2, i3, j6);
            dVar.k = z4;
            return dVar;
        }

        public long b() {
            return fy4.q0(this.g);
        }

        public long c() {
            return fy4.S1(this.l);
        }

        public long d() {
            return this.l;
        }

        public long e() {
            return fy4.S1(this.m);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && d.class.equals(obj.getClass())) {
                d dVar = (d) obj;
                if (Objects.equals(this.a, dVar.a) && Objects.equals(this.c, dVar.c) && Objects.equals(this.d, dVar.d) && Objects.equals(this.j, dVar.j) && this.e == dVar.e && this.f == dVar.f && this.g == dVar.g && this.h == dVar.h && this.i == dVar.i && this.k == dVar.k && this.l == dVar.l && this.m == dVar.m && this.n == dVar.n && this.o == dVar.o && this.p == dVar.p) {
                    return true;
                }
            }
            return false;
        }

        public long f() {
            return this.p;
        }

        public boolean g() {
            return this.j != null;
        }

        public d h(Object obj, fg2 fg2Var, Object obj2, long j, long j2, long j3, boolean z2, boolean z3, fg2.g gVar, long j4, long j5, int i, int i2, long j6) {
            fg2.h hVar;
            this.a = obj;
            this.c = fg2Var != null ? fg2Var : s;
            this.b = (fg2Var == null || (hVar = fg2Var.b) == null) ? null : hVar.i;
            this.d = obj2;
            this.e = j;
            this.f = j2;
            this.g = j3;
            this.h = z2;
            this.i = z3;
            this.j = gVar;
            this.l = j4;
            this.m = j5;
            this.n = i;
            this.o = i2;
            this.p = j6;
            this.k = false;
            return this;
        }

        public int hashCode() {
            int iHashCode = (((217 + this.a.hashCode()) * 31) + this.c.hashCode()) * 31;
            Object obj = this.d;
            int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
            fg2.g gVar = this.j;
            int iHashCode3 = (iHashCode2 + (gVar != null ? gVar.hashCode() : 0)) * 31;
            long j = this.e;
            int i = (iHashCode3 + ((int) (j ^ (j >>> 32)))) * 31;
            long j2 = this.f;
            int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.g;
            int i3 = (((((((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.h ? 1 : 0)) * 31) + (this.i ? 1 : 0)) * 31) + (this.k ? 1 : 0)) * 31;
            long j4 = this.l;
            int i4 = (i3 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
            long j5 = this.m;
            int i5 = (((((i4 + ((int) (j5 ^ (j5 >>> 32)))) * 31) + this.n) * 31) + this.o) * 31;
            long j6 = this.p;
            return i5 + ((int) (j6 ^ (j6 >>> 32)));
        }

        public Bundle i(int i) {
            Bundle bundle = new Bundle();
            if (!fg2.i.equals(this.c)) {
                bundle.putBundle(t, this.c.e(i));
            }
            long j = this.e;
            if (j != -9223372036854775807L) {
                bundle.putLong(u, j);
            }
            long j2 = this.f;
            if (j2 != -9223372036854775807L) {
                bundle.putLong(v, j2);
            }
            long j3 = this.g;
            if (j3 != -9223372036854775807L) {
                bundle.putLong(w, j3);
            }
            boolean z2 = this.h;
            if (z2) {
                bundle.putBoolean(x, z2);
            }
            boolean z3 = this.i;
            if (z3) {
                bundle.putBoolean(y, z3);
            }
            fg2.g gVar = this.j;
            if (gVar != null) {
                bundle.putBundle(z, gVar.c());
            }
            boolean z4 = this.k;
            if (z4) {
                bundle.putBoolean(A, z4);
            }
            long j4 = this.l;
            if (j4 != 0) {
                bundle.putLong(B, j4);
            }
            long j5 = this.m;
            if (j5 != -9223372036854775807L) {
                bundle.putLong(C, j5);
            }
            int i2 = this.n;
            if (i2 != 0) {
                bundle.putInt(D, i2);
            }
            int i3 = this.o;
            if (i3 != 0) {
                bundle.putInt(E, i3);
            }
            long j6 = this.p;
            if (j6 != 0) {
                bundle.putLong(F, j6);
            }
            return bundle;
        }
    }

    public static no4 d(Bundle bundle, final int i) {
        xi1 xi1VarE = e(new p81() { // from class: lo4
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return no4.d.a((Bundle) obj, i);
            }
        }, bundle.getBinder(b));
        xi1 xi1VarE2 = e(new p81() { // from class: mo4
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return no4.b.a((Bundle) obj, i);
            }
        }, bundle.getBinder(c));
        int[] intArray = bundle.getIntArray(d);
        if (intArray == null) {
            intArray = f(xi1VarE.size());
        }
        return new c(xi1VarE, xi1VarE2, intArray);
    }

    public static xi1 e(p81 p81Var, IBinder iBinder) {
        return iBinder == null ? xi1.u() : fm.d(p81Var, km.a(iBinder));
    }

    public static int[] f(int i) {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = i2;
        }
        return iArr;
    }

    public final no4 c(int i) {
        if (v() == 1) {
            return this;
        }
        d dVarU = u(i, new d(), 0L);
        xi1.a aVarM = xi1.m();
        int i2 = dVarU.n;
        while (true) {
            int i3 = dVarU.o;
            if (i2 > i3) {
                dVarU.o = i3 - dVarU.n;
                dVarU.n = 0;
                return new c(xi1.w(dVarU), aVarM.k(), new int[]{0});
            }
            b bVarM = m(i2, new b(), true);
            bVarM.c = 0;
            aVarM.a(bVarM);
            i2++;
        }
    }

    public boolean equals(Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof no4)) {
            return false;
        }
        no4 no4Var = (no4) obj;
        if (no4Var.v() != v() || no4Var.o() != o()) {
            return false;
        }
        d dVar = new d();
        b bVar = new b();
        d dVar2 = new d();
        b bVar2 = new b();
        for (int i2 = 0; i2 < v(); i2++) {
            if (!t(i2, dVar).equals(no4Var.t(i2, dVar2))) {
                return false;
            }
        }
        for (int i3 = 0; i3 < o(); i3++) {
            if (!m(i3, bVar, true).equals(no4Var.m(i3, bVar2, true))) {
                return false;
            }
        }
        int iG = g(true);
        if (iG != no4Var.g(true) || (i = i(true)) != no4Var.i(true)) {
            return false;
        }
        while (iG != i) {
            int iK = k(iG, 0, true);
            if (iK != no4Var.k(iG, 0, true)) {
                return false;
            }
            iG = iK;
        }
        return true;
    }

    public int g(boolean z) {
        return w() ? -1 : 0;
    }

    public abstract int h(Object obj);

    public int hashCode() {
        d dVar = new d();
        b bVar = new b();
        int iV = 217 + v();
        for (int i = 0; i < v(); i++) {
            iV = (iV * 31) + t(i, dVar).hashCode();
        }
        int iO = (iV * 31) + o();
        for (int i2 = 0; i2 < o(); i2++) {
            iO = (iO * 31) + m(i2, bVar, true).hashCode();
        }
        int iG = g(true);
        while (iG != -1) {
            iO = (iO * 31) + iG;
            iG = k(iG, 0, true);
        }
        return iO;
    }

    public int i(boolean z) {
        if (w()) {
            return -1;
        }
        return v() - 1;
    }

    public final int j(int i, b bVar, d dVar, int i2, boolean z) {
        int i3 = l(i, bVar).c;
        if (t(i3, dVar).o != i) {
            return i + 1;
        }
        int iK = k(i3, i2, z);
        if (iK == -1) {
            return -1;
        }
        return t(iK, dVar).n;
    }

    public int k(int i, int i2, boolean z) {
        if (i2 == 0) {
            if (i == i(z)) {
                return -1;
            }
            return i + 1;
        }
        if (i2 == 1) {
            return i;
        }
        if (i2 == 2) {
            return i == i(z) ? g(z) : i + 1;
        }
        z20.a();
        return 0;
    }

    public final b l(int i, b bVar) {
        return m(i, bVar, false);
    }

    public abstract b m(int i, b bVar, boolean z);

    public b n(Object obj, b bVar) {
        return m(h(obj), bVar, true);
    }

    public abstract int o();

    public final Pair p(d dVar, b bVar, int i, long j) {
        return (Pair) gg3.q(q(dVar, bVar, i, j, 0L));
    }

    public final Pair q(d dVar, b bVar, int i, long j, long j2) {
        gg3.o(i, v());
        u(i, dVar, j2);
        if (j == -9223372036854775807L) {
            j = dVar.d();
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        int i2 = dVar.n;
        l(i2, bVar);
        while (i2 < dVar.o && bVar.e != j) {
            int i3 = i2 + 1;
            if (l(i3, bVar).e > j) {
                break;
            }
            i2 = i3;
        }
        m(i2, bVar, true);
        long jMin = j - bVar.e;
        long j3 = bVar.d;
        if (j3 != -9223372036854775807L) {
            jMin = Math.min(jMin, j3 - 1);
        }
        return Pair.create(gg3.q(bVar.b), Long.valueOf(Math.max(0L, jMin)));
    }

    public int r(int i, int i2, boolean z) {
        if (i2 == 0) {
            if (i == g(z)) {
                return -1;
            }
            return i - 1;
        }
        if (i2 == 1) {
            return i;
        }
        if (i2 == 2) {
            return i == g(z) ? i(z) : i - 1;
        }
        z20.a();
        return 0;
    }

    public abstract Object s(int i);

    public final d t(int i, d dVar) {
        return u(i, dVar, 0L);
    }

    public abstract d u(int i, d dVar, long j);

    public abstract int v();

    public final boolean w() {
        return v() == 0;
    }

    public final boolean x(int i, b bVar, d dVar, int i2, boolean z) {
        return j(i, bVar, dVar, i2, z) == -1;
    }

    public final Bundle y(int i) {
        ArrayList arrayList = new ArrayList();
        int iV = v();
        d dVar = new d();
        for (int i2 = 0; i2 < iV; i2++) {
            arrayList.add(u(i2, dVar, 0L).i(i));
        }
        ArrayList arrayList2 = new ArrayList();
        int iO = o();
        b bVar = new b();
        for (int i3 = 0; i3 < iO; i3++) {
            arrayList2.add(m(i3, bVar, false).w(i));
        }
        int[] iArr = new int[iV];
        if (iV > 0) {
            iArr[0] = g(true);
        }
        for (int i4 = 1; i4 < iV; i4++) {
            iArr[i4] = k(iArr[i4 - 1], 0, true);
        }
        Bundle bundle = new Bundle();
        bundle.putBinder(b, new km(arrayList));
        bundle.putBinder(c, new km(arrayList2));
        bundle.putIntArray(d, iArr);
        return bundle;
    }
}
