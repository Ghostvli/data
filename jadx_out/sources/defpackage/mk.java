package defpackage;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class mk implements yr3, zj1 {
    public final Bitmap f;
    public final kk g;

    public mk(Bitmap bitmap, kk kkVar) {
        this.f = (Bitmap) fg3.f(bitmap, "Bitmap must not be null");
        this.g = (kk) fg3.f(kkVar, "BitmapPool must not be null");
    }

    public static mk f(Bitmap bitmap, kk kkVar) {
        if (bitmap == null) {
            return null;
        }
        return new mk(bitmap, kkVar);
    }

    @Override // defpackage.zj1
    public void a() {
        this.f.prepareToDraw();
    }

    @Override // defpackage.yr3
    public void b() {
        this.g.c(this.f);
    }

    @Override // defpackage.yr3
    public int c() {
        return iy4.i(this.f);
    }

    @Override // defpackage.yr3
    public Class d() {
        return Bitmap.class;
    }

    @Override // defpackage.yr3
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Bitmap get() {
        return this.f;
    }
}
