package org.jupnp.binding.annotations;

import defpackage.j02;
import defpackage.jl;
import defpackage.n02;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.jupnp.binding.LocalServiceBinder;
import org.jupnp.binding.LocalServiceBindingException;
import org.jupnp.model.ValidationError;
import org.jupnp.model.ValidationException;
import org.jupnp.model.action.ActionExecutor;
import org.jupnp.model.action.QueryStateVariableExecutor;
import org.jupnp.model.meta.Action;
import org.jupnp.model.meta.LocalService;
import org.jupnp.model.meta.QueryStateVariableAction;
import org.jupnp.model.meta.StateVariable;
import org.jupnp.model.state.FieldStateVariableAccessor;
import org.jupnp.model.state.GetterStateVariableAccessor;
import org.jupnp.model.state.StateVariableAccessor;
import org.jupnp.model.types.ServiceId;
import org.jupnp.model.types.ServiceType;
import org.jupnp.model.types.UDAServiceId;
import org.jupnp.model.types.UDAServiceType;
import org.jupnp.model.types.csv.CSV;
import org.jupnp.util.Reflections;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AnnotationLocalServiceBinder implements LocalServiceBinder {
    private final j02 logger = n02.k(AnnotationLocalServiceBinder.class);

    public static String toJavaActionName(String str) {
        if (str.isEmpty()) {
            jl.a("Variable name must be at least 1 character long");
            return null;
        }
        return str.substring(0, 1).toLowerCase(Locale.ENGLISH) + str.substring(1);
    }

    public static String toJavaStateVariableName(String str) {
        if (str.isEmpty()) {
            jl.a("Variable name must be at least 1 character long");
            return null;
        }
        return str.substring(0, 1).toLowerCase(Locale.ENGLISH) + str.substring(1);
    }

    public static String toUpnpActionName(String str) {
        if (str.isEmpty()) {
            jl.a("Action name must be at least 1 character long");
            return null;
        }
        return str.substring(0, 1).toUpperCase(Locale.ENGLISH) + str.substring(1);
    }

    public static String toUpnpStateVariableName(String str) {
        if (str.isEmpty()) {
            jl.a("Variable name must be at least 1 character long");
            return null;
        }
        return str.substring(0, 1).toUpperCase(Locale.ENGLISH) + str.substring(1);
    }

    public boolean isActionExcluded(Action action) {
        return false;
    }

    @Override // org.jupnp.binding.LocalServiceBinder
    public LocalService read(Class<?> cls) {
        this.logger.h("Reading and binding annotations of service implementation class: {}", cls);
        if (!cls.isAnnotationPresent(UpnpService.class)) {
            throw new LocalServiceBindingException("Given class is not an @UpnpService");
        }
        UpnpService upnpService = (UpnpService) cls.getAnnotation(UpnpService.class);
        UpnpServiceId upnpServiceIdServiceId = upnpService.serviceId();
        UpnpServiceType upnpServiceTypeServiceType = upnpService.serviceType();
        return read(cls, upnpServiceIdServiceId.namespace().equals(UDAServiceId.DEFAULT_NAMESPACE) ? new UDAServiceId(upnpServiceIdServiceId.value()) : new ServiceId(upnpServiceIdServiceId.namespace(), upnpServiceIdServiceId.value()), upnpServiceTypeServiceType.namespace().equals("schemas-upnp-org") ? new UDAServiceType(upnpServiceTypeServiceType.value(), upnpServiceTypeServiceType.version()) : new ServiceType(upnpServiceTypeServiceType.namespace(), upnpServiceTypeServiceType.value(), upnpServiceTypeServiceType.version()), upnpService.supportsQueryStateVariables(), readStringConvertibleTypes(upnpService.stringConvertibleTypes()));
    }

    public Map<Action, ActionExecutor> readActions(Class<?> cls, Map<StateVariable, StateVariableAccessor> map, Set<Class> set) {
        HashMap map2 = new HashMap();
        Iterator<Method> it = Reflections.getMethods(cls, UpnpAction.class).iterator();
        while (it.hasNext()) {
            Action actionAppendAction = new AnnotationActionBinder(it.next(), map, set).appendAction(map2);
            if (isActionExcluded(actionAppendAction)) {
                map2.remove(actionAppendAction);
            }
        }
        return map2;
    }

    public Map<StateVariable, StateVariableAccessor> readStateVariables(Class<?> cls, Set<Class> set) {
        StateVariableAccessor fieldStateVariableAccessor;
        GetterStateVariableAccessor getterStateVariableAccessor;
        HashMap map = new HashMap();
        if (cls.isAnnotationPresent(UpnpStateVariables.class)) {
            UpnpStateVariables upnpStateVariables = (UpnpStateVariables) cls.getAnnotation(UpnpStateVariables.class);
            for (UpnpStateVariable upnpStateVariable : upnpStateVariables.value()) {
                if (upnpStateVariable.name().isEmpty()) {
                    throw new LocalServiceBindingException("Class-level @UpnpStateVariable name attribute value required");
                }
                String javaStateVariableName = toJavaStateVariableName(upnpStateVariable.name());
                Method getterMethod = Reflections.getGetterMethod(cls, javaStateVariableName);
                Field field = Reflections.getField(cls, javaStateVariableName);
                if (getterMethod == null || field == null) {
                    if (field != null) {
                        fieldStateVariableAccessor = new FieldStateVariableAccessor(field);
                    } else if (getterMethod != null) {
                        getterStateVariableAccessor = new GetterStateVariableAccessor(getterMethod);
                        fieldStateVariableAccessor = getterStateVariableAccessor;
                    } else {
                        this.logger.h("No field or getter found for state variable, skipping accessor: {}", upnpStateVariable.name());
                        fieldStateVariableAccessor = null;
                    }
                } else if (upnpStateVariables.preferFields()) {
                    fieldStateVariableAccessor = new FieldStateVariableAccessor(field);
                } else {
                    getterStateVariableAccessor = new GetterStateVariableAccessor(getterMethod);
                    fieldStateVariableAccessor = getterStateVariableAccessor;
                }
                map.put(new AnnotationStateVariableBinder(upnpStateVariable, upnpStateVariable.name(), fieldStateVariableAccessor, set).createStateVariable(), fieldStateVariableAccessor);
            }
        }
        for (Field field2 : Reflections.getFields(cls, UpnpStateVariable.class)) {
            UpnpStateVariable upnpStateVariable2 = (UpnpStateVariable) field2.getAnnotation(UpnpStateVariable.class);
            FieldStateVariableAccessor fieldStateVariableAccessor2 = new FieldStateVariableAccessor(field2);
            map.put(new AnnotationStateVariableBinder(upnpStateVariable2, upnpStateVariable2.name().isEmpty() ? toUpnpStateVariableName(field2.getName()) : upnpStateVariable2.name(), fieldStateVariableAccessor2, set).createStateVariable(), fieldStateVariableAccessor2);
        }
        for (Method method : Reflections.getMethods(cls, UpnpStateVariable.class)) {
            String methodPropertyName = Reflections.getMethodPropertyName(method.getName());
            if (methodPropertyName == null) {
                throw new LocalServiceBindingException("Annotated method is not a getter method (: ".concat(String.valueOf(method)));
            }
            if (method.getParameterTypes().length > 0) {
                throw new LocalServiceBindingException("Getter method defined as @UpnpStateVariable can not have parameters: ".concat(String.valueOf(method)));
            }
            UpnpStateVariable upnpStateVariable3 = (UpnpStateVariable) method.getAnnotation(UpnpStateVariable.class);
            GetterStateVariableAccessor getterStateVariableAccessor2 = new GetterStateVariableAccessor(method);
            map.put(new AnnotationStateVariableBinder(upnpStateVariable3, upnpStateVariable3.name().isEmpty() ? toUpnpStateVariableName(methodPropertyName) : upnpStateVariable3.name(), getterStateVariableAccessor2, set).createStateVariable(), getterStateVariableAccessor2);
        }
        return map;
    }

    public Set<Class> readStringConvertibleTypes(Class[] clsArr) {
        for (Class cls : clsArr) {
            if (!Modifier.isPublic(cls.getModifiers())) {
                throw new LocalServiceBindingException("Declared string-convertible type must be public: ".concat(String.valueOf(cls)));
            }
            try {
                cls.getConstructor(String.class);
            } catch (NoSuchMethodException unused) {
                throw new LocalServiceBindingException("Declared string-convertible type needs a public single-argument String constructor: ".concat(String.valueOf(cls)));
            }
        }
        HashSet hashSet = new HashSet(Arrays.asList(clsArr));
        hashSet.add(URI.class);
        hashSet.add(URL.class);
        hashSet.add(CSV.class);
        return hashSet;
    }

    @Override // org.jupnp.binding.LocalServiceBinder
    public LocalService read(Class<?> cls, ServiceId serviceId, ServiceType serviceType, boolean z, Class[] clsArr) {
        return read(cls, serviceId, serviceType, z, new HashSet(Arrays.asList(clsArr)));
    }

    public LocalService read(Class<?> cls, ServiceId serviceId, ServiceType serviceType, boolean z, Set<Class> set) {
        Map<StateVariable, StateVariableAccessor> stateVariables = readStateVariables(cls, set);
        Map<Action, ActionExecutor> actions = readActions(cls, stateVariables, set);
        if (z) {
            actions.put(new QueryStateVariableAction(), new QueryStateVariableExecutor());
        }
        try {
            return new LocalService(serviceType, serviceId, actions, stateVariables, set, z);
        } catch (ValidationException e) {
            this.logger.a("Could not validate device model", e);
            Iterator<ValidationError> it = e.getErrors().iterator();
            while (it.hasNext()) {
                this.logger.error(it.next().toString());
            }
            throw new LocalServiceBindingException("Validation of model failed, check the log");
        }
    }
}
