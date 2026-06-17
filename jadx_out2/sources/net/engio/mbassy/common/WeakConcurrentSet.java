package net.engio.mbassy.common;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import net.engio.mbassy.common.AbstractConcurrentSet;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class WeakConcurrentSet<T> extends AbstractConcurrentSet<T> {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public WeakConcurrentSet() {
        super(new WeakHashMap());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // net.engio.mbassy.common.AbstractConcurrentSet
    public AbstractConcurrentSet.Entry<T> createEntry(T t, AbstractConcurrentSet.Entry<T> entry) {
        return entry != null ? new WeakEntry(t, entry) : new WeakEntry(t);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return new Iterator<T>() { // from class: net.engio.mbassy.common.WeakConcurrentSet.1
            private ISetEntry<T> current;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            {
                this.current = WeakConcurrentSet.this.head;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            private void removeOrphans() {
                ISetEntry<T> iSetEntry;
                ReentrantReadWriteLock.WriteLock writeLock = WeakConcurrentSet.this.lock.writeLock();
                try {
                    writeLock.lock();
                    do {
                        ISetEntry<T> iSetEntry2 = this.current;
                        this.current = iSetEntry2.next();
                        WeakConcurrentSet weakConcurrentSet = WeakConcurrentSet.this;
                        AbstractConcurrentSet.Entry<T> entry = weakConcurrentSet.head;
                        if (iSetEntry2 == entry) {
                            weakConcurrentSet.head = entry.next();
                        }
                        iSetEntry2.remove();
                        iSetEntry = this.current;
                        if (iSetEntry == null) {
                            break;
                        }
                    } while (iSetEntry.getValue() == null);
                    writeLock.unlock();
                } catch (Throwable th) {
                    writeLock.unlock();
                    throw th;
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.Iterator
            public boolean hasNext() {
                ISetEntry<T> iSetEntry = this.current;
                if (iSetEntry == null) {
                    return false;
                }
                if (iSetEntry.getValue() != null) {
                    return true;
                }
                removeOrphans();
                return this.current != null;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.Iterator
            public T next() {
                ISetEntry<T> iSetEntry = this.current;
                if (iSetEntry == null) {
                    return null;
                }
                T value = iSetEntry.getValue();
                if (value == null) {
                    removeOrphans();
                    return (T) next();
                }
                this.current = this.current.next();
                return value;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.Iterator
            public void remove() {
                ISetEntry<T> iSetEntry = this.current;
                if (iSetEntry == null) {
                    return;
                }
                ISetEntry<T> next = iSetEntry.next();
                WeakConcurrentSet.this.remove(this.current.getValue());
                this.current = next;
            }
        };
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class WeakEntry<T> extends AbstractConcurrentSet.Entry<T> {
        private WeakReference<T> value;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private WeakEntry(T t, AbstractConcurrentSet.Entry<T> entry) {
            super(entry);
            this.value = new WeakReference<>(t);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // net.engio.mbassy.common.ISetEntry
        public T getValue() {
            return this.value.get();
        }

        private WeakEntry(T t) {
            this.value = new WeakReference<>(t);
        }
    }
}
