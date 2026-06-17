package defpackage;

import defpackage.xl0;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class r90 implements xl0.b {
    public final ns0 a;
    public final Object b;
    public final u63 c;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public r90(ns0 ns0Var, Object obj, u63 u63Var) {
        this.a = ns0Var;
        this.b = obj;
        this.c = u63Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // xl0.b
    public boolean a(File file) {
        return this.a.a(this.b, file, this.c);
    }
}
