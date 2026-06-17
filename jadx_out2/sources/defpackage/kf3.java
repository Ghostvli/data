package defpackage;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class kf3 {
    public final int a;
    public final Function0 b;
    public final int c;
    public final ReentrantLock d;
    public int e;
    public boolean f;
    public final c10[] g;
    public final n04 h;
    public final ia i;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends g30 {
        public /* synthetic */ Object f;
        public int h;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(f30 f30Var) {
            super(f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= Integer.MIN_VALUE;
            return kf3.this.a(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends g30 {
        public long f;
        public Object g;
        public Object h;
        public /* synthetic */ Object i;
        public int k;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(f30 f30Var) {
            super(f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.i = obj;
            this.k |= Integer.MIN_VALUE;
            return kf3.this.b(0L, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends oj4 implements Function2 {
        public Object f;
        public int g;
        public final /* synthetic */ mp3 h;
        public final /* synthetic */ kf3 i;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(mp3 mp3Var, kf3 kf3Var, f30 f30Var) {
            super(2, f30Var);
            this.h = mp3Var;
            this.i = kf3Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            return new c(this.h, this.i, f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(u40 u40Var, f30 f30Var) {
            return ((c) create(u40Var, f30Var)).invokeSuspend(fw4.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) throws Throwable {
            mp3 mp3Var;
            Object objE = kl1.e();
            int i = this.g;
            if (i == 0) {
                lt3.b(obj);
                mp3 mp3Var2 = this.h;
                kf3 kf3Var = this.i;
                this.f = mp3Var2;
                this.g = 1;
                Object objA = kf3Var.a(this);
                if (objA == objE) {
                    return objE;
                }
                obj = objA;
                mp3Var = mp3Var2;
            } else {
                if (i != 1) {
                    e04.a("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                mp3Var = (mp3) this.f;
                lt3.b(obj);
            }
            mp3Var.f = obj;
            return fw4.a;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public kf3(int i, Function0 function0, int i2) {
        function0.getClass();
        this.a = i;
        this.b = function0;
        this.c = i2;
        this.d = new ReentrantLock();
        this.g = new c10[i];
        this.h = r04.b(i, 0, 2, null);
        this.i = new ia(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(f30 f30Var) throws Throwable {
        a aVar;
        if (f30Var instanceof a) {
            aVar = (a) f30Var;
            int i = aVar.h;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.h = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(f30Var);
            }
        }
        Object obj = aVar.f;
        Object objE = kl1.e();
        int i2 = aVar.h;
        if (i2 == 0) {
            lt3.b(obj);
            n04 n04Var = this.h;
            aVar.h = 1;
            if (n04Var.b(aVar) == objE) {
                return objE;
            }
        } else {
            if (i2 != 1) {
                e04.a("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            lt3.b(obj);
        }
        try {
            ReentrantLock reentrantLock = this.d;
            reentrantLock.lock();
            try {
                if (this.f) {
                    kw3.b(21, "Connection pool is closed");
                    throw new kr1();
                }
                if (this.i.isEmpty()) {
                    f();
                }
                c10 c10Var = (c10) this.i.removeLast();
                reentrantLock.unlock();
                return c10Var;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        } catch (Throwable th2) {
            this.h.release();
            throw th2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Duplicate block (B:27:0x0064) to fix multi-entry loop: BACK_EDGE: B:27:0x0064 -> B:43:0x0069 */
    /* JADX WARN: Can't wrap try/catch for region: R(12:11|45|12|24|43|28|(1:(1:38)(2:34|(1:36)))(1:30)|37|19|47|20|(1:22)(10:23|24|43|28|(0)(0)|37|19|47|20|(0)(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005f, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0064, code lost:
    
        r11 = r11;
        r10 = r10;
        r2 = r0;
        r0 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0057 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006d A[Catch: all -> 0x0071, TryCatch #0 {all -> 0x0071, blocks: (B:28:0x0069, B:30:0x006d, B:34:0x0075, B:38:0x007c), top: B:43:0x0069 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0058 -> B:24:0x005a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b(long j, Function0 function0, f30 f30Var) throws Throwable {
        b bVar;
        mp3 mp3Var;
        b bVar2;
        Throwable th;
        c cVar;
        if (f30Var instanceof b) {
            bVar = (b) f30Var;
            int i = bVar.k;
            if ((i & Integer.MIN_VALUE) != 0) {
                bVar.k = i - Integer.MIN_VALUE;
            } else {
                bVar = new b(f30Var);
            }
        }
        Object obj = bVar.i;
        Object objE = kl1.e();
        int i2 = bVar.k;
        if (i2 == 0) {
            lt3.b(obj);
            mp3 mp3Var2 = new mp3();
            cVar = new c(mp3Var2, this, null);
            bVar.g = function0;
            bVar.h = mp3Var2;
            bVar.f = j;
            bVar.k = 1;
            if (so4.d(j, cVar, bVar) != objE) {
            }
        } else {
            if (i2 != 1) {
                e04.a("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            j = bVar.f;
            mp3 mp3Var3 = (mp3) bVar.h;
            Function0 function02 = (Function0) bVar.g;
            try {
                try {
                    lt3.b(obj);
                } catch (Throwable th2) {
                    mp3Var = mp3Var3;
                    function0 = function02;
                    bVar2 = bVar;
                    th = th2;
                    if (th instanceof po4) {
                    }
                    bVar = bVar2;
                    mp3 mp3Var22 = new mp3();
                    cVar = new c(mp3Var22, this, null);
                    bVar.g = function0;
                    bVar.h = mp3Var22;
                    bVar.f = j;
                    bVar.k = 1;
                    if (so4.d(j, cVar, bVar) != objE) {
                    }
                }
                if (th instanceof po4) {
                    function0.invoke();
                } else {
                    if (th != null) {
                        throw th;
                    }
                    Object obj2 = mp3Var.f;
                    if (obj2 != null) {
                        return obj2;
                    }
                }
                bVar = bVar2;
                mp3 mp3Var222 = new mp3();
                cVar = new c(mp3Var222, this, null);
                bVar.g = function0;
                bVar.h = mp3Var222;
                bVar.f = j;
                bVar.k = 1;
                if (so4.d(j, cVar, bVar) != objE) {
                    return objE;
                }
                function02 = function0;
                mp3Var3 = mp3Var222;
                mp3Var = mp3Var3;
                function0 = function02;
                bVar2 = bVar;
                th = null;
                if (th instanceof po4) {
                }
                bVar = bVar2;
                mp3 mp3Var2222 = new mp3();
                cVar = new c(mp3Var2222, this, null);
                bVar.g = function0;
                bVar.h = mp3Var2222;
                bVar.f = j;
                bVar.k = 1;
                if (so4.d(j, cVar, bVar) != objE) {
                }
            } catch (Throwable th3) {
                c10 c10Var = (c10) mp3Var.f;
                if (c10Var != null) {
                    e(c10Var);
                }
                throw th3;
            }
            mp3Var = mp3Var3;
            function0 = function02;
            bVar2 = bVar;
            th = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void c() {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            this.f = true;
            for (c10 c10Var : this.g) {
                if (c10Var != null) {
                    c10Var.close();
                }
            }
            fw4 fw4Var = fw4.a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void d(StringBuilder sb) {
        sb.getClass();
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            List listC = nw.c();
            int size = this.i.size();
            for (int i = 0; i < size; i++) {
                listC.add(this.i.get(i));
            }
            List listA = nw.a(listC);
            sb.append('\t' + super.toString() + " (");
            sb.append("capacity=" + this.a + ", ");
            sb.append("permits=" + this.h.a() + ", ");
            sb.append("queue=(size=" + listA.size() + ")[" + ww.P(listA, null, null, null, 0, null, null, 63, null) + ']');
            sb.append(")");
            sb.append('\n');
            c10[] c10VarArr = this.g;
            int length = c10VarArr.length;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                c10 c10Var = c10VarArr[i3];
                i2++;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("\t\t[");
                sb2.append(i2);
                sb2.append("] - ");
                sb2.append(c10Var != null ? c10Var.toString() : null);
                sb.append(sb2.toString());
                sb.append('\n');
                if (c10Var != null) {
                    c10Var.i(sb);
                }
            }
            fw4 fw4Var = fw4.a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void e(c10 c10Var) {
        c10Var.getClass();
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            this.i.addLast(c10Var);
            fw4 fw4Var = fw4.a;
            reentrantLock.unlock();
            this.h.release();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f() {
        if (this.e >= this.a) {
            return;
        }
        c10 c10Var = new c10((lw3) this.b.invoke(), null, this.c, 2, null);
        c10[] c10VarArr = this.g;
        int i = this.e;
        this.e = i + 1;
        c10VarArr[i] = c10Var;
        this.i.addLast(c10Var);
    }
}
