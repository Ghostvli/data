package org.jupnp.transport.impl;

import defpackage.j02;
import defpackage.n02;
import defpackage.zt2;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilderFactory;
import org.jupnp.model.Constants;
import org.jupnp.model.UnsupportedDataException;
import org.jupnp.model.XMLUtil;
import org.jupnp.model.message.UpnpMessage;
import org.jupnp.model.message.gena.IncomingEventRequestMessage;
import org.jupnp.model.message.gena.OutgoingEventRequestMessage;
import org.jupnp.model.meta.RemoteService;
import org.jupnp.model.meta.StateVariable;
import org.jupnp.model.state.StateVariableValue;
import org.jupnp.model.types.InvalidValueException;
import org.jupnp.transport.spi.GENAEventProcessor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXParseException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class GENAEventProcessorImpl extends PooledXmlProcessor implements GENAEventProcessor, ErrorHandler {
    private final j02 logger = n02.k(GENAEventProcessor.class);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DocumentBuilderFactory createDocumentBuilderFactory() {
        return DocumentBuilderFactory.newInstance();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xml.sax.ErrorHandler
    public void error(SAXParseException sAXParseException) throws SAXParseException {
        throw sAXParseException;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xml.sax.ErrorHandler
    public void fatalError(SAXParseException sAXParseException) throws SAXParseException {
        throw sAXParseException;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getMessageBody(UpnpMessage upnpMessage) {
        if (upnpMessage.isBodyNonEmptyString()) {
            return upnpMessage.getBodyString().trim();
        }
        throw new UnsupportedDataException("Can't transform null or non-string/zero-length body of: ".concat(String.valueOf(upnpMessage)));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getUnprefixedNodeName(Node node) {
        return node.getPrefix() != null ? node.getNodeName().substring(node.getPrefix().length() + 1) : node.getNodeName();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.spi.GENAEventProcessor
    public void readBody(IncomingEventRequestMessage incomingEventRequestMessage) {
        this.logger.h("Reading body of: {}", incomingEventRequestMessage);
        if (this.logger.n()) {
            this.logger.y("===================================== GENA BODY BEGIN ============================================");
            this.logger.y(incomingEventRequestMessage.getBody() != null ? incomingEventRequestMessage.getBody().toString() : "null");
            this.logger.y("-===================================== GENA BODY END ============================================");
        }
        String messageBody = getMessageBody(incomingEventRequestMessage);
        try {
            readProperties(readPropertysetElement(readDocument(new InputSource(new StringReader(messageBody)), this)), incomingEventRequestMessage);
        } catch (Exception e) {
            throw new UnsupportedDataException("Can't transform message payload: " + e.getMessage(), e, messageBody);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void readProperties(Element element, IncomingEventRequestMessage incomingEventRequestMessage) {
        NodeList childNodes = element.getChildNodes();
        StateVariable<RemoteService>[] stateVariables = incomingEventRequestMessage.getService().getStateVariables();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node nodeItem = childNodes.item(i);
            if (nodeItem.getNodeType() == 1 && getUnprefixedNodeName(nodeItem).equals("property")) {
                NodeList childNodes2 = nodeItem.getChildNodes();
                for (int i2 = 0; i2 < childNodes2.getLength(); i2++) {
                    Node nodeItem2 = childNodes2.item(i2);
                    if (nodeItem2.getNodeType() == 1) {
                        String unprefixedNodeName = getUnprefixedNodeName(nodeItem2);
                        int length = stateVariables.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 < length) {
                                StateVariable<RemoteService> stateVariable = stateVariables[i3];
                                if (stateVariable.getName().equals(unprefixedNodeName)) {
                                    this.logger.h("Reading state variable value: {}", unprefixedNodeName);
                                    String textContent = XMLUtil.getTextContent(nodeItem2);
                                    try {
                                        incomingEventRequestMessage.getStateVariableValues().add(new StateVariableValue(stateVariable, textContent));
                                        break;
                                    } catch (InvalidValueException e) {
                                        this.logger.s("Value {} for the state variable {} ignored: {}", textContent, unprefixedNodeName, e.getMessage());
                                    }
                                } else {
                                    i3++;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Element readPropertysetElement(Document document) {
        Element documentElement = document.getDocumentElement();
        if (documentElement != null && getUnprefixedNodeName(documentElement).equals("propertyset")) {
            return documentElement;
        }
        zt2.a("Root element was not 'propertyset'");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString(Document document) {
        String strDocumentToString = XMLUtil.documentToString(document);
        while (true) {
            if (!strDocumentToString.endsWith("\n") && !strDocumentToString.endsWith("\r")) {
                return strDocumentToString;
            }
            strDocumentToString = strDocumentToString.substring(0, strDocumentToString.length() - 1);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xml.sax.ErrorHandler
    public void warning(SAXParseException sAXParseException) {
        this.logger.warn(sAXParseException.toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.spi.GENAEventProcessor
    public void writeBody(OutgoingEventRequestMessage outgoingEventRequestMessage) {
        this.logger.h("Writing body of: {}", outgoingEventRequestMessage);
        try {
            Document documentNewDocument = newDocument();
            writeProperties(documentNewDocument, writePropertysetElement(documentNewDocument), outgoingEventRequestMessage);
            outgoingEventRequestMessage.setBody(UpnpMessage.BodyType.STRING, toString(documentNewDocument));
            if (this.logger.n()) {
                this.logger.y("===================================== GENA BODY BEGIN ============================================");
                this.logger.y(outgoingEventRequestMessage.getBody().toString());
                this.logger.y("====================================== GENA BODY END =============================================");
            }
        } catch (Exception e) {
            throw new UnsupportedDataException("Can't transform message payload: " + e.getMessage(), e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void writeProperties(Document document, Element element, OutgoingEventRequestMessage outgoingEventRequestMessage) {
        for (StateVariableValue stateVariableValue : outgoingEventRequestMessage.getStateVariableValues()) {
            Element elementCreateElementNS = document.createElementNS(Constants.NS_UPNP_EVENT_10, "e:property");
            element.appendChild(elementCreateElementNS);
            XMLUtil.appendNewElement(document, elementCreateElementNS, stateVariableValue.getStateVariable().getName(), stateVariableValue.toString());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Element writePropertysetElement(Document document) {
        Element elementCreateElementNS = document.createElementNS(Constants.NS_UPNP_EVENT_10, "e:propertyset");
        document.appendChild(elementCreateElementNS);
        return elementCreateElementNS;
    }
}
