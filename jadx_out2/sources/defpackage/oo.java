package defpackage;

import java.io.File;
import java.util.ArrayList;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class oo {
    public final int a;
    public final String b;
    public final TreeSet c;
    public final ArrayList d;
    public xe0 e;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final long a;
        public final long b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(long j, long j2) {
            this.a = j;
            this.b = j2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean a(long j, long j2) {
            long j3 = this.b;
            if (j3 == -1) {
                return j >= this.a;
            }
            if (j2 == -1) {
                return false;
            }
            long j4 = this.a;
            return j4 <= j && j + j2 <= j4 + j3;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean b(long j, long j2) {
            long j3 = this.a;
            if (j3 > j) {
                return j2 == -1 || j + j2 > j3;
            }
            long j4 = this.b;
            return j4 == -1 || j3 + j4 > j;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public oo(int i, String str, xe0 xe0Var) {
        this.a = i;
        this.b = str;
        this.e = xe0Var;
        this.c = new TreeSet();
        this.d = new ArrayList();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void a(z64 z64Var) {
        this.c.add(z64Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean b(u20 u20Var) {
        this.e = this.e.g(u20Var);
        return !r2.equals(r0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public xe0 c() {
        return this.e;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public z64 d(long j, long j2) {
        z64 z64VarJ = z64.j(this.b, j);
        z64 z64Var = (z64) this.c.floor(z64VarJ);
        if (z64Var != null && z64Var.g + z64Var.h > j) {
            return z64Var;
        }
        z64 z64Var2 = (z64) this.c.ceiling(z64VarJ);
        if (z64Var2 != null) {
            long j3 = z64Var2.g - j;
            j2 = j2 == -1 ? j3 : Math.min(j3, j2);
        }
        return z64.i(this.b, j, j2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public TreeSet e() {
        return this.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && oo.class == obj.getClass()) {
            oo ooVar = (oo) obj;
            if (this.a == ooVar.a && this.b.equals(ooVar.b) && this.c.equals(ooVar.c) && this.e.equals(ooVar.e)) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean f() {
        return this.c.isEmpty();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean g(long j, long j2) {
        for (int i = 0; i < this.d.size(); i++) {
            if (((a) this.d.get(i)).a(j, j2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean h() {
        return this.d.isEmpty();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return (((this.a * 31) + this.b.hashCode()) * 31) + this.e.hashCode();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean i(long j, long j2) {
        int i = 0;
        while (true) {
            int size = this.d.size();
            ArrayList arrayList = this.d;
            if (i >= size) {
                arrayList.add(new a(j, j2));
                return true;
            }
            if (((a) arrayList.get(i)).b(j, j2)) {
                return false;
            }
            i++;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean j(no noVar) {
        if (!this.c.remove(noVar)) {
            return false;
        }
        File file = noVar.j;
        if (file == null) {
            return true;
        }
        file.delete();
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public z64 k(z64 z64Var, long j, boolean z) {
        long j2;
        gg3.v(this.c.remove(z64Var));
        File file = (File) gg3.q(z64Var.j);
        if (z) {
            j2 = j;
            File fileK = z64.k((File) gg3.q(file.getParentFile()), this.a, z64Var.g, j2);
            if (file.renameTo(fileK)) {
                file = fileK;
            } else {
                xz1.i("CachedContent", "Failed to rename " + file + " to " + fileK);
            }
        } else {
            j2 = j;
        }
        z64 z64VarF = z64Var.f(file, j2);
        this.c.add(z64VarF);
        return z64VarF;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void l(long j) {
        for (int i = 0; i < this.d.size(); i++) {
            if (((a) this.d.get(i)).a == j) {
                this.d.remove(i);
                return;
            }
        }
        z20.a();
    }

    public oo(int i, String str) {
        this(i, str, xe0.c);
    }
}
