package androidx.media3.exoplayer.dash;

import android.os.Handler;
import android.os.Message;
import defpackage.at2;
import defpackage.dv0;
import defpackage.ev0;
import defpackage.ex3;
import defpackage.fy4;
import defpackage.g90;
import defpackage.gr4;
import defpackage.j5;
import defpackage.pt;
import defpackage.r73;
import defpackage.r83;
import defpackage.t41;
import defpackage.u41;
import defpackage.x90;
import defpackage.xs2;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Handler.Callback {
    public final j5 f;
    public final b g;
    public g90 k;
    public long l;
    public boolean m;
    public boolean n;
    public boolean o;
    public final TreeMap j = new TreeMap();
    public final Handler i = fy4.F(this);
    public final ev0 h = new ev0();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final long a;
        public final long b;

        public a(long j, long j2) {
            this.a = j;
            this.b = j2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        void a();

        void b(long j);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class c implements gr4 {
        public final ex3 a;
        public final u41 b = new u41();
        public final at2 c = new at2();
        public long d = -9223372036854775807L;

        public c(j5 j5Var) {
            this.a = ex3.n(j5Var);
        }

        @Override // defpackage.gr4
        public void b(long j, int i, int i2, int i3, gr4.a aVar) {
            this.a.b(j, i, i2, i3, aVar);
            m();
        }

        @Override // defpackage.gr4
        public void c(r73 r73Var, int i, int i2) {
            this.a.a(r73Var, i);
        }

        @Override // defpackage.gr4
        public int f(x90 x90Var, int i, boolean z, int i2) {
            return this.a.d(x90Var, i, z);
        }

        @Override // defpackage.gr4
        public void g(t41 t41Var) {
            this.a.g(t41Var);
        }

        public final at2 h() {
            this.c.clear();
            if (this.a.W(this.b, this.c, 0, false) != -4) {
                return null;
            }
            this.c.flip();
            return this.c;
        }

        public boolean i(long j) {
            return d.this.j(j);
        }

        public void j(pt ptVar) {
            long j = this.d;
            if (j == -9223372036854775807L || ptVar.h > j) {
                this.d = ptVar.h;
            }
            d.this.m(ptVar);
        }

        public boolean k(pt ptVar) {
            long j = this.d;
            return d.this.n(j != -9223372036854775807L && j < ptVar.g);
        }

        public final void l(long j, long j2) {
            d.this.i.sendMessage(d.this.i.obtainMessage(1, new a(j, j2)));
        }

        public final void m() {
            while (this.a.P(false)) {
                at2 at2VarH = h();
                if (at2VarH != null) {
                    long j = at2VarH.timeUs;
                    xs2 xs2VarA = d.this.h.a(at2VarH);
                    if (xs2VarA != null) {
                        dv0 dv0Var = (dv0) xs2VarA.e(0);
                        if (d.h(dv0Var.a, dv0Var.b)) {
                            n(j, dv0Var);
                        }
                    }
                }
            }
            this.a.u();
        }

        public final void n(long j, dv0 dv0Var) {
            long jF = d.f(dv0Var);
            if (jF == -9223372036854775807L) {
                return;
            }
            l(j, jF);
        }

        public void o() {
            this.a.X();
        }
    }

    public d(g90 g90Var, b bVar, j5 j5Var) {
        this.k = g90Var;
        this.g = bVar;
        this.f = j5Var;
    }

    public static long f(dv0 dv0Var) {
        try {
            return fy4.l1(fy4.N(dv0Var.e));
        } catch (r83 unused) {
            return -9223372036854775807L;
        }
    }

    public static boolean h(String str, String str2) {
        if ("urn:mpeg:dash:event:2012".equals(str)) {
            return "1".equals(str2) || "2".equals(str2) || "3".equals(str2);
        }
        return false;
    }

    public final Map.Entry e(long j) {
        return this.j.ceilingEntry(Long.valueOf(j));
    }

    public final void g(long j, long j2) {
        Long l = (Long) this.j.get(Long.valueOf(j2));
        if (l == null) {
            this.j.put(Long.valueOf(j2), Long.valueOf(j));
        } else if (l.longValue() > j) {
            this.j.put(Long.valueOf(j2), Long.valueOf(j));
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.o) {
            return true;
        }
        if (message.what != 1) {
            return false;
        }
        a aVar = (a) message.obj;
        g(aVar.a, aVar.b);
        return true;
    }

    public final void i() {
        if (this.m) {
            this.n = true;
            this.m = false;
            this.g.a();
        }
    }

    public boolean j(long j) {
        g90 g90Var = this.k;
        boolean z = false;
        if (!g90Var.d) {
            return false;
        }
        if (this.n) {
            return true;
        }
        Map.Entry entryE = e(g90Var.h);
        if (entryE != null && ((Long) entryE.getValue()).longValue() < j) {
            this.l = ((Long) entryE.getKey()).longValue();
            l();
            z = true;
        }
        if (z) {
            i();
        }
        return z;
    }

    public c k() {
        return new c(this.f);
    }

    public final void l() {
        this.g.b(this.l);
    }

    public void m(pt ptVar) {
        this.m = true;
    }

    public boolean n(boolean z) {
        if (!this.k.d) {
            return false;
        }
        if (this.n) {
            return true;
        }
        if (!z) {
            return false;
        }
        i();
        return true;
    }

    public void o() {
        this.o = true;
        this.i.removeCallbacksAndMessages(null);
    }

    public final void p() {
        Iterator it = this.j.entrySet().iterator();
        while (it.hasNext()) {
            if (((Long) ((Map.Entry) it.next()).getKey()).longValue() < this.k.h) {
                it.remove();
            }
        }
    }

    public void q(g90 g90Var) {
        this.n = false;
        this.l = -9223372036854775807L;
        this.k = g90Var;
        p();
    }
}
