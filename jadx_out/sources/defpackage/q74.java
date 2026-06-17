package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class q74 extends dj1 {
    public final transient Object h;

    public q74(Object obj) {
        this.h = gg3.q(obj);
    }

    @Override // defpackage.dj1, defpackage.vi1
    public xi1 b() {
        return xi1.w(this.h);
    }

    @Override // defpackage.vi1
    public int c(Object[] objArr, int i) {
        objArr[i] = this.h;
        return i + 1;
    }

    @Override // defpackage.vi1, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.h.equals(obj);
    }

    @Override // defpackage.vi1
    public boolean g() {
        return false;
    }

    @Override // defpackage.dj1, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.h.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: j */
    public pw4 iterator() {
        return lm1.t(this.h);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return "[" + this.h.toString() + ']';
    }
}
