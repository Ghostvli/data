package androidx.media3.session;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.media3.session.s;
import defpackage.d60;
import defpackage.e43;
import defpackage.ec3;
import defpackage.gg3;
import defpackage.y14;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements s.a {
    public final x a;

    public d(x xVar) {
        this.a = xVar;
    }

    public static KeyEvent g(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null || !extras.containsKey("android.intent.extra.KEY_EVENT")) {
            return null;
        }
        return (KeyEvent) extras.getParcelable("android.intent.extra.KEY_EVENT");
    }

    @Override // androidx.media3.session.s.a
    public e43.a a(u uVar, IconCompat iconCompat, CharSequence charSequence, int i) {
        return new e43.a(iconCompat, charSequence, d(uVar, i));
    }

    @Override // androidx.media3.session.s.a
    public PendingIntent b(u uVar) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("androidx.media3.session.NOTIFICATION_DISMISSED_EVENT_KEY", true);
        x xVar = this.a;
        return new ec3(xVar, 3, xVar.getClass()).e(uVar.g()).d(bundle).a();
    }

    @Override // androidx.media3.session.s.a
    public e43.a c(u uVar, a aVar) {
        y14 y14Var = aVar.a;
        gg3.d(y14Var != null && y14Var.a == 0);
        y14 y14Var2 = (y14) gg3.q(aVar.a);
        IconCompat iconCompatE = IconCompat.e(this.a, aVar.d);
        CharSequence charSequence = aVar.f;
        x xVar = this.a;
        return new e43.a(iconCompatE, charSequence, new d60(xVar, xVar.getClass(), y14Var2).c(uVar.g()).a());
    }

    public PendingIntent d(u uVar, int i) {
        x xVar = this.a;
        return new ec3(xVar, i, xVar.getClass()).f(!uVar.m().getPlayWhenReady()).e(uVar.g()).a();
    }

    public String e(Intent intent) {
        Bundle extras = intent.getExtras();
        Object obj = extras != null ? extras.get("androidx.media3.session.EXTRAS_KEY_CUSTOM_NOTIFICATION_ACTION") : null;
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public Bundle f(Intent intent) {
        Bundle extras = intent.getExtras();
        Object obj = extras != null ? extras.get("androidx.media3.session.EXTRAS_KEY_CUSTOM_NOTIFICATION_ACTION_EXTRAS") : null;
        return obj instanceof Bundle ? (Bundle) obj : Bundle.EMPTY;
    }

    public boolean h(Intent intent) {
        return "androidx.media3.session.CUSTOM_NOTIFICATION_ACTION".equals(intent.getAction());
    }

    public boolean i(Intent intent) {
        return "android.intent.action.MEDIA_BUTTON".equals(intent.getAction());
    }
}
