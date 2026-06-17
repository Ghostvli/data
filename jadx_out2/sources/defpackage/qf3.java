package defpackage;

import android.database.SQLException;
import defpackage.ds4;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class qf3 implements ds4, ao3 {
    public final m00 a;
    public final c10 b;
    public final boolean c;
    public final ia d;
    public volatile boolean e;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class a implements ow3 {
        public final ow3 f;
        public final long g;
        public final /* synthetic */ qf3 h;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(qf3 qf3Var, ow3 ow3Var) {
            ow3Var.getClass();
            this.h = qf3Var;
            this.f = ow3Var;
            this.g = qn4.b();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public String I(int i) {
            if (this.h.e) {
                kw3.b(21, "Statement is recycled");
                mx3.a();
                return null;
            }
            if (this.g == qn4.b()) {
                return this.f.I(i);
            }
            kw3.b(21, "Attempted to use statement on a different thread");
            mx3.a();
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public boolean Y() {
            if (this.h.e) {
                kw3.b(21, "Statement is recycled");
                mx3.a();
                return false;
            }
            if (this.g == qn4.b()) {
                return this.f.Y();
            }
            kw3.b(21, "Attempted to use statement on a different thread");
            mx3.a();
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public void b(int i, double d) {
            if (this.h.e) {
                kw3.b(21, "Statement is recycled");
                mx3.a();
            } else if (this.g == qn4.b()) {
                this.f.b(i, d);
            } else {
                kw3.b(21, "Attempted to use statement on a different thread");
                mx3.a();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3, java.lang.AutoCloseable
        public void close() {
            if (this.h.e) {
                kw3.b(21, "Statement is recycled");
                mx3.a();
            } else if (this.g == qn4.b()) {
                this.f.close();
            } else {
                kw3.b(21, "Attempted to use statement on a different thread");
                mx3.a();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public void d(int i, long j) {
            if (this.h.e) {
                kw3.b(21, "Statement is recycled");
                mx3.a();
            } else if (this.g == qn4.b()) {
                this.f.d(i, j);
            } else {
                kw3.b(21, "Attempted to use statement on a different thread");
                mx3.a();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public void e(int i) {
            if (this.h.e) {
                kw3.b(21, "Statement is recycled");
                mx3.a();
            } else if (this.g == qn4.b()) {
                this.f.e(i);
            } else {
                kw3.b(21, "Attempted to use statement on a different thread");
                mx3.a();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public void g() {
            if (this.h.e) {
                kw3.b(21, "Statement is recycled");
                mx3.a();
            } else if (this.g == qn4.b()) {
                this.f.g();
            } else {
                kw3.b(21, "Attempted to use statement on a different thread");
                mx3.a();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public int getColumnCount() {
            if (this.h.e) {
                kw3.b(21, "Statement is recycled");
                mx3.a();
                return 0;
            }
            if (this.g == qn4.b()) {
                return this.f.getColumnCount();
            }
            kw3.b(21, "Attempted to use statement on a different thread");
            mx3.a();
            return 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public String getColumnName(int i) {
            if (this.h.e) {
                kw3.b(21, "Statement is recycled");
                mx3.a();
                return null;
            }
            if (this.g == qn4.b()) {
                return this.f.getColumnName(i);
            }
            kw3.b(21, "Attempted to use statement on a different thread");
            mx3.a();
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public double getDouble(int i) {
            if (this.h.e) {
                kw3.b(21, "Statement is recycled");
                mx3.a();
                return 0.0d;
            }
            if (this.g == qn4.b()) {
                return this.f.getDouble(i);
            }
            kw3.b(21, "Attempted to use statement on a different thread");
            mx3.a();
            return 0.0d;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public long getLong(int i) {
            if (this.h.e) {
                kw3.b(21, "Statement is recycled");
                mx3.a();
                return 0L;
            }
            if (this.g == qn4.b()) {
                return this.f.getLong(i);
            }
            kw3.b(21, "Attempted to use statement on a different thread");
            mx3.a();
            return 0L;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public boolean isNull(int i) {
            if (this.h.e) {
                kw3.b(21, "Statement is recycled");
                mx3.a();
                return false;
            }
            if (this.g == qn4.b()) {
                return this.f.isNull(i);
            }
            kw3.b(21, "Attempted to use statement on a different thread");
            mx3.a();
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public void reset() {
            if (this.h.e) {
                kw3.b(21, "Statement is recycled");
                mx3.a();
            } else if (this.g == qn4.b()) {
                this.f.reset();
            } else {
                kw3.b(21, "Attempted to use statement on a different thread");
                mx3.a();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public void w(int i, String str) {
            str.getClass();
            if (this.h.e) {
                kw3.b(21, "Statement is recycled");
                mx3.a();
            } else if (this.g == qn4.b()) {
                this.f.w(i, str);
            } else {
                kw3.b(21, "Attempted to use statement on a different thread");
                mx3.a();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class b implements cs4, ao3 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.pf3
        public Object a(String str, Function1 function1, f30 f30Var) {
            return qf3.this.a(str, function1, f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ao3
        public lw3 d() {
            return qf3.this.d();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c {
        public final int a;
        public boolean b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(int i, boolean z) {
            this.a = i;
            this.b = z;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final int a() {
            return this.a;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean b() {
            return this.b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        static {
            int[] iArr = new int[ds4.a.values().length];
            try {
                iArr[ds4.a.f.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ds4.a.g.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ds4.a.h.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e extends g30 {
        public Object f;
        public Object g;
        public /* synthetic */ Object h;
        public int j;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(f30 f30Var) {
            super(f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.h = obj;
            this.j |= Integer.MIN_VALUE;
            return qf3.this.i(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class f extends g30 {
        public boolean f;
        public Object g;
        public /* synthetic */ Object h;
        public int j;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public f(f30 f30Var) {
            super(f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.h = obj;
            this.j |= Integer.MIN_VALUE;
            return qf3.this.j(false, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class g extends g30 {
        public Object f;
        public Object g;
        public int h;
        public /* synthetic */ Object i;
        public int k;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public g(f30 f30Var) {
            super(f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.i = obj;
            this.k |= Integer.MIN_VALUE;
            return qf3.this.o(null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class h extends g30 {
        public Object f;
        public Object g;
        public Object h;
        public /* synthetic */ Object i;
        public int k;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public h(f30 f30Var) {
            super(f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.i = obj;
            this.k |= Integer.MIN_VALUE;
            return qf3.this.a(null, null, this);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public qf3(m00 m00Var, c10 c10Var, boolean z) {
        m00Var.getClass();
        c10Var.getClass();
        this.a = m00Var;
        this.b = c10Var;
        this.c = z;
        this.d = new ia();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0093 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object o(ds4.a aVar, Function2 function2, f30 f30Var) throws Throwable {
        g gVar;
        SQLException e2;
        Throwable th;
        int i;
        if (f30Var instanceof g) {
            gVar = (g) f30Var;
            int i2 = gVar.k;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                gVar.k = i2 - Integer.MIN_VALUE;
            } else {
                gVar = new g(f30Var);
            }
        }
        Object objInvoke = gVar.i;
        Object objE = kl1.e();
        int i3 = gVar.k;
        try {
            if (i3 == 0) {
                lt3.b(objInvoke);
                if (aVar == null) {
                    aVar = ds4.a.f;
                }
                gVar.f = function2;
                gVar.k = 1;
                if (i(aVar, gVar) != objE) {
                }
            }
            if (i3 == 1) {
                function2 = (Function2) gVar.f;
                lt3.b(objInvoke);
            } else {
                if (i3 == 2) {
                    i = gVar.h;
                    lt3.b(objInvoke);
                    boolean z = i != 0;
                    gVar.f = objInvoke;
                    gVar.k = 3;
                    return j(z, gVar) != objE ? objE : objInvoke;
                }
                if (i3 == 3 || i3 == 4) {
                    Object obj = gVar.f;
                    lt3.b(objInvoke);
                    return obj;
                }
                if (i3 != 5) {
                    e04.a("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                th = (Throwable) gVar.g;
                th = (Throwable) gVar.f;
                try {
                    lt3.b(objInvoke);
                    throw th;
                } catch (SQLException e3) {
                    e2 = e3;
                    if (th != null) {
                    }
                }
            }
            b bVar = new b();
            gVar.f = null;
            gVar.h = 1;
            gVar.k = 2;
            objInvoke = function2.invoke(bVar, gVar);
            if (objInvoke != objE) {
                i = 1;
                if (i != 0) {
                }
                gVar.f = objInvoke;
                gVar.k = 3;
                if (j(z, gVar) != objE) {
                }
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                throw th;
            } catch (Throwable th3) {
                try {
                    gVar.f = th;
                    gVar.g = th3;
                    gVar.k = 5;
                    if (j(false, gVar) != objE) {
                        throw th3;
                    }
                } catch (SQLException e4) {
                    e2 = e4;
                    th = th3;
                    if (th != null) {
                        throw e2;
                    }
                    mv0.a(th, e2);
                    throw th;
                }
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // defpackage.pf3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(String str, Function1 function1, f30 f30Var) throws Throwable {
        h hVar;
        rw2 rw2Var;
        if (f30Var instanceof h) {
            hVar = (h) f30Var;
            int i = hVar.k;
            if ((i & Integer.MIN_VALUE) != 0) {
                hVar.k = i - Integer.MIN_VALUE;
            } else {
                hVar = new h(f30Var);
            }
        }
        Object obj = hVar.i;
        Object objE = kl1.e();
        int i2 = hVar.k;
        if (i2 == 0) {
            lt3.b(obj);
            if (this.e) {
                kw3.b(21, "Connection is recycled");
                mx3.a();
                return null;
            }
            l00 l00Var = (l00) hVar.getContext().a(k());
            if (l00Var == null || l00Var.b() != this) {
                kw3.b(21, "Attempted to use connection on a different coroutine");
                mx3.a();
                return null;
            }
            rw2Var = this.b;
            hVar.f = str;
            hVar.g = function1;
            hVar.h = rw2Var;
            hVar.k = 1;
            if (rw2Var.h(null, hVar) == objE) {
                return objE;
            }
        } else {
            if (i2 != 1) {
                e04.a("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            rw2 rw2Var2 = (rw2) hVar.h;
            function1 = (Function1) hVar.g;
            String str2 = (String) hVar.f;
            lt3.b(obj);
            rw2Var = rw2Var2;
            str = str2;
        }
        try {
            a aVar = new a(this, this.b.a0(str));
            try {
                Object objInvoke = function1.invoke(aVar);
                ne.a(aVar, null);
                return objInvoke;
            } finally {
            }
        } finally {
            rw2Var.c(null);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ds4
    public Object b(ds4.a aVar, Function2 function2, f30 f30Var) {
        if (this.e) {
            kw3.b(21, "Connection is recycled");
            mx3.a();
            return null;
        }
        l00 l00Var = (l00) f30Var.getContext().a(k());
        if (l00Var != null && l00Var.b() == this) {
            return o(aVar, function2, f30Var);
        }
        kw3.b(21, "Attempted to use connection on a different coroutine");
        mx3.a();
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ds4
    public Object c(f30 f30Var) {
        if (this.e) {
            kw3.b(21, "Connection is recycled");
            mx3.a();
            return null;
        }
        l00 l00Var = (l00) f30Var.getContext().a(k());
        if (l00Var != null && l00Var.b() == this) {
            return hl.a(!this.d.isEmpty() || this.b.f());
        }
        kw3.b(21, "Attempted to use connection on a different coroutine");
        mx3.a();
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ao3
    public lw3 d() {
        return this.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object i(ds4.a aVar, f30 f30Var) throws Throwable {
        e eVar;
        rw2 rw2Var;
        if (f30Var instanceof e) {
            eVar = (e) f30Var;
            int i = eVar.j;
            if ((i & Integer.MIN_VALUE) != 0) {
                eVar.j = i - Integer.MIN_VALUE;
            } else {
                eVar = new e(f30Var);
            }
        }
        Object obj = eVar.h;
        Object objE = kl1.e();
        int i2 = eVar.j;
        if (i2 == 0) {
            lt3.b(obj);
            rw2Var = this.b;
            eVar.f = aVar;
            eVar.g = rw2Var;
            eVar.j = 1;
            if (rw2Var.h(null, eVar) == objE) {
                return objE;
            }
        } else {
            if (i2 != 1) {
                e04.a("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            rw2 rw2Var2 = (rw2) eVar.g;
            ds4.a aVar2 = (ds4.a) eVar.f;
            lt3.b(obj);
            rw2Var = rw2Var2;
            aVar = aVar2;
        }
        try {
            int size = this.d.size();
            if (this.d.isEmpty()) {
                int i3 = d.a[aVar.ordinal()];
                if (i3 == 1) {
                    kw3.a(this.b, "BEGIN DEFERRED TRANSACTION");
                } else if (i3 == 2) {
                    kw3.a(this.b, "BEGIN IMMEDIATE TRANSACTION");
                } else {
                    if (i3 != 3) {
                        throw new j33();
                    }
                    kw3.a(this.b, "BEGIN EXCLUSIVE TRANSACTION");
                }
            } else {
                kw3.a(this.b, "SAVEPOINT '" + size + '\'');
            }
            this.d.addLast(new c(size, false));
            fw4 fw4Var = fw4.a;
            rw2Var.c(null);
            return fw4Var;
        } catch (Throwable th) {
            rw2Var.c(null);
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object j(boolean z, f30 f30Var) throws Throwable {
        f fVar;
        rw2 rw2Var;
        if (f30Var instanceof f) {
            fVar = (f) f30Var;
            int i = fVar.j;
            if ((i & Integer.MIN_VALUE) != 0) {
                fVar.j = i - Integer.MIN_VALUE;
            } else {
                fVar = new f(f30Var);
            }
        }
        Object obj = fVar.h;
        Object objE = kl1.e();
        int i2 = fVar.j;
        if (i2 == 0) {
            lt3.b(obj);
            c10 c10Var = this.b;
            fVar.g = c10Var;
            fVar.f = z;
            fVar.j = 1;
            if (c10Var.h(null, fVar) == objE) {
                return objE;
            }
            rw2Var = c10Var;
        } else {
            if (i2 != 1) {
                e04.a("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            z = fVar.f;
            rw2Var = (rw2) fVar.g;
            lt3.b(obj);
        }
        try {
            if (this.d.isEmpty()) {
                throw new IllegalStateException("Not in a transaction");
            }
            c cVar = (c) tw.z(this.d);
            if (!z || cVar.b()) {
                boolean zIsEmpty = this.d.isEmpty();
                c10 c10Var2 = this.b;
                if (zIsEmpty) {
                    kw3.a(c10Var2, "ROLLBACK TRANSACTION");
                } else {
                    kw3.a(c10Var2, "ROLLBACK TRANSACTION TO SAVEPOINT '" + cVar.a() + '\'');
                }
            } else {
                boolean zIsEmpty2 = this.d.isEmpty();
                c10 c10Var3 = this.b;
                if (zIsEmpty2) {
                    kw3.a(c10Var3, "END TRANSACTION");
                } else {
                    kw3.a(c10Var3, "RELEASE SAVEPOINT '" + cVar.a() + '\'');
                }
            }
            fw4 fw4Var = fw4.a;
            rw2Var.c(null);
            return fw4Var;
        } catch (Throwable th) {
            rw2Var.c(null);
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final m00 k() {
        return this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final c10 l() {
        return this.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean m() {
        return this.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void n() throws Exception {
        if (this.e) {
            return;
        }
        this.e = true;
        if (this.b.f()) {
            kw3.a(this.b, "ROLLBACK TRANSACTION");
        }
    }
}
