package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.g;
import androidx.media3.session.x;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class e24 {
    public static final String b;
    public static final String c;
    public final a a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        int a();

        String b();

        ComponentName c();

        Object d();

        String e();

        boolean f();

        int g();

        Bundle getExtras();

        int getType();

        Bundle h();

        MediaSession.Token i();
    }

    static {
        kg2.a("media3.session");
        b = fy4.N0(0);
        c = fy4.N0(1);
    }

    public e24(Context context, ComponentName componentName) {
        int i;
        gg3.r(context, "context must not be null");
        gg3.r(componentName, "serviceComponent must not be null");
        PackageManager packageManager = context.getPackageManager();
        int iJ = j(packageManager, componentName.getPackageName());
        if (k(packageManager, MediaLibraryService.SERVICE_INTERFACE, componentName)) {
            i = 2;
        } else if (k(packageManager, x.SERVICE_INTERFACE, componentName)) {
            i = 1;
        } else {
            if (!k(packageManager, "android.media.browse.MediaBrowserService", componentName)) {
                f02.a("Failed to resolve SessionToken for ", componentName, ". Manifest doesn't declare one of either MediaSessionService, MediaLibraryService, MediaBrowserService or MediaBrowserServiceCompat. Use service's full name.");
                throw null;
            }
            i = 101;
        }
        if (i != 101) {
            this.a = new f24(componentName, iJ, i);
        } else {
            this.a = new g24(componentName, iJ);
        }
    }

    public static int j(PackageManager packageManager, String str) {
        try {
            return packageManager.getApplicationInfo(str, 0).uid;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    public static boolean k(PackageManager packageManager, String str, ComponentName componentName) {
        ServiceInfo serviceInfo;
        Intent intent = new Intent(str);
        intent.setPackage(componentName.getPackageName());
        List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 128);
        if (listQueryIntentServices != null) {
            for (int i = 0; i < listQueryIntentServices.size(); i++) {
                ResolveInfo resolveInfo = listQueryIntentServices.get(i);
                if (resolveInfo != null && (serviceInfo = resolveInfo.serviceInfo) != null && TextUtils.equals(serviceInfo.name, componentName.getClassName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public Object a() {
        return this.a.d();
    }

    public ComponentName b() {
        return this.a.c();
    }

    public Bundle c() {
        return this.a.getExtras();
    }

    public int d() {
        return this.a.g();
    }

    public String e() {
        return this.a.b();
    }

    public boolean equals(Object obj) {
        if (obj instanceof e24) {
            return this.a.equals(((e24) obj).a);
        }
        return false;
    }

    public MediaSession.Token f() {
        return this.a.i();
    }

    public String g() {
        return this.a.e();
    }

    public int h() {
        return this.a.getType();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public int i() {
        return this.a.a();
    }

    public boolean l() {
        return this.a.f();
    }

    public Bundle m() {
        Bundle bundle = new Bundle();
        if (this.a instanceof f24) {
            bundle.putInt(b, 0);
        } else {
            bundle.putInt(b, 1);
        }
        bundle.putBundle(c, this.a.h());
        return bundle;
    }

    public String toString() {
        return this.a.toString();
    }

    public e24(int i, int i2, int i3, int i4, String str, g gVar, Bundle bundle, MediaSession.Token token) {
        this.a = new f24(i, i2, i3, i4, str, gVar, bundle, token);
    }
}
