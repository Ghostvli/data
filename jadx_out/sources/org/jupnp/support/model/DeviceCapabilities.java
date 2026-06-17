package org.jupnp.support.model;

import java.util.Map;
import org.jupnp.model.ModelUtil;
import org.jupnp.model.action.ActionArgumentValue;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DeviceCapabilities {
    private StorageMedium[] playMedia;
    private StorageMedium[] recMedia;
    private RecordQualityMode[] recQualityModes;

    public DeviceCapabilities(Map<String, ActionArgumentValue<?>> map) {
        this(StorageMedium.valueOfCommaSeparatedList((String) map.get("PlayMedia").getValue()), StorageMedium.valueOfCommaSeparatedList((String) map.get("RecMedia").getValue()), RecordQualityMode.valueOfCommaSeparatedList((String) map.get("RecQualityModes").getValue()));
    }

    public StorageMedium[] getPlayMedia() {
        return this.playMedia;
    }

    public String getPlayMediaString() {
        return ModelUtil.toCommaSeparatedList(this.playMedia);
    }

    public StorageMedium[] getRecMedia() {
        return this.recMedia;
    }

    public String getRecMediaString() {
        return ModelUtil.toCommaSeparatedList(this.recMedia);
    }

    public RecordQualityMode[] getRecQualityModes() {
        return this.recQualityModes;
    }

    public String getRecQualityModesString() {
        return ModelUtil.toCommaSeparatedList(this.recQualityModes);
    }

    public DeviceCapabilities(StorageMedium[] storageMediumArr) {
        this.recMedia = new StorageMedium[]{StorageMedium.NOT_IMPLEMENTED};
        this.recQualityModes = new RecordQualityMode[]{RecordQualityMode.NOT_IMPLEMENTED};
        this.playMedia = storageMediumArr;
    }

    public DeviceCapabilities(StorageMedium[] storageMediumArr, StorageMedium[] storageMediumArr2, RecordQualityMode[] recordQualityModeArr) {
        this.recMedia = new StorageMedium[]{StorageMedium.NOT_IMPLEMENTED};
        RecordQualityMode recordQualityMode = RecordQualityMode.EP;
        this.playMedia = storageMediumArr;
        this.recMedia = storageMediumArr2;
        this.recQualityModes = recordQualityModeArr;
    }
}
