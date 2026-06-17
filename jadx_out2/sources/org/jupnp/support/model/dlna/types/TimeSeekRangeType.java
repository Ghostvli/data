package org.jupnp.support.model.dlna.types;

import org.jupnp.model.types.BytesRange;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class TimeSeekRangeType {
    private BytesRange bytesRange;
    private NormalPlayTimeRange normalPlayTimeRange;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public TimeSeekRangeType(NormalPlayTimeRange normalPlayTimeRange, BytesRange bytesRange) {
        this.normalPlayTimeRange = normalPlayTimeRange;
        this.bytesRange = bytesRange;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public BytesRange getBytesRange() {
        return this.bytesRange;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public NormalPlayTimeRange getNormalPlayTimeRange() {
        return this.normalPlayTimeRange;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setBytesRange(BytesRange bytesRange) {
        this.bytesRange = bytesRange;
    }

    public TimeSeekRangeType(NormalPlayTimeRange normalPlayTimeRange) {
        this.normalPlayTimeRange = normalPlayTimeRange;
    }
}
