package defpackage;

import defpackage.wm0;
import org.jupnp.xml.DOM;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class w90 extends ms1 {
    public w90(String str) {
        super(str);
    }

    @Override // defpackage.l33
    public String C() {
        return "#data";
    }

    @Override // defpackage.l33
    public void J(uj3 uj3Var, wm0.a aVar) {
        String strF0 = f0();
        if (aVar.j() != wm0.a.EnumC0128a.xml || strF0.contains(DOM.CDATA_BEGIN)) {
            uj3Var.b(strF0);
            return;
        }
        if (M("script")) {
            uj3Var.b("//<![CDATA[\n").b(strF0).b("\n//]]>");
        } else if (M("style")) {
            uj3Var.b("/*<![CDATA[*/\n").b(strF0).b("\n/*]]>*/");
        } else {
            uj3Var.b(DOM.CDATA_BEGIN).b(strF0).b(DOM.CDATA_END);
        }
    }

    @Override // defpackage.l33
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public w90 clone() {
        return (w90) super.clone();
    }

    public String f0() {
        return a0();
    }
}
