package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import defpackage.mc1;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class nk4 implements mc1 {
    public static final List b = new ArrayList(50);
    public final Handler a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements mc1.a {
        public Message a;
        public nk4 b;

        public b() {
        }

        @Override // mc1.a
        public void a() {
            ((Message) gg3.q(this.a)).sendToTarget();
            b();
        }

        public final void b() {
            this.a = null;
            this.b = null;
            nk4.q(this);
        }

        public boolean c(Handler handler) {
            boolean zSendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue((Message) gg3.q(this.a));
            b();
            return zSendMessageAtFrontOfQueue;
        }

        public b d(Message message, nk4 nk4Var) {
            this.a = message;
            this.b = nk4Var;
            return this;
        }
    }

    public nk4(Handler handler) {
        this.a = handler;
    }

    public static b p() {
        b bVar;
        List list = b;
        synchronized (list) {
            try {
                bVar = list.isEmpty() ? new b() : (b) list.remove(list.size() - 1);
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    public static void q(b bVar) {
        List list = b;
        synchronized (list) {
            try {
                if (list.size() < 50) {
                    list.add(bVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.mc1
    public mc1.a a(int i, int i2, int i3) {
        return p().d(this.a.obtainMessage(i, i2, i3), this);
    }

    @Override // defpackage.mc1
    public boolean b(mc1.a aVar) {
        return ((b) aVar).c(this.a);
    }

    @Override // defpackage.mc1
    public boolean c(int i, int i2) {
        return this.a.sendEmptyMessageDelayed(i, i2);
    }

    @Override // defpackage.mc1
    public boolean d(Runnable runnable) {
        return this.a.post(runnable);
    }

    @Override // defpackage.mc1
    public mc1.a e(int i) {
        return p().d(this.a.obtainMessage(i), this);
    }

    @Override // defpackage.mc1
    public boolean f(int i) {
        gg3.d(i != 0);
        return this.a.hasMessages(i);
    }

    @Override // defpackage.mc1
    public boolean g(Runnable runnable, long j) {
        return this.a.postDelayed(runnable, j);
    }

    @Override // defpackage.mc1
    public boolean h(int i) {
        return this.a.sendEmptyMessage(i);
    }

    @Override // defpackage.mc1
    public mc1.a i(int i, int i2, int i3, Object obj) {
        return p().d(this.a.obtainMessage(i, i2, i3, obj), this);
    }

    @Override // defpackage.mc1
    public boolean j(int i, long j) {
        return this.a.sendEmptyMessageAtTime(i, j);
    }

    @Override // defpackage.mc1
    public void k(int i) {
        gg3.d(i != 0);
        this.a.removeMessages(i);
    }

    @Override // defpackage.mc1
    public mc1.a l(int i, Object obj) {
        return p().d(this.a.obtainMessage(i, obj), this);
    }

    @Override // defpackage.mc1
    public void m(Object obj) {
        this.a.removeCallbacksAndMessages(obj);
    }

    @Override // defpackage.mc1
    public Looper n() {
        return this.a.getLooper();
    }
}
