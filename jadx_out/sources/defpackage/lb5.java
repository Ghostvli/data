package defpackage;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class lb5 implements ye3 {
    public final ko1 a;
    public final ko1 b;
    public final ko1 c;
    public final ko1 d;
    public we3 e;

    public lb5(ko1 ko1Var) {
        this.a = ko1Var;
        this.b = ko1Var.m("contentImage").m("collectionThumbnailViewModel").m("primaryThumbnail").m("thumbnailViewModel");
        ko1 ko1VarM = ko1Var.m("metadata").m("lockupMetadataViewModel");
        this.c = ko1VarM;
        this.d = ko1VarM.m("metadata").m("contentMetadataViewModel").b("metadataRows").d(0);
        try {
            this.e = cc5.q(v());
        } catch (s83 unused) {
            this.e = we3.NORMAL;
        }
    }

    public static /* synthetic */ s83 r() {
        return new s83("Could not get thumbnailOverlayBadgeViewModel");
    }

    public static /* synthetic */ s83 s() {
        return new s83("Could not get thumbnailBadgeViewModel");
    }

    @Override // defpackage.ye3
    public String a() {
        if (this.e != we3.NORMAL) {
            return null;
        }
        return cc5.O(this.d.b("metadataParts").d(0).m("text").b("commandRuns").d(0).m("onTap").m("innertubeCommand"));
    }

    @Override // defpackage.ye3
    public boolean b() {
        if (this.e != we3.NORMAL) {
            return false;
        }
        return cc5.S(this.d.b("metadataParts").d(0).m("text").b("attachmentRuns"));
    }

    @Override // defpackage.ye3
    public long c() throws s83 {
        if (this.e != we3.NORMAL) {
            return -2L;
        }
        try {
            return Long.parseLong(yy4.t(((ko1) ((ko1) this.b.b("overlays").stream().filter(new co1(ko1.class)).map(new e72(ko1.class)).filter(new Predicate() { // from class: hb5
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((ko1) obj).q("thumbnailOverlayBadgeViewModel");
                }
            }).findFirst().orElseThrow(new Supplier() { // from class: ib5
                @Override // java.util.function.Supplier
                public final Object get() {
                    return lb5.r();
                }
            })).m("thumbnailOverlayBadgeViewModel").b("thumbnailBadges").stream().filter(new co1(ko1.class)).map(new e72(ko1.class)).filter(new Predicate() { // from class: jb5
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((ko1) obj).q("thumbnailBadgeViewModel");
                }
            }).findFirst().orElseThrow(new Supplier() { // from class: kb5
                @Override // java.util.function.Supplier
                public final Object get() {
                    return lb5.s();
                }
            })).m("thumbnailBadgeViewModel").o("text")));
        } catch (Exception e) {
            uo1.a("Could not get playlist stream count", e);
            return 0L;
        }
    }

    @Override // defpackage.ye3
    public String d() {
        return this.d.b("metadataParts").d(0).m("text").o("content");
    }

    @Override // defpackage.wj1
    public String getName() {
        return this.c.m("title").o("content");
    }

    @Override // defpackage.wj1
    public String getUrl() {
        if (this.e == we3.NORMAL) {
            try {
                return gc5.n().f(v());
            } catch (Exception unused) {
            }
        }
        return cc5.O(this.a.m("rendererContext").m("commandContext").m("onTap").m("innertubeCommand"));
    }

    @Override // defpackage.ye3
    public we3 i() {
        return this.e;
    }

    @Override // defpackage.wj1
    public List n() {
        return cc5.E(this.b.m("image").b("sources"));
    }

    public final String v() throws s83 {
        String strO = this.a.o("contentId");
        if (yy4.n(strO)) {
            strO = this.a.m("rendererContext").m("commandContext").m("watchEndpoint").o("playlistId");
        }
        if (!yy4.n(strO)) {
            return strO;
        }
        ny4.a("Could not get playlist ID");
        return null;
    }
}
