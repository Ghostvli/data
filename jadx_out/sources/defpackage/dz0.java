package defpackage;

import defpackage.fg2;
import defpackage.jq2;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class dz0 extends ji {
    public final long m;
    public fg2 n;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements jq2.a {
        public final long c;

        public b(long j, bz0 bz0Var) {
            this.c = j;
        }

        @Override // jq2.a
        public jq2.a f(zo0 zo0Var) {
            return this;
        }

        @Override // jq2.a
        public jq2.a g(sy1 sy1Var) {
            return this;
        }

        @Override // jq2.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public dz0 e(fg2 fg2Var) {
            return new dz0(fg2Var, this.c, null);
        }
    }

    public dz0(fg2 fg2Var, long j, bz0 bz0Var) {
        this.n = fg2Var;
        this.m = j;
    }

    @Override // defpackage.ji
    public void E(hs4 hs4Var) {
        F(new h74(this.m, true, false, false, null, i()));
    }

    @Override // defpackage.ji
    public void G() {
    }

    @Override // defpackage.jq2
    public boolean a(fg2 fg2Var) {
        fg2.h hVar = fg2Var.b;
        fg2.h hVar2 = (fg2.h) gg3.q(i().b);
        if (hVar == null || !hVar.a.equals(hVar2.a) || !Objects.equals(hVar.b, hVar2.b)) {
            return false;
        }
        long j = hVar.j;
        return j == -9223372036854775807L || fy4.c1(j) == this.m;
    }

    @Override // defpackage.jq2
    public mi2 d(jq2.b bVar, j5 j5Var, long j) {
        fg2 fg2VarI = i();
        gg3.q(fg2VarI.b);
        gg3.r(fg2VarI.b.b, "Externally loaded mediaItems require a MIME type.");
        fg2.h hVar = fg2VarI.b;
        return new cz0(hVar.a, hVar.b, null);
    }

    @Override // defpackage.jq2
    public synchronized fg2 i() {
        return this.n;
    }

    @Override // defpackage.jq2
    public void m() {
    }

    @Override // defpackage.jq2
    public synchronized void q(fg2 fg2Var) {
        this.n = fg2Var;
    }

    @Override // defpackage.jq2
    public void s(mi2 mi2Var) {
        ((cz0) mi2Var).l();
    }
}
