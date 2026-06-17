package defpackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import java.lang.reflect.Array;
import tv.cjump.jni.NativeBitmapFactory;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ko0 {
    public Canvas a;
    public Bitmap b;
    public Bitmap[][] c;
    public Object d;
    public int e;
    public int f;
    public int g;

    public void a(int i, int i2, int i3, boolean z, int i4) {
        int i5 = this.e;
        if (!z ? !(i > i5 || i2 > this.f) : !(i != i5 || i2 != this.f)) {
            Bitmap bitmap = this.b;
            if (bitmap != null) {
                bitmap.eraseColor(0);
                this.a.setBitmap(this.b);
                d();
                return;
            }
        }
        if (this.b != null) {
            c();
        }
        this.e = i;
        this.f = i2;
        Bitmap.Config config = Bitmap.Config.ARGB_4444;
        if (i4 == 32) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap bitmapA = NativeBitmapFactory.a(i, i2, config);
        this.b = bitmapA;
        if (i3 > 0) {
            this.g = i3;
            bitmapA.setDensity(i3);
        }
        Canvas canvas = this.a;
        if (canvas != null) {
            canvas.setBitmap(this.b);
            return;
        }
        Canvas canvas2 = new Canvas(this.b);
        this.a = canvas2;
        canvas2.setDensity(i3);
    }

    public final synchronized boolean b(Canvas canvas, float f, float f2, Paint paint) {
        if (this.c == null) {
            Bitmap bitmap = this.b;
            if (bitmap == null) {
                return false;
            }
            canvas.drawBitmap(bitmap, f, f2, paint);
            return true;
        }
        for (int i = 0; i < this.c.length; i++) {
            int i2 = 0;
            while (true) {
                Bitmap[] bitmapArr = this.c[i];
                if (i2 < bitmapArr.length) {
                    Bitmap bitmap2 = bitmapArr[i2];
                    if (bitmap2 != null) {
                        float width = (bitmap2.getWidth() * i2) + f;
                        if (width <= canvas.getWidth() && bitmap2.getWidth() + width >= 0.0f) {
                            float height = (bitmap2.getHeight() * i) + f2;
                            if (height <= canvas.getHeight() && bitmap2.getHeight() + height >= 0.0f) {
                                canvas.drawBitmap(bitmap2, width, height, paint);
                            }
                        }
                    }
                    i2++;
                }
            }
        }
        return true;
    }

    public synchronized void c() {
        try {
            Bitmap bitmap = this.b;
            this.b = null;
            this.f = 0;
            this.e = 0;
            if (bitmap != null) {
                bitmap.recycle();
            }
            d();
            this.d = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void d() {
        Bitmap[][] bitmapArr = this.c;
        this.c = null;
        if (bitmapArr != null) {
            for (int i = 0; i < bitmapArr.length; i++) {
                int i2 = 0;
                while (true) {
                    Bitmap[] bitmapArr2 = bitmapArr[i];
                    if (i2 < bitmapArr2.length) {
                        Bitmap bitmap = bitmapArr2[i2];
                        if (bitmap != null) {
                            bitmap.recycle();
                            bitmapArr[i][i2] = null;
                        }
                        i2++;
                    }
                }
            }
        }
    }

    public void e(int i, int i2, int i3, int i4) {
        int i5;
        d();
        int i6 = this.e;
        if (i6 <= 0 || (i5 = this.f) <= 0 || this.b == null) {
            return;
        }
        if (i6 > i3 || i5 > i4) {
            int iMin = Math.min(i3, i);
            int iMin2 = Math.min(i4, i2);
            int i7 = this.e;
            int i8 = (i7 / iMin) + (i7 % iMin == 0 ? 0 : 1);
            int i9 = this.f;
            int i10 = (i9 / iMin2) + (i9 % iMin2 == 0 ? 0 : 1);
            int i11 = i7 / i8;
            int i12 = i9 / i10;
            Bitmap[][] bitmapArr = (Bitmap[][]) Array.newInstance((Class<?>) Bitmap.class, i10, i8);
            if (this.a == null) {
                Canvas canvas = new Canvas();
                this.a = canvas;
                int i13 = this.g;
                if (i13 > 0) {
                    canvas.setDensity(i13);
                }
            }
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            for (int i14 = 0; i14 < i10; i14++) {
                for (int i15 = 0; i15 < i8; i15++) {
                    Bitmap[] bitmapArr2 = bitmapArr[i14];
                    Bitmap bitmapA = NativeBitmapFactory.a(i11, i12, Bitmap.Config.ARGB_8888);
                    bitmapArr2[i15] = bitmapA;
                    int i16 = this.g;
                    if (i16 > 0) {
                        bitmapA.setDensity(i16);
                    }
                    this.a.setBitmap(bitmapA);
                    int i17 = i15 * i11;
                    int i18 = i14 * i12;
                    rect.set(i17, i18, i17 + i11, i18 + i12);
                    rect2.set(0, 0, bitmapA.getWidth(), bitmapA.getHeight());
                    this.a.drawBitmap(this.b, rect, rect2, (Paint) null);
                }
            }
            this.a.setBitmap(this.b);
            this.c = bitmapArr;
        }
    }
}
