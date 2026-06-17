package org.xmlpull.v1.wrapper;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface XmlSerializerWrapper extends XmlSerializer {
    public static final String NO_NAMESPACE = "";
    public static final String XSI_NS = "http://www.w3.org/2001/XMLSchema-instance";

    XmlSerializerWrapper attribute(String str, String str2);

    XmlSerializerWrapper element(String str, String str2);

    XmlSerializerWrapper element(String str, String str2, String str3);

    XmlSerializerWrapper endTag(String str);

    String escapeAttributeValue(String str);

    String escapeText(String str);

    void event(XmlPullParser xmlPullParser);

    void fragment(String str);

    String getCurrentNamespaceForElements();

    String setCurrentNamespaceForElements(String str);

    XmlSerializerWrapper startTag(String str);

    void wiriteStringElement(String str, String str2, String str3);

    void writeDouble(double d);

    void writeDoubleElement(String str, String str2, double d);

    void writeFloat(float f);

    void writeFloatElement(String str, String str2, float f);

    void writeInt(int i);

    void writeIntElement(String str, String str2, int i);

    void writeString(String str);
}
