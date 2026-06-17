package org.jupnp.transport.impl;

import defpackage.cx4;
import defpackage.j02;
import defpackage.n02;
import defpackage.zt2;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jupnp.model.Constants;
import org.jupnp.model.UnsupportedDataException;
import org.jupnp.model.XMLUtil;
import org.jupnp.model.action.ActionArgumentValue;
import org.jupnp.model.action.ActionException;
import org.jupnp.model.action.ActionInvocation;
import org.jupnp.model.message.control.ActionMessage;
import org.jupnp.model.message.control.ActionRequestMessage;
import org.jupnp.model.message.control.ActionResponseMessage;
import org.jupnp.model.meta.ActionArgument;
import org.jupnp.model.types.ErrorCode;
import org.jupnp.model.types.InvalidValueException;
import org.jupnp.transport.spi.SOAPActionProcessor;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXParseException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SOAPActionProcessorImpl extends PooledXmlProcessor implements SOAPActionProcessor, ErrorHandler {
    private final j02 logger = n02.k(SOAPActionProcessor.class);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ActionArgumentValue createValue(ActionArgument actionArgument, String str) throws ActionException {
        try {
            return new ActionArgumentValue(actionArgument, str);
        } catch (InvalidValueException e) {
            throw new ActionException(ErrorCode.ARGUMENT_VALUE_INVALID, "Wrong type or invalid value for '" + actionArgument.getName() + "': " + e.getMessage(), e);
        }
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
    public Node findActionArgumentNode(List<Node> list, ActionArgument actionArgument) {
        for (Node node : list) {
            if (actionArgument.isNameOrAlias(getUnprefixedNodeName(node))) {
                return node;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List<Node> getMatchingNodes(NodeList nodeList, ActionArgument[] actionArgumentArr) throws ActionException {
        ArrayList arrayList = new ArrayList();
        for (ActionArgument actionArgument : actionArgumentArr) {
            arrayList.add(actionArgument.getName());
            arrayList.addAll(Arrays.asList(actionArgument.getAliases()));
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nodeItem = nodeList.item(i);
            if (nodeItem.getNodeType() == 1 && arrayList.contains(getUnprefixedNodeName(nodeItem))) {
                arrayList2.add(nodeItem);
            }
        }
        if (arrayList2.size() >= actionArgumentArr.length) {
            return arrayList2;
        }
        throw new ActionException(ErrorCode.ARGUMENT_VALUE_INVALID, "Invalid number of input or output arguments in XML message, expected " + actionArgumentArr.length + " but found " + arrayList2.size());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getMessageBody(ActionMessage actionMessage) {
        if (actionMessage.isBodyNonEmptyString()) {
            return actionMessage.getBodyString().trim();
        }
        throw new UnsupportedDataException("Can't transform null or non-string/zero-length body of: ".concat(String.valueOf(actionMessage)));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getUnprefixedNodeName(Node node) {
        return node.getPrefix() != null ? node.getNodeName().substring(node.getPrefix().length() + 1) : node.getNodeName();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void readActionInputArguments(Element element, ActionInvocation actionInvocation) {
        actionInvocation.setInput(readArgumentValues(element.getChildNodes(), actionInvocation.getAction().getInputArguments()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void readActionOutputArguments(Element element, ActionInvocation actionInvocation) {
        actionInvocation.setOutput(readArgumentValues(element.getChildNodes(), actionInvocation.getAction().getOutputArguments()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Element readActionRequestElement(Element element, ActionRequestMessage actionRequestMessage, ActionInvocation actionInvocation) {
        NodeList childNodes = element.getChildNodes();
        this.logger.h("Looking for action request element matching namespace: {}", actionRequestMessage.getActionNamespace());
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node nodeItem = childNodes.item(i);
            if (nodeItem.getNodeType() == 1) {
                String unprefixedNodeName = getUnprefixedNodeName(nodeItem);
                if (unprefixedNodeName.equals(actionInvocation.getAction().getName())) {
                    if (nodeItem.getNamespaceURI() == null || !nodeItem.getNamespaceURI().equals(actionRequestMessage.getActionNamespace())) {
                        throw new UnsupportedDataException("Illegal or missing namespace on action request element: ".concat(String.valueOf(nodeItem)));
                    }
                    this.logger.h("Reading action request element: {}", unprefixedNodeName);
                    return (Element) nodeItem;
                }
            }
        }
        throw new UnsupportedDataException("Could not read action request element matching namespace: " + actionRequestMessage.getActionNamespace());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Element readActionResponseElement(Element element, ActionInvocation actionInvocation) {
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node nodeItem = childNodes.item(i);
            if (nodeItem.getNodeType() == 1) {
                if (getUnprefixedNodeName(nodeItem).equals(actionInvocation.getAction().getName() + "Response")) {
                    this.logger.h("Reading action response element: {}", getUnprefixedNodeName(nodeItem));
                    return (Element) nodeItem;
                }
            }
        }
        this.logger.y("Could not read action response element");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ActionArgumentValue[] readArgumentValues(NodeList nodeList, ActionArgument[] actionArgumentArr) throws ActionException {
        List<Node> matchingNodes = getMatchingNodes(nodeList, actionArgumentArr);
        ActionArgumentValue[] actionArgumentValueArr = new ActionArgumentValue[actionArgumentArr.length];
        for (int i = 0; i < actionArgumentArr.length; i++) {
            ActionArgument actionArgument = actionArgumentArr[i];
            Node nodeFindActionArgumentNode = findActionArgumentNode(matchingNodes, actionArgument);
            if (nodeFindActionArgumentNode == null) {
                throw new ActionException(ErrorCode.ARGUMENT_VALUE_INVALID, "Could not find argument '" + actionArgument.getName() + "' node");
            }
            this.logger.h("Reading action argument: {}", actionArgument.getName());
            actionArgumentValueArr[i] = createValue(actionArgument, XMLUtil.getTextContent(nodeFindActionArgumentNode));
        }
        return actionArgumentValueArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.spi.SOAPActionProcessor
    public void readBody(ActionResponseMessage actionResponseMessage, ActionInvocation actionInvocation) {
        this.logger.i("Reading body of {} for: {}", actionResponseMessage, actionInvocation);
        if (this.logger.n()) {
            this.logger.y("===================================== SOAP BODY BEGIN ============================================");
            this.logger.y(actionResponseMessage.getBodyString());
            this.logger.y("-===================================== SOAP BODY END ============================================");
        }
        String messageBody = getMessageBody(actionResponseMessage);
        try {
            Document document = readDocument(new InputSource(new StringReader(messageBody)), this);
            Element bodyElement = readBodyElement(document);
            ActionException bodyFailure = readBodyFailure(document, bodyElement);
            if (bodyFailure == null) {
                readBodyResponse(document, bodyElement, actionResponseMessage, actionInvocation);
            } else {
                actionInvocation.setFailure(bodyFailure);
            }
        } catch (Exception e) {
            throw new UnsupportedDataException("Can't transform message payload", e, messageBody);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Element readBodyElement(Document document) {
        Element documentElement = document.getDocumentElement();
        if (documentElement == null || !getUnprefixedNodeName(documentElement).equals("Envelope")) {
            zt2.a("Response root element was not 'Envelope'");
            return null;
        }
        NodeList childNodes = documentElement.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node nodeItem = childNodes.item(i);
            if (nodeItem.getNodeType() == 1 && getUnprefixedNodeName(nodeItem).equals("Body")) {
                return (Element) nodeItem;
            }
        }
        zt2.a("Response envelope did not contain 'Body' child element");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ActionException readBodyFailure(Document document, Element element) {
        return readFaultElement(element);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void readBodyRequest(Document document, Element element, ActionRequestMessage actionRequestMessage, ActionInvocation actionInvocation) {
        readActionInputArguments(readActionRequestElement(element, actionRequestMessage, actionInvocation), actionInvocation);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void readBodyResponse(Document document, Element element, ActionResponseMessage actionResponseMessage, ActionInvocation actionInvocation) {
        readActionOutputArguments(readActionResponseElement(element, actionInvocation), actionInvocation);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ActionException readFaultElement(Element element) {
        NodeList childNodes = element.getChildNodes();
        boolean z = false;
        String textContent = null;
        String textContent2 = null;
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node nodeItem = childNodes.item(i);
            if (nodeItem.getNodeType() == 1 && getUnprefixedNodeName(nodeItem).equals("Fault")) {
                NodeList childNodes2 = nodeItem.getChildNodes();
                for (int i2 = 0; i2 < childNodes2.getLength(); i2++) {
                    Node nodeItem2 = childNodes2.item(i2);
                    if (nodeItem2.getNodeType() == 1 && getUnprefixedNodeName(nodeItem2).equals("detail")) {
                        NodeList childNodes3 = nodeItem2.getChildNodes();
                        for (int i3 = 0; i3 < childNodes3.getLength(); i3++) {
                            Node nodeItem3 = childNodes3.item(i3);
                            if (nodeItem3.getNodeType() == 1 && getUnprefixedNodeName(nodeItem3).equals("UPnPError")) {
                                NodeList childNodes4 = nodeItem3.getChildNodes();
                                for (int i4 = 0; i4 < childNodes4.getLength(); i4++) {
                                    Node nodeItem4 = childNodes4.item(i4);
                                    if (nodeItem4.getNodeType() == 1) {
                                        if (getUnprefixedNodeName(nodeItem4).equals("errorCode")) {
                                            textContent = XMLUtil.getTextContent(nodeItem4);
                                        }
                                        if (getUnprefixedNodeName(nodeItem4).equals("errorDescription")) {
                                            textContent2 = XMLUtil.getTextContent(nodeItem4);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                z = true;
            }
        }
        if (textContent == null) {
            if (!z) {
                return null;
            }
            zt2.a("Received fault element but no error code");
            return null;
        }
        try {
            int i5 = Integer.parseInt(textContent);
            ErrorCode byCode = ErrorCode.getByCode(i5);
            j02 j02Var = this.logger;
            if (byCode != null) {
                j02Var.i("Reading fault element: {} - {}", Integer.valueOf(byCode.getCode()), textContent2);
                return new ActionException(byCode, textContent2, false);
            }
            j02Var.i("Reading fault element: {} - {}", Integer.valueOf(i5), textContent2);
            return new ActionException(i5, textContent2);
        } catch (NumberFormatException e) {
            cx4.a("Error code was not a number", e);
            return null;
        }
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
    public void writeActionInputArguments(Document document, Element element, ActionInvocation actionInvocation) {
        for (ActionArgument actionArgument : actionInvocation.getAction().getInputArguments()) {
            this.logger.h("Writing action input argument: {}", actionArgument.getName());
            XMLUtil.appendNewElement(document, element, actionArgument.getName(), actionInvocation.getInput(actionArgument) != null ? actionInvocation.getInput(actionArgument).toString() : "");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void writeActionOutputArguments(Document document, Element element, ActionInvocation actionInvocation) {
        for (ActionArgument actionArgument : actionInvocation.getAction().getOutputArguments()) {
            this.logger.h("Writing action output argument: {}", actionArgument.getName());
            XMLUtil.appendNewElement(document, element, actionArgument.getName(), actionInvocation.getOutput(actionArgument) != null ? actionInvocation.getOutput(actionArgument).toString() : "");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Element writeActionRequestElement(Document document, Element element, ActionRequestMessage actionRequestMessage, ActionInvocation actionInvocation) {
        this.logger.h("Writing action request element: {}", actionInvocation.getAction().getName());
        Element elementCreateElementNS = document.createElementNS(actionRequestMessage.getActionNamespace(), "u:" + actionInvocation.getAction().getName());
        element.appendChild(elementCreateElementNS);
        return elementCreateElementNS;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Element writeActionResponseElement(Document document, Element element, ActionResponseMessage actionResponseMessage, ActionInvocation actionInvocation) {
        this.logger.h("Writing action response element: {}", actionInvocation.getAction().getName());
        Element elementCreateElementNS = document.createElementNS(actionResponseMessage.getActionNamespace(), "u:" + actionInvocation.getAction().getName() + "Response");
        element.appendChild(elementCreateElementNS);
        return elementCreateElementNS;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.spi.SOAPActionProcessor
    public void writeBody(ActionResponseMessage actionResponseMessage, ActionInvocation actionInvocation) {
        this.logger.i("Writing body of {} for: {}", actionResponseMessage, actionInvocation);
        try {
            Document documentNewDocument = newDocument();
            Element elementWriteBodyElement = writeBodyElement(documentNewDocument);
            if (actionInvocation.getFailure() != null) {
                writeBodyFailure(documentNewDocument, elementWriteBodyElement, actionResponseMessage, actionInvocation);
            } else {
                writeBodyResponse(documentNewDocument, elementWriteBodyElement, actionResponseMessage, actionInvocation);
            }
            if (this.logger.n()) {
                this.logger.y("===================================== SOAP BODY BEGIN ============================================");
                this.logger.y(actionResponseMessage.getBodyString());
                this.logger.y("-===================================== SOAP BODY END ============================================");
            }
        } catch (Exception e) {
            throw new UnsupportedDataException("Can't transform message payload", e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Element writeBodyElement(Document document) {
        Element elementCreateElementNS = document.createElementNS(Constants.SOAP_NS_ENVELOPE, "s:Envelope");
        Attr attrCreateAttributeNS = document.createAttributeNS(Constants.SOAP_NS_ENVELOPE, "s:encodingStyle");
        attrCreateAttributeNS.setValue(Constants.SOAP_URI_ENCODING_STYLE);
        elementCreateElementNS.setAttributeNode(attrCreateAttributeNS);
        document.appendChild(elementCreateElementNS);
        Element elementCreateElementNS2 = document.createElementNS(Constants.SOAP_NS_ENVELOPE, "s:Body");
        elementCreateElementNS.appendChild(elementCreateElementNS2);
        return elementCreateElementNS2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void writeBodyFailure(Document document, Element element, ActionResponseMessage actionResponseMessage, ActionInvocation actionInvocation) {
        writeFaultElement(document, element, actionInvocation);
        actionResponseMessage.setBody(toString(document));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void writeBodyRequest(Document document, Element element, ActionRequestMessage actionRequestMessage, ActionInvocation actionInvocation) {
        writeActionInputArguments(document, writeActionRequestElement(document, element, actionRequestMessage, actionInvocation), actionInvocation);
        actionRequestMessage.setBody(toString(document));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void writeBodyResponse(Document document, Element element, ActionResponseMessage actionResponseMessage, ActionInvocation actionInvocation) {
        writeActionOutputArguments(document, writeActionResponseElement(document, element, actionResponseMessage, actionInvocation), actionInvocation);
        actionResponseMessage.setBody(toString(document));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void writeFaultElement(Document document, Element element, ActionInvocation actionInvocation) {
        Element elementCreateElementNS = document.createElementNS(Constants.SOAP_NS_ENVELOPE, "s:Fault");
        element.appendChild(elementCreateElementNS);
        XMLUtil.appendNewElement(document, elementCreateElementNS, "faultcode", "s:Client");
        XMLUtil.appendNewElement(document, elementCreateElementNS, "faultstring", "UPnPError");
        Element elementCreateElement = document.createElement("detail");
        elementCreateElementNS.appendChild(elementCreateElement);
        Element elementCreateElementNS2 = document.createElementNS(Constants.NS_UPNP_CONTROL_10, "UPnPError");
        elementCreateElement.appendChild(elementCreateElementNS2);
        int errorCode = actionInvocation.getFailure().getErrorCode();
        String message = actionInvocation.getFailure().getMessage();
        this.logger.i("Writing fault element: {} - {}", Integer.valueOf(errorCode), message);
        XMLUtil.appendNewElement(document, elementCreateElementNS2, "errorCode", Integer.toString(errorCode));
        XMLUtil.appendNewElement(document, elementCreateElementNS2, "errorDescription", message);
    }

    @Override // org.jupnp.transport.spi.SOAPActionProcessor
    public void writeBody(ActionRequestMessage actionRequestMessage, ActionInvocation actionInvocation) {
        this.logger.i("Writing body of {} for: {}", actionRequestMessage, actionInvocation);
        try {
            Document documentNewDocument = newDocument();
            writeBodyRequest(documentNewDocument, writeBodyElement(documentNewDocument), actionRequestMessage, actionInvocation);
            if (this.logger.n()) {
                this.logger.y("===================================== SOAP BODY BEGIN ============================================");
                this.logger.y(actionRequestMessage.getBodyString());
                this.logger.y("-===================================== SOAP BODY END ============================================");
            }
        } catch (Exception e) {
            throw new UnsupportedDataException("Can't transform message payload", e);
        }
    }

    @Override // org.jupnp.transport.spi.SOAPActionProcessor
    public void readBody(ActionRequestMessage actionRequestMessage, ActionInvocation actionInvocation) {
        this.logger.i("Reading body of {} for: {}", actionRequestMessage, actionInvocation);
        if (this.logger.n()) {
            this.logger.y("===================================== SOAP BODY BEGIN ============================================");
            this.logger.y(actionRequestMessage.getBodyString());
            this.logger.y("-===================================== SOAP BODY END ============================================");
        }
        String messageBody = getMessageBody(actionRequestMessage);
        try {
            Document document = readDocument(new InputSource(new StringReader(messageBody)), this);
            readBodyRequest(document, readBodyElement(document), actionRequestMessage, actionInvocation);
        } catch (Exception e) {
            throw new UnsupportedDataException("Can't transform message payload", e, messageBody);
        }
    }
}
