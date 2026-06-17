package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ga0 extends IOException {
    public final int f;

    public ga0(int i) {
        this.f = i;
    }

    public ga0(Throwable th, int i) {
        super(th);
        this.f = i;
    }

    public ga0(String str, int i) {
        super(str);
        this.f = i;
    }

    public ga0(String str, Throwable th, int i) {
        super(str, th);
        this.f = i;
    }
}
