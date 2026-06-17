package okhttp3;

import defpackage.hp1;
import kotlin.jvm.functions.Function0;
import okio.Timeout;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface Call extends Cloneable {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface Factory {
        Call newCall(Request request);
    }

    void cancel();

    /* JADX INFO: renamed from: clone */
    Call mo157clone();

    void enqueue(Callback callback);

    Response execute();

    boolean isCanceled();

    boolean isExecuted();

    Request request();

    <T> T tag(hp1 hp1Var);

    <T> T tag(hp1 hp1Var, Function0<? extends T> function0);

    <T> T tag(Class<? extends T> cls);

    <T> T tag(Class<T> cls, Function0<? extends T> function0);

    Timeout timeout();
}
