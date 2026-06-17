package org.mozilla.javascript.engine;

import defpackage.jl;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import javax.script.AbstractScriptEngine;
import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptException;
import javax.script.SimpleBindings;
import org.mozilla.javascript.Callable;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.RhinoException;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class RhinoScriptEngine extends AbstractScriptEngine implements Compilable, Invocable {
    private static final boolean DEFAULT_DEBUG = true;
    private static final String DEFAULT_FILENAME = "eval";
    static final int DEFAULT_LANGUAGE_VERSION = 200;
    public static final String INTERPRETED_MODE = "org.mozilla.javascript.interpreted_mode";

    @Deprecated
    public static final String OPTIMIZATION_LEVEL = "org.mozilla.javascript.optimization_level";
    private static final CtxFactory ctxFactory = new CtxFactory();
    private final RhinoScriptEngineFactory factory;
    private ScriptableObject topLevelScope = null;
    private final Builtins builtins = new Builtins();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public RhinoScriptEngine(RhinoScriptEngineFactory rhinoScriptEngineFactory) {
        this.factory = rhinoScriptEngineFactory;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void configureContext(Context context) {
        Object obj = get("javax.script.language_version");
        if (obj != null) {
            context.setLanguageVersion(parseInteger(obj));
        }
        Object obj2 = get(OPTIMIZATION_LEVEL);
        if (obj2 != null) {
            context.setOptimizationLevel(parseInteger(obj2));
        }
        Object obj3 = get(INTERPRETED_MODE);
        if (obj3 != null) {
            context.setInterpretedMode(parseBoolean(obj3));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String getFilename() {
        Object obj = get("javax.script.filename");
        return obj instanceof String ? (String) obj : DEFAULT_FILENAME;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Scriptable initScope(Context context, ScriptContext scriptContext) {
        configureContext(context);
        if (this.topLevelScope == null) {
            ScriptableObject scriptableObjectInitStandardObjects = context.initStandardObjects();
            this.topLevelScope = scriptableObjectInitStandardObjects;
            scriptableObjectInitStandardObjects.associateValue(Builtins.BUILTIN_KEY, this.builtins);
            this.builtins.register(context, this.topLevelScope, scriptContext);
        }
        BindingsObject bindingsObject = new BindingsObject(scriptContext.getBindings(100));
        bindingsObject.setParentScope(null);
        bindingsObject.setPrototype(this.topLevelScope);
        if (scriptContext.getBindings(200) != null) {
            BindingsObject bindingsObject2 = new BindingsObject(scriptContext.getBindings(200));
            bindingsObject2.setParentScope(null);
            bindingsObject2.setPrototype(this.topLevelScope);
            bindingsObject.setPrototype(bindingsObject2);
        }
        return bindingsObject;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean methodsMissing(Scriptable scriptable, Class<?> cls) {
        for (Method method : cls.getMethods()) {
            if (method.getDeclaringClass() != Object.class && !(ScriptableObject.getProperty(scriptable, method.getName()) instanceof Callable)) {
                return DEFAULT_DEBUG;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.script.ScriptException */
    private static boolean parseBoolean(Object obj) throws ScriptException {
        if (obj instanceof String) {
            return Boolean.parseBoolean((String) obj);
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        throw new ScriptException("Value must be a string or boolean");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.script.ScriptException */
    private static int parseInteger(Object obj) throws ScriptException {
        if (obj instanceof String) {
            try {
                return Integer.parseInt((String) obj);
            } catch (NumberFormatException unused) {
                throw new ScriptException("Invalid number ".concat(String.valueOf(obj)));
            }
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        throw new ScriptException("Value must be a string or number");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.script.ScriptException */
    public CompiledScript compile(Reader reader) throws ScriptException {
        try {
            Context contextEnterContext = ctxFactory.enterContext();
            try {
                configureContext(contextEnterContext);
                RhinoCompiledScript rhinoCompiledScript = new RhinoCompiledScript(this, contextEnterContext.compileReader(reader, getFilename(), 1, null));
                contextEnterContext.close();
                return rhinoCompiledScript;
            } finally {
            }
        } catch (IOException e) {
            throw new ScriptException(e);
        } catch (RhinoException e2) {
            throw new ScriptException(e2.getMessage(), e2.sourceName(), e2.lineNumber(), e2.columnNumber());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Bindings createBindings() {
        return new SimpleBindings();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.script.ScriptException */
    public Object eval(Reader reader, ScriptContext scriptContext) throws ScriptException {
        try {
            Context contextEnterContext = ctxFactory.enterContext();
            try {
                Object objJsToJava = Context.jsToJava(contextEnterContext.evaluateReader(initScope(contextEnterContext, scriptContext), reader, getFilename(), 0, null), Object.class);
                contextEnterContext.close();
                return objJsToJava;
            } catch (Throwable th) {
                if (contextEnterContext == null) {
                    throw th;
                }
                try {
                    contextEnterContext.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        } catch (IOException e) {
            throw new ScriptException(e);
        } catch (RhinoException e2) {
            throw new ScriptException(e2.getMessage(), e2.sourceName(), e2.lineNumber(), e2.columnNumber());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ScriptEngineFactory getFactory() {
        return this.factory;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public <T> T getInterface(Object obj, Class<T> cls) {
        if (cls == null || !cls.isInterface()) {
            jl.a("Not an interface");
            return null;
        }
        try {
            Context contextEnterContext = ctxFactory.enterContext();
            try {
                if (methodsMissing(Context.toObject(obj, initScope(contextEnterContext, this.context)), cls)) {
                    if (contextEnterContext != null) {
                        contextEnterContext.close();
                    }
                    return null;
                }
                if (contextEnterContext != null) {
                    contextEnterContext.close();
                }
                return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, new RhinoInvocationHandler(this, obj));
            } finally {
            }
        } catch (ScriptException unused) {
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object invokeFunction(String str, Object... objArr) {
        return invokeMethod(null, str, objArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object invokeMethod(Object obj, String str, Object... objArr) {
        return invokeMethodRaw(obj, str, Object.class, objArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.script.ScriptException */
    public Object invokeMethodRaw(Object obj, String str, Class<?> cls, Object... objArr) throws ScriptException {
        Object objJsToJava;
        try {
            Context contextEnterContext = ctxFactory.enterContext();
            try {
                Scriptable scriptableInitScope = initScope(contextEnterContext, this.context);
                Scriptable object = obj == null ? scriptableInitScope : Context.toObject(obj, scriptableInitScope);
                Object property = ScriptableObject.getProperty(object, str);
                if (property == Scriptable.NOT_FOUND) {
                    throw new NoSuchMethodException(str);
                }
                if (!(property instanceof Callable)) {
                    throw new ScriptException("\"" + str + "\" is not a function");
                }
                Callable callable = (Callable) property;
                if (objArr != null) {
                    for (int i = 0; i < objArr.length; i++) {
                        objArr[i] = Context.javaToJS(objArr[i], scriptableInitScope);
                    }
                }
                Object objCall = callable.call(contextEnterContext, scriptableInitScope, object, objArr);
                if (cls != Void.TYPE) {
                    objJsToJava = Context.jsToJava(objCall, cls);
                    if (contextEnterContext != null) {
                    }
                    return objJsToJava;
                }
                objJsToJava = null;
                if (contextEnterContext == null) {
                    return null;
                }
                contextEnterContext.close();
                return objJsToJava;
            } finally {
            }
        } catch (RhinoException e) {
            throw new ScriptException(e.getMessage(), e.sourceName(), e.lineNumber(), e.columnNumber());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class CtxFactory extends ContextFactory {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.mozilla.javascript.ContextFactory
        public boolean hasFeature(Context context, int i) {
            return i == 18 ? RhinoScriptEngine.DEFAULT_DEBUG : super.hasFeature(context, i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.mozilla.javascript.ContextFactory
        public void onContextCreated(Context context) {
            context.setLanguageVersion(200);
            context.setGeneratingDebug(RhinoScriptEngine.DEFAULT_DEBUG);
        }

        private CtxFactory() {
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.script.ScriptException */
    public CompiledScript compile(String str) throws ScriptException {
        try {
            Context contextEnterContext = ctxFactory.enterContext();
            try {
                configureContext(contextEnterContext);
                RhinoCompiledScript rhinoCompiledScript = new RhinoCompiledScript(this, contextEnterContext.compileString(str, getFilename(), 1, null));
                contextEnterContext.close();
                return rhinoCompiledScript;
            } finally {
            }
        } catch (RhinoException e) {
            throw new ScriptException(e.getMessage(), e.sourceName(), e.lineNumber(), e.columnNumber());
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.script.ScriptException */
    public Object eval(String str, ScriptContext scriptContext) throws ScriptException {
        try {
            Context contextEnterContext = ctxFactory.enterContext();
            try {
                Object objJsToJava = Context.jsToJava(contextEnterContext.evaluateString(initScope(contextEnterContext, scriptContext), str, getFilename(), 0, null), Object.class);
                contextEnterContext.close();
                return objJsToJava;
            } finally {
            }
        } catch (RhinoException e) {
            throw new ScriptException(e.getMessage(), e.sourceName(), e.lineNumber(), e.columnNumber());
        }
    }

    public <T> T getInterface(Class<T> cls) {
        if (cls != null && cls.isInterface()) {
            try {
                Context contextEnterContext = ctxFactory.enterContext();
                try {
                    if (methodsMissing(initScope(contextEnterContext, this.context), cls)) {
                        if (contextEnterContext != null) {
                            contextEnterContext.close();
                        }
                        return null;
                    }
                    if (contextEnterContext != null) {
                        contextEnterContext.close();
                    }
                    return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, new RhinoInvocationHandler(this, null));
                } finally {
                }
            } catch (ScriptException unused) {
                return null;
            }
        }
        jl.a("Not an interface");
        return null;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.script.ScriptException */
    public Object eval(Script script, ScriptContext scriptContext) throws ScriptException {
        try {
            Context contextEnterContext = ctxFactory.enterContext();
            try {
                Object objJsToJava = Context.jsToJava(script.exec(contextEnterContext, initScope(contextEnterContext, scriptContext)), Object.class);
                if (contextEnterContext != null) {
                    contextEnterContext.close();
                }
                return objJsToJava;
            } finally {
            }
        } catch (RhinoException e) {
            throw new ScriptException(e.getMessage(), e.sourceName(), e.lineNumber(), e.columnNumber());
        }
    }
}
