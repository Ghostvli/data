package defpackage;

import defpackage.er3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class nu0 implements er3, yq3 {
    public final Object a;
    public final er3 b;
    public volatile yq3 c;
    public volatile yq3 d;
    public er3.a e;
    public er3.a f;

    public nu0(Object obj, er3 er3Var) {
        er3.a aVar = er3.a.CLEARED;
        this.e = aVar;
        this.f = aVar;
        this.a = obj;
        this.b = er3Var;
    }

    @Override // defpackage.er3, defpackage.yq3
    public boolean a() {
        boolean z;
        synchronized (this.a) {
            try {
                z = this.c.a() || this.d.a();
            } finally {
            }
        }
        return z;
    }

    @Override // defpackage.er3
    public void b(yq3 yq3Var) {
        synchronized (this.a) {
            try {
                if (yq3Var.equals(this.d)) {
                    this.f = er3.a.FAILED;
                    er3 er3Var = this.b;
                    if (er3Var != null) {
                        er3Var.b(this);
                    }
                    return;
                }
                this.e = er3.a.FAILED;
                er3.a aVar = this.f;
                er3.a aVar2 = er3.a.RUNNING;
                if (aVar != aVar2) {
                    this.f = aVar2;
                    this.d.i();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.er3
    public void c(yq3 yq3Var) {
        synchronized (this.a) {
            try {
                if (yq3Var.equals(this.c)) {
                    this.e = er3.a.SUCCESS;
                } else if (yq3Var.equals(this.d)) {
                    this.f = er3.a.SUCCESS;
                }
                er3 er3Var = this.b;
                if (er3Var != null) {
                    er3Var.c(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.yq3
    public void clear() {
        synchronized (this.a) {
            try {
                er3.a aVar = er3.a.CLEARED;
                this.e = aVar;
                this.c.clear();
                if (this.f != aVar) {
                    this.f = aVar;
                    this.d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.yq3
    public boolean d(yq3 yq3Var) {
        if (yq3Var instanceof nu0) {
            nu0 nu0Var = (nu0) yq3Var;
            if (this.c.d(nu0Var.c) && this.d.d(nu0Var.d)) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.er3
    public boolean e(yq3 yq3Var) {
        boolean z;
        synchronized (this.a) {
            try {
                z = l() && yq3Var.equals(this.c);
            } finally {
            }
        }
        return z;
    }

    @Override // defpackage.er3
    public boolean f(yq3 yq3Var) {
        boolean z;
        synchronized (this.a) {
            try {
                z = m() && k(yq3Var);
            } finally {
            }
        }
        return z;
    }

    @Override // defpackage.er3
    public boolean g(yq3 yq3Var) {
        boolean zN;
        synchronized (this.a) {
            zN = n();
        }
        return zN;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [er3] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    @Override // defpackage.er3
    public er3 getRoot() {
        ?? root;
        synchronized (this.a) {
            try {
                er3 er3Var = this.b;
                this = this;
                if (er3Var != null) {
                    root = er3Var.getRoot();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return root;
    }

    @Override // defpackage.yq3
    public boolean h() {
        boolean z;
        synchronized (this.a) {
            try {
                er3.a aVar = this.e;
                er3.a aVar2 = er3.a.CLEARED;
                z = aVar == aVar2 && this.f == aVar2;
            } finally {
            }
        }
        return z;
    }

    @Override // defpackage.yq3
    public void i() {
        synchronized (this.a) {
            try {
                er3.a aVar = this.e;
                er3.a aVar2 = er3.a.RUNNING;
                if (aVar != aVar2) {
                    this.e = aVar2;
                    this.c.i();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.yq3
    public boolean isRunning() {
        boolean z;
        synchronized (this.a) {
            try {
                er3.a aVar = this.e;
                er3.a aVar2 = er3.a.RUNNING;
                z = aVar == aVar2 || this.f == aVar2;
            } finally {
            }
        }
        return z;
    }

    @Override // defpackage.yq3
    public boolean j() {
        boolean z;
        synchronized (this.a) {
            try {
                er3.a aVar = this.e;
                er3.a aVar2 = er3.a.SUCCESS;
                z = aVar == aVar2 || this.f == aVar2;
            } finally {
            }
        }
        return z;
    }

    public final boolean k(yq3 yq3Var) {
        er3.a aVar = this.e;
        er3.a aVar2 = er3.a.FAILED;
        if (aVar != aVar2) {
            return yq3Var.equals(this.c);
        }
        if (!yq3Var.equals(this.d)) {
            return false;
        }
        er3.a aVar3 = this.f;
        return aVar3 == er3.a.SUCCESS || aVar3 == aVar2;
    }

    public final boolean l() {
        er3 er3Var = this.b;
        return er3Var == null || er3Var.e(this);
    }

    public final boolean m() {
        er3 er3Var = this.b;
        return er3Var == null || er3Var.f(this);
    }

    public final boolean n() {
        er3 er3Var = this.b;
        return er3Var == null || er3Var.g(this);
    }

    public void o(yq3 yq3Var, yq3 yq3Var2) {
        this.c = yq3Var;
        this.d = yq3Var2;
    }

    @Override // defpackage.yq3
    public void pause() {
        synchronized (this.a) {
            try {
                er3.a aVar = this.e;
                er3.a aVar2 = er3.a.RUNNING;
                if (aVar == aVar2) {
                    this.e = er3.a.PAUSED;
                    this.c.pause();
                }
                if (this.f == aVar2) {
                    this.f = er3.a.PAUSED;
                    this.d.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
