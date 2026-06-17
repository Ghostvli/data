package org.jupnp.model.message.discovery;

import org.jupnp.model.Location;
import org.jupnp.model.message.header.DeviceTypeHeader;
import org.jupnp.model.message.header.DeviceUSNHeader;
import org.jupnp.model.message.header.UpnpHeader;
import org.jupnp.model.meta.LocalDevice;
import org.jupnp.model.types.NotificationSubtype;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class OutgoingNotificationRequestDeviceType extends OutgoingNotificationRequest {
    public OutgoingNotificationRequestDeviceType(Location location, LocalDevice localDevice, NotificationSubtype notificationSubtype) {
        super(location, localDevice, notificationSubtype);
        getHeaders().add(UpnpHeader.Type.NT, new DeviceTypeHeader(localDevice.getType()));
        getHeaders().add(UpnpHeader.Type.USN, new DeviceUSNHeader(localDevice.getIdentity().getUdn(), localDevice.getType()));
    }
}
