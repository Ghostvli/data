package defpackage;

import defpackage.wm0;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class sm4 extends ms1 {
    public sm4(String str) {
        super(str);
    }

    public static boolean h0(StringBuilder sb) {
        return sb.length() != 0 && sb.charAt(sb.length() - 1) == ' ';
    }

    @Override // defpackage.l33
    public String C() {
        return "#text";
    }

    @Override // defpackage.l33
    public void J(uj3 uj3Var, wm0.a aVar) {
        bt0.m(uj3Var, a0(), aVar, 1);
    }

    @Override // defpackage.l33
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public sm4 clone() {
        return (sm4) super.clone();
    }

    public String f0() {
        return a0();
    }

    public boolean g0() {
        return fg4.j(a0());
    }

    @Override // defpackage.l33
    public String toString() {
        return H();
    }
}
