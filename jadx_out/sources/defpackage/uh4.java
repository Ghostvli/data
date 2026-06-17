package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class uh4 implements j02 {
    public final String f;
    public volatile j02 g;
    public Boolean h;
    public Method i;
    public gv0 j;
    public final Queue k;
    public final boolean l;

    public uh4(String str, Queue queue, boolean z) {
        this.f = str;
        this.k = queue;
        this.l = z;
    }

    @Override // defpackage.j02
    public void A(String str, Object obj, Object obj2) {
        B().A(str, obj, obj2);
    }

    public j02 B() {
        return this.g != null ? this.g : this.l ? yw2.f : C();
    }

    public final j02 C() {
        if (this.j == null) {
            this.j = new gv0(this, this.k);
        }
        return this.j;
    }

    public boolean D() {
        Boolean bool = this.h;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.i = this.g.getClass().getMethod("log", p02.class);
            this.h = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.h = Boolean.FALSE;
        }
        return this.h.booleanValue();
    }

    public boolean E() {
        return this.g instanceof yw2;
    }

    public boolean F() {
        return this.g == null;
    }

    public void G(p02 p02Var) {
        if (D()) {
            try {
                this.i.invoke(this.g, p02Var);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    public void H(j02 j02Var) {
        this.g = j02Var;
    }

    @Override // defpackage.j02
    public void a(String str, Throwable th) {
        B().a(str, th);
    }

    @Override // defpackage.j02
    public void b(String str) {
        B().b(str);
    }

    @Override // defpackage.j02
    public void c(String str, Object obj) {
        B().c(str, obj);
    }

    @Override // defpackage.j02
    public void d(String str, Object obj) {
        B().d(str, obj);
    }

    @Override // defpackage.j02
    public boolean e() {
        return B().e();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f.equals(((uh4) obj).f);
    }

    @Override // defpackage.j02
    public void error(String str) {
        B().error(str);
    }

    @Override // defpackage.j02
    public void f(String str, Object obj, Object obj2) {
        B().f(str, obj, obj2);
    }

    @Override // defpackage.j02
    public boolean g() {
        return B().g();
    }

    @Override // defpackage.j02
    public String getName() {
        return this.f;
    }

    @Override // defpackage.j02
    public void h(String str, Object obj) {
        B().h(str, obj);
    }

    public int hashCode() {
        return this.f.hashCode();
    }

    @Override // defpackage.j02
    public void i(String str, Object obj, Object obj2) {
        B().i(str, obj, obj2);
    }

    @Override // defpackage.j02
    public void info(String str) {
        B().info(str);
    }

    @Override // defpackage.j02
    public boolean j() {
        return B().j();
    }

    @Override // defpackage.j02
    public void k(String str, Object... objArr) {
        B().k(str, objArr);
    }

    @Override // defpackage.j02
    public boolean l() {
        return B().l();
    }

    @Override // defpackage.j02
    public void m(String str, Object obj, Object obj2) {
        B().m(str, obj, obj2);
    }

    @Override // defpackage.j02
    public boolean n() {
        return B().n();
    }

    @Override // defpackage.j02
    public void o(String str, Object obj, Object obj2) {
        B().o(str, obj, obj2);
    }

    @Override // defpackage.j02
    public void p(String str, Object... objArr) {
        B().p(str, objArr);
    }

    @Override // defpackage.j02
    public void q(String str, Object obj) {
        B().q(str, obj);
    }

    @Override // defpackage.j02
    public void r(String str, Object obj) {
        B().r(str, obj);
    }

    @Override // defpackage.j02
    public void s(String str, Object... objArr) {
        B().s(str, objArr);
    }

    @Override // defpackage.j02
    public void t(String str, Throwable th) {
        B().t(str, th);
    }

    @Override // defpackage.j02
    public void u(String str, Throwable th) {
        B().u(str, th);
    }

    @Override // defpackage.j02
    public void v(String str, Throwable th) {
        B().v(str, th);
    }

    @Override // defpackage.j02
    public void w(String str, Throwable th) {
        B().w(str, th);
    }

    @Override // defpackage.j02
    public void warn(String str) {
        B().warn(str);
    }

    @Override // defpackage.j02
    public boolean x(rs1 rs1Var) {
        return B().x(rs1Var);
    }

    @Override // defpackage.j02
    public void y(String str) {
        B().y(str);
    }

    @Override // defpackage.j02
    public void z(String str, Object... objArr) {
        B().z(str, objArr);
    }
}
