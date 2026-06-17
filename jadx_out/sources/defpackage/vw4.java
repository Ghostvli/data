package defpackage;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class vw4 {
    public static final Unsafe a = D();
    public static final Class b = s5.b();
    public static final boolean c = o(Long.TYPE);
    public static final boolean d = o(Integer.TYPE);
    public static final e e = B();
    public static final boolean f = T();
    public static final boolean g = S();
    public static final long h;
    public static final long i;
    public static final long j;
    public static final long k;
    public static final long l;
    public static final long m;
    public static final long n;
    public static final long o;
    public static final long p;
    public static final long q;
    public static final long r;
    public static final long s;
    public static final long t;
    public static final long u;
    public static final int v;
    public static final boolean w;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements PrivilegedExceptionAction {
        @Override // java.security.PrivilegedExceptionAction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unsafe run() throws IllegalAccessException {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends e {
        public b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // vw4.e
        public boolean c(Object obj, long j) {
            return vw4.w ? vw4.s(obj, j) : vw4.t(obj, j);
        }

        @Override // vw4.e
        public byte d(Object obj, long j) {
            return vw4.w ? vw4.v(obj, j) : vw4.w(obj, j);
        }

        @Override // vw4.e
        public double e(Object obj, long j) {
            return Double.longBitsToDouble(h(obj, j));
        }

        @Override // vw4.e
        public float f(Object obj, long j) {
            return Float.intBitsToFloat(g(obj, j));
        }

        @Override // vw4.e
        public void k(Object obj, long j, boolean z) {
            if (vw4.w) {
                vw4.I(obj, j, z);
            } else {
                vw4.J(obj, j, z);
            }
        }

        @Override // vw4.e
        public void l(Object obj, long j, byte b) {
            if (vw4.w) {
                vw4.L(obj, j, b);
            } else {
                vw4.M(obj, j, b);
            }
        }

        @Override // vw4.e
        public void m(Object obj, long j, double d) {
            p(obj, j, Double.doubleToLongBits(d));
        }

        @Override // vw4.e
        public void n(Object obj, long j, float f) {
            o(obj, j, Float.floatToIntBits(f));
        }

        @Override // vw4.e
        public boolean s() {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends e {
        public c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // vw4.e
        public boolean c(Object obj, long j) {
            return vw4.w ? vw4.s(obj, j) : vw4.t(obj, j);
        }

        @Override // vw4.e
        public byte d(Object obj, long j) {
            return vw4.w ? vw4.v(obj, j) : vw4.w(obj, j);
        }

        @Override // vw4.e
        public double e(Object obj, long j) {
            return Double.longBitsToDouble(h(obj, j));
        }

        @Override // vw4.e
        public float f(Object obj, long j) {
            return Float.intBitsToFloat(g(obj, j));
        }

        @Override // vw4.e
        public void k(Object obj, long j, boolean z) {
            if (vw4.w) {
                vw4.I(obj, j, z);
            } else {
                vw4.J(obj, j, z);
            }
        }

        @Override // vw4.e
        public void l(Object obj, long j, byte b) {
            if (vw4.w) {
                vw4.L(obj, j, b);
            } else {
                vw4.M(obj, j, b);
            }
        }

        @Override // vw4.e
        public void m(Object obj, long j, double d) {
            p(obj, j, Double.doubleToLongBits(d));
        }

        @Override // vw4.e
        public void n(Object obj, long j, float f) {
            o(obj, j, Float.floatToIntBits(f));
        }

        @Override // vw4.e
        public boolean s() {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d extends e {
        public d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // vw4.e
        public boolean c(Object obj, long j) {
            return this.a.getBoolean(obj, j);
        }

        @Override // vw4.e
        public byte d(Object obj, long j) {
            return this.a.getByte(obj, j);
        }

        @Override // vw4.e
        public double e(Object obj, long j) {
            return this.a.getDouble(obj, j);
        }

        @Override // vw4.e
        public float f(Object obj, long j) {
            return this.a.getFloat(obj, j);
        }

        @Override // vw4.e
        public void k(Object obj, long j, boolean z) {
            this.a.putBoolean(obj, j, z);
        }

        @Override // vw4.e
        public void l(Object obj, long j, byte b) {
            this.a.putByte(obj, j, b);
        }

        @Override // vw4.e
        public void m(Object obj, long j, double d) {
            this.a.putDouble(obj, j, d);
        }

        @Override // vw4.e
        public void n(Object obj, long j, float f) {
            this.a.putFloat(obj, j, f);
        }

        @Override // vw4.e
        public boolean r() {
            if (!super.r()) {
                return false;
            }
            try {
                Class<?> cls = this.a.getClass();
                Class cls2 = Long.TYPE;
                cls.getMethod("getByte", Object.class, cls2);
                cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
                cls.getMethod("getBoolean", Object.class, cls2);
                cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
                cls.getMethod("getFloat", Object.class, cls2);
                cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
                cls.getMethod("getDouble", Object.class, cls2);
                cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
                return true;
            } catch (Throwable th) {
                vw4.G(th);
                return false;
            }
        }

        @Override // vw4.e
        public boolean s() {
            if (!super.s()) {
                return false;
            }
            try {
                Class<?> cls = this.a.getClass();
                Class cls2 = Long.TYPE;
                cls.getMethod("getByte", cls2);
                cls.getMethod("putByte", cls2, Byte.TYPE);
                cls.getMethod("getInt", cls2);
                cls.getMethod("putInt", cls2, Integer.TYPE);
                cls.getMethod("getLong", cls2);
                cls.getMethod("putLong", cls2, cls2);
                cls.getMethod("copyMemory", cls2, cls2, cls2);
                cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                return true;
            } catch (Throwable th) {
                vw4.G(th);
                return false;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class e {
        public Unsafe a;

        public e(Unsafe unsafe) {
            this.a = unsafe;
        }

        public final int a(Class cls) {
            return this.a.arrayBaseOffset(cls);
        }

        public final int b(Class cls) {
            return this.a.arrayIndexScale(cls);
        }

        public abstract boolean c(Object obj, long j);

        public abstract byte d(Object obj, long j);

        public abstract double e(Object obj, long j);

        public abstract float f(Object obj, long j);

        public final int g(Object obj, long j) {
            return this.a.getInt(obj, j);
        }

        public final long h(Object obj, long j) {
            return this.a.getLong(obj, j);
        }

        public final Object i(Object obj, long j) {
            return this.a.getObject(obj, j);
        }

        public final long j(Field field) {
            return this.a.objectFieldOffset(field);
        }

        public abstract void k(Object obj, long j, boolean z);

        public abstract void l(Object obj, long j, byte b);

        public abstract void m(Object obj, long j, double d);

        public abstract void n(Object obj, long j, float f);

        public final void o(Object obj, long j, int i) {
            this.a.putInt(obj, j, i);
        }

        public final void p(Object obj, long j, long j2) {
            this.a.putLong(obj, j, j2);
        }

        public final void q(Object obj, long j, Object obj2) {
            this.a.putObject(obj, j, obj2);
        }

        public boolean r() {
            Unsafe unsafe = this.a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("arrayBaseOffset", Class.class);
                cls.getMethod("arrayIndexScale", Class.class);
                Class cls2 = Long.TYPE;
                cls.getMethod("getInt", Object.class, cls2);
                cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
                cls.getMethod("getLong", Object.class, cls2);
                cls.getMethod("putLong", Object.class, cls2, cls2);
                cls.getMethod("getObject", Object.class, cls2);
                cls.getMethod("putObject", Object.class, cls2, Object.class);
                return true;
            } catch (Throwable th) {
                vw4.G(th);
                return false;
            }
        }

        public boolean s() {
            Unsafe unsafe = this.a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                return vw4.n() != null;
            } catch (Throwable th) {
                vw4.G(th);
                return false;
            }
        }
    }

    static {
        long jL = l(byte[].class);
        h = jL;
        i = l(boolean[].class);
        j = m(boolean[].class);
        k = l(int[].class);
        l = m(int[].class);
        m = l(long[].class);
        n = m(long[].class);
        o = l(float[].class);
        p = m(float[].class);
        q = l(double[].class);
        r = m(double[].class);
        s = l(Object[].class);
        t = m(Object[].class);
        u = q(n());
        v = (int) (jL & 7);
        w = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static long A(Object obj, long j2) {
        return e.h(obj, j2);
    }

    public static e B() {
        Unsafe unsafe = a;
        if (unsafe == null) {
            return null;
        }
        if (!s5.c()) {
            return new d(unsafe);
        }
        if (c) {
            return new c(unsafe);
        }
        if (d) {
            return new b(unsafe);
        }
        return null;
    }

    public static Object C(Object obj, long j2) {
        return e.i(obj, j2);
    }

    public static Unsafe D() {
        Unsafe unsafe;
        try {
            unsafe = (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            unsafe = null;
        }
        if (unsafe == null) {
            return null;
        }
        try {
            unsafe.arrayBaseOffset(byte[].class);
            return unsafe;
        } catch (Exception unused2) {
            Logger.getLogger(vw4.class.getName()).log(Level.WARNING, "As part of the planned removal, sun.misc.Unsafe is available in the current environment but configured to throw on use. Protobuf will continue without using it, but with slightly reduced performance. --sun-misc-unsafe-memory-access=allow is likely available to opt back in if desired. A later Protobuf version release will stop using sun.misc.Unsafe entirely.");
            return null;
        }
    }

    public static boolean E() {
        return g;
    }

    public static boolean F() {
        return f;
    }

    public static void G(Throwable th) {
        Logger.getLogger(vw4.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    public static void H(Object obj, long j2, boolean z) {
        e.k(obj, j2, z);
    }

    public static void I(Object obj, long j2, boolean z) {
        L(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    public static void J(Object obj, long j2, boolean z) {
        M(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    public static void K(byte[] bArr, long j2, byte b2) {
        e.l(bArr, h + j2, b2);
    }

    public static void L(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int iZ = z(obj, j3);
        int i2 = ((~((int) j2)) & 3) << 3;
        P(obj, j3, ((255 & b2) << i2) | (iZ & (~(255 << i2))));
    }

    public static void M(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int i2 = (((int) j2) & 3) << 3;
        P(obj, j3, ((255 & b2) << i2) | (z(obj, j3) & (~(255 << i2))));
    }

    public static void N(Object obj, long j2, double d2) {
        e.m(obj, j2, d2);
    }

    public static void O(Object obj, long j2, float f2) {
        e.n(obj, j2, f2);
    }

    public static void P(Object obj, long j2, int i2) {
        e.o(obj, j2, i2);
    }

    public static void Q(Object obj, long j2, long j3) {
        e.p(obj, j2, j3);
    }

    public static void R(Object obj, long j2, Object obj2) {
        e.q(obj, j2, obj2);
    }

    public static boolean S() {
        e eVar = e;
        if (eVar == null) {
            return false;
        }
        return eVar.r();
    }

    public static boolean T() {
        e eVar = e;
        if (eVar == null) {
            return false;
        }
        return eVar.s();
    }

    public static Object k(Class cls) {
        try {
            return a.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static int l(Class cls) {
        if (g) {
            return e.a(cls);
        }
        return -1;
    }

    public static int m(Class cls) {
        if (g) {
            return e.b(cls);
        }
        return -1;
    }

    public static Field n() {
        Field fieldP;
        if (s5.c() && (fieldP = p(Buffer.class, "effectiveDirectAddress")) != null) {
            return fieldP;
        }
        Field fieldP2 = p(Buffer.class, "address");
        if (fieldP2 == null || fieldP2.getType() != Long.TYPE) {
            return null;
        }
        return fieldP2;
    }

    public static boolean o(Class cls) {
        if (!s5.c()) {
            return false;
        }
        try {
            Class cls2 = b;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static Field p(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static long q(Field field) {
        e eVar;
        if (field == null || (eVar = e) == null) {
            return -1L;
        }
        return eVar.j(field);
    }

    public static boolean r(Object obj, long j2) {
        return e.c(obj, j2);
    }

    public static boolean s(Object obj, long j2) {
        return v(obj, j2) != 0;
    }

    public static boolean t(Object obj, long j2) {
        return w(obj, j2) != 0;
    }

    public static byte u(byte[] bArr, long j2) {
        return e.d(bArr, h + j2);
    }

    public static byte v(Object obj, long j2) {
        return (byte) ((z(obj, (-4) & j2) >>> ((int) (((~j2) & 3) << 3))) & 255);
    }

    public static byte w(Object obj, long j2) {
        return (byte) ((z(obj, (-4) & j2) >>> ((int) ((j2 & 3) << 3))) & 255);
    }

    public static double x(Object obj, long j2) {
        return e.e(obj, j2);
    }

    public static float y(Object obj, long j2) {
        return e.f(obj, j2);
    }

    public static int z(Object obj, long j2) {
        return e.g(obj, j2);
    }
}
