package defpackage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class gc5 extends gu1 {
    public static final gc5 a = new gc5();

    public static gc5 n() {
        return a;
    }

    @Override // defpackage.wt1
    public String e(String str) throws s83 {
        try {
            URL urlV = yy4.v(str);
            if (!yy4.m(urlV) || (!cc5.f0(urlV) && !cc5.X(urlV))) {
                throw new s83("the url given is not a YouTube-URL");
            }
            String path = urlV.getPath();
            if (!path.equals("/watch") && !path.equals("/playlist")) {
                throw new s83("the url given is neither a video nor a playlist URL");
            }
            String strI = yy4.i(urlV, "list");
            if (strI == null) {
                throw new s83("the URL given does not include a playlist");
            }
            if (strI.matches("[a-zA-Z0-9_-]{10,}")) {
                return strI;
            }
            throw new s83("the list-ID given in the URL does not match the list pattern");
        } catch (Exception e) {
            throw new s83("Error could not parse URL: " + e.getMessage(), e);
        }
    }

    @Override // defpackage.wt1
    public boolean h(String str) {
        try {
            e(str);
            return true;
        } catch (s83 unused) {
            return false;
        }
    }

    @Override // defpackage.gu1, defpackage.wt1
    /* JADX INFO: renamed from: j */
    public fu1 c(String str) {
        try {
            URL urlV = yy4.v(str);
            String strI = yy4.i(urlV, "list");
            if (strI == null || !cc5.b0(strI)) {
                return super.c(str);
            }
            String strI2 = yy4.i(urlV, "v");
            if (strI2 == null) {
                strI2 = cc5.s(strI);
            }
            return new fu1(new vt1(str, "https://www.youtube.com/watch?v=" + strI2 + "&list=" + strI, strI));
        } catch (MalformedURLException e) {
            throw new s83("Error could not parse URL: " + e.getMessage(), e);
        }
    }

    @Override // defpackage.gu1
    public String l(String str, List list, String str2) {
        return "https://www.youtube.com/playlist?list=" + str;
    }
}
