package com.hierynomus.protocol.commons.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SequencedFuture<V> extends AFuture<List<V>> {
    private List<Future<V>> futures;

    public SequencedFuture(List<Future<V>> list) {
        this.futures = list;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        boolean z2;
        while (true) {
            for (Future<V> future : this.futures) {
                z2 = z2 && future.cancel(z);
            }
            return z2;
        }
    }

    @Override // java.util.concurrent.Future
    public List<V> get() {
        ArrayList arrayList = new ArrayList();
        Iterator<Future<V>> it = this.futures.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().get());
        }
        return arrayList;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        Iterator<Future<V>> it = this.futures.iterator();
        while (it.hasNext()) {
            if (!it.next().isCancelled()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Iterator<Future<V>> it = this.futures.iterator();
        while (it.hasNext()) {
            if (!it.next().isDone()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.concurrent.Future
    public List<V> get(long j, TimeUnit timeUnit) {
        ArrayList arrayList = new ArrayList();
        Iterator<Future<V>> it = this.futures.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().get(j, timeUnit));
        }
        return arrayList;
    }
}
