package defpackage;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.session.MediaSessionManager;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class fm2 {
    public static final Object b = new Object();
    public static volatile fm2 c;
    public a a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public Context a;
        public ContentResolver b;

        public a(Context context) {
            this.a = context;
            this.b = context.getContentResolver();
        }

        public final boolean a(c cVar) {
            return this.a.checkPermission("android.permission.MEDIA_CONTENT_CONTROL", cVar.c(), cVar.a()) == 0;
        }

        public boolean b(c cVar) {
            String string = Settings.Secure.getString(this.b, "enabled_notification_listeners");
            if (string != null) {
                for (String str : string.split(":")) {
                    ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                    if (componentNameUnflattenFromString != null && componentNameUnflattenFromString.getPackageName().equals(cVar.b())) {
                        return true;
                    }
                }
            }
            return false;
        }

        public final boolean c(c cVar, String str) {
            int iC = cVar.c();
            Context context = this.a;
            return iC < 0 ? context.getPackageManager().checkPermission(str, cVar.b()) == 0 : context.checkPermission(str, cVar.c(), cVar.a()) == 0;
        }

        public boolean d(c cVar) {
            if (a(cVar)) {
                return true;
            }
            try {
                if (this.a.getPackageManager().getApplicationInfo(cVar.b(), 0) == null) {
                    return false;
                }
                return c(cVar, "android.permission.STATUS_BAR_SERVICE") || c(cVar, "android.permission.MEDIA_CONTENT_CONTROL") || cVar.a() == 1000 || cVar.a() == Process.myUid() || b(cVar);
            } catch (PackageManager.NameNotFoundException unused) {
                xz1.b("MediaSessionManager", "Package " + cVar.b() + " doesn't exist");
                return false;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface c {
        int a();

        String b();

        int c();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class e implements c {
        public final String a;
        public final int b;
        public final int c;

        public e(String str, int i, int i2) {
            this.a = str;
            this.b = i;
            this.c = i2;
        }

        @Override // fm2.c
        public int a() {
            return this.c;
        }

        @Override // fm2.c
        public String b() {
            return this.a;
        }

        @Override // fm2.c
        public int c() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return (this.b < 0 || eVar.b < 0) ? TextUtils.equals(this.a, eVar.a) && this.c == eVar.c : TextUtils.equals(this.a, eVar.a) && this.b == eVar.b && this.c == eVar.c;
        }

        public int hashCode() {
            return u43.b(this.a, Integer.valueOf(this.c));
        }
    }

    public fm2(Context context) {
        this.a = new a(context);
    }

    public static fm2 a(Context context) {
        fm2 fm2Var;
        synchronized (b) {
            try {
                if (c == null) {
                    c = new fm2(context.getApplicationContext());
                }
                fm2Var = c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fm2Var;
    }

    public boolean b(b bVar) {
        return this.a.d(bVar.a);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d extends e {
        public d(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            super(remoteUserInfo.getPackageName(), remoteUserInfo.getPid(), remoteUserInfo.getUid());
        }

        public static String d(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            return remoteUserInfo.getPackageName();
        }

        public d(String str, int i, int i2) {
            super(str, i, i2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public c a;

        public b(String str, int i, int i2) {
            if (str == null) {
                om1.a("package shouldn't be null");
                throw null;
            }
            if (TextUtils.isEmpty(str)) {
                jl.a("packageName should be nonempty");
                throw null;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                this.a = new d(str, i, i2);
            } else {
                this.a = new e(str, i, i2);
            }
        }

        public String a() {
            return this.a.b();
        }

        public int b() {
            return this.a.c();
        }

        public int c() {
            return this.a.a();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return this.a.equals(((b) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public b(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            String strD = d.d(remoteUserInfo);
            if (strD != null) {
                if (!TextUtils.isEmpty(strD)) {
                    this.a = new d(remoteUserInfo);
                    return;
                } else {
                    jl.a("packageName should be nonempty");
                    throw null;
                }
            }
            om1.a("package shouldn't be null");
            throw null;
        }
    }
}
