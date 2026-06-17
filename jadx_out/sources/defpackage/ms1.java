package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ms1 extends l33 {
    public Object i;

    public ms1(String str) {
        zy4.j(str);
        this.i = str;
    }

    @Override // defpackage.l33
    public String F() {
        return a0();
    }

    public String a0() {
        return e(C());
    }

    @Override // defpackage.l33
    public String b(String str) {
        c0();
        return super.b(str);
    }

    @Override // defpackage.l33
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public ms1 o(l33 l33Var) {
        ms1 ms1Var = (ms1) super.o(l33Var);
        if (x()) {
            ms1Var.i = ((xb) this.i).clone();
        }
        return ms1Var;
    }

    public final void c0() {
        if (x()) {
            return;
        }
        String str = (String) this.i;
        xb xbVar = new xb();
        this.i = xbVar;
        xbVar.C(C(), str);
    }

    @Override // defpackage.l33
    public l33 d(String str, String str2) {
        if (!x() && str.equals(C())) {
            this.i = str2;
            return this;
        }
        c0();
        super.d(str, str2);
        return this;
    }

    @Override // defpackage.l33
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public br0 L() {
        return this.f;
    }

    @Override // defpackage.l33
    public String e(String str) {
        return !x() ? C().equals(str) ? (String) this.i : "" : super.e(str);
    }

    @Override // defpackage.l33
    public final xb f() {
        c0();
        return (xb) this.i;
    }

    @Override // defpackage.l33
    public String g() {
        br0 br0Var = this.f;
        return br0Var != null ? br0Var.g() : "";
    }

    @Override // defpackage.l33
    public int l() {
        return 0;
    }

    @Override // defpackage.l33
    public void p(String str) {
    }

    @Override // defpackage.l33
    public l33 q() {
        return this;
    }

    @Override // defpackage.l33
    public List r() {
        return l33.h;
    }

    @Override // defpackage.l33
    public final boolean x() {
        return this.i instanceof xb;
    }
}
