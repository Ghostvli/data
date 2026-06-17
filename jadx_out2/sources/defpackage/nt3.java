package defpackage;

import defpackage.kt3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class nt3 extends qn1 {
    public final sp j;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public nt3(sp spVar) {
        this.j = spVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.qn1
    public boolean w() {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.qn1
    public void x(Throwable th) {
        Object objE0 = v().e0();
        boolean z = objE0 instanceof zx;
        sp spVar = this.j;
        if (z) {
            kt3.a aVar = kt3.g;
            spVar.resumeWith(kt3.b(lt3.a(((zx) objE0).a)));
        } else {
            kt3.a aVar2 = kt3.g;
            spVar.resumeWith(kt3.b(tn1.h(objE0)));
        }
    }
}
