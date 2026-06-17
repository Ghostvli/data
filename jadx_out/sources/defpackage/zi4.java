package defpackage;

import defpackage.zi4;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zi4 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements xi4, Serializable {
        public transient Object f = new Object();
        public final xi4 g;
        public volatile transient boolean h;
        public transient Object i;

        public a(xi4 xi4Var) {
            this.g = (xi4) gg3.q(xi4Var);
        }

        @Override // defpackage.xi4
        public Object get() {
            if (!this.h) {
                synchronized (this.f) {
                    try {
                        if (!this.h) {
                            Object obj = this.g.get();
                            this.i = obj;
                            this.h = true;
                            return obj;
                        }
                    } finally {
                    }
                }
            }
            return p43.a(this.i);
        }

        public String toString() {
            Object obj;
            StringBuilder sb = new StringBuilder("Suppliers.memoize(");
            if (this.h) {
                obj = "<supplier that returned " + this.i + ">";
            } else {
                obj = this.g;
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements xi4 {
        public static final xi4 i = new xi4() { // from class: aj4
            @Override // defpackage.xi4
            public final Object get() {
                return zi4.b.a();
            }
        };
        public final Object f = new Object();
        public volatile xi4 g;
        public Object h;

        public b(xi4 xi4Var) {
            this.g = (xi4) gg3.q(xi4Var);
        }

        public static /* synthetic */ Void a() {
            throw new IllegalStateException();
        }

        @Override // defpackage.xi4
        public Object get() {
            xi4 xi4Var = this.g;
            xi4 xi4Var2 = i;
            if (xi4Var != xi4Var2) {
                synchronized (this.f) {
                    try {
                        if (this.g != xi4Var2) {
                            Object obj = this.g.get();
                            this.h = obj;
                            this.g = xi4Var2;
                            return obj;
                        }
                    } finally {
                    }
                }
            }
            return p43.a(this.h);
        }

        public String toString() {
            Object obj = this.g;
            StringBuilder sb = new StringBuilder("Suppliers.memoize(");
            if (obj == i) {
                obj = "<supplier that returned " + this.h + ">";
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    public static xi4 a(xi4 xi4Var) {
        return ((xi4Var instanceof b) || (xi4Var instanceof a)) ? xi4Var : xi4Var instanceof Serializable ? new a(xi4Var) : new b(xi4Var);
    }
}
