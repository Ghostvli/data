package defpackage;

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

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C0093a(f30 f30Var, Function1 function1) {
                        super(2, f30Var);
                        this.h = function1;
                    }

                    @Override // defpackage.hh
                    public final f30 create(Object obj, f30 f30Var) {
                        C0093a c0093a = new C0093a(f30Var, this.h);
                        c0093a.g = obj;
                        return c0093a;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(cs4 cs4Var, f30 f30Var) {
                        return ((C0093a) create(cs4Var, f30Var)).invokeSuspend(fw4.a);
                    }

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

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0092a(boolean z, boolean z2, bu3 bu3Var, f30 f30Var, Function1 function1) {
                    super(2, f30Var);
                    this.i = z;
                    this.j = z2;
                    this.k = bu3Var;
                    this.l = function1;
                }

                @Override // defpackage.hh
                public final f30 create(Object obj, f30 f30Var) {
                    C0092a c0092a = new C0092a(this.i, this.j, this.k, f30Var, this.l);
                    c0092a.h = obj;
                    return c0092a;
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
                public final Object invoke(ds4 ds4Var, f30 f30Var) {
                    return ((C0092a) create(ds4Var, f30Var)).invokeSuspend(fw4.a);
                }

                /* JADX WARN: Removed duplicated region for block: B:37:0x00a0 A[PHI: r1 r9
                  0x00a0: PHI (r1v11 ds4) = (r1v8 ds4), (r1v18 ds4) binds: [B:35:0x009d, B:11:0x0022] A[DONT_GENERATE, DONT_INLINE]
                  0x00a0: PHI (r9v14 java.lang.Object) = (r9v13 java.lang.Object), (r9v0 java.lang.Object) binds: [B:35:0x009d, B:11:0x0022] A[DONT_GENERATE, DONT_INLINE]] */
                /* JADX WARN: Removed duplicated region for block: B:39:0x00a4  */
                /* JADX WARN: Removed duplicated region for block: B:45:0x00b9  */
                /* JADX WARN: Removed duplicated region for block: B:47:0x00c3 A[RETURN] */
                @Override // defpackage.hh
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
                    /*
                        Method dump skipped, instruction units count: 212
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: l70.a.C0091a.C0092a.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0091a(bu3 bu3Var, boolean z, boolean z2, Function1 function1, f30 f30Var) {
                super(2, f30Var);
                this.g = bu3Var;
                this.h = z;
                this.i = z2;
                this.j = function1;
            }

            @Override // defpackage.hh
            public final f30 create(Object obj, f30 f30Var) {
                return new C0091a(this.g, this.h, this.i, this.j, f30Var);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(u40 u40Var, f30 f30Var) {
                return ((C0091a) create(u40Var, f30Var)).invokeSuspend(fw4.a);
            }

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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(g40 g40Var, bu3 bu3Var, boolean z, boolean z2, Function1 function1, f30 f30Var) {
            super(2, f30Var);
            this.g = g40Var;
            this.h = bu3Var;
            this.i = z;
            this.j = z2;
            this.k = function1;
        }

        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            return new a(this.g, this.h, this.i, this.j, this.k, f30Var);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(u40 u40Var, f30 f30Var) {
            return ((a) create(u40Var, f30Var)).invokeSuspend(fw4.a);
        }

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
