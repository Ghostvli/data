package org.jupnp.android;

import android.os.Build;
import org.jupnp.DefaultUpnpServiceConfiguration;
import org.jupnp.binding.xml.DeviceDescriptorBinder;
import org.jupnp.binding.xml.RecoveringUDA10DeviceDescriptorBinderImpl;
import org.jupnp.binding.xml.ServiceDescriptorBinder;
import org.jupnp.binding.xml.UDA10ServiceDescriptorBinderSAXImpl;
import org.jupnp.model.Namespace;
import org.jupnp.model.ServerClientTokens;
import org.jupnp.transport.impl.GENAEventProcessorImpl;
import org.jupnp.transport.impl.SOAPActionProcessorImpl;
import org.jupnp.transport.impl.ServletStreamServerConfigurationImpl;
import org.jupnp.transport.impl.ServletStreamServerImpl;
import org.jupnp.transport.impl.jetty.JettyServletContainer;
import org.jupnp.transport.impl.jetty.JettyStreamClientImpl;
import org.jupnp.transport.impl.jetty.StreamClientConfigurationImpl;
import org.jupnp.transport.spi.GENAEventProcessor;
import org.jupnp.transport.spi.NetworkAddressFactory;
import org.jupnp.transport.spi.SOAPActionProcessor;
import org.jupnp.transport.spi.StreamClient;
import org.jupnp.transport.spi.StreamServer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AndroidUpnpServiceConfiguration extends DefaultUpnpServiceConfiguration {
    public AndroidUpnpServiceConfiguration(int i, int i2) {
        super(i, i2, false);
        System.setProperty("org.xml.sax.driver", "org.xmlpull.v1.sax2.Driver");
    }

    @Override // org.jupnp.DefaultUpnpServiceConfiguration
    public DeviceDescriptorBinder createDeviceDescriptorBinderUDA10() {
        return new RecoveringUDA10DeviceDescriptorBinderImpl();
    }

    @Override // org.jupnp.DefaultUpnpServiceConfiguration
    public GENAEventProcessor createGENAEventProcessor() {
        return new GENAEventProcessorImpl();
    }

    @Override // org.jupnp.DefaultUpnpServiceConfiguration
    public Namespace createNamespace() {
        return new Namespace("/upnp");
    }

    @Override // org.jupnp.DefaultUpnpServiceConfiguration
    public NetworkAddressFactory createNetworkAddressFactory(int i, int i2) {
        return new AndroidNetworkAddressFactory(i, i2);
    }

    @Override // org.jupnp.DefaultUpnpServiceConfiguration
    public SOAPActionProcessor createSOAPActionProcessor() {
        return new SOAPActionProcessorImpl();
    }

    @Override // org.jupnp.DefaultUpnpServiceConfiguration
    public ServiceDescriptorBinder createServiceDescriptorBinderUDA10() {
        return new UDA10ServiceDescriptorBinderSAXImpl();
    }

    @Override // org.jupnp.DefaultUpnpServiceConfiguration, org.jupnp.UpnpServiceConfiguration
    public StreamClient createStreamClient() {
        return new JettyStreamClientImpl(new StreamClientConfigurationImpl(getSyncProtocolExecutorService()) { // from class: org.jupnp.android.AndroidUpnpServiceConfiguration.1
            @Override // org.jupnp.transport.spi.AbstractStreamClientConfiguration, org.jupnp.transport.spi.StreamClientConfiguration
            public String getUserAgentValue(int i, int i2) {
                ServerClientTokens serverClientTokens = new ServerClientTokens(i, i2);
                serverClientTokens.setOsName("Android");
                serverClientTokens.setOsVersion(Build.VERSION.RELEASE);
                return serverClientTokens.toString();
            }
        });
    }

    @Override // org.jupnp.DefaultUpnpServiceConfiguration, org.jupnp.UpnpServiceConfiguration
    public StreamServer createStreamServer(NetworkAddressFactory networkAddressFactory) {
        return new ServletStreamServerImpl(new ServletStreamServerConfigurationImpl(JettyServletContainer.INSTANCE, networkAddressFactory.getStreamListenPort()));
    }

    @Override // org.jupnp.DefaultUpnpServiceConfiguration, org.jupnp.UpnpServiceConfiguration
    public int getRegistryMaintenanceIntervalMillis() {
        return 3000;
    }

    public AndroidUpnpServiceConfiguration() {
        this(0, 0);
    }
}
