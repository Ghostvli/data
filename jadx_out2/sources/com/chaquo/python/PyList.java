package com.chaquo.python;

import java.util.AbstractList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
class PyList extends AbstractList<PyObject> {
    private final MethodCache methods;
    private final PyObject obj;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PyList(PyObject pyObject) {
        this.obj = pyObject;
        MethodCache methodCache = new MethodCache(pyObject);
        this.methods = methodCache;
        methodCache.get("__getitem__");
        methodCache.get("__len__");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void checkLowerBound(int i) {
        if (i < 0) {
            throw outOfBounds(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private RuntimeException maybeOutOfBounds(int i, PyException pyException) {
        return pyException.getMessage().startsWith("IndexError:") ? outOfBounds(i) : pyException;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private IndexOutOfBoundsException outOfBounds(int i) {
        return new IndexOutOfBoundsException("Invalid index " + i + ", size is " + size());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: add(ILjava/lang/Object;)V */
    @Override // java.util.AbstractList, java.util.List
    public void add(int i, PyObject pyObject) {
        checkLowerBound(i);
        if (i > size()) {
            throw outOfBounds(i);
        }
        this.methods.get("insert").call(Integer.valueOf(i), pyObject);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.methods.get("clear").call(new Object[0]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: get(I)Ljava/lang/Object; */
    @Override // java.util.AbstractList, java.util.List
    public PyObject get(int i) {
        checkLowerBound(i);
        try {
            return this.methods.get("__getitem__").call(Integer.valueOf(i));
        } catch (PyException e) {
            throw this.maybeOutOfBounds(i, e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: remove(I)Ljava/lang/Object; */
    @Override // java.util.AbstractList, java.util.List
    public PyObject remove(int i) {
        checkLowerBound(i);
        try {
            return this.methods.get("pop").call(Integer.valueOf(i));
        } catch (PyException e) {
            throw this.maybeOutOfBounds(i, e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: set(ILjava/lang/Object;)Ljava/lang/Object; */
    @Override // java.util.AbstractList, java.util.List
    public PyObject set(int i, PyObject pyObject) {
        PyObject pyObject2 = get(i);
        this.methods.get("__setitem__").call(Integer.valueOf(i), pyObject);
        return pyObject2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.methods.get("__len__").call(new Object[0]).toInt();
    }
}
