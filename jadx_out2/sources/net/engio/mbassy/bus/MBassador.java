package net.engio.mbassy.bus;

import java.util.concurrent.TimeUnit;
import net.engio.mbassy.bus.common.IMessageBus;
import net.engio.mbassy.bus.config.BusConfiguration;
import net.engio.mbassy.bus.config.Feature;
import net.engio.mbassy.bus.config.IBusConfiguration;
import net.engio.mbassy.bus.error.IPublicationErrorHandler;
import net.engio.mbassy.bus.error.PublicationError;
import net.engio.mbassy.bus.publication.SyncAsyncPostCommand;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class MBassador<T> extends AbstractSyncAsyncMessageBus<T, SyncAsyncPostCommand<T>> implements IMessageBus<T, SyncAsyncPostCommand<T>> {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public MBassador(IPublicationErrorHandler iPublicationErrorHandler) {
        super(new BusConfiguration().addFeature(Feature.SyncPubSub.Default()).addFeature(Feature.AsynchronousHandlerInvocation.Default()).addFeature(Feature.AsynchronousMessageDispatch.Default()).addPublicationErrorHandler(iPublicationErrorHandler));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: post(Ljava/lang/Object;)Lnet/engio/mbassy/bus/publication/IPublicationCommand; */
    /* JADX DEBUG: Method merged with bridge method: post(Ljava/lang/Object;)Lnet/engio/mbassy/bus/publication/ISyncAsyncPublicationCommand; */
    @Override // net.engio.mbassy.bus.common.IMessageBus, net.engio.mbassy.bus.common.GenericMessagePublicationSupport
    public SyncAsyncPostCommand<T> post(T t) {
        return new SyncAsyncPostCommand<>(this, t);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // net.engio.mbassy.bus.common.PubSubSupport
    public IMessagePublication publish(T t) {
        MessagePublication messagePublicationCreateMessagePublication = createMessagePublication(t);
        try {
            messagePublicationCreateMessagePublication.execute();
            return messagePublicationCreateMessagePublication;
        } catch (Throwable th) {
            try {
                handlePublicationError(new PublicationError().setMessage("Error during publication of message").setCause(th).setPublication(messagePublicationCreateMessagePublication));
            } catch (Throwable unused) {
            }
            return messagePublicationCreateMessagePublication;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public IMessagePublication publishAsync(T t) {
        return addAsynchronousPublication(createMessagePublication(t));
    }

    public IMessagePublication publishAsync(T t, long j, TimeUnit timeUnit) {
        return addAsynchronousPublication(createMessagePublication(t), j, timeUnit);
    }

    public MBassador() {
        this(new BusConfiguration().addFeature(Feature.SyncPubSub.Default()).addFeature(Feature.AsynchronousHandlerInvocation.Default()).addFeature(Feature.AsynchronousMessageDispatch.Default()));
    }

    public MBassador(IBusConfiguration iBusConfiguration) {
        super(iBusConfiguration);
    }
}
