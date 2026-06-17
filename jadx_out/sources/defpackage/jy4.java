package defpackage;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.fongmi.android.tv.App;
import com.github.catvod.utils.Shell;
import defpackage.w95;
import java.net.NetworkInterface;
import java.util.Formatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class jy4 {
    public static final Pattern a = Pattern.compile("(?i)(?:ep|第|e|[\\-\\.\\s])\\s?(\\d{1,4})");

    public static String b(String str) {
        if (!str.contains("<")) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : Html.fromHtml(str, 0).toString().replace(" ", " ").replace("\u3000", " ").split("\\r?\\n")) {
            sb.append(str2.trim());
            sb.append("\n");
        }
        return s(sb.toString()).trim();
    }

    public static void c(String str) {
        try {
            ((ClipboardManager) App.b().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("", str));
            i43.h(sm3.e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String d(StringBuilder sb, Formatter formatter, long j) {
        try {
            return fy4.y0(sb, formatter, j);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String e() {
        try {
            String string = Settings.Secure.getString(App.b().getContentResolver(), "android_id");
            if (TextUtils.isEmpty(string)) {
                throw new NullPointerException();
            }
            return string;
        } catch (Exception unused) {
            return "0000000000000000";
        }
    }

    public static float f(Activity activity) {
        try {
            float f = activity.getWindow().getAttributes().screenBrightness;
            return (1.0f < f || f < 0.0f) ? Settings.System.getFloat(activity.getContentResolver(), "screen_brightness") / 255.0f : f;
        } catch (Exception unused) {
            return 0.5f;
        }
    }

    public static CharSequence g() {
        ClipboardManager clipboardManager = (ClipboardManager) App.b().getSystemService("clipboard");
        ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
        return (primaryClip == null || primaryClip.getItemCount() == 0) ? "" : primaryClip.getItemAt(0).getText();
    }

    public static String h() {
        String str = Build.MODEL;
        String str2 = Build.MANUFACTURER;
        if (str.startsWith(str2)) {
            return str;
        }
        return str2 + " " + str;
    }

    public static String i(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            NetworkInterface byName = NetworkInterface.getByName(str);
            if (byName.getHardwareAddress() == null) {
                return "";
            }
            for (byte b : byName.getHardwareAddress()) {
                sb.append(String.format("%02X:", Byte.valueOf(b)));
            }
            return s(sb.toString());
        } catch (Exception unused) {
            return "";
        }
    }

    public static int j(String str) {
        try {
            String strReplaceAll = str.replaceAll("\\[.*?\\]|\\(.*?\\)", "").replaceAll("\\b(19|20)\\d{2}\\b", "").toLowerCase().replaceAll("2160p|1080p|720p|480p|4k|h26[45]|x26[45]|mp4", "");
            Matcher matcher = a.matcher(strReplaceAll);
            if (matcher.find()) {
                return Integer.parseInt(matcher.group(1));
            }
            String strReplaceAll2 = strReplaceAll.replaceAll("\\D+", "");
            if (strReplaceAll2.isEmpty()) {
                return -1;
            }
            return Integer.parseInt(strReplaceAll2);
        } catch (Exception unused) {
            return -1;
        }
    }

    public static String k() {
        return Shell.exec("getprop ro.serialno").replace("\n", "");
    }

    public static void l(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) App.b().getSystemService("input_method");
        IBinder windowToken = view.getWindowToken();
        if (inputMethodManager == null || windowToken == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
    }

    public static void m(Activity activity) {
        n(activity.getWindow());
    }

    public static void n(Window window) {
        z95 z95VarA = p95.a(window, window.getDecorView());
        z95VarA.e(2);
        window.addFlags(1024);
        z95VarA.a(w95.n.e());
    }

    public static boolean o() {
        return false;
    }

    public static void p(final View view) {
        final InputMethodManager inputMethodManager;
        if (view.requestFocus() && (inputMethodManager = (InputMethodManager) App.b().getSystemService("input_method")) != null) {
            view.postDelayed(new Runnable() { // from class: zx4
                @Override // java.lang.Runnable
                public final void run() {
                    inputMethodManager.showSoftInput(view, 1);
                }
            }, 250L);
        }
    }

    public static void q(Activity activity) {
        r(activity.getWindow());
    }

    public static void r(Window window) {
        p95.a(window, window.getDecorView()).f(w95.n.e());
        window.clearFlags(1024);
    }

    public static String s(String str) {
        return t(str, 1);
    }

    public static String t(String str, int i) {
        return (str == null || str.length() <= i) ? str : str.substring(0, str.length() - i);
    }

    public static String u(long j) {
        StringBuilder sb = new StringBuilder();
        return d(sb, new Formatter(sb, Locale.getDefault()), j);
    }

    public static void v(Activity activity, boolean z) {
        if (z) {
            m(activity);
        } else {
            q(activity);
        }
    }
}
