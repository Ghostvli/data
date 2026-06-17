package org.jupnp.support.model;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class TransportSettings {
    private PlayMode playMode;
    private RecordQualityMode recQualityMode;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public TransportSettings(PlayMode playMode) {
        this.playMode = PlayMode.NORMAL;
        this.recQualityMode = RecordQualityMode.NOT_IMPLEMENTED;
        this.playMode = playMode;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PlayMode getPlayMode() {
        return this.playMode;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public RecordQualityMode getRecQualityMode() {
        return this.recQualityMode;
    }

    public TransportSettings() {
        this.playMode = PlayMode.NORMAL;
        this.recQualityMode = RecordQualityMode.NOT_IMPLEMENTED;
    }

    public TransportSettings(PlayMode playMode, RecordQualityMode recordQualityMode) {
        this.playMode = PlayMode.NORMAL;
        RecordQualityMode recordQualityMode2 = RecordQualityMode.EP;
        this.playMode = playMode;
        this.recQualityMode = recordQualityMode;
    }
}
