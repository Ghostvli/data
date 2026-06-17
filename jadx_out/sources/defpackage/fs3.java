package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class fs3 implements ds3 {
    public static final s63 b = s63.e("com.bumptech.glide.load.resource.bitmap.Downsampler.Theme");
    public final Context a;

    public fs3(Context context) {
        this.a = context.getApplicationContext();
    }

    @Override // defpackage.ds3
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public yr3 b(Uri uri, int i, int i2, u63 u63Var) {
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            wx1.a("Package name for ", uri, " is null or empty");
            return null;
        }
        Context contextD = d(uri, authority);
        int iG = g(contextD, uri);
        Resources.Theme theme = ((String) fg3.e(authority)).equals(this.a.getPackageName()) ? (Resources.Theme) u63Var.c(b) : null;
        Context context = this.a;
        return v33.f(theme == null ? un0.b(context, contextD, iG) : un0.a(context, iG, theme));
    }

    public final Context d(Uri uri, String str) {
        boolean zEquals = str.equals(this.a.getPackageName());
        Context context = this.a;
        if (zEquals) {
            return context;
        }
        try {
            return context.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            if (str.contains(this.a.getPackageName())) {
                return this.a;
            }
            kp4.a("Failed to obtain context or unrecognized Uri format for: ", uri, e);
            return null;
        }
    }

    public final int e(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e) {
            kp4.a("Unrecognized Uri format: ", uri, e);
            return 0;
        }
    }

    public final int f(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, "android");
        }
        if (identifier != 0) {
            return identifier;
        }
        c.a("Failed to find resource id for: ", uri);
        return 0;
    }

    public final int g(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return f(context, uri);
        }
        if (pathSegments.size() == 1) {
            return e(uri);
        }
        c.a("Unrecognized Uri format: ", uri);
        return 0;
    }

    @Override // defpackage.ds3
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri, u63 u63Var) {
        String scheme = uri.getScheme();
        return scheme != null && scheme.equals("android.resource");
    }
}
