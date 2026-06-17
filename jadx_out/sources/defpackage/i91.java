package defpackage;

import defpackage.aa5;
import defpackage.b01;
import defpackage.bl1;
import defpackage.ha;
import defpackage.p0;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i91 extends p0 {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Class<?>, i91> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize = -1;
    protected mw4 unknownFields = mw4.c();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b extends u0 {
        public final i91 b;

        public b(i91 i91Var) {
            this.b = i91Var;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c implements b01.a {
        public final int f;
        public final aa5.b g;
        public final boolean h;
        public final boolean i;

        public c(bl1.d dVar, int i, aa5.b bVar, boolean z, boolean z2) {
            this.f = i;
            this.g = bVar;
            this.h = z;
            this.i = z2;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            return this.f - cVar.f;
        }

        public bl1.d b() {
            return null;
        }

        @Override // b01.a
        public boolean c() {
            return this.h;
        }

        @Override // b01.a
        public int d() {
            return this.f;
        }

        public aa5.b e() {
            return this.g;
        }

        @Override // b01.a
        public aa5.c s() {
            return this.g.b();
        }

        @Override // b01.a
        public boolean u() {
            return this.i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d extends vy0 {
        public final rs2 a;
        public final Object b;
        public final rs2 c;
        public final c d;

        public d(rs2 rs2Var, Object obj, rs2 rs2Var2, c cVar, Class cls) {
            if (rs2Var == null) {
                jl.a("Null containingTypeDefaultInstance");
                throw null;
            }
            if (cVar.e() == aa5.b.r && rs2Var2 == null) {
                jl.a("Null messageDefaultInstance");
                throw null;
            }
            this.a = rs2Var;
            this.b = obj;
            this.c = rs2Var2;
            this.d = cVar;
        }

        public aa5.b b() {
            return this.d.e();
        }

        public rs2 c() {
            return this.c;
        }

        public int d() {
            return this.d.d();
        }

        public boolean e() {
            return this.d.h;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum e {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    public static d b(vy0 vy0Var) {
        if (vy0Var.a()) {
            return (d) vy0Var;
        }
        jl.a("Expected a lite extension.");
        return null;
    }

    public static i91 c(i91 i91Var) throws ol1 {
        if (i91Var == null || i91Var.isInitialized()) {
            return i91Var;
        }
        throw i91Var.newUninitializedMessageException().a().k(i91Var);
    }

    public static bl1.a emptyBooleanList() {
        return al.g();
    }

    public static bl1.b emptyDoubleList() {
        return cn0.g();
    }

    public static bl1.f emptyFloatList() {
        return s21.g();
    }

    public static bl1.g emptyIntList() {
        return nk1.g();
    }

    public static bl1.h emptyLongList() {
        return s02.g();
    }

    public static <E> bl1.i emptyProtobufList() {
        return mi3.d();
    }

    public static final boolean f(i91 i91Var, boolean z) {
        byte bByteValue = ((Byte) i91Var.dynamicMethod(e.GET_MEMOIZED_IS_INITIALIZED, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zC = li3.a().c(i91Var).c(i91Var);
        if (z) {
            i91Var.dynamicMethod(e.SET_MEMOIZED_IS_INITIALIZED, zC ? i91Var : null, null);
        }
        return zC;
    }

    public static i91 g(i91 i91Var, InputStream inputStream, xy0 xy0Var) throws ol1 {
        try {
            int i = inputStream.read();
            if (i == -1) {
                return null;
            }
            hv hvVarH = hv.h(new p0.a.C0109a(inputStream, hv.z(i, inputStream)));
            i91 partialFrom = parsePartialFrom(i91Var, hvVarH, xy0Var);
            try {
                hvVarH.a(0);
                return partialFrom;
            } catch (ol1 e2) {
                throw e2.k(partialFrom);
            }
        } catch (ol1 e3) {
            if (e3.a()) {
                throw new ol1(e3);
            }
            throw e3;
        } catch (IOException e4) {
            throw new ol1(e4);
        }
    }

    public static <T extends i91> T getDefaultInstance(Class<T> cls) {
        T t = (T) defaultInstanceMap.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (T) defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e2) {
                l02.a("Class initialization cannot fail.", e2);
                return null;
            }
        }
        if (t != null) {
            return t;
        }
        T t2 = (T) ((i91) vw4.k(cls)).getDefaultInstanceForType();
        if (t2 != null) {
            defaultInstanceMap.put((Class<?>) cls, t2);
            return t2;
        }
        z20.a();
        return null;
    }

    public static Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e2);
        }
    }

    public static i91 h(i91 i91Var, hn hnVar, xy0 xy0Var) throws ol1 {
        hv hvVarP = hnVar.p();
        i91 partialFrom = parsePartialFrom(i91Var, hvVarP, xy0Var);
        try {
            hvVarP.a(0);
            return partialFrom;
        } catch (ol1 e2) {
            throw e2.k(partialFrom);
        }
    }

    public static i91 i(i91 i91Var, byte[] bArr, int i, int i2, xy0 xy0Var) throws ol1 {
        if (i2 == 0) {
            return i91Var;
        }
        i91 i91VarNewMutableInstance = i91Var.newMutableInstance();
        try {
            py3 py3VarC = li3.a().c(i91VarNewMutableInstance);
            py3VarC.e(i91VarNewMutableInstance, bArr, i, i + i2, new ha.a(xy0Var));
            py3VarC.b(i91VarNewMutableInstance);
            return i91VarNewMutableInstance;
        } catch (cw4 e2) {
            throw e2.a().k(i91VarNewMutableInstance);
        } catch (IndexOutOfBoundsException unused) {
            throw ol1.m().k(i91VarNewMutableInstance);
        } catch (ol1 e3) {
            ol1 ol1Var = e3;
            if (ol1Var.a()) {
                ol1Var = new ol1(ol1Var);
            }
            throw ol1Var.k(i91VarNewMutableInstance);
        } catch (IOException e4) {
            if (e4.getCause() instanceof ol1) {
                throw ((ol1) e4.getCause());
            }
            throw new ol1(e4).k(i91VarNewMutableInstance);
        }
    }

    public static Object invokeOrDie(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            cx4.a("Couldn't use Java reflection to implement protocol message reflection.", e2);
            return null;
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            cx4.a("Unexpected exception thrown by generated accessor method.", cause);
            return null;
        }
    }

    public static bl1.g mutableCopy(bl1.g gVar) {
        return gVar.a(gVar.size() * 2);
    }

    public static Object newMessageInfo(rs2 rs2Var, String str, Object[] objArr) {
        return new co3(rs2Var, str, objArr);
    }

    public static <ContainingType extends rs2, Type> d newRepeatedGeneratedExtension(ContainingType containingtype, rs2 rs2Var, bl1.d dVar, int i, aa5.b bVar, boolean z, Class<?> cls) {
        return new d(containingtype, mi3.d(), rs2Var, new c(dVar, i, bVar, true, z), cls);
    }

    public static <ContainingType extends rs2, Type> d newSingularGeneratedExtension(ContainingType containingtype, Type type, rs2 rs2Var, bl1.d dVar, int i, aa5.b bVar, Class<?> cls) {
        return new d(containingtype, type, rs2Var, new c(dVar, i, bVar, false, false), cls);
    }

    public static <T extends i91> T parseDelimitedFrom(T t, InputStream inputStream) {
        return (T) c(g(t, inputStream, xy0.b()));
    }

    public static <T extends i91> T parseFrom(T t, InputStream inputStream) {
        return (T) c(parsePartialFrom(t, hv.h(inputStream), xy0.b()));
    }

    public static <T extends i91> T parsePartialFrom(T t, hv hvVar, xy0 xy0Var) throws ol1 {
        T t2 = (T) t.newMutableInstance();
        try {
            py3 py3VarC = li3.a().c(t2);
            py3VarC.d(t2, iv.P(hvVar), xy0Var);
            py3VarC.b(t2);
            return t2;
        } catch (cw4 e2) {
            throw e2.a().k(t2);
        } catch (ol1 e3) {
            e = e3;
            if (e.a()) {
                e = new ol1(e);
            }
            throw e.k(t2);
        } catch (IOException e4) {
            if (e4.getCause() instanceof ol1) {
                throw ((ol1) e4.getCause());
            }
            throw new ol1(e4).k(t2);
        } catch (RuntimeException e5) {
            if (e5.getCause() instanceof ol1) {
                throw ((ol1) e5.getCause());
            }
            throw e5;
        }
    }

    public static <T extends i91> void registerDefaultInstance(Class<T> cls, T t) {
        t.markImmutable();
        defaultInstanceMap.put(cls, t);
    }

    public Object buildMessageInfo() {
        return dynamicMethod(e.BUILD_MESSAGE_INFO, null, null);
    }

    public void clearMemoizedHashCode() {
        this.memoizedHashCode = 0;
    }

    public void clearMemoizedSerializedSize() {
        setMemoizedSerializedSize(Integer.MAX_VALUE);
    }

    public int computeHashCode() {
        return li3.a().c(this).i(this);
    }

    public final <MessageType2 extends i91, BuilderType2 extends a> BuilderType2 createBuilder() {
        return (BuilderType2) dynamicMethod(e.NEW_BUILDER, null, null);
    }

    public final int d(py3 py3Var) {
        return py3Var == null ? li3.a().c(this).h(this) : py3Var.h(this);
    }

    public abstract Object dynamicMethod(e eVar, Object obj, Object obj2);

    public final void e() {
        if (this.unknownFields == mw4.c()) {
            this.unknownFields = mw4.o();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return li3.a().c(this).f(this, (i91) obj);
        }
        return false;
    }

    @Override // defpackage.ss2
    public final i91 getDefaultInstanceForType() {
        return (i91) dynamicMethod(e.GET_DEFAULT_INSTANCE, null, null);
    }

    public int getMemoizedHashCode() {
        return this.memoizedHashCode;
    }

    public int getMemoizedSerializedSize() {
        return this.memoizedSerializedSize & Integer.MAX_VALUE;
    }

    public final n83 getParserForType() {
        return (n83) dynamicMethod(e.GET_PARSER, null, null);
    }

    @Override // defpackage.p0
    public int getSerializedSize(py3 py3Var) {
        if (isMutable()) {
            int iD = d(py3Var);
            if (iD >= 0) {
                return iD;
            }
            bo1.a("serialized size must be non-negative, was ", iD);
            return 0;
        }
        if (getMemoizedSerializedSize() != Integer.MAX_VALUE) {
            return getMemoizedSerializedSize();
        }
        int iD2 = d(py3Var);
        setMemoizedSerializedSize(iD2);
        return iD2;
    }

    public int hashCode() {
        if (isMutable()) {
            return computeHashCode();
        }
        if (hashCodeIsNotMemoized()) {
            setMemoizedHashCode(computeHashCode());
        }
        return getMemoizedHashCode();
    }

    public boolean hashCodeIsNotMemoized() {
        return getMemoizedHashCode() == 0;
    }

    public final boolean isInitialized() {
        return f(this, true);
    }

    public boolean isMutable() {
        return (this.memoizedSerializedSize & MUTABLE_FLAG_MASK) != 0;
    }

    public void makeImmutable() {
        li3.a().c(this).b(this);
        markImmutable();
    }

    public void markImmutable() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    public void mergeLengthDelimitedField(int i, hn hnVar) {
        e();
        this.unknownFields.l(i, hnVar);
    }

    public final void mergeUnknownFields(mw4 mw4Var) {
        this.unknownFields = mw4.n(this.unknownFields, mw4Var);
    }

    public void mergeVarintField(int i, int i2) {
        e();
        this.unknownFields.m(i, i2);
    }

    @Override // defpackage.rs2
    public final a newBuilderForType() {
        return (a) dynamicMethod(e.NEW_BUILDER, null, null);
    }

    public i91 newMutableInstance() {
        return (i91) dynamicMethod(e.NEW_MUTABLE_INSTANCE, null, null);
    }

    public boolean parseUnknownField(int i, hv hvVar) {
        if (aa5.b(i) == 4) {
            return false;
        }
        e();
        return this.unknownFields.i(i, hvVar);
    }

    public void setMemoizedHashCode(int i) {
        this.memoizedHashCode = i;
    }

    public void setMemoizedSerializedSize(int i) {
        if (i < 0) {
            bo1.a("serialized size must be non-negative, was ", i);
        } else {
            this.memoizedSerializedSize = (i & Integer.MAX_VALUE) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
        }
    }

    @Override // defpackage.rs2
    public final a toBuilder() {
        return ((a) dynamicMethod(e.NEW_BUILDER, null, null)).mergeFrom(this);
    }

    public String toString() {
        return ts2.f(this, super.toString());
    }

    @Override // defpackage.rs2
    public void writeTo(jv jvVar) {
        li3.a().c(this).g(this, kv.P(jvVar));
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class a extends p0.a {
        private final i91 defaultInstance;
        protected i91 instance;

        public a(i91 i91Var) {
            this.defaultInstance = i91Var;
            if (i91Var.isMutable()) {
                jl.a("Default instance must be immutable.");
                throw null;
            }
            this.instance = e();
        }

        public static void d(Object obj, Object obj2) {
            li3.a().c(obj).a(obj, obj2);
        }

        private i91 e() {
            return this.defaultInstance.newMutableInstance();
        }

        /* JADX INFO: renamed from: build, reason: merged with bridge method [inline-methods] */
        public final i91 m3build() {
            i91 i91VarBuildPartial = buildPartial();
            if (i91VarBuildPartial.isInitialized()) {
                return i91VarBuildPartial;
            }
            throw p0.a.newUninitializedMessageException(i91VarBuildPartial);
        }

        @Override // rs2.a
        public i91 buildPartial() {
            boolean zIsMutable = this.instance.isMutable();
            i91 i91Var = this.instance;
            if (!zIsMutable) {
                return i91Var;
            }
            i91Var.makeImmutable();
            return this.instance;
        }

        /* JADX INFO: renamed from: clear, reason: merged with bridge method [inline-methods] */
        public final a m4clear() {
            if (this.defaultInstance.isMutable()) {
                jl.a("Default instance must be immutable.");
                return null;
            }
            this.instance = e();
            return this;
        }

        /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public a m7clone() {
            a aVarNewBuilderForType = getDefaultInstanceForType().newBuilderForType();
            aVarNewBuilderForType.instance = buildPartial();
            return aVarNewBuilderForType;
        }

        public final void copyOnWrite() {
            if (this.instance.isMutable()) {
                return;
            }
            copyOnWriteInternal();
        }

        public void copyOnWriteInternal() {
            i91 i91VarE = e();
            d(i91VarE, this.instance);
            this.instance = i91VarE;
        }

        public final boolean isInitialized() {
            return i91.f(this.instance, false);
        }

        @Override // p0.a
        /* JADX INFO: renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public a m9mergeFrom(byte[] bArr, int i, int i2, xy0 xy0Var) throws ol1 {
            copyOnWrite();
            try {
                li3.a().c(this.instance).e(this.instance, bArr, i, i + i2, new ha.a(xy0Var));
                return this;
            } catch (IndexOutOfBoundsException unused) {
                throw ol1.m();
            } catch (ol1 e) {
                throw e;
            } catch (IOException e2) {
                cx4.a("Reading from byte array should not throw IOException.", e2);
                return null;
            }
        }

        @Override // defpackage.ss2
        public i91 getDefaultInstanceForType() {
            return this.defaultInstance;
        }

        @Override // p0.a
        public a internalMergeFrom(i91 i91Var) {
            return mergeFrom(i91Var);
        }

        public a mergeFrom(i91 i91Var) {
            if (getDefaultInstanceForType().equals(i91Var)) {
                return this;
            }
            copyOnWrite();
            d(this.instance, i91Var);
            return this;
        }

        @Override // p0.a
        /* JADX INFO: renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public a m8mergeFrom(byte[] bArr, int i, int i2) {
            return m9mergeFrom(bArr, i, i2, xy0.b());
        }

        @Override // rs2.a
        public a mergeFrom(hv hvVar, xy0 xy0Var) throws IOException {
            copyOnWrite();
            try {
                li3.a().c(this.instance).d(this.instance, iv.P(hvVar), xy0Var);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }
    }

    public final <MessageType2 extends i91, BuilderType2 extends a> BuilderType2 createBuilder(MessageType2 messagetype2) {
        return (BuilderType2) createBuilder().mergeFrom((i91) messagetype2);
    }

    public static bl1.h mutableCopy(bl1.h hVar) {
        return hVar.a(hVar.size() * 2);
    }

    public static bl1.f mutableCopy(bl1.f fVar) {
        return fVar.a(fVar.size() * 2);
    }

    public static <T extends i91> T parseDelimitedFrom(T t, InputStream inputStream, xy0 xy0Var) {
        return (T) c(g(t, inputStream, xy0Var));
    }

    public static bl1.b mutableCopy(bl1.b bVar) {
        return bVar.a(bVar.size() * 2);
    }

    public static bl1.a mutableCopy(bl1.a aVar) {
        return aVar.a(aVar.size() * 2);
    }

    public static <T extends i91> T parseFrom(T t, ByteBuffer byteBuffer) {
        return (T) parseFrom(t, byteBuffer, xy0.b());
    }

    public static <T extends i91> T parseFrom(T t, hn hnVar) {
        return (T) c(parseFrom(t, hnVar, xy0.b()));
    }

    public static <E> bl1.i mutableCopy(bl1.i iVar) {
        return iVar.a(iVar.size() * 2);
    }

    public static <T extends i91> T parseFrom(T t, hn hnVar, xy0 xy0Var) {
        return (T) c(h(t, hnVar, xy0Var));
    }

    public static <T extends i91> T parseFrom(T t, byte[] bArr) {
        return (T) c(i(t, bArr, 0, bArr.length, xy0.b()));
    }

    public static <T extends i91> T parseFrom(T t, byte[] bArr, xy0 xy0Var) {
        return (T) c(i(t, bArr, 0, bArr.length, xy0Var));
    }

    public static <T extends i91> T parseFrom(T t, ByteBuffer byteBuffer, xy0 xy0Var) {
        return (T) c(parseFrom(t, hv.j(byteBuffer), xy0Var));
    }

    public static <T extends i91> T parseFrom(T t, InputStream inputStream, xy0 xy0Var) {
        return (T) c(parsePartialFrom(t, hv.h(inputStream), xy0Var));
    }

    public static <T extends i91> T parseFrom(T t, hv hvVar) {
        return (T) parseFrom(t, hvVar, xy0.b());
    }

    public static <T extends i91> T parseFrom(T t, hv hvVar, xy0 xy0Var) {
        return (T) c(parsePartialFrom(t, hvVar, xy0Var));
    }

    @Override // defpackage.rs2
    public int getSerializedSize() {
        return getSerializedSize(null);
    }

    public static <T extends i91> T parsePartialFrom(T t, hv hvVar) {
        return (T) parsePartialFrom(t, hvVar, xy0.b());
    }
}
