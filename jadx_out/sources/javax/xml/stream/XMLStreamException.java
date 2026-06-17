package javax.xml.stream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class XMLStreamException extends Exception {
    protected Location location;
    protected Throwable nested;

    public XMLStreamException(String str, Location location, Throwable th) {
        StringBuffer stringBuffer = new StringBuffer("ParseError at [row,col]:[");
        stringBuffer.append(location.getLineNumber());
        stringBuffer.append(",");
        stringBuffer.append(location.getColumnNumber());
        stringBuffer.append("]\nMessage: ");
        stringBuffer.append(str);
        super(stringBuffer.toString());
        this.nested = th;
        this.location = location;
    }

    public Location getLocation() {
        return this.location;
    }

    public Throwable getNestedException() {
        return this.nested;
    }

    public XMLStreamException(String str) {
        super(str);
    }

    public XMLStreamException(Throwable th) {
        this.nested = th;
    }

    public XMLStreamException(String str, Throwable th) {
        super(str);
        this.nested = th;
    }

    public XMLStreamException() {
    }

    public XMLStreamException(String str, Location location) {
        StringBuffer stringBuffer = new StringBuffer("ParseError at [row,col]:[");
        stringBuffer.append(location.getLineNumber());
        stringBuffer.append(",");
        stringBuffer.append(location.getColumnNumber());
        stringBuffer.append("]\nMessage: ");
        stringBuffer.append(str);
        super(stringBuffer.toString());
        this.location = location;
    }
}
