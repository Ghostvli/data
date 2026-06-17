package org.jupnp.model;

import java.util.Collection;
import org.jupnp.internal.compat.java.beans.PropertyChangeSupport;
import org.jupnp.model.meta.LocalService;
import org.jupnp.model.state.StateVariableValue;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface ServiceManager<T> {
    public static final String EVENTED_STATE_VARIABLES = "_EventedStateVariables";

    void execute(Command<T> command);

    Collection<StateVariableValue> getCurrentState();

    T getImplementation();

    PropertyChangeSupport getPropertyChangeSupport();

    LocalService<T> getService();
}
