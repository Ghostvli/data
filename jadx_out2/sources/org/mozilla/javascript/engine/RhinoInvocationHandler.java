package org.mozilla.javascript.engine;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class RhinoInvocationHandler implements InvocationHandler {
    private final RhinoScriptEngine engine;
    private final Object thiz;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public RhinoInvocationHandler(RhinoScriptEngine rhinoScriptEngine, Object obj) {
        this.engine = rhinoScriptEngine;
        this.thiz = obj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        return this.engine.invokeMethodRaw(this.thiz, method.getName(), method.getReturnType(), objArr);
    }
}
