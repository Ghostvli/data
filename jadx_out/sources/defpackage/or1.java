package defpackage;

import android.content.Context;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class or1 {
    public static boolean a = false;
    public static boolean b = false;
    public static boolean c = true;
    public static boolean d;
    public static p22 f;
    public static o22 g;
    public static volatile s23 h;
    public static volatile r23 i;
    public static ThreadLocal j;
    public static jb e = jb.AUTOMATIC;
    public static jp3 k = new sk4();

    public static /* synthetic */ File a(Context context) {
        return new File(context.getCacheDir(), "lottie_network_cache");
    }

    public static void b(String str) {
        if (b) {
            g().a(str);
        }
    }

    public static float c(String str) {
        if (b) {
            return g().b(str);
        }
        return 0.0f;
    }

    public static jb d() {
        return e;
    }

    public static boolean e() {
        return d;
    }

    public static jp3 f() {
        return k;
    }

    public static w22 g() {
        w22 w22Var = (w22) j.get();
        if (w22Var != null) {
            return w22Var;
        }
        w22 w22Var2 = new w22();
        j.set(w22Var2);
        return w22Var2;
    }

    public static boolean h() {
        return b;
    }

    public static r23 i(Context context) {
        r23 r23Var;
        if (!c) {
            return null;
        }
        final Context applicationContext = context.getApplicationContext();
        r23 r23Var2 = i;
        if (r23Var2 != null) {
            return r23Var2;
        }
        synchronized (r23.class) {
            try {
                r23Var = i;
                if (r23Var == null) {
                    o22 o22Var = g;
                    if (o22Var == null) {
                        o22Var = new o22() { // from class: mr1
                            @Override // defpackage.o22
                            public final File a() {
                                return or1.a(applicationContext);
                            }
                        };
                    }
                    r23Var = new r23(o22Var);
                    i = r23Var;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return r23Var;
    }

    public static s23 j(Context context) {
        s23 s23Var;
        s23 s23Var2 = h;
        if (s23Var2 != null) {
            return s23Var2;
        }
        synchronized (s23.class) {
            try {
                s23Var = h;
                if (s23Var == null) {
                    r23 r23VarI = i(context);
                    p22 kg0Var = f;
                    if (kg0Var == null) {
                        kg0Var = new kg0();
                    }
                    s23Var = new s23(r23VarI, kg0Var);
                    h = s23Var;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return s23Var;
    }
}
