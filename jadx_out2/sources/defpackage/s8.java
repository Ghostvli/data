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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0060 A[RETURN] */
        @Override // ls3.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean b(Context context, int i, Drawable drawable) {
            int i2;
            boolean z;
            int iRound;
            PorterDuff.Mode mode = s8.b;
            if (f(this.a, i)) {
                i2 = nk3.u;
            } else if (f(this.c, i)) {
                i2 = nk3.s;
            } else {
                if (f(this.d, i)) {
                    mode = PorterDuff.Mode.MULTIPLY;
                } else {
                    if (i == hl3.u) {
                        iRound = Math.round(40.8f);
                        i2 = 16842800;
                        z = true;
                        if (!z) {
                            return false;
                        }
                        Drawable drawableMutate = drawable.mutate();
                        drawableMutate.setColorFilter(s8.e(en4.c(context, i2), mode));
                        if (iRound != -1) {
                            drawableMutate.setAlpha(iRound);
                        }
                        return true;
                    }
                    if (i != hl3.l) {
                        i2 = 0;
                        z = false;
                        iRound = -1;
                        if (!z) {
                        }
                    }
                }
                i2 = 16842801;
            }
            z = true;
            iRound = -1;
            if (!z) {
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ls3.b
        public PorterDuff.Mode c(int i) {
            if (i == hl3.H) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean f(int[] iArr, int i) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final ColorStateList g(Context context) {
            return h(context, 0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final ColorStateList h(Context context, int i) {
            int iC = en4.c(context, nk3.t);
            return new ColorStateList(new int[][]{en4.b, en4.e, en4.c, en4.i}, new int[]{en4.b(context, nk3.r), gx.g(iC, i), gx.g(iC, i), i});
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final ColorStateList i(Context context) {
            return h(context, en4.c(context, nk3.q));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final ColorStateList j(Context context) {
            return h(context, en4.c(context, nk3.r));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void m(Drawable drawable, int i, PorterDuff.Mode mode) {
            Drawable drawableMutate = drawable.mutate();
            if (mode == null) {
                mode = s8.b;
            }
            drawableMutate.setColorFilter(s8.e(i, mode));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static synchronized PorterDuffColorFilter e(int i, PorterDuff.Mode mode) {
        return ls3.k(i, mode);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static synchronized void h() {
        if (c == null) {
            s8 s8Var = new s8();
            c = s8Var;
            s8Var.a = ls3.g();
            c.a.t(new a());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void i(Drawable drawable, bp4 bp4Var, int[] iArr) {
        ls3.v(drawable, bp4Var, iArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized Drawable c(Context context, int i) {
        return this.a.i(context, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized Drawable d(Context context, int i, boolean z) {
        return this.a.j(context, i, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized ColorStateList f(Context context, int i) {
        return this.a.l(context, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized void g(Context context) {
        this.a.r(context);
    }
}
