package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class uu0 {
    public static volatile uu0 s;
    public static final vu0 t = new vu0();
    public static final Map u = new HashMap();
    public final Map a;
    public final Map b;
    public final Map c;
    public final ThreadLocal d;
    public final d42 e;
    public final ag3 f;
    public final tf g;
    public final ib h;
    public final qh4 i;
    public final ExecutorService j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final int q;
    public final h02 r;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends ThreadLocal {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: initialValue()Ljava/lang/Object; */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c initialValue() {
            return new c();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        static {
            int[] iArr = new int[ThreadMode.values().length];
            a = iArr;
            try {
                iArr[ThreadMode.POSTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ThreadMode.MAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ThreadMode.MAIN_ORDERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ThreadMode.BACKGROUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ThreadMode.ASYNC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c {
        public final List a = new ArrayList();
        public boolean b;
        public boolean c;
        public sh4 d;
        public Object e;
        public boolean f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public uu0(vu0 vu0Var) {
        this.d = new a();
        this.r = vu0Var.c();
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = new ConcurrentHashMap();
        d42 d42VarD = vu0Var.d();
        this.e = d42VarD;
        this.f = d42VarD != null ? d42VarD.a(this) : null;
        this.g = new tf(this);
        this.h = new ib(this);
        List list = vu0Var.j;
        this.q = list != null ? list.size() : 0;
        this.i = new qh4(vu0Var.j, vu0Var.h, vu0Var.g);
        this.l = vu0Var.a;
        this.m = vu0Var.b;
        this.n = vu0Var.c;
        this.o = vu0Var.d;
        this.k = vu0Var.e;
        this.p = vu0Var.f;
        this.j = vu0Var.i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void a(List list, Class[] clsArr) {
        for (Class cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static vu0 b() {
        return new vu0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static uu0 d() {
        uu0 uu0Var;
        uu0 uu0Var2 = s;
        if (uu0Var2 != null) {
            return uu0Var2;
        }
        synchronized (uu0.class) {
            try {
                uu0Var = s;
                if (uu0Var == null) {
                    uu0Var = new uu0();
                    s = uu0Var;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return uu0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List k(Class cls) {
        List arrayList;
        Map map = u;
        synchronized (map) {
            try {
                arrayList = (List) map.get(cls);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    for (Class superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
                        arrayList.add(superclass);
                        a(arrayList, superclass.getInterfaces());
                    }
                    u.put(cls, arrayList);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void c(sh4 sh4Var, Object obj) {
        if (obj != null) {
            o(sh4Var, obj, j());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ExecutorService e() {
        return this.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public h02 f() {
        return this.r;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g(sh4 sh4Var, Object obj, Throwable th) {
        if (!(obj instanceof mh4)) {
            if (this.k) {
                throw new wu0("Invoking subscriber failed", th);
            }
            if (this.l) {
                this.r.b(Level.SEVERE, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + sh4Var.a.getClass(), th);
            }
            if (this.n) {
                l(new mh4(this, th, obj, sh4Var.a));
                return;
            }
            return;
        }
        if (this.l) {
            h02 h02Var = this.r;
            Level level = Level.SEVERE;
            h02Var.b(level, "SubscriberExceptionEvent subscriber " + sh4Var.a.getClass() + " threw an exception", th);
            mh4 mh4Var = (mh4) obj;
            this.r.b(level, "Initial event " + mh4Var.c + " caused exception in " + mh4Var.d, mh4Var.b);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void h(ja3 ja3Var) {
        Object obj = ja3Var.a;
        sh4 sh4Var = ja3Var.b;
        ja3.b(ja3Var);
        if (sh4Var.c) {
            i(sh4Var, obj);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void i(sh4 sh4Var, Object obj) {
        try {
            sh4Var.b.a.invoke(sh4Var.a, obj);
        } catch (IllegalAccessException e) {
            l02.a("Unexpected exception", e);
        } catch (InvocationTargetException e2) {
            g(sh4Var, obj, e2.getCause());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean j() {
        d42 d42Var = this.e;
        return d42Var == null || d42Var.b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void l(Object obj) {
        c cVar = (c) this.d.get();
        List list = cVar.a;
        list.add(obj);
        if (cVar.b) {
            return;
        }
        cVar.c = j();
        cVar.b = true;
        if (cVar.f) {
            throw new wu0("Internal error. Abort state was not reset");
        }
        while (true) {
            try {
                if (list.isEmpty()) {
                    return;
                } else {
                    m(list.remove(0), cVar);
                }
            } finally {
                cVar.b = false;
                cVar.c = false;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void m(Object obj, c cVar) {
        boolean zN;
        Class<?> cls = obj.getClass();
        if (this.p) {
            List listK = k(cls);
            int size = listK.size();
            zN = false;
            for (int i = 0; i < size; i++) {
                zN |= n(obj, cVar, (Class) listK.get(i));
            }
        } else {
            zN = n(obj, cVar, cls);
        }
        if (zN) {
            return;
        }
        if (this.m) {
            this.r.a(Level.FINE, "No subscribers registered for event " + cls);
        }
        if (!this.o || cls == h33.class || cls == mh4.class) {
            return;
        }
        l(new h33(this, obj));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean n(Object obj, c cVar, Class cls) {
        CopyOnWriteArrayList<sh4> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = (CopyOnWriteArrayList) this.a.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        for (sh4 sh4Var : copyOnWriteArrayList) {
            cVar.e = obj;
            cVar.d = sh4Var;
            try {
                o(sh4Var, obj, cVar.c);
                if (cVar.f) {
                    return true;
                }
            } finally {
                cVar.e = null;
                cVar.d = null;
                cVar.f = false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void o(sh4 sh4Var, Object obj, boolean z) {
        int i = b.a[sh4Var.b.b.ordinal()];
        if (i == 1) {
            i(sh4Var, obj);
            return;
        }
        if (i == 2) {
            if (z) {
                i(sh4Var, obj);
                return;
            } else {
                this.f.a(sh4Var, obj);
                return;
            }
        }
        if (i == 3) {
            ag3 ag3Var = this.f;
            if (ag3Var != null) {
                ag3Var.a(sh4Var, obj);
                return;
            } else {
                i(sh4Var, obj);
                return;
            }
        }
        if (i != 4) {
            if (i == 5) {
                this.h.a(sh4Var, obj);
                return;
            } else {
                d.a("Unknown thread mode: ", sh4Var.b.b);
                return;
            }
        }
        if (z) {
            this.g.a(sh4Var, obj);
        } else {
            i(sh4Var, obj);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void p(Object obj) {
        if (y5.c() && !y5.a()) {
            zt2.a("It looks like you are using EventBus on Android, make sure to add the \"eventbus\" Android library to your dependencies.");
            return;
        }
        List listA = this.i.a(obj.getClass());
        synchronized (this) {
            try {
                Iterator it = listA.iterator();
                while (it.hasNext()) {
                    q(obj, (ph4) it.next());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void q(Object obj, ph4 ph4Var) {
        Class cls = ph4Var.c;
        sh4 sh4Var = new sh4(obj, ph4Var);
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.a.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.a.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(sh4Var)) {
            throw new wu0("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        for (int i = 0; i <= size; i++) {
            if (i == size || ph4Var.d > ((sh4) copyOnWriteArrayList.get(i)).b.d) {
                copyOnWriteArrayList.add(i, sh4Var);
                break;
            }
        }
        List arrayList = (List) this.b.get(obj);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.b.put(obj, arrayList);
        }
        arrayList.add(cls);
        if (ph4Var.e) {
            boolean z = this.p;
            Map map = this.c;
            if (!z) {
                c(sh4Var, map.get(cls));
                return;
            }
            for (Map.Entry entry : map.entrySet()) {
                if (cls.isAssignableFrom((Class) entry.getKey())) {
                    c(sh4Var, entry.getValue());
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized void r(Object obj) {
        try {
            List list = (List) this.b.get(obj);
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    s(obj, (Class) it.next());
                }
                this.b.remove(obj);
            } else {
                this.r.a(Level.WARNING, "Subscriber to unregister was not registered before: " + obj.getClass());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void s(Object obj, Class cls) {
        List list = (List) this.a.get(cls);
        if (list != null) {
            int size = list.size();
            int i = 0;
            while (i < size) {
                sh4 sh4Var = (sh4) list.get(i);
                if (sh4Var.a == obj) {
                    sh4Var.c = false;
                    list.remove(i);
                    i--;
                    size--;
                }
                i++;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "EventBus[indexCount=" + this.q + ", eventInheritance=" + this.p + "]";
    }

    public uu0() {
        this(t);
    }
}
