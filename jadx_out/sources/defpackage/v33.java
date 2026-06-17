package defpackage;

import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class v33 extends wn0 {
    public v33(Drawable drawable) {
        super(drawable);
    }

    public static yr3 f(Drawable drawable) {
        if (drawable != null) {
            return new v33(drawable);
        }
        return null;
    }

    @Override // defpackage.yr3
    public void b() {
    }

    @Override // defpackage.yr3
    public int c() {
        return Math.max(1, this.f.getIntrinsicWidth() * this.f.getIntrinsicHeight() * 4);
    }

    @Override // defpackage.yr3
    public Class d() {
        return this.f.getClass();
    }
}
