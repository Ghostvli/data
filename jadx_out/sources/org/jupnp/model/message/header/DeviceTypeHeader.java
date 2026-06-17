package org.jupnp.model.message.header;

import defpackage.tn3;
import java.net.URI;
import org.jupnp.model.types.DeviceType;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DeviceTypeHeader extends UpnpHeader<DeviceType> {
    public DeviceTypeHeader(URI uri) {
        setString(uri.toString());
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public String getString() {
        return getValue().toString();
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public void setString(String str) {
        try {
            setValue(DeviceType.valueOf(str));
        } catch (RuntimeException e) {
            tn3.a("Invalid device type header value, ", e.getMessage(), e);
        }
    }

    public DeviceTypeHeader() {
    }

    public DeviceTypeHeader(DeviceType deviceType) {
        setValue(deviceType);
    }
}
