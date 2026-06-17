package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.a;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class lf extends ts1 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ts1
    public void a(Context context, a aVar, up3 up3Var) {
        jf jfVar = new jf(aVar.f());
        up3Var.o("Bitmap", ByteBuffer.class, Bitmap.class, jfVar);
        up3Var.o("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new bk(context.getResources(), jfVar));
        ds3 mfVar = new mf(up3Var.g(), jfVar, aVar.e());
        up3Var.o("Bitmap", InputStream.class, Bitmap.class, mfVar);
        up3Var.o("BitmapDrawable", InputStream.class, BitmapDrawable.class, new bk(context.getResources(), mfVar));
    }
}
