package defpackage;

import android.os.Handler;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface qg {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {

        /* JADX INFO: renamed from: qg$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class C0114a {
            public final CopyOnWriteArrayList a = new CopyOnWriteArrayList();

            /* JADX INFO: renamed from: qg$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static final class C0115a {
                public final Handler a;
                public final a b;
                public boolean c;

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public C0115a(Handler handler, a aVar) {
                    this.a = handler;
                    this.b = aVar;
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public void d() {
                    this.c = true;
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public void b(Handler handler, a aVar) {
                gg3.q(handler);
                gg3.q(aVar);
                d(aVar);
                this.a.add(new C0115a(handler, aVar));
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public void c(int i, long j, long j2) {
                final int i2;
                final long j3;
                final long j4;
                for (final C0115a c0115a : this.a) {
                    if (c0115a.c) {
                        i2 = i;
                        j3 = j;
                        j4 = j2;
                    } else {
                        i2 = i;
                        j3 = j;
                        j4 = j2;
                        c0115a.a.post(new Runnable() { // from class: pg
                            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                            @Override // java.lang.Runnable
                            public final void run() {
                                c0115a.b.A(i2, j3, j4);
                            }
                        });
                    }
                    i = i2;
                    j = j3;
                    j2 = j4;
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public void d(a aVar) {
                for (C0115a c0115a : this.a) {
                    if (c0115a.b == aVar) {
                        c0115a.d();
                        this.a.remove(c0115a);
                    }
                }
            }
        }

        void A(int i, long j, long j2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    default long a() {
        return -9223372036854775807L;
    }

    void c(Handler handler, a aVar);

    hs4 e();

    void f(a aVar);

    long g();
}
