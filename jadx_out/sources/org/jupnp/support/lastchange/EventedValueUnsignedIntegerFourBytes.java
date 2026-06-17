package org.jupnp.support.lastchange;

import java.util.Map;
import org.jupnp.model.types.Datatype;
import org.jupnp.model.types.UnsignedIntegerFourBytes;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class EventedValueUnsignedIntegerFourBytes extends EventedValue<UnsignedIntegerFourBytes> {
    public EventedValueUnsignedIntegerFourBytes(UnsignedIntegerFourBytes unsignedIntegerFourBytes) {
        super(unsignedIntegerFourBytes);
    }

    @Override // org.jupnp.support.lastchange.EventedValue
    public Datatype<?> getDatatype() {
        return Datatype.Builtin.UI4.getDatatype();
    }

    public EventedValueUnsignedIntegerFourBytes(Map.Entry<String, String>[] entryArr) {
        super(entryArr);
    }
}
