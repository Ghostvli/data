package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import defpackage.ls3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class s8 {
    public static final PorterDuff.Mode b = PorterDuff.Mode.SRC_IN;
    public static s8 c;
    public ls3 a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements ls3.b {
        public final int[] a = {hl3.R, hl3.P, hl3.a};
        public final int[] b = {hl3.o, hl3.B, hl3.t, hl3.p, hl3.q, hl3.s, hl3.r};
        public final int[] c = {hl3.O, hl3.Q, hl3.k, hl3.K, hl3.L, hl3.M, hl3.N};
        public final int[] d = {hl3.w, hl3.i, hl3.v};
        public final int[] e = {hl3.J, hl3.S};
        public final int[] f = {hl3.c, hl3.g, hl3.d, hl3.h};

        @Override // ls3.b
        public Drawable a(ls3 ls3Var, Context context, int i) {
            if (i == hl3.j) {
                return new LayerDrawable(new Drawable[]{ls3Var.i(context, hl3.i), ls3Var.i(context, hl3.k)});
            }
            if (i == hl3.y) {
                return l(ls3Var, context, al3.c);
            }
            if (i == hl3.x) {
                return l(ls3Var, context, al3.d);
            }
            if (i == hl3.z) {
                return l(ls3Var, context, al3.e);
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0060 A[RETURN] */
        @Override // ls3.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean b(android.content.Context r6, int r7, android.graphics.drawable.Drawable r8) {
            /*
                r5 = this;
                android.graphics.PorterDuff$Mode r0 = defpackage.s8.a()
                int[] r1 = r5.a
                boolean r1 = r5.f(r1, r7)
                r2 = 1
                r3 = 0
                r4 = -1
                if (r1 == 0) goto L14
                int r5 = defpackage.nk3.u
            L11:
                r1 = r2
            L12:
                r7 = r4
                goto L49
            L14:
                int[] r1 = r5.c
                boolean r1 = r5.f(r1, r7)
                if (r1 == 0) goto L1f
                int r5 = defpackage.nk3.s
                goto L11
            L1f:
                int[] r1 = r5.d
                boolean r5 = r5.f(r1, r7)
                r1 = 16842801(0x1010031, float:2.3693695E-38)
                if (r5 == 0) goto L2e
                android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
            L2c:
                r5 = r1
                goto L11
            L2e:
                int r5 = defpackage.hl3.u
                if (r7 != r5) goto L41
                r5 = 1109603123(0x42233333, float:40.8)
                int r5 = java.lang.Math.round(r5)
                r7 = 16842800(0x1010030, float:2.3693693E-38)
                r1 = r7
                r7 = r5
                r5 = r1
                r1 = r2
                goto L49
            L41:
                int r5 = defpackage.hl3.l
                if (r7 != r5) goto L46
                goto L2c
            L46:
                r5 = r3
                r1 = r5
                goto L12
            L49:
                if (r1 == 0) goto L60
                android.graphics.drawable.Drawable r8 = r8.mutate()
                int r5 = defpackage.en4.c(r6, r5)
                android.graphics.PorterDuffColorFilter r5 = defpackage.s8.e(r5, r0)
                r8.setColorFilter(r5)
                if (r7 == r4) goto L5f
                r8.setAlpha(r7)
            L5f:
                return r2
            L60:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: s8.a.b(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }

        @Override // ls3.b
        public PorterDuff.Mode c(int i) {
            if (i == hl3.H) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        @Override // ls3.b
        public ColorStateList d(Context context, int i) {
            if (i == hl3.m) {
                return e9.a(context, tk3.e);
            }
            if (i == hl3.I) {
                return e9.a(context, tk3.h);
            }
            if (i == hl3.H) {
                return k(context);
            }
            if (i == hl3.f) {
                return j(context);
            }
            if (i == hl3.b) {
                return g(context);
            }
            if (i == hl3.e) {
                return i(context);
            }
            if (i == hl3.D || i == hl3.E) {
                return e9.a(context, tk3.g);
            }
            if (f(this.b, i)) {
                return en4.e(context, nk3.u);
            }
            if (f(this.e, i)) {
                return e9.a(context, tk3.d);
            }
            if (f(this.f, i)) {
                return e9.a(context, tk3.c);
            }
            if (i == hl3.A) {
                return e9.a(context, tk3.f);
            }
            return null;
        }

        @Override // ls3.b
        public boolean e(Context context, int i, Drawable drawable) {
            if (i == hl3.C) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                m(layerDrawable.findDrawableByLayerId(R.id.background), en4.c(context, nk3.u), s8.b);
                m(layerDrawable.findDrawableByLayerId(R.id.secondaryProgress), en4.c(context, nk3.u), s8.b);
                m(layerDrawable.findDrawableByLayerId(R.id.progress), en4.c(context, nk3.s), s8.b);
                return true;
            }
            if (i != hl3.y && i != hl3.x && i != hl3.z) {
                return false;
            }
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            m(layerDrawable2.findDrawableByLayerId(R.id.background), en4.b(context, nk3.u), s8.b);
            m(layerDrawable2.findDrawableByLayerId(R.id.secondaryProgress), en4.c(context, nk3.s), s8.b);
            m(layerDrawable2.findDrawableByLayerId(R.id.progress), en4.c(context, nk3.s), s8.b);
            return true;
        }

        public final boolean f(int[] iArr, int i) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        public final ColorStateList g(Context context) {
            return h(context, 0);
        }

        public final ColorStateList h(Context context, int i) {
            int iC = en4.c(context, nk3.t);
            return new ColorStateList(new int[][]{en4.b, en4.e, en4.c, en4.i}, new int[]{en4.b(context, nk3.r), gx.g(iC, i), gx.g(iC, i), i});
        }

        public final ColorStateList i(Context context) {
            return h(context, en4.c(context, nk3.q));
        }

        public final ColorStateList j(Context context) {
            return h(context, en4.c(context, nk3.r));
        }

        public final ColorStateList k(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            ColorStateList colorStateListE = en4.e(context, nk3.x);
            if (colorStateListE == null || !colorStateListE.isStateful()) {
                iArr[0] = en4.b;
                iArr2[0] = en4.b(context, nk3.x);
                iArr[1] = en4.f;
                iArr2[1] = en4.c(context, nk3.s);
                iArr[2] = en4.i;
                iArr2[2] = en4.c(context, nk3.x);
            } else {
                int[] iArr3 = en4.b;
                iArr[0] = iArr3;
                iArr2[0] = colorStateListE.getColorForState(iArr3, 0);
                iArr[1] = en4.f;
                iArr2[1] = en4.c(context, nk3.s);
                iArr[2] = en4.i;
                iArr2[2] = colorStateListE.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        public final LayerDrawable l(ls3 ls3Var, Context context, int i) {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
            Drawable drawableI = ls3Var.i(context, hl3.F);
            Drawable drawableI2 = ls3Var.i(context, hl3.G);
            if ((drawableI instanceof BitmapDrawable) && drawableI.getIntrinsicWidth() == dimensionPixelSize && drawableI.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable = (BitmapDrawable) drawableI;
                bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
            } else {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                drawableI.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableI.draw(canvas);
                bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
                bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
            }
            bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
            if ((drawableI2 instanceof BitmapDrawable) && drawableI2.getIntrinsicWidth() == dimensionPixelSize && drawableI2.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) drawableI2;
            } else {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
                drawableI2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableI2.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
            layerDrawable.setId(0, R.id.background);
            layerDrawable.setId(1, R.id.secondaryProgress);
            layerDrawable.setId(2, R.id.progress);
            return layerDrawable;
        }

        public final void m(Drawable drawable, int i, PorterDuff.Mode mode) {
            Drawable drawableMutate = drawable.mutate();
            if (mode == null) {
                mode = s8.b;
            }
            drawableMutate.setColorFilter(s8.e(i, mode));
        }
    }

    public static synchronized s8 b() {
        try {
            if (c == null) {
                h();
            }
        } catch (Throwable th) {
            throw th;
        }
        return c;
    }

    public static synchronized PorterDuffColorFilter e(int i, PorterDuff.Mode mode) {
        return ls3.k(i, mode);
    }

    public static synchronized void h() {
        if (c == null) {
            s8 s8Var = new s8();
            c = s8Var;
            s8Var.a = ls3.g();
            c.a.t(new a());
        }
    }

    public static void i(Drawable drawable, bp4 bp4Var, int[] iArr) {
        ls3.v(drawable, bp4Var, iArr);
    }

    public synchronized Drawable c(Context context, int i) {
        return this.a.i(context, i);
    }

    public synchronized Drawable d(Context context, int i, boolean z) {
        return this.a.j(context, i, z);
    }

    public synchronized ColorStateList f(Context context, int i) {
        return this.a.l(context, i);
    }

    public synchronized void g(Context context) {
        this.a.r(context);
    }
}
