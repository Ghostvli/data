package com.hierynomus.msdtyp;

import j$.time.Instant;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class FileTime {
    public static final int NANO100_TO_MILLI = 10000;
    public static final int NANO100_TO_NANO = 100;
    public static final long WINDOWS_TO_UNIX_EPOCH = 116444736000000000L;
    private final long windowsTimeStamp;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FileTime(long j) {
        this.windowsTimeStamp = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static FileTime fromDate(Date date) {
        return new FileTime((date.getTime() * 10000) + WINDOWS_TO_UNIX_EPOCH);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static FileTime fromInstant(Instant instant) {
        return new FileTime((instant.toEpochMilli() * 10000) + WINDOWS_TO_UNIX_EPOCH);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static FileTime now() {
        return ofEpochMillis(System.currentTimeMillis());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static FileTime ofEpoch(long j, TimeUnit timeUnit) {
        return new FileTime((TimeUnit.NANOSECONDS.convert(j, timeUnit) / 100) + WINDOWS_TO_UNIX_EPOCH);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static FileTime ofEpochMillis(long j) {
        return ofEpoch(j, TimeUnit.MILLISECONDS);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.windowsTimeStamp == ((FileTime) obj).windowsTimeStamp;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getWindowsTimeStamp() {
        return this.windowsTimeStamp;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        long j = this.windowsTimeStamp;
        return (int) (j ^ (j >>> 32));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Date toDate() {
        return new Date(toEpochMillis());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long toEpoch(TimeUnit timeUnit) {
        return timeUnit.convert((this.windowsTimeStamp - WINDOWS_TO_UNIX_EPOCH) * 100, TimeUnit.NANOSECONDS);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long toEpochMillis() {
        return toEpoch(TimeUnit.MILLISECONDS);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Instant toInstant() {
        return Instant.ofEpochMilli(toEpochMillis());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return toDate().toString();
    }
}
