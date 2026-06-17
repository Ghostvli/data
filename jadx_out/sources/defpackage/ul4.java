package defpackage;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ul4 {
    public static final qu1 a = du2.c(Executors.newFixedThreadPool(5));
    public static final qu1 b = du2.c(Executors.newFixedThreadPool(20));
    public static final ScheduledExecutorService c = Executors.newSingleThreadScheduledExecutor();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements v81 {
        public final /* synthetic */ Consumer a;
        public final /* synthetic */ Consumer b;

        public a(Consumer consumer, Consumer consumer2) {
            this.a = consumer;
            this.b = consumer2;
        }

        @Override // defpackage.v81
        public void a(Object obj) {
            this.a.accept(obj);
        }

        @Override // defpackage.v81
        public void b(Throwable th) {
            Consumer consumer = this.b;
            if (consumer != null) {
                consumer.accept(th);
            }
        }
    }

    public static v81 a(Consumer consumer) {
        return b(consumer, null);
    }

    public static v81 b(Consumer consumer, Consumer consumer2) {
        return new a(consumer, consumer2);
    }

    public static void c(Runnable runnable) {
        a.execute(runnable);
    }

    public static qu1 d() {
        return a;
    }

    public static qu1 e() {
        return b;
    }

    public static void f(Runnable runnable, long j, TimeUnit timeUnit) {
        c.schedule(runnable, j, timeUnit);
    }

    public static ScheduledExecutorService g() {
        return c;
    }

    public static Future h(Runnable runnable) {
        return a.submit(runnable);
    }

    public static Future i(Runnable runnable) {
        return b.submit(runnable);
    }
}
