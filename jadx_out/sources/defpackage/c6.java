package defpackage;

import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class c6 implements eh1 {
    public InputStream a;

    public c6(InputStream inputStream) {
        this.a = inputStream;
    }

    public InputStream a() {
        return this.a;
    }

    @Override // defpackage.eh1
    public void release() {
        mh1.a(this.a);
        this.a = null;
    }
}
