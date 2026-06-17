package defpackage;

import androidx.lifecycle.l;
import com.fongmi.android.tv.bean.Channel;
import com.fongmi.android.tv.bean.Epg;
import com.fongmi.android.tv.bean.EpgData;
import com.fongmi.android.tv.bean.Live;
import com.fongmi.android.tv.bean.Result;
import j$.time.ZoneId;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ry1 extends c45 {
    public final nw2 e = new nw2();
    public final nw2 b = new nw2();
    public final nw2 c = new nw2();
    public final nw2 d = new nw2();
    public volatile ZoneId h = ZoneId.systemDefault();
    public final Map f = new EnumMap(a.class);
    public final Map g = new EnumMap(a.class);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum a {
        LIVE(f10.d),
        EPG(f10.e),
        XML(f10.f),
        URL(f10.l);

        public final long f;

        a(long j) {
            this.f = j;
        }
    }

    public ry1() {
        for (a aVar : a.values()) {
            this.g.put(aVar, new AtomicInteger(0));
        }
    }

    public static /* synthetic */ void i(AtomicInteger atomicInteger, int i, Consumer consumer, Object obj) {
        if (atomicInteger.get() == i) {
            consumer.accept(obj);
        }
    }

    public static /* synthetic */ void k(AtomicInteger atomicInteger, int i, Consumer consumer, Throwable th) {
        if (!(th instanceof CancellationException) && atomicInteger.get() == i) {
            consumer.accept(th);
        }
    }

    public final /* synthetic */ void A(Throwable th) {
        if (th instanceof ez0) {
            this.c.j(Result.error(th.getMessage()));
        } else {
            this.d.j(new Live());
        }
    }

    public final /* synthetic */ void B(Throwable th) {
        this.b.j(Boolean.FALSE);
    }

    public l C() {
        return this.d;
    }

    public void D(final Live live) {
        a aVar = a.LIVE;
        Callable callable = new Callable() { // from class: ky1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.z(live);
            }
        };
        final nw2 nw2Var = this.d;
        Objects.requireNonNull(nw2Var);
        r(aVar, callable, new Consumer() { // from class: ly1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                nw2Var.j((Live) obj);
            }
        }, new Consumer() { // from class: my1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.A((Throwable) obj);
            }
        });
    }

    public void E(final Live live) {
        a aVar = a.XML;
        Callable callable = new Callable() { // from class: fy1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Boolean.valueOf(nw1.i(live));
            }
        };
        final nw2 nw2Var = this.b;
        Objects.requireNonNull(nw2Var);
        r(aVar, callable, new Consumer() { // from class: gy1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                nw2Var.j((Boolean) obj);
            }
        }, new Consumer() { // from class: hy1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.B((Throwable) obj);
            }
        });
    }

    public final void F(Live live) {
        try {
            this.h = live.getTimeZone().isEmpty() ? ZoneId.systemDefault() : ZoneId.of(live.getTimeZone());
        } catch (Exception unused) {
        }
    }

    public l G() {
        return this.c;
    }

    public l H() {
        return this.b;
    }

    @Override // defpackage.c45
    public void d() {
        super.d();
        this.f.values().forEach(new Consumer() { // from class: qy1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((lu1) obj).cancel(true);
            }
        });
    }

    public l q() {
        return this.e;
    }

    public final void r(a aVar, Callable callable, final Consumer consumer, final Consumer consumer2) {
        final AtomicInteger atomicInteger = (AtomicInteger) this.g.get(aVar);
        final int iIncrementAndGet = atomicInteger.incrementAndGet();
        lu1 lu1Var = (lu1) this.f.get(aVar);
        if (lu1Var != null) {
            lu1Var.cancel(true);
        }
        p31 p31VarS = p31.R(ul4.d().submit(callable)).S(aVar.f, TimeUnit.MILLISECONDS, ul4.g());
        this.f.put(aVar, p31VarS);
        p31VarS.Q(ul4.b(new Consumer() { // from class: dy1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ry1.i(atomicInteger, iIncrementAndGet, consumer, obj);
            }
        }, new Consumer() { // from class: ey1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ry1.k(atomicInteger, iIncrementAndGet, consumer2, (Throwable) obj);
            }
        }), du2.b());
    }

    public void s(final Channel channel) {
        a aVar = a.EPG;
        Callable callable = new Callable() { // from class: by1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.x(channel);
            }
        };
        final nw2 nw2Var = this.e;
        Objects.requireNonNull(nw2Var);
        r(aVar, callable, new Consumer() { // from class: iy1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                nw2Var.j((Epg) obj);
            }
        }, new Consumer() { // from class: jy1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.y((Throwable) obj);
            }
        });
    }

    public void t(final Channel channel) {
        a aVar = a.URL;
        Callable callable = new Callable() { // from class: ny1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return nw1.f(channel);
            }
        };
        nw2 nw2Var = this.c;
        Objects.requireNonNull(nw2Var);
        r(aVar, callable, new oy1(nw2Var), new py1(this));
    }

    public void u(final Channel channel, final EpgData epgData) {
        a aVar = a.URL;
        Callable callable = new Callable() { // from class: cy1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return nw1.g(channel, epgData);
            }
        };
        nw2 nw2Var = this.c;
        Objects.requireNonNull(nw2Var);
        r(aVar, callable, new oy1(nw2Var), new py1(this));
    }

    public ZoneId v() {
        return this.h;
    }

    public final void w(Throwable th) {
        boolean z = th instanceof ez0;
        nw2 nw2Var = this.c;
        if (z) {
            nw2Var.j(Result.error(th.getMessage()));
        } else {
            nw2Var.j(new Result());
        }
    }

    public final /* synthetic */ Epg x(Channel channel) {
        return nw1.e(channel, this.h);
    }

    public final /* synthetic */ void y(Throwable th) {
        this.e.j(new Epg());
    }

    public final /* synthetic */ Live z(Live live) {
        nw1.h(live);
        F(live);
        return live;
    }
}
