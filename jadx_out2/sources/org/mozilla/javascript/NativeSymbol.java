package org.mozilla.javascript;

import java.util.HashMap;
import java.util.Map;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.NativeSymbol;
import org.mozilla.javascript.Scriptable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NativeSymbol extends ScriptableObject implements Symbol {
    public static final String CLASS_NAME = "Symbol";
    private static final Object GLOBAL_TABLE_KEY = new Object();
    public static final String TYPE_NAME = "symbol";
    private static final long serialVersionUID = -589539749749830003L;
    private final SymbolKey key;
    private final NativeSymbol symbolData;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public NativeSymbol(NativeSymbol nativeSymbol) {
        this.key = nativeSymbol.key;
        this.symbolData = nativeSymbol.symbolData;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static NativeSymbol constructSymbol(Context context, Scriptable scriptable, LambdaConstructor lambdaConstructor, SymbolKey symbolKey) {
        return (NativeSymbol) lambdaConstructor.call(context, scriptable, null, new Object[]{Undefined.instance, symbolKey});
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void createStandardSymbol(Context context, Scriptable scriptable, LambdaConstructor lambdaConstructor, String str, SymbolKey symbolKey) {
        lambdaConstructor.defineProperty(str, constructSymbol(context, scriptable, lambdaConstructor, symbolKey), 7);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Map<String, NativeSymbol> getGlobalMap(Scriptable scriptable) {
        ScriptableObject scriptableObject = (ScriptableObject) ScriptableObject.getTopLevelScope(scriptable);
        Object obj = GLOBAL_TABLE_KEY;
        Map<String, NativeSymbol> map = (Map) scriptableObject.getAssociatedValue(obj);
        if (map != null) {
            return map;
        }
        HashMap map2 = new HashMap();
        scriptableObject.associateValue(obj, map2);
        return map2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static NativeSymbol getSelf(Scriptable scriptable) {
        return (NativeSymbol) LambdaConstructor.convertThisObject(scriptable, NativeSymbol.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void init(Context context, Scriptable scriptable, boolean z) {
        final LambdaConstructor lambdaConstructor = new LambdaConstructor(scriptable, CLASS_NAME, 0, 1, new Constructable() { // from class: sz2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.Constructable
            public final Scriptable construct(Context context2, Scriptable scriptable2, Object[] objArr) {
                return NativeSymbol.js_constructor(context2, scriptable2, objArr);
            }
        });
        lambdaConstructor.setPrototypePropertyAttributes(7);
        lambdaConstructor.defineConstructorMethod(scriptable, "for", 1, new Callable() { // from class: tz2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeSymbol.js_for(context2, scriptable2, objArr, lambdaConstructor);
            }
        }, 2, 3);
        lambdaConstructor.defineConstructorMethod(scriptable, "keyFor", 1, new Callable() { // from class: uz2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeSymbol.js_keyFor(context2, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, "toString", 0, new Callable() { // from class: vz2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeSymbol.js_toString(context2, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        lambdaConstructor.definePrototypeMethod(scriptable, "valueOf", 0, new Callable() { // from class: wz2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeSymbol.js_valueOf(context2, scriptable2, scriptable3, objArr);
            }
        }, 2, 3);
        SymbolKey symbolKey = SymbolKey.TO_PRIMITIVE;
        lambdaConstructor.definePrototypeMethod(scriptable, symbolKey, 1, new Callable() { // from class: wz2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.Callable
            public final Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                return NativeSymbol.js_valueOf(context2, scriptable2, scriptable3, objArr);
            }
        }, 3, 3);
        SymbolKey symbolKey2 = SymbolKey.TO_STRING_TAG;
        lambdaConstructor.definePrototypeProperty(symbolKey2, CLASS_NAME, 3);
        lambdaConstructor.definePrototypeProperty(context, "description", new java.util.function.Function() { // from class: xz2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return NativeSymbol.js_description((Scriptable) obj);
            }
        }, 3);
        ScriptableObject.defineProperty(scriptable, CLASS_NAME, lambdaConstructor, 2);
        createStandardSymbol(context, scriptable, lambdaConstructor, "iterator", SymbolKey.ITERATOR);
        createStandardSymbol(context, scriptable, lambdaConstructor, "species", SymbolKey.SPECIES);
        createStandardSymbol(context, scriptable, lambdaConstructor, "toStringTag", symbolKey2);
        createStandardSymbol(context, scriptable, lambdaConstructor, "hasInstance", SymbolKey.HAS_INSTANCE);
        createStandardSymbol(context, scriptable, lambdaConstructor, "isConcatSpreadable", SymbolKey.IS_CONCAT_SPREADABLE);
        createStandardSymbol(context, scriptable, lambdaConstructor, "isRegExp", SymbolKey.IS_REGEXP);
        createStandardSymbol(context, scriptable, lambdaConstructor, "toPrimitive", symbolKey);
        createStandardSymbol(context, scriptable, lambdaConstructor, "match", SymbolKey.MATCH);
        createStandardSymbol(context, scriptable, lambdaConstructor, "matchAll", SymbolKey.MATCH_ALL);
        createStandardSymbol(context, scriptable, lambdaConstructor, "replace", SymbolKey.REPLACE);
        createStandardSymbol(context, scriptable, lambdaConstructor, "search", SymbolKey.SEARCH);
        createStandardSymbol(context, scriptable, lambdaConstructor, "split", SymbolKey.SPLIT);
        createStandardSymbol(context, scriptable, lambdaConstructor, "unscopables", SymbolKey.UNSCOPABLES);
        if (z) {
            lambdaConstructor.sealObject();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean isStrictMode() {
        Context currentContext = Context.getCurrentContext();
        return currentContext != null && currentContext.isStrictMode();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public static NativeSymbol js_constructor(Context context, Scriptable scriptable, Object[] objArr) {
        return objArr.length > 1 ? new NativeSymbol((SymbolKey) objArr[1]) : new NativeSymbol(new SymbolKey((objArr.length <= 0 || Undefined.isUndefined(objArr[0])) ? null : ScriptRuntime.toString(objArr[0])));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public static Object js_description(Scriptable scriptable) {
        return getSelf(scriptable).getKey().getDescription();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public static Object js_for(final Context context, final Scriptable scriptable, Object[] objArr, final LambdaConstructor lambdaConstructor) {
        final String string = objArr.length > 0 ? ScriptRuntime.toString(objArr[0]) : ScriptRuntime.toString(Undefined.instance);
        return getGlobalMap(scriptable).computeIfAbsent(string, new java.util.function.Function() { // from class: yz2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return NativeSymbol.constructSymbol(context, scriptable, lambdaConstructor, string);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public static Object js_keyFor(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
        if (!(obj instanceof NativeSymbol)) {
            throw ScriptRuntime.throwCustomError(context, scriptable, "TypeError", "Not a Symbol");
        }
        NativeSymbol nativeSymbol = (NativeSymbol) obj;
        for (Map.Entry<String, NativeSymbol> entry : getGlobalMap(scriptable).entrySet()) {
            if (entry.getValue().key == nativeSymbol.key) {
                return entry.getKey();
            }
        }
        return Undefined.instance;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public static String js_toString(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return getSelf(scriptable2).toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public static Object js_valueOf(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return getSelf(scriptable2).symbolData;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        return this.key.equals(obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return CLASS_NAME;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SymbolKey getKey() {
        return this.key;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.ScriptableObject
    public String getTypeOf() {
        return isSymbol() ? TYPE_NAME : super.getTypeOf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return this.key.hashCode();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isSymbol() {
        return this.symbolData == this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        if (!isSymbol()) {
            super.put(str, scriptable, obj);
        } else if (isStrictMode()) {
            throw ScriptRuntime.typeErrorById("msg.no.assign.symbol.strict", new Object[0]);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return this.key.toString();
    }

    public NativeSymbol(SymbolKey symbolKey) {
        this.key = symbolKey;
        this.symbolData = this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static NativeSymbol constructSymbol(Context context, Scriptable scriptable, LambdaConstructor lambdaConstructor, String str) {
        return (NativeSymbol) lambdaConstructor.call(context, scriptable, null, new Object[]{str});
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        if (!isSymbol()) {
            super.put(i, scriptable, obj);
        } else if (isStrictMode()) {
            throw ScriptRuntime.typeErrorById("msg.no.assign.symbol.strict", new Object[0]);
        }
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.SymbolScriptable
    public void put(Symbol symbol, Scriptable scriptable, Object obj) {
        if (!isSymbol()) {
            super.put(symbol, scriptable, obj);
        } else if (isStrictMode()) {
            throw ScriptRuntime.typeErrorById("msg.no.assign.symbol.strict", new Object[0]);
        }
    }
}
