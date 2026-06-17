package defpackage;

import defpackage.er3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class yn4 implements er3, yq3 {
    public final er3 a;
    public final Object b;
    public volatile yq3 c;
    public volatile yq3 d;
    public er3.a e;
    public er3.a f;
    public boolean g;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public yn4(Object obj, er3 er3Var) {
        er3.a aVar = er3.a.CLEARED;
        this.e = aVar;
        this.f = aVar;
        this.b = obj;
        this.a = er3Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean k() {
        er3 er3Var = this.a;
        return er3Var == null || er3Var.e(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean l() {
        er3 er3Var = this.a;
        return er3Var == null || er3Var.f(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean m() {
        er3 er3Var = this.a;
        return er3Var == null || er3Var.g(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.er3, defpackage.yq3
    public boolean a() {
        boolean z;
        synchronized (this.b) {
            try {
                z = this.d.a() || this.c.a();
            } finally {
            }
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.er3
    public void b(yq3 yq3Var) {
        synchronized (this.b) {
            try {
                if (!yq3Var.equals(this.c)) {
                    this.f = er3.a.FAILED;
                    return;
                }
                this.e = er3.a.FAILED;
                er3 er3Var = this.a;
                if (er3Var != null) {
                    er3Var.b(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.er3
    public void c(yq3 yq3Var) {
        synchronized (this.b) {
            try {
                if (yq3Var.equals(this.d)) {
                    this.f = er3.a.SUCCESS;
                    return;
                }
                this.e = er3.a.SUCCESS;
                er3 er3Var = this.a;
                if (er3Var != null) {
                    er3Var.c(this);
                }
                if (!this.f.b()) {
                    this.d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yq3
    public void clear() {
        synchronized (this.b) {
            this.g = false;
            er3.a aVar = er3.a.CLEARED;
            this.e = aVar;
            this.f = aVar;
            this.d.clear();
            this.c.clear();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yq3
    public boolean d(yq3 yq3Var) {
        if (yq3Var instanceof yn4) {
            yn4 yn4Var = (yn4) yq3Var;
            if (this.c != null ? this.c.d(yn4Var.c) : yn4Var.c == null) {
                if (this.d == null) {
                    if (yn4Var.d == null) {
                        return true;
                    }
                } else if (this.d.d(yn4Var.d)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.er3
    public boolean e(yq3 yq3Var) {
        boolean z;
        synchronized (this.b) {
            try {
                z = k() && yq3Var.equals(this.c) && this.e != er3.a.PAUSED;
            } finally {
            }
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.er3
    public boolean f(yq3 yq3Var) {
        boolean z;
        synchronized (this.b) {
            try {
                z = l() && yq3Var.equals(this.c) && !a();
            } finally {
            }
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.er3
    public boolean g(yq3 yq3Var) {
        boolean z;
        synchronized (this.b) {
            try {
                z = m() && (yq3Var.equals(this.c) || this.e != er3.a.SUCCESS);
            } finally {
            }
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [er3] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    @Override // defpackage.er3
    public er3 getRoot() {
        ?? root;
        synchronized (this.b) {
            try {
                er3 er3Var = this.a;
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yq3
    public boolean h() {
        boolean z;
        synchronized (this.b) {
            z = this.e == er3.a.CLEARED;
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yq3
    public void i() {
        synchronized (this.b) {
            try {
                this.g = true;
                try {
                    if (this.e != er3.a.SUCCESS) {
                        er3.a aVar = this.f;
                        er3.a aVar2 = er3.a.RUNNING;
                        if (aVar != aVar2) {
                            this.f = aVar2;
                            this.d.i();
                        }
                    }
                    if (this.g) {
                        er3.a aVar3 = this.e;
                        er3.a aVar4 = er3.a.RUNNING;
                        if (aVar3 != aVar4) {
                            this.e = aVar4;
                            this.c.i();
                        }
                    }
                    this.g = false;
                } catch (Throwable th) {
                    this.g = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yq3
    public boolean isRunning() {
        boolean z;
        synchronized (this.b) {
            z = this.e == er3.a.RUNNING;
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yq3
    public boolean j() {
        boolean z;
        synchronized (this.b) {
            z = this.e == er3.a.SUCCESS;
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void n(yq3 yq3Var, yq3 yq3Var2) {
        this.c = yq3Var;
        this.d = yq3Var2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yq3
    public void pause() {
        synchronized (this.b) {
            try {
                if (!this.f.b()) {
                    this.f = er3.a.PAUSED;
                    this.d.pause();
                }
                if (!this.e.b()) {
                    this.e = er3.a.PAUSED;
                    this.c.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
