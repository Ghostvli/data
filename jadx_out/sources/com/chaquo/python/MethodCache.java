package com.chaquo.python;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
class MethodCache {
    private Map<String, PyObject> cache = new HashMap();
    private PyObject obj;

    public MethodCache(PyObject pyObject) {
        this.obj = pyObject;
    }

    public PyObject get(String str) {
        PyObject pyObject = this.cache.get(str);
        if (pyObject != null) {
            return pyObject;
        }
        PyObject pyObject2 = this.obj.get((Object) str);
        if (pyObject2 == null) {
            throw new UnsupportedOperationException(String.format("'%s' object has no attribute '%s'", this.obj.type().get((Object) "__name__"), str));
        }
        this.cache.put(str, pyObject2);
        return pyObject2;
    }
}
