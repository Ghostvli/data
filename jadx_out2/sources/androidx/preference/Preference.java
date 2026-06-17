package androidx.preference;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import defpackage.dm3;
import defpackage.hn3;
import defpackage.jk3;
import defpackage.kg3;
import defpackage.lg3;
import defpackage.wu4;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Preference implements Comparable<Preference> {
    public boolean A;
    public boolean B;
    public boolean C;
    public int D;
    public int E;
    public List F;
    public b G;
    public final View.OnClickListener H;
    public final Context f;
    public int g;
    public int h;
    public CharSequence i;
    public CharSequence j;
    public int k;
    public String l;
    public Intent m;
    public String n;
    public boolean o;
    public boolean p;
    public boolean q;
    public String r;
    public Object s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements View.OnClickListener {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Preference.this.C(view);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        CharSequence a(Preference preference);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Preference(Context context, AttributeSet attributeSet, int i, int i2) {
        this.g = Integer.MAX_VALUE;
        this.h = 0;
        this.o = true;
        this.p = true;
        this.q = true;
        this.t = true;
        this.u = true;
        this.v = true;
        this.w = true;
        this.x = true;
        this.z = true;
        this.C = true;
        this.D = dm3.a;
        this.H = new a();
        this.f = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, hn3.H, i, i2);
        this.k = wu4.l(typedArrayObtainStyledAttributes, hn3.f0, hn3.I, 0);
        this.l = wu4.m(typedArrayObtainStyledAttributes, hn3.i0, hn3.O);
        this.i = wu4.n(typedArrayObtainStyledAttributes, hn3.q0, hn3.M);
        this.j = wu4.n(typedArrayObtainStyledAttributes, hn3.p0, hn3.P);
        this.g = wu4.d(typedArrayObtainStyledAttributes, hn3.k0, hn3.Q, Integer.MAX_VALUE);
        this.n = wu4.m(typedArrayObtainStyledAttributes, hn3.e0, hn3.V);
        this.D = wu4.l(typedArrayObtainStyledAttributes, hn3.j0, hn3.L, dm3.a);
        this.E = wu4.l(typedArrayObtainStyledAttributes, hn3.r0, hn3.R, 0);
        this.o = wu4.b(typedArrayObtainStyledAttributes, hn3.d0, hn3.K, true);
        this.p = wu4.b(typedArrayObtainStyledAttributes, hn3.m0, hn3.N, true);
        this.q = wu4.b(typedArrayObtainStyledAttributes, hn3.l0, hn3.J, true);
        this.r = wu4.m(typedArrayObtainStyledAttributes, hn3.b0, hn3.S);
        int i3 = hn3.Y;
        this.w = wu4.b(typedArrayObtainStyledAttributes, i3, i3, this.p);
        int i4 = hn3.Z;
        this.x = wu4.b(typedArrayObtainStyledAttributes, i4, i4, this.p);
        if (typedArrayObtainStyledAttributes.hasValue(hn3.a0)) {
            this.s = z(typedArrayObtainStyledAttributes, hn3.a0);
        } else if (typedArrayObtainStyledAttributes.hasValue(hn3.T)) {
            this.s = z(typedArrayObtainStyledAttributes, hn3.T);
        }
        this.C = wu4.b(typedArrayObtainStyledAttributes, hn3.n0, hn3.U, true);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(hn3.o0);
        this.y = zHasValue;
        if (zHasValue) {
            this.z = wu4.b(typedArrayObtainStyledAttributes, hn3.o0, hn3.W, true);
        }
        this.A = wu4.b(typedArrayObtainStyledAttributes, hn3.g0, hn3.X, false);
        int i5 = hn3.h0;
        this.v = wu4.b(typedArrayObtainStyledAttributes, i5, i5, true);
        int i6 = hn3.c0;
        this.B = wu4.b(typedArrayObtainStyledAttributes, i6, i6, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void A(Preference preference, boolean z) {
        if (this.u == z) {
            this.u = !z;
            w(H());
            v();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void B() {
        if (r() && t()) {
            x();
            m();
            if (this.m != null) {
                e().startActivity(this.m);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void C(View view) {
        B();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean D(boolean z) {
        if (!I()) {
            return false;
        }
        if (z == i(!z)) {
            return true;
        }
        l();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean E(int i) {
        if (!I()) {
            return false;
        }
        if (i == j(~i)) {
            return true;
        }
        l();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean F(String str) {
        if (!I()) {
            return false;
        }
        Object obj = null;
        if (TextUtils.equals(str, k(null))) {
            return true;
        }
        l();
        obj.getClass();
        throw null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void G(b bVar) {
        this.G = bVar;
        v();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean H() {
        return !r();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean I() {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean a(Object obj) {
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: compareTo(Ljava/lang/Object;)I */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(Preference preference) {
        int i = this.g;
        int i2 = preference.g;
        if (i != i2) {
            return i - i2;
        }
        CharSequence charSequence = this.i;
        CharSequence charSequence2 = preference.i;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference.i.toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Context e() {
        return this.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public StringBuilder f() {
        StringBuilder sb = new StringBuilder();
        CharSequence charSequenceP = p();
        if (!TextUtils.isEmpty(charSequenceP)) {
            sb.append(charSequenceP);
            sb.append(' ');
        }
        CharSequence charSequenceN = n();
        if (!TextUtils.isEmpty(charSequenceN)) {
            sb.append(charSequenceN);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String g() {
        return this.n;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Intent h() {
        return this.m;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean i(boolean z) {
        if (!I()) {
            return z;
        }
        l();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int j(int i) {
        if (!I()) {
            return i;
        }
        l();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String k(String str) {
        if (!I()) {
            return str;
        }
        l();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public kg3 l() {
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public lg3 m() {
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public CharSequence n() {
        return o() != null ? o().a(this) : this.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final b o() {
        return this.G;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public CharSequence p() {
        return this.i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean q() {
        return !TextUtils.isEmpty(this.l);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean r() {
        return this.o && this.t && this.u;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean t() {
        return this.p;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return f().toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void v() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void w(boolean z) {
        List list = this.F;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((Preference) list.get(i)).y(this, z);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void x() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void y(Preference preference, boolean z) {
        if (this.t == z) {
            this.t = !z;
            w(H());
            v();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object z(TypedArray typedArray, int i) {
        return null;
    }

    public Preference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, wu4.a(context, jk3.g, R.attr.preferenceStyle));
    }
}
