package net.engio.mbassy.bus;

import net.engio.mbassy.bus.common.ErrorHandlingSupport;
import net.engio.mbassy.bus.common.GenericMessagePublicationSupport;
import net.engio.mbassy.bus.common.PubSubSupport;
import net.engio.mbassy.bus.config.BusConfiguration;
import net.engio.mbassy.bus.config.Feature;
import net.engio.mbassy.bus.config.IBusConfiguration;
import net.engio.mbassy.bus.error.IPublicationErrorHandler;
import net.engio.mbassy.bus.error.PublicationError;
import net.engio.mbassy.bus.publication.IPublicationCommand;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SyncMessageBus<T> extends AbstractPubSubSupport<T> implements PubSubSupport<T>, ErrorHandlingSupport, GenericMessagePublicationSupport<T, SyncPostCommand> {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class SyncPostCommand implements IPublicationCommand {
        private T message;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public SyncPostCommand(T t) {
            this.message = t;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // net.engio.mbassy.bus.publication.IPublicationCommand
        public IMessagePublication now() {
            return SyncMessageBus.this.publish(this.message);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SyncMessageBus(IPublicationErrorHandler iPublicationErrorHandler) {
        super(new BusConfiguration().addFeature(Feature.SyncPubSub.Default()).addPublicationErrorHandler(iPublicationErrorHandler));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: post(Ljava/lang/Object;)Lnet/engio/mbassy/bus/publication/IPublicationCommand; */
    @Override // net.engio.mbassy.bus.common.GenericMessagePublicationSupport
    public SyncMessageBus<T>.SyncPostCommand post(T t) {
        return new SyncPostCommand(t);
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

    public SyncMessageBus() {
        super(new BusConfiguration().addFeature(Feature.SyncPubSub.Default()));
    }

    public SyncMessageBus(IBusConfiguration iBusConfiguration) {
        super(iBusConfiguration);
    }
}
