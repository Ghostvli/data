package defpackage;

import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import j$.time.format.DateTimeFormatter;
import j$.time.format.DateTimeParseException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class je5 implements ze4 {
    public static final DateTimeFormatter h = DateTimeFormatter.ofPattern("dd/MM/yyyy, HH:mm");
    public final ko1 a;
    public final go4 b;
    public gf4 c;
    public String d;
    public Optional e;
    public a f;
    public eo1 g;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class a {
        public ko1 a;

        public a(ko1 ko1Var) {
            this.a = ko1Var;
        }

        public abstract ko1 a();

        public abstract ko1 b();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b extends a {
        public b(ko1 ko1Var) {
            super(ko1Var);
        }

        @Override // je5.a
        public ko1 a() {
            return this.a.b("avatars").d(0);
        }

        @Override // je5.a
        public ko1 b() {
            return (ko1) this.a.m("rendererContext").m("commandContext").m("onTap").m("innertubeCommand").m("showDialogCommand").m("panelLoadingStrategy").m("inlineContent").m("dialogViewModel").m("customContent").m("listViewModel").b("listItems").g().map(new Function() { // from class: ke5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((ko1) obj).m("listItemViewModel");
                }
            }).findFirst().orElse(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c extends a {
        public c(ko1 ko1Var) {
            super(ko1Var);
        }

        @Override // je5.a
        public ko1 a() {
            return this.a.m("avatar");
        }

        @Override // je5.a
        public ko1 b() {
            return this.a;
        }
    }

    public je5(ko1 ko1Var, go4 go4Var) {
        this.a = ko1Var;
        this.b = go4Var;
    }

    public static /* synthetic */ s83 D() {
        return new s83("Could not get uploader name");
    }

    private boolean M() {
        return ((Boolean) I().map(new Function() { // from class: ce5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Boolean.valueOf(((String) obj).contains("Premieres "));
            }
        }).orElse(Boolean.FALSE)).booleanValue();
    }

    public static /* synthetic */ boolean u(ko1 ko1Var) {
        if ("THUMBNAIL_OVERLAY_BADGE_STYLE_LIVE".equals(ko1Var.o("badgeStyle"))) {
            return true;
        }
        return ko1Var.m("icon").b("sources").g().map(new Function() { // from class: zd5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ko1) obj).m("clientResource").o("imageName");
            }
        }).anyMatch(new qd5("LIVE"));
    }

    public static /* synthetic */ boolean v(String str) {
        return !yy4.n(str);
    }

    public final a E() {
        if (this.f == null) {
            this.f = F();
        }
        return this.f;
    }

    public final a F() throws s83 {
        ko1 ko1VarM = this.a.m("metadata").m("lockupMetadataViewModel").m("image");
        ko1 ko1VarN = ko1VarM.n("decoratedAvatarViewModel", null);
        if (ko1VarN != null) {
            return new c(ko1VarN);
        }
        ko1 ko1VarN2 = ko1VarM.n("avatarStackViewModel", null);
        if (ko1VarN2 != null) {
            return new b(ko1VarN2);
        }
        ny4.a("Failed to determine channel image view model");
        return null;
    }

    public final gf4 G() {
        return xo1.a(this.a, "contentImage.thumbnailViewModel.overlays").g().flatMap(new Function() { // from class: ie5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ko1) obj).m("thumbnailOverlayBadgeViewModel").b("thumbnailBadges").g();
            }
        }).map(new Function() { // from class: wd5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ko1) obj).m("thumbnailBadgeViewModel");
            }
        }).anyMatch(new Predicate() { // from class: xd5
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return je5.u((ko1) obj);
            }
        }) ? gf4.LIVE_STREAM : gf4.VIDEO_STREAM;
    }

    public final String H(Optional optional) {
        return (String) optional.map(new Function() { // from class: vd5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((String) obj).replace("Premieres ", "");
            }
        }).orElse(null);
    }

    public final Optional I() {
        if (this.e == null) {
            this.e = N(1, 1).map(new fe5(this));
        }
        return this.e;
    }

    public final String J(ko1 ko1Var) {
        return ko1Var.m("text").o("content");
    }

    public final long K(String str) {
        if (str.toLowerCase().contains("no views")) {
            return 0L;
        }
        if (str.toLowerCase().contains("recommended")) {
            return -1L;
        }
        return yy4.q(str);
    }

    public final boolean L() {
        return o() != gf4.VIDEO_STREAM;
    }

    public final Optional N(int i, final int i2) {
        if (this.g == null) {
            this.g = xo1.a(this.a, "metadata.lockupMetadataViewModel.metadata.contentMetadataViewModel.metadataRows");
        }
        return this.g.g().skip(i).limit(1L).flatMap(new Function() { // from class: yd5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ko1) obj).b("metadataParts").g().skip(i2).limit(1L);
            }
        }).findFirst();
    }

    public final String O(String str) {
        sa5 sa5VarN = sa5.n();
        if (str.startsWith(ServiceReference.DELIMITER)) {
            str = str.substring(1);
        }
        return sa5VarN.f(str);
    }

    @Override // defpackage.ze4
    public String a() throws s83 {
        ko1 ko1VarM = E().b().m("rendererContext").m("commandContext").m("onTap").m("innertubeCommand");
        ko1 ko1VarM2 = ko1VarM.m("browseEndpoint");
        String strO = ko1VarM2.o("browseId");
        if (strO != null && strO.startsWith("UC")) {
            return sa5.n().f("channel/".concat(strO));
        }
        String strO2 = ko1VarM2.o("canonicalBaseUrl");
        if (!yy4.n(strO2)) {
            return O(strO2);
        }
        String strO3 = ko1VarM.m("commandMetadata").m("webCommandMetadata").o("url");
        if (!yy4.n(strO3)) {
            return O(strO3);
        }
        ny4.a("Could not get uploader url");
        return null;
    }

    @Override // defpackage.ze4
    public boolean b() {
        return ((Boolean) N(0, 0).map(new Function() { // from class: de5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ko1) obj).m("text").b("attachmentRuns");
            }
        }).map(new Function() { // from class: ee5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Boolean.valueOf(cc5.S((eo1) obj));
            }
        }).orElse(Boolean.FALSE)).booleanValue();
    }

    @Override // defpackage.ze4
    public String d() {
        return (String) N(0, 0).map(new fe5(this)).filter(new Predicate() { // from class: ge5
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return je5.v((String) obj);
            }
        }).orElseThrow(new Supplier() { // from class: he5
            @Override // java.util.function.Supplier
            public final Object get() {
                return je5.D();
            }
        });
    }

    @Override // defpackage.ze4
    public long e() {
        if (M()) {
            return -1L;
        }
        Optional map = N(1, 0).map(new fe5(this));
        return map.isPresent() ? K((String) map.get()) : !L() ? -1L : 0L;
    }

    @Override // defpackage.ze4
    public boolean f() throws s83 {
        String name = getName();
        return "[Private video]".equals(name) || "[Deleted video]".equals(name);
    }

    @Override // defpackage.ze4
    public List g() {
        return cc5.E(xo1.a(E().a(), "avatarViewModel.image.sources"));
    }

    @Override // defpackage.ze4
    public long getDuration() throws s83 {
        if (L() || M()) {
            return -1L;
        }
        List list = (List) xo1.a(this.a, "contentImage.thumbnailViewModel.overlays").g().flatMap(new Function() { // from class: ae5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ko1) obj).m("thumbnailBottomOverlayViewModel").b("badges").g();
            }
        }).map(new Function() { // from class: be5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ko1) obj).m("thumbnailBadgeViewModel").o("text");
            }
        }).collect(Collectors.toList());
        if (list.isEmpty()) {
            ny4.a("Could not get duration: No parsable durations detected");
            return 0L;
        }
        Iterator it = list.iterator();
        s83 e = null;
        while (it.hasNext()) {
            try {
                return cc5.g0((String) it.next());
            } catch (s83 e2) {
                e = e2;
            }
        }
        uo1.a("Could not get duration", e);
        return 0L;
    }

    @Override // defpackage.wj1
    public String getName() throws s83 {
        String str = this.d;
        if (str != null) {
            return str;
        }
        String strH = xo1.h(this.a, "metadata.lockupMetadataViewModel.title.content");
        if (yy4.n(strH)) {
            ny4.a("Could not get name");
            return null;
        }
        this.d = strH;
        return strH;
    }

    @Override // defpackage.wj1
    public String getUrl() throws s83 {
        try {
            String strO = this.a.o("contentId");
            if (yy4.n(strO)) {
                strO = xo1.h(this.a, "rendererContext.commandContext.onTap.innertubeCommand.watchEndpoint.videoId");
            }
            return me5.l().f(strO);
        } catch (Exception e) {
            uo1.a("Could not get url", e);
            return null;
        }
    }

    @Override // defpackage.ze4
    public String l() {
        if (L()) {
            return null;
        }
        Optional optionalI = I();
        return M() ? H(optionalI) : (String) optionalI.orElse(null);
    }

    @Override // defpackage.ze4
    public qa0 m() throws s83 {
        String strL;
        if (this.b == null || (strL = l()) == null) {
            return null;
        }
        if (!M()) {
            return this.b.e(strL);
        }
        String strH = H(I());
        if (strH == null) {
            ny4.a("Could not get upload date from premiere");
            return null;
        }
        try {
            return new qa0(LocalDateTime.parse(strH, h).M(ZoneOffset.UTC).toInstant(), false);
        } catch (DateTimeParseException e) {
            uo1.a("Could not parse premiere upload date", e);
            return null;
        }
    }

    @Override // defpackage.wj1
    public List n() {
        return cc5.E(xo1.a(this.a, "contentImage.thumbnailViewModel.image.sources"));
    }

    @Override // defpackage.ze4
    public gf4 o() {
        if (this.c == null) {
            this.c = G();
        }
        return this.c;
    }
}
