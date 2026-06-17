package org.jupnp.model.gena;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jupnp.model.meta.Service;
import org.jupnp.model.state.StateVariableValue;
import org.jupnp.model.types.UnsignedIntegerFourBytes;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class GENASubscription<S extends Service> {
    protected volatile int actualDurationSeconds;
    protected volatile UnsignedIntegerFourBytes currentSequence;
    protected Map<String, StateVariableValue<S>> currentValues;
    protected volatile int requestedDurationSeconds;
    protected final S service;
    protected volatile String subscriptionId;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public GENASubscription(S s) {
        this.requestedDurationSeconds = 1800;
        this.currentValues = new ConcurrentHashMap();
        this.service = s;
    }

    public abstract void established();

    public abstract void eventReceived();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getActualDurationSeconds() {
        return this.actualDurationSeconds;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public UnsignedIntegerFourBytes getCurrentSequence() {
        return this.currentSequence;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Map<String, StateVariableValue<S>> getCurrentValues() {
        return this.currentValues;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getRequestedDurationSeconds() {
        return this.requestedDurationSeconds;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public S getService() {
        return this.service;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getSubscriptionId() {
        return this.subscriptionId;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setActualSubscriptionDurationSeconds(int i) {
        this.actualDurationSeconds = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setSubscriptionId(String str) {
        this.subscriptionId = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "(GENASubscription, SID: " + getSubscriptionId() + ", SEQUENCE: " + String.valueOf(getCurrentSequence()) + ")";
    }

    public GENASubscription(S s, int i) {
        this(s);
        this.requestedDurationSeconds = i;
    }
}
