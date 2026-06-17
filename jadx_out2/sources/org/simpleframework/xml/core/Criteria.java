package org.simpleframework.xml.core;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
interface Criteria extends Iterable<Object> {
    void commit(Object obj);

    Variable get(Object obj);

    Variable get(Label label);

    Variable remove(Object obj);

    Variable resolve(String str);

    void set(Label label, Object obj);
}
