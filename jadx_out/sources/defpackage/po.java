package defpackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class po {
    public final HashMap a;
    public final SparseArray b;
    public final SparseBooleanArray c;
    public final SparseBooleanArray d;
    public c e;
    public c f;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements c {
        public static final String[] e = {Name.MARK, "key", "metadata"};
        public final oa0 a;
        public final SparseArray b = new SparseArray();
        public String c;
        public String d;

        public a(oa0 oa0Var) {
            this.a = oa0Var;
        }

        public static void i(oa0 oa0Var, String str) throws na0 {
            try {
                String strM = m(str);
                SQLiteDatabase writableDatabase = oa0Var.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    kz4.c(writableDatabase, 1, str);
                    k(writableDatabase, strM);
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e2) {
                throw new na0(e2);
            }
        }

        public static void k(SQLiteDatabase sQLiteDatabase, String str) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        }

        public static String m(String str) {
            return "ExoPlayerCacheIndex" + str;
        }

        @Override // po.c
        public void a(HashMap map) throws na0 {
            try {
                SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    n(writableDatabase);
                    Iterator it = map.values().iterator();
                    while (it.hasNext()) {
                        h(writableDatabase, (oo) it.next());
                    }
                    writableDatabase.setTransactionSuccessful();
                    this.b.clear();
                    writableDatabase.endTransaction();
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            } catch (SQLException e2) {
                throw new na0(e2);
            }
        }

        @Override // po.c
        public void b(oo ooVar, boolean z) {
            SparseArray sparseArray = this.b;
            if (z) {
                sparseArray.delete(ooVar.a);
            } else {
                sparseArray.put(ooVar.a, null);
            }
        }

        @Override // po.c
        public void c(oo ooVar) {
            this.b.put(ooVar.a, ooVar);
        }

        @Override // po.c
        public boolean d() throws na0 {
            try {
                return kz4.b(this.a.getReadableDatabase(), 1, (String) gg3.q(this.c)) != -1;
            } catch (SQLException e2) {
                throw new na0(e2);
            }
        }

        @Override // po.c
        public void delete() throws na0 {
            i(this.a, (String) gg3.q(this.c));
        }

        @Override // po.c
        public void e(HashMap map) throws na0 {
            if (this.b.size() == 0) {
                return;
            }
            try {
                SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                for (int i = 0; i < this.b.size(); i++) {
                    try {
                        oo ooVar = (oo) this.b.valueAt(i);
                        if (ooVar == null) {
                            j(writableDatabase, this.b.keyAt(i));
                        } else {
                            h(writableDatabase, ooVar);
                        }
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                }
                writableDatabase.setTransactionSuccessful();
                this.b.clear();
                writableDatabase.endTransaction();
            } catch (SQLException e2) {
                throw new na0(e2);
            }
        }

        @Override // po.c
        public void f(long j) {
            String hexString = Long.toHexString(j);
            this.c = hexString;
            this.d = m(hexString);
        }

        @Override // po.c
        public void g(HashMap map, SparseArray sparseArray) throws na0 {
            gg3.v(this.b.size() == 0);
            try {
                if (kz4.b(this.a.getReadableDatabase(), 1, (String) gg3.q(this.c)) != 1) {
                    SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        n(writableDatabase);
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                }
                Cursor cursorL = l();
                while (cursorL.moveToNext()) {
                    try {
                        oo ooVar = new oo(cursorL.getInt(0), (String) gg3.q(cursorL.getString(1)), po.o(new DataInputStream(new ByteArrayInputStream(cursorL.getBlob(2)))));
                        map.put(ooVar.b, ooVar);
                        sparseArray.put(ooVar.a, ooVar.b);
                    } finally {
                    }
                }
                cursorL.close();
            } catch (SQLiteException e2) {
                map.clear();
                sparseArray.clear();
                throw new na0(e2);
            }
        }

        public final void h(SQLiteDatabase sQLiteDatabase, oo ooVar) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            po.r(ooVar.c(), new DataOutputStream(byteArrayOutputStream));
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ContentValues contentValues = new ContentValues();
            contentValues.put(Name.MARK, Integer.valueOf(ooVar.a));
            contentValues.put("key", ooVar.b);
            contentValues.put("metadata", byteArray);
            sQLiteDatabase.replaceOrThrow((String) gg3.q(this.d), null, contentValues);
        }

        public final void j(SQLiteDatabase sQLiteDatabase, int i) {
            sQLiteDatabase.delete((String) gg3.q(this.d), "id = ?", new String[]{Integer.toString(i)});
        }

        public final Cursor l() {
            return this.a.getReadableDatabase().query((String) gg3.q(this.d), e, null, null, null, null, null);
        }

        public final void n(SQLiteDatabase sQLiteDatabase) throws na0 {
            kz4.d(sQLiteDatabase, 1, (String) gg3.q(this.c), 1);
            k(sQLiteDatabase, (String) gg3.q(this.d));
            sQLiteDatabase.execSQL("CREATE TABLE " + this.d + " (id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b implements c {
        public final boolean a;
        public final Cipher b;
        public final SecretKeySpec c;
        public final SecureRandom d;
        public final ub e;
        public boolean f;
        public qt3 g;

        public b(File file, byte[] bArr, boolean z) {
            Cipher cipher;
            SecretKeySpec secretKeySpec;
            gg3.v((bArr == null && z) ? false : true);
            if (bArr != null) {
                gg3.d(bArr.length == 16);
                try {
                    cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                    secretKeySpec = new SecretKeySpec(bArr, "AES");
                } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
                    throw new IllegalStateException(e);
                }
            } else {
                gg3.d(!z);
                cipher = null;
                secretKeySpec = null;
            }
            this.a = z;
            this.b = cipher;
            this.c = secretKeySpec;
            this.d = z ? new SecureRandom() : null;
            this.e = new ub(file);
        }

        @Override // po.c
        public void a(HashMap map) throws Throwable {
            l(map);
            this.f = false;
        }

        @Override // po.c
        public void b(oo ooVar, boolean z) {
            this.f = true;
        }

        @Override // po.c
        public void c(oo ooVar) {
            this.f = true;
        }

        @Override // po.c
        public boolean d() {
            return this.e.c();
        }

        @Override // po.c
        public void delete() {
            this.e.a();
        }

        @Override // po.c
        public void e(HashMap map) throws Throwable {
            if (this.f) {
                a(map);
            }
        }

        @Override // po.c
        public void f(long j) {
        }

        @Override // po.c
        public void g(HashMap map, SparseArray sparseArray) {
            gg3.v(!this.f);
            if (j(map, sparseArray)) {
                return;
            }
            map.clear();
            sparseArray.clear();
            this.e.a();
        }

        public final int h(oo ooVar, int i) {
            int i2;
            int iHashCode;
            int iHashCode2 = (ooVar.a * 31) + ooVar.b.hashCode();
            if (i < 2) {
                long jA = t20.a(ooVar.c());
                i2 = iHashCode2 * 31;
                iHashCode = (int) (jA ^ (jA >>> 32));
            } else {
                i2 = iHashCode2 * 31;
                iHashCode = ooVar.c().hashCode();
            }
            return i2 + iHashCode;
        }

        public final oo i(int i, DataInputStream dataInputStream) throws IOException {
            xe0 xe0VarO;
            int i2 = dataInputStream.readInt();
            String utf = dataInputStream.readUTF();
            if (i < 2) {
                long j = dataInputStream.readLong();
                u20 u20Var = new u20();
                u20.g(u20Var, j);
                xe0VarO = xe0.c.g(u20Var);
            } else {
                xe0VarO = po.o(dataInputStream);
            }
            return new oo(i2, utf, xe0VarO);
        }

        public final boolean j(HashMap map, SparseArray sparseArray) throws Throwable {
            BufferedInputStream bufferedInputStream;
            DataInputStream dataInputStream;
            if (!this.e.c()) {
                return true;
            }
            DataInputStream dataInputStream2 = null;
            try {
                bufferedInputStream = new BufferedInputStream(this.e.d());
                dataInputStream = new DataInputStream(bufferedInputStream);
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                int i = dataInputStream.readInt();
                if (i >= 0 && i <= 2) {
                    if ((dataInputStream.readInt() & 1) != 0) {
                        if (this.b == null) {
                            fy4.p(dataInputStream);
                            return false;
                        }
                        byte[] bArr = new byte[16];
                        dataInputStream.readFully(bArr);
                        try {
                            this.b.init(2, (Key) fy4.l(this.c), new IvParameterSpec(bArr));
                            dataInputStream = new DataInputStream(new CipherInputStream(bufferedInputStream, this.b));
                        } catch (InvalidAlgorithmParameterException e) {
                            e = e;
                            throw new IllegalStateException(e);
                        } catch (InvalidKeyException e2) {
                            e = e2;
                            throw new IllegalStateException(e);
                        }
                    } else if (this.a) {
                        this.f = true;
                    }
                    int i2 = dataInputStream.readInt();
                    int iH = 0;
                    for (int i3 = 0; i3 < i2; i3++) {
                        oo ooVarI = i(i, dataInputStream);
                        map.put(ooVarI.b, ooVarI);
                        sparseArray.put(ooVarI.a, ooVarI.b);
                        iH += h(ooVarI, i);
                    }
                    int i4 = dataInputStream.readInt();
                    boolean z = dataInputStream.read() == -1;
                    if (i4 == iH && z) {
                        fy4.p(dataInputStream);
                        return true;
                    }
                    fy4.p(dataInputStream);
                    return false;
                }
                fy4.p(dataInputStream);
                return false;
            } catch (IOException unused2) {
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    fy4.p(dataInputStream2);
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    fy4.p(dataInputStream2);
                }
                throw th;
            }
        }

        public final void k(oo ooVar, DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeInt(ooVar.a);
            dataOutputStream.writeUTF(ooVar.b);
            po.r(ooVar.c(), dataOutputStream);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void l(HashMap map) throws Throwable {
            qt3 qt3Var;
            DataOutputStream dataOutputStream;
            DataOutputStream dataOutputStream2 = null;
            try {
                OutputStream outputStreamF = this.e.f();
                qt3 qt3Var2 = this.g;
                if (qt3Var2 == null) {
                    this.g = new qt3(outputStreamF);
                } else {
                    qt3Var2.a(outputStreamF);
                }
                qt3Var = this.g;
                dataOutputStream = new DataOutputStream(qt3Var);
            } catch (Throwable th) {
                th = th;
            }
            try {
                dataOutputStream.writeInt(2);
                dataOutputStream.writeInt(this.a ? 1 : 0);
                if (this.a) {
                    byte[] bArr = new byte[16];
                    ((SecureRandom) fy4.l(this.d)).nextBytes(bArr);
                    dataOutputStream.write(bArr);
                    try {
                        ((Cipher) fy4.l(this.b)).init(1, (Key) fy4.l(this.c), new IvParameterSpec(bArr));
                        dataOutputStream.flush();
                        dataOutputStream = new DataOutputStream(new CipherOutputStream(qt3Var, this.b));
                    } catch (InvalidAlgorithmParameterException e) {
                        e = e;
                        throw new IllegalStateException(e);
                    } catch (InvalidKeyException e2) {
                        e = e2;
                        throw new IllegalStateException(e);
                    }
                }
                dataOutputStream.writeInt(map.size());
                int iH = 0;
                for (oo ooVar : map.values()) {
                    k(ooVar, dataOutputStream);
                    iH += h(ooVar, 2);
                }
                dataOutputStream.writeInt(iH);
                this.e.b(dataOutputStream);
                fy4.p(null);
            } catch (Throwable th2) {
                th = th2;
                dataOutputStream2 = dataOutputStream;
                fy4.p(dataOutputStream2);
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface c {
        void a(HashMap map);

        void b(oo ooVar, boolean z);

        void c(oo ooVar);

        boolean d();

        void delete();

        void e(HashMap map);

        void f(long j);

        void g(HashMap map, SparseArray sparseArray);
    }

    public po(oa0 oa0Var, File file, byte[] bArr, boolean z, boolean z2) {
        gg3.v((oa0Var == null && file == null) ? false : true);
        this.a = new HashMap();
        this.b = new SparseArray();
        this.c = new SparseBooleanArray();
        this.d = new SparseBooleanArray();
        a aVar = oa0Var != null ? new a(oa0Var) : null;
        b bVar = file != null ? new b(new File(file, "cached_content_index.exi"), bArr, z) : null;
        if (aVar == null || (bVar != null && z2)) {
            this.e = (c) fy4.l(bVar);
            this.f = aVar;
        } else {
            this.e = aVar;
            this.f = bVar;
        }
    }

    public static int j(SparseArray sparseArray) {
        int size = sparseArray.size();
        int i = 0;
        int iKeyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (iKeyAt >= 0) {
            return iKeyAt;
        }
        while (i < size && i == sparseArray.keyAt(i)) {
            i++;
        }
        return i;
    }

    public static boolean m(String str) {
        return str.startsWith("cached_content_index.exi");
    }

    public static xe0 o(DataInputStream dataInputStream) throws IOException {
        int i = dataInputStream.readInt();
        HashMap map = new HashMap();
        for (int i2 = 0; i2 < i; i2++) {
            String utf = dataInputStream.readUTF();
            int i3 = dataInputStream.readInt();
            if (i3 < 0) {
                ye5.a("Invalid value size: ", i3);
                return null;
            }
            int iMin = Math.min(i3, 10485760);
            byte[] bArrCopyOf = fy4.f;
            int i4 = 0;
            while (i4 != i3) {
                int i5 = i4 + iMin;
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, i5);
                dataInputStream.readFully(bArrCopyOf, i4, iMin);
                iMin = Math.min(i3 - i5, 10485760);
                i4 = i5;
            }
            map.put(utf, bArrCopyOf);
        }
        return new xe0(map);
    }

    public static void r(xe0 xe0Var, DataOutputStream dataOutputStream) throws IOException {
        Set<Map.Entry> setH = xe0Var.h();
        dataOutputStream.writeInt(setH.size());
        for (Map.Entry entry : setH) {
            dataOutputStream.writeUTF((String) entry.getKey());
            byte[] bArr = (byte[]) entry.getValue();
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.write(bArr);
        }
    }

    public final oo c(String str) {
        int iJ = j(this.b);
        oo ooVar = new oo(iJ, str);
        this.a.put(str, ooVar);
        this.b.put(iJ, str);
        this.d.put(iJ, true);
        this.e.c(ooVar);
        return ooVar;
    }

    public void d(String str, u20 u20Var) {
        oo ooVarK = k(str);
        if (ooVarK.b(u20Var)) {
            this.e.c(ooVarK);
        }
    }

    public int e(String str) {
        return k(str).a;
    }

    public oo f(String str) {
        return (oo) this.a.get(str);
    }

    public Collection g() {
        return Collections.unmodifiableCollection(this.a.values());
    }

    public t20 h(String str) {
        oo ooVarF = f(str);
        return ooVarF != null ? ooVarF.c() : xe0.c;
    }

    public String i(int i) {
        return (String) this.b.get(i);
    }

    public oo k(String str) {
        oo ooVar = (oo) this.a.get(str);
        return ooVar == null ? c(str) : ooVar;
    }

    public void l(long j) {
        c cVar;
        this.e.f(j);
        c cVar2 = this.f;
        if (cVar2 != null) {
            cVar2.f(j);
        }
        if (this.e.d() || (cVar = this.f) == null || !cVar.d()) {
            this.e.g(this.a, this.b);
        } else {
            this.f.g(this.a, this.b);
            this.e.a(this.a);
        }
        c cVar3 = this.f;
        if (cVar3 != null) {
            cVar3.delete();
            this.f = null;
        }
    }

    public void n(String str) {
        oo ooVar = (oo) this.a.get(str);
        if (ooVar != null && ooVar.f() && ooVar.h()) {
            this.a.remove(str);
            int i = ooVar.a;
            boolean z = this.d.get(i);
            this.e.b(ooVar, z);
            SparseArray sparseArray = this.b;
            if (z) {
                sparseArray.remove(i);
                this.d.delete(i);
            } else {
                sparseArray.put(i, null);
                this.c.put(i, true);
            }
        }
    }

    public void p() {
        pw4 it = dj1.p(this.a.keySet()).iterator();
        while (it.hasNext()) {
            n((String) it.next());
        }
    }

    public void q() {
        this.e.e(this.a);
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            this.b.remove(this.c.keyAt(i));
        }
        this.c.clear();
        this.d.clear();
    }
}
