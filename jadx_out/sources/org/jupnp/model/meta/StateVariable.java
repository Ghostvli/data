package org.jupnp.model.meta;

import defpackage.e04;
import java.util.ArrayList;
import java.util.List;
import org.jupnp.model.ModelUtil;
import org.jupnp.model.Validatable;
import org.jupnp.model.ValidationError;
import org.jupnp.model.meta.Service;
import org.jupnp.model.types.Datatype;
import org.jupnp.util.SpecificationViolationReporter;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class StateVariable<S extends Service> implements Validatable {
    private final StateVariableEventDetails eventDetails;
    private final String name;
    private S service;
    private final StateVariableTypeDetails type;

    public StateVariable(String str, StateVariableTypeDetails stateVariableTypeDetails, StateVariableEventDetails stateVariableEventDetails) {
        this.name = str;
        this.type = stateVariableTypeDetails;
        this.eventDetails = stateVariableEventDetails;
    }

    public StateVariable<S> deepCopy() {
        return new StateVariable<>(getName(), getTypeDetails(), getEventDetails());
    }

    public StateVariableEventDetails getEventDetails() {
        return this.eventDetails;
    }

    public String getName() {
        return this.name;
    }

    public S getService() {
        return this.service;
    }

    public StateVariableTypeDetails getTypeDetails() {
        return this.type;
    }

    public boolean isModeratedNumericType() {
        return Datatype.Builtin.isNumeric(getTypeDetails().getDatatype().getBuiltin()) && getEventDetails().getEventMinimumDelta() > 0;
    }

    public void setService(S s) {
        if (this.service == null) {
            this.service = s;
        } else {
            e04.a("Final value has been set already, model is immutable");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(getClass().getSimpleName());
        sb.append(", Name: ");
        sb.append(getName());
        sb.append(", Type: ");
        sb.append(getTypeDetails().getDatatype().getDisplayString());
        sb.append(")");
        if (!getEventDetails().isSendEvents()) {
            sb.append(" (No Events)");
        }
        if (getTypeDetails().getDefaultValue() != null) {
            sb.append(" Default Value: '");
            sb.append(getTypeDetails().getDefaultValue());
            sb.append("'");
        }
        if (getTypeDetails().getAllowedValues() != null) {
            sb.append(" Allowed Values: ");
            for (String str : getTypeDetails().getAllowedValues()) {
                sb.append(str);
                sb.append("|");
            }
        }
        return sb.toString();
    }

    @Override // org.jupnp.model.Validatable
    public List<ValidationError> validate() {
        ArrayList arrayList = new ArrayList();
        if (getName() == null || getName().isEmpty()) {
            arrayList.add(new ValidationError(getClass(), "name", "StateVariable without name of: ".concat(String.valueOf(getService()))));
        } else if (!ModelUtil.isValidUDAName(getName())) {
            SpecificationViolationReporter.report(getService().getDevice(), "Invalid state variable name: {}", this);
        }
        arrayList.addAll(getTypeDetails().validate());
        return arrayList;
    }

    public StateVariable(String str, StateVariableTypeDetails stateVariableTypeDetails) {
        this(str, stateVariableTypeDetails, new StateVariableEventDetails());
    }
}
