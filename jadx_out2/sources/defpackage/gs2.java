package defpackage;

import android.graphics.Path;
import defpackage.fs2;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class gs2 implements f93, ib1 {
    public final String d;
    public final fs2 f;
    public final Path a = new Path();
    public final Path b = new Path();
    public final Path c = new Path();
    public final List e = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        static {
            int[] iArr = new int[fs2.a.values().length];
            a = iArr;
            try {
                iArr[fs2.a.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[fs2.a.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[fs2.a.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[fs2.a.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[fs2.a.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public gs2(fs2 fs2Var) {
        this.d = fs2Var.c();
        this.f = fs2Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void a() {
        for (int i = 0; i < this.e.size(); i++) {
            this.c.addPath(((f93) this.e.get(i)).getPath());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.k20
    public void b(List list, List list2) {
        for (int i = 0; i < this.e.size(); i++) {
            ((f93) this.e.get(i)).b(list, list2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ib1
    public void f(ListIterator listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            k20 k20Var = (k20) listIterator.previous();
            if (k20Var instanceof f93) {
                this.e.add((f93) k20Var);
                listIterator.remove();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g(Path.Op op) {
        List list;
        this.b.reset();
        this.a.reset();
        int size = this.e.size() - 1;
        while (true) {
            list = this.e;
            if (size < 1) {
                break;
            }
            f93 f93Var = (f93) list.get(size);
            if (f93Var instanceof o20) {
                o20 o20Var = (o20) f93Var;
                List listL = o20Var.l();
                for (int size2 = listL.size() - 1; size2 >= 0; size2--) {
                    Path path = ((f93) listL.get(size2)).getPath();
                    path.transform(o20Var.m());
                    this.b.addPath(path);
                }
            } else {
                this.b.addPath(f93Var.getPath());
            }
            size--;
        }
        f93 f93Var2 = (f93) list.get(0);
        if (f93Var2 instanceof o20) {
            o20 o20Var2 = (o20) f93Var2;
            List listL2 = o20Var2.l();
            for (int i = 0; i < listL2.size(); i++) {
                Path path2 = ((f93) listL2.get(i)).getPath();
                path2.transform(o20Var2.m());
                this.a.addPath(path2);
            }
        } else {
            this.a.set(f93Var2.getPath());
        }
        this.c.op(this.a, this.b, op);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.f93
    public Path getPath() {
        this.c.reset();
        if (this.f.d()) {
            return this.c;
        }
        int i = a.a[this.f.b().ordinal()];
        if (i == 1) {
            a();
        } else if (i == 2) {
            g(Path.Op.UNION);
        } else if (i == 3) {
            g(Path.Op.REVERSE_DIFFERENCE);
        } else if (i == 4) {
            g(Path.Op.INTERSECT);
        } else if (i == 5) {
            g(Path.Op.XOR);
        }
        return this.c;
    }
}
