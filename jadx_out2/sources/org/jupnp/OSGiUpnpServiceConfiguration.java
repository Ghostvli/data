package org.jupnp;

import defpackage.j02;
import defpackage.n02;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.jupnp.binding.xml.DeviceDescriptorBinder;
import org.jupnp.binding.xml.RecoveringUDA10DeviceDescriptorBinderImpl;
import org.jupnp.binding.xml.RecoveringUDA10ServiceDescriptorBinderSAXImpl;
import org.jupnp.binding.xml.ServiceDescriptorBinder;
import org.jupnp.model.ModelUtil;
import org.jupnp.model.Namespace;
import org.jupnp.model.message.UpnpHeaders;
import org.jupnp.model.meta.RemoteDeviceIdentity;
import org.jupnp.model.meta.RemoteService;
import org.jupnp.model.types.ServiceType;
import org.jupnp.transport.TransportConfiguration;
import org.jupnp.transport.TransportConfigurationProvider;
import org.jupnp.transport.impl.DatagramIOConfigurationImpl;
import org.jupnp.transport.impl.DatagramIOImpl;
import org.jupnp.transport.impl.DatagramProcessorImpl;
import org.jupnp.transport.impl.GENAEventProcessorImpl;
import org.jupnp.transport.impl.MulticastReceiverConfigurationImpl;
import org.jupnp.transport.impl.MulticastReceiverImpl;
import org.jupnp.transport.impl.NetworkAddressFactoryImpl;
import org.jupnp.transport.impl.SOAPActionProcessorImpl;
import org.jupnp.transport.impl.ServletStreamServerConfigurationImpl;
import org.jupnp.transport.impl.ServletStreamServerImpl;
import org.jupnp.transport.impl.jetty.StreamClientConfigurationImpl;
import org.jupnp.transport.impl.osgi.HttpServiceServletContainerAdapter;
import org.jupnp.transport.spi.DatagramIO;
import org.jupnp.transport.spi.DatagramProcessor;
import org.jupnp.transport.spi.GENAEventProcessor;
import org.jupnp.transport.spi.MulticastReceiver;
import org.jupnp.transport.spi.NetworkAddressFactory;
import org.jupnp.transport.spi.SOAPActionProcessor;
import org.jupnp.transport.spi.StreamClient;
import org.jupnp.transport.spi.StreamClientConfiguration;
import org.jupnp.transport.spi.StreamServer;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.http.HttpService;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
@Component(configurationPid = {"org.jupnp"}, configurationPolicy = ConfigurationPolicy.REQUIRE, enabled = false)
public class OSGiUpnpServiceConfiguration implements UpnpServiceConfiguration {
    protected static final String OSGI_SERVICE_HTTP_PORT = "org.osgi.service.http.port";
    protected ExecutorService asyncExecutorService;
    protected boolean asyncThreadPool;
    protected int asyncThreadPoolSize;
    protected Namespace callbackURI;
    protected BundleContext context;
    protected DatagramProcessor datagramProcessor;
    protected DeviceDescriptorBinder deviceDescriptorBinderUDA10;
    protected GENAEventProcessor genaEventProcessor;
    protected int httpProxyPort;
    protected HttpService httpService;
    protected String interfaces;
    private final j02 logger;
    protected ExecutorService mainExecutorService;
    protected boolean mainThreadPool;
    protected int multicastResponsePort;
    protected Namespace namespace;
    protected ExecutorService remoteExecutorService;
    protected boolean remoteThreadPool;
    protected int remoteThreadPoolSize;
    protected Integer retryAfterSeconds;
    protected Integer retryIterations;
    protected ServiceDescriptorBinder serviceDescriptorBinderUDA10;
    protected SOAPActionProcessor soapActionProcessor;
    protected int streamListenPort;
    protected int threadPoolSize;
    protected Integer timeoutSeconds;
    protected TransportConfiguration transportConfiguration;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public OSGiUpnpServiceConfiguration(int i, int i2, boolean z) {
        this.logger = n02.k(OSGiUpnpServiceConfiguration.class);
        this.threadPoolSize = 20;
        this.asyncThreadPoolSize = 20;
        this.remoteThreadPoolSize = 40;
        this.httpProxyPort = -1;
        this.streamListenPort = 8080;
        this.asyncThreadPool = true;
        this.mainThreadPool = true;
        this.remoteThreadPool = true;
        this.callbackURI = new Namespace("http://localhost/upnpcallback");
        this.timeoutSeconds = 10;
        this.retryIterations = 5;
        this.retryAfterSeconds = 600;
        if (z && ModelUtil.ANDROID_RUNTIME) {
            throw new Error("Unsupported runtime environment, use org.jupnp.android.AndroidUpnpServiceConfiguration");
        }
        this.streamListenPort = i;
        this.multicastResponsePort = i2;
        this.transportConfiguration = TransportConfigurationProvider.getDefaultTransportConfiguration();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private StreamClientConfiguration createStreamClientConfiguration() {
        return new StreamClientConfigurationImpl(this.asyncExecutorService, this.timeoutSeconds.intValue(), 5, this.retryAfterSeconds.intValue(), this.retryIterations.intValue());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Activate
    public void activate(BundleContext bundleContext, Map<String, Object> map) {
        this.context = bundleContext;
        setConfigValues(map);
        createExecutorServices();
        this.datagramProcessor = createDatagramProcessor();
        this.soapActionProcessor = createSOAPActionProcessor();
        this.genaEventProcessor = createGENAEventProcessor();
        this.deviceDescriptorBinderUDA10 = createDeviceDescriptorBinderUDA10();
        this.serviceDescriptorBinderUDA10 = createServiceDescriptorBinderUDA10();
        this.namespace = createNamespace();
        this.logger.q("{} activated", this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ExecutorService createAsyncProtocolExecutorService() {
        return QueueingThreadPoolExecutor.createInstance("upnp-async", this.asyncThreadPoolSize);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public DatagramIO createDatagramIO(NetworkAddressFactory networkAddressFactory) {
        return new DatagramIOImpl(new DatagramIOConfigurationImpl());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DatagramProcessor createDatagramProcessor() {
        return new DatagramProcessorImpl();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DeviceDescriptorBinder createDeviceDescriptorBinderUDA10() {
        return new RecoveringUDA10DeviceDescriptorBinderImpl();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void createExecutorServices() {
        boolean z = this.mainThreadPool;
        j02 j02Var = this.logger;
        if (z) {
            j02Var.b("Creating mainThreadPool");
            this.mainExecutorService = createMainExecutorService();
        } else {
            j02Var.b("Skipping mainThreadPool creation.");
        }
        boolean z2 = this.asyncThreadPool;
        j02 j02Var2 = this.logger;
        if (z2) {
            j02Var2.b("Creating asyncThreadPool");
            this.asyncExecutorService = createAsyncProtocolExecutorService();
        } else {
            j02Var2.b("Skipping asyncThreadPool creation.");
        }
        boolean z3 = this.remoteThreadPool;
        j02 j02Var3 = this.logger;
        if (!z3) {
            j02Var3.b("Skipping remoteThreadPool creation.");
        } else {
            j02Var3.b("Creating remoteThreadPool");
            this.remoteExecutorService = createRemoteProtocolExecutorService();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public GENAEventProcessor createGENAEventProcessor() {
        return new GENAEventProcessorImpl();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ExecutorService createMainExecutorService() {
        return QueueingThreadPoolExecutor.createInstance("upnp-main", this.threadPoolSize);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public MulticastReceiver createMulticastReceiver(NetworkAddressFactory networkAddressFactory) {
        return new MulticastReceiverImpl(new MulticastReceiverConfigurationImpl(networkAddressFactory.getMulticastGroup(), networkAddressFactory.getMulticastPort()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Namespace createNamespace() {
        return this.callbackURI;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public NetworkAddressFactory createNetworkAddressFactory() {
        return createNetworkAddressFactory(this.streamListenPort, this.multicastResponsePort);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ExecutorService createRemoteProtocolExecutorService() {
        return QueueingThreadPoolExecutor.createInstance("upnp-remote", this.remoteThreadPoolSize);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SOAPActionProcessor createSOAPActionProcessor() {
        return new SOAPActionProcessorImpl();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ServiceDescriptorBinder createServiceDescriptorBinderUDA10() {
        return new RecoveringUDA10ServiceDescriptorBinderSAXImpl();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public StreamClient createStreamClient() {
        return this.transportConfiguration.createStreamClient(getSyncProtocolExecutorService(), createStreamClientConfiguration());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public StreamServer createStreamServer(NetworkAddressFactory networkAddressFactory) {
        HttpService httpService = this.httpService;
        j02 j02Var = this.logger;
        if (httpService == null) {
            j02Var.b("createStreamServer without OSGi HttpService");
            return this.transportConfiguration.createStreamServer(networkAddressFactory.getStreamListenPort());
        }
        j02Var.b("createStreamServer using OSGi HttpService");
        HttpServiceServletContainerAdapter httpServiceServletContainerAdapter = HttpServiceServletContainerAdapter.getInstance(this.httpService, this.context);
        int port = this.httpProxyPort;
        if (port == -1) {
            port = this.callbackURI.getBasePath().getPort();
        }
        return new ServletStreamServerImpl(new ServletStreamServerConfigurationImpl(httpServiceServletContainerAdapter, port));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Deactivate
    public void deactivate() {
        shutdown();
        this.logger.q("{} deactivated", this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public int getAliveIntervalMillis() {
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: getAsyncProtocolExecutor()Ljava/util/concurrent/Executor; */
    @Override // org.jupnp.UpnpServiceConfiguration
    public ExecutorService getAsyncProtocolExecutor() {
        return this.asyncThreadPool ? this.asyncExecutorService : Executors.newCachedThreadPool();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public DatagramProcessor getDatagramProcessor() {
        return this.datagramProcessor;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public UpnpHeaders getDescriptorRetrievalHeaders(RemoteDeviceIdentity remoteDeviceIdentity) {
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public DeviceDescriptorBinder getDeviceDescriptorBinderUDA10() {
        return this.deviceDescriptorBinderUDA10;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public UpnpHeaders getEventSubscriptionHeaders(RemoteService remoteService) {
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public ServiceType[] getExclusiveServiceTypes() {
        return new ServiceType[0];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public GENAEventProcessor getGenaEventProcessor() {
        return this.genaEventProcessor;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ExecutorService getMainExecutorService() {
        return this.mainThreadPool ? this.mainExecutorService : Executors.newCachedThreadPool();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public Namespace getNamespace() {
        return this.namespace;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public Executor getRegistryListenerExecutor() {
        return getMainExecutorService();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public Executor getRegistryMaintainerExecutor() {
        return getMainExecutorService();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public int getRegistryMaintenanceIntervalMillis() {
        return 1000;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public Integer getRemoteDeviceMaxAgeSeconds() {
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ExecutorService getRemoteExecutorService() {
        return this.remoteThreadPool ? this.remoteExecutorService : Executors.newCachedThreadPool();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public Executor getRemoteListenerExecutor() {
        return getRemoteExecutorService();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public ServiceDescriptorBinder getServiceDescriptorBinderUDA10() {
        return this.serviceDescriptorBinderUDA10;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public SOAPActionProcessor getSoapActionProcessor() {
        return this.soapActionProcessor;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public ExecutorService getStreamServerExecutorService() {
        return getMainExecutorService();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public ExecutorService getSyncProtocolExecutorService() {
        return getMainExecutorService();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public boolean isReceivedSubscriptionTimeoutIgnored() {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setConfigValues(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        Object obj = map.get("threadPoolSize");
        if (obj instanceof String) {
            try {
                int i = Integer.parseInt((String) obj);
                this.threadPoolSize = i;
                this.mainThreadPool = i != -1;
            } catch (NumberFormatException unused) {
                this.logger.o("Invalid value '{}' for threadPoolSize - using default value '{}'", obj, Integer.valueOf(this.threadPoolSize));
            }
        }
        this.logger.A("OSGiUpnpServiceConfiguration createConfiguration threadPoolSize = {} {}", Integer.valueOf(this.threadPoolSize), Boolean.valueOf(this.mainThreadPool));
        Object obj2 = map.get("asyncThreadPoolSize");
        if (obj2 instanceof String) {
            try {
                int i2 = Integer.parseInt((String) obj2);
                this.asyncThreadPoolSize = i2;
                this.asyncThreadPool = i2 != -1;
            } catch (NumberFormatException unused2) {
                this.logger.o("Invalid value '{}' for asyncThreadPoolSize - using default value '{}'", obj2, Integer.valueOf(this.asyncThreadPoolSize));
            }
        }
        this.logger.A("OSGiUpnpServiceConfiguration createConfiguration asyncThreadPoolSize = {} {}", Integer.valueOf(this.asyncThreadPoolSize), Boolean.valueOf(this.asyncThreadPool));
        Object obj3 = map.get("multicastResponsePort");
        if (obj3 instanceof String) {
            try {
                this.multicastResponsePort = Integer.parseInt((String) obj3);
            } catch (NumberFormatException unused3) {
                this.logger.o("Invalid value '{}' for multicastResponsePort - using default value '{}'", obj3, Integer.valueOf(this.multicastResponsePort));
            }
        } else if (obj3 instanceof Integer) {
            this.multicastResponsePort = ((Integer) obj3).intValue();
        }
        Object obj4 = map.get("streamListenPort");
        if (obj4 instanceof String) {
            try {
                this.streamListenPort = Integer.parseInt((String) obj4);
            } catch (NumberFormatException unused4) {
                this.logger.o("Invalid value '{}' for streamListenPort - using default value '{}'", obj4, Integer.valueOf(this.streamListenPort));
            }
        } else if (obj4 instanceof Integer) {
            this.streamListenPort = ((Integer) obj4).intValue();
        } else if (System.getProperty(OSGI_SERVICE_HTTP_PORT) != null) {
            try {
                this.streamListenPort = Integer.parseInt(System.getProperty(OSGI_SERVICE_HTTP_PORT));
            } catch (NumberFormatException unused5) {
                this.logger.f("Invalid value '{}' for osgi.http.port - using default value '{}'", obj4, Integer.valueOf(this.streamListenPort));
            }
        }
        Object obj5 = map.get("interfaces");
        if (obj5 instanceof String) {
            this.interfaces = (String) obj5;
        }
        this.logger.c("OSGiUpnpServiceConfiguration interfaces = {}", this.interfaces);
        Object obj6 = map.get("callbackURI");
        if (obj6 instanceof String) {
            try {
                this.callbackURI = new Namespace((String) obj6);
            } catch (Exception unused6) {
                this.logger.o("Invalid value '{}' for callbackURI - using default value '{}'", obj6, this.callbackURI);
            }
        }
        Object obj7 = map.get("httpProxyPort");
        if (obj7 instanceof String) {
            try {
                this.httpProxyPort = Integer.parseInt((String) obj7);
            } catch (NumberFormatException unused7) {
                this.logger.o("Invalid value '{}' for httpProxyPort - using default value '{}'", obj7, Integer.valueOf(this.httpProxyPort));
            }
        } else if (obj7 instanceof Integer) {
            this.httpProxyPort = ((Integer) obj7).intValue();
        }
        Object obj8 = map.get("retryAfterSeconds");
        if (obj8 instanceof String) {
            try {
                this.retryAfterSeconds = Integer.valueOf((String) obj8);
            } catch (NumberFormatException unused8) {
                this.logger.r("Invalid value '{}' for retryAfterSeconds - using default value", obj8);
            }
        } else if (obj8 instanceof Integer) {
            this.retryAfterSeconds = (Integer) obj8;
        }
        this.logger.c("OSGiUpnpServiceConfiguration retryAfterSeconds = {}", this.retryAfterSeconds);
        Object obj9 = map.get("retryIterations");
        if (obj9 instanceof String) {
            try {
                this.retryIterations = Integer.valueOf((String) obj9);
            } catch (NumberFormatException unused9) {
                this.logger.r("Invalid value '{}' for retryIterations - using default value", obj9);
            }
        } else if (obj9 instanceof Integer) {
            this.retryIterations = (Integer) obj9;
        }
        this.logger.c("OSGiUpnpServiceConfiguration retryIterations = {}", this.retryIterations);
        Object obj10 = map.get("timeoutSeconds");
        if (obj10 instanceof String) {
            try {
                this.timeoutSeconds = Integer.valueOf((String) obj10);
            } catch (NumberFormatException unused10) {
                this.logger.r("Invalid value '{}' for timeoutSeconds - using default value", obj10);
            }
        } else if (obj10 instanceof Integer) {
            this.timeoutSeconds = (Integer) obj10;
        }
        this.logger.c("OSGiUpnpServiceConfiguration timeoutSeconds = {}", this.timeoutSeconds);
        if (this.mainThreadPool && this.asyncThreadPool) {
            this.remoteThreadPool = true;
            this.remoteThreadPoolSize = this.threadPoolSize + this.asyncThreadPoolSize;
        } else {
            this.remoteThreadPool = false;
            this.remoteThreadPoolSize = -1;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Reference
    public void setHttpService(HttpService httpService) {
        this.httpService = httpService;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public void shutdown() {
        this.logger.b("Shutting down executor services");
        shutdownExecutorServices();
        createExecutorServices();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void shutdownExecutorServices() {
        ExecutorService executorService = this.mainExecutorService;
        if (executorService != null) {
            executorService.shutdownNow();
        }
        ExecutorService executorService2 = this.asyncExecutorService;
        if (executorService2 != null) {
            executorService2.shutdownNow();
        }
        ExecutorService executorService3 = this.remoteExecutorService;
        if (executorService3 != null) {
            executorService3.shutdownNow();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void unsetHttpService(HttpService httpService) {
        this.httpService = null;
    }

    /* JADX DEBUG: Method merged with bridge method: getDatagramIOExecutor()Ljava/util/concurrent/Executor; */
    @Override // org.jupnp.UpnpServiceConfiguration
    public ExecutorService getDatagramIOExecutor() {
        return getMainExecutorService();
    }

    /* JADX DEBUG: Method merged with bridge method: getMulticastReceiverExecutor()Ljava/util/concurrent/Executor; */
    @Override // org.jupnp.UpnpServiceConfiguration
    public ExecutorService getMulticastReceiverExecutor() {
        return getMainExecutorService();
    }

    public NetworkAddressFactory createNetworkAddressFactory(int i, int i2) {
        return new NetworkAddressFactoryImpl(i, i2, this.interfaces);
    }

    public OSGiUpnpServiceConfiguration(int i) {
        this(i, 0, true);
    }

    public OSGiUpnpServiceConfiguration(int i, int i2) {
        this(i, i2, true);
    }

    public OSGiUpnpServiceConfiguration(boolean z) {
        this(0, 0, z);
    }

    public OSGiUpnpServiceConfiguration() {
        this(0);
    }
}
