package defpackage;

import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ut2 {
    public final e32 a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends e32 {
        public a(long j) {
            super(j);
        }

        @Override // defpackage.e32
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public void j(b bVar, Object obj) {
            bVar.c();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public static final Queue d = iy4.g(0);
        public int a;
        public int b;
        public Object c;

        public static b a(Object obj, int i, int i2) {
            b bVar;
            Queue queue = d;
            synchronized (queue) {
                bVar = (b) queue.poll();
            }
            if (bVar == null) {
                bVar = new b();
            }
            bVar.b(obj, i, i2);
            return bVar;
        }

        public final void b(Object obj, int i, int i2) {
            this.c = obj;
            this.b = i;
            this.a = i2;
        }

        public void c() {
            Queue queue = d;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.b == bVar.b && this.a == bVar.a && this.c.equals(bVar.c)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.c.hashCode();
        }
    }

    public ut2(long j) {
        this.a = new a(j);
    }

    public Object a(Object obj, int i, int i2) {
        b bVarA = b.a(obj, i, i2);
        Object objG = this.a.g(bVarA);
        bVarA.c();
        return objG;
    }

    public void b(Object obj, int i, int i2, Object obj2) {
        this.a.k(b.a(obj, i, i2), obj2);
    }
}
