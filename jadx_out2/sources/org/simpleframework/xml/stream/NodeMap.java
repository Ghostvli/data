package org.simpleframework.xml.stream;

import java.util.Iterator;
import org.simpleframework.xml.stream.Node;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface NodeMap<T extends Node> extends Iterable<String> {
    T get(String str);

    String getName();

    T getNode();

    @Override // java.lang.Iterable
    Iterator<String> iterator();

    T put(String str, String str2);

    T remove(String str);
}
