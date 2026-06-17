package org.jupnp.protocol.async;

import defpackage.j02;
import defpackage.n02;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jupnp.UpnpService;
import org.jupnp.model.Location;
import org.jupnp.model.NetworkAddress;
import org.jupnp.model.message.discovery.OutgoingNotificationRequest;
import org.jupnp.model.message.discovery.OutgoingNotificationRequestDeviceType;
import org.jupnp.model.message.discovery.OutgoingNotificationRequestRootDevice;
import org.jupnp.model.message.discovery.OutgoingNotificationRequestServiceType;
import org.jupnp.model.message.discovery.OutgoingNotificationRequestUDN;
import org.jupnp.model.meta.LocalDevice;
import org.jupnp.model.types.NotificationSubtype;
import org.jupnp.model.types.ServiceType;
import org.jupnp.protocol.SendingAsync;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SendingNotification extends SendingAsync {
    private LocalDevice device;
    private final j02 logger;

    public SendingNotification(UpnpService upnpService, LocalDevice localDevice) {
        super(upnpService);
        this.logger = n02.k(SendingNotification.class);
        this.device = localDevice;
    }

    public List<OutgoingNotificationRequest> createDeviceMessages(LocalDevice localDevice, Location location) {
        ArrayList arrayList = new ArrayList();
        if (localDevice.isRoot()) {
            arrayList.add(new OutgoingNotificationRequestRootDevice(location, localDevice, getNotificationSubtype()));
        }
        arrayList.add(new OutgoingNotificationRequestUDN(location, localDevice, getNotificationSubtype()));
        arrayList.add(new OutgoingNotificationRequestDeviceType(location, localDevice, getNotificationSubtype()));
        return arrayList;
    }

    public List<OutgoingNotificationRequest> createServiceTypeMessages(LocalDevice localDevice, Location location) {
        ArrayList arrayList = new ArrayList();
        for (ServiceType serviceType : localDevice.findServiceTypes()) {
            arrayList.add(new OutgoingNotificationRequestServiceType(location, localDevice, getNotificationSubtype(), serviceType));
        }
        return arrayList;
    }

    @Override // org.jupnp.protocol.SendingAsync
    public void execute() {
        List<NetworkAddress> activeStreamServers = getUpnpService().getRouter().getActiveStreamServers(null);
        if (activeStreamServers.isEmpty()) {
            this.logger.y("Aborting notifications, no active stream servers found (network disabled?)");
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<NetworkAddress> it = activeStreamServers.iterator();
        while (it.hasNext()) {
            arrayList.add(new Location(it.next(), getUpnpService().getConfiguration().getNamespace().getDescriptorPathString(getDevice())));
        }
        for (int i = 0; i < getBulkRepeat(); i++) {
            try {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    sendMessages((Location) it2.next());
                }
                this.logger.h("Sleeping {} milliseconds", Integer.valueOf(getBulkIntervalMilliseconds()));
                Thread.sleep(getBulkIntervalMilliseconds());
            } catch (InterruptedException e) {
                this.logger.u("Advertisement thread was interrupted", e);
            }
        }
    }

    public int getBulkIntervalMilliseconds() {
        return 150;
    }

    public int getBulkRepeat() {
        return 3;
    }

    public LocalDevice getDevice() {
        return this.device;
    }

    public abstract NotificationSubtype getNotificationSubtype();

    public void sendMessages(Location location) {
        this.logger.h("Sending root device messages: {}", getDevice());
        Iterator<OutgoingNotificationRequest> it = createDeviceMessages(getDevice(), location).iterator();
        while (it.hasNext()) {
            getUpnpService().getRouter().send(it.next());
        }
        if (getDevice().hasEmbeddedDevices()) {
            for (LocalDevice localDevice : getDevice().findEmbeddedDevices()) {
                this.logger.h("Sending embedded device messages: {}", localDevice);
                Iterator<OutgoingNotificationRequest> it2 = createDeviceMessages(localDevice, location).iterator();
                while (it2.hasNext()) {
                    getUpnpService().getRouter().send(it2.next());
                }
            }
        }
        List<OutgoingNotificationRequest> listCreateServiceTypeMessages = createServiceTypeMessages(getDevice(), location);
        if (listCreateServiceTypeMessages.isEmpty()) {
            return;
        }
        this.logger.y("Sending service type messages");
        Iterator<OutgoingNotificationRequest> it3 = listCreateServiceTypeMessages.iterator();
        while (it3.hasNext()) {
            getUpnpService().getRouter().send(it3.next());
        }
    }
}
