package org.jupnp.xml;

import defpackage.j02;
import defpackage.j80;
import defpackage.jl;
import defpackage.n02;
import defpackage.wg1;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.jupnp.xml.DOM;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DOMParser<D extends DOM> implements ErrorHandler, EntityResolver {
    public static final URL XML_SCHEMA_RESOURCE = Thread.currentThread().getContextClassLoader().getResource("org/jupnp/schemas/xml.xsd");
    private final j02 logger;
    protected Schema schema;
    protected Source[] schemaSources;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class NodeVisitor {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private short nodeType;

        public NodeVisitor(short s) {
            this.nodeType = s;
        }

        public boolean isHalted() {
            return false;
        }

        public abstract void visit(Node node);
    }

    public DOMParser(Source[] sourceArr) {
        this.logger = n02.k(DOMParser.class);
        this.schemaSources = sourceArr;
    }

    public static void accept(Node node, NodeVisitor nodeVisitor) {
        if (node == null || nodeVisitor.isHalted()) {
            return;
        }
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node nodeItem = childNodes.item(i);
            if (nodeItem.getNodeType() == nodeVisitor.nodeType) {
                nodeVisitor.visit(nodeItem);
                if (nodeVisitor.isHalted()) {
                    return;
                }
            }
            accept(nodeItem, nodeVisitor);
        }
    }

    public static String escape(String str, boolean z, boolean z2) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            String str2 = cCharAt != '\"' ? cCharAt != '&' ? cCharAt != '<' ? cCharAt != '>' ? null : "&#62;" : "&#60;" : "&#38;" : "&#34;";
            if (str2 != null) {
                sb.append(str2);
            } else {
                sb.append(cCharAt);
            }
        }
        String string = sb.toString();
        if (z2) {
            Matcher matcher = Pattern.compile("(\\n+)(\\s*)(.*)").matcher(string);
            StringBuilder sb2 = new StringBuilder();
            while (matcher.find()) {
                String strGroup = matcher.group(2);
                StringBuilder sb3 = new StringBuilder();
                sb3.append(j80.a("&#160;", strGroup.length()));
                matcher.appendReplacement(sb2, "$1" + String.valueOf(sb3) + "$3");
            }
            matcher.appendTail(sb2);
            string = sb2.toString();
        }
        return z ? string.replaceAll("\n", "<br/>") : string;
    }

    public static String stripElements(String str) {
        if (str == null) {
            return null;
        }
        return str.replaceAll("<([a-zA-Z]|/).*?>", "");
    }

    public static String wrap(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder("<");
        sb.append(str);
        if (str2 != null) {
            sb.append(" xmlns=\"");
            sb.append(str2);
            sb.append("\"");
        }
        sb.append(">");
        sb.append(str3);
        sb.append("</");
        sb.append(str);
        sb.append(">");
        return sb.toString();
    }

    public abstract D createDOM(Document document);

    public D createDocument() {
        try {
            return (D) createDOM(createFactory(false).newDocumentBuilder().newDocument());
        } catch (Exception e) {
            wg1.a(e);
            return null;
        }
    }

    public DocumentBuilderFactory createFactory(boolean z) throws ParserException {
        DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
        try {
            documentBuilderFactoryNewInstance.setNamespaceAware(true);
            if (z) {
                documentBuilderFactoryNewInstance.setXIncludeAware(true);
                documentBuilderFactoryNewInstance.setFeature("http://apache.org/xml/features/xinclude/fixup-base-uris", false);
                documentBuilderFactoryNewInstance.setFeature("http://apache.org/xml/features/xinclude/fixup-language", false);
                documentBuilderFactoryNewInstance.setSchema(getSchema());
                documentBuilderFactoryNewInstance.setFeature("http://apache.org/xml/features/validation/dynamic", true);
            }
            return documentBuilderFactoryNewInstance;
        } catch (ParserConfigurationException e) {
            throw new ParserException(e);
        }
    }

    public Transformer createTransformer(String str, int i, boolean z) throws ParserException {
        try {
            TransformerFactory transformerFactoryNewInstance = TransformerFactory.newInstance();
            if (i > 0) {
                try {
                    transformerFactoryNewInstance.setAttribute("indent-number", Integer.valueOf(i));
                } catch (IllegalArgumentException unused) {
                }
            }
            Transformer transformerNewTransformer = transformerFactoryNewInstance.newTransformer();
            transformerNewTransformer.setOutputProperty("omit-xml-declaration", z ? "no" : "yes");
            if (z) {
                try {
                    transformerNewTransformer.setOutputProperty("http://www.oracle.com/xml/is-standalone", "yes");
                } catch (IllegalArgumentException unused2) {
                }
            }
            transformerNewTransformer.setOutputProperty("indent", i > 0 ? "yes" : "no");
            if (i > 0) {
                transformerNewTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", Integer.toString(i));
            }
            transformerNewTransformer.setOutputProperty("method", str);
            return transformerNewTransformer;
        } catch (Exception e) {
            throw new ParserException(e);
        }
    }

    public XPath createXPath(NamespaceContext namespaceContext) {
        XPath xPathNewXPath = createXPathFactory().newXPath();
        xPathNewXPath.setNamespaceContext(namespaceContext);
        return xPathNewXPath;
    }

    public XPathFactory createXPathFactory() {
        return XPathFactory.newInstance();
    }

    @Override // org.xml.sax.ErrorHandler
    public void error(SAXParseException sAXParseException) throws SAXException {
        throw new SAXException(new ParserException(sAXParseException));
    }

    @Override // org.xml.sax.ErrorHandler
    public void fatalError(SAXParseException sAXParseException) throws SAXException {
        throw new SAXException(new ParserException(sAXParseException));
    }

    public Schema getSchema() {
        if (this.schema == null) {
            try {
                SchemaFactory schemaFactoryNewInstance = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
                schemaFactoryNewInstance.setResourceResolver(new CatalogResourceResolver(new HashMap<URI, URL>() { // from class: org.jupnp.xml.DOMParser.1
                    {
                        put(DOM.XML_SCHEMA_NAMESPACE, DOMParser.XML_SCHEMA_RESOURCE);
                    }
                }));
                Source[] sourceArr = this.schemaSources;
                if (sourceArr != null) {
                    this.schema = schemaFactoryNewInstance.newSchema(sourceArr);
                } else {
                    this.schema = schemaFactoryNewInstance.newSchema();
                }
            } catch (Exception e) {
                wg1.a(e);
                return null;
            }
        }
        return this.schema;
    }

    public Object getXPathResult(Node node, XPath xPath, String str, QName qName) {
        try {
            this.logger.h("Evaluating xpath query: {}", str);
            return xPath.evaluate(str, node, qName);
        } catch (Exception e) {
            wg1.a(e);
            return null;
        }
    }

    public boolean isIgnorableWSNode(Node node) {
        return node.getNodeType() == 3 && node.getTextContent().matches("[\\t\\n\\x0B\\f\\r\\s]+");
    }

    public D parse(File file, boolean z) throws ParserException {
        if (file == null) {
            jl.a("Can't parse null file");
            return null;
        }
        try {
            return (D) parse(file.toURI().toURL(), z);
        } catch (Exception e) {
            throw new ParserException("Parsing file failed: ".concat(String.valueOf(file)), e);
        }
    }

    public String print(Source source, int i, boolean z) throws ParserException {
        try {
            Transformer transformerCreateTransformer = createTransformer(XMLConstants.XML_NS_PREFIX, i, z);
            transformerCreateTransformer.setOutputProperty("encoding", "utf-8");
            StringWriter stringWriter = new StringWriter();
            transformerCreateTransformer.transform(source, new StreamResult(stringWriter));
            stringWriter.flush();
            return stringWriter.toString();
        } catch (Exception e) {
            throw new ParserException(e);
        }
    }

    public String printHTML(Document document, int i, boolean z, boolean z2) throws ParserException {
        Document document2 = (Document) document.cloneNode(true);
        accept(document2.getDocumentElement(), new NodeVisitor((short) 4) { // from class: org.jupnp.xml.DOMParser.2
            @Override // org.jupnp.xml.DOMParser.NodeVisitor
            public void visit(Node node) {
                CDATASection cDATASection = (CDATASection) node;
                cDATASection.getParentNode().setTextContent(cDATASection.getData());
            }
        });
        removeIgnorableWSNodes(document2.getDocumentElement());
        try {
            Transformer transformerCreateTransformer = createTransformer("html", i, z);
            if (z2) {
                transformerCreateTransformer.setOutputProperty("doctype-public", "-//W3C//DTD HTML 4.01 Transitional//EN");
                transformerCreateTransformer.setOutputProperty("doctype-system", "http://www.w3.org/TR/html4/loose.dtd");
            }
            StringWriter stringWriter = new StringWriter();
            transformerCreateTransformer.transform(new DOMSource(document2), new StreamResult(stringWriter));
            stringWriter.flush();
            return stringWriter.toString().replaceFirst("\\s*<META http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">", "").replaceFirst("<html xmlns=\"http://www.w3.org/1999/xhtml\">", "<html>");
        } catch (Exception e) {
            throw new ParserException(e);
        }
    }

    public void removeIgnorableWSNodes(Element element) {
        Node firstChild = element.getFirstChild();
        while (firstChild != null) {
            Node nextSibling = firstChild.getNextSibling();
            if (isIgnorableWSNode(firstChild)) {
                element.removeChild(firstChild);
            } else if (firstChild.getNodeType() == 1) {
                removeIgnorableWSNodes((Element) firstChild);
            }
            firstChild = nextSibling;
        }
    }

    @Override // org.xml.sax.EntityResolver
    public InputSource resolveEntity(String str, String str2) {
        InputSource inputSource = str2.startsWith("file://") ? new InputSource(new FileInputStream(new File(URI.create(str2)))) : new InputSource(new ByteArrayInputStream(new byte[0]));
        inputSource.setPublicId(str);
        inputSource.setSystemId(str2);
        return inputSource;
    }

    public ParserException unwrapException(Exception exc) {
        return (exc.getCause() == null || !(exc.getCause() instanceof ParserException)) ? new ParserException(exc) : (ParserException) exc.getCause();
    }

    public void validate(String str) throws ParserException {
        if (str == null) {
            jl.a("Can't validate null string");
        } else {
            this.logger.h("Validating XML string characters: {}", Integer.valueOf(str.length()));
            validate(new SAXSource(new InputSource(new StringReader(str))));
        }
    }

    @Override // org.xml.sax.ErrorHandler
    public void warning(SAXParseException sAXParseException) {
        this.logger.warn(sAXParseException.toString());
    }

    public XPath createXPath(XPathFactory xPathFactory, NamespaceContext namespaceContext) {
        XPath xPathNewXPath = xPathFactory.newXPath();
        xPathNewXPath.setNamespaceContext(namespaceContext);
        return xPathNewXPath;
    }

    public DOMParser() {
        this(null);
    }

    public Object getXPathResult(DOMElement dOMElement, XPath xPath, String str, QName qName) {
        return getXPathResult(dOMElement.getW3CElement(), xPath, str, qName);
    }

    public Object getXPathResult(DOM dom, XPath xPath, String str, QName qName) {
        return getXPathResult(dom.getW3CDocument(), xPath, str, qName);
    }

    public D parse(String str) {
        return (D) parse(str, true);
    }

    public D parse(File file) {
        return (D) parse(file, true);
    }

    public D parse(InputStream inputStream) {
        return (D) parse(inputStream, true);
    }

    public String print(DOM dom, int i) {
        return print(dom, i, true);
    }

    public D parse(URL url, boolean z) throws ParserException {
        if (url != null) {
            try {
                return (D) parse(url.openStream(), z);
            } catch (Exception e) {
                throw new ParserException("Parsing URL failed: ".concat(String.valueOf(url)), e);
            }
        }
        jl.a("Can't parse null URL");
        return null;
    }

    public String print(DOM dom, boolean z) {
        return print(dom, 4, z);
    }

    public void validate(URL url) throws ParserException {
        if (url != null) {
            this.logger.h("Validating XML of URL: {}", url);
            validate(new StreamSource(url.toString()));
        } else {
            jl.a("Can't validate null URL");
        }
    }

    public String print(DOM dom, int i, boolean z) {
        return print(dom.getW3CDocument(), i, z);
    }

    public String print(Document document, int i, boolean z) {
        removeIgnorableWSNodes(document.getDocumentElement());
        return print(new DOMSource(document.getDocumentElement()), i, z);
    }

    public D parse(String str, boolean z) {
        if (str != null) {
            return (D) parse(new InputSource(new StringReader(str)), z);
        }
        jl.a("Can't parse null string");
        return null;
    }

    public void validate(Document document) throws ParserException {
        validate(new DOMSource(document));
    }

    public String print(String str, int i, boolean z) {
        return print(new StreamSource(new StringReader(str)), i, z);
    }

    public void validate(DOM dom) throws ParserException {
        validate(new DOMSource(dom.getW3CDocument()));
    }

    public D parse(URL url) {
        return (D) parse(url, true);
    }

    public String print(DOM dom) {
        return print(dom, 4, true);
    }

    public void validate(Source source) throws ParserException {
        try {
            Validator validatorNewValidator = getSchema().newValidator();
            validatorNewValidator.setErrorHandler(this);
            validatorNewValidator.validate(source);
        } catch (Exception e) {
            throw unwrapException(e);
        }
    }

    public D parse(InputStream inputStream, boolean z) {
        return (D) parse(new InputSource(inputStream), z);
    }

    public static String wrap(String str, String str2) {
        return wrap(str, null, str2);
    }

    public D parse(InputSource inputSource, boolean z) throws ParserException {
        try {
            DocumentBuilder documentBuilderNewDocumentBuilder = createFactory(z).newDocumentBuilder();
            documentBuilderNewDocumentBuilder.setEntityResolver(this);
            documentBuilderNewDocumentBuilder.setErrorHandler(this);
            Document document = documentBuilderNewDocumentBuilder.parse(inputSource);
            document.normalizeDocument();
            return (D) createDOM(document);
        } catch (Exception e) {
            throw this.unwrapException(e);
        }
    }

    public String printHTML(Document document) {
        return printHTML(document, 4, true, true);
    }

    public static String escape(String str) {
        return escape(str, false, false);
    }
}
