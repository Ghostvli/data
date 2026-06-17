package defpackage;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.hardware.display.DisplayManager;
import android.media.AudioFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.Display;
import android.view.WindowManager;
import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.hd3;
import defpackage.t41;
import j$.util.DesugarTimeZone;
import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.ws.RealWebSocket;
import org.jupnp.model.ServiceReference;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Token;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class fy4 {
    public static final int a;
    public static final String b;
    public static final String c;
    public static final String d;
    public static final String e;
    public static final byte[] f;
    public static final long[] g;
    public static final Pattern h;
    public static final Pattern i;
    public static final Pattern j;
    public static final Pattern k;
    public static HashMap l;
    public static final String[] m;
    public static final String[] n;
    public static final int[] o;
    public static final int[] p;
    public static final int[] q;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public static void b(Service service, boolean z) {
            service.stopForeground(z ? 1 : 2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public static void b(NotificationManager notificationManager, String str, String str2) {
            NotificationChannel notificationChannelA = gy4.a(str, str2, 2);
            if (Build.VERSION.SDK_INT <= 27) {
                notificationChannelA.setShowBadge(false);
            }
            notificationManager.createNotificationChannel(notificationChannelA);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c {
        public static void a(Service service, int i, Notification notification, int i2, String str) {
            try {
                service.startForeground(i, notification, i2);
            } catch (RuntimeException e) {
                xz1.d("Util", "The service must be declared with a foregroundServiceType that includes " + str);
                throw e;
            }
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        a = i2;
        String str = Build.DEVICE;
        b = str;
        String str2 = Build.MANUFACTURER;
        c = str2;
        String str3 = Build.MODEL;
        d = str3;
        e = str + ", " + str3 + ", " + str2 + ", " + i2;
        f = new byte[0];
        g = new long[0];
        h = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt ](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)?))?");
        i = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        j = Pattern.compile("%([A-Fa-f0-9]{2})");
        k = Pattern.compile("(?:.*\\.)?isml?(?:/(manifest(.*))?)?", 2);
        m = new String[]{"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", Name.MARK, "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "arb", "ar-arb", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
        n = new String[]{"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
        o = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
        p = new int[]{0, 4129, 8258, 12387, 16516, 20645, 24774, 28903, 33032, 37161, 41290, 45419, 49548, 53677, 57806, 61935};
        q = new int[]{0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, Token.ASSIGN_MOD, Token.INC, 126, Token.DOT, Token.ASSIGN_ADD, Token.ASSIGN_URSH, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, 231, 238, 233, 252, 251, 242, 245, 216, 223, 214, 209, 196, 195, 202, 205, Token.LABEL, Token.TYPEOFNAME, Token.COLONCOLON, Token.SETPROP_OP, 140, Token.VOID, 130, Token.BREAK, Token.CONST, Token.COMMENT, Token.SET, Token.XMLATTR, 180, Token.YIELD_STAR, Token.QUESTION_DOT, 189, 199, 192, 201, 206, 219, 220, 213, 210, 255, 248, 241, 246, 227, 228, 237, 234, Token.TAGGED_TEMPLATE_LITERAL, Token.GENEXPR, Token.NULLISH_COALESCING, 190, Token.ARRAYCOMP, Token.LETEXPR, Token.GET, Token.XMLEND, Token.BLOCK, Token.WITH, Token.DEFAULT, Token.CONTINUE, Token.EXPR_VOID, Token.EXPR_RESULT, Token.DOTDOT, Token.SETELEM_OP, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, Token.ASSIGN_DIV, Token.ASSIGN_LOGICAL_AND, 97, 102, Token.HOOK, Token.COLON, Token.IF, Token.FUNCTION, Token.CATCH, Token.COMPUTED_PROPERTY, Token.VAR, 128, Token.JSR, Token.LOOP, Token.LOCAL_BLOCK, Token.SET_REF_OP, Token.METHOD, Token.TEMPLATE_LITERAL_SUBST, 191, Token.DOTDOTDOT, Token.WITHEXPR, 170, Token.TO_OBJECT, Token.TO_DOUBLE, 249, 254, 247, 240, 229, 226, 235, 236, 193, 198, 207, 200, 221, 218, 211, 212, Token.ASSIGN_LSH, 110, 103, 96, Token.OR, 114, Token.EXPORT, Token.IMPORT, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, Token.AND, Token.ASSIGN_EXP, 120, 127, Token.ASSIGN_RSH, Token.ASSIGN_SUB, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, Token.DEBUGGER, Token.SETCONST, 160, Token.LET, Token.ARROW, Token.TEMPLATE_CHARS, 188, Token.LAST_TOKEN, 150, Token.TARGET, Token.USE_STACK, Token.XML, Token.FINALLY, Token.EMPTY, Token.FOR, Token.DO, 222, 217, 208, 215, 194, 197, 204, 203, 230, 225, 232, 239, Context.VERSION_ECMASCRIPT, 253, 244, 243};
    }

    public static int A(int i2, int i3) {
        int i4 = (i2 ^ ((i3 >> 12) & 255)) & 255;
        return (p[i4] ^ ((i3 << 4) & Settings.DEFAULT_INITIAL_WINDOW_SIZE)) & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
    }

    public static String[] A0() {
        return B0(Resources.getSystem().getConfiguration());
    }

    public static void A1(long[] jArr, long j2, long j3, RoundingMode roundingMode) {
        if (j2 == 0) {
            Arrays.fill(jArr, 0L);
            return;
        }
        int i2 = 0;
        if (j3 >= j2 && j3 % j2 == 0) {
            long jB = v02.b(j3, j2, RoundingMode.UNNECESSARY);
            while (i2 < jArr.length) {
                jArr[i2] = v02.b(jArr[i2], jB, roundingMode);
                i2++;
            }
            return;
        }
        if (j3 < j2 && j2 % j3 == 0) {
            long jB2 = v02.b(j2, j3, RoundingMode.UNNECESSARY);
            while (i2 < jArr.length) {
                jArr[i2] = v02.e(jArr[i2], jB2);
                i2++;
            }
            return;
        }
        for (int i3 = 0; i3 < jArr.length; i3++) {
            long j4 = jArr[i3];
            if (j4 != 0) {
                if (j3 >= j4 && j3 % j4 == 0) {
                    jArr[i3] = v02.b(j2, v02.b(j3, j4, RoundingMode.UNNECESSARY), roundingMode);
                } else if (j3 >= j4 || j4 % j3 != 0) {
                    jArr[i3] = y1(j4, j2, j3, roundingMode);
                } else {
                    jArr[i3] = v02.e(j2, v02.b(j4, j3, RoundingMode.UNNECESSARY));
                }
            }
        }
    }

    public static int B(byte[] bArr, int i2, int i3, int i4) {
        while (i2 < i3) {
            i4 = o[((i4 >>> 24) ^ (bArr[i2] & 255)) & 255] ^ (i4 << 8);
            i2++;
        }
        return i4;
    }

    public static String[] B0(Configuration configuration) {
        return G1(configuration.getLocales().toLanguageTags(), ",");
    }

    public static void B1(Service service, int i2, Notification notification, int i3, String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            c.a(service, i2, notification, i3, str);
        } else {
            service.startForeground(i2, notification);
        }
    }

    public static int C(byte[] bArr, int i2, int i3, int i4) {
        while (i2 < i3) {
            i4 = q[i4 ^ (bArr[i2] & 255)];
            i2++;
        }
        return i4;
    }

    public static String C0(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception e2) {
            xz1.e("Util", "Failed to read system property " + str, e2);
            return null;
        }
    }

    public static boolean C1(hd3 hd3Var) {
        if (hd3Var == null) {
            return false;
        }
        int playbackState = hd3Var.getPlaybackState();
        return (!hd3Var.isCommandAvailable(16) || hd3Var.getCurrentMediaItem() != null) && (hd3Var.isCommandAvailable(1) || (playbackState == 1 && hd3Var.isCommandAvailable(2)) || (playbackState == 4 && hd3Var.isCommandAvailable(4)));
    }

    public static Handler D(Looper looper, Handler.Callback callback) {
        return new Handler(looper, callback);
    }

    public static String D0(int i2) {
        switch (i2) {
            case -2:
                return "none";
            case -1:
                return "unknown";
            case 0:
                return "default";
            case 1:
                return "audio";
            case 2:
                return "video";
            case 3:
                return "text";
            case 4:
                return "image";
            case 5:
                return "metadata";
            case 6:
                return "camera motion";
            default:
                if (i2 < 10000) {
                    return "?";
                }
                return "custom (" + i2 + ")";
        }
    }

    public static boolean D1(hd3 hd3Var, boolean z) {
        return hd3Var == null || !hd3Var.getPlayWhenReady() || hd3Var.getPlaybackState() == 1 || hd3Var.getPlaybackState() == 4 || !(!z || hd3Var.getPlaybackSuppressionReason() == 0 || hd3Var.getPlaybackSuppressionReason() == 4);
    }

    public static Handler E() {
        return F(null);
    }

    public static String E0(android.content.Context context, String str) {
        String str2;
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "?";
        }
        return str + ServiceReference.DELIMITER + str2 + " (Linux;Android " + Build.VERSION.RELEASE + ") AndroidXMedia3/1.10.0";
    }

    public static void E1(Throwable th) throws Throwable {
        F1(th);
    }

    public static Handler F(Handler.Callback callback) {
        return D((Looper) gg3.q(Looper.myLooper()), callback);
    }

    public static byte[] F0(String str) {
        return str.getBytes(StandardCharsets.UTF_8);
    }

    public static void F1(Throwable th) throws Throwable {
        throw th;
    }

    public static Handler G() {
        return H(null);
    }

    public static boolean G0(hd3 hd3Var) {
        if (hd3Var == null || !hd3Var.isCommandAvailable(1)) {
            return false;
        }
        hd3Var.pause();
        return true;
    }

    public static String[] G1(String str, String str2) {
        return str.split(str2, -1);
    }

    public static Handler H(Handler.Callback callback) {
        return D(f0(), callback);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean H0(defpackage.hd3 r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            int r1 = r4.getPlaybackState()
            r2 = 1
            if (r1 != r2) goto L17
            r3 = 2
            boolean r3 = r4.isCommandAvailable(r3)
            if (r3 == 0) goto L17
            r4.prepare()
        L15:
            r0 = r2
            goto L24
        L17:
            r3 = 4
            if (r1 != r3) goto L24
            boolean r1 = r4.isCommandAvailable(r3)
            if (r1 == 0) goto L24
            r4.seekToDefaultPosition()
            goto L15
        L24:
            boolean r1 = r4.isCommandAvailable(r2)
            if (r1 == 0) goto L2e
            r4.play()
            return r2
        L2e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fy4.H0(hd3):boolean");
    }

    public static String[] H1(String str, String str2) {
        return str.split(str2, 2);
    }

    public static HashMap I() {
        String[] iSOLanguages = Locale.getISOLanguages();
        HashMap map = new HashMap(iSOLanguages.length + m.length);
        int i2 = 0;
        for (String str : iSOLanguages) {
            try {
                String iSO3Language = new Locale(str).getISO3Language();
                if (!TextUtils.isEmpty(iSO3Language)) {
                    map.put(iSO3Language, str);
                }
            } catch (MissingResourceException unused) {
            }
        }
        while (true) {
            String[] strArr = m;
            if (i2 >= strArr.length) {
                return map;
            }
            map.put(strArr[i2], strArr[i2 + 1]);
            i2 += 2;
        }
    }

    public static boolean I0(hd3 hd3Var, boolean z) {
        return D1(hd3Var, z) ? H0(hd3Var) : G0(hd3Var);
    }

    public static String[] I1(String str) {
        return TextUtils.isEmpty(str) ? new String[0] : G1(str.trim(), "(\\s*,\\s*)");
    }

    public static long J(long j2, int i2) {
        return x1(j2, i2, 1000000L, RoundingMode.UP);
    }

    public static int J0(Uri uri) {
        int iK0;
        String scheme = uri.getScheme();
        if (scheme != null && (xa.a("rtsp", scheme) || xa.a("rtspt", scheme))) {
            return 3;
        }
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return 4;
        }
        int iLastIndexOf = lastPathSegment.lastIndexOf(46);
        if (iLastIndexOf >= 0 && (iK0 = K0(lastPathSegment.substring(iLastIndexOf + 1))) != 4) {
            return iK0;
        }
        Matcher matcher = k.matcher((CharSequence) gg3.q(uri.getPath()));
        if (!matcher.matches()) {
            return 4;
        }
        String strGroup = matcher.group(2);
        if (strGroup != null) {
            if (strGroup.contains("format=mpd-time-csf")) {
                return 0;
            }
            if (strGroup.contains("format=m3u8-aapl")) {
                return 2;
            }
        }
        return 1;
    }

    public static void J1(Service service, boolean z) {
        a.b(service, z);
    }

    public static void K(NotificationManager notificationManager, String str, String str2) {
        if (Build.VERSION.SDK_INT < 26 || notificationManager.getNotificationChannel(str) != null) {
            return;
        }
        b.b(notificationManager, str, str2);
    }

    public static int K0(String str) {
        String strF = xa.f(str);
        strF.getClass();
        switch (strF) {
            case "ism":
            case "isml":
                return 1;
            case "mpd":
                return 0;
            case "m3u8":
                return 2;
            default:
                return 4;
        }
    }

    public static long K1(long j2, long j3, long j4) {
        long jF = v02.f(j2, j3);
        return ((jF != Long.MIN_VALUE || j2 - j3 == Long.MIN_VALUE) && (jF != Long.MAX_VALUE || j2 - j3 == Long.MAX_VALUE)) ? jF : j4;
    }

    public static Uri L(Uri uri) {
        String path = uri.getPath();
        if (path == null) {
            return uri;
        }
        Matcher matcher = k.matcher(path);
        return (matcher.matches() && matcher.group(1) == null) ? Uri.withAppendedPath(uri, "Manifest") : uri;
    }

    public static int L0(Uri uri, String str) {
        if (str == null) {
            return J0(uri);
        }
        switch (str) {
            case "application/x-mpegURL":
                return 2;
            case "application/vnd.ms-sstr+xml":
                return 1;
            case "application/dash+xml":
                return 0;
            case "application/x-rtsp":
                return 3;
            default:
                return 4;
        }
    }

    public static boolean L1(SQLiteDatabase sQLiteDatabase, String str) {
        return DatabaseUtils.queryNumEntries(sQLiteDatabase, "sqlite_master", "tbl_name = ?", new String[]{str}) > 0;
    }

    public static String M(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static boolean M0(r73 r73Var, r73 r73Var2, Inflater inflater) {
        if (r73Var.a() == 0) {
            return false;
        }
        if (r73Var2.b() < r73Var.a()) {
            r73Var2.d(r73Var.a() * 2);
        }
        if (inflater == null) {
            inflater = new Inflater();
        }
        inflater.setInput(r73Var.f(), r73Var.g(), r73Var.a());
        int iInflate = 0;
        while (true) {
            try {
                iInflate += inflater.inflate(r73Var2.f(), iInflate, r73Var2.b() - iInflate);
                if (!inflater.finished()) {
                    if (inflater.needsDictionary() || inflater.needsInput()) {
                        break;
                    }
                    if (iInflate == r73Var2.b()) {
                        r73Var2.d(r73Var2.b() * 2);
                    }
                } else {
                    r73Var2.e0(iInflate);
                    inflater.reset();
                    return true;
                }
            } catch (DataFormatException unused) {
                return false;
            } finally {
                inflater.reset();
            }
        }
        return false;
    }

    public static String M1(int i2) {
        return new String(ll1.o(i2), StandardCharsets.US_ASCII);
    }

    public static String N(byte[] bArr) {
        return new String(bArr, StandardCharsets.UTF_8);
    }

    public static String N0(int i2) {
        return Integer.toString(i2, 36);
    }

    public static String N1(byte[] bArr) {
        return sh.a().j().e(bArr);
    }

    public static String O(byte[] bArr, int i2, int i3) {
        return new String(bArr, i2, i3, StandardCharsets.UTF_8);
    }

    public static boolean O0(android.content.Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.automotive");
    }

    public static long O1(int i2, int i3) {
        return P1(i3) | (P1(i2) << 32);
    }

    public static int P(android.content.Context context) {
        int iGenerateAudioSessionId = tc.c(context).generateAudioSessionId();
        if (iGenerateAudioSessionId != -1) {
            return iGenerateAudioSessionId;
        }
        return 0;
    }

    public static boolean P0(String str) {
        str.getClass();
        switch (str) {
            case "image/avif":
                return Build.VERSION.SDK_INT >= 34;
            case "image/heic":
            case "image/heif":
                return Build.VERSION.SDK_INT >= 26;
            case "image/jpeg":
            case "image/webp":
            case "image/bmp":
            case "image/png":
                return true;
            default:
                return false;
        }
    }

    public static long P1(int i2) {
        return ((long) i2) & 4294967295L;
    }

    public static int Q(int i2) {
        switch (i2) {
            case 2:
            case 3:
                return 3;
            case 4:
            case 5:
            case 6:
                return 21;
            case 7:
            case 8:
                return 23;
            case 9:
            case 10:
            case 11:
            case 12:
            case 15:
            case 16:
            case 17:
            case 18:
                return 28;
            case 13:
            case 19:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            default:
                return Integer.MAX_VALUE;
            case 14:
                return 25;
            case 20:
                return 30;
            case 21:
            case 22:
                return 31;
            case 30:
            case 31:
                return 34;
        }
    }

    public static boolean Q0(int i2) {
        return i2 == 21 || i2 == 1342177280 || i2 == 22 || i2 == 1610612736 || i2 == 4 || i2 == 1879048192;
    }

    public static lu1 Q1(final lu1 lu1Var, final gb gbVar) {
        final p24 p24VarQ = p24.Q();
        p24VarQ.g(new Runnable() { // from class: ay4
            @Override // java.lang.Runnable
            public final void run() {
                fy4.b(p24VarQ, lu1Var);
            }
        }, du2.b());
        lu1Var.g(new Runnable() { // from class: by4
            @Override // java.lang.Runnable
            public final void run() {
                fy4.c(lu1Var, p24VarQ, gbVar);
            }
        }, du2.b());
        return p24VarQ;
    }

    public static AudioFormat R(int i2, int i3, int i4) {
        return new AudioFormat.Builder().setSampleRate(i2).setChannelMask(i3).setEncoding(i4).build();
    }

    public static boolean R0(int i2) {
        return i2 == 3 || i2 == 2 || i2 == 268435456 || i2 == 21 || i2 == 1342177280 || i2 == 22 || i2 == 1610612736 || i2 == 4 || i2 == 1879048192;
    }

    public static String R1(String str) {
        int length = str.length();
        int iEnd = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (str.charAt(i3) == '%') {
                i2++;
            }
        }
        if (i2 == 0) {
            return str;
        }
        int i4 = length - (i2 * 2);
        StringBuilder sb = new StringBuilder(i4);
        Matcher matcher = j.matcher(str);
        while (i2 > 0 && matcher.find()) {
            char c2 = (char) Integer.parseInt((String) gg3.q(matcher.group(1)), 16);
            sb.append((CharSequence) str, iEnd, matcher.start());
            sb.append(c2);
            iEnd = matcher.end();
            i2--;
        }
        if (iEnd < length) {
            sb.append((CharSequence) str, iEnd, length);
        }
        if (sb.length() != i4) {
            return null;
        }
        return sb.toString();
    }

    public static int S(int i2) {
        if (i2 == 10) {
            return Build.VERSION.SDK_INT >= 32 ? 737532 : 6396;
        }
        if (i2 == 16) {
            return Build.VERSION.SDK_INT >= 32 ? 205215996 : 0;
        }
        if (i2 == 24) {
            return Build.VERSION.SDK_INT >= 32 ? 67108860 : 0;
        }
        switch (i2) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            default:
                switch (i2) {
                    case 13:
                        if (Build.VERSION.SDK_INT >= 32) {
                        }
                        break;
                    case 14:
                        if (Build.VERSION.SDK_INT >= 32) {
                        }
                        break;
                }
                break;
        }
        return 0;
    }

    public static boolean S0(android.content.Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 29 || context.getApplicationInfo().targetSdkVersion < 29) {
            return true;
        }
        if (i2 == 30) {
            String str = Build.MODEL;
            if (xa.a(str, "moto g(20)") || xa.a(str, "rmx3231")) {
                return true;
            }
        }
        return i2 == 34 && xa.a(Build.MODEL, "sm-x200");
    }

    public static long S1(long j2) {
        return (j2 == -9223372036854775807L || j2 == Long.MIN_VALUE) ? j2 : j2 / 1000;
    }

    public static String T(int i2) {
        if (i2 == 0) {
            return "undefined";
        }
        if (i2 == 1) {
            return "original";
        }
        if (i2 == 2) {
            return "depth-linear";
        }
        if (i2 == 3) {
            return "depth-inverse";
        }
        if (i2 == 4) {
            return "depth metadata";
        }
        e04.a("Unsupported auxiliary track type");
        return null;
    }

    public static boolean T0(int i2) {
        return i2 == 10 || i2 == 13;
    }

    public static hd3.b U(hd3 hd3Var, hd3.b bVar) {
        boolean zIsPlayingAd = hd3Var.isPlayingAd();
        boolean zIsCurrentMediaItemSeekable = hd3Var.isCurrentMediaItemSeekable();
        boolean zHasPreviousMediaItem = hd3Var.hasPreviousMediaItem();
        boolean zHasNextMediaItem = hd3Var.hasNextMediaItem();
        boolean zIsCurrentMediaItemLive = hd3Var.isCurrentMediaItemLive();
        boolean zIsCurrentMediaItemDynamic = hd3Var.isCurrentMediaItemDynamic();
        boolean zW = hd3Var.getCurrentTimeline().w();
        boolean z = false;
        hd3.b.a aVarE = new hd3.b.a().b(bVar).e(4, !zIsPlayingAd).e(5, zIsCurrentMediaItemSeekable && !zIsPlayingAd).e(6, zHasPreviousMediaItem && !zIsPlayingAd).e(7, !zW && (zHasPreviousMediaItem || !zIsCurrentMediaItemLive || zIsCurrentMediaItemSeekable) && !zIsPlayingAd).e(8, zHasNextMediaItem && !zIsPlayingAd).e(9, !zW && (zHasNextMediaItem || (zIsCurrentMediaItemLive && zIsCurrentMediaItemDynamic)) && !zIsPlayingAd).e(10, !zIsPlayingAd).e(11, zIsCurrentMediaItemSeekable && !zIsPlayingAd);
        if (zIsCurrentMediaItemSeekable && !zIsPlayingAd) {
            z = true;
        }
        return aVarE.e(12, z).f();
    }

    public static boolean U0(Uri uri) {
        String scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) || Objects.equals(scheme, "file");
    }

    public static int V(ByteBuffer byteBuffer, int i2) {
        int i3 = byteBuffer.getInt(i2);
        return byteBuffer.order() == ByteOrder.BIG_ENDIAN ? i3 : Integer.reverseBytes(i3);
    }

    public static boolean V0() {
        String strF = xa.f(Build.DEVICE);
        return strF.contains("emulator") || strF.contains("emu64a") || strF.contains("emu64x") || strF.contains("generic");
    }

    public static int W(int i2) {
        if (i2 != 2) {
            if (i2 == 3) {
                return 1;
            }
            if (i2 != 4) {
                if (i2 != 21) {
                    if (i2 != 22) {
                        if (i2 != 268435456) {
                            if (i2 != 1342177280) {
                                if (i2 != 1610612736) {
                                    if (i2 == 1879048192) {
                                        return 8;
                                    }
                                    d04.a();
                                    return 0;
                                }
                            }
                        }
                    }
                }
                return 3;
            }
            return 4;
        }
        return 2;
    }

    public static boolean W0(android.content.Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public static byte[] X(String str) {
        return sh.a().i().b(str);
    }

    public static boolean X0(android.content.Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }

    public static int Y(String str, int i2) {
        int i3 = 0;
        for (String str2 : I1(str)) {
            if (i2 == nt2.m(str2)) {
                i3++;
            }
        }
        return i3;
    }

    public static int Y0(int[] iArr, int i2) {
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (iArr[i3] == i2) {
                return i3;
            }
        }
        return -1;
    }

    public static String Z(String str, int i2) {
        String[] strArrI1 = I1(str);
        if (strArrI1.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArrI1) {
            if (i2 == nt2.m(str2)) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    public static boolean Z0(r73 r73Var, r73 r73Var2, Inflater inflater) {
        return r73Var.a() > 0 && r73Var.q() == 120 && M0(r73Var, r73Var2, inflater);
    }

    public static /* synthetic */ void a(p24 p24Var, Runnable runnable, Object obj) {
        try {
            if (p24Var.isCancelled()) {
                return;
            }
            runnable.run();
            p24Var.M(obj);
        } catch (Throwable th) {
            p24Var.N(th);
        }
    }

    public static String a0(String str, int i2) {
        String[] strArrI1 = I1(str);
        if (strArrI1.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArrI1) {
            if (i2 != nt2.m(str2)) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    public static String a1(String str) {
        int i2 = 0;
        while (true) {
            String[] strArr = n;
            if (i2 >= strArr.length) {
                return str;
            }
            if (str.startsWith(strArr[i2])) {
                return strArr[i2 + 1] + str.substring(strArr[i2].length());
            }
            i2 += 2;
        }
    }

    public static /* synthetic */ void b(p24 p24Var, lu1 lu1Var) {
        if (p24Var.isCancelled()) {
            lu1Var.cancel(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0045 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.bx b0(java.lang.String r3, java.lang.String r4, java.lang.String r5) {
        /*
            r0 = 0
            if (r3 != 0) goto L4
            return r0
        L4:
            boolean r4 = defpackage.nt2.p(r3, r4)
            if (r4 != 0) goto Lb
            return r0
        Lb:
            java.lang.String r4 = "dvhe"
            boolean r4 = r3.startsWith(r4)
            r1 = -1
            r2 = 6
            if (r4 != 0) goto L41
            java.lang.String r4 = "dvh1"
            boolean r4 = r3.startsWith(r4)
            if (r4 != 0) goto L41
            java.lang.String r4 = "dav1"
            boolean r3 = r3.startsWith(r4)
            if (r3 == 0) goto L26
            goto L41
        L26:
            if (r5 == 0) goto L3d
            java.lang.String r3 = "db1p"
            boolean r3 = r5.equals(r3)
            r4 = 2
            if (r3 == 0) goto L33
        L31:
            r3 = r2
            goto L43
        L33:
            java.lang.String r3 = "db4"
            boolean r3 = r5.startsWith(r3)
            if (r3 == 0) goto L3d
            r3 = 7
            goto L43
        L3d:
            r3 = r1
            r4 = r3
            r2 = r4
            goto L43
        L41:
            r4 = 1
            goto L31
        L43:
            if (r2 != r1) goto L46
            return r0
        L46:
            bx$b r5 = new bx$b
            r5.<init>()
            bx$b r5 = r5.d(r2)
            bx$b r4 = r5.c(r4)
            bx$b r3 = r4.e(r3)
            bx r3 = r3.a()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fy4.b0(java.lang.String, java.lang.String, java.lang.String):bx");
    }

    public static void b1(List list, int i2, int i3, int i4) {
        ArrayDeque arrayDeque = new ArrayDeque();
        for (int i5 = (i3 - i2) - 1; i5 >= 0; i5--) {
            arrayDeque.addFirst(list.remove(i2 + i5));
        }
        list.addAll(Math.min(i4, list.size()), arrayDeque);
    }

    public static /* synthetic */ void c(lu1 lu1Var, p24 p24Var, gb gbVar) {
        try {
            try {
                p24Var.O(gbVar.apply(x81.c(lu1Var)));
            } catch (Throwable th) {
                p24Var.N(th);
            }
        } catch (Error e2) {
            e = e2;
            p24Var.N(e);
        } catch (CancellationException unused) {
            p24Var.cancel(false);
        } catch (RuntimeException e3) {
            e = e3;
            p24Var.N(e);
        } catch (ExecutionException e4) {
            e = e4;
            Throwable cause = e.getCause();
            if (cause != null) {
                e = cause;
            }
            p24Var.N(e);
        }
    }

    public static String c0(android.content.Context context) {
        TelephonyManager telephonyManager;
        if (context != null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!TextUtils.isEmpty(networkCountryIso)) {
                return xa.g(networkCountryIso);
            }
        }
        return xa.g(Locale.getDefault().getCountry());
    }

    public static long c1(long j2) {
        return (j2 == -9223372036854775807L || j2 == Long.MIN_VALUE) ? j2 : j2 * 1000;
    }

    public static /* synthetic */ Thread d(String str, Runnable runnable) {
        return new Thread(runnable, str);
    }

    public static Point d0(android.content.Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        Display display = displayManager != null ? displayManager.getDisplay(0) : null;
        if (display == null) {
            display = ((WindowManager) gg3.q((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
        }
        return e0(context, display);
    }

    public static ExecutorService d1(final String str) {
        return Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: cy4
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return fy4.e(str, runnable);
            }
        });
    }

    public static /* synthetic */ Thread e(String str, Runnable runnable) {
        return new Thread(runnable, str);
    }

    public static Point e0(android.content.Context context, Display display) {
        if (display.getDisplayId() == 0 && W0(context)) {
            String strC0 = Build.VERSION.SDK_INT < 28 ? C0("sys.display-size") : C0("vendor.display-size");
            if (!TextUtils.isEmpty(strC0)) {
                try {
                    String[] strArrG1 = G1(strC0.trim(), "x");
                    if (strArrG1.length == 2) {
                        int i2 = Integer.parseInt(strArrG1[0]);
                        int i3 = Integer.parseInt(strArrG1[1]);
                        if (i2 > 0 && i3 > 0) {
                            return new Point(i2, i3);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                xz1.d("Util", "Invalid display size: " + strC0);
            }
            if ("Sony".equals(Build.MANUFACTURER) && Build.MODEL.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(3840, 2160);
            }
        }
        Point point = new Point();
        h0(display, point);
        return point;
    }

    public static ScheduledExecutorService e1(final String str) {
        return Executors.newSingleThreadScheduledExecutor(new ThreadFactory() { // from class: dy4
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return fy4.d(str, runnable);
            }
        });
    }

    public static long f(long j2, long j3, long j4) {
        long jD = v02.d(j2, j3);
        return ((jD != Long.MIN_VALUE || j2 + j3 == Long.MIN_VALUE) && (jD != Long.MAX_VALUE || j2 + j3 == Long.MAX_VALUE)) ? jD : j4;
    }

    public static Looper f0() {
        Looper looperMyLooper = Looper.myLooper();
        return looperMyLooper != null ? looperMyLooper : Looper.getMainLooper();
    }

    public static String f1(String str) {
        if (str == null) {
            return null;
        }
        String strReplace = str.replace('_', '-');
        if (!strReplace.isEmpty() && !strReplace.equals("und")) {
            str = strReplace;
        }
        String strF = xa.f(str);
        String str2 = H1(strF, "-")[0];
        if (l == null) {
            l = I();
        }
        String str3 = (String) l.get(str2);
        if (str3 != null) {
            strF = str3.concat(strF.substring(str2.length()));
            str2 = str3;
        }
        return ("no".equals(str2) || "i".equals(str2) || "zh".equals(str2)) ? a1(strF) : strF;
    }

    public static int g(long[] jArr, long j2, boolean z, boolean z2) {
        int i2;
        int i3;
        int iBinarySearch = Arrays.binarySearch(jArr, j2);
        if (iBinarySearch < 0) {
            i3 = ~iBinarySearch;
        } else {
            while (true) {
                i2 = iBinarySearch + 1;
                if (i2 >= jArr.length || jArr[i2] != j2) {
                    break;
                }
                iBinarySearch = i2;
            }
            i3 = z ? iBinarySearch : i2;
        }
        return z2 ? Math.min(jArr.length - 1, i3) : i3;
    }

    public static Locale g0() {
        return Locale.getDefault(Locale.Category.DISPLAY);
    }

    public static Object[] g1(Object[] objArr, Object obj) {
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length + 1);
        objArrCopyOf[objArr.length] = obj;
        return m(objArrCopyOf);
    }

    public static int h(r02 r02Var, long j2, boolean z, boolean z2) {
        int i2;
        int iD = r02Var.d() - 1;
        int i3 = 0;
        while (i3 <= iD) {
            int i4 = (i3 + iD) >>> 1;
            if (r02Var.c(i4) < j2) {
                i3 = i4 + 1;
            } else {
                iD = i4 - 1;
            }
        }
        if (z && (i2 = iD + 1) < r02Var.d() && r02Var.c(i2) == j2) {
            return i2;
        }
        if (z2 && iD == -1) {
            return 0;
        }
        return iD;
    }

    public static void h0(Display display, Point point) {
        Display.Mode mode = display.getMode();
        point.x = mode.getPhysicalWidth();
        point.y = mode.getPhysicalHeight();
    }

    public static Object[] h1(Object[] objArr, Object[] objArr2) {
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length + objArr2.length);
        System.arraycopy(objArr2, 0, objArrCopyOf, objArr.length, objArr2.length);
        return objArrCopyOf;
    }

    public static int i(List list, Comparable comparable, boolean z, boolean z2) {
        int i2;
        int i3;
        int iBinarySearch = Collections.binarySearch(list, comparable);
        if (iBinarySearch < 0) {
            i3 = -(iBinarySearch + 2);
        } else {
            while (true) {
                i2 = iBinarySearch - 1;
                if (i2 < 0 || ((Comparable) list.get(i2)).compareTo(comparable) != 0) {
                    break;
                }
                iBinarySearch = i2;
            }
            i3 = z ? iBinarySearch : i2;
        }
        return z2 ? Math.max(0, i3) : i3;
    }

    public static Drawable i0(android.content.Context context, Resources resources, int i2) {
        return resources.getDrawable(i2, context.getTheme());
    }

    public static Object[] i1(Object[] objArr, int i2) {
        gg3.d(i2 <= objArr.length);
        return Arrays.copyOf(objArr, i2);
    }

    public static int j(int[] iArr, int i2, boolean z, boolean z2) {
        int i3;
        int i4;
        int iBinarySearch = Arrays.binarySearch(iArr, i2);
        if (iBinarySearch < 0) {
            i4 = -(iBinarySearch + 2);
        } else {
            while (true) {
                i3 = iBinarySearch - 1;
                if (i3 < 0 || iArr[i3] != i2) {
                    break;
                }
                iBinarySearch = i3;
            }
            i4 = z ? iBinarySearch : i3;
        }
        return z2 ? Math.max(0, i4) : i4;
    }

    public static int j0(int i2) {
        if (i2 == 2 || i2 == 4) {
            return 6005;
        }
        if (i2 == 10) {
            return 6004;
        }
        if (i2 == 7) {
            return 6005;
        }
        if (i2 == 8) {
            return 6003;
        }
        switch (i2) {
            case 15:
                return 6003;
            case 16:
            case 18:
                return 6005;
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
                return 6004;
            default:
                switch (i2) {
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                        return 6002;
                    default:
                        return 6006;
                }
        }
    }

    public static Object[] j1(Object[] objArr, int i2, int i3) {
        gg3.d(i2 >= 0);
        gg3.d(i3 <= objArr.length);
        return Arrays.copyOfRange(objArr, i2, i3);
    }

    public static int k(long[] jArr, long j2, boolean z, boolean z2) {
        int i2;
        int i3;
        int iBinarySearch = Arrays.binarySearch(jArr, j2);
        if (iBinarySearch < 0) {
            i3 = -(iBinarySearch + 2);
        } else {
            while (true) {
                i2 = iBinarySearch - 1;
                if (i2 < 0 || jArr[i2] != j2) {
                    break;
                }
                iBinarySearch = i2;
            }
            i3 = z ? iBinarySearch : i2;
        }
        return z2 ? Math.max(0, i3) : i3;
    }

    public static int k0(String str) {
        String[] strArrG1;
        int length;
        int i2 = 0;
        if (str == null || (length = (strArrG1 = G1(str, "_")).length) < 2) {
            return 0;
        }
        String str2 = strArrG1[length - 1];
        boolean z = length >= 3 && "neg".equals(strArrG1[length - 2]);
        try {
            i2 = Integer.parseInt((String) gg3.q(str2));
            if (z) {
                return -i2;
            }
        } catch (NumberFormatException unused) {
        }
        return i2;
    }

    public static void k1(List list, Object[] objArr) {
        gg3.v(list.size() == objArr.length);
        list.toArray(objArr);
    }

    public static Object l(Object obj) {
        return obj;
    }

    public static String l0(int i2) {
        if (i2 == 0) {
            return "NO";
        }
        if (i2 == 1) {
            return "NO_UNSUPPORTED_SUBTYPE";
        }
        if (i2 == 2) {
            return "NO_UNSUPPORTED_DRM";
        }
        if (i2 == 3) {
            return "NO_EXCEEDS_CAPABILITIES";
        }
        if (i2 == 4) {
            return "YES";
        }
        z20.a();
        return null;
    }

    public static long l1(String str) throws r83 {
        Matcher matcher = h.matcher(str);
        if (!matcher.matches()) {
            throw r83.a("Invalid date/time format: " + str, null);
        }
        int i2 = 0;
        if (matcher.group(9) != null && !matcher.group(9).equalsIgnoreCase("Z")) {
            int i3 = Integer.parseInt(matcher.group(12)) * 60;
            String strGroup = matcher.group(13);
            if (strGroup != null) {
                i3 += Integer.parseInt(strGroup);
            }
            i2 = i3;
            if ("-".equals(matcher.group(11))) {
                i2 *= -1;
            }
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(DesugarTimeZone.getTimeZone("GMT"));
        gregorianCalendar.clear();
        gregorianCalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
        if (!TextUtils.isEmpty(matcher.group(8))) {
            gregorianCalendar.set(14, new BigDecimal("0." + matcher.group(8)).movePointRight(3).intValue());
        }
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        return i2 != 0 ? timeInMillis - (((long) i2) * RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS) : timeInMillis;
    }

    public static Object[] m(Object[] objArr) {
        return objArr;
    }

    public static int m0(ByteBuffer byteBuffer, int i2) {
        ByteOrder byteOrderOrder = byteBuffer.order();
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        byte b2 = byteBuffer.get(byteOrderOrder == byteOrder ? i2 : i2 + 2);
        byte b3 = byteBuffer.get(i2 + 1);
        if (byteBuffer.order() == byteOrder) {
            i2 += 2;
        }
        return (((byteBuffer.get(i2) << 8) & 65280) | (((b2 << 24) & (-16777216)) | ((b3 << 16) & 16711680))) >> 8;
    }

    public static long m1(String str) {
        Matcher matcher = i.matcher(str);
        if (!matcher.matches()) {
            return (long) (Double.parseDouble(str) * 3600.0d * 1000.0d);
        }
        boolean zIsEmpty = TextUtils.isEmpty(matcher.group(1));
        String strGroup = matcher.group(3);
        double d2 = strGroup != null ? Double.parseDouble(strGroup) * 3.1556908E7d : 0.0d;
        String strGroup2 = matcher.group(5);
        double d3 = d2 + (strGroup2 != null ? Double.parseDouble(strGroup2) * 2629739.0d : 0.0d);
        String strGroup3 = matcher.group(7);
        double d4 = d3 + (strGroup3 != null ? Double.parseDouble(strGroup3) * 86400.0d : 0.0d);
        String strGroup4 = matcher.group(10);
        double d5 = d4 + (strGroup4 != null ? Double.parseDouble(strGroup4) * 3600.0d : 0.0d);
        String strGroup5 = matcher.group(12);
        double d6 = d5 + (strGroup5 != null ? Double.parseDouble(strGroup5) * 60.0d : 0.0d);
        String strGroup6 = matcher.group(14);
        long j2 = (long) ((d6 + (strGroup6 != null ? Double.parseDouble(strGroup6) : 0.0d)) * 1000.0d);
        return !zIsEmpty ? -j2 : j2;
    }

    public static int n(int i2, int i3) {
        return ((i2 + i3) - 1) / i3;
    }

    public static String n0(Locale locale) {
        return locale.toLanguageTag();
    }

    public static int n1(long j2, long j3) {
        long jE = v02.e(j2, 100L);
        return ll1.m((jE == Long.MAX_VALUE || jE == Long.MIN_VALUE) ? j2 / (j3 / 100) : jE / j3);
    }

    public static long o(long j2, long j3) {
        return ((j2 + j3) - 1) / j3;
    }

    public static int o0(android.content.Context context) {
        return S0(context) ? 1 : 5;
    }

    public static boolean o1(Handler handler, Runnable runnable) {
        Looper looper = handler.getLooper();
        if (!looper.getThread().isAlive()) {
            return false;
        }
        if (looper != Looper.myLooper()) {
            return handler.post(runnable);
        }
        runnable.run();
        return true;
    }

    public static void p(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static long p0(long j2, float f2) {
        return f2 == 1.0f ? j2 : Math.round(j2 * ((double) f2));
    }

    public static lu1 p1(Handler handler, final Runnable runnable, final Object obj) {
        final p24 p24VarQ = p24.Q();
        o1(handler, new Runnable() { // from class: ey4
            @Override // java.lang.Runnable
            public final void run() {
                fy4.a(p24VarQ, runnable, obj);
            }
        });
        return p24VarQ;
    }

    public static double q(double d2, double d3, double d4) {
        return Math.max(d3, Math.min(d2, d4));
    }

    public static long q0(long j2) {
        return j2 == -9223372036854775807L ? System.currentTimeMillis() : SystemClock.elapsedRealtime() + j2;
    }

    public static void q1(ByteBuffer byteBuffer, int i2) {
        gg3.k(((-16777216) & i2) == 0 || (i2 & (-8388608)) == -8388608, "Value out of range of 24-bit integer: %s", Integer.toHexString(i2));
        gg3.d(byteBuffer.remaining() >= 3);
        ByteOrder byteOrderOrder = byteBuffer.order();
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        byteBuffer.put((byte) (byteOrderOrder == byteOrder ? (i2 & 16711680) >> 16 : i2 & 255)).put((byte) ((65280 & i2) >> 8)).put((byte) (byteBuffer.order() == byteOrder ? i2 & 255 : (i2 & 16711680) >> 16));
    }

    public static float r(float f2, float f3, float f4) {
        return Math.max(f3, Math.min(f2, f4));
    }

    public static int r0(int i2) {
        return s0(i2, ByteOrder.LITTLE_ENDIAN);
    }

    public static Intent r1(android.content.Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return Build.VERSION.SDK_INT < 33 ? context.registerReceiver(broadcastReceiver, intentFilter) : context.registerReceiver(broadcastReceiver, intentFilter, 4);
    }

    public static int s(int i2, int i3, int i4) {
        return Math.max(i3, Math.min(i2, i4));
    }

    public static int s0(int i2, ByteOrder byteOrder) {
        if (i2 == 8) {
            return 3;
        }
        if (i2 == 16) {
            return byteOrder.equals(ByteOrder.LITTLE_ENDIAN) ? 2 : 268435456;
        }
        if (i2 == 24) {
            return byteOrder.equals(ByteOrder.LITTLE_ENDIAN) ? 21 : 1342177280;
        }
        if (i2 != 32) {
            return 0;
        }
        return byteOrder.equals(ByteOrder.LITTLE_ENDIAN) ? 22 : 1610612736;
    }

    public static void s1(List list, int i2, int i3) {
        if (i2 < 0 || i3 > list.size() || i2 > i3) {
            d04.a();
        } else if (i2 != i3) {
            list.subList(i2, i3).clear();
        }
    }

    public static long t(long j2, long j3, long j4) {
        return Math.max(j3, Math.min(j2, j4));
    }

    public static t41 t0(int i2, int i3, int i4) {
        return new t41.b().A0("audio/raw").U(i3).B0(i4).t0(i2).Q();
    }

    public static long t1(long j2, int i2) {
        return x1(j2, 1000000L, i2, RoundingMode.DOWN);
    }

    public static boolean u(SparseArray sparseArray, int i2) {
        return sparseArray.indexOfKey(i2) >= 0;
    }

    public static int u0(int i2, int i3) {
        return W(i2) * i3;
    }

    public static long u1(long j2, long j3, long j4) {
        return x1(j2, j3, j4, RoundingMode.DOWN);
    }

    public static boolean v(Object[] objArr, Object obj) {
        for (Object obj2 : objArr) {
            if (Objects.equals(obj2, obj)) {
                return true;
            }
        }
        return false;
    }

    public static long v0(long j2, float f2) {
        return f2 == 1.0f ? j2 : Math.round(j2 / ((double) f2));
    }

    public static long[] v1(List list, long j2, long j3) {
        return z1(list, j2, j3, RoundingMode.DOWN);
    }

    public static boolean w(SparseArray sparseArray, SparseArray sparseArray2) {
        if (sparseArray == null) {
            return sparseArray2 == null;
        }
        if (sparseArray2 == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return sparseArray.contentEquals(sparseArray2);
        }
        int size = sparseArray.size();
        if (size != sparseArray2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (!Objects.equals(sparseArray.valueAt(i2), sparseArray2.get(sparseArray.keyAt(i2)))) {
                return false;
            }
        }
        return true;
    }

    public static List w0(int i2) {
        ArrayList arrayList = new ArrayList();
        if ((i2 & 1) != 0) {
            arrayList.add("main");
        }
        if ((i2 & 2) != 0) {
            arrayList.add("alt");
        }
        if ((i2 & 4) != 0) {
            arrayList.add("supplementary");
        }
        if ((i2 & 8) != 0) {
            arrayList.add("commentary");
        }
        if ((i2 & 16) != 0) {
            arrayList.add("dub");
        }
        if ((i2 & 32) != 0) {
            arrayList.add("emergency");
        }
        if ((i2 & 64) != 0) {
            arrayList.add("caption");
        }
        if ((i2 & 128) != 0) {
            arrayList.add("subtitle");
        }
        if ((i2 & Buffer.DEFAULT_SIZE) != 0) {
            arrayList.add("sign");
        }
        if ((i2 & 512) != 0) {
            arrayList.add("describes-video");
        }
        if ((i2 & 1024) != 0) {
            arrayList.add("describes-music");
        }
        if ((i2 & 2048) != 0) {
            arrayList.add("enhanced-intelligibility");
        }
        if ((i2 & okio.internal.Buffer.SEGMENTING_THRESHOLD) != 0) {
            arrayList.add("transcribes-dialog");
        }
        if ((i2 & 8192) != 0) {
            arrayList.add("easy-read");
        }
        if ((i2 & Http2.INITIAL_MAX_FRAME_SIZE) != 0) {
            arrayList.add("trick-play");
        }
        if ((i2 & 32768) != 0) {
            arrayList.add("auxiliary");
        }
        return arrayList;
    }

    public static void w1(long[] jArr, long j2, long j3) {
        A1(jArr, j2, j3, RoundingMode.DOWN);
    }

    public static int x(SparseArray sparseArray) {
        if (Build.VERSION.SDK_INT >= 31) {
            return sparseArray.contentHashCode();
        }
        int iKeyAt = 17;
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            iKeyAt = (((iKeyAt * 31) + sparseArray.keyAt(i2)) * 31) + Objects.hashCode(sparseArray.valueAt(i2));
        }
        return iKeyAt;
    }

    public static List x0(int i2) {
        ArrayList arrayList = new ArrayList();
        if ((i2 & 4) != 0) {
            arrayList.add("auto");
        }
        if ((i2 & 1) != 0) {
            arrayList.add("default");
        }
        if ((i2 & 2) != 0) {
            arrayList.add("forced");
        }
        return arrayList;
    }

    public static long x1(long j2, long j3, long j4, RoundingMode roundingMode) {
        if (j2 == 0 || j3 == 0) {
            return 0L;
        }
        return (j4 < j3 || j4 % j3 != 0) ? (j4 >= j3 || j3 % j4 != 0) ? (j4 < j2 || j4 % j2 != 0) ? (j4 >= j2 || j2 % j4 != 0) ? y1(j2, j3, j4, roundingMode) : v02.e(j3, v02.b(j2, j4, RoundingMode.UNNECESSARY)) : v02.b(j3, v02.b(j4, j2, RoundingMode.UNNECESSARY), roundingMode) : v02.e(j2, v02.b(j3, j4, RoundingMode.UNNECESSARY)) : v02.b(j2, v02.b(j4, j3, RoundingMode.UNNECESSARY), roundingMode);
    }

    public static Bundle y(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader((ClassLoader) gg3.q(fy4.class.getClassLoader()));
        try {
            bundle.isEmpty();
            return bundle;
        } catch (RuntimeException e2) {
            xz1.e("Util", "Ignoring invalid bundle", e2);
            return null;
        }
    }

    public static String y0(StringBuilder sb, Formatter formatter, long j2) {
        if (j2 == -9223372036854775807L) {
            j2 = 0;
        }
        String str = j2 < 0 ? "-" : "";
        long jAbs = (Math.abs(j2) + 500) / 1000;
        long j3 = jAbs % 60;
        long j4 = (jAbs / 60) % 60;
        long j5 = jAbs / 3600;
        sb.setLength(0);
        return j5 > 0 ? formatter.format("%s%d:%02d:%02d", str, Long.valueOf(j5), Long.valueOf(j4), Long.valueOf(j3)).toString() : formatter.format("%s%02d:%02d", str, Long.valueOf(j4), Long.valueOf(j3)).toString();
    }

    public static long y1(long j2, long j3, long j4, RoundingMode roundingMode) {
        long jE = v02.e(j2, j3);
        if (jE != Long.MAX_VALUE && jE != Long.MIN_VALUE) {
            return v02.b(jE, j4, roundingMode);
        }
        long jC = v02.c(Math.abs(j3), Math.abs(j4));
        RoundingMode roundingMode2 = RoundingMode.UNNECESSARY;
        long jB = v02.b(j3, jC, roundingMode2);
        long jB2 = v02.b(j4, jC, roundingMode2);
        long jC2 = v02.c(Math.abs(j2), Math.abs(jB2));
        long jB3 = v02.b(j2, jC2, roundingMode2);
        long jB4 = v02.b(jB2, jC2, roundingMode2);
        long jE2 = v02.e(jB3, jB);
        if (jE2 != Long.MAX_VALUE && jE2 != Long.MIN_VALUE) {
            return v02.b(jE2, jB4, roundingMode);
        }
        double d2 = jB3 * (jB / jB4);
        if (d2 > 9.223372036854776E18d) {
            return Long.MAX_VALUE;
        }
        if (d2 < -9.223372036854776E18d) {
            return Long.MIN_VALUE;
        }
        return dn0.f(d2, roundingMode);
    }

    public static int z(byte[] bArr, int i2, int i3, int i4) {
        while (i2 < i3) {
            int iB = ww4.b(bArr[i2]);
            i4 = A(iB & 15, A(iB >> 4, i4));
            i2++;
        }
        return i4;
    }

    public static String[] z0() {
        String[] strArrA0 = A0();
        for (int i2 = 0; i2 < strArrA0.length; i2++) {
            strArrA0[i2] = f1(strArrA0[i2]);
        }
        return strArrA0;
    }

    public static long[] z1(List list, long j2, long j3, RoundingMode roundingMode) {
        long j4 = j2;
        long j5 = j3;
        RoundingMode roundingMode2 = roundingMode;
        int size = list.size();
        long[] jArr = new long[size];
        if (j4 != 0) {
            int i2 = 0;
            if (j5 >= j4 && j5 % j4 == 0) {
                long jB = v02.b(j5, j4, RoundingMode.UNNECESSARY);
                while (i2 < size) {
                    jArr[i2] = v02.b(((Long) list.get(i2)).longValue(), jB, roundingMode2);
                    i2++;
                }
            } else if (j5 >= j4 || j4 % j5 != 0) {
                int i3 = 0;
                while (i3 < size) {
                    long jLongValue = ((Long) list.get(i3)).longValue();
                    if (jLongValue != 0) {
                        if (j5 >= jLongValue && j5 % jLongValue == 0) {
                            jArr[i3] = v02.b(j4, v02.b(j5, jLongValue, RoundingMode.UNNECESSARY), roundingMode2);
                        } else if (j5 >= jLongValue || jLongValue % j5 != 0) {
                            jArr[i3] = y1(jLongValue, j4, j5, roundingMode2);
                        } else {
                            jArr[i3] = v02.e(j4, v02.b(jLongValue, j5, RoundingMode.UNNECESSARY));
                        }
                    }
                    i3++;
                    j4 = j2;
                    j5 = j3;
                    roundingMode2 = roundingMode;
                }
            } else {
                long jB2 = v02.b(j4, j5, RoundingMode.UNNECESSARY);
                while (i2 < size) {
                    jArr[i2] = v02.e(((Long) list.get(i2)).longValue(), jB2);
                    i2++;
                }
            }
        }
        return jArr;
    }
}
