package net.engio.mbassy.dispatch;

import net.engio.mbassy.bus.MessagePublication;
import net.engio.mbassy.subscription.MessageEnvelope;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class EnvelopedMessageDispatcher extends DelegatingMessageDispatcher {
    public EnvelopedMessageDispatcher(IMessageDispatcher iMessageDispatcher) {
        super(iMessageDispatcher);
    }

    @Override // net.engio.mbassy.dispatch.IMessageDispatcher
    public void dispatch(MessagePublication messagePublication, Object obj, Iterable iterable) {
        getDelegate().dispatch(messagePublication, new MessageEnvelope(obj), iterable);
    }
}
