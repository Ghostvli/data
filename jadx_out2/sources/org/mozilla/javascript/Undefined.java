package org.mozilla.javascript;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Undefined implements Serializable {
    public static final Scriptable SCRIPTABLE_UNDEFINED;
    public static final Object instance;
    private static final int instanceHash;
    private static final long serialVersionUID = 9195680630202616767L;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        Undefined undefined = new Undefined();
        instance = undefined;
        instanceHash = System.identityHashCode(undefined);
        SCRIPTABLE_UNDEFINED = new Scriptable() { // from class: org.mozilla.javascript.Undefined.1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.Scriptable
            public void delete(int i) {
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public boolean equals(Object obj) {
                return Undefined.isUndefined(obj) || obj == this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.Scriptable
            public Object get(String str, Scriptable scriptable) {
                return Scriptable.NOT_FOUND;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.Scriptable
            public String getClassName() {
                return "undefined";
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.Scriptable
            public Object getDefaultValue(Class<?> cls) {
                if (cls == null || cls == ScriptRuntime.StringClass) {
                    return toString();
                }
                return null;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.Scriptable
            public Object[] getIds() {
                return ScriptRuntime.emptyArgs;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.Scriptable
            public Scriptable getParentScope() {
                return null;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.Scriptable
            public Scriptable getPrototype() {
                return null;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.Scriptable
            public boolean has(int i, Scriptable scriptable) {
                return false;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.Scriptable
            public boolean hasInstance(Scriptable scriptable) {
                return false;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public int hashCode() {
                return Undefined.instanceHash;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.Scriptable
            public void put(int i, Scriptable scriptable, Object obj) {
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.Scriptable
            public void setParentScope(Scriptable scriptable) {
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.Scriptable
            public void setPrototype(Scriptable scriptable) {
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public String toString() {
                return "undefined";
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 2 */
            @Override // org.mozilla.javascript.Scriptable
            public void delete(String str) {
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 2 */
            @Override // org.mozilla.javascript.Scriptable
            public void put(String str, Scriptable scriptable, Object obj) {
            }

            @Override // org.mozilla.javascript.Scriptable
            public boolean has(String str, Scriptable scriptable) {
                return false;
            }

            @Override // org.mozilla.javascript.Scriptable
            public Object get(int i, Scriptable scriptable) {
                return Scriptable.NOT_FOUND;
            }
        };
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Undefined() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean isUndefined(Object obj) {
        return instance == obj || SCRIPTABLE_UNDEFINED == obj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        return isUndefined(obj) || obj == this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return instanceHash;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object readResolve() {
        return instance;
    }
}
