package org.mozilla.javascript.regexp;

import org.mozilla.javascript.Callable;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ES6Iterator;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Undefined;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class NativeRegExpStringIterator extends ES6Iterator {
    private static final String ITERATOR_TAG = "RegExpStringIterator";
    private static final long serialVersionUID = 1;
    private boolean fullUnicode;
    private boolean global;
    private Object next;
    private boolean nextDone;
    private Scriptable regexp;
    private String string;

    public NativeRegExpStringIterator(Scriptable scriptable, Scriptable scriptable2, String str, boolean z, boolean z2) {
        super(scriptable, ITERATOR_TAG);
        this.next = null;
        this.regexp = scriptable2;
        this.string = str;
        this.global = z;
        this.fullUnicode = z2;
        this.nextDone = false;
    }

    public static void init(ScriptableObject scriptableObject, boolean z) {
        ES6Iterator.init(scriptableObject, z, new NativeRegExpStringIterator(), ITERATOR_TAG);
    }

    private Object regExpExec(Context context, Scriptable scriptable) {
        Object objectProp = ScriptRuntime.getObjectProp(this.regexp, "exec", context);
        boolean z = objectProp instanceof Callable;
        Scriptable scriptable2 = this.regexp;
        return z ? ((Callable) objectProp).call(context, scriptable, scriptable2, new Object[]{this.string}) : NativeRegExp.js_exec(context, scriptable, scriptable2, new Object[]{this.string});
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "RegExp String Iterator";
    }

    @Override // org.mozilla.javascript.ES6Iterator
    public String getTag() {
        return ITERATOR_TAG;
    }

    @Override // org.mozilla.javascript.ES6Iterator
    public boolean isDone(Context context, Scriptable scriptable) {
        if (this.nextDone) {
            return true;
        }
        Object objRegExpExec = regExpExec(context, scriptable);
        this.next = objRegExpExec;
        if (objRegExpExec == null) {
            this.next = Undefined.instance;
            this.nextDone = true;
            return true;
        }
        if (!this.global) {
            this.nextDone = true;
            return false;
        }
        if (ScriptRuntime.toString(ScriptRuntime.getObjectIndex(objRegExpExec, 0.0d, context, scriptable)).isEmpty()) {
            ScriptRuntime.setObjectProp(this.regexp, "lastIndex", (Object) Long.valueOf(ScriptRuntime.advanceStringIndex(this.string, ScriptRuntime.toLength(ScriptRuntime.getObjectProp(this.regexp, "lastIndex", context)), this.fullUnicode)), context);
        }
        return false;
    }

    @Override // org.mozilla.javascript.ES6Iterator
    public Object nextValue(Context context, Scriptable scriptable) {
        return this.next;
    }

    private NativeRegExpStringIterator() {
        this.next = null;
    }
}
