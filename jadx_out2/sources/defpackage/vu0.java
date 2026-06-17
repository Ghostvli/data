package defpackage;

import defpackage.h02;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class vu0 {
    public static final ExecutorService m = Executors.newCachedThreadPool();
    public boolean e;
    public boolean g;
    public boolean h;
    public List j;
    public h02 k;
    public d42 l;
    public boolean a = true;
    public boolean b = true;
    public boolean c = true;
    public boolean d = true;
    public boolean f = true;
    public ExecutorService i = m;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public vu0 a(oh4 oh4Var) {
        if (this.j == null) {
            this.j = new ArrayList();
        }
        this.j.add(oh4Var);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public uu0 b() {
        return new uu0(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public h02 c() {
        h02 h02Var = this.k;
        return h02Var != null ? h02Var : h02.a.a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public d42 d() {
        d42 d42Var = this.l;
        if (d42Var != null) {
            return d42Var;
        }
        if (x5.a()) {
            return x5.b().b;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public uu0 e() {
        uu0 uu0Var;
        synchronized (uu0.class) {
            try {
                if (uu0.s != null) {
                    throw new wu0("Default instance already exists. It may be only set once before it's used the first time to ensure consistent behavior.");
                }
                uu0.s = b();
                uu0Var = uu0.s;
            } catch (Throwable th) {
                throw th;
            }
        }
        return uu0Var;
    }
}
