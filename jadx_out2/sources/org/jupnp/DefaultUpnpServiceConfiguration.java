package org.jupnp;

import defpackage.e45;
import defpackage.j02;
import defpackage.n02;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.jupnp.binding.xml.DeviceDescriptorBinder;
import org.jupnp.binding.xml.ServiceDescriptorBinder;
import org.jupnp.binding.xml.UDA10DeviceDescriptorBinderImpl;
import org.jupnp.binding.xml.UDA10ServiceDescriptorBinderImpl;
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
import org.jupnp.transport.impl.jetty.StreamClientConfigurationImpl;
import org.jupnp.transport.spi.DatagramIO;
import org.jupnp.transport.spi.DatagramProcessor;
import org.jupnp.transport.spi.GENAEventProcessor;
import org.jupnp.transport.spi.MulticastReceiver;
import org.jupnp.transport.spi.NetworkAddressFactory;
import org.jupnp.transport.spi.SOAPActionProcessor;
import org.jupnp.transport.spi.StreamClient;
import org.jupnp.transport.spi.StreamClientConfiguration;
import org.jupnp.transport.spi.StreamServer;
import org.jupnp.util.Exceptions;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultUpnpServiceConfiguration implements UpnpServiceConfiguration {
    private static final int CORE_THREAD_POOL_SIZE = 16;
    private static final boolean THREAD_POOL_CORE_TIMEOUT = true;
    private static final int THREAD_POOL_SIZE = 200;
    private static final int THREAD_QUEUE_SIZE = 1000;
    private StreamClientConfiguration configuration;
    private final DatagramProcessor datagramProcessor;
    private final ExecutorService defaultExecutorService;
    private final DeviceDescriptorBinder deviceDescriptorBinderUDA10;
    private final GENAEventProcessor genaEventProcessor;
    private final j02 logger;
    private final int multicastResponsePort;
    private final Namespace namespace;
    private final ServiceDescriptorBinder serviceDescriptorBinderUDA10;
    private final SOAPActionProcessor soapActionProcessor;
    private final int streamListenPort;
    private final TransportConfiguration transportConfiguration;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class JUPnPThreadFactory implements ThreadFactory {
        protected final AtomicInteger threadNumber = new AtomicInteger(1);
        protected final String namePrefix = "jupnp-";
        protected final ThreadGroup group = Thread.currentThread().getThreadGroup();

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.group, runnable, "jupnp-" + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DefaultUpnpServiceConfiguration(int i, int i2, boolean z) {
        this.logger = n02.k(DefaultUpnpServiceConfiguration.class);
        if (z && ModelUtil.ANDROID_RUNTIME) {
            throw new Error("Unsupported runtime environment, use org.jupnp.android.AndroidUpnpServiceConfiguration");
        }
        this.streamListenPort = i;
        this.multicastResponsePort = i2;
        ExecutorService executorServiceCreateDefaultExecutorService = createDefaultExecutorService();
        this.defaultExecutorService = executorServiceCreateDefaultExecutorService;
        this.datagramProcessor = createDatagramProcessor();
        this.soapActionProcessor = createSOAPActionProcessor();
        this.genaEventProcessor = createGENAEventProcessor();
        this.deviceDescriptorBinderUDA10 = createDeviceDescriptorBinderUDA10();
        this.serviceDescriptorBinderUDA10 = createServiceDescriptorBinderUDA10();
        this.namespace = createNamespace();
        this.configuration = new StreamClientConfigurationImpl(executorServiceCreateDefaultExecutorService);
        this.transportConfiguration = TransportConfigurationProvider.getDefaultTransportConfiguration();
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
    public ExecutorService createDefaultExecutorService() {
        return new JUPnPExecutor();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DeviceDescriptorBinder createDeviceDescriptorBinderUDA10() {
        return new UDA10DeviceDescriptorBinderImpl();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public GENAEventProcessor createGENAEventProcessor() {
        return new GENAEventProcessorImpl();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public MulticastReceiver createMulticastReceiver(NetworkAddressFactory networkAddressFactory) {
        return new MulticastReceiverImpl(new MulticastReceiverConfigurationImpl(networkAddressFactory.getMulticastGroup(), networkAddressFactory.getMulticastPort()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Namespace createNamespace() {
        return new Namespace();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public NetworkAddressFactory createNetworkAddressFactory() {
        return createNetworkAddressFactory(this.streamListenPort, this.multicastResponsePort);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SOAPActionProcessor createSOAPActionProcessor() {
        return new SOAPActionProcessorImpl();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ServiceDescriptorBinder createServiceDescriptorBinderUDA10() {
        return new UDA10ServiceDescriptorBinderImpl();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public StreamClient createStreamClient() {
        return this.transportConfiguration.createStreamClient(getSyncProtocolExecutorService(), this.configuration);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public StreamServer createStreamServer(NetworkAddressFactory networkAddressFactory) {
        return this.transportConfiguration.createStreamServer(networkAddressFactory.getStreamListenPort());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public int getAliveIntervalMillis() {
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public DatagramProcessor getDatagramProcessor() {
        return this.datagramProcessor;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ExecutorService getDefaultExecutorService() {
        return this.defaultExecutorService;
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
    @Override // org.jupnp.UpnpServiceConfiguration
    public Namespace getNamespace() {
        return this.namespace;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public Executor getRegistryListenerExecutor() {
        return getDefaultExecutorService();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public Executor getRegistryMaintainerExecutor() {
        return getDefaultExecutorService();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public int getRegistryMaintenanceIntervalMillis() {
        return THREAD_QUEUE_SIZE;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public Integer getRemoteDeviceMaxAgeSeconds() {
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public Executor getRemoteListenerExecutor() {
        return getDefaultExecutorService();
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
        return getDefaultExecutorService();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public ExecutorService getSyncProtocolExecutorService() {
        return getDefaultExecutorService();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public boolean isReceivedSubscriptionTimeoutIgnored() {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.UpnpServiceConfiguration
    public void shutdown() {
        this.logger.y("Shutting down default executor service");
        getDefaultExecutorService().shutdownNow();
    }

    /* JADX DEBUG: Method merged with bridge method: getAsyncProtocolExecutor()Ljava/util/concurrent/Executor; */
    @Override // org.jupnp.UpnpServiceConfiguration
    public ExecutorService getAsyncProtocolExecutor() {
        return getDefaultExecutorService();
    }

    /* JADX DEBUG: Method merged with bridge method: getDatagramIOExecutor()Ljava/util/concurrent/Executor; */
    @Override // org.jupnp.UpnpServiceConfiguration
    public ExecutorService getDatagramIOExecutor() {
        return getDefaultExecutorService();
    }

    /* JADX DEBUG: Method merged with bridge method: getMulticastReceiverExecutor()Ljava/util/concurrent/Executor; */
    @Override // org.jupnp.UpnpServiceConfiguration
    public ExecutorService getMulticastReceiverExecutor() {
        return getDefaultExecutorService();
    }

    public NetworkAddressFactory createNetworkAddressFactory(int i, int i2) {
        return new NetworkAddressFactoryImpl(i, i2);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class JUPnPExecutor extends ThreadPoolExecutor implements AutoCloseable {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public JUPnPExecutor(ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
            super(16, 200, 10L, TimeUnit.SECONDS, new ArrayBlockingQueue(DefaultUpnpServiceConfiguration.THREAD_QUEUE_SIZE), threadFactory, rejectedExecutionHandler);
            allowCoreThreadTimeOut(DefaultUpnpServiceConfiguration.THREAD_POOL_CORE_TIMEOUT);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.concurrent.ThreadPoolExecutor
        public void afterExecute(Runnable runnable, Throwable th) {
            super.afterExecute(runnable, th);
            if (th == null || (Exceptions.unwrap(th) instanceof InterruptedException)) {
                return;
            }
            n02.k(DefaultUpnpServiceConfiguration.class).m("Thread terminated {} abruptly", runnable, th);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.AutoCloseable
        public /* synthetic */ void close() {
            e45.a(this);
        }

        public JUPnPExecutor() {
            this(new JUPnPThreadFactory(), new ThreadPoolExecutor.DiscardPolicy() { // from class: org.jupnp.DefaultUpnpServiceConfiguration.JUPnPExecutor.1
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.util.concurrent.ThreadPoolExecutor.DiscardPolicy, java.util.concurrent.RejectedExecutionHandler
                public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                    n02.k(DefaultUpnpServiceConfiguration.class).d("Thread pool rejected execution of {}", runnable.getClass());
                    super.rejectedExecution(runnable, threadPoolExecutor);
                }
            });
        }
    }

    public DefaultUpnpServiceConfiguration(int i) {
        this(i, 0, THREAD_POOL_CORE_TIMEOUT);
    }

    public DefaultUpnpServiceConfiguration(int i, int i2) {
        this(i, i2, THREAD_POOL_CORE_TIMEOUT);
    }

    public DefaultUpnpServiceConfiguration(boolean z) {
        this(0, 0, z);
    }

    public DefaultUpnpServiceConfiguration() {
        this(0);
    }
}
