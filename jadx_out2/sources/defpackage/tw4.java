package defpackage;

import android.net.Uri;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class tw4 extends r83 {
    public final Uri h;
    public final xi1 i;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public tw4(String str, Uri uri, List list) {
        super(str, null, false, 1);
        this.h = uri;
        this.i = xi1.p(list);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.r83, java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        if (this.i.isEmpty()) {
            return message;
        }
        return message + "\nsniff failures: " + this.i;
    }
}
