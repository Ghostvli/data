package org.jupnp;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import org.jupnp.binding.xml.DeviceDescriptorBinder;
import org.jupnp.binding.xml.ServiceDescriptorBinder;
import org.jupnp.model.Namespace;
import org.jupnp.model.message.UpnpHeaders;
import org.jupnp.model.meta.RemoteDeviceIdentity;
import org.jupnp.model.meta.RemoteService;
import org.jupnp.model.types.ServiceType;
import org.jupnp.transport.spi.DatagramIO;
import org.jupnp.transport.spi.DatagramProcessor;
import org.jupnp.transport.spi.GENAEventProcessor;
import org.jupnp.transport.spi.MulticastReceiver;
import org.jupnp.transport.spi.NetworkAddressFactory;
import org.jupnp.transport.spi.SOAPActionProcessor;
import org.jupnp.transport.spi.StreamClient;
import org.jupnp.transport.spi.StreamServer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface UpnpServiceConfiguration {
    DatagramIO createDatagramIO(NetworkAddressFactory networkAddressFactory);

    MulticastReceiver createMulticastReceiver(NetworkAddressFactory networkAddressFactory);

    NetworkAddressFactory createNetworkAddressFactory();

    StreamClient createStreamClient();

    StreamServer createStreamServer(NetworkAddressFactory networkAddressFactory);

    int getAliveIntervalMillis();

    Executor getAsyncProtocolExecutor();

    Executor getDatagramIOExecutor();

    DatagramProcessor getDatagramProcessor();

    UpnpHeaders getDescriptorRetrievalHeaders(RemoteDeviceIdentity remoteDeviceIdentity);

    DeviceDescriptorBinder getDeviceDescriptorBinderUDA10();

    UpnpHeaders getEventSubscriptionHeaders(RemoteService remoteService);

    ServiceType[] getExclusiveServiceTypes();

    GENAEventProcessor getGenaEventProcessor();

    Executor getMulticastReceiverExecutor();

    Namespace getNamespace();

    Executor getRegistryListenerExecutor();

    Executor getRegistryMaintainerExecutor();

    int getRegistryMaintenanceIntervalMillis();

    Integer getRemoteDeviceMaxAgeSeconds();

    Executor getRemoteListenerExecutor();

    ServiceDescriptorBinder getServiceDescriptorBinderUDA10();

    SOAPActionProcessor getSoapActionProcessor();

    ExecutorService getStreamServerExecutorService();

    ExecutorService getSyncProtocolExecutorService();

    boolean isReceivedSubscriptionTimeoutIgnored();

    void shutdown();
}
