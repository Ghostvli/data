package defpackage;

import defpackage.f35;
import defpackage.qd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.function.Supplier;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class t72 extends ue4 {
    public ko1 h;
    public ko1 i;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public t72(wf4 wf4Var, vt1 vt1Var) {
        super(wf4Var, vt1Var);
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0010: CONSTRUCTOR 
      (wrap:java.lang.String:STR_CONCAT ("Cannot convert this language to a locale: "), (r3v0 java.lang.String) A[MD:():java.lang.String (c), SYNTHETIC, WRAPPED] (LINE:13))
     A[MD:(java.lang.String):void (m)] (LINE:17) call: s83.<init>(java.lang.String):void type: CONSTRUCTOR */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ s83 e0(String str) {
        return new s83("Cannot convert this language to a locale: " + str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public Locale B() {
        return pz1.f(this.h.o("original_language"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public long C() {
        return this.h.h(Name.LENGTH);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public gf4 J() {
        return gf4.VIDEO_STREAM;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List P() {
        return xo1.i(this.h.b("tags"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String Q() {
        return this.h.o("release_date");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List R() {
        return q72.e(this.h);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public qa0 U() {
        return qa0.b(Q());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List V() {
        return q72.a(this.i.o("logo_url"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String W() {
        return this.h.o("conference_url").replaceFirst("https://(api\\.)?media\\.ccc\\.de/public/conferences/", "");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String Y() {
        return "https://media.ccc.de/c/" + W();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List Z() {
        return Collections.EMPTY_LIST;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List a0() {
        eo1 eo1VarB = this.h.b("recordings");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < eo1VarB.size(); i++) {
            ko1 ko1VarD = eo1VarB.d(i);
            String strO = ko1VarD.o("mime_type");
            if (strO.startsWith("video")) {
                arrayList.add(new f35.a().d(ko1VarD.p("filename", " ")).b(ko1VarD.o("recording_url"), true).e(false).h(strO.endsWith("webm") ? dg2.WEBM : strO.endsWith("mp4") ? dg2.MPEG_4 : null).i(ko1VarD.h("height") + "p").a());
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public long b0() {
        return this.h.h("view_count");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gz0
    public String j() {
        return this.h.o("title");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gz0
    public String k() {
        return this.h.o("frontend_link");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gz0
    public void p(gn0 gn0Var) throws fz0 {
        String str = "https://api.media.ccc.de/public/events/" + h();
        try {
            this.h = (ko1) lo1.d().a(gn0Var.b(str).c());
            this.i = (ko1) lo1.d().a(gn0Var.b(this.h.o("conference_url")).c());
        } catch (mo1 e) {
            throw new fz0("Could not parse json returned by URL: ".concat(str), e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List r() {
        eo1 eo1VarB = this.h.b("recordings");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < eo1VarB.size(); i++) {
            ko1 ko1VarD = eo1VarB.d(i);
            String strO = ko1VarD.o("mime_type");
            if (strO.startsWith("audio")) {
                qd.a aVarR = new qd.a().u(ko1VarD.p("filename", " ")).s(ko1VarD.o("recording_url"), true).x(strO.endsWith("opus") ? dg2.OPUS : strO.endsWith("mpeg") ? dg2.MP3 : strO.endsWith("ogg") ? dg2.OGG : null).r(-1);
                final String strO2 = ko1VarD.o("language");
                if (strO2 != null && !strO2.contains("-")) {
                    aVarR.n((Locale) iz1.a(strO2).orElseThrow(new Supplier() { // from class: s72
                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // java.util.function.Supplier
                        public final Object get() {
                            return t72.e0(strO2);
                        }
                    }));
                }
                arrayList.add(aVarR.m());
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public qj0 v() {
        return new qj0(this.h.o("description"), 3);
    }
}
