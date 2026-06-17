package defpackage;

import android.webkit.CookieManager;
import com.fongmi.android.tv.App;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class w85 {
    public static final Set a = v85.a(new Object[]{"com.android.chrome", "com.mi.globalbrowser", "com.huawei.browser", "com.heytap.browser", "com.vivo.browser"});

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean a() {
        try {
            CookieManager.getInstance();
            return App.b().getPackageManager().hasSystemFeature("android.software.webview");
        } catch (Throwable unused) {
            return false;
        }
    }
}
