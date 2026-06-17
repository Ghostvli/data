package org.jupnp.model.meta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jupnp.model.Validatable;
import org.jupnp.model.ValidationError;
import org.jupnp.model.types.Datatype;
import org.jupnp.util.SpecificationViolationReporter;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class StateVariableTypeDetails implements Validatable {
    private final StateVariableAllowedValueRange allowedValueRange;
    private final String[] allowedValues;
    private final Datatype datatype;
    private final String defaultValue;

    public StateVariableTypeDetails(Datatype datatype, String str, String[] strArr, StateVariableAllowedValueRange stateVariableAllowedValueRange) {
        this.datatype = datatype;
        this.defaultValue = str;
        this.allowedValues = strArr;
        this.allowedValueRange = stateVariableAllowedValueRange;
    }

    public boolean foundDefaultInAllowedValues(String str, String[] strArr) {
        if (str == null || strArr == null) {
            return true;
        }
        for (String str2 : strArr) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public StateVariableAllowedValueRange getAllowedValueRange() {
        return this.allowedValueRange;
    }

    public String[] getAllowedValues() {
        if (foundDefaultInAllowedValues(this.defaultValue, this.allowedValues)) {
            return this.allowedValues;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(this.allowedValues));
        arrayList.add(getDefaultValue());
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public Datatype getDatatype() {
        return this.datatype;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    @Override // org.jupnp.model.Validatable
    public List<ValidationError> validate() {
        ArrayList arrayList = new ArrayList();
        if (getDatatype() == null) {
            arrayList.add(new ValidationError(getClass(), "datatype", "Service state variable has no datatype"));
        }
        if (getAllowedValues() != null) {
            if (getAllowedValueRange() != null) {
                arrayList.add(new ValidationError(getClass(), "allowedValues", "Allowed value list of state variable can not also be restricted with allowed value range"));
            }
            if (!Datatype.Builtin.STRING.equals(getDatatype().getBuiltin())) {
                arrayList.add(new ValidationError(getClass(), "allowedValues", "Allowed value list of state variable only available for string datatype, not: ".concat(String.valueOf(getDatatype()))));
            }
            for (String str : getAllowedValues()) {
                if (str.length() > 31) {
                    SpecificationViolationReporter.report("Allowed value string must be less than 32 chars: {}", str);
                }
            }
            if (!foundDefaultInAllowedValues(this.defaultValue, this.allowedValues)) {
                SpecificationViolationReporter.report("Allowed string values don't contain default value: {}", this.defaultValue);
            }
        }
        if (getAllowedValueRange() != null) {
            arrayList.addAll(getAllowedValueRange().validate());
        }
        return arrayList;
    }

    public StateVariableTypeDetails(Datatype datatype, String str) {
        this(datatype, str, null, null);
    }

    public StateVariableTypeDetails(Datatype datatype) {
        this(datatype, null, null, null);
    }
}
