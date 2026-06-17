package defpackage;

import android.content.ContentResolver;
import android.net.Uri;
import defpackage.vt2;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class jx4 implements vt2 {
    public static final Set b = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "content", "android.resource")));
    public final c a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements wt2, c {
        public final ContentResolver a;
        public final boolean b;

        public a(ContentResolver contentResolver, boolean z) {
            this.a = contentResolver;
            this.b = z;
        }

        @Override // jx4.c
        public t90 a(Uri uri) {
            return new za(this.a, uri, this.b);
        }

        @Override // defpackage.wt2
        public void d() {
        }

        @Override // defpackage.wt2
        public vt2 e(bw2 bw2Var) {
            return new jx4(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b implements wt2, c {
        public final ContentResolver a;
        public final boolean b;

        public b(ContentResolver contentResolver, boolean z) {
            this.a = contentResolver;
            this.b = z;
        }

        @Override // jx4.c
        public t90 a(Uri uri) {
            return new k01(this.a, uri, this.b);
        }

        @Override // defpackage.wt2
        public void d() {
        }

        @Override // defpackage.wt2
        public vt2 e(bw2 bw2Var) {
            return new jx4(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface c {
        t90 a(Uri uri);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d implements wt2, c {
        public final ContentResolver a;
        public final boolean b;

        public d(ContentResolver contentResolver, boolean z) {
            this.a = contentResolver;
            this.b = z;
        }

        @Override // jx4.c
        public t90 a(Uri uri) {
            return new cf4(this.a, uri, this.b);
        }

        @Override // defpackage.wt2
        public void d() {
        }

        @Override // defpackage.wt2
        public vt2 e(bw2 bw2Var) {
            return new jx4(this);
        }
    }

    public jx4(c cVar) {
        this.a = cVar;
    }

    @Override // defpackage.vt2
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public vt2.a b(Uri uri, int i, int i2, u63 u63Var) {
        return new vt2.a(new t43(uri), this.a.a(uri));
    }

    @Override // defpackage.vt2
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return b.contains(uri.getScheme());
    }
}
