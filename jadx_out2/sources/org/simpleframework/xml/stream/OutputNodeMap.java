package org.simpleframework.xml.stream;

import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class OutputNodeMap extends LinkedHashMap<String, OutputNode> implements NodeMap<OutputNode> {
    private final OutputNode source;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public OutputNodeMap(OutputNode outputNode) {
        this.source = outputNode;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: get(Ljava/lang/String;)Lorg/simpleframework/xml/stream/Node; */
    @Override // org.simpleframework.xml.stream.NodeMap
    public OutputNode get(String str) {
        return (OutputNode) super.get((Object) str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.simpleframework.xml.stream.NodeMap
    public String getName() {
        return this.source.getName();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.simpleframework.xml.stream.NodeMap, java.lang.Iterable
    public Iterator<String> iterator() {
        return keySet().iterator();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: put(Ljava/lang/String;Ljava/lang/String;)Lorg/simpleframework/xml/stream/Node; */
    @Override // org.simpleframework.xml.stream.NodeMap
    public OutputNode put(String str, String str2) {
        OutputAttribute outputAttribute = new OutputAttribute(this.source, str, str2);
        if (this.source != null) {
            put(str, outputAttribute);
        }
        return outputAttribute;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: remove(Ljava/lang/String;)Lorg/simpleframework/xml/stream/Node; */
    @Override // org.simpleframework.xml.stream.NodeMap
    public OutputNode remove(String str) {
        return (OutputNode) super.remove((Object) str);
    }

    /* JADX DEBUG: Method merged with bridge method: getNode()Lorg/simpleframework/xml/stream/Node; */
    @Override // org.simpleframework.xml.stream.NodeMap
    public OutputNode getNode() {
        return this.source;
    }
}
