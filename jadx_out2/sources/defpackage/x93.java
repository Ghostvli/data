package defpackage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class x93 extends gu1 {
    public static final x93 a = new x93();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static x93 o() {
        return a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wt1
    public String e(String str) {
        return n(p83.i("/((accounts|a)|(video-channels|c))/([^/?&#]*)", str, 0));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wt1
    public boolean h(String str) {
        try {
            new URL(str);
            if (!str.contains("/accounts/") && !str.contains("/a/") && !str.contains("/video-channels/")) {
                if (!str.contains("/c/")) {
                    return false;
                }
            }
            return true;
        } catch (MalformedURLException unused) {
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gu1
    public String l(String str, List list, String str2) {
        return m(str, list, str2, x14.d.m());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gu1
    public String m(String str, List list, String str2, String str3) {
        if (!str.matches("((accounts|a)|(video-channels|c))/([^/?&#]*)")) {
            return str3 + "/accounts/" + str;
        }
        return str3 + ServiceReference.DELIMITER + n(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String n(String str) {
        if (str.startsWith(ServiceReference.DELIMITER)) {
            str = str.substring(1);
        }
        return str.startsWith("a/") ? "accounts".concat(str.substring(1)) : str.startsWith("c/") ? "video-channels".concat(str.substring(1)) : str;
    }
}
