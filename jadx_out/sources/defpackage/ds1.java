package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ds1 implements yr3, zj1 {
    public final Resources f;
    public final yr3 g;

    public ds1(Resources resources, yr3 yr3Var) {
        this.f = (Resources) fg3.e(resources);
        this.g = (yr3) fg3.e(yr3Var);
    }

    public static yr3 f(Resources resources, yr3 yr3Var) {
        if (yr3Var == null) {
            return null;
        }
        return new ds1(resources, yr3Var);
    }

    @Override // defpackage.zj1
    public void a() {
        yr3 yr3Var = this.g;
        if (yr3Var instanceof zj1) {
            ((zj1) yr3Var).a();
        }
    }

    @Override // defpackage.yr3
    public void b() {
        this.g.b();
    }

    @Override // defpackage.yr3
    public int c() {
        return this.g.c();
    }

    @Override // defpackage.yr3
    public Class d() {
        return BitmapDrawable.class;
    }

    @Override // defpackage.yr3
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.f, (Bitmap) this.g.get());
    }
}
