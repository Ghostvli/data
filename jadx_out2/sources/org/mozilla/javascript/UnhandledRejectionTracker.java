package org.mozilla.javascript;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class UnhandledRejectionTracker {
    private static final IdentityHashMap<NativePromise, NativePromise> unhandled = new IdentityHashMap<>(0);
    private boolean enabled = false;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void enable(boolean z) {
        this.enabled = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List<Object> enumerate() {
        ArrayList arrayList = new ArrayList();
        Iterator<NativePromise> it = unhandled.values().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getResult());
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void process(Consumer<Object> consumer) {
        Iterator<NativePromise> it = unhandled.values().iterator();
        while (it.hasNext()) {
            try {
                consumer.accept(it.next().getResult());
            } finally {
                it.remove();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void promiseHandled(NativePromise nativePromise) {
        if (this.enabled) {
            unhandled.remove(nativePromise);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void promiseRejected(NativePromise nativePromise) {
        if (this.enabled) {
            unhandled.put(nativePromise, nativePromise);
        }
    }
}
