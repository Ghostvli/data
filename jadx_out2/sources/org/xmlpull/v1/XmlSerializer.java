package org.xmlpull.v1;

import java.io.OutputStream;
import java.io.Writer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface XmlSerializer {
    XmlSerializer attribute(String str, String str2, String str3);

    void cdsect(String str);

    void comment(String str);

    void docdecl(String str);

    void endDocument();

    XmlSerializer endTag(String str, String str2);

    void entityRef(String str);

    void flush();

    int getDepth();

    boolean getFeature(String str);

    String getName();

    String getNamespace();

    String getPrefix(String str, boolean z);

    Object getProperty(String str);

    void ignorableWhitespace(String str);

    void processingInstruction(String str);

    void setFeature(String str, boolean z);

    void setOutput(OutputStream outputStream, String str);

    void setOutput(Writer writer);

    void setPrefix(String str, String str2);

    void setProperty(String str, Object obj);

    void startDocument(String str, Boolean bool);

    XmlSerializer startTag(String str, String str2);

    XmlSerializer text(String str);

    XmlSerializer text(char[] cArr, int i, int i2);
}
