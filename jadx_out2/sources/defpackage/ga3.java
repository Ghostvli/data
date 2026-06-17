package defpackage;

import defpackage.f35;
import defpackage.qd;
import defpackage.si4;
import defpackage.ue4;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.jupnp.model.ServiceReference;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ga3 extends ue4 {
    public final String h;
    public ko1 i;
    public final List j;
    public final List k;
    public final List l;
    public s83 m;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ga3(wf4 wf4Var, vt1 vt1Var) {
        super(wf4Var, vt1Var);
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.m = null;
        this.h = d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String A() {
        return xo1.h(this.i, "account.host");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public Locale B() {
        try {
            return new Locale(xo1.h(this.i, "language.id"));
        } catch (s83 unused) {
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public long C() {
        return this.i.j("duration");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String D() {
        return xo1.h(this.i, "licence.label");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public long E() {
        return this.i.j("likes");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public ue4.a G() {
        int iH = this.i.m("privacy").h(Name.MARK);
        return iH != 1 ? iH != 2 ? iH != 3 ? iH != 4 ? ue4.a.OTHER : ue4.a.INTERNAL : ue4.a.PRIVATE : ue4.a.UNLISTED : ue4.a.PUBLIC;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List I() throws s83 {
        ArrayList arrayList = new ArrayList();
        try {
            ko1 ko1VarJ0 = j0("chapters");
            if (ko1VarJ0 != null && ko1VarJ0.q("chapters")) {
                eo1 eo1VarB = ko1VarJ0.b("chapters");
                for (int i = 0; i < eo1VarB.size(); i++) {
                    ko1 ko1VarD = eo1VarB.d(i);
                    arrayList.add(new ff4(ko1VarD.o("title"), ko1VarD.h("timecode")));
                }
            }
            return arrayList;
        } catch (fo3 | IOException e) {
            uo1.a("Could not get stream segments", e);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public gf4 J() {
        return this.i.d("isLive") ? gf4.LIVE_STREAM : gf4.VIDEO_STREAM;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List K() {
        return ba3.c(this.h, this.i.m("channel"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String L() {
        return xo1.h(this.i, "channel.displayName");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String M() {
        return xo1.h(this.i, "channel.url");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List N() throws s83 {
        s83 s83Var = this.m;
        if (s83Var == null) {
            return this.j;
        }
        throw s83Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String O() {
        try {
            return xo1.h(this.i, "support");
        } catch (s83 unused) {
            return "";
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List P() {
        return xo1.i(this.i.b("tags"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String Q() {
        return xo1.h(this.i, "publishedAt");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List R() {
        return ba3.f(this.h, this.i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public long S() throws s83 {
        long jT = T("((#|&|\\?)start=\\d{0,3}h?\\d{0,3}m?\\d{1,3}s?)");
        if (jT == -2) {
            return 0L;
        }
        return jT;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public qa0 U() {
        return qa0.a(Q());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List V() {
        return ba3.c(this.h, this.i.m("account"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String W() {
        return xo1.h(this.i, "account.displayName");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String Y() {
        String strH = xo1.h(this.i, "account.name");
        String strH2 = xo1.h(this.i, "account.host");
        return l().a().b("accounts/" + strH + "@" + strH2, this.h).d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List Z() {
        return Collections.EMPTY_LIST;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List a0() throws s83 {
        a();
        if (this.l.isEmpty()) {
            if (J() == gf4.VIDEO_STREAM) {
                o0();
            } else {
                i0();
            }
        }
        return this.l;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public long b0() {
        return this.i.j("views");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f0(ko1 ko1Var, boolean z, String str, String str2, String str3, String str4) {
        String strSubstring = str3.substring(str3.lastIndexOf(".") + 1);
        dg2 dg2VarB = dg2.b(strSubstring);
        String str5 = str + "-" + strSubstring;
        this.k.add(new qd.a().u(str5 + "-" + str2 + "-" + mj0.PROGRESSIVE_HTTP).s(str3, true).x(dg2VarB).r(-1).m());
        if (!yy4.n(str4)) {
            String strK0 = z ? k0(ko1Var, str2, strSubstring, str3) : l0(ko1Var, str4);
            qd.a aVar = new qd.a();
            mj0 mj0Var = mj0.HLS;
            qd qdVarM = aVar.u(str5 + "-" + mj0Var).s(strK0, true).t(mj0Var).x(dg2VarB).r(-1).w(str4).m();
            if (!oe4.a(qdVarM, this.k)) {
                this.k.add(qdVarM);
            }
        }
        String strH = xo1.h(ko1Var, "torrentUrl");
        if (yy4.n(strH)) {
            return;
        }
        List list = this.k;
        qd.a aVar2 = new qd.a();
        mj0 mj0Var2 = mj0.TORRENT;
        list.add(aVar2.u(str5 + "-" + str2 + "-" + mj0Var2).s(strH, true).t(mj0Var2).x(dg2VarB).r(-1).m());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g0(ko1 ko1Var, boolean z, String str, String str2, String str3, String str4) {
        String strSubstring = str3.substring(str3.lastIndexOf(".") + 1);
        dg2 dg2VarB = dg2.b(strSubstring);
        String str5 = str + "-" + strSubstring;
        boolean z2 = ko1Var.q("hasAudio") && !ko1Var.d("hasAudio");
        this.l.add(new f35.a().d(str5 + "-" + str2 + "-" + mj0.PROGRESSIVE_HTTP).b(str3, true).e(z2).i(str).h(dg2VarB).a());
        if (!yy4.n(str4)) {
            String strK0 = z ? k0(ko1Var, str2, strSubstring, str3) : l0(ko1Var, str4);
            f35.a aVar = new f35.a();
            mj0 mj0Var = mj0.HLS;
            f35 f35VarA = aVar.d(str5 + "-" + mj0Var).b(strK0, true).e(z2).c(mj0Var).i(str).h(dg2VarB).g(str4).a();
            if (!oe4.a(f35VarA, this.l)) {
                this.l.add(f35VarA);
            }
        }
        String strH = xo1.h(ko1Var, "torrentUrl");
        if (yy4.n(strH)) {
            return;
        }
        List list = this.l;
        f35.a aVar2 = new f35.a();
        mj0 mj0Var2 = mj0.TORRENT;
        list.add(aVar2.d(str5 + "-" + str2 + "-" + mj0Var2).b(strH, true).e(z2).c(mj0Var2).i(str).h(dg2VarB).a());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h0(af4 af4Var, ko1 ko1Var) throws s83 {
        try {
            for (Object obj : (eo1) xo1.j(ko1Var, "data")) {
                if (obj instanceof ko1) {
                    ha3 ha3Var = new ha3((ko1) obj, this.h);
                    if (!ha3Var.getUrl().equals(o())) {
                        af4Var.d(ha3Var);
                    }
                }
            }
        } catch (Exception e) {
            uo1.a("Could not extract related videos", e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void i0() throws s83 {
        try {
            Stream map = this.i.b("streamingPlaylists").stream().filter(new co1(ko1.class)).map(new e72(ko1.class)).map(new Function() { // from class: ea3
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    ko1 ko1Var = (ko1) obj;
                    return new f35.a().d(String.valueOf(ko1Var.i(Name.MARK, -1))).b(ko1Var.p("playlistUrl", ""), true).e(false).i("").h(dg2.MPEG_4).c(mj0.HLS).a();
                }
            });
            final List list = this.l;
            Objects.requireNonNull(list);
            map.forEachOrdered(new Consumer() { // from class: fa3
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    list.add((f35) obj);
                }
            });
        } catch (Exception e) {
            uo1.a("Could not get video streams", e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gz0
    public String j() {
        return xo1.h(this.i, "name");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ko1 j0(String str) throws s83 {
        ws3 ws3VarB = e().b(this.h + "/api/v1/videos/" + h() + ServiceReference.DELIMITER + str);
        if (ws3VarB == null) {
            ny4.a("Could not get segments from API.");
            return null;
        }
        if (ws3VarB.d() == 400) {
            return null;
        }
        if (ws3VarB.d() == 200) {
            try {
                return (ko1) lo1.d().a(ws3VarB.c());
            } catch (mo1 e) {
                uo1.a("Could not parse json data for segments", e);
                return null;
            }
        }
        throw new s83("Could not get segments from API. Response code: " + ws3VarB.d());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String k0(ko1 ko1Var, String str, String str2, String str3) {
        if ("fileDownloadUrl".equals(str)) {
            str3 = xo1.h(ko1Var, "fileUrl");
        }
        return str3.replace("-fragmented." + str2, ".m3u8");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String l0(ko1 ko1Var, String str) {
        return str.replace("master", xo1.e(ko1Var, "resolution.id").toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: H()Lxj1; */
    @Override // defpackage.ue4
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public af4 H() throws s83 {
        String strN0;
        List listP = P();
        if (listP.isEmpty()) {
            strN0 = this.h + "/api/v1/accounts/" + xo1.h(this.i, "account.name") + "@" + xo1.h(this.i, "account.host") + "/videos?start=0&count=8";
        } else {
            strN0 = n0(listP);
        }
        if (yy4.l(strN0)) {
            return null;
        }
        af4 af4Var = new af4(m());
        p0(af4Var, strN0);
        return af4Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String n0(List list) {
        String str = this.h + "/api/v1/search/videos";
        StringBuilder sb = new StringBuilder("start=0&count=8&sort=-createdAt");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            sb.append("&tagsOneOf=");
            sb.append(yy4.f(str2));
        }
        return str + "?" + ((Object) sb);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void o0() throws s83 {
        q0(this.i.b("files"), "");
        try {
            for (ko1 ko1Var : (List) this.i.b("streamingPlaylists").stream().filter(new co1(ko1.class)).map(new e72(ko1.class)).collect(Collectors.toList())) {
                q0(ko1Var.b("files"), ko1Var.o("playlistUrl"));
            }
        } catch (Exception e) {
            uo1.a("Could not get streams", e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gz0
    public void p(gn0 gn0Var) throws fz0 {
        ws3 ws3VarB = gn0Var.b(this.h + "/api/v1/videos/" + h());
        if (ws3VarB == null) {
            throw new fz0("Could not extract PeerTube channel data");
        }
        s0(ws3VarB.c());
        r0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void p0(af4 af4Var, String str) throws s83 {
        ko1 ko1Var;
        ws3 ws3VarB = e().b(str);
        if (ws3VarB == null || yy4.l(ws3VarB.c())) {
            ko1Var = null;
        } else {
            try {
                ko1Var = (ko1) lo1.d().a(ws3VarB.c());
            } catch (mo1 e) {
                uo1.a("Could not parse json data for related videos", e);
                return;
            }
        }
        if (ko1Var != null) {
            h0(af4Var, ko1Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public int q() {
        return xo1.b(this.i, "nsfw").booleanValue() ? 18 : 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void q0(eo1 eo1Var, String str) throws s83 {
        ga3 ga3Var;
        String str2;
        try {
            boolean z = !yy4.n(str) && str.endsWith("-master.m3u8");
            for (ko1 ko1Var : (List) eo1Var.stream().filter(new co1(ko1.class)).map(new e72(ko1.class)).collect(Collectors.toList())) {
                String strH = xo1.h(ko1Var, ko1Var.q("fileUrl") ? "fileUrl" : "fileDownloadUrl");
                if (yy4.n(strH)) {
                    return;
                }
                String strH2 = xo1.h(ko1Var, "resolution.label");
                String str3 = ko1Var.q("fileUrl") ? "fileUrl" : "fileDownloadUrl";
                if (strH2.toLowerCase().contains("audio")) {
                    ga3Var = this;
                    str2 = str;
                    ga3Var.f0(ko1Var, z, strH2, str3, strH, str2);
                } else {
                    ga3Var = this;
                    str2 = str;
                    ga3Var.g0(ko1Var, z, strH2, str3, strH, str2);
                }
                this = ga3Var;
                str = str2;
            }
        } catch (Exception e) {
            uo1.a("Could not get streams from array", e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List r() throws s83 {
        a();
        if (this.k.isEmpty() && this.l.isEmpty() && J() == gf4.VIDEO_STREAM) {
            o0();
        }
        return this.k;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void r0() {
        if (this.j.isEmpty()) {
            try {
                for (Object obj : xo1.a((ko1) lo1.d().a(e().b(this.h + "/api/v1/videos/" + h() + "/captions").c()), "data")) {
                    if (obj instanceof ko1) {
                        ko1 ko1Var = (ko1) obj;
                        String str = this.h + xo1.h(ko1Var, "captionPath");
                        String strH = xo1.h(ko1Var, "language.id");
                        dg2 dg2VarB = dg2.b(str.substring(str.lastIndexOf(".") + 1));
                        if (dg2VarB != null && !yy4.n(strH)) {
                            this.j.add(new si4.a().c(str, true).e(dg2VarB).d(strH).b(false).a());
                        }
                    }
                }
            } catch (Exception e) {
                this.m = new s83("Could not get subtitles", e);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String s() {
        return xo1.h(this.i, "category.label");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void s0(String str) throws fz0 {
        try {
            ko1 ko1Var = (ko1) lo1.d().a(str);
            this.i = ko1Var;
            if (ko1Var == null) {
                throw new fz0("Could not extract PeerTube stream data");
            }
            ba3.g(ko1Var);
        } catch (mo1 e) {
            throw new fz0("Could not extract PeerTube stream data", e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public qj0 v() {
        try {
            String strH = xo1.h(this.i, "description");
            if (strH.length() == 250 && strH.substring(247).equals("...")) {
                gn0 gn0VarA = a33.a();
                try {
                    strH = xo1.h((ko1) lo1.d().a(gn0VarA.b(this.h + "/api/v1/videos/" + h() + "/description").c()), "description");
                } catch (fo3 | IOException | mo1 unused) {
                }
            }
            return new qj0(strH, 2);
        } catch (s83 unused2) {
            return qj0.h;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public long w() {
        return this.i.j("dislikes");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List y() throws fz0 {
        ArrayList arrayList = new ArrayList();
        try {
            ko1 ko1VarJ0 = j0("storyboards");
            if (ko1VarJ0 != null && ko1VarJ0.q("storyboards")) {
                for (Object obj : ko1VarJ0.b("storyboards")) {
                    if (obj instanceof ko1) {
                        ko1 ko1Var = (ko1) obj;
                        String strO = ko1Var.o("storyboardPath");
                        int iH = ko1Var.h("spriteWidth");
                        int iH2 = ko1Var.h("spriteHeight");
                        int iH3 = ko1Var.h("totalWidth") / iH;
                        int iH4 = ko1Var.h("totalHeight") / iH2;
                        arrayList.add(new u71(av4.a(new Object[]{this.h + strO}), iH, iH2, iH3 * iH4, ko1Var.h("spriteDuration") * 1000, iH3, iH4));
                    }
                }
            }
            return arrayList;
        } catch (fo3 | IOException e) {
            throw new fz0("Could not get frames", e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String z() {
        a();
        return (J() != gf4.VIDEO_STREAM || yy4.p(this.i.m("files"))) ? this.i.b("streamingPlaylists").d(0).p("playlistUrl", "") : this.i.m("files").p("playlistUrl", "");
    }
}
