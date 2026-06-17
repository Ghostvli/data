package com.fongmi.quickjs.method;

import com.whl.quickjs.wrapper.QuickJSContext;
import defpackage.g02;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Console implements QuickJSContext.Console {
    private static final String TAG = "quickjs";

    @Override // com.whl.quickjs.wrapper.QuickJSContext.Console
    public void error(String str) {
        g02.b(TAG).c(str, new Object[0]);
    }

    @Override // com.whl.quickjs.wrapper.QuickJSContext.Console
    public void info(String str) {
        g02.b(TAG).e(str, new Object[0]);
    }

    @Override // com.whl.quickjs.wrapper.QuickJSContext.Console
    public void log(String str) {
        g02.b(TAG).g(str);
    }

    @Override // com.whl.quickjs.wrapper.QuickJSContext.Console
    public void warn(String str) {
        g02.b(TAG).d(str, new Object[0]);
    }
}
