package defpackage;

import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class nk0 {
    public static a a = a.Unknown;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum a {
        Unknown,
        ARM,
        X86,
        MIPS,
        ARM64
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0084, code lost:
    
        if (r4 == 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0086, code lost:
    
        r4.close();
        r4 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x008d, code lost:
    
        if (r4 == 0) goto L64;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0077 -> B:61:0x009b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized nk0.a a() {
        /*
            java.lang.String r0 = "libc.so is unknown arch: "
            java.lang.Class<nk0> r1 = defpackage.nk0.class
            monitor-enter(r1)
            r2 = 20
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L74
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L74
            java.io.File r4 = android.os.Environment.getRootDirectory()     // Catch: java.lang.Throwable -> L74
            java.lang.String r5 = "lib/libc.so"
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L74
            boolean r4 = r3.canRead()     // Catch: java.lang.Throwable -> L74
            if (r4 == 0) goto L9b
            r4 = 0
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L7b java.io.IOException -> L7d java.io.FileNotFoundException -> L7f
            java.lang.String r6 = "r"
            r5.<init>(r3, r6)     // Catch: java.lang.Throwable -> L7b java.io.IOException -> L7d java.io.FileNotFoundException -> L7f
            r5.readFully(r2)     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L57 java.io.FileNotFoundException -> L5a
            r3 = 19
            r3 = r2[r3]     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L57 java.io.FileNotFoundException -> L5a
            r4 = 8
            int r3 = r3 << r4
            r6 = 18
            r2 = r2[r6]     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L57 java.io.FileNotFoundException -> L5a
            r2 = r2 | r3
            r3 = 3
            if (r2 == r3) goto L6c
            if (r2 == r4) goto L67
            r3 = 40
            if (r2 == r3) goto L62
            r3 = 183(0xb7, float:2.56E-43)
            if (r2 == r3) goto L5d
            java.lang.String r3 = "NativeBitmapFactory"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L57 java.io.FileNotFoundException -> L5a
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L57 java.io.FileNotFoundException -> L5a
            java.lang.String r0 = java.lang.Integer.toHexString(r2)     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L57 java.io.FileNotFoundException -> L5a
            r4.append(r0)     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L57 java.io.FileNotFoundException -> L5a
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L57 java.io.FileNotFoundException -> L5a
            android.util.Log.e(r3, r0)     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L57 java.io.FileNotFoundException -> L5a
            goto L70
        L54:
            r0 = move-exception
            r4 = r5
            goto L90
        L57:
            r0 = move-exception
            r4 = r5
            goto L81
        L5a:
            r0 = move-exception
            r4 = r5
            goto L8a
        L5d:
            nk0$a r0 = nk0.a.ARM64     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L57 java.io.FileNotFoundException -> L5a
            defpackage.nk0.a = r0     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L57 java.io.FileNotFoundException -> L5a
            goto L70
        L62:
            nk0$a r0 = nk0.a.ARM     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L57 java.io.FileNotFoundException -> L5a
            defpackage.nk0.a = r0     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L57 java.io.FileNotFoundException -> L5a
            goto L70
        L67:
            nk0$a r0 = nk0.a.MIPS     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L57 java.io.FileNotFoundException -> L5a
            defpackage.nk0.a = r0     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L57 java.io.FileNotFoundException -> L5a
            goto L70
        L6c:
            nk0$a r0 = nk0.a.X86     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L57 java.io.FileNotFoundException -> L5a
            defpackage.nk0.a = r0     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L57 java.io.FileNotFoundException -> L5a
        L70:
            r5.close()     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76
            goto L9b
        L74:
            r0 = move-exception
            goto L9f
        L76:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L74
            goto L9b
        L7b:
            r0 = move-exception
            goto L90
        L7d:
            r0 = move-exception
            goto L81
        L7f:
            r0 = move-exception
            goto L8a
        L81:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L7b
            if (r4 == 0) goto L9b
        L86:
            r4.close()     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76
            goto L9b
        L8a:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L7b
            if (r4 == 0) goto L9b
            goto L86
        L90:
            if (r4 == 0) goto L9a
            r4.close()     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L96
            goto L9a
        L96:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L74
        L9a:
            throw r0     // Catch: java.lang.Throwable -> L74
        L9b:
            nk0$a r0 = defpackage.nk0.a     // Catch: java.lang.Throwable -> L74
            monitor-exit(r1)
            return r0
        L9f:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L74
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nk0.a():nk0$a");
    }

    public static String b() {
        return Build.CPU_ABI;
    }

    public static String c() {
        try {
            Field declaredField = Build.class.getDeclaredField("CPU_ABI2");
            if (declaredField == null) {
                return null;
            }
            Object obj = declaredField.get(null);
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean d() {
        return Build.MANUFACTURER.equalsIgnoreCase("MagicBox") && Build.PRODUCT.equalsIgnoreCase("MagicBox");
    }

    public static boolean e() {
        return Build.MANUFACTURER.equalsIgnoreCase("Xiaomi") && Build.PRODUCT.equalsIgnoreCase("dredd");
    }

    public static boolean f() {
        return e() || d();
    }

    public static boolean g() {
        return (i("armeabi-v7a") || i("armeabi")) && a.ARM.equals(a());
    }

    public static boolean h() {
        return i("x86") || a.X86.equals(a());
    }

    public static boolean i(String str) {
        String strB = b();
        if (TextUtils.isEmpty(strB) || !strB.equalsIgnoreCase(str)) {
            return !TextUtils.isEmpty(c()) && strB.equalsIgnoreCase(str);
        }
        return true;
    }
}
