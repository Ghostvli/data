package defpackage;

import android.net.Uri;
import defpackage.db4;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class oz4 implements db4.a {
    @Override // db4.a
    public void a() {
    }

    @Override // db4.a
    public boolean b(Uri uri) {
        return "video".equals(qx4.i(uri));
    }

    @Override // db4.a
    public String c(String str) {
        return str.substring(8);
    }

    @Override // db4.a
    public void stop() {
    }
}
