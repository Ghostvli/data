package defpackage;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k41 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public final Uri a;
        public final int b;
        public final int c;
        public final boolean d;
        public final int e;

        public b(Uri uri, int i, int i2, boolean z, int i3) {
            this.a = (Uri) hg3.g(uri);
            this.b = i;
            this.c = i2;
            this.d = z;
            this.e = i3;
        }

        public static b a(Uri uri, int i, int i2, boolean z, int i3) {
            return new b(uri, i, i2, z, i3);
        }

        public int b() {
            return this.e;
        }

        public int c() {
            return this.b;
        }

        public Uri d() {
            return this.a;
        }

        public int e() {
            return this.c;
        }

        public boolean f() {
            return this.d;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c {
        public abstract void a(int i);

        public abstract void b(Typeface typeface);
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b[] bVarArr) {
        return bv4.b(context, cancellationSignal, bVarArr, 0);
    }

    public static a b(Context context, CancellationSignal cancellationSignal, g41 g41Var) {
        return f41.e(context, av4.a(new Object[]{g41Var}), cancellationSignal);
    }

    public static Typeface c(Context context, List list, int i, boolean z, int i2, Handler handler, c cVar) {
        wo woVar = new wo(cVar, fr3.b(handler));
        if (!z) {
            return i41.d(context, list, i, null, woVar);
        }
        if (list.size() <= 1) {
            return i41.e(context, (g41) list.get(0), woVar, i, i2);
        }
        jl.a("Fallbacks with blocking fetches are not supported for performance reasons");
        return null;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public final int a;
        public final List b;

        public a(int i, b[] bVarArr) {
            this.a = i;
            this.b = Collections.singletonList(bVarArr);
        }

        public static a a(int i, List list) {
            return new a(i, list);
        }

        public static a b(int i, b[] bVarArr) {
            return new a(i, bVarArr);
        }

        public b[] c() {
            return (b[]) this.b.get(0);
        }

        public List d() {
            return this.b;
        }

        public int e() {
            return this.a;
        }

        public boolean f() {
            return this.b.size() > 1;
        }

        public a(int i, List list) {
            this.a = i;
            this.b = list;
        }
    }
}
