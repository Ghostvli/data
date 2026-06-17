package org.xmlpull.v1.wrapper.classic;

import defpackage.jl;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;
import org.xmlpull.v1.wrapper.XmlPullParserWrapper;
import org.xmlpull.v1.wrapper.XmlPullWrapperFactory;
import org.xmlpull.v1.wrapper.XmlSerializerWrapper;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class StaticXmlSerializerWrapper extends XmlSerializerDelegate implements XmlSerializerWrapper {
    private static final String PROPERTY_XMLDECL_STANDALONE = "http://xmlpull.org/v1/doc/features.html#xmldecl-standalone";
    private static final boolean TRACE_SIZING = false;
    protected String currentNs;
    protected XmlPullParserWrapper fragmentParser;
    protected int[] namespaceDepth;
    protected int namespaceEnd;
    protected String[] namespacePrefix;
    protected String[] namespaceUri;
    protected XmlPullWrapperFactory wf;

    public StaticXmlSerializerWrapper(XmlSerializer xmlSerializer, XmlPullWrapperFactory xmlPullWrapperFactory) {
        super(xmlSerializer);
        this.namespaceEnd = 0;
        String[] strArr = new String[8];
        this.namespacePrefix = strArr;
        this.namespaceUri = new String[strArr.length];
        this.namespaceDepth = new int[strArr.length];
        this.wf = xmlPullWrapperFactory;
    }

    private void ensureNamespacesCapacity() {
        int i = this.namespaceEnd;
        int i2 = i > 7 ? i * 2 : 8;
        String[] strArr = new String[i2];
        String[] strArr2 = new String[i2];
        int[] iArr = new int[i2];
        String[] strArr3 = this.namespacePrefix;
        if (strArr3 != null) {
            System.arraycopy(strArr3, 0, strArr, 0, i);
            System.arraycopy(this.namespaceUri, 0, strArr2, 0, this.namespaceEnd);
            System.arraycopy(this.namespaceDepth, 0, iArr, 0, this.namespaceEnd);
        }
        this.namespacePrefix = strArr;
        this.namespaceUri = strArr2;
        this.namespaceDepth = iArr;
    }

    private void writeStartTag(XmlPullParser xmlPullParser) {
        if (!xmlPullParser.getFeature(XmlPullParser.FEATURE_REPORT_NAMESPACE_ATTRIBUTES)) {
            int namespaceCount = xmlPullParser.getNamespaceCount(xmlPullParser.getDepth());
            for (int namespaceCount2 = xmlPullParser.getNamespaceCount(xmlPullParser.getDepth() - 1); namespaceCount2 < namespaceCount; namespaceCount2++) {
                setPrefix(xmlPullParser.getNamespacePrefix(namespaceCount2), xmlPullParser.getNamespaceUri(namespaceCount2));
            }
        }
        startTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            attribute(xmlPullParser.getAttributeNamespace(i), xmlPullParser.getAttributeName(i), xmlPullParser.getAttributeValue(i));
        }
    }

    @Override // org.xmlpull.v1.wrapper.XmlSerializerWrapper
    public XmlSerializerWrapper attribute(String str, String str2) {
        this.xs.attribute(null, str, str2);
        return this;
    }

    @Override // org.xmlpull.v1.wrapper.XmlSerializerWrapper
    public XmlSerializerWrapper element(String str, String str2, String str3) throws XmlPullParserException {
        if (str2 == null) {
            throw new XmlPullParserException("name for element can not be null");
        }
        this.xs.startTag(str, str2);
        XmlSerializer xmlSerializer = this.xs;
        if (str3 == null) {
            xmlSerializer.attribute("http://www.w3.org/2001/XMLSchema-instance", "nil", "true");
        } else {
            xmlSerializer.text(str3);
        }
        this.xs.endTag(str, str2);
        return this;
    }

    @Override // org.xmlpull.v1.wrapper.XmlSerializerWrapper
    public XmlSerializerWrapper endTag(String str) {
        endTag(this.currentNs, str);
        return this;
    }

    @Override // org.xmlpull.v1.wrapper.XmlSerializerWrapper
    public String escapeAttributeValue(String str) {
        int iIndexOf = str.indexOf(60);
        int iIndexOf2 = str.indexOf(38);
        int iIndexOf3 = str.indexOf(34);
        int iIndexOf4 = str.indexOf(39);
        if (iIndexOf == -1 && iIndexOf2 == -1 && iIndexOf3 == -1 && iIndexOf4 == -1) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str.length() + 10);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\"') {
                stringBuffer.append("&quot;");
            } else if (cCharAt == '<') {
                stringBuffer.append("&lt;");
            } else if (cCharAt == '&') {
                stringBuffer.append("&amp;");
            } else if (cCharAt != '\'') {
                stringBuffer.append(cCharAt);
            } else {
                stringBuffer.append("&apos;");
            }
        }
        return stringBuffer.toString();
    }

    @Override // org.xmlpull.v1.wrapper.XmlSerializerWrapper
    public String escapeText(String str) {
        int iIndexOf = str.indexOf(60);
        int iIndexOf2 = str.indexOf(38);
        if (iIndexOf == -1 && iIndexOf2 == -1) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str.length() + 10);
        int i = 0;
        while (true) {
            if (iIndexOf != -1 || iIndexOf2 != -1) {
                if (iIndexOf != -1 && (iIndexOf == -1 || iIndexOf2 == -1 || iIndexOf2 >= iIndexOf)) {
                    if (iIndexOf2 != -1 && (iIndexOf == -1 || iIndexOf2 == -1 || iIndexOf >= iIndexOf2)) {
                        break;
                    }
                    if (i < iIndexOf) {
                        stringBuffer.append(str.substring(i, iIndexOf));
                    }
                    stringBuffer.append("&lt;");
                    i = iIndexOf + 1;
                    iIndexOf = str.indexOf(60, i);
                } else {
                    if (i < iIndexOf2) {
                        stringBuffer.append(str.substring(i, iIndexOf2));
                    }
                    stringBuffer.append("&amp;");
                    i = iIndexOf2 + 1;
                    iIndexOf2 = str.indexOf(38, i);
                }
            } else {
                stringBuffer.append(str.substring(i));
                return stringBuffer.toString();
            }
        }
        StringBuffer stringBuffer2 = new StringBuffer("wrong state posLt=");
        stringBuffer2.append(iIndexOf);
        stringBuffer2.append(" posAmp=");
        stringBuffer2.append(iIndexOf2);
        stringBuffer2.append(" for ");
        stringBuffer2.append(str);
        throw new IllegalStateException(stringBuffer2.toString());
    }

    @Override // org.xmlpull.v1.wrapper.XmlSerializerWrapper
    public void event(XmlPullParser xmlPullParser) {
        switch (xmlPullParser.getEventType()) {
            case 0:
                startDocument(xmlPullParser.getInputEncoding(), (Boolean) xmlPullParser.getProperty(PROPERTY_XMLDECL_STANDALONE));
                break;
            case 1:
                endDocument();
                break;
            case 2:
                writeStartTag(xmlPullParser);
                break;
            case 3:
                endTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                break;
            case 4:
                if (xmlPullParser.getDepth() <= 0) {
                    ignorableWhitespace(xmlPullParser.getText());
                } else {
                    text(xmlPullParser.getText());
                }
                break;
            case 5:
                cdsect(xmlPullParser.getText());
                break;
            case 6:
                entityRef(xmlPullParser.getName());
                break;
            case 7:
                ignorableWhitespace(xmlPullParser.getText());
                break;
            case 8:
                processingInstruction(xmlPullParser.getText());
                break;
            case 9:
                comment(xmlPullParser.getText());
                break;
            case 10:
                docdecl(xmlPullParser.getText());
                break;
        }
    }

    @Override // org.xmlpull.v1.wrapper.XmlSerializerWrapper
    public void fragment(String str) {
        StringBuffer stringBuffer = new StringBuffer(str.length() + (this.namespaceEnd * 30));
        stringBuffer.append("<fragment");
        for (int i = this.namespaceEnd - 1; i >= 0; i--) {
            String str2 = this.namespacePrefix[i];
            int i2 = this.namespaceEnd - 1;
            while (true) {
                if (i2 <= i) {
                    stringBuffer.append(" xmlns");
                    if (str2.length() > 0) {
                        stringBuffer.append(':');
                        stringBuffer.append(str2);
                    }
                    stringBuffer.append("='");
                    stringBuffer.append(escapeAttributeValue(this.namespaceUri[i]));
                    stringBuffer.append("'");
                } else if (str2.equals(this.namespacePrefix[i2])) {
                    break;
                } else {
                    i2--;
                }
            }
        }
        stringBuffer.append(">");
        stringBuffer.append(str);
        stringBuffer.append("</fragment>");
        if (this.fragmentParser == null) {
            this.fragmentParser = this.wf.newPullParserWrapper();
        }
        this.fragmentParser.setInput(new StringReader(stringBuffer.toString()));
        this.fragmentParser.nextTag();
        this.fragmentParser.require(2, null, "fragment");
        while (true) {
            this.fragmentParser.nextToken();
            if (this.fragmentParser.getDepth() == 1 && this.fragmentParser.getEventType() == 3) {
                this.fragmentParser.require(3, null, "fragment");
                return;
            }
            event(this.fragmentParser);
        }
    }

    @Override // org.xmlpull.v1.wrapper.XmlSerializerWrapper
    public String getCurrentNamespaceForElements() {
        return this.currentNs;
    }

    @Override // org.xmlpull.v1.wrapper.XmlSerializerWrapper
    public String setCurrentNamespaceForElements(String str) {
        String str2 = this.currentNs;
        this.currentNs = str;
        return str2;
    }

    @Override // org.xmlpull.v1.wrapper.classic.XmlSerializerDelegate, org.xmlpull.v1.XmlSerializer
    public void setPrefix(String str, String str2) {
        this.xs.setPrefix(str, str2);
        int depth = getDepth();
        for (int i = this.namespaceEnd - 1; i >= 0 && this.namespaceDepth[i] > depth; i--) {
            this.namespaceEnd--;
        }
        if (this.namespaceEnd >= this.namespacePrefix.length) {
            ensureNamespacesCapacity();
        }
        String[] strArr = this.namespacePrefix;
        int i2 = this.namespaceEnd;
        strArr[i2] = str;
        this.namespaceUri[i2] = str2;
        this.namespaceEnd = i2 + 1;
    }

    @Override // org.xmlpull.v1.wrapper.XmlSerializerWrapper
    public XmlSerializerWrapper startTag(String str) {
        this.xs.startTag(this.currentNs, str);
        return this;
    }

    @Override // org.xmlpull.v1.wrapper.XmlSerializerWrapper
    public void wiriteStringElement(String str, String str2, String str3) {
        this.xs.startTag(str, str2);
        writeString(str3);
        this.xs.endTag(str, str2);
    }

    @Override // org.xmlpull.v1.wrapper.XmlSerializerWrapper
    public void writeDouble(double d) {
        if (d == Double.POSITIVE_INFINITY) {
            this.xs.text("INF");
            return;
        }
        XmlSerializer xmlSerializer = this.xs;
        if (d == Double.NEGATIVE_INFINITY) {
            xmlSerializer.text("-INF");
        } else {
            xmlSerializer.text(Double.toString(d));
        }
    }

    @Override // org.xmlpull.v1.wrapper.XmlSerializerWrapper
    public void writeDoubleElement(String str, String str2, double d) {
        this.xs.startTag(str, str2);
        writeDouble(d);
        this.xs.endTag(str, str2);
    }

    @Override // org.xmlpull.v1.wrapper.XmlSerializerWrapper
    public void writeFloat(float f) {
        if (f == Float.POSITIVE_INFINITY) {
            this.xs.text("INF");
            return;
        }
        XmlSerializer xmlSerializer = this.xs;
        if (f == Float.NEGATIVE_INFINITY) {
            xmlSerializer.text("-INF");
        } else {
            xmlSerializer.text(Float.toString(f));
        }
    }

    @Override // org.xmlpull.v1.wrapper.XmlSerializerWrapper
    public void writeFloatElement(String str, String str2, float f) {
        this.xs.startTag(str, str2);
        writeFloat(f);
        this.xs.endTag(str, str2);
    }

    @Override // org.xmlpull.v1.wrapper.XmlSerializerWrapper
    public void writeInt(int i) {
        this.xs.text(Integer.toString(i));
    }

    @Override // org.xmlpull.v1.wrapper.XmlSerializerWrapper
    public void writeIntElement(String str, String str2, int i) {
        this.xs.startTag(str, str2);
        writeInt(i);
        this.xs.endTag(str, str2);
    }

    @Override // org.xmlpull.v1.wrapper.XmlSerializerWrapper
    public void writeString(String str) {
        if (str != null) {
            this.xs.text(str);
        } else {
            jl.a("null string can not be written");
        }
    }

    @Override // org.xmlpull.v1.wrapper.XmlSerializerWrapper
    public XmlSerializerWrapper element(String str, String str2) {
        return element(this.currentNs, str, str2);
    }
}
