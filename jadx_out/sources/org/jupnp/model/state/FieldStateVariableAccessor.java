package org.jupnp.model.state;

import java.lang.reflect.Field;
import org.jupnp.util.Reflections;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class FieldStateVariableAccessor extends StateVariableAccessor {
    protected Field field;

    public FieldStateVariableAccessor(Field field) {
        this.field = field;
    }

    public Field getField() {
        return this.field;
    }

    @Override // org.jupnp.model.state.StateVariableAccessor
    public Class<?> getReturnType() {
        return getField().getType();
    }

    @Override // org.jupnp.model.state.StateVariableAccessor
    public Object read(Object obj) {
        return Reflections.get(this.field, obj);
    }

    @Override // org.jupnp.model.state.StateVariableAccessor
    public String toString() {
        return super.toString() + " Field: " + String.valueOf(getField());
    }
}
