package org.jupnp.model.message.header;

import defpackage.tn3;
import java.net.URI;
import org.jupnp.model.types.UDAServiceType;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class UDAServiceTypeHeader extends ServiceTypeHeader {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public UDAServiceTypeHeader() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.model.message.header.ServiceTypeHeader, org.jupnp.model.message.header.UpnpHeader
    public void setString(String str) {
        try {
            setValue(UDAServiceType.valueOf(str));
        } catch (Exception e) {
            tn3.a("Invalid UDA service type header value, ", e.getMessage(), e);
        }
    }

    public UDAServiceTypeHeader(URI uri) {
        super(uri);
    }

    public UDAServiceTypeHeader(UDAServiceType uDAServiceType) {
        super(uDAServiceType);
    }
}
