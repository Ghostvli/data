package defpackage;

import android.content.Context;
import android.util.Log;
import defpackage.go3;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ho3 {
    public final Set a;
    public final go3.b b;
    public final go3.a c;
    public boolean d;
    public boolean e;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Runnable {
        public final /* synthetic */ Context f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(Context context, String str, String str2, go3.c cVar) {
            this.f = context;
            this.g = str;
            this.h = str2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: Code restructure failed: missing block: B:10:?, code lost:
        
            throw null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:?, code lost:
        
            throw null;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() throws Throwable {
            try {
                ho3.this.g(this.f, this.g, this.h);
                throw null;
            } catch (UnsatisfiedLinkError unused) {
                throw null;
            } catch (pt2 unused2) {
                throw null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements FilenameFilter {
        public final /* synthetic */ String a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(String str) {
            this.a = str;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith(this.a);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ho3(go3.b bVar, go3.a aVar) {
        this.a = new HashSet();
        if (bVar == null) {
            jl.a("Cannot pass null library loader");
            throw null;
        }
        if (aVar == null) {
            jl.a("Cannot pass null library installer");
            throw null;
        }
        this.b = bVar;
        this.c = aVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b(Context context, String str, String str2) {
        File fileC = c(context);
        File fileD = d(context, str, str2);
        File[] fileArrListFiles = fileC.listFiles(new b(this.b.a(str)));
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (this.d || !file.getAbsolutePath().equals(fileD.getAbsolutePath())) {
                file.delete();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public File c(Context context) {
        return context.getDir("lib", 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public File d(Context context, String str, String str2) {
        String strA = this.b.a(str);
        if (ym4.a(str2)) {
            return new File(c(context), strA);
        }
        return new File(c(context), strA + "." + str2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e(Context context, String str) {
        f(context, str, null, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f(Context context, String str, String str2, go3.c cVar) {
        if (context == null) {
            jl.a("Given context is null");
            return;
        }
        if (ym4.a(str)) {
            jl.a("Given library is either null or empty");
            return;
        }
        i("Beginning load of %s...", str);
        if (cVar == null) {
            g(context, str, str2);
        } else {
            new Thread(new a(context, str, str2, cVar)).start();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g(Context context, String str, String str2) throws Throwable {
        ho3 ho3Var;
        Context context2;
        mr0 mr0Var;
        Throwable th;
        if (this.a.contains(str) && !this.d) {
            i("%s already loaded previously!", str);
            return;
        }
        try {
            this.b.b(str);
            this.a.add(str);
            i("%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e) {
            i("Loading the library normally failed: %s", Log.getStackTraceString(e));
            i("%s (%s) was not loaded normally, re-linking...", str, str2);
            File fileD = d(context, str, str2);
            if (!fileD.exists() || this.d) {
                if (this.d) {
                    i("Forcing a re-link of %s (%s)...", str, str2);
                }
                b(context, str, str2);
                ho3Var = this;
                context2 = context;
                this.c.a(context2, this.b.d(), this.b.a(str), fileD, ho3Var);
            } else {
                ho3Var = this;
                context2 = context;
            }
            try {
                if (ho3Var.e) {
                    try {
                        mr0Var = new mr0(fileD);
                        try {
                            List listH = mr0Var.h();
                            mr0Var.close();
                            Iterator it = listH.iterator();
                            while (it.hasNext()) {
                                ho3Var.e(context2, ho3Var.b.c((String) it.next()));
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (mr0Var == null) {
                                throw th;
                            }
                            mr0Var.close();
                            throw th;
                        }
                    } catch (Throwable th3) {
                        mr0Var = null;
                        th = th3;
                    }
                }
            } catch (IOException unused) {
            }
            ho3Var.b.e(fileD.getAbsolutePath());
            ho3Var.a.add(str);
            ho3Var.i("%s (%s) was re-linked!", str, str2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void h(String str) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void i(String str, Object... objArr) {
        h(String.format(Locale.US, str, objArr));
    }

    public ho3() {
        this(new ok4(), new u7());
    }
}
