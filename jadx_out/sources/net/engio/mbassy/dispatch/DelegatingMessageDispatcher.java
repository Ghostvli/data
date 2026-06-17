package net.engio.mbassy.dispatch;

import net.engio.mbassy.subscription.AbstractSubscriptionContextAware;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DelegatingMessageDispatcher extends AbstractSubscriptionContextAware implements IMessageDispatcher {
    private final IMessageDispatcher delegate;

    public DelegatingMessageDispatcher(IMessageDispatcher iMessageDispatcher) {
        super(iMessageDispatcher.getContext());
        this.delegate = iMessageDispatcher;
    }

    public IMessageDispatcher getDelegate() {
        return this.delegate;
    }

    @Override // net.engio.mbassy.dispatch.IMessageDispatcher
    public IHandlerInvocation getInvocation() {
        return this.delegate.getInvocation();
    }
}
