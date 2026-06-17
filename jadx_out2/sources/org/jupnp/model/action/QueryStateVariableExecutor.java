package org.jupnp.model.action;

import defpackage.e04;
import org.jupnp.model.meta.LocalService;
import org.jupnp.model.meta.QueryStateVariableAction;
import org.jupnp.model.meta.StateVariable;
import org.jupnp.model.state.StateVariableAccessor;
import org.jupnp.model.types.ErrorCode;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class QueryStateVariableExecutor extends AbstractActionExecutor {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.model.action.AbstractActionExecutor
    public void execute(ActionInvocation<LocalService> actionInvocation, Object obj) throws ActionException {
        if (!(actionInvocation.getAction() instanceof QueryStateVariableAction)) {
            e04.a("This class can only execute QueryStateVariableAction's, not: ".concat(String.valueOf(actionInvocation.getAction())));
        } else if (((LocalService) actionInvocation.getAction().getService()).isSupportsQueryStateVariables()) {
            executeQueryStateVariable(actionInvocation, obj);
        } else {
            actionInvocation.setFailure(new ActionException(ErrorCode.INVALID_ACTION, "This service does not support querying state variables"));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void executeQueryStateVariable(ActionInvocation<LocalService> actionInvocation, Object obj) throws ActionException {
        LocalService localService = (LocalService) actionInvocation.getAction().getService();
        String string = actionInvocation.getInput(QueryStateVariableAction.INPUT_ARG_VAR_NAME).toString();
        StateVariable<LocalService> stateVariable = localService.getStateVariable(string);
        if (stateVariable == null) {
            throw new ActionException(ErrorCode.ARGUMENT_VALUE_INVALID, "No state variable found: " + string);
        }
        StateVariableAccessor accessor = localService.getAccessor(stateVariable.getName());
        if (accessor != null) {
            try {
                setOutputArgumentValue(actionInvocation, actionInvocation.getAction().getOutputArgument("return"), accessor.read(stateVariable, obj).toString());
            } catch (Exception e) {
                throw new ActionException(ErrorCode.ACTION_FAILED, e.getMessage());
            }
        } else {
            throw new ActionException(ErrorCode.ARGUMENT_VALUE_INVALID, "No accessor for state variable, can't read state: " + string);
        }
    }
}
