package org.jupnp.model.state;

import org.jupnp.model.VariableValue;
import org.jupnp.model.meta.Service;
import org.jupnp.model.meta.StateVariable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class StateVariableValue<S extends Service> extends VariableValue {
    private StateVariable<S> stateVariable;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public StateVariableValue(StateVariable<S> stateVariable, Object obj) {
        super(stateVariable.getTypeDetails().getDatatype(), obj);
        this.stateVariable = stateVariable;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public StateVariable<S> getStateVariable() {
        return this.stateVariable;
    }
}
