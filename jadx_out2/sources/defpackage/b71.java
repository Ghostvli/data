package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class b71 {
    public static final b71 a = new b71();
    public static c b = c.d;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum a {
        PENALTY_LOG,
        PENALTY_DEATH,
        DETECT_FRAGMENT_REUSE,
        DETECT_FRAGMENT_TAG_USAGE,
        DETECT_WRONG_NESTED_HIERARCHY,
        DETECT_RETAIN_INSTANCE_USAGE,
        DETECT_SET_USER_VISIBLE_HINT,
        DETECT_TARGET_FRAGMENT_USAGE,
        DETECT_WRONG_FRAGMENT_CONTAINER
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void a(String str, r55 r55Var) {
        r55Var.getClass();
        Log.e("FragmentStrictMode", "Policy violation with PENALTY_DEATH in " + str, r55Var);
        throw r55Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void e(p51 p51Var, String str) {
        p51Var.getClass();
        str.getClass();
        q61 q61Var = new q61(p51Var, str);
        b71 b71Var = a;
        b71Var.d(q61Var);
        c cVarB = b71Var.b(p51Var);
        if (cVarB.a().contains(a.DETECT_FRAGMENT_REUSE) && b71Var.l(cVarB, p51Var.getClass(), q61Var.getClass())) {
            b71Var.c(cVarB, q61Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void f(p51 p51Var, ViewGroup viewGroup) {
        p51Var.getClass();
        c71 c71Var = new c71(p51Var, viewGroup);
        b71 b71Var = a;
        b71Var.d(c71Var);
        c cVarB = b71Var.b(p51Var);
        if (cVarB.a().contains(a.DETECT_FRAGMENT_TAG_USAGE) && b71Var.l(cVarB, p51Var.getClass(), c71Var.getClass())) {
            b71Var.c(cVarB, c71Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void g(p51 p51Var) {
        p51Var.getClass();
        o91 o91Var = new o91(p51Var);
        b71 b71Var = a;
        b71Var.d(o91Var);
        c cVarB = b71Var.b(p51Var);
        if (cVarB.a().contains(a.DETECT_TARGET_FRAGMENT_USAGE) && b71Var.l(cVarB, p51Var.getClass(), o91Var.getClass())) {
            b71Var.c(cVarB, o91Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void h(p51 p51Var, boolean z) {
        p51Var.getClass();
        k24 k24Var = new k24(p51Var, z);
        b71 b71Var = a;
        b71Var.d(k24Var);
        c cVarB = b71Var.b(p51Var);
        if (cVarB.a().contains(a.DETECT_SET_USER_VISIBLE_HINT) && b71Var.l(cVarB, p51Var.getClass(), k24Var.getClass())) {
            b71Var.c(cVarB, k24Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void i(p51 p51Var, ViewGroup viewGroup) {
        p51Var.getClass();
        viewGroup.getClass();
        ia5 ia5Var = new ia5(p51Var, viewGroup);
        b71 b71Var = a;
        b71Var.d(ia5Var);
        c cVarB = b71Var.b(p51Var);
        if (cVarB.a().contains(a.DETECT_WRONG_FRAGMENT_CONTAINER) && b71Var.l(cVarB, p51Var.getClass(), ia5Var.getClass())) {
            b71Var.c(cVarB, ia5Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void j(p51 p51Var, p51 p51Var2, int i) {
        p51Var.getClass();
        p51Var2.getClass();
        ja5 ja5Var = new ja5(p51Var, p51Var2, i);
        b71 b71Var = a;
        b71Var.d(ja5Var);
        c cVarB = b71Var.b(p51Var);
        if (cVarB.a().contains(a.DETECT_WRONG_NESTED_HIERARCHY) && b71Var.l(cVarB, p51Var.getClass(), ja5Var.getClass())) {
            b71Var.c(cVarB, ja5Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final c b(p51 p51Var) {
        while (p51Var != null) {
            if (p51Var.H0()) {
                k61 k61VarK0 = p51Var.k0();
                k61VarK0.getClass();
                if (k61VarK0.D0() != null) {
                    c cVarD0 = k61VarK0.D0();
                    cVarD0.getClass();
                    return cVarD0;
                }
            }
            p51Var = p51Var.j0();
        }
        return b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void c(c cVar, final r55 r55Var) {
        p51 p51VarA = r55Var.a();
        final String name = p51VarA.getClass().getName();
        if (cVar.a().contains(a.PENALTY_LOG)) {
            Log.d("FragmentStrictMode", "Policy violation in ".concat(name), r55Var);
        }
        cVar.b();
        if (cVar.a().contains(a.PENALTY_DEATH)) {
            k(p51VarA, new Runnable() { // from class: a71
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    b71.a(name, r55Var);
                }
            });
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void d(r55 r55Var) {
        if (k61.K0(3)) {
            Log.d("FragmentManager", "StrictMode violation in ".concat(r55Var.a().getClass().getName()), r55Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k(p51 p51Var, Runnable runnable) {
        if (!p51Var.H0()) {
            runnable.run();
            return;
        }
        Handler handlerG = p51Var.k0().x0().g();
        handlerG.getClass();
        if (il1.a(handlerG.getLooper(), Looper.myLooper())) {
            runnable.run();
        } else {
            handlerG.post(runnable);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean l(c cVar, Class cls, Class cls2) {
        Set set = (Set) cVar.c().get(cls.getName());
        if (set == null) {
            return true;
        }
        if (il1.a(cls2.getSuperclass(), r55.class) || !ww.E(set, cls2.getSuperclass())) {
            return !set.contains(cls2);
        }
        return false;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c {
        public static final a c = new a(null);
        public static final c d = new c(o24.d(), null, y42.h());
        public final Set a;
        public final Map b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(Set set, b bVar, Map map) {
            set.getClass();
            map.getClass();
            this.a = set;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                linkedHashMap.put((String) entry.getKey(), (Set) entry.getValue());
            }
            this.b = linkedHashMap;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Set a() {
            return this.a;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final b b() {
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Map c() {
            return this.b;
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class a {
            /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: b71.c.a.<init>():void type: THIS */
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public /* synthetic */ a(we0 we0Var) {
                this();
            }

            public a() {
            }
        }
    }
}
