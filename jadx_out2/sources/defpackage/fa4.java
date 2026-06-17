package defpackage;

import java.lang.ref.SoftReference;
import java.util.ArrayDeque;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class fa4 {
    public final ThreadLocal a = new ea4(new Supplier() { // from class: da4
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.function.Supplier
        public final Object get() {
            return fa4.a();
        }
    });
    public final Supplier b;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public fa4(Supplier supplier) {
        this.b = supplier;
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0007: CONSTRUCTOR 
      (wrap:java.util.ArrayDeque:0x0004: CONSTRUCTOR  A[MD:():void (c), WRAPPED] (LINE:5) call: java.util.ArrayDeque.<init>():void type: CONSTRUCTOR)
     A[MD:(T):void (c)] (LINE:8) call: java.lang.ref.SoftReference.<init>(java.lang.Object):void type: CONSTRUCTOR */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ SoftReference a() {
        return new SoftReference(new ArrayDeque());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object b() {
        ArrayDeque arrayDequeC = c();
        return !arrayDequeC.isEmpty() ? arrayDequeC.pop() : this.b.get();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ArrayDeque c() {
        ArrayDeque arrayDeque = (ArrayDeque) ((SoftReference) this.a.get()).get();
        if (arrayDeque != null) {
            return arrayDeque;
        }
        ArrayDeque arrayDeque2 = new ArrayDeque();
        this.a.set(new SoftReference(arrayDeque2));
        return arrayDeque2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void d(Object obj) {
        ArrayDeque arrayDequeC = c();
        if (arrayDequeC.size() < 12) {
            arrayDequeC.push(obj);
        }
    }
}
