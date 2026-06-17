package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k51 implements jy0 {
    public final jy0 a;

    public k51(jy0 jy0Var) {
        this.a = jy0Var;
    }

    @Override // defpackage.jy0
    public boolean a(int i, long j) {
        return this.a.a(i, j);
    }

    @Override // defpackage.jy0
    public void b(long j, long j2, long j3, List list, w72[] w72VarArr) {
        this.a.b(j, j2, j3, list, w72VarArr);
    }

    @Override // defpackage.jy0
    public int d() {
        return this.a.d();
    }

    @Override // defpackage.jy0
    public void disable() {
        this.a.disable();
    }

    @Override // defpackage.jy0
    public void enable() {
        this.a.enable();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k51) {
            return this.a.equals(((k51) obj).a);
        }
        return false;
    }

    @Override // defpackage.jy0
    public boolean f(long j, pt ptVar, List list) {
        return this.a.f(j, ptVar, list);
    }

    @Override // defpackage.jy0
    public void g(boolean z) {
        this.a.g(z);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // defpackage.ir4
    public int i(int i) {
        return this.a.i(i);
    }

    @Override // defpackage.jy0
    public int j(long j, List list) {
        return this.a.j(j, list);
    }

    @Override // defpackage.jy0
    public int k() {
        return this.a.k();
    }

    @Override // defpackage.ir4
    public int length() {
        return this.a.length();
    }

    @Override // defpackage.jy0
    public int m() {
        return this.a.m();
    }

    @Override // defpackage.jy0
    public boolean n(int i, long j) {
        return this.a.n(i, j);
    }

    @Override // defpackage.jy0
    public void o(float f) {
        this.a.o(f);
    }

    @Override // defpackage.jy0
    public Object p() {
        return this.a.p();
    }

    @Override // defpackage.jy0
    public void q() {
        this.a.q();
    }

    @Override // defpackage.jy0
    public void r() {
        this.a.r();
    }

    @Override // defpackage.ir4
    public int s(int i) {
        return this.a.s(i);
    }

    public jy0 t() {
        return this.a;
    }
}
