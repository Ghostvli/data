package pl.droidsonroids.gif;

import defpackage.w91;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class GifIOException extends IOException {
    public final w91 f;
    public final String g;

    public GifIOException(int i, String str) {
        this.f = w91.b(i);
        this.g = str;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String str = this.g;
        w91 w91Var = this.f;
        if (str == null) {
            return w91Var.e();
        }
        return w91Var.e() + ": " + this.g;
    }
}
