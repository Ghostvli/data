package com.whl.quickjs.wrapper;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class QuickJSFunction extends QuickJSObject implements JSFunction {
    private Status currentStatus;
    private int stashTimes;
    private final long thisPointer;
    private final int thisPointerTag;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum Status {
        NOT_CALLED,
        CALLING,
        CALLED
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public QuickJSFunction(QuickJSContext quickJSContext, long j, long j2, int i) {
        super(quickJSContext, j);
        this.stashTimes = 0;
        this.currentStatus = Status.NOT_CALLED;
        this.thisPointer = j2;
        this.thisPointerTag = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSFunction
    public Object call(Object... objArr) throws Throwable {
        QuickJSFunction quickJSFunction;
        checkRefCountIsZero();
        this.currentStatus = Status.CALLING;
        try {
            quickJSFunction = this;
            try {
                Object objCall = getContext().call(quickJSFunction, this.thisPointer, this.thisPointerTag, objArr);
                quickJSFunction.currentStatus = Status.CALLED;
                if (quickJSFunction.stashTimes > 0) {
                    for (int i = 0; i < quickJSFunction.stashTimes; i++) {
                        quickJSFunction.release();
                    }
                    quickJSFunction.stashTimes = 0;
                }
                return objCall;
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                quickJSFunction.currentStatus = Status.CALLED;
                if (quickJSFunction.stashTimes <= 0) {
                    throw th2;
                }
                for (int i2 = 0; i2 < quickJSFunction.stashTimes; i2++) {
                    quickJSFunction.release();
                }
                quickJSFunction.stashTimes = 0;
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            quickJSFunction = this;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.JSFunction
    public void callVoid(Object... objArr) throws Throwable {
        Object objCall = call(objArr);
        if (objCall instanceof JSObject) {
            ((JSObject) objCall).release();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.QuickJSObject, com.whl.quickjs.wrapper.JSObject
    public void release() {
        if (this.currentStatus == Status.CALLING) {
            this.stashTimes++;
        } else {
            super.release();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.QuickJSObject, com.whl.quickjs.wrapper.JSObject
    public ArrayList<Object> toArray() {
        throw new UnsupportedOperationException("JSFunction types do not support conversion to map or array.");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.whl.quickjs.wrapper.QuickJSObject, com.whl.quickjs.wrapper.JSObject
    public HashMap<String, Object> toMap() {
        throw new UnsupportedOperationException("JSFunction types do not support conversion to map or array.");
    }
}
