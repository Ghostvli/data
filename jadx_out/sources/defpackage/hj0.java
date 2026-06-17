package defpackage;

import defpackage.g40;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class hj0 {
    public static final Object a(long j, f30 f30Var) {
        if (j <= 0) {
            return fw4.a;
        }
        sp spVar = new sp(jl1.c(f30Var), 1);
        spVar.E();
        if (j < Long.MAX_VALUE) {
            b(spVar.getContext()).F(j, spVar);
        }
        Object objY = spVar.y();
        if (objY == kl1.e()) {
            ta0.c(f30Var);
        }
        return objY == kl1.e() ? objY : fw4.a;
    }

    public static final gj0 b(g40 g40Var) {
        g40.b bVarA = g40Var.a(h30.b);
        gj0 gj0Var = bVarA instanceof gj0 ? (gj0) bVarA : null;
        return gj0Var == null ? rf0.a() : gj0Var;
    }

    public static final long c(long j) {
        boolean zO = tp0.o(j);
        if (zO) {
            return tp0.e(tp0.p(j, wp0.n(999999L, xp0.g)));
        }
        if (zO) {
            throw new j33();
        }
        return 0L;
    }
}
