package org.jupnp.xml;

import defpackage.j02;
import defpackage.n02;
import defpackage.wg1;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SAXParser {
    public static final URI XML_SCHEMA_NAMESPACE = URI.create("http://www.w3.org/2001/xml.xsd");
    public static final URL XML_SCHEMA_RESOURCE = Thread.currentThread().getContextClassLoader().getResource("org/jupnp/schemas/xml.xsd");
    private final XMLReader xr;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class SimpleErrorHandler implements ErrorHandler {
        @Override // org.xml.sax.ErrorHandler
        public void error(SAXParseException sAXParseException) throws SAXException {
            throw new SAXException(sAXParseException);
        }

        @Override // org.xml.sax.ErrorHandler
        public void fatalError(SAXParseException sAXParseException) throws SAXException {
            throw new SAXException(sAXParseException);
        }

        @Override // org.xml.sax.ErrorHandler
        public void warning(SAXParseException sAXParseException) throws SAXException {
            throw new SAXException(sAXParseException);
        }
    }

    public SAXParser(DefaultHandler defaultHandler) {
        XMLReader xMLReaderCreate = create();
        this.xr = xMLReaderCreate;
        if (defaultHandler != null) {
            xMLReaderCreate.setContentHandler(defaultHandler);
        }
    }

    public XMLReader create() {
        XMLReader xMLReaderCreateXMLReader;
        try {
            if (getSchemaSources() != null) {
                SAXParserFactory sAXParserFactoryNewInstance = SAXParserFactory.newInstance();
                sAXParserFactoryNewInstance.setNamespaceAware(true);
                sAXParserFactoryNewInstance.setSchema(createSchema(getSchemaSources()));
                xMLReaderCreateXMLReader = sAXParserFactoryNewInstance.newSAXParser().getXMLReader();
            } else {
                xMLReaderCreateXMLReader = XMLReaderFactory.createXMLReader();
            }
            xMLReaderCreateXMLReader.setErrorHandler(getErrorHandler());
            return xMLReaderCreateXMLReader;
        } catch (Exception e) {
            wg1.a(e);
            return null;
        }
    }

    public Schema createSchema(Source[] sourceArr) {
        try {
            SchemaFactory schemaFactoryNewInstance = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            schemaFactoryNewInstance.setResourceResolver(new CatalogResourceResolver(new HashMap<URI, URL>() { // from class: org.jupnp.xml.SAXParser.1
                {
                    put(SAXParser.XML_SCHEMA_NAMESPACE, SAXParser.XML_SCHEMA_RESOURCE);
                }
            }));
            return schemaFactoryNewInstance.newSchema(sourceArr);
        } catch (Exception e) {
            wg1.a(e);
            return null;
        }
    }

    public ErrorHandler getErrorHandler() {
        return new SimpleErrorHandler();
    }

    public Source[] getSchemaSources() {
        return null;
    }

    public void parse(InputSource inputSource) {
        try {
            this.xr.parse(inputSource);
        } catch (Exception e) {
            throw new ParserException(e);
        }
    }

    public void setContentHandler(ContentHandler contentHandler) {
        this.xr.setContentHandler(contentHandler);
    }

    public SAXParser() {
        this(null);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Handler<I> extends DefaultHandler {
        protected Attributes attributes;
        protected StringBuilder characters;
        protected I instance;
        private final j02 logger;
        protected Handler parent;
        protected SAXParser parser;

        public Handler(I i, SAXParser sAXParser, Handler handler) {
            this.logger = n02.k(SAXParser.class);
            this.characters = new StringBuilder();
            this.instance = i;
            this.parser = sAXParser;
            this.parent = handler;
            if (sAXParser != null) {
                sAXParser.setContentHandler(this);
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) {
            this.characters.append(cArr, i, i2);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) {
            boolean zIsLastElement = isLastElement(str, str2, str3);
            j02 j02Var = this.logger;
            if (!zIsLastElement) {
                j02Var.i("{} ending: {}", getClass().getSimpleName(), str2);
            } else {
                j02Var.i("{}: last element, switching to parent: {}", getClass().getSimpleName(), str2);
                switchToParent();
            }
        }

        public Attributes getAttributes() {
            return this.attributes;
        }

        public String getCharacters() {
            return this.characters.toString();
        }

        public I getInstance() {
            return this.instance;
        }

        public Handler getParent() {
            return this.parent;
        }

        public SAXParser getParser() {
            return this.parser;
        }

        public boolean isLastElement(String str, String str2, String str3) {
            return false;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) {
            this.characters = new StringBuilder();
            this.attributes = new AttributesImpl(attributes);
            this.logger.i("{} starting: {}", getClass().getSimpleName(), str2);
        }

        public void switchToParent() {
            Handler handler;
            SAXParser sAXParser = this.parser;
            if (sAXParser == null || (handler = this.parent) == null) {
                return;
            }
            sAXParser.setContentHandler(handler);
            this.attributes = null;
        }

        public Handler(I i, SAXParser sAXParser) {
            this(i, sAXParser, null);
        }

        public Handler(I i, Handler handler) {
            this(i, handler.getParser(), handler);
        }

        public Handler(I i) {
            this(i, null, null);
        }
    }
}
