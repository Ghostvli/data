package org.jupnp.support.model.dlna.types;

import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NormalPlayTimeRange {
    public static final String PREFIX = "npt=";
    private NormalPlayTime timeDuration;
    private NormalPlayTime timeEnd;
    private NormalPlayTime timeStart;

    public NormalPlayTimeRange(long j, long j2) {
        this.timeStart = new NormalPlayTime(j);
        this.timeEnd = new NormalPlayTime(j2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.jupnp.support.model.dlna.types.NormalPlayTimeRange valueOf(java.lang.String r6, boolean r7) {
        /*
            java.lang.String r0 = "npt="
            boolean r0 = r6.startsWith(r0)
            if (r0 == 0) goto L64
            r0 = 4
            java.lang.String r0 = r6.substring(r0)
            java.lang.String r1 = "[-/]"
            java.lang.String[] r0 = r0.split(r1)
            int r1 = r0.length
            r2 = 0
            r3 = 1
            if (r1 == r3) goto L47
            r4 = 2
            if (r1 == r4) goto L37
            r5 = 3
            if (r1 != r5) goto L64
            r1 = r0[r4]
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L37
            r1 = r0[r4]
            java.lang.String r5 = "*"
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L37
            r1 = r0[r4]
            org.jupnp.support.model.dlna.types.NormalPlayTime r1 = org.jupnp.support.model.dlna.types.NormalPlayTime.valueOf(r1)
            goto L38
        L37:
            r1 = r2
        L38:
            r4 = r0[r3]
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L48
            r2 = r0[r3]
            org.jupnp.support.model.dlna.types.NormalPlayTime r2 = org.jupnp.support.model.dlna.types.NormalPlayTime.valueOf(r2)
            goto L48
        L47:
            r1 = r2
        L48:
            r4 = 0
            r5 = r0[r4]
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L64
            if (r7 == 0) goto L58
            if (r7 == 0) goto L64
            int r7 = r0.length
            if (r7 <= r3) goto L64
        L58:
            r6 = r0[r4]
            org.jupnp.support.model.dlna.types.NormalPlayTime r6 = org.jupnp.support.model.dlna.types.NormalPlayTime.valueOf(r6)
            org.jupnp.support.model.dlna.types.NormalPlayTimeRange r7 = new org.jupnp.support.model.dlna.types.NormalPlayTimeRange
            r7.<init>(r6, r2, r1)
            return r7
        L64:
            org.jupnp.model.types.InvalidValueException r7 = new org.jupnp.model.types.InvalidValueException
            java.lang.String r0 = "Can't parse NormalPlayTimeRange: "
            java.lang.String r6 = r0.concat(r6)
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jupnp.support.model.dlna.types.NormalPlayTimeRange.valueOf(java.lang.String, boolean):org.jupnp.support.model.dlna.types.NormalPlayTimeRange");
    }

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

    public NormalPlayTime getTimeDuration() {
        return this.timeDuration;
    }

    public NormalPlayTime getTimeEnd() {
        return this.timeEnd;
    }

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
