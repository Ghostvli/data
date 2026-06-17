package defpackage;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class gs extends f04 {
    public final yl e;
    public final /* synthetic */ AtomicReferenceArray f;

    public gs(long j, gs gsVar, yl ylVar, int i) {
        super(j, gsVar, i);
        this.e = ylVar;
        this.f = new AtomicReferenceArray(zl.b * 2);
    }

    public final Object A(int i) {
        return z().get(i * 2);
    }

    public final Object B(int i) {
        return z().get((i * 2) + 1);
    }

    public final void C(int i, boolean z) {
        if (z) {
            y().R0((this.c * ((long) zl.b)) + ((long) i));
        }
        t();
    }

    public final Object D(int i) {
        Object objA = A(i);
        w(i);
        return objA;
    }

    public final void E(int i, Object obj) {
        z().set(i * 2, obj);
    }

    public final void F(int i, Object obj) {
        z().set((i * 2) + 1, obj);
    }

    public final void G(int i, Object obj) {
        E(i, obj);
    }

    @Override // defpackage.f04
    public int r() {
        return zl.b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004d, code lost:
    
        w(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0050, code lost:
    
        if (r0 == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0052, code lost:
    
        r3 = y().g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0058, code lost:
    
        if (r3 == null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x005a, code lost:
    
        defpackage.p63.a(r3, r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x005d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:?, code lost:
    
        return;
     */
    @Override // defpackage.f04
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void s(int r4, java.lang.Throwable r5, defpackage.g40 r6) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            r3 = this;
            int r5 = defpackage.zl.b
            if (r4 < r5) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            if (r0 == 0) goto La
            int r4 = r4 - r5
        La:
            java.lang.Object r5 = r3.A(r4)
        Le:
            java.lang.Object r1 = r3.B(r4)
            boolean r2 = r1 instanceof defpackage.f85
            if (r2 != 0) goto L5e
            boolean r2 = r1 instanceof defpackage.g85
            if (r2 == 0) goto L1b
            goto L5e
        L1b:
            qj4 r2 = defpackage.zl.j()
            if (r1 == r2) goto L4d
            qj4 r2 = defpackage.zl.i()
            if (r1 != r2) goto L28
            goto L4d
        L28:
            qj4 r2 = defpackage.zl.p()
            if (r1 == r2) goto Le
            qj4 r2 = defpackage.zl.q()
            if (r1 != r2) goto L35
            goto Le
        L35:
            qj4 r3 = defpackage.zl.f()
            if (r1 == r3) goto L84
            qj4 r3 = defpackage.zl.d
            if (r1 != r3) goto L40
            goto L84
        L40:
            qj4 r3 = defpackage.zl.z()
            if (r1 != r3) goto L47
            goto L84
        L47:
            java.lang.String r3 = "unexpected state: "
            defpackage.rn1.a(r3, r1)
            return
        L4d:
            r3.w(r4)
            if (r0 == 0) goto L84
            yl r3 = r3.y()
            kotlin.jvm.functions.Function1 r3 = r3.g
            if (r3 == 0) goto L84
            defpackage.p63.a(r3, r5, r6)
            return
        L5e:
            if (r0 == 0) goto L65
            qj4 r2 = defpackage.zl.j()
            goto L69
        L65:
            qj4 r2 = defpackage.zl.i()
        L69:
            boolean r1 = r3.v(r4, r1, r2)
            if (r1 == 0) goto Le
            r3.w(r4)
            r1 = r0 ^ 1
            r3.C(r4, r1)
            if (r0 == 0) goto L84
            yl r3 = r3.y()
            kotlin.jvm.functions.Function1 r3 = r3.g
            if (r3 == 0) goto L84
            defpackage.p63.a(r3, r5, r6)
        L84:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gs.s(int, java.lang.Throwable, g40):void");
    }

    public final boolean v(int i, Object obj, Object obj2) {
        return fs.a(z(), (i * 2) + 1, obj, obj2);
    }

    public final void w(int i) {
        E(i, null);
    }

    public final Object x(int i, Object obj) {
        return z().getAndSet((i * 2) + 1, obj);
    }

    public final yl y() {
        yl ylVar = this.e;
        ylVar.getClass();
        return ylVar;
    }

    public final /* synthetic */ AtomicReferenceArray z() {
        return this.f;
    }
}
