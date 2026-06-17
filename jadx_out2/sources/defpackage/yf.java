package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import defpackage.im4;
import defpackage.zf;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class yf extends Drawable implements im4.b {
    public static final int s = ym3.r;
    public static final int t = mk3.b;
    public final WeakReference f;
    public final l62 g;
    public final im4 h;
    public final Rect i;
    public final zf j;
    public float k;
    public float l;
    public int m;
    public float n;
    public float o;
    public float p;
    public WeakReference q;
    public WeakReference r;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public yf(Context context, int i, int i2, int i3, zf.a aVar) {
        this.f = new WeakReference(context);
        dn4.c(context);
        this.i = new Rect();
        im4 im4Var = new im4(this);
        this.h = im4Var;
        im4Var.g().setTextAlign(Paint.Align.CENTER);
        zf zfVar = new zf(context, i, i2, i3, aVar);
        this.j = zfVar;
        this.g = new l62(y44.f(context, B() ? zfVar.m() : zfVar.i(), B() ? zfVar.l() : zfVar.h()).m());
        N();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void P(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static yf e(Context context) {
        return new yf(context, 0, t, s, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static yf f(Context context, zf.a aVar) {
        return new yf(context, 0, t, s, aVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int A() {
        int iC = this.j.C();
        if (B()) {
            iC = this.j.B();
            Context context = (Context) this.f.get();
            if (context != null) {
                iC = k7.c(iC, iC - this.j.t(), k7.b(0.0f, 1.0f, 0.3f, 1.0f, k62.f(context) - 1.0f));
            }
        }
        if (this.j.k == 0) {
            iC -= Math.round(this.p);
        }
        return iC + this.j.c();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean B() {
        return D() || C();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean C() {
        return !this.j.E() && this.j.D();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean D() {
        return this.j.E();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void E() {
        this.h.g().setAlpha(getAlpha());
        invalidateSelf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void F() {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(this.j.e());
        if (this.g.C() != colorStateListValueOf) {
            this.g.e0(colorStateListValueOf);
            invalidateSelf();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void G() {
        this.h.l(true);
        I();
        R();
        invalidateSelf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void H() {
        WeakReference weakReference = this.q;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        View view = (View) this.q.get();
        WeakReference weakReference2 = this.r;
        Q(view, weakReference2 != null ? (FrameLayout) weakReference2.get() : null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void I() {
        Context context = (Context) this.f.get();
        if (context == null) {
            return;
        }
        l62 l62Var = this.g;
        boolean zB = B();
        zf zfVar = this.j;
        int iM = zB ? zfVar.m() : zfVar.i();
        boolean zB2 = B();
        zf zfVar2 = this.j;
        l62Var.setShapeAppearanceModel(y44.f(context, iM, zB2 ? zfVar2.l() : zfVar2.h()).m());
        invalidateSelf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void J() {
        bm4 bm4Var;
        Context context = (Context) this.f.get();
        if (context == null || this.h.e() == (bm4Var = new bm4(context, this.j.A()))) {
            return;
        }
        this.h.k(bm4Var, context);
        K();
        R();
        invalidateSelf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void K() {
        this.h.g().setColor(this.j.j());
        invalidateSelf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void L() {
        S();
        this.h.l(true);
        R();
        invalidateSelf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void M() {
        setVisible(this.j.G(), false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void N() {
        I();
        J();
        L();
        G();
        E();
        F();
        K();
        H();
        R();
        M();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void O(int i) {
        zf zfVar = this.j;
        if (zfVar.l != i) {
            zfVar.l = i;
            R();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Q(View view, FrameLayout frameLayout) {
        this.q = new WeakReference(view);
        this.r = new WeakReference(frameLayout);
        P(view);
        R();
        invalidateSelf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void R() {
        Context context = (Context) this.f.get();
        WeakReference weakReference = this.q;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (context == null || view == null) {
            return;
        }
        Rect rect = new Rect();
        rect.set(this.i);
        Rect rect2 = new Rect();
        view.getDrawingRect(rect2);
        WeakReference weakReference2 = this.r;
        ViewGroup viewGroup = weakReference2 != null ? (ViewGroup) weakReference2.get() : null;
        if (viewGroup != null) {
            viewGroup.offsetDescendantRectToMyCoords(view, rect2);
        }
        d(rect2, view);
        ag.g(this.i, this.k, this.l, this.o, this.p);
        float f = this.n;
        if (f != -1.0f) {
            this.g.b0(f);
        }
        if (rect.equals(this.i)) {
            return;
        }
        this.g.setBounds(this.i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void S() {
        if (o() != -2) {
            this.m = ((int) Math.pow(10.0d, ((double) o()) - 1.0d)) - 1;
        } else {
            this.m = p();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // im4.b
    public void a() {
        invalidateSelf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void b(View view) {
        ViewParent viewParentK = k();
        if (viewParentK == null) {
            viewParentK = view.getParent();
        }
        if ((viewParentK instanceof View) && (viewParentK.getParent() instanceof View)) {
            c(view, (View) viewParentK.getParent());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:? */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: android.view.ViewParent */
    /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: android.view.ViewParent */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: android.view.ViewParent */
    /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: android.view.ViewParent */
    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: android.view.ViewParent */
    /* JADX WARN: Multi-variable type inference failed */
    public final void c(View view, View view2) {
        float y;
        float x;
        ViewParent parent;
        boolean z;
        FrameLayout frameLayoutK = k();
        if (frameLayoutK == null) {
            float y2 = view.getY();
            x = view.getX();
            parent = view.getParent();
            y = y2;
        } else {
            y = 0.0f;
            x = 0.0f;
            parent = frameLayoutK;
        }
        while (true) {
            z = parent instanceof View;
            if (!z || parent == view2) {
                break;
            }
            ViewParent parent2 = parent.getParent();
            if (!(parent2 instanceof ViewGroup) || ((ViewGroup) parent2).getClipChildren()) {
                break;
            }
            View view3 = (View) parent;
            y += view3.getY();
            x += view3.getX();
            parent = parent.getParent();
        }
        if (z) {
            float fY = y(y);
            float fN = n(x);
            View view4 = (View) parent;
            float fI = i(view4.getHeight(), y);
            float fT = t(view4.getWidth(), x);
            if (fY < 0.0f) {
                this.l += Math.abs(fY);
            }
            if (fN < 0.0f) {
                this.k += Math.abs(fN);
            }
            if (fI > 0.0f) {
                this.l -= Math.abs(fI);
            }
            if (fT > 0.0f) {
                this.k -= Math.abs(fT);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void d(Rect rect, View view) {
        boolean zB = B();
        zf zfVar = this.j;
        float f = zB ? zfVar.d : zfVar.c;
        this.n = f;
        if (f != -1.0f) {
            this.o = f;
            this.p = f;
        } else {
            boolean zB2 = B();
            zf zfVar2 = this.j;
            this.o = Math.round((zB2 ? zfVar2.g : zfVar2.e) / 2.0f);
            boolean zB3 = B();
            zf zfVar3 = this.j;
            this.p = Math.round((zB3 ? zfVar3.h : zfVar3.f) / 2.0f);
        }
        if (B()) {
            String strH = h();
            this.o = Math.max(this.o, (this.h.h(strH) / 2.0f) + this.j.g());
            float fMax = Math.max(this.p, (this.h.f(strH) / 2.0f) + this.j.k());
            this.p = fMax;
            this.o = Math.max(this.o, fMax);
        }
        int iA = A();
        int iF = this.j.f();
        if (iF == 8388691 || iF == 8388693) {
            this.l = rect.bottom - iA;
        } else {
            this.l = rect.top + iA;
        }
        int iZ = z();
        int iF2 = this.j.f();
        if (iF2 == 8388659 || iF2 == 8388691) {
            this.k = this.j.l == 0 ? view.getLayoutDirection() == 0 ? (rect.left + this.o) - ((this.p * 2.0f) - iZ) : (rect.right - this.o) + ((this.p * 2.0f) - iZ) : view.getLayoutDirection() == 0 ? (rect.left - this.o) + iZ : (rect.right + this.o) - iZ;
        } else {
            this.k = this.j.l == 0 ? view.getLayoutDirection() == 0 ? (rect.right + this.o) - iZ : (rect.left - this.o) + iZ : view.getLayoutDirection() == 0 ? (rect.right - this.o) + ((this.p * 2.0f) - iZ) : (rect.left + this.o) - ((this.p * 2.0f) - iZ);
        }
        if (this.j.F()) {
            b(view);
        } else {
            c(view, null);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.g.draw(canvas);
        if (B()) {
            g(canvas);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g(Canvas canvas) {
        String strH = h();
        if (strH != null) {
            Rect rect = new Rect();
            this.h.g().getTextBounds(strH, 0, strH.length(), rect);
            float fExactCenterY = this.l - rect.exactCenterY();
            canvas.drawText(strH, this.k, rect.bottom <= 0 ? (int) fExactCenterY : Math.round(fExactCenterY), this.h.g());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.j.d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.i.height();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.i.width();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String h() {
        if (D()) {
            return w();
        }
        if (C()) {
            return r();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final float i(float f, float f2) {
        return ((this.l + this.p) - f) + f2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public CharSequence j() {
        if (isVisible()) {
            return D() ? x() : C() ? s() : l();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FrameLayout k() {
        WeakReference weakReference = this.r;
        if (weakReference != null) {
            return (FrameLayout) weakReference.get();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final CharSequence l() {
        return this.j.p();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int m() {
        return this.j.s();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final float n(float f) {
        return (this.k - this.o) + f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int o() {
        return this.j.u();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable, im4.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int p() {
        return this.j.v();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int q() {
        if (this.j.D()) {
            return this.j.w();
        }
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String r() {
        if (this.m == -2 || q() <= this.m) {
            return NumberFormat.getInstance(this.j.x()).format(q());
        }
        Context context = (Context) this.f.get();
        return context == null ? "" : String.format(this.j.x(), context.getString(tm3.u), Integer.valueOf(this.m), "+");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String s() {
        Context context;
        if (this.j.q() == 0 || (context = (Context) this.f.get()) == null) {
            return null;
        }
        return (this.m == -2 || q() <= this.m) ? context.getResources().getQuantityString(this.j.q(), q(), Integer.valueOf(q())) : context.getString(this.j.n(), Integer.valueOf(this.m));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.j.I(i);
        E();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final float t(float f, float f2) {
        return ((this.k + this.o) - f) + f2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public zf.a u() {
        return this.j.y();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String v() {
        return this.j.z();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String w() {
        String strV = v();
        int iO = o();
        if (iO == -2 || strV == null || strV.length() <= iO) {
            return strV;
        }
        Context context = (Context) this.f.get();
        if (context == null) {
            return "";
        }
        return String.format(context.getString(tm3.k), strV.substring(0, iO - 1), "…");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final CharSequence x() {
        CharSequence charSequenceO = this.j.o();
        return charSequenceO != null ? charSequenceO : v();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final float y(float f) {
        return (this.l - this.p) + f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int z() {
        boolean zB = B();
        zf zfVar = this.j;
        int iR = zB ? zfVar.r() : zfVar.s();
        if (this.j.k == 1) {
            boolean zB2 = B();
            zf zfVar2 = this.j;
            iR += zB2 ? zfVar2.j : zfVar2.i;
        }
        return iR + this.j.b();
    }
}
