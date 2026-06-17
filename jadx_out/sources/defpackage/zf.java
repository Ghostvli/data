package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class zf {
    public final a a;
    public final a b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public final float g;
    public final float h;
    public final int i;
    public final int j;
    public int k;
    public int l;

    public zf(Context context, int i, int i2, int i3, a aVar) {
        a aVar2 = new a();
        this.b = aVar2;
        aVar = aVar == null ? new a() : aVar;
        if (i != 0) {
            aVar.f = i;
        }
        TypedArray typedArrayA = a(context, aVar.f, i2, i3);
        Resources resources = context.getResources();
        this.c = typedArrayA.getDimensionPixelSize(cn3.u, -1);
        this.i = context.getResources().getDimensionPixelSize(zk3.W);
        this.j = context.getResources().getDimensionPixelSize(zk3.Y);
        this.d = typedArrayA.getDimensionPixelSize(cn3.E, -1);
        this.e = typedArrayA.getDimension(cn3.C, resources.getDimension(zk3.t));
        this.g = typedArrayA.getDimension(cn3.H, resources.getDimension(zk3.u));
        this.f = typedArrayA.getDimension(cn3.t, resources.getDimension(zk3.t));
        this.h = typedArrayA.getDimension(cn3.D, resources.getDimension(zk3.u));
        boolean z = true;
        this.k = typedArrayA.getInt(cn3.O, 1);
        this.l = typedArrayA.getInt(cn3.r, 0);
        aVar2.n = aVar.n == -2 ? 255 : aVar.n;
        if (aVar.p != -2) {
            aVar2.p = aVar.p;
        } else if (typedArrayA.hasValue(cn3.N)) {
            aVar2.p = typedArrayA.getInt(cn3.N, 0);
        } else {
            aVar2.p = -1;
        }
        if (aVar.o != null) {
            aVar2.o = aVar.o;
        } else if (typedArrayA.hasValue(cn3.x)) {
            aVar2.o = typedArrayA.getString(cn3.x);
        }
        aVar2.t = aVar.t;
        aVar2.u = aVar.u == null ? context.getString(tm3.o) : aVar.u;
        aVar2.v = aVar.v == 0 ? km3.a : aVar.v;
        aVar2.w = aVar.w == 0 ? tm3.t : aVar.w;
        if (aVar.y != null && !aVar.y.booleanValue()) {
            z = false;
        }
        aVar2.y = Boolean.valueOf(z);
        aVar2.q = aVar.q == -2 ? typedArrayA.getInt(cn3.L, -2) : aVar.q;
        aVar2.r = aVar.r == -2 ? typedArrayA.getInt(cn3.M, -2) : aVar.r;
        aVar2.j = Integer.valueOf(aVar.j == null ? typedArrayA.getResourceId(cn3.v, ym3.e) : aVar.j.intValue());
        aVar2.k = Integer.valueOf(aVar.k == null ? typedArrayA.getResourceId(cn3.w, 0) : aVar.k.intValue());
        aVar2.l = Integer.valueOf(aVar.l == null ? typedArrayA.getResourceId(cn3.F, ym3.e) : aVar.l.intValue());
        aVar2.m = Integer.valueOf(aVar.m == null ? typedArrayA.getResourceId(cn3.G, 0) : aVar.m.intValue());
        aVar2.g = Integer.valueOf(aVar.g == null ? H(context, typedArrayA, cn3.q) : aVar.g.intValue());
        aVar2.i = Integer.valueOf(aVar.i == null ? typedArrayA.getResourceId(cn3.y, ym3.g) : aVar.i.intValue());
        if (aVar.h != null) {
            aVar2.h = aVar.h;
        } else if (typedArrayA.hasValue(cn3.z)) {
            aVar2.h = Integer.valueOf(H(context, typedArrayA, cn3.z));
        } else {
            aVar2.h = Integer.valueOf(new bm4(context, aVar2.i.intValue()).k().getDefaultColor());
        }
        aVar2.x = Integer.valueOf(aVar.x == null ? typedArrayA.getInt(cn3.s, 8388661) : aVar.x.intValue());
        aVar2.z = Integer.valueOf(aVar.z == null ? typedArrayA.getDimensionPixelSize(cn3.B, resources.getDimensionPixelSize(zk3.X)) : aVar.z.intValue());
        aVar2.A = Integer.valueOf(aVar.A == null ? typedArrayA.getDimensionPixelSize(cn3.A, resources.getDimensionPixelSize(zk3.v)) : aVar.A.intValue());
        aVar2.B = Integer.valueOf(aVar.B == null ? typedArrayA.getDimensionPixelOffset(cn3.I, 0) : aVar.B.intValue());
        aVar2.C = Integer.valueOf(aVar.C == null ? typedArrayA.getDimensionPixelOffset(cn3.P, 0) : aVar.C.intValue());
        aVar2.D = Integer.valueOf(aVar.D == null ? typedArrayA.getDimensionPixelOffset(cn3.J, aVar2.B.intValue()) : aVar.D.intValue());
        aVar2.E = Integer.valueOf(aVar.E == null ? typedArrayA.getDimensionPixelOffset(cn3.Q, aVar2.C.intValue()) : aVar.E.intValue());
        aVar2.H = Integer.valueOf(aVar.H == null ? typedArrayA.getDimensionPixelOffset(cn3.K, 0) : aVar.H.intValue());
        aVar2.F = Integer.valueOf(aVar.F == null ? 0 : aVar.F.intValue());
        aVar2.G = Integer.valueOf(aVar.G == null ? 0 : aVar.G.intValue());
        aVar2.I = Boolean.valueOf(aVar.I == null ? typedArrayA.getBoolean(cn3.p, false) : aVar.I.booleanValue());
        typedArrayA.recycle();
        if (aVar.s == null) {
            aVar2.s = Locale.getDefault(Locale.Category.FORMAT);
        } else {
            aVar2.s = aVar.s;
        }
        this.a = aVar;
    }

    public static int H(Context context, TypedArray typedArray, int i) {
        return k62.b(context, typedArray, i).getDefaultColor();
    }

    public int A() {
        return this.b.i.intValue();
    }

    public int B() {
        return this.b.E.intValue();
    }

    public int C() {
        return this.b.C.intValue();
    }

    public boolean D() {
        return this.b.p != -1;
    }

    public boolean E() {
        return this.b.o != null;
    }

    public boolean F() {
        return this.b.I.booleanValue();
    }

    public boolean G() {
        return this.b.y.booleanValue();
    }

    public void I(int i) {
        this.a.n = i;
        this.b.n = i;
    }

    public final TypedArray a(Context context, int i, int i2, int i3) {
        AttributeSet attributeSetI;
        int styleAttribute;
        if (i != 0) {
            attributeSetI = go0.i(context, i, "badge");
            styleAttribute = attributeSetI.getStyleAttribute();
        } else {
            attributeSetI = null;
            styleAttribute = 0;
        }
        return dn4.i(context, attributeSetI, cn3.o, i2, styleAttribute == 0 ? i3 : styleAttribute, new int[0]);
    }

    public int b() {
        return this.b.F.intValue();
    }

    public int c() {
        return this.b.G.intValue();
    }

    public int d() {
        return this.b.n;
    }

    public int e() {
        return this.b.g.intValue();
    }

    public int f() {
        return this.b.x.intValue();
    }

    public int g() {
        return this.b.z.intValue();
    }

    public int h() {
        return this.b.k.intValue();
    }

    public int i() {
        return this.b.j.intValue();
    }

    public int j() {
        return this.b.h.intValue();
    }

    public int k() {
        return this.b.A.intValue();
    }

    public int l() {
        return this.b.m.intValue();
    }

    public int m() {
        return this.b.l.intValue();
    }

    public int n() {
        return this.b.w;
    }

    public CharSequence o() {
        return this.b.t;
    }

    public CharSequence p() {
        return this.b.u;
    }

    public int q() {
        return this.b.v;
    }

    public int r() {
        return this.b.D.intValue();
    }

    public int s() {
        return this.b.B.intValue();
    }

    public int t() {
        return this.b.H.intValue();
    }

    public int u() {
        return this.b.q;
    }

    public int v() {
        return this.b.r;
    }

    public int w() {
        return this.b.p;
    }

    public Locale x() {
        return this.b.s;
    }

    public a y() {
        return this.a;
    }

    public String z() {
        return this.b.o;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements Parcelable {
        public static final Parcelable.Creator<a> CREATOR = new C0143a();
        public Integer A;
        public Integer B;
        public Integer C;
        public Integer D;
        public Integer E;
        public Integer F;
        public Integer G;
        public Integer H;
        public Boolean I;
        public Integer J;
        public int f;
        public Integer g;
        public Integer h;
        public Integer i;
        public Integer j;
        public Integer k;
        public Integer l;
        public Integer m;
        public int n;
        public String o;
        public int p;
        public int q;
        public int r;
        public Locale s;
        public CharSequence t;
        public CharSequence u;
        public int v;
        public int w;
        public Integer x;
        public Boolean y;
        public Integer z;

        /* JADX INFO: renamed from: zf$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class C0143a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public a[] newArray(int i) {
                return new a[i];
            }
        }

        public a(Parcel parcel) {
            this.n = 255;
            this.p = -2;
            this.q = -2;
            this.r = -2;
            this.y = Boolean.TRUE;
            this.f = parcel.readInt();
            this.g = (Integer) parcel.readSerializable();
            this.h = (Integer) parcel.readSerializable();
            this.i = (Integer) parcel.readSerializable();
            this.j = (Integer) parcel.readSerializable();
            this.k = (Integer) parcel.readSerializable();
            this.l = (Integer) parcel.readSerializable();
            this.m = (Integer) parcel.readSerializable();
            this.n = parcel.readInt();
            this.o = parcel.readString();
            this.p = parcel.readInt();
            this.q = parcel.readInt();
            this.r = parcel.readInt();
            this.t = parcel.readString();
            this.u = parcel.readString();
            this.v = parcel.readInt();
            this.x = (Integer) parcel.readSerializable();
            this.z = (Integer) parcel.readSerializable();
            this.A = (Integer) parcel.readSerializable();
            this.B = (Integer) parcel.readSerializable();
            this.C = (Integer) parcel.readSerializable();
            this.D = (Integer) parcel.readSerializable();
            this.E = (Integer) parcel.readSerializable();
            this.H = (Integer) parcel.readSerializable();
            this.F = (Integer) parcel.readSerializable();
            this.G = (Integer) parcel.readSerializable();
            this.y = (Boolean) parcel.readSerializable();
            this.s = (Locale) parcel.readSerializable();
            this.I = (Boolean) parcel.readSerializable();
            this.J = (Integer) parcel.readSerializable();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f);
            parcel.writeSerializable(this.g);
            parcel.writeSerializable(this.h);
            parcel.writeSerializable(this.i);
            parcel.writeSerializable(this.j);
            parcel.writeSerializable(this.k);
            parcel.writeSerializable(this.l);
            parcel.writeSerializable(this.m);
            parcel.writeInt(this.n);
            parcel.writeString(this.o);
            parcel.writeInt(this.p);
            parcel.writeInt(this.q);
            parcel.writeInt(this.r);
            CharSequence charSequence = this.t;
            parcel.writeString(charSequence != null ? charSequence.toString() : null);
            CharSequence charSequence2 = this.u;
            parcel.writeString(charSequence2 != null ? charSequence2.toString() : null);
            parcel.writeInt(this.v);
            parcel.writeSerializable(this.x);
            parcel.writeSerializable(this.z);
            parcel.writeSerializable(this.A);
            parcel.writeSerializable(this.B);
            parcel.writeSerializable(this.C);
            parcel.writeSerializable(this.D);
            parcel.writeSerializable(this.E);
            parcel.writeSerializable(this.H);
            parcel.writeSerializable(this.F);
            parcel.writeSerializable(this.G);
            parcel.writeSerializable(this.y);
            parcel.writeSerializable(this.s);
            parcel.writeSerializable(this.I);
            parcel.writeSerializable(this.J);
        }

        public a() {
            this.n = 255;
            this.p = -2;
            this.q = -2;
            this.r = -2;
            this.y = Boolean.TRUE;
        }
    }
}
