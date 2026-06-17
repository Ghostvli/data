package org.mozilla.javascript;

import java.io.IOException;
import java.io.Reader;
import java.math.BigInteger;
import java.util.HashMap;
import org.mozilla.javascript.Parser;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class TokenStream implements Parser.CurrentPositionReporter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final char BYTE_ORDER_MARK = 65279;
    private static final int EOF_CHAR = -1;
    private static final char NUMERIC_SEPARATOR = '_';
    private static final int REPORT_NUMBER_FORMAT_ERROR = -2;
    private BigInteger bigInt;
    Token.CommentType commentType;
    int cursor;
    private boolean dirtyLine;
    private boolean isBinary;
    private boolean isHex;
    private boolean isOctal;
    private boolean isOldOctal;
    private int lastLineEnd;
    int lineno;
    private double number;
    private Parser parser;
    private int quoteChar;
    String regExpFlags;
    private char[] sourceBuffer;
    int sourceCursor;
    private int sourceEnd;
    private Reader sourceReader;
    private String sourceString;
    private int stringBufferTop;
    int tokenBeg;
    int tokenEnd;
    private int tokenStartLastLineEnd;
    private int tokenStartLineno;
    private int ungetCursor;
    private boolean xmlIsAttribute;
    private boolean xmlIsTagContent;
    private int xmlOpenTagsCount;
    private StringBuilder rawString = new StringBuilder();
    private String string = "";
    private char[] stringBuffer = new char[128];
    private final HashMap<String, String> allStrings = new HashMap<>();
    private final int[] ungetBuffer = new int[3];
    private boolean hitEOF = false;
    private int lineStart = 0;
    private int lineEndChar = -1;
    private String commentPrefix = "";
    private int commentCursor = -1;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public TokenStream(Parser parser, Reader reader, String str, int i) {
        this.parser = parser;
        this.lineno = i;
        if (reader != null) {
            if (str != null) {
                Kit.codeBug();
            }
            this.sourceReader = reader;
            this.sourceBuffer = new char[512];
            this.sourceEnd = 0;
        } else {
            if (str == null) {
                Kit.codeBug();
            }
            this.sourceString = str;
            this.sourceEnd = str.length();
        }
        this.cursor = 0;
        this.sourceCursor = 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void addToString(int i) {
        int i2 = this.stringBufferTop;
        int iCharCount = Character.charCount(i);
        int i3 = i2 + iCharCount;
        char[] cArr = this.stringBuffer;
        if (i3 >= cArr.length) {
            char[] cArr2 = new char[cArr.length * 2];
            System.arraycopy(cArr, 0, cArr2, 0, i2);
            this.stringBuffer = cArr2;
        }
        char[] cArr3 = this.stringBuffer;
        if (iCharCount == 1) {
            cArr3[i2] = (char) i;
        } else {
            cArr3[i2] = Character.highSurrogate(i);
            this.stringBuffer[i2 + 1] = Character.lowSurrogate(i);
        }
        this.stringBufferTop = i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean canUngetChar() {
        int i = this.ungetCursor;
        return i == 0 || this.ungetBuffer[i - 1] != 10;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final int charAt(int i) {
        if (i < 0) {
            return -1;
        }
        String str = this.sourceString;
        int i2 = this.sourceEnd;
        if (str != null) {
            if (i >= i2) {
                return -1;
            }
            return str.charAt(i);
        }
        if (i >= i2) {
            int i3 = this.sourceCursor;
            try {
                if (!fillSourceBuffer()) {
                    return -1;
                }
                i -= i3 - this.sourceCursor;
            } catch (IOException unused) {
                return -1;
            }
        }
        return this.sourceBuffer[i];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static String convertLastCharToHex(String str) {
        int length = str.length() - 1;
        StringBuilder sb = new StringBuilder(str.substring(0, length));
        sb.append("\\u");
        String hexString = Integer.toHexString(str.charAt(length));
        for (int i = 0; i < 4 - hexString.length(); i++) {
            sb.append('0');
        }
        sb.append(hexString);
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean fillSourceBuffer() throws IOException {
        if (this.sourceString != null) {
            Kit.codeBug();
        }
        if (this.sourceEnd == this.sourceBuffer.length) {
            if (this.lineStart == 0 || isMarkingComment()) {
                char[] cArr = this.sourceBuffer;
                char[] cArr2 = new char[cArr.length * 2];
                System.arraycopy(cArr, 0, cArr2, 0, this.sourceEnd);
                this.sourceBuffer = cArr2;
            } else {
                char[] cArr3 = this.sourceBuffer;
                int i = this.lineStart;
                System.arraycopy(cArr3, i, cArr3, 0, this.sourceEnd - i);
                int i2 = this.sourceEnd;
                int i3 = this.lineStart;
                this.sourceEnd = i2 - i3;
                this.sourceCursor -= i3;
                this.lineStart = 0;
            }
        }
        Reader reader = this.sourceReader;
        char[] cArr4 = this.sourceBuffer;
        int i4 = this.sourceEnd;
        int i5 = reader.read(cArr4, i4, cArr4.length - i4);
        if (i5 < 0) {
            return false;
        }
        this.sourceEnd += i5;
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private int getChar(boolean z, boolean z2) {
        int i;
        int i2;
        int i3 = this.ungetCursor;
        if (i3 != 0) {
            this.cursor++;
            int[] iArr = this.ungetBuffer;
            int i4 = i3 - 1;
            this.ungetCursor = i4;
            return iArr[i4];
        }
        while (true) {
            String str = this.sourceString;
            int i5 = this.sourceCursor;
            if (str != null) {
                if (i5 == this.sourceEnd) {
                    this.hitEOF = true;
                    return -1;
                }
                this.cursor++;
                int iCodePointAt = str.codePointAt(i5);
                this.sourceCursor += Character.charCount(iCodePointAt);
                i = iCodePointAt;
            } else {
                if (i5 == this.sourceEnd && !fillSourceBuffer()) {
                    this.hitEOF = true;
                    return -1;
                }
                this.cursor++;
                char[] cArr = this.sourceBuffer;
                int i6 = this.sourceCursor;
                this.sourceCursor = i6 + 1;
                i = cArr[i6];
            }
            if (!z2 && (i2 = this.lineEndChar) >= 0) {
                if (i2 == 13 && i == 10) {
                    this.lineEndChar = 10;
                } else {
                    this.lineEndChar = -1;
                    this.lineStart = this.sourceCursor - 1;
                    this.lastLineEnd = this.tokenEnd;
                    this.lineno++;
                }
            }
            if (i > 127) {
                if (i == 65279) {
                    break;
                }
                if (!z || !isJSFormatChar(i)) {
                    break;
                }
            } else if (i == 10 || i == 13) {
                this.lineEndChar = i;
                return 10;
            }
        }
        if (ScriptRuntime.isJSLineTerminator(i)) {
            this.lineEndChar = i;
            return 10;
        }
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private int getCharIgnoreLineEnd() {
        return getChar(true, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String getStringFromBuffer() {
        this.tokenEnd = this.cursor;
        return new String(this.stringBuffer, 0, this.stringBufferTop);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private int getTemplateLiteralChar() {
        int charIgnoreLineEnd = getCharIgnoreLineEnd(false);
        if (charIgnoreLineEnd == 10) {
            int i = this.lineEndChar;
            if (i != 13) {
                if (i == 8232 || i == 8233) {
                    charIgnoreLineEnd = i;
                }
            } else if (charAt(this.cursor) == 10) {
                getCharIgnoreLineEnd(false);
            }
            this.lineEndChar = -1;
            this.lineStart = this.sourceCursor - 1;
            this.lineno++;
        }
        this.rawString.append((char) charIgnoreLineEnd);
        return charIgnoreLineEnd;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String internString(String str) {
        String strPutIfAbsent = this.allStrings.putIfAbsent(str, str);
        return strPutIfAbsent == null ? str : strPutIfAbsent;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean isAlpha(int i) {
        return i <= 90 ? 65 <= i : 97 <= i && i <= 122;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean isDigit(int i, int i2) {
        if (i == 10 && isDigit(i2)) {
            return true;
        }
        if (i == 16 && isHexDigit(i2)) {
            return true;
        }
        if (i == 8 && isOctalDigit(i2)) {
            return true;
        }
        return i == 2 && isDualDigit(i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean isDualDigit(int i) {
        return 48 == i || i == 49;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean isHexDigit(int i) {
        if (48 <= i && i <= 57) {
            return true;
        }
        if (97 > i || i > 102) {
            return 65 <= i && i <= 70;
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean isJSFormatChar(int i) {
        return i > 127 && Character.getType((char) i) == 16;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean isJSSpace(int i) {
        return i <= 127 ? i == 32 || i == 9 || i == 12 || i == 11 : i == 160 || i == 65279 || Character.getType((char) i) == 12;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean isKeyword(String str, int i, boolean z) {
        return stringToKeyword(str, i, z) != 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean isMarkingComment() {
        return this.commentCursor != -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean isOctalDigit(int i) {
        return 48 <= i && i <= 55;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean isValidIdentifierName(String str) {
        int[] array = str.codePoints().toArray();
        int length = array.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = array[i];
            int i4 = i2 + 1;
            if (i2 == 0) {
                if (i3 != 36 && i3 != 95 && !Character.isUnicodeIdentifierStart(i3)) {
                    return false;
                }
            } else if (i3 != 36 && i3 != 8204 && i3 != 8205 && !Character.isUnicodeIdentifierPart(i3)) {
                return false;
            }
            i++;
            i2 = i4;
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void markCommentStart(String str) {
        if (!this.parser.compilerEnv.isRecordingComments() || this.sourceReader == null) {
            return;
        }
        this.commentPrefix = str;
        this.commentCursor = this.sourceCursor - 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean matchChar(int i) {
        int charIgnoreLineEnd = getCharIgnoreLineEnd();
        if (charIgnoreLineEnd == i) {
            this.tokenEnd = this.cursor;
            return true;
        }
        ungetCharIgnoreLineEnd(charIgnoreLineEnd);
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean matchTemplateLiteralChar(int i) {
        int templateLiteralChar = getTemplateLiteralChar();
        if (templateLiteralChar == i) {
            return true;
        }
        ungetTemplateLiteralChar(templateLiteralChar);
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private int peekChar() {
        int i = getChar();
        ungetChar(i);
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private int peekTemplateLiteralChar() {
        int templateLiteralChar = getTemplateLiteralChar();
        ungetTemplateLiteralChar(templateLiteralChar);
        return templateLiteralChar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean readCDATA() {
        int i = getChar();
        while (i != -1) {
            addToString(i);
            if (i == 93 && peekChar() == 93) {
                i = getChar();
                addToString(i);
                if (peekChar() == 62) {
                    addToString(getChar());
                    return true;
                }
            } else {
                i = getChar();
            }
        }
        this.stringBufferTop = 0;
        this.string = null;
        this.parser.addError("msg.XML.bad.form");
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private int readDigits(int i, int i2) {
        if (isDigit(i, i2)) {
            addToString(i2);
            i2 = getChar();
            if (i2 != -1) {
                while (true) {
                    if (i2 != 95) {
                        if (!isDigit(i, i2)) {
                            break;
                        }
                        addToString(i2);
                        i2 = getChar();
                        if (i2 == -1) {
                            return -1;
                        }
                    } else {
                        i2 = getChar();
                        if (i2 == 10 || i2 == -1) {
                            return REPORT_NUMBER_FORMAT_ERROR;
                        }
                        if (!isDigit(i, i2)) {
                            ungetChar(i2);
                            return 95;
                        }
                        addToString(95);
                    }
                }
            } else {
                return -1;
            }
        }
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean readEntity() {
        int i = getChar();
        int i2 = 1;
        while (i != -1) {
            addToString(i);
            if (i == 60) {
                i2++;
            } else if (i == 62 && i2 - 1 == 0) {
                return true;
            }
            i = getChar();
        }
        this.stringBufferTop = 0;
        this.string = null;
        this.parser.addError("msg.XML.bad.form");
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean readPI() {
        while (true) {
            int i = getChar();
            if (i == -1) {
                this.stringBufferTop = 0;
                this.string = null;
                this.parser.addError("msg.XML.bad.form");
                return false;
            }
            addToString(i);
            if (i == 63 && peekChar() == 62) {
                addToString(getChar());
                return true;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean readQuotedString(int i) {
        int i2;
        do {
            i2 = getChar();
            if (i2 == -1) {
                this.stringBufferTop = 0;
                this.string = null;
                this.parser.addError("msg.XML.bad.form");
                return false;
            }
            addToString(i2);
        } while (i2 != i);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean readXmlComment() {
        int i = getChar();
        while (i != -1) {
            addToString(i);
            if (i == 45 && peekChar() == 45) {
                i = getChar();
                addToString(i);
                if (peekChar() == 62) {
                    addToString(getChar());
                    return true;
                }
            } else {
                i = getChar();
            }
        }
        this.stringBufferTop = 0;
        this.string = null;
        this.parser.addError("msg.XML.bad.form");
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void skipLine() {
        int i;
        do {
            i = getChar();
            if (i == -1) {
                break;
            }
        } while (i != 10);
        ungetChar(i);
        this.tokenEnd = this.cursor;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int stringToKeyword(String str, int i, boolean z) {
        return i < 200 ? stringToKeywordForJS(str) : stringToKeywordForES(str, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int stringToKeywordForES(String str, boolean z) {
        int i;
        str.getClass();
        i = 32;
        switch (str) {
            case "delete":
                i = 31;
                break;
            case "extends":
            case "export":
            case "import":
            case "enum":
            case "await":
            case "class":
                i = 140;
                break;
            case "public":
                if (!z) {
                    i = 0;
                    break;
                } else {
                    i = 140;
                    break;
                }
                break;
            case "return":
                i = 4;
                break;
            case "implements":
                if (!z) {
                    i = 0;
                    break;
                } else {
                    i = 140;
                    break;
                }
                break;
            case "static":
                if (!z) {
                    i = 0;
                    break;
                } else {
                    i = 140;
                    break;
                }
                break;
            case "switch":
                i = 127;
                break;
            case "typeof":
                break;
            case "finally":
                i = Token.FINALLY;
                break;
            case "package":
                if (!z) {
                    i = 0;
                    break;
                } else {
                    i = 140;
                    break;
                }
                break;
            case "protected":
                if (!z) {
                    i = 0;
                    break;
                } else {
                    i = 140;
                    break;
                }
                break;
            case "continue":
                i = Token.CONTINUE;
                break;
            case "private":
                if (!z) {
                    i = 0;
                    break;
                } else {
                    i = 140;
                    break;
                }
                break;
            case "do":
                i = Token.DO;
                break;
            case "if":
                i = Token.IF;
                break;
            case "in":
                i = 57;
                break;
            case "for":
                i = Token.FOR;
                break;
            case "let":
                i = Token.LET;
                break;
            case "new":
                i = 30;
                break;
            case "try":
                i = 90;
                break;
            case "var":
                i = Token.VAR;
                break;
            case "case":
                i = 128;
                break;
            case "else":
                i = 126;
                break;
            case "null":
                i = 47;
                break;
            case "this":
                i = 48;
                break;
            case "true":
                i = 50;
                break;
            case "void":
                i = Token.VOID;
                break;
            case "with":
                i = Token.WITH;
                break;
            case "break":
                i = Token.BREAK;
                break;
            case "catch":
                i = Token.CATCH;
                break;
            case "const":
                i = Token.CONST;
                break;
            case "false":
                i = 49;
                break;
            case "super":
                i = 79;
                break;
            case "throw":
                i = 55;
                break;
            case "while":
                i = 130;
                break;
            case "yield":
                i = 78;
                break;
            case "interface":
                if (!z) {
                    i = 0;
                    break;
                } else {
                    i = 140;
                    break;
                }
                break;
            case "debugger":
                i = Token.DEBUGGER;
                break;
            case "instanceof":
                i = 58;
                break;
            case "function":
                i = Token.FUNCTION;
                break;
            case "default":
                i = Token.DEFAULT;
                break;
            default:
                i = 0;
                break;
        }
        if (i == 0) {
            return 0;
        }
        return i & 255;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int stringToKeywordForJS(String str) {
        int i;
        str.getClass();
        i = 58;
        switch (str) {
            case "volatile":
            case "synchronized":
            case "double":
            case "extends":
            case "export":
            case "import":
            case "native":
            case "public":
            case "implements":
            case "static":
            case "throws":
            case "package":
            case "protected":
            case "private":
            case "int":
            case "byte":
            case "char":
            case "enum":
            case "goto":
            case "long":
            case "boolean":
            case "class":
            case "final":
            case "float":
            case "short":
            case "super":
            case "interface":
            case "transient":
            case "abstract":
                i = 140;
                break;
            case "delete":
                i = 31;
                break;
            case "return":
                i = 4;
                break;
            case "switch":
                i = 127;
                break;
            case "typeof":
                i = 32;
                break;
            case "finally":
                i = Token.FINALLY;
                break;
            case "continue":
                i = Token.CONTINUE;
                break;
            case "do":
                i = Token.DO;
                break;
            case "if":
                i = Token.IF;
                break;
            case "in":
                i = 57;
                break;
            case "for":
                i = Token.FOR;
                break;
            case "let":
                i = Token.LET;
                break;
            case "new":
                i = 30;
                break;
            case "try":
                i = 90;
                break;
            case "var":
                i = Token.VAR;
                break;
            case "case":
                i = 128;
                break;
            case "else":
                i = 126;
                break;
            case "null":
                i = 47;
                break;
            case "this":
                i = 48;
                break;
            case "true":
                i = 50;
                break;
            case "void":
                i = Token.VOID;
                break;
            case "with":
                i = Token.WITH;
                break;
            case "break":
                i = Token.BREAK;
                break;
            case "catch":
                i = Token.CATCH;
                break;
            case "const":
                i = Token.CONST;
                break;
            case "false":
                i = 49;
                break;
            case "throw":
                i = 55;
                break;
            case "while":
                i = 130;
                break;
            case "yield":
                i = 78;
                break;
            case "debugger":
                i = Token.DEBUGGER;
                break;
            case "instanceof":
                break;
            case "function":
                i = Token.FUNCTION;
                break;
            case "default":
                i = Token.DEFAULT;
                break;
            default:
                i = 0;
                break;
        }
        if (i == 0) {
            return 0;
        }
        return i & 255;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final String substring(int i, int i2) {
        String str = this.sourceString;
        if (str != null) {
            return str.substring(i, i2);
        }
        return new String(this.sourceBuffer, i, i2 - i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void ungetChar(int i) {
        int i2 = this.ungetCursor;
        if (i2 != 0 && this.ungetBuffer[i2 - 1] == 10) {
            Kit.codeBug();
        }
        int[] iArr = this.ungetBuffer;
        int i3 = this.ungetCursor;
        this.ungetCursor = i3 + 1;
        iArr[i3] = i;
        this.cursor--;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void ungetCharIgnoreLineEnd(int i) {
        int[] iArr = this.ungetBuffer;
        int i2 = this.ungetCursor;
        this.ungetCursor = i2 + 1;
        iArr[i2] = i;
        this.cursor--;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void ungetTemplateLiteralChar(int i) {
        ungetCharIgnoreLineEnd(i);
        this.rawString.setLength(r0.length() - 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean eof() {
        return this.hitEOF;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String getAndResetCurrentComment() {
        if (this.sourceString != null) {
            if (isMarkingComment()) {
                Kit.codeBug();
            }
            return this.sourceString.substring(this.tokenBeg, this.tokenEnd);
        }
        if (!isMarkingComment()) {
            Kit.codeBug();
        }
        StringBuilder sb = new StringBuilder(this.commentPrefix);
        sb.append(this.sourceBuffer, this.commentCursor, getTokenLength() - this.commentPrefix.length());
        this.commentCursor = -1;
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final BigInteger getBigInt() {
        return this.bigInt;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Token.CommentType getCommentType() {
        return this.commentType;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getCursor() {
        return this.cursor;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getFirstXMLToken() {
        this.xmlOpenTagsCount = 0;
        this.xmlIsAttribute = false;
        this.xmlIsTagContent = false;
        if (!canUngetChar()) {
            return -1;
        }
        ungetChar(60);
        return getNextXMLToken();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.Parser.CurrentPositionReporter
    public int getLength() {
        return this.tokenEnd - this.tokenBeg;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String getLine(int i, int[] iArr) {
        int i2 = (this.cursor + this.ungetCursor) - i;
        int i3 = this.sourceCursor;
        if (i2 > i3) {
            return null;
        }
        int i4 = 0;
        int i5 = 0;
        while (i2 > 0) {
            int iCharAt = charAt(i3 - 1);
            if (ScriptRuntime.isJSLineTerminator(iCharAt)) {
                if (iCharAt == 10 && charAt(i3 + REPORT_NUMBER_FORMAT_ERROR) == 13) {
                    i2--;
                    i3--;
                }
                i4++;
                i5 = i3 - 1;
            }
            i2--;
            i3--;
        }
        int i6 = 0;
        while (true) {
            if (i3 <= 0) {
                i3 = 0;
                break;
            }
            if (ScriptRuntime.isJSLineTerminator(charAt(i3 - 1))) {
                break;
            }
            i3--;
            i6++;
        }
        iArr[0] = (this.lineno - i4) + (this.lineEndChar >= 0 ? 1 : 0);
        iArr[1] = i6;
        return i4 == 0 ? getLine() : substring(i3, i5);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.Parser.CurrentPositionReporter
    public int getLineno() {
        return this.lineno;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0162, code lost:
    
        r10.stringBufferTop = 0;
        r10.string = null;
        r10.parser.addError("msg.XML.bad.form");
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x016b, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getNextXMLToken() {
        this.tokenStartLastLineEnd = this.lastLineEnd;
        this.tokenStartLineno = this.lineno;
        this.tokenBeg = this.cursor;
        this.stringBufferTop = 0;
        while (true) {
            int i = getChar();
            if (i == -1) {
                this.tokenEnd = this.cursor;
                this.stringBufferTop = 0;
                this.string = null;
                this.parser.addError("msg.XML.bad.form");
                return -1;
            }
            if (this.xmlIsTagContent) {
                if (i == 9 || i == 10 || i == 13 || i == 32) {
                    addToString(i);
                } else if (i == 34 || i == 39) {
                    addToString(i);
                    if (!readQuotedString(i)) {
                        return -1;
                    }
                } else if (i == 47) {
                    addToString(i);
                    if (peekChar() == 62) {
                        addToString(getChar());
                        this.xmlIsTagContent = false;
                        this.xmlOpenTagsCount--;
                    }
                } else {
                    if (i == 123) {
                        ungetChar(i);
                        this.string = getStringFromBuffer();
                        return Token.XML;
                    }
                    if (i == 61) {
                        addToString(i);
                        this.xmlIsAttribute = true;
                    } else if (i != 62) {
                        addToString(i);
                        this.xmlIsAttribute = false;
                    } else {
                        addToString(i);
                        this.xmlIsTagContent = false;
                        this.xmlIsAttribute = false;
                    }
                }
                if (!this.xmlIsTagContent && this.xmlOpenTagsCount == 0) {
                    this.string = getStringFromBuffer();
                    int i2 = this.sourceCursor;
                    this.cursor = i2;
                    this.tokenEnd = i2;
                    return Token.XMLEND;
                }
            } else if (i == 60) {
                addToString(i);
                int iPeekChar = peekChar();
                if (iPeekChar == 33) {
                    addToString(getChar());
                    int iPeekChar2 = peekChar();
                    if (iPeekChar2 == 45) {
                        addToString(getChar());
                        int i3 = getChar();
                        if (i3 != 45) {
                            this.stringBufferTop = 0;
                            this.string = null;
                            this.parser.addError("msg.XML.bad.form");
                            return -1;
                        }
                        addToString(i3);
                        if (!readXmlComment()) {
                            return -1;
                        }
                    } else if (iPeekChar2 == 91) {
                        addToString(getChar());
                        if (getChar() != 67 || getChar() != 68 || getChar() != 65 || getChar() != 84 || getChar() != 65 || getChar() != 91) {
                            break;
                        }
                        addToString(67);
                        addToString(68);
                        addToString(65);
                        addToString(84);
                        addToString(65);
                        addToString(91);
                        if (!readCDATA()) {
                            return -1;
                        }
                    } else if (!readEntity()) {
                        return -1;
                    }
                } else if (iPeekChar == 47) {
                    addToString(getChar());
                    int i4 = this.xmlOpenTagsCount;
                    if (i4 == 0) {
                        this.stringBufferTop = 0;
                        this.string = null;
                        this.parser.addError("msg.XML.bad.form");
                        return -1;
                    }
                    this.xmlIsTagContent = true;
                    this.xmlOpenTagsCount = i4 - 1;
                } else if (iPeekChar != 63) {
                    this.xmlIsTagContent = true;
                    this.xmlOpenTagsCount++;
                } else {
                    addToString(getChar());
                    if (!readPI()) {
                        return -1;
                    }
                }
            } else {
                if (i == 123) {
                    ungetChar(i);
                    this.string = getStringFromBuffer();
                    return Token.XML;
                }
                addToString(i);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final double getNumber() {
        return this.number;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.Parser.CurrentPositionReporter
    public int getOffset() {
        int i = this.sourceCursor - this.lineStart;
        return this.lineEndChar >= 0 ? i - 1 : i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.Parser.CurrentPositionReporter
    public int getPosition() {
        return this.tokenBeg;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final char getQuoteChar() {
        return (char) this.quoteChar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getRawString() {
        return this.rawString.length() == 0 ? "" : this.rawString.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String getSourceString() {
        return this.sourceString;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String getString() {
        return this.string;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Duplicate block (B:270:0x038f) to fix multi-entry loop: BACK_EDGE: B:270:0x038f -> B:271:0x0390 */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0176, code lost:
    
        r7 = "yield";
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0178, code lost:
    
        r30.string = r7;
        r7 = 44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x017b, code lost:
    
        r30.string = internString(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0183, code lost:
    
        if (r7 == 140) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x018e, code lost:
    
        if (r30.parser.compilerEnv.getLanguageVersion() < 200) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0199, code lost:
    
        if (r30.parser.compilerEnv.isReservedKeywordAsIdentifier() != false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x019b, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x019c, code lost:
    
        if (r1 == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01a6, code lost:
    
        if (r30.parser.compilerEnv.getLanguageVersion() < 200) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01ac, code lost:
    
        if (isValidIdentifierName(r4) != false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x01ae, code lost:
    
        r30.parser.reportError("msg.invalid.escape");
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x01b3, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x01b4, code lost:
    
        r30.string = internString(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01ba, code lost:
    
        return 44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00bb, code lost:
    
        r30.parser.reportError("msg.invalid.escape");
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0119, code lost:
    
        r12 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x011a, code lost:
    
        ungetChar(r12);
        r4 = getStringFromBuffer();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0123, code lost:
    
        if (r1 == false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x012d, code lost:
    
        if (r30.parser.compilerEnv.getLanguageVersion() < 200) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0142, code lost:
    
        if (isKeyword(r4, r30.parser.compilerEnv.getLanguageVersion(), r30.parser.inUseStrictDirective()) == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0144, code lost:
    
        r4 = convertLastCharToHex(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0149, code lost:
    
        r7 = stringToKeyword(r4, r30.parser.compilerEnv.getLanguageVersion(), r30.parser.inUseStrictDirective());
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x015b, code lost:
    
        if (r7 == 0) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x015f, code lost:
    
        if (r7 == 167) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0163, code lost:
    
        if (r7 != 78) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x016f, code lost:
    
        if (r30.parser.compilerEnv.getLanguageVersion() >= 170) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0171, code lost:
    
        if (r7 != 167) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0173, code lost:
    
        r7 = "let";
     */
    /* JADX WARN: Removed duplicated region for block: B:275:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:625:0x0396 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:275:0x03a3 -> B:268:0x0389). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int getToken() {
        int digits;
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        boolean z4;
        double dStringPrefixToNumber;
        boolean z5;
        int i2;
        int i3;
        int i4;
        int iXDigitToInt;
        int i5;
        boolean z6;
        int i6;
        int i7;
        int iXDigitToInt2;
        do {
            digits = getChar();
            if (digits == -1) {
                this.tokenStartLastLineEnd = this.lastLineEnd;
                this.tokenStartLineno = this.lineno;
                int i8 = this.cursor;
                this.tokenBeg = i8 - 1;
                this.tokenEnd = i8;
                return 0;
            }
            z = true;
            if (digits == 10) {
                this.dirtyLine = false;
                this.tokenStartLastLineEnd = this.lastLineEnd;
                this.tokenStartLineno = this.lineno;
                int i9 = this.cursor;
                this.tokenBeg = i9 - 1;
                this.tokenEnd = i9;
                return 1;
            }
        } while (isJSSpace(digits));
        if (digits != 45) {
            this.dirtyLine = true;
        }
        this.tokenStartLastLineEnd = this.lastLineEnd;
        this.tokenStartLineno = this.lineno;
        int i10 = this.cursor;
        this.tokenBeg = i10 - 1;
        this.tokenEnd = i10;
        if (digits == 64) {
            return Token.XMLATTR;
        }
        int i11 = 92;
        if (digits == 92) {
            digits = getChar();
            if (digits == 117) {
                this.stringBufferTop = 0;
                z2 = true;
                z3 = true;
            } else {
                ungetChar(digits);
                z2 = false;
                z3 = false;
                digits = 92;
            }
        } else {
            z2 = Character.isUnicodeIdentifierStart(digits) || digits == 36 || digits == 95;
            if (z2) {
                this.stringBufferTop = 0;
                addToString(digits);
            }
            z3 = false;
        }
        int i12 = 10;
        int i13 = 4;
        if (z2) {
            boolean z7 = z3;
            while (true) {
                if (z3) {
                    if (matchTemplateLiteralChar(Token.EXPORT)) {
                        iXDigitToInt2 = 0;
                        do {
                            int templateLiteralChar = getTemplateLiteralChar();
                            if (templateLiteralChar == 125) {
                                break;
                            }
                            iXDigitToInt2 = Kit.xDigitToInt(templateLiteralChar, iXDigitToInt2);
                        } while (iXDigitToInt2 >= 0);
                        if (iXDigitToInt2 < 0 || iXDigitToInt2 > 1114111) {
                            break;
                        }
                        i7 = i13;
                    } else {
                        int i14 = 0;
                        int iXDigitToInt3 = 0;
                        while (true) {
                            i7 = i13;
                            if (i14 == i13) {
                                break;
                            }
                            iXDigitToInt3 = Kit.xDigitToInt(getChar(), iXDigitToInt3);
                            if (iXDigitToInt3 < 0) {
                                this.parser.reportError("msg.invalid.escape");
                                break;
                            }
                            i14++;
                            i13 = i7;
                        }
                        iXDigitToInt2 = iXDigitToInt3;
                    }
                    if (iXDigitToInt2 < 0) {
                        this.parser.addError("msg.invalid.escape");
                        return -1;
                    }
                    addToString(iXDigitToInt2);
                    i13 = i7;
                    z3 = false;
                } else {
                    int i15 = i13;
                    int i16 = getChar();
                    if (i16 == 92) {
                        int i17 = getChar();
                        if (i17 != 117) {
                            this.parser.addError("msg.illegal.character", i17);
                            return -1;
                        }
                        z7 = true;
                        z3 = true;
                    } else {
                        if (i16 == -1 || i16 == 65279 || !(Character.isUnicodeIdentifierPart(i16) || i16 == 36)) {
                            break;
                        }
                        addToString(i16);
                    }
                    i13 = i15;
                }
            }
        } else {
            int i18 = 4;
            int i19 = 120;
            if (isDigit(digits) || (digits == 46 && isDigit(peekChar()))) {
                this.stringBufferTop = 0;
                this.isBinary = false;
                this.isOctal = false;
                this.isOldOctal = false;
                this.isHex = false;
                boolean z8 = this.parser.compilerEnv.getLanguageVersion() >= 200;
                if (digits != 48) {
                    i = 10;
                } else {
                    digits = getChar();
                    if (digits == 120 || digits == 88) {
                        this.isHex = true;
                        digits = getChar();
                        i = 16;
                    } else {
                        if (z8 && (digits == 111 || digits == 79)) {
                            this.isOctal = true;
                            digits = getChar();
                        } else if (z8 && (digits == 98 || digits == 66)) {
                            this.isBinary = true;
                            digits = getChar();
                            i = 2;
                        } else if (isDigit(digits)) {
                            this.isOldOctal = true;
                        } else {
                            addToString(48);
                            i = 10;
                        }
                        i = 8;
                    }
                }
                int i20 = this.stringBufferTop;
                if (i == 10 || i == 16 || ((i == 8 && !this.isOldOctal) || i == 2)) {
                    digits = readDigits(i, digits);
                    if (digits == REPORT_NUMBER_FORMAT_ERROR) {
                        this.parser.addError("msg.caught.nfe");
                        return -1;
                    }
                } else {
                    while (true) {
                        if (!isDigit(digits)) {
                            break;
                        }
                        if (digits >= 56) {
                            this.parser.addWarning("msg.bad.octal.literal", digits == 56 ? "8" : "9");
                            digits = readDigits(10, digits);
                            if (digits == REPORT_NUMBER_FORMAT_ERROR) {
                                this.parser.addError("msg.caught.nfe");
                                return -1;
                            }
                            i = 10;
                        } else {
                            addToString(digits);
                            digits = getChar();
                        }
                    }
                }
                if (this.stringBufferTop == i20 && (this.isBinary || this.isOctal || this.isHex)) {
                    this.parser.addError("msg.caught.nfe");
                    return -1;
                }
                if (z8 && digits == 110) {
                    digits = getChar();
                    z4 = true;
                } else if (i == 10 && (digits == 46 || digits == 101 || digits == 69)) {
                    if (digits == 46) {
                        addToString(digits);
                        digits = readDigits(i, getChar());
                        if (digits == REPORT_NUMBER_FORMAT_ERROR) {
                            this.parser.addError("msg.caught.nfe");
                            return -1;
                        }
                    }
                    if (digits == 101 || digits == 69) {
                        addToString(digits);
                        int i21 = getChar();
                        if (i21 == 43 || i21 == 45) {
                            addToString(i21);
                            i21 = getChar();
                        }
                        if (!isDigit(i21)) {
                            this.parser.addError("msg.missing.exponent");
                            return -1;
                        }
                        digits = readDigits(i, i21);
                        if (digits == REPORT_NUMBER_FORMAT_ERROR) {
                            this.parser.addError("msg.caught.nfe");
                            return -1;
                        }
                    }
                    z4 = false;
                    z = false;
                } else {
                    z4 = false;
                }
                ungetChar(digits);
                String stringFromBuffer = getStringFromBuffer();
                this.string = stringFromBuffer;
                int iIndexOf = stringFromBuffer.indexOf(95);
                if (iIndexOf != -1) {
                    char[] charArray = stringFromBuffer.toCharArray();
                    for (int i22 = iIndexOf + 1; i22 < charArray.length; i22++) {
                        char c = charArray[i22];
                        if (c != '_') {
                            charArray[iIndexOf] = c;
                            iIndexOf++;
                        }
                    }
                    stringFromBuffer = new String(charArray, 0, iIndexOf);
                }
                if (z4) {
                    this.bigInt = new BigInteger(stringFromBuffer, i);
                    return 89;
                }
                if (i != 10 || z) {
                    dStringPrefixToNumber = ScriptRuntime.stringPrefixToNumber(stringFromBuffer, 0, i);
                } else {
                    try {
                        dStringPrefixToNumber = Double.parseDouble(stringFromBuffer);
                    } catch (NumberFormatException unused) {
                        this.parser.addError("msg.caught.nfe");
                        return -1;
                    }
                }
                this.number = dStringPrefixToNumber;
                return 45;
            }
            int i23 = 117;
            int i24 = 114;
            if (digits == 34 || digits == 39) {
                this.quoteChar = digits;
                this.stringBufferTop = 0;
                int charIgnoreLineEnd = getCharIgnoreLineEnd(false);
                while (charIgnoreLineEnd != this.quoteChar) {
                    if (charIgnoreLineEnd != -1) {
                        int i25 = i12;
                        if (charIgnoreLineEnd == i25) {
                            int i26 = this.lineEndChar;
                            if (i26 != i25 && i26 != 13) {
                                if (i26 == 8232 || i26 == 8233) {
                                    charIgnoreLineEnd = i26;
                                }
                            }
                            z5 = true;
                        }
                        z5 = false;
                    } else {
                        z5 = true;
                    }
                    if (z5) {
                        ungetCharIgnoreLineEnd(charIgnoreLineEnd);
                        this.tokenEnd = this.cursor;
                        this.parser.addError("msg.unterminated.string.lit");
                        return -1;
                    }
                    if (charIgnoreLineEnd == i11) {
                        i3 = getChar();
                        if (i3 == 10) {
                            charIgnoreLineEnd = getChar();
                            i24 = 114;
                            i11 = 92;
                            i12 = 10;
                            i18 = 4;
                        } else if (i3 == 98) {
                            i2 = i23;
                            i3 = 8;
                        } else if (i3 == 102) {
                            i2 = i23;
                            i3 = 12;
                        } else if (i3 == 110) {
                            i2 = i23;
                            i3 = 10;
                        } else if (i3 != i24) {
                            if (i3 != 120) {
                                switch (i3) {
                                    case Token.COLON /* 116 */:
                                        i2 = i23;
                                        i3 = 9;
                                        break;
                                    case Token.OR /* 117 */:
                                        int i27 = this.stringBufferTop;
                                        i2 = i23;
                                        addToString(i2);
                                        if (matchChar(Token.EXPORT)) {
                                            iXDigitToInt = 0;
                                            while (true) {
                                                i5 = getChar();
                                                if (i5 == 125) {
                                                    addToString(i5);
                                                } else {
                                                    iXDigitToInt = Kit.xDigitToInt(i5, iXDigitToInt);
                                                    if (iXDigitToInt >= 0) {
                                                        addToString(i5);
                                                    }
                                                }
                                            }
                                            if (iXDigitToInt < 0 || iXDigitToInt > 1114111) {
                                                this.parser.reportError("msg.invalid.escape");
                                                charIgnoreLineEnd = i5;
                                                i23 = i2;
                                                i24 = 114;
                                                i11 = 92;
                                                i12 = 10;
                                                break;
                                            }
                                        } else {
                                            int i28 = 0;
                                            int iXDigitToInt4 = 0;
                                            for (int i29 = i18; i28 != i29; i29 = 4) {
                                                int i30 = getChar();
                                                iXDigitToInt4 = Kit.xDigitToInt(i30, iXDigitToInt4);
                                                if (iXDigitToInt4 < 0) {
                                                    if (this.parser.compilerEnv.getLanguageVersion() >= 200) {
                                                        this.parser.reportError("msg.invalid.escape");
                                                    }
                                                    charIgnoreLineEnd = i30;
                                                } else {
                                                    addToString(i30);
                                                    i28++;
                                                }
                                                break;
                                            }
                                            iXDigitToInt = iXDigitToInt4;
                                        }
                                        this.stringBufferTop = i27;
                                        i3 = iXDigitToInt;
                                        break;
                                    case Token.AND /* 118 */:
                                        i3 = 11;
                                        i2 = i23;
                                        break;
                                    default:
                                        if (48 <= i3 && i3 < 56) {
                                            i3 -= 48;
                                            int i31 = getChar();
                                            if (48 <= i31 && i31 < 56) {
                                                i3 = ((i3 * 8) + i31) - 48;
                                                i31 = getChar();
                                                if (48 <= i31 && i31 < 56 && i3 <= 31) {
                                                    i3 = ((i3 * 8) + i31) - 48;
                                                    i31 = getChar();
                                                }
                                            }
                                            ungetChar(i31);
                                        }
                                        i2 = i23;
                                        break;
                                }
                            } else {
                                i2 = i23;
                                charIgnoreLineEnd = getChar();
                                int iXDigitToInt5 = Kit.xDigitToInt(charIgnoreLineEnd, 0);
                                if (iXDigitToInt5 < 0) {
                                    addToString(120);
                                } else {
                                    i4 = getChar();
                                    int iXDigitToInt6 = Kit.xDigitToInt(i4, iXDigitToInt5);
                                    if (iXDigitToInt6 < 0) {
                                        addToString(120);
                                        addToString(charIgnoreLineEnd);
                                        charIgnoreLineEnd = i4;
                                    } else {
                                        i3 = iXDigitToInt6;
                                    }
                                }
                            }
                            i23 = i2;
                            i24 = 114;
                            i11 = 92;
                            i12 = 10;
                            i18 = 4;
                        } else {
                            i2 = i23;
                            i3 = 13;
                        }
                    } else {
                        i2 = i23;
                        i3 = charIgnoreLineEnd;
                    }
                    addToString(i3);
                    i4 = getChar(false);
                    charIgnoreLineEnd = i4;
                    i23 = i2;
                    i24 = 114;
                    i11 = 92;
                    i12 = 10;
                    i18 = 4;
                }
                this.string = internString(getStringFromBuffer());
                int i32 = this.sourceCursor;
                this.cursor = i32;
                this.tokenEnd = i32;
                return 46;
            }
            if (digits == 35 && this.cursor == 1 && peekChar() == 33 && !this.parser.calledByCompileFunction) {
                skipLine();
                return Token.COMMENT;
            }
            if (digits == 33) {
                if (matchChar(61)) {
                    return matchChar(61) ? 52 : 13;
                }
                return 26;
            }
            if (digits == 91) {
                return 92;
            }
            if (digits == 96) {
                return 180;
            }
            if (digits == 37) {
                if (matchChar(61)) {
                    return Token.ASSIGN_MOD;
                }
                return 25;
            }
            if (digits == 38) {
                return matchChar(38) ? matchChar(61) ? Token.ASSIGN_LOGICAL_AND : Token.AND : matchChar(61) ? 103 : 11;
            }
            if (digits == 93) {
                return 93;
            }
            if (digits == 94) {
                return matchChar(61) ? 102 : 10;
            }
            switch (digits) {
                case 40:
                    return 96;
                case Token.SETELEM /* 41 */:
                    return 97;
                case Token.SETELEM_SUPER /* 42 */:
                    if (this.parser.compilerEnv.getLanguageVersion() < 200 || !matchChar(42)) {
                        return matchChar(61) ? 110 : 23;
                    }
                    if (matchChar(61)) {
                        return Token.ASSIGN_EXP;
                    }
                    return 81;
                case Token.CALL /* 43 */:
                    if (matchChar(61)) {
                        return Token.ASSIGN_ADD;
                    }
                    if (matchChar(43)) {
                        return Token.INC;
                    }
                    return 21;
                case Token.NAME /* 44 */:
                    return 98;
                case Token.NUMBER /* 45 */:
                    if (matchChar(61)) {
                        i19 = Token.ASSIGN_SUB;
                    } else if (!matchChar(45)) {
                        i19 = 22;
                    } else if (!this.dirtyLine && matchChar(62)) {
                        markCommentStart("--");
                        skipLine();
                        this.commentType = Token.CommentType.HTML;
                        return Token.COMMENT;
                    }
                    this.dirtyLine = true;
                    return i19;
                case Token.STRING /* 46 */:
                    if (matchChar(46)) {
                        return (this.parser.compilerEnv.getLanguageVersion() < 180 || !matchChar(46)) ? Token.DOTDOT : Token.DOTDOTDOT;
                    }
                    if (matchChar(40)) {
                        return 160;
                    }
                    return Token.DOT;
                case Token.NULL /* 47 */:
                    markCommentStart();
                    if (matchChar(47)) {
                        this.tokenStartLastLineEnd = this.lastLineEnd;
                        this.tokenStartLineno = this.lineno;
                        this.tokenBeg = this.cursor + REPORT_NUMBER_FORMAT_ERROR;
                        skipLine();
                        this.commentType = Token.CommentType.LINE;
                        return Token.COMMENT;
                    }
                    if (!matchChar(42)) {
                        if (matchChar(61)) {
                            return Token.ASSIGN_DIV;
                        }
                        return 24;
                    }
                    this.tokenStartLastLineEnd = this.lastLineEnd;
                    this.tokenStartLineno = this.lineno;
                    this.tokenBeg = this.cursor + REPORT_NUMBER_FORMAT_ERROR;
                    if (matchChar(42)) {
                        this.commentType = Token.CommentType.JSDOC;
                        z6 = true;
                        while (true) {
                            i6 = getChar();
                            if (i6 == -1) {
                                this.tokenEnd = this.cursor - 1;
                                this.parser.addError("msg.unterminated.comment");
                                return Token.COMMENT;
                            }
                            if (i6 != 42) {
                                if (i6 != 47) {
                                    this.tokenEnd = this.cursor;
                                    z6 = false;
                                } else if (z6) {
                                    int i33 = this.sourceCursor;
                                    this.cursor = i33;
                                    this.tokenEnd = i33;
                                    return Token.COMMENT;
                                }
                            }
                        }
                    } else {
                        this.commentType = Token.CommentType.BLOCK_COMMENT;
                        z6 = false;
                        while (true) {
                            i6 = getChar();
                            if (i6 == -1) {
                            }
                        }
                    }
                    break;
                default:
                    switch (digits) {
                        case Token.INSTANCEOF /* 58 */:
                            return matchChar(58) ? Token.COLONCOLON : Token.COLON;
                        case Token.LOCAL_LOAD /* 59 */:
                            return 91;
                        case 60:
                            if (matchChar(33)) {
                                if (matchChar(45)) {
                                    if (matchChar(45)) {
                                        this.tokenStartLastLineEnd = this.lastLineEnd;
                                        this.tokenStartLineno = this.lineno;
                                        this.tokenBeg = this.cursor - 4;
                                        skipLine();
                                        this.commentType = Token.CommentType.HTML;
                                        return Token.COMMENT;
                                    }
                                    ungetCharIgnoreLineEnd(45);
                                }
                                ungetCharIgnoreLineEnd(33);
                            }
                            if (!matchChar(60)) {
                                return matchChar(61) ? 15 : 14;
                            }
                            if (matchChar(61)) {
                                return Token.ASSIGN_LSH;
                            }
                            return 18;
                        case Token.SETVAR /* 61 */:
                            if (matchChar(61)) {
                                return matchChar(61) ? 51 : 12;
                            }
                            if (matchChar(62)) {
                                return Token.ARROW;
                            }
                            return 99;
                        case Token.CATCH_SCOPE /* 62 */:
                            if (!matchChar(62)) {
                                return matchChar(61) ? 17 : 16;
                            }
                            if (matchChar(62)) {
                                if (matchChar(61)) {
                                    return Token.ASSIGN_URSH;
                                }
                                return 20;
                            }
                            if (matchChar(61)) {
                                return Token.ASSIGN_RSH;
                            }
                            return 19;
                        case Token.ENUM_INIT_KEYS /* 63 */:
                            if (this.parser.compilerEnv.getLanguageVersion() < 200) {
                                return Token.HOOK;
                            }
                            if (peekChar() == 46) {
                                getChar();
                                if (!isDigit(peekChar())) {
                                    return Token.QUESTION_DOT;
                                }
                                ungetChar(46);
                                return Token.HOOK;
                            }
                            if (!matchChar(63)) {
                                return Token.HOOK;
                            }
                            if (matchChar(61)) {
                                return 114;
                            }
                            return Token.NULLISH_COALESCING;
                        default:
                            switch (digits) {
                                case Token.EXPORT /* 123 */:
                                    return 94;
                                case Token.IMPORT /* 124 */:
                                    if (!matchChar(Token.IMPORT)) {
                                        return matchChar(61) ? 100 : 9;
                                    }
                                    if (matchChar(61)) {
                                        return 101;
                                    }
                                    return Token.OR;
                                case Token.IF /* 125 */:
                                    return 95;
                                case 126:
                                    return 27;
                                default:
                                    this.parser.addError("msg.illegal.character", digits);
                                    return -1;
                            }
                    }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getTokenBeg() {
        return this.tokenBeg;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getTokenColumn() {
        return (this.tokenBeg - this.tokenStartLastLineEnd) + 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getTokenEnd() {
        return this.tokenEnd;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getTokenLength() {
        return this.tokenEnd - this.tokenBeg;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getTokenStartLineno() {
        return this.tokenStartLineno;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean isNumericBinary() {
        return this.isBinary;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean isNumericHex() {
        return this.isHex;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean isNumericOctal() {
        return this.isOctal;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean isNumericOldOctal() {
        return this.isOldOctal;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isXMLAttribute() {
        return this.xmlIsAttribute;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String readAndClearRegExpFlags() {
        String str = this.regExpFlags;
        this.regExpFlags = null;
        return str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00fc, code lost:
    
        ungetChar(r2);
        r8.tokenEnd = r8.cursor - 1;
        r8.string = new java.lang.String(r8.stringBuffer, 0, r8.stringBufferTop);
        r8.parser.reportError("msg.unterminated.re.lit");
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0114, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void readRegExp(int i) {
        int i2;
        int i3 = this.tokenBeg;
        this.stringBufferTop = 0;
        if (i == 111) {
            addToString(61);
        } else {
            if (i != 24) {
                Kit.codeBug();
            }
            if (peekChar() == 42) {
                this.tokenEnd = this.cursor - 1;
                this.string = new String(this.stringBuffer, 0, this.stringBufferTop);
                this.parser.reportError("msg.unterminated.re.lit");
                return;
            }
        }
        boolean z = false;
        while (true) {
            i2 = getChar();
            if (i2 == 47 && !z) {
                int i4 = this.stringBufferTop;
                while (true) {
                    if (!matchChar(103)) {
                        if (!matchChar(Token.ASSIGN_LSH)) {
                            if (!matchChar(Token.ASSIGN_SUB)) {
                                if (!matchChar(Token.HOOK)) {
                                    if (!matchChar(Token.DOT)) {
                                        break;
                                    } else {
                                        addToString(Token.DOT);
                                    }
                                } else {
                                    addToString(Token.HOOK);
                                }
                            } else {
                                addToString(Token.ASSIGN_SUB);
                            }
                        } else {
                            addToString(Token.ASSIGN_LSH);
                        }
                    } else {
                        addToString(103);
                    }
                }
                this.tokenEnd = i3 + this.stringBufferTop + 2;
                if (isAlpha(peekChar())) {
                    this.parser.reportError("msg.invalid.re.flag", String.valueOf(Character.toChars(peekChar())));
                }
                this.string = new String(this.stringBuffer, 0, i4);
                this.regExpFlags = new String(this.stringBuffer, i4, this.stringBufferTop - i4);
                return;
            }
            if (i2 == 10 || i2 == -1) {
                break;
            }
            if (i2 == 92) {
                addToString(i2);
                i2 = getChar();
                if (i2 == 10 || i2 == -1) {
                    break;
                }
            } else if (i2 == 91) {
                z = true;
            } else if (i2 == 93) {
                z = false;
            }
            addToString(i2);
        }
        ungetChar(i2);
        this.tokenEnd = this.cursor - 1;
        this.string = new String(this.stringBuffer, 0, this.stringBufferTop);
        this.parser.reportError("msg.unterminated.re.lit");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0092, code lost:
    
        if (r2 < 0) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0097, code lost:
    
        if (r2 <= 1114111) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x009d, code lost:
    
        if (r2 <= 65535) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x009f, code lost:
    
        addToString(java.lang.Character.highSurrogate(r2));
        addToString(java.lang.Character.lowSurrogate(r2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00af, code lost:
    
        if (r11 == false) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00b4, code lost:
    
        r10.parser.reportError("msg.syntax");
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b9, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int readTemplateLiteral(boolean z) {
        this.rawString.setLength(0);
        this.stringBufferTop = 0;
        boolean z2 = false;
        while (true) {
            int templateLiteralChar = getTemplateLiteralChar();
            if (templateLiteralChar == -1) {
                this.string = z2 ? null : getStringFromBuffer();
                this.tokenEnd = this.cursor - 1;
                this.parser.reportError("msg.unexpected.eof");
                return -1;
            }
            if (templateLiteralChar == 36) {
                if (matchTemplateLiteralChar(Token.EXPORT)) {
                    StringBuilder sb = this.rawString;
                    sb.setLength(sb.length() - 2);
                    this.string = z2 ? null : getStringFromBuffer();
                    this.tokenEnd = this.cursor - 1;
                    return Token.TEMPLATE_LITERAL_SUBST;
                }
                addToString(templateLiteralChar);
            } else if (templateLiteralChar == 92) {
                int templateLiteralChar2 = getTemplateLiteralChar();
                if (templateLiteralChar2 == 10) {
                    continue;
                } else {
                    if (templateLiteralChar2 == 98) {
                        templateLiteralChar2 = 8;
                    } else if (templateLiteralChar2 == 102) {
                        templateLiteralChar2 = 12;
                    } else if (templateLiteralChar2 == 110) {
                        templateLiteralChar2 = 10;
                    } else if (templateLiteralChar2 == 114) {
                        templateLiteralChar2 = 13;
                    } else if (templateLiteralChar2 == 120) {
                        int i = 0;
                        int iXDigitToInt = 0;
                        while (true) {
                            if (i >= 2) {
                                templateLiteralChar2 = iXDigitToInt;
                            } else if (peekTemplateLiteralChar() == 96) {
                                templateLiteralChar2 = -1;
                            } else {
                                iXDigitToInt = Kit.xDigitToInt(getTemplateLiteralChar(), iXDigitToInt);
                                i++;
                            }
                        }
                        if (templateLiteralChar2 < 0) {
                            if (!z) {
                                this.parser.reportError("msg.syntax");
                                return -1;
                            }
                            z2 = true;
                        }
                    } else if (templateLiteralChar2 != 8232 && templateLiteralChar2 != 8233) {
                        switch (templateLiteralChar2) {
                            case 48:
                                int iPeekTemplateLiteralChar = peekTemplateLiteralChar();
                                if (iPeekTemplateLiteralChar >= 48 && iPeekTemplateLiteralChar <= 57) {
                                    if (!z) {
                                        this.parser.reportError("msg.syntax");
                                        return -1;
                                    }
                                    z2 = true;
                                } else {
                                    templateLiteralChar2 = 0;
                                }
                                break;
                            case Token.FALSE /* 49 */:
                            case 50:
                            case Token.SHEQ /* 51 */:
                            case Token.SHNE /* 52 */:
                            case Token.REGEXP /* 53 */:
                            case Token.BINDNAME /* 54 */:
                            case Token.THROW /* 55 */:
                            case Token.RETHROW /* 56 */:
                            case Token.IN /* 57 */:
                                if (!z) {
                                    this.parser.reportError("msg.syntax");
                                    return -1;
                                }
                                z2 = true;
                                break;
                            default:
                                switch (templateLiteralChar2) {
                                    case Token.COLON /* 116 */:
                                        templateLiteralChar2 = 9;
                                        break;
                                    case Token.OR /* 117 */:
                                        if (!matchTemplateLiteralChar(Token.EXPORT)) {
                                            int i2 = 0;
                                            int iXDigitToInt2 = 0;
                                            while (true) {
                                                if (i2 >= 4) {
                                                    templateLiteralChar2 = iXDigitToInt2;
                                                } else if (peekTemplateLiteralChar() == 96) {
                                                    templateLiteralChar2 = -1;
                                                } else {
                                                    iXDigitToInt2 = Kit.xDigitToInt(getTemplateLiteralChar(), iXDigitToInt2);
                                                    i2++;
                                                }
                                            }
                                            if (templateLiteralChar2 < 0) {
                                                if (!z) {
                                                    this.parser.reportError("msg.syntax");
                                                    return -1;
                                                }
                                                z2 = true;
                                            }
                                        } else {
                                            templateLiteralChar2 = 0;
                                            while (true) {
                                                if (peekTemplateLiteralChar() == 96) {
                                                    templateLiteralChar2 = -1;
                                                } else {
                                                    int templateLiteralChar3 = getTemplateLiteralChar();
                                                    if (templateLiteralChar3 == -1) {
                                                        this.parser.reportError("msg.syntax");
                                                        return -1;
                                                    }
                                                    if (templateLiteralChar3 != 125) {
                                                        templateLiteralChar2 = Kit.xDigitToInt(templateLiteralChar3, templateLiteralChar2);
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                    case Token.AND /* 118 */:
                                        templateLiteralChar2 = 11;
                                        break;
                                }
                                break;
                        }
                    }
                    addToString(templateLiteralChar2);
                }
            } else {
                if (templateLiteralChar == 96) {
                    StringBuilder sb2 = this.rawString;
                    sb2.setLength(sb2.length() - 1);
                    this.string = z2 ? null : getStringFromBuffer();
                    int i3 = this.sourceCursor;
                    this.cursor = i3;
                    this.tokenEnd = i3;
                    return 180;
                }
                addToString(templateLiteralChar);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String tokenToString(int i) {
        return "";
    }

    private int getCharIgnoreLineEnd(boolean z) {
        return getChar(z, true);
    }

    private void markCommentStart() {
        markCommentStart("");
    }

    private static boolean isDigit(int i) {
        return 48 <= i && i <= 57;
    }

    @Override // org.mozilla.javascript.Parser.CurrentPositionReporter
    public String getLine() {
        int i;
        int i2 = this.sourceCursor;
        int i3 = this.lineEndChar;
        if (i3 >= 0) {
            i = i2 - 1;
            if (i3 == 10 && charAt(i2 + REPORT_NUMBER_FORMAT_ERROR) == 13) {
                i = i2 + REPORT_NUMBER_FORMAT_ERROR;
            }
        } else {
            int i4 = i2 - this.lineStart;
            while (true) {
                int iCharAt = charAt(this.lineStart + i4);
                if (iCharAt == -1 || ScriptRuntime.isJSLineTerminator(iCharAt)) {
                    break;
                }
                i4++;
            }
            i = this.lineStart + i4;
        }
        return substring(this.lineStart, i);
    }

    private int getChar(boolean z) {
        return getChar(z, false);
    }

    private int getChar() {
        return getChar(true, false);
    }
}
