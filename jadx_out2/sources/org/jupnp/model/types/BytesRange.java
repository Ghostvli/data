package org.jupnp.model.types;

import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class BytesRange {
    public static final String PREFIX = "bytes=";
    private Long byteLength;
    private Long firstByte;
    private Long lastByte;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public BytesRange(Long l, Long l2) {
        this.firstByte = l;
        this.lastByte = l2;
        this.byteLength = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static BytesRange valueOf(String str, String str2) {
        Long lValueOf;
        Long lValueOf2;
        if (str.startsWith(str2 != null ? str2 : PREFIX)) {
            if (str2 == null) {
                str2 = PREFIX;
            }
            String[] strArrSplit = str.substring(str2.length()).split("[-/]");
            int length = strArrSplit.length;
            if (length == 1) {
                lValueOf = null;
                lValueOf2 = null;
            } else if (length == 2) {
                lValueOf = null;
                lValueOf2 = strArrSplit[1].isEmpty() ? Long.valueOf(Long.parseLong(strArrSplit[1])) : null;
            } else if (length == 3) {
                if (!strArrSplit[2].isEmpty() && !strArrSplit[2].equals("*")) {
                    lValueOf = Long.valueOf(Long.parseLong(strArrSplit[2]));
                }
                if (strArrSplit[1].isEmpty()) {
                }
            }
            Long lValueOf3 = strArrSplit[0].isEmpty() ? null : Long.valueOf(Long.parseLong(strArrSplit[0]));
            if (lValueOf3 != null || lValueOf2 != null) {
                return new BytesRange(lValueOf3, lValueOf2, lValueOf);
            }
        }
        throw new InvalidValueException("Can't parse Bytes Range: ".concat(str));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Long getByteLength() {
        return this.byteLength;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Long getFirstByte() {
        return this.firstByte;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Long getLastByte() {
        return this.lastByte;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getString(boolean z, String str) {
        if (str == null) {
            str = PREFIX;
        }
        Long l = this.firstByte;
        if (l != null) {
            str = str + l.toString();
        }
        String strConcat = str.concat("-");
        Long l2 = this.lastByte;
        if (l2 != null) {
            strConcat = strConcat + l2.toString();
        }
        if (!z) {
            return strConcat;
        }
        Long l3 = this.byteLength;
        return strConcat + ServiceReference.DELIMITER + (l3 != null ? l3.toString() : "*");
    }

    public BytesRange(Long l, Long l2, Long l3) {
        this.firstByte = l;
        this.lastByte = l2;
        this.byteLength = l3;
    }

    public String getString(boolean z) {
        return getString(z, null);
    }

    public String getString() {
        return getString(false, null);
    }

    public static BytesRange valueOf(String str) {
        return valueOf(str, null);
    }
}
