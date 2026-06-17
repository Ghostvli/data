package defpackage;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Build;
import android.os.Bundle;
import androidx.media3.session.u;
import defpackage.e43;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class nr2 extends e43.d {
    public final u e;
    public int[] f;
    public CharSequence g;
    public int h;
    public PendingIntent i;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public nr2(u uVar) {
        this.e = uVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // e43.d
    public void b(c43 c43Var) {
        CharSequence charSequence;
        Notification.MediaStyle mediaSession = new Notification.MediaStyle().setMediaSession(this.e.l());
        int[] iArr = this.f;
        if (iArr != null) {
            mediaSession.setShowActionsInCompactView(iArr);
        }
        if (Build.VERSION.SDK_INT >= 34 && (charSequence = this.g) != null) {
            mr2.a(mediaSession, charSequence, this.h, this.i);
            c43Var.a().setStyle(mediaSession);
        } else {
            c43Var.a().setStyle(mediaSession);
            Bundle bundle = new Bundle();
            bundle.putBundle("androidx.media3.session", this.e.p().m());
            c43Var.a().addExtras(bundle);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public nr2 h(int... iArr) {
        this.f = iArr;
        return this;
    }
}
