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
public class ActionArgument<S extends Service> implements Validatable {
    private Action<S> action;
    private final String[] aliases;
    private final Direction direction;
    private final String name;
    private final String relatedStateVariableName;
    private final boolean returnValue;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum Direction {
        IN,
        OUT
    }

    public ActionArgument(String str, String[] strArr, String str2, Direction direction, boolean z) {
        this.name = str;
        this.aliases = strArr;
        this.relatedStateVariableName = str2;
        this.direction = direction;
        this.returnValue = z;
    }

    public ActionArgument<S> deepCopy() {
        return new ActionArgument<>(getName(), getAliases(), getRelatedStateVariableName(), getDirection(), isReturnValue());
    }

    public Action<S> getAction() {
        return this.action;
    }

    public String[] getAliases() {
        return this.aliases;
    }

    public Datatype getDatatype() {
        return getAction().getService().getDatatype(this);
    }

    public Direction getDirection() {
        return this.direction;
    }

    public String getName() {
        return this.name;
    }

    public String getRelatedStateVariableName() {
        return this.relatedStateVariableName;
    }

    public boolean isNameOrAlias(String str) {
        if (getName().equalsIgnoreCase(str)) {
            return true;
        }
        for (String str2 : this.aliases) {
            if (str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean isReturnValue() {
        return this.returnValue;
    }

    public void setAction(Action<S> action) {
        if (this.action == null) {
            this.action = action;
        } else {
            e04.a("Final value has been set already, model is immutable");
        }
    }

    public String toString() {
        return "(" + getClass().getSimpleName() + ", " + String.valueOf(getDirection()) + ") " + getName();
    }

    @Override // org.jupnp.model.Validatable
    public List<ValidationError> validate() {
        ArrayList arrayList = new ArrayList();
        if (getName() == null || getName().isEmpty()) {
            arrayList.add(new ValidationError(getClass(), "name", "Argument without name of: ".concat(String.valueOf(getAction()))));
        } else if (!ModelUtil.isValidUDAName(getName())) {
            SpecificationViolationReporter.report(getAction().getService().getDevice(), "Invalid argument name: {}", this);
        } else if (getName().length() > 32) {
            SpecificationViolationReporter.report(getAction().getService().getDevice(), "Argument name should be less than 32 characters: {}", this);
        }
        if (getDirection() == null) {
            arrayList.add(new ValidationError(getClass(), "direction", "Argument '" + getName() + "' requires a direction, either IN or OUT"));
        }
        if (isReturnValue() && getDirection() != Direction.OUT) {
            arrayList.add(new ValidationError(getClass(), "direction", "Return value argument '" + getName() + "' must be direction OUT"));
        }
        return arrayList;
    }

    public ActionArgument(String str, String[] strArr, String str2, Direction direction) {
        this(str, strArr, str2, direction, false);
    }

    public ActionArgument(String str, String str2, Direction direction, boolean z) {
        this(str, new String[0], str2, direction, z);
    }

    public ActionArgument(String str, String str2, Direction direction) {
        this(str, new String[0], str2, direction, false);
    }
}
