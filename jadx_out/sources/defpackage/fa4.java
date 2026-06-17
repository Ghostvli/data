package defpackage;

import java.lang.ref.SoftReference;
import java.util.ArrayDeque;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class fa4 {
    public final ThreadLocal a = new ea4(new Supplier() { // from class: da4
        @Override // java.util.function.Supplier
        public final Object get() {
            return fa4.a();
        }
    });
    public final Supplier b;

    public fa4(Supplier supplier) {
        this.b = supplier;
    }

    public static /* synthetic */ SoftReference a() {
        return new SoftReference(new ArrayDeque());
    }

    public Object b() {
        ArrayDeque arrayDequeC = c();
        return !arrayDequeC.isEmpty() ? arrayDequeC.pop() : this.b.get();
    }

    public ArrayDeque c() {
        ArrayDeque arrayDeque = (ArrayDeque) ((SoftReference) this.a.get()).get();
        if (arrayDeque != null) {
            return arrayDeque;
        }
        ArrayDeque arrayDeque2 = new ArrayDeque();
        this.a.set(new SoftReference(arrayDeque2));
        return arrayDeque2;
    }

    public void d(Object obj) {
        ArrayDeque arrayDequeC = c();
        if (arrayDequeC.size() < 12) {
            arrayDequeC.push(obj);
        }
    }
}
