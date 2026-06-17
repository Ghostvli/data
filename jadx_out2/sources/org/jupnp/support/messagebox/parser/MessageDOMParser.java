package org.jupnp.support.messagebox.parser;

import javax.xml.xpath.XPath;
import org.jupnp.xml.DOMParser;
import org.jupnp.xml.NamespaceContextMap;
import org.w3c.dom.Document;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class MessageDOMParser extends DOMParser<MessageDOM> {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: createDOM(Lorg/w3c/dom/Document;)Lorg/jupnp/xml/DOM; */
    @Override // org.jupnp.xml.DOMParser
    public MessageDOM createDOM(Document document) {
        return new MessageDOM(document);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public NamespaceContextMap createDefaultNamespaceContext(String... strArr) {
        NamespaceContextMap namespaceContextMap = new NamespaceContextMap() { // from class: org.jupnp.support.messagebox.parser.MessageDOMParser.1
            private static final long serialVersionUID = -5868179503803332877L;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.jupnp.xml.NamespaceContextMap
            public String getDefaultNamespaceURI() {
                return MessageDOM.NAMESPACE_URI;
            }
        };
        for (String str : strArr) {
            namespaceContextMap.put(str, MessageDOM.NAMESPACE_URI);
        }
        return namespaceContextMap;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public XPath createXPath() {
        return super.createXPath(createDefaultNamespaceContext(MessageElement.XPATH_PREFIX));
    }
}
