package net.engio.mbassy.dispatch;

import net.engio.mbassy.bus.MessagePublication;
import net.engio.mbassy.listener.IMessageFilter;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class FilteredMessageDispatcher extends DelegatingMessageDispatcher {
    private final IMessageFilter[] filter;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FilteredMessageDispatcher(IMessageDispatcher iMessageDispatcher) {
        super(iMessageDispatcher);
        this.filter = iMessageDispatcher.getContext().getHandler().getFilter();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean passesFilter(Object obj) {
        IMessageFilter[] iMessageFilterArr = this.filter;
        if (iMessageFilterArr == null) {
            return true;
        }
        for (IMessageFilter iMessageFilter : iMessageFilterArr) {
            if (!iMessageFilter.accepts(obj, getContext())) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // net.engio.mbassy.dispatch.IMessageDispatcher
    public void dispatch(MessagePublication messagePublication, Object obj, Iterable iterable) {
        if (passesFilter(obj)) {
            getDelegate().dispatch(messagePublication, obj, iterable);
        }
    }
}
