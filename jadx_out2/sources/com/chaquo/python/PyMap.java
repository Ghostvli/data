package com.chaquo.python;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
class PyMap extends AbstractMap<PyObject, PyObject> {
    private final MethodCache methods;
    private final PyObject obj;

    /* JADX INFO: renamed from: com.chaquo.python.PyMap$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class AnonymousClass1 extends AbstractSet<Map.Entry<PyObject, PyObject>> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public AnonymousClass1() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            PyMap.this.methods.get("clear").call(new Object[0]);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<PyObject, PyObject>> iterator() {
            return new PyIterator<Map.Entry<PyObject, PyObject>>(PyMap.this.methods) { // from class: com.chaquo.python.PyMap.1.1
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                /* JADX DEBUG: Method merged with bridge method: makeNext(Lcom/chaquo/python/PyObject;)Ljava/lang/Object; */
                @Override // com.chaquo.python.PyIterator
                public Map.Entry<PyObject, PyObject> makeNext(final PyObject pyObject) {
                    return new Map.Entry<PyObject, PyObject>() { // from class: com.chaquo.python.PyMap.1.1.1
                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        /* JADX DEBUG: Method merged with bridge method: getValue()Ljava/lang/Object; */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // java.util.Map.Entry
                        public PyObject getValue() {
                            return PyMap.this.get((Object) pyObject);
                        }

                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        /* JADX DEBUG: Method merged with bridge method: setValue(Ljava/lang/Object;)Ljava/lang/Object; */
                        @Override // java.util.Map.Entry
                        public PyObject setValue(PyObject pyObject2) {
                            return PyMap.this.put(pyObject, pyObject2);
                        }

                        /* JADX DEBUG: Method merged with bridge method: getKey()Ljava/lang/Object; */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // java.util.Map.Entry
                        public PyObject getKey() {
                            return pyObject;
                        }
                    };
                }
            };
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return PyMap.this.methods.get("__len__").call(new Object[0]).toInt();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PyMap(PyObject pyObject) {
        this.obj = pyObject;
        MethodCache methodCache = new MethodCache(pyObject);
        this.methods = methodCache;
        methodCache.get("__contains__");
        methodCache.get("__getitem__");
        methodCache.get("__iter__");
        methodCache.get("__len__");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return this.methods.get("__contains__").call(obj).toBoolean();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<PyObject, PyObject>> entrySet() {
        return new AnonymousClass1();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: get(Ljava/lang/Object;)Ljava/lang/Object; */
    @Override // java.util.AbstractMap, java.util.Map
    public PyObject get(Object obj) {
        try {
            return this.methods.get("__getitem__").call(obj);
        } catch (PyException e) {
            if (e.getMessage().startsWith("KeyError:")) {
                return null;
            }
            throw e;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
    @Override // java.util.AbstractMap, java.util.Map
    public PyObject put(PyObject pyObject, PyObject pyObject2) {
        PyObject pyObject3 = get((Object) pyObject);
        this.methods.get("__setitem__").call(pyObject, pyObject2);
        return pyObject3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: remove(Ljava/lang/Object;)Ljava/lang/Object; */
    @Override // java.util.AbstractMap, java.util.Map
    public PyObject remove(Object obj) {
        return this.methods.get("pop").call(obj, null);
    }
}
