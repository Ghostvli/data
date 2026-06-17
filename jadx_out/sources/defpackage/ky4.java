package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.forcetech.service.P2PService;
import com.forcetech.service.P3PService;
import com.gsoft.mitv.MainActivity;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ky4 {
    public static int a = 9002;
    public static int b = 9906;
    public static int c = 9907;

    public static Class a(String str) {
        str.getClass();
        return !str.equals("p2p") ? !str.equals("p3p") ? MainActivity.class : P3PService.class : P2PService.class;
    }

    public static Intent b(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) a(str));
        intent.putExtra("scheme", str);
        return intent;
    }

    public static int c(String str) {
        str.getClass();
        return !str.equals("p2p") ? !str.equals("p3p") ? a : c : b;
    }

    public static String d(String str) {
        String scheme = Uri.parse(str).getScheme();
        if ("P2p".equals(scheme)) {
            scheme = "mitv";
        }
        return scheme.toLowerCase();
    }

    public static String e(ComponentName componentName) {
        String className = componentName.getClassName();
        return className.substring(className.lastIndexOf(".") + 1).replace("Service", "").replace("MainActivity", "mitv").toLowerCase();
    }
}
