package org.xmlpull.mxp1_serializer;

import defpackage.e04;
import defpackage.jl;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import javax.xml.XMLConstants;
import org.jupnp.xml.DOM;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class MXSerializer implements XmlSerializer {
    private static final boolean TRACE_SIZING = false;
    protected static final String XMLNS_URI = "http://www.w3.org/2000/xmlns/";
    protected static final String XML_URI = "http://www.w3.org/XML/1998/namespace";
    protected static final String[] precomputedPrefixes = new String[32];
    protected boolean attributeUseApostrophe;
    protected int autoDeclaredPrefixes;
    protected boolean doIndent;
    protected String[] elName;
    protected String[] elNamespace;
    protected int[] elNamespaceCount;
    protected boolean finished;
    protected char[] indentationBuf;
    protected int indentationJump;
    protected int maxIndentLevel;
    protected boolean namesInterned;
    protected String[] namespacePrefix;
    protected String[] namespaceUri;
    protected int offsetNewLine;
    protected Writer out;
    protected boolean pastRoot;
    protected boolean seenTag;
    protected boolean setPrefixCalled;
    protected boolean startTagIncomplete;
    protected boolean writeIndentation;
    protected boolean writeLineSepartor;
    protected final String FEATURE_SERIALIZER_ATTVALUE_USE_APOSTROPHE = "http://xmlpull.org/v1/doc/features.html#serializer-attvalue-use-apostrophe";
    protected final String FEATURE_NAMES_INTERNED = "http://xmlpull.org/v1/doc/features.html#names-interned";
    protected final String PROPERTY_SERIALIZER_INDENTATION = "http://xmlpull.org/v1/doc/properties.html#serializer-indentation";
    protected final String PROPERTY_SERIALIZER_LINE_SEPARATOR = "http://xmlpull.org/v1/doc/properties.html#serializer-line-separator";
    protected String indentationString = null;
    protected String lineSeparator = "\n";
    protected int depth = 0;
    protected int namespaceEnd = 0;
    private boolean checkNamesInterned = false;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        int i = 0;
        while (true) {
            String[] strArr = precomputedPrefixes;
            if (i >= strArr.length) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer("n");
            stringBuffer.append(i);
            strArr[i] = stringBuffer.toString().intern();
            i++;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public MXSerializer() {
        String[] strArr = new String[2];
        this.elNamespace = strArr;
        this.elName = new String[strArr.length];
        this.elNamespaceCount = new int[strArr.length];
        String[] strArr2 = new String[8];
        this.namespacePrefix = strArr2;
        this.namespaceUri = new String[strArr2.length];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void addPrintable(StringBuffer stringBuffer, char c) {
        if (c == '\f') {
            stringBuffer.append("\\f");
            return;
        }
        if (c == '\r') {
            stringBuffer.append("\\r");
            return;
        }
        if (c == '\"') {
            stringBuffer.append("\\\"");
            return;
        }
        if (c == '\'') {
            stringBuffer.append("\\'");
            return;
        }
        if (c == '\\') {
            stringBuffer.append("\\\\");
            return;
        }
        switch (c) {
            case '\b':
                stringBuffer.append("\\b");
                break;
            case '\t':
                stringBuffer.append("\\t");
                break;
            case '\n':
                stringBuffer.append("\\n");
                break;
            default:
                if (c >= ' ' && c <= '~') {
                    stringBuffer.append(c);
                } else {
                    StringBuffer stringBuffer2 = new StringBuffer("0000");
                    stringBuffer2.append(Integer.toString(c, 16));
                    String string = stringBuffer2.toString();
                    stringBuffer.append("\\u".concat(string.substring(string.length() - 4, string.length())));
                }
                break;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void checkInterning(String str) {
        if (!this.namesInterned || str == str.intern()) {
            return;
        }
        jl.a("all names passed as arguments must be internedwhen NAMES INTERNED feature is enabled");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String generatePrefix(String str) {
        String strIntern;
        int i = this.autoDeclaredPrefixes + 1;
        this.autoDeclaredPrefixes = i;
        String[] strArr = precomputedPrefixes;
        if (i < strArr.length) {
            strIntern = strArr[i];
        } else {
            StringBuffer stringBuffer = new StringBuffer("n");
            stringBuffer.append(this.autoDeclaredPrefixes);
            strIntern = stringBuffer.toString().intern();
        }
        for (int i2 = this.namespaceEnd - 1; i2 >= 0; i2--) {
            String str2 = this.namespacePrefix[i2];
        }
        if (this.namespaceEnd >= this.namespacePrefix.length) {
            ensureNamespacesCapacity();
        }
        String[] strArr2 = this.namespacePrefix;
        int i3 = this.namespaceEnd;
        strArr2[i3] = strIntern;
        this.namespaceUri[i3] = str;
        this.namespaceEnd = i3 + 1;
        return strIntern;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final String printable(String str) {
        if (str == null) {
            return "null";
        }
        StringBuffer stringBuffer = new StringBuffer(str.length() + 16);
        stringBuffer.append("'");
        for (int i = 0; i < str.length(); i++) {
            addPrintable(stringBuffer, str.charAt(i));
        }
        stringBuffer.append("'");
        return stringBuffer.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void writeNamespaceDeclarations() throws IOException {
        for (int i = this.elNamespaceCount[this.depth - 1]; i < this.namespaceEnd; i++) {
            String str = this.namespacePrefix[i];
            Writer writer = this.out;
            if (str != "") {
                writer.write(" xmlns:");
                this.out.write(this.namespacePrefix[i]);
                this.out.write(61);
            } else {
                writer.write(" xmlns=");
            }
            int i2 = 34;
            this.out.write(this.attributeUseApostrophe ? 39 : 34);
            writeAttributeValue(this.namespaceUri[i], this.out);
            Writer writer2 = this.out;
            if (this.attributeUseApostrophe) {
                i2 = 39;
            }
            writer2.write(i2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer attribute(String str, String str2, String str3) throws IOException {
        if (!this.startTagIncomplete) {
            jl.a("startTag() must be called before attribute()");
            return null;
        }
        this.out.write(32);
        if (str != null && str.length() > 0) {
            if (!this.namesInterned) {
                str = str.intern();
            } else if (this.checkNamesInterned) {
                checkInterning(str);
            }
            String strLookupOrDeclarePrefix = lookupOrDeclarePrefix(str);
            if (strLookupOrDeclarePrefix.length() == 0) {
                strLookupOrDeclarePrefix = generatePrefix(str);
            }
            this.out.write(strLookupOrDeclarePrefix);
            this.out.write(58);
        }
        this.out.write(str2);
        this.out.write(61);
        this.out.write(this.attributeUseApostrophe ? 39 : 34);
        writeAttributeValue(str3, this.out);
        this.out.write(this.attributeUseApostrophe ? 39 : 34);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlSerializer
    public void cdsect(String str) throws IOException {
        if (this.startTagIncomplete || this.setPrefixCalled) {
            closeStartTag();
        }
        if (this.doIndent && this.seenTag) {
            this.seenTag = false;
        }
        this.out.write(DOM.CDATA_BEGIN);
        this.out.write(str);
        this.out.write(DOM.CDATA_END);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void closeStartTag() throws IOException {
        if (this.finished) {
            jl.a("trying to write past already finished output");
            return;
        }
        if (this.setPrefixCalled) {
            jl.a("startTag() must be called immediately after setPrefix()");
            return;
        }
        if (!this.startTagIncomplete) {
            jl.a("trying to close start tag that is not opened");
            return;
        }
        writeNamespaceDeclarations();
        this.out.write(62);
        this.elNamespaceCount[this.depth] = this.namespaceEnd;
        this.startTagIncomplete = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlSerializer
    public void comment(String str) throws IOException {
        if (this.startTagIncomplete || this.setPrefixCalled) {
            closeStartTag();
        }
        if (this.doIndent && this.seenTag) {
            this.seenTag = false;
        }
        this.out.write("<!--");
        this.out.write(str);
        this.out.write("-->");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlSerializer
    public void docdecl(String str) throws IOException {
        if (this.startTagIncomplete || this.setPrefixCalled) {
            closeStartTag();
        }
        if (this.doIndent && this.seenTag) {
            this.seenTag = false;
        }
        this.out.write("<!DOCTYPE");
        this.out.write(str);
        this.out.write(">");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlSerializer
    public void endDocument() throws IOException {
        while (true) {
            int i = this.depth;
            if (i <= 0) {
                this.startTagIncomplete = true;
                this.pastRoot = true;
                this.finished = true;
                this.out.flush();
                return;
            }
            endTag(this.elNamespace[i], this.elName[i]);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer endTag(String str, String str2) throws IOException {
        if (str != null) {
            if (!this.namesInterned) {
                str = str.intern();
            } else if (this.checkNamesInterned) {
                checkInterning(str);
            }
        }
        if (str != this.elNamespace[this.depth]) {
            StringBuffer stringBuffer = new StringBuffer("expected namespace ");
            stringBuffer.append(printable(this.elNamespace[this.depth]));
            stringBuffer.append(" and not ");
            stringBuffer.append(printable(str));
            throw new IllegalArgumentException(stringBuffer.toString());
        }
        if (str2 == null) {
            jl.a("end tag name can not be null");
            return null;
        }
        if (this.checkNamesInterned && this.namesInterned) {
            checkInterning(str2);
        }
        if ((!this.namesInterned && !str2.equals(this.elName[this.depth])) || (this.namesInterned && str2 != this.elName[this.depth])) {
            StringBuffer stringBuffer2 = new StringBuffer("expected element name ");
            stringBuffer2.append(printable(this.elName[this.depth]));
            stringBuffer2.append(" and not ");
            stringBuffer2.append(printable(str2));
            throw new IllegalArgumentException(stringBuffer2.toString());
        }
        if (this.startTagIncomplete) {
            writeNamespaceDeclarations();
            this.out.write(" />");
            this.depth--;
        } else {
            this.depth--;
            if (this.doIndent && this.seenTag) {
                writeIndent();
            }
            this.out.write("</");
            if (str != null && str.length() > 0) {
                String strLookupOrDeclarePrefix = lookupOrDeclarePrefix(str);
                if (strLookupOrDeclarePrefix.length() > 0) {
                    this.out.write(strLookupOrDeclarePrefix);
                    this.out.write(58);
                }
            }
            this.out.write(str2);
            this.out.write(62);
        }
        this.namespaceEnd = this.elNamespaceCount[this.depth];
        this.startTagIncomplete = false;
        this.seenTag = true;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void ensureElementsCapacity() {
        String[] strArr = this.elName;
        int length = strArr.length;
        int i = this.depth;
        int i2 = (i >= 7 ? i * 2 : 8) + 2;
        boolean z = length > 0;
        String[] strArr2 = new String[i2];
        if (z) {
            System.arraycopy(strArr, 0, strArr2, 0, length);
        }
        this.elName = strArr2;
        String[] strArr3 = new String[i2];
        if (z) {
            System.arraycopy(this.elNamespace, 0, strArr3, 0, length);
        }
        this.elNamespace = strArr3;
        int[] iArr = new int[i2];
        if (z) {
            System.arraycopy(this.elNamespaceCount, 0, iArr, 0, length);
        } else {
            iArr[0] = 0;
        }
        this.elNamespaceCount = iArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void ensureNamespacesCapacity() {
        int i = this.namespaceEnd;
        int i2 = i > 7 ? i * 2 : 8;
        String[] strArr = new String[i2];
        String[] strArr2 = new String[i2];
        String[] strArr3 = this.namespacePrefix;
        if (strArr3 != null) {
            System.arraycopy(strArr3, 0, strArr, 0, i);
            System.arraycopy(this.namespaceUri, 0, strArr2, 0, this.namespaceEnd);
        }
        this.namespacePrefix = strArr;
        this.namespaceUri = strArr2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlSerializer
    public void entityRef(String str) throws IOException {
        if (this.startTagIncomplete || this.setPrefixCalled) {
            closeStartTag();
        }
        if (this.doIndent && this.seenTag) {
            this.seenTag = false;
        }
        this.out.write(38);
        this.out.write(str);
        this.out.write(59);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlSerializer
    public void flush() throws IOException {
        if (this.startTagIncomplete) {
            closeStartTag();
        }
        this.out.flush();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlSerializer
    public int getDepth() {
        return this.depth;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlSerializer
    public boolean getFeature(String str) {
        if (str == null) {
            jl.a("feature name can not be null");
            return false;
        }
        if ("http://xmlpull.org/v1/doc/features.html#names-interned".equals(str)) {
            return this.namesInterned;
        }
        if ("http://xmlpull.org/v1/doc/features.html#serializer-attvalue-use-apostrophe".equals(str)) {
            return this.attributeUseApostrophe;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlSerializer
    public String getName() {
        return this.elName[this.depth];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlSerializer
    public String getNamespace() {
        return this.elNamespace[this.depth];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlSerializer
    public String getPrefix(String str, boolean z) {
        if (!this.namesInterned) {
            str = str.intern();
        } else if (this.checkNamesInterned) {
            checkInterning(str);
        } else if (str == null) {
            jl.a("namespace must be not null");
            return null;
        }
        for (int i = this.namespaceEnd - 1; i >= 0; i--) {
            if (str == this.namespaceUri[i]) {
                String str2 = this.namespacePrefix[i];
                for (int i2 = this.namespaceEnd - 1; i2 > i; i2--) {
                    String str3 = this.namespacePrefix[i2];
                }
                return str2;
            }
        }
        if (z) {
            return generatePrefix(str);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlSerializer
    public Object getProperty(String str) {
        if (str == null) {
            jl.a("property name can not be null");
            return null;
        }
        if ("http://xmlpull.org/v1/doc/properties.html#serializer-indentation".equals(str)) {
            return this.indentationString;
        }
        if ("http://xmlpull.org/v1/doc/properties.html#serializer-line-separator".equals(str)) {
            return this.lineSeparator;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlSerializer
    public void ignorableWhitespace(String str) throws IOException {
        if (this.startTagIncomplete || this.setPrefixCalled) {
            closeStartTag();
        }
        if (this.doIndent && this.seenTag) {
            this.seenTag = false;
        }
        this.out.write(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String lookupOrDeclarePrefix(String str) {
        return getPrefix(str, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlSerializer
    public void processingInstruction(String str) throws IOException {
        if (this.startTagIncomplete || this.setPrefixCalled) {
            closeStartTag();
        }
        if (this.doIndent && this.seenTag) {
            this.seenTag = false;
        }
        this.out.write("<?");
        this.out.write(str);
        this.out.write("?>");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void rebuildIndentationBuf() {
        int length;
        int i;
        if (this.doIndent) {
            this.offsetNewLine = 0;
            if (this.writeLineSepartor) {
                length = this.lineSeparator.length();
                this.offsetNewLine = length;
            } else {
                length = 0;
            }
            this.maxIndentLevel = 0;
            if (this.writeIndentation) {
                int length2 = this.indentationString.length();
                this.indentationJump = length2;
                int i2 = 65 / length2;
                this.maxIndentLevel = i2;
                length += i2 * length2;
            }
            char[] cArr = this.indentationBuf;
            if (cArr == null || cArr.length < length) {
                this.indentationBuf = new char[length + 8];
            }
            if (this.writeLineSepartor) {
                int i3 = 0;
                i = 0;
                while (i3 < this.lineSeparator.length()) {
                    this.indentationBuf[i] = this.lineSeparator.charAt(i3);
                    i3++;
                    i++;
                }
            } else {
                i = 0;
            }
            if (this.writeIndentation) {
                for (int i4 = 0; i4 < this.maxIndentLevel; i4++) {
                    int i5 = 0;
                    while (i5 < this.indentationString.length()) {
                        this.indentationBuf[i] = this.indentationString.charAt(i5);
                        i5++;
                        i++;
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void reset() {
        this.out = null;
        this.autoDeclaredPrefixes = 0;
        this.depth = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.elNamespaceCount;
            if (i >= iArr.length) {
                this.namespaceEnd = 0;
                String[] strArr = this.namespacePrefix;
                strArr[0] = XMLConstants.XMLNS_ATTRIBUTE;
                String[] strArr2 = this.namespaceUri;
                strArr2[0] = "http://www.w3.org/2000/xmlns/";
                this.namespaceEnd = 1;
                strArr[1] = XMLConstants.XML_NS_PREFIX;
                strArr2[1] = "http://www.w3.org/XML/1998/namespace";
                this.namespaceEnd = 1 + 1;
                this.finished = false;
                this.pastRoot = false;
                this.setPrefixCalled = false;
                this.startTagIncomplete = false;
                this.seenTag = false;
                return;
            }
            this.elName[i] = null;
            this.elNamespace[i] = null;
            iArr[i] = 2;
            i++;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlSerializer
    public void setFeature(String str, boolean z) {
        if (str == null) {
            jl.a("feature name can not be null");
            return;
        }
        if ("http://xmlpull.org/v1/doc/features.html#names-interned".equals(str)) {
            this.namesInterned = z;
        } else if ("http://xmlpull.org/v1/doc/features.html#serializer-attvalue-use-apostrophe".equals(str)) {
            this.attributeUseApostrophe = z;
        } else {
            e04.a("unsupported feature ".concat(str));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlSerializer
    public void setOutput(OutputStream outputStream, String str) {
        if (outputStream == null) {
            jl.a("output stream can not be null");
            return;
        }
        reset();
        if (str != null) {
            this.out = new OutputStreamWriter(outputStream, str);
        } else {
            this.out = new OutputStreamWriter(outputStream);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlSerializer
    public void setPrefix(String str, String str2) throws IOException {
        if (this.startTagIncomplete) {
            closeStartTag();
        }
        if (str == null) {
            str = "";
        }
        if (!this.namesInterned) {
            str = str.intern();
        } else if (this.checkNamesInterned) {
            checkInterning(str);
        }
        for (int i = this.elNamespaceCount[this.depth]; i < this.namespaceEnd; i++) {
            if (str == this.namespacePrefix[i]) {
                StringBuffer stringBuffer = new StringBuffer("duplicated prefix ");
                stringBuffer.append(printable(str));
                throw new IllegalStateException(stringBuffer.toString());
            }
        }
        if (!this.namesInterned) {
            str2 = str2.intern();
        } else if (this.checkNamesInterned) {
            checkInterning(str2);
        } else if (str2 == null) {
            jl.a("namespace must be not null");
            return;
        }
        if (this.namespaceEnd >= this.namespacePrefix.length) {
            ensureNamespacesCapacity();
        }
        String[] strArr = this.namespacePrefix;
        int i2 = this.namespaceEnd;
        strArr[i2] = str;
        this.namespaceUri[i2] = str2;
        this.namespaceEnd = i2 + 1;
        this.setPrefixCalled = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlSerializer
    public void setProperty(String str, Object obj) {
        if (str == null) {
            jl.a("property name can not be null");
            return;
        }
        if ("http://xmlpull.org/v1/doc/properties.html#serializer-indentation".equals(str)) {
            this.indentationString = (String) obj;
        } else {
            if (!"http://xmlpull.org/v1/doc/properties.html#serializer-line-separator".equals(str)) {
                e04.a("unsupported property ".concat(str));
                return;
            }
            this.lineSeparator = (String) obj;
        }
        String str2 = this.lineSeparator;
        boolean z = true;
        this.writeLineSepartor = str2 != null && str2.length() > 0;
        String str3 = this.indentationString;
        boolean z2 = str3 != null && str3.length() > 0;
        this.writeIndentation = z2;
        if (this.indentationString == null || (!this.writeLineSepartor && !z2)) {
            z = false;
        }
        this.doIndent = z;
        rebuildIndentationBuf();
        this.seenTag = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlSerializer
    public void startDocument(String str, Boolean bool) throws IOException {
        this.out.write("<?xml version=\"1.0\"");
        if (str != null) {
            this.out.write(" encoding='");
            this.out.write(str);
            this.out.write(39);
        }
        if (bool != null) {
            boolean zBooleanValue = bool.booleanValue();
            Writer writer = this.out;
            if (zBooleanValue) {
                writer.write(" standalone='yes'");
            } else {
                writer.write(" standalone='no'");
            }
        }
        this.out.write("?>");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer startTag(String str, String str2) throws IOException {
        if (this.startTagIncomplete) {
            closeStartTag();
        }
        if (this.doIndent && this.depth > 0 && this.seenTag) {
            writeIndent();
        }
        this.seenTag = true;
        this.setPrefixCalled = false;
        this.startTagIncomplete = true;
        int i = this.depth;
        this.depth = i + 1;
        if (i + 2 >= this.elName.length) {
            ensureElementsCapacity();
        }
        if (this.checkNamesInterned && this.namesInterned) {
            checkInterning(str);
        }
        this.elNamespace[this.depth] = (this.namesInterned || str == null) ? str : str.intern();
        if (this.checkNamesInterned && this.namesInterned) {
            checkInterning(str2);
        }
        this.elName[this.depth] = (this.namesInterned || str2 == null) ? str2 : str2.intern();
        this.out.write(60);
        if (str != null) {
            if (str.length() <= 0) {
                int i2 = this.namespaceEnd - 1;
                while (true) {
                    if (i2 < 0) {
                        break;
                    }
                    if (this.namespacePrefix[i2] == "") {
                        String str3 = this.namespaceUri[i2];
                        if (str3 == null) {
                            setPrefix("", "");
                        } else if (str3.length() > 0) {
                            StringBuffer stringBuffer = new StringBuffer("start tag can not be written in empty default namespace as default namespace is currently bound to '");
                            stringBuffer.append(str3);
                            stringBuffer.append("'");
                            throw new IllegalStateException(stringBuffer.toString());
                        }
                    } else {
                        i2--;
                    }
                }
            } else {
                String strLookupOrDeclarePrefix = lookupOrDeclarePrefix(str);
                if (strLookupOrDeclarePrefix.length() > 0) {
                    this.out.write(strLookupOrDeclarePrefix);
                    this.out.write(58);
                }
            }
        }
        this.out.write(str2);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer text(String str) throws IOException {
        if (this.startTagIncomplete || this.setPrefixCalled) {
            closeStartTag();
        }
        if (this.doIndent && this.seenTag) {
            this.seenTag = false;
        }
        writeElementContent(str, this.out);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void writeAttributeValue(String str, Writer writer) throws IOException {
        boolean z = this.attributeUseApostrophe;
        int i = z ? 39 : 34;
        String str2 = z ? "&apos;" : "&quot;";
        int iIndexOf = str.indexOf(60);
        int iIndexOf2 = str.indexOf(38);
        int iIndexOf3 = str.indexOf(i);
        int i2 = 0;
        while (true) {
            if (iIndexOf == -1 && iIndexOf2 == -1 && iIndexOf3 == -1) {
                if (i2 > 0) {
                    writer.write(str.substring(i2));
                    return;
                } else {
                    writer.write(str);
                    return;
                }
            }
            if (iIndexOf3 != -1 && ((iIndexOf2 == -1 || (iIndexOf2 != -1 && iIndexOf3 < iIndexOf2)) && (iIndexOf == -1 || (iIndexOf != -1 && iIndexOf3 < iIndexOf)))) {
                if (i2 < iIndexOf3) {
                    writer.write(str.substring(i2, iIndexOf3));
                }
                writer.write(str2);
                i2 = iIndexOf3 + 1;
                iIndexOf3 = str.indexOf(i, i2);
            } else if (iIndexOf2 != -1 && ((iIndexOf3 == -1 || (iIndexOf3 != -1 && iIndexOf2 < iIndexOf3)) && (iIndexOf == -1 || (iIndexOf != -1 && iIndexOf2 < iIndexOf)))) {
                if (i2 < iIndexOf2) {
                    writer.write(str.substring(i2, iIndexOf2));
                }
                writer.write("&amp;");
                i2 = iIndexOf2 + 1;
                iIndexOf2 = str.indexOf(38, i2);
            } else {
                if (iIndexOf == -1 || ((iIndexOf3 != -1 && (iIndexOf3 == -1 || iIndexOf >= iIndexOf3)) || (iIndexOf2 != -1 && (iIndexOf2 == -1 || iIndexOf >= iIndexOf2)))) {
                    break;
                }
                if (i2 < iIndexOf) {
                    writer.write(str.substring(i2, iIndexOf));
                }
                writer.write("&lt;");
                i2 = iIndexOf + 1;
                iIndexOf = str.indexOf(60, i2);
            }
        }
        StringBuffer stringBuffer = new StringBuffer("wrong state #1 posLt=");
        stringBuffer.append(iIndexOf);
        stringBuffer.append(" posAmp=");
        stringBuffer.append(iIndexOf2);
        stringBuffer.append(" posQuot=");
        stringBuffer.append(iIndexOf3);
        stringBuffer.append(" for ");
        stringBuffer.append(str);
        throw new IllegalStateException(stringBuffer.toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void writeElementContent(String str, Writer writer) throws IOException {
        int iIndexOf = str.indexOf(60);
        int iIndexOf2 = str.indexOf(38);
        int i = 0;
        while (true) {
            if (iIndexOf != -1 || iIndexOf2 != -1) {
                if (iIndexOf != -1 && (iIndexOf == -1 || iIndexOf2 == -1 || iIndexOf2 >= iIndexOf)) {
                    if (iIndexOf2 != -1 && (iIndexOf == -1 || iIndexOf2 == -1 || iIndexOf >= iIndexOf2)) {
                        break;
                    }
                    if (i < iIndexOf) {
                        writer.write(str.substring(i, iIndexOf));
                    }
                    writer.write("&lt;");
                    i = iIndexOf + 1;
                    iIndexOf = str.indexOf(60, i);
                } else {
                    if (i < iIndexOf2) {
                        writer.write(str.substring(i, iIndexOf2));
                    }
                    writer.write("&amp;");
                    i = iIndexOf2 + 1;
                    iIndexOf2 = str.indexOf(38, i);
                }
            } else {
                writer.write(str.substring(i));
                return;
            }
        }
        StringBuffer stringBuffer = new StringBuffer("wrong state posLt=");
        stringBuffer.append(iIndexOf);
        stringBuffer.append(" posAmp=");
        stringBuffer.append(iIndexOf2);
        stringBuffer.append(" for ");
        stringBuffer.append(str);
        throw new IllegalStateException(stringBuffer.toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void writeIndent() throws IOException {
        int i = this.writeLineSepartor ? 0 : this.offsetNewLine;
        int i2 = this.depth;
        int i3 = this.maxIndentLevel;
        if (i2 > i3) {
            i2 = i3;
        }
        this.out.write(this.indentationBuf, i, (i2 * this.indentationJump) + this.offsetNewLine);
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer text(char[] cArr, int i, int i2) throws IOException {
        if (this.startTagIncomplete || this.setPrefixCalled) {
            closeStartTag();
        }
        if (this.doIndent && this.seenTag) {
            this.seenTag = false;
        }
        writeElementContent(cArr, i, i2, this.out);
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setOutput(Writer writer) {
        reset();
        this.out = writer;
    }

    public static final String printable(char c) {
        StringBuffer stringBuffer = new StringBuffer();
        addPrintable(stringBuffer, c);
        return stringBuffer.toString();
    }

    public void writeElementContent(char[] cArr, int i, int i2, Writer writer) throws IOException {
        int i3 = i2 + i;
        int i4 = i;
        while (i < i3) {
            char c = cArr[i];
            if (c == '&') {
                if (i > i4) {
                    writer.write(cArr, i4, i - i4);
                }
                writer.write("&amp;");
            } else if (c != '<') {
                i++;
            } else {
                if (i > i4) {
                    writer.write(cArr, i4, i - i4);
                }
                writer.write("&lt;");
            }
            i4 = i + 1;
            i++;
        }
        if (i3 > i4) {
            writer.write(cArr, i4, i3 - i4);
        }
    }
}
