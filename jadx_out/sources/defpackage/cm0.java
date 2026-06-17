package defpackage;

import android.os.Build;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class cm0 implements Closeable {
    public final File f;
    public final File g;
    public final File h;
    public final File i;
    public final int j;
    public long k;
    public final int l;
    public Writer n;
    public int p;
    public long m = 0;
    public final LinkedHashMap o = new LinkedHashMap(0, 0.75f, true);
    public long q = 0;
    public final ThreadPoolExecutor r = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));
    public final Callable s = new a();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Callable {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            synchronized (cm0.this) {
                try {
                    if (cm0.this.n == null) {
                        return null;
                    }
                    cm0.this.Z();
                    if (cm0.this.P()) {
                        cm0.this.U();
                        cm0.this.p = 0;
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public cm0(File file, int i, int i2, long j) {
        this.f = file;
        this.j = i;
        this.g = new File(file, "journal");
        this.h = new File(file, "journal.tmp");
        this.i = new File(file, "journal.bkp");
        this.l = i2;
        this.k = j;
    }

    public static void B(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static void K(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static void N(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static cm0 Q(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            jl.a("maxSize <= 0");
            return null;
        }
        if (i2 <= 0) {
            jl.a("valueCount <= 0");
            return null;
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                W(file2, file3, false);
            }
        }
        cm0 cm0Var = new cm0(file, i, i2, j);
        if (cm0Var.g.exists()) {
            try {
                cm0Var.S();
                cm0Var.R();
                return cm0Var;
            } catch (IOException e2) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                cm0Var.J();
            }
        }
        file.mkdirs();
        cm0 cm0Var2 = new cm0(file, i, i2, j);
        cm0Var2.U();
        return cm0Var2;
    }

    public static void W(File file, File file2, boolean z) throws IOException {
        if (z) {
            K(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public final synchronized void F(c cVar, boolean z) {
        d dVar = cVar.a;
        if (dVar.f != cVar) {
            throw new IllegalStateException();
        }
        if (z && !dVar.e) {
            for (int i = 0; i < this.l; i++) {
                if (!cVar.b[i]) {
                    cVar.a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                }
                if (!dVar.k(i).exists()) {
                    cVar.a();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.l; i2++) {
            File fileK = dVar.k(i2);
            if (!z) {
                K(fileK);
            } else if (fileK.exists()) {
                File fileJ = dVar.j(i2);
                fileK.renameTo(fileJ);
                long j = dVar.b[i2];
                long length = fileJ.length();
                dVar.b[i2] = length;
                this.m = (this.m - j) + length;
            }
        }
        this.p++;
        dVar.f = null;
        if (dVar.e || z) {
            dVar.e = true;
            this.n.append((CharSequence) "CLEAN");
            this.n.append(' ');
            this.n.append((CharSequence) dVar.a);
            this.n.append((CharSequence) dVar.l());
            this.n.append('\n');
            if (z) {
                long j2 = this.q;
                this.q = 1 + j2;
                dVar.g = j2;
            }
        } else {
            this.o.remove(dVar.a);
            this.n.append((CharSequence) "REMOVE");
            this.n.append(' ');
            this.n.append((CharSequence) dVar.a);
            this.n.append('\n');
        }
        N(this.n);
        if (this.m > this.k || P()) {
            this.r.submit(this.s);
        }
    }

    public void J() throws IOException {
        close();
        hy4.b(this.f);
    }

    public c L(String str) {
        return M(str, -1L);
    }

    public final synchronized c M(String str, long j) {
        y();
        d dVar = (d) this.o.get(str);
        a aVar = null;
        if (j != -1 && (dVar == null || dVar.g != j)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(this, str, aVar);
            this.o.put(str, dVar);
        } else if (dVar.f != null) {
            return null;
        }
        c cVar = new c(this, dVar, aVar);
        dVar.f = cVar;
        this.n.append((CharSequence) "DIRTY");
        this.n.append(' ');
        this.n.append((CharSequence) str);
        this.n.append('\n');
        N(this.n);
        return cVar;
    }

    public synchronized e O(String str) {
        cm0 cm0Var;
        Throwable th;
        try {
            try {
                y();
                d dVar = (d) this.o.get(str);
                if (dVar == null) {
                    return null;
                }
                if (!dVar.e) {
                    return null;
                }
                for (File file : dVar.c) {
                    try {
                        if (!file.exists()) {
                            return null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cm0Var = this;
                    }
                }
                this.p++;
                this.n.append((CharSequence) "READ");
                this.n.append(' ');
                this.n.append((CharSequence) str);
                this.n.append('\n');
                if (P()) {
                    this.r.submit(this.s);
                }
                return new e(this, str, dVar.g, dVar.c, dVar.b, null);
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            cm0Var = this;
        }
        th = th;
        throw th;
    }

    public final boolean P() {
        int i = this.p;
        return i >= 2000 && i >= this.o.size();
    }

    public final void R() throws IOException {
        K(this.h);
        Iterator it = this.o.values().iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            int i = 0;
            if (dVar.f == null) {
                while (i < this.l) {
                    this.m += dVar.b[i];
                    i++;
                }
            } else {
                dVar.f = null;
                while (i < this.l) {
                    K(dVar.j(i));
                    K(dVar.k(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    public final void S() {
        xf4 xf4Var = new xf4(new FileInputStream(this.g), hy4.a);
        try {
            String strI = xf4Var.i();
            String strI2 = xf4Var.i();
            String strI3 = xf4Var.i();
            String strI4 = xf4Var.i();
            String strI5 = xf4Var.i();
            if (!"libcore.io.DiskLruCache".equals(strI) || !"1".equals(strI2) || !Integer.toString(this.j).equals(strI3) || !Integer.toString(this.l).equals(strI4) || !"".equals(strI5)) {
                throw new IOException("unexpected journal header: [" + strI + ", " + strI2 + ", " + strI4 + ", " + strI5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    T(xf4Var.i());
                    i++;
                } catch (EOFException unused) {
                    this.p = i - this.o.size();
                    if (xf4Var.h()) {
                        U();
                    } else {
                        this.n = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.g, true), hy4.a));
                    }
                    hy4.a(xf4Var);
                    return;
                }
            }
        } catch (Throwable th) {
            hy4.a(xf4Var);
            throw th;
        }
    }

    public final void T(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            sb1.a("unexpected journal line: ".concat(str));
            return;
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.o.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        d dVar = (d) this.o.get(strSubstring);
        a aVar = null;
        if (dVar == null) {
            dVar = new d(this, strSubstring, aVar);
            this.o.put(strSubstring, dVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            dVar.e = true;
            dVar.f = null;
            dVar.n(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            dVar.f = new c(this, dVar, aVar);
        } else {
            if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith("READ")) {
                return;
            }
            sb1.a("unexpected journal line: ".concat(str));
        }
    }

    public final synchronized void U() {
        try {
            Writer writer = this.n;
            if (writer != null) {
                B(writer);
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.h), hy4.a));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.j));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.l));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (d dVar : this.o.values()) {
                    if (dVar.f != null) {
                        bufferedWriter.write("DIRTY " + dVar.a + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + dVar.a + dVar.l() + '\n');
                    }
                }
                B(bufferedWriter);
                if (this.g.exists()) {
                    W(this.g, this.i, true);
                }
                W(this.h, this.g, false);
                this.i.delete();
                this.n = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.g, true), hy4.a));
            } catch (Throwable th) {
                B(bufferedWriter);
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized boolean V(String str) {
        try {
            y();
            d dVar = (d) this.o.get(str);
            if (dVar != null && dVar.f == null) {
                for (int i = 0; i < this.l; i++) {
                    File fileJ = dVar.j(i);
                    if (fileJ.exists() && !fileJ.delete()) {
                        throw new IOException("failed to delete " + fileJ);
                    }
                    this.m -= dVar.b[i];
                    dVar.b[i] = 0;
                }
                this.p++;
                this.n.append((CharSequence) "REMOVE");
                this.n.append(' ');
                this.n.append((CharSequence) str);
                this.n.append('\n');
                this.o.remove(str);
                if (P()) {
                    this.r.submit(this.s);
                }
                return true;
            }
            return false;
        } finally {
        }
    }

    public final void Z() {
        while (this.m > this.k) {
            V((String) ((Map.Entry) this.o.entrySet().iterator().next()).getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.n == null) {
                return;
            }
            for (d dVar : new ArrayList(this.o.values())) {
                if (dVar.f != null) {
                    dVar.f.a();
                }
            }
            Z();
            B(this.n);
            this.n = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void y() {
        if (this.n != null) {
            return;
        }
        e04.a("cache is closed");
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements ThreadFactory {
        public b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class e {
        public final String a;
        public final long b;
        public final long[] c;
        public final File[] d;

        public e(String str, long j, File[] fileArr, long[] jArr) {
            this.a = str;
            this.b = j;
            this.d = fileArr;
            this.c = jArr;
        }

        public File a(int i) {
            return this.d[i];
        }

        public /* synthetic */ e(cm0 cm0Var, String str, long j, File[] fileArr, long[] jArr, a aVar) {
            this(str, j, fileArr, jArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class c {
        public final d a;
        public final boolean[] b;
        public boolean c;

        public c(d dVar) {
            this.a = dVar;
            this.b = dVar.e ? null : new boolean[cm0.this.l];
        }

        public void a() {
            cm0.this.F(this, false);
        }

        public void b() {
            if (this.c) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public void e() {
            cm0.this.F(this, true);
            this.c = true;
        }

        public File f(int i) {
            File fileK;
            synchronized (cm0.this) {
                try {
                    if (this.a.f != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.a.e) {
                        this.b[i] = true;
                    }
                    fileK = this.a.k(i);
                    cm0.this.f.mkdirs();
                } catch (Throwable th) {
                    throw th;
                }
            }
            return fileK;
        }

        public /* synthetic */ c(cm0 cm0Var, d dVar, a aVar) {
            this(dVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class d {
        public final String a;
        public final long[] b;
        public File[] c;
        public File[] d;
        public boolean e;
        public c f;
        public long g;

        public d(String str) {
            this.a = str;
            this.b = new long[cm0.this.l];
            this.c = new File[cm0.this.l];
            this.d = new File[cm0.this.l];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < cm0.this.l; i++) {
                sb.append(i);
                this.c[i] = new File(cm0.this.f, sb.toString());
                sb.append(".tmp");
                this.d[i] = new File(cm0.this.f, sb.toString());
                sb.setLength(length);
            }
        }

        public File j(int i) {
            return this.c[i];
        }

        public File k(int i) {
            return this.d[i];
        }

        public String l() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.b) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        public final IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final void n(String[] strArr) throws IOException {
            if (strArr.length != cm0.this.l) {
                throw m(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.b[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw m(strArr);
                }
            }
        }

        public /* synthetic */ d(cm0 cm0Var, String str, a aVar) {
            this(str);
        }
    }
}
