package defpackage;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ne4 implements aa0 {
    public final aa0 a;
    public long b;
    public Uri c = Uri.EMPTY;
    public Map d = Collections.EMPTY_MAP;

    public ne4(aa0 aa0Var) {
        this.a = (aa0) gg3.q(aa0Var);
    }

    @Override // defpackage.aa0
    public long a(ja0 ja0Var) {
        this.c = ja0Var.a;
        this.d = Collections.EMPTY_MAP;
        try {
            return this.a.a(ja0Var);
        } finally {
            Uri uri = getUri();
            if (uri != null) {
                this.c = uri;
            }
            this.d = o();
        }
    }

    @Override // defpackage.aa0
    public void close() {
        this.a.close();
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

    public long h() {
        return this.b;
    }

    @Override // defpackage.aa0
    public Map o() {
        return this.a.o();
    }

    @Override // defpackage.x90
    public int read(byte[] bArr, int i, int i2) {
        int i3 = this.a.read(bArr, i, i2);
        if (i3 != -1) {
            this.b += (long) i3;
        }
        return i3;
    }

    public Uri t() {
        return this.c;
    }

    public Map u() {
        return this.d;
    }

    public void v() {
        this.b = 0L;
    }
}
