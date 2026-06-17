package org.jupnp.model.message.header;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AVClientInfoHeader extends UpnpHeader<String> {
    public AVClientInfoHeader(String str) {
        setValue(str);
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public String getString() {
        return getValue();
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public void setString(String str) {
        setValue(str);
    }

    public AVClientInfoHeader() {
    }
}
