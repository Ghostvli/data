package defpackage;

import defpackage.g40;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class zr4 implements g40.b {
    public static final a g = new a(null);
    public final h30 f;

    public zr4(h30 h30Var) {
        h30Var.getClass();
        this.f = h30Var;
    }

    @Override // defpackage.g40
    public g40 B(g40.c cVar) {
        return g40.b.a.c(this, cVar);
    }

    @Override // defpackage.g40
    public g40 N(g40 g40Var) {
        return g40.b.a.d(this, g40Var);
    }

    @Override // defpackage.g40
    public Object T(Object obj, Function2 function2) {
        return g40.b.a.a(this, obj, function2);
    }

    @Override // g40.b, defpackage.g40
    public g40.b a(g40.c cVar) {
        return g40.b.a.b(this, cVar);
    }

    public final h30 b() {
        return this.f;
    }

    @Override // g40.b
    public g40.c getKey() {
        return g;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements g40.c {
        public /* synthetic */ a(we0 we0Var) {
            this();
        }

        public a() {
        }
    }
}
