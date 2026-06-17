package org.xmlpull.v1.wrapper.classic;

import defpackage.w32;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.util.XmlPullUtil;
import org.xmlpull.v1.wrapper.XmlPullParserWrapper;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class StaticXmlPullParserWrapper extends XmlPullParserDelegate implements XmlPullParserWrapper {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public StaticXmlPullParserWrapper(XmlPullParser xmlPullParser) {
        super(xmlPullParser);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.wrapper.XmlPullParserWrapper
    public String getAttributeValue(String str) {
        return XmlPullUtil.getAttributeValue(this.pp, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.wrapper.XmlPullParserWrapper
    public String getPIData() {
        return XmlPullUtil.getPIData(this.pp);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.wrapper.XmlPullParserWrapper
    public String getPITarget() {
        return XmlPullUtil.getPITarget(this.pp);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.wrapper.XmlPullParserWrapper
    public String getRequiredAttributeValue(String str) {
        return XmlPullUtil.getRequiredAttributeValue(this.pp, null, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.wrapper.XmlPullParserWrapper
    public String getRequiredElementText(String str, String str2) throws XmlPullParserException {
        String strNextText;
        if (str2 == null) {
            throw new XmlPullParserException("name for element can not be null");
        }
        nextStartTag(str, str2);
        if (isNil()) {
            nextEndTag(str, str2);
            strNextText = null;
        } else {
            strNextText = this.pp.nextText();
        }
        this.pp.require(3, str, str2);
        return strNextText;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.wrapper.XmlPullParserWrapper
    public boolean isNil() {
        return "true".equals(this.pp.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.wrapper.XmlPullParserWrapper
    public boolean matches(int i, String str, String str2) {
        return XmlPullUtil.matches(this.pp, i, str, str2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.wrapper.XmlPullParserWrapper
    public void nextEndTag(String str) {
        XmlPullUtil.nextEndTag(this.pp, null, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.wrapper.XmlPullParserWrapper
    public void nextStartTag() throws XmlPullParserException {
        if (this.pp.nextTag() == 2) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer("expected START_TAG and not ");
        stringBuffer.append(this.pp.getPositionDescription());
        throw new XmlPullParserException(stringBuffer.toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.wrapper.XmlPullParserWrapper
    public String nextText(String str, String str2) {
        return XmlPullUtil.nextText(this.pp, str, str2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.wrapper.XmlPullParserWrapper
    public double readDouble() throws XmlPullParserException {
        String strNextText = this.pp.nextText();
        try {
            return Double.parseDouble(strNextText);
        } catch (NumberFormatException e) {
            if (strNextText.equals("INF") || strNextText.toLowerCase().equals("infinity")) {
                return Double.POSITIVE_INFINITY;
            }
            if (strNextText.equals("-INF") || strNextText.toLowerCase().equals("-infinity")) {
                return Double.NEGATIVE_INFINITY;
            }
            if (strNextText.equals("NaN")) {
                return Double.NaN;
            }
            StringBuffer stringBuffer = new StringBuffer("can't parse double value '");
            stringBuffer.append(strNextText);
            stringBuffer.append("'");
            throw new XmlPullParserException(stringBuffer.toString(), this, e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.wrapper.XmlPullParserWrapper
    public double readDoubleElement(String str, String str2) {
        this.pp.require(2, str, str2);
        return readDouble();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.wrapper.XmlPullParserWrapper
    public float readFloat() throws XmlPullParserException {
        String strNextText = this.pp.nextText();
        try {
            return Float.parseFloat(strNextText);
        } catch (NumberFormatException e) {
            if (strNextText.equals("INF") || strNextText.toLowerCase().equals("infinity")) {
                return Float.POSITIVE_INFINITY;
            }
            if (strNextText.equals("-INF") || strNextText.toLowerCase().equals("-infinity")) {
                return Float.NEGATIVE_INFINITY;
            }
            if (strNextText.equals("NaN")) {
                return Float.NaN;
            }
            StringBuffer stringBuffer = new StringBuffer("can't parse float value '");
            stringBuffer.append(strNextText);
            stringBuffer.append("'");
            throw new XmlPullParserException(stringBuffer.toString(), this, e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.wrapper.XmlPullParserWrapper
    public float readFloatElement(String str, String str2) {
        this.pp.require(2, str, str2);
        return readFloat();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.wrapper.XmlPullParserWrapper
    public int readInt() throws XmlPullParserException {
        try {
            return Integer.parseInt(this.pp.nextText());
        } catch (NumberFormatException e) {
            w32.a("can't parse int value", this, e);
            return 0;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.wrapper.XmlPullParserWrapper
    public int readIntElement(String str, String str2) {
        this.pp.require(2, str, str2);
        return readInt();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.wrapper.XmlPullParserWrapper
    public String readString() {
        return this.pp.nextText();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.wrapper.XmlPullParserWrapper
    public String readStringElemet(String str, String str2) {
        this.pp.require(2, str, str2);
        return readString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.wrapper.XmlPullParserWrapper
    public void skipSubTree() {
        XmlPullUtil.skipSubTree(this.pp);
    }

    @Override // org.xmlpull.v1.wrapper.XmlPullParserWrapper
    public void nextEndTag() throws XmlPullParserException {
        XmlPullUtil.nextEndTag(this.pp);
    }

    @Override // org.xmlpull.v1.wrapper.XmlPullParserWrapper
    public String getRequiredAttributeValue(String str, String str2) {
        return XmlPullUtil.getRequiredAttributeValue(this.pp, str, str2);
    }

    @Override // org.xmlpull.v1.wrapper.XmlPullParserWrapper
    public void nextEndTag(String str, String str2) {
        XmlPullUtil.nextEndTag(this.pp, str, str2);
    }

    @Override // org.xmlpull.v1.wrapper.XmlPullParserWrapper
    public void nextStartTag(String str) {
        this.pp.nextTag();
        this.pp.require(2, null, str);
    }

    @Override // org.xmlpull.v1.wrapper.XmlPullParserWrapper
    public void nextStartTag(String str, String str2) {
        this.pp.nextTag();
        this.pp.require(2, str, str2);
    }
}
