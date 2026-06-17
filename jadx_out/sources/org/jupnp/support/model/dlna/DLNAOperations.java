package org.jupnp.support.model.dlna;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public enum DLNAOperations {
    NONE(0),
    RANGE(1),
    TIMESEEK(16);

    private final int code;

    DLNAOperations(int i) {
        this.code = i;
    }

    public static DLNAOperations valueOf(int i) {
        for (DLNAOperations dLNAOperations : values()) {
            if (dLNAOperations.getCode() == i) {
                return dLNAOperations;
            }
        }
        return null;
    }

    public int getCode() {
        return this.code;
    }
}
