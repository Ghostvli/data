package defpackage;

import android.net.Uri;
import android.os.SystemClock;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.ui.activity.VideoActivity;
import defpackage.db4;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class yi3 implements db4.a {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // db4.a
    public void a() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // db4.a
    public boolean b(Uri uri) {
        return "push".equals(qx4.i(uri));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // db4.a
    public String c(String str) {
        if (App.a() != null) {
            VideoActivity.l8(App.a(), str.substring(7));
        }
        SystemClock.sleep(500L);
        return "";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // db4.a
    public void stop() {
    }
}
