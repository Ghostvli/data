package defpackage;

import android.content.res.Resources;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class bk implements ds3 {
    public final ds3 a;
    public final Resources b;

    public bk(Resources resources, ds3 ds3Var) {
        this.b = (Resources) fg3.e(resources);
        this.a = (ds3) fg3.e(ds3Var);
    }

    @Override // defpackage.ds3
    public boolean a(Object obj, u63 u63Var) {
        return this.a.a(obj, u63Var);
    }

    @Override // defpackage.ds3
    public yr3 b(Object obj, int i, int i2, u63 u63Var) {
        return ds1.f(this.b, this.a.b(obj, i, i2, u63Var));
    }
}
