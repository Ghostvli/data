package org.mozilla.javascript.xml;

import javax.xml.XMLConstants;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdScriptableObject;
import org.mozilla.javascript.NativeWith;
import org.mozilla.javascript.Ref;
import org.mozilla.javascript.Scriptable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class XMLObject extends IdScriptableObject {
    private static final long serialVersionUID = 8455156490438576500L;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public XMLObject() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object addValues(Context context, boolean z, Object obj) {
        return Scriptable.NOT_FOUND;
    }

    public abstract boolean delete(Context context, Object obj);

    public abstract NativeWith enterDotQuery(Scriptable scriptable);

    public abstract NativeWith enterWith(Scriptable scriptable);

    public abstract Object get(Context context, Object obj);

    public abstract Scriptable getExtraMethodSource(Context context);

    public abstract Object getFunctionProperty(Context context, int i);

    public abstract Object getFunctionProperty(Context context, String str);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.ScriptableObject
    public String getTypeOf() {
        return avoidObjectDetection() ? "undefined" : XMLConstants.XML_NS_PREFIX;
    }

    public abstract boolean has(Context context, Object obj);

    public abstract Ref memberRef(Context context, Object obj, int i);

    public abstract Ref memberRef(Context context, Object obj, Object obj2, int i);

    public abstract void put(Context context, Object obj, Object obj2);

    public XMLObject(Scriptable scriptable, Scriptable scriptable2) {
        super(scriptable, scriptable2);
    }
}
