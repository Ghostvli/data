package javax.xml.stream;

import java.io.OutputStream;
import java.io.Writer;
import javax.xml.transform.Result;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class XMLOutputFactory {
    public static final String IS_REPAIRING_NAMESPACES = "javax.xml.stream.isRepairingNamespaces";

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static XMLOutputFactory newInstance() {
        return (XMLOutputFactory) FactoryFinder.find("javax.xml.stream.XMLOutputFactory", "com.bea.xml.stream.XMLOutputFactoryBase");
    }

    public abstract XMLEventWriter createXMLEventWriter(OutputStream outputStream);

    public abstract XMLEventWriter createXMLEventWriter(OutputStream outputStream, String str);

    public abstract XMLEventWriter createXMLEventWriter(Writer writer);

    public abstract XMLEventWriter createXMLEventWriter(Result result);

    public abstract XMLStreamWriter createXMLStreamWriter(OutputStream outputStream);

    public abstract XMLStreamWriter createXMLStreamWriter(OutputStream outputStream, String str);

    public abstract XMLStreamWriter createXMLStreamWriter(Writer writer);

    public abstract XMLStreamWriter createXMLStreamWriter(Result result);

    public abstract Object getProperty(String str);

    public abstract boolean isPropertySupported(String str);

    public abstract void setProperty(String str, Object obj);

    public static XMLOutputFactory newInstance(String str, ClassLoader classLoader) {
        return (XMLOutputFactory) FactoryFinder.find(str, "com.bea.xml.stream.XMLOutputFactoryBase", classLoader);
    }
}
