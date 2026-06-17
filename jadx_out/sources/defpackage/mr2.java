package defpackage;

import android.app.Notification;
import android.app.PendingIntent;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class mr2 {
    public static Notification.MediaStyle a(Notification.MediaStyle mediaStyle, CharSequence charSequence, int i, PendingIntent pendingIntent) {
        mediaStyle.setRemotePlaybackInfo(charSequence, i, pendingIntent);
        return mediaStyle;
    }
}
