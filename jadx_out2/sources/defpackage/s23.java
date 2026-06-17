package defpackage;

import android.content.Context;
import android.util.Pair;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipInputStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class s23 {
    public final r23 a;
    public final p22 b;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        static {
            int[] iArr = new int[l01.values().length];
            a = iArr;
            try {
                iArr[l01.ZIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[l01.GZIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public s23(r23 r23Var, p22 p22Var) {
        this.a = r23Var;
        this.b = p22Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final f12 a(Context context, String str, String str2) {
        r23 r23Var;
        Pair pairA;
        r22 r22VarB;
        if (str2 == null || (r23Var = this.a) == null || (pairA = r23Var.a(str)) == null) {
            return null;
        }
        l01 l01Var = (l01) pairA.first;
        InputStream inputStream = (InputStream) pairA.second;
        int i = a.a[l01Var.ordinal()];
        if (i == 1) {
            r22VarB = o12.B(context, new ZipInputStream(inputStream), str2);
        } else if (i != 2) {
            r22VarB = o12.p(inputStream, str2);
        } else {
            try {
                r22VarB = o12.p(new GZIPInputStream(inputStream), str2);
            } catch (IOException e) {
                r22VarB = new r22((Throwable) e);
            }
        }
        if (r22VarB.b() != null) {
            return (f12) r22VarB.b();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    public final r22 b(Context context, String str, String str2) {
        r22 r22Var;
        k02.a("Fetching " + str);
        Closeable closeable = null;
        try {
            try {
                j22 j22VarA = this.b.a(str);
                if (j22VarA.isSuccessful()) {
                    r22Var = e(context, str, j22VarA.H(), j22VarA.D(), str2);
                    StringBuilder sb = new StringBuilder("Completed fetch from network. Success: ");
                    sb.append(r22Var.b() != null);
                    k02.a(sb.toString());
                } else {
                    r22Var = new r22((Throwable) new IllegalArgumentException(j22VarA.E()));
                }
                try {
                    j22VarA.close();
                    return r22Var;
                } catch (IOException e) {
                    k02.d("LottieFetchResult close failed ", e);
                    return r22Var;
                }
            } catch (Throwable th) {
                if (0 == 0) {
                    throw th;
                }
                try {
                    closeable.close();
                    throw th;
                } catch (IOException e2) {
                    k02.d("LottieFetchResult close failed ", e2);
                    throw th;
                }
            }
        } catch (Exception e3) {
            r22 r22Var2 = new r22((Throwable) e3);
            if (0 != 0) {
                try {
                    closeable.close();
                } catch (IOException e4) {
                    k02.d("LottieFetchResult close failed ", e4);
                }
            }
            return r22Var2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public r22 c(Context context, String str, String str2) {
        f12 f12VarA = a(context, str, str2);
        if (f12VarA != null) {
            return new r22(f12VarA);
        }
        k02.a("Animation for " + str + " not found in cache. Fetching from network.");
        return b(context, str, str2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final r22 d(String str, InputStream inputStream, String str2) {
        r23 r23Var;
        return (str2 == null || (r23Var = this.a) == null) ? o12.p(new GZIPInputStream(inputStream), null) : o12.p(new GZIPInputStream(new FileInputStream(r23Var.g(str, inputStream, l01.GZIP))), str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final r22 e(Context context, String str, InputStream inputStream, String str2, String str3) {
        r22 r22VarG;
        l01 l01Var;
        r23 r23Var;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (str2.contains("application/zip") || str2.contains("application/x-zip") || str2.contains("application/x-zip-compressed") || str.split("\\?")[0].endsWith(".lottie")) {
            k02.a("Handling zip response.");
            l01 l01Var2 = l01.ZIP;
            r22VarG = g(context, str, inputStream, str3);
            l01Var = l01Var2;
        } else if (str2.contains("application/gzip") || str2.contains("application/x-gzip") || str.split("\\?")[0].endsWith(".tgs")) {
            k02.a("Handling gzip response.");
            l01Var = l01.GZIP;
            r22VarG = d(str, inputStream, str3);
        } else {
            k02.a("Received json response.");
            l01Var = l01.JSON;
            r22VarG = f(str, inputStream, str3);
        }
        if (str3 != null && r22VarG.b() != null && (r23Var = this.a) != null) {
            r23Var.f(str, l01Var);
        }
        return r22VarG;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final r22 f(String str, InputStream inputStream, String str2) {
        r23 r23Var;
        return (str2 == null || (r23Var = this.a) == null) ? o12.p(inputStream, null) : o12.p(new FileInputStream(r23Var.g(str, inputStream, l01.JSON).getAbsolutePath()), str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final r22 g(Context context, String str, InputStream inputStream, String str2) {
        r23 r23Var;
        return (str2 == null || (r23Var = this.a) == null) ? o12.B(context, new ZipInputStream(inputStream), null) : o12.B(context, new ZipInputStream(new FileInputStream(r23Var.g(str, inputStream, l01.ZIP))), str);
    }
}
