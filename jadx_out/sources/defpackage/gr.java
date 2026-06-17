package defpackage;

import android.graphics.Bitmap;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class gr extends nk {
    public static final byte[] b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(wq1.a);

    @Override // defpackage.wq1
    public void b(MessageDigest messageDigest) {
        messageDigest.update(b);
    }

    @Override // defpackage.nk
    public Bitmap c(kk kkVar, Bitmap bitmap, int i, int i2) {
        return os4.b(kkVar, bitmap, i, i2);
    }

    @Override // defpackage.wq1
    public boolean equals(Object obj) {
        return obj instanceof gr;
    }

    @Override // defpackage.wq1
    public int hashCode() {
        return -599754482;
    }
}
