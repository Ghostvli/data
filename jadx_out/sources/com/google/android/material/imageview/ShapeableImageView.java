package com.google.android.material.imageview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatImageView;
import defpackage.cn3;
import defpackage.e9;
import defpackage.k62;
import defpackage.l62;
import defpackage.o62;
import defpackage.r54;
import defpackage.y44;
import defpackage.ym3;
import defpackage.z44;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ShapeableImageView extends AppCompatImageView implements r54 {
    public static final int A = ym3.D;
    public final z44 i;
    public final RectF j;
    public final RectF k;
    public final Paint l;
    public final Paint m;
    public final Path n;
    public ColorStateList o;
    public l62 p;
    public y44 q;
    public float r;
    public Path s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public boolean z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends ViewOutlineProvider {
        public final Rect a = new Rect();

        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (ShapeableImageView.this.q == null) {
                return;
            }
            if (ShapeableImageView.this.p == null) {
                ShapeableImageView.this.p = new l62(ShapeableImageView.this.q);
            }
            ShapeableImageView.this.j.round(this.a);
            ShapeableImageView.this.p.setBounds(this.a);
            ShapeableImageView.this.p.getOutline(outline);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ShapeableImageView(Context context, AttributeSet attributeSet, int i) {
        int i2 = A;
        super(o62.d(context, attributeSet, i, i2), attributeSet, i);
        this.i = z44.l();
        this.n = new Path();
        this.z = false;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.m = paint;
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.j = new RectF();
        this.k = new RectF();
        this.s = new Path();
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, cn3.n5, i, i2);
        setLayerType(2, null);
        this.o = k62.b(context2, typedArrayObtainStyledAttributes, cn3.v5);
        this.r = typedArrayObtainStyledAttributes.getDimensionPixelSize(cn3.w5, 0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(cn3.o5, 0);
        this.t = dimensionPixelSize;
        this.u = dimensionPixelSize;
        this.v = dimensionPixelSize;
        this.w = dimensionPixelSize;
        this.t = typedArrayObtainStyledAttributes.getDimensionPixelSize(cn3.r5, dimensionPixelSize);
        this.u = typedArrayObtainStyledAttributes.getDimensionPixelSize(cn3.u5, dimensionPixelSize);
        this.v = typedArrayObtainStyledAttributes.getDimensionPixelSize(cn3.s5, dimensionPixelSize);
        this.w = typedArrayObtainStyledAttributes.getDimensionPixelSize(cn3.p5, dimensionPixelSize);
        this.x = typedArrayObtainStyledAttributes.getDimensionPixelSize(cn3.t5, Integer.MIN_VALUE);
        this.y = typedArrayObtainStyledAttributes.getDimensionPixelSize(cn3.q5, Integer.MIN_VALUE);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint2 = new Paint();
        this.l = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        this.q = y44.i(context2, attributeSet, i, i2).m();
        setOutlineProvider(new a());
    }

    public final void g(Canvas canvas) {
        if (this.o == null) {
            return;
        }
        this.l.setStrokeWidth(this.r);
        int colorForState = this.o.getColorForState(getDrawableState(), this.o.getDefaultColor());
        if (this.r <= 0.0f || colorForState == 0) {
            return;
        }
        this.l.setColor(colorForState);
        canvas.drawPath(this.n, this.l);
    }

    public int getContentPaddingBottom() {
        return this.w;
    }

    public final int getContentPaddingEnd() {
        int i = this.y;
        return i != Integer.MIN_VALUE ? i : i() ? this.t : this.v;
    }

    public int getContentPaddingLeft() {
        int i;
        int i2;
        if (h()) {
            if (i() && (i2 = this.y) != Integer.MIN_VALUE) {
                return i2;
            }
            if (!i() && (i = this.x) != Integer.MIN_VALUE) {
                return i;
            }
        }
        return this.t;
    }

    public int getContentPaddingRight() {
        int i;
        int i2;
        if (h()) {
            if (i() && (i2 = this.x) != Integer.MIN_VALUE) {
                return i2;
            }
            if (!i() && (i = this.y) != Integer.MIN_VALUE) {
                return i;
            }
        }
        return this.v;
    }

    public final int getContentPaddingStart() {
        int i = this.x;
        return i != Integer.MIN_VALUE ? i : i() ? this.v : this.t;
    }

    public int getContentPaddingTop() {
        return this.u;
    }

    @Override // android.view.View
    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    @Override // android.view.View
    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    @Override // android.view.View
    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    @Override // android.view.View
    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    @Override // android.view.View
    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    @Override // android.view.View
    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    public y44 getShapeAppearanceModel() {
        return this.q;
    }

    public ColorStateList getStrokeColor() {
        return this.o;
    }

    public float getStrokeWidth() {
        return this.r;
    }

    public final boolean h() {
        return (this.x == Integer.MIN_VALUE && this.y == Integer.MIN_VALUE) ? false : true;
    }

    public final boolean i() {
        return getLayoutDirection() == 1;
    }

    public final void j(int i, int i2) {
        this.j.set(getPaddingLeft(), getPaddingTop(), i - getPaddingRight(), i2 - getPaddingBottom());
        this.i.e(this.q, 1.0f, this.j, this.n);
        this.s.rewind();
        this.s.addPath(this.n);
        this.k.set(0.0f, 0.0f, i, i2);
        this.s.addRect(this.k, Path.Direction.CCW);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.s, this.m);
        g(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.z && isLayoutDirectionResolved()) {
            this.z = true;
            if (isPaddingRelative() || h()) {
                setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
            } else {
                setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        j(i, i2);
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i + getContentPaddingLeft(), i2 + getContentPaddingTop(), i3 + getContentPaddingRight(), i4 + getContentPaddingBottom());
    }

    @Override // android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i + getContentPaddingStart(), i2 + getContentPaddingTop(), i3 + getContentPaddingEnd(), i4 + getContentPaddingBottom());
    }

    @Override // defpackage.r54
    public void setShapeAppearanceModel(y44 y44Var) {
        this.q = y44Var;
        l62 l62Var = this.p;
        if (l62Var != null) {
            l62Var.setShapeAppearanceModel(y44Var);
        }
        j(getWidth(), getHeight());
        invalidate();
        invalidateOutline();
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.o = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(int i) {
        setStrokeColor(e9.a(getContext(), i));
    }

    public void setStrokeWidth(float f) {
        if (this.r != f) {
            this.r = f;
            invalidate();
        }
    }

    public void setStrokeWidthResource(int i) {
        setStrokeWidth(getResources().getDimensionPixelSize(i));
    }

    public ShapeableImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShapeableImageView(Context context) {
        this(context, null, 0);
    }
}
