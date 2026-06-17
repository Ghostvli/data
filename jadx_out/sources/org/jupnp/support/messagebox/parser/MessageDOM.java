package org.jupnp.support.messagebox.parser;

import javax.xml.xpath.XPath;
import org.jupnp.xml.DOM;
import org.w3c.dom.Document;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class MessageDOM extends DOM {
    public static final String NAMESPACE_URI = "urn:samsung-com:messagebox-1-0";

    public MessageDOM(Document document) {
        super(document);
    }

    @Override // org.jupnp.xml.DOM
    public MessageDOM copy() {
        return new MessageDOM((Document) getW3CDocument().cloneNode(true));
    }

    public MessageElement createRoot(XPath xPath, String str) {
        super.createRoot(str);
        return getRoot(xPath);
    }

    @Override // org.jupnp.xml.DOM
    public MessageElement getRoot(XPath xPath) {
        return new MessageElement(xPath, getW3CDocument().getDocumentElement());
    }

    @Override // org.jupnp.xml.DOM
    public String getRootElementNamespace() {
        return NAMESPACE_URI;
    }
}
