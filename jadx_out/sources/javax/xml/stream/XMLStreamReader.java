package javax.xml.stream;

import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface XMLStreamReader extends XMLStreamConstants {
    void close();

    int getAttributeCount();

    String getAttributeLocalName(int i);

    QName getAttributeName(int i);

    String getAttributeNamespace(int i);

    String getAttributePrefix(int i);

    String getAttributeType(int i);

    String getAttributeValue(int i);

    String getAttributeValue(String str, String str2);

    String getCharacterEncodingScheme();

    String getElementText();

    String getEncoding();

    int getEventType();

    String getLocalName();

    Location getLocation();

    QName getName();

    NamespaceContext getNamespaceContext();

    int getNamespaceCount();

    String getNamespacePrefix(int i);

    String getNamespaceURI();

    String getNamespaceURI(int i);

    String getNamespaceURI(String str);

    String getPIData();

    String getPITarget();

    String getPrefix();

    Object getProperty(String str);

    String getText();

    int getTextCharacters(int i, char[] cArr, int i2, int i3);

    char[] getTextCharacters();

    int getTextLength();

    int getTextStart();

    String getVersion();

    boolean hasName();

    boolean hasNext();

    boolean hasText();

    boolean isAttributeSpecified(int i);

    boolean isCharacters();

    boolean isEndElement();

    boolean isStandalone();

    boolean isStartElement();

    boolean isWhiteSpace();

    int next();

    int nextTag();

    void require(int i, String str, String str2);

    boolean standaloneSet();
}
