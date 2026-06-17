package defpackage;

import defpackage.kt3;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class fe4 extends d1 {
    public final AtomicReference a = new AtomicReference(null);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: a(Ljava/lang/Object;)Z */
    @Override // defpackage.d1
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(de4 de4Var) {
        if (bz.a(this.a) != null) {
            return false;
        }
        bz.b(this.a, ee4.a);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object e(f30 f30Var) {
        sp spVar = new sp(jl1.c(f30Var), 1);
        spVar.E();
        if (!pb.a(this.a, ee4.a, spVar)) {
            kt3.a aVar = kt3.g;
            spVar.resumeWith(kt3.b(fw4.a));
        }
        Object objY = spVar.y();
        if (objY == kl1.e()) {
            ta0.c(f30Var);
        }
        return objY == kl1.e() ? objY : fw4.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: b(Ljava/lang/Object;)[Lf30; */
    @Override // defpackage.d1
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public f30[] b(de4 de4Var) {
        bz.b(this.a, null);
        return c1.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g() {
        AtomicReference atomicReference = this.a;
        while (true) {
            Object objA = bz.a(atomicReference);
            if (objA == null || objA == ee4.b) {
                return;
            }
            qj4 qj4Var = ee4.a;
            AtomicReference atomicReference2 = this.a;
            if (objA == qj4Var) {
                if (pb.a(atomicReference2, objA, ee4.b)) {
                    return;
                }
            } else if (pb.a(atomicReference2, objA, ee4.a)) {
                kt3.a aVar = kt3.g;
                ((sp) objA).resumeWith(kt3.b(fw4.a));
                return;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean h() {
        Object andSet = this.a.getAndSet(ee4.a);
        andSet.getClass();
        return andSet == ee4.b;
    }
}
