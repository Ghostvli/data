package defpackage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f95 {
    public static final Pattern a = Pattern.compile("^NOTE([ \t].*)?$");

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Matcher a(r73 r73Var) {
        String strB;
        while (true) {
            String strB2 = r73Var.B();
            if (strB2 == null) {
                return null;
            }
            if (a.matcher(strB2).matches()) {
                do {
                    strB = r73Var.B();
                    if (strB != null) {
                    }
                } while (!strB.isEmpty());
            } else {
                Matcher matcher = b95.a.matcher(strB2);
                if (matcher.matches()) {
                    return matcher;
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean b(r73 r73Var) {
        String strB = r73Var.B();
        return strB != null && strB.startsWith("WEBVTT");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static float c(String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long d(String str) {
        String[] strArrH1 = fy4.H1(str, "\\.");
        long j = 0;
        for (String str2 : fy4.G1(strArrH1[0], ":")) {
            j = (j * 60) + Long.parseLong(str2);
        }
        long j2 = j * 1000;
        if (strArrH1.length == 2) {
            String strTrim = strArrH1[1].trim();
            if (strTrim.length() != 3) {
                jl.a("Expected 3 decimal places, got: ".concat(strTrim));
                return 0L;
            }
            j2 += Long.parseLong(strTrim);
        }
        return j2 * 1000;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void e(r73 r73Var) {
        int iG = r73Var.g();
        if (b(r73Var)) {
            return;
        }
        r73Var.f0(iG);
        throw r83.a("Expected WEBVTT. Got " + r73Var.B(), null);
    }
}
