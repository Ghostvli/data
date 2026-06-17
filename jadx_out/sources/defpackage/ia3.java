package defpackage;

import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class ia3 extends wt1 {
    public static final ia3 a = new ia3();

    public static ia3 i() {
        return a;
    }

    @Override // defpackage.wt1
    public String e(String str) {
        return p83.i("(/w/|(/videos/(watch/|embed/)?))(?!p/)([^/?&#]*)", str, 4);
    }

    @Override // defpackage.wt1
    public String f(String str) {
        return g(str, x14.d.m());
    }

    @Override // defpackage.wt1
    public String g(String str, String str2) {
        return str2 + "/videos/watch/" + str;
    }

    @Override // defpackage.wt1
    public boolean h(String str) {
        if (str.contains("/playlist/")) {
            return false;
        }
        try {
            new URL(str);
            e(str);
            return true;
        } catch (MalformedURLException | s83 unused) {
            return false;
        }
    }
}
