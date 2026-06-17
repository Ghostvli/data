package org.xmlpull.v1.builder;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface XmlDoctype extends XmlContainer {
    XmlProcessingInstruction addProcessingInstruction(String str, String str2);

    Iterator children();

    XmlDocument getParent();

    String getPublicIdentifier();

    String getSystemIdentifier();

    void removeAllProcessingInstructions();
}
