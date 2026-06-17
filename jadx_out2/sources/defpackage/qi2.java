package defpackage;

import android.content.Context;
import android.media.session.MediaSession;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class qi2 {
    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0002: CONSTRUCTOR (r1v0 android.content.Context), (r2v0 java.lang.String), (r3v0 android.os.Bundle) A[MD:(android.content.Context, java.lang.String, android.os.Bundle):void (c)] (LINE:3) call: android.media.session.MediaSession.<init>(android.content.Context, java.lang.String, android.os.Bundle):void type: CONSTRUCTOR */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ MediaSession a(Context context, String str, Bundle bundle) {
        return new MediaSession(context, str, bundle);
    }
}
