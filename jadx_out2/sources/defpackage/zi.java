package defpackage;

import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zi implements kr {
    public oa3 a;
    public kr b;
    public qy0 c;
    public x41 d;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public zi(oa3 oa3Var) {
        oa3Var.getClass();
        this.a = oa3Var;
        this.c = new qy0(oa3Var, this);
        this.d = new x41(this.a, this);
        this.c = new qy0(this.a, this);
        this.d = new x41(this.a, this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.kr
    public void b() {
        fw4 fw4Var;
        kr krVar = this.b;
        if (krVar != null) {
            krVar.request();
            fw4Var = fw4.a;
        } else {
            fw4Var = null;
        }
        if (fw4Var == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.a.m);
            arrayList.addAll(this.a.n);
            arrayList.addAll(this.a.k);
            if (this.a.s()) {
                if (ua3.d(this.a.b(), "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                    this.a.l.add("android.permission.ACCESS_BACKGROUND_LOCATION");
                } else {
                    arrayList.add("android.permission.ACCESS_BACKGROUND_LOCATION");
                }
            }
            if (this.a.x() && this.a.e() >= 23) {
                if (Settings.canDrawOverlays(this.a.b())) {
                    this.a.l.add("android.permission.SYSTEM_ALERT_WINDOW");
                } else {
                    arrayList.add("android.permission.SYSTEM_ALERT_WINDOW");
                }
            }
            if (this.a.y() && this.a.e() >= 23) {
                if (Settings.System.canWrite(this.a.b())) {
                    this.a.l.add("android.permission.WRITE_SETTINGS");
                } else {
                    arrayList.add("android.permission.WRITE_SETTINGS");
                }
            }
            if (this.a.v()) {
                if (Build.VERSION.SDK_INT < 30 || !Environment.isExternalStorageManager()) {
                    arrayList.add("android.permission.MANAGE_EXTERNAL_STORAGE");
                } else {
                    this.a.l.add("android.permission.MANAGE_EXTERNAL_STORAGE");
                }
            }
            if (this.a.u()) {
                if (Build.VERSION.SDK_INT < 26 || this.a.e() < 26 || !this.a.b().getPackageManager().canRequestPackageInstalls()) {
                    arrayList.add("android.permission.REQUEST_INSTALL_PACKAGES");
                } else {
                    this.a.l.add("android.permission.REQUEST_INSTALL_PACKAGES");
                }
            }
            if (this.a.w()) {
                if (ua3.a(this.a.b())) {
                    this.a.l.add("android.permission.POST_NOTIFICATIONS");
                } else {
                    arrayList.add("android.permission.POST_NOTIFICATIONS");
                }
            }
            if (this.a.t()) {
                if (ua3.d(this.a.b(), "android.permission.BODY_SENSORS_BACKGROUND")) {
                    this.a.l.add("android.permission.BODY_SENSORS_BACKGROUND");
                } else {
                    arrayList.add("android.permission.BODY_SENSORS_BACKGROUND");
                }
            }
            cr3 cr3Var = this.a.r;
            if (cr3Var != null) {
                cr3Var.getClass();
                cr3Var.c(arrayList.isEmpty(), new ArrayList(this.a.l), arrayList);
            }
            this.a.a();
        }
    }
}
