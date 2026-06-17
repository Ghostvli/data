package defpackage;

import android.media.DeniedByServerException;
import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import android.os.Build;
import android.os.SystemClock;
import defpackage.ag2;
import defpackage.gf0;
import defpackage.ja0;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ap0 {
    public static ag2.b a(aa0 aa0Var, String str, byte[] bArr, Map map) throws Throwable {
        ja0 ja0Var;
        ha0 ha0Var;
        ne4 ne4Var = new ne4(aa0Var);
        ja0 ja0VarA = new ja0.b().j(str).e(map).d(2).c(bArr).b(1).a();
        int i = 0;
        ja0 ja0VarA2 = ja0VarA;
        while (true) {
            try {
                ha0 ha0Var2 = new ha0(ne4Var, ja0VarA2);
                try {
                } catch (og1 e) {
                    e = e;
                    ha0Var = ha0Var2;
                    ja0Var = ja0VarA;
                } catch (Throwable th) {
                    th = th;
                    ha0Var = ha0Var2;
                }
                try {
                    ja0Var = ja0VarA;
                    ha0Var = ha0Var2;
                    try {
                        try {
                            ag2.b bVarC = new ag2.b.a(dn.b(ha0Var2)).d(new ty1(-1L, ja0Var, ne4Var.t(), ne4Var.u(), SystemClock.elapsedRealtime(), 0L, r0.length)).c();
                            fy4.p(ha0Var);
                            return bVarC;
                        } catch (og1 e2) {
                            e = e2;
                            String strC = c(e, i);
                            if (strC == null) {
                                throw e;
                            }
                            i++;
                            ja0VarA2 = ja0VarA2.a().j(strC).a();
                            try {
                                fy4.p(ha0Var);
                                ja0VarA = ja0Var;
                            } catch (Exception e3) {
                                e = e3;
                                throw new bg2(ja0Var, ne4Var.t(), ne4Var.o(), ne4Var.h(), e);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fy4.p(ha0Var);
                        throw th;
                    }
                } catch (og1 e4) {
                    e = e4;
                    ja0Var = ja0VarA;
                    ha0Var = ha0Var2;
                } catch (Throwable th3) {
                    th = th3;
                    ha0Var = ha0Var2;
                    fy4.p(ha0Var);
                    throw th;
                }
                ja0VarA = ja0Var;
            } catch (Exception e5) {
                e = e5;
                ja0Var = ja0VarA;
            }
        }
    }

    public static int b(Throwable th, int i) {
        if (th instanceof MediaDrm.MediaDrmStateException) {
            return fy4.j0(fy4.k0(((MediaDrm.MediaDrmStateException) th).getDiagnosticInfo()));
        }
        if (th instanceof MediaDrmResetException) {
            return 6006;
        }
        if ((th instanceof NotProvisionedException) || d(th)) {
            return 6002;
        }
        if (th instanceof DeniedByServerException) {
            return 6007;
        }
        if (th instanceof zw4) {
            return 6001;
        }
        if (th instanceof gf0.e) {
            return 6003;
        }
        if (th instanceof ir1) {
            return 6008;
        }
        if (i == 1) {
            return 6006;
        }
        if (i == 2) {
            return 6004;
        }
        if (i == 3) {
            return 6002;
        }
        d04.a();
        return 0;
    }

    public static String c(og1 og1Var, int i) {
        Map map;
        List list;
        int i2 = og1Var.i;
        if ((i2 != 307 && i2 != 308) || i >= 5 || (map = og1Var.k) == null || (list = (List) map.get("Location")) == null || list.isEmpty()) {
            return null;
        }
        return (String) list.get(0);
    }

    public static boolean d(Throwable th) {
        return Build.VERSION.SDK_INT == 34 && (th instanceof NoSuchMethodError) && th.getMessage() != null && th.getMessage().contains("Landroid/media/NotProvisionedException;.<init>(");
    }

    public static boolean e(Throwable th) {
        return Build.VERSION.SDK_INT == 34 && (th instanceof NoSuchMethodError) && th.getMessage() != null && th.getMessage().contains("Landroid/media/ResourceBusyException;.<init>(");
    }
}
