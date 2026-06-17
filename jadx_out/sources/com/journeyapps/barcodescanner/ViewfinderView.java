package com.journeyapps.barcodescanner;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.google.zxing.ResultPoint;
import com.google.zxing.client.android.R;
import com.journeyapps.barcodescanner.a;
import defpackage.c94;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ViewfinderView extends View {
    public static final int[] s = {0, 64, 128, 192, 255, 192, 128, 64};
    public final Paint f;
    public Bitmap g;
    public int h;
    public final int i;
    public final int j;
    public final int k;
    public boolean l;
    public int m;
    public List n;
    public List o;
    public com.journeyapps.barcodescanner.a p;
    public Rect q;
    public c94 r;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements a.f {
        public a() {
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void a() {
            ViewfinderView.this.b();
            ViewfinderView.this.invalidate();
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void b(Exception exc) {
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void c() {
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void d() {
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void e() {
        }
    }

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = new Paint(1);
        Resources resources = getResources();
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.zxing_finder);
        this.h = typedArrayObtainStyledAttributes.getColor(R.styleable.zxing_finder_zxing_viewfinder_mask, resources.getColor(R.color.zxing_viewfinder_mask));
        this.i = typedArrayObtainStyledAttributes.getColor(R.styleable.zxing_finder_zxing_result_view, resources.getColor(R.color.zxing_result_view));
        this.j = typedArrayObtainStyledAttributes.getColor(R.styleable.zxing_finder_zxing_viewfinder_laser, resources.getColor(R.color.zxing_viewfinder_laser));
        this.k = typedArrayObtainStyledAttributes.getColor(R.styleable.zxing_finder_zxing_possible_result_points, resources.getColor(R.color.zxing_possible_result_points));
        this.l = typedArrayObtainStyledAttributes.getBoolean(R.styleable.zxing_finder_zxing_viewfinder_laser_visibility, true);
        typedArrayObtainStyledAttributes.recycle();
        this.m = 0;
        this.n = new ArrayList(20);
        this.o = new ArrayList(20);
    }

    public void a(ResultPoint resultPoint) {
        if (this.n.size() < 20) {
            this.n.add(resultPoint);
        }
    }

    public void b() {
        com.journeyapps.barcodescanner.a aVar = this.p;
        if (aVar == null) {
            return;
        }
        Rect framingRect = aVar.getFramingRect();
        c94 previewSize = this.p.getPreviewSize();
        if (framingRect == null || previewSize == null) {
            return;
        }
        this.q = framingRect;
        this.r = previewSize;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        c94 c94Var;
        b();
        Rect rect = this.q;
        if (rect == null || (c94Var = this.r) == null) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        this.f.setColor(this.g != null ? this.i : this.h);
        float f = width;
        canvas.drawRect(0.0f, 0.0f, f, rect.top, this.f);
        canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom + 1, this.f);
        canvas.drawRect(rect.right + 1, rect.top, f, rect.bottom + 1, this.f);
        canvas.drawRect(0.0f, rect.bottom + 1, f, height, this.f);
        if (this.g != null) {
            this.f.setAlpha(160);
            canvas.drawBitmap(this.g, (Rect) null, rect, this.f);
            return;
        }
        if (this.l) {
            this.f.setColor(this.j);
            Paint paint = this.f;
            int[] iArr = s;
            paint.setAlpha(iArr[this.m]);
            this.m = (this.m + 1) % iArr.length;
            int iHeight = (rect.height() / 2) + rect.top;
            canvas.drawRect(rect.left + 2, iHeight - 1, rect.right - 1, iHeight + 2, this.f);
        }
        float width2 = getWidth() / c94Var.f;
        float height2 = getHeight() / c94Var.g;
        if (!this.o.isEmpty()) {
            this.f.setAlpha(80);
            this.f.setColor(this.k);
            for (ResultPoint resultPoint : this.o) {
                canvas.drawCircle((int) (resultPoint.getX() * width2), (int) (resultPoint.getY() * height2), 3.0f, this.f);
            }
            this.o.clear();
        }
        if (!this.n.isEmpty()) {
            this.f.setAlpha(160);
            this.f.setColor(this.k);
            for (ResultPoint resultPoint2 : this.n) {
                canvas.drawCircle((int) (resultPoint2.getX() * width2), (int) (resultPoint2.getY() * height2), 6.0f, this.f);
            }
            List list = this.n;
            List list2 = this.o;
            this.n = list2;
            this.o = list;
            list2.clear();
        }
        postInvalidateDelayed(80L, rect.left - 6, rect.top - 6, rect.right + 6, rect.bottom + 6);
    }

    public void setCameraPreview(com.journeyapps.barcodescanner.a aVar) {
        this.p = aVar;
        aVar.i(new a());
    }

    public void setLaserVisibility(boolean z) {
        this.l = z;
    }

    public void setMaskColor(int i) {
        this.h = i;
    }
}
