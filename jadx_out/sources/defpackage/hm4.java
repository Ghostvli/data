package defpackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import java.util.Locale;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class hm4 extends ShapeDrawable {
    public static final b m = new b(null);
    public final Paint a;
    public final Paint b;
    public final String c;
    public final int d;
    public final RectShape e;
    public final int f;
    public final int g;
    public final int h;
    public final float i;
    public final int j;
    public final int k;
    public final Bitmap l;

    public hm4(a aVar) {
        String strN;
        super(aVar.m());
        this.e = aVar.m();
        this.f = aVar.k();
        this.g = aVar.q();
        this.i = aVar.l();
        if (aVar.p()) {
            String strN2 = aVar.n();
            strN2 = strN2 == null ? "" : strN2;
            Locale locale = Locale.ROOT;
            locale.getClass();
            strN = strN2.toUpperCase(locale);
            strN.getClass();
        } else {
            strN = aVar.n();
        }
        this.c = strN;
        int iG = aVar.g();
        this.d = iG;
        this.h = aVar.j();
        Paint paint = new Paint(1);
        this.a = paint;
        paint.setColor(aVar.o());
        paint.setAntiAlias(true);
        paint.setFakeBoldText(aVar.r());
        paint.setStyle(Paint.Style.FILL);
        paint.setTypeface(aVar.i());
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setStrokeWidth(aVar.f());
        int iF = aVar.f();
        this.j = iF;
        int iE = aVar.e();
        this.k = iE;
        Paint paint2 = new Paint(1);
        this.b = paint2;
        paint2.setColor(iE == -1 ? b(iG) : iE);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(iF);
        paint2.setAntiAlias(true);
        Paint paint3 = getPaint();
        paint3.getClass();
        paint3.setColor(iG);
        Drawable drawableH = aVar.h();
        BitmapDrawable bitmapDrawable = (BitmapDrawable) (drawableH instanceof BitmapDrawable ? drawableH : null);
        this.l = bitmapDrawable != null ? bitmapDrawable.getBitmap() : null;
    }

    public final void a(Canvas canvas) {
        RectF rectF = new RectF(getBounds());
        float fCeil = (int) Math.ceil(this.j / 2);
        rectF.inset(fCeil, fCeil);
        RectShape rectShape = this.e;
        if (rectShape instanceof OvalShape) {
            canvas.drawOval(rectF, this.b);
        } else if (!(rectShape instanceof RoundRectShape)) {
            canvas.drawRect(rectF, this.b);
        } else {
            float f = this.i;
            canvas.drawRoundRect(rectF, f, f, this.b);
        }
    }

    public final int b(int i) {
        return Color.rgb((int) (Color.red(i) * 0.9f), (int) (Color.green(i) * 0.9f), (int) (Color.blue(i) * 0.9f));
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.getClass();
        super.draw(canvas);
        Rect bounds = getBounds();
        bounds.getClass();
        if (this.j > 0) {
            a(canvas);
        }
        int iSave = canvas.save();
        if (this.l == null) {
            canvas.translate(bounds.left, bounds.top);
        }
        int iWidth = this.g;
        if (iWidth < 0) {
            iWidth = bounds.width();
        }
        int iHeight = this.f;
        if (iHeight < 0) {
            iHeight = bounds.height();
        }
        Bitmap bitmap = this.l;
        if (bitmap == null) {
            int iMin = this.h;
            if (iMin < 0) {
                iMin = Math.min(iWidth, iHeight) / 2;
            }
            this.a.setTextSize(iMin);
            Rect rect = new Rect();
            Paint paint = this.a;
            String str = this.c;
            paint.getTextBounds(str, 0, str != null ? str.length() : 0, rect);
            String str2 = this.c;
            if (str2 == null) {
                str2 = "";
            }
            canvas.drawText(str2, iWidth / 2, (iHeight / 2) - rect.exactCenterY(), this.a);
        } else {
            canvas.drawBitmap(bitmap, (iWidth - bitmap.getWidth()) / 2, (iHeight - this.l.getHeight()) / 2, (Paint) null);
        }
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f;
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.g;
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.a.setAlpha(i);
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public float m;
        public Drawable n;
        public static final b q = new b(null);
        public static final RectF o = new RectF();
        public static final cs1 p = is1.b(C0083a.g);
        public String a = "";
        public int b = -7829368;
        public int i = -1;
        public int c = 0;
        public int d = -1;
        public int e = -1;
        public int f = -1;
        public RectShape h = new RectShape();
        public Typeface g = q.a();
        public int j = -1;
        public boolean k = false;
        public boolean l = false;

        /* JADX INFO: renamed from: hm4$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class C0083a extends tr1 implements Function0 {
            public static final C0083a g = new C0083a();

            public C0083a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Typeface invoke() {
                return Typeface.create("sans-serif-light", 0);
            }
        }

        public final hm4 b(String str, int i) {
            str.getClass();
            this.b = i;
            this.a = str;
            return new hm4(this, null);
        }

        public final hm4 c(String str, int i) {
            str.getClass();
            s();
            return b(str, i);
        }

        public final hm4 d(String str, int i, int i2) {
            str.getClass();
            t(i2);
            return b(str, i);
        }

        public final int e() {
            return this.d;
        }

        public final int f() {
            return this.c;
        }

        public final int g() {
            return this.b;
        }

        public final Drawable h() {
            return this.n;
        }

        public final Typeface i() {
            return this.g;
        }

        public final int j() {
            return this.j;
        }

        public final int k() {
            return this.f;
        }

        public final float l() {
            return this.m;
        }

        public final RectShape m() {
            return this.h;
        }

        public final String n() {
            return this.a;
        }

        public final int o() {
            return this.i;
        }

        public final boolean p() {
            return this.l;
        }

        public final int q() {
            return this.e;
        }

        public final boolean r() {
            return this.k;
        }

        public final a s() {
            this.h = new RectShape();
            return this;
        }

        public final a t(int i) {
            float f = i;
            this.m = f;
            this.h = new RoundRectShape(new float[]{f, f, f, f, f, f, f, f}, o, null);
            return this;
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class b {
            public static final /* synthetic */ sp1[] a = {np3.e(new gi3(np3.b(b.class), "DEFAULT_FONT", "getDEFAULT_FONT()Landroid/graphics/Typeface;"))};

            public b() {
            }

            public final Typeface a() {
                cs1 cs1Var = a.p;
                sp1 sp1Var = a[0];
                return (Typeface) cs1Var.getValue();
            }

            public /* synthetic */ b(we0 we0Var) {
                this();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(we0 we0Var) {
            this();
        }
    }

    public /* synthetic */ hm4(a aVar, we0 we0Var) {
        this(aVar);
    }
}
