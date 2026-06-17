package org.jupnp.support.messagebox.parser;

import javax.xml.xpath.XPath;
import org.jupnp.xml.DOMElement;
import org.w3c.dom.Element;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class MessageElement extends DOMElement<MessageElement, MessageElement> {
    public static final String XPATH_PREFIX = "m";

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public MessageElement(XPath xPath, Element element) {
        super(xPath, element);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.xml.DOMElement
    public DOMElement.ArrayBuilder<MessageElement> createChildBuilder(DOMElement dOMElement) {
        return new DOMElement.ArrayBuilder<MessageElement>(dOMElement) { // from class: org.jupnp.support.messagebox.parser.MessageElement.2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: build(Lorg/w3c/dom/Element;)Lorg/jupnp/xml/DOMElement; */
            @Override // org.jupnp.xml.DOMElement.Builder
            public MessageElement build(Element element) {
                return new MessageElement(MessageElement.this.getXpath(), element);
            }

            /* JADX DEBUG: Method merged with bridge method: newChildrenArray(I)[Lorg/jupnp/xml/DOMElement; */
            @Override // org.jupnp.xml.DOMElement.ArrayBuilder
            public MessageElement[] newChildrenArray(int i) {
                return new MessageElement[i];
            }
        };
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.xml.DOMElement
    public DOMElement.Builder<MessageElement> createParentBuilder(DOMElement dOMElement) {
        return new DOMElement.Builder<MessageElement>(dOMElement) { // from class: org.jupnp.support.messagebox.parser.MessageElement.1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: build(Lorg/w3c/dom/Element;)Lorg/jupnp/xml/DOMElement; */
            @Override // org.jupnp.xml.DOMElement.Builder
            public MessageElement build(Element element) {
                return new MessageElement(MessageElement.this.getXpath(), element);
            }
        };
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.xml.DOMElement
    public String prefix(String str) {
        return "m:" + str;
    }
}
