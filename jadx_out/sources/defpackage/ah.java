package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import defpackage.a6;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ah {
    public abstract void a();

    public boolean b(ih ihVar, Canvas canvas, float f, float f2, Paint paint, TextPaint textPaint) {
        ko0 ko0Var;
        hh1 hh1VarE = ihVar.e();
        if (hh1VarE == null || (ko0Var = (ko0) hh1VarE.get()) == null) {
            return false;
        }
        return ko0Var.b(canvas, f, f2, paint);
    }

    public abstract void c(ih ihVar, Canvas canvas, float f, float f2, boolean z, a6.a aVar);

    public abstract void d(ih ihVar, TextPaint textPaint, boolean z);

    public void e(ih ihVar, boolean z) {
    }

    public void f(ih ihVar) {
    }
}
