package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class qo extends la {
    public int l;

    @Override // defpackage.x64, java.util.Map
    public void clear() {
        this.l = 0;
        super.clear();
    }

    @Override // defpackage.x64
    public void g(x64 x64Var) {
        this.l = 0;
        super.g(x64Var);
    }

    @Override // defpackage.x64
    public Object h(int i) {
        this.l = 0;
        return super.h(i);
    }

    @Override // defpackage.x64, java.util.Map
    public int hashCode() {
        if (this.l == 0) {
            this.l = super.hashCode();
        }
        return this.l;
    }

    @Override // defpackage.x64
    public Object i(int i, Object obj) {
        this.l = 0;
        return super.i(i, obj);
    }

    @Override // defpackage.x64, java.util.Map
    public Object put(Object obj, Object obj2) {
        this.l = 0;
        return super.put(obj, obj2);
    }
}
