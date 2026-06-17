package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class r83 extends IOException {
    public final boolean f;
    public final int g;

    public r83(String str, Throwable th, boolean z, int i) {
        super(str, th);
        this.f = z;
        this.g = i;
    }

    public static r83 a(String str, Throwable th) {
        return new r83(str, th, true, 1);
    }

    public static r83 b(String str, Throwable th) {
        return new r83(str, th, true, 0);
    }

    public static r83 c(String str, Throwable th) {
        return new r83(str, th, true, 4);
    }

    public static r83 d(String str, Throwable th) {
        return new r83(str, th, false, 4);
    }

    public static r83 e(String str) {
        return new r83(str, null, false, 1);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        StringBuilder sb = new StringBuilder();
        sb.append(message != null ? message.concat(" ") : "");
        sb.append("{contentIsMalformed=");
        sb.append(this.f);
        sb.append(", dataType=");
        sb.append(this.g);
        sb.append("}");
        return sb.toString();
    }
}
