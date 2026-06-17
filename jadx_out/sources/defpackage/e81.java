package defpackage;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class e81 implements hj4 {
    public static final a g = new a(null);
    public static final String[] h = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    public static final String[] i = new String[0];
    public static final cs1 j;
    public static final cs1 k;
    public final SQLiteDatabase f;

    static {
        ls1 ls1Var = ls1.g;
        j = is1.a(ls1Var, new Function0() { // from class: c81
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return e81.h();
            }
        });
        k = is1.a(ls1Var, new Function0() { // from class: d81
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return e81.a();
            }
        });
    }

    public e81(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.getClass();
        this.f = sQLiteDatabase;
    }

    public static Method a() {
        Class<?> returnType;
        try {
            Method methodD = g.d();
            if (methodD == null || (returnType = methodD.getReturnType()) == null) {
                return null;
            }
            Class cls = Integer.TYPE;
            return returnType.getDeclaredMethod("beginTransaction", cls, SQLiteTransactionListener.class, cls, CancellationSignal.class);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Cursor c(Function4 function4, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        return (Cursor) function4.invoke(sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
    }

    public static Method h() {
        try {
            Method declaredMethod = SQLiteDatabase.class.getDeclaredMethod("getThreadSession", null);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static SQLiteCursor i(lj4 lj4Var, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        sQLiteQuery.getClass();
        lj4Var.b(new j81(sQLiteQuery));
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }

    @Override // defpackage.hj4
    public void A() {
        this.f.beginTransactionNonExclusive();
    }

    @Override // defpackage.hj4
    public void G() {
        this.f.endTransaction();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f.close();
    }

    @Override // defpackage.hj4
    public boolean f() {
        return this.f.inTransaction();
    }

    @Override // defpackage.hj4
    public String getPath() {
        return this.f.getPath();
    }

    @Override // defpackage.hj4
    public boolean isOpen() {
        return this.f.isOpen();
    }

    @Override // defpackage.hj4
    public void j() {
        this.f.beginTransaction();
    }

    @Override // defpackage.hj4
    public Cursor k(final lj4 lj4Var) {
        lj4Var.getClass();
        final Function4 function4 = new Function4() { // from class: a81
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return e81.i(lj4Var, (SQLiteDatabase) obj, (SQLiteCursorDriver) obj2, (String) obj3, (SQLiteQuery) obj4);
            }
        };
        Cursor cursorRawQueryWithFactory = this.f.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: b81
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                return e81.c(function4, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, lj4Var.a(), i, null);
        cursorRawQueryWithFactory.getClass();
        return cursorRawQueryWithFactory;
    }

    @Override // defpackage.hj4
    public List m() {
        return this.f.getAttachedDbs();
    }

    @Override // defpackage.hj4
    public void n() {
        this.f.disableWriteAheadLogging();
    }

    @Override // defpackage.hj4
    public void o(String str) {
        str.getClass();
        this.f.execSQL(str);
    }

    @Override // defpackage.hj4
    public nj4 q(String str) {
        str.getClass();
        SQLiteStatement sQLiteStatementCompileStatement = this.f.compileStatement(str);
        sQLiteStatementCompileStatement.getClass();
        return new k81(sQLiteStatementCompileStatement);
    }

    @Override // defpackage.hj4
    public void r() throws IllegalAccessException, InvocationTargetException {
        v(null);
    }

    public void u(SQLiteTransactionListener sQLiteTransactionListener) {
        sQLiteTransactionListener.getClass();
        this.f.beginTransactionWithListener(sQLiteTransactionListener);
    }

    public final void v(SQLiteTransactionListener sQLiteTransactionListener) throws IllegalAccessException, InvocationTargetException {
        a aVar = g;
        if (aVar.c() == null || aVar.d() == null) {
            if (sQLiteTransactionListener != null) {
                u(sQLiteTransactionListener);
                return;
            } else {
                j();
                return;
            }
        }
        Method methodC = aVar.c();
        methodC.getClass();
        Method methodD = aVar.d();
        methodD.getClass();
        Object objInvoke = methodD.invoke(this.f, null);
        if (objInvoke != null) {
            methodC.invoke(objInvoke, 0, sQLiteTransactionListener, 0, null);
        } else {
            e04.a("Required value was null.");
        }
    }

    @Override // defpackage.hj4
    public boolean x() {
        return this.f.enableWriteAheadLogging();
    }

    public final boolean y(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.getClass();
        return il1.a(this.f, sQLiteDatabase);
    }

    @Override // defpackage.hj4
    public void z() {
        this.f.setTransactionSuccessful();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public /* synthetic */ a(we0 we0Var) {
            this();
        }

        public final Method c() {
            return (Method) e81.k.getValue();
        }

        public final Method d() {
            return (Method) e81.j.getValue();
        }

        public a() {
        }
    }
}
