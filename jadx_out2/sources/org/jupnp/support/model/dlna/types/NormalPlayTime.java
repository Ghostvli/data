package org.jupnp.support.model.dlna.types;

import defpackage.f80;
import defpackage.x33;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NormalPlayTime {
    private static final Pattern pattern = Pattern.compile("^(\\d+):(\\d{1,2}):(\\d{1,2})(\\.(\\d{1,3}))?|(\\d+)(\\.(\\d{1,3}))?$", 2);
    private long milliseconds;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum Format {
        SECONDS,
        TIME
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public NormalPlayTime(long j, long j2, long j3, long j4) {
        if (j < 0) {
            x33.a("Invalid parameter hours: ", j);
            throw null;
        }
        if (j2 < 0 || j2 > 59) {
            x33.a("Invalid parameter minutes: ", j);
            throw null;
        }
        if (j3 < 0 || j3 > 59) {
            x33.a("Invalid parameter seconds: ", j);
            throw null;
        }
        if (j4 < 0 || j4 > 999) {
            x33.a("Invalid parameter milliseconds: ", j4);
            throw null;
        }
        this.milliseconds = (((j * 3600) + (j2 * 60) + j3) * 1000) + j4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static NormalPlayTime valueOf(String str) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            try {
                if (matcher.group(1) != null) {
                    return new NormalPlayTime(Long.parseLong(matcher.group(1)), Long.parseLong(matcher.group(2)), Long.parseLong(matcher.group(3)), Long.parseLong(matcher.group(5)) * ((long) ((int) Math.pow(10.0d, 3 - matcher.group(5).length()))));
                }
                return new NormalPlayTime((Long.parseLong(matcher.group(6)) * 1000) + (Long.parseLong(matcher.group(8)) * ((long) ((int) Math.pow(10.0d, 3 - matcher.group(8).length())))));
            } catch (NumberFormatException unused) {
            }
        }
        f80.a("Can't parse NormalPlayTime: ", str);
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getMilliseconds() {
        return this.milliseconds;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getString(Format format) {
        long j = this.milliseconds;
        long j2 = j / 1000;
        long j3 = j % 1000;
        if (format.ordinal() != 1) {
            return String.format(Locale.ROOT, "%d.%03d", Long.valueOf(j2), Long.valueOf(j3));
        }
        long j4 = this.milliseconds;
        long seconds = (j4 / 1000) - TimeUnit.MINUTES.toSeconds(j4 / RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS);
        long j5 = this.milliseconds;
        return String.format(Locale.ROOT, "%d:%02d:%02d.%03d", Long.valueOf(j5 / 3600000), Long.valueOf((j5 / RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS) - TimeUnit.HOURS.toMinutes(j5 / 3600000)), Long.valueOf(seconds), Long.valueOf(j3));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setMilliseconds(long j) {
        if (j >= 0) {
            this.milliseconds = j;
        } else {
            x33.a("Invalid parameter milliseconds: ", j);
        }
    }

    public NormalPlayTime(long j) {
        if (j >= 0) {
            this.milliseconds = j;
        } else {
            x33.a("Invalid parameter milliseconds: ", j);
            throw null;
        }
    }

    public String getString() {
        return getString(Format.SECONDS);
    }
}
