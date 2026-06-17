package defpackage;

import defpackage.bu1;
import j$.util.Base64;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;
import java.util.function.Predicate;
import org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class fc5 extends ve3 {
    public ko1 h;
    public ko1 i;
    public boolean j;

    public fc5(wf4 wf4Var, fu1 fu1Var) {
        super(wf4Var, fu1Var);
    }

    public static /* synthetic */ void q(af4 af4Var, go4 go4Var, ko1 ko1Var) {
        if (ko1Var.q("playlistVideoRenderer")) {
            af4Var.d(new ud5(ko1Var.m("playlistVideoRenderer"), go4Var));
            return;
        }
        if (ko1Var.q("richItemRenderer")) {
            ko1 ko1VarM = ko1Var.m("richItemRenderer");
            if (ko1VarM.q("content")) {
                ko1 ko1VarM2 = ko1VarM.m("content");
                if (ko1VarM2.q("reelItemRenderer")) {
                    af4Var.d(new hc5(ko1VarM2.m("reelItemRenderer")));
                }
            }
        }
    }

    @Override // defpackage.gz0
    public void p(gn0 gn0Var) throws x20 {
        String strH = h();
        pz1 pz1VarG = g();
        String strB = zo1.b(cc5.h0(pz1VarG, f()).h("browseId", "VL" + strH).h("params", "wgYCCAA%3D").b());
        Charset charset = StandardCharsets.UTF_8;
        ko1 ko1VarH = cc5.H("browse", av4.a(new Object[]{"$fields=sidebar,header,microformat,alerts"}), strB.getBytes(charset), pz1VarG);
        this.h = ko1VarH;
        cc5.l(ko1VarH);
        this.j = s();
        this.i = cc5.I("browse", zo1.b(cc5.h0(pz1VarG, f()).h("continuation", yy4.f(Base64.getUrlEncoder().encodeToString(((PlaylistProtobufContinuation.PlaylistContinuation) PlaylistProtobufContinuation.PlaylistContinuation.newBuilder().setParameters((PlaylistProtobufContinuation.ContinuationParams) PlaylistProtobufContinuation.ContinuationParams.newBuilder().setBrowseId("VL" + strH).setPlaylistId(strH).setContinuationProperties("CADCBgIIAA%3D%3D").m3build()).m3build()).toByteArray()))).b()).getBytes(charset), pz1VarG);
    }

    public final boolean s() {
        return this.h.q("header") && !this.h.q("sidebar");
    }

    public final void t(final af4 af4Var, eo1 eo1Var) {
        final go4 go4VarN = n();
        eo1Var.stream().filter(new co1(ko1.class)).map(new e72(ko1.class)).forEach(new Consumer() { // from class: ec5
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                fc5.q(af4Var, go4VarN, (ko1) obj);
            }
        });
    }

    public bu1.a u() {
        af4 af4Var = new af4(m());
        eo1 eo1VarB = this.i.b("onResponseReceivedActions").d(0).m("reloadContinuationItemsCommand").b("continuationItems");
        t(af4Var, eo1VarB);
        return new bu1.a(af4Var, v(eo1VarB));
    }

    public final e73 v(eo1 eo1Var) {
        if (yy4.o(eo1Var)) {
            return null;
        }
        ko1 ko1VarD = eo1Var.d(eo1Var.size() - 1);
        if (!ko1VarD.q("continuationItemRenderer")) {
            return null;
        }
        ko1 ko1VarM = ko1VarD.m("continuationItemRenderer").m("continuationEndpoint");
        if (ko1VarM.q("commandExecutorCommand")) {
            ko1VarM = (ko1) ko1VarM.m("commandExecutorCommand").b("commands").stream().filter(new co1(ko1.class)).map(new e72(ko1.class)).filter(new Predicate() { // from class: dc5
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((ko1) obj).q("continuationCommand");
                }
            }).findFirst().orElse(new ko1());
        }
        String strO = ko1VarM.m("continuationCommand").o("token");
        if (yy4.n(strO)) {
            return null;
        }
        return new e73("https://www.youtube.com/youtubei/v1/browse?prettyPrint=false", zo1.b(cc5.h0(g(), f()).h("continuation", strO).b()).getBytes(StandardCharsets.UTF_8));
    }

    public bu1.a w(e73 e73Var) {
        if (e73Var == null || yy4.n(e73Var.c())) {
            jl.a("Page doesn't contain an URL");
            return null;
        }
        af4 af4Var = new af4(m());
        eo1 eo1VarB = cc5.I("browse", e73Var.a(), g()).b("onResponseReceivedActions").d(0).m("appendContinuationItemsAction").b("continuationItems");
        t(af4Var, eo1VarB);
        return new bu1.a(af4Var, v(eo1VarB));
    }
}
