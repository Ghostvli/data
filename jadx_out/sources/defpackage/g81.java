package defpackage;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import defpackage.g81;
import defpackage.jj4;
import java.io.File;
import java.util.UUID;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class g81 implements jj4 {
    public static final a m = new a(null);
    public final Context f;
    public final String g;
    public final jj4.a h;
    public final boolean i;
    public final boolean j;
    public final cs1 k;
    public boolean l;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public e81 a;

        public b(e81 e81Var) {
            this.a = e81Var;
        }

        public final e81 a() {
            return this.a;
        }

        public final void b(e81 e81Var) {
            this.a = e81Var;
        }
    }

    public g81(Context context, String str, jj4.a aVar, boolean z, boolean z2) {
        context.getClass();
        aVar.getClass();
        this.f = context;
        this.g = str;
        this.h = aVar;
        this.i = z;
        this.j = z2;
        this.k = is1.b(new Function0() { // from class: f81
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return g81.a(this.f);
            }
        });
    }

    public static c a(g81 g81Var) {
        c cVar;
        if (g81Var.g == null || !g81Var.i) {
            cVar = new c(g81Var.f, g81Var.g, new b(null), g81Var.h, g81Var.j);
        } else {
            cVar = new c(g81Var.f, new File(fj4.a(g81Var.f), g81Var.g).getAbsolutePath(), new b(null), g81Var.h, g81Var.j);
        }
        cVar.setWriteAheadLoggingEnabled(g81Var.l);
        return cVar;
    }

    public final c c() {
        return (c) this.k.getValue();
    }

    @Override // defpackage.jj4, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.k.isInitialized()) {
            c().close();
        }
    }

    @Override // defpackage.jj4
    public String getDatabaseName() {
        return this.g;
    }

    @Override // defpackage.jj4
    public hj4 getWritableDatabase() {
        return c().c(true);
    }

    @Override // defpackage.jj4
    public void setWriteAheadLoggingEnabled(boolean z) {
        if (this.k.isInitialized()) {
            c().setWriteAheadLoggingEnabled(z);
        }
        this.l = z;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends SQLiteOpenHelper {
        public static final C0082c m = new C0082c(null);
        public final Context f;
        public final b g;
        public final jj4.a h;
        public final boolean i;
        public boolean j;
        public final bh3 k;
        public boolean l;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class a extends RuntimeException {
            public final b f;
            public final Throwable g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar, Throwable th) {
                super(th);
                bVar.getClass();
                th.getClass();
                this.f = bVar;
                this.g = th;
            }

            public final b a() {
                return this.f;
            }

            @Override // java.lang.Throwable
            public Throwable getCause() {
                return this.g;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class b {
            public static final b f = new b("ON_CONFIGURE", 0);
            public static final b g = new b("ON_CREATE", 1);
            public static final b h = new b("ON_UPGRADE", 2);
            public static final b i = new b("ON_DOWNGRADE", 3);
            public static final b j = new b("ON_OPEN", 4);
            public static final /* synthetic */ b[] k;
            public static final /* synthetic */ gt0 l;

            static {
                b[] bVarArrA = a();
                k = bVarArrA;
                l = ht0.a(bVarArrA);
            }

            public b(String str, int i2) {
            }

            public static final /* synthetic */ b[] a() {
                return new b[]{f, g, h, i, j};
            }

            public static b valueOf(String str) {
                return (b) Enum.valueOf(b.class, str);
            }

            public static b[] values() {
                return (b[]) k.clone();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final /* synthetic */ class d {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[b.values().length];
                try {
                    iArr[b.f.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[b.g.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[b.h.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[b.i.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[b.j.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context, String str, final b bVar, final jj4.a aVar, boolean z) {
            String string;
            super(context, str, null, aVar.a, new DatabaseErrorHandler() { // from class: h81
                @Override // android.database.DatabaseErrorHandler
                public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    g81.c.a(aVar, bVar, sQLiteDatabase);
                }
            });
            context.getClass();
            bVar.getClass();
            aVar.getClass();
            this.f = context;
            this.g = bVar;
            this.h = aVar;
            this.i = z;
            if (str == null) {
                string = UUID.randomUUID().toString();
                string.getClass();
            } else {
                string = str;
            }
            this.k = new bh3(string, context.getCacheDir(), false);
        }

        public static void a(jj4.a aVar, b bVar, SQLiteDatabase sQLiteDatabase) {
            C0082c c0082c = m;
            sQLiteDatabase.getClass();
            aVar.c(c0082c.a(bVar, sQLiteDatabase));
        }

        public final hj4 c(boolean z) {
            hj4 hj4VarH;
            try {
                this.k.b((this.l || getDatabaseName() == null) ? false : true);
                this.j = false;
                SQLiteDatabase sQLiteDatabaseL = l(z);
                if (this.j) {
                    close();
                    hj4VarH = c(z);
                } else {
                    hj4VarH = h(sQLiteDatabaseL);
                }
                this.k.d();
                return hj4VarH;
            } catch (Throwable th) {
                this.k.d();
                throw th;
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public void close() {
            try {
                bh3.c(this.k, false, 1, null);
                super.close();
                this.g.b(null);
                this.l = false;
            } finally {
                this.k.d();
            }
        }

        public final e81 h(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.getClass();
            return m.a(this.g, sQLiteDatabase);
        }

        public final SQLiteDatabase i(boolean z) {
            if (z) {
                SQLiteDatabase writableDatabase = super.getWritableDatabase();
                writableDatabase.getClass();
                return writableDatabase;
            }
            SQLiteDatabase readableDatabase = super.getReadableDatabase();
            readableDatabase.getClass();
            return readableDatabase;
        }

        public final SQLiteDatabase l(boolean z) throws Throwable {
            File parentFile;
            String databaseName = getDatabaseName();
            boolean z2 = this.l;
            if (databaseName != null && !z2 && (parentFile = this.f.getDatabasePath(databaseName).getParentFile()) != null) {
                parentFile.mkdirs();
                if (!parentFile.isDirectory()) {
                    Log.w("SupportSQLite", "Invalid database parent file, not a directory: " + parentFile);
                }
            }
            try {
                return i(z);
            } catch (Throwable unused) {
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException unused2) {
                }
                try {
                    return this.i(z);
                } catch (Throwable th) {
                    th = th;
                    if (th instanceof a) {
                        a aVar = (a) th;
                        Throwable cause = aVar.getCause();
                        int i = d.a[aVar.a().ordinal()];
                        if (i == 1 || i == 2 || i == 3 || i == 4) {
                            throw cause;
                        }
                        if (i != 5) {
                            throw new j33();
                        }
                        if (!(cause instanceof SQLiteException)) {
                            throw cause;
                        }
                        th = cause;
                    }
                    if (!(th instanceof SQLiteException) || databaseName == null || !this.i) {
                        throw th;
                    }
                    this.f.deleteDatabase(databaseName);
                    try {
                        return this.i(z);
                    } catch (a e) {
                        throw e.getCause();
                    }
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.getClass();
            if (!this.j && this.h.a != sQLiteDatabase.getVersion()) {
                sQLiteDatabase.setMaxSqlCacheSize(1);
            }
            try {
                this.h.b(h(sQLiteDatabase));
            } catch (Throwable th) {
                throw new a(b.f, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.getClass();
            try {
                this.h.d(h(sQLiteDatabase));
            } catch (Throwable th) {
                throw new a(b.g, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            sQLiteDatabase.getClass();
            this.j = true;
            try {
                this.h.e(h(sQLiteDatabase), i, i2);
            } catch (Throwable th) {
                throw new a(b.i, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.getClass();
            if (!this.j) {
                try {
                    this.h.f(h(sQLiteDatabase));
                } catch (Throwable th) {
                    throw new a(b.j, th);
                }
            }
            this.l = true;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            sQLiteDatabase.getClass();
            this.j = true;
            try {
                this.h.g(h(sQLiteDatabase), i, i2);
            } catch (Throwable th) {
                throw new a(b.h, th);
            }
        }

        /* JADX INFO: renamed from: g81$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class C0082c {
            public /* synthetic */ C0082c(we0 we0Var) {
                this();
            }

            public final e81 a(b bVar, SQLiteDatabase sQLiteDatabase) {
                bVar.getClass();
                sQLiteDatabase.getClass();
                e81 e81VarA = bVar.a();
                if (e81VarA != null && e81VarA.y(sQLiteDatabase)) {
                    return e81VarA;
                }
                e81 e81Var = new e81(sQLiteDatabase);
                bVar.b(e81Var);
                return e81Var;
            }

            public C0082c() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public /* synthetic */ a(we0 we0Var) {
            this();
        }

        public a() {
        }
    }
}
