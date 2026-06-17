package defpackage;

import android.graphics.Bitmap;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ek implements gs3 {
    public static final s63 b = s63.f("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    public static final s63 c = s63.e("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    public final ma a;

    public ek(ma maVar) {
        this.a = maVar;
    }

    @Override // defpackage.gs3
    public ms0 b(u63 u63Var) {
        return ms0.TRANSFORMED;
    }

    @Override // defpackage.ns0
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(yr3 yr3Var, File file, u63 u63Var) {
        boolean z;
        FileOutputStream fileOutputStream;
        Bitmap bitmap = (Bitmap) yr3Var.get();
        Bitmap.CompressFormat compressFormatD = d(bitmap, u63Var);
        qa1.d("encode: [%dx%d] %s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), compressFormatD);
        try {
            long jB = b02.b();
            int iIntValue = ((Integer) u63Var.c(b)).intValue();
            OutputStream amVar = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e) {
                e = e;
            }
            try {
                amVar = this.a != null ? new am(fileOutputStream, this.a) : fileOutputStream;
                bitmap.compress(compressFormatD, iIntValue, amVar);
                amVar.close();
                try {
                    amVar.close();
                } catch (IOException unused) {
                }
                z = true;
            } catch (IOException e2) {
                e = e2;
                amVar = fileOutputStream;
                if (Log.isLoggable("BitmapEncoder", 3)) {
                    Log.d("BitmapEncoder", "Failed to encode Bitmap", e);
                }
                if (amVar != null) {
                    try {
                        amVar.close();
                    } catch (IOException unused2) {
                    }
                }
                z = false;
            } catch (Throwable th2) {
                th = th2;
                amVar = fileOutputStream;
                if (amVar != null) {
                    try {
                        amVar.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
            if (Log.isLoggable("BitmapEncoder", 2)) {
                Log.v("BitmapEncoder", "Compressed with type: " + compressFormatD + " of size " + iy4.i(bitmap) + " in " + b02.a(jB) + ", options format: " + u63Var.c(c) + ", hasAlpha: " + bitmap.hasAlpha());
            }
            return z;
        } finally {
            qa1.e();
        }
    }

    public final Bitmap.CompressFormat d(Bitmap bitmap, u63 u63Var) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) u63Var.c(c);
        return compressFormat != null ? compressFormat : bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }
}
