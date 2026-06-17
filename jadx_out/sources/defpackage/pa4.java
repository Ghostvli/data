package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class pa4 extends gu1 {
    public static final pa4 a = new pa4();

    public static pa4 n() {
        return a;
    }

    @Override // defpackage.wt1
    public String e(String str) throws s83 {
        yy4.c("^https?://(www\\.|m\\.)?soundcloud.com/[0-9a-z_-]+(/((tracks|albums|sets|reposts|followers|following)/?)?)?([#?].*)?$", str);
        try {
            return sa4.n(str);
        } catch (Exception e) {
            throw new s83(e.getMessage(), e);
        }
    }

    @Override // defpackage.wt1
    public boolean h(String str) {
        return p83.g("^https?://(www\\.|m\\.)?soundcloud.com/[0-9a-z_-]+(/((tracks|albums|sets|reposts|followers|following)/?)?)?([#?].*)?$", str.toLowerCase());
    }

    @Override // defpackage.gu1
    public String l(String str, List list, String str2) throws s83 {
        try {
            return sa4.o("https://api.soundcloud.com/users/" + str);
        } catch (Exception e) {
            throw new s83(e.getMessage(), e);
        }
    }
}
