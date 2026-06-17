package org.mozilla.javascript.json;

import java.util.ArrayList;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class JsonParser {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Context cx;
    private int length;
    private int pos;
    private Scriptable scope;
    private String src;

    public JsonParser(Context context, Scriptable scriptable) {
        this.cx = context;
        this.scope = scriptable;
    }

    private void consume(char c) throws ParseException {
        consumeWhitespace();
        int i = this.pos;
        if (i >= this.length) {
            throw new ParseException("Expected " + c + " but reached end of stream");
        }
        String str = this.src;
        this.pos = i + 1;
        char cCharAt = str.charAt(i);
        if (cCharAt == c) {
            return;
        }
        throw new ParseException("Expected " + c + " found " + cCharAt);
    }

    private void consumeWhitespace() {
        while (true) {
            int i = this.pos;
            if (i >= this.length) {
                return;
            }
            char cCharAt = this.src.charAt(i);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != ' ') {
                return;
            } else {
                this.pos++;
            }
        }
    }

    private static int fromHex(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'A' && c <= 'F') {
            return c - '7';
        }
        if (c < 'a' || c > 'f') {
            return -1;
        }
        return c - 'W';
    }

    private char nextOrNumberError(int i) throws ParseException {
        int i2 = this.pos;
        int i3 = this.length;
        if (i2 >= i3) {
            throw numberError(i, i3);
        }
        String str = this.src;
        this.pos = i2 + 1;
        return str.charAt(i2);
    }

    private ParseException numberError(int i, int i2) {
        return new ParseException("Unsupported number format: ".concat(this.src.substring(i, i2)));
    }

    private Object readArray() throws ParseException {
        consumeWhitespace();
        int i = this.pos;
        if (i < this.length && this.src.charAt(i) == ']') {
            this.pos++;
            return this.cx.newArray(this.scope, 0);
        }
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        while (true) {
            int i2 = this.pos;
            if (i2 >= this.length) {
                throw new ParseException("Unterminated array literal");
            }
            char cCharAt = this.src.charAt(i2);
            if (cCharAt != ',') {
                if (cCharAt == ']') {
                    if (!z) {
                        throw new ParseException("Unexpected comma in array literal");
                    }
                    this.pos++;
                    return this.cx.newArray(this.scope, arrayList.toArray());
                }
                if (z) {
                    throw new ParseException("Missing comma in array literal");
                }
                arrayList.add(readValue());
                z = true;
            } else {
                if (!z) {
                    throw new ParseException("Unexpected comma in array literal");
                }
                this.pos++;
                z = false;
            }
            consumeWhitespace();
        }
    }

    private void readDigits() {
        char cCharAt;
        while (true) {
            int i = this.pos;
            if (i >= this.length || (cCharAt = this.src.charAt(i)) < '0' || cCharAt > '9') {
                return;
            } else {
                this.pos++;
            }
        }
    }

    private Boolean readFalse() throws ParseException {
        int i = this.length;
        int i2 = this.pos;
        if (i - i2 < 4 || this.src.charAt(i2) != 'a' || this.src.charAt(this.pos + 1) != 'l' || this.src.charAt(this.pos + 2) != 's' || this.src.charAt(this.pos + 3) != 'e') {
            throw new ParseException("Unexpected token: f");
        }
        this.pos += 4;
        return Boolean.FALSE;
    }

    private Object readNull() throws ParseException {
        int i = this.length;
        int i2 = this.pos;
        if (i - i2 < 3 || this.src.charAt(i2) != 'u' || this.src.charAt(this.pos + 1) != 'l' || this.src.charAt(this.pos + 2) != 'l') {
            throw new ParseException("Unexpected token: n");
        }
        this.pos += 3;
        return null;
    }

    private Number readNumber(char c) throws ParseException {
        char cCharAt;
        int i = this.pos - 1;
        if (c == '-' && ((c = nextOrNumberError(i)) < '0' || c > '9')) {
            throw numberError(i, this.pos);
        }
        if (c != '0') {
            readDigits();
        }
        int i2 = this.pos;
        if (i2 < this.length && this.src.charAt(i2) == '.') {
            this.pos++;
            char cNextOrNumberError = nextOrNumberError(i);
            if (cNextOrNumberError < '0' || cNextOrNumberError > '9') {
                throw numberError(i, this.pos);
            }
            readDigits();
        }
        int i3 = this.pos;
        if (i3 < this.length && ((cCharAt = this.src.charAt(i3)) == 'e' || cCharAt == 'E')) {
            this.pos++;
            char cNextOrNumberError2 = nextOrNumberError(i);
            if (cNextOrNumberError2 == '-' || cNextOrNumberError2 == '+') {
                cNextOrNumberError2 = nextOrNumberError(i);
            }
            if (cNextOrNumberError2 < '0' || cNextOrNumberError2 > '9') {
                throw numberError(i, this.pos);
            }
            readDigits();
        }
        double d = Double.parseDouble(this.src.substring(i, this.pos));
        int i4 = (int) d;
        return ((double) i4) == d ? Integer.valueOf(i4) : Double.valueOf(d);
    }

    private Object readObject() throws ParseException {
        consumeWhitespace();
        Scriptable scriptableNewObject = this.cx.newObject(this.scope);
        int i = this.pos;
        if (i < this.length && this.src.charAt(i) == '}') {
            this.pos++;
            return scriptableNewObject;
        }
        boolean z = false;
        while (true) {
            int i2 = this.pos;
            if (i2 >= this.length) {
                throw new ParseException("Unterminated object literal");
            }
            String str = this.src;
            this.pos = i2 + 1;
            char cCharAt = str.charAt(i2);
            if (cCharAt != '\"') {
                if (cCharAt != ',') {
                    if (cCharAt != '}') {
                        throw new ParseException("Unexpected token in object literal");
                    }
                    if (z) {
                        return scriptableNewObject;
                    }
                    throw new ParseException("Unexpected comma in object literal");
                }
                if (!z) {
                    throw new ParseException("Unexpected comma in object literal");
                }
                z = false;
            } else {
                if (z) {
                    throw new ParseException("Missing comma in object literal");
                }
                String string = readString();
                consume(':');
                Object value = readValue();
                ScriptRuntime.StringIdOrIndex stringIdOrIndex = ScriptRuntime.toStringIdOrIndex(string);
                if (stringIdOrIndex.getStringId() == null) {
                    scriptableNewObject.put(stringIdOrIndex.getIndex(), scriptableNewObject, value);
                } else {
                    scriptableNewObject.put(stringIdOrIndex.getStringId(), scriptableNewObject, value);
                }
                z = true;
            }
            consumeWhitespace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x0037, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String readString() throws org.mozilla.javascript.json.JsonParser.ParseException {
        /*
            Method dump skipped, instruction units count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.json.JsonParser.readString():java.lang.String");
    }

    private Boolean readTrue() throws ParseException {
        int i = this.length;
        int i2 = this.pos;
        if (i - i2 < 3 || this.src.charAt(i2) != 'r' || this.src.charAt(this.pos + 1) != 'u' || this.src.charAt(this.pos + 2) != 'e') {
            throw new ParseException("Unexpected token: t");
        }
        this.pos += 3;
        return Boolean.TRUE;
    }

    private Object readValue() throws ParseException {
        consumeWhitespace();
        int i = this.pos;
        if (i >= this.length) {
            throw new ParseException("Empty JSON string");
        }
        String str = this.src;
        this.pos = i + 1;
        char cCharAt = str.charAt(i);
        if (cCharAt == '\"') {
            return readString();
        }
        if (cCharAt != '-') {
            if (cCharAt == '[') {
                return readArray();
            }
            if (cCharAt == 'f') {
                return readFalse();
            }
            if (cCharAt == 'n') {
                return readNull();
            }
            if (cCharAt == 't') {
                return readTrue();
            }
            if (cCharAt == '{') {
                return readObject();
            }
            switch (cCharAt) {
                case '0':
                case Token.FALSE /* 49 */:
                case '2':
                case Token.SHEQ /* 51 */:
                case Token.SHNE /* 52 */:
                case Token.REGEXP /* 53 */:
                case Token.BINDNAME /* 54 */:
                case Token.THROW /* 55 */:
                case Token.RETHROW /* 56 */:
                case Token.IN /* 57 */:
                    break;
                default:
                    throw new ParseException("Unexpected token: " + cCharAt);
            }
        }
        return readNumber(cCharAt);
    }

    public synchronized Object parseValue(String str) {
        Object value;
        try {
            if (str == null) {
                throw new ParseException("Input string may not be null");
            }
            this.pos = 0;
            this.length = str.length();
            this.src = str;
            value = readValue();
            consumeWhitespace();
            if (this.pos < this.length) {
                throw new ParseException("Expected end of stream at char " + this.pos);
            }
        } catch (Throwable th) {
            throw th;
        }
        return value;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class ParseException extends Exception {
        private static final long serialVersionUID = 4804542791749920772L;

        public ParseException(String str) {
            super(str);
        }

        public ParseException(Exception exc) {
            super(exc);
        }
    }
}
