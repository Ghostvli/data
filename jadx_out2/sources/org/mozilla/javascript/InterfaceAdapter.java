package org.mozilla.javascript;

import defpackage.d04;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import org.mozilla.javascript.Context;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class InterfaceAdapter {
    private final Object proxyHelper;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private InterfaceAdapter(ContextFactory contextFactory, Class<?> cls) {
        this.proxyHelper = VMBridge.instance.getInterfaceProxyHelper(contextFactory, new Class[]{cls});
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object create(Context context, Class<?> cls, ScriptableObject scriptableObject) {
        if (!cls.isInterface()) {
            d04.a();
            return null;
        }
        Scriptable topCallScope = ScriptRuntime.getTopCallScope(context);
        ClassCache classCache = ClassCache.get(topCallScope);
        InterfaceAdapter interfaceAdapter = (InterfaceAdapter) classCache.getInterfaceAdapter(cls);
        ContextFactory factory = context.getFactory();
        if (interfaceAdapter == null) {
            if (scriptableObject instanceof Callable) {
                Method[] methods = cls.getMethods();
                HashSet hashSet = new HashSet();
                HashSet hashSet2 = new HashSet();
                for (Method method : methods) {
                    if (isFunctionalMethodCandidate(method)) {
                        hashSet.add(method.getName());
                        if (hashSet.size() > 1) {
                            break;
                        }
                    } else {
                        hashSet2.add(method.getName());
                    }
                }
                if (hashSet.size() != 1 && (!hashSet.isEmpty() || hashSet2.size() != 1)) {
                    if (hashSet.isEmpty() && hashSet2.isEmpty()) {
                        throw Context.reportRuntimeErrorById("msg.no.empty.interface.conversion", cls.getName());
                    }
                    throw Context.reportRuntimeErrorById("msg.no.function.interface.conversion", cls.getName());
                }
            }
            interfaceAdapter = new InterfaceAdapter(factory, cls);
            classCache.cacheInterfaceAdapter(cls, interfaceAdapter);
        }
        InterfaceAdapter interfaceAdapter2 = interfaceAdapter;
        return VMBridge.instance.newInterfaceProxy(interfaceAdapter2.proxyHelper, factory, interfaceAdapter2, scriptableObject, topCallScope);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean isFunctionalMethodCandidate(Method method) {
        if (method.getName().equals("equals") || method.getName().equals("hashCode") || method.getName().equals("toString")) {
            return false;
        }
        return Modifier.isAbstract(method.getModifiers());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object invoke(ContextFactory contextFactory, final Object obj, final Scriptable scriptable, final Object obj2, final Method method, final Object[] objArr) {
        return contextFactory.call(new ContextAction() { // from class: zk1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.ContextAction
            public final Object run(Context context) {
                return this.a.invokeImpl(context, obj, scriptable, obj2, method, objArr);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object invokeImpl(Context context, Object obj, Scriptable scriptable, Object obj2, Method method, Object[] objArr) {
        Callable callable;
        boolean z = obj instanceof Callable;
        Class<?> cls = Void.TYPE;
        if (z) {
            callable = (Callable) obj;
        } else {
            String name = method.getName();
            Object property = ScriptableObject.getProperty((Scriptable) obj, name);
            if (property == Scriptable.NOT_FOUND) {
                Context.reportWarning(ScriptRuntime.getMessageById("msg.undefined.function.interface", name));
                Class<?> returnType = method.getReturnType();
                if (returnType == cls) {
                    return null;
                }
                return Context.jsToJava(null, returnType);
            }
            if (!(property instanceof Callable)) {
                throw Context.reportRuntimeErrorById("msg.not.function.interface", name);
            }
            callable = (Callable) property;
        }
        WrapFactory wrapFactory = context.getWrapFactory();
        if (objArr == null) {
            objArr = ScriptRuntime.emptyArgs;
        } else {
            int length = objArr.length;
            for (int i = 0; i != length; i++) {
                Object obj3 = objArr[i];
                if (!(obj3 instanceof String) && !(obj3 instanceof Number) && !(obj3 instanceof Boolean)) {
                    objArr[i] = wrapFactory.wrap(context, scriptable, obj3, null);
                }
            }
        }
        Object objCall = callable.call(context, scriptable, wrapFactory.wrapAsJavaObject(context, scriptable, obj2, null), objArr);
        Class<?> returnType2 = method.getReturnType();
        if (returnType2 == cls) {
            return null;
        }
        return Context.jsToJava(objCall, returnType2);
    }
}
