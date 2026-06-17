package net.engio.mbassy.dispatch;

import java.util.Iterator;
import net.engio.mbassy.bus.MessagePublication;
import net.engio.mbassy.subscription.AbstractSubscriptionContextAware;
import net.engio.mbassy.subscription.SubscriptionContext;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class MessageDispatcher extends AbstractSubscriptionContextAware implements IMessageDispatcher {
    private final IHandlerInvocation invocation;

    public MessageDispatcher(SubscriptionContext subscriptionContext, IHandlerInvocation iHandlerInvocation) {
        super(subscriptionContext);
        this.invocation = iHandlerInvocation;
    }

    @Override // net.engio.mbassy.dispatch.IMessageDispatcher
    public void dispatch(MessagePublication messagePublication, Object obj, Iterable iterable) {
        messagePublication.markDispatched();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            getInvocation().invoke(it.next(), obj, messagePublication);
        }
    }

    @Override // net.engio.mbassy.dispatch.IMessageDispatcher
    public IHandlerInvocation getInvocation() {
        return this.invocation;
    }
}
