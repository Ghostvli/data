package android.support.v4.media.session;

import android.os.Bundle;
import android.os.ResultReceiver;
import defpackage.w82;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
class MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver extends ResultReceiver {
    public WeakReference f;

    @Override // android.os.ResultReceiver
    public void onReceiveResult(int i, Bundle bundle) {
        w82.a(this.f.get());
    }
}
