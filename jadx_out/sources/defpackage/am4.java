package defpackage;

import android.net.Uri;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class am4 implements aa0 {
    public final aa0 a;
    public final z90 b;
    public boolean c;
    public long d;

    public am4(aa0 aa0Var, z90 z90Var) {
        this.a = (aa0) gg3.q(aa0Var);
        this.b = (z90) gg3.q(z90Var);
    }

    @Override // defpackage.aa0
    public long a(ja0 ja0Var) {
        long jA = this.a.a(ja0Var);
        this.d = jA;
        if (jA == 0) {
            return 0L;
        }
        if (ja0Var.h == -1 && jA != -1) {
            ja0Var = ja0Var.f(0L, jA);
        }
        this.c = true;
        this.b.a(ja0Var);
        return this.d;
    }

    @Override // defpackage.aa0
    public void close() {
        try {
            this.a.close();
        } finally {
            if (this.c) {
                this.c = false;
                this.b.close();
            }
        }
    }

    @Override // defpackage.aa0
    public void f(hs4 hs4Var) {
        gg3.q(hs4Var);
        this.a.f(hs4Var);
    }

    @Override // defpackage.aa0
    public Uri getUri() {
        return this.a.getUri();
    }

    @Override // defpackage.aa0
    public Map o() {
        return this.a.o();
    }

    @Override // defpackage.x90
    public int read(byte[] bArr, int i, int i2) {
        if (this.d == 0) {
            return -1;
        }
        int i3 = this.a.read(bArr, i, i2);
        if (i3 > 0) {
            this.b.write(bArr, i, i3);
            long j = this.d;
            if (j != -1) {
                this.d = j - ((long) i3);
            }
        }
        return i3;
    }
}
