package defpackage;

import android.text.TextUtils;
import android.util.Log;
import java.net.UnknownHostException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class xz1 {
    public static int b = 0;
    public static boolean c = true;
    public static final Object a = new Object();
    public static a d = a.a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        public static final a a = new C0135a();

        /* JADX INFO: renamed from: xz1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class C0135a implements a {
            @Override // xz1.a
            public void a(String str, String str2, Throwable th) {
                Log.w(str, xz1.a(str2, th));
            }

            @Override // xz1.a
            public void b(String str, String str2, Throwable th) {
                Log.e(str, xz1.a(str2, th));
            }

            @Override // xz1.a
            public void c(String str, String str2, Throwable th) {
                Log.d(str, xz1.a(str2, th));
            }

            @Override // xz1.a
            public void d(String str, String str2, Throwable th) {
                Log.i(str, xz1.a(str2, th));
            }
        }

        void a(String str, String str2, Throwable th);

        void b(String str, String str2, Throwable th);

        void c(String str, String str2, Throwable th);

        void d(String str, String str2, Throwable th);
    }

    public static String a(String str, Throwable th) {
        String strF = f(th);
        if (TextUtils.isEmpty(strF)) {
            return str;
        }
        return str + "\n  " + strF.replace("\n", "\n  ") + '\n';
    }

    public static void b(String str, String str2) {
        synchronized (a) {
            try {
                if (b == 0) {
                    d.c(str, str2, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void c(String str, String str2, Throwable th) {
        synchronized (a) {
            try {
                if (b == 0) {
                    d.c(str, str2, th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void d(String str, String str2) {
        synchronized (a) {
            try {
                if (b <= 3) {
                    d.b(str, str2, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void e(String str, String str2, Throwable th) {
        synchronized (a) {
            try {
                if (b <= 3) {
                    d.b(str, str2, th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static String f(Throwable th) {
        if (th == null) {
            return null;
        }
        synchronized (a) {
            try {
                if (h(th)) {
                    return "UnknownHostException (no network)";
                }
                if (c) {
                    return Log.getStackTraceString(th).trim().replace("\t", "    ");
                }
                return th.getMessage();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void g(String str, String str2) {
        synchronized (a) {
            try {
                if (b <= 1) {
                    d.d(str, str2, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean h(Throwable th) {
        while (th != null) {
            if (th instanceof UnknownHostException) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    public static void i(String str, String str2) {
        synchronized (a) {
            try {
                if (b <= 2) {
                    d.a(str, str2, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void j(String str, String str2, Throwable th) {
        synchronized (a) {
            try {
                if (b <= 2) {
                    d.a(str, str2, th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
