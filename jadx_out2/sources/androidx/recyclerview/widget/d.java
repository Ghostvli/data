package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.c;
import androidx.recyclerview.widget.g;
import defpackage.ju1;
import defpackage.w82;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public static final Executor h = new b();
    public final ju1 a;
    public final c b;
    public Executor c;
    public final List d;
    public List e;
    public List f;
    public int g;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Runnable {
        public final /* synthetic */ List f;
        public final /* synthetic */ List g;
        public final /* synthetic */ int h;
        public final /* synthetic */ Runnable i;

        /* JADX INFO: renamed from: androidx.recyclerview.widget.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class C0040a extends g.b {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public C0040a() {
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.recyclerview.widget.g.b
            public boolean a(int i, int i2) {
                Object obj = a.this.f.get(i);
                Object obj2 = a.this.g.get(i2);
                if (obj != null && obj2 != null) {
                    return d.this.b.b().a(obj, obj2);
                }
                if (obj == null && obj2 == null) {
                    return true;
                }
                throw new AssertionError();
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.recyclerview.widget.g.b
            public boolean b(int i, int i2) {
                Object obj = a.this.f.get(i);
                Object obj2 = a.this.g.get(i2);
                return (obj == null || obj2 == null) ? obj == null && obj2 == null : d.this.b.b().b(obj, obj2);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.recyclerview.widget.g.b
            public Object c(int i, int i2) {
                Object obj = a.this.f.get(i);
                Object obj2 = a.this.g.get(i2);
                if (obj == null || obj2 == null) {
                    throw new AssertionError();
                }
                return d.this.b.b().c(obj, obj2);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.recyclerview.widget.g.b
            public int d() {
                return a.this.g.size();
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.recyclerview.widget.g.b
            public int e() {
                return a.this.f.size();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class b implements Runnable {
            public final /* synthetic */ g.e f;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public b(g.e eVar) {
                this.f = eVar;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                d dVar = d.this;
                if (dVar.g == aVar.h) {
                    dVar.b(aVar.g, this.f, aVar.i);
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(List list, List list2, int i, Runnable runnable) {
            this.f = list;
            this.g = list2;
            this.h = i;
            this.i = runnable;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            d.this.c.execute(new b(g.b(new C0040a())));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b implements Executor {
        public final Handler f = new Handler(Looper.getMainLooper());

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f.post(runnable);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public d(ju1 ju1Var, c cVar) {
        this.d = new CopyOnWriteArrayList();
        this.f = Collections.EMPTY_LIST;
        this.a = ju1Var;
        this.b = cVar;
        if (cVar.c() != null) {
            this.c = cVar.c();
        } else {
            this.c = h;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List a() {
        return this.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b(List list, g.e eVar, Runnable runnable) {
        List list2 = this.f;
        this.e = list;
        this.f = Collections.unmodifiableList(list);
        eVar.b(this.a);
        c(list2, runnable);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void c(List list, Runnable runnable) {
        Iterator it = this.d.iterator();
        if (it.hasNext()) {
            w82.a(it.next());
            throw null;
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void d(List list, Runnable runnable) {
        int i = this.g + 1;
        this.g = i;
        List list2 = this.e;
        if (list == list2) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        List list3 = this.f;
        if (list == null) {
            int size = list2.size();
            this.e = null;
            this.f = Collections.EMPTY_LIST;
            this.a.c(0, size);
            c(list3, runnable);
            return;
        }
        if (list2 != null) {
            this.b.a().execute(new a(list2, list, i, runnable));
            return;
        }
        this.e = list;
        this.f = Collections.unmodifiableList(list);
        this.a.b(0, list.size());
        c(list3, runnable);
    }

    public d(RecyclerView.h hVar, g.f fVar) {
        this(new androidx.recyclerview.widget.b(hVar), new c.a(fVar).a());
    }
}
