package defpackage;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.media3.session.v;
import java.util.concurrent.ThreadLocalRandom;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class d60 {
    public final Context a;
    public final Class b;
    public final y14 c;
    public String d;

    public d60(Context context, Class cls, y14 y14Var) {
        gg3.d(y14Var.a == 0);
        this.a = context;
        this.b = cls;
        this.c = y14Var;
        this.d = null;
    }

    public static Intent b(Context context, y14 y14Var, String str, Class cls) {
        gg3.d(y14Var.a == 0);
        Intent intent = new Intent("androidx.media3.session.CUSTOM_NOTIFICATION_ACTION");
        intent.setData(v.X(str));
        intent.setComponent(new ComponentName(context, (Class<?>) cls));
        intent.putExtra("androidx.media3.session.EXTRAS_KEY_CUSTOM_NOTIFICATION_ACTION", y14Var.b);
        intent.putExtra("androidx.media3.session.EXTRAS_KEY_CUSTOM_NOTIFICATION_ACTION_EXTRAS", y14Var.c);
        return intent;
    }

    public PendingIntent a() {
        return PendingIntent.getService(this.a, ThreadLocalRandom.current().nextInt(), b(this.a, this.c, this.d, this.b), 201326592);
    }

    public d60 c(String str) {
        this.d = str;
        return this;
    }
}
