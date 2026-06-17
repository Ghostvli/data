package defpackage;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class gw4 implements ds3 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements yr3 {
        public final Bitmap f;

        public a(Bitmap bitmap) {
            this.f = bitmap;
        }

        @Override // defpackage.yr3
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap get() {
            return this.f;
        }

        @Override // defpackage.yr3
        public void b() {
        }

        @Override // defpackage.yr3
        public int c() {
            return iy4.i(this.f);
        }

        @Override // defpackage.yr3
        public Class d() {
            return Bitmap.class;
        }
    }

    @Override // defpackage.ds3
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public yr3 b(Bitmap bitmap, int i, int i2, u63 u63Var) {
        return new a(bitmap);
    }

    @Override // defpackage.ds3
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Bitmap bitmap, u63 u63Var) {
        return true;
    }
}
