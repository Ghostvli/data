package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class f32 {
    public int a;
    public final g32 b;
    public final qz1 c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public f32(int i) {
        this.a = i;
        if (!(i > 0)) {
            fw3.a("maxSize <= 0");
        }
        this.b = new g32(0, 0.75f);
        this.c = new qz1();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object a(Object obj) {
        obj.getClass();
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b(boolean z, Object obj, Object obj2, Object obj3) {
        obj.getClass();
        obj2.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void c() {
        i(-1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object d(Object obj) {
        Object objD;
        obj.getClass();
        synchronized (this.c) {
            Object objA = this.b.a(obj);
            if (objA != null) {
                this.h++;
                return objA;
            }
            this.i++;
            Object objA2 = a(obj);
            if (objA2 == null) {
                return null;
            }
            synchronized (this.c) {
                try {
                    this.f++;
                    objD = this.b.d(obj, objA2);
                    if (objD != null) {
                        this.b.d(obj, objD);
                    } else {
                        this.d += f(obj, objA2);
                        fw4 fw4Var = fw4.a;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (objD != null) {
                b(false, obj, objA2, objD);
                return objD;
            }
            i(this.a);
            return objA2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object e(Object obj, Object obj2) {
        Object objD;
        obj.getClass();
        obj2.getClass();
        synchronized (this.c) {
            try {
                this.e++;
                this.d += f(obj, obj2);
                objD = this.b.d(obj, obj2);
                if (objD != null) {
                    this.d -= f(obj, objD);
                }
                fw4 fw4Var = fw4.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (objD != null) {
            b(false, obj, objD, obj2);
        }
        i(this.a);
        return objD;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int f(Object obj, Object obj2) {
        int iH = h(obj, obj2);
        if (!(iH >= 0)) {
            fw3.b("Negative size: " + obj + '=' + obj2);
        }
        return iH;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int g() {
        int i;
        synchronized (this.c) {
            i = this.d;
        }
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int h(Object obj, Object obj2) {
        obj.getClass();
        obj2.getClass();
        return 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0060, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void i(int i) {
        Object key;
        Object value;
        while (true) {
            synchronized (this.c) {
                try {
                    if (!(this.d >= 0 && (!this.b.c() || this.d == 0))) {
                        fw3.b("LruCache.sizeOf() is reporting inconsistent results!");
                    }
                    if (this.d <= i || this.b.c()) {
                        break;
                    }
                    Map.Entry entry = (Map.Entry) ww.J(this.b.b());
                    if (entry == null) {
                        return;
                    }
                    key = entry.getKey();
                    value = entry.getValue();
                    this.b.e(key);
                    this.d -= f(key, value);
                    this.g++;
                } catch (Throwable th) {
                    throw th;
                }
            }
            b(true, key, value, null);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        String str;
        synchronized (this.c) {
            try {
                int i = this.h;
                int i2 = this.i + i;
                str = "LruCache[maxSize=" + this.a + ",hits=" + this.h + ",misses=" + this.i + ",hitRate=" + (i2 != 0 ? (i * 100) / i2 : 0) + "%]";
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
