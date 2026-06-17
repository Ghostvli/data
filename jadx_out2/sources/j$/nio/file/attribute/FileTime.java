package j$.nio.file.attribute;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class FileTime implements Comparable<FileTime> {
    public final long a;
    public Instant b = null;
    public String c;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FileTime(long j) {
        this.a = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long N(long j, long j2, long j3) {
        if (j > j3) {
            return Long.MAX_VALUE;
        }
        if (j < (-j3)) {
            return Long.MIN_VALUE;
        }
        return j * j2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void u(StringBuilder sb, int i, int i2) {
        while (i > 0) {
            sb.append((char) ((i2 / i) + 48));
            i2 %= i;
            i /= 10;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: compareTo(Ljava/lang/Object;)I */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public final int compareTo(FileTime fileTime) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        if (timeUnit != null) {
            fileTime.getClass();
            return Long.compare(this.a, fileTime.a);
        }
        long j = toInstant().a;
        int iCompare = Long.compare(j, fileTime.toInstant().a);
        if (iCompare != 0) {
            return iCompare;
        }
        int iCompare2 = Long.compare(toInstant().b, fileTime.toInstant().b);
        if (iCompare2 != 0) {
            return iCompare2;
        }
        if (j != 31556889864403199L && j != -31557014167219200L) {
            return 0;
        }
        long j2 = timeUnit != null ? this.a / 86400000 : toInstant().a / 86400;
        long j3 = timeUnit != null ? fileTime.a / 86400000 : fileTime.toInstant().a / 86400;
        return j2 == j3 ? Long.compare(Q(j2), fileTime.Q(j3)) : Long.compare(j2, j3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long Q(long j) {
        TimeUnit timeUnit = TimeUnit.DAYS;
        TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
        if (timeUnit2 != null) {
            return timeUnit2.toNanos(this.a - timeUnit2.convert(j, timeUnit));
        }
        return TimeUnit.SECONDS.toNanos(toInstant().a - timeUnit.toSeconds(j));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean equals(Object obj) {
        return (obj instanceof FileTime) && compareTo((FileTime) obj) == 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int hashCode() {
        return toInstant().hashCode();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Instant toInstant() {
        long jN;
        int iFloorMod;
        long jFloorDiv;
        if (this.b == null) {
            switch (r.a[TimeUnit.MILLISECONDS.ordinal()]) {
                case 1:
                    jN = N(this.a, 86400L, 106751991167300L);
                    long j = jN;
                    iFloorMod = 0;
                    jFloorDiv = j;
                    if (jFloorDiv <= -31557014167219200L) {
                        this.b = Instant.c;
                    } else if (jFloorDiv < 31556889864403199L) {
                        this.b = Instant.N(jFloorDiv, iFloorMod);
                    } else {
                        this.b = Instant.d;
                    }
                    break;
                case 2:
                    jN = N(this.a, 3600L, 2562047788015215L);
                    long j2 = jN;
                    iFloorMod = 0;
                    jFloorDiv = j2;
                    if (jFloorDiv <= -31557014167219200L) {
                    }
                    break;
                case 3:
                    jN = N(this.a, 60L, 153722867280912930L);
                    long j22 = jN;
                    iFloorMod = 0;
                    jFloorDiv = j22;
                    if (jFloorDiv <= -31557014167219200L) {
                    }
                    break;
                case 4:
                    jN = this.a;
                    long j222 = jN;
                    iFloorMod = 0;
                    jFloorDiv = j222;
                    if (jFloorDiv <= -31557014167219200L) {
                    }
                    break;
                case 5:
                    jFloorDiv = Math.floorDiv(this.a, 1000L);
                    iFloorMod = ((int) Math.floorMod(this.a, 1000L)) * 1000000;
                    if (jFloorDiv <= -31557014167219200L) {
                    }
                    break;
                case 6:
                    jFloorDiv = Math.floorDiv(this.a, 1000000L);
                    iFloorMod = ((int) Math.floorMod(this.a, 1000000L)) * 1000;
                    if (jFloorDiv <= -31557014167219200L) {
                    }
                    break;
                case 7:
                    jFloorDiv = Math.floorDiv(this.a, 1000000000L);
                    iFloorMod = (int) Math.floorMod(this.a, 1000000000L);
                    if (jFloorDiv <= -31557014167219200L) {
                    }
                    break;
                default:
                    throw new AssertionError("Unit not handled");
            }
        }
        return this.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long toMillis() {
        if (TimeUnit.MILLISECONDS != null) {
            return this.a;
        }
        Instant instant = this.b;
        long j = instant.a;
        long j2 = j * 1000;
        return (((Math.abs(j) | 1000) >>> 31) == 0 || j2 / 1000 == j) ? j2 + ((long) (instant.b / 1000000)) : j < 0 ? Long.MIN_VALUE : Long.MAX_VALUE;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String toString() {
        long j;
        int i;
        long jFloorDiv;
        LocalDateTime localDateTimeY;
        int i2;
        if (this.c == null) {
            if (this.b != null || TimeUnit.MILLISECONDS.compareTo(TimeUnit.SECONDS) < 0) {
                j = toInstant().a;
                i = toInstant().b;
            } else {
                j = this.a / 1000;
                i = 0;
            }
            if (j >= -62167219200L) {
                long j2 = j - 253402300800L;
                jFloorDiv = Math.floorDiv(j2, 315569520000L) + 1;
                localDateTimeY = LocalDateTime.Y(Math.floorMod(j2, 315569520000L) - 62167219200L, i, ZoneOffset.UTC);
                i2 = localDateTimeY.a.a;
            } else {
                long j3 = j + 62167219200L;
                jFloorDiv = j3 / 315569520000L;
                localDateTimeY = LocalDateTime.Y((j3 % 315569520000L) - 62167219200L, i, ZoneOffset.UTC);
                i2 = localDateTimeY.a.a;
            }
            int i3 = (((int) jFloorDiv) * com.hierynomus.msdtyp.FileTime.NANO100_TO_MILLI) + i2;
            if (i3 <= 0) {
                i3--;
            }
            int i4 = localDateTimeY.b.d;
            StringBuilder sb = new StringBuilder(64);
            sb.append(i3 < 0 ? "-" : "");
            int iAbs = Math.abs(i3);
            if (iAbs < 10000) {
                u(sb, 1000, Math.abs(iAbs));
            } else {
                sb.append(String.valueOf(iAbs));
            }
            sb.append('-');
            u(sb, 10, localDateTimeY.a.b);
            sb.append('-');
            u(sb, 10, localDateTimeY.a.c);
            sb.append('T');
            u(sb, 10, localDateTimeY.b.a);
            sb.append(':');
            u(sb, 10, localDateTimeY.b.b);
            sb.append(':');
            u(sb, 10, localDateTimeY.b.c);
            if (i4 != 0) {
                sb.append('.');
                int i5 = 100000000;
                while (i4 % 10 == 0) {
                    i4 /= 10;
                    i5 /= 10;
                }
                u(sb, i5, i4);
            }
            sb.append('Z');
            this.c = sb.toString();
        }
        return this.c;
    }
}
