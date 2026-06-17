package org.xmlpull.v1;

import java.io.PrintStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class XmlPullParserException extends Exception {
    protected int column;
    protected Throwable detail;
    protected int row;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public XmlPullParserException(String str, XmlPullParser xmlPullParser, Throwable th) {
        String string;
        StringBuffer stringBuffer = new StringBuffer();
        String string2 = "";
        stringBuffer.append(str == null ? "" : str.concat(" "));
        if (xmlPullParser == null) {
            string = "";
        } else {
            StringBuffer stringBuffer2 = new StringBuffer("(position:");
            stringBuffer2.append(xmlPullParser.getPositionDescription());
            stringBuffer2.append(") ");
            string = stringBuffer2.toString();
        }
        stringBuffer.append(string);
        if (th != null) {
            StringBuffer stringBuffer3 = new StringBuffer("caused by: ");
            stringBuffer3.append(th);
            string2 = stringBuffer3.toString();
        }
        stringBuffer.append(string2);
        super(stringBuffer.toString());
        this.row = -1;
        this.column = -1;
        if (xmlPullParser != null) {
            this.row = xmlPullParser.getLineNumber();
            this.column = xmlPullParser.getColumnNumber();
        }
        this.detail = th;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getColumnNumber() {
        return this.column;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Throwable getDetail() {
        return this.detail;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getLineNumber() {
        return this.row;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.Throwable
    public void printStackTrace() {
        if (this.detail == null) {
            super.printStackTrace();
            return;
        }
        synchronized (System.err) {
            PrintStream printStream = System.err;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(super.getMessage());
            stringBuffer.append("; nested exception is:");
            printStream.println(stringBuffer.toString());
            this.detail.printStackTrace();
        }
    }

    public XmlPullParserException(String str) {
        super(str);
        this.row = -1;
        this.column = -1;
    }
}
