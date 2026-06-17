package defpackage;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class s04 extends f04 {
    public final /* synthetic */ AtomicReferenceArray e;

    public s04(long j, s04 s04Var, int i) {
        super(j, s04Var, i);
        this.e = new AtomicReferenceArray(r04.f);
    }

    @Override // defpackage.f04
    public int r() {
        return r04.f;
    }

    @Override // defpackage.f04
    public void s(int i, Throwable th, g40 g40Var) {
        v().set(i, r04.e);
        t();
    }

    public String toString() {
        return "SemaphoreSegment[id=" + this.c + ", hashCode=" + hashCode() + ']';
    }

    public final /* synthetic */ AtomicReferenceArray v() {
        return this.e;
    }
}
