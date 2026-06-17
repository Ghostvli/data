package com.chaquo.python;

import defpackage.bo;
import java.lang.ref.WeakReference;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class PyObject extends AbstractMap<String, PyObject> implements AutoCloseable {
    private static final Map<Long, WeakReference<PyObject>> cache = new HashMap();
    public long addr;

    /* JADX INFO: renamed from: com.chaquo.python.PyObject$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class AnonymousClass1 extends AbstractSet<Map.Entry<String, PyObject>> {

        /* JADX INFO: renamed from: com.chaquo.python.PyObject$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class C00581 implements Iterator<Map.Entry<String, PyObject>> {
            int i = 0;
            List<String> keys;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public C00581() {
                this.keys = PyObject.this.dir();
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.i < this.keys.size();
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: next()Ljava/lang/Object; */
            @Override // java.util.Iterator
            public Map.Entry<String, PyObject> next() {
                if (!hasNext()) {
                    bo.a();
                    return null;
                }
                Map.Entry<String, PyObject> entry = new Map.Entry<String, PyObject>() { // from class: com.chaquo.python.PyObject.1.1.1
                    String key;

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    {
                        this.key = C00581.this.keys.get(C00581.this.i);
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    /* JADX DEBUG: Method merged with bridge method: getValue()Ljava/lang/Object; */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.Map.Entry
                    public PyObject getValue() {
                        return PyObject.this.get((Object) this.key);
                    }

                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    /* JADX DEBUG: Method merged with bridge method: setValue(Ljava/lang/Object;)Ljava/lang/Object; */
                    @Override // java.util.Map.Entry
                    public PyObject setValue(PyObject pyObject) {
                        return PyObject.this.put(this.key, pyObject);
                    }

                    /* JADX DEBUG: Method merged with bridge method: getKey()Ljava/lang/Object; */
                    @Override // java.util.Map.Entry
                    public String getKey() {
                        return this.key;
                    }
                };
                this.i++;
                return entry;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.Iterator
            public void remove() {
                PyObject.this.remove((Object) this.keys.get(this.i - 1));
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public AnonymousClass1() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<String, PyObject>> iterator() {
            return new C00581();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return PyObject.this.dir().size();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private PyObject(long j) {
        this.addr = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static PyObject _chaquopyCall(StaticProxy staticProxy, String str, Object... objArr) {
        try {
            return fromJava(staticProxy).callAttrThrows(str, objArr);
        } catch (Error | RuntimeException e) {
            throw e;
        } catch (Throwable th) {
            throw new UndeclaredThrowableException(th);
        }
    }

    private native long callAttrThrowsNative(String str, Object... objArr);

    private native long callThrowsNative(Object... objArr);

    private native void closeNative();

    private native boolean containsKeyNative(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native List<String> dir();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static PyObject fromJava(Object obj) {
        return getInstance(fromJavaNative(obj));
    }

    private static native long fromJavaNative(Object obj);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static PyObject getInstance(long j) {
        PyObject pyObject;
        if (j == 0) {
            return null;
        }
        Map<Long, WeakReference<PyObject>> map = cache;
        synchronized (map) {
            try {
                WeakReference<PyObject> weakReference = map.get(Long.valueOf(j));
                if (weakReference != null && (pyObject = weakReference.get()) != null) {
                    return pyObject;
                }
                PyObject pyObject2 = new PyObject(j);
                map.put(Long.valueOf(j), new WeakReference<>(pyObject2));
                return pyObject2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private native long getNative(String str);

    private native long putNative(String str, Object obj);

    private native long removeNative(String str);

    private native long typeNative();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List<PyObject> asList() {
        return new PyList(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Map<PyObject, PyObject> asMap() {
        return new PyMap(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Set<PyObject> asSet() {
        return new PySet(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PyObject call(Object... objArr) {
        try {
            return callThrows(objArr);
        } catch (PyException e) {
            throw e;
        } catch (Throwable th) {
            throw new PyException(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PyObject callAttr(String str, Object... objArr) {
        try {
            return callAttrThrows(str, objArr);
        } catch (PyException e) {
            throw e;
        } catch (Throwable th) {
            throw new PyException(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PyObject callAttrThrows(String str, Object... objArr) {
        return getInstance(callAttrThrowsNative(str, objArr));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PyObject callThrows(Object... objArr) {
        return getInstance(callThrowsNative(objArr));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        super.clear();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.AutoCloseable
    public void close() {
        PyObject pyObject;
        if (this.addr == 0) {
            return;
        }
        Map<Long, WeakReference<PyObject>> map = cache;
        synchronized (map) {
            try {
                WeakReference<PyObject> weakReferenceRemove = map.remove(Long.valueOf(this.addr));
                if (weakReferenceRemove != null && (pyObject = weakReferenceRemove.get()) != null && pyObject != this) {
                    map.put(Long.valueOf(this.addr), weakReferenceRemove);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        closeNative();
        this.addr = 0L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return containsKeyNative((String) obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return super.containsValue(fromJava(obj));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<String, PyObject>> entrySet() {
        return new AnonymousClass1();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public native boolean equals(Object obj);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void finalize() throws Throwable {
        close();
        super.finalize();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: get(Ljava/lang/Object;)Ljava/lang/Object; */
    @Override // java.util.AbstractMap, java.util.Map
    public PyObject get(Object obj) {
        return getInstance(getNative((String) obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public native int hashCode();

    public native long id();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return super.isEmpty();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractMap, java.util.Map
    public Set<String> keySet() {
        return super.keySet();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: remove(Ljava/lang/Object;)Ljava/lang/Object; */
    @Override // java.util.AbstractMap, java.util.Map
    public PyObject remove(Object obj) {
        return getInstance(removeNative((String) obj));
    }

    public native String repr();

    public native boolean toBoolean();

    public native byte toByte();

    public native char toChar();

    public native double toDouble();

    public native float toFloat();

    public native int toInt();

    public native <T> T toJava(Class<T> cls);

    public native long toLong();

    public native short toShort();

    @Override // java.util.AbstractMap
    public native String toString();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PyObject type() {
        PyObject pyObject = getInstance(typeNative());
        Objects.requireNonNull(pyObject);
        return pyObject;
    }

    /* JADX DEBUG: Method merged with bridge method: put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
    @Override // java.util.AbstractMap, java.util.Map
    public PyObject put(String str, PyObject pyObject) {
        return put(str, (Object) pyObject);
    }

    public PyObject put(String str, Object obj) {
        return getInstance(putNative(str, obj));
    }
}
