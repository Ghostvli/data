package javax.xml.stream;

import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.util.XMLEventConsumer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface XMLEventWriter extends XMLEventConsumer {
    void add(XMLEventReader xMLEventReader);

    @Override // javax.xml.stream.util.XMLEventConsumer
    void add(XMLEvent xMLEvent);

    void close();

    void flush();

    NamespaceContext getNamespaceContext();

    String getPrefix(String str);

    void setDefaultNamespace(String str);

    void setNamespaceContext(NamespaceContext namespaceContext);

    void setPrefix(String str, String str2);
}
