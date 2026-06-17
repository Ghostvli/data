package org.mozilla.javascript;

import defpackage.e04;
import java.lang.reflect.AccessibleObject;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class VMBridge {
    static final VMBridge instance = makeInstance();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static VMBridge makeInstance() {
        VMBridge vMBridge;
        String[] strArr = {"org.mozilla.javascript.VMBridge_custom", "org.mozilla.javascript.jdk18.VMBridge_jdk18"};
        for (int i = 0; i != 2; i++) {
            Class<?> clsClassOrNull = Kit.classOrNull(strArr[i]);
            if (clsClassOrNull != null && (vMBridge = (VMBridge) Kit.newInstanceOrNull(clsClassOrNull)) != null) {
                return vMBridge;
            }
        }
        e04.a("Failed to create VMBridge instance");
        return null;
    }

    public abstract Context getContext(Object obj);

    public abstract Object getInterfaceProxyHelper(ContextFactory contextFactory, Class<?>[] clsArr);

    public abstract Object getThreadContextHelper();

    public abstract Object newInterfaceProxy(Object obj, ContextFactory contextFactory, InterfaceAdapter interfaceAdapter, Object obj2, Scriptable scriptable);

    public abstract void setContext(Object obj, Context context);

    public abstract boolean tryToMakeAccessible(AccessibleObject accessibleObject);
}
