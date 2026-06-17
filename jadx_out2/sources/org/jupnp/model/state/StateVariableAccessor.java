package org.jupnp.model.state;

import org.jupnp.model.Command;
import org.jupnp.model.ServiceManager;
import org.jupnp.model.meta.LocalService;
import org.jupnp.model.meta.StateVariable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class StateVariableAccessor {

    /* JADX INFO: renamed from: org.jupnp.model.state.StateVariableAccessor$1AccessCommand, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class C1AccessCommand implements Command {
        Object result;
        final /* synthetic */ StateVariableAccessor this$0;
        final /* synthetic */ Object val$serviceImpl;
        final /* synthetic */ StateVariable val$stateVariable;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public C1AccessCommand(StateVariableAccessor stateVariableAccessor, Object obj, StateVariable stateVariable) {
            this.val$serviceImpl = obj;
            this.val$stateVariable = stateVariable;
            this.this$0 = stateVariableAccessor;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.jupnp.model.Command
        public void execute(ServiceManager serviceManager) {
            this.result = this.this$0.read(this.val$serviceImpl);
            if (((LocalService) this.val$stateVariable.getService()).isStringConvertibleType(this.result)) {
                this.result = this.result.toString();
            }
        }
    }

    public abstract Class<?> getReturnType();

    public abstract Object read(Object obj);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public StateVariableValue read(StateVariable<LocalService> stateVariable, Object obj) {
        C1AccessCommand c1AccessCommand = new C1AccessCommand(this, obj, stateVariable);
        ((LocalService) stateVariable.getService()).getManager().execute(c1AccessCommand);
        return new StateVariableValue(stateVariable, c1AccessCommand.result);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "(" + getClass().getSimpleName() + ")";
    }
}
