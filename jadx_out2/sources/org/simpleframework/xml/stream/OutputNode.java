package org.simpleframework.xml.stream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface OutputNode extends Node {
    void commit();

    NodeMap<OutputNode> getAttributes();

    OutputNode getChild(String str);

    String getComment();

    Mode getMode();

    NamespaceMap getNamespaces();

    @Override // org.simpleframework.xml.stream.Node
    OutputNode getParent();

    String getPrefix();

    String getPrefix(boolean z);

    String getReference();

    boolean isCommitted();

    boolean isRoot();

    void remove();

    OutputNode setAttribute(String str, String str2);

    void setComment(String str);

    void setData(boolean z);

    void setMode(Mode mode);

    void setName(String str);

    void setReference(String str);

    void setValue(String str);
}
