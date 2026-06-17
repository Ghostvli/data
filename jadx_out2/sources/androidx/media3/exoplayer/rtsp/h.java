package androidx.media3.exoplayer.rtsp;

import android.net.Uri;
import androidx.media3.exoplayer.rtsp.e;
import defpackage.d04;
import defpackage.fy4;
import defpackage.gg3;
import defpackage.gg4;
import defpackage.pw4;
import defpackage.r83;
import defpackage.wn1;
import defpackage.wv3;
import defpackage.xi1;
import defpackage.xv3;
import defpackage.yi1;
import defpackage.z20;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h {
    public static final Pattern a = Pattern.compile("([A-Z_]+) (.*) RTSP/1\\.0");
    public static final Pattern b = Pattern.compile("RTSP/1\\.0 (\\d+) (.+)");
    public static final Pattern c = Pattern.compile("Content-Length:\\s?(\\d+)", 2);
    public static final Pattern d = Pattern.compile("([\\w$\\-_.+]+)(?:;\\s?timeout=(\\d+))?");
    public static final Pattern e = Pattern.compile("Digest realm=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\",\\s?(?:domain=\"(.+)\",\\s?)?nonce=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\"(?:,\\s?opaque=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\")?");
    public static final Pattern f = Pattern.compile("Basic realm=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\"");
    public static final String g = new String(new byte[]{10});
    public static final String h = new String(new byte[]{13, 10});

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final String a;
        public final String b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final String a;
        public final long b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(String str, long j) {
            this.a = str;
            this.b = j;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void a(boolean z, String str) throws r83 {
        if (!z) {
            throw r83.c(str, null);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static byte[] b(List list) {
        return wn1.h(h).e(list).getBytes(g.l);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String c(int i) {
        if (i == 200) {
            return "OK";
        }
        if (i == 461) {
            return "Unsupported Transport";
        }
        if (i == 500) {
            return "Internal Server Error";
        }
        if (i == 505) {
            return "RTSP Version Not Supported";
        }
        if (i == 301) {
            return "Move Permanently";
        }
        if (i == 302) {
            return "Move Temporarily";
        }
        if (i == 400) {
            return "Bad Request";
        }
        if (i == 401) {
            return "Unauthorized";
        }
        if (i == 404) {
            return "Not Found";
        }
        if (i == 405) {
            return "Method Not Allowed";
        }
        switch (i) {
            case 454:
                return "Session Not Found";
            case 455:
                return "Method Not Valid In This State";
            case 456:
                return "Header Field Not Valid";
            case 457:
                return "Invalid Range";
            default:
                d04.a();
                return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static byte[] d(String str) {
        return str.getBytes(g.l);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean e(List list) {
        return b.matcher((CharSequence) list.get(0)).matches();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean f(String str) {
        return a.matcher(str).matches() || b.matcher(str).matches();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long g(String str) throws r83 {
        try {
            Matcher matcher = c.matcher(str);
            if (matcher.find()) {
                return Long.parseLong((String) gg3.q(matcher.group(1)));
            }
            return -1L;
        } catch (NumberFormatException e2) {
            throw r83.c(str, e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int h(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            throw r83.c(str, e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int i(String str) {
        str.getClass();
        switch (str) {
            case "RECORD":
                return 8;
            case "TEARDOWN":
                return 12;
            case "GET_PARAMETER":
                return 3;
            case "OPTIONS":
                return 4;
            case "PLAY_NOTIFY":
                return 7;
            case "PLAY":
                return 6;
            case "REDIRECT":
                return 9;
            case "SET_PARAMETER":
                return 11;
            case "PAUSE":
                return 5;
            case "SETUP":
                return 10;
            case "ANNOUNCE":
                return 1;
            case "DESCRIBE":
                return 2;
            default:
                return 0;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static xi1 j(String str) {
        if (str == null) {
            return xi1.u();
        }
        xi1.a aVar = new xi1.a();
        for (String str2 : fy4.G1(str, ",\\s?")) {
            int i = i(str2);
            if (i != 0) {
                aVar.a(Integer.valueOf(i));
            }
        }
        return aVar.k();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static wv3 k(List list) {
        Matcher matcher = a.matcher((CharSequence) list.get(0));
        gg3.d(matcher.matches());
        int i = i((String) gg3.q(matcher.group(1)));
        Uri uri = Uri.parse((String) gg3.q(matcher.group(2)));
        int iIndexOf = list.indexOf("");
        gg3.d(iIndexOf > 0);
        return new wv3(uri, i, new e.b().c(list.subList(1, iIndexOf)).e(), wn1.h(h).e(list.subList(iIndexOf + 1, list.size())));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static xv3 l(List list) {
        Matcher matcher = b.matcher((CharSequence) list.get(0));
        gg3.d(matcher.matches());
        int i = Integer.parseInt((String) gg3.q(matcher.group(1)));
        int iIndexOf = list.indexOf("");
        gg3.d(iIndexOf > 0);
        return new xv3(i, new e.b().c(list.subList(1, iIndexOf)).e(), wn1.h(h).e(list.subList(iIndexOf + 1, list.size())));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static b m(String str) throws r83 {
        long j;
        Matcher matcher = d.matcher(str);
        if (!matcher.matches()) {
            throw r83.c(str, null);
        }
        String str2 = (String) gg3.q(matcher.group(1));
        String strGroup = matcher.group(2);
        if (strGroup != null) {
            try {
                j = ((long) Integer.parseInt(strGroup)) * 1000;
            } catch (NumberFormatException e2) {
                throw r83.c(str, e2);
            }
        } else {
            j = RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS;
        }
        return new b(str2, j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static a n(Uri uri) {
        String userInfo = uri.getUserInfo();
        if (userInfo == null || !userInfo.contains(":")) {
            return null;
        }
        String[] strArrH1 = fy4.H1(userInfo, ":");
        return new a(strArrH1[0], strArrH1[1]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static c o(String str) throws r83 {
        Matcher matcher = e.matcher(str);
        if (matcher.find()) {
            return new c(2, (String) gg3.q(matcher.group(1)), (String) gg3.q(matcher.group(3)), gg4.d(matcher.group(4)));
        }
        Matcher matcher2 = f.matcher(str);
        if (matcher2.matches()) {
            return new c(1, (String) gg3.q(matcher2.group(1)), "", "");
        }
        throw r83.c("Invalid WWW-Authenticate header " + str, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Uri p(Uri uri) {
        if (uri.getUserInfo() == null) {
            return uri;
        }
        String str = (String) gg3.q(uri.getEncodedAuthority());
        gg3.d(str.contains("@"));
        return uri.buildUpon().encodedAuthority(fy4.G1(str, "@")[1]).build();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static xi1 q(wv3 wv3Var) {
        gg3.d(wv3Var.c.d("CSeq") != null);
        xi1.a aVar = new xi1.a();
        aVar.a(fy4.M("%s %s %s", t(wv3Var.b), wv3Var.a, "RTSP/1.0"));
        yi1 yi1VarB = wv3Var.c.b();
        pw4 it = yi1VarB.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            xi1 xi1Var = yi1VarB.get(str);
            for (int i = 0; i < xi1Var.size(); i++) {
                aVar.a(fy4.M("%s: %s", str, xi1Var.get(i)));
            }
        }
        aVar.a("");
        aVar.a(wv3Var.d);
        return aVar.k();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static xi1 r(xv3 xv3Var) {
        gg3.d(xv3Var.b.d("CSeq") != null);
        xi1.a aVar = new xi1.a();
        aVar.a(fy4.M("%s %s %s", "RTSP/1.0", Integer.valueOf(xv3Var.a), c(xv3Var.a)));
        yi1 yi1VarB = xv3Var.b.b();
        pw4 it = yi1VarB.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            xi1 xi1Var = yi1VarB.get(str);
            for (int i = 0; i < xi1Var.size(); i++) {
                aVar.a(fy4.M("%s: %s", str, xi1Var.get(i)));
            }
        }
        aVar.a("");
        aVar.a(xv3Var.c);
        return aVar.k();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String[] s(String str) {
        String str2 = h;
        if (!str.contains(str2)) {
            str2 = g;
        }
        return fy4.G1(str, str2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String t(int i) {
        switch (i) {
            case 1:
                return "ANNOUNCE";
            case 2:
                return "DESCRIBE";
            case 3:
                return "GET_PARAMETER";
            case 4:
                return "OPTIONS";
            case 5:
                return "PAUSE";
            case 6:
                return "PLAY";
            case 7:
                return "PLAY_NOTIFY";
            case 8:
                return "RECORD";
            case 9:
                return "REDIRECT";
            case 10:
                return "SETUP";
            case 11:
                return "SET_PARAMETER";
            case 12:
                return "TEARDOWN";
            default:
                z20.a();
                return null;
        }
    }
}
