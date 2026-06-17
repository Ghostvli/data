package defpackage;

import defpackage.dh1;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class e90 implements dh1 {
    public Collection a;
    public e90 b;
    public ih c;
    public ih d;
    public ih e;
    public ih f;
    public volatile AtomicInteger g;
    public int h;
    public dh1.a i;
    public boolean j;
    public Object k;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public e90(int i, boolean z, dh1.a aVar) {
        this.g = new AtomicInteger(0);
        this.h = 0;
        this.k = new Object();
        if (i != 0) {
            aVar = i == 1 ? new dh1.e(z) : i == 2 ? new dh1.f(z) : null;
        } else if (aVar == null) {
            aVar = new dh1.d(z);
        }
        if (i == 4) {
            this.a = new LinkedList();
        } else {
            this.j = z;
            aVar.b(z);
            this.a = new TreeSet(aVar);
            this.i = aVar;
        }
        this.h = i;
        this.g.set(0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.dh1
    public dh1 a(long j, long j2) {
        Collection collectionK = k(j, j2);
        if (collectionK == null || collectionK.isEmpty()) {
            return null;
        }
        return new e90(new LinkedList(collectionK));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.dh1
    public boolean b(ih ihVar) {
        Collection collection = this.a;
        return collection != null && collection.contains(ihVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.dh1
    public boolean c(ih ihVar) {
        synchronized (this.k) {
            try {
                Collection collection = this.a;
                if (collection != null) {
                    try {
                        if (collection.add(ihVar)) {
                            this.g.incrementAndGet();
                            return true;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.dh1
    public void clear() {
        synchronized (this.k) {
            try {
                Collection collection = this.a;
                if (collection != null) {
                    collection.clear();
                    this.g.set(0);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.b != null) {
            this.b = null;
            this.c = h("start");
            this.d = h("end");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.dh1
    public dh1 d(long j, long j2) {
        Collection collection = this.a;
        if (collection == null || collection.size() == 0) {
            return null;
        }
        if (this.b == null) {
            if (this.h == 4) {
                e90 e90Var = new e90(4);
                this.b = e90Var;
                e90Var.k = this.k;
                synchronized (this.k) {
                    this.b.j(this.a);
                }
            } else {
                e90 e90Var2 = new e90(this.j);
                this.b = e90Var2;
                e90Var2.k = this.k;
            }
        }
        if (this.h == 4) {
            return this.b;
        }
        if (this.c == null) {
            this.c = h("start");
        }
        if (this.d == null) {
            this.d = h("end");
        }
        if (this.b != null && j - this.c.b() >= 0 && j2 <= this.d.b()) {
            return this.b;
        }
        this.c.B(j);
        this.d.B(j2);
        synchronized (this.k) {
            this.b.j(((SortedSet) this.a).subSet(this.c, this.d));
        }
        return this.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.dh1
    public void e(dh1.b bVar) {
        bVar.c();
        Iterator it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ih ihVar = (ih) it.next();
            if (ihVar != null) {
                int iA = bVar.a(ihVar);
                if (iA == 1) {
                    break;
                }
                if (iA == 2) {
                    it.remove();
                    this.g.decrementAndGet();
                } else if (iA == 3) {
                    it.remove();
                    this.g.decrementAndGet();
                    break;
                }
            }
        }
        bVar.b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.dh1
    public boolean f(ih ihVar) {
        if (ihVar == null) {
            return false;
        }
        if (ihVar.s()) {
            ihVar.E(false);
        }
        synchronized (this.k) {
            try {
                if (!this.a.remove(ihVar)) {
                    return false;
                }
                this.g.decrementAndGet();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.dh1
    public ih first() {
        Collection collection = this.a;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        int i = this.h;
        Collection collection2 = this.a;
        return i == 4 ? (ih) ((LinkedList) collection2).peek() : (ih) ((SortedSet) collection2).first();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.dh1
    public void g(dh1.b bVar) {
        synchronized (this.k) {
            e(bVar);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ih h(String str) {
        return new p80(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object i() {
        return this.k;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.dh1
    public boolean isEmpty() {
        Collection collection = this.a;
        return collection == null || collection.isEmpty();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void j(Collection collection) {
        if (!this.j || this.h == 4) {
            this.a = collection;
        } else {
            synchronized (this.k) {
                this.a.clear();
                this.a.addAll(collection);
                collection = this.a;
            }
        }
        if (collection instanceof List) {
            this.h = 4;
        }
        this.g.set(collection == null ? 0 : collection.size());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Collection k(long j, long j2) {
        Collection collection;
        if (this.h == 4 || (collection = this.a) == null || collection.size() == 0) {
            return null;
        }
        if (this.b == null) {
            e90 e90Var = new e90(this.j);
            this.b = e90Var;
            e90Var.k = this.k;
        }
        if (this.f == null) {
            this.f = h("start");
        }
        if (this.e == null) {
            this.e = h("end");
        }
        this.f.B(j);
        this.e.B(j2);
        return ((SortedSet) this.a).subSet(this.f, this.e);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.dh1
    public ih last() {
        Collection collection = this.a;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        int i = this.h;
        Collection collection2 = this.a;
        return i == 4 ? (ih) ((LinkedList) collection2).peekLast() : (ih) ((SortedSet) collection2).last();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.dh1
    public int size() {
        return this.g.get();
    }

    public e90(int i) {
        this(i, false);
    }

    public e90(int i, boolean z) {
        this(i, z, null);
    }

    public e90() {
        this(0, false);
    }

    public e90(Collection collection) {
        this.g = new AtomicInteger(0);
        this.h = 0;
        this.k = new Object();
        j(collection);
    }

    public e90(boolean z) {
        this(0, z);
    }
}
