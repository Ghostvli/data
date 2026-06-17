package com.hierynomus.smbj.common;

import com.hierynomus.smbj.common.Pooled;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Pooled<A extends Pooled<A>> {
    private final AtomicInteger leases = new AtomicInteger(1);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public A lease() {
        if (this.leases.getAndIncrement() > 0) {
            return this;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean release() {
        return this.leases.decrementAndGet() <= 0;
    }
}
