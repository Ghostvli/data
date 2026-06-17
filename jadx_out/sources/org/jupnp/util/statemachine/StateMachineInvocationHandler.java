package org.jupnp.util.statemachine;

import defpackage.j02;
import defpackage.n02;
import defpackage.u04;
import defpackage.zt2;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class StateMachineInvocationHandler implements InvocationHandler {
    public static final String METHOD_ON_ENTRY = "onEntry";
    public static final String METHOD_ON_EXIT = "onExit";
    Object currentState;
    final Class<?> initialStateClass;
    private final j02 logger;
    final Map<Class<?>, Object> stateObjects;

    public StateMachineInvocationHandler(List<Class<?>> list, Class<?> cls, Class<?>[] clsArr, Object[] objArr) {
        Object objNewInstance;
        j02 j02VarK = n02.k(StateMachineInvocationHandler.class);
        this.logger = j02VarK;
        this.stateObjects = new ConcurrentHashMap();
        j02VarK.q("Creating state machine with initial state: {}", cls);
        this.initialStateClass = cls;
        for (Class<?> cls2 : list) {
            if (clsArr != null) {
                try {
                    objNewInstance = cls2.getConstructor(clsArr).newInstance(objArr);
                } catch (NoSuchMethodException e) {
                    u04.a("State ", cls2.getName(), " has the wrong constructor", e);
                    throw null;
                } catch (Exception e2) {
                    u04.a("State ", cls2.getName(), " can't be instantiated", e2);
                    throw null;
                }
            } else {
                objNewInstance = cls2.getDeclaredConstructor(null).newInstance(null);
            }
            this.logger.q("Adding state instance: {}", objNewInstance.getClass().getName());
            this.stateObjects.put(cls2, objNewInstance);
        }
        if (!this.stateObjects.containsKey(cls)) {
            zt2.a("Initial state not in list of states: ".concat(String.valueOf(cls)));
            throw null;
        }
        this.currentState = this.stateObjects.get(cls);
        synchronized (this) {
            invokeEntryMethod(this.currentState);
        }
    }

    private Method getMethodOfCurrentState(Method method) {
        try {
            return this.currentState.getClass().getMethod(method.getName(), method.getParameterTypes());
        } catch (NoSuchMethodException unused) {
            throw new TransitionException("State '" + this.currentState.getClass().getName() + "' doesn't support signal '" + method.getName() + "'");
        }
    }

    private void invokeEntryMethod(Object obj) {
        this.logger.q("Trying to invoke entry method of state: {}", obj.getClass().getName());
        try {
            obj.getClass().getMethod(METHOD_ON_ENTRY, null).invoke(obj, null);
        } catch (NoSuchMethodException unused) {
            this.logger.q("No entry method found on state: {}", obj.getClass().getName());
        } catch (Exception e) {
            throw new TransitionException("State '" + obj.getClass().getName() + "' entry method threw exception", e);
        }
    }

    private void invokeExitMethod(Object obj) {
        this.logger.q("Trying to invoking exit method of state: {}", obj.getClass().getName());
        try {
            obj.getClass().getMethod(METHOD_ON_EXIT, null).invoke(obj, null);
        } catch (NoSuchMethodException unused) {
            this.logger.q("No exit method found on state: {}", obj.getClass().getName());
        } catch (Exception e) {
            throw new TransitionException("State '" + obj.getClass().getName() + "' exit method threw exception", e);
        }
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        Object obj2;
        synchronized (this) {
            try {
                if (StateMachine.METHOD_CURRENT_STATE.equals(method.getName()) && method.getParameterTypes().length == 0) {
                    return this.currentState;
                }
                if (StateMachine.METHOD_FORCE_STATE.equals(method.getName()) && method.getParameterTypes().length == 1 && objArr.length == 1 && (obj2 = objArr[0]) != null && (obj2 instanceof Class)) {
                    Object obj3 = this.stateObjects.get((Class) obj2);
                    if (obj3 == null) {
                        throw new TransitionException("Can't force to invalid state: ".concat(String.valueOf(objArr[0])));
                    }
                    this.logger.q("Forcing state machine into state: {}", obj3.getClass().getName());
                    invokeExitMethod(this.currentState);
                    this.currentState = obj3;
                    invokeEntryMethod(obj3);
                    return null;
                }
                Method methodOfCurrentState = getMethodOfCurrentState(method);
                this.logger.q("Invoking signal method of current state: {}", methodOfCurrentState);
                Object objInvoke = methodOfCurrentState.invoke(this.currentState, objArr);
                if (objInvoke != null && (objInvoke instanceof Class)) {
                    Class cls = (Class) objInvoke;
                    if (this.stateObjects.containsKey(cls)) {
                        this.logger.q("Executing transition to next state: {}", cls.getName());
                        invokeExitMethod(this.currentState);
                        Object obj4 = this.stateObjects.get(cls);
                        this.currentState = obj4;
                        invokeEntryMethod(obj4);
                    }
                }
                return objInvoke;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
