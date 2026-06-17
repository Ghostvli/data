package org.simpleframework.xml.stream;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
abstract class EventToken implements EventNode {
    @Override // org.simpleframework.xml.stream.EventNode
    public int getLine() {
        return -1;
    }

    @Override // org.simpleframework.xml.stream.EventNode
    public String getName() {
        return null;
    }

    @Override // org.simpleframework.xml.stream.EventNode
    public String getPrefix() {
        return null;
    }

    @Override // org.simpleframework.xml.stream.EventNode
    public String getReference() {
        return null;
    }

    @Override // org.simpleframework.xml.stream.EventNode
    public Object getSource() {
        return null;
    }

    @Override // org.simpleframework.xml.stream.EventNode
    public String getValue() {
        return null;
    }

    @Override // org.simpleframework.xml.stream.EventNode
    public boolean isEnd() {
        return false;
    }

    @Override // org.simpleframework.xml.stream.EventNode
    public boolean isStart() {
        return false;
    }

    @Override // org.simpleframework.xml.stream.EventNode
    public boolean isText() {
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<Attribute> iterator() {
        return null;
    }
}
