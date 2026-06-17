package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class gj4 implements lw3 {
    public final hj4 f;

    public gj4(hj4 hj4Var) {
        hj4Var.getClass();
        this.f = hj4Var;
    }

    public final hj4 a() {
        return this.f;
    }

    @Override // defpackage.lw3
    public ow3 a0(String str) {
        str.getClass();
        if (this.f.isOpen()) {
            return mj4.i.a(this.f, str);
        }
        kw3.b(21, "connection is closed");
        mx3.a();
        return null;
    }

    @Override // defpackage.lw3, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f.close();
    }

    @Override // defpackage.lw3
    public boolean f() {
        return this.f.f();
    }
}
