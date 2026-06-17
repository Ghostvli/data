package org.jupnp.model.state;

import java.lang.reflect.Method;
import org.jupnp.util.Reflections;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class GetterStateVariableAccessor extends StateVariableAccessor {
    private Method getter;

    public GetterStateVariableAccessor(Method method) {
        this.getter = method;
    }

    public Method getGetter() {
        return this.getter;
    }

    @Override // org.jupnp.model.state.StateVariableAccessor
    public Class<?> getReturnType() {
        return getGetter().getReturnType();
    }

    @Override // org.jupnp.model.state.StateVariableAccessor
    public Object read(Object obj) {
        return Reflections.invoke(getGetter(), obj, new Object[0]);
    }

    @Override // org.jupnp.model.state.StateVariableAccessor
    public String toString() {
        return super.toString() + " Method: " + String.valueOf(getGetter());
    }
}
