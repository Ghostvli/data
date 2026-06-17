package org.jupnp.model.message.header;

import defpackage.j32;
import org.jupnp.model.types.NotificationSubtype;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NTSHeader extends UpnpHeader<NotificationSubtype> {
    public NTSHeader(NotificationSubtype notificationSubtype) {
        setValue(notificationSubtype);
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public String getString() {
        return getValue().getHeaderString();
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public void setString(String str) {
        NotificationSubtype[] notificationSubtypeArrValues = NotificationSubtype.values();
        int length = notificationSubtypeArrValues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            NotificationSubtype notificationSubtype = notificationSubtypeArrValues[i];
            if (str.equals(notificationSubtype.getHeaderString())) {
                setValue(notificationSubtype);
                break;
            }
            i++;
        }
        if (getValue() != null) {
            return;
        }
        j32.a("Invalid NTS header value: ", str);
    }

    public NTSHeader() {
    }
}
