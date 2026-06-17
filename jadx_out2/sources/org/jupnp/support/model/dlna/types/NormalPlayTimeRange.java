package org.jupnp.support.model.dlna.types;

import org.jupnp.model.ServiceReference;
import org.jupnp.model.types.InvalidValueException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NormalPlayTimeRange {
    public static final String PREFIX = "npt=";
    private NormalPlayTime timeDuration;
    private NormalPlayTime timeEnd;
    private NormalPlayTime timeStart;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public NormalPlayTimeRange(long j, long j2) {
        this.timeStart = new NormalPlayTime(j);
        this.timeEnd = new NormalPlayTime(j2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static NormalPlayTimeRange valueOf(String str, boolean z) {
        NormalPlayTime normalPlayTimeValueOf;
        if (str.startsWith(PREFIX)) {
            String[] strArrSplit = str.substring(4).split("[-/]");
            int length = strArrSplit.length;
            NormalPlayTime normalPlayTimeValueOf2 = null;
            if (length == 1) {
                normalPlayTimeValueOf = null;
            } else if (length == 2) {
                normalPlayTimeValueOf = null;
                if (!strArrSplit[1].isEmpty()) {
                    normalPlayTimeValueOf2 = NormalPlayTime.valueOf(strArrSplit[1]);
                }
            } else if (length == 3) {
                if (!strArrSplit[2].isEmpty() && !strArrSplit[2].equals("*")) {
                    normalPlayTimeValueOf = NormalPlayTime.valueOf(strArrSplit[2]);
                }
                if (!strArrSplit[1].isEmpty()) {
                }
            }
            if (!strArrSplit[0].isEmpty() && (!z || (z && strArrSplit.length > 1))) {
                return new NormalPlayTimeRange(NormalPlayTime.valueOf(strArrSplit[0]), normalPlayTimeValueOf2, normalPlayTimeValueOf);
            }
        }
        throw new InvalidValueException("Can't parse NormalPlayTimeRange: ".concat(str));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getString(boolean z) {
        String str = PREFIX + this.timeStart.getString() + "-";
        NormalPlayTime normalPlayTime = this.timeEnd;
        if (normalPlayTime != null) {
            str = str + normalPlayTime.getString();
        }
        if (!z) {
            return str;
        }
        NormalPlayTime normalPlayTime2 = this.timeDuration;
        return str + ServiceReference.DELIMITER + (normalPlayTime2 != null ? normalPlayTime2.getString() : "*");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public NormalPlayTime getTimeDuration() {
        return this.timeDuration;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public NormalPlayTime getTimeEnd() {
        return this.timeEnd;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public NormalPlayTime getTimeStart() {
        return this.timeStart;
    }

    public NormalPlayTimeRange(NormalPlayTime normalPlayTime, NormalPlayTime normalPlayTime2) {
        this.timeStart = normalPlayTime;
        this.timeEnd = normalPlayTime2;
    }

    public NormalPlayTimeRange(NormalPlayTime normalPlayTime, NormalPlayTime normalPlayTime2, NormalPlayTime normalPlayTime3) {
        this.timeStart = normalPlayTime;
        this.timeEnd = normalPlayTime2;
        this.timeDuration = normalPlayTime3;
    }

    public String getString() {
        return getString(true);
    }

    public static NormalPlayTimeRange valueOf(String str) {
        return valueOf(str, false);
    }
}
