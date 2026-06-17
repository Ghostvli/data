package org.jupnp.support.model.dlna.types;

import org.jupnp.model.types.BytesRange;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AvailableSeekRangeType {
    private BytesRange bytesRange;
    private Mode modeFlag;
    private NormalPlayTimeRange normalPlayTimeRange;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum Mode {
        MODE_0,
        MODE_1
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AvailableSeekRangeType(Mode mode, NormalPlayTimeRange normalPlayTimeRange, BytesRange bytesRange) {
        this.modeFlag = mode;
        this.normalPlayTimeRange = normalPlayTimeRange;
        this.bytesRange = bytesRange;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public BytesRange getBytesRange() {
        return this.bytesRange;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Mode getModeFlag() {
        return this.modeFlag;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public NormalPlayTimeRange getNormalPlayTimeRange() {
        return this.normalPlayTimeRange;
    }

    public AvailableSeekRangeType(Mode mode, BytesRange bytesRange) {
        this.modeFlag = mode;
        this.bytesRange = bytesRange;
    }

    public AvailableSeekRangeType(Mode mode, NormalPlayTimeRange normalPlayTimeRange) {
        this.modeFlag = mode;
        this.normalPlayTimeRange = normalPlayTimeRange;
    }
}
