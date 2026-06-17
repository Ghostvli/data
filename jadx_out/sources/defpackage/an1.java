package defpackage;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.ScriptableObject;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class an1 {
    public static void a(String str) {
        Context contextEnter = Context.enter();
        try {
            contextEnter.setInterpretedMode(true);
            contextEnter.compileString(str, null, 1, null);
            contextEnter.close();
        } catch (Throwable th) {
            if (contextEnter != null) {
                try {
                    contextEnter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static String b(String str, String str2, String... strArr) {
        Context contextEnter = Context.enter();
        try {
            contextEnter.setInterpretedMode(true);
            ScriptableObject scriptableObjectInitSafeStandardObjects = contextEnter.initSafeStandardObjects();
            contextEnter.evaluateString(scriptableObjectInitSafeStandardObjects, str, str2, 1, null);
            String string = ((Function) scriptableObjectInitSafeStandardObjects.get(str2, scriptableObjectInitSafeStandardObjects)).call(contextEnter, scriptableObjectInitSafeStandardObjects, scriptableObjectInitSafeStandardObjects, strArr).toString();
            contextEnter.close();
            return string;
        } catch (Throwable th) {
            if (contextEnter == null) {
                throw th;
            }
            try {
                contextEnter.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }
}
