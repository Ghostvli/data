package com.thegrizzlylabs.sardineandroid.util;

import javax.xml.namespace.QName;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.w3c.dom.Element;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ElementConverter {
    public static Element read(InputNode inputNode) {
        Element elementCreateElement = SardineUtil.createElement(new QName(inputNode.getReference(), inputNode.getName(), inputNode.getPrefix()));
        elementCreateElement.setTextContent(inputNode.getValue());
        return elementCreateElement;
    }

    public static void write(OutputNode outputNode, Element element) {
        OutputNode child = outputNode.getChild(element.getNodeName());
        child.getNamespaces().setReference(element.getNamespaceURI(), element.getPrefix());
        child.setValue(element.getTextContent());
        child.commit();
    }
}
