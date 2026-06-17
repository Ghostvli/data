package defpackage;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.media3.session.v;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ec3 {
    public final Context a;
    public final int b;
    public final Class c;
    public final int d;
    public boolean e;
    public String f;
    public Bundle g;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ec3(Context context, int i, Class cls) {
        this.a = context;
        this.b = i;
        int iG = g(i);
        this.d = iG;
        gg3.d(c(iG));
        this.c = cls;
        this.e = false;
        this.f = null;
        this.g = Bundle.EMPTY;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Intent b(Context context, int i, Bundle bundle, String str, Class cls) {
        gg3.d(c(i));
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setData(v.X(str));
        intent.setComponent(new ComponentName(context, (Class<?>) cls));
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, i));
        return intent;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean c(int i) {
        return i == 87 || i == 88 || i == 86 || i == 90 || i == 89 || i == 85;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int g(int i) {
        if (i == 1) {
            return 85;
        }
        if (i == 3) {
            return 86;
        }
        if (i == 11) {
            return 89;
        }
        if (i == 12) {
            return 90;
        }
        switch (i) {
            case 6:
            case 7:
                return 88;
            case 8:
            case 9:
                return 87;
            default:
                return 0;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PendingIntent a() {
        if (Build.VERSION.SDK_INT >= 26 && this.e && this.b == 1) {
            Context context = this.a;
            int i = this.d;
            return PendingIntent.getForegroundService(context, i, b(context, i, this.g, this.f, this.c), 201326592);
        }
        Context context2 = this.a;
        int i2 = this.d;
        return PendingIntent.getService(context2, i2, b(context2, i2, this.g, this.f, this.c), 201326592);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ec3 d(Bundle bundle) {
        this.g = (Bundle) gg3.q(bundle);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ec3 e(String str) {
        this.f = str;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ec3 f(boolean z) {
        this.e = z;
        return this;
    }
}
