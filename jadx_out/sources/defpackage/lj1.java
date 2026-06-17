package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class lj1 implements Iterator, op1 {
    public int f;
    public int g;
    public boolean h;

    public lj1(int i) {
        this.f = i;
    }

    public abstract Object b(int i);

    public abstract void c(int i);

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.g < this.f;
    }

    @Override // java.util.Iterator
    public Object next() {
        if (!hasNext()) {
            bo.a();
            return null;
        }
        Object objB = b(this.g);
        this.g++;
        this.h = true;
        return objB;
    }

    @Override // java.util.Iterator
    public void remove() {
        if (!this.h) {
            fw3.b("Call next() before removing an element.");
        }
        int i = this.g - 1;
        this.g = i;
        c(i);
        this.f--;
        this.h = false;
    }
}
