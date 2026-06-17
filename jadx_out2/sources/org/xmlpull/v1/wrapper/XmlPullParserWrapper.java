package org.xmlpull.v1.wrapper;

import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface XmlPullParserWrapper extends XmlPullParser {
    public static final String NO_NAMESPACE = "";
    public static final String XSI_NS = "http://www.w3.org/2001/XMLSchema-instance";

    String getAttributeValue(String str);

    String getPIData();

    String getPITarget();

    String getRequiredAttributeValue(String str);

    String getRequiredAttributeValue(String str, String str2);

    String getRequiredElementText(String str, String str2);

    boolean isNil();

    boolean matches(int i, String str, String str2);

    void nextEndTag();

    void nextEndTag(String str);

    void nextEndTag(String str, String str2);

    void nextStartTag();

    void nextStartTag(String str);

    void nextStartTag(String str, String str2);

    String nextText(String str, String str2);

    double readDouble();

    double readDoubleElement(String str, String str2);

    float readFloat();

    float readFloatElement(String str, String str2);

    int readInt();

    int readIntElement(String str, String str2);

    String readString();

    String readStringElemet(String str, String str2);

    void skipSubTree();
}
