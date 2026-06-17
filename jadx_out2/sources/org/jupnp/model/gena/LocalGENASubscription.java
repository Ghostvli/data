package org.jupnp.model.gena;

import defpackage.j02;
import defpackage.n02;
import java.net.URL;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.jupnp.internal.compat.java.beans.PropertyChangeEvent;
import org.jupnp.internal.compat.java.beans.PropertyChangeListener;
import org.jupnp.model.ServiceManager;
import org.jupnp.model.meta.LocalService;
import org.jupnp.model.meta.StateVariable;
import org.jupnp.model.state.StateVariableValue;
import org.jupnp.model.types.UnsignedIntegerFourBytes;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class LocalGENASubscription extends GENASubscription<LocalService> implements PropertyChangeListener {
    final List<URL> callbackURLs;
    final Map<String, Long> lastSentNumericValue;
    final Map<String, Long> lastSentTimestamp;
    private final j02 logger;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public LocalGENASubscription(LocalService localService, Integer num, List<URL> list) {
        super(localService);
        j02 j02VarK = n02.k(LocalGENASubscription.class);
        this.logger = j02VarK;
        this.lastSentTimestamp = new HashMap();
        this.lastSentNumericValue = new HashMap();
        setSubscriptionDuration(num);
        j02VarK.y("Reading initial state of local service at subscription time");
        long time = new Date().getTime();
        this.currentValues.clear();
        Collection<StateVariableValue> currentState = getService().getManager().getCurrentState();
        j02VarK.h("Got evented state variable values: {}", Integer.valueOf(currentState.size()));
        for (StateVariableValue stateVariableValue : currentState) {
            this.currentValues.put(stateVariableValue.getStateVariable().getName(), (StateVariableValue<S>) stateVariableValue);
            this.logger.i("Read state variable value '{}': {}", stateVariableValue.getStateVariable().getName(), stateVariableValue);
            this.lastSentTimestamp.put(stateVariableValue.getStateVariable().getName(), Long.valueOf(time));
            if (stateVariableValue.getStateVariable().isModeratedNumericType()) {
                this.lastSentNumericValue.put(stateVariableValue.getStateVariable().getName(), Long.valueOf(stateVariableValue.toString()));
            }
        }
        this.subscriptionId = "uuid:".concat(String.valueOf(UUID.randomUUID()));
        this.currentSequence = new UnsignedIntegerFourBytes(0L);
        this.callbackURLs = list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized void end(CancelReason cancelReason) {
        try {
            getService().getManager().getPropertyChangeSupport().removePropertyChangeListener(this);
        } catch (Exception e) {
            this.logger.u("Removal of local service property change listener failed", e);
        }
        ended(cancelReason);
    }

    public abstract void ended(CancelReason cancelReason);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized void establish() {
        established();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized List<URL> getCallbackURLs() {
        return this.callbackURLs;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized void incrementSequence() {
        this.currentSequence.increment(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized Set<String> moderateStateVariables(long j, Collection<StateVariableValue> collection) {
        HashSet hashSet;
        try {
            hashSet = new HashSet();
            for (StateVariableValue stateVariableValue : collection) {
                StateVariable stateVariable = stateVariableValue.getStateVariable();
                String name = stateVariableValue.getStateVariable().getName();
                if (stateVariable.getEventDetails().getEventMaximumRateMilliseconds() == 0 && stateVariable.getEventDetails().getEventMinimumDelta() == 0) {
                    this.logger.h("Variable is not moderated: {}", stateVariable);
                } else if (!this.lastSentTimestamp.containsKey(name)) {
                    this.logger.h("Variable is moderated but was never sent before: {}", stateVariable);
                } else if (stateVariable.getEventDetails().getEventMaximumRateMilliseconds() > 0 && j <= this.lastSentTimestamp.get(name).longValue() + ((long) stateVariable.getEventDetails().getEventMaximumRateMilliseconds())) {
                    this.logger.h("Excluding state variable with maximum rate: {}", stateVariable);
                    hashSet.add(name);
                } else if (stateVariable.isModeratedNumericType() && this.lastSentNumericValue.get(name) != null) {
                    long jLongValue = this.lastSentNumericValue.get(name).longValue();
                    long j2 = Long.parseLong(stateVariableValue.toString());
                    long eventMinimumDelta = stateVariable.getEventDetails().getEventMinimumDelta();
                    if (j2 > jLongValue && j2 - jLongValue < eventMinimumDelta) {
                        this.logger.h("Excluding state variable with minimum delta: {}", stateVariable);
                        hashSet.add(name);
                    } else if (j2 < jLongValue && jLongValue - j2 < eventMinimumDelta) {
                        this.logger.h("Excluding state variable with minimum delta: {}", stateVariable);
                        hashSet.add(name);
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return hashSet;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // org.jupnp.internal.compat.java.beans.PropertyChangeListener
    public synchronized void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        try {
            if (propertyChangeEvent.getPropertyName().equals(ServiceManager.EVENTED_STATE_VARIABLES)) {
                this.logger.h("Eventing triggered, getting state for subscription: {}", getSubscriptionId());
                long time = new Date().getTime();
                Collection<StateVariableValue> collection = (Collection) propertyChangeEvent.getNewValue();
                Set<String> setModerateStateVariables = moderateStateVariables(time, collection);
                this.currentValues.clear();
                for (StateVariableValue stateVariableValue : collection) {
                    String name = stateVariableValue.getStateVariable().getName();
                    if (!setModerateStateVariables.contains(name)) {
                        this.logger.i("Adding state variable value to current values of event: {} = {}", stateVariableValue.getStateVariable(), stateVariableValue);
                        this.currentValues.put(stateVariableValue.getStateVariable().getName(), (StateVariableValue<S>) stateVariableValue);
                        this.lastSentTimestamp.put(name, Long.valueOf(time));
                        if (stateVariableValue.getStateVariable().isModeratedNumericType()) {
                            this.lastSentNumericValue.put(name, Long.valueOf(stateVariableValue.toString()));
                        }
                    }
                }
                boolean zIsEmpty = this.currentValues.isEmpty();
                j02 j02Var = this.logger;
                if (zIsEmpty) {
                    j02Var.y("No state variable values for event (all moderated out?), not triggering event");
                } else {
                    j02Var.h("Propagating new state variable values to subscription: {}", this);
                    eventReceived();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized void registerOnService() {
        getService().getManager().getPropertyChangeSupport().addPropertyChangeListener(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized void setSubscriptionDuration(Integer num) {
        this.requestedDurationSeconds = num == null ? 1800 : num.intValue();
        setActualSubscriptionDurationSeconds(this.requestedDurationSeconds);
    }

    public LocalGENASubscription(LocalService localService, List<URL> list) {
        super(localService);
        this.logger = n02.k(LocalGENASubscription.class);
        this.lastSentTimestamp = new HashMap();
        this.lastSentNumericValue = new HashMap();
        this.callbackURLs = list;
    }
}
