package defpackage;

import android.content.ClipData;
import android.view.ContentInfo;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class r20 {
    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0002: CONSTRUCTOR (r1v0 android.content.ClipData), (r2v0 int) A[MD:(android.content.ClipData, int):void (c)] (LINE:3) call: android.view.ContentInfo.Builder.<init>(android.content.ClipData, int):void type: CONSTRUCTOR */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ ContentInfo.Builder a(ClipData clipData, int i) {
        return new ContentInfo.Builder(clipData, i);
    }
}
