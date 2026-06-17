package defpackage;

import android.net.Uri;
import defpackage.ja0;
import defpackage.xy1;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class t83 implements xy1.e {
    public final long a;
    public final ja0 b;
    public final int c;
    public final ne4 d;
    public final a e;
    public volatile Object f;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        Object a(Uri uri, InputStream inputStream);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public t83(aa0 aa0Var, ja0 ja0Var, int i, a aVar) {
        this.d = new ne4(aa0Var);
        this.b = ja0Var;
        this.c = i;
        this.e = aVar;
        this.a = ty1.b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long a() {
        return this.d.h();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // xy1.e
    public final void b() {
        this.d.v();
        ha0 ha0Var = new ha0(this.d, this.b);
        try {
            ha0Var.c();
            this.f = this.e.a((Uri) gg3.q(this.d.getUri()), ha0Var);
        } finally {
            fy4.p(ha0Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // xy1.e
    public final void c() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Map d() {
        return this.d.u();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object e() {
        return this.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Uri f() {
        return this.d.t();
    }

    public t83(aa0 aa0Var, Uri uri, int i, a aVar) {
        this(aa0Var, new ja0.b().i(uri).b(1).a(), i, aVar);
    }
}
