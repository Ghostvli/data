package org.jupnp.model.types;

import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class BytesRange {
    public static final String PREFIX = "bytes=";
    private Long byteLength;
    private Long firstByte;
    private Long lastByte;

    public BytesRange(Long l, Long l2) {
        this.firstByte = l;
        this.lastByte = l2;
        this.byteLength = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.jupnp.model.types.BytesRange valueOf(java.lang.String r5, java.lang.String r6) {
        /*
            java.lang.String r0 = "bytes="
            if (r6 == 0) goto L6
            r1 = r6
            goto L7
        L6:
            r1 = r0
        L7:
            boolean r1 = r5.startsWith(r1)
            if (r1 == 0) goto L7c
            if (r6 == 0) goto L10
            goto L11
        L10:
            r6 = r0
        L11:
            int r6 = r6.length()
            java.lang.String r6 = r5.substring(r6)
            java.lang.String r0 = "[-/]"
            java.lang.String[] r6 = r6.split(r0)
            int r0 = r6.length
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L5d
            r3 = 2
            if (r0 == r3) goto L47
            r4 = 3
            if (r0 != r4) goto L7c
            r0 = r6[r3]
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L47
            r0 = r6[r3]
            java.lang.String r4 = "*"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L47
            r0 = r6[r3]
            long r3 = java.lang.Long.parseLong(r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r3)
            goto L48
        L47:
            r0 = r2
        L48:
            r3 = r6[r1]
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L5b
            r1 = r6[r1]
            long r3 = java.lang.Long.parseLong(r1)
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            goto L5f
        L5b:
            r1 = r2
            goto L5f
        L5d:
            r0 = r2
            r1 = r0
        L5f:
            r3 = 0
            r4 = r6[r3]
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L72
            r6 = r6[r3]
            long r2 = java.lang.Long.parseLong(r6)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
        L72:
            if (r2 != 0) goto L76
            if (r1 == 0) goto L7c
        L76:
            org.jupnp.model.types.BytesRange r5 = new org.jupnp.model.types.BytesRange
            r5.<init>(r2, r1, r0)
            return r5
        L7c:
            org.jupnp.model.types.InvalidValueException r6 = new org.jupnp.model.types.InvalidValueException
            java.lang.String r0 = "Can't parse Bytes Range: "
            java.lang.String r5 = r0.concat(r5)
            r6.<init>(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jupnp.model.types.BytesRange.valueOf(java.lang.String, java.lang.String):org.jupnp.model.types.BytesRange");
    }

    public Long getByteLength() {
        return this.byteLength;
    }

    public Long getFirstByte() {
        return this.firstByte;
    }

    public Long getLastByte() {
        return this.lastByte;
    }

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
