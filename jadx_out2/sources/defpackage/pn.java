package defpackage;

import defpackage.wm0;
import org.jupnp.xml.DOM;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class pn extends sm4 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public pn(String str) {
        super(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.sm4, defpackage.l33
    public String C() {
        return "#cdata";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.sm4, defpackage.l33
    public void J(uj3 uj3Var, wm0.a aVar) {
        uj3Var.b(DOM.CDATA_BEGIN).b(f0()).b(DOM.CDATA_END);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: clone()Ljava/lang/Object; */
    /* JADX DEBUG: Method merged with bridge method: e0()Lsm4; */
    /* JADX DEBUG: Method merged with bridge method: n()Ll33; */
    @Override // defpackage.sm4, defpackage.l33
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public pn clone() {
        return (pn) super.clone();
    }
}
