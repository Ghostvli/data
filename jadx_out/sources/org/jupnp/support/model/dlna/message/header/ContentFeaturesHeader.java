package org.jupnp.support.model.dlna.message.header;

import java.util.EnumMap;
import org.jupnp.support.model.dlna.DLNAAttribute;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ContentFeaturesHeader extends DLNAHeader<EnumMap<DLNAAttribute.Type, DLNAAttribute<?>>> {
    public ContentFeaturesHeader() {
        setValue(new EnumMap(DLNAAttribute.Type.class));
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public String getString() {
        String str = "";
        for (DLNAAttribute.Type type : DLNAAttribute.Type.values()) {
            String string = getValue().containsKey(type) ? getValue().get(type).getString() : null;
            if (string != null && !string.isEmpty()) {
                str = str + (str.isEmpty() ? "" : ";") + type.getAttributeName() + "=" + string;
            }
        }
        return str;
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public void setString(String str) {
        DLNAAttribute.Type typeValueOfAttributeName;
        if (str.isEmpty()) {
            return;
        }
        for (String str2 : str.split(";")) {
            String[] strArrSplit = str2.split("=");
            if (strArrSplit.length == 2 && (typeValueOfAttributeName = DLNAAttribute.Type.valueOfAttributeName(strArrSplit[0])) != null) {
                getValue().put(typeValueOfAttributeName, DLNAAttribute.newInstance(typeValueOfAttributeName, strArrSplit[1], ""));
            }
        }
    }
}
