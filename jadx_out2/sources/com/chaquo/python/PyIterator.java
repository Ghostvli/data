package com.chaquo.python;

import defpackage.bo;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
abstract class PyIterator<T> implements Iterator<T> {
    private boolean hasNextElem = true;
    private PyObject iter;
    private PyObject nextElem;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PyIterator(MethodCache methodCache) {
        this.iter = methodCache.get("__iter__").call(new Object[0]);
        updateNext();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNextElem;
    }

    public abstract T makeNext(PyObject pyObject);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.Iterator
    public T next() {
        if (!hasNext()) {
            bo.a();
            return null;
        }
        T tMakeNext = makeNext(this.nextElem);
        updateNext();
        return tMakeNext;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Python does not support removing from a container while iterating over it");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void updateNext() {
        try {
            this.nextElem = this.iter.callAttr("__next__", new Object[0]);
        } catch (PyException e) {
            if (!e.getMessage().startsWith("StopIteration:")) {
                throw e;
            }
            this.hasNextElem = false;
            this.nextElem = null;
        }
    }
}
