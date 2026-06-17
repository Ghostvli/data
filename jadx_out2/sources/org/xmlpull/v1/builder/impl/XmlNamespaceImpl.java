package org.xmlpull.v1.builder.impl;

import org.xmlpull.v1.builder.XmlBuilderException;
import org.xmlpull.v1.builder.XmlNamespace;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class XmlNamespaceImpl implements XmlNamespace {
    private String namespaceName;
    private String prefix;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public XmlNamespaceImpl(String str, String str2) {
        this.prefix = str;
        if (str2 == null) {
            throw new XmlBuilderException("namespace name can not be null");
        }
        this.namespaceName = str2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlNamespace
    public String getNamespaceName() {
        return this.namespaceName;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.builder.XmlNamespace
    public String getPrefix() {
        return this.prefix;
    }
}
