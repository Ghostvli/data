package defpackage;

import com.thegrizzlylabs.sardineandroid.util.SardineUtil;
import defpackage.f35;
import defpackage.jm1;
import defpackage.qd;
import defpackage.si4;
import defpackage.ue4;
import j$.time.LocalDate;
import j$.time.format.DateTimeFormatter;
import j$.time.format.DateTimeParseException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.mozilla.javascript.ES6Iterator;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class md5 extends ue4 {
    public static boolean w;
    public ko1 h;
    public ko1 i;
    public ko1 j;
    public ko1 k;
    public ko1 l;
    public ko1 m;
    public ko1 n;
    public ko1 o;
    public eo1 p;
    public int q;
    public gf4 r;
    public String s;
    public String t;
    public String u;
    public String v;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public md5(wf4 wf4Var, vt1 vt1Var) {
        super(wf4Var, vt1Var);
        this.q = -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void C0(ko1 ko1Var) throws v64, x20 {
        String strO = ko1Var.o("status");
        if (strO == null || strO.equalsIgnoreCase("ok")) {
            return;
        }
        String strO2 = ko1Var.o("reason");
        if (strO2 != null) {
            if (strO.equalsIgnoreCase("login_required")) {
                if (strO2.contains("inappropriate for some users")) {
                    throw new g5("This age-restricted video cannot be watched anonymously");
                }
                if (strO2.contains("private")) {
                    throw new yg3("This video is private");
                }
                if (strO2.contains("a bot")) {
                    throw new v64("YouTube probably temporarily blocked anonymous watch access with this IP , got error " + strO + ": \"" + strO2 + "\"");
                }
            }
            if (strO.equalsIgnoreCase("unplayable") || strO.equalsIgnoreCase("error")) {
                if (strO2.contains("Music Premium")) {
                    throw new mb5();
                }
                if (strO2.contains("payment")) {
                    throw new g73("This video is a paid video");
                }
                if (strO2.contains("members")) {
                    throw new g73("This video is only available for members of the channel of this video");
                }
                if (strO2.contains("country")) {
                    throw new n91("This video is not available in client's country.");
                }
                if (strO2.contains("closed") || strO2.contains("terminated")) {
                    throw new k2(strO2);
                }
            }
        }
        throw new x20("Got error " + strO + ": \"" + strO2 + "\"");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String J0(String str, List list, String str2) {
        String str3 = str + "ManifestUrl";
        Iterator it = list.iterator();
        while (it.hasNext()) {
            j73 j73Var = (j73) it.next();
            if (j73Var.a() != null) {
                String strO = ((ko1) j73Var.a()).o(str3);
                if (!yy4.n(strO)) {
                    if (j73Var.b() == null) {
                        return strO + "?" + str2;
                    }
                    return strO + "?pot=" + ((String) j73Var.b()) + "&" + str2;
                }
            }
        }
        return "";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean R0(ko1 ko1Var, String str) {
        return !str.equals(ko1Var.m("videoDetails").o("videoId"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long S0(eo1 eo1Var) throws s83 {
        String strO = null;
        ko1 ko1Var = (ko1) eo1Var.stream().filter(new co1(ko1.class)).map(new e72(ko1.class)).map(new Function() { // from class: oc5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ko1) obj).m("segmentedLikeDislikeButtonRenderer").m("likeButton").m("toggleButtonRenderer");
            }
        }).filter(new Predicate() { // from class: pc5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return md5.v0((ko1) obj);
            }
        }).findFirst().orElse(null);
        if (ko1Var != null) {
            String strO2 = ko1Var.m("accessibilityData").m("accessibilityData").o("label");
            if (strO2 == null) {
                strO2 = ko1Var.m("accessibility").o("label");
            }
            strO = strO2 == null ? ko1Var.m("defaultText").m("accessibility").m("accessibilityData").o("label") : strO2;
            if (strO != null && strO.toLowerCase().contains("no likes")) {
                return 0L;
            }
        }
        if (strO == null) {
            ny4.a("Could not get like count from accessibility data");
            return 0L;
        }
        try {
            return Long.parseLong(yy4.t(strO));
        } catch (NumberFormatException e) {
            pa0.a("Could not parse \"", strO, "\" as a long", e);
            return 0L;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long T0(eo1 eo1Var) throws s83 {
        ko1 ko1Var = (ko1) eo1Var.stream().filter(new co1(ko1.class)).map(new e72(ko1.class)).map(new Function() { // from class: mc5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ko1) obj).m("segmentedLikeDislikeButtonViewModel").m("likeButtonViewModel").m("likeButtonViewModel").m("toggleButtonViewModel").m("toggleButtonViewModel").m("defaultButtonViewModel").m("buttonViewModel");
            }
        }).filter(new Predicate() { // from class: nc5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return md5.l0((ko1) obj);
            }
        }).findFirst().orElse(null);
        if (ko1Var == null) {
            ny4.a("Could not find buttonViewModel object");
            return 0L;
        }
        String strO = ko1Var.o("accessibilityText");
        if (strO == null) {
            ny4.a("Could not find buttonViewModel's accessibilityText string");
            return 0L;
        }
        try {
            return Long.parseLong(yy4.t(strO));
        } catch (NumberFormatException e) {
            pa0.a("Could not parse \"", strO, "\" as a long", e);
            return 0L;
        }
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0015: CONSTRUCTOR 
      (wrap:java.lang.String:STR_CONCAT ("Could not parse upload date ""), (r3v0 java.lang.String), (""") A[MD:():java.lang.String (c), SYNTHETIC, WRAPPED] (LINE:18))
     A[MD:(java.lang.String):void (m)] (LINE:22) call: s83.<init>(java.lang.String):void type: CONSTRUCTOR */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ s83 j0(String str) {
        return new s83("Could not parse upload date \"" + str + "\"");
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: NOT 
      (wrap:boolean:0x0000: INVOKE (r0v0 ko1) STATIC call: yy4.p(java.util.Map):boolean A[DONT_GENERATE, MD:(java.util.Map):boolean (m), REMOVE, WRAPPED] (LINE:1))
     */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ boolean l0(ko1 ko1Var) {
        return !yy4.p(ko1Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ wj1 o0(go4 go4Var, ko1 ko1Var) {
        if (ko1Var.q("compactVideoRenderer")) {
            return new ud5(ko1Var.m("compactVideoRenderer"), go4Var);
        }
        if (ko1Var.q("compactRadioRenderer")) {
            return new gb5(ko1Var.m("compactRadioRenderer"));
        }
        if (ko1Var.q("compactPlaylistRenderer")) {
            return new gb5(ko1Var.m("compactPlaylistRenderer"));
        }
        if (!ko1Var.q("lockupViewModel")) {
            return null;
        }
        ko1 ko1VarM = ko1Var.m("lockupViewModel");
        String strO = ko1VarM.o("contentType");
        if ("LOCKUP_CONTENT_TYPE_PLAYLIST".equals(strO) || "LOCKUP_CONTENT_TYPE_PODCAST".equals(strO)) {
            return new lb5(ko1VarM);
        }
        if ("LOCKUP_CONTENT_TYPE_VIDEO".equals(strO)) {
            return new je5(ko1VarM, go4Var);
        }
        return null;
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0007: CONSTRUCTOR 
      (wrap:j$.time.LocalDateTime:0x0002: INVOKE (r2v0 j$.time.LocalDate) VIRTUAL call: j$.time.LocalDate.atStartOfDay():j$.time.LocalDateTime A[MD:():j$.time.LocalDateTime (m), WRAPPED] (LINE:3))
      true
     A[MD:(j$.time.LocalDateTime, boolean):void (m)] (LINE:8) call: qa0.<init>(j$.time.LocalDateTime, boolean):void type: CONSTRUCTOR */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ qa0 p0(LocalDate localDate) {
        return new qa0(localDate.atStartOfDay(), true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ im1 r0(md5 md5Var, jm1.a aVar, String str, String str2, String str3, ko1 ko1Var) {
        md5Var.getClass();
        try {
            jm1 jm1VarN = jm1.n(ko1Var.h("itag"));
            jm1.a aVar2 = jm1VarN.h;
            if (aVar2 == aVar) {
                return md5Var.B0(str, ko1Var, jm1VarN, aVar2, str2, str3);
            }
            return null;
        } catch (fz0 unused) {
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void s0(List list, oe4 oe4Var) {
        if (oe4.a(oe4Var, list)) {
            return;
        }
        list.add(oe4Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ qd t0(md5 md5Var, im1 im1Var) {
        md5Var.getClass();
        jm1 jm1VarC = im1Var.c();
        qd.a aVarV = new qd.a().u(String.valueOf(jm1VarC.g)).s(im1Var.a(), im1Var.b()).x(jm1VarC.o()).r(jm1VarC.e()).o(jm1VarC.b()).p(jm1VarC.c()).n(jm1VarC.a()).q(jm1VarC.d()).v(jm1VarC);
        gf4 gf4Var = md5Var.r;
        if (gf4Var == gf4.LIVE_STREAM || gf4Var == gf4.POST_LIVE_STREAM || !im1Var.b()) {
            aVarV.t(mj0.DASH);
        }
        return aVarV.m();
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: NOT 
      (wrap:boolean:0x0000: INVOKE (r0v0 ko1) STATIC call: yy4.p(java.util.Map):boolean A[DONT_GENERATE, MD:(java.util.Map):boolean (m), REMOVE, WRAPPED] (LINE:1))
     */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ boolean v0(ko1 ko1Var) {
        return !yy4.p(ko1Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ f35 y0(md5 md5Var, boolean z, im1 im1Var) {
        md5Var.getClass();
        jm1 jm1VarC = im1Var.c();
        f35.a aVarF = new f35.a().d(String.valueOf(jm1VarC.g)).b(im1Var.a(), im1Var.b()).h(jm1VarC.o()).e(z).f(jm1VarC);
        String strQ = jm1VarC.q();
        if (strQ == null) {
            strQ = "";
        }
        aVarF.i(strQ);
        if (md5Var.r != gf4.VIDEO_STREAM || !im1Var.b()) {
            aVarF.c(mj0.DASH);
        }
        return aVarF.a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ Stream z0(md5 md5Var, String str, String str2, jm1.a aVar, j73 j73Var) {
        md5Var.getClass();
        return md5Var.L0(str, (ko1) j73Var.a(), str2, aVar, (String) ((j73) j73Var.b()).a(), (String) ((j73) j73Var.b()).b());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public Locale B() {
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final im1 B0(String str, ko1 ko1Var, final jm1 jm1Var, jm1.a aVar, String str2, String str3) throws Exception {
        String strO;
        if (ko1Var.q("url")) {
            strO = ko1Var.o("url");
        } else {
            String strP = ko1Var.p("cipher", ko1Var.o("signatureCipher"));
            if (yy4.n(strP)) {
                return null;
            }
            Map mapF = p83.f(strP);
            String strA = bb5.a(str, (String) mapF.getOrDefault(SardineUtil.CUSTOM_NAMESPACE_PREFIX, ""));
            strO = ((String) mapF.get("url")) + "&" + ((String) mapF.get("sp")) + "=" + strA;
        }
        String str4 = bb5.c(str, strO) + "&cpn=" + str2;
        if (str3 != null) {
            str4 = str4 + "&pot=" + str3;
        }
        ko1 ko1VarM = ko1Var.m("initRange");
        ko1 ko1VarM2 = ko1Var.m("indexRange");
        String strP2 = ko1Var.p("mimeType", "");
        String str5 = strP2.contains("codecs") ? strP2.split("\"")[1] : "";
        jm1Var.z(ko1Var.h("bitrate"));
        jm1Var.N(ko1Var.h("width"));
        jm1Var.D(ko1Var.h("height"));
        jm1Var.H(Integer.parseInt(ko1VarM.p("start", "-1")));
        jm1Var.G(Integer.parseInt(ko1VarM.p("end", "-1")));
        jm1Var.F(Integer.parseInt(ko1VarM2.p("start", "-1")));
        jm1Var.E(Integer.parseInt(ko1VarM2.p("end", "-1")));
        jm1Var.K(ko1Var.o("quality"));
        jm1Var.A(str5);
        jm1Var.I(Boolean.valueOf(ko1Var.e("isDrc", Boolean.FALSE)));
        jm1Var.J(Long.parseLong(ko1Var.p("lastModified", "-1")));
        jm1Var.O(ko1Var.o("xtags"));
        gf4 gf4Var = this.r;
        if (gf4Var == gf4.LIVE_STREAM || gf4Var == gf4.POST_LIVE_STREAM) {
            jm1Var.M(ko1Var.h("targetDurationSec"));
        }
        if (aVar == jm1.a.VIDEO || aVar == jm1.a.VIDEO_ONLY) {
            jm1Var.C(ko1Var.h("fps"));
        } else if (aVar == jm1.a.AUDIO) {
            jm1Var.L(Integer.parseInt(ko1Var.o("audioSampleRate")));
            jm1Var.u(ko1Var.i("audioChannels", 2));
            String strO2 = ko1Var.m("audioTrack").o(Name.MARK);
            if (!yy4.n(strO2)) {
                jm1Var.w(strO2);
                int iIndexOf = strO2.indexOf(".");
                if (iIndexOf != -1) {
                    iz1.a(strO2.substring(0, iIndexOf)).ifPresent(new Consumer() { // from class: dd5
                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            jm1Var.v((Locale) obj);
                        }
                    });
                }
                jm1Var.y(cc5.m(str4));
            }
            jm1Var.x(ko1Var.m("audioTrack").o("displayName"));
        }
        jm1Var.B(Long.parseLong(ko1Var.p("contentLength", String.valueOf(-1L))));
        jm1Var.t(Long.parseLong(ko1Var.p("approxDurationMs", String.valueOf(-1L))));
        im1 im1Var = new im1(str4, jm1Var);
        gf4 gf4Var2 = this.r;
        if (gf4Var2 == gf4.VIDEO_STREAM) {
            im1Var.d(!ko1Var.p("type", "").equalsIgnoreCase("FORMAT_STREAM_TYPE_OTF"));
            return im1Var;
        }
        im1Var.d(gf4Var2 != gf4.POST_LIVE_STREAM);
        return im1Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public long C() {
        a();
        try {
            return Long.parseLong(this.h.m("videoDetails").o("lengthSeconds"));
        } catch (Exception unused) {
            return H0(Arrays.asList(this.k, this.j));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String D() {
        ko1 ko1VarM = P0().m("metadataRowContainer").m("metadataRowContainerRenderer").b("rows").d(0).m("metadataRowRenderer");
        String strK = cc5.K(ko1VarM.b("contents").d(0));
        return (strK == null || !"Licence".equals(cc5.K(ko1VarM.m("title")))) ? "YouTube licence" : strK;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void D0(pz1 pz1Var, m20 m20Var, String str, df3 df3Var) throws fz0 {
        String strV = cc5.v();
        this.t = strV;
        ko1 ko1VarB = od5.b(m20Var, pz1Var, str, strV);
        this.h = ko1VarB;
        C0(ko1VarB.m("playabilityStatus"));
        if (R0(this.h, str)) {
            throw new fz0("ANDROID player response is not valid");
        }
        this.k = this.h.m("streamingData");
        this.o = this.h.m("captions").m("playerCaptionsTracklistRenderer");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public long E() throws s83 {
        a();
        if (!this.h.m("videoDetails").d("allowRatings")) {
            return -1L;
        }
        eo1 eo1VarB = O0().m("videoActions").m("menuRenderer").b("topLevelButtons");
        try {
            try {
                return T0(eo1VarB);
            } catch (s83 unused) {
                return S0(eo1VarB);
            }
        } catch (s83 e) {
            uo1.a("Could not get like count", e);
            return 0L;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void E0(pz1 pz1Var, m20 m20Var, String str, df3 df3Var) {
        try {
            String strV = cc5.v();
            this.s = strV;
            ko1 ko1VarC = od5.c(m20Var, pz1Var, str, strV, df3Var);
            if (R0(ko1VarC, str)) {
                return;
            }
            this.j = ko1VarC.m("streamingData");
            if (yy4.p(this.o)) {
                this.o = ko1VarC.m("captions").m("playerCaptionsTracklistRenderer");
            }
        } catch (Exception unused) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List F() {
        return fb5.f(this.i.m("contents").m("twoColumnWatchNextResults").m("results").m("results").b("contents"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void F0(pz1 pz1Var, m20 m20Var, String str) {
        try {
            ko1 ko1VarE = od5.e(pz1Var, m20Var, str);
            if (R0(ko1VarE, str)) {
                return;
            }
            this.n = ko1VarE.m("microformat").m("playerMicroformatRenderer");
            ko1 ko1VarM = ko1VarE.m("videoDetails").m("thumbnail");
            if (ko1VarM.containsKey("thumbnails")) {
                this.p = ko1VarM.b("thumbnails");
            } else {
                this.p = this.h.m("videoDetails").m("thumbnail").b("thumbnails");
            }
        } catch (Exception unused) {
            this.n = new ko1();
            this.p = this.h.m("videoDetails").m("thumbnail").b("thumbnails");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public ue4.a G() {
        return (this.n.d("isUnlisted") || O0().b("badges").g().anyMatch(new Predicate() { // from class: ad5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return "PRIVACY_UNLISTED".equals(((ko1) obj).m("metadataBadgeRenderer").m("icon").o("iconType"));
            }
        })) ? ue4.a.UNLISTED : ue4.a.PUBLIC;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Function G0() {
        return new Function() { // from class: fd5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return md5.t0(this.a, (im1) obj);
            }
        };
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int H0(List list) throws s83 {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!((ko1) it.next()).b("adaptiveFormats").isEmpty()) {
                try {
                    return Math.round(Long.parseLong(r3.d(0).o("approxDurationMs")) / 1000.0f);
                } catch (NumberFormatException unused) {
                    continue;
                }
            }
        }
        ny4.a("Could not get duration");
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List I() throws s83 {
        if (!this.i.q("engagementPanels")) {
            return Collections.EMPTY_LIST;
        }
        eo1 eo1Var = (eo1) this.i.b("engagementPanels").stream().filter(new co1(ko1.class)).map(new e72(ko1.class)).filter(new Predicate() { // from class: gd5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return "engagement-panel-macro-markers-description-chapters".equals(((ko1) obj).m("engagementPanelSectionListRenderer").o("panelIdentifier"));
            }
        }).map(new Function() { // from class: hd5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ko1) obj).m("engagementPanelSectionListRenderer").m("content").m("macroMarkersListRenderer").b("contents");
            }
        }).findFirst().orElse(null);
        if (eo1Var == null) {
            return Collections.EMPTY_LIST;
        }
        long jC = C();
        ArrayList arrayList = new ArrayList();
        for (ko1 ko1Var : (List) eo1Var.stream().filter(new co1(ko1.class)).map(new e72(ko1.class)).map(new Function() { // from class: id5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ko1) obj).m("macroMarkersListItemRenderer");
            }
        }).collect(Collectors.toList())) {
            int i = ko1Var.m("onTap").m("watchEndpoint").i("startTimeSeconds", -1);
            if (i == -1) {
                ny4.a("Could not get stream segment start time.");
                return null;
            }
            if (i > jC) {
                break;
            }
            String strK = cc5.K(ko1Var.m("title"));
            if (yy4.n(strK)) {
                ny4.a("Could not get stream segment title.");
                return null;
            }
            ff4 ff4Var = new ff4(strK, i);
            ff4Var.c(o() + "?t=" + i);
            if (ko1Var.q("thumbnail")) {
                eo1 eo1VarB = ko1Var.m("thumbnail").b("thumbnails");
                if (!eo1VarB.isEmpty()) {
                    ff4Var.b(cc5.t(eo1VarB.d(eo1VarB.size() - 1).o("url")));
                }
            }
            arrayList.add(ff4Var);
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final List I0(final String str, final jm1.a aVar, Function function, String str2) throws s83 {
        try {
            final String strH = h();
            final ArrayList arrayList = new ArrayList();
            Stream.of((Object[]) new j73[]{new j73(this.k, new j73(this.t, this.u)), new j73(this.j, new j73(this.s, this.v))}).flatMap(new Function() { // from class: uc5
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return md5.z0(this.a, strH, str, aVar, (j73) obj);
                }
            }).map(function).forEachOrdered(new Consumer() { // from class: wc5
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    md5.s0(arrayList, (oe4) obj);
                }
            });
            return arrayList;
        } catch (Exception e) {
            pa0.a("Could not get ", str2, " streams", e);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public gf4 J() {
        a();
        return this.r;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: H()Lxj1; */
    @Override // defpackage.ue4
    /* JADX INFO: renamed from: K0, reason: merged with bridge method [inline-methods] */
    public zv2 H() throws s83 {
        a();
        if (q() != 0) {
            return null;
        }
        try {
            final zv2 zv2Var = new zv2(m());
            eo1 eo1VarB = this.i.m("contents").m("twoColumnWatchNextResults").m("secondaryResults").m("secondaryResults").b("results");
            final go4 go4VarN = n();
            eo1VarB.stream().filter(new co1(ko1.class)).map(new e72(ko1.class)).map(new Function() { // from class: qc5
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return md5.o0(go4VarN, (ko1) obj);
                }
            }).filter(new Predicate() { // from class: rc5
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return Objects.nonNull((wj1) obj);
                }
            }).forEach(new Consumer() { // from class: sc5
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    zv2Var.d((wj1) obj);
                }
            });
            return zv2Var;
        } catch (Exception e) {
            uo1.a("Could not get related videos", e);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Stream L0(final String str, ko1 ko1Var, String str2, final jm1.a aVar, final String str3, final String str4) {
        return (ko1Var == null || !ko1Var.q(str2)) ? Stream.empty() : ko1Var.b(str2).stream().filter(new co1(ko1.class)).map(new e72(ko1.class)).map(new Function() { // from class: bd5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return md5.r0(this.a, aVar, str, str3, str4, (ko1) obj);
            }
        }).filter(new Predicate() { // from class: cd5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Objects.nonNull((im1) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List M0(dg2 dg2Var) {
        a();
        ArrayList arrayList = new ArrayList();
        eo1 eo1VarB = this.o.b("captionTracks");
        for (int i = 0; i < eo1VarB.size(); i++) {
            String strO = eo1VarB.d(i).o("languageCode");
            String strO2 = eo1VarB.d(i).o("baseUrl");
            String strO3 = eo1VarB.d(i).o("vssId");
            if (strO != null && strO2 != null && strO3 != null) {
                boolean zStartsWith = strO3.startsWith("a.");
                String strReplaceAll = strO2.replaceAll("&fmt=[^&]*", "").replaceAll("&tlang=[^&]*", "");
                arrayList.add(new si4.a().c(strReplaceAll + "&fmt=" + dg2Var.f(), true).e(dg2Var).d(strO).b(zStartsWith).a());
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List N() {
        return M0(dg2.TTML);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ko1 N0(final String str) {
        return (ko1) this.i.m("contents").m("twoColumnWatchNextResults").m("results").m("results").b("contents").stream().filter(new co1(ko1.class)).map(new e72(ko1.class)).filter(new Predicate() { // from class: vc5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((ko1) obj).q(str);
            }
        }).map(new Function() { // from class: ed5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ko1) obj).m(str);
            }
        }).findFirst().orElse(new ko1());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ko1 O0() {
        ko1 ko1Var = this.l;
        if (ko1Var != null) {
            return ko1Var;
        }
        ko1 ko1VarN0 = N0("videoPrimaryInfoRenderer");
        this.l = ko1VarN0;
        return ko1VarN0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List P() {
        return xo1.i(this.h.m("videoDetails").b("keywords"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ko1 P0() {
        ko1 ko1Var = this.m;
        if (ko1Var != null) {
            return ko1Var;
        }
        ko1 ko1VarN0 = N0("videoSecondaryInfoRenderer");
        this.m = ko1VarN0;
        return ko1VarN0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String Q() {
        String strK;
        String strP = this.n.p("uploadDate", "");
        if (strP.isEmpty()) {
            strP = this.n.p("publishDate", "");
        }
        if (!strP.isEmpty()) {
            return strP;
        }
        ko1 ko1VarM = this.n.m("liveBroadcastDetails");
        String strP2 = ko1VarM.p("endTimestamp", "");
        if (strP2.isEmpty()) {
            strP2 = ko1VarM.p("startTimestamp", "");
        }
        if (!strP2.isEmpty()) {
            return strP2;
        }
        if (J() == gf4.LIVE_STREAM || (strK = cc5.K(O0().m("dateText"))) == null) {
            return null;
        }
        return strK.startsWith("Premiered on ") ? strK.substring(13) : strK.startsWith("Premiered ") ? strK.substring(10) : strK;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Function Q0(final boolean z) {
        return new Function() { // from class: tc5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return md5.y0(this.a, z, (im1) obj);
            }
        };
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List R() throws s83 {
        a();
        try {
            return cc5.E(this.p);
        } catch (Exception unused) {
            ny4.a("Could not get thumbnails");
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public long S() throws s83 {
        long jT = T("((#|&|\\?)t=\\d*h?\\d*m?\\d+s?)");
        if (jT == -2) {
            return 0L;
        }
        return jT;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public qa0 U() {
        final String strQ = Q();
        try {
            try {
                return qa0.b(strQ);
            } catch (s83 unused) {
                return (qa0) kc5.a(this.U0(strQ, "MMM dd, yyyy"), new Supplier() { // from class: xc5
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return this.a.U0(strQ, "dd MMM yyyy");
                    }
                }).map(new Function() { // from class: yc5
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return md5.p0((LocalDate) obj);
                    }
                }).orElseThrow(new Supplier() { // from class: zc5
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return md5.j0(strQ);
                    }
                });
            }
        } catch (s83 unused2) {
            return ho4.b(new pz1("en")).e(strQ);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Optional U0(String str, String str2) {
        try {
            return Optional.of(LocalDate.parse(str, DateTimeFormatter.ofPattern(str2, Locale.ENGLISH)));
        } catch (DateTimeParseException unused) {
            return Optional.empty();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List V() throws s83 {
        a();
        ko1 ko1VarM = P0().m("owner").m("videoOwnerRenderer");
        List listE = ko1VarM.q("avatarStack") ? cc5.E(ko1VarM.m("avatarStack").m("avatarStackViewModel").b("avatars").d(0).m("avatarViewModel").m("image").b("sources")) : cc5.E(ko1VarM.m("thumbnail").b("thumbnails"));
        if (!listE.isEmpty() || this.q != 0) {
            return listE;
        }
        ny4.a("Could not get uploader avatars");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void V0() {
        if (this.h.m("playabilityStatus").q("liveStreamability")) {
            this.r = gf4.LIVE_STREAM;
        } else if (this.h.m("videoDetails").e("isPostLiveDvr", Boolean.FALSE)) {
            this.r = gf4.POST_LIVE_STREAM;
        } else {
            this.r = gf4.VIDEO_STREAM;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String W() throws s83 {
        a();
        String strO = this.h.m("videoDetails").o("author");
        if (!yy4.n(strO)) {
            return strO;
        }
        ny4.a("Could not get uploader name");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public long X() throws s83 {
        ko1 ko1VarF = xo1.f(this.m, "owner.videoOwnerRenderer");
        String strK = ko1VarF.q("subscriberCountText") ? cc5.K(ko1VarF.m("subscriberCountText")) : cc5.D(ko1VarF.m("navigationEndpoint")).m("subtitle").o("content").split("•")[1];
        if (yy4.n(strK)) {
            return -1L;
        }
        try {
            return yy4.q(strK);
        } catch (NumberFormatException e) {
            uo1.a("Could not get uploader subscriber count", e);
            return 0L;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String Y() throws s83 {
        a();
        String strO = this.h.m("videoDetails").o("channelId");
        if (yy4.n(strO)) {
            ny4.a("Could not get uploader url");
            return null;
        }
        return sa5.n().f("channel/" + strO);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List Z() {
        a();
        return I0("adaptiveFormats", jm1.a.VIDEO_ONLY, Q0(true), "video-only");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List a0() {
        a();
        return I0("formats", jm1.a.VIDEO, Q0(false), "video");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public long b0() throws s83 {
        String strK = cc5.K(O0().m("viewCount").m("videoViewCountRenderer").m("viewCount"));
        if (yy4.n(strK)) {
            strK = this.h.m("videoDetails").o("viewCount");
            if (yy4.n(strK)) {
                ny4.a("Could not get view count");
                return 0L;
            }
        }
        if (strK.toLowerCase().contains("no views")) {
            return 0L;
        }
        return Long.parseLong(yy4.t(strK));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public boolean d0() {
        ko1 ko1VarM = P0().m("owner").m("videoOwnerRenderer");
        if (ko1VarM.q("badges")) {
            return cc5.Y(ko1VarM.b("badges"));
        }
        ko1 ko1VarD = cc5.D(ko1VarM.m("navigationEndpoint"));
        if (ko1VarD == null) {
            return false;
        }
        return cc5.S(ko1VarD.m("title").b("attachmentRuns"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gz0
    public String j() throws s83 {
        a();
        String strO = this.h.m("videoDetails").o("title");
        if (!yy4.n(strO)) {
            return strO;
        }
        String strK = cc5.K(O0().m("title"));
        if (!yy4.n(strK)) {
            return strK;
        }
        ny4.a("Could not get name");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gz0
    public void p(gn0 gn0Var) throws fz0 {
        String strH = h();
        pz1 pz1VarG = g();
        m20 m20VarF = f();
        D0(pz1VarG, m20VarF, strH, null);
        V0();
        if (w) {
            E0(pz1VarG, m20VarF, strH, null);
        }
        F0(pz1VarG, m20VarF, strH);
        this.i = cc5.I(ES6Iterator.NEXT_METHOD, zo1.b(cc5.h0(pz1VarG, m20VarF).h("videoId", strH).i("contentCheckOk", true).i("racyCheckOk", true).b()).getBytes(StandardCharsets.UTF_8), pz1VarG);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public int q() {
        int i = this.q;
        if (i != -1) {
            return i;
        }
        int i2 = P0().m("metadataRowContainer").m("metadataRowContainerRenderer").b("rows").stream().filter(new co1(ko1.class)).map(new e72(ko1.class)).flatMap(new Function() { // from class: jd5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ko1) obj).m("metadataRowRenderer").b("contents").stream().filter(new co1(ko1.class)).map(new e72(ko1.class));
            }
        }).flatMap(new Function() { // from class: kd5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ko1) obj).b("runs").stream().filter(new co1(ko1.class)).map(new e72(ko1.class));
            }
        }).map(new Function() { // from class: ld5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ko1) obj).p("text", "");
            }
        }).anyMatch(new Predicate() { // from class: lc5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((String) obj).contains("Age-restricted");
            }
        }) ? 18 : 0;
        this.q = i2;
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List r() {
        a();
        return I0("adaptiveFormats", jm1.a.AUDIO, G0(), "audio");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String s() {
        return this.n.p("category", "");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String u() {
        a();
        return J0("dash", av4.a(new Object[]{new j73(this.k, this.u)}), "mpd_version=7");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public qj0 v() {
        a();
        String strL = cc5.L(P0().m("description"), true);
        if (!yy4.n(strL)) {
            return new qj0(strL, 1);
        }
        String strI = za5.i(P0().m("attributedDescription"));
        if (!yy4.n(strI)) {
            return new qj0(strI, 1);
        }
        String strO = this.h.m("videoDetails").o("shortDescription");
        if (strO == null) {
            strO = cc5.K(this.n.m("description"));
        }
        return new qj0(strO, 3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String x() {
        try {
            return cc5.K(this.h.m("playabilityStatus").m("errorScreen").m("playerErrorMessageRenderer").m("reason"));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List y() throws fz0 {
        List listSingletonList;
        String str = "playerLiveStoryboardSpecRenderer";
        try {
            ko1 ko1VarM = this.h.m("storyboards");
            if (!ko1VarM.q("playerLiveStoryboardSpecRenderer")) {
                str = "playerStoryboardSpecRenderer";
            }
            ko1 ko1VarM2 = ko1VarM.m(str);
            if (ko1VarM2 == null) {
                return Collections.EMPTY_LIST;
            }
            String strO = ko1VarM2.o("spec");
            if (strO == null) {
                return Collections.EMPTY_LIST;
            }
            String[] strArrSplit = strO.split("\\|");
            String str2 = strArrSplit[0];
            ArrayList arrayList = new ArrayList(strArrSplit.length - 1);
            for (int i = 1; i < strArrSplit.length; i++) {
                String[] strArrSplit2 = strArrSplit[i].split("#");
                if (strArrSplit2.length == 8 && Integer.parseInt(strArrSplit2[5]) != 0) {
                    int i2 = Integer.parseInt(strArrSplit2[2]);
                    int i3 = Integer.parseInt(strArrSplit2[3]);
                    int i4 = Integer.parseInt(strArrSplit2[4]);
                    String str3 = str2.replace("$L", String.valueOf(i - 1)).replace("$N", strArrSplit2[6]) + "&sigh=" + strArrSplit2[7];
                    if (str3.contains("$M")) {
                        int iCeil = (int) Math.ceil(((double) i2) / ((double) (i3 * i4)));
                        listSingletonList = new ArrayList(iCeil);
                        for (int i5 = 0; i5 < iCeil; i5++) {
                            listSingletonList.add(str3.replace("$M", String.valueOf(i5)));
                        }
                    } else {
                        listSingletonList = Collections.singletonList(str3);
                    }
                    arrayList.add(new u71(listSingletonList, Integer.parseInt(strArrSplit2[0]), Integer.parseInt(strArrSplit2[1]), i2, Integer.parseInt(strArrSplit2[5]), i3, i4));
                }
            }
            return arrayList;
        } catch (Exception e) {
            throw new fz0("Could not get frames", e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String z() {
        a();
        return J0("hls", av4.a(new Object[]{new j73(this.j, this.v), new j73(this.k, this.u)}), "");
    }
}
