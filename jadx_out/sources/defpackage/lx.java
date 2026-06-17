package defpackage;

import defpackage.wm0;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class lx extends ms1 {
    public lx(String str) {
        super(str);
    }

    @Override // defpackage.l33
    public String C() {
        return "#comment";
    }

    @Override // defpackage.l33
    public void J(uj3 uj3Var, wm0.a aVar) {
        uj3Var.b("<!--").b(f0()).b("-->");
    }

    @Override // defpackage.l33
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public lx clone() {
        return (lx) super.clone();
    }

    public String f0() {
        return a0();
    }
}
