package defpackage;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zz1 {
    public static String a(Context context) {
        StringBuilder sb = new StringBuilder("========== Log Export ==========\nExport Time: ");
        sb.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()));
        sb.append("\nDevice: ");
        sb.append(Build.MANUFACTURER);
        sb.append(" ");
        sb.append(Build.MODEL);
        sb.append("\nOS: Android ");
        sb.append(Build.VERSION.RELEASE);
        sb.append(" (SDK ");
        sb.append(Build.VERSION.SDK_INT);
        sb.append(")\nApp Version: ");
        sb.append(f(context));
        sb.append("\n\n");
        String strB = b(context);
        if (!strB.isEmpty()) {
            sb.append("===== Crash Log =====\n");
            sb.append(strB);
            sb.append("\n");
        }
        sb.append("===== Logcat =====\n");
        sb.append(c());
        String strD = d(context);
        if (!strD.isEmpty()) {
            sb.append("===== Persisted App Log =====\n");
            sb.append(strD);
            sb.append("\n");
        }
        return sb.toString();
    }

    public static String b(Context context) {
        StringBuilder sb = new StringBuilder();
        File fileC = o01.c(context);
        if (fileC != null && fileC.exists()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(fileC));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                        sb.append("\n");
                    } finally {
                    }
                }
                bufferedReader.close();
            } catch (Exception e) {
                sb.append("Failed to read crash log: ");
                sb.append(e.getMessage());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:0|2|27|3|(11:4|(1:6)(1:31)|12|(1:14)|15|29|16|(4:17|(1:19)(1:32)|25|26)|22|25|26)|9|12|(0)|15|29|16|(5:17|(0)(0)|25|26|19)|22|25|26) */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00aa, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b3, code lost:
    
        r2.append("Failed to collect app logcat: ");
        r2.append(r0.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a3 A[Catch: Exception -> 0x00aa, LOOP:1: B:17:0x009d->B:19:0x00a3, LOOP_END, TryCatch #1 {Exception -> 0x00aa, blocks: (B:16:0x0061, B:17:0x009d, B:19:0x00a3, B:22:0x00ac), top: B:29:0x0061 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ac A[EDGE_INSN: B:32:0x00ac->B:22:0x00ac BREAK  A[LOOP:1: B:17:0x009d->B:19:0x00a3], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String c() {
        /*
            java.lang.String r1 = "\n"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.Runtime r0 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Exception -> L3c
            java.lang.String r3 = "logcat"
            java.lang.String r4 = "-d"
            java.lang.String r5 = "-t"
            java.lang.String r6 = "2000"
            java.lang.String r7 = "-v"
            java.lang.String r8 = "time"
            java.lang.String r9 = "*:W"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4, r5, r6, r7, r8, r9}     // Catch: java.lang.Exception -> L3c
            java.lang.Process r0 = r0.exec(r3)     // Catch: java.lang.Exception -> L3c
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Exception -> L3c
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Exception -> L3c
            java.io.InputStream r5 = r0.getInputStream()     // Catch: java.lang.Exception -> L3c
            r4.<init>(r5)     // Catch: java.lang.Exception -> L3c
            r3.<init>(r4)     // Catch: java.lang.Exception -> L3c
        L2f:
            java.lang.String r4 = r3.readLine()     // Catch: java.lang.Exception -> L3c
            if (r4 == 0) goto L3e
            r2.append(r4)     // Catch: java.lang.Exception -> L3c
            r2.append(r1)     // Catch: java.lang.Exception -> L3c
            goto L2f
        L3c:
            r0 = move-exception
            goto L45
        L3e:
            r3.close()     // Catch: java.lang.Exception -> L3c
            r0.destroy()     // Catch: java.lang.Exception -> L3c
            goto L51
        L45:
            java.lang.String r3 = "Failed to collect logcat: "
            r2.append(r3)
            java.lang.String r0 = r0.getMessage()
            r2.append(r0)
        L51:
            int r0 = r2.length()
            if (r0 != 0) goto L5c
            java.lang.String r0 = "(No WARN/ERROR logcat entries)\n\n"
            r2.append(r0)
        L5c:
            java.lang.String r0 = "===== Logcat (app verbose, last 500) =====\n"
            r2.append(r0)
            java.lang.Runtime r0 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Exception -> Laa
            java.lang.String r3 = "logcat"
            java.lang.String r4 = "-d"
            java.lang.String r5 = "-t"
            java.lang.String r6 = "500"
            java.lang.String r7 = "-v"
            java.lang.String r8 = "time"
            java.lang.String r9 = "-s"
            java.lang.String r10 = "MpvEngine:V"
            java.lang.String r11 = "CTC:V"
            java.lang.String r12 = "HWSpider:V"
            java.lang.String r13 = "ZTESpider:V"
            java.lang.String r14 = "SpiderDebug:V"
            java.lang.String r15 = "FileLogAdapter:V"
            java.lang.String r16 = "CrashActivity:V"
            java.lang.String r17 = "PlayerManager:V"
            java.lang.String r18 = "Proxy:V"
            java.lang.String r19 = "TsProxy:V"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19}     // Catch: java.lang.Exception -> Laa
            java.lang.Process r0 = r0.exec(r3)     // Catch: java.lang.Exception -> Laa
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Exception -> Laa
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Exception -> Laa
            java.io.InputStream r5 = r0.getInputStream()     // Catch: java.lang.Exception -> Laa
            r4.<init>(r5)     // Catch: java.lang.Exception -> Laa
            r3.<init>(r4)     // Catch: java.lang.Exception -> Laa
        L9d:
            java.lang.String r4 = r3.readLine()     // Catch: java.lang.Exception -> Laa
            if (r4 == 0) goto Lac
            r2.append(r4)     // Catch: java.lang.Exception -> Laa
            r2.append(r1)     // Catch: java.lang.Exception -> Laa
            goto L9d
        Laa:
            r0 = move-exception
            goto Lb3
        Lac:
            r3.close()     // Catch: java.lang.Exception -> Laa
            r0.destroy()     // Catch: java.lang.Exception -> Laa
            goto Lbf
        Lb3:
            java.lang.String r1 = "Failed to collect app logcat: "
            r2.append(r1)
            java.lang.String r0 = r0.getMessage()
            r2.append(r0)
        Lbf:
            java.lang.String r0 = r2.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.zz1.c():java.lang.String");
    }

    public static String d(Context context) {
        StringBuilder sb = new StringBuilder();
        File fileD = o01.d(context);
        if (fileD != null && fileD.exists()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(fileD));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                        sb.append("\n");
                    } finally {
                    }
                }
                bufferedReader.close();
            } catch (Exception e) {
                sb.append("Failed to read persisted log: ");
                sb.append(e.getMessage());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static File e(Context context) {
        return g(context, a(context));
    }

    public static String f(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "unknown";
        }
    }

    public static File g(Context context, String str) {
        String str2 = "sggc_iptv_log_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date()) + ".txt";
        try {
            File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
            if (externalFilesDir == null) {
                externalFilesDir = context.getFilesDir();
            }
            if (!externalFilesDir.exists()) {
                externalFilesDir.mkdirs();
            }
            File file = new File(externalFilesDir, str2);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(str.getBytes("UTF-8"));
            fileOutputStream.close();
            return file;
        } catch (Exception unused) {
            return null;
        }
    }
}
