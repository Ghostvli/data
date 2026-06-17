package org.jupnp.model.action;

import defpackage.j02;
import defpackage.n02;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;
import org.jupnp.model.VariableValue;
import org.jupnp.model.meta.ActionArgument;
import org.jupnp.model.meta.LocalService;
import org.jupnp.model.profile.RemoteClientInfo;
import org.jupnp.model.state.StateVariableAccessor;
import org.jupnp.model.types.ErrorCode;
import org.jupnp.util.Reflections;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class MethodActionExecutor extends AbstractActionExecutor {
    private final j02 logger;
    protected Method method;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public MethodActionExecutor(Method method) {
        this.logger = n02.k(MethodActionExecutor.class);
        this.method = method;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object[] createInputArgumentValues(ActionInvocation<LocalService> actionInvocation, Method method) throws ActionException {
        LocalService localService = (LocalService) actionInvocation.getAction().getService();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (ActionArgument actionArgument : actionInvocation.getAction().getInputArguments()) {
            Class<?> cls = method.getParameterTypes()[i];
            VariableValue input = actionInvocation.getInput(actionArgument);
            if (cls.isPrimitive() && (input == null || input.toString().isEmpty())) {
                throw new ActionException(ErrorCode.ARGUMENT_VALUE_INVALID, "Primitive action method argument '" + actionArgument.getName() + "' requires input value, can't be null or empty string");
            }
            if (input == null) {
                arrayList.add(i, null);
                i++;
            } else {
                String string = input.toString();
                if (string.isEmpty() || !localService.isStringConvertibleType((Class) cls) || cls.isEnum()) {
                    arrayList.add(i, input.getValue());
                    i++;
                } else {
                    try {
                        Constructor<?> constructor = cls.getConstructor(String.class);
                        this.logger.h("Creating new input argument value instance with String.class constructor of type: {}", cls);
                        int i2 = i + 1;
                        arrayList.add(i, constructor.newInstance(string));
                        i = i2;
                    } catch (Exception e) {
                        this.logger.k("Error preparing action method call: {}. Can't convert input argument string to desired type of '{}'", method, actionArgument.getName(), e);
                        throw new ActionException(ErrorCode.ARGUMENT_VALUE_INVALID, "Can't convert input argument string to desired type of '" + actionArgument.getName() + "': " + String.valueOf(e));
                    }
                }
            }
        }
        if (method.getParameterTypes().length > 0 && RemoteClientInfo.class.isAssignableFrom(method.getParameterTypes()[method.getParameterTypes().length - 1])) {
            if (actionInvocation instanceof RemoteActionInvocation) {
                RemoteActionInvocation remoteActionInvocation = (RemoteActionInvocation) actionInvocation;
                if (remoteActionInvocation.getRemoteClientInfo() != null) {
                    this.logger.h("Providing remote client info as last action method input argument: {}", method);
                    arrayList.add(i, remoteActionInvocation.getRemoteClientInfo());
                } else {
                    arrayList.add(i, null);
                }
            }
        }
        return arrayList.toArray(new Object[arrayList.size()]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a9  */
    @Override // org.jupnp.model.action.AbstractActionExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void execute(ActionInvocation<LocalService> actionInvocation, Object obj) throws Exception {
        Object objInvoke;
        boolean z;
        ActionArgument<LocalService>[] outputArguments;
        Object[] objArrCreateInputArgumentValues = createInputArgumentValues(actionInvocation, this.method);
        if (!actionInvocation.getAction().hasOutputArguments()) {
            this.logger.h("Calling local service method with no output arguments: {}", this.method);
            Reflections.invoke(this.method, obj, objArrCreateInputArgumentValues);
            return;
        }
        boolean zEquals = this.method.getReturnType().equals(Void.TYPE);
        this.logger.h("Calling local service method with output arguments: {}", this.method);
        if (zEquals) {
            this.logger.y("Action method is void, calling declared accessors(s) on service instance to retrieve output argument(s)");
            Reflections.invoke(this.method, obj, objArrCreateInputArgumentValues);
            objInvoke = readOutputArgumentValues(actionInvocation.getAction(), obj);
        } else {
            boolean zIsUseOutputArgumentAccessors = isUseOutputArgumentAccessors(actionInvocation);
            j02 j02Var = this.logger;
            if (!zIsUseOutputArgumentAccessors) {
                j02Var.y("Action method is not void, using returned value as (single) output argument");
                objInvoke = Reflections.invoke(this.method, obj, objArrCreateInputArgumentValues);
                z = false;
                outputArguments = actionInvocation.getAction().getOutputArguments();
                if (!z && (objInvoke instanceof Object[])) {
                    Object[] objArr = (Object[]) objInvoke;
                    this.logger.h("Accessors returned Object[], setting output argument values: {}", Integer.valueOf(objArr.length));
                    for (int i = 0; i < outputArguments.length; i++) {
                        setOutputArgumentValue(actionInvocation, outputArguments[i], objArr[i]);
                    }
                    return;
                }
                if (outputArguments.length != 1) {
                    setOutputArgumentValue(actionInvocation, outputArguments[0], objInvoke);
                    return;
                }
                throw new ActionException(ErrorCode.ACTION_FAILED, "Method return does not match required number of output arguments: " + outputArguments.length);
            }
            j02Var.y("Action method is not void, calling declared accessor(s) on returned instance to retrieve output argument(s)");
            objInvoke = readOutputArgumentValues(actionInvocation.getAction(), Reflections.invoke(this.method, obj, objArrCreateInputArgumentValues));
        }
        z = true;
        outputArguments = actionInvocation.getAction().getOutputArguments();
        if (!z) {
        }
        if (outputArguments.length != 1) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Method getMethod() {
        return this.method;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isUseOutputArgumentAccessors(ActionInvocation<LocalService> actionInvocation) {
        for (ActionArgument actionArgument : actionInvocation.getAction().getOutputArguments()) {
            if (getOutputArgumentAccessors().get(actionArgument) != null) {
                return true;
            }
        }
        return false;
    }

    public MethodActionExecutor(Map<ActionArgument<LocalService>, StateVariableAccessor> map, Method method) {
        super(map);
        this.logger = n02.k(MethodActionExecutor.class);
        this.method = method;
    }
}
