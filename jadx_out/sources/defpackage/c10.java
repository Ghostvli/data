package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class c10 implements lw3, rw2 {
    public final lw3 f;
    public final rw2 g;
    public g40 h;
    public Throwable i;
    public final b j;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements ow3 {
        public final ow3 f;

        public a(ow3 ow3Var) {
            ow3Var.getClass();
            this.f = ow3Var;
        }

        @Override // defpackage.ow3
        public String I(int i) {
            return this.f.I(i);
        }

        @Override // defpackage.ow3
        public boolean Y() {
            return this.f.Y();
        }

        @Override // defpackage.ow3
        public void b(int i, double d) {
            this.f.b(i, d);
        }

        @Override // defpackage.ow3, java.lang.AutoCloseable
        public void close() {
            this.f.reset();
            this.f.g();
        }

        @Override // defpackage.ow3
        public void d(int i, long j) {
            this.f.d(i, j);
        }

        @Override // defpackage.ow3
        public void e(int i) {
            this.f.e(i);
        }

        @Override // defpackage.ow3
        public void g() {
            this.f.g();
        }

        @Override // defpackage.ow3
        public int getColumnCount() {
            return this.f.getColumnCount();
        }

        @Override // defpackage.ow3
        public String getColumnName(int i) {
            return this.f.getColumnName(i);
        }

        @Override // defpackage.ow3
        public double getDouble(int i) {
            return this.f.getDouble(i);
        }

        @Override // defpackage.ow3
        public long getLong(int i) {
            return this.f.getLong(i);
        }

        @Override // defpackage.ow3
        public boolean isNull(int i) {
            return this.f.isNull(i);
        }

        @Override // defpackage.ow3
        public void reset() {
            this.f.reset();
        }

        @Override // defpackage.ow3
        public boolean s(int i) {
            return this.f.s(i);
        }

        @Override // defpackage.ow3
        public void w(int i, String str) {
            str.getClass();
            this.f.w(i, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class b extends f32 {
        public b(int i) {
            super(i);
        }

        @Override // defpackage.f32
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public ow3 a(String str) {
            str.getClass();
            return c10.this.f.a0(str);
        }

        @Override // defpackage.f32
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void b(boolean z, String str, ow3 ow3Var, ow3 ow3Var2) {
            str.getClass();
            ow3Var.getClass();
            ow3Var.close();
            super.b(z, str, ow3Var, ow3Var2);
        }
    }

    public c10(lw3 lw3Var, rw2 rw2Var, int i) {
        lw3Var.getClass();
        rw2Var.getClass();
        this.f = lw3Var;
        this.g = rw2Var;
        this.j = i > 0 ? new b(i) : null;
    }

    @Override // defpackage.lw3
    public ow3 a0(String str) {
        str.getClass();
        b bVar = this.j;
        if (bVar == null) {
            return this.f.a0(str);
        }
        Object objD = bVar.d(str);
        objD.getClass();
        return new a((ow3) objD);
    }

    @Override // defpackage.rw2
    public void c(Object obj) {
        this.g.c(obj);
    }

    @Override // defpackage.lw3, java.lang.AutoCloseable
    public void close() {
        b bVar = this.j;
        if (bVar != null) {
            bVar.c();
        }
        this.f.close();
    }

    @Override // defpackage.lw3
    public boolean f() {
        return this.f.f();
    }

    @Override // defpackage.rw2
    public Object h(Object obj, f30 f30Var) {
        return this.g.h(obj, f30Var);
    }

    public final void i(StringBuilder sb) {
        sb.getClass();
        if (this.h == null && this.i == null) {
            sb.append("\t\tStatus: Free connection");
            sb.append('\n');
        } else {
            sb.append("\t\tStatus: Acquired connection");
            sb.append('\n');
            g40 g40Var = this.h;
            if (g40Var != null) {
                sb.append("\t\tCoroutine: " + g40Var);
                sb.append('\n');
            }
            Throwable th = this.i;
            if (th != null) {
                sb.append("\t\tAcquired:");
                sb.append('\n');
                Iterator it = ww.F(wg4.j0(mv0.b(th)), 1).iterator();
                while (it.hasNext()) {
                    sb.append("\t\t" + ((String) it.next()));
                    sb.append('\n');
                }
            }
        }
        if (this.j != null) {
            sb.append("\t\tPrepared Statement Cache Size: " + this.j.g());
            sb.append('\n');
        }
    }

    public final c10 l(g40 g40Var) {
        g40Var.getClass();
        this.h = g40Var;
        this.i = new Throwable();
        return this;
    }

    public final c10 t() {
        this.h = null;
        this.i = null;
        return this;
    }

    public String toString() {
        return this.f.toString();
    }

    public /* synthetic */ c10(lw3 lw3Var, rw2 rw2Var, int i, int i2, we0 we0Var) {
        this(lw3Var, (i2 & 2) != 0 ? xw2.b(false, 1, null) : rw2Var, i);
    }
}
