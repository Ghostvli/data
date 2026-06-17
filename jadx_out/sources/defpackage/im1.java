package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class im1 implements Serializable {
    public final String f;
    public final jm1 g;
    public boolean h;

    public im1(String str, jm1 jm1Var) {
        this.f = str;
        this.g = jm1Var;
    }

    public String a() {
        return this.f;
    }

    public boolean b() {
        return this.h;
    }

    public jm1 c() {
        return this.g;
    }

    public void d(boolean z) {
        this.h = z;
    }
}
