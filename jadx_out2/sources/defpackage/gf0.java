package defpackage;

import android.media.ResourceBusyException;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import defpackage.ff0;
import defpackage.gf0;
import defpackage.oo0;
import defpackage.po0;
import defpackage.wo0;
import defpackage.xo0;
import defpackage.yv0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class gf0 implements xo0 {
    public final UUID b;
    public final yv0.c c;
    public final ag2 d;
    public final HashMap e;
    public final boolean f;
    public final int[] g;
    public final boolean h;
    public final g i;
    public final sy1 j;
    public final h k;
    public final long l;
    public final List m;
    public final Set n;
    public final Set o;
    public int p;
    public yv0 q;
    public ff0 r;
    public ff0 s;
    public Looper t;
    public Handler u;
    public int v;
    public byte[] w;
    public ie3 x;
    public volatile d y;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public boolean d;
        public final HashMap a = new HashMap();
        public UUID b = kn.e;
        public yv0.c c = z71.d;
        public int[] e = new int[0];
        public boolean f = true;
        public sy1 g = new ig0();
        public long h = 300000;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public gf0 a(ag2 ag2Var) {
            return new gf0(this.b, this.c, ag2Var, this.a, this.d, this.e, this.f, this.g, this.h);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b b(sy1 sy1Var) {
            this.g = (sy1) gg3.q(sy1Var);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b c(boolean z) {
            this.d = z;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b d(boolean z) {
            this.f = z;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b e(int... iArr) {
            for (int i : iArr) {
                boolean z = true;
                if (i != 2 && i != 1) {
                    z = false;
                }
                gg3.d(z);
            }
            this.e = (int[]) iArr.clone();
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b f(UUID uuid, yv0.c cVar) {
            this.b = (UUID) gg3.q(uuid);
            this.c = (yv0.c) gg3.q(cVar);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c implements yv0.b {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // yv0.b
        public void a(yv0 yv0Var, byte[] bArr, int i, int i2, byte[] bArr2) {
            ((d) gg3.q(gf0.this.y)).obtainMessage(i, bArr).sendToTarget();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d extends Handler {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(Looper looper) {
            super(looper);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null) {
                return;
            }
            for (ff0 ff0Var : gf0.this.m) {
                if (ff0Var.w(bArr)) {
                    ff0Var.C(message.what);
                    return;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e extends Exception {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(UUID uuid) {
            super("Media does not support uuid: " + uuid);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class f implements xo0.b {
        public final wo0.a b;
        public po0 c;
        public boolean d;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public f(wo0.a aVar) {
            this.b = aVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ void b(f fVar, t41 t41Var) {
            if (gf0.this.p == 0 || fVar.d) {
                return;
            }
            gf0 gf0Var = gf0.this;
            fVar.c = gf0Var.s((Looper) gg3.q(gf0Var.t), fVar.b, t41Var, false);
            gf0.this.n.add(fVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ void c(f fVar) {
            if (fVar.d) {
                return;
            }
            po0 po0Var = fVar.c;
            if (po0Var != null) {
                po0Var.d(fVar.b);
            }
            gf0.this.n.remove(fVar);
            fVar.d = true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void d(final t41 t41Var) {
            ((Handler) gg3.q(gf0.this.u)).post(new Runnable() { // from class: hf0
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    gf0.f.b(this.f, t41Var);
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // xo0.b
        public void release() {
            fy4.o1((Handler) gg3.q(gf0.this.u), new Runnable() { // from class: if0
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    gf0.f.c(this.f);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class g implements ff0.a {
        public final Set a = new HashSet();
        public ff0 b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public g() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ff0.a
        public void a(ff0 ff0Var) {
            this.a.add(ff0Var);
            if (this.b != null) {
                return;
            }
            this.b = ff0Var;
            ff0Var.I();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ff0.a
        public void b(Exception exc, boolean z) {
            this.b = null;
            xi1 xi1VarP = xi1.p(this.a);
            this.a.clear();
            pw4 it = xi1VarP.iterator();
            while (it.hasNext()) {
                ((ff0) it.next()).E(exc, z);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ff0.a
        public void c() {
            this.b = null;
            xi1 xi1VarP = xi1.p(this.a);
            this.a.clear();
            pw4 it = xi1VarP.iterator();
            while (it.hasNext()) {
                ((ff0) it.next()).D();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void d(ff0 ff0Var) {
            this.a.remove(ff0Var);
            if (this.b == ff0Var) {
                this.b = null;
                if (this.a.isEmpty()) {
                    return;
                }
                ff0 ff0Var2 = (ff0) this.a.iterator().next();
                this.b = ff0Var2;
                ff0Var2.I();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class h implements ff0.b {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public h() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ff0.b
        public void a(ff0 ff0Var, int i) {
            if (gf0.this.l != -9223372036854775807L) {
                gf0.this.o.remove(ff0Var);
                ((Handler) gg3.q(gf0.this.u)).removeCallbacksAndMessages(ff0Var);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ff0.b
        public void b(final ff0 ff0Var, int i) {
            if (i == 1 && gf0.this.p > 0 && gf0.this.l != -9223372036854775807L) {
                gf0.this.o.add(ff0Var);
                ((Handler) gg3.q(gf0.this.u)).postAtTime(new Runnable() { // from class: jf0
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        ff0Var.d(null);
                    }
                }, ff0Var, SystemClock.uptimeMillis() + gf0.this.l);
            } else if (i == 0) {
                gf0.this.m.remove(ff0Var);
                if (gf0.this.r == ff0Var) {
                    gf0.this.r = null;
                }
                if (gf0.this.s == ff0Var) {
                    gf0.this.s = null;
                }
                gf0.this.i.d(ff0Var);
                if (gf0.this.l != -9223372036854775807L) {
                    ((Handler) gg3.q(gf0.this.u)).removeCallbacksAndMessages(ff0Var);
                    gf0.this.o.remove(ff0Var);
                }
            }
            gf0.this.B();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public gf0(UUID uuid, yv0.c cVar, ag2 ag2Var, HashMap map, boolean z, int[] iArr, boolean z2, sy1 sy1Var, long j) {
        gg3.q(uuid);
        gg3.e(!kn.c.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.b = uuid;
        this.c = cVar;
        this.d = ag2Var;
        this.e = map;
        this.f = z;
        this.g = iArr;
        this.h = z2;
        this.j = sy1Var;
        this.i = new g();
        this.k = new h();
        this.v = 0;
        this.m = new ArrayList();
        this.n = m24.g();
        this.o = m24.g();
        this.l = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean t(po0 po0Var) {
        if (po0Var.getState() != 1) {
            return false;
        }
        Throwable cause = ((po0.a) gg3.q(po0Var.getError())).getCause();
        return (cause instanceof ResourceBusyException) || ap0.e(cause);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List x(oo0 oo0Var, UUID uuid, boolean z) {
        ArrayList arrayList = new ArrayList(oo0Var.i);
        for (int i = 0; i < oo0Var.i; i++) {
            oo0.b bVarV = oo0Var.v(i);
            if ((bVarV.u(uuid) || (kn.d.equals(uuid) && bVarV.u(kn.c))) && (bVarV.j != null || z)) {
                arrayList.add(bVarV);
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void A(Looper looper) {
        if (this.y == null) {
            this.y = new d(looper);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void B() {
        if (this.q != null && this.p == 0 && this.m.isEmpty() && this.n.isEmpty()) {
            ((yv0) gg3.q(this.q)).release();
            this.q = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void C() {
        pw4 it = dj1.p(this.o).iterator();
        while (it.hasNext()) {
            ((po0) it.next()).d(null);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void D() {
        pw4 it = dj1.p(this.n).iterator();
        while (it.hasNext()) {
            ((f) it.next()).release();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void E(int i, byte[] bArr) {
        gg3.v(this.m.isEmpty());
        if (i == 1 || i == 3) {
            gg3.q(bArr);
        }
        this.v = i;
        this.w = bArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void F(po0 po0Var, wo0.a aVar) {
        po0Var.d(aVar);
        if (this.l != -9223372036854775807L) {
            po0Var.d(null);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void G(boolean z) {
        if (z && this.t == null) {
            xz1.j("DefaultDrmSessionMgr", "DefaultDrmSessionManager accessed before setPlayer(), possibly on the wrong thread.", new IllegalStateException());
            return;
        }
        if (Thread.currentThread() != ((Looper) gg3.q(this.t)).getThread()) {
            xz1.j("DefaultDrmSessionMgr", "DefaultDrmSessionManager accessed on the wrong thread.\nCurrent thread: " + Thread.currentThread().getName() + "\nExpected thread: " + this.t.getThread().getName(), new IllegalStateException());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xo0
    public po0 a(wo0.a aVar, t41 t41Var) {
        G(false);
        gg3.v(this.p > 0);
        gg3.q(this.t);
        return s(this.t, aVar, t41Var, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xo0
    public xo0.b b(wo0.a aVar, t41 t41Var) {
        gg3.v(this.p > 0);
        gg3.q(this.t);
        f fVar = new f(aVar);
        fVar.d(t41Var);
        return fVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xo0
    public void c(Looper looper, ie3 ie3Var) {
        y(looper);
        this.x = ie3Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xo0
    public int d(t41 t41Var) {
        G(false);
        int iL = ((yv0) gg3.q(this.q)).l();
        oo0 oo0Var = t41Var.t;
        if (oo0Var == null) {
            if (fy4.Y0(this.g, nt2.k(t41Var.p)) == -1) {
                return 0;
            }
        } else if (!u(oo0Var)) {
            return 1;
        }
        return iL;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xo0
    public final void prepare() {
        G(true);
        int i = this.p;
        this.p = i + 1;
        if (i != 0) {
            return;
        }
        if (this.q == null) {
            yv0 yv0VarA = this.c.a(this.b);
            this.q = yv0VarA;
            yv0VarA.i(new c());
        } else if (this.l != -9223372036854775807L) {
            for (int i2 = 0; i2 < this.m.size(); i2++) {
                ((ff0) this.m.get(i2)).f(null);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xo0
    public final void release() {
        G(true);
        int i = this.p - 1;
        this.p = i;
        if (i != 0) {
            return;
        }
        if (this.l != -9223372036854775807L) {
            ArrayList arrayList = new ArrayList(this.m);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                ((ff0) arrayList.get(i2)).d(null);
            }
        }
        D();
        B();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    public final po0 s(Looper looper, wo0.a aVar, t41 t41Var, boolean z) {
        List listX;
        A(looper);
        oo0 oo0Var = t41Var.t;
        if (oo0Var == null) {
            return z(nt2.k(t41Var.p), z);
        }
        ff0 ff0Var = null;
        Object[] objArr = 0;
        if (this.w == null) {
            listX = x((oo0) gg3.q(oo0Var), this.b, false);
            if (listX.isEmpty()) {
                e eVar = new e(this.b);
                xz1.e("DefaultDrmSessionMgr", "DRM error", eVar);
                if (aVar != null) {
                    aVar.l(eVar);
                }
                return new ou0(new po0.a(eVar, 6003));
            }
        } else {
            listX = null;
        }
        if (this.f) {
            Iterator it = this.m.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ff0 ff0Var2 = (ff0) it.next();
                if (Objects.equals(ff0Var2.a, listX)) {
                    ff0Var = ff0Var2;
                    break;
                }
            }
        } else {
            ff0Var = this.s;
        }
        if (ff0Var != null) {
            ff0Var.f(aVar);
            return ff0Var;
        }
        ff0 ff0VarW = w(listX, false, aVar, z);
        if (!this.f) {
            this.s = ff0VarW;
        }
        this.m.add(ff0VarW);
        return ff0VarW;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean u(oo0 oo0Var) {
        if (this.w != null) {
            return true;
        }
        if (x(oo0Var, this.b, true).isEmpty()) {
            if (oo0Var.i != 1 || !oo0Var.v(0).u(kn.c)) {
                return false;
            }
            xz1.i("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.b);
        }
        String str = oo0Var.h;
        if (str == null || "cenc".equals(str)) {
            return true;
        }
        return "cbcs".equals(str) ? Build.VERSION.SDK_INT >= 25 : ("cbc1".equals(str) || "cens".equals(str)) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ff0 v(List list, boolean z, wo0.a aVar) {
        gg3.q(this.q);
        ff0 ff0Var = new ff0(this.b, this.q, this.i, this.k, list, this.v, this.h | z, z, this.w, this.e, this.d, (Looper) gg3.q(this.t), this.j, (ie3) gg3.q(this.x));
        ff0Var.f(aVar);
        if (this.l != -9223372036854775807L) {
            ff0Var.f(null);
        }
        return ff0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ff0 w(List list, boolean z, wo0.a aVar, boolean z2) {
        ff0 ff0VarV = v(list, z, aVar);
        if (t(ff0VarV) && !this.o.isEmpty()) {
            C();
            F(ff0VarV, aVar);
            ff0VarV = v(list, z, aVar);
        }
        if (!t(ff0VarV) || !z2 || this.n.isEmpty()) {
            return ff0VarV;
        }
        D();
        if (!this.o.isEmpty()) {
            C();
        }
        F(ff0VarV, aVar);
        return v(list, z, aVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final synchronized void y(Looper looper) {
        try {
            Looper looper2 = this.t;
            if (looper2 == null) {
                this.t = looper;
                this.u = new Handler(looper);
            } else {
                gg3.v(looper2 == looper);
                gg3.q(this.u);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final po0 z(int i, boolean z) {
        yv0 yv0Var = (yv0) gg3.q(this.q);
        if ((yv0Var.l() == 2 && v71.d) || fy4.Y0(this.g, i) == -1 || yv0Var.l() == 1) {
            return null;
        }
        ff0 ff0Var = this.r;
        if (ff0Var == null) {
            ff0 ff0VarW = w(xi1.u(), true, null, z);
            this.m.add(ff0VarW);
            this.r = ff0VarW;
        } else {
            ff0Var.f(null);
        }
        return this.r;
    }
}
