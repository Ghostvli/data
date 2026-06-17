package org.jupnp.support.igd;

import defpackage.j02;
import defpackage.n02;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jupnp.model.action.ActionInvocation;
import org.jupnp.model.message.UpnpResponse;
import org.jupnp.model.meta.Device;
import org.jupnp.model.meta.Service;
import org.jupnp.model.types.DeviceType;
import org.jupnp.model.types.ServiceType;
import org.jupnp.model.types.UDADeviceType;
import org.jupnp.model.types.UDAServiceType;
import org.jupnp.registry.DefaultRegistryListener;
import org.jupnp.registry.Registry;
import org.jupnp.support.igd.callback.PortMappingAdd;
import org.jupnp.support.igd.callback.PortMappingDelete;
import org.jupnp.support.model.PortMapping;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class PortMappingListener extends DefaultRegistryListener {
    protected Map<Service<?, ?>, List<PortMapping>> activePortMappings;
    private final j02 logger;
    protected PortMapping[] portMappings;
    public static final DeviceType IGD_DEVICE_TYPE = new UDADeviceType("InternetGatewayDevice", 1);
    public static final DeviceType CONNECTION_DEVICE_TYPE = new UDADeviceType("WANConnectionDevice", 1);
    public static final ServiceType IP_SERVICE_TYPE = new UDAServiceType("WANIPConnection", 1);
    public static final ServiceType PPP_SERVICE_TYPE = new UDAServiceType("WANPPPConnection", 1);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PortMappingListener(PortMapping[] portMappingArr) {
        this.logger = n02.k(PortMappingListener.class);
        this.activePortMappings = new HashMap();
        this.portMappings = portMappingArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.DefaultRegistryListener, org.jupnp.registry.RegistryListener
    public synchronized void beforeShutdown(Registry registry) throws Throwable {
        try {
            try {
                for (Map.Entry<Service<?, ?>, List<PortMapping>> entry : this.activePortMappings.entrySet()) {
                    final Iterator<PortMapping> it = entry.getValue().iterator();
                    while (it.hasNext()) {
                        final PortMapping next = it.next();
                        this.logger.q("Trying to delete port mapping on IGD: {}", next);
                        PortMappingListener portMappingListener = this;
                        new PortMappingDelete(portMappingListener, entry.getKey(), registry.getUpnpService().getControlPoint(), next) { // from class: org.jupnp.support.igd.PortMappingListener.2
                            final /* synthetic */ PortMappingListener this$0;

                            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                            {
                                this.this$0 = portMappingListener;
                            }

                            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                            @Override // org.jupnp.controlpoint.ActionCallback
                            public void failure(ActionInvocation actionInvocation, UpnpResponse upnpResponse, String str) {
                                this.this$0.handleFailureMessage("Failed to delete port mapping: ".concat(String.valueOf(next)));
                                this.this$0.handleFailureMessage("Reason: " + str);
                            }

                            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                            @Override // org.jupnp.controlpoint.ActionCallback
                            public void success(ActionInvocation actionInvocation) {
                                this.this$0.logger.q("Port mapping deleted: {}", next);
                                it.remove();
                            }
                        }.run();
                        this = portMappingListener;
                    }
                }
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            PortMappingListener portMappingListener2 = this;
            Throwable th22 = th;
            throw th22;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.DefaultRegistryListener
    public synchronized void deviceAdded(Registry registry, Device device) throws Throwable {
        PortMappingListener portMappingListener;
        try {
            try {
                Service<?, ?> serviceDiscoverConnectionService = discoverConnectionService(device);
                if (serviceDiscoverConnectionService != null) {
                    this.logger.q("Activating port mappings on: {}", serviceDiscoverConnectionService);
                    final ArrayList arrayList = new ArrayList();
                    PortMapping[] portMappingArr = this.portMappings;
                    int length = portMappingArr.length;
                    int i = 0;
                    while (i < length) {
                        final PortMapping portMapping = portMappingArr[i];
                        PortMappingListener portMappingListener2 = this;
                        new PortMappingAdd(portMappingListener2, serviceDiscoverConnectionService, registry.getUpnpService().getControlPoint(), portMapping) { // from class: org.jupnp.support.igd.PortMappingListener.1
                            final /* synthetic */ PortMappingListener this$0;

                            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                            {
                                this.this$0 = portMappingListener2;
                            }

                            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                            @Override // org.jupnp.controlpoint.ActionCallback
                            public void failure(ActionInvocation actionInvocation, UpnpResponse upnpResponse, String str) {
                                this.this$0.handleFailureMessage("Failed to add port mapping: ".concat(String.valueOf(portMapping)));
                                this.this$0.handleFailureMessage("Reason: " + str);
                            }

                            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                            @Override // org.jupnp.controlpoint.ActionCallback
                            public void success(ActionInvocation actionInvocation) {
                                this.this$0.logger.q("Port mapping added: {}", portMapping);
                                arrayList.add(portMapping);
                            }
                        }.run();
                        i++;
                        this = portMappingListener2;
                    }
                    PortMappingListener portMappingListener3 = this;
                    portMappingListener3.activePortMappings.put(serviceDiscoverConnectionService, arrayList);
                    return;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            portMappingListener = this;
        }
        Throwable th3 = th;
        throw th3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.DefaultRegistryListener
    public synchronized void deviceRemoved(Registry registry, Device device) {
        try {
            for (Service service : device.findServices()) {
                Iterator<Map.Entry<Service<?, ?>, List<PortMapping>>> it = this.activePortMappings.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Service<?, ?>, List<PortMapping>> next = it.next();
                    if (next.getKey().equals(service)) {
                        if (!next.getValue().isEmpty()) {
                            handleFailureMessage("Device disappeared, couldn't delete port mappings: " + next.getValue().size());
                        }
                        it.remove();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Service<?, ?> discoverConnectionService(Device<?, ?, ?> device) {
        if (!device.getType().equals(IGD_DEVICE_TYPE)) {
            return null;
        }
        DeviceType deviceType = CONNECTION_DEVICE_TYPE;
        Device[] deviceArrFindDevices = device.findDevices(deviceType);
        if (deviceArrFindDevices.length == 0) {
            this.logger.f("IGD doesn't support '{}': {}", deviceType, device);
            return null;
        }
        Device device2 = deviceArrFindDevices[0];
        this.logger.q("Using first discovered WAN connection device: {}", device2);
        Service<?, ?> serviceFindService = device2.findService(IP_SERVICE_TYPE);
        Service<?, ?> serviceFindService2 = device2.findService(PPP_SERVICE_TYPE);
        if (serviceFindService == null && serviceFindService2 == null) {
            this.logger.q("IGD doesn't support IP or PPP WAN connection service: {}", device);
        }
        return serviceFindService != null ? serviceFindService : serviceFindService2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void handleFailureMessage(String str) {
        this.logger.warn(str);
    }

    public PortMappingListener(PortMapping portMapping) {
        this(new PortMapping[]{portMapping});
    }
}
