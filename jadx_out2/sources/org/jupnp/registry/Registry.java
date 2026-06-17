package org.jupnp.registry;

import java.net.URI;
import java.util.Collection;
import org.jupnp.UpnpService;
import org.jupnp.UpnpServiceConfiguration;
import org.jupnp.model.DiscoveryOptions;
import org.jupnp.model.ServiceReference;
import org.jupnp.model.gena.LocalGENASubscription;
import org.jupnp.model.gena.RemoteGENASubscription;
import org.jupnp.model.meta.Device;
import org.jupnp.model.meta.LocalDevice;
import org.jupnp.model.meta.RemoteDevice;
import org.jupnp.model.meta.RemoteDeviceIdentity;
import org.jupnp.model.meta.Service;
import org.jupnp.model.resource.Resource;
import org.jupnp.model.types.DeviceType;
import org.jupnp.model.types.ServiceType;
import org.jupnp.model.types.UDN;
import org.jupnp.protocol.ProtocolFactory;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface Registry {
    void addDevice(LocalDevice localDevice);

    void addDevice(LocalDevice localDevice, DiscoveryOptions discoveryOptions);

    void addDevice(RemoteDevice remoteDevice);

    void addListener(RegistryListener registryListener);

    void addLocalSubscription(LocalGENASubscription localGENASubscription);

    void addRemoteSubscription(RemoteGENASubscription remoteGENASubscription);

    void addResource(Resource resource);

    void addResource(Resource resource, int i);

    void advertiseLocalDevices();

    UpnpServiceConfiguration getConfiguration();

    Device getDevice(UDN udn, boolean z);

    Collection<Device> getDevices();

    Collection<Device> getDevices(DeviceType deviceType);

    Collection<Device> getDevices(ServiceType serviceType);

    DiscoveryOptions getDiscoveryOptions(UDN udn);

    Collection<RegistryListener> getListeners();

    LocalDevice getLocalDevice(UDN udn, boolean z);

    Collection<LocalDevice> getLocalDevices();

    LocalGENASubscription getLocalSubscription(String str);

    ProtocolFactory getProtocolFactory();

    RemoteDevice getRemoteDevice(UDN udn, boolean z);

    Collection<RemoteDevice> getRemoteDevices();

    RemoteGENASubscription getRemoteSubscription(String str);

    <T extends Resource> T getResource(Class<T> cls, URI uri);

    Resource getResource(URI uri);

    Collection<Resource> getResources();

    <T extends Resource> Collection<T> getResources(Class<T> cls);

    Service getService(ServiceReference serviceReference);

    UpnpService getUpnpService();

    RemoteGENASubscription getWaitRemoteSubscription(String str);

    boolean isPaused();

    void notifyDiscoveryFailure(RemoteDevice remoteDevice, Exception exc);

    boolean notifyDiscoveryStart(RemoteDevice remoteDevice);

    void pause();

    void registerPendingRemoteSubscription(RemoteGENASubscription remoteGENASubscription);

    void removeAllLocalDevices();

    void removeAllRemoteDevices();

    boolean removeDevice(LocalDevice localDevice);

    boolean removeDevice(RemoteDevice remoteDevice);

    boolean removeDevice(UDN udn);

    void removeListener(RegistryListener registryListener);

    boolean removeLocalSubscription(LocalGENASubscription localGENASubscription);

    void removeRemoteSubscription(RemoteGENASubscription remoteGENASubscription);

    boolean removeResource(Resource resource);

    void resume();

    void setDiscoveryOptions(UDN udn, DiscoveryOptions discoveryOptions);

    void shutdown();

    void unregisterPendingRemoteSubscription(RemoteGENASubscription remoteGENASubscription);

    boolean update(RemoteDeviceIdentity remoteDeviceIdentity);

    boolean updateLocalSubscription(LocalGENASubscription localGENASubscription);

    void updateRemoteSubscription(RemoteGENASubscription remoteGENASubscription);
}
