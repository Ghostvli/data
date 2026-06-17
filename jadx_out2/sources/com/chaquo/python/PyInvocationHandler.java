package com.chaquo.python;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class PyInvocationHandler implements InvocationHandler {
    private PyObject dict;
    private PyObject type;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PyInvocationHandler(PyObject pyObject) {
        this.type = pyObject;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        String name;
        name = method.getName();
        name.getClass();
        switch (name) {
            case "_chaquopySetDict":
                this.dict = (PyObject) objArr[0];
                return null;
            case "_chaquopyGetDict":
                return this.dict;
            case "_chaquopyGetType":
                return this.type;
            default:
                PyObject pyObjectFromJava = PyObject.fromJava(obj);
                if (objArr == null) {
                    objArr = new Object[0];
                }
                PyObject pyObjectCallAttrThrows = pyObjectFromJava.callAttrThrows(name, objArr);
                if (pyObjectCallAttrThrows == null) {
                    return null;
                }
                return pyObjectCallAttrThrows.toJava(method.getReturnType());
        }
    }
}
