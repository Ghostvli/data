package okhttp3.internal;

import defpackage.hp1;
import defpackage.pb;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class TagsKt {
    public static final <T> T computeIfAbsent(AtomicReference<Tags> atomicReference, hp1 hp1Var, Function0<? extends T> function0) {
        Tags tags;
        atomicReference.getClass();
        hp1Var.getClass();
        function0.getClass();
        T tInvoke = null;
        do {
            tags = atomicReference.get();
            T t = (T) tags.get(hp1Var);
            if (t != null) {
                return t;
            }
            if (tInvoke == null) {
                tInvoke = function0.invoke();
            }
        } while (!pb.a(atomicReference, tags, tags.plus(hp1Var, tInvoke)));
        return tInvoke;
    }
}
