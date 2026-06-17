package defpackage;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import defpackage.se;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class se implements jj4, ij0 {
    public final jj4 f;
    public final pe g;
    public final a h;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements hj4 {
        public final pe f;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final /* synthetic */ class b extends t81 implements Function1 {
            public static final b f = new b();

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public b() {
                super(1, hj4.class, "inTransaction", "inTransaction()Z", 0);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;)Ljava/lang/Object; */
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(hj4 hj4Var) {
                hj4Var.getClass();
                return Boolean.valueOf(hj4Var.f());
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(pe peVar) {
            peVar.getClass();
            this.f = peVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static Object a(hj4 hj4Var) {
            hj4Var.getClass();
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static fw4 c(String str, hj4 hj4Var) {
            hj4Var.getClass();
            hj4Var.o(str);
            return fw4.a;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hj4
        public void A() {
            try {
                this.f.i().A();
            } catch (Throwable th) {
                this.f.f();
                throw th;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hj4
        public void G() {
            try {
                hj4 hj4VarH = this.f.h();
                hj4VarH.getClass();
                hj4VarH.G();
            } finally {
                this.f.f();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f.e();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hj4
        public boolean f() {
            if (this.f.h() == null) {
                return false;
            }
            return ((Boolean) this.f.g(b.f)).booleanValue();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hj4
        public String getPath() {
            return (String) this.f.g(new gi3() { // from class: se.a.c
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.gi3, defpackage.rp1
                public Object get(Object obj) {
                    return ((hj4) obj).getPath();
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void h() {
            this.f.g(new Function1() { // from class: qe
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return se.a.a((hj4) obj);
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hj4
        public boolean isOpen() {
            return this.f.l();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hj4
        public void j() {
            try {
                this.f.i().j();
            } catch (Throwable th) {
                this.f.f();
                throw th;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hj4
        public Cursor k(lj4 lj4Var) {
            lj4Var.getClass();
            try {
                return new c(this.f.i().k(lj4Var), this.f);
            } catch (Throwable th) {
                this.f.f();
                throw th;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hj4
        public List m() {
            return (List) this.f.g(new gi3() { // from class: se.a.a
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.gi3, defpackage.rp1
                public Object get(Object obj) {
                    return ((hj4) obj).m();
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hj4
        public void n() {
            throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hj4
        public void o(final String str) {
            str.getClass();
            this.f.g(new Function1() { // from class: re
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return se.a.c(str, (hj4) obj);
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hj4
        public nj4 q(String str) {
            str.getClass();
            return new b(str, this.f);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hj4
        public boolean x() {
            throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hj4
        public void z() {
            hj4 hj4VarH = this.f.h();
            hj4VarH.getClass();
            hj4VarH.z();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c implements Cursor {
        public final Cursor f;
        public final pe g;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(Cursor cursor, pe peVar) {
            cursor.getClass();
            peVar.getClass();
            this.f = cursor;
            this.g = peVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f.close();
            this.g.f();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
            this.f.copyStringToBuffer(i, charArrayBuffer);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public void deactivate() {
            this.f.deactivate();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public byte[] getBlob(int i) {
            return this.f.getBlob(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public int getColumnCount() {
            return this.f.getColumnCount();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public int getColumnIndex(String str) {
            return this.f.getColumnIndex(str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public int getColumnIndexOrThrow(String str) {
            return this.f.getColumnIndexOrThrow(str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public String getColumnName(int i) {
            return this.f.getColumnName(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public String[] getColumnNames() {
            return this.f.getColumnNames();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public int getCount() {
            return this.f.getCount();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public double getDouble(int i) {
            return this.f.getDouble(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public Bundle getExtras() {
            return this.f.getExtras();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public float getFloat(int i) {
            return this.f.getFloat(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public int getInt(int i) {
            return this.f.getInt(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public long getLong(int i) {
            return this.f.getLong(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public Uri getNotificationUri() {
            return this.f.getNotificationUri();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public int getPosition() {
            return this.f.getPosition();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public short getShort(int i) {
            return this.f.getShort(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public String getString(int i) {
            return this.f.getString(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public int getType(int i) {
            return this.f.getType(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public boolean getWantsAllOnMoveCalls() {
            return this.f.getWantsAllOnMoveCalls();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public boolean isAfterLast() {
            return this.f.isAfterLast();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public boolean isBeforeFirst() {
            return this.f.isBeforeFirst();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public boolean isClosed() {
            return this.f.isClosed();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public boolean isFirst() {
            return this.f.isFirst();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public boolean isLast() {
            return this.f.isLast();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public boolean isNull(int i) {
            return this.f.isNull(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public boolean move(int i) {
            return this.f.move(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public boolean moveToFirst() {
            return this.f.moveToFirst();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public boolean moveToLast() {
            return this.f.moveToLast();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public boolean moveToNext() {
            return this.f.moveToNext();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public boolean moveToPosition(int i) {
            return this.f.moveToPosition(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public boolean moveToPrevious() {
            return this.f.moveToPrevious();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public void registerContentObserver(ContentObserver contentObserver) {
            this.f.registerContentObserver(contentObserver);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.f.registerDataSetObserver(dataSetObserver);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public boolean requery() {
            return this.f.requery();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public Bundle respond(Bundle bundle) {
            return this.f.respond(bundle);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public void setExtras(Bundle bundle) {
            this.f.setExtras(bundle);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
            this.f.setNotificationUri(contentResolver, uri);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public void unregisterContentObserver(ContentObserver contentObserver) {
            this.f.unregisterContentObserver(contentObserver);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.database.Cursor
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.f.unregisterDataSetObserver(dataSetObserver);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public se(jj4 jj4Var, pe peVar) {
        jj4Var.getClass();
        peVar.getClass();
        this.f = jj4Var;
        this.g = peVar;
        this.h = new a(peVar);
        peVar.k(a());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ij0
    public jj4 a() {
        return this.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final pe c() {
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jj4, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.h.close();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jj4
    public String getDatabaseName() {
        return this.f.getDatabaseName();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jj4
    public hj4 getWritableDatabase() {
        this.h.h();
        return this.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jj4
    public void setWriteAheadLoggingEnabled(boolean z) {
        this.f.setWriteAheadLoggingEnabled(z);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements nj4 {
        public static final a m = new a(null);
        public final String f;
        public final pe g;
        public int[] h;
        public long[] i;
        public double[] j;
        public String[] k;
        public byte[][] l;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(String str, pe peVar) {
            str.getClass();
            peVar.getClass();
            this.f = str;
            this.g = peVar;
            this.h = new int[0];
            this.i = new long[0];
            this.j = new double[0];
            this.k = new String[0];
            this.l = new byte[0][];
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static fw4 a(nj4 nj4Var) {
            nj4Var.getClass();
            nj4Var.execute();
            return fw4.a;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static Object c(b bVar, Function1 function1, hj4 hj4Var) {
            hj4Var.getClass();
            nj4 nj4VarQ = hj4Var.q(bVar.f);
            bVar.h(nj4VarQ);
            return function1.invoke(nj4VarQ);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.kj4
        public void C(int i, byte[] bArr) {
            bArr.getClass();
            i(4, i);
            this.h[i] = 4;
            this.l[i] = bArr;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.kj4
        public void b(int i, double d) {
            i(2, i);
            this.h[i] = 2;
            this.j[i] = d;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            g();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.kj4
        public void d(int i, long j) {
            i(1, i);
            this.h[i] = 1;
            this.i[i] = j;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.kj4
        public void e(int i) {
            i(5, i);
            this.h[i] = 5;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.nj4
        public void execute() {
            l(new Function1() { // from class: te
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return se.b.a((nj4) obj);
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.kj4
        public void g() {
            this.h = new int[0];
            this.i = new long[0];
            this.j = new double[0];
            this.k = new String[0];
            this.l = new byte[0][];
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void h(kj4 kj4Var) {
            int length = this.h.length;
            for (int i = 1; i < length; i++) {
                int i2 = this.h[i];
                if (i2 == 1) {
                    kj4Var.d(i, this.i[i]);
                } else if (i2 == 2) {
                    kj4Var.b(i, this.j[i]);
                } else if (i2 == 3) {
                    String str = this.k[i];
                    str.getClass();
                    kj4Var.p(i, str);
                } else if (i2 == 4) {
                    byte[] bArr = this.l[i];
                    bArr.getClass();
                    kj4Var.C(i, bArr);
                } else if (i2 == 5) {
                    kj4Var.e(i);
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void i(int i, int i2) {
            int i3 = i2 + 1;
            int[] iArr = this.h;
            if (iArr.length < i3) {
                this.h = Arrays.copyOf(iArr, i3);
            }
            if (i == 1) {
                long[] jArr = this.i;
                if (jArr.length < i3) {
                    this.i = Arrays.copyOf(jArr, i3);
                    return;
                }
                return;
            }
            if (i == 2) {
                double[] dArr = this.j;
                if (dArr.length < i3) {
                    this.j = Arrays.copyOf(dArr, i3);
                    return;
                }
                return;
            }
            if (i == 3) {
                String[] strArr = this.k;
                if (strArr.length < i3) {
                    this.k = (String[]) Arrays.copyOf(strArr, i3);
                    return;
                }
                return;
            }
            if (i != 4) {
                return;
            }
            byte[][] bArr = this.l;
            if (bArr.length < i3) {
                this.l = (byte[][]) Arrays.copyOf(bArr, i3);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Object l(final Function1 function1) {
            return this.g.g(new Function1() { // from class: ue
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return se.b.c(this.f, function1, (hj4) obj);
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.kj4
        public void p(int i, String str) {
            str.getClass();
            i(3, i);
            this.h[i] = 3;
            this.k[i] = str;
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class a {
            /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: se.b.a.<init>():void type: THIS */
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public /* synthetic */ a(we0 we0Var) {
                this();
            }

            public a() {
            }
        }
    }
}
