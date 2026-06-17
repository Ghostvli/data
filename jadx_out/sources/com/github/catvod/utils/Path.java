package com.github.catvod.utils;

import android.os.Environment;
import com.github.catvod.utils.Path;
import defpackage.g02;
import defpackage.yj1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal.http2.Http2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Path {
    private static final String TAG = "Path";

    public static /* synthetic */ int a(File file, File file2) {
        if (file.isDirectory() && file2.isFile()) {
            return -1;
        }
        if (file.isFile() && file2.isDirectory()) {
            return 1;
        }
        return file.getName().toLowerCase().compareTo(file2.getName().toLowerCase());
    }

    public static File cache(String str) {
        return new File(cache(), str);
    }

    public static void clear(File file) {
        if (file == null) {
            return;
        }
        if (file.isDirectory()) {
            Iterator<File> it = list(file).iterator();
            while (it.hasNext()) {
                clear(it.next());
            }
        }
        if (file.delete()) {
            g02.b(TAG).g("Deleted:" + file);
        }
    }

    public static void copy(InputStream inputStream, File file) {
        try {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(create(file));
                try {
                    byte[] bArr = new byte[Http2.INITIAL_MAX_FRAME_SIZE];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            fileOutputStream.close();
                            inputStream.close();
                            return;
                        }
                        fileOutputStream.write(bArr, 0, i);
                    }
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
        }
    }

    public static File create(File file) {
        try {
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                mkdir(parentFile);
            }
            if (file.exists()) {
                clear(file);
            }
            if (file.createNewFile()) {
                g02.b(TAG).g("Create:" + file);
            }
            file.setReadable(true);
            file.setWritable(true);
            file.setExecutable(true);
            Shell.exec("chmod 777 " + file);
        } catch (IOException unused) {
        }
        return file;
    }

    public static File epg() {
        return mkdir(new File(cache() + File.separator + "epg"));
    }

    public static boolean exists(File file) {
        return file != null && file.exists() && file.length() > 0;
    }

    public static File exo() {
        return mkdir(new File(cache() + File.separator + "exo"));
    }

    public static File files(String str) {
        return new File(files(), str);
    }

    public static File jar() {
        return mkdir(new File(cache() + File.separator + "jar"));
    }

    public static File jpa() {
        return mkdir(new File(cache() + File.separator + "jpa"));
    }

    public static File js() {
        return mkdir(new File(cache() + File.separator + "js"));
    }

    public static List<File> list(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            sort(fileArrListFiles);
        }
        return fileArrListFiles == null ? new ArrayList() : Arrays.asList(fileArrListFiles);
    }

    public static File local(String str) {
        String strReplace = str.replace("file:/", "");
        File file = new File(root(), strReplace);
        return file.exists() ? file : new File(strReplace);
    }

    private static File mkdir(File file) {
        if (file != null && !file.exists() && file.mkdirs()) {
            g02.b(TAG).g("Created dir:" + file);
        }
        return file;
    }

    public static void move(File file, File file2) {
        if (file.renameTo(file2)) {
            return;
        }
        copy(file, file2);
        clear(file);
    }

    public static File py() {
        return mkdir(new File(cache() + File.separator + "py"));
    }

    public static String read(File file) {
        try {
            return new String(readToByte(file), StandardCharsets.UTF_8);
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x002f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static byte[] readToByte(java.io.InputStream r4) throws java.io.IOException {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L22
            r0.<init>()     // Catch: java.lang.Throwable -> L22
            r1 = 16384(0x4000, float:2.2959E-41)
            byte[] r1 = new byte[r1]     // Catch: java.lang.Throwable -> L15
        L9:
            int r2 = r4.read(r1)     // Catch: java.lang.Throwable -> L15
            r3 = -1
            if (r2 == r3) goto L17
            r3 = 0
            r0.write(r1, r3, r2)     // Catch: java.lang.Throwable -> L15
            goto L9
        L15:
            r1 = move-exception
            goto L24
        L17:
            byte[] r1 = r0.toByteArray()     // Catch: java.lang.Throwable -> L15
            r0.close()     // Catch: java.lang.Throwable -> L22
            r4.close()
            return r1
        L22:
            r0 = move-exception
            goto L2d
        L24:
            r0.close()     // Catch: java.lang.Throwable -> L28
            goto L2c
        L28:
            r0 = move-exception
            r1.addSuppressed(r0)     // Catch: java.lang.Throwable -> L22
        L2c:
            throw r1     // Catch: java.lang.Throwable -> L22
        L2d:
            if (r4 == 0) goto L37
            r4.close()     // Catch: java.lang.Throwable -> L33
            goto L37
        L33:
            r4 = move-exception
            r0.addSuppressed(r4)
        L37:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.utils.Path.readToByte(java.io.InputStream):byte[]");
    }

    public static File root(String str, String str2) {
        return new File(mkdir(new File(root(), str)), str2);
    }

    public static String rootPath() {
        return root().getAbsolutePath();
    }

    public static File so() {
        return mkdir(new File(files() + File.separator + "so"));
    }

    public static void sort(File[] fileArr) {
        Arrays.sort(fileArr, new Comparator() { // from class: e93
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Path.a((File) obj, (File) obj2);
            }
        });
    }

    public static File thunder() {
        return mkdir(new File(cache() + File.separator + "thunder"));
    }

    public static File tv() {
        return mkdir(new File(root() + File.separator + "TV"));
    }

    public static File write(File file, InputStream inputStream) {
        try {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(create(file));
                try {
                    byte[] bArr = new byte[Http2.INITIAL_MAX_FRAME_SIZE];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            fileOutputStream.close();
                            inputStream.close();
                            return file;
                        }
                        fileOutputStream.write(bArr, 0, i);
                    }
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            return file;
        }
    }

    public static File cache() {
        return yj1.a().getCacheDir();
    }

    public static File files() {
        return yj1.a().getFilesDir();
    }

    public static String read(InputStream inputStream) {
        try {
            return new String(readToByte(inputStream), StandardCharsets.UTF_8);
        } catch (IOException unused) {
            return "";
        }
    }

    public static File root(String str) {
        return new File(root(), str);
    }

    public static File root() {
        return Environment.getExternalStorageDirectory();
    }

    public static boolean exists(String str) {
        return new File(str.replace("file://", "")).exists();
    }

    public static File epg(String str) {
        return new File(epg(), str);
    }

    public static File jar(String str) {
        return new File(jar(), Util.md5(str).concat(".jar"));
    }

    public static File js(String str) {
        return new File(js(), str);
    }

    public static File py(String str) {
        return new File(py(), str);
    }

    public static File thunder(String str) {
        return mkdir(new File(thunder(), str));
    }

    public static byte[] readToByte(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                byte[] toByte = readToByte(fileInputStream);
                fileInputStream.close();
                return toByte;
            } finally {
            }
        } catch (IOException unused) {
            return new byte[0];
        }
    }

    public static void copy(File file, File file2) {
        try {
            copy(new FileInputStream(file), file2);
        } catch (IOException unused) {
        }
    }

    public static File write(File file, byte[] bArr) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(create(file));
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                fileOutputStream.close();
                return file;
            } finally {
            }
        } catch (IOException unused) {
            return file;
        }
    }
}
