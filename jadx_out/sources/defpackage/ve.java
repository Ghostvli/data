package defpackage;

import defpackage.jj4;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ve implements jj4.c {
    public final jj4.c a;
    public final pe b;

    public ve(jj4.c cVar, pe peVar) {
        cVar.getClass();
        peVar.getClass();
        this.a = cVar;
        this.b = peVar;
    }

    @Override // jj4.c
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public se a(jj4.b bVar) {
        bVar.getClass();
        return new se(this.a.a(bVar), this.b);
    }
}
