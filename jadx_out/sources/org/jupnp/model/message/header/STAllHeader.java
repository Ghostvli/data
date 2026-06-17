package org.jupnp.model.message.header;

import org.jupnp.model.types.NotificationSubtype;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class STAllHeader extends UpnpHeader<NotificationSubtype> {
    public STAllHeader() {
        setValue(NotificationSubtype.ALL);
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public String getString() {
        return getValue().getHeaderString();
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public void setString(String str) {
        NotificationSubtype notificationSubtype = NotificationSubtype.ALL;
        if (str.equals(notificationSubtype.getHeaderString())) {
            return;
        }
        throw new InvalidHeaderException("Invalid ST header value (not " + String.valueOf(notificationSubtype) + "): " + str);
    }
}
