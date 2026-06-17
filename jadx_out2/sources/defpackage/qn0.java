package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class qn0 {
    public static Paint a = null;
    public static Paint b = null;
    public static RectF c = null;
    public static boolean d = true;
    public static boolean e = true;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        Paint paint = new Paint();
        a = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        a.setColor(0);
        c = new RectF();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void a(Canvas canvas) {
        if (!d) {
            c.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
            c(canvas, c);
        } else if (e) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        } else {
            canvas.drawColor(0);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void b(Canvas canvas, float f, float f2, float f3, float f4) {
        c.set(f, f2, f3, f4);
        c(canvas, c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void c(Canvas canvas, RectF rectF) {
        if (rectF.width() <= 0.0f || rectF.height() <= 0.0f) {
            return;
        }
        canvas.drawRect(rectF, a);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void d(Canvas canvas, String str) {
        if (b == null) {
            Paint paint = new Paint();
            b = paint;
            paint.setColor(-65536);
            b.setTextSize(30.0f);
        }
        int height = canvas.getHeight();
        b(canvas, 10.0f, height - 100, (int) (b.measureText(str) + 20.0f), canvas.getHeight());
        canvas.drawText(str, 10.0f, height - 50, b);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void e(boolean z, boolean z2) {
        d = z;
        e = z2;
    }
}
