package defpackage;

import android.net.Uri;
import com.github.catvod.utils.UriUtil;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class qx4 {
    public static String a(String str) {
        String strJ = j(str);
        String str2 = "assets".equals(strJ) ? ServiceReference.DELIMITER : "file".equals(strJ) ? "/file/" : "proxy".equals(strJ) ? "/proxy?" : null;
        if (str2 == null) {
            return str;
        }
        return str.replace(strJ + "://", t14.b().d(str2));
    }

    public static String b(String str) {
        return "User-Agent".equalsIgnoreCase(str) ? "User-Agent" : "Referer".equalsIgnoreCase(str) ? "Referer" : "Cookie".equalsIgnoreCase(str) ? "Cookie" : str;
    }

    public static String c(String str) {
        Uri uri = Uri.parse(str);
        String strF = f(uri);
        String strD = d(uri);
        return !strF.isEmpty() ? strF : !strD.isEmpty() ? strD : str;
    }

    public static String d(Uri uri) {
        String host = uri.getHost();
        return host == null ? "" : host.toLowerCase().trim();
    }

    public static String e(String str) {
        return str == null ? "" : d(Uri.parse(str));
    }

    public static String f(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        return lastPathSegment == null ? "" : lastPathSegment.trim();
    }

    public static String g(String str) {
        return str == null ? "" : f(Uri.parse(str));
    }

    public static String h(String str, String str2) {
        return UriUtil.resolve(str, str2);
    }

    public static String i(Uri uri) {
        String scheme = uri.getScheme();
        return scheme == null ? "" : scheme.toLowerCase().trim();
    }

    public static String j(String str) {
        return str == null ? "" : i(Uri.parse(str));
    }

    public static Uri k(String str) {
        return Uri.parse(str.trim().replace("\\", ""));
    }
}
