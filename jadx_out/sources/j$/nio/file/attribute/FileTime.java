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

    public FileTime(long j) {
        this.a = j;
    }

    public static long N(long j, long j2, long j3) {
        if (j > j3) {
            return Long.MAX_VALUE;
        }
        if (j < (-j3)) {
            return Long.MIN_VALUE;
        }
        return j * j2;
    }

    public static void u(StringBuilder sb, int i, int i2) {
        while (i > 0) {
            sb.append((char) ((i2 / i) + 48));
            i2 %= i;
            i /= 10;
        }
    }

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

    public final long Q(long j) {
        TimeUnit timeUnit = TimeUnit.DAYS;
        TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
        if (timeUnit2 != null) {
            return timeUnit2.toNanos(this.a - timeUnit2.convert(j, timeUnit));
        }
        return TimeUnit.SECONDS.toNanos(toInstant().a - timeUnit.toSeconds(j));
    }

    public final boolean equals(Object obj) {
        return (obj instanceof FileTime) && compareTo((FileTime) obj) == 0;
    }

    public final int hashCode() {
        return toInstant().hashCode();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final j$.time.Instant toInstant() {
        /*
            r12 = this;
            j$.time.Instant r0 = r12.b
            if (r0 != 0) goto La6
            int[] r0 = j$.nio.file.attribute.r.a
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 0
            switch(r0) {
                case 1: goto L74;
                case 2: goto L66;
                case 3: goto L58;
                case 4: goto L52;
                case 5: goto L3e;
                case 6: goto L2b;
                case 7: goto L1a;
                default: goto L12;
            }
        L12:
            java.lang.AssertionError r12 = new java.lang.AssertionError
            java.lang.String r0 = "Unit not handled"
            r12.<init>(r0)
            throw r12
        L1a:
            long r0 = r12.a
            r2 = 1000000000(0x3b9aca00, double:4.94065646E-315)
            long r0 = java.lang.Math.floorDiv(r0, r2)
            long r4 = r12.a
            long r2 = java.lang.Math.floorMod(r4, r2)
            int r2 = (int) r2
            goto L83
        L2b:
            long r0 = r12.a
            r2 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = java.lang.Math.floorDiv(r0, r2)
            long r4 = r12.a
            long r2 = java.lang.Math.floorMod(r4, r2)
            int r2 = (int) r2
            int r2 = r2 * 1000
            goto L83
        L3e:
            long r0 = r12.a
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = java.lang.Math.floorDiv(r0, r2)
            long r4 = r12.a
            long r2 = java.lang.Math.floorMod(r4, r2)
            int r2 = (int) r2
            r3 = 1000000(0xf4240, float:1.401298E-39)
            int r2 = r2 * r3
            goto L83
        L52:
            long r2 = r12.a
        L54:
            r10 = r2
            r2 = r1
            r0 = r10
            goto L83
        L58:
            long r4 = r12.a
            r6 = 60
            r8 = 153722867280912930(0x222222222222222, double:2.166167076120538E-298)
            long r2 = N(r4, r6, r8)
            goto L54
        L66:
            long r4 = r12.a
            r6 = 3600(0xe10, double:1.7786E-320)
            r8 = 2562047788015215(0x91a2b3c4d5e6f, double:1.2658197950618743E-308)
            long r2 = N(r4, r6, r8)
            goto L54
        L74:
            long r4 = r12.a
            r6 = 86400(0x15180, double:4.26873E-319)
            r8 = 106751991167300(0x611722833944, double:5.2742491460911E-310)
            long r2 = N(r4, r6, r8)
            goto L54
        L83:
            r3 = -31557014167219200(0xff8fe31014641400, double:-2.7989734602046733E306)
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 > 0) goto L91
            j$.time.Instant r0 = j$.time.Instant.c
            r12.b = r0
            goto La6
        L91:
            r3 = 31556889864403199(0x701cd2fa9578ff, double:1.434068493154717E-306)
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 < 0) goto L9f
            j$.time.Instant r0 = j$.time.Instant.d
            r12.b = r0
            goto La6
        L9f:
            long r2 = (long) r2
            j$.time.Instant r0 = j$.time.Instant.N(r0, r2)
            r12.b = r0
        La6:
            j$.time.Instant r12 = r12.b
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.nio.file.attribute.FileTime.toInstant():j$.time.Instant");
    }

    public long toMillis() {
        if (TimeUnit.MILLISECONDS != null) {
            return this.a;
        }
        Instant instant = this.b;
        long j = instant.a;
        long j2 = j * 1000;
        return (((Math.abs(j) | 1000) >>> 31) == 0 || j2 / 1000 == j) ? j2 + ((long) (instant.b / 1000000)) : j < 0 ? Long.MIN_VALUE : Long.MAX_VALUE;
    }

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
