package androidx.media3.session;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import defpackage.e43;
import defpackage.gg3;
import defpackage.xi1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class s {
    public final int a;
    public final Notification b;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        e43.a a(u uVar, IconCompat iconCompat, CharSequence charSequence, int i);

        PendingIntent b(u uVar);

        e43.a c(u uVar, androidx.media3.session.a aVar);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public interface a {
            void a(s sVar);
        }

        /* JADX INFO: renamed from: androidx.media3.session.s$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static class C0033b {
            public final String a;
            public final String b;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public C0033b(String str, String str2) {
                this.a = str;
                this.b = str2;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public String a() {
                return this.a;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public String b() {
                return this.b;
            }
        }

        boolean a(u uVar, String str, Bundle bundle);

        C0033b b();

        s c(u uVar, xi1 xi1Var, a aVar, a aVar2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public s(int i, Notification notification) {
        this.a = i;
        this.b = (Notification) gg3.q(notification);
    }
}
