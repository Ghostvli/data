package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class as extends xj1 {
    public as(int i) {
        super(i);
    }

    @Override // defpackage.yw
    public /* bridge */ /* synthetic */ Object a(Object obj) {
        w82.a(obj);
        return h(null);
    }

    public yr h(zr zrVar) {
        yr yrVar = new yr(g(), zrVar.getUrl(), zrVar.getName());
        try {
            yrVar.i(zrVar.p());
        } catch (Exception e) {
            b(e);
        }
        try {
            yrVar.h(zrVar.c());
        } catch (Exception e2) {
            b(e2);
        }
        try {
            yrVar.f(zrVar.n());
        } catch (Exception e3) {
            b(e3);
        }
        try {
            yrVar.g(zrVar.getDescription());
        } catch (Exception e4) {
            b(e4);
        }
        try {
            yrVar.j(zrVar.h());
        } catch (Exception e5) {
            b(e5);
        }
        return yrVar;
    }
}
