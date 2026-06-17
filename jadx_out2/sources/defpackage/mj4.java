package defpackage;

import android.database.Cursor;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class mj4 implements ow3 {
    public static final b i = new b(null);
    public final hj4 f;
    public final String g;
    public boolean h;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends mj4 implements ow3 {
        public final mj4 j;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(hj4 hj4Var, String str, mj4 mj4Var) {
            super(hj4Var, str, null);
            hj4Var.getClass();
            str.getClass();
            mj4Var.getClass();
            this.j = mj4Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public String I(int i) {
            return this.j.I(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public boolean Y() {
            boolean zY = this.j.Y();
            if (sg4.y(I(0), "wal", true)) {
                a().x();
                return zY;
            }
            a().n();
            return zY;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public void b(int i, double d) {
            this.j.b(i, d);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3, java.lang.AutoCloseable
        public void close() {
            this.j.close();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public void d(int i, long j) {
            this.j.d(i, j);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public void e(int i) {
            this.j.e(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public void g() {
            this.j.g();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public int getColumnCount() {
            return this.j.getColumnCount();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public String getColumnName(int i) {
            return this.j.getColumnName(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public double getDouble(int i) {
            return this.j.getDouble(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public long getLong(int i) {
            return this.j.getLong(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public boolean isNull(int i) {
            return this.j.isNull(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public void reset() {
            this.j.reset();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public boolean s(int i) {
            return this.j.s(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public void w(int i, String str) {
            str.getClass();
            this.j.w(i, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d extends mj4 {
        public final nj4 j;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(hj4 hj4Var, String str) {
            super(hj4Var, str, null);
            hj4Var.getClass();
            str.getClass();
            this.j = hj4Var.q(str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public String I(int i) {
            i();
            kw3.b(21, "no row");
            throw new kr1();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public boolean Y() {
            i();
            this.j.execute();
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public void b(int i, double d) {
            i();
            this.j.b(i, d);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3, java.lang.AutoCloseable
        public void close() throws IOException {
            this.j.close();
            h(true);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public void d(int i, long j) {
            i();
            this.j.d(i, j);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public void e(int i) {
            i();
            this.j.e(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public void g() {
            i();
            this.j.g();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public int getColumnCount() {
            i();
            return 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public String getColumnName(int i) {
            i();
            kw3.b(21, "no row");
            throw new kr1();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public double getDouble(int i) {
            i();
            kw3.b(21, "no row");
            throw new kr1();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public long getLong(int i) {
            i();
            kw3.b(21, "no row");
            throw new kr1();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public boolean isNull(int i) {
            i();
            kw3.b(21, "no row");
            throw new kr1();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public void reset() {
            i();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public void w(int i, String str) {
            str.getClass();
            i();
            this.j.p(i, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e extends mj4 {
        public final b.EnumC0099b j;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            static {
                int[] iArr = new int[b.EnumC0099b.values().length];
                try {
                    iArr[b.EnumC0099b.f.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[b.EnumC0099b.g.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[b.EnumC0099b.h.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[b.EnumC0099b.i.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[b.EnumC0099b.j.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                a = iArr;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(hj4 hj4Var, String str, b.EnumC0099b enumC0099b) {
            super(hj4Var, str, null);
            hj4Var.getClass();
            str.getClass();
            enumC0099b.getClass();
            this.j = enumC0099b;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public String I(int i) {
            i();
            kw3.b(21, "no row");
            throw new kr1();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public boolean Y() {
            int i = a.a[this.j.ordinal()];
            if (i == 1) {
                a().z();
                a().G();
                return false;
            }
            if (i == 2) {
                a().G();
                return false;
            }
            if (i == 3) {
                a().j();
                return false;
            }
            if (i == 4) {
                a().A();
                return false;
            }
            if (i != 5) {
                throw new j33();
            }
            a().r();
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public void b(int i, double d) {
            i();
            kw3.b(25, "column index out of range");
            throw new kr1();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3, java.lang.AutoCloseable
        public void close() {
            h(true);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public void d(int i, long j) {
            i();
            kw3.b(25, "column index out of range");
            throw new kr1();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public void e(int i) {
            i();
            kw3.b(25, "column index out of range");
            throw new kr1();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public void g() {
            i();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public int getColumnCount() {
            i();
            return 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public String getColumnName(int i) {
            i();
            kw3.b(21, "no row");
            throw new kr1();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public double getDouble(int i) {
            i();
            kw3.b(21, "no row");
            throw new kr1();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public long getLong(int i) {
            i();
            kw3.b(21, "no row");
            throw new kr1();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public boolean isNull(int i) {
            i();
            kw3.b(21, "no row");
            throw new kr1();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public void reset() {
            i();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public void w(int i, String str) {
            str.getClass();
            i();
            kw3.b(25, "column index out of range");
            throw new kr1();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public mj4(hj4 hj4Var, String str) {
        this.f = hj4Var;
        this.g = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final hj4 a() {
        return this.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String c() {
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h(boolean z) {
        this.h = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void i() {
        if (this.h) {
            kw3.b(21, "statement is closed");
            mx3.a();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean isClosed() {
        return this.h;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends mj4 {
        public static final b p = new b(null);
        public int[] j;
        public long[] k;
        public double[] l;
        public String[] m;
        public byte[][] n;
        public Cursor o;

        /* JADX INFO: renamed from: mj4$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class C0097a implements lj4 {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public C0097a() {
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.lj4
            public String a() {
                return a.this.c();
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.lj4
            public void b(kj4 kj4Var) {
                kj4Var.getClass();
                int length = a.this.j.length;
                for (int i = 1; i < length; i++) {
                    int i2 = a.this.j[i];
                    if (i2 == 1) {
                        kj4Var.d(i, a.this.k[i]);
                    } else if (i2 == 2) {
                        kj4Var.b(i, a.this.l[i]);
                    } else if (i2 == 3) {
                        String str = a.this.m[i];
                        str.getClass();
                        kj4Var.p(i, str);
                    } else if (i2 == 4) {
                        byte[] bArr = a.this.n[i];
                        bArr.getClass();
                        kj4Var.C(i, bArr);
                    } else if (i2 == 5) {
                        kj4Var.e(i);
                    }
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(hj4 hj4Var, String str) {
            super(hj4Var, str, null);
            hj4Var.getClass();
            str.getClass();
            this.j = new int[0];
            this.k = new long[0];
            this.l = new double[0];
            this.m = new String[0];
            this.n = new byte[0][];
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void B(int i, int i2) {
            int i3 = i2 + 1;
            int[] iArr = this.j;
            if (iArr.length < i3) {
                this.j = Arrays.copyOf(iArr, i3);
            }
            if (i == 1) {
                long[] jArr = this.k;
                if (jArr.length < i3) {
                    this.k = Arrays.copyOf(jArr, i3);
                    return;
                }
                return;
            }
            if (i == 2) {
                double[] dArr = this.l;
                if (dArr.length < i3) {
                    this.l = Arrays.copyOf(dArr, i3);
                    return;
                }
                return;
            }
            if (i == 3) {
                String[] strArr = this.m;
                if (strArr.length < i3) {
                    this.m = (String[]) Arrays.copyOf(strArr, i3);
                    return;
                }
                return;
            }
            if (i != 4) {
                return;
            }
            byte[][] bArr = this.n;
            if (bArr.length < i3) {
                this.n = (byte[][]) Arrays.copyOf(bArr, i3);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void F() {
            if (this.o == null) {
                this.o = a().k(new C0097a());
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public String I(int i) {
            i();
            Cursor cursorK = K();
            J(cursorK, i);
            String string = cursorK.getString(i);
            string.getClass();
            return string;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void J(Cursor cursor, int i) {
            if (i < 0 || i >= cursor.getColumnCount()) {
                kw3.b(25, "column index out of range");
                mx3.a();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Cursor K() {
            Cursor cursor = this.o;
            if (cursor != null) {
                return cursor;
            }
            kw3.b(21, "no row");
            mx3.a();
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public boolean Y() {
            i();
            F();
            Cursor cursor = this.o;
            if (cursor != null) {
                return cursor.moveToNext();
            }
            e04.a("Required value was null.");
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public void b(int i, double d) {
            i();
            B(2, i);
            this.j[i] = 2;
            this.l[i] = d;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3, java.lang.AutoCloseable
        public void close() {
            if (!isClosed()) {
                g();
                reset();
            }
            h(true);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public void d(int i, long j) {
            i();
            B(1, i);
            this.j[i] = 1;
            this.k[i] = j;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public void e(int i) {
            i();
            B(5, i);
            this.j[i] = 5;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public void g() {
            i();
            this.j = new int[0];
            this.k = new long[0];
            this.l = new double[0];
            this.m = new String[0];
            this.n = new byte[0][];
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public int getColumnCount() {
            i();
            F();
            Cursor cursor = this.o;
            if (cursor != null) {
                return cursor.getColumnCount();
            }
            return 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public String getColumnName(int i) {
            i();
            F();
            Cursor cursor = this.o;
            if (cursor == null) {
                e04.a("Required value was null.");
                return null;
            }
            J(cursor, i);
            String columnName = cursor.getColumnName(i);
            columnName.getClass();
            return columnName;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public double getDouble(int i) {
            i();
            Cursor cursorK = K();
            J(cursorK, i);
            return cursorK.getDouble(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public long getLong(int i) {
            i();
            Cursor cursorK = K();
            J(cursorK, i);
            return cursorK.getLong(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public boolean isNull(int i) {
            i();
            Cursor cursorK = K();
            J(cursorK, i);
            return cursorK.isNull(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public void reset() {
            i();
            Cursor cursor = this.o;
            if (cursor != null) {
                cursor.close();
            }
            this.o = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ow3
        public void w(int i, String str) {
            str.getClass();
            i();
            B(3, i);
            this.j[i] = 3;
            this.m[i] = str;
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class b {
            /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: mj4.a.b.<init>():void type: THIS */
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public /* synthetic */ b(we0 we0Var) {
                this();
            }

            public b() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: renamed from: mj4$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class EnumC0099b {
            public static final EnumC0099b f = new EnumC0099b("END", 0);
            public static final EnumC0099b g = new EnumC0099b("ROLLBACK", 1);
            public static final EnumC0099b h = new EnumC0099b("BEGIN_EXCLUSIVE", 2);
            public static final EnumC0099b i = new EnumC0099b("BEGIN_IMMEDIATE", 3);
            public static final EnumC0099b j = new EnumC0099b("BEGIN_DEFERRED", 4);
            public static final /* synthetic */ EnumC0099b[] k;
            public static final /* synthetic */ gt0 l;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            static {
                EnumC0099b[] enumC0099bArrA = a();
                k = enumC0099bArrA;
                l = ht0.a(enumC0099bArrA);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public EnumC0099b(String str, int i2) {
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public static final /* synthetic */ EnumC0099b[] a() {
                return new EnumC0099b[]{f, g, h, i, j};
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public static EnumC0099b valueOf(String str) {
                return (EnumC0099b) Enum.valueOf(EnumC0099b.class, str);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public static EnumC0099b[] values() {
                return (EnumC0099b[]) k.clone();
            }
        }

        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: mj4.b.<init>():void type: THIS */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public /* synthetic */ b(we0 we0Var) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final mj4 a(hj4 hj4Var, String str) {
            hj4Var.getClass();
            str.getClass();
            String upperCase = wg4.O0(str).toString().toUpperCase(Locale.ROOT);
            upperCase.getClass();
            String strC = c(upperCase);
            if (strC == null) {
                return new d(hj4Var, str);
            }
            EnumC0099b enumC0099bE = e(strC, upperCase);
            return enumC0099bE != null ? new e(hj4Var, str, enumC0099bE) : b(strC, upperCase) instanceof a.C0098a ? new c(hj4Var, str, new a(hj4Var, str)) : f(strC) ? new a(hj4Var, str) : new d(hj4Var, str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final a b(String str, String str2) {
            if (il1.a(str, "PRA")) {
                String lowerCase = str2.toLowerCase(Locale.ROOT);
                lowerCase.getClass();
                if (wg4.P(wg4.J0(lowerCase, "journal_mode", ""), "=", false, 2, null)) {
                    return a.C0098a.a;
                }
            }
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final String c(String str) {
            str.getClass();
            int iD = d(str);
            if (iD < 0 || iD > str.length()) {
                return null;
            }
            return str.substring(iD, Math.min(iD + 3, str.length()));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final int d(String str) {
            String str2;
            int i;
            int length = str.length() - 2;
            if (length < 0) {
                return -1;
            }
            int i2 = 0;
            while (i2 < length) {
                char cCharAt = str.charAt(i2);
                if (il1.b(cCharAt, 32) <= 0) {
                    i2++;
                } else {
                    if (cCharAt != '-') {
                        str2 = str;
                        if (cCharAt == '/') {
                            int iZ = i2 + 1;
                            if (str2.charAt(iZ) == '*') {
                                do {
                                    String str3 = str2;
                                    iZ = wg4.Z(str3, '*', iZ + 1, false, 4, null);
                                    str2 = str3;
                                    if (iZ >= 0) {
                                        i = iZ + 1;
                                        if (i >= length) {
                                            break;
                                        }
                                    } else {
                                        return -1;
                                    }
                                } while (str2.charAt(i) != '/');
                                i2 = iZ + 2;
                                str = str2;
                            }
                        }
                        return i2;
                    }
                    if (str.charAt(i2 + 1) != '-') {
                        return i2;
                    }
                    str2 = str;
                    int iZ2 = wg4.Z(str2, '\n', i2 + 2, false, 4, null);
                    if (iZ2 < 0) {
                        return -1;
                    }
                    i2 = iZ2 + 1;
                    str = str2;
                }
            }
            return -1;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
        
            if (r4.equals("END") == false) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
        
            if (r4.equals("COM") == false) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0034, code lost:
        
            return mj4.b.EnumC0099b.f;
         */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final EnumC0099b e(String str, String str2) {
            switch (str.hashCode()) {
                case 65636:
                    if (str.equals("BEG")) {
                        return wg4.P(str2, "EXCLUSIVE", false, 2, null) ? EnumC0099b.h : wg4.P(str2, "IMMEDIATE", false, 2, null) ? EnumC0099b.i : EnumC0099b.j;
                    }
                    return null;
                case 66913:
                    break;
                case 68795:
                    break;
                case 81327:
                    if (str.equals("ROL") && !wg4.P(str2, " TO ", false, 2, null)) {
                        return EnumC0099b.g;
                    }
                    return null;
                default:
                    return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean f(String str) {
            int iHashCode = str.hashCode();
            return iHashCode != 79487 ? iHashCode != 81978 ? iHashCode == 85954 && str.equals("WIT") : str.equals("SEL") : str.equals("PRA");
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static abstract class a {

            /* JADX INFO: renamed from: mj4$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static final class C0098a extends a {
                public static final C0098a a = new C0098a();

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public C0098a() {
                    super(null);
                }
            }

            /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: mj4.b.a.<init>():void type: THIS */
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public /* synthetic */ a(we0 we0Var) {
                this();
            }

            public a() {
            }
        }

        public b() {
        }
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR (r1v0 hj4), (r2v0 java.lang.String) A[MD:(hj4, java.lang.String):void (m)] (LINE:9) call: mj4.<init>(hj4, java.lang.String):void type: THIS */
    public /* synthetic */ mj4(hj4 hj4Var, String str, we0 we0Var) {
        this(hj4Var, str);
    }
}
