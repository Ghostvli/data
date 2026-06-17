package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import defpackage.o21;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class pu1 {
    public final zu a;
    public final Thread b;
    public final mc1 c;
    public final b d;
    public final CopyOnWriteArraySet e;
    public final ArrayDeque f;
    public final ArrayDeque g;
    public final Object h;
    public boolean i;
    public boolean j;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void invoke(Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        void a(Object obj, o21 o21Var);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c {
        public final Object a;
        public o21.b b = new o21.b();
        public boolean c;
        public boolean d;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(Object obj) {
            this.a = obj;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void b(int i, a aVar) {
            if (this.d) {
                return;
            }
            if (i != -1) {
                this.b.a(i);
            }
            this.c = true;
            aVar.invoke(this.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void c(b bVar) {
            if (this.d || !this.c) {
                return;
            }
            o21 o21VarE = this.b.e();
            this.b = new o21.b();
            this.c = false;
            bVar.a(this.a, o21VarE);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void d(b bVar) {
            this.d = true;
            if (bVar == null || !this.c) {
                return;
            }
            this.c = false;
            bVar.a(this.a, this.b.e());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            return this.a.equals(((c) obj).a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public pu1(CopyOnWriteArraySet copyOnWriteArraySet, Looper looper, Thread thread, zu zuVar, b bVar, boolean z) {
        this.a = zuVar;
        this.b = thread;
        this.e = copyOnWriteArraySet;
        this.d = bVar;
        this.h = new Object();
        this.f = new ArrayDeque();
        this.g = new ArrayDeque();
        if (looper == null || zuVar == null || bVar == null) {
            this.c = null;
        } else {
            this.c = zuVar.c(looper, new Handler.Callback() { // from class: nu1
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // android.os.Handler.Callback
                public final boolean handleMessage(Message message) {
                    return this.f.f(message);
                }
            });
        }
        this.j = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(CopyOnWriteArraySet copyOnWriteArraySet, int i, a aVar) {
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((c) it.next()).b(i, aVar);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void c(Object obj) {
        gg3.q(obj);
        synchronized (this.h) {
            try {
                if (this.i) {
                    return;
                }
                this.e.add(new c(obj));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public pu1 d(Looper looper, zu zuVar, b bVar) {
        gg3.v(zuVar != null || bVar == null);
        return new pu1(this.e, looper, looper.getThread(), zuVar, bVar, this.j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e() {
        m();
        if (this.g.isEmpty()) {
            return;
        }
        if (this.d != null && !((mc1) gg3.q(this.c)).f(1)) {
            mc1 mc1Var = this.c;
            mc1Var.b(mc1Var.e(1));
        }
        boolean zIsEmpty = this.f.isEmpty();
        this.f.addAll(this.g);
        this.g.clear();
        if (zIsEmpty) {
            while (!this.f.isEmpty()) {
                ((Runnable) this.f.peekFirst()).run();
                this.f.removeFirst();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean f(Message message) {
        b bVar = (b) gg3.q(this.d);
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((c) it.next()).c(bVar);
            if (((mc1) gg3.q(this.c)).f(1)) {
                break;
            }
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean g() {
        return Thread.currentThread() == this.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void h(final int i, final a aVar) {
        m();
        final CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(this.e);
        this.g.add(new Runnable() { // from class: ou1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                pu1.a(copyOnWriteArraySet, i, aVar);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void i() {
        m();
        synchronized (this.h) {
            this.i = true;
        }
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((c) it.next()).d(this.d);
        }
        this.e.clear();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void j(Object obj) {
        m();
        for (c cVar : this.e) {
            if (cVar.a.equals(obj)) {
                cVar.d(this.d);
                this.e.remove(cVar);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void k(int i, a aVar) {
        h(i, aVar);
        e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void l(a aVar) {
        k(-1, aVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void m() {
        if (this.j) {
            gg3.v(g());
        }
    }

    public pu1(Thread thread) {
        this(new CopyOnWriteArraySet(), null, thread, null, null, true);
    }

    public pu1(Looper looper, zu zuVar, b bVar) {
        this(new CopyOnWriteArraySet(), looper, looper.getThread(), zuVar, bVar, true);
    }

    public pu1(Looper looper) {
        this(looper.getThread());
    }
}
