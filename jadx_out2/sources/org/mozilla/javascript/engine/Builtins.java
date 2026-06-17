package org.mozilla.javascript.engine;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import javax.script.ScriptContext;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Builtins {
    static final Object BUILTIN_KEY = new Object();
    private Writer stdout;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Builtins getSelf(Scriptable scriptable) {
        return (Builtins) ScriptableObject.getTopScopeValue(scriptable, BUILTIN_KEY);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void print(Context context, Scriptable scriptable, Object[] objArr, Function function) throws IOException {
        Builtins self = getSelf(scriptable);
        for (Object obj : objArr) {
            self.stdout.write(ScriptRuntime.toString(obj));
        }
        self.stdout.write(10);
        self.stdout.flush();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void register(Context context, ScriptableObject scriptableObject, ScriptContext scriptContext) {
        if (scriptContext.getWriter() == null) {
            this.stdout = new OutputStreamWriter(System.out, StandardCharsets.UTF_8);
        } else {
            this.stdout = scriptContext.getWriter();
        }
        scriptableObject.defineFunctionProperties(new String[]{"print"}, Builtins.class, 6);
    }
}
