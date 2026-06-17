package defpackage;

import android.app.Notification;
import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class d43 {
    public final String a;
    public CharSequence b;
    public int c;
    public String d;
    public String e;
    public boolean i;
    public boolean k;
    public long[] l;
    public String m;
    public String n;
    public boolean f = true;
    public Uri g = Settings.System.DEFAULT_NOTIFICATION_URI;
    public int j = 0;
    public AudioAttributes h = Notification.AUDIO_ATTRIBUTES_DEFAULT;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public static NotificationChannel a(String str, CharSequence charSequence, int i) {
            return new NotificationChannel(str, charSequence, i);
        }

        public static void b(NotificationChannel notificationChannel, boolean z) {
            notificationChannel.enableLights(z);
        }

        public static void c(NotificationChannel notificationChannel, boolean z) {
            notificationChannel.enableVibration(z);
        }

        public static void d(NotificationChannel notificationChannel, String str) {
            notificationChannel.setDescription(str);
        }

        public static void e(NotificationChannel notificationChannel, String str) {
            notificationChannel.setGroup(str);
        }

        public static void f(NotificationChannel notificationChannel, int i) {
            notificationChannel.setLightColor(i);
        }

        public static void g(NotificationChannel notificationChannel, boolean z) {
            notificationChannel.setShowBadge(z);
        }

        public static void h(NotificationChannel notificationChannel, Uri uri, AudioAttributes audioAttributes) {
            notificationChannel.setSound(uri, audioAttributes);
        }

        public static void i(NotificationChannel notificationChannel, long[] jArr) {
            notificationChannel.setVibrationPattern(jArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public static void a(NotificationChannel notificationChannel, String str, String str2) {
            notificationChannel.setConversationId(str, str2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c {
        public final d43 a;

        public c(String str, int i) {
            this.a = new d43(str, i);
        }

        public d43 a() {
            return this.a;
        }

        public c b(CharSequence charSequence) {
            this.a.b = charSequence;
            return this;
        }
    }

    public d43(String str, int i) {
        this.a = (String) hg3.g(str);
        this.c = i;
    }

    public NotificationChannel a() {
        String str;
        String str2;
        int i = Build.VERSION.SDK_INT;
        if (i < 26) {
            return null;
        }
        NotificationChannel notificationChannelA = a.a(this.a, this.b, this.c);
        a.d(notificationChannelA, this.d);
        a.e(notificationChannelA, this.e);
        a.g(notificationChannelA, this.f);
        a.h(notificationChannelA, this.g, this.h);
        a.b(notificationChannelA, this.i);
        a.f(notificationChannelA, this.j);
        a.i(notificationChannelA, this.l);
        a.c(notificationChannelA, this.k);
        if (i >= 30 && (str = this.m) != null && (str2 = this.n) != null) {
            b.a(notificationChannelA, str, str2);
        }
        return notificationChannelA;
    }
}
