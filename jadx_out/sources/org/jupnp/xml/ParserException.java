package org.jupnp.xml;

import org.xml.sax.SAXParseException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ParserException extends Exception {
    public ParserException(SAXParseException sAXParseException) {
        super("(Line/Column: " + sAXParseException.getLineNumber() + ":" + sAXParseException.getColumnNumber() + ") " + sAXParseException.getMessage());
    }

    public ParserException(String str) {
        super(str);
    }

    public ParserException(String str, Throwable th) {
        super(str, th);
    }

    public ParserException(Throwable th) {
        super(th);
    }

    public ParserException() {
    }
}
