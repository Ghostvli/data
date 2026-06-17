package org.jupnp.support.lastchange;

import java.lang.Enum;
import java.util.Map;
import org.jupnp.model.types.Datatype;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class EventedValueEnum<E extends Enum<E>> extends EventedValue<E> {
    public EventedValueEnum(E e) {
        super(e);
    }

    public abstract E enumValueOf(String str);

    @Override // org.jupnp.support.lastchange.EventedValue
    public Datatype<?> getDatatype() {
        return null;
    }

    @Override // org.jupnp.support.lastchange.EventedValue
    public String toString() {
        return getValue().name();
    }

    public EventedValueEnum(Map.Entry<String, String>[] entryArr) {
        super(entryArr);
    }

    @Override // org.jupnp.support.lastchange.EventedValue
    public E valueOf(String str) {
        return (E) enumValueOf(str);
    }
}
