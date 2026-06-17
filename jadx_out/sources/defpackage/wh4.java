package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class wh4 implements p02 {
    public rs1 a;
    public List b;
    public String c;
    public uh4 d;
    public String e;
    public String f;
    public Object[] g;
    public long h;
    public Throwable i;

    public void a(b52 b52Var) {
        if (b52Var == null) {
            return;
        }
        if (this.b == null) {
            this.b = new ArrayList(2);
        }
        this.b.add(b52Var);
    }

    public rs1 b() {
        return this.a;
    }

    public uh4 c() {
        return this.d;
    }

    public void d(Object[] objArr) {
        this.g = objArr;
    }

    public void e(rs1 rs1Var) {
        this.a = rs1Var;
    }

    public void f(uh4 uh4Var) {
        this.d = uh4Var;
    }

    public void g(String str) {
        this.c = str;
    }

    public void h(String str) {
        this.f = str;
    }

    public void i(String str) {
        this.e = str;
    }

    public void j(Throwable th) {
        this.i = th;
    }

    public void k(long j) {
        this.h = j;
    }
}
