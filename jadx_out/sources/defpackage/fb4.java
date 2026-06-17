package defpackage;

import android.util.Log;
import defpackage.t90;
import defpackage.u90;
import defpackage.vt2;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class fb4 implements u90, u90.a {
    public final ab0 f;
    public final u90.a g;
    public volatile int h;
    public volatile p90 i;
    public volatile Object j;
    public volatile vt2.a k;
    public volatile q90 l;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements t90.a {
        public final /* synthetic */ vt2.a f;

        public a(vt2.a aVar) {
            this.f = aVar;
        }

        @Override // t90.a
        public void d(Exception exc) {
            if (fb4.this.g(this.f)) {
                fb4.this.i(this.f, exc);
            }
        }

        @Override // t90.a
        public void f(Object obj) {
            if (fb4.this.g(this.f)) {
                fb4.this.h(this.f, obj);
            }
        }
    }

    public fb4(ab0 ab0Var, u90.a aVar) {
        this.f = ab0Var;
        this.g = aVar;
    }

    private boolean d() {
        return this.h < this.f.g().size();
    }

    @Override // u90.a
    public void a(wq1 wq1Var, Exception exc, t90 t90Var, ba0 ba0Var) {
        this.g.a(wq1Var, exc, t90Var, this.k.c.e());
    }

    @Override // defpackage.u90
    public boolean b() {
        if (this.j != null) {
            Object obj = this.j;
            this.j = null;
            try {
                if (!c(obj)) {
                    return true;
                }
            } catch (IOException e) {
                if (Log.isLoggable("SourceGenerator", 3)) {
                    Log.d("SourceGenerator", "Failed to properly rewind or write data to cache", e);
                }
            }
        }
        if (this.i != null && this.i.b()) {
            return true;
        }
        this.i = null;
        this.k = null;
        boolean z = false;
        while (!z && d()) {
            List listG = this.f.g();
            int i = this.h;
            this.h = i + 1;
            this.k = (vt2.a) listG.get(i);
            if (this.k != null && (this.f.e().c(this.k.c.e()) || this.f.u(this.k.c.a()))) {
                j(this.k);
                z = true;
            }
        }
        return z;
    }

    public final boolean c(Object obj) throws Throwable {
        Throwable th;
        long jB = b02.b();
        boolean z = false;
        try {
            com.bumptech.glide.load.data.a aVarO = this.f.o(obj);
            Object objA = aVarO.a();
            ns0 ns0VarQ = this.f.q(objA);
            r90 r90Var = new r90(ns0VarQ, objA, this.f.k());
            q90 q90Var = new q90(this.k.a, this.f.p());
            xl0 xl0VarD = this.f.d();
            xl0VarD.b(q90Var, r90Var);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + q90Var + ", data: " + obj + ", encoder: " + ns0VarQ + ", duration: " + b02.a(jB));
            }
            if (xl0VarD.a(q90Var) != null) {
                this.l = q90Var;
                this.i = new p90(Collections.singletonList(this.k.a), this.f, this);
                this.k.c.b();
                return true;
            }
            if (Log.isLoggable("SourceGenerator", 3)) {
                Log.d("SourceGenerator", "Attempt to write: " + this.l + ", data: " + obj + " to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly...");
            }
            try {
                this.g.f(this.k.a, aVarO.a(), this.k.c, this.k.c.e(), this.k.a);
                return false;
            } catch (Throwable th2) {
                th = th2;
                z = true;
                if (z) {
                    throw th;
                }
                this.k.c.b();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // defpackage.u90
    public void cancel() {
        vt2.a aVar = this.k;
        if (aVar != null) {
            aVar.c.cancel();
        }
    }

    @Override // u90.a
    public void e() {
        throw new UnsupportedOperationException();
    }

    @Override // u90.a
    public void f(wq1 wq1Var, Object obj, t90 t90Var, ba0 ba0Var, wq1 wq1Var2) {
        this.g.f(wq1Var, obj, t90Var, this.k.c.e(), wq1Var);
    }

    public boolean g(vt2.a aVar) {
        vt2.a aVar2 = this.k;
        return aVar2 != null && aVar2 == aVar;
    }

    public void h(vt2.a aVar, Object obj) {
        zl0 zl0VarE = this.f.e();
        if (obj != null && zl0VarE.c(aVar.c.e())) {
            this.j = obj;
            this.g.e();
        } else {
            u90.a aVar2 = this.g;
            wq1 wq1Var = aVar.a;
            t90 t90Var = aVar.c;
            aVar2.f(wq1Var, obj, t90Var, t90Var.e(), this.l);
        }
    }

    public void i(vt2.a aVar, Exception exc) {
        u90.a aVar2 = this.g;
        q90 q90Var = this.l;
        t90 t90Var = aVar.c;
        aVar2.a(q90Var, exc, t90Var, t90Var.e());
    }

    public final void j(vt2.a aVar) {
        this.k.c.c(this.f.l(), new a(aVar));
    }
}
