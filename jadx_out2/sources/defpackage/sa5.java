package defpackage;

import java.net.URL;
import java.util.List;
import java.util.regex.Pattern;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class sa5 extends gu1 {
    public static final sa5 a = new sa5();
    public static final Pattern b = Pattern.compile("playlist|watch|attribution_link|watch_popup|embed|feed|select_site|account|reporthistory|redirect");

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static sa5 n() {
        return a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wt1
    public String e(String str) throws s83 {
        try {
            URL urlV = yy4.v(str);
            String path = urlV.getPath();
            if (!yy4.m(urlV) || (!cc5.f0(urlV) && !cc5.X(urlV) && !cc5.W(urlV))) {
                throw new s83("The URL given is not a YouTube URL");
            }
            String strSubstring = path.substring(1);
            String[] strArrSplit = strSubstring.split(ServiceReference.DELIMITER);
            if (!p(strArrSplit) && !o(strArrSplit)) {
                if (!strSubstring.startsWith("user/") && !strSubstring.startsWith("channel/") && !strSubstring.startsWith("c/")) {
                    throw new s83("The given URL is not a channel, a user or a handle URL");
                }
                String str2 = strArrSplit[1];
                if (yy4.l(str2)) {
                    throw new s83("The given ID is not a YouTube channel or user ID");
                }
                return strArrSplit[0] + ServiceReference.DELIMITER + str2;
            }
            return strArrSplit[0];
        } catch (Exception e) {
            throw new s83("Could not parse URL :" + e.getMessage(), e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wt1
    public boolean h(String str) {
        try {
            e(str);
            return true;
        } catch (s83 unused) {
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gu1
    public String l(String str, List list, String str2) {
        return "https://www.youtube.com/" + str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean o(String[] strArr) {
        return (strArr.length != 1 || strArr[0].isEmpty() || b.matcher(strArr[0]).matches()) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean p(String[] strArr) {
        return strArr.length > 0 && strArr[0].startsWith("@");
    }
}
