package org.xmlpull.v1.wrapper.classic;

import java.io.InputStream;
import java.io.Reader;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class XmlPullParserDelegate implements XmlPullParser {
    protected XmlPullParser pp;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public XmlPullParserDelegate(XmlPullParser xmlPullParser) {
        this.pp = xmlPullParser;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public void defineEntityReplacementText(String str, String str2) {
        this.pp.defineEntityReplacementText(str, str2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public int getAttributeCount() {
        return this.pp.getAttributeCount();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeName(int i) {
        return this.pp.getAttributeName(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeNamespace(int i) {
        return this.pp.getAttributeNamespace(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributePrefix(int i) {
        return this.pp.getAttributePrefix(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeType(int i) {
        return this.pp.getAttributeType(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeValue(int i) {
        return this.pp.getAttributeValue(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public int getColumnNumber() {
        return this.pp.getColumnNumber();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public int getDepth() {
        return this.pp.getDepth();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public int getEventType() {
        return this.pp.getEventType();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public boolean getFeature(String str) {
        return this.pp.getFeature(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public String getInputEncoding() {
        return this.pp.getInputEncoding();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public int getLineNumber() {
        return this.pp.getLineNumber();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public String getName() {
        return this.pp.getName();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespace(String str) {
        return this.pp.getNamespace(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public int getNamespaceCount(int i) {
        return this.pp.getNamespaceCount(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespacePrefix(int i) {
        return this.pp.getNamespacePrefix(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespaceUri(int i) {
        return this.pp.getNamespaceUri(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public String getPositionDescription() {
        return this.pp.getPositionDescription();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public String getPrefix() {
        return this.pp.getPrefix();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public Object getProperty(String str) {
        return this.pp.getProperty(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public String getText() {
        return this.pp.getText();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public char[] getTextCharacters(int[] iArr) {
        return this.pp.getTextCharacters(iArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public boolean isAttributeDefault(int i) {
        return this.pp.isAttributeDefault(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public boolean isEmptyElementTag() {
        return this.pp.isEmptyElementTag();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public boolean isWhitespace() {
        return this.pp.isWhitespace();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public int next() {
        return this.pp.next();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public int nextTag() {
        return this.pp.nextTag();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public String nextText() {
        return this.pp.nextText();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public int nextToken() {
        return this.pp.nextToken();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public void require(int i, String str, String str2) {
        this.pp.require(i, str, str2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public void setFeature(String str, boolean z) {
        this.pp.setFeature(str, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public void setInput(Reader reader) {
        this.pp.setInput(reader);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public void setProperty(String str, Object obj) {
        this.pp.setProperty(str, obj);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void setInput(InputStream inputStream, String str) {
        this.pp.setInput(inputStream, str);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeValue(String str, String str2) {
        return this.pp.getAttributeValue(str, str2);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespace() {
        return this.pp.getNamespace();
    }
}
