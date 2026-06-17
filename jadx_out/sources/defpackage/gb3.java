package defpackage;

import android.net.Uri;
import defpackage.aa0;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class gb3 implements aa0 {
    public static final gb3 a = new gb3();
    public static final aa0.a b = new aa0.a() { // from class: fb3
        @Override // aa0.a
        public final aa0 b() {
            return gb3.h();
        }
    };

    public static /* synthetic */ gb3 h() {
        return new gb3();
    }

    @Override // defpackage.aa0
    public long a(ja0 ja0Var) throws IOException {
        throw new IOException("PlaceholderDataSource cannot be opened");
    }

    @Override // defpackage.aa0
    public void close() {
    }

    @Override // defpackage.aa0
    public void f(hs4 hs4Var) {
    }

    @Override // defpackage.aa0
    public Uri getUri() {
        return null;
    }

    @Override // defpackage.x90
    public int read(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException();
    }
}
