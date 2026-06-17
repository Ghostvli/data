package defpackage;

import androidx.media3.exoplayer.rtsp.h;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class yv3 {
    public static final yv3 c = new yv3(0, -9223372036854775807L);
    public static final Pattern d = Pattern.compile("npt[:=]([.\\d]+|now)\\s?-\\s?([.\\d]+)?");
    public final long a;
    public final long b;

    public yv3(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public static String b(long j) {
        return fy4.M("npt=%.3f-", Double.valueOf(j / 1000.0d));
    }

    public static yv3 d(String str) throws r83 {
        long j;
        Matcher matcher = d.matcher(str);
        h.a(matcher.matches(), str);
        String strGroup = matcher.group(1);
        h.a(strGroup != null, str);
        long j2 = ((String) fy4.l(strGroup)).equals("now") ? 0L : (long) (Float.parseFloat(strGroup) * 1000.0f);
        String strGroup2 = matcher.group(2);
        if (strGroup2 != null) {
            try {
                j = (long) (Float.parseFloat(strGroup2) * 1000.0f);
                h.a(j >= j2, str);
            } catch (NumberFormatException e) {
                throw r83.c(strGroup2, e);
            }
        } else {
            j = -9223372036854775807L;
        }
        return new yv3(j2, j);
    }

    public long a() {
        return this.b - this.a;
    }

    public boolean c() {
        return this.b == -9223372036854775807L;
    }
}
