package org.jupnp.support.model.dlna.message.header;

import defpackage.fq0;
import java.util.ArrayList;
import java.util.List;
import org.jupnp.model.types.PragmaType;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class PragmaHeader extends DLNAHeader<List<PragmaType>> {
    public PragmaHeader() {
        setValue(new ArrayList());
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public String getString() {
        List<PragmaType> value = getValue();
        StringBuilder sb = new StringBuilder();
        for (PragmaType pragmaType : value) {
            sb.append(sb.length() == 0 ? "" : ",");
            sb.append(pragmaType.getString());
        }
        return sb.toString();
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public void setString(String str) {
        if (str.isEmpty()) {
            fq0.a("Invalid Pragma header value: ".concat(str));
            return;
        }
        if (str.endsWith(";")) {
            str = str.substring(0, str.length() - 1);
        }
        String[] strArrSplit = str.split("\\s*;\\s*");
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArrSplit) {
            arrayList.add(PragmaType.valueOf(str2));
        }
    }
}
