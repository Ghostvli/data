package defpackage;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ud5 implements ze4 {
    public static final Pattern e = Pattern.compile("([\\d,]+) views$");
    public final ko1 a;
    public final go4 b;
    public gf4 c;
    public Boolean d;

    public ud5(ko1 ko1Var, go4 go4Var) {
        this.a = ko1Var;
        this.b = go4Var;
    }

    public final boolean A() {
        Iterator<E> it = this.a.b("badges").iterator();
        while (it.hasNext()) {
            if (((ko1) it.next()).m("metadataBadgeRenderer").p("label", "").equals("Premium")) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.ze4
    public String a() throws s83 {
        String strO = cc5.O(this.a.m("longBylineText").b("runs").d(0).m("navigationEndpoint"));
        if (yy4.n(strO)) {
            strO = cc5.O(this.a.m("ownerText").b("runs").d(0).m("navigationEndpoint"));
            if (yy4.n(strO)) {
                String strO2 = cc5.O(this.a.m("shortBylineText").b("runs").d(0).m("navigationEndpoint"));
                if (!yy4.n(strO2)) {
                    return strO2;
                }
                ny4.a("Could not get uploader url");
                return null;
            }
        }
        return strO;
    }

    @Override // defpackage.ze4
    public boolean b() {
        return cc5.Y(this.a.b("ownerBadges"));
    }

    @Override // defpackage.ze4
    public String d() throws s83 {
        String strK = cc5.K(this.a.m("longBylineText"));
        if (yy4.n(strK)) {
            strK = cc5.K(this.a.m("ownerText"));
            if (yy4.n(strK)) {
                String strK2 = cc5.K(this.a.m("shortBylineText"));
                if (!yy4.n(strK2)) {
                    return strK2;
                }
                ny4.a("Could not get uploader name");
                return null;
            }
        }
        return strK;
    }

    @Override // defpackage.ze4
    public long e() {
        if (!A() && !z()) {
            String strK = cc5.K(this.a.m("viewCountText"));
            if (!yy4.n(strK)) {
                try {
                    return x(strK, false);
                } catch (Exception unused) {
                }
            }
            if (o() != gf4.LIVE_STREAM) {
                try {
                    return w();
                } catch (Exception unused2) {
                }
            }
            if (this.a.q("videoInfo")) {
                try {
                    return x(this.a.m("videoInfo").b("runs").d(0).p("text", ""), true);
                } catch (Exception unused3) {
                }
            }
            if (this.a.q("shortViewCountText")) {
                try {
                    String strK2 = cc5.K(this.a.m("shortViewCountText"));
                    if (!yy4.n(strK2)) {
                        return x(strK2, true);
                    }
                } catch (Exception unused4) {
                }
            }
        }
        return -1L;
    }

    @Override // defpackage.ze4
    public boolean f() {
        return A() || getName().equals("[Private video]") || getName().equals("[Deleted video]");
    }

    @Override // defpackage.ze4
    public List g() {
        boolean zQ = this.a.q("channelThumbnailSupportedRenderers");
        ko1 ko1Var = this.a;
        return zQ ? cc5.E(xo1.a(ko1Var, "channelThumbnailSupportedRenderers.channelThumbnailWithLinkRenderer.thumbnail.thumbnails")) : ko1Var.q("channelThumbnail") ? cc5.E(xo1.a(this.a, "channelThumbnail.thumbnails")) : Collections.EMPTY_LIST;
    }

    @Override // defpackage.ze4
    public long getDuration() throws s83 {
        ko1 ko1Var;
        if (o() == gf4.LIVE_STREAM) {
            return -1L;
        }
        String strK = cc5.K(this.a.m("lengthText"));
        if (yy4.n(strK)) {
            strK = this.a.o("lengthSeconds");
            if (yy4.n(strK) && (ko1Var = (ko1) this.a.b("thumbnailOverlays").stream().filter(new co1(ko1.class)).map(new e72(ko1.class)).filter(new Predicate() { // from class: rd5
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((ko1) obj).q("thumbnailOverlayTimeStatusRenderer");
                }
            }).findFirst().orElse(null)) != null) {
                strK = cc5.K(ko1Var.m("thumbnailOverlayTimeStatusRenderer").m("text"));
            }
            if (yy4.n(strK)) {
                if (z()) {
                    return -1L;
                }
                ny4.a("Could not get duration");
                return 0L;
            }
        }
        return cc5.g0(strK);
    }

    @Override // defpackage.wj1
    public String getName() throws s83 {
        ko1 ko1VarM = this.a.m("title");
        String strK = cc5.K(ko1VarM);
        if (!yy4.n(strK)) {
            return strK;
        }
        if (!yy4.p(ko1VarM) && !ko1VarM.q("runs")) {
            return "";
        }
        ny4.a("Could not get name");
        return null;
    }

    @Override // defpackage.wj1
    public String getUrl() throws s83 {
        try {
            return me5.l().f(this.a.o("videoId"));
        } catch (Exception e2) {
            uo1.a("Could not get url", e2);
            return null;
        }
    }

    @Override // defpackage.ze4
    public l20 j() {
        return z() ? l20.UPCOMING : y() ? l20.MEMBERSHIP : A() ? l20.PAID : l20.AVAILABLE;
    }

    @Override // defpackage.ze4
    public boolean k() throws s83 {
        try {
            String strO = this.a.m("navigationEndpoint").m("commandMetadata").m("webCommandMetadata").o("webPageType");
            boolean zQ = !yy4.n(strO) && strO.equals("WEB_PAGE_TYPE_SHORTS");
            if (!zQ) {
                zQ = this.a.m("navigationEndpoint").q("reelWatchEndpoint");
            }
            if (!zQ) {
                ko1 ko1Var = (ko1) this.a.b("thumbnailOverlays").stream().filter(new co1(ko1.class)).map(new e72(ko1.class)).filter(new Predicate() { // from class: sd5
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return ((ko1) obj).q("thumbnailOverlayTimeStatusRenderer");
                    }
                }).map(new Function() { // from class: td5
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return ((ko1) obj).m("thumbnailOverlayTimeStatusRenderer");
                    }
                }).findFirst().orElse(null);
                if (!yy4.p(ko1Var)) {
                    if (!ko1Var.p("style", "").equalsIgnoreCase("SHORTS")) {
                        if (!ko1Var.m("icon").p("iconType", "").toLowerCase().contains("shorts")) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return zQ;
        } catch (Exception e2) {
            uo1.a("Could not determine if this is short-form content", e2);
            return false;
        }
    }

    @Override // defpackage.ze4
    public String l() {
        if (o() == gf4.LIVE_STREAM) {
            return null;
        }
        if (z()) {
            return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(LocalDateTime.ofInstant(v(), ZoneId.systemDefault()));
        }
        String strK = cc5.K(this.a.m("publishedTimeText"));
        if (yy4.n(strK) && this.a.q("videoInfo")) {
            strK = this.a.m("videoInfo").b("runs").d(2).o("text");
        }
        if (yy4.n(strK)) {
            return null;
        }
        return strK;
    }

    @Override // defpackage.ze4
    public qa0 m() throws s83 {
        if (o() == gf4.LIVE_STREAM) {
            return null;
        }
        if (z()) {
            return new qa0(v());
        }
        String strL = l();
        if (this.b == null || yy4.n(strL)) {
            return null;
        }
        try {
            return this.b.e(strL);
        } catch (s83 e2) {
            uo1.a("Could not get upload date", e2);
            return null;
        }
    }

    @Override // defpackage.wj1
    public List n() {
        return cc5.N(this.a);
    }

    @Override // defpackage.ze4
    public gf4 o() {
        gf4 gf4Var = this.c;
        if (gf4Var != null) {
            return gf4Var;
        }
        for (Object obj : this.a.b("badges")) {
            if (obj instanceof ko1) {
                ko1 ko1VarM = ((ko1) obj).m("metadataBadgeRenderer");
                if (ko1VarM.p("style", "").equals("BADGE_STYLE_TYPE_LIVE_NOW") || ko1VarM.p("label", "").equals("LIVE NOW")) {
                    gf4 gf4Var2 = gf4.LIVE_STREAM;
                    this.c = gf4Var2;
                    return gf4Var2;
                }
            }
        }
        for (Object obj2 : this.a.b("thumbnailOverlays")) {
            if ((obj2 instanceof ko1) && ((ko1) obj2).m("thumbnailOverlayTimeStatusRenderer").p("style", "").equalsIgnoreCase("LIVE")) {
                gf4 gf4Var3 = gf4.LIVE_STREAM;
                this.c = gf4Var3;
                return gf4Var3;
            }
        }
        gf4 gf4Var4 = gf4.VIDEO_STREAM;
        this.c = gf4Var4;
        return gf4Var4;
    }

    @Override // defpackage.ze4
    public String q() {
        boolean zQ = this.a.q("detailedMetadataSnippets");
        ko1 ko1Var = this.a;
        if (zQ) {
            return cc5.K(ko1Var.b("detailedMetadataSnippets").d(0).m("snippetText"));
        }
        if (ko1Var.q("descriptionSnippet")) {
            return cc5.K(this.a.m("descriptionSnippet"));
        }
        return null;
    }

    public final Instant v() throws s83 {
        String strO = this.a.m("upcomingEventData").o("startTime");
        try {
            return Instant.ofEpochSecond(Long.parseLong(strO));
        } catch (Exception e2) {
            throw new s83("Could not parse date from premiere: \"" + strO + "\"", e2);
        }
    }

    public final long w() {
        String strP = this.a.m("title").m("accessibility").m("accessibilityData").p("label", "");
        if (strP.toLowerCase().endsWith("no views")) {
            return 0L;
        }
        return Long.parseLong(yy4.t(p83.l(e, strP)));
    }

    public final long x(String str, boolean z) {
        if (str.toLowerCase().contains("no views")) {
            return 0L;
        }
        if (str.toLowerCase().contains("recommended")) {
            return -1L;
        }
        return z ? yy4.q(str) : Long.parseLong(yy4.t(str));
    }

    public final boolean y() {
        return this.a.b("badges").stream().filter(new co1(ko1.class)).map(new e72(ko1.class)).map(new Function() { // from class: pd5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ko1) obj).m("metadataBadgeRenderer").o("style");
            }
        }).anyMatch(new qd5("BADGE_STYLE_TYPE_MEMBERS_ONLY"));
    }

    public final boolean z() {
        if (this.d == null) {
            this.d = Boolean.valueOf(this.a.q("upcomingEventData"));
        }
        return this.d.booleanValue();
    }
}
