package com.whl.quickjs.wrapper;

import com.whl.quickjs.wrapper.QuickJSObject;
import defpackage.om1;
import defpackage.qj3;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class QuickJSObject implements JSObject {
    private final QuickJSContext context;
    private final long pointer;
    private int refCount;
    private Throwable stackTrace;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public QuickJSObject(QuickJSContext quickJSContext, long j) {
        this.context = quickJSContext;
        this.pointer = j;
        this.refCount++;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ Object a(Method method, Object obj, Object[] objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void setPropertyObject(String str, Object obj) {
        checkRefCountIsZero();
        this.context.setProperty(this, str, obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void checkRefCountIsZero() {
        if (isRefCountZero()) {
            throw new QuickJSException("The call threw an exception, the reference count of the current object has already reached zero.");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void convertToMap(Object obj, Object obj2, HashMap<Long, Object> map, MapFilter mapFilter, Object obj3, MapCreator mapCreator) {
        QuickJSObject quickJSObject;
        String str;
        Object property;
        HashMap<Long, Object> map2 = map;
        MapFilter mapFilter2 = mapFilter;
        JSObject jSObject = (JSObject) obj;
        map2.put(Long.valueOf(jSObject.getPointer()), obj2);
        boolean z = obj instanceof JSArray;
        JSArray names = z ? (JSArray) obj : jSObject.getNames();
        int length = names.length();
        int i = 0;
        while (i < length) {
            if (z) {
                str = null;
                property = names.get(i);
                quickJSObject = this;
            } else {
                String str2 = (String) names.get(i);
                quickJSObject = this;
                if (mapFilter2 != null && mapFilter2.shouldSkipKey(str2, quickJSObject.pointer, obj3)) {
                    i++;
                    map2 = map;
                    mapFilter2 = mapFilter;
                }
                str = str2;
                property = jSObject.getProperty(str2);
            }
            boolean z2 = property instanceof JSObject;
            if (z2) {
                long pointer = ((JSObject) property).getPointer();
                if (map2.containsKey(Long.valueOf(pointer))) {
                    Object obj4 = map2.get(Long.valueOf(pointer));
                    if (obj2 instanceof Map) {
                        ((Map) obj2).put(str, obj4);
                    } else if (obj2 instanceof ArrayList) {
                        ((ArrayList) obj2).add(obj4);
                    }
                } else if (property instanceof JSFunction) {
                    ((JSFunction) property).release();
                } else if (property instanceof JSArray) {
                    JSArray jSArray = (JSArray) property;
                    ArrayList arrayList = new ArrayList(jSArray.length());
                    quickJSObject.convertToMap(property, arrayList, map2, mapFilter2, obj3, mapCreator);
                    if (obj2 instanceof Map) {
                        ((Map) obj2).put(str, arrayList);
                    } else if (obj2 instanceof ArrayList) {
                        ((ArrayList) obj2).add(arrayList);
                    }
                    jSArray.release();
                } else if (z2) {
                    Map<String, Object> map3 = mapCreator.get();
                    convertToMap(property, map3, map, mapFilter, obj3, mapCreator);
                    if (obj2 instanceof Map) {
                        ((Map) obj2).put(str, map3);
                    } else if (obj2 instanceof ArrayList) {
                        ((ArrayList) obj2).add(map3);
                    }
                    ((JSObject) property).release();
                } else if (obj2 instanceof Map) {
                    ((Map) obj2).put(str, property);
                } else if (obj2 instanceof ArrayList) {
                    ((ArrayList) obj2).add(property);
                }
            }
            i++;
            map2 = map;
            mapFilter2 = mapFilter;
        }
        if (z) {
            return;
        }
        names.release();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSObject
    public void decrementRefCount() {
        checkRefCountIsZero();
        this.refCount--;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSObject
    public Boolean getBoolean(String str) {
        Object property = getProperty(str);
        if (property instanceof Boolean) {
            return (Boolean) property;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSObject
    public Boolean getBooleanProperty(String str) {
        return getBoolean(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSObject
    public byte[] getBytes(String str) {
        Object property = getProperty(str);
        if (property instanceof byte[]) {
            return (byte[]) property;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSObject
    public QuickJSContext getContext() {
        return this.context;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSObject
    public Double getDouble(String str) {
        Object property = getProperty(str);
        if (property instanceof Double) {
            return (Double) property;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSObject
    public Double getDoubleProperty(String str) {
        return getDouble(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSObject
    public Integer getIntProperty(String str) {
        return getInteger(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSObject
    public Integer getInteger(String str) {
        Object property = getProperty(str);
        if (property instanceof Integer) {
            return (Integer) property;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSObject
    public JSArray getJSArray(String str) {
        Object property = getProperty(str);
        if (property instanceof JSArray) {
            return (JSArray) property;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSObject
    public JSArray getJSArrayProperty(String str) {
        return getJSArray(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSObject
    public JSFunction getJSFunction(String str) {
        Object property = getProperty(str);
        if (property instanceof JSFunction) {
            return (JSFunction) property;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSObject
    public JSFunction getJSFunctionProperty(String str) {
        return getJSFunction(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSObject
    public JSObject getJSObject(String str) {
        Object property = getProperty(str);
        if (property instanceof JSObject) {
            return (JSObject) property;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSObject
    public JSObject getJSObjectProperty(String str) {
        return getJSObject(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSObject
    public Long getLong(String str) {
        Object property = getProperty(str);
        if (property instanceof Long) {
            return (Long) property;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSObject
    public JSArray getNames() {
        checkRefCountIsZero();
        return (JSArray) this.context.getOwnPropertyNames(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSObject
    public JSArray getOwnPropertyNames() {
        return getNames();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSObject
    public long getPointer() {
        return this.pointer;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSObject
    public Object getProperty(String str) {
        checkRefCountIsZero();
        return this.context.getProperty(this, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSObject
    public int getRefCount() {
        return this.refCount;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSObject
    public Throwable getStackTrace() {
        return this.stackTrace;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSObject
    public String getString(String str) {
        Object property = getProperty(str);
        if (property instanceof String) {
            return (String) property;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSObject
    public String getStringProperty(String str) {
        return getString(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return Arrays.hashCode(new long[]{this.pointer});
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSObject
    public void hold() {
        checkRefCountIsZero();
        this.refCount++;
        this.context.hold(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSObject
    public boolean isAlive() {
        return !isRefCountZero();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSObject
    public boolean isRefCountZero() {
        return this.refCount == 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSObject
    public void release() {
        if (isRefCountZero()) {
            return;
        }
        this.refCount--;
        this.context.freeValue(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSObject
    public void setProperty(String str, Class<?> cls) {
        final Object objNewInstance;
        try {
            objNewInstance = cls.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            objNewInstance = null;
        } catch (InstantiationException e2) {
            e2.printStackTrace();
            objNewInstance = null;
        }
        if (objNewInstance == null) {
            om1.a("The JavaObj cannot be null. An error occurred in newInstance!");
            return;
        }
        JSObject jSObjectCreateNewJSObject = this.context.createNewJSObject();
        for (final Method method : cls.getMethods()) {
            if (method.isAnnotationPresent(JSMethod.class)) {
                jSObjectCreateNewJSObject.setProperty(method.getName(), new JSCallFunction() { // from class: tj3
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // com.whl.quickjs.wrapper.JSCallFunction
                    public final Object call(Object[] objArr) {
                        return QuickJSObject.a(method, objNewInstance, objArr);
                    }
                });
            }
        }
        setProperty(str, jSObjectCreateNewJSObject);
        jSObjectCreateNewJSObject.release();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSObject
    public void setStackTrace(Throwable th) {
        this.stackTrace = th;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSObject
    public String stringify() {
        checkRefCountIsZero();
        return this.context.stringify(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSObject
    public ArrayList<Object> toArray(MapFilter mapFilter, Object obj, MapCreator mapCreator) {
        throw new UnsupportedOperationException("Object types are not yet supported for conversion to array. You should use toMap.");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSObject
    public Map<String, Object> toMap(MapFilter mapFilter, Object obj, MapCreator mapCreator) {
        Map<String, Object> map = mapCreator.get();
        HashMap<Long, Object> map2 = new HashMap<>();
        convertToMap(this, map, map2, mapFilter, obj, mapCreator);
        map2.clear();
        return map;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        checkRefCountIsZero();
        JSFunction jSFunction = getJSFunction("toString");
        String str = (String) jSFunction.call(new Object[0]);
        jSFunction.release();
        return str;
    }

    @Override // com.whl.quickjs.wrapper.JSObject
    public ArrayList<Object> toArray() {
        return toArray(null);
    }

    @Override // com.whl.quickjs.wrapper.JSObject
    public ArrayList<Object> toArray(MapFilter mapFilter) {
        return toArray(mapFilter, null, null);
    }

    @Override // com.whl.quickjs.wrapper.JSObject
    public HashMap<String, Object> toMap(MapFilter mapFilter) {
        return (HashMap) toMap(mapFilter, null, new qj3());
    }

    @Override // com.whl.quickjs.wrapper.JSObject
    public HashMap<String, Object> toMap() {
        return toMap(null);
    }

    @Override // com.whl.quickjs.wrapper.JSObject
    public void setProperty(String str, int i) {
        setPropertyObject(str, Integer.valueOf(i));
    }

    @Override // com.whl.quickjs.wrapper.JSObject
    public void setProperty(String str, long j) {
        setPropertyObject(str, Long.valueOf(j));
    }

    @Override // com.whl.quickjs.wrapper.JSObject
    public void setProperty(String str, JSObject jSObject) {
        setPropertyObject(str, jSObject);
    }

    @Override // com.whl.quickjs.wrapper.JSObject
    public void setProperty(String str, boolean z) {
        setPropertyObject(str, Boolean.valueOf(z));
    }

    @Override // com.whl.quickjs.wrapper.JSObject
    public void setProperty(String str, double d) {
        setPropertyObject(str, Double.valueOf(d));
    }

    @Override // com.whl.quickjs.wrapper.JSObject
    public void setProperty(String str, byte[] bArr) {
        setPropertyObject(str, bArr);
    }

    @Override // com.whl.quickjs.wrapper.JSObject
    public void setProperty(String str, JSCallFunction jSCallFunction) {
        setPropertyObject(str, jSCallFunction);
    }

    @Override // com.whl.quickjs.wrapper.JSObject
    public void setProperty(String str, String str2) {
        setPropertyObject(str, str2);
    }
}
