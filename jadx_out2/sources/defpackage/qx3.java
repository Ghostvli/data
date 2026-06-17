package defpackage;

import android.os.Bundle;
import defpackage.yo3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class qx3 {
    public final ux3 a;
    public yo3.b b;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void a(vx3 vx3Var);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        Bundle a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public qx3(ux3 ux3Var) {
        ux3Var.getClass();
        this.a = ux3Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Bundle a(String str) {
        str.getClass();
        return this.a.c(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final b b(String str) {
        str.getClass();
        return this.a.d(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void c(String str, b bVar) {
        str.getClass();
        bVar.getClass();
        this.a.i(str, bVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void d(Class cls) {
        cls.getClass();
        if (!this.a.e()) {
            e04.a("Can not perform this action after onSaveInstanceState");
            return;
        }
        yo3.b bVar = this.b;
        if (bVar == null) {
            bVar = new yo3.b(this);
        }
        this.b = bVar;
        try {
            cls.getDeclaredConstructor(null);
            yo3.b bVar2 = this.b;
            if (bVar2 != null) {
                bVar2.b(cls.getName());
            }
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Class " + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
        }
    }
}
