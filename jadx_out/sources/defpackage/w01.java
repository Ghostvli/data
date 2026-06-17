package defpackage;

import android.content.Intent;
import android.net.Uri;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.fongmi.android.tv.App;
import com.github.catvod.utils.Path;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Objects;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import okhttp3.internal.http2.Http2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class w01 {
    public static /* synthetic */ void b(final to toVar) {
        final String strD = d(h(Path.cache()));
        App.d(new Runnable() { // from class: u01
            @Override // java.lang.Runnable
            public final void run() {
                toVar.e(strD);
            }
        });
    }

    public static /* synthetic */ void c(to toVar) {
        Path.clear(Path.cache());
        Objects.requireNonNull(toVar);
        App.d(new dh(toVar));
    }

    public static String d(long j) {
        if (j <= 0) {
            return vr3.l(sm3.P);
        }
        double d = j;
        int iLog10 = (int) (Math.log10(d) / Math.log10(1024.0d));
        return new DecimalFormat("#,##0.#").format(d / Math.pow(1024.0d, iLog10)) + " " + new String[]{"bytes", "KB", "MB", "GB", "TB"}[iLog10];
    }

    public static void e(final to toVar) {
        ul4.c(new Runnable() { // from class: v01
            @Override // java.lang.Runnable
            public final void run() {
                w01.c(toVar);
            }
        });
    }

    public static long f(File file) {
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static void g(final to toVar) {
        ul4.c(new Runnable() { // from class: t01
            @Override // java.lang.Runnable
            public final void run() {
                w01.b(toVar);
            }
        });
    }

    public static long h(File file) {
        long jH = 0;
        if (file == null) {
            return 0L;
        }
        if (!file.isDirectory()) {
            return file.length();
        }
        Iterator<File> it = Path.list(file).iterator();
        while (it.hasNext()) {
            jH += h(it.next());
        }
        return jH;
    }

    public static String i(String str) {
        String strGuessContentTypeFromName = URLConnection.guessContentTypeFromName(str);
        return TextUtils.isEmpty(strGuessContentTypeFromName) ? "*/*" : strGuessContentTypeFromName;
    }

    public static Uri j(File file) {
        return FileProvider.h(App.b(), App.b().getPackageName() + ".provider", file);
    }

    public static File k(int i) {
        return Path.files("wallpaper_" + i);
    }

    public static File l() {
        return Path.files("wallpaper_cache");
    }

    public static void m(File file) {
        byte[] bArr = new byte[Http2.INITIAL_MAX_FRAME_SIZE];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(new FileOutputStream(file.getAbsolutePath() + ".gz"));
                while (true) {
                    try {
                        int i = fileInputStream.read(bArr);
                        if (i <= 0) {
                            gZIPOutputStream.close();
                            fileInputStream.close();
                            return;
                        }
                        gZIPOutputStream.write(bArr, 0, i);
                    } finally {
                    }
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Path.clear(file);
        }
    }

    public static void n(File file, File file2) {
        byte[] bArr = new byte[Http2.INITIAL_MAX_FRAME_SIZE];
        try {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(new BufferedInputStream(new FileInputStream(file)));
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                while (true) {
                    try {
                        int i = gZIPInputStream.read(bArr);
                        if (i == -1) {
                            bufferedOutputStream.close();
                            gZIPInputStream.close();
                            return;
                        }
                        bufferedOutputStream.write(bArr, 0, i);
                    } finally {
                    }
                }
            } finally {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void o(File file) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.addFlags(1);
        intent.setDataAndType(j(file), i(file.getName()));
        App.b().startActivity(intent);
    }

    public static void p(File file, File file2) {
        try {
            ZipFile zipFile = new ZipFile(file);
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                while (enumerationEntries.hasMoreElements()) {
                    ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    File file3 = new File(file2, zipEntryNextElement.getName());
                    if (zipEntryNextElement.isDirectory()) {
                        file3.mkdirs();
                    } else {
                        Path.copy(zipFile.getInputStream(zipEntryNextElement), file3);
                    }
                }
                zipFile.close();
            } finally {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
