package defpackage;

import android.os.ConditionVariable;
import defpackage.ao;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class y64 implements ao {
    public static final HashSet l = new HashSet();
    public final File a;
    public final ho b;
    public final po c;
    public final jo d;
    public final HashMap e;
    public final Random f;
    public final boolean g;
    public long h;
    public long i;
    public boolean j;
    public ao.a k;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends Thread {
        public final /* synthetic */ ConditionVariable f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, ConditionVariable conditionVariable) {
            super(str);
            this.f = conditionVariable;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            synchronized (y64.this) {
                this.f.open();
                y64.this.o();
                y64.this.b.d();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public y64(File file, ho hoVar, po poVar, jo joVar) {
        if (!r(file)) {
            ho1.a("Another SimpleCache instance uses the folder: ", file);
            throw null;
        }
        this.a = file;
        this.b = hoVar;
        this.c = poVar;
        this.d = joVar;
        this.e = new HashMap();
        this.f = new Random();
        this.g = hoVar.e();
        this.h = -1L;
        ConditionVariable conditionVariable = new ConditionVariable();
        new a("ExoPlayer:SimpleCacheInit", conditionVariable).start();
        conditionVariable.block();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void l(File file) throws ao.a {
        if (file.mkdirs() || file.isDirectory()) {
            return;
        }
        String str = "Failed to create cache directory: " + file;
        xz1.d("SimpleCache", str);
        throw new ao.a(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long m(File file) throws IOException {
        long jNextLong = new SecureRandom().nextLong();
        long jAbs = jNextLong == Long.MIN_VALUE ? 0L : Math.abs(jNextLong);
        File file2 = new File(file, Long.toString(jAbs, 16) + ".uid");
        if (file2.createNewFile()) {
            return jAbs;
        }
        we5.a("Failed to create UID file: ", file2);
        return 0L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long q(File[] fileArr) {
        int length = fileArr.length;
        for (int i = 0; i < length; i++) {
            File file = fileArr[i];
            String name = file.getName();
            if (name.endsWith(".uid")) {
                try {
                    return v(name);
                } catch (NumberFormatException unused) {
                    xz1.d("SimpleCache", "Malformed UID file: " + file);
                    file.delete();
                }
            }
        }
        return -1L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static synchronized boolean r(File file) {
        return l.add(file.getAbsoluteFile());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long v(String str) {
        return Long.parseLong(str.substring(0, str.indexOf(46)), 16);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ao
    public synchronized File a(String str, long j, long j2) throws Throwable {
        Throwable th;
        y64 y64Var;
        oo ooVarF;
        File file;
        try {
            try {
                gg3.v(!this.j);
                k();
                ooVarF = this.c.f(str);
                gg3.q(ooVarF);
                gg3.v(ooVarF.g(j, j2));
                if (!this.a.exists()) {
                    try {
                        l(this.a);
                        x();
                    } catch (Throwable th2) {
                        th = th2;
                        y64Var = this;
                        throw th;
                    }
                }
                this.b.a(this, str, j, j2);
                file = new File(this.a, Integer.toString(this.f.nextInt(10)));
                if (!file.exists()) {
                    l(file);
                }
            } catch (Throwable th3) {
                th = th3;
                y64Var = this;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        return z64.k(file, ooVarF.a, j, System.currentTimeMillis());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ao
    public synchronized t20 b(String str) {
        gg3.v(!this.j);
        return this.c.h(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ao
    public synchronized void c(no noVar) {
        gg3.v(!this.j);
        oo ooVar = (oo) gg3.q(this.c.f(noVar.f));
        ooVar.l(noVar.g);
        this.c.n(ooVar.b);
        notifyAll();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ao
    public synchronized no d(String str, long j, long j2) {
        gg3.v(!this.j);
        k();
        z64 z64VarN = n(str, j, j2);
        if (z64VarN.i) {
            return y(str, z64VarN);
        }
        if (this.c.k(str).i(j, z64VarN.h)) {
            return z64VarN;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ao
    public synchronized no e(String str, long j, long j2) {
        no noVarD;
        gg3.v(!this.j);
        k();
        while (true) {
            noVarD = d(str, j, j2);
            if (noVarD == null) {
                wait();
            }
        }
        return noVarD;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ao
    public synchronized void f(File file, long j) {
        boolean z = true;
        gg3.v(!this.j);
        if (file.exists()) {
            if (j == 0) {
                file.delete();
                return;
            }
            z64 z64Var = (z64) gg3.q(z64.h(file, j, this.c));
            oo ooVar = (oo) gg3.q(this.c.f(z64Var.f));
            gg3.v(ooVar.g(z64Var.g, z64Var.h));
            long jA = t20.a(ooVar.c());
            if (jA != -1) {
                if (z64Var.g + z64Var.h > jA) {
                    z = false;
                }
                gg3.v(z);
            }
            if (this.d == null) {
                j(z64Var);
                this.c.q();
                notifyAll();
                return;
            }
            try {
                this.d.h(file.getName(), z64Var.h, z64Var.k);
                j(z64Var);
                try {
                    this.c.q();
                    notifyAll();
                    return;
                } catch (IOException e) {
                    throw new ao.a(e);
                }
            } catch (IOException e2) {
                throw new ao.a(e2);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ao
    public synchronized void g(String str, u20 u20Var) {
        gg3.v(!this.j);
        k();
        this.c.d(str, u20Var);
        try {
            this.c.q();
        } catch (IOException e) {
            throw new ao.a(e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j(z64 z64Var) {
        this.c.k(z64Var.f).a(z64Var);
        this.i += z64Var.h;
        s(z64Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized void k() {
        ao.a aVar = this.k;
        if (aVar != null) {
            throw aVar;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final z64 n(String str, long j, long j2) {
        z64 z64VarD;
        oo ooVarF = this.c.f(str);
        if (ooVarF == null) {
            return z64.i(str, j, j2);
        }
        while (true) {
            z64VarD = ooVarF.d(j, j2);
            if (!z64VarD.i || ((File) gg3.q(z64VarD.j)).length() == z64VarD.h) {
                break;
            }
            x();
        }
        return z64VarD;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void o() {
        if (!this.a.exists()) {
            try {
                l(this.a);
            } catch (ao.a e) {
                this.k = e;
                return;
            }
        }
        File[] fileArrListFiles = this.a.listFiles();
        if (fileArrListFiles == null) {
            String str = "Failed to list cache directory files: " + this.a;
            xz1.d("SimpleCache", str);
            this.k = new ao.a(str);
            return;
        }
        long jQ = q(fileArrListFiles);
        this.h = jQ;
        if (jQ == -1) {
            try {
                this.h = m(this.a);
            } catch (IOException e2) {
                String str2 = "Failed to create cache UID: " + this.a;
                xz1.e("SimpleCache", str2, e2);
                this.k = new ao.a(str2, e2);
                return;
            }
        }
        try {
            this.c.l(this.h);
            jo joVar = this.d;
            if (joVar != null) {
                joVar.e(this.h);
                Map mapB = this.d.b();
                p(this.a, true, fileArrListFiles, mapB);
                this.d.g(mapB.keySet());
            } else {
                p(this.a, true, fileArrListFiles, null);
            }
            this.c.p();
            try {
                this.c.q();
            } catch (IOException e3) {
                xz1.e("SimpleCache", "Storing index file failed", e3);
            }
        } catch (IOException e4) {
            String str3 = "Failed to initialize cache indices: " + this.a;
            xz1.e("SimpleCache", str3, e4);
            this.k = new ao.a(str3, e4);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void p(File file, boolean z, File[] fileArr, Map map) {
        long j;
        long j2;
        if (fileArr == null || fileArr.length == 0) {
            if (z) {
                return;
            }
            file.delete();
            return;
        }
        for (File file2 : fileArr) {
            String name = file2.getName();
            if (z && name.indexOf(46) == -1) {
                p(file2, false, file2.listFiles(), map);
            } else if (!z || (!po.m(name) && !name.endsWith(".uid"))) {
                io ioVar = map != null ? (io) map.remove(name) : null;
                if (ioVar != null) {
                    j = ioVar.a;
                    j2 = ioVar.b;
                } else {
                    j = -1;
                    j2 = -9223372036854775807L;
                }
                z64 z64VarG = z64.g(file2, j, j2, this.c);
                if (z64VarG != null) {
                    j(z64VarG);
                } else {
                    file2.delete();
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void s(z64 z64Var) {
        ArrayList arrayList = (ArrayList) this.e.get(z64Var.f);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((ao.b) arrayList.get(size)).c(this, z64Var);
            }
        }
        this.b.c(this, z64Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void t(no noVar) {
        ArrayList arrayList = (ArrayList) this.e.get(noVar.f);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((ao.b) arrayList.get(size)).b(this, noVar);
            }
        }
        this.b.b(this, noVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void u(z64 z64Var, no noVar) {
        ArrayList arrayList = (ArrayList) this.e.get(z64Var.f);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((ao.b) arrayList.get(size)).f(this, z64Var, noVar);
            }
        }
        this.b.f(this, z64Var, noVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void w(no noVar) {
        oo ooVarF = this.c.f(noVar.f);
        if (ooVarF == null || !ooVarF.j(noVar)) {
            return;
        }
        this.i -= noVar.h;
        if (this.d != null) {
            String name = ((File) gg3.q(noVar.j)).getName();
            try {
                this.d.f(name);
            } catch (IOException unused) {
                xz1.i("SimpleCache", "Failed to remove file index entry for: " + name);
            }
        }
        this.c.n(ooVarF.b);
        t(noVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void x() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.c.g().iterator();
        while (it.hasNext()) {
            for (no noVar : ((oo) it.next()).e()) {
                if (((File) gg3.q(noVar.j)).length() != noVar.h) {
                    arrayList.add(noVar);
                }
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            w((no) arrayList.get(i));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final z64 y(String str, z64 z64Var) {
        boolean z;
        if (!this.g) {
            return z64Var;
        }
        String name = ((File) gg3.q(z64Var.j)).getName();
        long j = z64Var.h;
        long jCurrentTimeMillis = System.currentTimeMillis();
        jo joVar = this.d;
        if (joVar != null) {
            try {
                joVar.h(name, j, jCurrentTimeMillis);
            } catch (IOException unused) {
                xz1.i("SimpleCache", "Failed to update index with new touch timestamp.");
            }
            z = false;
        } else {
            z = true;
        }
        z64 z64VarK = ((oo) gg3.q(this.c.f(str))).k(z64Var, jCurrentTimeMillis, z);
        u(z64Var, z64VarK);
        return z64VarK;
    }

    public y64(File file, ho hoVar, oa0 oa0Var, byte[] bArr, boolean z, boolean z2) {
        this(file, hoVar, new po(oa0Var, file, bArr, z, z2), (oa0Var == null || z2) ? null : new jo(oa0Var));
    }

    public y64(File file, ho hoVar, oa0 oa0Var) {
        this(file, hoVar, oa0Var, null, false, false);
    }
}
