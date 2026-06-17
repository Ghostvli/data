package defpackage;

import android.util.Log;
import defpackage.cm0;
import defpackage.xl0;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class fm0 implements xl0 {
    public final File b;
    public final long c;
    public cm0 e;
    public final am0 d = new am0();
    public final zw3 a = new zw3();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public fm0(File file, long j) {
        this.b = file;
        this.c = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static xl0 c(File file, long j) {
        return new fm0(file, j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xl0
    public File a(wq1 wq1Var) {
        String strB = this.a.b(wq1Var);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + strB + " for for Key: " + wq1Var);
        }
        try {
            cm0.e eVarO = d().O(strB);
            if (eVarO != null) {
                return eVarO.a(0);
            }
            return null;
        } catch (IOException e) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xl0
    public void b(wq1 wq1Var, xl0.b bVar) {
        String strB = this.a.b(wq1Var);
        this.d.a(strB);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + strB + " for for Key: " + wq1Var);
            }
            try {
                cm0 cm0VarD = d();
                if (cm0VarD.O(strB) == null) {
                    cm0.c cVarL = cm0VarD.L(strB);
                    if (cVarL == null) {
                        throw new IllegalStateException("Had two simultaneous puts for: " + strB);
                    }
                    try {
                        if (bVar.a(cVarL.f(0))) {
                            cVarL.e();
                        }
                        cVarL.b();
                    } catch (Throwable th) {
                        cVarL.b();
                        throw th;
                    }
                }
            } catch (IOException e) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e);
                }
            }
        } finally {
            this.d.b(strB);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final synchronized cm0 d() {
        try {
            if (this.e == null) {
                this.e = cm0.Q(this.b, 1, 1, this.c);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.e;
    }
}
