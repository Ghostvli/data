package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g0 implements Iterator {
    public a f = a.NOT_READY;
    public Object g;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum a {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    public abstract Object b();

    public final Object c() {
        this.f = a.DONE;
        return null;
    }

    public final boolean d() {
        this.f = a.FAILED;
        this.g = b();
        if (this.f == a.DONE) {
            return false;
        }
        this.f = a.READY;
        return true;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        gg3.v(this.f != a.FAILED);
        int iOrdinal = this.f.ordinal();
        if (iOrdinal == 0) {
            return true;
        }
        if (iOrdinal != 2) {
            return d();
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            bo.a();
            return null;
        }
        this.f = a.NOT_READY;
        Object objA = p43.a(this.g);
        this.g = null;
        return objA;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
