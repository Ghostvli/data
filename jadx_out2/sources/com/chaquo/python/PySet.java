package com.chaquo.python;

import java.util.AbstractSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
class PySet extends AbstractSet<PyObject> {
    private final MethodCache methods;
    private final PyObject obj;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PySet(PyObject pyObject) {
        this.obj = pyObject;
        MethodCache methodCache = new MethodCache(pyObject);
        this.methods = methodCache;
        methodCache.get("__contains__");
        methodCache.get("__iter__");
        methodCache.get("__len__");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: add(Ljava/lang/Object;)Z */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(PyObject pyObject) {
        PyObject pyObject2 = this.methods.get("add");
        if (contains(pyObject)) {
            return false;
        }
        pyObject2.call(pyObject);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.methods.get("clear").call(new Object[0]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.methods.get("__contains__").call(obj).toBoolean();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<PyObject> iterator() {
        return new PyIterator<PyObject>(this.methods) { // from class: com.chaquo.python.PySet.1
            /* JADX DEBUG: Method merged with bridge method: makeNext(Lcom/chaquo/python/PyObject;)Ljava/lang/Object; */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.chaquo.python.PyIterator
            public PyObject makeNext(PyObject pyObject) {
                return pyObject;
            }
        };
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        try {
            this.methods.get("remove").call(obj);
            return true;
        } catch (PyException e) {
            if (e.getMessage().startsWith("KeyError:")) {
                return false;
            }
            throw e;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.methods.get("__len__").call(new Object[0]).toInt();
    }
}
