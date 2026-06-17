package defpackage;

import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import defpackage.ag2;
import defpackage.cr1;
import defpackage.po0;
import defpackage.sy1;
import defpackage.wo0;
import defpackage.yv0;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ff0 implements po0 {
    public yv0.d A;
    public final List a;
    public final yv0 b;
    public final a c;
    public final b d;
    public final int e;
    public final boolean f;
    public final boolean g;
    public final HashMap h;
    public final c40 i;
    public final sy1 j;
    public final ie3 k;
    public final ag2 l;
    public final UUID m;
    public final Looper n;
    public final e o;
    public final Object p;
    public int q;
    public int r;
    public HandlerThread s;
    public c t;
    public f50 u;
    public po0.a v;
    public byte[] w;
    public byte[] x;
    public yv0.a y;
    public cr1.b z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void a(ff0 ff0Var);

        void b(Exception exc, boolean z);

        void c();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        void a(ff0 ff0Var, int i);

        void b(ff0 ff0Var, int i);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends Handler {
        public boolean a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(Looper looper) {
            super(looper);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean a(Message message, bg2 bg2Var) {
            d dVar = (d) message.obj;
            if (!dVar.b) {
                return false;
            }
            int i = dVar.e + 1;
            dVar.e = i;
            if (i > ff0.this.j.d(3)) {
                return false;
            }
            ty1 ty1Var = new ty1(dVar.a, bg2Var.f, bg2Var.g, bg2Var.h, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - dVar.c, bg2Var.i);
            long jA = ff0.this.j.a(new sy1.c(ty1Var, new oh2(3), bg2Var.getCause() instanceof IOException ? (IOException) bg2Var.getCause() : new f(bg2Var.getCause()), dVar.e));
            if (jA == -9223372036854775807L) {
                return false;
            }
            synchronized (ff0.this.p) {
                try {
                    if (ff0.this.z != null) {
                        ff0.this.z.c(ty1Var);
                    }
                } finally {
                }
            }
            synchronized (this) {
                try {
                    if (this.a) {
                        return false;
                    }
                    sendMessageDelayed(Message.obtain(message), jA);
                    return true;
                } finally {
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void b(int i, Object obj, boolean z) {
            obtainMessage(i, new d(ty1.b(), z, SystemClock.elapsedRealtime(), obj)).sendToTarget();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public synchronized void c() {
            removeCallbacksAndMessages(null);
            this.a = true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object objA;
            d dVar = (d) message.obj;
            try {
                int i = message.what;
                if (i == 1) {
                    objA = ff0.this.l.a(ff0.this.m, (yv0.d) dVar.d);
                } else {
                    if (i != 2) {
                        throw new RuntimeException();
                    }
                    ag2.b bVarB = ff0.this.l.b(ff0.this.m, (yv0.a) dVar.d);
                    synchronized (ff0.this.p) {
                        try {
                            if (ff0.this.z != null && bVarB.b != null) {
                                ff0.this.z.c(bVarB.b.a(dVar.a, SystemClock.elapsedRealtime() - dVar.c));
                            }
                        } finally {
                        }
                    }
                    objA = bVarB;
                }
            } catch (bg2 e) {
                boolean zA = a(message, e);
                objA = e;
                if (zA) {
                    return;
                }
            } catch (Exception e2) {
                xz1.j("DefaultDrmSession", "Key/provisioning request produced an unexpected exception. Not retrying.", e2);
                objA = e2;
            }
            ff0.this.j.c(dVar.a);
            synchronized (this) {
                try {
                    if (!this.a) {
                        ff0.this.o.obtainMessage(message.what, Pair.create(dVar.d, objA)).sendToTarget();
                    }
                } finally {
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d {
        public final long a;
        public final boolean b;
        public final long c;
        public final Object d;
        public int e;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(long j, boolean z, long j2, Object obj) {
            this.a = j;
            this.b = z;
            this.c = j2;
            this.d = obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class e extends Handler {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(Looper looper) {
            super(looper);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i = message.what;
            if (i == 1) {
                ff0.this.F(obj, obj2);
            } else {
                if (i != 2) {
                    return;
                }
                ff0.this.z(obj, obj2);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class f extends IOException {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public f(Throwable th) {
            super(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ff0(UUID uuid, yv0 yv0Var, a aVar, b bVar, List list, int i, boolean z, boolean z2, byte[] bArr, HashMap map, ag2 ag2Var, Looper looper, sy1 sy1Var, ie3 ie3Var) {
        if (i == 1 || i == 3) {
            gg3.q(bArr);
        }
        this.m = uuid;
        this.c = aVar;
        this.d = bVar;
        this.b = yv0Var;
        this.e = i;
        this.f = z;
        this.g = z2;
        if (bArr != null) {
            this.x = bArr;
            this.a = null;
        } else {
            this.a = Collections.unmodifiableList((List) gg3.q(list));
        }
        this.h = map;
        this.l = ag2Var;
        this.i = new c40();
        this.j = sy1Var;
        this.k = ie3Var;
        this.q = 2;
        this.n = looper;
        this.o = new e(looper);
        this.p = new Object();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void A(Throwable th, boolean z) {
        if ((th instanceof NotProvisionedException) || ap0.d(th)) {
            this.c.a(this);
        } else {
            y(th, z ? 1 : 2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void B() {
        if (this.e == 0 && this.q == 4) {
            fy4.l(this.w);
            u(false);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void C(int i) {
        if (i != 2) {
            return;
        }
        B();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void D() {
        if (G()) {
            u(true);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void E(Exception exc, boolean z) {
        y(exc, z ? 1 : 3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void F(Object obj, Object obj2) {
        if (obj == this.A) {
            if (this.q == 2 || x()) {
                this.A = null;
                if (obj2 instanceof Exception) {
                    this.c.b((Exception) obj2, false);
                    return;
                }
                try {
                    this.b.j(((ag2.b) obj2).a);
                    this.c.c();
                } catch (Exception e2) {
                    this.c.b(e2, true);
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean G() {
        if (x()) {
            return true;
        }
        try {
            byte[] bArrD = this.b.d();
            this.w = bArrD;
            this.b.m(bArrD, this.k);
            this.u = this.b.c(this.w);
            final int i = 3;
            this.q = 3;
            t(new g20() { // from class: af0
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.g20
                public final void accept(Object obj) {
                    ((wo0.a) obj).k(i);
                }
            });
            gg3.q(this.w);
            return true;
        } catch (NotProvisionedException unused) {
            this.c.a(this);
            return false;
        } catch (Exception e2) {
            e = e2;
            if (ap0.d(e)) {
                y(e, 1);
                return false;
            }
            this.c.a(this);
            return false;
        } catch (NoSuchMethodError e3) {
            e = e3;
            if (ap0.d(e)) {
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void H(byte[] bArr, int i, boolean z) {
        try {
            synchronized (this.p) {
                try {
                    cr1.b bVar = new cr1.b();
                    this.z = bVar;
                    List list = this.a;
                    if (list != null) {
                        bVar.e(list);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.y = this.b.k(bArr, this.a, i, this.h);
            ((c) fy4.l(this.t)).b(2, gg3.q(this.y), z);
        } catch (Exception | NoSuchMethodError e2) {
            A(e2, true);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void I() {
        this.A = this.b.b();
        ((c) fy4.l(this.t)).b(1, gg3.q(this.A), true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean J() {
        try {
            this.b.f(this.w, this.x);
            return true;
        } catch (Exception | NoSuchMethodError e2) {
            y(e2, 1);
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void K() {
        if (Thread.currentThread() != this.n.getThread()) {
            xz1.j("DefaultDrmSession", "DefaultDrmSession accessed on the wrong thread.\nCurrent thread: " + Thread.currentThread().getName() + "\nExpected thread: " + this.n.getThread().getName(), new IllegalStateException());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.po0
    public final UUID a() {
        K();
        return this.m;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.po0
    public boolean c() {
        K();
        return this.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.po0
    public void d(wo0.a aVar) {
        K();
        int i = this.r;
        if (i <= 0) {
            xz1.d("DefaultDrmSession", "release() called on a session that's already fully released.");
            return;
        }
        int i2 = i - 1;
        this.r = i2;
        if (i2 == 0) {
            this.q = 0;
            ((e) fy4.l(this.o)).removeCallbacksAndMessages(null);
            ((c) fy4.l(this.t)).c();
            this.t = null;
            ((HandlerThread) fy4.l(this.s)).quit();
            this.s = null;
            this.u = null;
            this.v = null;
            this.y = null;
            synchronized (this.p) {
                this.z = null;
            }
            this.A = null;
            byte[] bArr = this.w;
            if (bArr != null) {
                this.b.g(bArr);
                this.w = null;
            }
        }
        if (aVar != null) {
            this.i.c(aVar);
            if (this.i.t(aVar) == 0) {
                aVar.m();
            }
        }
        this.d.b(this, this.r);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.po0
    public Map e() {
        K();
        byte[] bArr = this.w;
        if (bArr == null) {
            return null;
        }
        return this.b.a(bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.po0
    public void f(wo0.a aVar) {
        K();
        if (this.r < 0) {
            xz1.d("DefaultDrmSession", "Session reference count less than zero: " + this.r);
            this.r = 0;
        }
        if (aVar != null) {
            this.i.b(aVar);
        }
        int i = this.r + 1;
        this.r = i;
        if (i == 1) {
            gg3.v(this.q == 2);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.s = handlerThread;
            handlerThread.start();
            this.t = new c(this.s.getLooper());
            if (G()) {
                u(true);
            }
        } else if (aVar != null && x() && this.i.t(aVar) == 1) {
            aVar.k(this.q);
        }
        this.d.a(this, this.r);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.po0
    public boolean g(String str) {
        K();
        return this.b.e((byte[]) gg3.q(this.w), str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.po0
    public final po0.a getError() {
        K();
        if (this.q == 1) {
            return this.v;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.po0
    public final int getState() {
        K();
        return this.q;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.po0
    public final f50 h() {
        K();
        return this.u;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void t(g20 g20Var) {
        Iterator it = this.i.i().iterator();
        while (it.hasNext()) {
            g20Var.accept((wo0.a) it.next());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void u(boolean z) {
        if (this.g) {
            return;
        }
        byte[] bArr = (byte[]) fy4.l(this.w);
        int i = this.e;
        if (i != 0 && i != 1) {
            if (i == 2) {
                if (this.x == null || J()) {
                    H(bArr, 2, z);
                    return;
                }
                return;
            }
            if (i != 3) {
                return;
            }
            gg3.q(this.x);
            gg3.q(this.w);
            H(this.x, 3, z);
            return;
        }
        if (this.x == null) {
            H(bArr, 1, z);
            return;
        }
        if (this.q == 4 || J()) {
            long jV = v();
            if (this.e == 0 && jV <= 60) {
                xz1.b("DefaultDrmSession", "Offline license has expired or will expire soon. Remaining seconds: " + jV);
                H(bArr, 2, z);
                return;
            }
            if (jV <= 0) {
                y(new ir1(), 2);
            } else {
                this.q = 4;
                t(new g20() { // from class: ef0
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // defpackage.g20
                    public final void accept(Object obj) {
                        ((wo0.a) obj).j();
                    }
                });
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long v() {
        if (!kn.e.equals(this.m)) {
            return Long.MAX_VALUE;
        }
        Pair pair = (Pair) gg3.q(i95.b(this));
        return Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean w(byte[] bArr) {
        K();
        return Arrays.equals(this.w, bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean x() {
        int i = this.q;
        return i == 3 || i == 4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void y(final Throwable th, int i) {
        this.v = new po0.a(th, ap0.b(th, i));
        xz1.e("DefaultDrmSession", "DRM session error", th);
        if (th instanceof Exception) {
            t(new g20() { // from class: df0
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.g20
                public final void accept(Object obj) {
                    ((wo0.a) obj).l((Exception) th);
                }
            });
        } else if (!(th instanceof Error)) {
            l02.a("Unexpected Throwable subclass", th);
            return;
        } else if (!ap0.e(th) && !ap0.d(th)) {
            throw ((Error) th);
        }
        if (this.q != 4) {
            this.q = 1;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void z(Object obj, Object obj2) {
        final cr1 cr1VarD;
        if (obj == this.y && x()) {
            this.y = null;
            synchronized (this.p) {
                cr1VarD = ((cr1.b) gg3.q(this.z)).d();
                this.z = null;
            }
            if ((obj2 instanceof Exception) || (obj2 instanceof NoSuchMethodError)) {
                A((Throwable) obj2, false);
                return;
            }
            try {
                byte[] bArr = ((ag2.b) obj2).a;
                int i = this.e;
                yv0 yv0Var = this.b;
                if (i == 3) {
                    yv0Var.h((byte[]) fy4.l(this.x), bArr);
                    t(new g20() { // from class: bf0
                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // defpackage.g20
                        public final void accept(Object obj3) {
                            ((wo0.a) obj3).i();
                        }
                    });
                    return;
                }
                byte[] bArrH = yv0Var.h(this.w, bArr);
                int i2 = this.e;
                if ((i2 == 2 || (i2 == 0 && this.x != null)) && bArrH != null && bArrH.length != 0) {
                    this.x = bArrH;
                }
                this.q = 4;
                t(new g20() { // from class: cf0
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // defpackage.g20
                    public final void accept(Object obj3) {
                        ((wo0.a) obj3).h(cr1VarD);
                    }
                });
            } catch (Exception e2) {
                e = e2;
                A(e, true);
            } catch (NoSuchMethodError e3) {
                e = e3;
                A(e, true);
            }
        }
    }
}
