package net.engio.mbassy.bus.common;

import net.engio.mbassy.bus.IMessagePublication;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface PubSubSupport<T> extends RuntimeProvider {
    IMessagePublication publish(T t);

    void subscribe(Object obj);

    boolean unsubscribe(Object obj);
}
