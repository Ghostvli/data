package defpackage;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.forcetech.android.ForceTV;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zi3 extends Service {
    public ForceTV f;
    public IBinder g;

    public abstract int a();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        ForceTV forceTV = new ForceTV();
        this.f = forceTV;
        forceTV.a(intent.getStringExtra("scheme"), a());
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.g = new gz1();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        ForceTV forceTV = this.f;
        if (forceTV == null) {
            return false;
        }
        forceTV.stop();
        return false;
    }
}
