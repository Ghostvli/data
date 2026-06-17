package defpackage;

import android.graphics.drawable.Drawable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class gr3 implements w81, jr3 {
    public static final a p = new a();
    public final int f;
    public final int g;
    public final boolean h;
    public final a i;
    public Object j;
    public yq3 k;
    public boolean l;
    public boolean m;
    public boolean n;
    public ja1 o;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public void a(Object obj) {
            obj.notifyAll();
        }

        public void b(Object obj, long j) throws InterruptedException {
            obj.wait(j);
        }
    }

    public gr3(int i, int i2, boolean z, a aVar) {
        this.f = i;
        this.g = i2;
        this.h = z;
        this.i = aVar;
    }

    @Override // defpackage.rl4
    public void a(j94 j94Var) {
        j94Var.e(this.f, this.g);
    }

    @Override // defpackage.zs1
    public void b() {
    }

    @Override // defpackage.jr3
    public synchronized boolean c(ja1 ja1Var, Object obj, rl4 rl4Var, boolean z) {
        this.n = true;
        this.o = ja1Var;
        this.i.a(this);
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        synchronized (this) {
            try {
                if (isDone()) {
                    return false;
                }
                this.l = true;
                this.i.a(this);
                yq3 yq3Var = null;
                if (z) {
                    yq3 yq3Var2 = this.k;
                    this.k = null;
                    yq3Var = yq3Var2;
                }
                if (yq3Var != null) {
                    yq3Var.clear();
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.rl4
    public synchronized void d(Object obj, ys4 ys4Var) {
    }

    @Override // defpackage.jr3
    public synchronized boolean e(Object obj, Object obj2, rl4 rl4Var, ba0 ba0Var, boolean z) {
        this.m = true;
        this.j = obj;
        this.i.a(this);
        return false;
    }

    @Override // defpackage.rl4
    public synchronized void f(yq3 yq3Var) {
        this.k = yq3Var;
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        try {
            return n(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    @Override // defpackage.zs1
    public void h() {
    }

    @Override // defpackage.rl4
    public void i(j94 j94Var) {
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.l;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0012  */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean isDone() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.l     // Catch: java.lang.Throwable -> L10
            if (r0 != 0) goto L12
            boolean r0 = r1.m     // Catch: java.lang.Throwable -> L10
            if (r0 != 0) goto L12
            boolean r0 = r1.n     // Catch: java.lang.Throwable -> L10
            if (r0 == 0) goto Le
            goto L12
        Le:
            r0 = 0
            goto L13
        L10:
            r0 = move-exception
            goto L15
        L12:
            r0 = 1
        L13:
            monitor-exit(r1)
            return r0
        L15:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L10
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gr3.isDone():boolean");
    }

    @Override // defpackage.rl4
    public synchronized void j(Drawable drawable) {
    }

    @Override // defpackage.rl4
    public void k(Drawable drawable) {
    }

    @Override // defpackage.rl4
    public synchronized yq3 l() {
        return this.k;
    }

    @Override // defpackage.rl4
    public void m(Drawable drawable) {
    }

    public final synchronized Object n(Long l) {
        try {
            if (this.h && !isDone()) {
                iy4.a();
            }
            if (this.l) {
                throw new CancellationException();
            }
            if (this.n) {
                throw new ExecutionException(this.o);
            }
            if (this.m) {
                return this.j;
            }
            if (l == null) {
                this.i.b(this, 0L);
            } else if (l.longValue() > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jLongValue = l.longValue() + jCurrentTimeMillis;
                while (!isDone() && jCurrentTimeMillis < jLongValue) {
                    this.i.b(this, jLongValue - jCurrentTimeMillis);
                    jCurrentTimeMillis = System.currentTimeMillis();
                }
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            if (this.n) {
                throw new ExecutionException(this.o);
            }
            if (this.l) {
                throw new CancellationException();
            }
            if (!this.m) {
                throw new TimeoutException();
            }
            return this.j;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // defpackage.zs1
    public void onStop() {
    }

    public String toString() {
        yq3 yq3Var;
        String str;
        String str2 = super.toString() + "[status=";
        synchronized (this) {
            try {
                yq3Var = null;
                if (this.l) {
                    str = "CANCELLED";
                } else if (this.n) {
                    str = "FAILURE";
                } else if (this.m) {
                    str = "SUCCESS";
                } else {
                    str = "PENDING";
                    yq3Var = this.k;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (yq3Var == null) {
            return str2 + str + "]";
        }
        return str2 + str + ", request=[" + yq3Var + "]]";
    }

    public gr3(int i, int i2) {
        this(i, i2, true, p);
    }

    @Override // java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) {
        return n(Long.valueOf(timeUnit.toMillis(j)));
    }
}
