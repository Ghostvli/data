package org.jupnp.binding.annotations;

import defpackage.j02;
import defpackage.n02;
import defpackage.p7;
import defpackage.q7;
import defpackage.r7;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jupnp.binding.LocalServiceBindingException;
import org.jupnp.model.Constants;
import org.jupnp.model.ModelUtil;
import org.jupnp.model.action.ActionExecutor;
import org.jupnp.model.action.MethodActionExecutor;
import org.jupnp.model.meta.Action;
import org.jupnp.model.meta.ActionArgument;
import org.jupnp.model.meta.LocalService;
import org.jupnp.model.meta.StateVariable;
import org.jupnp.model.profile.RemoteClientInfo;
import org.jupnp.model.state.GetterStateVariableAccessor;
import org.jupnp.model.state.StateVariableAccessor;
import org.jupnp.model.types.Datatype;
import org.jupnp.util.Reflections;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AnnotationActionBinder {
    protected UpnpAction annotation;
    private final j02 logger = n02.k(AnnotationLocalServiceBinder.class);
    protected Method method;
    protected Map<StateVariable, StateVariableAccessor> stateVariables;
    protected Set<Class> stringConvertibleTypes;

    public AnnotationActionBinder(Method method, Map<StateVariable, StateVariableAccessor> map, Set<Class> set) {
        this.annotation = (UpnpAction) method.getAnnotation(UpnpAction.class);
        this.stateVariables = map;
        this.method = method;
        this.stringConvertibleTypes = set;
    }

    public Action appendAction(Map<Action, ActionExecutor> map) {
        String strName = !getAnnotation().name().isEmpty() ? getAnnotation().name() : AnnotationLocalServiceBinder.toUpnpActionName(getMethod().getName());
        this.logger.h("Creating action and executor: {}", strName);
        List<ActionArgument> listCreateInputArguments = createInputArguments();
        Map<ActionArgument<LocalService>, StateVariableAccessor> mapCreateOutputArguments = createOutputArguments();
        listCreateInputArguments.addAll(mapCreateOutputArguments.keySet());
        Action action = new Action(strName, (ActionArgument[]) listCreateInputArguments.toArray(new ActionArgument[listCreateInputArguments.size()]));
        map.put(action, createExecutor(mapCreateOutputArguments));
        return action;
    }

    public ActionExecutor createExecutor(Map<ActionArgument<LocalService>, StateVariableAccessor> map) {
        return new MethodActionExecutor(map, getMethod());
    }

    public List<ActionArgument> createInputArguments() {
        ArrayList arrayList = new ArrayList();
        Annotation[][] parameterAnnotations = getMethod().getParameterAnnotations();
        int i = 0;
        for (int i2 = 0; i2 < parameterAnnotations.length; i2++) {
            for (Annotation annotation : parameterAnnotations[i2]) {
                if (annotation instanceof UpnpInputArgument) {
                    UpnpInputArgument upnpInputArgument = (UpnpInputArgument) annotation;
                    i++;
                    String strName = upnpInputArgument.name();
                    StateVariable stateVariableFindRelatedStateVariable = findRelatedStateVariable(upnpInputArgument.stateVariable(), strName, getMethod().getName());
                    if (stateVariableFindRelatedStateVariable == null) {
                        throw new LocalServiceBindingException("Could not detected related state variable of argument: " + strName);
                    }
                    validateType(stateVariableFindRelatedStateVariable, getMethod().getParameterTypes()[i2]);
                    arrayList.add(new ActionArgument(strName, upnpInputArgument.aliases(), stateVariableFindRelatedStateVariable.getName(), ActionArgument.Direction.IN));
                }
            }
        }
        if (i >= getMethod().getParameterTypes().length || RemoteClientInfo.class.isAssignableFrom(this.method.getParameterTypes()[this.method.getParameterTypes().length - 1])) {
            return arrayList;
        }
        q7.a("Method has parameters that are not input arguments: ", getMethod().getName());
        return null;
    }

    public Map<ActionArgument<LocalService>, StateVariableAccessor> createOutputArguments() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        UpnpAction upnpAction = (UpnpAction) getMethod().getAnnotation(UpnpAction.class);
        if (upnpAction.out().length != 0) {
            boolean z = upnpAction.out().length > 1;
            for (UpnpOutputArgument upnpOutputArgument : upnpAction.out()) {
                String strName = upnpOutputArgument.name();
                StateVariable stateVariableFindRelatedStateVariable = findRelatedStateVariable(upnpOutputArgument.stateVariable(), strName, getMethod().getName());
                if (stateVariableFindRelatedStateVariable == null && !upnpOutputArgument.getterName().isEmpty()) {
                    stateVariableFindRelatedStateVariable = findRelatedStateVariable(null, null, upnpOutputArgument.getterName());
                }
                if (stateVariableFindRelatedStateVariable == null) {
                    throw new LocalServiceBindingException("Related state variable not found for output argument: " + strName);
                }
                StateVariableAccessor stateVariableAccessorFindOutputArgumentAccessor = findOutputArgumentAccessor(stateVariableFindRelatedStateVariable, upnpOutputArgument.getterName(), z);
                this.logger.i("Found related state variable for output argument '{}': {}", strName, stateVariableFindRelatedStateVariable);
                linkedHashMap.put(new ActionArgument(strName, stateVariableFindRelatedStateVariable.getName(), ActionArgument.Direction.OUT, !z), stateVariableAccessorFindOutputArgumentAccessor);
            }
        }
        return linkedHashMap;
    }

    public StateVariableAccessor findOutputArgumentAccessor(StateVariable stateVariable, String str, boolean z) {
        if (getMethod().getReturnType().equals(Void.TYPE)) {
            if (str == null || str.isEmpty()) {
                this.logger.h("Action method is void, trying to find existing accessor of related: {}", stateVariable);
                return getStateVariables().get(stateVariable);
            }
            this.logger.h("Action method is void, will use getter method named: {}", str);
            Method method = Reflections.getMethod(getMethod().getDeclaringClass(), str);
            if (method != null) {
                validateType(stateVariable, method.getReturnType());
                return new GetterStateVariableAccessor(method);
            }
            p7.a(getMethod().getDeclaringClass(), "Declared getter method '", str, "' not found on: ");
            return null;
        }
        if (str == null || str.isEmpty()) {
            if (!z) {
                this.logger.h("Action method is not void, will use the returned instance: {}", getMethod().getReturnType());
                validateType(stateVariable, getMethod().getReturnType());
            }
            return null;
        }
        this.logger.h("Action method is not void, will use getter method on returned instance: {}", str);
        Method method2 = Reflections.getMethod(getMethod().getReturnType(), str);
        if (method2 != null) {
            validateType(stateVariable, method2.getReturnType());
            return new GetterStateVariableAccessor(method2);
        }
        p7.a(getMethod().getReturnType(), "Declared getter method '", str, "' not found on return type: ");
        return null;
    }

    public StateVariable findRelatedStateVariable(String str, String str2, String str3) {
        String methodPropertyName;
        StateVariable stateVariable = (str == null || str.isEmpty()) ? null : getStateVariable(str);
        if (stateVariable == null && str2 != null && !str2.isEmpty()) {
            this.logger.h("Finding related state variable with argument name (converted to UPnP name): {}", AnnotationLocalServiceBinder.toUpnpStateVariableName(str2));
            stateVariable = getStateVariable(str2);
        }
        if (stateVariable == null && str2 != null && !str2.isEmpty()) {
            String str4 = Constants.ARG_TYPE_PREFIX + AnnotationLocalServiceBinder.toUpnpStateVariableName(str2);
            this.logger.h("Finding related state variable with prefixed argument name (converted to UPnP name): {}", str4);
            stateVariable = getStateVariable(str4);
        }
        if (stateVariable != null || str3 == null || str3.isEmpty() || (methodPropertyName = Reflections.getMethodPropertyName(str3)) == null) {
            return stateVariable;
        }
        this.logger.h("Finding related state variable with method property name: {}", methodPropertyName);
        return getStateVariable(AnnotationLocalServiceBinder.toUpnpStateVariableName(methodPropertyName));
    }

    public UpnpAction getAnnotation() {
        return this.annotation;
    }

    public Method getMethod() {
        return this.method;
    }

    public StateVariable getStateVariable(String str) {
        for (StateVariable stateVariable : getStateVariables().keySet()) {
            if (stateVariable.getName().equals(str)) {
                return stateVariable;
            }
        }
        return null;
    }

    public Map<StateVariable, StateVariableAccessor> getStateVariables() {
        return this.stateVariables;
    }

    public Set<Class> getStringConvertibleTypes() {
        return this.stringConvertibleTypes;
    }

    public void validateType(StateVariable stateVariable, Class cls) {
        Datatype.Default byJavaType = ModelUtil.isStringConvertibleType(getStringConvertibleTypes(), cls) ? Datatype.Default.STRING : Datatype.Default.getByJavaType(cls);
        this.logger.i("Expecting '{}' to match default mapping: {}", stateVariable, byJavaType);
        if (byJavaType != null && !stateVariable.getTypeDetails().getDatatype().isHandlingJavaType(byJavaType.getJavaType())) {
            p7.a(byJavaType.getJavaType(), "State variable '", String.valueOf(stateVariable), "' datatype can't handle action argument's Java type (change one): ");
        } else if (byJavaType != null || stateVariable.getTypeDetails().getDatatype().getBuiltin() == null) {
            this.logger.y("State variable matches required argument datatype (or can't be validated because it is custom)");
        } else {
            r7.a("State variable '", String.valueOf(stateVariable), "' should be custom datatype (action argument type is unknown Java type): ", cls.getSimpleName());
        }
    }
}
