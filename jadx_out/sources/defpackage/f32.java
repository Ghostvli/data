package defpackage;

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

    public f32(int i) {
        this.a = i;
        if (!(i > 0)) {
            fw3.a("maxSize <= 0");
        }
        this.b = new g32(0, 0.75f);
        this.c = new qz1();
    }

    public Object a(Object obj) {
        obj.getClass();
        return null;
    }

    public void b(boolean z, Object obj, Object obj2, Object obj3) {
        obj.getClass();
        obj2.getClass();
    }

    public final void c() {
        i(-1);
    }

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

    public final int f(Object obj, Object obj2) {
        int iH = h(obj, obj2);
        if (!(iH >= 0)) {
            fw3.b("Negative size: " + obj + '=' + obj2);
        }
        return iH;
    }

    public final int g() {
        int i;
        synchronized (this.c) {
            i = this.d;
        }
        return i;
    }

    public int h(Object obj, Object obj2) {
        obj.getClass();
        obj2.getClass();
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0060, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void i(int r7) {
        /*
            r6 = this;
        L0:
            qz1 r0 = r6.c
            monitor-enter(r0)
            int r1 = r6.d     // Catch: java.lang.Throwable -> L15
            r2 = 1
            if (r1 < 0) goto L19
            g32 r1 = r6.b     // Catch: java.lang.Throwable -> L15
            boolean r1 = r1.c()     // Catch: java.lang.Throwable -> L15
            if (r1 == 0) goto L17
            int r1 = r6.d     // Catch: java.lang.Throwable -> L15
            if (r1 != 0) goto L19
            goto L17
        L15:
            r6 = move-exception
            goto L61
        L17:
            r1 = r2
            goto L1a
        L19:
            r1 = 0
        L1a:
            if (r1 != 0) goto L21
            java.lang.String r1 = "LruCache.sizeOf() is reporting inconsistent results!"
            defpackage.fw3.b(r1)     // Catch: java.lang.Throwable -> L15
        L21:
            int r1 = r6.d     // Catch: java.lang.Throwable -> L15
            if (r1 <= r7) goto L5f
            g32 r1 = r6.b     // Catch: java.lang.Throwable -> L15
            boolean r1 = r1.c()     // Catch: java.lang.Throwable -> L15
            if (r1 == 0) goto L2e
            goto L5f
        L2e:
            g32 r1 = r6.b     // Catch: java.lang.Throwable -> L15
            java.util.Set r1 = r1.b()     // Catch: java.lang.Throwable -> L15
            java.lang.Object r1 = defpackage.ww.J(r1)     // Catch: java.lang.Throwable -> L15
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.lang.Throwable -> L15
            if (r1 != 0) goto L3e
            monitor-exit(r0)
            return
        L3e:
            java.lang.Object r3 = r1.getKey()     // Catch: java.lang.Throwable -> L15
            java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Throwable -> L15
            g32 r4 = r6.b     // Catch: java.lang.Throwable -> L15
            r4.e(r3)     // Catch: java.lang.Throwable -> L15
            int r4 = r6.d     // Catch: java.lang.Throwable -> L15
            int r5 = r6.f(r3, r1)     // Catch: java.lang.Throwable -> L15
            int r4 = r4 - r5
            r6.d = r4     // Catch: java.lang.Throwable -> L15
            int r4 = r6.g     // Catch: java.lang.Throwable -> L15
            int r4 = r4 + r2
            r6.g = r4     // Catch: java.lang.Throwable -> L15
            monitor-exit(r0)
            r0 = 0
            r6.b(r2, r3, r1, r0)
            goto L0
        L5f:
            monitor-exit(r0)
            return
        L61:
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.f32.i(int):void");
    }

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
