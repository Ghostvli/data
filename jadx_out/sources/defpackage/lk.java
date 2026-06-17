package defpackage;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class lk implements kk {
    @Override // defpackage.kk
    public void a(int i) {
    }

    @Override // defpackage.kk
    public void b() {
    }

    @Override // defpackage.kk
    public void c(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // defpackage.kk
    public Bitmap d(int i, int i2, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }

    @Override // defpackage.kk
    public Bitmap e(int i, int i2, Bitmap.Config config) {
        return d(i, i2, config);
    }
}
