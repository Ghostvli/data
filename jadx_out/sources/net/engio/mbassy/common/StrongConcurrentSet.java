package net.engio.mbassy.common;

import java.util.HashMap;
import java.util.Iterator;
import net.engio.mbassy.common.AbstractConcurrentSet;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class StrongConcurrentSet<T> extends AbstractConcurrentSet<T> {
    public StrongConcurrentSet() {
        super(new HashMap());
    }

    @Override // net.engio.mbassy.common.AbstractConcurrentSet
    public AbstractConcurrentSet.Entry<T> createEntry(T t, AbstractConcurrentSet.Entry<T> entry) {
        return entry != null ? new StrongEntry(t, entry) : new StrongEntry(t);
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return new Iterator<T>() { // from class: net.engio.mbassy.common.StrongConcurrentSet.1
            private ISetEntry<T> current;

            {
                this.current = StrongConcurrentSet.this.head;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.current != null;
            }

            @Override // java.util.Iterator
            public T next() {
                ISetEntry<T> iSetEntry = this.current;
                if (iSetEntry == null) {
                    return null;
                }
                T value = iSetEntry.getValue();
                this.current = this.current.next();
                return value;
            }

            @Override // java.util.Iterator
            public void remove() {
                ISetEntry<T> iSetEntry = this.current;
                if (iSetEntry == null) {
                    return;
                }
                ISetEntry<T> next = iSetEntry.next();
                StrongConcurrentSet.this.remove(this.current.getValue());
                this.current = next;
            }
        };
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class StrongEntry<T> extends AbstractConcurrentSet.Entry<T> {
        private T value;

        private StrongEntry(T t, AbstractConcurrentSet.Entry<T> entry) {
            super(entry);
            this.value = t;
        }

        @Override // net.engio.mbassy.common.ISetEntry
        public T getValue() {
            return this.value;
        }

        private StrongEntry(T t) {
            this.value = t;
        }
    }
}
