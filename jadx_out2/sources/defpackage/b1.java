package defpackage;

import defpackage.kt3;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b1 {
    public d1[] f;
    public int g;
    public int h;
    public th4 i;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ce4 g() {
        th4 th4Var;
        synchronized (this) {
            th4Var = this.i;
            if (th4Var == null) {
                th4Var = new th4(this.g);
                this.i = th4Var;
            }
        }
        return th4Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final d1 h() {
        d1 d1VarI;
        th4 th4Var;
        synchronized (this) {
            try {
                d1[] d1VarArrJ = this.f;
                if (d1VarArrJ == null) {
                    d1VarArrJ = j(2);
                    this.f = d1VarArrJ;
                } else if (this.g >= d1VarArrJ.length) {
                    Object[] objArrCopyOf = Arrays.copyOf(d1VarArrJ, d1VarArrJ.length * 2);
                    this.f = (d1[]) objArrCopyOf;
                    d1VarArrJ = (d1[]) objArrCopyOf;
                }
                int i = this.h;
                do {
                    d1VarI = d1VarArrJ[i];
                    if (d1VarI == null) {
                        d1VarI = i();
                        d1VarArrJ[i] = d1VarI;
                    }
                    i++;
                    if (i >= d1VarArrJ.length) {
                        i = 0;
                    }
                    d1VarI.getClass();
                } while (!d1VarI.a(this));
                this.h = i;
                this.g++;
                th4Var = this.i;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (th4Var != null) {
            th4Var.Y(1);
        }
        return d1VarI;
    }

    public abstract d1 i();

    public abstract d1[] j(int i);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k(d1 d1Var) {
        th4 th4Var;
        int i;
        f30[] f30VarArrB;
        synchronized (this) {
            try {
                int i2 = this.g - 1;
                this.g = i2;
                th4Var = this.i;
                if (i2 == 0) {
                    this.h = 0;
                }
                d1Var.getClass();
                f30VarArrB = d1Var.b(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (f30 f30Var : f30VarArrB) {
            if (f30Var != null) {
                kt3.a aVar = kt3.g;
                f30Var.resumeWith(kt3.b(fw4.a));
            }
        }
        if (th4Var != null) {
            th4Var.Y(-1);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int l() {
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final d1[] m() {
        return this.f;
    }
}
