package org.jupnp.support.lastchange;

import java.util.Map;
import org.jupnp.model.types.Datatype;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class EventedValueString extends EventedValue<String> {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public EventedValueString(String str) {
        super(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.support.lastchange.EventedValue
    public Datatype<?> getDatatype() {
        return Datatype.Builtin.STRING.getDatatype();
    }

    public EventedValueString(Map.Entry<String, String>[] entryArr) {
        super(entryArr);
    }
}
