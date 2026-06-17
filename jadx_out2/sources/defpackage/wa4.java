package defpackage;

import defpackage.qd;
import defpackage.ue4;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class wa4 extends ue4 {
    public ko1 h;
    public boolean i;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public wa4(wf4 wf4Var, vt1 vt1Var) {
        super(wf4Var, vt1Var);
        this.i = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void e0(wa4 wa4Var, List list, ko1 ko1Var) {
        wa4Var.getClass();
        String strO = ko1Var.o("url");
        if (yy4.n(strO)) {
            return;
        }
        try {
            String strP = ko1Var.p("preset", " ");
            String strO2 = ko1Var.m("format").o("protocol");
            if (strO2.contains("encrypted")) {
                return;
            }
            qd.a aVarU = new qd.a().u(strP);
            if (strO2.equals("hls")) {
                aVarU.t(mj0.HLS);
            }
            aVarU.s(wa4Var.h0(strO), true);
            if (strP.contains("mp3")) {
                aVarU.x(dg2.MP3);
                aVarU.r(128);
            } else if (strP.contains("opus")) {
                aVarU.x(dg2.OPUS);
                aVarU.r(64);
            } else {
                if (!strP.contains("aac_160k")) {
                    return;
                }
                aVarU.x(dg2.M4A);
                aVarU.r(160);
            }
            qd qdVarM = aVarU.m();
            if (oe4.a(qdVarM, list)) {
                return;
            }
            list.add(qdVarM);
        } catch (fz0 | IOException unused) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public long C() {
        return this.h.j("duration") / 1000;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String D() {
        return this.h.o("license");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public long E() {
        return this.h.k("likes_count", -1L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public ue4.a G() {
        return this.h.o("sharing").equals("public") ? ue4.a.PUBLIC : ue4.a.PRIVATE;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public gf4 J() {
        return gf4.AUDIO_STREAM;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List P() {
        String[] strArrSplit = this.h.o("tag_list").split(" ");
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (String str : strArrSplit) {
            if (str.startsWith("\"")) {
                sb.append(str.replace("\"", ""));
                z = true;
            } else if (z) {
                if (str.endsWith("\"")) {
                    sb.append(" ");
                    sb.append(str.replace("\"", ""));
                    arrayList.add(sb.toString());
                    z = false;
                } else {
                    sb.append(" ");
                    sb.append(str);
                }
            } else if (!str.isEmpty()) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String Q() {
        return this.h.o("created_at");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List R() {
        return sa4.e(this.h);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public long S() throws s83 {
        long jT = T("(#t=\\d{0,3}h?\\d{0,3}m?\\d{1,3}s?)");
        if (jT == -2) {
            return 0L;
        }
        return jT;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public qa0 U() {
        return sa4.l(Q());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List V() {
        return sa4.c(sa4.f(this.h));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String W() {
        return sa4.j(this.h);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String Y() {
        return sa4.k(this.h);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List Z() {
        return Collections.EMPTY_LIST;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List a0() {
        return Collections.EMPTY_LIST;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public long b0() {
        return this.h.j("playback_count");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public boolean d0() {
        return this.h.m("user").d("verified");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f0(eo1 eo1Var, final List list) {
        eo1Var.stream().filter(new co1(ko1.class)).map(new e72(ko1.class)).forEachOrdered(new Consumer() { // from class: va4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                wa4.e0(this.a, list, (ko1) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: H()Lxj1; */
    @Override // defpackage.ue4
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public af4 H() {
        af4 af4Var = new af4(m());
        sa4.h(af4Var, "https://api-v2.soundcloud.com/tracks/" + yy4.f(h()) + "/related?client_id=" + yy4.f(sa4.b()));
        return af4Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gz0
    public String h() {
        return String.valueOf(this.h.j(Name.MARK));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String h0(String str) throws s83 {
        String str2 = str + "?client_id=" + sa4.b();
        String strO = this.h.o("track_authorization");
        if (!yy4.n(strO)) {
            str2 = str2 + "&track_authorization=" + strO;
        }
        try {
            return ((ko1) lo1.d().a(a33.a().b(str2).c())).o("url");
        } catch (mo1 e) {
            uo1.a("Could not parse streamable URL", e);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gz0
    public String j() {
        return this.h.o("title");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gz0
    public void p(gn0 gn0Var) throws s83 {
        ko1 ko1VarM = sa4.m(gn0Var, o());
        this.h = ko1VarM;
        String strP = ko1VarM.p("policy", "");
        if (strP.equals("ALLOW") || strP.equals("MONETIZE")) {
            return;
        }
        this.i = false;
        if (strP.equals("SNIP")) {
            throw new oa4();
        }
        if (!strP.equals("BLOCK")) {
            throw new x20("Content not available: policy ".concat(strP));
        }
        throw new n91("This track is not available in user's country");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List r() throws fz0 {
        ArrayList arrayList = new ArrayList();
        if (this.h.d("streamable") && this.i) {
            try {
                eo1 eo1VarB = this.h.m("media").b("transcodings");
                if (!yy4.o(eo1VarB)) {
                    f0(eo1VarB, arrayList);
                    return arrayList;
                }
            } catch (NullPointerException e) {
                throw new fz0("Could not get audio streams", e);
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String s() {
        return this.h.o("genre");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public qj0 v() {
        return new qj0(this.h.o("description"), 3);
    }
}
