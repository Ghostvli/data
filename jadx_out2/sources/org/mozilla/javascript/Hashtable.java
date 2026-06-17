package org.mozilla.javascript;

import defpackage.bo;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import org.mozilla.javascript.Hashtable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Hashtable implements Serializable, Iterable<Entry> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = -7151554912419543747L;
    private final HashMap<Object, Entry> map = new HashMap<>();
    private Entry first = null;
    private Entry last = null;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Iter implements Iterator<Entry> {
        private Entry pos;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Iter(Entry entry) {
            Entry entryMakeDummy = Hashtable.makeDummy();
            entryMakeDummy.next = entry;
            this.pos = entryMakeDummy;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private void skipDeleted() {
            while (true) {
                Entry entry = this.pos.next;
                if (entry == null || !entry.deleted) {
                    return;
                } else {
                    this.pos = entry;
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Iterator
        public boolean hasNext() {
            skipDeleted();
            Entry entry = this.pos;
            return (entry == null || entry.next == null) ? false : true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: next()Ljava/lang/Object; */
        @Override // java.util.Iterator
        public Entry next() {
            Entry entry;
            skipDeleted();
            Entry entry2 = this.pos;
            if (entry2 == null || (entry = entry2.next) == null) {
                bo.a();
                return null;
            }
            this.pos = entry;
            return entry;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ Entry b(Hashtable hashtable, Entry entry, Object obj, Object obj2, Entry entry2) {
        if (entry2 != null) {
            hashtable.getClass();
            entry2.value = obj;
            return entry2;
        }
        if (hashtable.first == null) {
            hashtable.last = entry;
            hashtable.first = entry;
            return entry;
        }
        Entry entry3 = hashtable.last;
        entry3.next = entry;
        entry.prev = entry3;
        hashtable.last = entry;
        return entry;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public static Entry makeDummy() {
        Entry entry = new Entry();
        entry.clear();
        return entry;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void clear() {
        iterator().forEachRemaining(new Consumer() { // from class: vc1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((Hashtable.Entry) obj).clear();
            }
        });
        if (this.first != null) {
            Entry entryMakeDummy = makeDummy();
            this.last.next = entryMakeDummy;
            this.last = entryMakeDummy;
            this.first = entryMakeDummy;
        }
        this.map.clear();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Deprecated
    public Object delete(Object obj) {
        Entry entryRemove = this.map.remove(new Entry(obj, null));
        if (entryRemove == null) {
            return null;
        }
        if (entryRemove != this.first) {
            Entry entry = entryRemove.prev;
            entry.next = entryRemove.next;
            entryRemove.prev = null;
            Entry entry2 = entryRemove.next;
            if (entry2 != null) {
                entry2.prev = entry;
            } else {
                this.last = entry;
            }
        } else if (entryRemove == this.last) {
            entryRemove.clear();
            entryRemove.prev = null;
        } else {
            Entry entry3 = entryRemove.next;
            this.first = entry3;
            entry3.prev = null;
            Entry entry4 = entry3.next;
            if (entry4 != null) {
                entry4.prev = entry3;
            }
        }
        Object obj2 = entryRemove.value;
        entryRemove.clear();
        return obj2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean deleteEntry(Object obj) {
        Entry entryRemove = this.map.remove(new Entry(obj, null));
        if (entryRemove == null) {
            return false;
        }
        if (entryRemove != this.first) {
            Entry entry = entryRemove.prev;
            entry.next = entryRemove.next;
            entryRemove.prev = null;
            Entry entry2 = entryRemove.next;
            if (entry2 != null) {
                entry2.prev = entry;
            } else {
                this.last = entry;
            }
        } else if (entryRemove == this.last) {
            entryRemove.clear();
            entryRemove.prev = null;
        } else {
            Entry entry3 = entryRemove.next;
            this.first = entry3;
            entry3.prev = null;
            Entry entry4 = entry3.next;
            if (entry4 != null) {
                entry4.prev = entry3;
            }
        }
        entryRemove.clear();
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Deprecated
    public Object get(Object obj) {
        Entry entry = this.map.get(new Entry(obj, null));
        if (entry == null) {
            return null;
        }
        return entry.value;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Entry getEntry(Object obj) {
        return this.map.get(new Entry(obj, null));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean has(Object obj) {
        return this.map.containsKey(new Entry(obj, null));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.Iterable
    public Iterator<Entry> iterator() {
        return new Iter(this.first);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void put(Object obj, final Object obj2) {
        final Entry entry = new Entry(obj, obj2);
        this.map.compute(entry, new BiFunction() { // from class: wc1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj3, Object obj4) {
                return Hashtable.b(this.a, entry, obj2, obj3, (Hashtable.Entry) obj4);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int size() {
        return this.map.size();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Entry implements Serializable {
        private static final long serialVersionUID = 4086572107122965503L;
        boolean deleted;
        final int hashCode;
        Object key;
        Entry next;
        Entry prev;
        Object value;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Entry(Object obj, Object obj2) {
            if (obj instanceof Number) {
                if ((obj instanceof Double) || (obj instanceof BigInteger)) {
                    this.key = obj;
                } else {
                    this.key = Double.valueOf(((Number) obj).doubleValue());
                }
            } else if (obj instanceof ConsString) {
                this.key = obj.toString();
            } else {
                this.key = obj;
            }
            if (this.key == null || obj.equals(ScriptRuntime.negativeZeroObj)) {
                this.hashCode = 0;
            } else {
                this.hashCode = this.key.hashCode();
            }
            this.value = obj2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void clear() {
            Object obj = Undefined.instance;
            this.key = obj;
            this.value = obj;
            this.deleted = true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                return ScriptRuntime.sameZero(this.key, ((Entry) obj).key);
            } catch (ClassCastException unused) {
                return false;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int hashCode() {
            return this.hashCode;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Object key() {
            return this.key;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Object value() {
            return this.value;
        }

        public Entry() {
            this.hashCode = 0;
        }
    }
}
