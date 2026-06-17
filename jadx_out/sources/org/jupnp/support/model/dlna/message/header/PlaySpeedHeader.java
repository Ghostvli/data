package org.jupnp.support.model.dlna.message.header;

import defpackage.fq0;
import org.jupnp.model.types.InvalidValueException;
import org.jupnp.support.avtransport.lastchange.AVTransportVariable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class PlaySpeedHeader extends DLNAHeader<AVTransportVariable.TransportPlaySpeed> {
    public PlaySpeedHeader(AVTransportVariable.TransportPlaySpeed transportPlaySpeed) {
        setValue(transportPlaySpeed);
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public String getString() {
        return getValue().getValue();
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public void setString(String str) {
        if (!str.isEmpty()) {
            try {
                setValue(new AVTransportVariable.TransportPlaySpeed(str));
                return;
            } catch (InvalidValueException unused) {
            }
        }
        fq0.a("Invalid PlaySpeed header value: ".concat(str));
    }

    public PlaySpeedHeader() {
    }
}
