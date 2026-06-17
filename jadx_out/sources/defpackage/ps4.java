package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ps4 implements Iterator {
    public final Iterator f;

    public ps4(Iterator it) {
        this.f = (Iterator) gg3.q(it);
    }

    public abstract Object b(Object obj);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return b(this.f.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f.remove();
    }
}
