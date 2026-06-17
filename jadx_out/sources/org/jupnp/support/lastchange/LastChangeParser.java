package org.jupnp.support.lastchange;

import defpackage.j02;
import defpackage.n02;
import defpackage.zt2;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.xml.parsers.DocumentBuilderFactory;
import org.jupnp.model.XMLUtil;
import org.jupnp.model.types.UnsignedIntegerFourBytes;
import org.jupnp.support.shared.AbstractMap;
import org.jupnp.util.io.IO;
import org.jupnp.xml.DOMParser;
import org.jupnp.xml.SAXParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class LastChangeParser extends SAXParser {
    private final j02 logger = n02.k(LastChangeParser.class);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum CONSTANTS {
        Event,
        InstanceID,
        val;

        public boolean equals(String str) {
            return name().equals(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class InstanceIDHandler extends SAXParser.Handler<InstanceID> {
        public InstanceIDHandler(InstanceID instanceID, SAXParser.Handler<?> handler) {
            super(instanceID, handler);
        }

        @Override // org.jupnp.xml.SAXParser.Handler
        public boolean isLastElement(String str, String str2, String str3) {
            return CONSTANTS.InstanceID.equals(str2);
        }

        @Override // org.jupnp.xml.SAXParser.Handler, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) {
            super.startElement(str, str2, str3, attributes);
            int length = attributes.getLength();
            Map.Entry<String, String>[] entryArr = new Map.Entry[length];
            for (int i = 0; i < length; i++) {
                entryArr[i] = new AbstractMap.SimpleEntry(attributes.getLocalName(i), attributes.getValue(i));
            }
            try {
                EventedValue<?> eventedValueCreateValue = LastChangeParser.this.createValue(str2, entryArr);
                if (eventedValueCreateValue != null) {
                    getInstance().getValues().add(eventedValueCreateValue);
                }
            } catch (Exception e) {
                LastChangeParser.this.logger.u("Error reading event XML, ignoring value", e);
            }
        }
    }

    public Document buildDOM(Event event) {
        DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
        documentBuilderFactoryNewInstance.setNamespaceAware(true);
        Document documentNewDocument = documentBuilderFactoryNewInstance.newDocumentBuilder().newDocument();
        generateRoot(event, documentNewDocument);
        return documentNewDocument;
    }

    public EventedValue<?> createValue(String str, Map.Entry<String, String>[] entryArr) {
        for (Class<? extends EventedValue<?>> cls : getEventedVariables()) {
            if (cls.getSimpleName().equals(str)) {
                return cls.getConstructor(Map.Entry[].class).newInstance(entryArr);
            }
        }
        return null;
    }

    public String generate(Event event) {
        return XMLUtil.documentToFragmentString(buildDOM(event));
    }

    public void generateEventedValue(EventedValue<?> eventedValue, Document document, Element element) {
        String name = eventedValue.getName();
        Map.Entry<String, String>[] attributes = eventedValue.getAttributes();
        if (attributes == null || attributes.length <= 0) {
            return;
        }
        Element elementAppendNewElement = XMLUtil.appendNewElement(document, element, name);
        for (Map.Entry<String, String> entry : attributes) {
            elementAppendNewElement.setAttribute(entry.getKey(), DOMParser.escape(entry.getValue()));
        }
    }

    public void generateInstanceIDs(Event event, Document document, Element element) {
        for (InstanceID instanceID : event.getInstanceIDs()) {
            if (instanceID.getId() != null) {
                Element elementAppendNewElement = XMLUtil.appendNewElement(document, element, CONSTANTS.InstanceID.name());
                elementAppendNewElement.setAttribute(CONSTANTS.val.name(), instanceID.getId().toString());
                Iterator<EventedValue<?>> it = instanceID.getValues().iterator();
                while (it.hasNext()) {
                    generateEventedValue(it.next(), document, elementAppendNewElement);
                }
            }
        }
    }

    public void generateRoot(Event event, Document document) {
        Element elementCreateElementNS = document.createElementNS(getNamespace(), CONSTANTS.Event.name());
        document.appendChild(elementCreateElementNS);
        generateInstanceIDs(event, document, elementCreateElementNS);
    }

    public Set<Class<? extends EventedValue<?>>> getEventedVariables() {
        return Collections.EMPTY_SET;
    }

    public abstract String getNamespace();

    public Event parse(String str) {
        if (str == null || str.isEmpty()) {
            zt2.a("Null or empty XML");
            return null;
        }
        Event event = new Event();
        new RootHandler(event, this);
        if (this.logger.g()) {
            this.logger.b("Parsing 'LastChange' event XML content");
            this.logger.b("===================================== 'LastChange' BEGIN ============================================");
            this.logger.b(str);
            this.logger.b("====================================== 'LastChange' END  ============================================");
        }
        parse(new InputSource(new StringReader(str)));
        this.logger.q("Parsed event with instances IDs: {}", Integer.valueOf(event.getInstanceIDs().size()));
        if (this.logger.n()) {
            for (InstanceID instanceID : event.getInstanceIDs()) {
                this.logger.i("InstanceID '{}' has values: {}", instanceID.getId(), Integer.valueOf(instanceID.getValues().size()));
                for (EventedValue<?> eventedValue : instanceID.getValues()) {
                    this.logger.i("{} => {}", eventedValue.getName(), eventedValue.getValue());
                }
            }
        }
        return event;
    }

    public Event parseResource(String str) throws IOException {
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(str);
        try {
            Event event = parse(IO.readLines(resourceAsStream));
            if (resourceAsStream != null) {
                resourceAsStream.close();
            }
            return event;
        } catch (Throwable th) {
            if (resourceAsStream != null) {
                try {
                    resourceAsStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class RootHandler extends SAXParser.Handler<Event> {
        public RootHandler(Event event, SAXParser sAXParser) {
            super(event, sAXParser);
        }

        @Override // org.jupnp.xml.SAXParser.Handler, org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) {
            String value;
            super.startElement(str, str2, str3, attributes);
            if (!CONSTANTS.InstanceID.equals(str2) || (value = attributes.getValue(CONSTANTS.val.name())) == null) {
                return;
            }
            InstanceID instanceID = new InstanceID(new UnsignedIntegerFourBytes(value));
            getInstance().getInstanceIDs().add(instanceID);
            LastChangeParser.this.new InstanceIDHandler(instanceID, this);
        }

        public RootHandler(Event event) {
            super(event);
        }
    }
}
