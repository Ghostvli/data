package net.engio.mbassy.bus;

import java.util.Collection;
import java.util.Iterator;
import net.engio.mbassy.bus.common.DeadMessage;
import net.engio.mbassy.bus.common.FilteredMessage;
import net.engio.mbassy.bus.error.PublicationError;
import net.engio.mbassy.subscription.Subscription;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class MessagePublication implements IMessagePublication {
    private volatile boolean dispatched = false;
    private PublicationError error = null;
    private final Object message;
    private final BusRuntime runtime;
    private volatile State state;
    private final Collection<Subscription> subscriptions;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Factory {
        public MessagePublication createPublication(BusRuntime busRuntime, Collection<Subscription> collection, Object obj) {
            return new MessagePublication(busRuntime, collection, obj, State.Initial);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum State {
        Initial,
        Scheduled,
        Running,
        Finished
    }

    public MessagePublication(BusRuntime busRuntime, Collection<Subscription> collection, Object obj, State state) {
        this.state = State.Initial;
        this.runtime = busRuntime;
        this.subscriptions = collection;
        this.message = obj;
        this.state = state;
    }

    public boolean add(Subscription subscription) {
        return this.subscriptions.add(subscription);
    }

    @Override // net.engio.mbassy.bus.IMessagePublication
    public void execute() {
        this.state = State.Running;
        Iterator<Subscription> it = this.subscriptions.iterator();
        while (it.hasNext()) {
            it.next().publish(this, this.message);
        }
        this.state = State.Finished;
        if (this.dispatched) {
            return;
        }
        if (!isFilteredMessage() && !isDeadMessage()) {
            this.runtime.getProvider().publish(new FilteredMessage(this.message));
        } else {
            if (isDeadMessage()) {
                return;
            }
            this.runtime.getProvider().publish(new DeadMessage(this.message));
        }
    }

    @Override // net.engio.mbassy.bus.IMessagePublication
    public PublicationError getError() {
        return this.error;
    }

    @Override // net.engio.mbassy.bus.IMessagePublication
    public Object getMessage() {
        return this.message;
    }

    @Override // net.engio.mbassy.bus.IMessagePublication
    public boolean hasError() {
        return this.error != null;
    }

    @Override // net.engio.mbassy.bus.IMessagePublication
    public boolean isDeadMessage() {
        return DeadMessage.class.equals(this.message.getClass());
    }

    @Override // net.engio.mbassy.bus.IMessagePublication
    public boolean isFilteredMessage() {
        return FilteredMessage.class.equals(this.message.getClass());
    }

    @Override // net.engio.mbassy.bus.IMessagePublication
    public boolean isFinished() {
        return this.state.equals(State.Finished);
    }

    @Override // net.engio.mbassy.bus.IMessagePublication
    public boolean isRunning() {
        return this.state.equals(State.Running);
    }

    @Override // net.engio.mbassy.bus.IMessagePublication
    public boolean isScheduled() {
        return this.state.equals(State.Scheduled);
    }

    public void markDispatched() {
        this.dispatched = true;
    }

    public void markError(PublicationError publicationError) {
        this.error = publicationError;
    }

    public MessagePublication markScheduled() {
        if (this.state.equals(State.Initial)) {
            this.state = State.Scheduled;
        }
        return this;
    }
}
