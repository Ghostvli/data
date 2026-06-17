package com.gsoft.mitv;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.anymediacloud.iptv.standard.ForceTV;
import com.github.catvod.utils.Asset;
import com.github.catvod.utils.Path;
import defpackage.gz1;
import defpackage.ky4;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class MainActivity extends Service {
    public ForceTV f;
    public IBinder g;

    public MainActivity() {
        try {
            a();
            System.loadLibrary("mitv");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private native void loadLibrary(int i);

    public final void a() {
        File fileCache = Path.cache("libmitv.so");
        if (fileCache.exists()) {
            return;
        }
        Path.copy(Asset.open("libmitv.so"), fileCache);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        ForceTV forceTV = new ForceTV();
        this.f = forceTV;
        forceTV.a(ky4.a);
        return this.g;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            this.g = new gz1();
            loadLibrary(1);
        } catch (Throwable unused) {
        }
    }

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
