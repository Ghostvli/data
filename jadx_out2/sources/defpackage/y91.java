package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class y91 {
    public final q91 a;
    public final Handler b;
    public final List c;
    public final lr3 d;
    public final kk e;
    public boolean f;
    public boolean g;
    public boolean h;
    public br3 i;
    public a j;
    public boolean k;
    public a l;
    public Bitmap m;
    public ns4 n;
    public a o;
    public int p;
    public int q;
    public int r;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a extends w60 {
        public final Handler i;
        public final int j;
        public final long k;
        public Bitmap l;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(Handler handler, int i, long j) {
            this.i = handler;
            this.j = i;
            this.k = j;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Bitmap c() {
            return this.l;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: d(Ljava/lang/Object;Lys4;)V */
        @Override // defpackage.rl4
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void d(Bitmap bitmap, ys4 ys4Var) {
            this.l = bitmap;
            this.i.sendMessageAtTime(this.i.obtainMessage(1, this), this.k);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.rl4
        public void m(Drawable drawable) {
            this.l = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        void a();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c implements Handler.Callback {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                y91.this.m((a) message.obj);
                return true;
            }
            if (i != 2) {
                return false;
            }
            y91.this.d.n((a) message.obj);
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public y91(kk kkVar, lr3 lr3Var, q91 q91Var, Handler handler, br3 br3Var, ns4 ns4Var, Bitmap bitmap) {
        this.c = new ArrayList();
        this.d = lr3Var;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.e = kkVar;
        this.b = handler;
        this.i = br3Var;
        this.a = q91Var;
        o(ns4Var, bitmap);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static wq1 g() {
        return new t43(Double.valueOf(Math.random()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static br3 i(lr3 lr3Var, int i, int i2) {
        return lr3Var.e().a(((qr3) ((qr3) qr3.l0(zl0.b).j0(true)).e0(true)).V(i, i2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void a() {
        this.c.clear();
        n();
        q();
        a aVar = this.j;
        if (aVar != null) {
            this.d.n(aVar);
            this.j = null;
        }
        a aVar2 = this.l;
        if (aVar2 != null) {
            this.d.n(aVar2);
            this.l = null;
        }
        a aVar3 = this.o;
        if (aVar3 != null) {
            this.d.n(aVar3);
            this.o = null;
        }
        this.a.clear();
        this.k = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ByteBuffer b() {
        return this.a.getData().asReadOnlyBuffer();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Bitmap c() {
        a aVar = this.j;
        return aVar != null ? aVar.c() : this.m;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int d() {
        a aVar = this.j;
        if (aVar != null) {
            return aVar.j;
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Bitmap e() {
        return this.m;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int f() {
        return this.a.c();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int h() {
        return this.r;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int j() {
        return this.a.h() + this.p;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int k() {
        return this.q;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l() {
        if (!this.f || this.g) {
            return;
        }
        if (this.h) {
            fg3.b(this.o == null, "Pending target must be null when starting from the first frame");
            this.a.f();
            this.h = false;
        }
        a aVar = this.o;
        if (aVar != null) {
            this.o = null;
            m(aVar);
            return;
        }
        this.g = true;
        long jUptimeMillis = SystemClock.uptimeMillis() + ((long) this.a.d());
        this.a.b();
        this.l = new a(this.b, this.a.g(), jUptimeMillis);
        this.i.a(qr3.m0(g())).z0(this.a).s0(this.l);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void m(a aVar) {
        this.g = false;
        if (this.k) {
            this.b.obtainMessage(2, aVar).sendToTarget();
            return;
        }
        if (!this.f) {
            if (this.h) {
                this.b.obtainMessage(2, aVar).sendToTarget();
                return;
            } else {
                this.o = aVar;
                return;
            }
        }
        if (aVar.c() != null) {
            n();
            a aVar2 = this.j;
            this.j = aVar;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                ((b) this.c.get(size)).a();
            }
            if (aVar2 != null) {
                this.b.obtainMessage(2, aVar2).sendToTarget();
            }
        }
        l();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void n() {
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            this.e.c(bitmap);
            this.m = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void o(ns4 ns4Var, Bitmap bitmap) {
        this.n = (ns4) fg3.e(ns4Var);
        this.m = (Bitmap) fg3.e(bitmap);
        this.i = this.i.a(new qr3().g0(ns4Var));
        this.p = iy4.i(bitmap);
        this.q = bitmap.getWidth();
        this.r = bitmap.getHeight();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void p() {
        if (this.f) {
            return;
        }
        this.f = true;
        this.k = false;
        l();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void q() {
        this.f = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void r(b bVar) {
        if (this.k) {
            e04.a("Cannot subscribe to a cleared frame loader");
            return;
        }
        if (this.c.contains(bVar)) {
            e04.a("Cannot subscribe twice in a row");
            return;
        }
        boolean zIsEmpty = this.c.isEmpty();
        this.c.add(bVar);
        if (zIsEmpty) {
            p();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void s(b bVar) {
        this.c.remove(bVar);
        if (this.c.isEmpty()) {
            q();
        }
    }

    public y91(com.bumptech.glide.a aVar, q91 q91Var, int i, int i2, ns4 ns4Var, Bitmap bitmap) {
        this(aVar.f(), com.bumptech.glide.a.t(aVar.h()), q91Var, null, i(com.bumptech.glide.a.t(aVar.h()), i, i2), ns4Var, bitmap);
    }
}
