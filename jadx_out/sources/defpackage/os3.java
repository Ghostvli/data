package defpackage;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.util.Log;
import defpackage.vt2;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class os3 implements vt2 {
    public final Context a;
    public final vt2 b;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements wt2 {
        public final Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // defpackage.wt2
        public void d() {
        }

        @Override // defpackage.wt2
        public vt2 e(bw2 bw2Var) {
            return new os3(this.a, bw2Var.d(Integer.class, AssetFileDescriptor.class));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements wt2 {
        public final Context a;

        public b(Context context) {
            this.a = context;
        }

        @Override // defpackage.wt2
        public void d() {
        }

        @Override // defpackage.wt2
        public vt2 e(bw2 bw2Var) {
            return new os3(this.a, bw2Var.d(Integer.class, InputStream.class));
        }
    }

    public os3(Context context, vt2 vt2Var) {
        this.a = context.getApplicationContext();
        this.b = vt2Var;
    }

    public static wt2 e(Context context) {
        return new a(context);
    }

    public static wt2 f(Context context) {
        return new b(context);
    }

    @Override // defpackage.vt2
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public vt2.a b(Uri uri, int i, int i2, u63 u63Var) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 1) {
            return g(uri, i, i2, u63Var);
        }
        if (pathSegments.size() == 2) {
            return h(uri, i, i2, u63Var);
        }
        if (!Log.isLoggable("ResourceUriLoader", 5)) {
            return null;
        }
        Log.w("ResourceUriLoader", "Failed to parse resource uri: " + uri);
        return null;
    }

    @Override // defpackage.vt2
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return "android.resource".equals(uri.getScheme()) && this.a.getPackageName().equals(uri.getAuthority());
    }

    public final vt2.a g(Uri uri, int i, int i2, u63 u63Var) {
        try {
            int i3 = Integer.parseInt(uri.getPathSegments().get(0));
            if (i3 != 0) {
                return this.b.b(Integer.valueOf(i3), i, i2, u63Var);
            }
            if (Log.isLoggable("ResourceUriLoader", 5)) {
                Log.w("ResourceUriLoader", "Failed to parse a valid non-0 resource id from: " + uri);
            }
            return null;
        } catch (NumberFormatException e) {
            if (Log.isLoggable("ResourceUriLoader", 5)) {
                Log.w("ResourceUriLoader", "Failed to parse resource id from: " + uri, e);
            }
            return null;
        }
    }

    public final vt2.a h(Uri uri, int i, int i2, u63 u63Var) {
        List<String> pathSegments = uri.getPathSegments();
        int identifier = this.a.getResources().getIdentifier(pathSegments.get(1), pathSegments.get(0), this.a.getPackageName());
        if (identifier != 0) {
            return this.b.b(Integer.valueOf(identifier), i, i2, u63Var);
        }
        if (!Log.isLoggable("ResourceUriLoader", 5)) {
            return null;
        }
        Log.w("ResourceUriLoader", "Failed to find resource id for: " + uri);
        return null;
    }
}
