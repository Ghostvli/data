package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class c40 implements Iterable {
    public final Object f = new Object();
    public final Map g = new HashMap();
    public Set h = Collections.EMPTY_SET;
    public List i = Collections.EMPTY_LIST;

    public void b(Object obj) {
        synchronized (this.f) {
            try {
                ArrayList arrayList = new ArrayList(this.i);
                arrayList.add(obj);
                this.i = Collections.unmodifiableList(arrayList);
                Integer num = (Integer) this.g.get(obj);
                if (num == null) {
                    HashSet hashSet = new HashSet(this.h);
                    hashSet.add(obj);
                    this.h = Collections.unmodifiableSet(hashSet);
                }
                this.g.put(obj, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void c(Object obj) {
        synchronized (this.f) {
            try {
                Integer num = (Integer) this.g.get(obj);
                if (num == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList(this.i);
                arrayList.remove(obj);
                this.i = Collections.unmodifiableList(arrayList);
                int iIntValue = num.intValue();
                Map map = this.g;
                if (iIntValue == 1) {
                    map.remove(obj);
                    HashSet hashSet = new HashSet(this.h);
                    hashSet.remove(obj);
                    this.h = Collections.unmodifiableSet(hashSet);
                } else {
                    map.put(obj, Integer.valueOf(num.intValue() - 1));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Set i() {
        Set set;
        synchronized (this.f) {
            set = this.h;
        }
        return set;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        Iterator it;
        synchronized (this.f) {
            it = this.i.iterator();
        }
        return it;
    }

    public int t(Object obj) {
        int iIntValue;
        synchronized (this.f) {
            try {
                iIntValue = this.g.containsKey(obj) ? ((Integer) this.g.get(obj)).intValue() : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iIntValue;
    }
}
