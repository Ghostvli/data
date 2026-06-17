package defpackage;

import defpackage.qd;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ng extends ue4 {
    public ko1 h;
    public ko1 i;
    public wm0 j;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ng(wf4 wf4Var, vt1 vt1Var) {
        super(wf4Var, vt1Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ko1 g0(String str) throws s83 {
        try {
            return xo1.d(str, "data-tralbum");
        } catch (ArrayIndexOutOfBoundsException e) {
            uo1.a("JSON does not exist", e);
            return null;
        } catch (mo1 e2) {
            uo1.a("Faulty JSON; page likely does not contain album data", e2);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public long C() {
        return (long) this.h.b("trackinfo").d(0).f("duration");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String D() {
        switch (this.i.h("license_type")) {
            case 1:
                return "All rights reserved ©";
            case 2:
                return "CC BY-NC-ND 3.0";
            case 3:
                return "CC BY-NC-SA 3.0";
            case 4:
                return "CC BY-NC 3.0";
            case 5:
                return "CC BY-ND 3.0";
            case 6:
                return "CC BY 3.0";
            case 7:
            default:
                return "Unknown";
            case 8:
                return "CC BY-SA 3.0";
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public gf4 J() {
        return gf4.AUDIO_STREAM;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List P() {
        return (List) this.j.x0("itemprop", "keywords").stream().map(new dr0()).collect(Collectors.toList());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String Q() {
        return this.i.o("publish_date");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List R() {
        return this.h.r("art_id") ? Collections.EMPTY_LIST : dg.e(this.h.j("art_id"), true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public qa0 U() {
        return dg.i(Q());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List V() {
        return dg.f((String) this.j.y0("band-photo").stream().map(new Function() { // from class: jg
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((br0) obj).e("src");
            }
        }).findFirst().orElse(""));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String W() {
        return this.h.o("artist");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String Y() {
        return "https://" + o().split(ServiceReference.DELIMITER)[2] + ServiceReference.DELIMITER;
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
    /* JADX DEBUG: Method merged with bridge method: H()Lxj1; */
    @Override // defpackage.ue4
    /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
    public ze3 H() {
        final ze3 ze3Var = new ze3(m());
        this.j.y0("recommended-album").stream().map(new Function() { // from class: lg
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return new hg((br0) obj);
            }
        }).forEach(new Consumer() { // from class: mg
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ze3Var.d((hg) obj);
            }
        });
        return ze3Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gz0
    public String j() {
        return this.i.o("title");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gz0
    public String o() {
        return yy4.u(this.h.o("url"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gz0
    public void p(gn0 gn0Var) throws fz0 {
        String strC = gn0Var.b(i().d()).c();
        this.j = cp1.a(strC);
        ko1 ko1VarG0 = g0(strC);
        this.h = ko1VarG0;
        this.i = ko1VarG0.m("current");
        if (this.h.b("trackinfo").size() > 1) {
            throw new fz0("Page is actually an album, not a track");
        }
        if (this.h.b("trackinfo").d(0).r("file")) {
            throw new g73("This track is not available without being purchased");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List r() {
        return Collections.singletonList(new qd.a().u("mp3-128").s(this.h.b("trackinfo").d(0).m("file").o("mp3-128"), true).x(dg2.MP3).r(128).m());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String s() {
        return (String) this.j.y0("tralbum-tags").stream().flatMap(new Function() { // from class: kg
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((br0) obj).y0("tag").stream();
            }
        }).map(new dr0()).findFirst().orElse("");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public qj0 v() {
        return new qj0(yy4.r("\n\n", this.i.o("about"), this.i.o("lyrics"), this.i.o("credits")), 3);
    }
}
