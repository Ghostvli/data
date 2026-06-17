package org.jupnp.model.message.header;

import defpackage.tn3;
import org.jupnp.model.types.DeviceType;
import org.jupnp.model.types.NamedDeviceType;
import org.jupnp.model.types.UDN;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DeviceUSNHeader extends UpnpHeader<NamedDeviceType> {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DeviceUSNHeader(UDN udn, DeviceType deviceType) {
        setValue(new NamedDeviceType(udn, deviceType));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.model.message.header.UpnpHeader
    public String getString() {
        return getValue().toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.model.message.header.UpnpHeader
    public void setString(String str) {
        try {
            setValue(NamedDeviceType.valueOf(str));
        } catch (Exception e) {
            tn3.a("Invalid device USN header value, ", e.getMessage(), e);
        }
    }

    public DeviceUSNHeader() {
    }

    public DeviceUSNHeader(NamedDeviceType namedDeviceType) {
        setValue(namedDeviceType);
    }
}
