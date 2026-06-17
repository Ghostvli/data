package org.mozilla.javascript;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class JavaScriptException extends RhinoException {
    private static final long serialVersionUID = -7666130513694669293L;
    private String details;
    private Object value;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public JavaScriptException(Object obj, String str, int i) {
        recordErrorOrigin(str, i, null, 0);
        this.value = obj;
        if (obj instanceof NativeError) {
            NativeError nativeError = (NativeError) obj;
            Object obj2 = nativeError.get("javaException", nativeError);
            if (Context.getContext().hasFeature(10)) {
                if (!nativeError.has("fileName", nativeError)) {
                    nativeError.put("fileName", nativeError, str);
                }
                if (!nativeError.has("lineNumber", nativeError)) {
                    nativeError.put("lineNumber", nativeError, Integer.valueOf(i));
                }
                nativeError.setStackProvider(this);
            }
            obj = obj2;
        }
        obj = obj instanceof Wrapper ? ((Wrapper) obj).unwrap() : obj;
        if (obj instanceof Throwable) {
            initCause((Throwable) obj);
        }
        this.details = getDetails();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.RhinoException
    public String details() {
        return this.details;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getDetails() {
        Object obj = this.value;
        if (obj == null) {
            return "null";
        }
        if (obj instanceof NativeError) {
            return obj.toString();
        }
        try {
            return ScriptRuntime.toString(obj);
        } catch (RuntimeException unused) {
            Object obj2 = this.value;
            return obj2 instanceof Scriptable ? ScriptRuntime.defaultObjectToString((Scriptable) obj2) : obj2.toString();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Deprecated
    public int getLineNumber() {
        return lineNumber();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Deprecated
    public String getSourceName() {
        return sourceName();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object getValue() {
        return this.value;
    }

    @Deprecated
    public JavaScriptException(Object obj) {
        this(obj, "", 0);
    }
}
