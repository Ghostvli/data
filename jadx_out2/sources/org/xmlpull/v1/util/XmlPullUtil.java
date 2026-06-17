package org.xmlpull.v1.util;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class XmlPullUtil {
    public static final String XSI_NS = "http://www.w3.org/2001/XMLSchema-instance";

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private XmlPullUtil() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String getAttributeValue(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("", str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String getPIData(XmlPullParser xmlPullParser) {
        try {
            int eventType = xmlPullParser.getEventType();
            if (eventType != 8) {
                StringBuffer stringBuffer = new StringBuffer("parser must be on processing instruction and not ");
                stringBuffer.append(XmlPullParser.TYPES[eventType]);
                stringBuffer.append(xmlPullParser.getPositionDescription());
                throw new IllegalStateException(stringBuffer.toString());
            }
            String text = xmlPullParser.getText();
            int i = -1;
            for (int i2 = 0; i2 < text.length(); i2++) {
                if (isS(text.charAt(i2))) {
                    i = i2;
                } else if (i > 0) {
                    return text.substring(i2);
                }
            }
            return "";
        } catch (XmlPullParserException e) {
            StringBuffer stringBuffer2 = new StringBuffer("could not determine parser state: ");
            stringBuffer2.append(e);
            stringBuffer2.append(xmlPullParser.getPositionDescription());
            throw new IllegalStateException(stringBuffer2.toString());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String getPITarget(XmlPullParser xmlPullParser) {
        try {
            int eventType = xmlPullParser.getEventType();
            if (eventType != 8) {
                StringBuffer stringBuffer = new StringBuffer("parser must be on processing instruction and not ");
                stringBuffer.append(XmlPullParser.TYPES[eventType]);
                stringBuffer.append(xmlPullParser.getPositionDescription());
                throw new IllegalStateException(stringBuffer.toString());
            }
            String text = xmlPullParser.getText();
            for (int i = 0; i < text.length(); i++) {
                if (isS(text.charAt(i))) {
                    return text.substring(0, i);
                }
            }
            return text;
        } catch (XmlPullParserException e) {
            StringBuffer stringBuffer2 = new StringBuffer("could not determine parser state: ");
            stringBuffer2.append(e);
            stringBuffer2.append(xmlPullParser.getPositionDescription());
            throw new IllegalStateException(stringBuffer2.toString());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String getRequiredAttributeValue(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException {
        String attributeValue = xmlPullParser.getAttributeValue(str, str2);
        if (attributeValue != null) {
            return attributeValue;
        }
        StringBuffer stringBuffer = new StringBuffer("required attribute ");
        stringBuffer.append(str2);
        stringBuffer.append(" is not present");
        throw new XmlPullParserException(stringBuffer.toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean isS(char c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t';
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean matches(XmlPullParser xmlPullParser, int i, String str, String str2) {
        if (i != xmlPullParser.getEventType()) {
            return false;
        }
        if (str == null || str.equals(xmlPullParser.getNamespace())) {
            return str2 == null || str2.equals(xmlPullParser.getName());
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void nextEndTag(XmlPullParser xmlPullParser) throws XmlPullParserException {
        if (xmlPullParser.nextTag() == 3) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer("expected END_TAG and not");
        stringBuffer.append(xmlPullParser.getPositionDescription());
        throw new XmlPullParserException(stringBuffer.toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void nextStartTag(XmlPullParser xmlPullParser) throws XmlPullParserException {
        if (xmlPullParser.nextTag() == 2) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer("expected START_TAG and not ");
        stringBuffer.append(xmlPullParser.getPositionDescription());
        throw new XmlPullParserException(stringBuffer.toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String nextText(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException {
        if (str2 == null) {
            throw new XmlPullParserException("name for element can not be null");
        }
        xmlPullParser.require(2, str, str2);
        return xmlPullParser.nextText();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void skipSubTree(XmlPullParser xmlPullParser) {
        xmlPullParser.require(2, null, null);
        int i = 1;
        while (i > 0) {
            int next = xmlPullParser.next();
            if (next == 3) {
                i--;
            } else if (next == 2) {
                i++;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void writeSimpleElement(XmlSerializer xmlSerializer, String str, String str2, String str3) throws XmlPullParserException {
        if (str2 == null) {
            throw new XmlPullParserException("name for element can not be null");
        }
        xmlSerializer.startTag(str, str2);
        if (str3 == null) {
            xmlSerializer.attribute("http://www.w3.org/2001/XMLSchema-instance", "nil", "true");
        } else {
            xmlSerializer.text(str3);
        }
        xmlSerializer.endTag(str, str2);
    }

    public static void nextEndTag(XmlPullParser xmlPullParser, String str, String str2) {
        xmlPullParser.nextTag();
        xmlPullParser.require(3, str, str2);
    }

    public static void nextStartTag(XmlPullParser xmlPullParser, String str) {
        xmlPullParser.nextTag();
        xmlPullParser.require(2, null, str);
    }

    public static void nextStartTag(XmlPullParser xmlPullParser, String str, String str2) {
        xmlPullParser.nextTag();
        xmlPullParser.require(2, str, str2);
    }
}
