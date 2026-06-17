package javax.xml.stream;

import java.io.InputStream;
import java.io.Reader;
import javax.xml.stream.util.XMLEventAllocator;
import javax.xml.transform.Source;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class XMLInputFactory {
    public static final String ALLOCATOR = "javax.xml.stream.allocator";
    public static final String IS_COALESCING = "javax.xml.stream.isCoalescing";
    public static final String IS_NAMESPACE_AWARE = "javax.xml.stream.isNamespaceAware";
    public static final String IS_REPLACING_ENTITY_REFERENCES = "javax.xml.stream.isReplacingEntityReferences";
    public static final String IS_SUPPORTING_EXTERNAL_ENTITIES = "javax.xml.stream.isSupportingExternalEntities";
    public static final String IS_VALIDATING = "javax.xml.stream.isValidating";
    public static final String REPORTER = "javax.xml.stream.reporter";
    public static final String RESOLVER = "javax.xml.stream.resolver";
    public static final String SUPPORT_DTD = "javax.xml.stream.supportDTD";

    public static XMLInputFactory newInstance() {
        return (XMLInputFactory) FactoryFinder.find("javax.xml.stream.XMLInputFactory", "com.bea.xml.stream.MXParserFactory");
    }

    public abstract XMLEventReader createFilteredReader(XMLEventReader xMLEventReader, EventFilter eventFilter);

    public abstract XMLStreamReader createFilteredReader(XMLStreamReader xMLStreamReader, StreamFilter streamFilter);

    public abstract XMLEventReader createXMLEventReader(InputStream inputStream);

    public abstract XMLEventReader createXMLEventReader(InputStream inputStream, String str);

    public abstract XMLEventReader createXMLEventReader(Reader reader);

    public abstract XMLEventReader createXMLEventReader(String str, InputStream inputStream);

    public abstract XMLEventReader createXMLEventReader(String str, Reader reader);

    public abstract XMLEventReader createXMLEventReader(XMLStreamReader xMLStreamReader);

    public abstract XMLEventReader createXMLEventReader(Source source);

    public abstract XMLStreamReader createXMLStreamReader(InputStream inputStream);

    public abstract XMLStreamReader createXMLStreamReader(InputStream inputStream, String str);

    public abstract XMLStreamReader createXMLStreamReader(Reader reader);

    public abstract XMLStreamReader createXMLStreamReader(String str, InputStream inputStream);

    public abstract XMLStreamReader createXMLStreamReader(String str, Reader reader);

    public abstract XMLStreamReader createXMLStreamReader(Source source);

    public abstract XMLEventAllocator getEventAllocator();

    public abstract Object getProperty(String str);

    public abstract XMLReporter getXMLReporter();

    public abstract XMLResolver getXMLResolver();

    public abstract boolean isPropertySupported(String str);

    public abstract void setEventAllocator(XMLEventAllocator xMLEventAllocator);

    public abstract void setProperty(String str, Object obj);

    public abstract void setXMLReporter(XMLReporter xMLReporter);

    public abstract void setXMLResolver(XMLResolver xMLResolver);

    public static XMLInputFactory newInstance(String str, ClassLoader classLoader) {
        return (XMLInputFactory) FactoryFinder.find(str, "com.bea.xml.stream.MXParserFactory", classLoader);
    }
}
