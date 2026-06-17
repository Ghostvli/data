package defpackage;

import android.net.Uri;
import com.fongmi.android.tv.App;
import com.github.catvod.utils.Path;
import defpackage.aa0;
import defpackage.go;
import defpackage.jq2;
import defpackage.s53;
import defpackage.wy;
import defpackage.ye0;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class tq2 implements jq2.a {
    public static y64 g;
    public final ug0 c = new ug0(k(), l());
    public lg1 d;
    public aa0.a e;
    public pz0 f;

    public static y64 i() {
        if (g == null) {
            g = new y64(Path.exo(), new e33(), new qd4(App.b()));
        }
        return g;
    }

    @Override // jq2.a
    public jq2 e(fg2 fg2Var) {
        m().a(ny0.l(fg2Var));
        Uri uri = fg2Var.h.a;
        String string = uri != null ? uri.toString() : "";
        return (string.contains("***") && string.contains("|||")) ? h(fg2Var, string) : this.c.e(fg2Var);
    }

    @Override // jq2.a
    public jq2.a f(zo0 zo0Var) {
        return this;
    }

    @Override // jq2.a
    public jq2.a g(sy1 sy1Var) {
        return this;
    }

    public final jq2 h(fg2 fg2Var, String str) {
        wy.b bVar = new wy.b();
        for (String str2 : str.split("\\*\\*\\*")) {
            String[] strArrSplit = str2.split("\\|\\|\\|");
            if (strArrSplit.length >= 2) {
                bVar.a(this.c.e(fg2Var.a().k(Uri.parse(strArrSplit[0])).a()), Long.parseLong(strArrSplit[1]));
            }
        }
        return bVar.b();
    }

    public final go.c j(aa0.a aVar) {
        return new go.c().e(i()).h(aVar).f(null).g(2);
    }

    public final aa0.a k() {
        if (this.e == null) {
            this.e = j(new ye0.a(App.b(), m()));
        }
        return this.e;
    }

    public final pz0 l() {
        if (this.f == null) {
            this.f = new vf0().q(64).r(1128000);
        }
        return this.f;
    }

    public final lg1 m() {
        if (this.d == null) {
            this.d = new s53.b(q53.A());
        }
        return this.d;
    }
}
