package net.engio.mbassy.subscription;

import java.util.Collection;
import java.util.Comparator;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import net.engio.mbassy.bus.MessagePublication;
import net.engio.mbassy.dispatch.IMessageDispatcher;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Subscription {
    public static final Comparator<Subscription> SubscriptionByPriorityDesc = new Comparator<Subscription>() { // from class: net.engio.mbassy.subscription.Subscription.1
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: compare(Ljava/lang/Object;Ljava/lang/Object;)I */
        @Override // java.util.Comparator
        public int compare(Subscription subscription, Subscription subscription2) {
            int iCompareTo = Integer.valueOf(subscription2.getPriority()).compareTo(Integer.valueOf(subscription.getPriority()));
            return iCompareTo == 0 ? subscription2.id.compareTo(subscription.id) : iCompareTo;
        }
    };
    private final SubscriptionContext context;
    private final IMessageDispatcher dispatcher;
    protected final Collection<Object> listeners;
    private final UUID id = UUID.randomUUID();
    private final CopyOnWriteArrayList<Runnable> onSubscription = new CopyOnWriteArrayList<>();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class Handle {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Handle() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void onSubscription(Runnable runnable) {
            Subscription.this.onSubscription.add(runnable);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Subscription(SubscriptionContext subscriptionContext, IMessageDispatcher iMessageDispatcher, Collection<Object> collection) {
        this.context = subscriptionContext;
        this.dispatcher = iMessageDispatcher;
        this.listeners = collection;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean belongsTo(Class cls) {
        return this.context.getHandler().isFromListener(cls);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean contains(Object obj) {
        return this.listeners.contains(obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Handle getHandle() {
        return new Handle();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Class[] getHandledMessageTypes() {
        return this.context.getHandler().getHandledMessages();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getPriority() {
        return this.context.getHandler().getPriority();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean handlesMessageType(Class<?> cls) {
        return this.context.getHandler().handlesMessage(cls);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void publish(MessagePublication messagePublication, Object obj) {
        if (this.listeners.isEmpty()) {
            return;
        }
        this.dispatcher.dispatch(messagePublication, obj, this.listeners);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int size() {
        return this.listeners.size();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void subscribe(Object obj) {
        this.listeners.add(obj);
        for (Runnable runnable : (Runnable[]) this.onSubscription.toArray(new Runnable[0])) {
            runnable.run();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean unsubscribe(Object obj) {
        return this.listeners.remove(obj);
    }
}
