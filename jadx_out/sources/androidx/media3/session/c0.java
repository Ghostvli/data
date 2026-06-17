package androidx.media3.session;

import android.os.Handler;
import defpackage.fy4;
import defpackage.gg3;
import defpackage.la;
import defpackage.xz1;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 {
    public int b;
    public Runnable d;
    public Handler e;
    public boolean f;
    public final Object a = new Object();
    public final la c = new la();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends defpackage.b0 {
        public final int m;
        public final Object n;

        public a(int i, Object obj) {
            this.m = i;
            this.n = obj;
        }

        public static a Q(int i, Object obj) {
            return new a(i, obj);
        }

        @Override // defpackage.b0
        public boolean M(Object obj) {
            return super.M(obj);
        }

        public Object R() {
            return this.n;
        }

        public int S() {
            return this.m;
        }

        public void T() {
            M(this.n);
        }
    }

    public a a(Object obj) {
        a aVarQ;
        synchronized (this.a) {
            try {
                int iC = c();
                aVarQ = a.Q(iC, obj);
                if (this.f) {
                    aVarQ.T();
                } else {
                    this.c.put(Integer.valueOf(iC), aVarQ);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVarQ;
    }

    public void b(long j, Runnable runnable) {
        synchronized (this.a) {
            try {
                Handler handlerE = fy4.E();
                this.e = handlerE;
                this.d = runnable;
                if (this.c.isEmpty()) {
                    d();
                } else {
                    handlerE.postDelayed(new Runnable() { // from class: j14
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f.d();
                        }
                    }, j);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int c() {
        int i;
        synchronized (this.a) {
            i = this.b;
            this.b = i + 1;
        }
        return i;
    }

    public void d() {
        ArrayList arrayList;
        synchronized (this.a) {
            try {
                this.f = true;
                arrayList = new ArrayList(this.c.values());
                this.c.clear();
                if (this.d != null) {
                    ((Handler) gg3.q(this.e)).post(this.d);
                    this.d = null;
                    this.e = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((a) it.next()).T();
        }
    }

    public void e(int i, Object obj) {
        synchronized (this.a) {
            try {
                a aVar = (a) this.c.remove(Integer.valueOf(i));
                if (aVar != null) {
                    if (aVar.R().getClass() == obj.getClass()) {
                        aVar.M(obj);
                    } else {
                        xz1.i("SequencedFutureManager", "Type mismatch, expected " + aVar.R().getClass() + ", but was " + obj.getClass());
                    }
                }
                if (this.d != null && this.c.isEmpty()) {
                    d();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
