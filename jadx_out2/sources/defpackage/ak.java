package defpackage;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ak implements ns3 {
    public final Bitmap.CompressFormat a;
    public final int b;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ak() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ns3
    public yr3 a(yr3 yr3Var, u63 u63Var) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap) yr3Var.get()).compress(this.a, this.b, byteArrayOutputStream);
        yr3Var.b();
        return new jn(byteArrayOutputStream.toByteArray());
    }

    public ak(Bitmap.CompressFormat compressFormat, int i) {
        this.a = compressFormat;
        this.b = i;
    }
}
