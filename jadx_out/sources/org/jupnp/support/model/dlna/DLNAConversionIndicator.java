package org.jupnp.support.model.dlna;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public enum DLNAConversionIndicator {
    NONE(0),
    TRANSCODED(1);

    private final int code;

    DLNAConversionIndicator(int i) {
        this.code = i;
    }

    public static DLNAConversionIndicator valueOf(int i) {
        for (DLNAConversionIndicator dLNAConversionIndicator : values()) {
            if (dLNAConversionIndicator.getCode() == i) {
                return dLNAConversionIndicator;
            }
        }
        return null;
    }

    public int getCode() {
        return this.code;
    }
}
