package org.jupnp.support.model;

import java.util.ArrayList;
import java.util.Arrays;
import org.jupnp.model.ModelUtil;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ProtocolInfos extends ArrayList<ProtocolInfo> {
    private static final long serialVersionUID = 5044783488205827065L;

    public ProtocolInfos(String str) {
        String[] strArrFromCommaSeparatedList = ModelUtil.fromCommaSeparatedList(str);
        if (strArrFromCommaSeparatedList != null) {
            for (String str2 : strArrFromCommaSeparatedList) {
                add(new ProtocolInfo(str2));
            }
        }
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return ModelUtil.toCommaSeparatedList(toArray(new ProtocolInfo[size()]));
    }

    public ProtocolInfos(ProtocolInfo... protocolInfoArr) {
        addAll(Arrays.asList(protocolInfoArr));
    }
}
