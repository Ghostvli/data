package net.engio.mbassy.dispatch;

import net.engio.mbassy.bus.MessagePublication;
import net.engio.mbassy.subscription.AbstractSubscriptionContextAware;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SynchronizedHandlerInvocation extends AbstractSubscriptionContextAware implements IHandlerInvocation<Object, Object> {
    private IHandlerInvocation delegate;

    public SynchronizedHandlerInvocation(IHandlerInvocation iHandlerInvocation) {
        super(iHandlerInvocation.getContext());
        this.delegate = iHandlerInvocation;
    }

    @Override // net.engio.mbassy.dispatch.IHandlerInvocation
    public void invoke(Object obj, Object obj2, MessagePublication messagePublication) {
        synchronized (obj) {
            this.delegate.invoke(obj, obj2, messagePublication);
        }
    }
}
