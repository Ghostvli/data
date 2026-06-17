package defpackage;

import android.net.Uri;
import defpackage.xi1;
import java.io.EOFException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class qm implements rh3 {
    public final pz0 a;
    public hz0 b;
    public jz0 c;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public qm(pz0 pz0Var) {
        this.a = pz0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.rh3
    public void a(long j, long j2) {
        ((hz0) gg3.q(this.b)).a(j, j2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.rh3
    public long b() {
        jz0 jz0Var = this.c;
        if (jz0Var != null) {
            return jz0Var.getPosition();
        }
        return -1L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.rh3
    public void c() {
        hz0 hz0Var = this.b;
        if (hz0Var == null) {
            return;
        }
        hz0 hz0VarC = hz0Var.c();
        if (hz0VarC instanceof pu2) {
            ((pu2) hz0VarC).m();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0053  */
    @Override // defpackage.rh3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(x90 x90Var, Uri uri, Map map, long j, long j2, mz0 mz0Var) throws tw4 {
        boolean z;
        sf0 sf0Var = new sf0(x90Var, j, j2);
        this.c = sf0Var;
        if (this.b != null) {
            return;
        }
        hz0[] hz0VarArrF = this.a.f(uri, map);
        xi1.a aVarN = xi1.n(hz0VarArrF.length);
        if (hz0VarArrF.length == 1) {
            this.b = hz0VarArrF[0];
        } else {
            int length = hz0VarArrF.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                hz0 hz0Var = hz0VarArrF[i];
                try {
                } catch (EOFException unused) {
                    if (this.b != null || sf0Var.getPosition() == j) {
                    }
                } catch (Throwable th) {
                    gg3.v(this.b != null || sf0Var.getPosition() == j);
                    sf0Var.p();
                    throw th;
                }
                if (hz0Var.e(sf0Var)) {
                    this.b = hz0Var;
                    gg3.v(true);
                    sf0Var.p();
                    break;
                } else {
                    aVarN.j(hz0Var.f());
                    if (this.b != null || sf0Var.getPosition() == j) {
                        z = true;
                    }
                    gg3.v(z);
                    sf0Var.p();
                    i++;
                }
                z = false;
                gg3.v(z);
                sf0Var.p();
                i++;
            }
            if (this.b == null) {
                throw new tw4("None of the available extractors (" + wn1.h(", ").e(ru1.i(xi1.q(hz0VarArrF), new p81() { // from class: pm
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // defpackage.p81
                    public final Object apply(Object obj) {
                        return ((hz0) obj).c().getClass().getSimpleName();
                    }
                })) + ") could read the stream.", (Uri) gg3.q(uri), aVarN.k());
            }
        }
        this.b.b(mz0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.rh3
    public int e(yf3 yf3Var) {
        return ((hz0) gg3.q(this.b)).d((jz0) gg3.q(this.c), yf3Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.rh3
    public void release() {
        hz0 hz0Var = this.b;
        if (hz0Var != null) {
            hz0Var.release();
            this.b = null;
        }
        this.c = null;
    }
}
