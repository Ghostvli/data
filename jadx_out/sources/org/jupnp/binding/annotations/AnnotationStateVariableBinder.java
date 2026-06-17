package org.jupnp.binding.annotations;

import defpackage.j02;
import defpackage.n02;
import defpackage.q7;
import defpackage.r7;
import java.util.Set;
import org.jupnp.binding.AllowedValueProvider;
import org.jupnp.binding.AllowedValueRangeProvider;
import org.jupnp.binding.LocalServiceBindingException;
import org.jupnp.model.ModelUtil;
import org.jupnp.model.meta.StateVariable;
import org.jupnp.model.meta.StateVariableAllowedValueRange;
import org.jupnp.model.meta.StateVariableEventDetails;
import org.jupnp.model.meta.StateVariableTypeDetails;
import org.jupnp.model.state.StateVariableAccessor;
import org.jupnp.model.types.Datatype;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AnnotationStateVariableBinder {
    protected StateVariableAccessor accessor;
    protected UpnpStateVariable annotation;
    private final j02 logger = n02.k(AnnotationLocalServiceBinder.class);
    protected String name;
    protected Set<Class> stringConvertibleTypes;

    public AnnotationStateVariableBinder(UpnpStateVariable upnpStateVariable, String str, StateVariableAccessor stateVariableAccessor, Set<Class> set) {
        this.annotation = upnpStateVariable;
        this.name = str;
        this.accessor = stateVariableAccessor;
        this.stringConvertibleTypes = set;
    }

    public Datatype createDatatype() {
        String strDatatype = getAnnotation().datatype();
        if (strDatatype.isEmpty() && getAccessor() != null) {
            Class<?> returnType = getAccessor().getReturnType();
            this.logger.h("Using accessor return type as state variable type: {}", returnType);
            if (ModelUtil.isStringConvertibleType(getStringConvertibleTypes(), returnType)) {
                this.logger.y("Return type is string-convertible, using string datatype");
                return Datatype.Default.STRING.getBuiltinType().getDatatype();
            }
            Datatype.Default byJavaType = Datatype.Default.getByJavaType(returnType);
            if (byJavaType != null) {
                this.logger.h("Return type has default UPnP datatype: {}", byJavaType);
                return byJavaType.getBuiltinType().getDatatype();
            }
        }
        if (strDatatype.isEmpty() && (getAnnotation().allowedValues().length > 0 || getAnnotation().allowedValuesEnum() != Void.TYPE)) {
            this.logger.y("State variable has restricted allowed values, hence using 'string' datatype");
            strDatatype = "string";
        }
        if (strDatatype.isEmpty()) {
            q7.a("Could not detect datatype of state variable: ", getName());
            return null;
        }
        this.logger.h("Trying to find built-in UPnP datatype for detected name: {}", strDatatype);
        Datatype.Builtin byDescriptorName = Datatype.Builtin.getByDescriptorName(strDatatype);
        if (byDescriptorName == null) {
            throw new LocalServiceBindingException("No built-in UPnP datatype found, using CustomDataType (TODO: NOT IMPLEMENTED)");
        }
        this.logger.h("Found built-in UPnP datatype: {}", byDescriptorName);
        return byDescriptorName.getDatatype();
    }

    public String createDefaultValue(Datatype datatype) {
        if (getAnnotation().defaultValue().isEmpty()) {
            return null;
        }
        try {
            datatype.valueOf(getAnnotation().defaultValue());
            this.logger.h("Found state variable default value: {}", getAnnotation().defaultValue());
            return getAnnotation().defaultValue();
        } catch (Exception e) {
            r7.a("Default value doesn't match datatype of state variable '", this.getName(), "': ", e.getMessage());
            return null;
        }
    }

    public StateVariable createStateVariable() {
        String[] allowedValues;
        AnnotationStateVariableBinder annotationStateVariableBinder;
        StateVariableAllowedValueRange allowedValueRange;
        int i;
        int iEventMaximumRateMilliseconds;
        this.logger.i("Creating state variable '{}' with accessor: {}", getName(), getAccessor());
        Datatype datatypeCreateDatatype = createDatatype();
        String strCreateDefaultValue = createDefaultValue(datatypeCreateDatatype);
        boolean zEquals = Datatype.Builtin.STRING.equals(datatypeCreateDatatype.getBuiltin());
        Class cls = Void.TYPE;
        int iEventMinimumDelta = 0;
        if (zEquals) {
            if (getAnnotation().allowedValueProvider() != cls) {
                allowedValues = getAllowedValuesFromProvider();
            } else if (getAnnotation().allowedValues().length > 0) {
                allowedValues = getAnnotation().allowedValues();
            } else if (getAnnotation().allowedValuesEnum() != cls) {
                allowedValues = getAllowedValues(getAnnotation().allowedValuesEnum());
            } else if (getAccessor() == null || !getAccessor().getReturnType().isEnum()) {
                this.logger.h("Not restricting allowed values (of string typed state var): {}", getName());
                allowedValues = null;
            } else {
                allowedValues = getAllowedValues(getAccessor().getReturnType());
            }
            if (allowedValues != null && strCreateDefaultValue != null) {
                for (String str : allowedValues) {
                    if (!str.equals(strCreateDefaultValue)) {
                    }
                }
                r7.a("Default value '", strCreateDefaultValue, "' is not in allowed values of: ", getName());
                return null;
            }
        } else {
            allowedValues = null;
        }
        if (Datatype.Builtin.isNumeric(datatypeCreateDatatype.getBuiltin())) {
            if (getAnnotation().allowedValueRangeProvider() != cls) {
                allowedValueRange = getAllowedRangeFromProvider();
                annotationStateVariableBinder = this;
            } else if (getAnnotation().allowedValueMinimum() > 0 || getAnnotation().allowedValueMaximum() > 0) {
                annotationStateVariableBinder = this;
                allowedValueRange = annotationStateVariableBinder.getAllowedValueRange(getAnnotation().allowedValueMinimum(), getAnnotation().allowedValueMaximum(), getAnnotation().allowedValueStep());
            } else {
                this.logger.h("Not restricting allowed value range (of numeric typed state var): {}", getName());
                annotationStateVariableBinder = this;
                allowedValueRange = null;
            }
            if (strCreateDefaultValue != null && allowedValueRange != null) {
                try {
                    if (!allowedValueRange.isInRange(Long.parseLong(strCreateDefaultValue))) {
                        r7.a("Default value '", strCreateDefaultValue, "' is not in allowed range of: ", annotationStateVariableBinder.getName());
                        return null;
                    }
                } catch (Exception unused) {
                    r7.a("Default value '", strCreateDefaultValue, "' is not numeric (for range checking) of: ", annotationStateVariableBinder.getName());
                    return null;
                }
            }
        } else {
            annotationStateVariableBinder = this;
            allowedValueRange = null;
        }
        boolean zSendEvents = annotationStateVariableBinder.getAnnotation().sendEvents();
        if (zSendEvents && annotationStateVariableBinder.getAccessor() == null) {
            q7.a("State variable sends events but has no accessor for field or getter: ", annotationStateVariableBinder.getName());
            return null;
        }
        if (zSendEvents) {
            if (annotationStateVariableBinder.getAnnotation().eventMaximumRateMilliseconds() > 0) {
                annotationStateVariableBinder.logger.h("Moderating state variable events using maximum rate (milliseconds): {}", Integer.valueOf(annotationStateVariableBinder.getAnnotation().eventMaximumRateMilliseconds()));
                iEventMaximumRateMilliseconds = annotationStateVariableBinder.getAnnotation().eventMaximumRateMilliseconds();
            } else {
                iEventMaximumRateMilliseconds = 0;
            }
            if (annotationStateVariableBinder.getAnnotation().eventMinimumDelta() > 0 && Datatype.Builtin.isNumeric(datatypeCreateDatatype.getBuiltin())) {
                annotationStateVariableBinder.logger.h("Moderating state variable events using minimum delta: {}", Integer.valueOf(annotationStateVariableBinder.getAnnotation().eventMinimumDelta()));
                iEventMinimumDelta = annotationStateVariableBinder.getAnnotation().eventMinimumDelta();
            }
            int i2 = iEventMinimumDelta;
            iEventMinimumDelta = iEventMaximumRateMilliseconds;
            i = i2;
        } else {
            i = 0;
        }
        return new StateVariable(annotationStateVariableBinder.getName(), new StateVariableTypeDetails(datatypeCreateDatatype, strCreateDefaultValue, allowedValues, allowedValueRange), new StateVariableEventDetails(zSendEvents, iEventMinimumDelta, i));
    }

    public StateVariableAccessor getAccessor() {
        return this.accessor;
    }

    public StateVariableAllowedValueRange getAllowedRangeFromProvider() {
        AllowedValueRangeProvider allowedValueRangeProvider;
        Class clsAllowedValueRangeProvider = getAnnotation().allowedValueRangeProvider();
        if (!AllowedValueRangeProvider.class.isAssignableFrom(clsAllowedValueRangeProvider)) {
            r7.a("Allowed value range provider is not of type ", String.valueOf(AllowedValueRangeProvider.class), ": ", getName());
            return null;
        }
        try {
            allowedValueRangeProvider = (AllowedValueRangeProvider) clsAllowedValueRangeProvider.getDeclaredConstructor(null).newInstance(null);
        } catch (Exception e) {
            e = e;
        }
        try {
            return getAllowedValueRange(allowedValueRangeProvider.getMinimum(), allowedValueRangeProvider.getMaximum(), allowedValueRangeProvider.getStep());
        } catch (Exception e2) {
            e = e2;
            this = this;
            throw new LocalServiceBindingException("Allowed value range provider can't be instantiated: " + this.getName(), e);
        }
    }

    public StateVariableAllowedValueRange getAllowedValueRange(long j, long j2, long j3) {
        if (j2 >= j) {
            return new StateVariableAllowedValueRange(j, j2, j3);
        }
        q7.a("Allowed value range maximum is smaller than minimum: ", getName());
        return null;
    }

    public String[] getAllowedValues(Class cls) {
        if (!cls.isEnum()) {
            throw new LocalServiceBindingException("Allowed values type is not an Enum: ".concat(String.valueOf(cls)));
        }
        this.logger.h("Restricting allowed values of state variable to Enum: {}", getName());
        String[] strArr = new String[cls.getEnumConstants().length];
        for (int i = 0; i < cls.getEnumConstants().length; i++) {
            Object obj = cls.getEnumConstants()[i];
            if (obj.toString().length() > 32) {
                throw new LocalServiceBindingException("Allowed value string (that is, Enum constant name) is longer than 32 characters: ".concat(String.valueOf(obj)));
            }
            this.logger.h("Adding allowed value (converted to string): {}", obj);
            strArr[i] = obj.toString();
        }
        return strArr;
    }

    public String[] getAllowedValuesFromProvider() {
        Class clsAllowedValueProvider = getAnnotation().allowedValueProvider();
        if (!AllowedValueProvider.class.isAssignableFrom(clsAllowedValueProvider)) {
            r7.a("Allowed value provider is not of type ", String.valueOf(AllowedValueProvider.class), ": ", getName());
            return null;
        }
        try {
            return ((AllowedValueProvider) clsAllowedValueProvider.getDeclaredConstructor(null).newInstance(null)).getValues();
        } catch (Exception e) {
            throw new LocalServiceBindingException("Allowed value provider can't be instantiated: " + this.getName(), e);
        }
    }

    public UpnpStateVariable getAnnotation() {
        return this.annotation;
    }

    public String getName() {
        return this.name;
    }

    public Set<Class> getStringConvertibleTypes() {
        return this.stringConvertibleTypes;
    }
}
