package tv.cjump.jni;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import defpackage.nk0;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NativeBitmapFactory {
    public static Field a;
    public static boolean b;
    public static boolean c;

    public static Bitmap a(int i, int i2, Bitmap.Config config) {
        return b(i, i2, config, config.equals(Bitmap.Config.ARGB_4444) || config.equals(Bitmap.Config.ARGB_8888));
    }

    public static synchronized Bitmap b(int i, int i2, Bitmap.Config config, boolean z) {
        if (b && a != null) {
            return c(i, i2, config, z);
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    public static Bitmap c(int i, int i2, Bitmap.Config config, boolean z) {
        return createBitmap(i, i2, d(config), z);
    }

    private static native Bitmap createBitmap(int i, int i2, int i3, boolean z);

    private static native Bitmap createBitmap19(int i, int i2, int i3, boolean z);

    public static int d(Bitmap.Config config) {
        try {
            Field field = a;
            if (field == null) {
                return 0;
            }
            return field.getInt(config);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return 0;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static void e() {
        try {
            Field declaredField = Bitmap.Config.class.getDeclaredField("nativeInt");
            a = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            a = null;
            e.printStackTrace();
        }
    }

    public static void f() {
        if (c) {
            return;
        }
        if (!nk0.g() && !nk0.h()) {
            c = true;
            b = false;
            return;
        }
        if (b) {
            return;
        }
        try {
            c = true;
            b = false;
        } catch (Error e) {
            e.printStackTrace();
            c = true;
            b = false;
        } catch (Exception e2) {
            e2.printStackTrace();
            c = true;
            b = false;
        }
        if (b) {
            if (init()) {
                e();
                if (!h()) {
                    release();
                    c = true;
                    b = false;
                }
            } else {
                release();
                c = true;
                b = false;
            }
        }
        Log.e("NativeBitmapFactory", "loaded" + b);
    }

    public static synchronized void g() {
        boolean z = b;
        a = null;
        b = false;
        if (z) {
            release();
        }
    }

    public static boolean h() {
        if (a == null) {
            return false;
        }
        Bitmap bitmapC = null;
        try {
            try {
                bitmapC = c(2, 2, Bitmap.Config.ARGB_8888, true);
                boolean zIsPremultiplied = bitmapC != null && bitmapC.getWidth() == 2 && bitmapC.getHeight() == 2;
                if (zIsPremultiplied) {
                    if (!bitmapC.isPremultiplied()) {
                        bitmapC.setPremultiplied(true);
                    }
                    Canvas canvas = new Canvas(bitmapC);
                    Paint paint = new Paint();
                    paint.setColor(-65536);
                    paint.setTextSize(20.0f);
                    canvas.drawRect(0.0f, 0.0f, bitmapC.getWidth(), bitmapC.getHeight(), paint);
                    canvas.drawText("TestLib", 0.0f, 0.0f, paint);
                    zIsPremultiplied = bitmapC.isPremultiplied();
                }
                if (bitmapC != null) {
                    bitmapC.recycle();
                }
                return zIsPremultiplied;
            } catch (Error unused) {
                if (bitmapC != null) {
                    bitmapC.recycle();
                }
                return false;
            } catch (Exception e) {
                Log.e("NativeBitmapFactory", "exception:" + e.toString());
                if (bitmapC != null) {
                    bitmapC.recycle();
                }
                return false;
            }
        } catch (Throwable th) {
            if (bitmapC != null) {
                bitmapC.recycle();
            }
            throw th;
        }
    }

    private static native boolean init();

    private static native boolean release();
}
