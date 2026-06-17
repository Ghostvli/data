package javax.xml.namespace;

import defpackage.jl;
import java.io.Serializable;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class QName implements Serializable {
    private String localPart;
    private String namespaceURI;
    private String prefix;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public QName(String str, String str2, String str3) {
        if (str2 == null) {
            jl.a("Local part not allowed to be null");
            throw null;
        }
        str = str == null ? "" : str;
        str3 = str3 == null ? "" : str3;
        this.namespaceURI = str;
        this.localPart = str2;
        this.prefix = str3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static QName valueOf(String str) {
        if (str == null || str.equals("")) {
            jl.a("invalid QName literal");
            return null;
        }
        if (str.charAt(0) != '{') {
            return new QName(str);
        }
        int iIndexOf = str.indexOf(Token.IF);
        if (iIndexOf == -1) {
            jl.a("invalid QName literal");
            return null;
        }
        if (iIndexOf != str.length() - 1) {
            return new QName(str.substring(1, iIndexOf), str.substring(iIndexOf + 1));
        }
        jl.a("invalid QName literal");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof QName)) {
            return false;
        }
        QName qName = (QName) obj;
        return this.localPart.equals(qName.localPart) && this.namespaceURI.equals(qName.namespaceURI);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getLocalPart() {
        return this.localPart;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getNamespaceURI() {
        return this.namespaceURI;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getPrefix() {
        return this.prefix;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int hashCode() {
        return this.localPart.hashCode() ^ this.namespaceURI.hashCode();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        if (this.namespaceURI.equals("")) {
            return this.localPart;
        }
        StringBuffer stringBuffer = new StringBuffer("{");
        stringBuffer.append(this.namespaceURI);
        stringBuffer.append("}");
        stringBuffer.append(this.localPart);
        return stringBuffer.toString();
    }

    public QName(String str, String str2) {
        this(str, str2, "");
    }

    public QName(String str) {
        this("", str);
    }
}
