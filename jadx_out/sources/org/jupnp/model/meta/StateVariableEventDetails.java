package org.jupnp.model.meta;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class StateVariableEventDetails {
    private final int eventMaximumRateMilliseconds;
    private final int eventMinimumDelta;
    private final boolean sendEvents;

    public StateVariableEventDetails(boolean z, int i, int i2) {
        this.sendEvents = z;
        this.eventMaximumRateMilliseconds = i;
        this.eventMinimumDelta = i2;
    }

    public int getEventMaximumRateMilliseconds() {
        return this.eventMaximumRateMilliseconds;
    }

    public int getEventMinimumDelta() {
        return this.eventMinimumDelta;
    }

    public boolean isSendEvents() {
        return this.sendEvents;
    }

    public StateVariableEventDetails(boolean z) {
        this(z, 0, 0);
    }

    public StateVariableEventDetails() {
        this(true, 0, 0);
    }
}
