package org.jupnp.support.model.dlna.message.header;

import defpackage.fq0;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SupportedHeader extends DLNAHeader<String[]> {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SupportedHeader() {
        setValue(new String[0]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.model.message.header.UpnpHeader
    public String getString() {
        String[] value = getValue();
        StringBuilder sb = new StringBuilder(value.length > 0 ? value[0] : "");
        for (int i = 1; i < value.length; i++) {
            sb.append(",");
            sb.append(value[i]);
        }
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.model.message.header.UpnpHeader
    public void setString(String str) {
        if (str.isEmpty()) {
            fq0.a("Invalid Supported header value: ".concat(str));
            return;
        }
        if (str.endsWith(";")) {
            str = str.substring(0, str.length() - 1);
        }
        setValue(str.split("\\s*,\\s*"));
    }
}
