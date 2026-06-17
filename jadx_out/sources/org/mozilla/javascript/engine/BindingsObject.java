package org.mozilla.javascript.engine;

import defpackage.jl;
import javax.script.Bindings;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class BindingsObject extends ScriptableObject {
    private final Bindings bindings;

    public BindingsObject(Bindings bindings) {
        if (bindings != null) {
            this.bindings = bindings;
        } else {
            jl.a("Bindings must not be null");
            throw null;
        }
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void delete(String str) {
        this.bindings.remove(str);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object get(String str, Scriptable scriptable) {
        return !this.bindings.containsKey(str) ? Scriptable.NOT_FOUND : Context.jsToJava(this.bindings.get(str), Object.class);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "BindingsObject";
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object[] getIds() {
        return this.bindings.keySet().toArray();
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public boolean has(String str, Scriptable scriptable) {
        return this.bindings.containsKey(str);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        this.bindings.put(str, Context.javaToJS(obj, scriptable));
    }
}
