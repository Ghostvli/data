package defpackage;

import android.database.sqlite.SQLiteProgram;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class j81 implements kj4 {
    public final SQLiteProgram f;

    public j81(SQLiteProgram sQLiteProgram) {
        sQLiteProgram.getClass();
        this.f = sQLiteProgram;
    }

    @Override // defpackage.kj4
    public void C(int i, byte[] bArr) {
        bArr.getClass();
        this.f.bindBlob(i, bArr);
    }

    @Override // defpackage.kj4
    public void b(int i, double d) {
        this.f.bindDouble(i, d);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f.close();
    }

    @Override // defpackage.kj4
    public void d(int i, long j) {
        this.f.bindLong(i, j);
    }

    @Override // defpackage.kj4
    public void e(int i) {
        this.f.bindNull(i);
    }

    @Override // defpackage.kj4
    public void g() {
        this.f.clearBindings();
    }

    @Override // defpackage.kj4
    public void p(int i, String str) {
        str.getClass();
        this.f.bindString(i, str);
    }
}
