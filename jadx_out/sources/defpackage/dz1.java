package defpackage;

import androidx.lifecycle.x;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class dz1 extends cz1 {
    public final bt1 a;
    public final a b;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a extends c45 {
        public static final x.c d = new C0077a();
        public mb4 b = new mb4();
        public boolean c = false;

        /* JADX INFO: renamed from: dz1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static class C0077a implements x.c {
            @Override // androidx.lifecycle.x.c
            public c45 a(Class cls) {
                return new a();
            }
        }

        public static a f(k45 k45Var) {
            return (a) new x(k45Var, d).b(a.class);
        }

        @Override // defpackage.c45
        public void d() {
            super.d();
            int iH = this.b.h();
            mb4 mb4Var = this.b;
            if (iH <= 0) {
                mb4Var.b();
            } else {
                w82.a(mb4Var.i(0));
                throw null;
            }
        }

        public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.b.h() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("    ");
                if (this.b.h() <= 0) {
                    return;
                }
                w82.a(this.b.i(0));
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.b.f(0));
                printWriter.print(": ");
                throw null;
            }
        }

        public void g() {
            if (this.b.h() <= 0) {
                return;
            }
            w82.a(this.b.i(0));
            throw null;
        }
    }

    public dz1(bt1 bt1Var, k45 k45Var) {
        this.a = bt1Var;
        this.b = a.f(k45Var);
    }

    @Override // defpackage.cz1
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.b.e(str, fileDescriptor, printWriter, strArr);
    }

    @Override // defpackage.cz1
    public void c() {
        this.b.g();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        va0.a(this.a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
