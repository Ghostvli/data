package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class gs extends f04 {
    public final yl e;
    public final /* synthetic */ AtomicReferenceArray f;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public gs(long j, gs gsVar, yl ylVar, int i) {
        super(j, gsVar, i);
        this.e = ylVar;
        this.f = new AtomicReferenceArray(zl.b * 2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object A(int i) {
        return z().get(i * 2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object B(int i) {
        return z().get((i * 2) + 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void C(int i, boolean z) {
        if (z) {
            y().R0((this.c * ((long) zl.b)) + ((long) i));
        }
        t();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object D(int i) {
        Object objA = A(i);
        w(i);
        return objA;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void E(int i, Object obj) {
        z().set(i * 2, obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void F(int i, Object obj) {
        z().set((i * 2) + 1, obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void G(int i, Object obj) {
        E(i, obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.f04
    public int r() {
        return zl.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
    */
    public void s(int i, Throwable th, g40 g40Var) throws IllegalAccessException, InvocationTargetException {
        Function1 function1;
        int i2 = zl.b;
        boolean z = i >= i2;
        if (z) {
            i -= i2;
        }
        Object objA = A(i);
        while (true) {
            Object objB = B(i);
            if ((objB instanceof f85) || (objB instanceof g85)) {
                if (v(i, objB, z ? zl.j : zl.k)) {
                    w(i);
                    C(i, !z);
                    if (!z || (function1 = y().g) == null) {
                        return;
                    }
                    p63.a(function1, objA, g40Var);
                    return;
                }
            } else {
                if (objB == zl.j || objB == zl.k) {
                    break;
                }
                if (objB != zl.g && objB != zl.f) {
                    if (objB == zl.i || objB == zl.d || objB == zl.z()) {
                        return;
                    }
                    rn1.a("unexpected state: ", objB);
                    return;
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean v(int i, Object obj, Object obj2) {
        return fs.a(z(), (i * 2) + 1, obj, obj2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void w(int i) {
        E(i, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object x(int i, Object obj) {
        return z().getAndSet((i * 2) + 1, obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final yl y() {
        yl ylVar = this.e;
        ylVar.getClass();
        return ylVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ AtomicReferenceArray z() {
        return this.f;
    }
}
