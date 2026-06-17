package defpackage;

import android.app.PendingIntent;
import android.app.RemoteAction;
import android.graphics.drawable.Icon;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class za3 {
    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0002: CONSTRUCTOR 
      (r1v0 android.graphics.drawable.Icon)
      (r2v0 java.lang.CharSequence)
      (r3v0 java.lang.CharSequence)
      (r4v0 android.app.PendingIntent)
     A[MD:(android.graphics.drawable.Icon, java.lang.CharSequence, java.lang.CharSequence, android.app.PendingIntent):void (c)] (LINE:3) call: android.app.RemoteAction.<init>(android.graphics.drawable.Icon, java.lang.CharSequence, java.lang.CharSequence, android.app.PendingIntent):void type: CONSTRUCTOR */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ RemoteAction a(Icon icon, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent) {
        return new RemoteAction(icon, charSequence, charSequence2, pendingIntent);
    }
}
