package javax.xml.stream.util;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.events.XMLEvent;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class EventReaderDelegate implements XMLEventReader {
    private XMLEventReader reader;

    public EventReaderDelegate(XMLEventReader xMLEventReader) {
        this.reader = xMLEventReader;
    }

    @Override // javax.xml.stream.XMLEventReader
    public void close() {
        this.reader.close();
    }

    @Override // javax.xml.stream.XMLEventReader
    public String getElementText() {
        return this.reader.getElementText();
    }

    public XMLEventReader getParent() {
        return this.reader;
    }

    @Override // javax.xml.stream.XMLEventReader
    public Object getProperty(String str) {
        return this.reader.getProperty(str);
    }

    @Override // javax.xml.stream.XMLEventReader, java.util.Iterator
    public boolean hasNext() {
        return this.reader.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        return this.reader.next();
    }

    @Override // javax.xml.stream.XMLEventReader
    public XMLEvent nextEvent() {
        return this.reader.nextEvent();
    }

    @Override // javax.xml.stream.XMLEventReader
    public XMLEvent nextTag() {
        return this.reader.nextTag();
    }

    @Override // javax.xml.stream.XMLEventReader
    public XMLEvent peek() {
        return this.reader.peek();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.reader.remove();
    }

    public void setParent(XMLEventReader xMLEventReader) {
        this.reader = xMLEventReader;
    }

    public EventReaderDelegate() {
    }
}
