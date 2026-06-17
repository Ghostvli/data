package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.b;
import com.bumptech.glide.c;
import defpackage.us0;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class i74 implements yq3, j94, cs3 {
    public static final boolean E = Log.isLoggable("GlideRequest", 2);
    public int A;
    public int B;
    public boolean C;
    public RuntimeException D;
    public int a;
    public final String b;
    public final je4 c;
    public final Object d;
    public final jr3 e;
    public final er3 f;
    public final Context g;
    public final c h;
    public final Object i;
    public final Class j;
    public final pi k;
    public final int l;
    public final int m;
    public final ug3 n;
    public final rl4 o;
    public final List p;
    public final zs4 q;
    public final Executor r;
    public yr3 s;
    public us0.d t;
    public long u;
    public volatile us0 v;
    public a w;
    public Drawable x;
    public Drawable y;
    public Drawable z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    public i74(Context context, c cVar, Object obj, Object obj2, Class cls, pi piVar, int i, int i2, ug3 ug3Var, rl4 rl4Var, jr3 jr3Var, List list, er3 er3Var, us0 us0Var, zs4 zs4Var, Executor executor) {
        this.b = E ? String.valueOf(super.hashCode()) : null;
        this.c = je4.a();
        this.d = obj;
        this.g = context;
        this.h = cVar;
        this.i = obj2;
        this.j = cls;
        this.k = piVar;
        this.l = i;
        this.m = i2;
        this.n = ug3Var;
        this.o = rl4Var;
        this.e = jr3Var;
        this.p = list;
        this.f = er3Var;
        this.v = us0Var;
        this.q = zs4Var;
        this.r = executor;
        this.w = a.PENDING;
        if (this.D == null && cVar.g().a(b.c.class)) {
            this.D = new RuntimeException("Glide request origin trace");
        }
    }

    public static int v(int i, float f) {
        return i == Integer.MIN_VALUE ? i : Math.round(f * i);
    }

    public static i74 y(Context context, c cVar, Object obj, Object obj2, Class cls, pi piVar, int i, int i2, ug3 ug3Var, rl4 rl4Var, jr3 jr3Var, List list, er3 er3Var, us0 us0Var, zs4 zs4Var, Executor executor) {
        return new i74(context, cVar, obj, obj2, cls, piVar, i, i2, ug3Var, rl4Var, jr3Var, list, er3Var, us0Var, zs4Var, executor);
    }

    public final void A(yr3 yr3Var, Object obj, ba0 ba0Var, boolean z) {
        boolean zE;
        boolean zS = s();
        this.w = a.COMPLETE;
        this.s = yr3Var;
        if (this.h.h() <= 3) {
            Log.d("Glide", "Finished loading " + obj.getClass().getSimpleName() + " from " + ba0Var + " for " + this.i + " with size [" + this.A + "x" + this.B + "] in " + b02.a(this.u) + " ms");
        }
        x();
        boolean z2 = true;
        this.C = true;
        try {
            List list = this.p;
            if (list != null) {
                Iterator it = list.iterator();
                zE = false;
                while (it.hasNext()) {
                    Object obj2 = obj;
                    ba0 ba0Var2 = ba0Var;
                    zE |= ((jr3) it.next()).e(obj2, this.i, this.o, ba0Var2, zS);
                    obj = obj2;
                    ba0Var = ba0Var2;
                }
            } else {
                zE = false;
            }
            Object obj3 = obj;
            ba0 ba0Var3 = ba0Var;
            jr3 jr3Var = this.e;
            if (jr3Var == null || !jr3Var.e(obj3, this.i, this.o, ba0Var3, zS)) {
                z2 = false;
            }
            if (!(z2 | zE)) {
                this.o.d(obj3, this.q.a(ba0Var3, zS));
            }
            this.C = false;
            qa1.f("GlideRequest", this.a);
        } catch (Throwable th) {
            this.C = false;
            throw th;
        }
    }

    public final void B() {
        if (l()) {
            Drawable drawableQ = this.i == null ? q() : null;
            if (drawableQ == null) {
                drawableQ = p();
            }
            if (drawableQ == null) {
                drawableQ = r();
            }
            this.o.j(drawableQ);
        }
    }

    @Override // defpackage.yq3
    public boolean a() {
        boolean z;
        synchronized (this.d) {
            z = this.w == a.COMPLETE;
        }
        return z;
    }

    @Override // defpackage.cs3
    public void b(ja1 ja1Var) {
        z(ja1Var, 5);
    }

    @Override // defpackage.cs3
    public void c(yr3 yr3Var, ba0 ba0Var, boolean z) {
        this.c.c();
        yr3 yr3Var2 = null;
        try {
            synchronized (this.d) {
                try {
                    this.t = null;
                    if (yr3Var == null) {
                        b(new ja1("Expected to receive a Resource<R> with an object of " + this.j + " inside, but instead got null."));
                        return;
                    }
                    Object obj = yr3Var.get();
                    try {
                        if (obj == null || !this.j.isAssignableFrom(obj.getClass())) {
                            this.s = null;
                            StringBuilder sb = new StringBuilder("Expected to receive an object of ");
                            sb.append(this.j);
                            sb.append(" but instead got ");
                            sb.append(obj != null ? obj.getClass() : "");
                            sb.append("{");
                            sb.append(obj);
                            sb.append("} inside Resource{");
                            sb.append(yr3Var);
                            sb.append("}.");
                            sb.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                            b(new ja1(sb.toString()));
                        } else if (m()) {
                            A(yr3Var, obj, ba0Var, z);
                            return;
                        } else {
                            this.s = null;
                            this.w = a.COMPLETE;
                            qa1.f("GlideRequest", this.a);
                        }
                        this.v.k(yr3Var);
                    } catch (Throwable th) {
                        yr3Var2 = yr3Var;
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (yr3Var2 != null) {
                this.v.k(yr3Var2);
            }
            throw th3;
        }
    }

    @Override // defpackage.yq3
    public void clear() {
        synchronized (this.d) {
            try {
                g();
                this.c.c();
                a aVar = this.w;
                a aVar2 = a.CLEARED;
                if (aVar == aVar2) {
                    return;
                }
                n();
                yr3 yr3Var = this.s;
                if (yr3Var != null) {
                    this.s = null;
                } else {
                    yr3Var = null;
                }
                if (k()) {
                    this.o.m(r());
                }
                qa1.f("GlideRequest", this.a);
                this.w = aVar2;
                if (yr3Var != null) {
                    this.v.k(yr3Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.yq3
    public boolean d(yq3 yq3Var) {
        int i;
        int i2;
        Object obj;
        Class cls;
        pi piVar;
        ug3 ug3Var;
        int size;
        int i3;
        int i4;
        Object obj2;
        Class cls2;
        pi piVar2;
        ug3 ug3Var2;
        int size2;
        if (!(yq3Var instanceof i74)) {
            return false;
        }
        synchronized (this.d) {
            try {
                i = this.l;
                i2 = this.m;
                obj = this.i;
                cls = this.j;
                piVar = this.k;
                ug3Var = this.n;
                List list = this.p;
                size = list != null ? list.size() : 0;
            } finally {
            }
        }
        i74 i74Var = (i74) yq3Var;
        synchronized (i74Var.d) {
            try {
                i3 = i74Var.l;
                i4 = i74Var.m;
                obj2 = i74Var.i;
                cls2 = i74Var.j;
                piVar2 = i74Var.k;
                ug3Var2 = i74Var.n;
                List list2 = i74Var.p;
                size2 = list2 != null ? list2.size() : 0;
            } finally {
            }
        }
        return i == i3 && i2 == i4 && iy4.d(obj, obj2) && cls.equals(cls2) && iy4.c(piVar, piVar2) && ug3Var == ug3Var2 && size == size2;
    }

    @Override // defpackage.j94
    public void e(int i, int i2) throws Throwable {
        Object obj;
        this.c.c();
        Object obj2 = this.d;
        synchronized (obj2) {
            try {
                try {
                    boolean z = E;
                    if (z) {
                        u("Got onSizeReady in " + b02.a(this.u));
                    }
                    if (this.w != a.WAITING_FOR_SIZE) {
                        return;
                    }
                    a aVar = a.RUNNING;
                    this.w = aVar;
                    float fZ = this.k.z();
                    this.A = v(i, fZ);
                    this.B = v(i2, fZ);
                    if (z) {
                        u("finished setup for calling load in " + b02.a(this.u));
                    }
                    try {
                        try {
                            try {
                                this.t = this.v.f(this.h, this.i, this.k.y(), this.A, this.B, this.k.x(), this.j, this.n, this.k.l(), this.k.B(), this.k.M(), this.k.I(), this.k.r(), this.k.G(), this.k.D(), this.k.C(), this.k.q(), this, this.r);
                                if (this.w != aVar) {
                                    this.t = null;
                                }
                                if (z) {
                                    u("finished onSizeReady in " + b02.a(this.u));
                                }
                            } catch (Throwable th) {
                                th = th;
                                obj = obj2;
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            obj = obj2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        obj = obj2;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Throwable th5) {
                th = th5;
                obj = obj2;
            }
        }
    }

    @Override // defpackage.cs3
    public Object f() {
        this.c.c();
        return this.d;
    }

    public final void g() {
        if (this.C) {
            e04.a("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @Override // defpackage.yq3
    public boolean h() {
        boolean z;
        synchronized (this.d) {
            z = this.w == a.CLEARED;
        }
        return z;
    }

    @Override // defpackage.yq3
    public void i() {
        synchronized (this.d) {
            try {
                g();
                this.c.c();
                this.u = b02.b();
                Object obj = this.i;
                if (obj == null) {
                    if (iy4.u(this.l, this.m)) {
                        this.A = this.l;
                        this.B = this.m;
                    }
                    z(new ja1("Received null model"), q() == null ? 5 : 3);
                    return;
                }
                a aVar = this.w;
                a aVar2 = a.RUNNING;
                if (aVar == aVar2) {
                    throw new IllegalArgumentException("Cannot restart a running request");
                }
                if (aVar == a.COMPLETE) {
                    c(this.s, ba0.MEMORY_CACHE, false);
                    return;
                }
                o(obj);
                this.a = qa1.b("GlideRequest");
                a aVar3 = a.WAITING_FOR_SIZE;
                this.w = aVar3;
                if (iy4.u(this.l, this.m)) {
                    e(this.l, this.m);
                } else {
                    this.o.a(this);
                }
                a aVar4 = this.w;
                if ((aVar4 == aVar2 || aVar4 == aVar3) && l()) {
                    this.o.k(r());
                }
                if (E) {
                    u("finished run method in " + b02.a(this.u));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.yq3
    public boolean isRunning() {
        boolean z;
        synchronized (this.d) {
            try {
                a aVar = this.w;
                z = aVar == a.RUNNING || aVar == a.WAITING_FOR_SIZE;
            } finally {
            }
        }
        return z;
    }

    @Override // defpackage.yq3
    public boolean j() {
        boolean z;
        synchronized (this.d) {
            z = this.w == a.COMPLETE;
        }
        return z;
    }

    public final boolean k() {
        er3 er3Var = this.f;
        return er3Var == null || er3Var.e(this);
    }

    public final boolean l() {
        er3 er3Var = this.f;
        return er3Var == null || er3Var.f(this);
    }

    public final boolean m() {
        er3 er3Var = this.f;
        return er3Var == null || er3Var.g(this);
    }

    public final void n() {
        g();
        this.c.c();
        this.o.i(this);
        us0.d dVar = this.t;
        if (dVar != null) {
            dVar.a();
            this.t = null;
        }
    }

    public final void o(Object obj) {
        List<jr3> list = this.p;
        if (list == null) {
            return;
        }
        for (jr3 jr3Var : list) {
        }
    }

    public final Drawable p() {
        if (this.x == null) {
            Drawable drawableN = this.k.n();
            this.x = drawableN;
            if (drawableN == null && this.k.m() > 0) {
                this.x = t(this.k.m());
            }
        }
        return this.x;
    }

    @Override // defpackage.yq3
    public void pause() {
        synchronized (this.d) {
            try {
                if (isRunning()) {
                    clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Drawable q() {
        if (this.z == null) {
            Drawable drawableO = this.k.o();
            this.z = drawableO;
            if (drawableO == null && this.k.p() > 0) {
                this.z = t(this.k.p());
            }
        }
        return this.z;
    }

    public final Drawable r() {
        if (this.y == null) {
            Drawable drawableU = this.k.u();
            this.y = drawableU;
            if (drawableU == null && this.k.v() > 0) {
                this.y = t(this.k.v());
            }
        }
        return this.y;
    }

    public final boolean s() {
        er3 er3Var = this.f;
        return er3Var == null || !er3Var.getRoot().a();
    }

    public final Drawable t(int i) {
        return un0.a(this.g, i, this.k.A() != null ? this.k.A() : this.g.getTheme());
    }

    public String toString() {
        Object obj;
        Class cls;
        synchronized (this.d) {
            obj = this.i;
            cls = this.j;
        }
        return super.toString() + "[model=" + obj + ", transcodeClass=" + cls + "]";
    }

    public final void u(String str) {
        Log.v("GlideRequest", str + " this: " + this.b);
    }

    public final void w() {
        er3 er3Var = this.f;
        if (er3Var != null) {
            er3Var.b(this);
        }
    }

    public final void x() {
        er3 er3Var = this.f;
        if (er3Var != null) {
            er3Var.c(this);
        }
    }

    public final void z(ja1 ja1Var, int i) {
        boolean zC;
        this.c.c();
        synchronized (this.d) {
            try {
                ja1Var.k(this.D);
                int iH = this.h.h();
                if (iH <= i) {
                    Log.w("Glide", "Load failed for [" + this.i + "] with dimensions [" + this.A + "x" + this.B + "]", ja1Var);
                    if (iH <= 4) {
                        ja1Var.g("Glide");
                    }
                }
                this.t = null;
                this.w = a.FAILED;
                w();
                boolean z = true;
                this.C = true;
                try {
                    List list = this.p;
                    if (list != null) {
                        Iterator it = list.iterator();
                        zC = false;
                        while (it.hasNext()) {
                            zC |= ((jr3) it.next()).c(ja1Var, this.i, this.o, s());
                        }
                    } else {
                        zC = false;
                    }
                    jr3 jr3Var = this.e;
                    if (jr3Var == null || !jr3Var.c(ja1Var, this.i, this.o, s())) {
                        z = false;
                    }
                    if (!(zC | z)) {
                        B();
                    }
                    this.C = false;
                    qa1.f("GlideRequest", this.a);
                } catch (Throwable th) {
                    this.C = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
