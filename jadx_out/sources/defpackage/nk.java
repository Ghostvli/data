package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.a;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class nk implements ns4 {
    @Override // defpackage.ns4
    public final yr3 a(Context context, yr3 yr3Var, int i, int i2) {
        if (!iy4.u(i, i2)) {
            ix2.a("Cannot apply transformation on width: ", i, " or height: ", i2, " less than or equal to zero and not Target.SIZE_ORIGINAL");
            return null;
        }
        kk kkVarF = a.c(context).f();
        Bitmap bitmap = (Bitmap) yr3Var.get();
        if (i == Integer.MIN_VALUE) {
            i = bitmap.getWidth();
        }
        if (i2 == Integer.MIN_VALUE) {
            i2 = bitmap.getHeight();
        }
        Bitmap bitmapC = c(kkVarF, bitmap, i, i2);
        return bitmap.equals(bitmapC) ? yr3Var : mk.f(bitmapC, kkVarF);
    }

    public abstract Bitmap c(kk kkVar, Bitmap bitmap, int i, int i2);
}
