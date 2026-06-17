package net.engio.mbassy.subscription;

import java.util.Collection;
import java.util.Iterator;
import net.engio.mbassy.bus.BusRuntime;
import net.engio.mbassy.bus.common.RuntimeProvider;
import net.engio.mbassy.bus.error.IPublicationErrorHandler;
import net.engio.mbassy.bus.error.PublicationError;
import net.engio.mbassy.listener.MessageHandler;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SubscriptionContext implements RuntimeProvider {
    private final Collection<IPublicationErrorHandler> errorHandlers;
    private final MessageHandler handler;
    private final BusRuntime runtime;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SubscriptionContext(BusRuntime busRuntime, MessageHandler messageHandler, Collection<IPublicationErrorHandler> collection) {
        this.runtime = busRuntime;
        this.handler = messageHandler;
        this.errorHandlers = collection;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Collection<IPublicationErrorHandler> getErrorHandlers() {
        return this.errorHandlers;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public MessageHandler getHandler() {
        return this.handler;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // net.engio.mbassy.bus.common.RuntimeProvider
    public BusRuntime getRuntime() {
        return this.runtime;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void handleError(PublicationError publicationError) {
        Iterator<IPublicationErrorHandler> it = this.errorHandlers.iterator();
        while (it.hasNext()) {
            it.next().handleError(publicationError);
        }
    }
}
