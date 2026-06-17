package org.jupnp.support.lastchange;

import java.util.Map;
import org.jupnp.model.types.Datatype;
import org.jupnp.model.types.UnsignedIntegerTwoBytes;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class EventedValueUnsignedIntegerTwoBytes extends EventedValue<UnsignedIntegerTwoBytes> {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public EventedValueUnsignedIntegerTwoBytes(UnsignedIntegerTwoBytes unsignedIntegerTwoBytes) {
        super(unsignedIntegerTwoBytes);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.support.lastchange.EventedValue
    public Datatype<?> getDatatype() {
        return Datatype.Builtin.UI2.getDatatype();
    }

    public EventedValueUnsignedIntegerTwoBytes(Map.Entry<String, String>[] entryArr) {
        super(entryArr);
    }
}
