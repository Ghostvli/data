package defpackage;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class t45 {
    public Interpolator c;
    public u45 d;
    public boolean e;
    public long b = -1;
    public final v45 f = new a();
    public final ArrayList a = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends v45 {
        public boolean a = false;
        public int b = 0;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.u45
        public void b(View view) {
            int i = this.b + 1;
            this.b = i;
            if (i == t45.this.a.size()) {
                u45 u45Var = t45.this.d;
                if (u45Var != null) {
                    u45Var.b(null);
                }
                d();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.v45, defpackage.u45
        public void c(View view) {
            if (this.a) {
                return;
            }
            this.a = true;
            u45 u45Var = t45.this.d;
            if (u45Var != null) {
                u45Var.c(null);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void d() {
            this.b = 0;
            this.a = false;
            t45.this.b();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void a() {
        if (this.e) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((s45) it.next()).c();
            }
            this.e = false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b() {
        this.e = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public t45 c(s45 s45Var) {
        if (!this.e) {
            this.a.add(s45Var);
        }
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public t45 d(s45 s45Var, s45 s45Var2) {
        this.a.add(s45Var);
        s45Var2.i(s45Var.d());
        this.a.add(s45Var2);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public t45 e(long j) {
        if (!this.e) {
            this.b = j;
        }
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public t45 f(Interpolator interpolator) {
        if (!this.e) {
            this.c = interpolator;
        }
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public t45 g(u45 u45Var) {
        if (!this.e) {
            this.d = u45Var;
        }
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void h() {
        if (this.e) {
            return;
        }
        for (s45 s45Var : this.a) {
            long j = this.b;
            if (j >= 0) {
                s45Var.e(j);
            }
            Interpolator interpolator = this.c;
            if (interpolator != null) {
                s45Var.f(interpolator);
            }
            if (this.d != null) {
                s45Var.g(this.f);
            }
            s45Var.k();
        }
        this.e = true;
    }
}
