package defpackage;

import defpackage.b0;
import defpackage.c0;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c0 extends el1 implements lu1 {
    public static final Object i = new Object();
    public static final js1 j = new js1(b0.class);
    public static final boolean k;
    public static final b l;
    public volatile Object f;
    public volatile b0.d g;
    public volatile f h;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class b {
        public b() {
        }

        public abstract boolean a(c0 c0Var, b0.d dVar, b0.d dVar2);

        public abstract boolean b(c0 c0Var, Object obj, Object obj2);

        public abstract boolean c(c0 c0Var, f fVar, f fVar2);

        public abstract b0.d d(c0 c0Var, b0.d dVar);

        public abstract f e(c0 c0Var, f fVar);

        public abstract void f(f fVar, f fVar2);

        public abstract void g(f fVar, Thread thread);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends b {
        public static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(f.class, Thread.class, "a");
        public static final AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(f.class, f.class, "b");
        public static final AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(c0.class, f.class, "h");
        public static final AtomicReferenceFieldUpdater d = AtomicReferenceFieldUpdater.newUpdater(c0.class, b0.d.class, "g");
        public static final AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(c0.class, Object.class, "f");

        public c() {
            super();
        }

        @Override // c0.b
        public boolean a(c0 c0Var, b0.d dVar, b0.d dVar2) {
            return z0.a(d, c0Var, dVar, dVar2);
        }

        @Override // c0.b
        public boolean b(c0 c0Var, Object obj, Object obj2) {
            return z0.a(e, c0Var, obj, obj2);
        }

        @Override // c0.b
        public boolean c(c0 c0Var, f fVar, f fVar2) {
            return z0.a(c, c0Var, fVar, fVar2);
        }

        @Override // c0.b
        public b0.d d(c0 c0Var, b0.d dVar) {
            return (b0.d) d.getAndSet(c0Var, dVar);
        }

        @Override // c0.b
        public f e(c0 c0Var, f fVar) {
            return (f) c.getAndSet(c0Var, fVar);
        }

        @Override // c0.b
        public void f(f fVar, f fVar2) {
            b.lazySet(fVar, fVar2);
        }

        @Override // c0.b
        public void g(f fVar, Thread thread) {
            a.lazySet(fVar, thread);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d extends b {
        public d() {
            super();
        }

        @Override // c0.b
        public boolean a(c0 c0Var, b0.d dVar, b0.d dVar2) {
            synchronized (c0Var) {
                try {
                    if (c0Var.g != dVar) {
                        return false;
                    }
                    c0Var.g = dVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // c0.b
        public boolean b(c0 c0Var, Object obj, Object obj2) {
            synchronized (c0Var) {
                try {
                    if (c0Var.f != obj) {
                        return false;
                    }
                    c0Var.f = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // c0.b
        public boolean c(c0 c0Var, f fVar, f fVar2) {
            synchronized (c0Var) {
                try {
                    if (c0Var.h != fVar) {
                        return false;
                    }
                    c0Var.h = fVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // c0.b
        public b0.d d(c0 c0Var, b0.d dVar) {
            b0.d dVar2;
            synchronized (c0Var) {
                try {
                    dVar2 = c0Var.g;
                    if (dVar2 != dVar) {
                        c0Var.g = dVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return dVar2;
        }

        @Override // c0.b
        public f e(c0 c0Var, f fVar) {
            f fVar2;
            synchronized (c0Var) {
                try {
                    fVar2 = c0Var.h;
                    if (fVar2 != fVar) {
                        c0Var.h = fVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return fVar2;
        }

        @Override // c0.b
        public void f(f fVar, f fVar2) {
            fVar.b = fVar2;
        }

        @Override // c0.b
        public void g(f fVar, Thread thread) {
            fVar.a = thread;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e extends b {
        public static final Unsafe a;
        public static final long b;
        public static final long c;
        public static final long d;
        public static final long e;
        public static final long f;

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (SecurityException unused) {
                    unsafe = (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction() { // from class: e0
                        @Override // java.security.PrivilegedExceptionAction
                        public final Object run() {
                            return c0.e.i();
                        }
                    });
                }
                try {
                    c = unsafe.objectFieldOffset(c0.class.getDeclaredField("h"));
                    b = unsafe.objectFieldOffset(c0.class.getDeclaredField("g"));
                    d = unsafe.objectFieldOffset(c0.class.getDeclaredField("f"));
                    e = unsafe.objectFieldOffset(f.class.getDeclaredField("a"));
                    f = unsafe.objectFieldOffset(f.class.getDeclaredField("b"));
                    a = unsafe;
                } catch (NoSuchFieldException e2) {
                    wg1.a(e2);
                }
            } catch (PrivilegedActionException e3) {
                cx4.a("Could not initialize intrinsics", e3.getCause());
            }
        }

        public e() {
            super();
        }

        public static /* synthetic */ Unsafe i() throws IllegalAccessException {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            throw new NoSuchFieldError("the Unsafe");
        }

        @Override // c0.b
        public boolean a(c0 c0Var, b0.d dVar, b0.d dVar2) {
            return d0.a(a, c0Var, b, dVar, dVar2);
        }

        @Override // c0.b
        public boolean b(c0 c0Var, Object obj, Object obj2) {
            return d0.a(a, c0Var, d, obj, obj2);
        }

        @Override // c0.b
        public boolean c(c0 c0Var, f fVar, f fVar2) {
            return d0.a(a, c0Var, c, fVar, fVar2);
        }

        @Override // c0.b
        public b0.d d(c0 c0Var, b0.d dVar) {
            b0.d dVar2;
            do {
                dVar2 = c0Var.g;
                if (dVar == dVar2) {
                    break;
                }
            } while (!a(c0Var, dVar2, dVar));
            return dVar2;
        }

        @Override // c0.b
        public f e(c0 c0Var, f fVar) {
            f fVar2;
            do {
                fVar2 = c0Var.h;
                if (fVar == fVar2) {
                    break;
                }
            } while (!c(c0Var, fVar2, fVar));
            return fVar2;
        }

        @Override // c0.b
        public void f(f fVar, f fVar2) {
            a.putObject(fVar, f, fVar2);
        }

        @Override // c0.b
        public void g(f fVar, Thread thread) {
            a.putObject(fVar, e, thread);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.util.logging.Logger] */
    /* JADX WARN: Type inference failed for: r1v1, types: [c0$a] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    static {
        boolean z;
        b cVar;
        Throwable th;
        b eVar;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        k = z;
        ?? r1 = 0;
        ?? r12 = 0;
        if (o()) {
            try {
                eVar = new e();
            } catch (Error | Exception e2) {
                try {
                    cVar = new c();
                } catch (Error | Exception e3) {
                    d dVar = new d();
                    r1 = e3;
                    cVar = dVar;
                }
                b bVar = cVar;
                th = e2;
                eVar = bVar;
                r12 = r1;
            }
        } else {
            try {
                eVar = new c();
            } catch (NoClassDefFoundError unused2) {
                eVar = new d();
            }
        }
        th = null;
        l = eVar;
        if (r12 != 0) {
            js1 js1Var = j;
            Logger loggerA = js1Var.a();
            Level level = Level.SEVERE;
            loggerA.log(level, "UnsafeAtomicHelper is broken!", th);
            js1Var.a().log(level, "AtomicReferenceFieldUpdaterAtomicHelper is broken!", r12);
        }
    }

    public static boolean j(c0 c0Var, Object obj, Object obj2) {
        return l.b(c0Var, obj, obj2);
    }

    public static boolean o() {
        String property = System.getProperty("java.runtime.name", "");
        return property == null || property.contains("Android");
    }

    public static void p(f fVar, f fVar2) {
        l.f(fVar, fVar2);
    }

    public static void q(f fVar, Thread thread) {
        l.g(fVar, thread);
    }

    public final Object f() throws InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.f;
        if ((obj2 != null) && b0.K(obj2)) {
            return b0.F(obj2);
        }
        f fVar = this.h;
        if (fVar != f.c) {
            f fVar2 = new f();
            do {
                fVar2.a(fVar);
                if (k(fVar, fVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            s(fVar2);
                            throw new InterruptedException();
                        }
                        obj = this.f;
                    } while (!((obj != null) & b0.K(obj)));
                    return b0.F(obj);
                }
                fVar = this.h;
            } while (fVar != f.c);
        }
        Object obj3 = this.f;
        Objects.requireNonNull(obj3);
        return b0.F(obj3);
    }

    public final Object h(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j2);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f;
        if ((obj != null) && b0.K(obj)) {
            return b0.F(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            f fVar = this.h;
            if (fVar != f.c) {
                f fVar2 = new f();
                do {
                    fVar2.a(fVar);
                    if (k(fVar, fVar2)) {
                        do {
                            a73.a(this, nanos);
                            if (Thread.interrupted()) {
                                s(fVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f;
                            if ((obj2 != null) && b0.K(obj2)) {
                                return b0.F(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        s(fVar2);
                    } else {
                        fVar = this.h;
                    }
                } while (fVar != f.c);
            }
            Object obj3 = this.f;
            Objects.requireNonNull(obj3);
            return b0.F(obj3);
        }
        while (nanos > 0) {
            Object obj4 = this.f;
            if ((obj4 != null) && b0.K(obj4)) {
                return b0.F(obj4);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String strConcat = "Waited " + j2 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String strConcat2 = strConcat.concat(" (plus ");
            long j3 = -nanos;
            long jConvert = timeUnit.convert(j3, TimeUnit.NANOSECONDS);
            long nanos2 = j3 - timeUnit.toNanos(jConvert);
            boolean z = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String strConcat3 = strConcat2 + jConvert + " " + lowerCase;
                if (z) {
                    strConcat3 = strConcat3.concat(",");
                }
                strConcat2 = strConcat3.concat(" ");
            }
            if (z) {
                strConcat2 = strConcat2 + nanos2 + " nanoseconds ";
            }
            strConcat = strConcat2.concat("delay)");
        }
        if (isDone()) {
            throw new TimeoutException(strConcat.concat(" but future completed as timeout expired"));
        }
        throw new TimeoutException(strConcat + " for " + string);
    }

    public final boolean i(b0.d dVar, b0.d dVar2) {
        return l.a(this, dVar, dVar2);
    }

    public final boolean k(f fVar, f fVar2) {
        return l.c(this, fVar, fVar2);
    }

    public final b0.d l(b0.d dVar) {
        return l.d(this, dVar);
    }

    public final f m(f fVar) {
        return l.e(this, fVar);
    }

    public final b0.d n() {
        return this.g;
    }

    public final void r() {
        for (f fVarM = m(f.c); fVarM != null; fVarM = fVarM.b) {
            fVarM.b();
        }
    }

    public final void s(f fVar) {
        fVar.a = null;
        while (true) {
            f fVar2 = this.h;
            if (fVar2 == f.c) {
                return;
            }
            f fVar3 = null;
            while (fVar2 != null) {
                f fVar4 = fVar2.b;
                if (fVar2.a != null) {
                    fVar3 = fVar2;
                } else if (fVar3 != null) {
                    fVar3.b = fVar4;
                    if (fVar3.a == null) {
                        break;
                    }
                } else if (!k(fVar2, fVar4)) {
                    break;
                }
                fVar2 = fVar4;
            }
            return;
        }
    }

    public final Object t() {
        return this.f;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class f {
        public static final f c = new f(false);
        public volatile Thread a;
        public volatile f b;

        public f() {
            c0.q(this, Thread.currentThread());
        }

        public void a(f fVar) {
            c0.p(this, fVar);
        }

        public void b() {
            Thread thread = this.a;
            if (thread != null) {
                this.a = null;
                LockSupport.unpark(thread);
            }
        }

        public f(boolean z) {
        }
    }
}
