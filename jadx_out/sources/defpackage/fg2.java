package defpackage;

import android.net.Uri;
import android.os.Bundle;
import defpackage.fg2;
import defpackage.xi1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class fg2 {
    public static final fg2 i = new c().a();
    public static final String j = fy4.N0(0);
    public static final String k = fy4.N0(1);
    public static final String l = fy4.N0(2);
    public static final String m = fy4.N0(3);
    public static final String n = fy4.N0(4);
    public static final String o = fy4.N0(5);
    public final String a;
    public final h b;
    public final h c;
    public final g d;
    public final ph2 e;
    public final d f;
    public final e g;
    public final i h;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public static final String c = fy4.N0(0);
        public final Uri a;
        public final Object b;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class a {
            public Uri a;
            public Object b;

            public a(Uri uri) {
                this.a = uri;
            }

            public b c() {
                return new b(this);
            }
        }

        public b(a aVar) {
            this.a = aVar.a;
            this.b = aVar.b;
        }

        public static b a(Bundle bundle) {
            Uri uri = (Uri) bundle.getParcelable(c);
            gg3.q(uri);
            return new a(uri).c();
        }

        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putParcelable(c, this.a);
            return bundle;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a.equals(bVar.a) && Objects.equals(this.b, bVar.b);
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            Object obj = this.b;
            return iHashCode + (obj != null ? obj.hashCode() : 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e extends d {
        public static final e r = new d.a().h();

        public e(d.a aVar) {
            super(aVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class h {
        public static final String k = fy4.N0(0);
        public static final String l = fy4.N0(1);
        public static final String m = fy4.N0(2);
        public static final String n = fy4.N0(3);
        public static final String o = fy4.N0(4);
        public static final String p = fy4.N0(5);
        public static final String q = fy4.N0(6);
        public static final String r = fy4.N0(7);
        public final Uri a;
        public final String b;
        public final f c;
        public final b d;
        public final List e;
        public final String f;
        public final xi1 g;
        public final List h;
        public final Object i;
        public final long j;

        public h(Uri uri, String str, f fVar, b bVar, List list, String str2, xi1 xi1Var, Object obj, long j) {
            this.a = uri;
            this.b = nt2.u(str);
            this.c = fVar;
            this.d = bVar;
            this.e = list;
            this.f = str2;
            this.g = xi1Var;
            xi1.a aVarM = xi1.m();
            for (int i = 0; i < xi1Var.size(); i++) {
                aVarM.a(((k) xi1Var.get(i)).a().j());
            }
            this.h = aVarM.k();
            this.i = obj;
            this.j = j;
        }

        public static h a(Bundle bundle) {
            Bundle bundle2 = bundle.getBundle(m);
            f fVarC = bundle2 == null ? null : f.c(bundle2);
            Bundle bundle3 = bundle.getBundle(n);
            b bVarA = bundle3 != null ? b.a(bundle3) : null;
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(o);
            xi1 xi1VarU = parcelableArrayList == null ? xi1.u() : fm.d(new p81() { // from class: ig2
                @Override // defpackage.p81
                public final Object apply(Object obj) {
                    return bf4.w((Bundle) obj);
                }
            }, parcelableArrayList);
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList(q);
            return new h((Uri) gg3.q((Uri) bundle.getParcelable(k)), bundle.getString(l), fVarC, bVarA, xi1VarU, bundle.getString(p), parcelableArrayList2 == null ? xi1.u() : fm.d(new p81() { // from class: jg2
                @Override // defpackage.p81
                public final Object apply(Object obj) {
                    return fg2.k.b((Bundle) obj);
                }
            }, parcelableArrayList2), null, bundle.getLong(r, -9223372036854775807L));
        }

        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putParcelable(k, this.a);
            String str = this.b;
            if (str != null) {
                bundle.putString(l, str);
            }
            f fVar = this.c;
            if (fVar != null) {
                bundle.putBundle(m, fVar.e());
            }
            b bVar = this.d;
            if (bVar != null) {
                bundle.putBundle(n, bVar.b());
            }
            if (!this.e.isEmpty()) {
                bundle.putParcelableArrayList(o, fm.h(this.e, new p81() { // from class: gg2
                    @Override // defpackage.p81
                    public final Object apply(Object obj) {
                        return ((bf4) obj).x();
                    }
                }));
            }
            String str2 = this.f;
            if (str2 != null) {
                bundle.putString(p, str2);
            }
            if (!this.g.isEmpty()) {
                bundle.putParcelableArrayList(q, fm.h(this.g, new p81() { // from class: hg2
                    @Override // defpackage.p81
                    public final Object apply(Object obj) {
                        return ((fg2.k) obj).c();
                    }
                }));
            }
            long j = this.j;
            if (j != -9223372036854775807L) {
                bundle.putLong(r, j);
            }
            return bundle;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return this.a.equals(hVar.a) && Objects.equals(this.b, hVar.b) && Objects.equals(this.c, hVar.c) && Objects.equals(this.d, hVar.d) && this.e.equals(hVar.e) && Objects.equals(this.f, hVar.f) && this.g.equals(hVar.g) && Objects.equals(this.i, hVar.i) && this.j == hVar.j;
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            String str = this.b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            f fVar = this.c;
            int iHashCode3 = (iHashCode2 + (fVar == null ? 0 : fVar.hashCode())) * 31;
            b bVar = this.d;
            int iHashCode4 = (((iHashCode3 + (bVar == null ? 0 : bVar.hashCode())) * 31) + this.e.hashCode()) * 31;
            String str2 = this.f;
            int iHashCode5 = (((iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.g.hashCode()) * 31;
            Object obj = this.i;
            return (int) ((((long) (iHashCode5 + (obj != null ? obj.hashCode() : 0))) * 31) + this.j);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class i {
        public static final i d = new a().d();
        public static final String e = fy4.N0(0);
        public static final String f = fy4.N0(1);
        public static final String g = fy4.N0(2);
        public final Uri a;
        public final String b;
        public final Bundle c;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class a {
            public Uri a;
            public String b;
            public Bundle c;

            public i d() {
                return new i(this);
            }

            public a e(Bundle bundle) {
                this.c = bundle;
                return this;
            }

            public a f(Uri uri) {
                this.a = uri;
                return this;
            }

            public a g(String str) {
                this.b = str;
                return this;
            }
        }

        public i(a aVar) {
            this.a = aVar.a;
            this.b = aVar.b;
            this.c = aVar.c;
        }

        public static i a(Bundle bundle) {
            return new a().f((Uri) bundle.getParcelable(e)).g(bundle.getString(f)).e(fy4.y(bundle.getBundle(g))).d();
        }

        public Bundle b() {
            Bundle bundle = new Bundle();
            Uri uri = this.a;
            if (uri != null) {
                bundle.putParcelable(e, uri);
            }
            String str = this.b;
            if (str != null) {
                bundle.putString(f, str);
            }
            Bundle bundle2 = this.c;
            if (bundle2 != null) {
                bundle.putBundle(g, bundle2);
            }
            return bundle;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            if (Objects.equals(this.a, iVar.a) && Objects.equals(this.b, iVar.b)) {
                if ((this.c == null) == (iVar.c == null)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            Uri uri = this.a;
            int iHashCode = (uri == null ? 0 : uri.hashCode()) * 31;
            String str = this.b;
            return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + (this.c != null ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class j extends k {
        public j(k.a aVar) {
            super(aVar);
        }
    }

    public fg2(String str, e eVar, h hVar, g gVar, ph2 ph2Var, i iVar) {
        this.a = str;
        this.b = hVar;
        this.c = hVar;
        this.d = gVar;
        this.e = ph2Var;
        this.f = eVar;
        this.g = eVar;
        this.h = iVar;
    }

    public static fg2 b(Bundle bundle, int i2) {
        String str = (String) gg3.q(bundle.getString(j, ""));
        Bundle bundle2 = bundle.getBundle(k);
        g gVarB = bundle2 == null ? g.f : g.b(bundle2);
        Bundle bundle3 = bundle.getBundle(l);
        ph2 ph2VarC = bundle3 == null ? ph2.M : ph2.c(bundle3, i2);
        Bundle bundle4 = bundle.getBundle(m);
        e eVarB = bundle4 == null ? e.r : d.b(bundle4);
        Bundle bundle5 = bundle.getBundle(n);
        i iVarA = bundle5 == null ? i.d : i.a(bundle5);
        Bundle bundle6 = bundle.getBundle(o);
        return new fg2(str, eVarB, bundle6 == null ? null : h.a(bundle6), gVarB, ph2VarC, iVarA);
    }

    public static fg2 c(Uri uri) {
        return new c().k(uri).a();
    }

    public static fg2 d(String str) {
        return new c().l(str).a();
    }

    public c a() {
        return new c();
    }

    public Bundle e(int i2) {
        return f(false, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fg2)) {
            return false;
        }
        fg2 fg2Var = (fg2) obj;
        return Objects.equals(this.a, fg2Var.a) && this.f.equals(fg2Var.f) && Objects.equals(this.b, fg2Var.b) && Objects.equals(this.d, fg2Var.d) && Objects.equals(this.e, fg2Var.e) && Objects.equals(this.h, fg2Var.h);
    }

    public final Bundle f(boolean z, int i2) {
        h hVar;
        Bundle bundle = new Bundle();
        if (!this.a.equals("")) {
            bundle.putString(j, this.a);
        }
        if (!this.d.equals(g.f)) {
            bundle.putBundle(k, this.d.c());
        }
        if (!this.e.equals(ph2.M)) {
            bundle.putBundle(l, this.e.f(i2));
        }
        if (!this.f.equals(d.i)) {
            bundle.putBundle(m, this.f.c());
        }
        if (!this.h.equals(i.d)) {
            bundle.putBundle(n, this.h.b());
        }
        if (z && (hVar = this.b) != null) {
            bundle.putBundle(o, hVar.b());
        }
        return bundle;
    }

    public Bundle g(int i2) {
        return f(true, i2);
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        h hVar = this.b;
        return ((((((((iHashCode + (hVar != null ? hVar.hashCode() : 0)) * 31) + this.d.hashCode()) * 31) + this.f.hashCode()) * 31) + this.e.hashCode()) * 31) + this.h.hashCode();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class g {
        public static final g f = new a().f();
        public static final String g = fy4.N0(0);
        public static final String h = fy4.N0(1);
        public static final String i = fy4.N0(2);
        public static final String j = fy4.N0(3);
        public static final String k = fy4.N0(4);
        public final long a;
        public final long b;
        public final long c;
        public final float d;
        public final float e;

        public g(a aVar) {
            this(aVar.a, aVar.b, aVar.c, aVar.d, aVar.e);
        }

        public static g b(Bundle bundle) {
            a aVar = new a();
            String str = g;
            g gVar = f;
            return aVar.k(bundle.getLong(str, gVar.a)).i(bundle.getLong(h, gVar.b)).g(bundle.getLong(i, gVar.c)).j(bundle.getFloat(j, gVar.d)).h(bundle.getFloat(k, gVar.e)).f();
        }

        public a a() {
            return new a();
        }

        public Bundle c() {
            Bundle bundle = new Bundle();
            long j2 = this.a;
            g gVar = f;
            if (j2 != gVar.a) {
                bundle.putLong(g, j2);
            }
            long j3 = this.b;
            if (j3 != gVar.b) {
                bundle.putLong(h, j3);
            }
            long j4 = this.c;
            if (j4 != gVar.c) {
                bundle.putLong(i, j4);
            }
            float f2 = this.d;
            if (f2 != gVar.d) {
                bundle.putFloat(j, f2);
            }
            float f3 = this.e;
            if (f3 != gVar.e) {
                bundle.putFloat(k, f3);
            }
            return bundle;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return this.a == gVar.a && this.b == gVar.b && this.c == gVar.c && this.d == gVar.d && this.e == gVar.e;
        }

        public int hashCode() {
            long j2 = this.a;
            long j3 = this.b;
            int i2 = ((((int) (j2 ^ (j2 >>> 32))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            long j4 = this.c;
            int i3 = (i2 + ((int) ((j4 >>> 32) ^ j4))) * 31;
            float f2 = this.d;
            int iFloatToIntBits = (i3 + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31;
            float f3 = this.e;
            return iFloatToIntBits + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0);
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class a {
            public long a;
            public long b;
            public long c;
            public float d;
            public float e;

            public a(g gVar) {
                this.a = gVar.a;
                this.b = gVar.b;
                this.c = gVar.c;
                this.d = gVar.d;
                this.e = gVar.e;
            }

            public g f() {
                return new g(this);
            }

            public a g(long j) {
                this.c = j;
                return this;
            }

            public a h(float f) {
                this.e = f;
                return this;
            }

            public a i(long j) {
                this.b = j;
                return this;
            }

            public a j(float f) {
                this.d = f;
                return this;
            }

            public a k(long j) {
                this.a = j;
                return this;
            }

            public a() {
                this.a = -9223372036854775807L;
                this.b = -9223372036854775807L;
                this.c = -9223372036854775807L;
                this.d = -3.4028235E38f;
                this.e = -3.4028235E38f;
            }
        }

        public g(long j2, long j3, long j4, float f2, float f3) {
            this.a = j2;
            this.b = j3;
            this.c = j4;
            this.d = f2;
            this.e = f3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d {
        public static final d i = new a().g();
        public static final String j = fy4.N0(0);
        public static final String k = fy4.N0(1);
        public static final String l = fy4.N0(2);
        public static final String m = fy4.N0(3);
        public static final String n = fy4.N0(4);
        public static final String o = fy4.N0(5);
        public static final String p = fy4.N0(6);
        public static final String q = fy4.N0(7);
        public final long a;
        public final long b;
        public final long c;
        public final long d;
        public final boolean e;
        public final boolean f;
        public final boolean g;
        public final boolean h;

        public d(a aVar) {
            this.a = fy4.S1(aVar.a);
            this.c = fy4.S1(aVar.b);
            this.b = aVar.a;
            this.d = aVar.b;
            this.e = aVar.c;
            this.f = aVar.d;
            this.g = aVar.e;
            this.h = aVar.f;
        }

        public static e b(Bundle bundle) {
            a aVar = new a();
            String str = j;
            d dVar = i;
            a aVarI = aVar.n(bundle.getLong(str, dVar.a)).j(bundle.getLong(k, dVar.c)).m(bundle.getBoolean(l, dVar.e)).l(bundle.getBoolean(m, dVar.f)).p(bundle.getBoolean(n, dVar.g)).i(bundle.getBoolean(q, dVar.h));
            long j2 = bundle.getLong(o, dVar.b);
            if (j2 != dVar.b) {
                aVarI.o(j2);
            }
            long j3 = bundle.getLong(p, dVar.d);
            if (j3 != dVar.d) {
                aVarI.k(j3);
            }
            return aVarI.h();
        }

        public a a() {
            return new a();
        }

        public Bundle c() {
            Bundle bundle = new Bundle();
            long j2 = this.a;
            d dVar = i;
            if (j2 != dVar.a) {
                bundle.putLong(j, j2);
            }
            long j3 = this.c;
            if (j3 != dVar.c) {
                bundle.putLong(k, j3);
            }
            long j4 = this.b;
            if (j4 != dVar.b) {
                bundle.putLong(o, j4);
            }
            long j5 = this.d;
            if (j5 != dVar.d) {
                bundle.putLong(p, j5);
            }
            boolean z = this.e;
            if (z != dVar.e) {
                bundle.putBoolean(l, z);
            }
            boolean z2 = this.f;
            if (z2 != dVar.f) {
                bundle.putBoolean(m, z2);
            }
            boolean z3 = this.g;
            if (z3 != dVar.g) {
                bundle.putBoolean(n, z3);
            }
            boolean z4 = this.h;
            if (z4 != dVar.h) {
                bundle.putBoolean(q, z4);
            }
            return bundle;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.b == dVar.b && this.d == dVar.d && this.e == dVar.e && this.f == dVar.f && this.g == dVar.g && this.h == dVar.h;
        }

        public int hashCode() {
            long j2 = this.b;
            int i2 = ((int) (j2 ^ (j2 >>> 32))) * 31;
            long j3 = this.d;
            return ((((((((i2 + ((int) ((j3 >>> 32) ^ j3))) * 31) + (this.e ? 1 : 0)) * 31) + (this.f ? 1 : 0)) * 31) + (this.g ? 1 : 0)) * 31) + (this.h ? 1 : 0);
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class a {
            public long a;
            public long b;
            public boolean c;
            public boolean d;
            public boolean e;
            public boolean f;

            public a(d dVar) {
                this.a = dVar.b;
                this.b = dVar.d;
                this.c = dVar.e;
                this.d = dVar.f;
                this.e = dVar.g;
                this.f = dVar.h;
            }

            public d g() {
                return new d(this);
            }

            public e h() {
                return new e(this);
            }

            public a i(boolean z) {
                this.f = z;
                return this;
            }

            public a j(long j) {
                return k(fy4.c1(j));
            }

            public a k(long j) {
                gg3.d(j == Long.MIN_VALUE || j >= 0);
                this.b = j;
                return this;
            }

            public a l(boolean z) {
                this.d = z;
                return this;
            }

            public a m(boolean z) {
                this.c = z;
                return this;
            }

            public a n(long j) {
                return o(fy4.c1(j));
            }

            public a o(long j) {
                gg3.d(j >= 0);
                this.a = j;
                return this;
            }

            public a p(boolean z) {
                this.e = z;
                return this;
            }

            public a() {
                this.b = Long.MIN_VALUE;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class k {
        public static final String h = fy4.N0(0);
        public static final String i = fy4.N0(1);
        public static final String j = fy4.N0(2);
        public static final String k = fy4.N0(3);
        public static final String l = fy4.N0(4);
        public static final String m = fy4.N0(5);
        public static final String n = fy4.N0(6);
        public final Uri a;
        public final String b;
        public final String c;
        public final int d;
        public final int e;
        public final String f;
        public final String g;

        public k(a aVar) {
            this.a = aVar.a;
            this.b = aVar.b;
            this.c = aVar.c;
            this.d = aVar.d;
            this.e = aVar.e;
            this.f = aVar.f;
            this.g = aVar.g;
        }

        public static k b(Bundle bundle) {
            Uri uri = (Uri) gg3.q((Uri) bundle.getParcelable(h));
            String string = bundle.getString(i);
            String string2 = bundle.getString(j);
            int i2 = bundle.getInt(k, 0);
            int i3 = bundle.getInt(l, 0);
            String string3 = bundle.getString(m);
            return new a(uri).n(string).m(string2).p(i2).o(i3).l(string3).k(bundle.getString(n)).i();
        }

        public a a() {
            return new a();
        }

        public Bundle c() {
            Bundle bundle = new Bundle();
            bundle.putParcelable(h, this.a);
            String str = this.b;
            if (str != null) {
                bundle.putString(i, str);
            }
            String str2 = this.c;
            if (str2 != null) {
                bundle.putString(j, str2);
            }
            int i2 = this.d;
            if (i2 != 0) {
                bundle.putInt(k, i2);
            }
            int i3 = this.e;
            if (i3 != 0) {
                bundle.putInt(l, i3);
            }
            String str3 = this.f;
            if (str3 != null) {
                bundle.putString(m, str3);
            }
            String str4 = this.g;
            if (str4 != null) {
                bundle.putString(n, str4);
            }
            return bundle;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            return this.a.equals(kVar.a) && Objects.equals(this.b, kVar.b) && Objects.equals(this.c, kVar.c) && this.d == kVar.d && this.e == kVar.e && Objects.equals(this.f, kVar.f) && Objects.equals(this.g, kVar.g);
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            String str = this.b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.c;
            int iHashCode3 = (((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.d) * 31) + this.e) * 31;
            String str3 = this.f;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.g;
            return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class a {
            public Uri a;
            public String b;
            public String c;
            public int d;
            public int e;
            public String f;
            public String g;

            public a(k kVar) {
                this.a = kVar.a;
                this.b = kVar.b;
                this.c = kVar.c;
                this.d = kVar.d;
                this.e = kVar.e;
                this.f = kVar.f;
                this.g = kVar.g;
            }

            public k i() {
                return new k(this);
            }

            public final j j() {
                return new j(this);
            }

            public a k(String str) {
                this.g = str;
                return this;
            }

            public a l(String str) {
                this.f = str;
                return this;
            }

            public a m(String str) {
                this.c = str;
                return this;
            }

            public a n(String str) {
                this.b = nt2.u(str);
                return this;
            }

            public a o(int i) {
                this.e = i;
                return this;
            }

            public a p(int i) {
                this.d = i;
                return this;
            }

            public a(Uri uri) {
                this.a = uri;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class f {
        public static final String l = fy4.N0(0);
        public static final String m = fy4.N0(1);
        public static final String n = fy4.N0(2);
        public static final String o = fy4.N0(3);
        public static final String p = fy4.N0(4);
        public static final String q = fy4.N0(5);
        public static final String r = fy4.N0(6);
        public static final String s = fy4.N0(7);
        public final UUID a;
        public final UUID b;
        public final Uri c;
        public final zi1 d;
        public final zi1 e;
        public final boolean f;
        public final boolean g;
        public final boolean h;
        public final xi1 i;
        public final xi1 j;
        public final byte[] k;

        public f(a aVar) {
            gg3.v((aVar.f && aVar.b == null) ? false : true);
            UUID uuid = (UUID) gg3.q(aVar.a);
            this.a = uuid;
            this.b = uuid;
            this.c = aVar.b;
            this.d = aVar.c;
            this.e = aVar.c;
            this.f = aVar.d;
            this.h = aVar.f;
            this.g = aVar.e;
            this.i = aVar.g;
            this.j = aVar.g;
            this.k = aVar.h != null ? Arrays.copyOf(aVar.h, aVar.h.length) : null;
        }

        public static f c(Bundle bundle) {
            UUID uuidFromString = UUID.fromString((String) gg3.q(bundle.getString(l)));
            Uri uri = (Uri) bundle.getParcelable(m);
            zi1 zi1VarB = fm.b(fm.e(bundle, n, Bundle.EMPTY));
            boolean z = bundle.getBoolean(o, false);
            boolean z2 = bundle.getBoolean(p, false);
            boolean z3 = bundle.getBoolean(q, false);
            xi1 xi1VarP = xi1.p(fm.f(bundle, r, new ArrayList()));
            return new a(uuidFromString).n(uri).m(zi1VarB).p(z).j(z3).q(z2).k(xi1VarP).l(bundle.getByteArray(s)).i();
        }

        public a b() {
            return new a();
        }

        public byte[] d() {
            byte[] bArr = this.k;
            if (bArr != null) {
                return Arrays.copyOf(bArr, bArr.length);
            }
            return null;
        }

        public Bundle e() {
            Bundle bundle = new Bundle();
            bundle.putString(l, this.a.toString());
            Uri uri = this.c;
            if (uri != null) {
                bundle.putParcelable(m, uri);
            }
            if (!this.e.isEmpty()) {
                bundle.putBundle(n, fm.g(this.e));
            }
            boolean z = this.f;
            if (z) {
                bundle.putBoolean(o, z);
            }
            boolean z2 = this.g;
            if (z2) {
                bundle.putBoolean(p, z2);
            }
            boolean z3 = this.h;
            if (z3) {
                bundle.putBoolean(q, z3);
            }
            if (!this.j.isEmpty()) {
                bundle.putIntegerArrayList(r, new ArrayList<>(this.j));
            }
            byte[] bArr = this.k;
            if (bArr != null) {
                bundle.putByteArray(s, bArr);
            }
            return bundle;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.a.equals(fVar.a) && Objects.equals(this.c, fVar.c) && Objects.equals(this.e, fVar.e) && this.f == fVar.f && this.h == fVar.h && this.g == fVar.g && this.j.equals(fVar.j) && Arrays.equals(this.k, fVar.k);
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            Uri uri = this.c;
            return ((((((((((((iHashCode + (uri != null ? uri.hashCode() : 0)) * 31) + this.e.hashCode()) * 31) + (this.f ? 1 : 0)) * 31) + (this.h ? 1 : 0)) * 31) + (this.g ? 1 : 0)) * 31) + this.j.hashCode()) * 31) + Arrays.hashCode(this.k);
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class a {
            public UUID a;
            public Uri b;
            public zi1 c;
            public boolean d;
            public boolean e;
            public boolean f;
            public xi1 g;
            public byte[] h;

            public a(f fVar) {
                this.a = fVar.a;
                this.b = fVar.c;
                this.c = fVar.e;
                this.d = fVar.f;
                this.e = fVar.g;
                this.f = fVar.h;
                this.g = fVar.j;
                this.h = fVar.k;
            }

            public f i() {
                return new f(this);
            }

            public a j(boolean z) {
                this.f = z;
                return this;
            }

            public a k(List list) {
                this.g = xi1.p(list);
                return this;
            }

            public a l(byte[] bArr) {
                this.h = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
                return this;
            }

            public a m(Map map) {
                this.c = zi1.c(map);
                return this;
            }

            public a n(Uri uri) {
                this.b = uri;
                return this;
            }

            public a o(String str) {
                this.b = str == null ? null : Uri.parse(str);
                return this;
            }

            public a p(boolean z) {
                this.d = z;
                return this;
            }

            public a q(boolean z) {
                this.e = z;
                return this;
            }

            public a(UUID uuid) {
                this();
                this.a = uuid;
            }

            public a() {
                this.c = zi1.j();
                this.e = true;
                this.g = xi1.u();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c {
        public String a;
        public Uri b;
        public String c;
        public d.a d;
        public f.a e;
        public List f;
        public String g;
        public xi1 h;
        public b i;
        public Object j;
        public long k;
        public ph2 l;
        public g.a m;
        public i n;

        public c(fg2 fg2Var) {
            this();
            this.d = fg2Var.f.a();
            this.a = fg2Var.a;
            this.l = fg2Var.e;
            this.m = fg2Var.d.a();
            this.n = fg2Var.h;
            h hVar = fg2Var.b;
            if (hVar != null) {
                this.g = hVar.f;
                this.c = hVar.b;
                this.b = hVar.a;
                this.f = hVar.e;
                this.h = hVar.g;
                this.j = hVar.i;
                f fVar = hVar.c;
                this.e = fVar != null ? fVar.b() : new f.a();
                this.i = hVar.d;
                this.k = hVar.j;
            }
        }

        public fg2 a() {
            h hVar;
            gg3.v(this.e.b == null || this.e.a != null);
            Uri uri = this.b;
            if (uri != null) {
                hVar = new h(uri, this.c, this.e.a != null ? this.e.i() : null, this.i, this.f, this.g, this.h, this.j, this.k);
            } else {
                hVar = null;
            }
            String str = this.a;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            e eVarH = this.d.h();
            g gVarF = this.m.f();
            ph2 ph2Var = this.l;
            if (ph2Var == null) {
                ph2Var = ph2.M;
            }
            return new fg2(str2, eVarH, hVar, gVarF, ph2Var, this.n);
        }

        public c b(f fVar) {
            this.e = fVar != null ? fVar.b() : new f.a();
            return this;
        }

        public c c(long j) {
            gg3.d(j > 0 || j == -9223372036854775807L);
            this.k = j;
            return this;
        }

        public c d(g gVar) {
            this.m = gVar.a();
            return this;
        }

        public c e(String str) {
            this.a = (String) gg3.q(str);
            return this;
        }

        public c f(ph2 ph2Var) {
            this.l = ph2Var;
            return this;
        }

        public c g(String str) {
            this.c = str;
            return this;
        }

        public c h(i iVar) {
            this.n = iVar;
            return this;
        }

        public c i(List list) {
            this.h = xi1.p(list);
            return this;
        }

        public c j(Object obj) {
            this.j = obj;
            return this;
        }

        public c k(Uri uri) {
            this.b = uri;
            return this;
        }

        public c l(String str) {
            return k(str == null ? null : Uri.parse(str));
        }

        public c() {
            this.d = new d.a();
            this.e = new f.a();
            this.f = Collections.EMPTY_LIST;
            this.h = xi1.u();
            this.m = new g.a();
            this.n = i.d;
            this.k = -9223372036854775807L;
        }
    }
}
