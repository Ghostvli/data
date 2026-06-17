package net.engio.mbassy.bus;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import net.engio.mbassy.bus.MessagePublication;
import net.engio.mbassy.bus.common.DeadMessage;
import net.engio.mbassy.bus.common.PubSubSupport;
import net.engio.mbassy.bus.config.ConfigurationError;
import net.engio.mbassy.bus.config.Feature;
import net.engio.mbassy.bus.config.IBusConfiguration;
import net.engio.mbassy.bus.error.IPublicationErrorHandler;
import net.engio.mbassy.bus.error.PublicationError;
import net.engio.mbassy.subscription.Subscription;
import net.engio.mbassy.subscription.SubscriptionManager;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractPubSubSupport<T> implements PubSubSupport<T> {
    public static final String ERROR_HANDLER_MSG = "INFO: No error handler has been configured to handle exceptions during publication.\nPublication error handlers can be added by IBusConfiguration.addPublicationErrorHandler()\nFalling back to console logger.";
    private final List<IPublicationErrorHandler> errorHandlers;
    private final MessagePublication.Factory publicationFactory;
    private final BusRuntime runtime;
    private final SubscriptionManager subscriptionManager;

    public AbstractPubSubSupport(IBusConfiguration iBusConfiguration) {
        ArrayList arrayList = new ArrayList();
        this.errorHandlers = arrayList;
        arrayList.addAll(iBusConfiguration.getRegisteredPublicationErrorHandlers());
        if (arrayList.isEmpty()) {
            arrayList.add(new IPublicationErrorHandler.ConsoleLogger());
            System.out.println(ERROR_HANDLER_MSG);
        }
        BusRuntime busRuntimeAdd = new BusRuntime(this).add(IBusConfiguration.Properties.PublicationErrorHandlers, iBusConfiguration.getRegisteredPublicationErrorHandlers()).add(IBusConfiguration.Properties.BusId, iBusConfiguration.getProperty(IBusConfiguration.Properties.BusId, UUID.randomUUID().toString()));
        this.runtime = busRuntimeAdd;
        Feature.SyncPubSub syncPubSub = (Feature.SyncPubSub) iBusConfiguration.getFeature(Feature.SyncPubSub.class);
        if (syncPubSub == null) {
            throw ConfigurationError.MissingFeature(Feature.SyncPubSub.class);
        }
        this.subscriptionManager = syncPubSub.getSubscriptionManagerProvider().createManager(syncPubSub.getMetadataReader(), syncPubSub.getSubscriptionFactory(), busRuntimeAdd);
        this.publicationFactory = syncPubSub.getPublicationFactory();
    }

    public MessagePublication createMessagePublication(T t) {
        Collection<Subscription> subscriptionsByMessageType = getSubscriptionsByMessageType(t.getClass());
        if ((subscriptionsByMessageType != null && !subscriptionsByMessageType.isEmpty()) || t.getClass().equals(DeadMessage.class)) {
            return getPublicationFactory().createPublication(this.runtime, subscriptionsByMessageType, t);
        }
        return getPublicationFactory().createPublication(this.runtime, getSubscriptionsByMessageType(DeadMessage.class), new DeadMessage(t));
    }

    public MessagePublication.Factory getPublicationFactory() {
        return this.publicationFactory;
    }

    public Collection<IPublicationErrorHandler> getRegisteredErrorHandlers() {
        return Collections.unmodifiableCollection(this.errorHandlers);
    }

    @Override // net.engio.mbassy.bus.common.RuntimeProvider
    public BusRuntime getRuntime() {
        return this.runtime;
    }

    public Collection<Subscription> getSubscriptionsByMessageType(Class cls) {
        return this.subscriptionManager.getSubscriptionsByMessageType(cls);
    }

    public void handlePublicationError(PublicationError publicationError) {
        Iterator<IPublicationErrorHandler> it = this.errorHandlers.iterator();
        while (it.hasNext()) {
            try {
                it.next().handleError(publicationError);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // net.engio.mbassy.bus.common.PubSubSupport
    public void subscribe(Object obj) {
        this.subscriptionManager.subscribe(obj);
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.runtime.get(IBusConfiguration.Properties.BusId) + ")";
    }

    @Override // net.engio.mbassy.bus.common.PubSubSupport
    public boolean unsubscribe(Object obj) {
        return this.subscriptionManager.unsubscribe(obj);
    }
}
