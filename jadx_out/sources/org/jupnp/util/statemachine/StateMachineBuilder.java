package org.jupnp.util.statemachine;

import java.lang.reflect.Proxy;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class StateMachineBuilder {
    public static <T extends StateMachine> T build(Class<T> cls, Class<?> cls2, Class<?>[] clsArr, Object[] objArr) {
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new StateMachineInvocationHandler(Arrays.asList(((States) cls.getAnnotation(States.class)).value()), cls2, clsArr, objArr));
    }

    public static <T extends StateMachine> T build(Class<T> cls, Class<?> cls2) {
        return (T) build(cls, cls2, null, null);
    }
}
