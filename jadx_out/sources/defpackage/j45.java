package defpackage;

import androidx.lifecycle.e;
import androidx.lifecycle.x;
import defpackage.d50;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class j45 {
    public static final j45 a = new j45();

    public final d50 a(l45 l45Var) {
        l45Var.getClass();
        return l45Var instanceof e ? ((e) l45Var).M() : d50.b.c;
    }

    public final x.c b(l45 l45Var) {
        l45Var.getClass();
        return l45Var instanceof e ? ((e) l45Var).L() : ej0.b;
    }

    public final String c(hp1 hp1Var) {
        hp1Var.getClass();
        String strA = zp.a(hp1Var);
        if (strA != null) {
            return "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA);
        }
        jl.a("Local and anonymous classes can not be ViewModels");
        return null;
    }

    public final c45 d() {
        throw new UnsupportedOperationException("`Factory.create(String, CreationExtras)` is not implemented. You may need to override the method and provide a custom implementation. Note that using `Factory.create(String)` is not supported and considered an error.");
    }
}
