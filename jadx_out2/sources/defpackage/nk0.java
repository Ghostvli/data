package defpackage;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x007b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x007d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x007f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:61:0x009b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:62:0x001b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:65:0x001b */
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
    */
    public static synchronized a a() {
        ?? r4;
        RandomAccessFile randomAccessFile;
        byte[] bArr = new byte[20];
        File file = new File(Environment.getRootDirectory(), "lib/libc.so");
        if (file.canRead()) {
            ?? r42 = 0;
            r42 = 0;
            r42 = 0;
            r42 = 0;
            try {
                try {
                    try {
                        randomAccessFile = new RandomAccessFile(file, "r");
                    } catch (IOException e) {
                        e.printStackTrace();
                        r42 = r42;
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                } catch (IOException e3) {
                    e = e3;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                randomAccessFile.readFully(bArr);
                ?? r43 = 8;
                r43 = 8;
                r43 = 8;
                r43 = 8;
                int i = bArr[18] | (bArr[19] << 8);
                if (i == 3) {
                    a = a.X86;
                } else if (i == 8) {
                    a = a.MIPS;
                } else if (i == 40) {
                    a = a.ARM;
                } else if (i != 183) {
                    StringBuilder sb = new StringBuilder("libc.so is unknown arch: ");
                    sb.append(Integer.toHexString(i));
                    Log.e("NativeBitmapFactory", sb.toString());
                    r43 = sb;
                } else {
                    a = a.ARM64;
                }
                randomAccessFile.close();
                r42 = r43;
            } catch (FileNotFoundException e4) {
                e = e4;
                r42 = randomAccessFile;
                e.printStackTrace();
                r4 = r42;
            } catch (IOException e5) {
                e = e5;
                r42 = randomAccessFile;
                e.printStackTrace();
                r4 = r42;
            } catch (Throwable th2) {
                th = th2;
                r42 = randomAccessFile;
                if (r42 != 0) {
                    try {
                        r42.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String b() {
        return Build.CPU_ABI;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean d() {
        return Build.MANUFACTURER.equalsIgnoreCase("MagicBox") && Build.PRODUCT.equalsIgnoreCase("MagicBox");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean e() {
        return Build.MANUFACTURER.equalsIgnoreCase("Xiaomi") && Build.PRODUCT.equalsIgnoreCase("dredd");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean f() {
        return e() || d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean g() {
        return (i("armeabi-v7a") || i("armeabi")) && a.ARM.equals(a());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean h() {
        return i("x86") || a.X86.equals(a());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean i(String str) {
        String strB = b();
        if (TextUtils.isEmpty(strB) || !strB.equalsIgnoreCase(str)) {
            return !TextUtils.isEmpty(c()) && strB.equalsIgnoreCase(str);
        }
        return true;
    }
}
