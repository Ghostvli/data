package org.jupnp;

import defpackage.cx4;
import defpackage.j02;
import defpackage.n02;
import java.lang.Thread;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.jupnp.UpnpServiceImpl;
import org.jupnp.controlpoint.ControlPoint;
import org.jupnp.controlpoint.ControlPointImpl;
import org.jupnp.model.message.header.STAllHeader;
import org.jupnp.protocol.ProtocolFactory;
import org.jupnp.protocol.ProtocolFactoryImpl;
import org.jupnp.registry.Registry;
import org.jupnp.registry.RegistryImpl;
import org.jupnp.transport.Router;
import org.jupnp.transport.RouterException;
import org.jupnp.transport.RouterImpl;
import org.jupnp.util.Exceptions;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
@Designate(ocd = Config.class)
@Component(configurationPid = {"org.jupnp.upnpservice"})
public class UpnpServiceImpl implements UpnpService {
    protected UpnpServiceConfiguration configuration;
    protected ControlPoint controlPoint;
    protected ProtocolFactory protocolFactory;
    protected Registry registry;
    protected Router router;
    protected ScheduledExecutorService scheduledExecutorService;
    protected volatile ScheduledFuture<?> scheduledFuture;
    private final j02 logger = n02.k(UpnpServiceImpl.class);
    protected boolean isConfigured = false;
    protected boolean isRunning = false;
    private volatile boolean isInitialSearchEnabled = true;
    private final Object lock = new Object();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    @ObjectClassDefinition(description = "Configuration for jUPnP OSGi service", id = "org.jupnp.upnpservice", name = "jUPnP service configuration")
    public @interface Config {
        @AttributeDefinition(description = "Enable initial search when starting jUPnP service.", name = "initialSearchEnabled")
        boolean initialSearchEnabled() default true;
    }

    public UpnpServiceImpl(UpnpServiceConfiguration upnpServiceConfiguration) {
        this.configuration = upnpServiceConfiguration;
    }

    public static /* synthetic */ void a(UpnpServiceImpl upnpServiceImpl) {
        upnpServiceImpl.shutdown();
        upnpServiceImpl.startup();
    }

    public static /* synthetic */ Thread b(Runnable runnable) {
        Thread thread = new Thread(runnable, "Upnp Service Delayed Startup Thread");
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: dx4
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread2, Throwable th) {
                UpnpServiceImpl.d(thread2, th);
            }
        });
        return thread;
    }

    public static /* synthetic */ void c(UpnpServiceImpl upnpServiceImpl) {
        synchronized (upnpServiceImpl.lock) {
            try {
                if (upnpServiceImpl.isRunning) {
                    upnpServiceImpl.logger.info("Shutting down UPnP service...");
                    upnpServiceImpl.shutdownRegistry();
                    upnpServiceImpl.shutdownConfiguration();
                    upnpServiceImpl.shutdownRouter();
                    upnpServiceImpl.logger.info("UPnP service shutdown completed");
                    upnpServiceImpl.isRunning = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static ScheduledExecutorService createExecutor() {
        return Executors.newSingleThreadScheduledExecutor(new ThreadFactory() { // from class: ex4
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return UpnpServiceImpl.b(runnable);
            }
        });
    }

    public static /* synthetic */ void d(Thread thread, Throwable th) {
        throw new IllegalStateException(th);
    }

    private void delayedStartup(int i) {
        Runnable runnable = new Runnable() { // from class: hx4
            @Override // java.lang.Runnable
            public final void run() {
                this.f.startup();
            }
        };
        if (this.scheduledFuture != null) {
            this.scheduledFuture.cancel(true);
        }
        this.scheduledFuture = this.scheduledExecutorService.schedule(runnable, i, TimeUnit.MILLISECONDS);
    }

    private void restart(boolean z) {
        Runnable runnable = new Runnable() { // from class: gx4
            @Override // java.lang.Runnable
            public final void run() {
                UpnpServiceImpl.a(this.f);
            }
        };
        if (z) {
            new Thread(runnable).start();
        } else {
            runnable.run();
        }
    }

    @Activate
    public void activate(Config config) {
        this.scheduledFuture = null;
        this.scheduledExecutorService = createExecutor();
        this.isInitialSearchEnabled = config.initialSearchEnabled();
        startup();
    }

    public ControlPoint createControlPoint(ProtocolFactory protocolFactory, Registry registry) {
        return new ControlPointImpl(getConfiguration(), protocolFactory, registry);
    }

    public ProtocolFactory createProtocolFactory() {
        return new ProtocolFactoryImpl(this);
    }

    public Registry createRegistry(ProtocolFactory protocolFactory) {
        return new RegistryImpl(this);
    }

    public Router createRouter(ProtocolFactory protocolFactory, Registry registry) {
        return new RouterImpl(getConfiguration(), protocolFactory);
    }

    @Deactivate
    public void deactivate() {
        if (this.scheduledFuture != null) {
            this.scheduledFuture.cancel(true);
        }
        this.scheduledExecutorService.shutdownNow();
        shutdown();
    }

    @Override // org.jupnp.UpnpService
    public UpnpServiceConfiguration getConfiguration() {
        return this.configuration;
    }

    @Override // org.jupnp.UpnpService
    public ControlPoint getControlPoint() {
        return this.controlPoint;
    }

    @Override // org.jupnp.UpnpService
    public ProtocolFactory getProtocolFactory() {
        return this.protocolFactory;
    }

    @Override // org.jupnp.UpnpService
    public Registry getRegistry() {
        return this.registry;
    }

    @Override // org.jupnp.UpnpService
    public Router getRouter() {
        return this.router;
    }

    @Reference
    public void setUpnpServiceConfiguration(UpnpServiceConfiguration upnpServiceConfiguration) {
        this.configuration = upnpServiceConfiguration;
        if (this.isRunning) {
            this.logger.b("New OSGi UpnpServiceConfiguration is bound while UPnP service is running; restart needed");
            restart(true);
        }
    }

    public void shutdown(boolean z) {
        Runnable runnable = new Runnable() { // from class: fx4
            @Override // java.lang.Runnable
            public final void run() {
                UpnpServiceImpl.c(this.f);
            }
        };
        if (z) {
            new Thread(runnable).start();
        } else {
            runnable.run();
        }
    }

    public void shutdownConfiguration() {
        getConfiguration().shutdown();
    }

    public void shutdownRegistry() {
        getRegistry().shutdown();
    }

    public void shutdownRouter() {
        try {
            getRouter().shutdown();
        } catch (RouterException e) {
            if (Exceptions.unwrap(e) instanceof InterruptedException) {
                this.logger.w("Router shutdown was interrupted", e);
            } else {
                cx4.a("Router error on shutdown", e);
            }
        }
    }

    @Override // org.jupnp.UpnpService
    public void startup() {
        synchronized (this.lock) {
            try {
                if (!this.isRunning) {
                    this.logger.info("Starting UPnP service...");
                    this.logger.q("Using configuration: {}", getConfiguration().getClass().getName());
                    ProtocolFactory protocolFactoryCreateProtocolFactory = createProtocolFactory();
                    this.protocolFactory = protocolFactoryCreateProtocolFactory;
                    Registry registryCreateRegistry = createRegistry(protocolFactoryCreateProtocolFactory);
                    this.registry = registryCreateRegistry;
                    Router routerCreateRouter = createRouter(this.protocolFactory, registryCreateRegistry);
                    this.router = routerCreateRouter;
                    try {
                        routerCreateRouter.enable();
                        this.controlPoint = createControlPoint(this.protocolFactory, this.registry);
                        this.logger.b("UPnP service started successfully");
                        this.isRunning = true;
                        if (this.isInitialSearchEnabled) {
                            this.controlPoint.search(new STAllHeader());
                        }
                    } catch (RouterException e) {
                        throw new RuntimeException("Enabling network router failed", e);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void unsetUpnpServiceConfiguration(UpnpServiceConfiguration upnpServiceConfiguration) {
        this.configuration = null;
    }

    @Override // org.jupnp.UpnpService
    public synchronized void shutdown() {
        shutdown(false);
    }

    public UpnpServiceImpl() {
    }
}
