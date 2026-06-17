package org.mozilla.javascript;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.NativeJavaMap;
import org.mozilla.javascript.Scriptable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NativeJavaMap extends NativeJavaObject {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = -3786257752907047381L;
    private static Callable symbol_iterator = new Callable() { // from class: az2
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.mozilla.javascript.Callable
        public final Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
            return NativeJavaMap.b(context, scriptable, scriptable2, objArr);
        }
    };
    private Map<Object, Object> map;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public NativeJavaMap(Scriptable scriptable, Object obj) {
        super(scriptable, obj, obj.getClass());
        this.map = (Map) obj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ Object b(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (scriptable2 instanceof NativeJavaMap) {
            return new NativeJavaMapIterator(scriptable, ((NativeJavaMap) scriptable2).map);
        }
        throw ScriptRuntime.typeErrorById("msg.incompat.call", SymbolKey.ITERATOR);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void init(ScriptableObject scriptableObject, boolean z) {
        NativeJavaMapIterator.init(scriptableObject, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.NativeJavaObject
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        Context currentContext = Context.getCurrentContext();
        if (currentContext == null || !currentContext.hasFeature(21) || !this.map.containsKey(Integer.valueOf(i))) {
            return super.get(i, scriptable);
        }
        Object obj = this.map.get(Integer.valueOf(i));
        return currentContext.getWrapFactory().wrap(currentContext, this, obj, obj == null ? null : obj.getClass());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "JavaMap";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public Object[] getIds() {
        Context currentContext = Context.getCurrentContext();
        if (currentContext == null || !currentContext.hasFeature(21)) {
            return super.getIds();
        }
        ArrayList arrayList = new ArrayList(this.map.size());
        for (Object obj : this.map.keySet()) {
            if (obj instanceof Integer) {
                arrayList.add(obj);
            } else {
                arrayList.add(ScriptRuntime.toString(obj));
            }
        }
        return arrayList.toArray();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        Context currentContext = Context.getCurrentContext();
        if (currentContext != null && currentContext.hasFeature(21) && this.map.containsKey(Integer.valueOf(i))) {
            return true;
        }
        return super.has(i, scriptable);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.NativeJavaObject
    public int hashCode() {
        return super.hashCode();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        Context context = Context.getContext();
        if (context == null || !context.hasFeature(21)) {
            super.put(i, scriptable, obj);
        } else {
            this.map.put(Integer.valueOf(i), Context.jsToJava(obj, Object.class));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class NativeJavaMapIterator extends ES6Iterator {
        private static final String ITERATOR_TAG = "JavaMapIterator";
        private static final long serialVersionUID = 1;
        private Iterator<Map.Entry<Object, Object>> iterator;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public NativeJavaMapIterator(Scriptable scriptable, Map<Object, Object> map) {
            super(scriptable, ITERATOR_TAG);
            this.iterator = map.entrySet().iterator();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void init(ScriptableObject scriptableObject, boolean z) {
            ES6Iterator.init(scriptableObject, z, new NativeJavaMapIterator(), ITERATOR_TAG);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
        public String getClassName() {
            return "Java Map Iterator";
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.mozilla.javascript.ES6Iterator
        public String getTag() {
            return ITERATOR_TAG;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.mozilla.javascript.ES6Iterator
        public boolean isDone(Context context, Scriptable scriptable) {
            return !this.iterator.hasNext();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.mozilla.javascript.ES6Iterator
        public Object nextValue(Context context, Scriptable scriptable) {
            if (!this.iterator.hasNext()) {
                Object obj = Undefined.instance;
                return context.newArray(scriptable, new Object[]{obj, obj});
            }
            Map.Entry<Object, Object> next = this.iterator.next();
            Object key = next.getKey();
            Object value = next.getValue();
            WrapFactory wrapFactory = context.getWrapFactory();
            return context.newArray(scriptable, new Object[]{wrapFactory.wrap(context, this, key, key == null ? null : key.getClass()), wrapFactory.wrap(context, this, value, value != null ? value.getClass() : null)});
        }

        private NativeJavaMapIterator() {
        }
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public boolean has(String str, Scriptable scriptable) {
        Context currentContext = Context.getCurrentContext();
        if (currentContext != null && currentContext.hasFeature(21) && this.map.containsKey(str)) {
            return true;
        }
        return super.has(str, scriptable);
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        Context currentContext = Context.getCurrentContext();
        if (currentContext != null && currentContext.hasFeature(21)) {
            this.map.put(str, Context.jsToJava(obj, Object.class));
        } else {
            super.put(str, scriptable, obj);
        }
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.SymbolScriptable
    public boolean has(Symbol symbol, Scriptable scriptable) {
        return SymbolKey.ITERATOR.equals(symbol);
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public Object get(String str, Scriptable scriptable) {
        Context currentContext = Context.getCurrentContext();
        if (currentContext != null && currentContext.hasFeature(21) && this.map.containsKey(str)) {
            Object obj = this.map.get(str);
            return currentContext.getWrapFactory().wrap(currentContext, this, obj, obj == null ? null : obj.getClass());
        }
        return super.get(str, scriptable);
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.SymbolScriptable
    public Object get(Symbol symbol, Scriptable scriptable) {
        if (SymbolKey.ITERATOR.equals(symbol)) {
            return symbol_iterator;
        }
        return super.get(symbol, scriptable);
    }
}
