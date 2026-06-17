package defpackage;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class k91 implements f14 {
    public final Function0 a;
    public final Function1 b;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements Iterator, op1 {
        public Object f;
        public int g = -2;

        public a() {
        }

        public final void b() {
            Object objInvoke;
            int i = this.g;
            k91 k91Var = k91.this;
            if (i == -2) {
                objInvoke = k91Var.a.invoke();
            } else {
                Function1 function1 = k91Var.b;
                Object obj = this.f;
                obj.getClass();
                objInvoke = function1.invoke(obj);
            }
            this.f = objInvoke;
            this.g = objInvoke == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.g < 0) {
                b();
            }
            return this.g == 1;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.g < 0) {
                b();
            }
            if (this.g == 0) {
                bo.a();
                return null;
            }
            Object obj = this.f;
            obj.getClass();
            this.g = -1;
            return obj;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public k91(Function0 function0, Function1 function1) {
        function0.getClass();
        function1.getClass();
        this.a = function0;
        this.b = function1;
    }

    @Override // defpackage.f14
    public Iterator iterator() {
        return new a();
    }
}
