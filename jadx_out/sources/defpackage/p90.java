package defpackage;

import defpackage.t90;
import defpackage.u90;
import defpackage.vt2;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class p90 implements u90, t90.a {
    public final List f;
    public final ab0 g;
    public final u90.a h;
    public int i;
    public wq1 j;
    public List k;
    public int l;
    public volatile vt2.a m;
    public File n;

    public p90(List list, ab0 ab0Var, u90.a aVar) {
        this.i = -1;
        this.f = list;
        this.g = ab0Var;
        this.h = aVar;
    }

    public final boolean a() {
        return this.l < this.k.size();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
    
        if (a() == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        r0 = r7.k;
        r3 = r7.l;
        r7.l = r3 + 1;
        r7.m = ((defpackage.vt2) r0.get(r3)).b(r7.n, r7.g.t(), r7.g.f(), r7.g.k());
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0047, code lost:
    
        if (r7.m == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0057, code lost:
    
        if (r7.g.u(r7.m.c.a()) == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0059, code lost:
    
        r7.m.c.c(r7.g.l(), r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0066, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006b, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:
    
        r7.m = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0015, code lost:
    
        if (r2 != false) goto L39;
     */
    @Override // defpackage.u90
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean b() {
        /*
            r7 = this;
            java.lang.String r0 = "DataCacheGenerator.startNext"
            defpackage.qa1.a(r0)
        L5:
            java.util.List r0 = r7.k     // Catch: java.lang.Throwable -> Lae
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L6c
            boolean r0 = r7.a()     // Catch: java.lang.Throwable -> Lae
            if (r0 != 0) goto L12
            goto L6c
        L12:
            r0 = 0
            r7.m = r0     // Catch: java.lang.Throwable -> Lae
        L15:
            if (r2 != 0) goto L68
            boolean r0 = r7.a()     // Catch: java.lang.Throwable -> Lae
            if (r0 == 0) goto L68
            java.util.List r0 = r7.k     // Catch: java.lang.Throwable -> Lae
            int r3 = r7.l     // Catch: java.lang.Throwable -> Lae
            int r4 = r3 + 1
            r7.l = r4     // Catch: java.lang.Throwable -> Lae
            java.lang.Object r0 = r0.get(r3)     // Catch: java.lang.Throwable -> Lae
            vt2 r0 = (defpackage.vt2) r0     // Catch: java.lang.Throwable -> Lae
            java.io.File r3 = r7.n     // Catch: java.lang.Throwable -> Lae
            ab0 r4 = r7.g     // Catch: java.lang.Throwable -> Lae
            int r4 = r4.t()     // Catch: java.lang.Throwable -> Lae
            ab0 r5 = r7.g     // Catch: java.lang.Throwable -> Lae
            int r5 = r5.f()     // Catch: java.lang.Throwable -> Lae
            ab0 r6 = r7.g     // Catch: java.lang.Throwable -> Lae
            u63 r6 = r6.k()     // Catch: java.lang.Throwable -> Lae
            vt2$a r0 = r0.b(r3, r4, r5, r6)     // Catch: java.lang.Throwable -> Lae
            r7.m = r0     // Catch: java.lang.Throwable -> Lae
            vt2$a r0 = r7.m     // Catch: java.lang.Throwable -> Lae
            if (r0 == 0) goto L15
            ab0 r0 = r7.g     // Catch: java.lang.Throwable -> Lae
            vt2$a r3 = r7.m     // Catch: java.lang.Throwable -> Lae
            t90 r3 = r3.c     // Catch: java.lang.Throwable -> Lae
            java.lang.Class r3 = r3.a()     // Catch: java.lang.Throwable -> Lae
            boolean r0 = r0.u(r3)     // Catch: java.lang.Throwable -> Lae
            if (r0 == 0) goto L15
            vt2$a r0 = r7.m     // Catch: java.lang.Throwable -> Lae
            t90 r0 = r0.c     // Catch: java.lang.Throwable -> Lae
            ab0 r2 = r7.g     // Catch: java.lang.Throwable -> Lae
            ug3 r2 = r2.l()     // Catch: java.lang.Throwable -> Lae
            r0.c(r2, r7)     // Catch: java.lang.Throwable -> Lae
            r2 = r1
            goto L15
        L68:
            defpackage.qa1.e()
            return r2
        L6c:
            int r0 = r7.i     // Catch: java.lang.Throwable -> Lae
            int r0 = r0 + r1
            r7.i = r0     // Catch: java.lang.Throwable -> Lae
            java.util.List r1 = r7.f     // Catch: java.lang.Throwable -> Lae
            int r1 = r1.size()     // Catch: java.lang.Throwable -> Lae
            if (r0 < r1) goto L7d
            defpackage.qa1.e()
            return r2
        L7d:
            java.util.List r0 = r7.f     // Catch: java.lang.Throwable -> Lae
            int r1 = r7.i     // Catch: java.lang.Throwable -> Lae
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> Lae
            wq1 r0 = (defpackage.wq1) r0     // Catch: java.lang.Throwable -> Lae
            q90 r1 = new q90     // Catch: java.lang.Throwable -> Lae
            ab0 r3 = r7.g     // Catch: java.lang.Throwable -> Lae
            wq1 r3 = r3.p()     // Catch: java.lang.Throwable -> Lae
            r1.<init>(r0, r3)     // Catch: java.lang.Throwable -> Lae
            ab0 r3 = r7.g     // Catch: java.lang.Throwable -> Lae
            xl0 r3 = r3.d()     // Catch: java.lang.Throwable -> Lae
            java.io.File r1 = r3.a(r1)     // Catch: java.lang.Throwable -> Lae
            r7.n = r1     // Catch: java.lang.Throwable -> Lae
            if (r1 == 0) goto L5
            r7.j = r0     // Catch: java.lang.Throwable -> Lae
            ab0 r0 = r7.g     // Catch: java.lang.Throwable -> Lae
            java.util.List r0 = r0.j(r1)     // Catch: java.lang.Throwable -> Lae
            r7.k = r0     // Catch: java.lang.Throwable -> Lae
            r7.l = r2     // Catch: java.lang.Throwable -> Lae
            goto L5
        Lae:
            r7 = move-exception
            defpackage.qa1.e()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.p90.b():boolean");
    }

    @Override // defpackage.u90
    public void cancel() {
        vt2.a aVar = this.m;
        if (aVar != null) {
            aVar.c.cancel();
        }
    }

    @Override // t90.a
    public void d(Exception exc) {
        this.h.a(this.j, exc, this.m.c, ba0.DATA_DISK_CACHE);
    }

    @Override // t90.a
    public void f(Object obj) {
        this.h.f(this.j, obj, this.m.c, ba0.DATA_DISK_CACHE, this.j);
    }

    public p90(ab0 ab0Var, u90.a aVar) {
        this(ab0Var.c(), ab0Var, aVar);
    }
}
