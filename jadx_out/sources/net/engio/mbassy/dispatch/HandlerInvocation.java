package net.engio.mbassy.dispatch;

import net.engio.mbassy.bus.MessagePublication;
import net.engio.mbassy.bus.error.PublicationError;
import net.engio.mbassy.subscription.AbstractSubscriptionContextAware;
import net.engio.mbassy.subscription.SubscriptionContext;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class HandlerInvocation<HANDLER, MESSAGE> extends AbstractSubscriptionContextAware implements IHandlerInvocation<HANDLER, MESSAGE> {
    public HandlerInvocation(SubscriptionContext subscriptionContext) {
        super(subscriptionContext);
    }

    public final void handlePublicationError(MessagePublication messagePublication, PublicationError publicationError) {
        messagePublication.markError(publicationError);
        getContext().handleError(publicationError);
    }
}
