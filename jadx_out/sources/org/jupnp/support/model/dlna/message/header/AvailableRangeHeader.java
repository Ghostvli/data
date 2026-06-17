package org.jupnp.support.model.dlna.message.header;

import defpackage.fq0;
import org.jupnp.support.model.dlna.types.NormalPlayTimeRange;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AvailableRangeHeader extends DLNAHeader<NormalPlayTimeRange> {
    @Override // org.jupnp.model.message.header.UpnpHeader
    public String getString() {
        return getValue().toString();
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public void setString(String str) {
        if (!str.isEmpty()) {
            try {
                setValue(NormalPlayTimeRange.valueOf(str, true));
                return;
            } catch (Exception unused) {
            }
        }
        fq0.a("Invalid AvailableRange header value: ".concat(str));
    }
}
