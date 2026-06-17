package defpackage;

import android.net.Uri;
import defpackage.vt2;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class px4 implements vt2 {
    public static final Set b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));
    public final vt2 a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a implements wt2 {
        @Override // defpackage.wt2
        public void d() {
        }

        @Override // defpackage.wt2
        public vt2 e(bw2 bw2Var) {
            return new px4(bw2Var.d(ra1.class, InputStream.class));
        }
    }

    public px4(vt2 vt2Var) {
        this.a = vt2Var;
    }

    @Override // defpackage.vt2
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public vt2.a b(Uri uri, int i, int i2, u63 u63Var) {
        return this.a.b(new ra1(uri.toString()), i, i2, u63Var);
    }

    @Override // defpackage.vt2
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return b.contains(uri.getScheme());
    }
}
