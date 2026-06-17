package androidx.recyclerview.widget;

import androidx.recyclerview.widget.g;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public final Executor a;
    public final Executor b;
    public final g.f c;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public static final Object d = new Object();
        public static Executor e;
        public Executor a;
        public Executor b;
        public final g.f c;

        public a(g.f fVar) {
            this.c = fVar;
        }

        public c a() {
            if (this.b == null) {
                synchronized (d) {
                    try {
                        if (e == null) {
                            e = Executors.newFixedThreadPool(2);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                this.b = e;
            }
            return new c(this.a, this.b, this.c);
        }
    }

    public c(Executor executor, Executor executor2, g.f fVar) {
        this.a = executor;
        this.b = executor2;
        this.c = fVar;
    }

    public Executor a() {
        return this.b;
    }

    public g.f b() {
        return this.c;
    }

    public Executor c() {
        return this.a;
    }
}
