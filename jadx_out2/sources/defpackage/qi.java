package defpackage;

import defpackage.bu3;
import defpackage.hu3;
import defpackage.kt3;
import defpackage.qi;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class qi {
    public static final a c = new a(null);
    public boolean a;
    public boolean b;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class b implements nw3 {
        public final nw3 a;
        public final /* synthetic */ qi b;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class a implements Function1 {
            public final /* synthetic */ String f;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a(String str) {
                this.f = str;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;)Ljava/lang/Object; */
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Void invoke(Throwable th) {
                th.getClass();
                throw new IllegalStateException("Unable to open database '" + this.f + "'. Was a proper path / name used in Room's database builder?", th);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(qi qiVar, nw3 nw3Var) {
            nw3Var.getClass();
            this.b = qiVar;
            this.a = nw3Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static lw3 c(qi qiVar, b bVar, String str) throws Exception {
            if (qiVar.b) {
                e04.a("Recursive database initialization detected. Did you try to use the database instance during initialization? Maybe in one of the callbacks?");
                return null;
            }
            lw3 lw3VarA = bVar.a.a(str);
            if (qiVar.a) {
                qiVar.g(lw3VarA);
                return lw3VarA;
            }
            try {
                qiVar.b = true;
                qiVar.i(lw3VarA);
                return lw3VarA;
            } finally {
                qiVar.b = false;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.nw3
        public lw3 a(String str) {
            str.getClass();
            return d(this.b.A(str));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.nw3
        public boolean b() {
            return this.a.b();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final lw3 d(final String str) {
            nv0 nv0Var = new nv0(str, (this.b.a || this.b.b || il1.a(str, ":memory:")) ? false : true);
            final qi qiVar = this.b;
            return (lw3) nv0Var.b(new Function0() { // from class: ri
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return qi.b.c(qiVar, this, str);
                }
            }, new a(str));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        static {
            int[] iArr = new int[bu3.d.values().length];
            try {
                iArr[bu3.d.g.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[bu3.d.h.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    public abstract String A(String str);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void B(lw3 lw3Var) throws Exception {
        l(lw3Var);
        kw3.a(lw3Var, gu3.a(r().c()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final void f(lw3 lw3Var) throws Exception {
        Object objB;
        hu3.a aVarJ;
        if (t(lw3Var)) {
            ow3 ow3VarA0 = lw3Var.a0("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1");
            try {
                String strI = ow3VarA0.Y() ? ow3VarA0.I(0) : null;
                ne.a(ow3VarA0, null);
                if (il1.a(r().c(), strI) || il1.a(r().d(), strI)) {
                    return;
                }
                throw new IllegalStateException(("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: " + r().c() + ", found: " + strI).toString());
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    ne.a(ow3VarA0, th);
                    throw th2;
                }
            }
        }
        kw3.a(lw3Var, "BEGIN EXCLUSIVE TRANSACTION");
        try {
            kt3.a aVar = kt3.g;
            aVarJ = r().j(lw3Var);
        } catch (Throwable th3) {
            kt3.a aVar2 = kt3.g;
            objB = kt3.b(lt3.a(th3));
        }
        if (!aVarJ.a) {
            throw new IllegalStateException(("Pre-packaged database has an invalid schema: " + aVarJ.b).toString());
        }
        r().h(lw3Var);
        B(lw3Var);
        objB = kt3.b(fw4.a);
        if (kt3.g(objB)) {
            kw3.a(lw3Var, "END TRANSACTION");
        }
        Throwable thD = kt3.d(objB);
        if (thD == null) {
            kt3.a(objB);
        } else {
            kw3.a(lw3Var, "ROLLBACK TRANSACTION");
            throw thD;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g(lw3 lw3Var) throws Exception {
        h(lw3Var);
        k(lw3Var);
        r().g(lw3Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final void h(lw3 lw3Var) throws Exception {
        ow3 ow3VarA0 = lw3Var.a0("PRAGMA busy_timeout");
        try {
            ow3VarA0.Y();
            long j = ow3VarA0.getLong(0);
            ne.a(ow3VarA0, null);
            if (j < 3000) {
                kw3.a(lw3Var, "PRAGMA busy_timeout = 3000");
            }
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
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final void i(lw3 lw3Var) throws Exception {
        Object objB;
        h(lw3Var);
        j(lw3Var);
        k(lw3Var);
        ow3 ow3VarA0 = lw3Var.a0("PRAGMA user_version");
        try {
            ow3VarA0.Y();
            int i = (int) ow3VarA0.getLong(0);
            ne.a(ow3VarA0, null);
            if (i != r().e()) {
                kw3.a(lw3Var, "BEGIN EXCLUSIVE TRANSACTION");
                try {
                    kt3.a aVar = kt3.g;
                    if (i == 0) {
                        x(lw3Var);
                    } else {
                        y(lw3Var, i, r().e());
                    }
                    kw3.a(lw3Var, "PRAGMA user_version = " + r().e());
                    objB = kt3.b(fw4.a);
                } catch (Throwable th) {
                    kt3.a aVar2 = kt3.g;
                    objB = kt3.b(lt3.a(th));
                }
                if (kt3.g(objB)) {
                    kw3.a(lw3Var, "END TRANSACTION");
                }
                Throwable thD = kt3.d(objB);
                if (thD != null) {
                    kw3.a(lw3Var, "ROLLBACK TRANSACTION");
                    throw thD;
                }
            }
            z(lw3Var);
        } finally {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j(lw3 lw3Var) throws Exception {
        if (o().g == bu3.d.h) {
            kw3.a(lw3Var, "PRAGMA journal_mode = WAL");
        } else {
            kw3.a(lw3Var, "PRAGMA journal_mode = TRUNCATE");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k(lw3 lw3Var) throws Exception {
        if (o().g == bu3.d.h) {
            kw3.a(lw3Var, "PRAGMA synchronous = NORMAL");
        } else {
            kw3.a(lw3Var, "PRAGMA synchronous = FULL");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l(lw3 lw3Var) throws Exception {
        kw3.a(lw3Var, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final void m(lw3 lw3Var) throws Exception {
        if (!o().s) {
            r().b(lw3Var);
            return;
        }
        ow3 ow3VarA0 = lw3Var.a0("SELECT name, type FROM sqlite_master WHERE type = 'table' OR type = 'view'");
        try {
            List listC = nw.c();
            while (ow3VarA0.Y()) {
                String strI = ow3VarA0.I(0);
                if (!sg4.K(strI, "sqlite_", false, 2, null) && !il1.a(strI, "android_metadata")) {
                    listC.add(fu4.a(strI, Boolean.valueOf(il1.a(ow3VarA0.I(1), "view"))));
                }
            }
            List<i73> listA = nw.a(listC);
            ne.a(ow3VarA0, null);
            for (i73 i73Var : listA) {
                String str = (String) i73Var.a();
                if (((Boolean) i73Var.b()).booleanValue()) {
                    kw3.a(lw3Var, "DROP VIEW IF EXISTS `" + str + '`');
                } else {
                    kw3.a(lw3Var, "DROP TABLE IF EXISTS `" + str + '`');
                }
            }
        } finally {
        }
    }

    public abstract List n();

    public abstract ma0 o();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int p(bu3.d dVar) {
        dVar.getClass();
        int i = c.a[dVar.ordinal()];
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 4;
        }
        throw new IllegalStateException(("Can't get max number of reader for journal mode '" + dVar + '\'').toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int q(bu3.d dVar) {
        dVar.getClass();
        int i = c.a[dVar.ordinal()];
        if (i == 1 || i == 2) {
            return 1;
        }
        throw new IllegalStateException(("Can't get max number of writers for journal mode '" + dVar + '\'').toString());
    }

    public abstract hu3 r();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final boolean s(lw3 lw3Var) throws Exception {
        ow3 ow3VarA0 = lw3Var.a0("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z = false;
            if (ow3VarA0.Y()) {
                if (ow3VarA0.getLong(0) == 0) {
                    z = true;
                }
            }
            ne.a(ow3VarA0, null);
            return z;
        } finally {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final boolean t(lw3 lw3Var) throws Exception {
        ow3 ow3VarA0 = lw3Var.a0("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name = 'room_master_table'");
        try {
            boolean z = false;
            if (ow3VarA0.Y()) {
                if (ow3VarA0.getLong(0) != 0) {
                    z = true;
                }
            }
            ne.a(ow3VarA0, null);
            return z;
        } finally {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void u(lw3 lw3Var) {
        Iterator it = n().iterator();
        while (it.hasNext()) {
            ((bu3.b) it.next()).a(lw3Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void v(lw3 lw3Var) {
        Iterator it = n().iterator();
        while (it.hasNext()) {
            ((bu3.b) it.next()).c(lw3Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void w(lw3 lw3Var) {
        Iterator it = n().iterator();
        while (it.hasNext()) {
            ((bu3.b) it.next()).e(lw3Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void x(lw3 lw3Var) {
        lw3Var.getClass();
        boolean zS = s(lw3Var);
        r().a(lw3Var);
        if (!zS) {
            hu3.a aVarJ = r().j(lw3Var);
            if (!aVarJ.a) {
                throw new IllegalStateException(("Pre-packaged database has an invalid schema: " + aVarJ.b).toString());
            }
        }
        B(lw3Var);
        r().f(lw3Var);
        u(lw3Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void y(lw3 lw3Var, int i, int i2) {
        lw3Var.getClass();
        List listB = jt2.b(o().d, i, i2);
        if (listB == null) {
            if (!jt2.d(o(), i, i2)) {
                m(lw3Var);
                v(lw3Var);
                r().a(lw3Var);
                return;
            } else {
                throw new IllegalStateException(("A migration from " + i + " to " + i2 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* functions.").toString());
            }
        }
        r().i(lw3Var);
        Iterator it = listB.iterator();
        while (it.hasNext()) {
            ((it2) it.next()).a(lw3Var);
        }
        hu3.a aVarJ = r().j(lw3Var);
        if (aVarJ.a) {
            r().h(lw3Var);
            B(lw3Var);
        } else {
            throw new IllegalStateException(("Migration didn't properly handle: " + aVarJ.b).toString());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void z(lw3 lw3Var) {
        lw3Var.getClass();
        f(lw3Var);
        r().g(lw3Var);
        w(lw3Var);
        this.a = true;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: qi.a.<init>():void type: THIS */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public /* synthetic */ a(we0 we0Var) {
            this();
        }

        public a() {
        }
    }
}
