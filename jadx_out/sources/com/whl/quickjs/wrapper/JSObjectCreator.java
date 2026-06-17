package com.whl.quickjs.wrapper;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface JSObjectCreator {
    JSArray newArray(QuickJSContext quickJSContext, long j);

    JSFunction newFunction(QuickJSContext quickJSContext, long j, long j2, int i);

    JSObject newObject(QuickJSContext quickJSContext, long j);
}
