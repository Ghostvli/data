package defpackage;

import android.view.ViewGroup;
import androidx.lifecycle.g;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d71 {
    public final a61 a;
    public final ClassLoader b;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public String k;
    public int l;
    public CharSequence m;
    public int n;
    public CharSequence o;
    public ArrayList p;
    public ArrayList q;
    public ArrayList s;
    public ArrayList c = new ArrayList();
    public boolean j = true;
    public boolean r = false;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public d71(a61 a61Var, ClassLoader classLoader) {
        this.a = a61Var;
        this.b = classLoader;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public d71 b(int i, p51 p51Var) {
        m(i, p51Var, null, 1);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public d71 c(int i, p51 p51Var, String str) {
        m(i, p51Var, str, 1);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public d71 d(p51 p51Var, String str) {
        m(0, p51Var, str, 1);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public d71 e(ViewGroup viewGroup, p51 p51Var, String str) {
        p51Var.M = viewGroup;
        return c(viewGroup.getId(), p51Var, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f(a aVar) {
        this.c.add(aVar);
        aVar.d = this.d;
        aVar.e = this.e;
        aVar.f = this.f;
        aVar.g = this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public d71 g(String str) {
        if (!this.j) {
            e04.a("This FragmentTransaction is not allowed to be added to the back stack.");
            return null;
        }
        this.i = true;
        this.k = str;
        return this;
    }

    public abstract int h();

    public abstract int i();

    public abstract void j();

    public abstract void k();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public d71 l() {
        if (this.i) {
            e04.a("This transaction is already being added to the back stack");
            return null;
        }
        this.j = false;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void m(int i, p51 p51Var, String str, int i2) {
        String str2 = p51Var.W;
        if (str2 != null) {
            b71.e(p51Var, str2);
        }
        Class<?> cls = p51Var.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = p51Var.E;
            if (str3 != null && !str.equals(str3)) {
                StringBuilder sb = new StringBuilder("Can't change tag of fragment ");
                sb.append(p51Var);
                String str4 = p51Var.E;
                sb.append(": was ");
                sb.append(str4);
                sb.append(" now ");
                sb.append(str);
                throw new IllegalStateException(sb.toString());
            }
            p51Var.E = str;
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + p51Var + " with tag " + str + " to container view with no id");
            }
            int i3 = p51Var.C;
            if (i3 != 0 && i3 != i) {
                StringBuilder sb2 = new StringBuilder("Can't change container ID of fragment ");
                sb2.append(p51Var);
                int i4 = p51Var.C;
                sb2.append(": was ");
                sb2.append(i4);
                sb2.append(" now ");
                sb2.append(i);
                throw new IllegalStateException(sb2.toString());
            }
            p51Var.C = i;
            p51Var.D = i;
        }
        f(new a(i2, p51Var));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public d71 n(p51 p51Var) {
        f(new a(4, p51Var));
        return this;
    }

    public abstract boolean o();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public d71 p(p51 p51Var) {
        f(new a(3, p51Var));
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public d71 q(int i, p51 p51Var) {
        return r(i, p51Var, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public d71 r(int i, p51 p51Var, String str) {
        if (i != 0) {
            m(i, p51Var, str, 2);
            return this;
        }
        jl.a("Must use non-zero containerViewId");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public d71 s(p51 p51Var, g.b bVar) {
        f(new a(10, p51Var, bVar));
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public d71 t(p51 p51Var) {
        f(new a(8, p51Var));
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public d71 u(boolean z) {
        this.r = z;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public d71 v(int i) {
        this.h = i;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public d71 w(p51 p51Var) {
        f(new a(5, p51Var));
        return this;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public int a;
        public p51 b;
        public boolean c;
        public int d;
        public int e;
        public int f;
        public int g;
        public g.b h;
        public g.b i;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(int i, p51 p51Var) {
            this.a = i;
            this.b = p51Var;
            this.c = false;
            g.b bVar = g.b.j;
            this.h = bVar;
            this.i = bVar;
        }

        public a() {
        }

        public a(int i, p51 p51Var, boolean z) {
            this.a = i;
            this.b = p51Var;
            this.c = z;
            g.b bVar = g.b.j;
            this.h = bVar;
            this.i = bVar;
        }

        public a(int i, p51 p51Var, g.b bVar) {
            this.a = i;
            this.b = p51Var;
            this.c = false;
            this.h = p51Var.X;
            this.i = bVar;
        }
    }
}
