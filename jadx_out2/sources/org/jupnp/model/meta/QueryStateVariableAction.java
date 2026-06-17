package org.jupnp.model.meta;

import java.util.Collections;
import java.util.List;
import org.jupnp.model.ValidationError;
import org.jupnp.model.meta.ActionArgument;
import org.jupnp.model.meta.Service;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class QueryStateVariableAction<S extends Service> extends Action<S> {
    public static final String ACTION_NAME = "QueryStateVariable";
    public static final String INPUT_ARG_VAR_NAME = "varName";
    public static final String OUTPUT_ARG_RETURN = "return";
    public static final String VIRTUAL_STATEVARIABLE_INPUT = "VirtualQueryActionInput";
    public static final String VIRTUAL_STATEVARIABLE_OUTPUT = "VirtualQueryActionOutput";

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public QueryStateVariableAction(S s) {
        super(ACTION_NAME, new ActionArgument[]{new ActionArgument(INPUT_ARG_VAR_NAME, VIRTUAL_STATEVARIABLE_INPUT, ActionArgument.Direction.IN), new ActionArgument("return", VIRTUAL_STATEVARIABLE_OUTPUT, ActionArgument.Direction.OUT)});
        setService(s);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.model.meta.Action
    public String getName() {
        return ACTION_NAME;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.model.meta.Action, org.jupnp.model.Validatable
    public List<ValidationError> validate() {
        return Collections.EMPTY_LIST;
    }

    public QueryStateVariableAction() {
        this(null);
    }
}
