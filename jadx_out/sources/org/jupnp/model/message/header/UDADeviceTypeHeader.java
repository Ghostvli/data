package org.jupnp.model.message.header;

import defpackage.tn3;
import java.net.URI;
import org.jupnp.model.types.DeviceType;
import org.jupnp.model.types.UDADeviceType;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class UDADeviceTypeHeader extends DeviceTypeHeader {
    public UDADeviceTypeHeader() {
    }

    @Override // org.jupnp.model.message.header.DeviceTypeHeader, org.jupnp.model.message.header.UpnpHeader
    public void setString(String str) {
        try {
            setValue(UDADeviceType.valueOf(str));
        } catch (Exception e) {
            tn3.a("Invalid UDA device type header value, ", e.getMessage(), e);
        }
    }

    public UDADeviceTypeHeader(URI uri) {
        super(uri);
    }

    public UDADeviceTypeHeader(DeviceType deviceType) {
        super(deviceType);
    }
}
