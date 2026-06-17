package defpackage;

import android.database.SQLException;
import defpackage.ds4;
import defpackage.v43;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class mt4 {
    public static final a l = new a(null);
    public static final String[] m = {"INSERT", "UPDATE", "DELETE"};
    public final bu3 a;
    public final Map b;
    public final Map c;
    public final boolean d;
    public final Function1 e;
    public final Map f;
    public final String[] g;
    public final v43 h;
    public final w43 i;
    public final AtomicBoolean j;
    public Function0 k;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends g30 {
        public Object f;
        public /* synthetic */ Object g;
        public int i;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(f30 f30Var) {
            super(f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= Integer.MIN_VALUE;
            return mt4.this.h(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends g30 {
        public Object f;
        public /* synthetic */ Object g;
        public int i;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(f30 f30Var) {
            super(f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= Integer.MIN_VALUE;
            return mt4.this.j(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d extends oj4 implements Function2 {
        public int f;
        public /* synthetic */ Object g;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class a extends oj4 implements Function2 {
            public int f;
            public /* synthetic */ Object g;
            public final /* synthetic */ mt4 h;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(mt4 mt4Var, f30 f30Var) {
                super(2, f30Var);
                this.h = mt4Var;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.hh
            public final f30 create(Object obj, f30 f30Var) {
                a aVar = new a(this.h, f30Var);
                aVar.g = obj;
                return aVar;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public final Object invoke(cs4 cs4Var, f30 f30Var) {
                return ((a) create(cs4Var, f30Var)).invokeSuspend(fw4.a);
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
                cs4 cs4Var = (cs4) this.g;
                mt4 mt4Var = this.h;
                this.f = 1;
                Object objH = mt4Var.h(cs4Var, this);
                return objH == objE ? objE : objH;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(f30 f30Var) {
            super(2, f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            d dVar = mt4.this.new d(f30Var);
            dVar.g = obj;
            return dVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(ds4 ds4Var, f30 f30Var) {
            return ((d) create(ds4Var, f30Var)).invokeSuspend(fw4.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0052, code lost:
        
            if (r7 == r0) goto L20;
         */
        @Override // defpackage.hh
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            ds4 ds4Var;
            Object objE = kl1.e();
            int i = this.f;
            try {
                if (i == 0) {
                    lt3.b(obj);
                    ds4Var = (ds4) this.g;
                    this.g = ds4Var;
                    this.f = 1;
                    obj = ds4Var.c(this);
                    if (obj != objE) {
                    }
                    return objE;
                }
                if (i != 1) {
                    if (i == 2) {
                        lt3.b(obj);
                        return (Set) obj;
                    }
                    e04.a("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ds4Var = (ds4) this.g;
                lt3.b(obj);
                if (((Boolean) obj).booleanValue()) {
                    return o24.d();
                }
                ds4.a aVar = ds4.a.g;
                a aVar2 = new a(mt4.this, null);
                this.g = null;
                this.f = 2;
                obj = ds4Var.b(aVar, aVar2, this);
            } catch (SQLException unused) {
                return o24.d();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e extends oj4 implements Function2 {
        public int f;
        public final /* synthetic */ Function0 h;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Function0 function0, f30 f30Var) {
            super(2, f30Var);
            this.h = function0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            return mt4.this.new e(this.h, f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(u40 u40Var, f30 f30Var) {
            return ((e) create(u40Var, f30Var)).invokeSuspend(fw4.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kl1.e();
            int i = this.f;
            try {
                if (i == 0) {
                    lt3.b(obj);
                    mt4 mt4Var = mt4.this;
                    this.f = 1;
                    obj = mt4Var.j(this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        e04.a("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    lt3.b(obj);
                }
                this.h.invoke();
                return fw4.a;
            } catch (Throwable th) {
                this.h.invoke();
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class f extends g30 {
        public Object f;
        public Object g;
        public Object h;
        public int i;
        public int j;
        public int k;
        public /* synthetic */ Object l;
        public int n;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public f(f30 f30Var) {
            super(f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.l = obj;
            this.n |= Integer.MIN_VALUE;
            return mt4.this.q(null, 0, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class g extends g30 {
        public Object f;
        public Object g;
        public Object h;
        public int i;
        public int j;
        public /* synthetic */ Object k;
        public int m;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public g(f30 f30Var) {
            super(f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.k = obj;
            this.m |= Integer.MIN_VALUE;
            return mt4.this.r(null, 0, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class h extends g30 {
        public Object f;
        public /* synthetic */ Object g;
        public int i;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public h(f30 f30Var) {
            super(f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= Integer.MIN_VALUE;
            return mt4.this.s(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class i extends oj4 implements Function2 {
        public Object f;
        public int g;
        public /* synthetic */ Object h;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class a extends oj4 implements Function2 {
            public Object f;
            public Object g;
            public Object h;
            public int i;
            public int j;
            public int k;
            public int l;
            public final /* synthetic */ v43.a[] m;
            public final /* synthetic */ mt4 n;
            public final /* synthetic */ ds4 o;

            /* JADX INFO: renamed from: mt4$i$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static final /* synthetic */ class C0102a {
                public static final /* synthetic */ int[] a;

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                static {
                    int[] iArr = new int[v43.a.values().length];
                    try {
                        iArr[v43.a.f.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[v43.a.g.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[v43.a.h.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    a = iArr;
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(v43.a[] aVarArr, mt4 mt4Var, ds4 ds4Var, f30 f30Var) {
                super(2, f30Var);
                this.m = aVarArr;
                this.n = mt4Var;
                this.o = ds4Var;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.hh
            public final f30 create(Object obj, f30 f30Var) {
                return new a(this.m, this.n, this.o, f30Var);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public final Object invoke(cs4 cs4Var, f30 f30Var) {
                return ((a) create(cs4Var, f30Var)).invokeSuspend(fw4.a);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Duplicate block (B:19:0x0065) to fix multi-entry loop: BACK_EDGE: B:19:0x0065 -> B:20:0x0067 */
            /* JADX WARN: Code restructure failed: missing block: B:24:0x0082, code lost:
            
                if (r7.q(r12, r6, r11) == r0) goto L25;
             */
            /* JADX WARN: Code restructure failed: missing block: B:30:0x0067, code lost:
            
                r6 = r12;
                r5 = r9;
             */
            /* JADX WARN: Removed duplicated region for block: B:11:0x003d  */
            /* JADX WARN: Removed duplicated region for block: B:28:0x0088  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0085 -> B:27:0x0086). Please report as a decompilation issue!!! */
            @Override // defpackage.hh
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) throws Throwable {
                int i;
                v43.a[] aVarArr;
                mt4 mt4Var;
                ds4 ds4Var;
                int i2;
                int i3;
                Object objE = kl1.e();
                int i4 = this.l;
                if (i4 == 0) {
                    lt3.b(obj);
                    v43.a[] aVarArr2 = this.m;
                    mt4 mt4Var2 = this.n;
                    ds4 ds4Var2 = this.o;
                    int length = aVarArr2.length;
                    i = 0;
                    aVarArr = aVarArr2;
                    mt4Var = mt4Var2;
                    ds4Var = ds4Var2;
                    i2 = length;
                    i3 = 0;
                    if (i3 >= i2) {
                    }
                } else {
                    if (i4 != 1 && i4 != 2) {
                        e04.a("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    i2 = this.k;
                    i3 = this.j;
                    int i5 = this.i;
                    ds4 ds4Var3 = (ds4) this.h;
                    mt4Var = (mt4) this.g;
                    aVarArr = (v43.a[]) this.f;
                    lt3.b(obj);
                    ds4Var = ds4Var3;
                    i = i5;
                    i3++;
                    if (i3 >= i2) {
                        int i6 = i + 1;
                        int i7 = C0102a.a[aVarArr[i3].ordinal()];
                        if (i7 == 1) {
                            i = i6;
                            i3++;
                            if (i3 >= i2) {
                                return fw4.a;
                            }
                        } else {
                            if (i7 != 2) {
                                if (i7 != 3) {
                                    throw new j33();
                                }
                                this.f = aVarArr;
                                this.g = mt4Var;
                                this.h = ds4Var;
                                this.i = i6;
                                this.j = i3;
                                this.k = i2;
                                this.l = 2;
                                if (mt4Var.r(ds4Var, i, this) != objE) {
                                    ds4Var3 = ds4Var;
                                    i5 = i6;
                                    ds4Var = ds4Var3;
                                    i = i5;
                                }
                                return objE;
                            }
                            this.f = aVarArr;
                            this.g = mt4Var;
                            this.h = ds4Var;
                            this.i = i6;
                            this.j = i3;
                            this.k = i2;
                            this.l = 1;
                            i3++;
                            if (i3 >= i2) {
                            }
                        }
                    }
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public i(f30 f30Var) {
            super(2, f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            i iVar = mt4.this.new i(f30Var);
            iVar.h = obj;
            return iVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(ds4 ds4Var, f30 f30Var) {
            return ((i) create(ds4Var, f30Var)).invokeSuspend(fw4.a);
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[GOTO]}, finally: {[GOTO, INVOKE] complete} */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: Removed duplicated region for block: B:74:0x00b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // defpackage.hh
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            ds4 ds4Var;
            Object objC;
            v43 v43Var;
            ReentrantLock reentrantLock;
            v43.a[] aVarArr;
            v43.a aVar;
            v43 v43Var2;
            ReentrantLock reentrantLock2;
            Object objE = kl1.e();
            int i = this.g;
            boolean z = true;
            if (i == 0) {
                lt3.b(obj);
                ds4Var = (ds4) this.h;
                this.h = ds4Var;
                this.g = 1;
                objC = ds4Var.c(this);
                if (objC != objE) {
                }
                return objE;
            }
            if (i != 1) {
                if (i != 2) {
                    e04.a("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                reentrantLock2 = (ReentrantLock) this.f;
                v43Var2 = (v43) this.h;
                try {
                    lt3.b(obj);
                    reentrantLock = reentrantLock2;
                    v43Var = v43Var2;
                    v43Var.f = false;
                    fw4 fw4Var = fw4.a;
                    reentrantLock.unlock();
                    return fw4.a;
                } catch (Throwable th) {
                    th = th;
                    try {
                        v43Var2.f = false;
                        throw th;
                    } catch (Throwable th2) {
                        th = th2;
                        reentrantLock = reentrantLock2;
                        reentrantLock.unlock();
                        throw th;
                    }
                }
            }
            ds4Var = (ds4) this.h;
            lt3.b(obj);
            objC = obj;
            if (((Boolean) objC).booleanValue()) {
                return fw4.a;
            }
            v43Var = mt4.this.h;
            mt4 mt4Var = mt4.this;
            reentrantLock = v43Var.e;
            reentrantLock.lock();
            try {
                v43Var.f = true;
                ReentrantLock reentrantLock3 = v43Var.a;
                reentrantLock3.lock();
                try {
                    if (v43Var.d) {
                        v43Var.d = false;
                        int length = v43Var.b.length;
                        aVarArr = new v43.a[length];
                        int i2 = 0;
                        boolean z2 = false;
                        while (i2 < length) {
                            boolean z3 = v43Var.b[i2] > 0 ? z : false;
                            if (z3 != v43Var.c[i2]) {
                                v43Var.c[i2] = z3;
                                aVar = z3 ? v43.a.g : v43.a.h;
                                z2 = true;
                            } else {
                                aVar = v43.a.f;
                            }
                            aVarArr[i2] = aVar;
                            i2++;
                            z = true;
                        }
                        if (!z2) {
                        }
                        if (aVarArr != null) {
                            try {
                                if (aVarArr.length != 0) {
                                    ds4.a aVar2 = ds4.a.g;
                                    a aVar3 = new a(aVarArr, mt4Var, ds4Var, null);
                                    this.h = v43Var;
                                    this.f = reentrantLock;
                                    this.g = 2;
                                    if (ds4Var.b(aVar2, aVar3, this) != objE) {
                                        v43Var2 = v43Var;
                                        reentrantLock2 = reentrantLock;
                                        reentrantLock = reentrantLock2;
                                        v43Var = v43Var2;
                                    }
                                    return objE;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                v43Var2 = v43Var;
                                reentrantLock2 = reentrantLock;
                                v43Var2.f = false;
                                throw th;
                            }
                        }
                        v43Var.f = false;
                        fw4 fw4Var2 = fw4.a;
                        reentrantLock.unlock();
                        return fw4.a;
                    }
                    aVarArr = null;
                    if (aVarArr != null) {
                    }
                    v43Var.f = false;
                    fw4 fw4Var22 = fw4.a;
                    reentrantLock.unlock();
                    return fw4.a;
                } finally {
                    reentrantLock3.unlock();
                }
            } catch (Throwable th4) {
                th = th4;
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public mt4(bu3 bu3Var, Map map, Map map2, String[] strArr, boolean z, Function1 function1) {
        String lowerCase;
        bu3Var.getClass();
        map.getClass();
        map2.getClass();
        strArr.getClass();
        function1.getClass();
        this.a = bu3Var;
        this.b = map;
        this.c = map2;
        this.d = z;
        this.e = function1;
        this.j = new AtomicBoolean(false);
        this.k = new Function0() { // from class: lt4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(mt4.b());
            }
        };
        this.f = new LinkedHashMap();
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            String str = strArr[i2];
            Locale locale = Locale.ROOT;
            String lowerCase2 = str.toLowerCase(locale);
            lowerCase2.getClass();
            this.f.put(lowerCase2, Integer.valueOf(i2));
            String str2 = (String) this.b.get(strArr[i2]);
            if (str2 != null) {
                lowerCase = str2.toLowerCase(locale);
                lowerCase.getClass();
            } else {
                lowerCase = null;
            }
            if (lowerCase != null) {
                lowerCase2 = lowerCase;
            }
            strArr2[i2] = lowerCase2;
        }
        this.g = strArr2;
        for (Map.Entry entry : this.b.entrySet()) {
            String str3 = (String) entry.getValue();
            Locale locale2 = Locale.ROOT;
            String lowerCase3 = str3.toLowerCase(locale2);
            lowerCase3.getClass();
            if (this.f.containsKey(lowerCase3)) {
                String lowerCase4 = ((String) entry.getKey()).toLowerCase(locale2);
                lowerCase4.getClass();
                Map map3 = this.f;
                map3.put(lowerCase4, y42.i(map3, lowerCase3));
            }
        }
        this.h = new v43(this.g.length);
        this.i = new w43(this.g.length);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Set a(ow3 ow3Var) {
        ow3Var.getClass();
        Set setB = n24.b();
        while (ow3Var.Y()) {
            setB.add(Integer.valueOf((int) ow3Var.getLong(0)));
        }
        return n24.a(setB);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean b() {
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(pf3 pf3Var, f30 f30Var) throws Throwable {
        b bVar;
        if (f30Var instanceof b) {
            bVar = (b) f30Var;
            int i2 = bVar.i;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                bVar.i = i2 - Integer.MIN_VALUE;
            } else {
                bVar = new b(f30Var);
            }
        }
        Object objA = bVar.g;
        Object objE = kl1.e();
        int i3 = bVar.i;
        if (i3 == 0) {
            lt3.b(objA);
            Function1 function1 = new Function1() { // from class: kt4
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return mt4.a((ow3) obj);
                }
            };
            bVar.f = pf3Var;
            bVar.i = 1;
            objA = pf3Var.a("SELECT * FROM room_table_modification_log WHERE invalidated = 1", function1, bVar);
            if (objA != objE) {
            }
            return objE;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                e04.a("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            Set set = (Set) bVar.f;
            lt3.b(objA);
            return set;
        }
        pf3Var = (pf3) bVar.f;
        lt3.b(objA);
        Set set2 = (Set) objA;
        if (!set2.isEmpty()) {
            bVar.f = set2;
            bVar.i = 2;
            if (fs4.b(pf3Var, "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1", bVar) == objE) {
                return objE;
            }
        }
        return set2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final void i(lw3 lw3Var) throws Exception {
        lw3Var.getClass();
        ow3 ow3VarA0 = lw3Var.a0("PRAGMA query_only");
        try {
            ow3VarA0.Y();
            boolean zS = ow3VarA0.s(0);
            ne.a(ow3VarA0, null);
            if (zS) {
                return;
            }
            kw3.a(lw3Var, "PRAGMA temp_store = MEMORY");
            kw3.a(lw3Var, "PRAGMA recursive_triggers = 1");
            kw3.a(lw3Var, "DROP TABLE IF EXISTS room_table_modification_log");
            if (this.d) {
                kw3.a(lw3Var, "CREATE TEMP TABLE IF NOT EXISTS room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            } else {
                kw3.a(lw3Var, sg4.G("CREATE TEMP TABLE IF NOT EXISTS room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)", "TEMP", "", false, 4, null));
            }
            this.h.h();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                ne.a(ow3VarA0, th);
                throw th2;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object j(f30 f30Var) throws Throwable {
        c cVar;
        av avVar;
        if (f30Var instanceof c) {
            cVar = (c) f30Var;
            int i2 = cVar.i;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                cVar.i = i2 - Integer.MIN_VALUE;
            } else {
                cVar = new c(f30Var);
            }
        }
        Object obj = cVar.g;
        Object objE = kl1.e();
        int i3 = cVar.i;
        if (i3 == 0) {
            lt3.b(obj);
            av avVarN = this.a.n();
            if (!avVarN.a()) {
                return o24.d();
            }
            try {
                if (!this.j.compareAndSet(true, false)) {
                    Set setD = o24.d();
                    avVarN.c();
                    return setD;
                }
                if (!((Boolean) this.k.invoke()).booleanValue()) {
                    Set setD2 = o24.d();
                    avVarN.c();
                    return setD2;
                }
                bu3 bu3Var = this.a;
                d dVar = new d(null);
                cVar.f = avVarN;
                cVar.i = 1;
                Object objI = bu3Var.I(false, dVar, cVar);
                if (objI == objE) {
                    return objE;
                }
                avVar = avVarN;
                obj = objI;
            } catch (Throwable th) {
                th = th;
                avVar = avVarN;
                avVar.c();
                throw th;
            }
        } else {
            if (i3 != 1) {
                e04.a("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            avVar = (av) cVar.f;
            try {
                lt3.b(obj);
            } catch (Throwable th2) {
                th = th2;
                avVar.c();
                throw th;
            }
        }
        Set set = (Set) obj;
        if (!set.isEmpty()) {
            this.i.a(set);
            this.e.invoke(set);
        }
        avVar.c();
        return set;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean k(int[] iArr) {
        iArr.getClass();
        return this.h.i(iArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean l(int[] iArr) {
        iArr.getClass();
        return this.h.j(iArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void m(Function0 function0, Function0 function02) {
        function0.getClass();
        function02.getClass();
        if (this.j.compareAndSet(false, true)) {
            function0.invoke();
            dm.b(this.a.o(), new s40("Room Invalidation Tracker Refresh"), null, new e(function02, null), 2, null);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void n() {
        this.h.k();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String[] o(String[] strArr) {
        Set setB = n24.b();
        for (String str : strArr) {
            Map map = this.c;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            Set set = (Set) map.get(lowerCase);
            if (set != null) {
                setB.addAll(set);
            } else {
                setB.add(str);
            }
        }
        return (String[]) n24.a(setB).toArray(new String[0]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void p(Function0 function0) {
        function0.getClass();
        this.k = function0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0070, code lost:
    
        if (defpackage.fs4.b(r13, r15, r0) == r1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00d9, code lost:
    
        if (defpackage.fs4.b(r7, r15, r0) == r1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00db, code lost:
    
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00d9 -> B:28:0x00dc). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object q(pf3 pf3Var, int i2, f30 f30Var) throws Throwable {
        f fVar;
        pf3 pf3Var2;
        int length;
        String[] strArr;
        int i3;
        int i4;
        String str;
        if (f30Var instanceof f) {
            fVar = (f) f30Var;
            int i5 = fVar.n;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                fVar.n = i5 - Integer.MIN_VALUE;
            } else {
                fVar = new f(f30Var);
            }
        }
        Object obj = fVar.l;
        Object objE = kl1.e();
        int i6 = fVar.n;
        if (i6 == 0) {
            lt3.b(obj);
            String str2 = "INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i2 + ", 0)";
            fVar.f = pf3Var;
            fVar.i = i2;
            fVar.n = 1;
        } else if (i6 == 1) {
            i2 = fVar.i;
            pf3Var = (pf3) fVar.f;
            lt3.b(obj);
        } else {
            if (i6 != 2) {
                e04.a("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            length = fVar.k;
            i4 = fVar.j;
            i3 = fVar.i;
            strArr = (String[]) fVar.h;
            str = (String) fVar.g;
            pf3Var2 = (pf3) fVar.f;
            lt3.b(obj);
            i4++;
            if (i4 < length) {
                return fw4.a;
            }
            String str3 = strArr[i4];
            String str4 = this.d ? "TEMP" : "";
            String str5 = "CREATE " + str4 + " TRIGGER IF NOT EXISTS `" + l.b(str, str3) + "` AFTER " + str3 + " ON `" + str + "` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = " + i3 + " AND invalidated = 0; END";
            fVar.f = pf3Var2;
            fVar.g = str;
            fVar.h = strArr;
            fVar.i = i3;
            fVar.j = i4;
            fVar.k = length;
            fVar.n = 2;
        }
        String str6 = this.g[i2];
        String[] strArr2 = m;
        pf3Var2 = pf3Var;
        length = strArr2.length;
        strArr = strArr2;
        i3 = i2;
        i4 = 0;
        str = str6;
        if (i4 < length) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0080 -> B:19:0x0083). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object r(pf3 pf3Var, int i2, f30 f30Var) throws Throwable {
        g gVar;
        String str;
        int length;
        String[] strArr;
        pf3 pf3Var2;
        int i3;
        if (f30Var instanceof g) {
            gVar = (g) f30Var;
            int i4 = gVar.m;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                gVar.m = i4 - Integer.MIN_VALUE;
            } else {
                gVar = new g(f30Var);
            }
        }
        Object obj = gVar.k;
        Object objE = kl1.e();
        int i5 = gVar.m;
        if (i5 == 0) {
            lt3.b(obj);
            String str2 = this.g[i2];
            String[] strArr2 = m;
            str = str2;
            length = strArr2.length;
            strArr = strArr2;
            pf3Var2 = pf3Var;
            i3 = 0;
            if (i3 < length) {
            }
        } else {
            if (i5 != 1) {
                e04.a("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            length = gVar.j;
            i3 = gVar.i;
            String[] strArr3 = (String[]) gVar.h;
            str = (String) gVar.g;
            pf3 pf3Var3 = (pf3) gVar.f;
            lt3.b(obj);
            strArr = strArr3;
            pf3Var2 = pf3Var3;
            i3++;
            if (i3 < length) {
                String str3 = "DROP TRIGGER IF EXISTS `" + l.b(str, strArr[i3]) + '`';
                gVar.f = pf3Var2;
                gVar.g = str;
                gVar.h = strArr;
                gVar.i = i3;
                gVar.j = length;
                gVar.m = 1;
                if (fs4.b(pf3Var2, str3, gVar) == objE) {
                    return objE;
                }
                i3++;
                if (i3 < length) {
                    return fw4.a;
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object s(f30 f30Var) throws Throwable {
        h hVar;
        Throwable th;
        av avVar;
        if (f30Var instanceof h) {
            hVar = (h) f30Var;
            int i2 = hVar.i;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                hVar.i = i2 - Integer.MIN_VALUE;
            } else {
                hVar = new h(f30Var);
            }
        }
        Object obj = hVar.g;
        Object objE = kl1.e();
        int i3 = hVar.i;
        if (i3 == 0) {
            lt3.b(obj);
            av avVarN = this.a.n();
            if (avVarN.a()) {
                try {
                    bu3 bu3Var = this.a;
                    i iVar = new i(null);
                    hVar.f = avVarN;
                    hVar.i = 1;
                    if (bu3Var.I(false, iVar, hVar) == objE) {
                        return objE;
                    }
                    avVar = avVarN;
                    avVar.c();
                } catch (Throwable th2) {
                    th = th2;
                    avVar = avVarN;
                    avVar.c();
                    throw th;
                }
            }
        } else {
            if (i3 != 1) {
                e04.a("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            avVar = (av) hVar.f;
            try {
                lt3.b(obj);
                avVar.c();
            } catch (Throwable th3) {
                th = th3;
                avVar.c();
                throw th;
            }
        }
        return fw4.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final i73 t(String[] strArr) {
        strArr.getClass();
        String[] strArrO = o(strArr);
        int length = strArrO.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            String str = strArrO[i2];
            Map map = this.f;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            Integer num = (Integer) map.get(lowerCase);
            if (num == null) {
                jl.a("There is no table with name ".concat(str));
                return null;
            }
            iArr[i2] = num.intValue();
        }
        return fu4.a(strArrO, iArr);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: mt4.a.<init>():void type: THIS */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public /* synthetic */ a(we0 we0Var) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final String b(String str, String str2) {
            return "room_table_modification_trigger_" + str + '_' + str2;
        }

        public a() {
        }
    }
}
