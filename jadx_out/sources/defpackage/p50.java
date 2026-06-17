package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class p50 {
    public final CharSequence a;
    public final Layout.Alignment b;
    public final Layout.Alignment c;
    public final Bitmap d;
    public final float e;
    public final int f;
    public final int g;
    public final float h;
    public final int i;
    public final float j;
    public final float k;
    public final boolean l;
    public final int m;
    public final int n;
    public final float o;
    public final int p;
    public final float q;
    public final int r;
    public static final p50 s = new b().o("").a();
    public static final String t = fy4.N0(0);
    public static final String u = fy4.N0(17);
    public static final String v = fy4.N0(1);
    public static final String w = fy4.N0(2);
    public static final String x = fy4.N0(3);
    public static final String y = fy4.N0(18);
    public static final String z = fy4.N0(4);
    public static final String A = fy4.N0(5);
    public static final String B = fy4.N0(6);
    public static final String C = fy4.N0(7);
    public static final String D = fy4.N0(8);
    public static final String E = fy4.N0(9);
    public static final String F = fy4.N0(10);
    public static final String G = fy4.N0(11);
    public static final String H = fy4.N0(12);
    public static final String I = fy4.N0(13);
    public static final String J = fy4.N0(14);
    public static final String K = fy4.N0(15);
    public static final String L = fy4.N0(16);
    public static final String M = fy4.N0(19);

    public p50(CharSequence charSequence, Layout.Alignment alignment, Layout.Alignment alignment2, Bitmap bitmap, float f, int i, int i2, float f2, int i3, int i4, float f3, float f4, float f5, boolean z2, int i5, int i6, float f6, int i7) {
        if (charSequence == null) {
            gg3.q(bitmap);
        } else {
            gg3.d(bitmap == null);
        }
        if (charSequence instanceof Spanned) {
            this.a = SpannedString.valueOf(charSequence);
        } else if (charSequence != null) {
            this.a = charSequence.toString();
        } else {
            this.a = null;
        }
        this.b = alignment;
        this.c = alignment2;
        this.d = bitmap;
        this.e = f;
        this.f = i;
        this.g = i2;
        this.h = f2;
        this.i = i3;
        this.j = f4;
        this.k = f5;
        this.l = z2;
        this.m = i5;
        this.n = i4;
        this.o = f3;
        this.p = i6;
        this.q = f6;
        this.r = i7;
    }

    public static p50 b(Bundle bundle) {
        b bVar = new b();
        CharSequence charSequence = bundle.getCharSequence(t);
        if (charSequence != null) {
            bVar.o(charSequence);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(u);
            if (parcelableArrayList != null) {
                SpannableString spannableStringValueOf = SpannableString.valueOf(charSequence);
                Iterator it = parcelableArrayList.iterator();
                while (it.hasNext()) {
                    u60.c((Bundle) it.next(), spannableStringValueOf);
                }
                bVar.o(spannableStringValueOf);
            }
        }
        Layout.Alignment alignment = (Layout.Alignment) bundle.getSerializable(v);
        if (alignment != null) {
            bVar.p(alignment);
        }
        Layout.Alignment alignment2 = (Layout.Alignment) bundle.getSerializable(w);
        if (alignment2 != null) {
            bVar.j(alignment2);
        }
        Bitmap bitmap = (Bitmap) bundle.getParcelable(x);
        if (bitmap != null) {
            bVar.f(bitmap);
        } else {
            byte[] byteArray = bundle.getByteArray(y);
            if (byteArray != null) {
                bVar.f(BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length));
            }
        }
        String str = z;
        if (bundle.containsKey(str)) {
            String str2 = A;
            if (bundle.containsKey(str2)) {
                bVar.h(bundle.getFloat(str), bundle.getInt(str2));
            }
        }
        String str3 = B;
        if (bundle.containsKey(str3)) {
            bVar.i(bundle.getInt(str3));
        }
        String str4 = C;
        if (bundle.containsKey(str4)) {
            bVar.k(bundle.getFloat(str4));
        }
        String str5 = D;
        if (bundle.containsKey(str5)) {
            bVar.l(bundle.getInt(str5));
        }
        String str6 = F;
        if (bundle.containsKey(str6)) {
            String str7 = E;
            if (bundle.containsKey(str7)) {
                bVar.q(bundle.getFloat(str6), bundle.getInt(str7));
            }
        }
        String str8 = G;
        if (bundle.containsKey(str8)) {
            bVar.n(bundle.getFloat(str8));
        }
        String str9 = H;
        if (bundle.containsKey(str9)) {
            bVar.g(bundle.getFloat(str9));
        }
        String str10 = I;
        if (bundle.containsKey(str10)) {
            bVar.s(bundle.getInt(str10));
        }
        if (!bundle.getBoolean(J, false)) {
            bVar.b();
        }
        String str11 = K;
        if (bundle.containsKey(str11)) {
            bVar.r(bundle.getInt(str11));
        }
        String str12 = L;
        if (bundle.containsKey(str12)) {
            bVar.m(bundle.getFloat(str12));
        }
        String str13 = M;
        if (bundle.containsKey(str13)) {
            bVar.t(bundle.getInt(str13));
        }
        return bVar.a();
    }

    public b a() {
        return new b();
    }

    public Bundle c() {
        Bundle bundleD = d();
        Bitmap bitmap = this.d;
        if (bitmap != null) {
            bundleD.putParcelable(x, bitmap);
        }
        return bundleD;
    }

    public final Bundle d() {
        Bundle bundle = new Bundle();
        CharSequence charSequence = this.a;
        if (charSequence != null) {
            bundle.putCharSequence(t, charSequence);
            CharSequence charSequence2 = this.a;
            if (charSequence2 instanceof Spanned) {
                ArrayList<? extends Parcelable> arrayListA = u60.a((Spanned) charSequence2);
                if (!arrayListA.isEmpty()) {
                    bundle.putParcelableArrayList(u, arrayListA);
                }
            }
        }
        bundle.putSerializable(v, this.b);
        bundle.putSerializable(w, this.c);
        bundle.putFloat(z, this.e);
        bundle.putInt(A, this.f);
        bundle.putInt(B, this.g);
        bundle.putFloat(C, this.h);
        bundle.putInt(D, this.i);
        bundle.putInt(E, this.n);
        bundle.putFloat(F, this.o);
        bundle.putFloat(G, this.j);
        bundle.putFloat(H, this.k);
        bundle.putBoolean(J, this.l);
        bundle.putInt(I, this.m);
        bundle.putInt(K, this.p);
        bundle.putFloat(L, this.q);
        bundle.putInt(M, this.r);
        return bundle;
    }

    public Bundle e() {
        Bundle bundleD = d();
        if (this.d != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            gg3.v(this.d.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream));
            bundleD.putByteArray(y, byteArrayOutputStream.toByteArray());
        }
        return bundleD;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && p50.class == obj.getClass()) {
            p50 p50Var = (p50) obj;
            if (TextUtils.equals(this.a, p50Var.a) && this.b == p50Var.b && this.c == p50Var.c) {
                Bitmap bitmap = this.d;
                Bitmap bitmap2 = p50Var.d;
                if (bitmap != null ? !(bitmap2 == null || !bitmap.sameAs(bitmap2)) : bitmap2 == null) {
                    if (this.e == p50Var.e && this.f == p50Var.f && this.g == p50Var.g && this.h == p50Var.h && this.i == p50Var.i && this.j == p50Var.j && this.k == p50Var.k && this.l == p50Var.l && this.m == p50Var.m && this.n == p50Var.n && this.o == p50Var.o && this.p == p50Var.p && this.q == p50Var.q && this.r == p50Var.r) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.a, this.b, this.c, this.d, Float.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(this.g), Float.valueOf(this.h), Integer.valueOf(this.i), Float.valueOf(this.j), Float.valueOf(this.k), Boolean.valueOf(this.l), Integer.valueOf(this.m), Integer.valueOf(this.n), Float.valueOf(this.o), Integer.valueOf(this.p), Float.valueOf(this.q), Integer.valueOf(this.r));
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public CharSequence a;
        public Bitmap b;
        public Layout.Alignment c;
        public Layout.Alignment d;
        public float e;
        public int f;
        public int g;
        public float h;
        public int i;
        public int j;
        public float k;
        public float l;
        public float m;
        public boolean n;
        public int o;
        public int p;
        public float q;
        public int r;

        public b(p50 p50Var) {
            this.a = p50Var.a;
            this.b = p50Var.d;
            this.c = p50Var.b;
            this.d = p50Var.c;
            this.e = p50Var.e;
            this.f = p50Var.f;
            this.g = p50Var.g;
            this.h = p50Var.h;
            this.i = p50Var.i;
            this.j = p50Var.n;
            this.k = p50Var.o;
            this.l = p50Var.j;
            this.m = p50Var.k;
            this.n = p50Var.l;
            this.o = p50Var.m;
            this.p = p50Var.p;
            this.q = p50Var.q;
            this.r = p50Var.r;
        }

        public p50 a() {
            return new p50(this.a, this.c, this.d, this.b, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r);
        }

        public b b() {
            this.n = false;
            return this;
        }

        public int c() {
            return this.g;
        }

        public int d() {
            return this.i;
        }

        public CharSequence e() {
            return this.a;
        }

        public b f(Bitmap bitmap) {
            this.b = bitmap;
            this.a = null;
            return this;
        }

        public b g(float f) {
            this.m = f;
            return this;
        }

        public b h(float f, int i) {
            this.e = f;
            this.f = i;
            return this;
        }

        public b i(int i) {
            this.g = i;
            return this;
        }

        public b j(Layout.Alignment alignment) {
            this.d = alignment;
            return this;
        }

        public b k(float f) {
            this.h = f;
            return this;
        }

        public b l(int i) {
            this.i = i;
            return this;
        }

        public b m(float f) {
            this.q = f;
            return this;
        }

        public b n(float f) {
            this.l = f;
            return this;
        }

        public b o(CharSequence charSequence) {
            this.a = charSequence;
            this.b = null;
            return this;
        }

        public b p(Layout.Alignment alignment) {
            this.c = alignment;
            return this;
        }

        public b q(float f, int i) {
            this.k = f;
            this.j = i;
            return this;
        }

        public b r(int i) {
            this.p = i;
            return this;
        }

        public b s(int i) {
            this.o = i;
            this.n = true;
            return this;
        }

        public b t(int i) {
            this.r = i;
            return this;
        }

        public b() {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = -3.4028235E38f;
            this.f = Integer.MIN_VALUE;
            this.g = Integer.MIN_VALUE;
            this.h = -3.4028235E38f;
            this.i = Integer.MIN_VALUE;
            this.j = Integer.MIN_VALUE;
            this.k = -3.4028235E38f;
            this.l = -3.4028235E38f;
            this.m = -3.4028235E38f;
            this.n = false;
            this.o = -16777216;
            this.p = Integer.MIN_VALUE;
        }
    }
}
