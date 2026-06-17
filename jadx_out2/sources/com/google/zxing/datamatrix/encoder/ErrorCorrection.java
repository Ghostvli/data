package com.google.zxing.datamatrix.encoder;

import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.b;
import defpackage.jl;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ErrorCorrection {
    private static final int MODULO_VALUE = 301;
    private static final int[] FACTOR_SETS = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    private static final int[][] FACTORS = {new int[]{228, 48, 15, Token.ASSIGN_DIV, 62}, new int[]{23, 68, Token.LABEL, Token.CONTINUE, 240, 92, 254}, new int[]{28, 24, Token.NULLISH_COALESCING, Token.SET, 223, 248, Token.COLON, 255, 110, 61}, new int[]{Token.COMMENT, Token.FINALLY, 205, 12, 194, Token.CONST, 39, 245, 60, 97, 120}, new int[]{41, Token.SETPROP_OP, Token.COLONCOLON, 91, 61, 42, Token.COMPUTED_PROPERTY, 213, 97, Token.ARROW, 100, 242}, new int[]{Token.SET_REF_OP, 97, 192, 252, 95, 9, Token.DOTDOT, Token.INC, Token.FINALLY, 45, 18, Token.QUESTION_DOT, 83, Token.NULLISH_COALESCING}, new int[]{83, 195, 100, 39, 188, 75, 66, 61, 241, 213, Token.ASSIGN_SUB, Token.DEFAULT, 94, 254, 225, 48, 90, 188}, new int[]{15, 195, 244, 9, 233, 71, Token.CONST, 2, 188, 160, Token.SETPROP_OP, Token.TARGET, 253, 79, Token.ASSIGN_ADD, 82, 27, Token.DEBUGGER, Token.QUESTION_DOT, Token.LETEXPR}, new int[]{52, 190, 88, 205, Token.ASSIGN_SUB, 39, Token.GENEXPR, 21, Token.LOCAL_BLOCK, 197, 251, 223, Token.LOCAL_BLOCK, 21, 5, Token.LETEXPR, 254, Token.IMPORT, 12, Token.TEMPLATE_CHARS, Token.DOTDOTDOT, 96, 50, 193}, new int[]{211, 231, 43, 97, 71, 96, 103, Token.DEBUGGER, 37, Token.TYPEOFNAME, 170, 53, 75, 34, 249, Token.DOT, 17, Token.FINALLY, 110, 213, Token.EMPTY, Token.WITH, 120, Token.TYPEOFNAME, 233, Token.CONST, 93, 255}, new int[]{245, 127, 242, 218, 130, Context.VERSION_ECMASCRIPT, Token.XMLEND, Token.TEMPLATE_CHARS, 102, 120, 84, Token.YIELD_STAR, 220, 251, 80, Token.TEMPLATE_LITERAL_SUBST, 229, 18, 2, 4, 68, 33, 101, Token.CATCH, 95, Token.INC, Token.HOOK, 44, Token.COMMENT, Token.DOTDOTDOT, 59, 25, 225, 98, 81, Token.ASSIGN_MOD}, new int[]{77, 193, Token.CATCH, 31, 19, 38, 22, Token.SETPROP_OP, 247, Token.ASSIGN_LSH, Token.FUNCTION, 2, 245, Token.BREAK, 242, 8, Token.COMMENT, 95, 100, 9, Token.LET, Token.ASSIGN_LSH, 214, Token.ASSIGN_DIV, 57, Token.DOT, 21, 1, 253, 57, 54, 101, 248, 202, 69, 50, 150, Token.METHOD, 226, 5, 9, 5}, new int[]{245, Token.FOR, Token.LETEXPR, 223, 96, 32, Token.OR, 22, 238, Token.BREAK, 238, 231, 205, 188, 237, 87, 191, Token.ASSIGN_RSH, 16, Token.EXPR_VOID, Token.AND, 23, 37, 90, 170, 205, Token.DO, 88, 120, 100, 66, Token.FINALLY, Token.QUESTION_DOT, 240, 82, 44, Token.GENEXPR, 87, Token.LAST_TOKEN, Token.EXPR_VOID, 160, Token.COMMENT, 69, 213, 92, 253, 225, 19}, new int[]{Token.COMMENT, 9, 223, 238, 12, 17, 220, 208, 100, 29, Token.COMMENT, 170, 230, 192, 215, 235, 150, Token.XML, 36, 223, 38, 200, Token.FOR, 54, 228, Token.LOOP, 218, 234, Token.OR, 203, 29, 232, Token.LABEL, 238, 22, 150, 201, Token.OR, 62, 207, Token.TO_DOUBLE, 13, Token.CATCH, 245, 127, 67, 247, 28, Token.LOCAL_BLOCK, 43, 203, Token.ASSIGN_URSH, 233, 53, Token.BLOCK, 46}, new int[]{242, 93, Token.SETCONST, 50, Token.LABEL, 210, 39, Token.AND, 202, 188, 201, 189, Token.BLOCK, Token.ASSIGN_ADD, 196, 37, Token.NULLISH_COALESCING, Token.ASSIGN_MOD, Token.CONTINUE, 230, 245, 63, 197, 190, Context.VERSION_ECMASCRIPT, Token.ASSIGN_RSH, Token.NULLISH_COALESCING, 221, Token.COMMENT, 64, 114, 71, Token.XMLATTR, 44, Token.EXPR_VOID, 6, 27, 218, 51, 63, 87, 10, 40, 130, 188, 17, Token.TO_OBJECT, 31, Token.GENEXPR, 170, 4, Token.ASSIGN_URSH, 232, 7, 94, Token.SET, 224, Token.IMPORT, 86, 47, 11, 204}, new int[]{220, 228, Token.WITHEXPR, 89, 251, Token.JSR, Token.XML, 56, 89, 33, Token.EXPR_VOID, 244, Token.SETELEM_OP, 36, 73, 127, 213, Token.WITH, 248, 180, 234, 197, Token.COLONCOLON, Token.METHOD, 68, Token.FUNCTION, 93, 213, 15, 160, 227, 236, 66, Token.VOID, Token.SETPROP_OP, Token.NULLISH_COALESCING, 202, Token.LET, Token.YIELD_STAR, 25, 220, 232, 96, 210, 231, Token.WITH, 223, 239, Token.TEMPLATE_CHARS, 241, 59, 52, Token.LETEXPR, 25, 49, 232, 211, 189, 64, 54, Token.ASSIGN_ADD, Token.SETPROP_OP, Token.FOR, 63, 96, 103, 82, Token.QUESTION_DOT}};
    private static final int[] LOG = new int[Buffer.DEFAULT_SIZE];
    private static final int[] ALOG = new int[255];

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        int i = 1;
        for (int i2 = 0; i2 < 255; i2++) {
            ALOG[i2] = i;
            LOG[i] = i2;
            i *= 2;
            if (i >= 256) {
                i ^= MODULO_VALUE;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private ErrorCorrection() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static String createECCBlock(CharSequence charSequence, int i) {
        int i2;
        int i3;
        int i4 = 0;
        while (true) {
            int[] iArr = FACTOR_SETS;
            if (i4 >= iArr.length) {
                i4 = -1;
                break;
            }
            if (iArr[i4] == i) {
                break;
            }
            i4++;
        }
        if (i4 < 0) {
            b.a("Illegal number of error correction codewords specified: ", i);
            return null;
        }
        int[] iArr2 = FACTORS[i4];
        char[] cArr = new char[i];
        for (int i5 = 0; i5 < i; i5++) {
            cArr[i5] = 0;
        }
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            int i7 = i - 1;
            int iCharAt = cArr[i7] ^ charSequence.charAt(i6);
            while (i7 > 0) {
                if (iCharAt == 0 || (i3 = iArr2[i7]) == 0) {
                    cArr[i7] = cArr[i7 - 1];
                } else {
                    char c = cArr[i7 - 1];
                    int[] iArr3 = ALOG;
                    int[] iArr4 = LOG;
                    cArr[i7] = (char) (iArr3[(iArr4[iCharAt] + iArr4[i3]) % 255] ^ c);
                }
                i7--;
            }
            if (iCharAt == 0 || (i2 = iArr2[0]) == 0) {
                cArr[0] = 0;
            } else {
                int[] iArr5 = ALOG;
                int[] iArr6 = LOG;
                cArr[0] = (char) iArr5[(iArr6[iCharAt] + iArr6[i2]) % 255];
            }
        }
        char[] cArr2 = new char[i];
        for (int i8 = 0; i8 < i; i8++) {
            cArr2[i8] = cArr[(i - i8) - 1];
        }
        return String.valueOf(cArr2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String encodeECC200(String str, SymbolInfo symbolInfo) {
        if (str.length() != symbolInfo.getDataCapacity()) {
            jl.a("The number of codewords does not match the selected symbol");
            return null;
        }
        StringBuilder sb = new StringBuilder(symbolInfo.getDataCapacity() + symbolInfo.getErrorCodewords());
        sb.append(str);
        int interleavedBlockCount = symbolInfo.getInterleavedBlockCount();
        if (interleavedBlockCount == 1) {
            sb.append(createECCBlock(str, symbolInfo.getErrorCodewords()));
        } else {
            sb.setLength(sb.capacity());
            int[] iArr = new int[interleavedBlockCount];
            int[] iArr2 = new int[interleavedBlockCount];
            int i = 0;
            while (i < interleavedBlockCount) {
                int i2 = i + 1;
                iArr[i] = symbolInfo.getDataLengthForInterleavedBlock(i2);
                iArr2[i] = symbolInfo.getErrorLengthForInterleavedBlock(i2);
                i = i2;
            }
            for (int i3 = 0; i3 < interleavedBlockCount; i3++) {
                StringBuilder sb2 = new StringBuilder(iArr[i3]);
                for (int i4 = i3; i4 < symbolInfo.getDataCapacity(); i4 += interleavedBlockCount) {
                    sb2.append(str.charAt(i4));
                }
                String strCreateECCBlock = createECCBlock(sb2.toString(), iArr2[i3]);
                int i5 = 0;
                int i6 = i3;
                while (i6 < iArr2[i3] * interleavedBlockCount) {
                    sb.setCharAt(symbolInfo.getDataCapacity() + i6, strCreateECCBlock.charAt(i5));
                    i6 += interleavedBlockCount;
                    i5++;
                }
            }
        }
        return sb.toString();
    }
}
