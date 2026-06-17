package defpackage;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class mq3 {
    public final b a;
    public final ArrayDeque b = new ArrayDeque();
    public final ArrayDeque c = new ArrayDeque();
    public final PriorityQueue d = new PriorityQueue();
    public int e = -1;
    public a f;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements Comparable {
        public long g = -9223372036854775807L;
        public final List f = new ArrayList();

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: compareTo(Ljava/lang/Object;)I */
        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            return Long.compare(this.g, aVar.g);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void b(long j, r73 r73Var) {
            gg3.d(j != -9223372036854775807L);
            gg3.v(this.f.isEmpty());
            this.g = j;
            this.f.add(r73Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        void a(long j, r73 r73Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public mq3(b bVar) {
        this.a = bVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void a(long j, r73 r73Var) {
        int i;
        if (j == -9223372036854775807L || (i = this.e) == 0 || (i != -1 && this.d.size() >= this.e && j < ((a) fy4.l((a) this.d.peek())).g)) {
            this.a.a(j, r73Var);
            return;
        }
        r73 r73VarC = c(r73Var);
        a aVar = this.f;
        if (aVar != null && j == aVar.g) {
            aVar.f.add(r73VarC);
            return;
        }
        a aVar2 = this.c.isEmpty() ? new a() : (a) this.c.pop();
        aVar2.b(j, r73VarC);
        this.d.add(aVar2);
        this.f = aVar2;
        int i2 = this.e;
        if (i2 != -1) {
            e(i2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b() {
        this.d.clear();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final r73 c(r73 r73Var) {
        r73 r73Var2 = this.b.isEmpty() ? new r73() : (r73) this.b.pop();
        r73Var2.b0(r73Var.a());
        System.arraycopy(r73Var.f(), r73Var.g(), r73Var2.f(), 0, r73Var2.a());
        return r73Var2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void d() {
        e(0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void e(int i) {
        while (this.d.size() > i) {
            a aVar = (a) fy4.l((a) this.d.poll());
            for (int i2 = 0; i2 < aVar.f.size(); i2++) {
                this.a.a(aVar.g, (r73) aVar.f.get(i2));
                this.b.push((r73) aVar.f.get(i2));
            }
            aVar.f.clear();
            a aVar2 = this.f;
            if (aVar2 != null && aVar2.g == aVar.g) {
                this.f = null;
            }
            this.c.push(aVar);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int f() {
        return this.e;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g(int i) {
        gg3.v(i >= 0);
        this.e = i;
        e(i);
    }
}
