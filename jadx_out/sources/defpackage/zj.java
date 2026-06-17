package defpackage;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.l;
import defpackage.le;
import defpackage.yj;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class zj extends c45 {
    public Executor b;
    public yj.a c;
    public yj.d d;
    public yj.c e;
    public le f;
    public xp g;
    public DialogInterface.OnClickListener h;
    public CharSequence i;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public nw2 p;
    public nw2 q;
    public nw2 r;
    public nw2 s;
    public nw2 t;
    public nw2 v;
    public nw2 x;
    public nw2 y;
    public int j = 0;
    public boolean u = true;
    public int w = 0;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends yj.a {
        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends le.d {
        public final WeakReference a;

        public b(zj zjVar) {
            this.a = new WeakReference(zjVar);
        }

        @Override // le.d
        public void a(int i, CharSequence charSequence) {
            if (this.a.get() == null || ((zj) this.a.get()).A() || !((zj) this.a.get()).y()) {
                return;
            }
            ((zj) this.a.get()).H(new vj(i, charSequence));
        }

        @Override // le.d
        public void b() {
            if (this.a.get() == null || !((zj) this.a.get()).y()) {
                return;
            }
            ((zj) this.a.get()).I(true);
        }

        @Override // le.d
        public void c(yj.b bVar) {
            if (this.a.get() == null || !((zj) this.a.get()).y()) {
                return;
            }
            if (bVar.a() == -1) {
                bVar = new yj.b(bVar.b(), ((zj) this.a.get()).s());
            }
            ((zj) this.a.get()).J(bVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c implements Executor {
        public final Handler f = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f.post(runnable);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d implements DialogInterface.OnClickListener {
        public final WeakReference f;

        public d(zj zjVar) {
            this.f = new WeakReference(zjVar);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f.get() != null) {
                ((zj) this.f.get()).X(true);
            }
        }
    }

    public static void b0(nw2 nw2Var, Object obj) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            nw2Var.l(obj);
        } else {
            nw2Var.j(obj);
        }
    }

    public boolean A() {
        return this.m;
    }

    public boolean B() {
        return this.n;
    }

    public l C() {
        if (this.v == null) {
            this.v = new nw2();
        }
        return this.v;
    }

    public boolean D() {
        return this.u;
    }

    public boolean E() {
        return this.o;
    }

    public l F() {
        if (this.t == null) {
            this.t = new nw2();
        }
        return this.t;
    }

    public boolean G() {
        return this.k;
    }

    public void H(vj vjVar) {
        if (this.q == null) {
            this.q = new nw2();
        }
        b0(this.q, vjVar);
    }

    public void I(boolean z) {
        if (this.s == null) {
            this.s = new nw2();
        }
        b0(this.s, Boolean.valueOf(z));
    }

    public void J(yj.b bVar) {
        if (this.p == null) {
            this.p = new nw2();
        }
        b0(this.p, bVar);
    }

    public void K(boolean z) {
        this.l = z;
    }

    public void L(int i) {
        this.j = i;
    }

    public void M(yj.a aVar) {
        this.c = aVar;
    }

    public void N(Executor executor) {
        this.b = executor;
    }

    public void O(boolean z) {
        this.m = z;
    }

    public void P(yj.c cVar) {
        this.e = cVar;
    }

    public void Q(boolean z) {
        this.n = z;
    }

    public void R(boolean z) {
        if (this.v == null) {
            this.v = new nw2();
        }
        b0(this.v, Boolean.valueOf(z));
    }

    public void S(boolean z) {
        this.u = z;
    }

    public void T(CharSequence charSequence) {
        if (this.y == null) {
            this.y = new nw2();
        }
        b0(this.y, charSequence);
    }

    public void U(int i) {
        this.w = i;
    }

    public void V(int i) {
        if (this.x == null) {
            this.x = new nw2();
        }
        b0(this.x, Integer.valueOf(i));
    }

    public void W(boolean z) {
        this.o = z;
    }

    public void X(boolean z) {
        if (this.t == null) {
            this.t = new nw2();
        }
        b0(this.t, Boolean.valueOf(z));
    }

    public void Y(CharSequence charSequence) {
        this.i = charSequence;
    }

    public void Z(yj.d dVar) {
        this.d = dVar;
    }

    public void a0(boolean z) {
        this.k = z;
    }

    public int e() {
        yj.d dVar = this.d;
        if (dVar != null) {
            return me.b(dVar, this.e);
        }
        return 0;
    }

    public le f() {
        if (this.f == null) {
            this.f = new le(new b(this));
        }
        return this.f;
    }

    public nw2 g() {
        if (this.q == null) {
            this.q = new nw2();
        }
        return this.q;
    }

    public l h() {
        if (this.r == null) {
            this.r = new nw2();
        }
        return this.r;
    }

    public l i() {
        if (this.p == null) {
            this.p = new nw2();
        }
        return this.p;
    }

    public int j() {
        return this.j;
    }

    public xp k() {
        if (this.g == null) {
            this.g = new xp();
        }
        return this.g;
    }

    public yj.a l() {
        if (this.c == null) {
            this.c = new a();
        }
        return this.c;
    }

    public Executor m() {
        Executor executor = this.b;
        return executor != null ? executor : new c();
    }

    public yj.c n() {
        return this.e;
    }

    public CharSequence o() {
        yj.d dVar = this.d;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    public l p() {
        if (this.y == null) {
            this.y = new nw2();
        }
        return this.y;
    }

    public int q() {
        return this.w;
    }

    public l r() {
        if (this.x == null) {
            this.x = new nw2();
        }
        return this.x;
    }

    public int s() {
        int iE = e();
        return (!me.d(iE) || me.c(iE)) ? -1 : 2;
    }

    public DialogInterface.OnClickListener t() {
        if (this.h == null) {
            this.h = new d(this);
        }
        return this.h;
    }

    public CharSequence u() {
        CharSequence charSequence = this.i;
        if (charSequence != null) {
            return charSequence;
        }
        yj.d dVar = this.d;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public CharSequence v() {
        yj.d dVar = this.d;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public CharSequence w() {
        yj.d dVar = this.d;
        if (dVar != null) {
            return dVar.e();
        }
        return null;
    }

    public l x() {
        if (this.s == null) {
            this.s = new nw2();
        }
        return this.s;
    }

    public boolean y() {
        return this.l;
    }

    public boolean z() {
        yj.d dVar = this.d;
        return dVar == null || dVar.f();
    }
}
