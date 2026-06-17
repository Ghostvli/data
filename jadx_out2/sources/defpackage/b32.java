package defpackage;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class b32 implements ma {
    public final nb1 a = new nb1();
    public final b b = new b();
    public final Map c = new HashMap();
    public final Map d = new HashMap();
    public final int e;
    public int f;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements nf3 {
        public final b a;
        public int b;
        public Class c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(b bVar) {
            this.a = bVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.nf3
        public void a() {
            this.a.c(this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void b(int i, Class cls) {
            this.b = i;
            this.c = cls;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.b == aVar.b && this.c == aVar.c) {
                    return true;
                }
            }
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int hashCode() {
            int i = this.b * 31;
            Class cls = this.c;
            return i + (cls != null ? cls.hashCode() : 0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String toString() {
            return "Key{size=" + this.b + "array=" + this.c + '}';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends yh {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a()Lnf3; */
        @Override // defpackage.yh
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a(this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a e(int i, Class cls) {
            a aVar = (a) b();
            aVar.b(i, cls);
            return aVar;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public b32(int i) {
        this.e = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ma
    public synchronized void a(int i) {
        try {
            if (i >= 40) {
                b();
            } else if (i >= 20 || i == 15) {
                g(this.e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ma
    public synchronized void b() {
        g(0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ma
    public synchronized Object c(int i, Class cls) {
        return k(this.b.e(i, cls), cls);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ma
    public synchronized Object d(int i, Class cls) {
        Integer num;
        boolean zO;
        b bVar;
        try {
            num = (Integer) l(cls).ceilingKey(Integer.valueOf(i));
            zO = o(i, num);
            bVar = this.b;
        } catch (Throwable th) {
            throw th;
        }
        return k(zO ? bVar.e(num.intValue(), cls) : bVar.e(i, cls), cls);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void e(int i, Class cls) {
        NavigableMap navigableMapL = l(cls);
        Integer num = (Integer) navigableMapL.get(Integer.valueOf(i));
        if (num != null) {
            if (num.intValue() == 1) {
                navigableMapL.remove(Integer.valueOf(i));
                return;
            } else {
                navigableMapL.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f() {
        g(this.e);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g(int i) {
        while (this.f > i) {
            Object objF = this.a.f();
            fg3.e(objF);
            fa faVarH = h(objF);
            this.f -= faVarH.c(objF) * faVarH.b();
            e(faVarH.c(objF), objF.getClass());
            if (Log.isLoggable(faVarH.a(), 2)) {
                Log.v(faVarH.a(), "evicted: " + faVarH.c(objF));
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final fa h(Object obj) {
        return i(obj.getClass());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final fa i(Class cls) {
        fa tmVar;
        fa faVar = (fa) this.d.get(cls);
        if (faVar != null) {
            return faVar;
        }
        if (cls.equals(int[].class)) {
            tmVar = new tk1();
        } else {
            if (!cls.equals(byte[].class)) {
                jl.a("No array pool found for: ".concat(cls.getSimpleName()));
                return null;
            }
            tmVar = new tm();
        }
        this.d.put(cls, tmVar);
        return tmVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object j(a aVar) {
        return this.a.a(aVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object k(a aVar, Class cls) {
        fa faVarI = i(cls);
        Object objJ = j(aVar);
        if (objJ != null) {
            this.f -= faVarI.c(objJ) * faVarI.b();
            e(faVarI.c(objJ), cls);
        }
        if (objJ != null) {
            return objJ;
        }
        if (Log.isLoggable(faVarI.a(), 2)) {
            Log.v(faVarI.a(), "Allocated " + aVar.b + " bytes");
        }
        return faVarI.newArray(aVar.b);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final NavigableMap l(Class cls) {
        NavigableMap navigableMap = (NavigableMap) this.c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.c.put(cls, treeMap);
        return treeMap;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean m() {
        int i = this.f;
        return i == 0 || this.e / i >= 2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean n(int i) {
        return i <= this.e / 2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean o(int i, Integer num) {
        if (num != null) {
            return m() || num.intValue() <= i * 8;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ma
    public synchronized void put(Object obj) {
        Class<?> cls = obj.getClass();
        fa faVarI = i(cls);
        int iC = faVarI.c(obj);
        int iB = faVarI.b() * iC;
        if (n(iB)) {
            a aVarE = this.b.e(iC, cls);
            this.a.d(aVarE, obj);
            NavigableMap navigableMapL = l(cls);
            Integer num = (Integer) navigableMapL.get(Integer.valueOf(aVarE.b));
            Integer numValueOf = Integer.valueOf(aVarE.b);
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            navigableMapL.put(numValueOf, Integer.valueOf(iIntValue));
            this.f += iB;
            f();
        }
    }
}
