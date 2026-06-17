package defpackage;

import androidx.lifecycle.l;
import com.fongmi.android.tv.bean.Result;
import com.fongmi.android.tv.bean.Site;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class b94 extends c45 {
    public final nw2 b = new nw2();
    public final nw2 c = new nw2();
    public final nw2 d = new nw2();
    public final nw2 e = new nw2();
    public final AtomicInteger i = new AtomicInteger(0);
    public final List h = new CopyOnWriteArrayList();
    public final Map f = new EnumMap(a.class);
    public final Map g = new EnumMap(a.class);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum a {
        RESULT,
        PLAYER,
        ACTION
    }

    public b94() {
        for (a aVar : a.values()) {
            this.g.put(aVar, new AtomicInteger(0));
        }
    }

    public static /* synthetic */ void f(AtomicInteger atomicInteger, int i, nw2 nw2Var, Result result) {
        if (atomicInteger.get() == i) {
            nw2Var.j(result);
        }
    }

    public static /* synthetic */ void h(AtomicInteger atomicInteger, int i, nw2 nw2Var, Throwable th) {
        if (atomicInteger.get() == i && !(th instanceof CancellationException)) {
            if (th instanceof ez0) {
                nw2Var.j(Result.error(th.getMessage()));
            } else {
                nw2Var.j(Result.empty());
            }
            th.printStackTrace();
        }
    }

    public final /* synthetic */ void A(String str, boolean z, final int i, Site site) {
        p31 p31VarS = p31.R(ul4.e().submit((Callable) sz3.d(site, str, z))).S(f10.i, TimeUnit.MILLISECONDS, ul4.g());
        this.h.add(p31VarS);
        p31VarS.Q(ul4.a(new Consumer() { // from class: a94
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.z(i, (Result) obj);
            }
        }), du2.b());
    }

    public void B(final String str, final String str2, final String str3) {
        s(a.PLAYER, this.c, new Callable() { // from class: u84
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return d84.l(str, str2, str3);
            }
        });
    }

    public void C(Site site, String str, boolean z, String str2) {
        s(a.RESULT, this.b, sz3.e(site, str, z, str2));
    }

    public void D(List list, final String str, final boolean z) {
        final int iE = E();
        list.forEach(new Consumer() { // from class: t84
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.A(str, z, iE, (Site) obj);
            }
        });
    }

    public int E() {
        int iIncrementAndGet = this.i.incrementAndGet();
        this.h.forEach(new Consumer() { // from class: q84
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((Future) obj).cancel(true);
            }
        });
        this.h.clear();
        return iIncrementAndGet;
    }

    @Override // defpackage.c45
    public void d() {
        super.d();
        E();
        this.f.values().forEach(new Consumer() { // from class: y84
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((lu1) obj).cancel(true);
            }
        });
    }

    public void p(final String str, final String str2) {
        s(a.ACTION, this.e, new Callable() { // from class: r84
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return d84.e(str, str2);
            }
        });
    }

    public void q(final String str, final String str2, final String str3, final boolean z, final HashMap map) {
        s(a.RESULT, this.b, new Callable() { // from class: s84
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return d84.g(str, str2, str3, z, map);
            }
        });
    }

    public void r(final String str, final String str2) {
        s(a.RESULT, this.b, new Callable() { // from class: v84
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return d84.h(str, str2);
            }
        });
    }

    public final void s(a aVar, final nw2 nw2Var, Callable callable) {
        final AtomicInteger atomicInteger = (AtomicInteger) this.g.get(aVar);
        Objects.requireNonNull(atomicInteger);
        final int iIncrementAndGet = atomicInteger.incrementAndGet();
        lu1 lu1Var = (lu1) this.f.get(aVar);
        if (lu1Var != null) {
            lu1Var.cancel(true);
        }
        p31 p31VarS = p31.R(ul4.d().submit(callable)).S(f10.c, TimeUnit.MILLISECONDS, ul4.g());
        this.f.put(aVar, p31VarS);
        p31VarS.Q(ul4.b(new Consumer() { // from class: w84
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                b94.f(atomicInteger, iIncrementAndGet, nw2Var, (Result) obj);
            }
        }, new Consumer() { // from class: x84
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                b94.h(atomicInteger, iIncrementAndGet, nw2Var, (Throwable) obj);
            }
        }), du2.b());
    }

    public l t() {
        return this.e;
    }

    public l u() {
        return this.c;
    }

    public l v() {
        return this.b;
    }

    public l w() {
        return this.d;
    }

    public void x() {
        s(a.RESULT, this.b, new Callable() { // from class: z84
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return d84.j(b75.I().O());
            }
        });
    }

    public b94 y() {
        this.d.l(null);
        this.b.l(null);
        this.c.l(null);
        this.e.l(null);
        return this;
    }

    public final /* synthetic */ void z(int i, Result result) {
        if (this.i.get() == i) {
            this.d.j(result);
        }
    }
}
