package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import okio.internal.Buffer;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class o12 {
    public static final Map a = new HashMap();
    public static final Set b = new HashSet();
    public static final byte[] c = {80, 75, 3, 4};
    public static final byte[] d = {31, -117, 8};

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static t22 A(final Context context, final String str, final String str2) {
        return h(str2, new Callable() { // from class: h12
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return o12.b(context, str, str2);
            }
        }, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static r22 B(Context context, ZipInputStream zipInputStream, String str) {
        return C(context, zipInputStream, str, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static r22 C(Context context, ZipInputStream zipInputStream, String str, boolean z) {
        try {
            return D(context, zipInputStream, str);
        } finally {
            if (z) {
                uy4.c(zipInputStream);
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:72:0x014b A[Catch: IOException -> 0x02ad, TryCatch #4 {IOException -> 0x02ad, blocks: (B:7:0x0019, B:9:0x001f, B:12:0x0028, B:14:0x0034, B:75:0x017b, B:15:0x0039, B:17:0x0045, B:18:0x004a, B:20:0x0056, B:21:0x006f, B:24:0x0079, B:26:0x0081, B:28:0x0089, B:31:0x0093, B:33:0x009b, B:36:0x00a4, B:37:0x00a9, B:39:0x00bb, B:41:0x00dc, B:70:0x0141, B:72:0x014b, B:73:0x0168, B:69:0x0120, B:74:0x016c, B:5:0x000f, B:42:0x00e5, B:53:0x0106, B:68:0x011f, B:67:0x011c, B:64:0x0117, B:43:0x00ea, B:52:0x0103, B:63:0x0116, B:62:0x0113), top: B:131:0x000f, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static r22 D(Context context, ZipInputStream zipInputStream, String str) {
        f12 f12VarA;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        if (str == null) {
            f12VarA = null;
        } else {
            try {
                f12VarA = g12.b().a(str);
            } catch (IOException e) {
                return new r22((Throwable) e);
            }
        }
        if (f12VarA != null) {
            return new r22(f12VarA);
        }
        ZipEntry nextEntry = zipInputStream.getNextEntry();
        f12 f12Var = null;
        while (nextEntry != null) {
            String name = nextEntry.getName();
            if (name.contains("__MACOSX")) {
                zipInputStream.closeEntry();
            } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                zipInputStream.closeEntry();
            } else if (nextEntry.getName().contains(".json")) {
                f12Var = (f12) t(no1.J(Okio.buffer(Okio.source(zipInputStream))), null, false).b();
            } else if (name.contains(".png") || name.contains(".webp") || name.contains(".jpg") || name.contains(".jpeg")) {
                String[] strArrSplit = name.split(ServiceReference.DELIMITER);
                map.put(strArrSplit[strArrSplit.length - 1], BitmapFactory.decodeStream(zipInputStream));
            } else if (name.contains(".ttf") || name.contains(".otf")) {
                String[] strArrSplit2 = name.split(ServiceReference.DELIMITER);
                String str2 = strArrSplit2[strArrSplit2.length - 1];
                String str3 = str2.split("\\.")[0];
                if (context == null) {
                    return new r22((Throwable) new IllegalStateException("Unable to extract font " + str3 + " please pass a non-null Context parameter"));
                }
                File file = new File(context.getCacheDir(), str2);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[Buffer.SEGMENTING_THRESHOLD];
                            while (true) {
                                int i = zipInputStream.read(bArr);
                                if (i == -1) {
                                    break;
                                }
                                fileOutputStream2.write(bArr, 0, i);
                            }
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                            fileOutputStream.close();
                        } catch (Throwable th) {
                            try {
                                fileOutputStream2.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } finally {
                    }
                } catch (Throwable th3) {
                    k02.d("Unable to save font " + str3 + " to the temporary file: " + str2 + ". ", th3);
                    Typeface typefaceCreateFromFile = Typeface.createFromFile(file);
                    if (!file.delete()) {
                    }
                    map2.put(str3, typefaceCreateFromFile);
                    nextEntry = zipInputStream.getNextEntry();
                }
                Typeface typefaceCreateFromFile2 = Typeface.createFromFile(file);
                if (!file.delete()) {
                    k02.c("Failed to delete temp font file " + file.getAbsolutePath() + ".");
                }
                map2.put(str3, typefaceCreateFromFile2);
            } else {
                zipInputStream.closeEntry();
            }
            nextEntry = zipInputStream.getNextEntry();
        }
        if (f12Var == null) {
            return new r22((Throwable) new IllegalArgumentException("Unable to parse composition"));
        }
        for (Map.Entry entry : map.entrySet()) {
            l22 l22VarI = i(f12Var, (String) entry.getKey());
            if (l22VarI != null) {
                l22VarI.g(uy4.m((Bitmap) entry.getValue(), l22VarI.f(), l22VarI.d()));
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            boolean z = false;
            for (y31 y31Var : f12Var.g().values()) {
                if (y31Var.a().equals(entry2.getKey())) {
                    y31Var.e((Typeface) entry2.getValue());
                    z = true;
                }
            }
            if (!z) {
                k02.c("Parsed font for " + ((String) entry2.getKey()) + " however it was not found in the animation.");
            }
        }
        if (map.isEmpty()) {
            Iterator it = f12Var.j().entrySet().iterator();
            while (it.hasNext()) {
                l22 l22Var = (l22) ((Map.Entry) it.next()).getValue();
                if (l22Var == null) {
                    return null;
                }
                String strC = l22Var.c();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = true;
                options.inDensity = 160;
                if (strC.startsWith("data:") && strC.indexOf("base64,") > 0) {
                    try {
                        byte[] bArrDecode = Base64.decode(strC.substring(strC.indexOf(44) + 1), 0);
                        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options);
                        if (bitmapDecodeByteArray != null) {
                            l22Var.g(uy4.m(bitmapDecodeByteArray, l22Var.f(), l22Var.d()));
                        }
                    } catch (IllegalArgumentException e2) {
                        k02.d("data URL did not have correct base64 format.", e2);
                        return null;
                    }
                }
            }
        }
        if (str != null) {
            g12.b().c(str, f12Var);
        }
        return new r22(f12Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Boolean E(BufferedSource bufferedSource) {
        return H(bufferedSource, d);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean F(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Boolean G(BufferedSource bufferedSource) {
        return H(bufferedSource, c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Boolean H(BufferedSource bufferedSource, byte[] bArr) {
        try {
            BufferedSource bufferedSourcePeek = bufferedSource.peek();
            for (byte b2 : bArr) {
                if (bufferedSourcePeek.readByte() != b2) {
                    return Boolean.FALSE;
                }
            }
            bufferedSourcePeek.close();
            return Boolean.TRUE;
        } catch (Exception e) {
            k02.b("Failed to check zip file header", e);
            return Boolean.FALSE;
        } catch (NoSuchMethodError unused) {
            return Boolean.FALSE;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void I(boolean z) {
        ArrayList arrayList = new ArrayList(b);
        if (arrayList.size() <= 0) {
            return;
        }
        w82.a(arrayList.get(0));
        throw null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String J(Context context, int i) {
        StringBuilder sb = new StringBuilder("rawRes");
        sb.append(F(context) ? "_night_" : "_day_");
        sb.append(i);
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(String str, AtomicBoolean atomicBoolean, Throwable th) {
        Map map = a;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            I(true);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ r22 b(Context context, String str, String str2) {
        r22 r22VarC = or1.j(context).c(context, str, str2);
        if (str2 != null && r22VarC.b() != null) {
            g12.b().c(str2, (f12) r22VarC.b());
        }
        return r22VarC;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ r22 c(WeakReference weakReference, Context context, int i, String str) {
        Context context2 = (Context) weakReference.get();
        if (context2 != null) {
            context = context2;
        }
        return y(context, i, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void g(String str, AtomicBoolean atomicBoolean, f12 f12Var) {
        Map map = a;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            I(true);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static t22 h(final String str, Callable callable, Runnable runnable) {
        f12 f12VarA = str == null ? null : g12.b().a(str);
        t22 t22Var = f12VarA != null ? new t22(f12VarA) : null;
        if (str != null) {
            Map map = a;
            if (map.containsKey(str)) {
                t22Var = (t22) map.get(str);
            }
        }
        if (t22Var != null) {
            if (runnable != null) {
                runnable.run();
            }
            return t22Var;
        }
        t22 t22Var2 = new t22(callable);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            t22Var2.d(new m22() { // from class: l12
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.m22
                public final void onResult(Object obj) {
                    o12.g(str, atomicBoolean, (f12) obj);
                }
            });
            t22Var2.c(new m22() { // from class: m12
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.m22
                public final void onResult(Object obj) {
                    o12.a(str, atomicBoolean, (Throwable) obj);
                }
            });
            if (!atomicBoolean.get()) {
                Map map2 = a;
                map2.put(str, t22Var2);
                if (map2.size() == 1) {
                    I(false);
                }
            }
        }
        return t22Var2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static l22 i(f12 f12Var, String str) {
        for (l22 l22Var : f12Var.j().values()) {
            if (l22Var.c().equals(str)) {
                return l22Var;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static t22 j(Context context, String str) {
        return k(context, str, "asset_" + str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static t22 k(Context context, final String str, final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return h(str2, new Callable() { // from class: k12
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return o12.m(applicationContext, str, str2);
            }
        }, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static r22 l(Context context, String str) {
        return m(context, str, "asset_" + str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static r22 m(Context context, String str, String str2) {
        f12 f12VarA = str2 == null ? null : g12.b().a(str2);
        if (f12VarA != null) {
            return new r22(f12VarA);
        }
        try {
            return n(context, context.getAssets().open(str), str2);
        } catch (IOException e) {
            return new r22((Throwable) e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static r22 n(Context context, InputStream inputStream, String str) {
        f12 f12VarA = str == null ? null : g12.b().a(str);
        if (f12VarA != null) {
            return new r22(f12VarA);
        }
        try {
            BufferedSource bufferedSourceBuffer = Okio.buffer(Okio.source(inputStream));
            return G(bufferedSourceBuffer).booleanValue() ? B(context, new ZipInputStream(bufferedSourceBuffer.inputStream()), str) : E(bufferedSourceBuffer).booleanValue() ? p(new GZIPInputStream(bufferedSourceBuffer.inputStream()), str) : r(no1.J(bufferedSourceBuffer), str);
        } catch (IOException e) {
            return new r22((Throwable) e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static t22 o(final InputStream inputStream, final String str) {
        return h(str, new Callable() { // from class: i12
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return o12.p(inputStream, str);
            }
        }, new Runnable() { // from class: j12
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                uy4.c(inputStream);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static r22 p(InputStream inputStream, String str) {
        return q(inputStream, str, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static r22 q(InputStream inputStream, String str, boolean z) {
        return u(Okio.source(inputStream), str, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static r22 r(no1 no1Var, String str) {
        return s(no1Var, str, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static r22 s(no1 no1Var, String str, boolean z) {
        return t(no1Var, str, z);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static r22 t(no1 no1Var, String str, boolean z) {
        f12 f12VarA;
        try {
            if (str == null) {
                f12VarA = null;
            } else {
                try {
                    f12VarA = g12.b().a(str);
                } catch (Exception e) {
                    r22 r22Var = new r22((Throwable) e);
                    if (z) {
                        uy4.c(no1Var);
                    }
                    return r22Var;
                }
            }
            if (f12VarA != null) {
                r22 r22Var2 = new r22(f12VarA);
                if (z) {
                    uy4.c(no1Var);
                }
                return r22Var2;
            }
            f12 f12VarA2 = p12.a(no1Var);
            if (str != null) {
                g12.b().c(str, f12VarA2);
            }
            r22 r22Var3 = new r22(f12VarA2);
            if (z) {
                uy4.c(no1Var);
            }
            return r22Var3;
        } catch (Throwable th) {
            if (z) {
                uy4.c(no1Var);
            }
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static r22 u(Source source, String str, boolean z) {
        return t(no1.J(Okio.buffer(source)), str, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static t22 v(Context context, int i) {
        return w(context, i, J(context, i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static t22 w(Context context, final int i, final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return h(str, new Callable() { // from class: n12
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return o12.c(weakReference, applicationContext, i, str);
            }
        }, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static r22 x(Context context, int i) {
        return y(context, i, J(context, i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static r22 y(Context context, int i, String str) {
        f12 f12VarA = str == null ? null : g12.b().a(str);
        if (f12VarA != null) {
            return new r22(f12VarA);
        }
        try {
            BufferedSource bufferedSourceBuffer = Okio.buffer(Okio.source(context.getResources().openRawResource(i)));
            if (G(bufferedSourceBuffer).booleanValue()) {
                return B(context, new ZipInputStream(bufferedSourceBuffer.inputStream()), str);
            }
            if (!E(bufferedSourceBuffer).booleanValue()) {
                return r(no1.J(bufferedSourceBuffer), str);
            }
            try {
                return p(new GZIPInputStream(bufferedSourceBuffer.inputStream()), str);
            } catch (IOException e) {
                return new r22((Throwable) e);
            }
        } catch (Resources.NotFoundException e2) {
            return new r22((Throwable) e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static t22 z(Context context, String str) {
        return A(context, str, "url_" + str);
    }
}
