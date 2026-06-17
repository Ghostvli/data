package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.focus.FocusRingDrawable;
import defpackage.l62;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class c62 {
    public final MaterialButton a;
    public x44 b;
    public ed4 c;
    public l62.d d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public PorterDuff.Mode k;
    public ColorStateList l;
    public ColorStateList m;
    public ColorStateList n;
    public Drawable o;
    public boolean s;
    public RippleDrawable u;
    public int v;
    public boolean p = false;
    public boolean q = false;
    public boolean r = false;
    public boolean t = true;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public c62(MaterialButton materialButton, x44 x44Var) {
        this.a = materialButton;
        this.b = x44Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void A(int i) {
        K(this.g, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void B(int i) {
        K(i, this.h);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void C(ColorStateList colorStateList) {
        if (this.n != colorStateList) {
            this.n = colorStateList;
            if (this.a.getBackground() instanceof RippleDrawable) {
                ((RippleDrawable) this.a.getBackground()).setColor(wt3.d(colorStateList));
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void D(x44 x44Var) {
        this.b = x44Var;
        M();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void E(boolean z) {
        this.p = z;
        N();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void F(ColorStateList colorStateList) {
        if (this.m != colorStateList) {
            this.m = colorStateList;
            N();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void G(int i) {
        if (this.j != i) {
            this.j = i;
            N();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void H(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            if (g() != null) {
                g().setTintList(this.l);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void I(PorterDuff.Mode mode) {
        if (this.k != mode) {
            this.k = mode;
            if (g() == null || this.k == null) {
                return;
            }
            g().setTintMode(this.k);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void J(boolean z) {
        this.t = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void K(int i, int i2) {
        int paddingStart = this.a.getPaddingStart();
        int paddingTop = this.a.getPaddingTop();
        int paddingEnd = this.a.getPaddingEnd();
        int paddingBottom = this.a.getPaddingBottom();
        int i3 = this.g;
        int i4 = this.h;
        this.h = i2;
        this.g = i;
        if (!this.q) {
            L();
        }
        this.a.setPaddingRelative(paddingStart, (paddingTop + i) - i3, paddingEnd, (paddingBottom + i2) - i4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void L() {
        this.a.setInternalBackground(a());
        l62 l62VarG = g();
        if (l62VarG != null) {
            l62VarG.d0(this.v);
            l62VarG.setState(this.a.getDrawableState());
        }
        FocusRingDrawable focusRingDrawableL = FocusRingDrawable.l(this.a.getBackground());
        if (focusRingDrawableL != null) {
            focusRingDrawableL.y(l62VarG);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void M() {
        l62 l62VarG = g();
        if (l62VarG != null) {
            l62VarG.k0(this.b);
            ed4 ed4Var = this.c;
            if (ed4Var != null) {
                l62VarG.c0(ed4Var);
            }
        }
        l62 l62VarP = p();
        if (l62VarP != null) {
            l62VarP.k0(this.b);
            ed4 ed4Var2 = this.c;
            if (ed4Var2 != null) {
                l62VarP.c0(ed4Var2);
            }
        }
        r54 r54VarF = f();
        if (r54VarF != null) {
            if (!(r54VarF instanceof l62)) {
                r54VarF.setShapeAppearanceModel(this.b.c());
                return;
            }
            l62 l62Var = (l62) r54VarF;
            l62Var.k0(this.b);
            ed4 ed4Var3 = this.c;
            if (ed4Var3 != null) {
                l62Var.c0(ed4Var3);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void N() {
        l62 l62VarG = g();
        l62 l62VarP = p();
        if (l62VarG != null) {
            l62VarG.n0(this.j, this.m);
            if (l62VarP != null) {
                l62VarP.m0(this.j, this.p ? h62.d(this.a, mk3.l) : 0);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final InsetDrawable O(Drawable drawable) {
        return new InsetDrawable(drawable, this.e, this.g, this.f, this.h);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Drawable a() {
        l62 l62Var = new l62(this.b);
        ed4 ed4Var = this.c;
        if (ed4Var != null) {
            l62Var.c0(ed4Var);
        }
        l62.d dVar = this.d;
        if (dVar != null) {
            l62Var.g0(dVar);
        }
        Context context = this.a.getContext();
        l62Var.S(context);
        l62Var.setTintList(this.l);
        PorterDuff.Mode mode = this.k;
        if (mode != null) {
            l62Var.setTintMode(mode);
        }
        l62Var.n0(this.j, this.m);
        l62 l62Var2 = new l62(this.b);
        ed4 ed4Var2 = this.c;
        if (ed4Var2 != null) {
            l62Var2.c0(ed4Var2);
        }
        l62Var2.setTint(0);
        l62Var2.m0(this.j, this.p ? h62.d(this.a, mk3.l) : 0);
        l62 l62Var3 = new l62(this.b);
        this.o = l62Var3;
        ed4 ed4Var3 = this.c;
        if (ed4Var3 != null) {
            l62Var3.c0(ed4Var3);
        }
        this.o.setTint(-1);
        RippleDrawable rippleDrawable = new RippleDrawable(wt3.d(this.n), O(new LayerDrawable(new Drawable[]{l62Var2, l62Var})), this.o);
        this.u = rippleDrawable;
        FocusRingDrawable.s(context, rippleDrawable);
        return this.u;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int b() {
        return this.i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ed4 c() {
        return this.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int d() {
        return this.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int e() {
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public r54 f() {
        RippleDrawable rippleDrawable = this.u;
        if (rippleDrawable == null) {
            return null;
        }
        Object objFindDrawableByLayerId = rippleDrawable.findDrawableByLayerId(R.id.mask);
        if (objFindDrawableByLayerId instanceof r54) {
            return (r54) objFindDrawableByLayerId;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public l62 g() {
        return h(false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final l62 h(boolean z) {
        RippleDrawable rippleDrawable = this.u;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (l62) ((LayerDrawable) ((InsetDrawable) this.u.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ColorStateList i() {
        return this.n;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public x44 j() {
        return this.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public y44 k() {
        return this.b.c();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ColorStateList l() {
        return this.m;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int m() {
        return this.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ColorStateList n() {
        return this.l;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PorterDuff.Mode o() {
        return this.k;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final l62 p() {
        return h(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean q() {
        return this.q;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean r() {
        return this.s;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean s() {
        return this.t;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void t(TypedArray typedArray) {
        this.e = typedArray.getDimensionPixelOffset(cn3.Y2, 0);
        this.f = typedArray.getDimensionPixelOffset(cn3.Z2, 0);
        this.g = typedArray.getDimensionPixelOffset(cn3.a3, 0);
        this.h = typedArray.getDimensionPixelOffset(cn3.b3, 0);
        if (typedArray.hasValue(cn3.f3)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(cn3.f3, -1);
            this.i = dimensionPixelSize;
            D(this.b.a(dimensionPixelSize));
            this.r = true;
        }
        this.j = typedArray.getDimensionPixelSize(cn3.v3, 0);
        this.k = e55.g(typedArray.getInt(cn3.e3, -1), PorterDuff.Mode.SRC_IN);
        this.l = k62.b(this.a.getContext(), typedArray, cn3.d3);
        this.m = k62.b(this.a.getContext(), typedArray, cn3.u3);
        this.n = k62.b(this.a.getContext(), typedArray, cn3.o3);
        this.s = typedArray.getBoolean(cn3.c3, false);
        this.v = typedArray.getDimensionPixelSize(cn3.g3, 0);
        this.t = typedArray.getBoolean(cn3.w3, true);
        int paddingStart = this.a.getPaddingStart();
        int paddingTop = this.a.getPaddingTop();
        int paddingEnd = this.a.getPaddingEnd();
        int paddingBottom = this.a.getPaddingBottom();
        if (typedArray.hasValue(cn3.W2)) {
            v();
        } else {
            L();
        }
        this.a.setPaddingRelative(paddingStart + this.e, paddingTop + this.g, paddingEnd + this.f, paddingBottom + this.h);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void u(int i) {
        if (g() != null) {
            g().setTint(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void v() {
        this.q = true;
        this.a.setSupportBackgroundTintList(this.l);
        this.a.setSupportBackgroundTintMode(this.k);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void w(boolean z) {
        this.s = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void x(int i) {
        if (this.r && this.i == i) {
            return;
        }
        this.i = i;
        this.r = true;
        D(this.b.a(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void y(l62.d dVar) {
        this.d = dVar;
        l62 l62VarG = g();
        if (l62VarG != null) {
            l62VarG.g0(dVar);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void z(ed4 ed4Var) {
        this.c = ed4Var;
        if (this.b instanceof he4) {
            M();
        }
    }
}
