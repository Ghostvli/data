package org.jupnp;

import org.jupnp.model.message.header.STAllHeader;
import org.jupnp.model.meta.LocalDevice;
import org.jupnp.model.meta.RemoteDevice;
import org.jupnp.registry.Registry;
import org.jupnp.registry.RegistryListener;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Main {
    public static void main(String[] strArr) throws InterruptedException {
        RegistryListener registryListener = new RegistryListener() { // from class: org.jupnp.Main.1
            @Override // org.jupnp.registry.RegistryListener
            public void afterShutdown() {
                System.out.println("Shutdown of registry complete!");
            }

            @Override // org.jupnp.registry.RegistryListener
            public void beforeShutdown(Registry registry) {
                System.out.println("Before shutdown, the registry has devices: " + registry.getDevices().size());
            }

            @Override // org.jupnp.registry.RegistryListener
            public void localDeviceAdded(Registry registry, LocalDevice localDevice) {
                System.out.println("Local device added: " + localDevice.getDisplayString());
            }

            @Override // org.jupnp.registry.RegistryListener
            public void localDeviceRemoved(Registry registry, LocalDevice localDevice) {
                System.out.println("Local device removed: " + localDevice.getDisplayString());
            }

            @Override // org.jupnp.registry.RegistryListener
            public void remoteDeviceAdded(Registry registry, RemoteDevice remoteDevice) {
                System.out.println("Remote device available: " + remoteDevice.getDisplayString());
            }

            @Override // org.jupnp.registry.RegistryListener
            public void remoteDeviceDiscoveryFailed(Registry registry, RemoteDevice remoteDevice, Exception exc) {
                System.out.println("Discovery failed: " + remoteDevice.getDisplayString() + " => " + String.valueOf(exc));
            }

            @Override // org.jupnp.registry.RegistryListener
            public void remoteDeviceDiscoveryStarted(Registry registry, RemoteDevice remoteDevice) {
                System.out.println("Discovery started: " + remoteDevice.getDisplayString());
            }

            @Override // org.jupnp.registry.RegistryListener
            public void remoteDeviceRemoved(Registry registry, RemoteDevice remoteDevice) {
                System.out.println("Remote device removed: " + remoteDevice.getDisplayString());
            }

            @Override // org.jupnp.registry.RegistryListener
            public void remoteDeviceUpdated(Registry registry, RemoteDevice remoteDevice) {
                System.out.println("Remote device updated: " + remoteDevice.getDisplayString());
            }
        };
        System.out.println("Starting jUPnP...");
        UpnpServiceImpl upnpServiceImpl = new UpnpServiceImpl(new DefaultUpnpServiceConfiguration());
        upnpServiceImpl.startup();
        upnpServiceImpl.getRegistry().addListener(registryListener);
        System.out.println("Sending SEARCH message to all devices...");
        upnpServiceImpl.getControlPoint().search(new STAllHeader());
        System.out.println("Waiting 10 seconds before shutting down...");
        Thread.sleep(10000L);
        System.out.println("Stopping jUPnP...");
        upnpServiceImpl.shutdown();
    }
}
