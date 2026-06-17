package defpackage;

import androidx.room.c;
import defpackage.ds4;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class l70 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends oj4 implements Function2 {
        public int f;
        public final /* synthetic */ g40 g;
        public final /* synthetic */ bu3 h;
        public final /* synthetic */ boolean i;
        public final /* synthetic */ boolean j;
        public final /* synthetic */ Function1 k;

        /* JADX INFO: renamed from: l70$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class C0091a extends oj4 implements Function2 {
            public int f;
            public final /* synthetic */ bu3 g;
            public final /* synthetic */ boolean h;
            public final /* synthetic */ boolean i;
            public final /* synthetic */ Function1 j;

            /* JADX INFO: renamed from: l70$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static final class C0092a extends oj4 implements Function2 {
                public Object f;
                public int g;
                public /* synthetic */ Object h;
                public final /* synthetic */ boolean i;
                public final /* synthetic */ boolean j;
                public final /* synthetic */ bu3 k;
                public final /* synthetic */ Function1 l;

                /* JADX INFO: renamed from: l70$a$a$a$a, reason: collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
                public static final class C0093a extends oj4 implements Function2 {
                    public int f;
                    public /* synthetic */ Object g;
                    public final /* synthetic */ Function1 h;

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C0093a(f30 f30Var, Function1 function1) {
                        super(2, f30Var);
                        this.h = function1;
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // defpackage.hh
                    public final f30 create(Object obj, f30 f30Var) {
                        C0093a c0093a = new C0093a(f30Var, this.h);
                        c0093a.g = obj;
                        return c0093a;
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
                    @Override // kotlin.jvm.functions.Function2
                    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(cs4 cs4Var, f30 f30Var) {
                        return ((C0093a) create(cs4Var, f30Var)).invokeSuspend(fw4.a);
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // defpackage.hh
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        kl1.e();
                        if (this.f != 0) {
                            e04.a("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        lt3.b(obj);
                        cs4 cs4Var = (cs4) this.g;
                        cs4Var.getClass();
                        return this.h.invoke(((ao3) cs4Var).d());
                    }
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0092a(boolean z, boolean z2, bu3 bu3Var, f30 f30Var, Function1 function1) {
                    super(2, f30Var);
                    this.i = z;
                    this.j = z2;
                    this.k = bu3Var;
                    this.l = function1;
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.hh
                public final f30 create(Object obj, f30 f30Var) {
                    C0092a c0092a = new C0092a(this.i, this.j, this.k, f30Var, this.l);
                    c0092a.h = obj;
                    return c0092a;
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
                public final Object invoke(ds4 ds4Var, f30 f30Var) {
                    return ((C0092a) create(ds4Var, f30Var)).invokeSuspend(fw4.a);
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                /* JADX WARN: Removed duplicated region for block: B:37:0x00a0 A[PHI: r1 r9
                  0x00a0: PHI (r1v11 ds4) = (r1v8 ds4), (r1v18 ds4) binds: [B:35:0x009d, B:11:0x0022] A[DONT_GENERATE, DONT_INLINE]
                  0x00a0: PHI (r9v14 java.lang.Object) = (r9v13 java.lang.Object), (r9v0 java.lang.Object) binds: [B:35:0x009d, B:11:0x0022] A[DONT_GENERATE, DONT_INLINE]] */
                /* JADX WARN: Removed duplicated region for block: B:39:0x00a4  */
                /* JADX WARN: Removed duplicated region for block: B:45:0x00b9  */
                /* JADX WARN: Removed duplicated region for block: B:47:0x00c3 A[RETURN] */
                @Override // defpackage.hh
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object invokeSuspend(Object obj) throws Throwable {
                    ds4.a aVar;
                    ds4 ds4Var;
                    ds4 ds4Var2;
                    ds4.a aVar2;
                    ds4 ds4Var3;
                    Object obj2;
                    Object objE = kl1.e();
                    int i = this.g;
                    if (i == 0) {
                        lt3.b(obj);
                        ds4 ds4Var4 = (ds4) this.h;
                        if (!this.i) {
                            ds4Var4.getClass();
                            return this.l.invoke(((ao3) ds4Var4).d());
                        }
                        boolean z = this.j;
                        aVar = z ? ds4.a.f : ds4.a.g;
                        if (z) {
                            ds4Var = ds4Var4;
                            C0093a c0093a = new C0093a(null, this.l);
                            this.h = ds4Var;
                            this.f = null;
                            this.g = 3;
                            obj = ds4Var.b(aVar, c0093a, this);
                            if (obj != objE) {
                            }
                            return objE;
                        }
                        this.h = ds4Var4;
                        this.f = aVar;
                        this.g = 1;
                        Object objC = ds4Var4.c(this);
                        if (objC != objE) {
                            ds4Var2 = ds4Var4;
                            obj = objC;
                            aVar2 = aVar;
                        }
                        return objE;
                    }
                    if (i != 1) {
                        if (i == 2) {
                            aVar2 = (ds4.a) this.f;
                            ds4Var3 = (ds4) this.h;
                            lt3.b(obj);
                            aVar = aVar2;
                            ds4Var = ds4Var3;
                            C0093a c0093a2 = new C0093a(null, this.l);
                            this.h = ds4Var;
                            this.f = null;
                            this.g = 3;
                            obj = ds4Var.b(aVar, c0093a2, this);
                            if (obj != objE) {
                                if (!this.j) {
                                }
                            }
                            return objE;
                        }
                        if (i != 3) {
                            if (i != 4) {
                                e04.a("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            obj2 = this.h;
                            lt3.b(obj);
                            if (!((Boolean) obj).booleanValue()) {
                                this.k.p().q();
                            }
                            return obj2;
                        }
                        ds4Var = (ds4) this.h;
                        lt3.b(obj);
                        if (!this.j) {
                            return obj;
                        }
                        this.h = obj;
                        this.g = 4;
                        Object objC2 = ds4Var.c(this);
                        if (objC2 != objE) {
                            obj2 = obj;
                            obj = objC2;
                            if (!((Boolean) obj).booleanValue()) {
                            }
                            return obj2;
                        }
                        return objE;
                    }
                    aVar2 = (ds4.a) this.f;
                    ds4Var2 = (ds4) this.h;
                    lt3.b(obj);
                    if (((Boolean) obj).booleanValue()) {
                        aVar = aVar2;
                        ds4Var = ds4Var2;
                        C0093a c0093a22 = new C0093a(null, this.l);
                        this.h = ds4Var;
                        this.f = null;
                        this.g = 3;
                        obj = ds4Var.b(aVar, c0093a22, this);
                        if (obj != objE) {
                        }
                        return objE;
                    }
                    c cVarP = this.k.p();
                    this.h = ds4Var2;
                    this.f = aVar2;
                    this.g = 2;
                    if (cVarP.v(this) != objE) {
                        ds4Var3 = ds4Var2;
                        aVar = aVar2;
                        ds4Var = ds4Var3;
                        C0093a c0093a222 = new C0093a(null, this.l);
                        this.h = ds4Var;
                        this.f = null;
                        this.g = 3;
                        obj = ds4Var.b(aVar, c0093a222, this);
                        if (obj != objE) {
                        }
                    }
                    return objE;
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0091a(bu3 bu3Var, boolean z, boolean z2, Function1 function1, f30 f30Var) {
                super(2, f30Var);
                this.g = bu3Var;
                this.h = z;
                this.i = z2;
                this.j = function1;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.hh
            public final f30 create(Object obj, f30 f30Var) {
                return new C0091a(this.g, this.h, this.i, this.j, f30Var);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(u40 u40Var, f30 f30Var) {
                return ((C0091a) create(u40Var, f30Var)).invokeSuspend(fw4.a);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.hh
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objE = kl1.e();
                int i = this.f;
                if (i != 0) {
                    if (i == 1) {
                        lt3.b(obj);
                        return obj;
                    }
                    e04.a("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                lt3.b(obj);
                boolean z = !(this.g.z() && this.g.A()) && this.h;
                bu3 bu3Var = this.g;
                boolean z2 = this.i;
                C0092a c0092a = new C0092a(z, z2, bu3Var, null, this.j);
                this.f = 1;
                Object objI = bu3Var.I(z2, c0092a, this);
                return objI == objE ? objE : objI;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(g40 g40Var, bu3 bu3Var, boolean z, boolean z2, Function1 function1, f30 f30Var) {
            super(2, f30Var);
            this.g = g40Var;
            this.h = bu3Var;
            this.i = z;
            this.j = z2;
            this.k = function1;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            return new a(this.g, this.h, this.i, this.j, this.k, f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(u40 u40Var, f30 f30Var) {
            return ((a) create(u40Var, f30Var)).invokeSuspend(fw4.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kl1.e();
            int i = this.f;
            if (i != 0) {
                if (i == 1) {
                    lt3.b(obj);
                    return obj;
                }
                e04.a("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            lt3.b(obj);
            g40 g40Var = this.g;
            C0091a c0091a = new C0091a(this.h, this.i, this.j, this.k, null);
            this.f = 1;
            Object objE2 = bm.e(g40Var, c0091a, this);
            return objE2 == objE ? objE : objE2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final Object a(bu3 bu3Var, boolean z, boolean z2, Function1 function1) {
        bu3Var.getClass();
        function1.getClass();
        bu3Var.e();
        bu3Var.f();
        g40 g40Var = (g40) bu3Var.w().get();
        if (g40Var == null) {
            g40Var = bs0.f;
        }
        return cw3.a(new a(g40Var, bu3Var, z2, z, function1, null));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static final int b(File file) throws IllegalAccessException, IOException, InvocationTargetException {
        file.getClass();
        FileChannel channel = new FileInputStream(file).getChannel();
        try {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            channel.tryLock(60L, 4L, true);
            channel.position(60L);
            if (channel.read(byteBufferAllocate) != 4) {
                throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
            }
            byteBufferAllocate.rewind();
            int i = byteBufferAllocate.getInt();
            bv.a(channel, null);
            return i;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                bv.a(channel, th);
                throw th2;
            }
        }
    }
}
