package org.xmlpull.mxp1;

import com.hierynomus.protocol.commons.buffer.Buffer;
import com.thegrizzlylabs.sardineandroid.util.SardineUtil;
import defpackage.jl;
import defpackage.w32;
import defpackage.x32;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import javax.xml.XMLConstants;
import okhttp3.internal.http2.Http2;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class MXParser implements XmlPullParser {
    protected static final String FEATURE_NAMES_INTERNED = "http://xmlpull.org/v1/doc/features.html#names-interned";
    protected static final String FEATURE_XML_ROUNDTRIP = "http://xmlpull.org/v1/doc/features.html#xml-roundtrip";
    protected static final int LOOKUP_MAX = 1024;
    protected static final char LOOKUP_MAX_CHAR = 1024;
    protected static final String PROPERTY_XMLDECL_CONTENT = "http://xmlpull.org/v1/doc/properties.html#xmldecl-content";
    protected static final String PROPERTY_XMLDECL_STANDALONE = "http://xmlpull.org/v1/doc/properties.html#xmldecl-standalone";
    protected static final String PROPERTY_XMLDECL_VERSION = "http://xmlpull.org/v1/doc/properties.html#xmldecl-version";
    protected static final int READ_CHUNK_SIZE = 8192;
    private static final boolean TRACE_SIZING = false;
    protected static final String XMLNS_URI = "http://www.w3.org/2000/xmlns/";
    protected static final String XML_URI = "http://www.w3.org/XML/1998/namespace";
    protected boolean allStringsInterned;
    protected int attributeCount;
    protected String[] attributeName;
    protected int[] attributeNameHash;
    protected String[] attributePrefix;
    protected String[] attributeUri;
    protected String[] attributeValue;
    protected char[] buf;
    protected int bufAbsoluteStart;
    protected int bufEnd;
    protected int bufLoadFactor = 95;
    protected int bufSoftLimit;
    protected int bufStart;
    protected char[] charRefOneCharBuf;
    protected int columnNumber;
    protected int depth;
    protected String[] elName;
    protected int[] elNamespaceCount;
    protected String[] elPrefix;
    protected char[][] elRawName;
    protected int[] elRawNameEnd;
    protected int[] elRawNameLine;
    protected String[] elUri;
    protected boolean emptyElementTag;
    protected int entityEnd;
    protected String[] entityName;
    protected char[][] entityNameBuf;
    protected int[] entityNameHash;
    protected String entityRefName;
    protected String[] entityReplacement;
    protected char[][] entityReplacementBuf;
    protected int eventType;
    protected String inputEncoding;
    protected int lineNumber;
    protected int namespaceEnd;
    protected String[] namespacePrefix;
    protected int[] namespacePrefixHash;
    protected String[] namespaceUri;
    protected boolean pastEndTag;
    protected char[] pc;
    protected int pcEnd;
    protected int pcStart;
    protected int pos;
    protected int posEnd;
    protected int posStart;
    protected boolean preventBufferCompaction;
    protected boolean processNamespaces;
    protected boolean reachedEnd;
    protected Reader reader;
    protected boolean roundtripSupported;
    protected boolean seenAmpersand;
    protected boolean seenDocdecl;
    protected boolean seenEndTag;
    protected boolean seenMarkup;
    protected boolean seenRoot;
    protected boolean seenStartTag;
    protected String text;
    protected boolean tokenize;
    protected boolean usePC;
    protected String xmlDeclContent;
    protected Boolean xmlDeclStandalone;
    protected String xmlDeclVersion;
    protected static final char[] VERSION = {'v', 'e', 'r', 's', 'i', 'o', 'n'};
    protected static final char[] NCODING = {'n', 'c', 'o', 'd', 'i', 'n', 'g'};
    protected static final char[] TANDALONE = {'t', 'a', 'n', 'd', 'a', 'l', 'o', 'n', 'e'};
    protected static final char[] YES = {'y', 'e', 's'};
    protected static final char[] NO = {'n', 'o'};
    protected static boolean[] lookupNameStartChar = new boolean[1024];
    protected static boolean[] lookupNameChar = new boolean[1024];

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        setNameStart(':');
        for (char c = 'A'; c <= 'Z'; c = (char) (c + 1)) {
            setNameStart(c);
        }
        setNameStart('_');
        for (char c2 = 'a'; c2 <= 'z'; c2 = (char) (c2 + 1)) {
            setNameStart(c2);
        }
        for (char c3 = 192; c3 <= 767; c3 = (char) (c3 + 1)) {
            setNameStart(c3);
        }
        for (char c4 = 880; c4 <= 893; c4 = (char) (c4 + 1)) {
            setNameStart(c4);
        }
        for (char c5 = 895; c5 < 1024; c5 = (char) (c5 + 1)) {
            setNameStart(c5);
        }
        setName('-');
        setName('.');
        for (char c6 = '0'; c6 <= '9'; c6 = (char) (c6 + 1)) {
            setName(c6);
        }
        setName((char) 183);
        for (char c7 = 768; c7 <= 879; c7 = (char) (c7 + 1)) {
            setName(c7);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public MXParser() {
        char[] cArr = new char[Runtime.getRuntime().freeMemory() > 1000000 ? 8192 : Buffer.DEFAULT_SIZE];
        this.buf = cArr;
        this.bufSoftLimit = (this.bufLoadFactor * cArr.length) / 100;
        this.pc = new char[Runtime.getRuntime().freeMemory() <= 1000000 ? 64 : 8192];
        this.charRefOneCharBuf = new char[1];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final int fastHash(char[] cArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = (cArr[i] << 7) + cArr[(i + i2) - 1];
        if (i2 > 16) {
            i3 = (i3 << 7) + cArr[(i2 / 4) + i];
        }
        return i2 > 8 ? (i3 << 7) + cArr[i + (i2 / 2)] : i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int findFragment(int i, char[] cArr, int i2, int i3) {
        if (i2 < i) {
            return i > i3 ? i3 : i;
        }
        if (i3 - i2 > 65) {
            i2 = i3 - 10;
        }
        int i4 = i2 + 1;
        while (true) {
            i4--;
            if (i4 <= i || i3 - i4 > 65 || (cArr[i4] == '<' && i2 - i4 > 10)) {
                break;
            }
        }
        return i4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static final void setName(char c) {
        lookupNameChar[c] = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static final void setNameStart(char c) {
        lookupNameStartChar[c] = true;
        setName(c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public void defineEntityReplacementText(String str, String str2) {
        ensureEntityCapacity();
        this.entityName[this.entityEnd] = newString(str.toCharArray(), 0, str.length());
        this.entityNameBuf[this.entityEnd] = str.toCharArray();
        String[] strArr = this.entityReplacement;
        int i = this.entityEnd;
        strArr[i] = str2;
        this.entityReplacementBuf[i] = str2.toCharArray();
        if (!this.allStringsInterned) {
            int[] iArr = this.entityNameHash;
            int i2 = this.entityEnd;
            char[] cArr = this.entityNameBuf[i2];
            iArr[i2] = fastHash(cArr, 0, cArr.length);
        }
        this.entityEnd++;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void ensureAttributesCapacity(int i) {
        String[] strArr = this.attributeName;
        int length = strArr != null ? strArr.length : 0;
        if (i >= length) {
            int i2 = i > 7 ? i * 2 : 8;
            boolean z = length > 0;
            String[] strArr2 = new String[i2];
            if (z) {
                System.arraycopy(strArr, 0, strArr2, 0, length);
            }
            this.attributeName = strArr2;
            String[] strArr3 = new String[i2];
            if (z) {
                System.arraycopy(this.attributePrefix, 0, strArr3, 0, length);
            }
            this.attributePrefix = strArr3;
            String[] strArr4 = new String[i2];
            if (z) {
                System.arraycopy(this.attributeUri, 0, strArr4, 0, length);
            }
            this.attributeUri = strArr4;
            String[] strArr5 = new String[i2];
            if (z) {
                System.arraycopy(this.attributeValue, 0, strArr5, 0, length);
            }
            this.attributeValue = strArr5;
            if (this.allStringsInterned) {
                return;
            }
            int[] iArr = new int[i2];
            if (z) {
                System.arraycopy(this.attributeNameHash, 0, iArr, 0, length);
            }
            this.attributeNameHash = iArr;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void ensureElementsCapacity() {
        String[] strArr = this.elName;
        int length = strArr != null ? strArr.length : 0;
        int i = this.depth;
        if (i + 1 >= length) {
            int i2 = (i >= 7 ? i * 2 : 8) + 2;
            boolean z = length > 0;
            String[] strArr2 = new String[i2];
            if (z) {
                System.arraycopy(strArr, 0, strArr2, 0, length);
            }
            this.elName = strArr2;
            String[] strArr3 = new String[i2];
            if (z) {
                System.arraycopy(this.elPrefix, 0, strArr3, 0, length);
            }
            this.elPrefix = strArr3;
            String[] strArr4 = new String[i2];
            if (z) {
                System.arraycopy(this.elUri, 0, strArr4, 0, length);
            }
            this.elUri = strArr4;
            int[] iArr = new int[i2];
            if (z) {
                System.arraycopy(this.elNamespaceCount, 0, iArr, 0, length);
            } else {
                iArr[0] = 0;
            }
            this.elNamespaceCount = iArr;
            int[] iArr2 = new int[i2];
            if (z) {
                System.arraycopy(this.elRawNameEnd, 0, iArr2, 0, length);
            }
            this.elRawNameEnd = iArr2;
            int[] iArr3 = new int[i2];
            if (z) {
                System.arraycopy(this.elRawNameLine, 0, iArr3, 0, length);
            }
            this.elRawNameLine = iArr3;
            char[][] cArr = new char[i2][];
            if (z) {
                System.arraycopy(this.elRawName, 0, cArr, 0, length);
            }
            this.elRawName = cArr;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void ensureEntityCapacity() {
        char[][] cArr = this.entityReplacementBuf;
        int length = cArr != null ? cArr.length : 0;
        int i = this.entityEnd;
        if (i >= length) {
            int i2 = i > 7 ? i * 2 : 8;
            String[] strArr = new String[i2];
            char[][] cArr2 = new char[i2][];
            String[] strArr2 = new String[i2];
            char[][] cArr3 = new char[i2][];
            String[] strArr3 = this.entityName;
            if (strArr3 != null) {
                System.arraycopy(strArr3, 0, strArr, 0, i);
                System.arraycopy(this.entityReplacementBuf, 0, strArr2, 0, this.entityEnd);
                System.arraycopy(this.entityReplacement, 0, strArr2, 0, this.entityEnd);
                System.arraycopy(this.entityReplacementBuf, 0, cArr3, 0, this.entityEnd);
            }
            this.entityName = strArr;
            this.entityNameBuf = cArr2;
            this.entityReplacement = strArr2;
            this.entityReplacementBuf = cArr3;
            if (this.allStringsInterned) {
                return;
            }
            int[] iArr = new int[i2];
            int[] iArr2 = this.entityNameHash;
            if (iArr2 != null) {
                System.arraycopy(iArr2, 0, iArr, 0, this.entityEnd);
            }
            this.entityNameHash = iArr;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void ensureNamespacesCapacity(int i) {
        String[] strArr = this.namespacePrefix;
        if (i >= (strArr != null ? strArr.length : 0)) {
            int i2 = i > 7 ? i * 2 : 8;
            String[] strArr2 = new String[i2];
            String[] strArr3 = new String[i2];
            if (strArr != null) {
                System.arraycopy(strArr, 0, strArr2, 0, this.namespaceEnd);
                System.arraycopy(this.namespaceUri, 0, strArr3, 0, this.namespaceEnd);
            }
            this.namespacePrefix = strArr2;
            this.namespaceUri = strArr3;
            if (this.allStringsInterned) {
                return;
            }
            int[] iArr = new int[i2];
            int[] iArr2 = this.namespacePrefixHash;
            if (iArr2 != null) {
                System.arraycopy(iArr2, 0, iArr, 0, this.namespaceEnd);
            }
            this.namespacePrefixHash = iArr;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void ensurePC(int i) {
        char[] cArr = new char[i > 8192 ? i * 2 : Http2.INITIAL_MAX_FRAME_SIZE];
        System.arraycopy(this.pc, 0, cArr, 0, this.pcEnd);
        this.pc = cArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void fillBuf() throws XmlPullParserException, IOException {
        boolean z;
        if (this.reader == null) {
            throw new XmlPullParserException("reader must be set before parsing is started");
        }
        int i = this.bufEnd;
        int i2 = this.bufSoftLimit;
        if (i > i2) {
            int i3 = this.bufStart;
            boolean z2 = i3 > i2;
            if (this.preventBufferCompaction) {
                z = true;
                z2 = false;
            } else if (z2) {
                z = false;
            } else if (i3 < this.buf.length / 2) {
                z = true;
            } else {
                z2 = true;
                z = false;
            }
            if (z2) {
                char[] cArr = this.buf;
                System.arraycopy(cArr, i3, cArr, 0, i - i3);
            } else {
                if (!z) {
                    throw new XmlPullParserException("internal error in fillBuffer()");
                }
                char[] cArr2 = this.buf;
                char[] cArr3 = new char[cArr2.length * 2];
                System.arraycopy(cArr2, i3, cArr3, 0, i - i3);
                this.buf = cArr3;
                int i4 = this.bufLoadFactor;
                if (i4 > 0) {
                    this.bufSoftLimit = (i4 * cArr3.length) / 100;
                }
            }
            int i5 = this.bufEnd;
            int i6 = this.bufStart;
            this.bufEnd = i5 - i6;
            this.pos -= i6;
            this.posStart -= i6;
            this.posEnd -= i6;
            this.bufAbsoluteStart += i6;
            this.bufStart = 0;
        }
        char[] cArr4 = this.buf;
        int length = cArr4.length;
        int i7 = this.bufEnd;
        int i8 = this.reader.read(cArr4, i7, length - i7 <= 8192 ? cArr4.length - i7 : 8192);
        if (i8 > 0) {
            this.bufEnd += i8;
            return;
        }
        if (i8 != -1) {
            StringBuffer stringBuffer = new StringBuffer("error reading input, returned ");
            stringBuffer.append(i8);
            throw new IOException(stringBuffer.toString());
        }
        if (this.bufAbsoluteStart == 0 && this.pos == 0) {
            throw new EOFException("input contained no data");
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        if (this.depth > 0) {
            stringBuffer2.append(" - expected end tag");
            if (this.depth > 1) {
                stringBuffer2.append(SardineUtil.CUSTOM_NAMESPACE_PREFIX);
            }
            stringBuffer2.append(" ");
            for (int i9 = this.depth; i9 > 0; i9--) {
                String str = new String(this.elRawName[i9], 0, this.elRawNameEnd[i9]);
                stringBuffer2.append("</");
                stringBuffer2.append(str);
                stringBuffer2.append('>');
            }
            stringBuffer2.append(" to close");
            for (int i10 = this.depth; i10 > 0; i10--) {
                if (i10 != this.depth) {
                    stringBuffer2.append(" and");
                }
                String str2 = new String(this.elRawName[i10], 0, this.elRawNameEnd[i10]);
                StringBuffer stringBuffer3 = new StringBuffer(" start tag <");
                stringBuffer3.append(str2);
                stringBuffer3.append(">");
                stringBuffer2.append(stringBuffer3.toString());
                StringBuffer stringBuffer4 = new StringBuffer(" from line ");
                stringBuffer4.append(this.elRawNameLine[i10]);
                stringBuffer2.append(stringBuffer4.toString());
            }
            stringBuffer2.append(", parser stopped on");
        }
        StringBuffer stringBuffer5 = new StringBuffer("no more data available");
        stringBuffer5.append(stringBuffer2.toString());
        stringBuffer5.append(getPositionDescription());
        throw new EOFException(stringBuffer5.toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public int getAttributeCount() {
        if (this.eventType != 2) {
            return -1;
        }
        return this.attributeCount;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeName(int i) {
        if (this.eventType != 2) {
            x32.a("only START_TAG can have attributes");
            return null;
        }
        if (i >= 0 && i < this.attributeCount) {
            return this.attributeName[i];
        }
        StringBuffer stringBuffer = new StringBuffer("attribute position must be 0..");
        stringBuffer.append(this.attributeCount - 1);
        stringBuffer.append(" and not ");
        stringBuffer.append(i);
        throw new IndexOutOfBoundsException(stringBuffer.toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeNamespace(int i) {
        if (this.eventType != 2) {
            x32.a("only START_TAG can have attributes");
            return null;
        }
        if (!this.processNamespaces) {
            return "";
        }
        if (i >= 0 && i < this.attributeCount) {
            return this.attributeUri[i];
        }
        StringBuffer stringBuffer = new StringBuffer("attribute position must be 0..");
        stringBuffer.append(this.attributeCount - 1);
        stringBuffer.append(" and not ");
        stringBuffer.append(i);
        throw new IndexOutOfBoundsException(stringBuffer.toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributePrefix(int i) {
        if (this.eventType != 2) {
            x32.a("only START_TAG can have attributes");
            return null;
        }
        if (!this.processNamespaces) {
            return null;
        }
        if (i >= 0 && i < this.attributeCount) {
            return this.attributePrefix[i];
        }
        StringBuffer stringBuffer = new StringBuffer("attribute position must be 0..");
        stringBuffer.append(this.attributeCount - 1);
        stringBuffer.append(" and not ");
        stringBuffer.append(i);
        throw new IndexOutOfBoundsException(stringBuffer.toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeType(int i) {
        if (this.eventType != 2) {
            x32.a("only START_TAG can have attributes");
            return null;
        }
        if (i >= 0 && i < this.attributeCount) {
            return "CDATA";
        }
        StringBuffer stringBuffer = new StringBuffer("attribute position must be 0..");
        stringBuffer.append(this.attributeCount - 1);
        stringBuffer.append(" and not ");
        stringBuffer.append(i);
        throw new IndexOutOfBoundsException(stringBuffer.toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeValue(String str, String str2) {
        if (this.eventType != 2) {
            StringBuffer stringBuffer = new StringBuffer("only START_TAG can have attributes");
            stringBuffer.append(getPositionDescription());
            throw new IndexOutOfBoundsException(stringBuffer.toString());
        }
        if (str2 == null) {
            jl.a("attribute name can not be null");
            return null;
        }
        int i = 0;
        if (this.processNamespaces) {
            if (str == null) {
                str = "";
            }
            String str3 = str;
            while (i < this.attributeCount) {
                String str4 = this.attributeUri[i];
                if ((str3 == str4 || str3.equals(str4)) && str2.equals(this.attributeName[i])) {
                    return this.attributeValue[i];
                }
                i++;
            }
        } else {
            if (str != null && str.length() == 0) {
                str = null;
            }
            if (str != null) {
                jl.a("when namespaces processing is disabled attribute namespace must be null");
                return null;
            }
            while (i < this.attributeCount) {
                if (str2.equals(this.attributeName[i])) {
                    return this.attributeValue[i];
                }
                i++;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public int getColumnNumber() {
        return this.columnNumber;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public int getDepth() {
        return this.depth;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public int getEventType() {
        return this.eventType;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public boolean getFeature(String str) {
        if (str == null) {
            jl.a("feature name should not be nulll");
            return false;
        }
        if (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(str)) {
            return this.processNamespaces;
        }
        if (FEATURE_NAMES_INTERNED.equals(str) || XmlPullParser.FEATURE_PROCESS_DOCDECL.equals(str) || !FEATURE_XML_ROUNDTRIP.equals(str)) {
            return false;
        }
        return this.roundtripSupported;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public String getInputEncoding() {
        return this.inputEncoding;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public int getLineNumber() {
        return this.lineNumber;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public String getName() {
        int i = this.eventType;
        if (i == 2) {
            return this.elName[this.depth];
        }
        if (i == 3) {
            return this.elName[this.depth];
        }
        if (i != 6) {
            return null;
        }
        if (this.entityRefName == null) {
            char[] cArr = this.buf;
            int i2 = this.posStart;
            this.entityRefName = newString(cArr, i2, this.posEnd - i2);
        }
        return this.entityRefName;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespace(String str) {
        int i = this.namespaceEnd;
        if (str == null) {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (this.namespacePrefix[i2] == null) {
                    return this.namespaceUri[i2];
                }
            }
            return null;
        }
        for (int i3 = i - 1; i3 >= 0; i3--) {
            if (str.equals(this.namespacePrefix[i3])) {
                return this.namespaceUri[i3];
            }
        }
        if (XMLConstants.XML_NS_PREFIX.equals(str)) {
            return "http://www.w3.org/XML/1998/namespace";
        }
        if (XMLConstants.XMLNS_ATTRIBUTE.equals(str)) {
            return "http://www.w3.org/2000/xmlns/";
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public int getNamespaceCount(int i) {
        if (!this.processNamespaces || i == 0) {
            return 0;
        }
        if (i >= 0 && i <= this.depth) {
            return this.elNamespaceCount[i];
        }
        StringBuffer stringBuffer = new StringBuffer("napespace count mayt be for depth 0..");
        stringBuffer.append(this.depth);
        stringBuffer.append(" not ");
        stringBuffer.append(i);
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespacePrefix(int i) throws XmlPullParserException {
        if (i < this.namespaceEnd) {
            return this.namespacePrefix[i];
        }
        StringBuffer stringBuffer = new StringBuffer("position ");
        stringBuffer.append(i);
        stringBuffer.append(" exceeded number of available namespaces ");
        stringBuffer.append(this.namespaceEnd);
        throw new XmlPullParserException(stringBuffer.toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespaceUri(int i) throws XmlPullParserException {
        if (i < this.namespaceEnd) {
            return this.namespaceUri[i];
        }
        StringBuffer stringBuffer = new StringBuffer("position ");
        stringBuffer.append(i);
        stringBuffer.append(" exceedded number of available namespaces ");
        stringBuffer.append(this.namespaceEnd);
        throw new XmlPullParserException(stringBuffer.toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public String getPositionDescription() {
        String string;
        int i = this.posStart;
        int i2 = this.pos;
        if (i <= i2) {
            int iFindFragment = findFragment(0, this.buf, i, i2);
            int i3 = this.pos;
            str = iFindFragment < i3 ? new String(this.buf, iFindFragment, i3 - iFindFragment) : null;
            if (this.bufAbsoluteStart > 0 || iFindFragment > 0) {
                StringBuffer stringBuffer = new StringBuffer("...");
                stringBuffer.append(str);
                str = stringBuffer.toString();
            }
        }
        StringBuffer stringBuffer2 = new StringBuffer(" ");
        stringBuffer2.append(XmlPullParser.TYPES[this.eventType]);
        if (str != null) {
            StringBuffer stringBuffer3 = new StringBuffer(" seen ");
            stringBuffer3.append(printable(str));
            stringBuffer3.append("...");
            string = stringBuffer3.toString();
        } else {
            string = "";
        }
        stringBuffer2.append(string);
        stringBuffer2.append(" @");
        stringBuffer2.append(getLineNumber());
        stringBuffer2.append(":");
        stringBuffer2.append(getColumnNumber());
        return stringBuffer2.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public String getPrefix() {
        int i = this.eventType;
        if (i == 2) {
            return this.elPrefix[this.depth];
        }
        if (i == 3) {
            return this.elPrefix[this.depth];
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public Object getProperty(String str) {
        if (str == null) {
            jl.a("property name should not be nulll");
            return null;
        }
        if (PROPERTY_XMLDECL_VERSION.equals(str)) {
            return this.xmlDeclVersion;
        }
        if (PROPERTY_XMLDECL_STANDALONE.equals(str)) {
            return this.xmlDeclStandalone;
        }
        if (PROPERTY_XMLDECL_CONTENT.equals(str)) {
            return this.xmlDeclContent;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public String getText() {
        int i = this.eventType;
        if (i == 0 || i == 1) {
            return null;
        }
        String str = this.text;
        if (i == 6) {
            return str;
        }
        if (str == null) {
            if (!this.usePC || i == 2 || i == 3) {
                char[] cArr = this.buf;
                int i2 = this.posStart;
                this.text = new String(cArr, i2, this.posEnd - i2);
            } else {
                char[] cArr2 = this.pc;
                int i3 = this.pcStart;
                this.text = new String(cArr2, i3, this.pcEnd - i3);
            }
        }
        return this.text;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public char[] getTextCharacters(int[] iArr) {
        int i = this.eventType;
        if (i == 4) {
            if (this.usePC) {
                int i2 = this.pcStart;
                iArr[0] = i2;
                iArr[1] = this.pcEnd - i2;
                return this.pc;
            }
            int i3 = this.posStart;
            iArr[0] = i3;
            iArr[1] = this.posEnd - i3;
            return this.buf;
        }
        if (i == 2 || i == 3 || i == 5 || i == 9 || i == 6 || i == 8 || i == 7 || i == 10) {
            int i4 = this.posStart;
            iArr[0] = i4;
            iArr[1] = this.posEnd - i4;
            return this.buf;
        }
        if (i == 0 || i == 1) {
            iArr[1] = -1;
            iArr[0] = -1;
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer("unknown text eventType: ");
        stringBuffer.append(this.eventType);
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public boolean isAttributeDefault(int i) {
        if (this.eventType != 2) {
            x32.a("only START_TAG can have attributes");
            return false;
        }
        if (i >= 0 && i < this.attributeCount) {
            return false;
        }
        StringBuffer stringBuffer = new StringBuffer("attribute position must be 0..");
        stringBuffer.append(this.attributeCount - 1);
        stringBuffer.append(" and not ");
        stringBuffer.append(i);
        throw new IndexOutOfBoundsException(stringBuffer.toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public boolean isEmptyElementTag() throws XmlPullParserException {
        if (this.eventType == 2) {
            return this.emptyElementTag;
        }
        w32.a("parser must be on START_TAG to check for empty element", this, null);
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isNameChar(char c) {
        if (c < 1024 && lookupNameChar[c]) {
            return true;
        }
        if (c >= 1024 && c <= 8231) {
            return true;
        }
        if (c < 8234 || c > 8591) {
            return c >= 10240 && c <= 65519;
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isNameStartChar(char c) {
        if (c < 1024 && lookupNameStartChar[c]) {
            return true;
        }
        if (c >= 1024 && c <= 8231) {
            return true;
        }
        if (c < 8234 || c > 8591) {
            return c >= 10240 && c <= 65519;
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isS(char c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t';
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public boolean isWhitespace() throws XmlPullParserException {
        int i = this.eventType;
        if (i != 4 && i != 5) {
            if (i == 7) {
                return true;
            }
            throw new XmlPullParserException("no content available to check for whitespaces");
        }
        if (this.usePC) {
            for (int i2 = this.pcStart; i2 < this.pcEnd; i2++) {
                if (!isS(this.pc[i2])) {
                    return false;
                }
            }
            return true;
        }
        for (int i3 = this.posStart; i3 < this.posEnd; i3++) {
            if (!isS(this.buf[i3])) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void joinPC() {
        int i = this.posEnd - this.posStart;
        int i2 = this.pcEnd + i + 1;
        if (i2 >= this.pc.length) {
            ensurePC(i2);
        }
        System.arraycopy(this.buf, this.posStart, this.pc, this.pcEnd, i);
        this.pcEnd += i;
        this.usePC = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public char[] lookuEntityReplacement(int i) {
        boolean z = this.allStringsInterned;
        char[] cArr = this.buf;
        if (z) {
            int i2 = this.posStart;
            this.entityRefName = newString(cArr, i2, this.posEnd - i2);
            for (int i3 = this.entityEnd - 1; i3 >= 0; i3--) {
                if (this.entityRefName == this.entityName[i3]) {
                    if (this.tokenize) {
                        this.text = this.entityReplacement[i3];
                    }
                    return this.entityReplacementBuf[i3];
                }
            }
            return null;
        }
        int i4 = this.posStart;
        int iFastHash = fastHash(cArr, i4, this.posEnd - i4);
        for (int i5 = this.entityEnd - 1; i5 >= 0; i5--) {
            if (iFastHash == this.entityNameHash[i5]) {
                char[] cArr2 = this.entityNameBuf[i5];
                if (i == cArr2.length) {
                    for (int i6 = 0; i6 < i; i6++) {
                        if (this.buf[this.posStart + i6] != cArr2[i6]) {
                            break;
                        }
                    }
                    if (this.tokenize) {
                        this.text = this.entityReplacement[i5];
                    }
                    return this.entityReplacementBuf[i5];
                }
                continue;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public char more() throws XmlPullParserException, IOException {
        if (this.pos >= this.bufEnd) {
            fillBuf();
        }
        char[] cArr = this.buf;
        int i = this.pos;
        this.pos = i + 1;
        char c = cArr[i];
        if (c != '\n') {
            this.columnNumber++;
            return c;
        }
        this.lineNumber++;
        this.columnNumber = 1;
        return c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String newString(char[] cArr, int i, int i2) {
        return new String(cArr, i, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String newStringIntern(char[] cArr, int i, int i2) {
        return new String(cArr, i, i2).intern();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public int next() {
        this.tokenize = false;
        return nextImpl();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int nextImpl() throws XmlPullParserException, IOException {
        char cMore;
        boolean z;
        this.text = null;
        this.pcStart = 0;
        this.pcEnd = 0;
        this.usePC = false;
        this.bufStart = this.posEnd;
        if (this.pastEndTag) {
            this.pastEndTag = false;
            int i = this.depth - 1;
            this.depth = i;
            this.namespaceEnd = this.elNamespaceCount[i];
        }
        if (this.emptyElementTag) {
            this.emptyElementTag = false;
            this.pastEndTag = true;
            this.eventType = 3;
            return 3;
        }
        if (this.depth <= 0) {
            return this.seenRoot ? parseEpilog() : parseProlog();
        }
        if (this.seenStartTag) {
            this.seenStartTag = false;
            int startTag = parseStartTag();
            this.eventType = startTag;
            return startTag;
        }
        if (this.seenEndTag) {
            this.seenEndTag = false;
            int endTag = parseEndTag();
            this.eventType = endTag;
            return endTag;
        }
        if (this.seenMarkup) {
            this.seenMarkup = false;
            cMore = '<';
        } else if (this.seenAmpersand) {
            this.seenAmpersand = false;
            cMore = '&';
        } else {
            cMore = more();
        }
        this.posStart = this.pos - 1;
        boolean z2 = false;
        boolean z3 = false;
        while (true) {
            if (cMore == '<') {
                if (z2 && this.tokenize) {
                    this.seenMarkup = true;
                    this.eventType = 4;
                    return 4;
                }
                char cMore2 = more();
                if (cMore2 == '/') {
                    if (this.tokenize || !z2) {
                        int endTag2 = parseEndTag();
                        this.eventType = endTag2;
                        return endTag2;
                    }
                    this.seenEndTag = true;
                    this.eventType = 4;
                    return 4;
                }
                if (cMore2 == '!') {
                    char cMore3 = more();
                    if (cMore3 == '-') {
                        parseComment();
                        if (this.tokenize) {
                            this.eventType = 9;
                            return 9;
                        }
                        if (this.usePC || !z2) {
                            this.posStart = this.pos;
                        } else {
                            z3 = true;
                        }
                    } else {
                        if (cMore3 != '[') {
                            StringBuffer stringBuffer = new StringBuffer("unexpected character in markup ");
                            stringBuffer.append(printable(cMore3));
                            throw new XmlPullParserException(stringBuffer.toString(), this, null);
                        }
                        parseCDSect(z2);
                        if (this.tokenize) {
                            this.eventType = 5;
                            return 5;
                        }
                        if (this.posEnd - this.posStart > 0 && !this.usePC) {
                            z2 = true;
                            z3 = true;
                        }
                    }
                } else {
                    if (cMore2 != '?') {
                        if (!isNameStartChar(cMore2)) {
                            StringBuffer stringBuffer2 = new StringBuffer("unexpected character in markup ");
                            stringBuffer2.append(printable(cMore2));
                            throw new XmlPullParserException(stringBuffer2.toString(), this, null);
                        }
                        if (this.tokenize || !z2) {
                            int startTag2 = parseStartTag();
                            this.eventType = startTag2;
                            return startTag2;
                        }
                        this.seenStartTag = true;
                        this.eventType = 4;
                        return 4;
                    }
                    parsePI();
                    if (this.tokenize) {
                        this.eventType = 8;
                        return 8;
                    }
                    if (this.usePC || !z2) {
                        this.posStart = this.pos;
                    }
                }
            } else if (cMore != '&') {
                if (z3) {
                    joinPC();
                    z3 = false;
                }
                boolean z4 = (this.tokenize && this.roundtripSupported) ? false : true;
                boolean z5 = false;
                do {
                    if (z4) {
                        if (cMore == '\r') {
                            int i2 = this.pos - 1;
                            this.posEnd = i2;
                            if (!this.usePC) {
                                if (i2 > this.posStart) {
                                    joinPC();
                                } else {
                                    this.usePC = true;
                                    this.pcEnd = 0;
                                    this.pcStart = 0;
                                }
                            }
                            int i3 = this.pcEnd;
                            if (i3 >= this.pc.length) {
                                ensurePC(i3);
                            }
                            char[] cArr = this.pc;
                            int i4 = this.pcEnd;
                            this.pcEnd = i4 + 1;
                            cArr[i4] = '\n';
                            z5 = true;
                        } else {
                            if (cMore == '\n') {
                                if (!z5 && this.usePC) {
                                    int i5 = this.pcEnd;
                                    if (i5 >= this.pc.length) {
                                        ensurePC(i5);
                                    }
                                    char[] cArr2 = this.pc;
                                    int i6 = this.pcEnd;
                                    this.pcEnd = i6 + 1;
                                    cArr2[i6] = '\n';
                                }
                            } else if (this.usePC) {
                                int i7 = this.pcEnd;
                                if (i7 >= this.pc.length) {
                                    ensurePC(i7);
                                }
                                char[] cArr3 = this.pc;
                                int i8 = this.pcEnd;
                                this.pcEnd = i8 + 1;
                                cArr3[i8] = cMore;
                            }
                            z5 = false;
                        }
                    }
                    cMore = more();
                    if (cMore == '<') {
                        break;
                    }
                } while (cMore != '&');
                this.posEnd = this.pos - 1;
                z2 = true;
            } else {
                if (this.tokenize && z2) {
                    this.seenAmpersand = true;
                    this.eventType = 4;
                    return 4;
                }
                int i9 = this.posStart;
                int i10 = this.bufAbsoluteStart;
                int i11 = i9 + i10;
                int i12 = this.posEnd + i10;
                char[] entityRef = parseEntityRef();
                if (this.tokenize) {
                    this.eventType = 6;
                    return 6;
                }
                if (entityRef == null) {
                    if (this.entityRefName == null) {
                        char[] cArr4 = this.buf;
                        int i13 = this.posStart;
                        this.entityRefName = newString(cArr4, i13, this.posEnd - i13);
                    }
                    StringBuffer stringBuffer3 = new StringBuffer("could not resolve entity named '");
                    stringBuffer3.append(printable(this.entityRefName));
                    stringBuffer3.append("'");
                    throw new XmlPullParserException(stringBuffer3.toString(), this, null);
                }
                int i14 = this.bufAbsoluteStart;
                this.posStart = i11 - i14;
                this.posEnd = i12 - i14;
                if (this.usePC) {
                    z = z3;
                    for (char c : entityRef) {
                        int i15 = this.pcEnd;
                        if (i15 >= this.pc.length) {
                            ensurePC(i15);
                        }
                        char[] cArr5 = this.pc;
                        int i16 = this.pcEnd;
                        this.pcEnd = i16 + 1;
                        cArr5[i16] = c;
                    }
                    z3 = z;
                } else if (z2) {
                    joinPC();
                    z = false;
                    while (i < entityRef.length) {
                    }
                    z3 = z;
                } else {
                    this.usePC = true;
                    this.pcEnd = 0;
                    this.pcStart = 0;
                    z = z3;
                    while (i < entityRef.length) {
                    }
                    z3 = z;
                }
            }
            cMore = more();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public int nextTag() throws XmlPullParserException {
        next();
        if (this.eventType == 4 && isWhitespace()) {
            next();
        }
        int i = this.eventType;
        if (i == 2 || i == 3) {
            return i;
        }
        StringBuffer stringBuffer = new StringBuffer("expected START_TAG or END_TAG not ");
        stringBuffer.append(XmlPullParser.TYPES[getEventType()]);
        throw new XmlPullParserException(stringBuffer.toString(), this, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public String nextText() throws XmlPullParserException {
        if (getEventType() != 2) {
            w32.a("parser must be on START_TAG to read next text", this, null);
            return null;
        }
        int next = next();
        if (next != 4) {
            if (next == 3) {
                return "";
            }
            w32.a("parser must be on START_TAG or TEXT to read text", this, null);
            return null;
        }
        String text = getText();
        if (next() == 3) {
            return text;
        }
        StringBuffer stringBuffer = new StringBuffer("TEXT must be immediately followed by END_TAG and not ");
        stringBuffer.append(XmlPullParser.TYPES[getEventType()]);
        throw new XmlPullParserException(stringBuffer.toString(), this, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public int nextToken() {
        this.tokenize = true;
        return nextImpl();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0349 A[PHI: r2 r10
      0x0349: PHI (r2v31 boolean) = (r2v5 boolean), (r2v33 boolean) binds: [B:163:0x0305, B:190:0x0337] A[DONT_GENERATE, DONT_INLINE]
      0x0349: PHI (r10v12 int) = (r10v1 int), (r10v14 int) binds: [B:163:0x0305, B:190:0x0337] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public char parseAttribute() throws XmlPullParserException, IOException {
        String strNewString;
        String strNewStringIntern;
        String string;
        int i;
        int i2 = this.posStart;
        int i3 = this.bufAbsoluteStart;
        int i4 = i2 + i3;
        int i5 = this.pos;
        int i6 = (i5 - 1) + i3;
        char c = this.buf[i5 - 1];
        if (c == ':' && this.processNamespaces) {
            w32.a("when namespaces processing enabled colon can not be at attribute name start", this, null);
            return (char) 0;
        }
        boolean z = this.processNamespaces && c == 'x';
        char cMore = more();
        int iHashCode = -1;
        int i7 = 0;
        int i8 = -1;
        while (isNameChar(cMore)) {
            if (this.processNamespaces) {
                if (z && i7 < 5) {
                    i7++;
                    if (i7 == 1) {
                        if (cMore != 'm') {
                            z = false;
                        }
                    } else if (i7 == 2) {
                        if (cMore != 'l') {
                        }
                    } else if (i7 == 3) {
                        if (cMore != 'n') {
                        }
                    } else if (i7 == 4) {
                        if (cMore != 's') {
                        }
                    } else if (i7 == 5 && cMore != ':') {
                        w32.a("after xmlns in attribute name must be colonwhen namespaces are enabled", this, null);
                        return (char) 0;
                    }
                }
                if (cMore == ':') {
                    i = -1;
                    if (i8 != -1) {
                        w32.a("only one colon is allowed in attribute name when namespaces are enabled", this, null);
                        return (char) 0;
                    }
                    i8 = this.bufAbsoluteStart + (this.pos - 1);
                }
            } else {
                i = -1;
            }
            iHashCode = i;
            cMore = more();
        }
        ensureAttributesCapacity(this.attributeCount);
        if (this.processNamespaces) {
            if (i7 < 4) {
                z = false;
            }
            if (!z) {
                String[] strArr = this.attributePrefix;
                if (i8 != iHashCode) {
                    strArr[this.attributeCount] = newString(this.buf, i6 - this.bufAbsoluteStart, i8 - i6);
                    int i9 = this.pos - 2;
                    int i10 = this.bufAbsoluteStart;
                    String[] strArr2 = this.attributeName;
                    int i11 = this.attributeCount;
                    strNewString = newString(this.buf, (i8 - i10) + 1, i9 - (i8 - i10));
                    strArr2[i11] = strNewString;
                } else {
                    int i12 = this.attributeCount;
                    strArr[i12] = null;
                    String[] strArr3 = this.attributeName;
                    char[] cArr = this.buf;
                    int i13 = this.bufAbsoluteStart;
                    strNewString = newString(cArr, i6 - i13, (this.pos - 1) - (i6 - i13));
                    strArr3[i12] = strNewString;
                }
                if (!this.allStringsInterned) {
                    this.attributeNameHash[this.attributeCount] = strNewString.hashCode();
                }
            } else if (i8 != iHashCode) {
                int i14 = this.pos - 2;
                int i15 = this.bufAbsoluteStart;
                int i16 = i14 - (i8 - i15);
                if (i16 == 0) {
                    w32.a("namespace prefix is required after xmlns:  when namespaces are enabled", this, null);
                    return (char) 0;
                }
                strNewString = newString(this.buf, (i8 - i15) + 1, i16);
            } else {
                strNewString = null;
            }
        } else {
            String[] strArr4 = this.attributeName;
            int i17 = this.attributeCount;
            char[] cArr2 = this.buf;
            int i18 = this.bufAbsoluteStart;
            strNewString = newString(cArr2, i6 - i18, (this.pos - 1) - (i6 - i18));
            strArr4[i17] = strNewString;
            if (!this.allStringsInterned) {
                this.attributeNameHash[this.attributeCount] = strNewString.hashCode();
            }
        }
        while (isS(cMore)) {
            cMore = more();
            iHashCode = -1;
        }
        if (cMore != '=') {
            w32.a("expected = after attribute name", this, null);
            return (char) 0;
        }
        char cMore2 = more();
        while (isS(cMore2)) {
            cMore2 = more();
            iHashCode = -1;
        }
        if (cMore2 != '\"' && cMore2 != '\'') {
            StringBuffer stringBuffer = new StringBuffer("attribute value must start with quotation or apostrophe not ");
            stringBuffer.append(printable(cMore2));
            throw new XmlPullParserException(stringBuffer.toString(), this, null);
        }
        this.usePC = false;
        this.pcStart = this.pcEnd;
        this.posStart = this.pos;
        boolean z2 = false;
        while (true) {
            char cMore3 = more();
            if (cMore3 == cMore2) {
                if (this.processNamespaces && z) {
                    if (this.usePC) {
                        char[] cArr3 = this.pc;
                        int i19 = this.pcStart;
                        strNewStringIntern = newStringIntern(cArr3, i19, this.pcEnd - i19);
                    } else {
                        char[] cArr4 = this.buf;
                        int i20 = this.posStart;
                        strNewStringIntern = newStringIntern(cArr4, i20, (this.pos - 1) - i20);
                    }
                    ensureNamespacesCapacity(this.namespaceEnd);
                    if (i8 == iHashCode) {
                        String[] strArr5 = this.namespacePrefix;
                        int i21 = this.namespaceEnd;
                        strArr5[i21] = null;
                        if (!this.allStringsInterned) {
                            this.namespacePrefixHash[i21] = iHashCode;
                        }
                    } else {
                        if (strNewStringIntern.length() == 0) {
                            w32.a("non-default namespace can not be declared to be empty string", this, null);
                            return (char) 0;
                        }
                        String[] strArr6 = this.namespacePrefix;
                        int i22 = this.namespaceEnd;
                        strArr6[i22] = strNewString;
                        if (!this.allStringsInterned) {
                            int[] iArr = this.namespacePrefixHash;
                            iHashCode = strNewString.hashCode();
                            iArr[i22] = iHashCode;
                        }
                    }
                    this.namespaceUri[this.namespaceEnd] = strNewStringIntern;
                    int i23 = this.elNamespaceCount[this.depth - 1];
                    for (int i24 = r7 - 1; i24 >= i23; i24--) {
                        boolean z3 = this.allStringsInterned;
                        if (((z3 || strNewString == null) && this.namespacePrefix[i24] == strNewString) || (!z3 && strNewString != null && this.namespacePrefixHash[i24] == iHashCode && strNewString.equals(this.namespacePrefix[i24]))) {
                            if (strNewString == null) {
                                string = "default";
                            } else {
                                StringBuffer stringBuffer2 = new StringBuffer("'");
                                stringBuffer2.append(strNewString);
                                stringBuffer2.append("'");
                                string = stringBuffer2.toString();
                            }
                            StringBuffer stringBuffer3 = new StringBuffer("duplicated namespace declaration for ");
                            stringBuffer3.append(string);
                            stringBuffer3.append(" prefix");
                            throw new XmlPullParserException(stringBuffer3.toString(), this, null);
                        }
                    }
                    this.namespaceEnd++;
                } else {
                    boolean z4 = this.usePC;
                    String[] strArr7 = this.attributeValue;
                    if (z4) {
                        int i25 = this.attributeCount;
                        char[] cArr5 = this.pc;
                        int i26 = this.pcStart;
                        strArr7[i25] = new String(cArr5, i26, this.pcEnd - i26);
                    } else {
                        int i27 = this.attributeCount;
                        char[] cArr6 = this.buf;
                        int i28 = this.posStart;
                        strArr7[i27] = new String(cArr6, i28, (this.pos - 1) - i28);
                    }
                    this.attributeCount++;
                }
                this.posStart = i4 - this.bufAbsoluteStart;
                return cMore3;
            }
            if (cMore3 == '<') {
                w32.a("markup not allowed inside attribute value - illegal < ", this, null);
                return (char) 0;
            }
            if (cMore3 == '&') {
                int i29 = this.pos - 1;
                this.posEnd = i29;
                if (!this.usePC) {
                    if (i29 > this.posStart) {
                        joinPC();
                    } else {
                        this.usePC = true;
                        this.pcEnd = 0;
                        this.pcStart = 0;
                    }
                }
                char[] entityRef = parseEntityRef();
                if (entityRef == null) {
                    if (this.entityRefName == null) {
                        char[] cArr7 = this.buf;
                        int i30 = this.posStart;
                        this.entityRefName = newString(cArr7, i30, this.posEnd - i30);
                    }
                    StringBuffer stringBuffer4 = new StringBuffer("could not resolve entity named '");
                    stringBuffer4.append(printable(this.entityRefName));
                    stringBuffer4.append("'");
                    throw new XmlPullParserException(stringBuffer4.toString(), this, null);
                }
                for (char c2 : entityRef) {
                    int i31 = this.pcEnd;
                    if (i31 >= this.pc.length) {
                        ensurePC(i31);
                    }
                    char[] cArr8 = this.pc;
                    int i32 = this.pcEnd;
                    this.pcEnd = i32 + 1;
                    cArr8[i32] = c2;
                }
            } else if (cMore3 == '\t' || cMore3 == '\n' || cMore3 == '\r') {
                if (!this.usePC) {
                    int i33 = this.pos - 1;
                    this.posEnd = i33;
                    if (i33 > this.posStart) {
                        joinPC();
                    } else {
                        this.usePC = true;
                        this.pcStart = 0;
                        this.pcEnd = 0;
                    }
                }
                int i34 = this.pcEnd;
                if (i34 >= this.pc.length) {
                    ensurePC(i34);
                }
                if (cMore3 != '\n' || !z2) {
                    char[] cArr9 = this.pc;
                    int i35 = this.pcEnd;
                    this.pcEnd = i35 + 1;
                    cArr9[i35] = ' ';
                }
            } else if (this.usePC) {
                int i36 = this.pcEnd;
                if (i36 >= this.pc.length) {
                    ensurePC(i36);
                }
                char[] cArr10 = this.pc;
                int i37 = this.pcEnd;
                this.pcEnd = i37 + 1;
                cArr10[i37] = cMore3;
            }
            z2 = cMore3 == '\r';
            iHashCode = -1;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void parseCDSect(boolean z) throws XmlPullParserException, IOException {
        if (more() != 'C') {
            w32.a("expected <[CDATA[ for comment start", this, null);
            return;
        }
        if (more() != 'D') {
            w32.a("expected <[CDATA[ for comment start", this, null);
            return;
        }
        if (more() != 'A') {
            w32.a("expected <[CDATA[ for comment start", this, null);
            return;
        }
        if (more() != 'T') {
            w32.a("expected <[CDATA[ for comment start", this, null);
            return;
        }
        if (more() != 'A') {
            w32.a("expected <[CDATA[ for comment start", this, null);
            return;
        }
        if (more() != '[') {
            w32.a("expected <[CDATA[ for comment start", this, null);
            return;
        }
        int i = this.pos + this.bufAbsoluteStart;
        int i2 = this.lineNumber;
        int i3 = this.columnNumber;
        boolean z2 = (this.tokenize && this.roundtripSupported) ? false : true;
        if (z2 && z) {
            try {
                if (!this.usePC) {
                    if (this.posEnd > this.posStart) {
                        joinPC();
                    } else {
                        this.usePC = true;
                        this.pcEnd = 0;
                        this.pcStart = 0;
                    }
                }
            } catch (EOFException e) {
                StringBuffer stringBuffer = new StringBuffer("CDATA section started on line ");
                stringBuffer.append(i2);
                stringBuffer.append(" and column ");
                stringBuffer.append(i3);
                stringBuffer.append(" was not closed");
                throw new XmlPullParserException(stringBuffer.toString(), this, e);
            }
        }
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        while (true) {
            char cMore = more();
            if (cMore == ']') {
                if (z3) {
                    z4 = true;
                } else {
                    z3 = true;
                }
            } else if (cMore != '>') {
                z3 = false;
            } else {
                if (z4) {
                    break;
                }
                z3 = false;
                z4 = false;
            }
            if (z2) {
                if (cMore == '\r') {
                    int i4 = i - this.bufAbsoluteStart;
                    this.posStart = i4;
                    int i5 = this.pos;
                    this.posEnd = i5;
                    if (!this.usePC) {
                        if (i5 > i4) {
                            joinPC();
                        } else {
                            this.usePC = true;
                            this.pcEnd = 0;
                            this.pcStart = 0;
                        }
                    }
                    int i6 = this.pcEnd;
                    if (i6 >= this.pc.length) {
                        ensurePC(i6);
                    }
                    char[] cArr = this.pc;
                    int i7 = this.pcEnd;
                    this.pcEnd = i7 + 1;
                    cArr[i7] = '\n';
                    z5 = true;
                } else {
                    if (cMore == '\n') {
                        if (!z5 && this.usePC) {
                            int i8 = this.pcEnd;
                            if (i8 >= this.pc.length) {
                                ensurePC(i8);
                            }
                            char[] cArr2 = this.pc;
                            int i9 = this.pcEnd;
                            this.pcEnd = i9 + 1;
                            cArr2[i9] = '\n';
                        }
                    } else if (this.usePC) {
                        int i10 = this.pcEnd;
                        if (i10 >= this.pc.length) {
                            ensurePC(i10);
                        }
                        char[] cArr3 = this.pc;
                        int i11 = this.pcEnd;
                        this.pcEnd = i11 + 1;
                        cArr3[i11] = cMore;
                    }
                    z5 = false;
                }
            }
        }
        if (z2 && this.usePC) {
            this.pcEnd -= 2;
        }
        this.posStart = i - this.bufAbsoluteStart;
        this.posEnd = this.pos - 3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
    
        r2 = new java.lang.StringBuffer();
        r2.append("in comment after two dashes (--) next character must be > not ");
        r2.append(printable(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004b, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r2.toString(), r13, null);
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void parseComment() throws XmlPullParserException, IOException {
        boolean z;
        if (more() != '-') {
            w32.a("expected <!-- for comment start", this, null);
            return;
        }
        boolean z2 = this.tokenize;
        if (z2) {
            this.posStart = this.pos;
        }
        int i = this.lineNumber;
        int i2 = this.columnNumber;
        if (z2) {
            try {
                z = !this.roundtripSupported;
            } catch (EOFException e) {
                StringBuffer stringBuffer = new StringBuffer("comment started on line ");
                stringBuffer.append(i);
                stringBuffer.append(" and column ");
                stringBuffer.append(i2);
                stringBuffer.append(" was not closed");
                throw new XmlPullParserException(stringBuffer.toString(), this, e);
            }
        }
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        while (true) {
            char cMore = more();
            if (z3 && cMore != '>') {
                break;
            }
            if (cMore == '-') {
                if (z4) {
                    z3 = true;
                    z4 = false;
                } else {
                    z4 = true;
                }
            } else if (cMore != '>') {
                z4 = false;
            } else {
                if (z3) {
                    if (this.tokenize) {
                        this.posEnd = this.pos - 3;
                        if (this.usePC) {
                            this.pcEnd -= 2;
                            return;
                        }
                        return;
                    }
                    return;
                }
                z3 = false;
                z4 = false;
            }
            if (z) {
                if (cMore == '\r') {
                    if (!this.usePC) {
                        int i3 = this.pos - 1;
                        this.posEnd = i3;
                        if (i3 > this.posStart) {
                            joinPC();
                        } else {
                            this.usePC = true;
                            this.pcEnd = 0;
                            this.pcStart = 0;
                        }
                    }
                    int i4 = this.pcEnd;
                    if (i4 >= this.pc.length) {
                        ensurePC(i4);
                    }
                    char[] cArr = this.pc;
                    int i5 = this.pcEnd;
                    this.pcEnd = i5 + 1;
                    cArr[i5] = '\n';
                    z5 = true;
                } else {
                    if (cMore == '\n') {
                        if (!z5 && this.usePC) {
                            int i6 = this.pcEnd;
                            if (i6 >= this.pc.length) {
                                ensurePC(i6);
                            }
                            char[] cArr2 = this.pc;
                            int i7 = this.pcEnd;
                            this.pcEnd = i7 + 1;
                            cArr2[i7] = '\n';
                        }
                    } else if (this.usePC) {
                        int i8 = this.pcEnd;
                        if (i8 >= this.pc.length) {
                            ensurePC(i8);
                        }
                        char[] cArr3 = this.pc;
                        int i9 = this.pcEnd;
                        this.pcEnd = i9 + 1;
                        cArr3[i9] = cMore;
                    }
                    z5 = false;
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void parseDocdecl() throws XmlPullParserException, IOException {
        if (more() != 'O') {
            w32.a("expected <!DOCTYPE", this, null);
            return;
        }
        if (more() != 'C') {
            w32.a("expected <!DOCTYPE", this, null);
            return;
        }
        if (more() != 'T') {
            w32.a("expected <!DOCTYPE", this, null);
            return;
        }
        if (more() != 'Y') {
            w32.a("expected <!DOCTYPE", this, null);
            return;
        }
        if (more() != 'P') {
            w32.a("expected <!DOCTYPE", this, null);
            return;
        }
        if (more() != 'E') {
            w32.a("expected <!DOCTYPE", this, null);
            return;
        }
        this.posStart = this.pos;
        boolean z = this.tokenize && !this.roundtripSupported;
        int i = 0;
        boolean z2 = false;
        while (true) {
            char cMore = more();
            if (cMore == '[') {
                i++;
            }
            if (cMore == ']') {
                i--;
            }
            if (cMore == '>' && i == 0) {
                this.posEnd = this.pos - 1;
                return;
            }
            if (z) {
                if (cMore == '\r') {
                    if (!this.usePC) {
                        int i2 = this.pos - 1;
                        this.posEnd = i2;
                        if (i2 > this.posStart) {
                            joinPC();
                        } else {
                            this.usePC = true;
                            this.pcEnd = 0;
                            this.pcStart = 0;
                        }
                    }
                    int i3 = this.pcEnd;
                    if (i3 >= this.pc.length) {
                        ensurePC(i3);
                    }
                    char[] cArr = this.pc;
                    int i4 = this.pcEnd;
                    this.pcEnd = i4 + 1;
                    cArr[i4] = '\n';
                    z2 = true;
                } else {
                    if (cMore == '\n') {
                        if (!z2 && this.usePC) {
                            int i5 = this.pcEnd;
                            if (i5 >= this.pc.length) {
                                ensurePC(i5);
                            }
                            char[] cArr2 = this.pc;
                            int i6 = this.pcEnd;
                            this.pcEnd = i6 + 1;
                            cArr2[i6] = '\n';
                        }
                    } else if (this.usePC) {
                        int i7 = this.pcEnd;
                        if (i7 >= this.pc.length) {
                            ensurePC(i7);
                        }
                        char[] cArr3 = this.pc;
                        int i8 = this.pcEnd;
                        this.pcEnd = i8 + 1;
                        cArr3[i8] = cMore;
                    }
                    z2 = false;
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int parseEndTag() throws XmlPullParserException, IOException {
        char cMore;
        char cMore2 = more();
        if (!isNameStartChar(cMore2)) {
            StringBuffer stringBuffer = new StringBuffer("expected name start and not ");
            stringBuffer.append(printable(cMore2));
            throw new XmlPullParserException(stringBuffer.toString(), this, null);
        }
        int i = this.pos;
        this.posStart = i - 3;
        int i2 = this.bufAbsoluteStart + (i - 1);
        do {
            cMore = more();
        } while (isNameChar(cMore));
        int i3 = i2 - this.bufAbsoluteStart;
        int i4 = (this.pos - 1) - i3;
        char[][] cArr = this.elRawName;
        int i5 = this.depth;
        char[] cArr2 = cArr[i5];
        int i6 = this.elRawNameEnd[i5];
        if (i6 != i4) {
            String str = new String(cArr2, 0, i6);
            String str2 = new String(this.buf, i3, i4);
            StringBuffer stringBuffer2 = new StringBuffer("end tag name </");
            stringBuffer2.append(str2);
            stringBuffer2.append("> must match start tag name <");
            stringBuffer2.append(str);
            stringBuffer2.append("> from line ");
            stringBuffer2.append(this.elRawNameLine[this.depth]);
            throw new XmlPullParserException(stringBuffer2.toString(), this, null);
        }
        int i7 = 0;
        while (i7 < i4) {
            int i8 = i3 + 1;
            if (this.buf[i3] != cArr2[i7]) {
                String str3 = new String(cArr2, 0, i4);
                String str4 = new String(this.buf, (i8 - i7) - 1, i4);
                StringBuffer stringBuffer3 = new StringBuffer("end tag name </");
                stringBuffer3.append(str4);
                stringBuffer3.append("> must be the same as start tag <");
                stringBuffer3.append(str3);
                stringBuffer3.append("> from line ");
                stringBuffer3.append(this.elRawNameLine[this.depth]);
                throw new XmlPullParserException(stringBuffer3.toString(), this, null);
            }
            i7++;
            i3 = i8;
        }
        while (isS(cMore)) {
            cMore = more();
        }
        if (cMore == '>') {
            this.posEnd = this.pos;
            this.pastEndTag = true;
            this.eventType = 3;
            return 3;
        }
        StringBuffer stringBuffer4 = new StringBuffer("expected > to finsh end tag not ");
        stringBuffer4.append(printable(cMore));
        stringBuffer4.append(" from line ");
        stringBuffer4.append(this.elRawNameLine[this.depth]);
        throw new XmlPullParserException(stringBuffer4.toString(), this, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public char[] parseEntityRef() throws XmlPullParserException, IOException {
        char c;
        char cMore;
        int i;
        int i2;
        this.entityRefName = null;
        this.posStart = this.pos;
        if (more() == '#') {
            char cMore2 = more();
            if (cMore2 == 'x') {
                c = 0;
                while (true) {
                    cMore = more();
                    if (cMore >= '0' && cMore <= '9') {
                        i = c * 16;
                        i2 = cMore - '0';
                    } else if (cMore >= 'a' && cMore <= 'f') {
                        i = c * 16;
                        i2 = cMore - 'W';
                    } else {
                        if (cMore < 'A' || cMore > 'F') {
                            break;
                        }
                        i = c * 16;
                        i2 = cMore - '7';
                    }
                    c = (char) (i + i2);
                }
                if (cMore != ';') {
                    StringBuffer stringBuffer = new StringBuffer("character reference (with hex value) may not contain ");
                    stringBuffer.append(printable(cMore));
                    throw new XmlPullParserException(stringBuffer.toString(), this, null);
                }
            } else {
                char c2 = 0;
                while (cMore2 >= '0' && cMore2 <= '9') {
                    c2 = (char) ((c2 * '\n') + (cMore2 - '0'));
                    cMore2 = more();
                }
                if (cMore2 != ';') {
                    StringBuffer stringBuffer2 = new StringBuffer("character reference (with decimal value) may not contain ");
                    stringBuffer2.append(printable(cMore2));
                    throw new XmlPullParserException(stringBuffer2.toString(), this, null);
                }
                c = c2;
            }
            this.posEnd = this.pos - 1;
            char[] cArr = this.charRefOneCharBuf;
            cArr[0] = c;
            if (this.tokenize) {
                this.text = newString(cArr, 0, 1);
            }
            return this.charRefOneCharBuf;
        }
        while (more() != ';') {
        }
        int i3 = this.pos - 1;
        this.posEnd = i3;
        int i4 = this.posStart;
        int i5 = i3 - i4;
        if (i5 == 2) {
            char[] cArr2 = this.buf;
            if (cArr2[i4] == 'l' && cArr2[i4 + 1] == 't') {
                if (this.tokenize) {
                    this.text = "<";
                }
                char[] cArr3 = this.charRefOneCharBuf;
                cArr3[0] = '<';
                return cArr3;
            }
        }
        if (i5 == 3) {
            char[] cArr4 = this.buf;
            if (cArr4[i4] == 'a' && cArr4[i4 + 1] == 'm' && cArr4[i4 + 2] == 'p') {
                if (this.tokenize) {
                    this.text = "&";
                }
                char[] cArr5 = this.charRefOneCharBuf;
                cArr5[0] = '&';
                return cArr5;
            }
        }
        if (i5 == 2) {
            char[] cArr6 = this.buf;
            if (cArr6[i4] == 'g' && cArr6[i4 + 1] == 't') {
                if (this.tokenize) {
                    this.text = ">";
                }
                char[] cArr7 = this.charRefOneCharBuf;
                cArr7[0] = '>';
                return cArr7;
            }
        }
        if (i5 == 4) {
            char[] cArr8 = this.buf;
            if (cArr8[i4] == 'a' && cArr8[i4 + 1] == 'p' && cArr8[i4 + 2] == 'o' && cArr8[i4 + 3] == 's') {
                if (this.tokenize) {
                    this.text = "'";
                }
                char[] cArr9 = this.charRefOneCharBuf;
                cArr9[0] = '\'';
                return cArr9;
            }
        }
        if (i5 == 4) {
            char[] cArr10 = this.buf;
            if (cArr10[i4] == 'q' && cArr10[i4 + 1] == 'u' && cArr10[i4 + 2] == 'o' && cArr10[i4 + 3] == 't') {
                if (this.tokenize) {
                    this.text = "\"";
                }
                char[] cArr11 = this.charRefOneCharBuf;
                cArr11[0] = '\"';
                return cArr11;
            }
        }
        char[] cArrLookuEntityReplacement = lookuEntityReplacement(i5);
        if (cArrLookuEntityReplacement != null) {
            return cArrLookuEntityReplacement;
        }
        if (this.tokenize) {
            this.text = null;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int parseEpilog() throws XmlPullParserException, IOException {
        if (this.eventType == 1) {
            w32.a("already reached end of XML input", this, null);
            return 0;
        }
        if (this.reachedEnd) {
            this.eventType = 1;
            return 1;
        }
        boolean z = false;
        boolean z2 = this.tokenize && !this.roundtripSupported;
        try {
            char cMore = this.seenMarkup ? this.buf[this.pos - 1] : more();
            this.seenMarkup = false;
            this.posStart = this.pos - 1;
            boolean z3 = false;
            boolean z4 = false;
            while (true) {
                if (cMore == '<') {
                    if (z3) {
                        try {
                            if (this.tokenize) {
                                this.posEnd = this.pos - 1;
                                this.seenMarkup = true;
                                this.eventType = 7;
                                return 7;
                            }
                        } catch (EOFException unused) {
                            z = z3;
                            this.reachedEnd = true;
                            if (this.tokenize) {
                            }
                            this.eventType = 1;
                            return 1;
                        }
                    }
                    char cMore2 = more();
                    if (cMore2 == '?') {
                        parsePI();
                        if (this.tokenize) {
                            this.eventType = 8;
                            return 8;
                        }
                    } else {
                        if (cMore2 != '!') {
                            if (cMore2 == '/') {
                                StringBuffer stringBuffer = new StringBuffer();
                                stringBuffer.append("end tag not allowed in epilog but got ");
                                stringBuffer.append(printable(cMore2));
                                throw new XmlPullParserException(stringBuffer.toString(), this, null);
                            }
                            if (isNameStartChar(cMore2)) {
                                StringBuffer stringBuffer2 = new StringBuffer();
                                stringBuffer2.append("start tag not allowed in epilog but got ");
                                stringBuffer2.append(printable(cMore2));
                                throw new XmlPullParserException(stringBuffer2.toString(), this, null);
                            }
                            StringBuffer stringBuffer3 = new StringBuffer();
                            stringBuffer3.append("in epilog expected ignorable content and not ");
                            stringBuffer3.append(printable(cMore2));
                            throw new XmlPullParserException(stringBuffer3.toString(), this, null);
                        }
                        char cMore3 = more();
                        if (cMore3 == 'D') {
                            parseDocdecl();
                            if (this.tokenize) {
                                this.eventType = 10;
                                return 10;
                            }
                        } else {
                            if (cMore3 != '-') {
                                StringBuffer stringBuffer4 = new StringBuffer();
                                stringBuffer4.append("unexpected markup <!");
                                stringBuffer4.append(printable(cMore3));
                                throw new XmlPullParserException(stringBuffer4.toString(), this, null);
                            }
                            parseComment();
                            if (this.tokenize) {
                                this.eventType = 9;
                                return 9;
                            }
                        }
                    }
                    cMore = more();
                } else {
                    if (!isS(cMore)) {
                        StringBuffer stringBuffer5 = new StringBuffer();
                        stringBuffer5.append("in epilog non whitespace content is not allowed but got ");
                        stringBuffer5.append(printable(cMore));
                        throw new XmlPullParserException(stringBuffer5.toString(), this, null);
                    }
                    if (!z2) {
                        z3 = true;
                    } else if (cMore == '\r') {
                        try {
                            if (!this.usePC) {
                                int i = this.pos - 1;
                                this.posEnd = i;
                                if (i > this.posStart) {
                                    joinPC();
                                } else {
                                    this.usePC = true;
                                    this.pcEnd = 0;
                                    this.pcStart = 0;
                                }
                            }
                            int i2 = this.pcEnd;
                            if (i2 >= this.pc.length) {
                                ensurePC(i2);
                            }
                            char[] cArr = this.pc;
                            int i3 = this.pcEnd;
                            this.pcEnd = i3 + 1;
                            cArr[i3] = '\n';
                            z3 = true;
                            z4 = true;
                        } catch (EOFException unused2) {
                            z = true;
                            this.reachedEnd = true;
                            if (this.tokenize || !z) {
                                this.eventType = 1;
                                return 1;
                            }
                            this.posEnd = this.pos;
                            this.eventType = 7;
                            return 7;
                        }
                    } else {
                        if (cMore == '\n') {
                            if (!z4 && this.usePC) {
                                int i4 = this.pcEnd;
                                if (i4 >= this.pc.length) {
                                    ensurePC(i4);
                                }
                                char[] cArr2 = this.pc;
                                int i5 = this.pcEnd;
                                this.pcEnd = i5 + 1;
                                cArr2[i5] = '\n';
                            }
                        } else if (this.usePC) {
                            int i6 = this.pcEnd;
                            if (i6 >= this.pc.length) {
                                ensurePC(i6);
                            }
                            char[] cArr3 = this.pc;
                            int i7 = this.pcEnd;
                            this.pcEnd = i7 + 1;
                            cArr3[i7] = cMore;
                        }
                        z3 = true;
                        z4 = false;
                    }
                    cMore = more();
                }
            }
        } catch (EOFException unused3) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:107:0x010d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c A[PHI: r8
      0x006c: PHI (r8v2 int) = (r8v1 int), (r8v1 int), (r8v6 int), (r8v6 int) binds: [B:27:0x004c, B:29:0x0052, B:31:0x005d, B:35:0x0069] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00fe A[Catch: EOFException -> 0x00a3, TryCatch #0 {EOFException -> 0x00a3, blocks: (B:12:0x0021, B:69:0x00d7, B:71:0x00db, B:73:0x00e5, B:75:0x00ed, B:76:0x00f7, B:78:0x00fe, B:79:0x0101, B:84:0x0118, B:86:0x011c, B:88:0x0123, B:89:0x0126, B:91:0x0133, B:93:0x0137, B:95:0x013e, B:96:0x0141, B:28:0x004e, B:30:0x0054, B:32:0x005f, B:38:0x0071, B:44:0x0083, B:54:0x009b, B:55:0x00a2, B:58:0x00a6, B:60:0x00ad, B:61:0x00b3, B:63:0x00c5, B:64:0x00cc), top: B:101:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x014c  */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r17v5 */
    /* JADX WARN: Type inference failed for: r17v6 */
    /* JADX WARN: Type inference failed for: r17v7 */
    /* JADX WARN: Type inference failed for: r17v8 */
    /* JADX WARN: Type inference failed for: r17v9 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean parsePI() throws XmlPullParserException, IOException {
        char cMore;
        ?? r17;
        int i;
        ?? r9;
        char[] cArr;
        char c;
        char c2;
        char c3;
        ?? r172;
        ?? r92;
        ?? r173;
        ?? r6;
        ?? r5;
        int i2;
        boolean z = this.tokenize;
        if (z) {
            this.posStart = this.pos;
        }
        int i3 = this.lineNumber;
        int i4 = this.columnNumber;
        int i5 = this.pos + this.bufAbsoluteStart;
        ?? r62 = 1;
        boolean z2 = z && !this.roundtripSupported;
        int i6 = -1;
        int i7 = -1;
        ?? r93 = 0;
        int i8 = 0;
        while (true) {
            try {
                cMore = more();
                if (cMore == '?') {
                    ?? r94 = r62;
                    r172 = r94 == true ? 1 : 0;
                    r92 = r94;
                } else if (cMore != '>') {
                    if (i7 == i6 && isS(cMore)) {
                        i7 = (this.pos - r62) + this.bufAbsoluteStart;
                        if (i7 - i5 == 3 && ((c = (cArr = this.buf)[i5]) == 'x' || c == 'X')) {
                            c2 = cArr[i5 + 1];
                            i = 0;
                            if (c2 == 'm' || c2 == 'M') {
                                c3 = cArr[i5 + 2];
                                if (c3 == 'l') {
                                    break;
                                }
                                r17 = r62;
                                if (c3 == 'L') {
                                    break;
                                }
                            } else {
                                r17 = r62;
                            }
                        }
                        r9 = i;
                        r173 = r17;
                    } else {
                        r17 = r62;
                        i = 0;
                        r9 = i;
                        r173 = r17;
                    }
                    if (z2) {
                        r6 = r173;
                    } else if (cMore != '\r') {
                        int i9 = i;
                        ?? r52 = r173;
                        if (cMore == '\n') {
                            if (i8 == 0 && this.usePC) {
                                int i10 = this.pcEnd;
                                if (i10 >= this.pc.length) {
                                    ensurePC(i10);
                                }
                                char[] cArr2 = this.pc;
                                int i11 = this.pcEnd;
                                this.pcEnd = i11 + 1;
                                cArr2[i11] = '\n';
                            }
                        } else if (this.usePC) {
                            int i12 = this.pcEnd;
                            if (i12 >= this.pc.length) {
                                ensurePC(i12);
                            }
                            char[] cArr3 = this.pc;
                            int i13 = this.pcEnd;
                            this.pcEnd = i13 + 1;
                            cArr3[i13] = cMore;
                        }
                        r6 = r52 == true ? 1 : 0;
                        i8 = i9;
                    } else if (this.usePC) {
                        r5 = r173;
                        i2 = this.pcEnd;
                        if (i2 >= this.pc.length) {
                        }
                        char[] cArr4 = this.pc;
                        int i14 = this.pcEnd;
                        this.pcEnd = i14 + 1;
                        cArr4[i14] = '\n';
                        r6 = r5;
                        i8 = r6 == true ? 1 : 0;
                    } else {
                        int i15 = this.pos - 1;
                        this.posEnd = i15;
                        if (i15 > this.posStart) {
                            joinPC();
                            r5 = r173;
                            i2 = this.pcEnd;
                            if (i2 >= this.pc.length) {
                                ensurePC(i2);
                            }
                            char[] cArr42 = this.pc;
                            int i142 = this.pcEnd;
                            this.pcEnd = i142 + 1;
                            cArr42[i142] = '\n';
                            r6 = r5;
                            i8 = r6 == true ? 1 : 0;
                        } else {
                            ?? r53 = r173;
                            this.usePC = r53;
                            int i16 = i;
                            this.pcEnd = i16;
                            this.pcStart = i16;
                            r5 = r53;
                            i2 = this.pcEnd;
                            if (i2 >= this.pc.length) {
                            }
                            char[] cArr422 = this.pc;
                            int i1422 = this.pcEnd;
                            this.pcEnd = i1422 + 1;
                            cArr422[i1422] = '\n';
                            r6 = r5;
                            i8 = r6 == true ? 1 : 0;
                        }
                    }
                    i6 = -1;
                    r62 = r6;
                    r93 = r9;
                } else {
                    if (r93 != 0) {
                        if (this.tokenize) {
                            this.posEnd = this.pos - 2;
                            if (z2) {
                                this.pcEnd -= r62;
                            }
                        }
                        return r62;
                    }
                    r172 = r62;
                    r92 = 0;
                }
                i = 0;
                r9 = r92;
                r173 = r172;
                if (z2) {
                }
                i6 = -1;
                r62 = r6;
                r93 = r9;
            } catch (EOFException e) {
                StringBuffer stringBuffer = new StringBuffer("processing instruction started on line ");
                stringBuffer.append(i3);
                stringBuffer.append(" and column ");
                stringBuffer.append(i4);
                stringBuffer.append(" was not closed");
                throw new XmlPullParserException(stringBuffer.toString(), this, e);
            }
        }
        if (i5 > 3) {
            throw new XmlPullParserException("processing instruction can not have PITarget with reserveld xml name", this, null);
        }
        if (c != 'x' && c2 != 'm' && c3 != 'l') {
            throw new XmlPullParserException("XMLDecl must have xml name in lowercase", this, null);
        }
        parseXmlDecl(cMore);
        if (this.tokenize) {
            this.posEnd = this.pos - 2;
        }
        int i17 = (i5 - this.bufAbsoluteStart) + 3;
        this.xmlDeclContent = newString(this.buf, i17, (this.pos - 2) - i17);
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int parseProlog() throws XmlPullParserException, IOException {
        char cMore = this.seenMarkup ? this.buf[this.pos - 1] : more();
        if (this.eventType == 0) {
            if (cMore == 65534) {
                w32.a("first character in input was UNICODE noncharacter (0xFFFE)- input requires int swapping", this, null);
                return 0;
            }
            if (cMore == 65279) {
                cMore = more();
            }
        }
        this.seenMarkup = false;
        this.posStart = this.pos - 1;
        boolean z = this.tokenize && !this.roundtripSupported;
        boolean z2 = false;
        boolean z3 = false;
        while (true) {
            if (cMore == '<') {
                if (z2 && this.tokenize) {
                    this.posEnd = this.pos - 1;
                    this.seenMarkup = true;
                    this.eventType = 7;
                    return 7;
                }
                char cMore2 = more();
                if (cMore2 == '?') {
                    if (!parsePI()) {
                        this.posStart = this.pos;
                        z2 = false;
                    } else if (this.tokenize) {
                        this.eventType = 8;
                        return 8;
                    }
                } else {
                    if (cMore2 != '!') {
                        if (cMore2 == '/') {
                            StringBuffer stringBuffer = new StringBuffer("expected start tag name and not ");
                            stringBuffer.append(printable(cMore2));
                            throw new XmlPullParserException(stringBuffer.toString(), this, null);
                        }
                        if (isNameStartChar(cMore2)) {
                            this.seenRoot = true;
                            return parseStartTag();
                        }
                        StringBuffer stringBuffer2 = new StringBuffer("expected start tag name and not ");
                        stringBuffer2.append(printable(cMore2));
                        throw new XmlPullParserException(stringBuffer2.toString(), this, null);
                    }
                    char cMore3 = more();
                    if (cMore3 == 'D') {
                        if (this.seenDocdecl) {
                            w32.a("only one docdecl allowed in XML document", this, null);
                            return 0;
                        }
                        this.seenDocdecl = true;
                        parseDocdecl();
                        if (this.tokenize) {
                            this.eventType = 10;
                            return 10;
                        }
                    } else {
                        if (cMore3 != '-') {
                            StringBuffer stringBuffer3 = new StringBuffer("unexpected markup <!");
                            stringBuffer3.append(printable(cMore3));
                            throw new XmlPullParserException(stringBuffer3.toString(), this, null);
                        }
                        parseComment();
                        if (this.tokenize) {
                            this.eventType = 9;
                            return 9;
                        }
                    }
                }
            } else {
                if (!isS(cMore)) {
                    StringBuffer stringBuffer4 = new StringBuffer("only whitespace content allowed before start tag and not ");
                    stringBuffer4.append(printable(cMore));
                    throw new XmlPullParserException(stringBuffer4.toString(), this, null);
                }
                if (!z) {
                    z2 = true;
                } else if (cMore == '\r') {
                    if (!this.usePC) {
                        int i = this.pos - 1;
                        this.posEnd = i;
                        if (i > this.posStart) {
                            joinPC();
                        } else {
                            this.usePC = true;
                            this.pcEnd = 0;
                            this.pcStart = 0;
                        }
                    }
                    int i2 = this.pcEnd;
                    if (i2 >= this.pc.length) {
                        ensurePC(i2);
                    }
                    char[] cArr = this.pc;
                    int i3 = this.pcEnd;
                    this.pcEnd = i3 + 1;
                    cArr[i3] = '\n';
                    z2 = true;
                    z3 = true;
                } else {
                    if (cMore == '\n') {
                        if (!z3 && this.usePC) {
                            int i4 = this.pcEnd;
                            if (i4 >= this.pc.length) {
                                ensurePC(i4);
                            }
                            char[] cArr2 = this.pc;
                            int i5 = this.pcEnd;
                            this.pcEnd = i5 + 1;
                            cArr2[i5] = '\n';
                        }
                    } else if (this.usePC) {
                        int i6 = this.pcEnd;
                        if (i6 >= this.pc.length) {
                            ensurePC(i6);
                        }
                        char[] cArr3 = this.pc;
                        int i7 = this.pcEnd;
                        this.pcEnd = i7 + 1;
                        cArr3[i7] = cMore;
                    }
                    z2 = true;
                    z3 = false;
                }
            }
            cMore = more();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0263 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x00bb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01bb A[LOOP:5: B:84:0x01bb->B:90:0x01d1, LOOP_START, PHI: r1
      0x01bb: PHI (r1v1 int) = (r1v0 int), (r1v2 int) binds: [B:37:0x00d6, B:90:0x01d1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int parseStartTag() throws XmlPullParserException, IOException {
        String strNewString;
        this.depth++;
        int i = this.pos;
        this.posStart = i - 2;
        this.emptyElementTag = false;
        this.attributeCount = 0;
        int i2 = (i - 1) + this.bufAbsoluteStart;
        if (this.buf[i - 1] == ':' && this.processNamespaces) {
            w32.a("when namespaces processing enabled colon can not be at element name start", this, null);
            return 0;
        }
        int i3 = -1;
        while (true) {
            char cMore = more();
            if (!isNameChar(cMore)) {
                ensureElementsCapacity();
                int i4 = this.pos - 1;
                int i5 = this.bufAbsoluteStart;
                int i6 = i4 - (i2 - i5);
                char[][] cArr = this.elRawName;
                int i7 = this.depth;
                char[] cArr2 = cArr[i7];
                if (cArr2 == null || cArr2.length < i6) {
                    cArr[i7] = new char[i6 * 2];
                }
                System.arraycopy(this.buf, i2 - i5, cArr[i7], 0, i6);
                int[] iArr = this.elRawNameEnd;
                int i8 = this.depth;
                iArr[i8] = i6;
                this.elRawNameLine[i8] = this.lineNumber;
                if (this.processNamespaces) {
                    String[] strArr = this.elPrefix;
                    if (i3 != -1) {
                        strNewString = newString(this.buf, i2 - this.bufAbsoluteStart, i3 - i2);
                        strArr[i8] = strNewString;
                        String[] strArr2 = this.elName;
                        int i9 = this.depth;
                        char[] cArr3 = this.buf;
                        int i10 = this.bufAbsoluteStart;
                        strArr2[i9] = newString(cArr3, (i3 + 1) - i10, (this.pos - 2) - (i3 - i10));
                        while (true) {
                            if (!isS(cMore)) {
                                cMore = more();
                            } else {
                                if (cMore == '>') {
                                    break;
                                }
                                if (cMore == '/') {
                                    if (this.emptyElementTag) {
                                        w32.a("repeated / in tag declaration", this, null);
                                        return 0;
                                    }
                                    this.emptyElementTag = true;
                                    char cMore2 = more();
                                    if (cMore2 != '>') {
                                        StringBuffer stringBuffer = new StringBuffer("expected > to end empty tag not ");
                                        stringBuffer.append(printable(cMore2));
                                        throw new XmlPullParserException(stringBuffer.toString(), this, null);
                                    }
                                } else {
                                    if (!isNameStartChar(cMore)) {
                                        StringBuffer stringBuffer2 = new StringBuffer("start tag unexpected character ");
                                        stringBuffer2.append(printable(cMore));
                                        throw new XmlPullParserException(stringBuffer2.toString(), this, null);
                                    }
                                    parseAttribute();
                                    cMore = more();
                                }
                            }
                        }
                        if (this.processNamespaces) {
                            for (int i11 = 1; i11 < this.attributeCount; i11++) {
                                for (int i12 = 0; i12 < i11; i12++) {
                                    if (this.allStringsInterned) {
                                        Object[] objArr = this.attributeName;
                                        if (!objArr[i12].equals(objArr[i11])) {
                                            if (!this.allStringsInterned) {
                                                int[] iArr2 = this.attributeNameHash;
                                                if (iArr2[i12] == iArr2[i11]) {
                                                    Object[] objArr2 = this.attributeName;
                                                    if (!objArr2[i12].equals(objArr2[i11])) {
                                                    }
                                                } else {
                                                    continue;
                                                }
                                            }
                                        }
                                    }
                                    String[] strArr3 = this.attributeName;
                                    String str = strArr3[i12];
                                    String str2 = strArr3[i11];
                                    StringBuffer stringBuffer3 = new StringBuffer("duplicated attributes ");
                                    stringBuffer3.append(str);
                                    stringBuffer3.append(" and ");
                                    stringBuffer3.append(str2);
                                    throw new XmlPullParserException(stringBuffer3.toString(), this, null);
                                }
                            }
                        } else {
                            String namespace = getNamespace(strNewString);
                            if (namespace == null) {
                                if (strNewString != null) {
                                    throw new XmlPullParserException("could not determine namespace bound to element prefix ".concat(strNewString), this, null);
                                }
                                namespace = "";
                            }
                            this.elUri[this.depth] = namespace;
                            for (int i13 = 0; i13 < this.attributeCount; i13++) {
                                String str3 = this.attributePrefix[i13];
                                if (str3 != null) {
                                    String namespace2 = getNamespace(str3);
                                    if (namespace2 == null) {
                                        throw new XmlPullParserException("could not determine namespace bound to attribute prefix ".concat(str3), this, null);
                                    }
                                    this.attributeUri[i13] = namespace2;
                                } else {
                                    this.attributeUri[i13] = "";
                                }
                            }
                            for (int i14 = 1; i14 < this.attributeCount; i14++) {
                                for (int i15 = 0; i15 < i14; i15++) {
                                    String[] strArr4 = this.attributeUri;
                                    if (strArr4[i15] == strArr4[i14]) {
                                        if (this.allStringsInterned) {
                                            Object[] objArr3 = this.attributeName;
                                            if (!objArr3[i15].equals(objArr3[i14])) {
                                            }
                                            String string = this.attributeName[i15];
                                            if (this.attributeUri[i15] != null) {
                                                StringBuffer stringBuffer4 = new StringBuffer();
                                                stringBuffer4.append(this.attributeUri[i15]);
                                                stringBuffer4.append(":");
                                                stringBuffer4.append(string);
                                                string = stringBuffer4.toString();
                                            }
                                            String string2 = this.attributeName[i14];
                                            if (this.attributeUri[i14] != null) {
                                                StringBuffer stringBuffer5 = new StringBuffer();
                                                stringBuffer5.append(this.attributeUri[i14]);
                                                stringBuffer5.append(":");
                                                stringBuffer5.append(string2);
                                                string2 = stringBuffer5.toString();
                                            }
                                            StringBuffer stringBuffer6 = new StringBuffer("duplicated attributes ");
                                            stringBuffer6.append(string);
                                            stringBuffer6.append(" and ");
                                            stringBuffer6.append(string2);
                                            throw new XmlPullParserException(stringBuffer6.toString(), this, null);
                                        }
                                        if (this.allStringsInterned) {
                                            continue;
                                        } else {
                                            int[] iArr3 = this.attributeNameHash;
                                            if (iArr3[i15] == iArr3[i14]) {
                                                Object[] objArr4 = this.attributeName;
                                                if (objArr4[i15].equals(objArr4[i14])) {
                                                    String string3 = this.attributeName[i15];
                                                    if (this.attributeUri[i15] != null) {
                                                    }
                                                    String string22 = this.attributeName[i14];
                                                    if (this.attributeUri[i14] != null) {
                                                    }
                                                    StringBuffer stringBuffer62 = new StringBuffer("duplicated attributes ");
                                                    stringBuffer62.append(string3);
                                                    stringBuffer62.append(" and ");
                                                    stringBuffer62.append(string22);
                                                    throw new XmlPullParserException(stringBuffer62.toString(), this, null);
                                                }
                                            } else {
                                                continue;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        this.elNamespaceCount[this.depth] = this.namespaceEnd;
                        this.posEnd = this.pos;
                        this.eventType = 2;
                        return 2;
                    }
                    strArr[i8] = null;
                    this.elName[i8] = newString(this.buf, i2 - this.bufAbsoluteStart, i6);
                } else {
                    this.elName[i8] = newString(this.buf, i2 - this.bufAbsoluteStart, i6);
                }
                strNewString = null;
                while (true) {
                    if (!isS(cMore)) {
                    }
                }
                if (this.processNamespaces) {
                }
                this.elNamespaceCount[this.depth] = this.namespaceEnd;
                this.posEnd = this.pos;
                this.eventType = 2;
                return 2;
            }
            if (cMore == ':' && this.processNamespaces) {
                if (i3 != -1) {
                    w32.a("only one colon is allowed in name of element when namespaces are enabled", this, null);
                    return 0;
                }
                i3 = (this.pos - 1) + this.bufAbsoluteStart;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void parseXmlDecl(char c) throws XmlPullParserException, IOException {
        this.preventBufferCompaction = true;
        this.bufStart = 0;
        char cSkipS = skipS(requireInput(skipS(c), VERSION));
        if (cSkipS != '=') {
            StringBuffer stringBuffer = new StringBuffer("expected equals sign (=) after version and not ");
            stringBuffer.append(printable(cSkipS));
            throw new XmlPullParserException(stringBuffer.toString(), this, null);
        }
        char cSkipS2 = skipS(more());
        if (cSkipS2 != '\'' && cSkipS2 != '\"') {
            StringBuffer stringBuffer2 = new StringBuffer("expected apostrophe (') or quotation mark (\") after version and not ");
            stringBuffer2.append(printable(cSkipS2));
            throw new XmlPullParserException(stringBuffer2.toString(), this, null);
        }
        int i = this.pos;
        char cMore = more();
        while (cMore != cSkipS2) {
            if ((cMore < 'a' || cMore > 'z') && ((cMore < 'A' || cMore > 'Z') && !((cMore >= '0' && cMore <= '9') || cMore == '_' || cMore == '.' || cMore == ':' || cMore == '-'))) {
                StringBuffer stringBuffer3 = new StringBuffer("<?xml version value expected to be in ([a-zA-Z0-9_.:] | '-') not ");
                stringBuffer3.append(printable(cMore));
                throw new XmlPullParserException(stringBuffer3.toString(), this, null);
            }
            cMore = more();
        }
        parseXmlDeclWithVersion(i, this.pos - 1);
        this.preventBufferCompaction = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void parseXmlDeclWithVersion(int i, int i2) throws XmlPullParserException, IOException {
        char cRequireInput;
        int i3 = i2 - i;
        if (i3 == 3) {
            char[] cArr = this.buf;
            if (cArr[i] == '1' && cArr[i + 1] == '.') {
                char c = '0';
                if (cArr[i + 2] == '0') {
                    this.xmlDeclVersion = newString(cArr, i, i3);
                    char cSkipS = skipS(more());
                    if (cSkipS == 'e') {
                        char cSkipS2 = skipS(requireInput(more(), NCODING));
                        if (cSkipS2 != '=') {
                            StringBuffer stringBuffer = new StringBuffer("expected equals sign (=) after encoding and not ");
                            stringBuffer.append(printable(cSkipS2));
                            throw new XmlPullParserException(stringBuffer.toString(), this, null);
                        }
                        char cSkipS3 = skipS(more());
                        if (cSkipS3 != '\'' && cSkipS3 != '\"') {
                            StringBuffer stringBuffer2 = new StringBuffer("expected apostrophe (') or quotation mark (\") after encoding and not ");
                            stringBuffer2.append(printable(cSkipS3));
                            throw new XmlPullParserException(stringBuffer2.toString(), this, null);
                        }
                        int i4 = this.pos;
                        char cMore = more();
                        if ((cMore < 'a' || cMore > 'z') && (cMore < 'A' || cMore > 'Z')) {
                            StringBuffer stringBuffer3 = new StringBuffer("<?xml encoding name expected to start with [A-Za-z] not ");
                            stringBuffer3.append(printable(cMore));
                            throw new XmlPullParserException(stringBuffer3.toString(), this, null);
                        }
                        char cMore2 = more();
                        while (cMore2 != cSkipS3) {
                            if ((cMore2 < 'a' || cMore2 > 'z') && ((cMore2 < 'A' || cMore2 > 'Z') && !((cMore2 >= c && cMore2 <= '9') || cMore2 == '.' || cMore2 == '_' || cMore2 == '-'))) {
                                StringBuffer stringBuffer4 = new StringBuffer("<?xml encoding value expected to be in ([A-Za-z0-9._] | '-') not ");
                                stringBuffer4.append(printable(cMore2));
                                throw new XmlPullParserException(stringBuffer4.toString(), this, null);
                            }
                            cMore2 = more();
                            c = '0';
                        }
                        this.inputEncoding = newString(this.buf, i4, (this.pos - 1) - i4);
                        cSkipS = more();
                    }
                    char cSkipS4 = skipS(cSkipS);
                    if (cSkipS4 == 's') {
                        char cSkipS5 = skipS(requireInput(more(), TANDALONE));
                        if (cSkipS5 != '=') {
                            StringBuffer stringBuffer5 = new StringBuffer("expected equals sign (=) after standalone and not ");
                            stringBuffer5.append(printable(cSkipS5));
                            throw new XmlPullParserException(stringBuffer5.toString(), this, null);
                        }
                        char cSkipS6 = skipS(more());
                        if (cSkipS6 != '\'' && cSkipS6 != '\"') {
                            StringBuffer stringBuffer6 = new StringBuffer("expected apostrophe (') or quotation mark (\") after encoding and not ");
                            stringBuffer6.append(printable(cSkipS6));
                            throw new XmlPullParserException(stringBuffer6.toString(), this, null);
                        }
                        char cMore3 = more();
                        if (cMore3 == 'y') {
                            cRequireInput = requireInput(cMore3, YES);
                            this.xmlDeclStandalone = new Boolean(true);
                        } else {
                            if (cMore3 != 'n') {
                                StringBuffer stringBuffer7 = new StringBuffer("expected 'yes' or 'no' after standalone and not ");
                                stringBuffer7.append(printable(cMore3));
                                throw new XmlPullParserException(stringBuffer7.toString(), this, null);
                            }
                            cRequireInput = requireInput(cMore3, NO);
                            this.xmlDeclStandalone = new Boolean(false);
                        }
                        if (cRequireInput != cSkipS6) {
                            StringBuffer stringBuffer8 = new StringBuffer("expected ");
                            stringBuffer8.append(cSkipS6);
                            stringBuffer8.append(" after standalone value not ");
                            stringBuffer8.append(printable(cRequireInput));
                            throw new XmlPullParserException(stringBuffer8.toString(), this, null);
                        }
                        cSkipS4 = more();
                    }
                    char cSkipS7 = skipS(cSkipS4);
                    if (cSkipS7 != '?') {
                        StringBuffer stringBuffer9 = new StringBuffer("expected ?> as last part of <?xml not ");
                        stringBuffer9.append(printable(cSkipS7));
                        throw new XmlPullParserException(stringBuffer9.toString(), this, null);
                    }
                    char cMore4 = more();
                    if (cMore4 == '>') {
                        return;
                    }
                    StringBuffer stringBuffer10 = new StringBuffer("expected ?> as last part of <?xml not ");
                    stringBuffer10.append(printable(cMore4));
                    throw new XmlPullParserException(stringBuffer10.toString(), this, null);
                }
            }
        }
        StringBuffer stringBuffer11 = new StringBuffer("only 1.0 is supported as <?xml version not '");
        stringBuffer11.append(printable(new String(this.buf, i, i3)));
        stringBuffer11.append("'");
        throw new XmlPullParserException(stringBuffer11.toString(), this, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String printable(char c) {
        if (c == '\n') {
            return "\\n";
        }
        if (c == '\r') {
            return "\\r";
        }
        if (c == '\t') {
            return "\\t";
        }
        if (c == '\'') {
            return "\\'";
        }
        if (c > 127 || c < ' ') {
            StringBuffer stringBuffer = new StringBuffer("\\u");
            stringBuffer.append(Integer.toHexString(c));
            return stringBuffer.toString();
        }
        StringBuffer stringBuffer2 = new StringBuffer("");
        stringBuffer2.append(c);
        return stringBuffer2.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public void require(int i, String str, String str2) throws XmlPullParserException {
        String string;
        String string2;
        String string3;
        String string4;
        if (!this.processNamespaces && str != null) {
            StringBuffer stringBuffer = new StringBuffer("processing namespaces must be enabled on parser (or factory) to have possible namespaces delcared on elements (postion:");
            stringBuffer.append(getPositionDescription());
            stringBuffer.append(")");
            throw new XmlPullParserException(stringBuffer.toString());
        }
        if (i == getEventType() && ((str == null || str.equals(getNamespace())) && (str2 == null || str2.equals(getName())))) {
            return;
        }
        StringBuffer stringBuffer2 = new StringBuffer("expected event ");
        String[] strArr = XmlPullParser.TYPES;
        stringBuffer2.append(strArr[i]);
        String string5 = "";
        if (str2 != null) {
            StringBuffer stringBuffer3 = new StringBuffer(" with name '");
            stringBuffer3.append(str2);
            stringBuffer3.append("'");
            string = stringBuffer3.toString();
        } else {
            string = "";
        }
        stringBuffer2.append(string);
        stringBuffer2.append((str == null || str2 == null) ? "" : " and");
        if (str != null) {
            StringBuffer stringBuffer4 = new StringBuffer(" with namespace '");
            stringBuffer4.append(str);
            stringBuffer4.append("'");
            string2 = stringBuffer4.toString();
        } else {
            string2 = "";
        }
        stringBuffer2.append(string2);
        stringBuffer2.append(" but got");
        if (i != getEventType()) {
            StringBuffer stringBuffer5 = new StringBuffer(" ");
            stringBuffer5.append(strArr[getEventType()]);
            string3 = stringBuffer5.toString();
        } else {
            string3 = "";
        }
        stringBuffer2.append(string3);
        if (str2 == null || getName() == null || str2.equals(getName())) {
            string4 = "";
        } else {
            StringBuffer stringBuffer6 = new StringBuffer(" name '");
            stringBuffer6.append(getName());
            stringBuffer6.append("'");
            string4 = stringBuffer6.toString();
        }
        stringBuffer2.append(string4);
        stringBuffer2.append((str == null || str2 == null || getName() == null || str2.equals(getName()) || getNamespace() == null || str.equals(getNamespace())) ? "" : " and");
        if (str != null && getNamespace() != null && !str.equals(getNamespace())) {
            StringBuffer stringBuffer7 = new StringBuffer(" namespace '");
            stringBuffer7.append(getNamespace());
            stringBuffer7.append("'");
            string5 = stringBuffer7.toString();
        }
        stringBuffer2.append(string5);
        stringBuffer2.append(" (postion:");
        stringBuffer2.append(getPositionDescription());
        stringBuffer2.append(")");
        throw new XmlPullParserException(stringBuffer2.toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public char requireInput(char c, char[] cArr) throws XmlPullParserException, IOException {
        for (int i = 0; i < cArr.length; i++) {
            if (c != cArr[i]) {
                StringBuffer stringBuffer = new StringBuffer("expected ");
                stringBuffer.append(printable(cArr[i]));
                stringBuffer.append(" in ");
                stringBuffer.append(new String(cArr));
                stringBuffer.append(" and not ");
                stringBuffer.append(printable(c));
                throw new XmlPullParserException(stringBuffer.toString(), this, null);
            }
            c = more();
        }
        return c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public char requireNextS() throws XmlPullParserException, IOException {
        char cMore = more();
        if (isS(cMore)) {
            return skipS(cMore);
        }
        StringBuffer stringBuffer = new StringBuffer("white space is required and not ");
        stringBuffer.append(printable(cMore));
        throw new XmlPullParserException(stringBuffer.toString(), this, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void reset() {
        this.lineNumber = 1;
        this.columnNumber = 0;
        this.seenRoot = false;
        this.reachedEnd = false;
        this.eventType = 0;
        this.emptyElementTag = false;
        this.depth = 0;
        this.attributeCount = 0;
        this.namespaceEnd = 0;
        this.entityEnd = 0;
        this.reader = null;
        this.inputEncoding = null;
        this.preventBufferCompaction = false;
        this.bufAbsoluteStart = 0;
        this.bufStart = 0;
        this.bufEnd = 0;
        this.posEnd = 0;
        this.posStart = 0;
        this.pos = 0;
        this.pcStart = 0;
        this.pcEnd = 0;
        this.usePC = false;
        this.seenStartTag = false;
        this.seenEndTag = false;
        this.pastEndTag = false;
        this.seenAmpersand = false;
        this.seenMarkup = false;
        this.seenDocdecl = false;
        this.xmlDeclVersion = null;
        this.xmlDeclStandalone = null;
        this.xmlDeclContent = null;
        resetStringCache();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void resetStringCache() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public void setFeature(String str, boolean z) throws XmlPullParserException {
        if (str == null) {
            jl.a("feature name should not be null");
            return;
        }
        if (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(str)) {
            if (this.eventType == 0) {
                this.processNamespaces = z;
                return;
            } else {
                w32.a("namespace processing feature can only be changed before parsing", this, null);
                return;
            }
        }
        if (FEATURE_NAMES_INTERNED.equals(str)) {
            if (z) {
                throw new XmlPullParserException("interning names in this implementation is not supported");
            }
        } else if (XmlPullParser.FEATURE_PROCESS_DOCDECL.equals(str)) {
            if (z) {
                throw new XmlPullParserException("processing DOCDECL is not supported");
            }
        } else {
            if (!FEATURE_XML_ROUNDTRIP.equals(str)) {
                throw new XmlPullParserException("unsupporte feature ".concat(str));
            }
            this.roundtripSupported = z;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public void setInput(InputStream inputStream, String str) throws XmlPullParserException {
        InputStreamReader inputStreamReader;
        if (inputStream == null) {
            jl.a("input stream can not be null");
            return;
        }
        if (str != null) {
            try {
                inputStreamReader = new InputStreamReader(inputStream, str);
            } catch (UnsupportedEncodingException e) {
                StringBuffer stringBuffer = new StringBuffer("could not create reader for encoding ");
                stringBuffer.append(str);
                stringBuffer.append(" : ");
                stringBuffer.append(e);
                throw new XmlPullParserException(stringBuffer.toString(), this, e);
            }
        } else {
            inputStreamReader = new InputStreamReader(inputStream);
        }
        setInput(inputStreamReader);
        this.inputEncoding = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlPullParser
    public void setProperty(String str, Object obj) throws XmlPullParserException {
        StringBuffer stringBuffer = new StringBuffer("unsupported property: '");
        stringBuffer.append(str);
        stringBuffer.append("'");
        throw new XmlPullParserException(stringBuffer.toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public char skipS(char c) throws XmlPullParserException, IOException {
        while (isS(c)) {
            c = more();
        }
        return c;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void setInput(Reader reader) {
        reset();
        this.reader = reader;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespace() {
        int i = this.eventType;
        if (i == 2) {
            return this.processNamespaces ? this.elUri[this.depth] : "";
        }
        if (i == 3) {
            return this.processNamespaces ? this.elUri[this.depth] : "";
        }
        return null;
    }

    public String printable(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length + 10);
        for (int i = 0; i < length; i++) {
            stringBuffer.append(printable(str.charAt(i)));
        }
        return stringBuffer.toString();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeValue(int i) {
        if (this.eventType == 2) {
            if (i >= 0 && i < this.attributeCount) {
                return this.attributeValue[i];
            }
            StringBuffer stringBuffer = new StringBuffer("attribute position must be 0..");
            stringBuffer.append(this.attributeCount - 1);
            stringBuffer.append(" and not ");
            stringBuffer.append(i);
            throw new IndexOutOfBoundsException(stringBuffer.toString());
        }
        x32.a("only START_TAG can have attributes");
        return null;
    }
}
