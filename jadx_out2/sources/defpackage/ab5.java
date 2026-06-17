package defpackage;

import defpackage.p83;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ab5 {
    public static final Pattern a = Pattern.compile("player\\\\/([a-z0-9]{8})\\\\/");
    public static final Pattern b = Pattern.compile("\"jsUrl\":\"(/s/player/[A-Za-z0-9]+/player_ias\\.vflset/[A-Za-z_-]+/base\\.js)\"");

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String a(String str) {
        return str.startsWith("//") ? "https:".concat(str) : str.startsWith(ServiceReference.DELIMITER) ? "https://www.youtube.com".concat(str) : str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String b(String str) throws s83 {
        try {
            return a33.a().c(str, pz1.h).c();
        } catch (Exception e) {
            uo1.a("Could not get JavaScript base player's code", e);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String c(String str) throws s83 {
        try {
            String strA = a(e());
            new URL(strA);
            return b(strA);
        } catch (Exception unused) {
            String strA2 = a(d(str));
            try {
                new URL(strA2);
                return b(strA2);
            } catch (MalformedURLException e) {
                uo1.a("The extracted and built JavaScript URL is invalid", e);
                return null;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String d(String str) throws s83 {
        try {
            String strC = a33.a().c("https://www.youtube.com/embed/" + str, pz1.h).c();
            Iterator<E> it = cp1.a(strC).R0("script").g("name", "player/base").iterator();
            while (it.hasNext()) {
                String strE = ((br0) it.next()).e("src");
                if (strE.contains("base.js")) {
                    return strE;
                }
            }
            try {
                return p83.l(b, strC);
            } catch (p83.a e) {
                uo1.a("Embedded watch page didn't provide JavaScript base player's URL", e);
                return null;
            }
        } catch (Exception e2) {
            uo1.a("Could not fetch embedded watch page", e2);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String e() throws s83 {
        try {
            try {
                return String.format("https://www.youtube.com/s/player/%s/player_ias.vflset/en_GB/base.js", p83.l(a, a33.a().c("https://www.youtube.com/iframe_api", pz1.h).c()));
            } catch (p83.a e) {
                uo1.a("IFrame resource didn't provide JavaScript base player's hash", e);
                return null;
            }
        } catch (Exception e2) {
            uo1.a("Could not fetch IFrame resource", e2);
            return null;
        }
    }
}
