package org.jupnp.protocol.async;

import defpackage.j02;
import defpackage.n02;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.jupnp.UpnpService;
import org.jupnp.model.DiscoveryOptions;
import org.jupnp.model.Location;
import org.jupnp.model.NetworkAddress;
import org.jupnp.model.message.IncomingDatagramMessage;
import org.jupnp.model.message.UpnpRequest;
import org.jupnp.model.message.discovery.IncomingSearchRequest;
import org.jupnp.model.message.discovery.OutgoingSearchResponse;
import org.jupnp.model.message.discovery.OutgoingSearchResponseDeviceType;
import org.jupnp.model.message.discovery.OutgoingSearchResponseRootDevice;
import org.jupnp.model.message.discovery.OutgoingSearchResponseServiceType;
import org.jupnp.model.message.discovery.OutgoingSearchResponseUDN;
import org.jupnp.model.message.header.DeviceTypeHeader;
import org.jupnp.model.message.header.MXHeader;
import org.jupnp.model.message.header.RootDeviceHeader;
import org.jupnp.model.message.header.STAllHeader;
import org.jupnp.model.message.header.ServiceTypeHeader;
import org.jupnp.model.message.header.UDNHeader;
import org.jupnp.model.message.header.UpnpHeader;
import org.jupnp.model.meta.Device;
import org.jupnp.model.meta.LocalDevice;
import org.jupnp.model.types.DeviceType;
import org.jupnp.model.types.ServiceType;
import org.jupnp.model.types.UDN;
import org.jupnp.protocol.ReceivingAsync;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ReceivingSearch extends ReceivingAsync<IncomingSearchRequest> {
    private final boolean LOG_ENABLED;
    private final j02 logger;
    protected final Random randomGenerator;

    public ReceivingSearch(UpnpService upnpService, IncomingDatagramMessage<UpnpRequest> incomingDatagramMessage) {
        super(upnpService, new IncomingSearchRequest(incomingDatagramMessage));
        j02 j02VarK = n02.k(ReceivingSearch.class);
        this.logger = j02VarK;
        this.LOG_ENABLED = j02VarK.n();
        this.randomGenerator = new Random();
    }

    public List<OutgoingSearchResponse> createDeviceMessages(LocalDevice localDevice, NetworkAddress networkAddress) {
        ArrayList arrayList = new ArrayList();
        if (localDevice.isRoot()) {
            arrayList.add(new OutgoingSearchResponseRootDevice(getInputMessage(), getDescriptorLocation(networkAddress, localDevice), localDevice));
        }
        arrayList.add(new OutgoingSearchResponseUDN(getInputMessage(), getDescriptorLocation(networkAddress, localDevice), localDevice));
        arrayList.add(new OutgoingSearchResponseDeviceType(getInputMessage(), getDescriptorLocation(networkAddress, localDevice), localDevice));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            prepareOutgoingSearchResponse((OutgoingSearchResponse) it.next());
        }
        return arrayList;
    }

    public List<OutgoingSearchResponse> createServiceTypeMessages(LocalDevice localDevice, NetworkAddress networkAddress) {
        ArrayList arrayList = new ArrayList();
        for (ServiceType serviceType : localDevice.findServiceTypes()) {
            OutgoingSearchResponseServiceType outgoingSearchResponseServiceType = new OutgoingSearchResponseServiceType(getInputMessage(), getDescriptorLocation(networkAddress, localDevice), localDevice, serviceType);
            prepareOutgoingSearchResponse(outgoingSearchResponseServiceType);
            arrayList.add(outgoingSearchResponseServiceType);
        }
        return arrayList;
    }

    @Override // org.jupnp.protocol.ReceivingAsync
    public void execute() {
        if (getUpnpService().getRouter() == null) {
            this.logger.y("Router hasn't completed initialization, ignoring received search message");
            return;
        }
        if (!getInputMessage().isMANSSDPDiscover()) {
            this.logger.h("Invalid search request, no or invalid MAN ssdp:discover header: {}", getInputMessage());
            return;
        }
        UpnpHeader searchTarget = getInputMessage().getSearchTarget();
        if (searchTarget == null) {
            this.logger.h("Invalid search request, did not contain ST header: {}", getInputMessage());
            return;
        }
        List<NetworkAddress> activeStreamServers = getUpnpService().getRouter().getActiveStreamServers(getInputMessage().getLocalAddress());
        if (activeStreamServers.isEmpty()) {
            this.logger.y("Aborting search response, no active stream servers found (network disabled?)");
            return;
        }
        Iterator<NetworkAddress> it = activeStreamServers.iterator();
        while (it.hasNext()) {
            sendResponses(searchTarget, it.next());
        }
    }

    public Location getDescriptorLocation(NetworkAddress networkAddress, LocalDevice localDevice) {
        return new Location(networkAddress, getUpnpService().getConfiguration().getNamespace().getDescriptorPathString(localDevice));
    }

    public boolean isAdvertisementDisabled(LocalDevice localDevice) {
        DiscoveryOptions discoveryOptions = getUpnpService().getRegistry().getDiscoveryOptions(localDevice.getIdentity().getUdn());
        return (discoveryOptions == null || discoveryOptions.isAdvertised()) ? false : true;
    }

    public void prepareOutgoingSearchResponse(OutgoingSearchResponse outgoingSearchResponse) {
    }

    public void sendResponses(UpnpHeader upnpHeader, NetworkAddress networkAddress) {
        if (upnpHeader instanceof STAllHeader) {
            sendSearchResponseAll(networkAddress);
            return;
        }
        if (upnpHeader instanceof RootDeviceHeader) {
            sendSearchResponseRootDevices(networkAddress);
            return;
        }
        if (upnpHeader instanceof UDNHeader) {
            sendSearchResponseUDN((UDN) upnpHeader.getValue(), networkAddress);
            return;
        }
        if (upnpHeader instanceof DeviceTypeHeader) {
            sendSearchResponseDeviceType((DeviceType) upnpHeader.getValue(), networkAddress);
        } else if (upnpHeader instanceof ServiceTypeHeader) {
            sendSearchResponseServiceType((ServiceType) upnpHeader.getValue(), networkAddress);
        } else {
            this.logger.d("Non-implemented search request target: {}", upnpHeader.getClass());
        }
    }

    public void sendSearchResponseAll(NetworkAddress networkAddress) {
        if (this.LOG_ENABLED) {
            this.logger.y("Responding to 'all' search with advertisement messages for all local devices");
        }
        for (LocalDevice localDevice : getUpnpService().getRegistry().getLocalDevices()) {
            if (!isAdvertisementDisabled(localDevice)) {
                if (this.LOG_ENABLED) {
                    this.logger.h("Sending root device messages: {}", localDevice);
                }
                Iterator<OutgoingSearchResponse> it = createDeviceMessages(localDevice, networkAddress).iterator();
                while (it.hasNext()) {
                    getUpnpService().getRouter().send(it.next());
                }
                if (localDevice.hasEmbeddedDevices()) {
                    for (LocalDevice localDevice2 : localDevice.findEmbeddedDevices()) {
                        if (this.LOG_ENABLED) {
                            this.logger.h("Sending embedded device messages: {}", localDevice2);
                        }
                        Iterator<OutgoingSearchResponse> it2 = createDeviceMessages(localDevice2, networkAddress).iterator();
                        while (it2.hasNext()) {
                            getUpnpService().getRouter().send(it2.next());
                        }
                    }
                }
                List<OutgoingSearchResponse> listCreateServiceTypeMessages = createServiceTypeMessages(localDevice, networkAddress);
                if (!listCreateServiceTypeMessages.isEmpty()) {
                    if (this.LOG_ENABLED) {
                        this.logger.y("Sending service type messages");
                    }
                    Iterator<OutgoingSearchResponse> it3 = listCreateServiceTypeMessages.iterator();
                    while (it3.hasNext()) {
                        getUpnpService().getRouter().send(it3.next());
                    }
                }
            }
        }
    }

    public void sendSearchResponseDeviceType(DeviceType deviceType, NetworkAddress networkAddress) {
        this.logger.h("Responding to device type search: {}", deviceType);
        for (Device device : getUpnpService().getRegistry().getDevices(deviceType)) {
            if (device instanceof LocalDevice) {
                LocalDevice localDevice = (LocalDevice) device;
                if (!isAdvertisementDisabled(localDevice)) {
                    this.logger.h("Sending matching device type search result for: {}", device);
                    OutgoingSearchResponseDeviceType outgoingSearchResponseDeviceType = new OutgoingSearchResponseDeviceType(getInputMessage(), getDescriptorLocation(networkAddress, localDevice), localDevice);
                    prepareOutgoingSearchResponse(outgoingSearchResponseDeviceType);
                    getUpnpService().getRouter().send(outgoingSearchResponseDeviceType);
                }
            }
        }
    }

    public void sendSearchResponseRootDevices(NetworkAddress networkAddress) {
        this.logger.y("Responding to root device search with advertisement messages for all local root devices");
        for (LocalDevice localDevice : getUpnpService().getRegistry().getLocalDevices()) {
            if (!isAdvertisementDisabled(localDevice)) {
                OutgoingSearchResponseRootDevice outgoingSearchResponseRootDevice = new OutgoingSearchResponseRootDevice(getInputMessage(), getDescriptorLocation(networkAddress, localDevice), localDevice);
                prepareOutgoingSearchResponse(outgoingSearchResponseRootDevice);
                getUpnpService().getRouter().send(outgoingSearchResponseRootDevice);
            }
        }
    }

    public void sendSearchResponseServiceType(ServiceType serviceType, NetworkAddress networkAddress) {
        this.logger.h("Responding to service type search: {}", serviceType);
        for (Device device : getUpnpService().getRegistry().getDevices(serviceType)) {
            if (device instanceof LocalDevice) {
                LocalDevice localDevice = (LocalDevice) device;
                if (!isAdvertisementDisabled(localDevice)) {
                    this.logger.h("Sending matching service type search result: {}", device);
                    OutgoingSearchResponseServiceType outgoingSearchResponseServiceType = new OutgoingSearchResponseServiceType(getInputMessage(), getDescriptorLocation(networkAddress, localDevice), localDevice, serviceType);
                    prepareOutgoingSearchResponse(outgoingSearchResponseServiceType);
                    getUpnpService().getRouter().send(outgoingSearchResponseServiceType);
                }
            }
        }
    }

    public void sendSearchResponseUDN(UDN udn, NetworkAddress networkAddress) {
        Device device = getUpnpService().getRegistry().getDevice(udn, false);
        if (device == null || !(device instanceof LocalDevice)) {
            return;
        }
        LocalDevice localDevice = (LocalDevice) device;
        if (isAdvertisementDisabled(localDevice)) {
            return;
        }
        this.logger.h("Responding to UDN device search: {}", udn);
        OutgoingSearchResponseUDN outgoingSearchResponseUDN = new OutgoingSearchResponseUDN(getInputMessage(), getDescriptorLocation(networkAddress, localDevice), localDevice);
        prepareOutgoingSearchResponse(outgoingSearchResponseUDN);
        getUpnpService().getRouter().send(outgoingSearchResponseUDN);
    }

    @Override // org.jupnp.protocol.ReceivingAsync
    public boolean waitBeforeExecution() throws InterruptedException {
        Integer mx = getInputMessage().getMX();
        if (mx == null) {
            this.logger.h("Invalid search request, did not contain MX header: {}", getInputMessage());
            return false;
        }
        if (mx.intValue() > 120 || mx.intValue() <= 0) {
            mx = MXHeader.DEFAULT_VALUE;
        }
        if (getUpnpService().getRegistry().getLocalDevices().isEmpty()) {
            return true;
        }
        int iNextInt = this.randomGenerator.nextInt(mx.intValue() * 1000);
        this.logger.h("Sleeping {} milliseconds to avoid flooding with search responses", Integer.valueOf(iNextInt));
        Thread.sleep(iNextInt);
        return true;
    }
}
