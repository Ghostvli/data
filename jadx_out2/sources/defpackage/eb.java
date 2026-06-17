package defpackage;

import com.whl.quickjs.wrapper.JSCallFunction;
import com.whl.quickjs.wrapper.JSFunction;
import com.whl.quickjs.wrapper.JSObject;
import java.util.concurrent.CompletableFuture;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class eb {
    public final JSCallFunction b = new JSCallFunction() { // from class: cb
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.whl.quickjs.wrapper.JSCallFunction
        public final Object call(Object[] objArr) {
            return this.a.g(objArr);
        }
    };
    public final JSCallFunction c = new JSCallFunction() { // from class: db
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.whl.quickjs.wrapper.JSCallFunction
        public final Object call(Object[] objArr) {
            return this.a.h(objArr);
        }
    };
    public CompletableFuture a = new CompletableFuture();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static CompletableFuture i(JSObject jSObject, String str, Object... objArr) {
        return new eb().c(jSObject, str, objArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final CompletableFuture c(JSObject jSObject, String str, Object... objArr) {
        JSFunction jSFunction = jSObject.getJSFunction(str);
        if (jSFunction == null) {
            return f();
        }
        d(jSFunction, objArr);
        return this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void d(JSFunction jSFunction, Object... objArr) {
        try {
            Object objCall = jSFunction.call(objArr);
            if (objCall instanceof JSObject) {
                j((JSObject) objCall);
            } else {
                this.a.complete(objCall);
            }
        } catch (Throwable th) {
            try {
                this.a.completeExceptionally(th);
            } finally {
                jSFunction.release();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void e(JSFunction jSFunction, JSCallFunction jSCallFunction) {
        if (jSFunction == null) {
            return;
        }
        try {
            jSFunction.call(jSCallFunction);
        } finally {
            jSFunction.release();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final CompletableFuture f() {
        this.a.complete(null);
        return this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ Object g(Object[] objArr) {
        this.a.complete((objArr == null || objArr.length <= 0) ? null : objArr[0]);
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ Object h(Object[] objArr) {
        Object obj;
        this.a.completeExceptionally(new Exception((objArr == null || objArr.length <= 0 || (obj = objArr[0]) == null) ? "" : obj.toString()));
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j(JSObject jSObject) {
        JSFunction jSFunction = jSObject.getJSFunction("then");
        if (jSFunction == null) {
            this.a.complete(jSObject);
        } else {
            e(jSFunction, this.b);
            e(jSObject.getJSFunction("catch"), this.c);
        }
    }
}
