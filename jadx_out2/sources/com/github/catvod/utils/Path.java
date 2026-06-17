package com.github.catvod.utils;

import android.os.Environment;
import com.github.catvod.utils.Path;
import defpackage.g02;
import defpackage.yj1;
import java.io.ByteArrayOutputStream;
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ int a(File file, File file2) {
        if (file.isDirectory() && file2.isFile()) {
            return -1;
        }
        if (file.isFile() && file2.isDirectory()) {
            return 1;
        }
        return file.getName().toLowerCase().compareTo(file2.getName().toLowerCase());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static File cache(String str) {
        return new File(cache(), str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static File epg() {
        return mkdir(new File(cache() + File.separator + "epg"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean exists(File file) {
        return file != null && file.exists() && file.length() > 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static File exo() {
        return mkdir(new File(cache() + File.separator + "exo"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static File files(String str) {
        return new File(files(), str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static File jar() {
        return mkdir(new File(cache() + File.separator + "jar"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static File jpa() {
        return mkdir(new File(cache() + File.separator + "jpa"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static File js() {
        return mkdir(new File(cache() + File.separator + "js"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List<File> list(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            sort(fileArrListFiles);
        }
        return fileArrListFiles == null ? new ArrayList() : Arrays.asList(fileArrListFiles);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static File local(String str) {
        String strReplace = str.replace("file:/", "");
        File file = new File(root(), strReplace);
        return file.exists() ? file : new File(strReplace);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static File mkdir(File file) {
        if (file != null && !file.exists() && file.mkdirs()) {
            g02.b(TAG).g("Created dir:" + file);
        }
        return file;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void move(File file, File file2) {
        if (file.renameTo(file2)) {
            return;
        }
        copy(file, file2);
        clear(file);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static File py() {
        return mkdir(new File(cache() + File.separator + "py"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String read(File file) {
        try {
            return new String(readToByte(file), StandardCharsets.UTF_8);
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:28:0x002f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static byte[] readToByte(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
            if (inputStream != null) {
            }
            throw th;
        }
        try {
            byte[] bArr = new byte[Http2.INITIAL_MAX_FRAME_SIZE];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    inputStream.close();
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr, 0, i);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } finally {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static File root(String str, String str2) {
        return new File(mkdir(new File(root(), str)), str2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String rootPath() {
        return root().getAbsolutePath();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static File so() {
        return mkdir(new File(files() + File.separator + "so"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void sort(File[] fileArr) {
        Arrays.sort(fileArr, new Comparator() { // from class: e93
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Path.a((File) obj, (File) obj2);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static File thunder() {
        return mkdir(new File(cache() + File.separator + "thunder"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static File tv() {
        return mkdir(new File(root() + File.separator + "TV"));
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
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
