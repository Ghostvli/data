package defpackage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface jj4 extends Closeable {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface c {
        jj4 a(b bVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    String getDatabaseName();

    hj4 getWritableDatabase();

    void setWriteAheadLoggingEnabled(boolean z);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class a {
        public static final C0086a b = new C0086a(null);
        public final int a;

        public a(int i) {
            this.a = i;
        }

        public final void a(String str) {
            if (sg4.y(str, ":memory:", true)) {
                return;
            }
            int length = str.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = il1.b(str.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            if (str.subSequence(i, length + 1).toString().length() == 0) {
                return;
            }
            Log.w("SupportSQLite", "deleting the database file: " + str);
            try {
                SQLiteDatabase.deleteDatabase(new File(str));
            } catch (Exception e) {
                Log.w("SupportSQLite", "delete failed: ", e);
            }
        }

        public void b(hj4 hj4Var) {
            hj4Var.getClass();
        }

        public void c(hj4 hj4Var) {
            hj4Var.getClass();
            Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + hj4Var + ".path");
            if (!hj4Var.isOpen()) {
                String path = hj4Var.getPath();
                if (path != null) {
                    a(path);
                    return;
                }
                return;
            }
            List listM = null;
            try {
                try {
                    listM = hj4Var.m();
                } finally {
                    if (listM != null) {
                        Iterator it = listM.iterator();
                        while (it.hasNext()) {
                            Object obj = ((Pair) it.next()).second;
                            obj.getClass();
                            a((String) obj);
                        }
                    } else {
                        String path2 = hj4Var.getPath();
                        if (path2 != null) {
                            a(path2);
                        }
                    }
                }
            } catch (SQLiteException unused) {
            }
            try {
                hj4Var.close();
            } catch (IOException unused2) {
            }
            if (listM != null) {
                return;
            }
        }

        public abstract void d(hj4 hj4Var);

        public abstract void e(hj4 hj4Var, int i, int i2);

        public abstract void f(hj4 hj4Var);

        public abstract void g(hj4 hj4Var, int i, int i2);

        /* JADX INFO: renamed from: jj4$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class C0086a {
            public /* synthetic */ C0086a(we0 we0Var) {
                this();
            }

            public C0086a() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public static final C0087b f = new C0087b(null);
        public final Context a;
        public final String b;
        public final a c;
        public final boolean d;
        public final boolean e;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static class a {
            public final Context a;
            public String b;
            public a c;
            public boolean d;
            public boolean e;

            public a(Context context) {
                context.getClass();
                this.a = context;
            }

            public b a() {
                String str;
                a aVar = this.c;
                if (aVar == null) {
                    jl.a("Must set a callback to create the configuration.");
                    return null;
                }
                if (!this.d || ((str = this.b) != null && str.length() != 0)) {
                    return new b(this.a, this.b, aVar, this.d, this.e);
                }
                jl.a("Must set a non-null database name to a configuration that uses the no backup directory.");
                return null;
            }

            public a b(a aVar) {
                aVar.getClass();
                this.c = aVar;
                return this;
            }

            public a c(String str) {
                this.b = str;
                return this;
            }
        }

        public b(Context context, String str, a aVar, boolean z, boolean z2) {
            context.getClass();
            aVar.getClass();
            this.a = context;
            this.b = str;
            this.c = aVar;
            this.d = z;
            this.e = z2;
        }

        /* JADX INFO: renamed from: jj4$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class C0087b {
            public /* synthetic */ C0087b(we0 we0Var) {
                this();
            }

            public final a a(Context context) {
                context.getClass();
                return new a(context);
            }

            public C0087b() {
            }
        }
    }
}
