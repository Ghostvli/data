package org.jupnp.model.types;

import java.lang.reflect.ParameterizedType;
import org.jupnp.model.types.Datatype;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractDatatype<V> implements Datatype<V> {
    private Datatype.Builtin builtin;

    @Override // org.jupnp.model.types.Datatype
    public Datatype.Builtin getBuiltin() {
        return this.builtin;
    }

    @Override // org.jupnp.model.types.Datatype
    public String getDisplayString() {
        return this instanceof CustomDatatype ? ((CustomDatatype) this).getName() : getBuiltin() != null ? getBuiltin().getDescriptorName() : getValueType().getSimpleName();
    }

    @Override // org.jupnp.model.types.Datatype
    public String getString(V v) {
        if (v == null) {
            return "";
        }
        if (isValid(v)) {
            return v.toString();
        }
        throw new InvalidValueException("Value is not valid: ".concat(String.valueOf(v)));
    }

    public Class<V> getValueType() {
        return (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override // org.jupnp.model.types.Datatype
    public boolean isHandlingJavaType(Class cls) {
        return getValueType().isAssignableFrom(cls);
    }

    @Override // org.jupnp.model.types.Datatype
    public boolean isValid(V v) {
        return v == null || getValueType().isAssignableFrom(v.getClass());
    }

    public void setBuiltin(Datatype.Builtin builtin) {
        this.builtin = builtin;
    }

    public String toString() {
        return "(" + getClass().getSimpleName() + ")";
    }

    @Override // org.jupnp.model.types.Datatype
    public V valueOf(String str) {
        return null;
    }
}
