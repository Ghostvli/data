package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class vf3 extends uf3 {
    public final Object c;

    public vf3(int i) {
        super(i);
        this.c = new Object();
    }

    @Override // defpackage.uf3, defpackage.tf3
    public Object a() {
        Object objA;
        synchronized (this.c) {
            objA = super.a();
        }
        return objA;
    }

    @Override // defpackage.uf3, defpackage.tf3
    public boolean b(Object obj) {
        boolean zB;
        obj.getClass();
        synchronized (this.c) {
            zB = super.b(obj);
        }
        return zB;
    }
}
