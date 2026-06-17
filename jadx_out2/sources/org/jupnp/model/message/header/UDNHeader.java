package org.jupnp.model.message.header;

import defpackage.fq0;
import org.jupnp.model.types.UDN;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class UDNHeader extends UpnpHeader<UDN> {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public UDNHeader(UDN udn) {
        setValue(udn);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.model.message.header.UpnpHeader
    public String getString() {
        return getValue().toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.model.message.header.UpnpHeader
    public void setString(String str) {
        if (!str.startsWith("uuid:")) {
            fq0.a("Invalid UDA header value, must start with 'uuid:': ".concat(str));
        } else if (str.contains("::urn")) {
            fq0.a("Invalid UDA header value, must not contain '::urn': ".concat(str));
        } else {
            setValue(new UDN(str.substring(5)));
        }
    }

    public UDNHeader() {
    }
}
