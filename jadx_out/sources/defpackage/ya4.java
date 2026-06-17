package defpackage;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class ya4 extends wt1 {
    public static final ya4 a = new ya4();
    public static final Pattern b = Pattern.compile("^https?://(?:www\\.|m\\.)?soundcloud.com/[0-9a-z_-]+/(?!(?:tracks|albums|sets|reposts|followers|following)/?$)[0-9a-z_-]+/?(?:[#?].*)?$|^https?://on\\.soundcloud\\.com/[0-9a-zA-Z]+$");
    public static final Pattern c = Pattern.compile("^https?://api-v2\\.soundcloud.com/(tracks|albums|sets|reposts|followers|following)/([0-9a-z_-]+)/");

    public static ya4 i() {
        return a;
    }

    @Override // defpackage.wt1
    public String e(String str) throws s83 {
        Pattern pattern = c;
        if (p83.h(pattern, str)) {
            return p83.l(pattern, str);
        }
        yy4.d(b, str);
        try {
            return sa4.n(str);
        } catch (Exception e) {
            throw new s83(e.getMessage(), e);
        }
    }

    @Override // defpackage.wt1
    public String f(String str) throws s83 {
        try {
            return sa4.o("https://api.soundcloud.com/tracks/" + str);
        } catch (Exception e) {
            throw new s83(e.getMessage(), e);
        }
    }

    @Override // defpackage.wt1
    public boolean h(String str) {
        return p83.h(b, str.toLowerCase());
    }
}
