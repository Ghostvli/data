package defpackage;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.fongmi.android.tv.App;
import fi.iki.elonen.NanoHTTPD;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.BiConsumer;
import java.util.function.LongConsumer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ge3 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String a(t41 t41Var) {
        StringJoiner stringJoiner = new StringJoiner(", ");
        String str = t41Var.k;
        if (str != null) {
            stringJoiner.add(str);
        }
        if (t41Var.w > 0 && t41Var.x > 0) {
            stringJoiner.add(t41Var.w + "x" + t41Var.x);
        }
        if (t41Var.A > 0.0f) {
            stringJoiner.add(String.format(Locale.getDefault(), "%.2ffps", Float.valueOf(t41Var.A)));
        }
        int i = t41Var.h;
        if (i > 0) {
            int i2 = t41Var.h;
            if (i >= 1000) {
                stringJoiner.add((i2 / 1000) + "kbps");
            } else {
                stringJoiner.add(i2 + "bps");
            }
        }
        if (t41Var.H > 0) {
            stringJoiner.add(t41Var.H + "ch");
        }
        if (t41Var.I > 0) {
            stringJoiner.add((t41Var.I / 1000) + "kHz");
        }
        String str2 = t41Var.b;
        if (str2 != null && !str2.isEmpty()) {
            stringJoiner.add(t41Var.b);
        }
        return stringJoiner.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Intent b(Intent intent) {
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : App.b().getPackageManager().queryIntentActivities(intent, 65536)) {
            String str = resolveInfo.activityInfo.packageName;
            if (str.equals(App.b().getPackageName())) {
                arrayList.add(new ComponentName(str, resolveInfo.activityInfo.name));
            }
        }
        return Intent.createChooser(intent, null).putExtra("android.intent.extra.EXCLUDE_COMPONENTS", (Parcelable[]) arrayList.toArray(new ComponentName[0]));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String c() {
        return fy4.E0(App.b(), "com.sggc.fongmi.mobile");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String d(String str) {
        return TextUtils.isEmpty(str) ? "" : str.endsWith(".vtt") ? "text/vtt" : (str.endsWith(".ssa") || str.endsWith(".ass")) ? "text/x-ssa" : (str.endsWith(".ttml") || str.endsWith(".xml") || str.endsWith(".dfxp")) ? "application/ttml+xml" : "application/x-subrip";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void e(Intent intent, Runnable runnable, LongConsumer longConsumer) {
        if (intent != null) {
            try {
                if (intent.getExtras() == null) {
                    return;
                }
                long j = intent.getExtras().getInt("position", 0);
                String string = intent.getExtras().getString("end_by", "");
                if ("playback_completion".equals(string)) {
                    App.d(runnable);
                }
                if ("user".equals(string)) {
                    longConsumer.accept(j);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void f(Activity activity, String str, Map map, CharSequence charSequence) {
        if (str != null) {
            try {
                if (str.isEmpty()) {
                    return;
                }
                Bundle bundleG = g(map);
                Intent intent = new Intent("android.intent.action.SEND");
                intent.addFlags(268435456);
                intent.putExtra("android.intent.extra.TEXT", str);
                intent.putExtra("extra_headers", bundleG);
                intent.putExtra("title", charSequence).putExtra("name", charSequence);
                intent.setType(NanoHTTPD.MIME_PLAINTEXT);
                activity.startActivity(b(intent));
            } catch (Exception unused) {
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Bundle g(Map map) {
        final Bundle bundle = new Bundle();
        map.forEach(new BiConsumer() { // from class: fe3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                bundle.putString((String) obj, (String) obj2);
            }
        });
        return bundle;
    }
}
