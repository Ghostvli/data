package defpackage;

import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.RecordingCanvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.RenderEffect;
import android.graphics.RenderNode;
import android.graphics.Shader;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class a53 {
    public static final Matrix B = new Matrix();
    public dp0 A;
    public Canvas a;
    public b b;
    public c c;
    public RectF d;
    public RectF e;
    public Rect f;
    public RectF g;
    public RectF h;
    public Rect i;
    public RectF j;
    public Paint k;
    public Bitmap l;
    public Canvas m;
    public Rect n;
    public qr1 o;
    public Matrix p;
    public float[] q;
    public Bitmap r;
    public Bitmap s;
    public Canvas t;
    public Canvas u;
    public qr1 v;
    public BlurMaskFilter w;
    public float x = 0.0f;
    public RenderNode y;
    public RenderNode z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.values().length];
            a = iArr;
            try {
                iArr[c.DIRECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c.SAVE_LAYER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[c.BITMAP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[c.RENDER_NODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public int a;
        public qk b;
        public ColorFilter c;
        public dp0 d;

        public b() {
            f();
        }

        public boolean a() {
            qk qkVar = this.b;
            return (qkVar == null || qkVar == qk.SRC_OVER) ? false : true;
        }

        public boolean b() {
            return this.c != null;
        }

        public boolean c() {
            return this.d != null;
        }

        public boolean d() {
            return (e() || a() || c() || b()) ? false : true;
        }

        public boolean e() {
            return this.a < 255;
        }

        public void f() {
            this.a = 255;
            this.b = null;
            this.c = null;
            this.d = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum c {
        DIRECT,
        SAVE_LAYER,
        BITMAP,
        RENDER_NODE
    }

    public final Bitmap a(RectF rectF, Bitmap.Config config) {
        return Bitmap.createBitmap(Math.max((int) Math.ceil(((double) rectF.width()) * 1.05d), 1), Math.max((int) Math.ceil(((double) rectF.height()) * 1.05d), 1), config);
    }

    public final RectF b(RectF rectF, dp0 dp0Var) {
        if (this.e == null) {
            this.e = new RectF();
        }
        if (this.g == null) {
            this.g = new RectF();
        }
        this.e.set(rectF);
        this.e.offsetTo(rectF.left + dp0Var.f(), rectF.top + dp0Var.g());
        this.e.inset(-dp0Var.h(), -dp0Var.h());
        this.g.set(rectF);
        this.e.union(this.g);
        return this.e;
    }

    public final c c(Canvas canvas, b bVar) {
        if (bVar.d()) {
            return c.DIRECT;
        }
        if (!bVar.c()) {
            return c.SAVE_LAYER;
        }
        int i = Build.VERSION.SDK_INT;
        return (i < 29 || !canvas.isHardwareAccelerated()) ? c.BITMAP : i <= 31 ? c.BITMAP : c.RENDER_NODE;
    }

    public final void d(Bitmap bitmap) {
        bitmap.recycle();
    }

    public void e() {
        if (this.a == null || this.b == null || this.q == null || this.d == null) {
            e04.a("OffscreenBitmap: finish() call without matching start()");
            return;
        }
        int i = a.a[this.c.ordinal()];
        if (i == 1 || i == 2) {
            this.a.restore();
        } else if (i != 3) {
            if (i == 4) {
                if (this.y == null) {
                    e04.a("RenderNode is not ready; should've been initialized at start() time");
                    return;
                }
                if (Build.VERSION.SDK_INT < 29) {
                    e04.a("RenderNode not supported but we chose it as render strategy");
                    return;
                }
                this.a.save();
                Canvas canvas = this.a;
                float[] fArr = this.q;
                canvas.scale(1.0f / fArr[0], 1.0f / fArr[4]);
                this.y.endRecording();
                if (this.b.c()) {
                    i(this.a, this.b.d);
                }
                this.a.drawRenderNode(this.y);
                this.a.restore();
            }
        } else {
            if (this.l == null) {
                e04.a("Bitmap is not ready; should've been initialized at start() time");
                return;
            }
            if (this.b.c()) {
                h(this.a, this.b.d);
            }
            if (this.n == null) {
                this.n = new Rect();
            }
            this.n.set(0, 0, (int) (this.d.width() * this.q[0]), (int) (this.d.height() * this.q[4]));
            this.a.drawBitmap(this.l, this.n, this.d, this.k);
        }
        this.a = null;
    }

    public boolean f() {
        return this.c == c.RENDER_NODE;
    }

    public final boolean g(Bitmap bitmap, RectF rectF) {
        return bitmap == null || rectF.width() >= ((float) bitmap.getWidth()) || rectF.height() >= ((float) bitmap.getHeight()) || rectF.width() < ((float) bitmap.getWidth()) * 0.75f || rectF.height() < ((float) bitmap.getHeight()) * 0.75f;
    }

    public final void h(Canvas canvas, dp0 dp0Var) {
        qr1 qr1Var;
        RectF rectF = this.d;
        if (rectF == null || this.l == null) {
            e04.a("Cannot render to bitmap outside a start()/finish() block");
            return;
        }
        RectF rectFB = b(rectF, dp0Var);
        if (this.f == null) {
            this.f = new Rect();
        }
        this.f.set((int) Math.floor(rectFB.left), (int) Math.floor(rectFB.top), (int) Math.ceil(rectFB.right), (int) Math.ceil(rectFB.bottom));
        float[] fArr = this.q;
        float f = fArr != null ? fArr[0] : 1.0f;
        float f2 = fArr != null ? fArr[4] : 1.0f;
        if (this.h == null) {
            this.h = new RectF();
        }
        this.h.set(rectFB.left * f, rectFB.top * f2, rectFB.right * f, rectFB.bottom * f2);
        if (this.i == null) {
            this.i = new Rect();
        }
        this.i.set(0, 0, Math.round(this.h.width()), Math.round(this.h.height()));
        if (g(this.r, this.h)) {
            Bitmap bitmap = this.r;
            if (bitmap != null) {
                d(bitmap);
            }
            Bitmap bitmap2 = this.s;
            if (bitmap2 != null) {
                d(bitmap2);
            }
            this.r = a(this.h, Bitmap.Config.ARGB_8888);
            this.s = a(this.h, Bitmap.Config.ALPHA_8);
            this.t = new Canvas(this.r);
            this.u = new Canvas(this.s);
        } else {
            Canvas canvas2 = this.t;
            if (canvas2 == null || this.u == null || (qr1Var = this.o) == null) {
                e04.a("If needNewBitmap() returns true, we should have a canvas and bitmap ready");
                return;
            } else {
                canvas2.drawRect(this.i, qr1Var);
                this.u.drawRect(this.i, this.o);
            }
        }
        if (this.s == null) {
            e04.a("Expected to have allocated a shadow mask bitmap");
            return;
        }
        if (this.v == null) {
            this.v = new qr1(1);
        }
        RectF rectF2 = this.d;
        this.u.drawBitmap(this.l, Math.round((rectF2.left - rectFB.left) * f), Math.round((rectF2.top - rectFB.top) * f2), (Paint) null);
        if (this.w == null || this.x != dp0Var.h()) {
            float fH = (dp0Var.h() * (f + f2)) / 2.0f;
            if (fH > 0.0f) {
                this.w = new BlurMaskFilter(fH, BlurMaskFilter.Blur.NORMAL);
            } else {
                this.w = null;
            }
            this.x = dp0Var.h();
        }
        this.v.setColor(dp0Var.e());
        float fH2 = dp0Var.h();
        qr1 qr1Var2 = this.v;
        if (fH2 > 0.0f) {
            qr1Var2.setMaskFilter(this.w);
        } else {
            qr1Var2.setMaskFilter(null);
        }
        this.v.setFilterBitmap(true);
        this.t.drawBitmap(this.s, Math.round(dp0Var.f() * f), Math.round(dp0Var.g() * f2), this.v);
        canvas.drawBitmap(this.r, this.i, this.f, this.k);
    }

    public final void i(Canvas canvas, dp0 dp0Var) {
        if (this.y == null || this.z == null) {
            e04.a("Cannot render to render node outside a start()/finish() block");
            return;
        }
        if (Build.VERSION.SDK_INT < 31) {
            zt2.a("RenderEffect is not supported on API level <31");
            return;
        }
        float[] fArr = this.q;
        float f = fArr != null ? fArr[0] : 1.0f;
        float f2 = fArr != null ? fArr[4] : 1.0f;
        dp0 dp0Var2 = this.A;
        if (dp0Var2 == null || !dp0Var.j(dp0Var2)) {
            RenderEffect renderEffectCreateColorFilterEffect = RenderEffect.createColorFilterEffect(new PorterDuffColorFilter(dp0Var.e(), PorterDuff.Mode.SRC_IN));
            if (dp0Var.h() > 0.0f) {
                float fH = (dp0Var.h() * (f + f2)) / 2.0f;
                renderEffectCreateColorFilterEffect = RenderEffect.createBlurEffect(fH, fH, renderEffectCreateColorFilterEffect, Shader.TileMode.CLAMP);
            }
            this.z.setRenderEffect(renderEffectCreateColorFilterEffect);
            this.A = dp0Var;
        }
        RectF rectFB = b(this.d, dp0Var);
        RectF rectF = new RectF(rectFB.left * f, rectFB.top * f2, rectFB.right * f, rectFB.bottom * f2);
        this.z.setPosition(0, 0, (int) rectF.width(), (int) rectF.height());
        RecordingCanvas recordingCanvasBeginRecording = this.z.beginRecording((int) rectF.width(), (int) rectF.height());
        recordingCanvasBeginRecording.translate((-rectF.left) + (dp0Var.f() * f), (-rectF.top) + (dp0Var.g() * f2));
        recordingCanvasBeginRecording.drawRenderNode(this.y);
        this.z.endRecording();
        canvas.save();
        canvas.translate(rectF.left, rectF.top);
        canvas.drawRenderNode(this.z);
        canvas.restore();
    }

    public Canvas j(Canvas canvas, RectF rectF, b bVar) {
        if (this.a != null) {
            e04.a("Cannot nest start() calls on a single OffscreenBitmap - call finish() first");
            return null;
        }
        if (this.q == null) {
            this.q = new float[9];
        }
        if (this.p == null) {
            this.p = new Matrix();
        }
        canvas.getMatrix(this.p);
        this.p.getValues(this.q);
        float[] fArr = this.q;
        float f = fArr[0];
        float f2 = fArr[4];
        if (this.j == null) {
            this.j = new RectF();
        }
        this.j.set(rectF.left * f, rectF.top * f2, rectF.right * f, rectF.bottom * f2);
        this.a = canvas;
        this.b = bVar;
        this.c = c(canvas, bVar);
        if (this.d == null) {
            this.d = new RectF();
        }
        this.d.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        if (this.k == null) {
            this.k = new qr1();
        }
        this.k.reset();
        int i = a.a[this.c.ordinal()];
        if (i == 1) {
            canvas.save();
            return canvas;
        }
        if (i == 2) {
            this.k.setAlpha(bVar.a);
            this.k.setColorFilter(bVar.c);
            if (bVar.a()) {
                h73.b(this.k, bVar.b);
            }
            uy4.n(canvas, rectF, this.k);
            return canvas;
        }
        if (i == 3) {
            if (this.o == null) {
                qr1 qr1Var = new qr1();
                this.o = qr1Var;
                qr1Var.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            }
            if (g(this.l, this.j)) {
                Bitmap bitmap = this.l;
                if (bitmap != null) {
                    d(bitmap);
                }
                this.l = a(this.j, Bitmap.Config.ARGB_8888);
                this.m = new Canvas(this.l);
            } else {
                Canvas canvas2 = this.m;
                if (canvas2 == null) {
                    e04.a("If needNewBitmap() returns true, we should have a canvas ready");
                    return null;
                }
                canvas2.setMatrix(B);
                this.m.drawRect(-1.0f, -1.0f, this.j.width() + 1.0f, this.j.height() + 1.0f, this.o);
            }
            h73.b(this.k, bVar.b);
            this.k.setColorFilter(bVar.c);
            this.k.setAlpha(bVar.a);
            Canvas canvas3 = this.m;
            canvas3.scale(f, f2);
            canvas3.translate(-rectF.left, -rectF.top);
            return canvas3;
        }
        if (i != 4) {
            zt2.a("Invalid render strategy for OffscreenLayer");
            return null;
        }
        if (Build.VERSION.SDK_INT < 29) {
            e04.a("RenderNode not supported but we chose it as render strategy");
            return null;
        }
        if (this.y == null) {
            this.y = z43.a("OffscreenLayer.main");
        }
        if (bVar.c() && this.z == null) {
            this.z = z43.a("OffscreenLayer.shadow");
            this.A = null;
        }
        if (bVar.a() || bVar.b()) {
            if (this.k == null) {
                this.k = new qr1();
            }
            this.k.reset();
            h73.b(this.k, bVar.b);
            this.k.setColorFilter(bVar.c);
            this.y.setUseCompositingLayer(true, this.k);
            if (bVar.c()) {
                RenderNode renderNode = this.z;
                if (renderNode == null) {
                    e04.a("Must initialize shadowRenderNode when we have shadow");
                    return null;
                }
                renderNode.setUseCompositingLayer(true, this.k);
            }
        }
        this.y.setAlpha(bVar.a / 255.0f);
        if (bVar.c()) {
            RenderNode renderNode2 = this.z;
            if (renderNode2 == null) {
                e04.a("Must initialize shadowRenderNode when we have shadow");
                return null;
            }
            renderNode2.setAlpha(bVar.a / 255.0f);
        }
        this.y.setHasOverlappingRendering(true);
        RenderNode renderNode3 = this.y;
        RectF rectF2 = this.j;
        renderNode3.setPosition((int) rectF2.left, (int) rectF2.top, (int) rectF2.right, (int) rectF2.bottom);
        RecordingCanvas recordingCanvasBeginRecording = this.y.beginRecording((int) this.j.width(), (int) this.j.height());
        recordingCanvasBeginRecording.setMatrix(B);
        recordingCanvasBeginRecording.scale(f, f2);
        recordingCanvasBeginRecording.translate(-rectF.left, -rectF.top);
        return recordingCanvasBeginRecording;
    }
}
