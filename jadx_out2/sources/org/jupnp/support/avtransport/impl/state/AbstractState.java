package org.jupnp.support.avtransport.impl.state;

import org.jupnp.support.model.AVTransport;
import org.jupnp.support.model.TransportAction;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractState<T extends AVTransport> {
    private T transport;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AbstractState(T t) {
        this.transport = t;
    }

    public abstract TransportAction[] getCurrentTransportActions();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public T getTransport() {
        return this.transport;
    }
}
