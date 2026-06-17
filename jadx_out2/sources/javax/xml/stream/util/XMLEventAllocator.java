package javax.xml.stream.util;

import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface XMLEventAllocator {
    XMLEvent allocate(XMLStreamReader xMLStreamReader);

    void allocate(XMLStreamReader xMLStreamReader, XMLEventConsumer xMLEventConsumer);

    XMLEventAllocator newInstance();
}
