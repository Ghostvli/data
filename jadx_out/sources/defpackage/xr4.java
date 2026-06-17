package defpackage;

import android.os.Bundle;
import defpackage.xr4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class xr4 {
    public static final xr4 b = new xr4(xi1.u());
    public static final String c = fy4.N0(0);
    public final xi1 a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public static final String f = fy4.N0(0);
        public static final String g = fy4.N0(1);
        public static final String h = fy4.N0(3);
        public static final String i = fy4.N0(4);
        public final int a;
        public final br4 b;
        public final boolean c;
        public final int[] d;
        public final boolean[] e;

        public a(br4 br4Var, boolean z, int[] iArr, boolean[] zArr) {
            int i2 = br4Var.a;
            this.a = i2;
            boolean z2 = false;
            gg3.d(i2 == iArr.length && i2 == zArr.length);
            this.b = br4Var;
            if (z && i2 > 1) {
                z2 = true;
            }
            this.c = z2;
            this.d = (int[]) iArr.clone();
            this.e = (boolean[]) zArr.clone();
        }

        public static a b(Bundle bundle) {
            br4 br4VarB = br4.b((Bundle) gg3.q(bundle.getBundle(f)));
            return new a(br4VarB, bundle.getBoolean(i, false), (int[]) eu2.a(bundle.getIntArray(g), new int[br4VarB.a]), (boolean[]) eu2.a(bundle.getBooleanArray(h), new boolean[br4VarB.a]));
        }

        public a a(br4 br4Var) {
            return new a(br4Var, this.c, this.d, this.e);
        }

        public br4 c() {
            return this.b;
        }

        public t41 d(int i2) {
            return this.b.c(i2);
        }

        public int e() {
            return this.b.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class == obj.getClass()) {
                a aVar = (a) obj;
                if (this.c == aVar.c && this.b.equals(aVar.b) && Arrays.equals(this.d, aVar.d) && Arrays.equals(this.e, aVar.e)) {
                    return true;
                }
            }
            return false;
        }

        public boolean f() {
            return bl.a(this.e, true);
        }

        public boolean g(boolean z) {
            for (int i2 = 0; i2 < this.d.length; i2++) {
                if (j(i2, z)) {
                    return true;
                }
            }
            return false;
        }

        public boolean h(int i2) {
            return this.e[i2];
        }

        public int hashCode() {
            return (((((this.b.hashCode() * 31) + (this.c ? 1 : 0)) * 31) + Arrays.hashCode(this.d)) * 31) + Arrays.hashCode(this.e);
        }

        public boolean i(int i2) {
            return j(i2, false);
        }

        public boolean j(int i2, boolean z) {
            int i3 = this.d[i2];
            if (i3 != 4) {
                return z && i3 == 3;
            }
            return true;
        }

        public Bundle k() {
            Bundle bundle = new Bundle();
            bundle.putBundle(f, this.b.h());
            bundle.putIntArray(g, this.d);
            bundle.putBooleanArray(h, this.e);
            bundle.putBoolean(i, this.c);
            return bundle;
        }
    }

    public xr4(List list) {
        this.a = xi1.p(list);
    }

    public static xr4 a(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(c);
        return new xr4(parcelableArrayList == null ? xi1.u() : fm.d(new p81() { // from class: wr4
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return xr4.a.b((Bundle) obj);
            }
        }, parcelableArrayList));
    }

    public xi1 b() {
        return this.a;
    }

    public boolean c() {
        return this.a.isEmpty();
    }

    public boolean d(int i) {
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            a aVar = (a) this.a.get(i2);
            if (aVar.f() && aVar.e() == i) {
                return true;
            }
        }
        return false;
    }

    public boolean e(int i) {
        return f(i, false);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || xr4.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((xr4) obj).a);
    }

    public boolean f(int i, boolean z) {
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            if (((a) this.a.get(i2)).e() == i && ((a) this.a.get(i2)).g(z)) {
                return true;
            }
        }
        return false;
    }

    public Bundle g() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(c, fm.h(this.a, new p81() { // from class: vr4
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return ((xr4.a) obj).k();
            }
        }));
        return bundle;
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
