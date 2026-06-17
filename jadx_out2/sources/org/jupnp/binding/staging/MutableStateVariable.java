package org.jupnp.binding.staging;

import java.util.List;
import org.jupnp.model.meta.StateVariable;
import org.jupnp.model.meta.StateVariableAllowedValueRange;
import org.jupnp.model.meta.StateVariableEventDetails;
import org.jupnp.model.meta.StateVariableTypeDetails;
import org.jupnp.model.types.Datatype;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class MutableStateVariable {
    public MutableAllowedValueRange allowedValueRange;
    public List<String> allowedValues;
    public Datatype dataType;
    public String defaultValue;
    public StateVariableEventDetails eventDetails;
    public String name;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public StateVariable build() {
        String[] strArr;
        String str = this.name;
        Datatype datatype = this.dataType;
        String str2 = this.defaultValue;
        List<String> list = this.allowedValues;
        if (list == null || list.isEmpty()) {
            strArr = null;
        } else {
            List<String> list2 = this.allowedValues;
            strArr = (String[]) list2.toArray(new String[list2.size()]);
        }
        MutableAllowedValueRange mutableAllowedValueRange = this.allowedValueRange;
        return new StateVariable(str, new StateVariableTypeDetails(datatype, str2, strArr, mutableAllowedValueRange != null ? new StateVariableAllowedValueRange(mutableAllowedValueRange.minimum.longValue(), this.allowedValueRange.maximum.longValue(), this.allowedValueRange.step.longValue()) : null), this.eventDetails);
    }
}
