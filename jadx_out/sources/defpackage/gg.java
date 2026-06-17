package defpackage;

import defpackage.di1;
import defpackage.qd;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class gg extends ng {
    public ko1 k;

    public gg(wf4 wf4Var, vt1 vt1Var) {
        super(wf4Var, vt1Var);
    }

    public static /* synthetic */ s83 i0() {
        return new s83("Could not get uploader name");
    }

    public static ko1 j0(int i) throws s83 {
        try {
            return (ko1) lo1.d().a(a33.a().b("https://bandcamp.com/api/bcweekly/1/get?id=" + i).c());
        } catch (fo3 | IOException | mo1 e) {
            uo1.a("could not get show data", e);
            return null;
        }
    }

    @Override // defpackage.ng, defpackage.ue4
    public long C() {
        return this.k.j("audio_duration");
    }

    @Override // defpackage.ng, defpackage.ue4
    public String D() {
        return "";
    }

    @Override // defpackage.ue4
    public List I() {
        eo1<ko1> eo1VarB = this.k.b("tracks");
        ArrayList arrayList = new ArrayList(eo1VarB.size());
        for (ko1 ko1Var : eo1VarB) {
            ff4 ff4Var = new ff4(ko1Var.o("title"), ko1Var.h("timecode"));
            ff4Var.b(dg.c(ko1Var.j("track_art_id"), true));
            ff4Var.a(ko1Var.o("artist"));
            arrayList.add(ff4Var);
        }
        return arrayList;
    }

    @Override // defpackage.ng, defpackage.ue4
    public List P() {
        return Collections.EMPTY_LIST;
    }

    @Override // defpackage.ng, defpackage.ue4
    public String Q() {
        return this.k.o("published_date");
    }

    @Override // defpackage.ng, defpackage.ue4
    public List R() {
        return dg.e(this.k.j("show_image_id"), false);
    }

    @Override // defpackage.ng, defpackage.ue4
    public List V() {
        return Collections.singletonList(new di1("https://bandcamp.com/img/buttons/bandcamp-button-circle-whitecolor-512.png", 512, 512, di1.a.MEDIUM));
    }

    @Override // defpackage.ng, defpackage.ue4
    public String W() {
        return (String) cp1.a(this.k.o("image_caption")).z0("a").stream().map(new dr0()).findFirst().orElseThrow(new Supplier() { // from class: fg
            @Override // java.util.function.Supplier
            public final Object get() {
                return gg.i0();
            }
        });
    }

    @Override // defpackage.ng, defpackage.ue4
    public String Y() throws y20 {
        throw new y20("Fan pages are not supported");
    }

    @Override // defpackage.ng, defpackage.ue4
    /* JADX INFO: renamed from: h0 */
    public ze3 H() {
        return null;
    }

    @Override // defpackage.ng, defpackage.gz0
    public String j() {
        return this.k.o("subtitle");
    }

    @Override // defpackage.ng, defpackage.gz0
    public String o() {
        return i().d();
    }

    @Override // defpackage.ng, defpackage.gz0
    public void p(gn0 gn0Var) {
        this.k = j0(Integer.parseInt(h()));
    }

    @Override // defpackage.ng, defpackage.ue4
    public List r() {
        ArrayList arrayList = new ArrayList();
        ko1 ko1VarM = this.k.m("audio_stream");
        if (ko1VarM.q("mp3-128")) {
            arrayList.add(new qd.a().u("mp3-128").s(ko1VarM.o("mp3-128"), true).x(dg2.MP3).r(128).m());
        }
        if (ko1VarM.q("opus-lo")) {
            arrayList.add(new qd.a().u("opus-lo").s(ko1VarM.o("opus-lo"), true).x(dg2.OPUS).r(100).m());
        }
        return arrayList;
    }

    @Override // defpackage.ng, defpackage.ue4
    public String s() {
        return "";
    }

    @Override // defpackage.ng, defpackage.ue4
    public qj0 v() {
        return new qj0(this.k.o("desc"), 3);
    }
}
