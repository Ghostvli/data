package defpackage;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zz1 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
    */
    public static String c() {
        BufferedReader bufferedReader;
        String line;
        Process processExec;
        BufferedReader bufferedReader2;
        StringBuilder sb = new StringBuilder();
        try {
            processExec = Runtime.getRuntime().exec(new String[]{"logcat", "-d", "-t", "2000", "-v", "time", "*:W"});
            bufferedReader2 = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
        } catch (Exception e) {
            sb.append("Failed to collect logcat: ");
            sb.append(e.getMessage());
        }
        while (true) {
            String line2 = bufferedReader2.readLine();
            if (line2 == null) {
                break;
            }
            sb.append(line2);
            sb.append("\n");
            if (sb.length() == 0) {
                sb.append("(No WARN/ERROR logcat entries)\n\n");
            }
            sb.append("===== Logcat (app verbose, last 500) =====\n");
            Process processExec2 = Runtime.getRuntime().exec(new String[]{"logcat", "-d", "-t", "500", "-v", "time", "-s", "MpvEngine:V", "CTC:V", "HWSpider:V", "ZTESpider:V", "SpiderDebug:V", "FileLogAdapter:V", "CrashActivity:V", "PlayerManager:V", "Proxy:V", "TsProxy:V"});
            bufferedReader = new BufferedReader(new InputStreamReader(processExec2.getInputStream()));
            while (true) {
                line = bufferedReader.readLine();
                if (line != null) {
                    break;
                }
                sb.append(line);
                sb.append("\n");
                return sb.toString();
            }
            bufferedReader.close();
            processExec2.destroy();
            return sb.toString();
        }
        bufferedReader2.close();
        processExec.destroy();
        if (sb.length() == 0) {
        }
        sb.append("===== Logcat (app verbose, last 500) =====\n");
        Process processExec22 = Runtime.getRuntime().exec(new String[]{"logcat", "-d", "-t", "500", "-v", "time", "-s", "MpvEngine:V", "CTC:V", "HWSpider:V", "ZTESpider:V", "SpiderDebug:V", "FileLogAdapter:V", "CrashActivity:V", "PlayerManager:V", "Proxy:V", "TsProxy:V"});
        bufferedReader = new BufferedReader(new InputStreamReader(processExec22.getInputStream()));
        while (true) {
            line = bufferedReader.readLine();
            if (line != null) {
            }
            return sb.toString();
            sb.append(line);
            sb.append("\n");
        }
        bufferedReader.close();
        processExec22.destroy();
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static File e(Context context) {
        return g(context, a(context));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String f(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "unknown";
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
