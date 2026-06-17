package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class ja implements Iterator, op1 {
    public final Object[] f;
    public int g;

    public ja(Object[] objArr) {
        objArr.getClass();
        this.f = objArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.g < this.f.length;
    }

    @Override // java.util.Iterator
    public Object next() {
        try {
            Object[] objArr = this.f;
            int i = this.g;
            this.g = i + 1;
            return objArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.g--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
