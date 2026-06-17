package defpackage;

import android.content.Context;
import android.os.Environment;
import com.thegrizzlylabs.sardineandroid.util.SardineUtil;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class o01 implements yz1 {
    public final File a;
    public final SimpleDateFormat b;
    public final Object c = new Object();

    public o01(Context context) {
        File fileE = e(context);
        this.a = new File(fileE, "app_log_" + new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date()) + ".txt");
        this.b = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault());
        f(fileE);
    }

    public static File c(Context context) {
        return new File(e(context), "crash_log.txt");
    }

    public static File d(Context context) {
        File[] fileArrListFiles = e(context).listFiles();
        File file = null;
        if (fileArrListFiles == null) {
            return null;
        }
        long jLastModified = 0;
        for (File file2 : fileArrListFiles) {
            if (file2.getName().startsWith("app_log_") && file2.getName().endsWith(".txt") && file2.lastModified() > jLastModified) {
                jLastModified = file2.lastModified();
                file = file2;
            }
        }
        return file;
    }

    public static File e(Context context) {
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        if (externalFilesDir == null) {
            externalFilesDir = context.getFilesDir();
        }
        File file = new File(externalFilesDir, "app_logs");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static void g(Context context, String str) {
        try {
            FileWriter fileWriter = new FileWriter(c(context), true);
            try {
                String str2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
                fileWriter.write("\n========== CRASH ==========\n");
                fileWriter.write("Time: " + str2 + "\n");
                fileWriter.write(str);
                fileWriter.write("\n===========================\n");
                fileWriter.flush();
                fileWriter.close();
            } finally {
            }
        } catch (IOException unused) {
        }
    }

    @Override // defpackage.yz1
    public void a(int i, String str, String str2) {
        synchronized (this.c) {
            try {
                if (this.a.length() > 2097152) {
                    return;
                }
                FileWriter fileWriter = new FileWriter(this.a, true);
                String strValueOf = i != 2 ? i != 3 ? i != 4 ? i != 5 ? i != 6 ? String.valueOf(i) : "E" : "W" : "I" : SardineUtil.DEFAULT_NAMESPACE_PREFIX : "V";
                fileWriter.write(this.b.format(new Date()));
                fileWriter.write(" ");
                fileWriter.write(strValueOf);
                fileWriter.write(ServiceReference.DELIMITER);
                if (str == null) {
                    str = "TV";
                }
                fileWriter.write(str);
                fileWriter.write(": ");
                fileWriter.write(str2);
                fileWriter.write("\n");
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // defpackage.yz1
    public boolean b(int i, String str) {
        return true;
    }

    public final void f(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - 259200000;
        for (File file2 : fileArrListFiles) {
            if (file2.getName().startsWith("app_log_") && file2.getName().endsWith(".txt")) {
                try {
                    if (new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).parse(file2.getName().replace("app_log_", "").replace(".txt", "")).getTime() < jCurrentTimeMillis) {
                        file2.delete();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }
}
