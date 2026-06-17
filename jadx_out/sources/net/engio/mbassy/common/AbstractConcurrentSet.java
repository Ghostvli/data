package net.engio.mbassy.common;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractConcurrentSet<T> implements Set<T> {
    private static final AtomicLong id = new AtomicLong();
    private final Map<T, ISetEntry<T>> entries;
    protected Entry<T> head;
    private final long ID = id.getAndIncrement();
    protected final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public AbstractConcurrentSet(Map<T, ISetEntry<T>> map) {
        this.entries = map;
    }

    private boolean insert(T t) {
        if (this.entries.containsKey(t)) {
            return false;
        }
        Entry<T> entryCreateEntry = createEntry(t, this.head);
        this.head = entryCreateEntry;
        this.entries.put(t, entryCreateEntry);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(T t) {
        if (t == null) {
            return false;
        }
        ReentrantReadWriteLock.WriteLock writeLock = this.lock.writeLock();
        try {
            writeLock.lock();
            return insert(t);
        } finally {
            writeLock.unlock();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        ReentrantReadWriteLock.WriteLock writeLock = this.lock.writeLock();
        try {
            writeLock.lock();
            boolean zInsert = false;
            for (T t : collection) {
                if (t != null) {
                    zInsert |= insert(t);
                }
            }
            return zInsert;
        } finally {
            writeLock.unlock();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        ReentrantReadWriteLock.WriteLock writeLock = this.lock.writeLock();
        try {
            writeLock.lock();
            this.head = null;
            this.entries.clear();
        } finally {
            writeLock.unlock();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        ReentrantReadWriteLock.ReadLock lock = this.lock.readLock();
        try {
            lock.lock();
            ISetEntry<T> iSetEntry = this.entries.get(obj);
            return (iSetEntry == null || iSetEntry.getValue() == null) ? false : true;
        } finally {
            lock.unlock();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public abstract Entry<T> createEntry(T t, Entry<T> entry);

    @Override // java.util.Set, java.util.Collection
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.ID == ((AbstractConcurrentSet) obj).ID;
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        long j = this.ID;
        return 31 + ((int) (j ^ (j >>> 32)));
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        if (!contains(obj)) {
            return false;
        }
        ReentrantReadWriteLock.WriteLock writeLock = this.lock.writeLock();
        try {
            writeLock.lock();
            ISetEntry<T> iSetEntry = this.entries.get(obj);
            if (iSetEntry == null) {
                writeLock.unlock();
                return false;
            }
            Entry<T> entry = this.head;
            if (iSetEntry != entry) {
                iSetEntry.remove();
            } else {
                this.head = entry.next();
            }
            this.entries.remove(obj);
            writeLock.unlock();
            return true;
        } catch (Throwable th) {
            writeLock.unlock();
            throw th;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override // java.util.Set, java.util.Collection
    public int size() {
        return this.entries.size();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return this.entries.entrySet().toArray();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class Entry<T> implements ISetEntry<T> {
        private Entry<T> next;
        private Entry<T> predecessor;

        public Entry(Entry<T> entry) {
            this.next = entry;
            entry.predecessor = this;
        }

        @Override // net.engio.mbassy.common.ISetEntry
        public void clear() {
            this.next = null;
        }

        @Override // net.engio.mbassy.common.ISetEntry
        public void remove() {
            Entry<T> entry = this.predecessor;
            Entry<T> entry2 = this.next;
            if (entry == null) {
                if (entry2 != null) {
                    entry2.predecessor = null;
                }
            } else {
                entry.next = entry2;
                Entry<T> entry3 = this.next;
                if (entry3 != null) {
                    entry3.predecessor = entry;
                }
            }
        }

        @Override // net.engio.mbassy.common.ISetEntry
        public Entry<T> next() {
            return this.next;
        }

        public Entry() {
        }
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.entries.entrySet().toArray(tArr);
    }
}
