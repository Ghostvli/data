package org.jupnp.model.message.header;

import defpackage.fq0;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class EXTHeader extends UpnpHeader<String> {
    public static final String DEFAULT_VALUE = "";

    public EXTHeader() {
        setValue("");
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public String getString() {
        return getValue();
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public void setString(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        fq0.a("Invalid EXT header, it has no value: ".concat(str));
    }
}
