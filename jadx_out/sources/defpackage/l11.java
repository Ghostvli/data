package defpackage;

import android.net.Uri;
import defpackage.t83;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class l11 implements t83.a {
    public final t83.a a;
    public final List b;

    public l11(t83.a aVar, List list) {
        this.a = aVar;
        this.b = list;
    }

    @Override // t83.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public j11 a(Uri uri, InputStream inputStream) {
        j11 j11Var = (j11) this.a.a(uri, inputStream);
        List list = this.b;
        return (list == null || list.isEmpty()) ? j11Var : (j11) j11Var.a(this.b);
    }
}
