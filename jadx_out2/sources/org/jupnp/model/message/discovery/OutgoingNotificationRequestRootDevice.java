package org.jupnp.model.message.discovery;

import org.jupnp.model.Constants;
import org.jupnp.model.Location;
import org.jupnp.model.message.header.InterfaceMacHeader;
import org.jupnp.model.message.header.RootDeviceHeader;
import org.jupnp.model.message.header.USNRootDeviceHeader;
import org.jupnp.model.message.header.UpnpHeader;
import org.jupnp.model.meta.LocalDevice;
import org.jupnp.model.types.NotificationSubtype;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class OutgoingNotificationRequestRootDevice extends OutgoingNotificationRequest {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public OutgoingNotificationRequestRootDevice(Location location, LocalDevice localDevice, NotificationSubtype notificationSubtype) {
        super(location, localDevice, notificationSubtype);
        getHeaders().add(UpnpHeader.Type.NT, new RootDeviceHeader());
        getHeaders().add(UpnpHeader.Type.USN, new USNRootDeviceHeader(localDevice.getIdentity().getUdn()));
        if (!"true".equals(System.getProperty(Constants.SYSTEM_PROPERTY_ANNOUNCE_MAC_ADDRESS)) || location.getNetworkAddress().getHardwareAddress() == null) {
            return;
        }
        getHeaders().add(UpnpHeader.Type.EXT_IFACE_MAC, new InterfaceMacHeader(location.getNetworkAddress().getHardwareAddress()));
    }
}
