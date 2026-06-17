package defpackage;

import com.fongmi.android.tv.ui.activity.LiveActivity;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class lv1 implements Runnable {
    public final /* synthetic */ LiveActivity f;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.fongmi.android.tv.ui.activity.LiveActivity.L1(android.os.Bundle):void, com.fongmi.android.tv.ui.activity.LiveActivity.z0():void] */
    public /* synthetic */ lv1(LiveActivity liveActivity) {
        this.f = liveActivity;
    }

    /* JADX DEBUG: Class process forced to load method for inline: com.fongmi.android.tv.ui.activity.LiveActivity.o3(com.fongmi.android.tv.ui.activity.LiveActivity):void */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.Runnable
    public final void run() {
        this.f.h4();
    }
}
