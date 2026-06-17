package defpackage;

import androidx.media3.session.l;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cc2 implements Runnable {
    public final /* synthetic */ l f;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [androidx.media3.session.n.M(androidx.media3.session.n):void, androidx.media3.session.n.b():void, androidx.media3.session.n.e.onBindingDied(android.content.ComponentName):void, androidx.media3.session.n.e.onServiceConnected(android.content.ComponentName, android.os.IBinder):void, androidx.media3.session.n.e.onServiceDisconnected(android.content.ComponentName):void] */
    public /* synthetic */ cc2(l lVar) {
        this.f = lVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.Runnable
    public final void run() {
        this.f.release();
    }
}
