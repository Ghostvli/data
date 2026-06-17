package defpackage;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import defpackage.dh1;
import defpackage.gh1;
import defpackage.nh1;
import defpackage.t80;
import tv.cjump.jni.NativeBitmapFactory;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class mo extends rn0 {
    public int v;
    public b w;
    public b90 x;
    public final Object y;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Runnable {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            mo.this.e.d();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements ah1 {
        public HandlerThread a;
        public e90 b = new e90();
        public lo0 c;
        public lf3 d;
        public int e;
        public int f;
        public int g;
        public f h;
        public boolean i;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a extends dh1.c {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a() {
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: a(Ljava/lang/Object;)I */
            @Override // dh1.b
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public int a(ih ihVar) {
                b.this.t(true, ihVar, null);
                return 0;
            }
        }

        /* JADX INFO: renamed from: mo$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class C0100b extends dh1.c {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public C0100b() {
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: a(Ljava/lang/Object;)I */
            @Override // dh1.b
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public int a(ih ihVar) {
                if (!ihVar.s()) {
                    return 0;
                }
                b.this.t(true, ihVar, null);
                return 2;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class c extends dh1.c {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public c() {
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: a(Ljava/lang/Object;)I */
            @Override // dh1.b
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public int a(ih ihVar) {
                if (!ihVar.w()) {
                    return 1;
                }
                hh1 hh1Var = ihVar.x;
                if (mo.this.a.F.c == -1 && hh1Var != null && !hh1Var.e() && hh1Var.size() / mo.this.v < mo.this.a.F.d) {
                    return 0;
                }
                if (!b.this.i) {
                    synchronized (mo.this.y) {
                        try {
                            try {
                                mo.this.y.wait(30L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                                return 1;
                            }
                        } finally {
                        }
                    }
                }
                b.this.t(false, ihVar, null);
                return 2;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class d extends dh1.b {
            public int a = 0;
            public ih b;
            public final /* synthetic */ int c;
            public final /* synthetic */ ih d;
            public final /* synthetic */ boolean e;
            public final /* synthetic */ int f;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public d(int i, ih ihVar, boolean z, int i2) {
                this.c = i;
                this.d = ihVar;
                this.e = z;
                this.f = i2;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: a(Ljava/lang/Object;)I */
            @Override // dh1.b
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public int a(ih ihVar) {
                int i = this.a;
                this.a = i + 1;
                if (i >= this.c) {
                    return 1;
                }
                hh1 hh1VarE = ihVar.e();
                if (hh1VarE != null && hh1VarE.get() != null) {
                    float f = ihVar.o;
                    ih ihVar2 = this.d;
                    if (f == ihVar2.o && ihVar.p == ihVar2.p && ihVar.j == ihVar2.j && ihVar.l == ihVar2.l && ihVar.f == ihVar2.f && ihVar.c.equals(ihVar2.c) && ihVar.e == this.d.e) {
                        this.b = ihVar;
                        return 1;
                    }
                    if (this.e) {
                        return 0;
                    }
                    if (!ihVar.w()) {
                        return 1;
                    }
                    if (hh1VarE.e()) {
                        return 0;
                    }
                    float f2 = hh1VarE.f() - this.d.o;
                    float fD = hh1VarE.d() - this.d.p;
                    if (f2 >= 0.0f) {
                        int i2 = this.f;
                        if (f2 <= i2 && fD >= 0.0f && fD <= i2) {
                            this.b = ihVar;
                            return 1;
                        }
                    }
                }
                return 0;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: d()Ljava/lang/Object; */
            @Override // dh1.b
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public ih d() {
                return this.b;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class e extends dh1.c {
            public final /* synthetic */ int a;
            public final /* synthetic */ boolean b;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public e(int i, boolean z) {
                this.a = i;
                this.b = z;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: a(Ljava/lang/Object;)I */
            @Override // dh1.b
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public int a(ih ihVar) {
                if (b.this.i || b.this.f + this.a <= b.this.e) {
                    return 1;
                }
                if (!ihVar.w() && !ihVar.o()) {
                    return this.b ? 1 : 0;
                }
                b.this.t(false, ihVar, null);
                return 2;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class f extends Handler {
            public boolean a;
            public boolean b;
            public boolean c;
            public boolean d;

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public class a extends dh1.c {
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public a() {
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                /* JADX DEBUG: Method merged with bridge method: a(Ljava/lang/Object;)I */
                @Override // dh1.b
                /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
                public int a(ih ihVar) {
                    ih ihVar2;
                    if (f.this.a || f.this.d) {
                        return 1;
                    }
                    if (ihVar.n()) {
                        ihVar2 = ihVar;
                    } else {
                        t80 t80Var = mo.this.a;
                        ihVar2 = ihVar;
                        t80Var.D.b(ihVar2, 0, 0, null, true, t80Var);
                    }
                    if (ihVar2.o()) {
                        return 0;
                    }
                    if (!ihVar2.q()) {
                        ihVar2.z(mo.this.b, true);
                    }
                    if (!ihVar2.u()) {
                        ihVar2.A(mo.this.b, true);
                    }
                    return 0;
                }
            }

            /* JADX INFO: renamed from: mo$b$f$b, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public class C0101b extends dh1.c {
                public int a = 0;
                public int b = 0;
                public final /* synthetic */ ih c;
                public final /* synthetic */ boolean d;
                public final /* synthetic */ int e;
                public final /* synthetic */ long f;
                public final /* synthetic */ long g;
                public final /* synthetic */ long h;

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public C0101b(ih ihVar, boolean z, int i, long j, long j2, long j3) {
                    this.c = ihVar;
                    this.d = z;
                    this.e = i;
                    this.f = j;
                    this.g = j2;
                    this.h = j3;
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                /* JADX DEBUG: Method merged with bridge method: a(Ljava/lang/Object;)I */
                @Override // dh1.b
                /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
                public int a(ih ihVar) {
                    ih ihVar2;
                    if (f.this.a || f.this.d || this.c.b() < mo.this.g.a) {
                        return 1;
                    }
                    hh1 hh1VarE = ihVar.e();
                    if (hh1VarE != null && hh1VarE.get() != null) {
                        return 0;
                    }
                    if (!this.d && (ihVar.w() || !ihVar.s())) {
                        return 0;
                    }
                    if (ihVar.n()) {
                        ihVar2 = ihVar;
                    } else {
                        t80 t80Var = mo.this.a;
                        ihVar2 = ihVar;
                        t80Var.D.b(ihVar2, this.a, this.e, null, true, t80Var);
                    }
                    if (ihVar2.n == 0 && ihVar2.o()) {
                        return 0;
                    }
                    if (ihVar2.m() == 1) {
                        int iB = (int) ((ihVar2.b() - this.f) / mo.this.a.E.f);
                        if (this.b == iB) {
                            this.a++;
                        } else {
                            this.a = 0;
                            this.b = iB;
                        }
                    }
                    if (!this.d && !f.this.b) {
                        try {
                            synchronized (mo.this.y) {
                                mo.this.y.wait(this.g);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            return 1;
                        }
                    }
                    f.this.g(ihVar2, false);
                    if (!this.d) {
                        long jB = lk4.b() - this.h;
                        b bVar = b.this;
                        y80 y80Var = mo.this.a.E;
                        if (jB >= ((long) bVar.g) * 3800) {
                            return 1;
                        }
                    }
                    return 0;
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public f(Looper looper) {
                super(looper);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public final void e(ih ihVar) {
                if (ihVar.w()) {
                    return;
                }
                if (ihVar.b() <= mo.this.x.a + mo.this.a.E.f || ihVar.y) {
                    if (ihVar.n == 0 && ihVar.o()) {
                        return;
                    }
                    hh1 hh1VarE = ihVar.e();
                    if (hh1VarE == null || hh1VarE.get() == null) {
                        g(ihVar, true);
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public void f() {
                sendEmptyMessage(1);
                sendEmptyMessageDelayed(4, mo.this.a.E.f);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public final byte g(ih ihVar, boolean z) {
                jo0 jo0Var;
                if (!ihVar.q()) {
                    ihVar.z(mo.this.b, true);
                }
                jo0 jo0Var2 = null;
                try {
                    b bVar = b.this;
                    ih ihVarW = bVar.w(ihVar, true, mo.this.a.F.f);
                    jo0Var = ihVarW != null ? (jo0) ihVarW.x : null;
                } catch (Exception unused) {
                } catch (OutOfMemoryError unused2) {
                }
                try {
                    if (jo0Var != null) {
                        jo0Var.l();
                        ihVar.x = jo0Var;
                        mo.this.w.B(ihVar, 0, z);
                        return (byte) 0;
                    }
                    b bVar2 = b.this;
                    ih ihVarW2 = bVar2.w(ihVar, false, mo.this.a.F.g);
                    if (ihVarW2 != null) {
                        jo0Var = (jo0) ihVarW2.x;
                    }
                    if (jo0Var != null) {
                        ihVarW2.x = null;
                        mo moVar = mo.this;
                        ihVar.x = d90.a(ihVar, moVar.b, jo0Var, moVar.a.F.a);
                        mo.this.w.B(ihVar, 0, z);
                        return (byte) 0;
                    }
                    int iF = d90.f((int) ihVar.o, (int) ihVar.p, mo.this.a.F.a / 8);
                    if (iF * 2 > mo.this.v) {
                        return (byte) 1;
                    }
                    if (!z && b.this.f + iF > b.this.e) {
                        mo.this.w.q(iF, false);
                        return (byte) 1;
                    }
                    jo0 jo0Var3 = (jo0) b.this.d.a();
                    mo moVar2 = mo.this;
                    jo0 jo0VarA = d90.a(ihVar, moVar2.b, jo0Var3, moVar2.a.F.a);
                    ihVar.x = jo0VarA;
                    boolean zB = mo.this.w.B(ihVar, b.this.I(ihVar), z);
                    if (!zB) {
                        n(ihVar, jo0VarA);
                    }
                    return !zB ? (byte) 1 : (byte) 0;
                } catch (Exception unused3) {
                    jo0Var2 = jo0Var;
                    n(ihVar, jo0Var2);
                    return (byte) 1;
                } catch (OutOfMemoryError unused4) {
                    jo0Var2 = jo0Var;
                    n(ihVar, jo0Var2);
                    return (byte) 1;
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public boolean h(ih ihVar) {
                jo0 jo0VarA;
                if (!ihVar.q()) {
                    ihVar.z(mo.this.b, true);
                }
                try {
                    jo0VarA = (jo0) b.this.d.a();
                } catch (Exception unused) {
                    jo0VarA = null;
                } catch (OutOfMemoryError unused2) {
                    jo0VarA = null;
                }
                try {
                    mo moVar = mo.this;
                    jo0VarA = d90.a(ihVar, moVar.b, jo0VarA, moVar.a.F.a);
                    ihVar.x = jo0VarA;
                    return true;
                } catch (Exception unused3) {
                    if (jo0VarA != null) {
                        b.this.d.b(jo0VarA);
                    }
                    ihVar.x = null;
                    return false;
                } catch (OutOfMemoryError unused4) {
                    if (jo0VarA != null) {
                        b.this.d.b(jo0VarA);
                    }
                    ihVar.x = null;
                    return false;
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX WARN: Removed duplicated region for block: B:46:0x011c  */
            @Override // android.os.Handler
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void handleMessage(Message message) {
                int i = message.what;
                switch (i) {
                    case 1:
                        b.this.v();
                        for (int i2 = 0; i2 < 300; i2++) {
                            b.this.d.b(new jo0());
                        }
                        break;
                    case 2:
                        e((ih) message.obj);
                        return;
                    case 3:
                        removeMessages(3);
                        mo moVar = mo.this;
                        boolean z = !(moVar.e == null || moVar.l) || this.c;
                        m(z);
                        if (z) {
                            this.c = false;
                        }
                        mo moVar2 = mo.this;
                        gh1.a aVar = moVar2.e;
                        if (aVar == null || moVar2.l) {
                            return;
                        }
                        aVar.b();
                        mo.this.l = true;
                        return;
                    case 4:
                        b.this.r();
                        return;
                    case 5:
                        Long l = (Long) message.obj;
                        if (l != null) {
                            long jLongValue = l.longValue();
                            long j = mo.this.x.a;
                            mo.this.x.c(jLongValue);
                            this.c = true;
                            long jX = b.this.x();
                            if (jLongValue <= j) {
                                long j2 = jX - jLongValue;
                                b bVar = b.this;
                                if (j2 > mo.this.a.E.f) {
                                    b.this.v();
                                } else {
                                    bVar.r();
                                }
                            }
                            m(true);
                            q();
                            return;
                        }
                        return;
                    case 6:
                        removeCallbacksAndMessages(null);
                        this.a = true;
                        b.this.u();
                        b.this.p();
                        getLooper().quit();
                        return;
                    case 7:
                        b.this.u();
                        b90 b90Var = mo.this.x;
                        mo moVar3 = mo.this;
                        b90Var.c(moVar3.g.a - moVar3.a.E.f);
                        this.c = true;
                        return;
                    case 8:
                        b.this.v();
                        mo.this.x.c(mo.this.g.a);
                        return;
                    case 9:
                        b.this.v();
                        mo.this.x.c(mo.this.g.a);
                        mo.this.l();
                        return;
                    default:
                        switch (i) {
                            case 17:
                                ih ihVar = (ih) message.obj;
                                if (ihVar != null) {
                                    hh1 hh1VarE = ihVar.e();
                                    if ((ihVar.I & 1) == 0 && hh1VarE != null && hh1VarE.get() != null && !hh1VarE.e()) {
                                        mo moVar4 = mo.this;
                                        ihVar.x = d90.a(ihVar, moVar4.b, (jo0) ihVar.x, moVar4.a.F.a);
                                        b.this.B(ihVar, 0, true);
                                    } else if (ihVar.y) {
                                        b.this.o(ihVar);
                                        h(ihVar);
                                    } else {
                                        if (hh1VarE != null && hh1VarE.e()) {
                                            hh1VarE.destroy();
                                        }
                                        b.this.t(true, ihVar, null);
                                        e(ihVar);
                                    }
                                }
                                break;
                            case 18:
                                this.d = false;
                                break;
                        }
                        return;
                }
                long jI = i();
                if (jI <= 0) {
                    jI = mo.this.a.E.f / 2;
                }
                sendEmptyMessageDelayed(16, jI);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public final long i() {
                long j = mo.this.x.a;
                b bVar = b.this;
                mo moVar = mo.this;
                long j2 = moVar.g.a;
                t80 t80Var = moVar.a;
                if (j <= j2 - t80Var.E.f) {
                    if (t80Var.F.c != -1) {
                        bVar.v();
                    }
                    mo.this.x.c(mo.this.g.a);
                    sendEmptyMessage(3);
                    return 0L;
                }
                float fY = bVar.y();
                ih ihVarFirst = b.this.b.first();
                long jB = ihVarFirst != null ? ihVarFirst.b() - mo.this.g.a : 0L;
                mo moVar2 = mo.this;
                long j3 = moVar2.a.E.f;
                long j4 = 2 * j3;
                if (fY < 0.6f && jB > j3) {
                    moVar2.x.c(mo.this.g.a);
                    removeMessages(3);
                    sendEmptyMessage(3);
                    return 0L;
                }
                if (fY > 0.4f && jB < (-j4)) {
                    removeMessages(4);
                    sendEmptyMessage(4);
                    return 0L;
                }
                if (fY >= 0.9f) {
                    return 0L;
                }
                long j5 = moVar2.x.a - mo.this.g.a;
                if (ihVarFirst != null && ihVarFirst.w()) {
                    mo moVar3 = mo.this;
                    if (j5 < (-moVar3.a.E.f)) {
                        moVar3.x.c(mo.this.g.a);
                        sendEmptyMessage(8);
                        sendEmptyMessage(3);
                        return 0L;
                    }
                }
                if (j5 > j4) {
                    return 0L;
                }
                removeMessages(3);
                sendEmptyMessage(3);
                return 0L;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public void j(boolean z) {
                this.b = !z;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public void k() {
                this.a = true;
                sendEmptyMessage(6);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public final void l() {
                dh1 dh1VarA;
                try {
                    mo moVar = mo.this;
                    long j = moVar.g.a;
                    long j2 = moVar.a.E.f;
                    dh1VarA = moVar.c.a(j - j2, (2 * j2) + j);
                } catch (Exception unused) {
                    dh1VarA = null;
                }
                if (dh1VarA == null || dh1VarA.isEmpty()) {
                    return;
                }
                dh1VarA.e(new a());
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public final long m(boolean z) {
                long j;
                l();
                long j2 = 30;
                long j3 = mo.this.x.a - 30;
                b bVar = b.this;
                long j4 = j3 + (mo.this.a.E.f * ((long) bVar.g));
                if (j4 < mo.this.g.a) {
                    return 0L;
                }
                long jB = lk4.b();
                int i = 0;
                dh1 dh1VarA = null;
                boolean z2 = false;
                while (true) {
                    j = j2;
                    try {
                        dh1VarA = mo.this.c.a(j3, j4);
                    } catch (Exception unused) {
                        lk4.a(10L);
                        z2 = true;
                    }
                    i++;
                    if (i >= 3 || dh1VarA != null || !z2) {
                        break;
                    }
                    j2 = j;
                }
                if (dh1VarA == null) {
                    mo.this.x.c(j4);
                    return 0L;
                }
                ih ihVarFirst = dh1VarA.first();
                ih ihVarLast = dh1VarA.last();
                if (ihVarFirst == null || ihVarLast == null) {
                    mo.this.x.c(j4);
                    return 0L;
                }
                long jB2 = ihVarFirst.b();
                mo moVar = mo.this;
                long j5 = jB2 - moVar.g.a;
                dh1VarA.e(new C0101b(ihVarLast, z, dh1VarA.size(), j3, z ? 0L : Math.min(100L, j5 < 0 ? j : ((j5 * 10) / moVar.a.E.f) + j), jB));
                long jB3 = lk4.b() - jB;
                mo.this.x.c(j4);
                return jB3;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public final void n(ih ihVar, jo0 jo0Var) {
                if (jo0Var == null) {
                    jo0Var = (jo0) ihVar.x;
                }
                ihVar.x = null;
                if (jo0Var == null) {
                    return;
                }
                jo0Var.destroy();
                b.this.d.b(jo0Var);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public void o(long j) {
                removeMessages(3);
                this.c = true;
                sendEmptyMessage(18);
                mo.this.x.c(mo.this.g.a + j);
                sendEmptyMessage(3);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public void p() {
                this.d = true;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public void q() {
                sendEmptyMessage(18);
                this.a = false;
                removeMessages(16);
                sendEmptyMessage(16);
                sendEmptyMessageDelayed(4, mo.this.a.E.f);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(int i, int i2) {
            lo0 lo0Var = new lo0();
            this.c = lo0Var;
            this.d = wf3.a(lo0Var, 800);
            this.i = false;
            this.f = 0;
            this.e = i;
            this.g = i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void A(Runnable runnable) {
            f fVar = this.h;
            if (fVar == null) {
                return;
            }
            fVar.post(runnable);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean B(ih ihVar, int i, boolean z) {
            if (i > 0) {
                q(i, z);
            }
            this.b.c(ihVar);
            this.f += i;
            return true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void C(long j) {
            f fVar = this.h;
            if (fVar != null) {
                fVar.o(j);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void D() {
            f fVar = this.h;
            if (fVar == null) {
                return;
            }
            fVar.removeMessages(3);
            this.h.removeMessages(18);
            this.h.p();
            this.h.removeMessages(7);
            this.h.sendEmptyMessage(7);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void E() {
            f fVar = this.h;
            if (fVar == null) {
                return;
            }
            fVar.removeMessages(4);
            this.h.sendEmptyMessage(4);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void F() {
            f fVar = this.h;
            if (fVar == null) {
                return;
            }
            fVar.removeMessages(9);
            this.h.sendEmptyMessage(9);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void G() {
            f fVar = this.h;
            if (fVar != null) {
                fVar.q();
            } else {
                n();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void H(long j) {
            f fVar = this.h;
            if (fVar == null) {
                return;
            }
            fVar.p();
            this.h.removeMessages(3);
            this.h.obtainMessage(5, Long.valueOf(j)).sendToTarget();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int I(ih ihVar) {
            hh1 hh1Var = ihVar.x;
            if (hh1Var == null || hh1Var.e()) {
                return 0;
            }
            return ihVar.x.size();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ah1
        public void a(ih ihVar) {
            f fVar = this.h;
            if (fVar != null) {
                if (!ihVar.y || !ihVar.z) {
                    fVar.obtainMessage(2, ihVar).sendToTarget();
                } else {
                    if (ihVar.w()) {
                        return;
                    }
                    this.h.h(ihVar);
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void n() {
            this.i = false;
            if (this.a == null) {
                HandlerThread handlerThread = new HandlerThread("DFM Cache-Building Thread");
                this.a = handlerThread;
                handlerThread.start();
            }
            if (this.h == null) {
                this.h = new f(this.a.getLooper());
            }
            this.h.f();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final long o(ih ihVar) {
            hh1 hh1Var = ihVar.x;
            if (hh1Var == null) {
                return 0L;
            }
            if (hh1Var.e()) {
                hh1Var.c();
                ihVar.x = null;
                return 0L;
            }
            long jI = I(ihVar);
            hh1Var.destroy();
            ihVar.x = null;
            return jI;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void p() {
            while (true) {
                jo0 jo0Var = (jo0) this.d.a();
                if (jo0Var == null) {
                    return;
                } else {
                    jo0Var.destroy();
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void q(int i, boolean z) {
            this.b.e(new e(i, z));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void r() {
            this.b.e(new c());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void s() {
            this.i = true;
            synchronized (mo.this.y) {
                mo.this.y.notifyAll();
            }
            f fVar = this.h;
            if (fVar != null) {
                fVar.removeCallbacksAndMessages(null);
                this.h.k();
                this.h = null;
            }
            HandlerThread handlerThread = this.a;
            if (handlerThread != null) {
                try {
                    handlerThread.join();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                this.a.quit();
                this.a = null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void t(boolean z, ih ihVar, ih ihVar2) {
            hh1 hh1VarE = ihVar.e();
            if (hh1VarE != null) {
                long jO = o(ihVar);
                if (ihVar.w()) {
                    mo.this.a.b().w().f(ihVar);
                }
                if (jO <= 0) {
                    return;
                }
                this.f = (int) (((long) this.f) - jO);
                this.d.b((jo0) hh1VarE);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void u() {
            e90 e90Var = this.b;
            if (e90Var != null) {
                e90Var.e(new a());
                this.b.clear();
            }
            this.f = 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void v() {
            e90 e90Var = this.b;
            if (e90Var != null) {
                e90Var.e(new C0100b());
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final ih w(ih ihVar, boolean z, int i) {
            d dVar = new d(i, ihVar, z, (!z ? mo.this.b.g() * 2 : 0) + mo.this.a.F.e);
            this.b.e(dVar);
            return (ih) dVar.d();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public long x() {
            ih ihVarFirst;
            e90 e90Var = this.b;
            if (e90Var == null || e90Var.size() <= 0 || (ihVarFirst = this.b.first()) == null) {
                return 0L;
            }
            return ihVarFirst.b();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public float y() {
            int i = this.e;
            if (i == 0) {
                return 0.0f;
            }
            return this.f / i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void z(int i) {
            f fVar = this.h;
            if (fVar != null) {
                fVar.j(i == 1);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public mo(b90 b90Var, t80 t80Var, gh1.a aVar) {
        super(b90Var, t80Var, aVar);
        this.v = 2;
        this.y = new Object();
        NativeBitmapFactory.f();
        int iMax = (int) Math.max(4194304.0f, Runtime.getRuntime().maxMemory() * t80Var.F.b);
        this.v = iMax;
        b bVar = new b(iMax, 3);
        this.w = bVar;
        this.f.d(bVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.rn0, defpackage.gh1
    public void a(int i) {
        super.a(i);
        b bVar = this.w;
        if (bVar != null) {
            bVar.z(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.rn0, defpackage.gh1
    public nh1.b b(o oVar) {
        b bVar;
        nh1.b bVarB = super.b(oVar);
        synchronized (this.y) {
            this.y.notify();
        }
        if (bVarB != null && (bVar = this.w) != null && bVarB.k - bVarB.l < -20) {
            bVar.E();
            this.w.C(-this.a.E.f);
        }
        return bVarB;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.rn0, defpackage.gh1
    public void c(long j) {
        super.c(j);
        if (this.w == null) {
            start();
        }
        this.w.H(j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.rn0, defpackage.gh1
    public void g() {
        super.g();
        t();
        this.f.d(null);
        b bVar = this.w;
        if (bVar != null) {
            bVar.s();
            this.w = null;
        }
        NativeBitmapFactory.g();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.rn0, defpackage.gh1
    public void k(long j, long j2, long j3) {
        super.k(j, j2, j3);
        b bVar = this.w;
        if (bVar != null) {
            bVar.H(j2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.rn0, defpackage.gh1
    public void prepare() {
        jh jhVar = this.d;
        if (jhVar == null) {
            return;
        }
        r(jhVar);
        this.w.n();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.rn0
    public void q(b90 b90Var) {
        this.g = b90Var;
        b90 b90Var2 = new b90();
        this.x = b90Var2;
        b90Var2.c(b90Var.a);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.rn0
    public boolean s(t80 t80Var, t80.b bVar, Object... objArr) {
        b bVar2;
        Object obj;
        b bVar3;
        if (!super.p(t80Var, bVar, objArr)) {
            if (t80.b.SCROLL_SPEED_FACTOR.equals(bVar)) {
                this.b.e(this.a.h);
                l();
            } else if (bVar.a()) {
                if (objArr != null && objArr.length > 0 && (obj = objArr[0]) != null && ((!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) && (bVar3 = this.w) != null)) {
                    bVar3.C(0L);
                }
                l();
            } else if (t80.b.TRANSPARENCY.equals(bVar) || t80.b.SCALE_TEXTSIZE.equals(bVar) || t80.b.DANMAKU_STYLE.equals(bVar)) {
                if (t80.b.SCALE_TEXTSIZE.equals(bVar)) {
                    this.b.e(this.a.h);
                }
                b bVar4 = this.w;
                if (bVar4 != null) {
                    bVar4.D();
                    this.w.C(-this.a.E.f);
                }
            } else {
                b bVar5 = this.w;
                if (bVar5 != null) {
                    bVar5.F();
                    this.w.C(0L);
                }
            }
        }
        if (this.e == null || (bVar2 = this.w) == null) {
            return true;
        }
        bVar2.A(new a());
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.rn0, defpackage.gh1
    public void start() {
        super.start();
        NativeBitmapFactory.f();
        b bVar = this.w;
        if (bVar != null) {
            bVar.G();
            return;
        }
        b bVar2 = new b(this.v, 3);
        this.w = bVar2;
        bVar2.n();
        this.f.d(this.w);
    }
}
