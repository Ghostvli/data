package net.engio.mbassy.subscription;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AbstractSubscriptionContextAware implements ISubscriptionContextAware {
    private final SubscriptionContext context;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AbstractSubscriptionContextAware(SubscriptionContext subscriptionContext) {
        this.context = subscriptionContext;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // net.engio.mbassy.subscription.ISubscriptionContextAware
    public final SubscriptionContext getContext() {
        return this.context;
    }
}
