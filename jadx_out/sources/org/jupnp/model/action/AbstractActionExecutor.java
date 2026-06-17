package org.jupnp.model.action;

import defpackage.e04;
import defpackage.j02;
import defpackage.n02;
import java.util.HashMap;
import java.util.Map;
import org.jupnp.model.Command;
import org.jupnp.model.ServiceManager;
import org.jupnp.model.meta.Action;
import org.jupnp.model.meta.ActionArgument;
import org.jupnp.model.meta.LocalService;
import org.jupnp.model.state.StateVariableAccessor;
import org.jupnp.model.types.ErrorCode;
import org.jupnp.model.types.InvalidValueException;
import org.jupnp.util.Exceptions;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractActionExecutor implements ActionExecutor {
    private final j02 logger;
    protected Map<ActionArgument<LocalService>, StateVariableAccessor> outputArgumentAccessors;

    public AbstractActionExecutor() {
        this.logger = n02.k(AbstractActionExecutor.class);
        this.outputArgumentAccessors = new HashMap();
    }

    @Override // org.jupnp.model.action.ActionExecutor
    public void execute(final ActionInvocation<LocalService> actionInvocation) {
        this.logger.h("Invoking on local service: {}", actionInvocation);
        LocalService localService = (LocalService) actionInvocation.getAction().getService();
        try {
            if (localService.getManager() == null) {
                throw new IllegalStateException("Service has no implementation factory, can't get service instance");
            }
            localService.getManager().execute(new Command(this) { // from class: org.jupnp.model.action.AbstractActionExecutor.1
                final /* synthetic */ AbstractActionExecutor this$0;

                {
                    this.this$0 = this;
                }

                @Override // org.jupnp.model.Command
                public void execute(ServiceManager serviceManager) {
                    this.this$0.execute(actionInvocation, serviceManager.getImplementation());
                }

                public String toString() {
                    return "Action invocation: ".concat(String.valueOf(actionInvocation.getAction()));
                }
            });
        } catch (InterruptedException e) {
            this.logger.v("InterruptedException thrown by service, wrapping in invocation and returning", e);
            actionInvocation.setFailure(new ActionCancelledException(e));
        } catch (ActionException e2) {
            this.logger.v("ActionException thrown by service, wrapping in invocation and returning", e2);
            actionInvocation.setFailure(e2);
        } catch (Exception e3) {
            Throwable thUnwrap = Exceptions.unwrap(e3);
            this.logger.v("Execution has thrown, wrapping root cause in ActionException and returning", e3);
            actionInvocation.setFailure(new ActionException(ErrorCode.ACTION_FAILED, thUnwrap.getMessage() != null ? thUnwrap.getMessage() : thUnwrap.toString(), thUnwrap));
        }
    }

    public abstract void execute(ActionInvocation<LocalService> actionInvocation, Object obj);

    public Map<ActionArgument<LocalService>, StateVariableAccessor> getOutputArgumentAccessors() {
        return this.outputArgumentAccessors;
    }

    public Object readOutputArgumentValues(Action<LocalService> action, Object obj) {
        int length = action.getOutputArguments().length;
        Object[] objArr = new Object[length];
        this.logger.h("Attempting to retrieve output argument values using accessor: {}", Integer.valueOf(length));
        Object[] outputArguments = action.getOutputArguments();
        int length2 = outputArguments.length;
        int i = 0;
        int i2 = 0;
        while (i < length2) {
            Object obj2 = outputArguments[i];
            this.logger.h("Calling acccessor method for: {}", obj2);
            StateVariableAccessor stateVariableAccessor = getOutputArgumentAccessors().get(obj2);
            if (stateVariableAccessor == null) {
                e04.a("No accessor bound for: ".concat(String.valueOf(obj2)));
                return null;
            }
            this.logger.h("Calling accessor to read output argument value: {}", stateVariableAccessor);
            objArr[i2] = stateVariableAccessor.read(obj);
            i++;
            i2++;
        }
        if (length == 1) {
            return objArr[0];
        }
        if (length > 0) {
            return objArr;
        }
        return null;
    }

    public void setOutputArgumentValue(ActionInvocation<LocalService> actionInvocation, ActionArgument<LocalService> actionArgument, Object obj) throws ActionException {
        LocalService localService = (LocalService) actionInvocation.getAction().getService();
        if (obj == null) {
            this.logger.y("Result of invocation is null, not setting any output argument value(s)");
            return;
        }
        try {
            boolean zIsStringConvertibleType = localService.isStringConvertibleType(obj);
            j02 j02Var = this.logger;
            if (zIsStringConvertibleType) {
                j02Var.y("Result of invocation matches convertible type, setting toString() single output argument value");
                actionInvocation.setOutput(new ActionArgumentValue<>(actionArgument, obj.toString()));
            } else {
                j02Var.y("Result of invocation is Object, setting single output argument value");
                actionInvocation.setOutput(new ActionArgumentValue<>(actionArgument, obj));
            }
        } catch (InvalidValueException e) {
            throw new ActionException(ErrorCode.ARGUMENT_VALUE_INVALID, "Wrong type or invalid value for '" + actionArgument.getName() + "': " + e.getMessage(), e);
        }
    }

    public AbstractActionExecutor(Map<ActionArgument<LocalService>, StateVariableAccessor> map) {
        this.logger = n02.k(AbstractActionExecutor.class);
        new HashMap();
        this.outputArgumentAccessors = map;
    }
}
