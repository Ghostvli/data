package org.jupnp.model.action;

import org.jupnp.model.VariableValue;
import org.jupnp.model.meta.ActionArgument;
import org.jupnp.model.meta.Service;
import org.jupnp.model.types.Datatype;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ActionArgumentValue<S extends Service> extends VariableValue {
    private final ActionArgument<S> argument;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Illegal instructions before constructor call */
    public ActionArgumentValue(ActionArgument<S> actionArgument, Object obj) {
        Datatype datatype = actionArgument.getDatatype();
        if (obj != null && obj.getClass().isEnum()) {
            obj = obj.toString();
        }
        super(datatype, obj);
        this.argument = actionArgument;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ActionArgument<S> getArgument() {
        return this.argument;
    }
}
