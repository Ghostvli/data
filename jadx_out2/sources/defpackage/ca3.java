package defpackage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class ca3 extends gu1 {
    public static final ca3 a = new ca3();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ca3 n() {
        return a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wt1
    public String e(String str) {
        try {
            return p83.i("(/videos/watch/playlist/|/w/p/)([^/?&#]*)", str, 2);
        } catch (s83 unused) {
            return p83.k("/video-playlists/([^/?&#]*)", str);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wt1
    public boolean h(String str) {
        try {
            new URL(str);
            e(str);
            return true;
        } catch (MalformedURLException | s83 unused) {
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
        return str3 + "/api/v1/video-playlists/" + str;
    }
}
