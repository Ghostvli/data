package defpackage;

import android.content.Context;
import android.net.Uri;
import defpackage.vt2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class jr2 implements vt2 {
    public final Context a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a implements wt2 {
        public final Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // defpackage.wt2
        public void d() {
        }

        @Override // defpackage.wt2
        public vt2 e(bw2 bw2Var) {
            return new jr2(this.a);
        }
    }

    public jr2(Context context) {
        this.a = context.getApplicationContext();
    }

    @Override // defpackage.vt2
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public vt2.a b(Uri uri, int i, int i2, u63 u63Var) {
        if (kr2.f(i, i2)) {
            return new vt2.a(new t43(uri), un4.f(this.a, uri));
        }
        return null;
    }

    @Override // defpackage.vt2
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return kr2.b(uri);
    }
}
