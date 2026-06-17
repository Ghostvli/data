package org.jupnp.support.model;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class VolumeDBRange {
    private Integer maxValue;
    private Integer minValue;

    public VolumeDBRange(Integer num, Integer num2) {
        this.minValue = num;
        this.maxValue = num2;
    }

    public Integer getMaxValue() {
        return this.maxValue;
    }

    public Integer getMinValue() {
        return this.minValue;
    }
}
