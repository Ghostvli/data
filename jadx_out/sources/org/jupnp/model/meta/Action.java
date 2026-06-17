package org.jupnp.model.meta;

import defpackage.e04;
import java.util.ArrayList;
import java.util.List;
import org.jupnp.model.ModelUtil;
import org.jupnp.model.Validatable;
import org.jupnp.model.ValidationError;
import org.jupnp.model.meta.ActionArgument;
import org.jupnp.model.meta.Service;
import org.jupnp.util.SpecificationViolationReporter;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Action<S extends Service> implements Validatable {
    private final ActionArgument[] arguments;
    private final ActionArgument[] inputArguments;
    private final String name;
    private final ActionArgument[] outputArguments;
    private S service;

    public Action(String str, ActionArgument[] actionArgumentArr) {
        this.name = str;
        if (actionArgumentArr == null) {
            this.arguments = new ActionArgument[0];
            this.inputArguments = new ActionArgument[0];
            this.outputArguments = new ActionArgument[0];
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ActionArgument actionArgument : actionArgumentArr) {
            actionArgument.setAction(this);
            if (actionArgument.getDirection().equals(ActionArgument.Direction.IN)) {
                arrayList.add(actionArgument);
            }
            if (actionArgument.getDirection().equals(ActionArgument.Direction.OUT)) {
                arrayList2.add(actionArgument);
            }
        }
        this.arguments = actionArgumentArr;
        this.inputArguments = (ActionArgument[]) arrayList.toArray(new ActionArgument[arrayList.size()]);
        this.outputArguments = (ActionArgument[]) arrayList2.toArray(new ActionArgument[arrayList2.size()]);
    }

    public Action<S> deepCopy() {
        ActionArgument[] actionArgumentArr = new ActionArgument[getArguments().length];
        for (int i = 0; i < getArguments().length; i++) {
            actionArgumentArr[i] = getArguments()[i].deepCopy();
        }
        return new Action<>(getName(), actionArgumentArr);
    }

    public ActionArgument[] getArguments() {
        return this.arguments;
    }

    public ActionArgument<S> getFirstInputArgument() {
        if (hasInputArguments()) {
            return getInputArguments()[0];
        }
        e04.a("No input arguments: ".concat(String.valueOf(this)));
        return null;
    }

    public ActionArgument<S> getFirstOutputArgument() {
        if (hasOutputArguments()) {
            return getOutputArguments()[0];
        }
        e04.a("No output arguments: ".concat(String.valueOf(this)));
        return null;
    }

    public ActionArgument<S> getInputArgument(String str) {
        for (ActionArgument<S> actionArgument : getInputArguments()) {
            if (actionArgument.isNameOrAlias(str)) {
                return actionArgument;
            }
        }
        return null;
    }

    public ActionArgument<S>[] getInputArguments() {
        return this.inputArguments;
    }

    public String getName() {
        return this.name;
    }

    public ActionArgument<S> getOutputArgument(String str) {
        for (ActionArgument<S> actionArgument : getOutputArguments()) {
            if (actionArgument.getName().equals(str)) {
                return actionArgument;
            }
        }
        return null;
    }

    public ActionArgument<S>[] getOutputArguments() {
        return this.outputArguments;
    }

    public S getService() {
        return this.service;
    }

    public boolean hasArguments() {
        return getArguments() != null && getArguments().length > 0;
    }

    public boolean hasInputArguments() {
        return getInputArguments() != null && getInputArguments().length > 0;
    }

    public boolean hasOutputArguments() {
        return getOutputArguments() != null && getOutputArguments().length > 0;
    }

    public void setService(S s) {
        if (this.service == null) {
            this.service = s;
        } else {
            e04.a("Final value has been set already, model is immutable");
        }
    }

    public String toString() {
        return "(" + getClass().getSimpleName() + ", Arguments: " + String.valueOf(getArguments() != null ? Integer.valueOf(getArguments().length) : "NO ARGS") + ") " + getName();
    }

    @Override // org.jupnp.model.Validatable
    public List<ValidationError> validate() {
        ArrayList arrayList = new ArrayList();
        if (getName() == null || getName().isEmpty()) {
            arrayList.add(new ValidationError(getClass(), "name", "Action without name of: ".concat(String.valueOf(getService()))));
        } else if (!ModelUtil.isValidUDAName(getName())) {
            SpecificationViolationReporter.report(getService().getDevice(), "Invalid action name: {}", this);
        }
        for (ActionArgument actionArgument : getArguments()) {
            if (getService().getStateVariable(actionArgument.getRelatedStateVariableName()) == null) {
                arrayList.add(new ValidationError(getClass(), "arguments", "Action argument references an unknown state variable: " + actionArgument.getRelatedStateVariableName()));
            }
        }
        ActionArgument actionArgument2 = null;
        int i = 0;
        int i2 = 0;
        for (ActionArgument actionArgument3 : getArguments()) {
            if (actionArgument3.isReturnValue()) {
                if (actionArgument3.getDirection() == ActionArgument.Direction.IN) {
                    SpecificationViolationReporter.report(getService().getDevice(), "Input argument can not have <retval/>", new Object[0]);
                } else {
                    if (actionArgument2 != null) {
                        SpecificationViolationReporter.report(getService().getDevice(), "Only one argument of action '{}' can be <retval/>", getName());
                    }
                    i2 = i;
                    actionArgument2 = actionArgument3;
                }
            }
            i++;
        }
        if (actionArgument2 != null) {
            for (int i3 = 0; i3 < i2; i3++) {
                if (getArguments()[i3].getDirection() == ActionArgument.Direction.OUT) {
                    SpecificationViolationReporter.report(getService().getDevice(), "Argument '{}' of action '{}' is <retval/> but not the first OUT argument", actionArgument2.getName(), getName());
                }
            }
        }
        for (ActionArgument actionArgument4 : this.arguments) {
            arrayList.addAll(actionArgument4.validate());
        }
        return arrayList;
    }
}
