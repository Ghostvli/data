package defpackage;

import android.database.sqlite.SQLiteStatement;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class k81 extends j81 implements nj4 {
    public final SQLiteStatement g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k81(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        sQLiteStatement.getClass();
        this.g = sQLiteStatement;
    }

    @Override // defpackage.nj4
    public void execute() {
        this.g.execute();
    }
}
