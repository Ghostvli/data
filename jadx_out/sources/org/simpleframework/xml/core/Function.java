package org.simpleframework.xml.core;

import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class Function {
    private final boolean contextual;
    private final Method method;

    public Function(Method method, boolean z) {
        this.contextual = z;
        this.method = method;
    }

    public Object call(Context context, Object obj) {
        if (obj == null) {
            return null;
        }
        Map map = context.getSession().getMap();
        boolean z = this.contextual;
        Method method = this.method;
        return z ? method.invoke(obj, map) : method.invoke(obj, null);
    }

    public Function(Method method) {
        this(method, false);
    }
}
