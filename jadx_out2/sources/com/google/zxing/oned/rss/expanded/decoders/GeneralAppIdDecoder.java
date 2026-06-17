package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;
import defpackage.bo1;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
final class GeneralAppIdDecoder {
    private final BitArray information;
    private final CurrentParsingState current = new CurrentParsingState();
    private final StringBuilder buffer = new StringBuilder();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public GeneralAppIdDecoder(BitArray bitArray) {
        this.information = bitArray;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private DecodedChar decodeAlphanumeric(int i) {
        char c;
        int iExtractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 5);
        if (iExtractNumericValueFromBitArray == 15) {
            return new DecodedChar(i + 5, '$');
        }
        if (iExtractNumericValueFromBitArray >= 5 && iExtractNumericValueFromBitArray < 15) {
            return new DecodedChar(i + 5, (char) (iExtractNumericValueFromBitArray + 43));
        }
        int iExtractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i, 6);
        if (iExtractNumericValueFromBitArray2 >= 32 && iExtractNumericValueFromBitArray2 < 58) {
            return new DecodedChar(i + 6, (char) (iExtractNumericValueFromBitArray2 + 33));
        }
        switch (iExtractNumericValueFromBitArray2) {
            case Token.INSTANCEOF /* 58 */:
                c = '*';
                break;
            case Token.LOCAL_LOAD /* 59 */:
                c = ',';
                break;
            case 60:
                c = '-';
                break;
            case Token.SETVAR /* 61 */:
                c = '.';
                break;
            case Token.CATCH_SCOPE /* 62 */:
                c = '/';
                break;
            default:
                bo1.a("Decoding invalid alphanumeric value: ", iExtractNumericValueFromBitArray2);
                return null;
        }
        return new DecodedChar(i + 6, c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private DecodedChar decodeIsoIec646(int i) throws FormatException {
        int iExtractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 5);
        if (iExtractNumericValueFromBitArray == 15) {
            return new DecodedChar(i + 5, '$');
        }
        char c = '+';
        if (iExtractNumericValueFromBitArray >= 5 && iExtractNumericValueFromBitArray < 15) {
            return new DecodedChar(i + 5, (char) (iExtractNumericValueFromBitArray + 43));
        }
        int iExtractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i, 7);
        if (iExtractNumericValueFromBitArray2 >= 64 && iExtractNumericValueFromBitArray2 < 90) {
            return new DecodedChar(i + 7, (char) (iExtractNumericValueFromBitArray2 + 1));
        }
        if (iExtractNumericValueFromBitArray2 >= 90 && iExtractNumericValueFromBitArray2 < 116) {
            return new DecodedChar(i + 7, (char) (iExtractNumericValueFromBitArray2 + 7));
        }
        switch (extractNumericValueFromBitArray(i, 8)) {
            case 232:
                c = '!';
                break;
            case 233:
                c = '\"';
                break;
            case 234:
                c = '%';
                break;
            case 235:
                c = '&';
                break;
            case 236:
                c = '\'';
                break;
            case 237:
                c = '(';
                break;
            case 238:
                c = ')';
                break;
            case 239:
                c = '*';
                break;
            case 240:
                break;
            case 241:
                c = ',';
                break;
            case 242:
                c = '-';
                break;
            case 243:
                c = '.';
                break;
            case 244:
                c = '/';
                break;
            case 245:
                c = ':';
                break;
            case 246:
                c = ';';
                break;
            case 247:
                c = '<';
                break;
            case 248:
                c = '=';
                break;
            case 249:
                c = '>';
                break;
            case Context.VERSION_ECMASCRIPT /* 250 */:
                c = '?';
                break;
            case 251:
                c = '_';
                break;
            case 252:
                c = ' ';
                break;
            default:
                throw FormatException.getFormatInstance();
        }
        return new DecodedChar(i + 8, c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private DecodedNumeric decodeNumeric(int i) {
        int i2 = i + 7;
        if (i2 <= this.information.getSize()) {
            int iExtractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 7) - 8;
            return new DecodedNumeric(i2, iExtractNumericValueFromBitArray / 11, iExtractNumericValueFromBitArray % 11);
        }
        int iExtractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i, 4);
        BitArray bitArray = this.information;
        return iExtractNumericValueFromBitArray2 == 0 ? new DecodedNumeric(bitArray.getSize(), 10, 10) : new DecodedNumeric(bitArray.getSize(), iExtractNumericValueFromBitArray2 - 1, 10);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int extractNumericValueFromBitArray(BitArray bitArray, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (bitArray.get(i + i4)) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean isAlphaOr646ToNumericLatch(int i) {
        int i2 = i + 3;
        if (i2 > this.information.getSize()) {
            return false;
        }
        while (i < i2) {
            if (this.information.get(i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean isAlphaTo646ToAlphaLatch(int i) {
        int i2;
        if (i + 1 > this.information.getSize()) {
            return false;
        }
        for (int i3 = 0; i3 < 5 && (i2 = i3 + i) < this.information.getSize(); i3++) {
            BitArray bitArray = this.information;
            if (i3 == 2) {
                if (!bitArray.get(i + 2)) {
                    return false;
                }
            } else if (bitArray.get(i2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean isNumericToAlphaNumericLatch(int i) {
        int i2;
        if (i + 1 > this.information.getSize()) {
            return false;
        }
        for (int i3 = 0; i3 < 4 && (i2 = i3 + i) < this.information.getSize(); i3++) {
            if (this.information.get(i2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean isStillAlpha(int i) {
        int iExtractNumericValueFromBitArray;
        if (i + 5 > this.information.getSize()) {
            return false;
        }
        int iExtractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i, 5);
        if (iExtractNumericValueFromBitArray2 < 5 || iExtractNumericValueFromBitArray2 >= 16) {
            return i + 6 <= this.information.getSize() && (iExtractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 6)) >= 16 && iExtractNumericValueFromBitArray < 63;
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean isStillIsoIec646(int i) {
        int iExtractNumericValueFromBitArray;
        if (i + 5 > this.information.getSize()) {
            return false;
        }
        int iExtractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i, 5);
        if (iExtractNumericValueFromBitArray2 >= 5 && iExtractNumericValueFromBitArray2 < 16) {
            return true;
        }
        if (i + 7 > this.information.getSize()) {
            return false;
        }
        int iExtractNumericValueFromBitArray3 = extractNumericValueFromBitArray(i, 7);
        if (iExtractNumericValueFromBitArray3 < 64 || iExtractNumericValueFromBitArray3 >= 116) {
            return i + 8 <= this.information.getSize() && (iExtractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 8)) >= 232 && iExtractNumericValueFromBitArray < 253;
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean isStillNumeric(int i) {
        if (i + 7 > this.information.getSize()) {
            return i + 4 <= this.information.getSize();
        }
        int i2 = i;
        while (true) {
            int i3 = i + 3;
            BitArray bitArray = this.information;
            if (i2 >= i3) {
                return bitArray.get(i3);
            }
            if (bitArray.get(i2)) {
                return true;
            }
            i2++;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private BlockParsedResult parseAlphaBlock() {
        while (true) {
            boolean zIsStillAlpha = isStillAlpha(this.current.getPosition());
            CurrentParsingState currentParsingState = this.current;
            if (!zIsStillAlpha) {
                boolean zIsAlphaOr646ToNumericLatch = isAlphaOr646ToNumericLatch(currentParsingState.getPosition());
                CurrentParsingState currentParsingState2 = this.current;
                if (zIsAlphaOr646ToNumericLatch) {
                    currentParsingState2.incrementPosition(3);
                    this.current.setNumeric();
                } else if (isAlphaTo646ToAlphaLatch(currentParsingState2.getPosition())) {
                    int position = this.current.getPosition() + 5;
                    int size = this.information.getSize();
                    CurrentParsingState currentParsingState3 = this.current;
                    if (position < size) {
                        currentParsingState3.incrementPosition(5);
                    } else {
                        currentParsingState3.setPosition(this.information.getSize());
                    }
                    this.current.setIsoIec646();
                }
                return new BlockParsedResult();
            }
            DecodedChar decodedCharDecodeAlphanumeric = decodeAlphanumeric(currentParsingState.getPosition());
            this.current.setPosition(decodedCharDecodeAlphanumeric.getNewPosition());
            if (decodedCharDecodeAlphanumeric.isFNC1()) {
                return new BlockParsedResult(new DecodedInformation(this.current.getPosition(), this.buffer.toString()), true);
            }
            this.buffer.append(decodedCharDecodeAlphanumeric.getValue());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private DecodedInformation parseBlocks() throws FormatException {
        BlockParsedResult numericBlock;
        boolean zIsFinished;
        do {
            int position = this.current.getPosition();
            if (this.current.isAlpha()) {
                numericBlock = parseAlphaBlock();
                zIsFinished = numericBlock.isFinished();
            } else if (this.current.isIsoIec646()) {
                numericBlock = parseIsoIec646Block();
                zIsFinished = numericBlock.isFinished();
            } else {
                numericBlock = parseNumericBlock();
                zIsFinished = numericBlock.isFinished();
            }
            if (position == this.current.getPosition() && !zIsFinished) {
                break;
            }
        } while (!zIsFinished);
        return numericBlock.getDecodedInformation();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private BlockParsedResult parseIsoIec646Block() throws FormatException {
        while (true) {
            boolean zIsStillIsoIec646 = isStillIsoIec646(this.current.getPosition());
            CurrentParsingState currentParsingState = this.current;
            if (!zIsStillIsoIec646) {
                boolean zIsAlphaOr646ToNumericLatch = isAlphaOr646ToNumericLatch(currentParsingState.getPosition());
                CurrentParsingState currentParsingState2 = this.current;
                if (zIsAlphaOr646ToNumericLatch) {
                    currentParsingState2.incrementPosition(3);
                    this.current.setNumeric();
                } else if (isAlphaTo646ToAlphaLatch(currentParsingState2.getPosition())) {
                    int position = this.current.getPosition() + 5;
                    int size = this.information.getSize();
                    CurrentParsingState currentParsingState3 = this.current;
                    if (position < size) {
                        currentParsingState3.incrementPosition(5);
                    } else {
                        currentParsingState3.setPosition(this.information.getSize());
                    }
                    this.current.setAlpha();
                }
                return new BlockParsedResult();
            }
            DecodedChar decodedCharDecodeIsoIec646 = decodeIsoIec646(currentParsingState.getPosition());
            this.current.setPosition(decodedCharDecodeIsoIec646.getNewPosition());
            if (decodedCharDecodeIsoIec646.isFNC1()) {
                return new BlockParsedResult(new DecodedInformation(this.current.getPosition(), this.buffer.toString()), true);
            }
            this.buffer.append(decodedCharDecodeIsoIec646.getValue());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private BlockParsedResult parseNumericBlock() {
        while (true) {
            boolean zIsStillNumeric = isStillNumeric(this.current.getPosition());
            CurrentParsingState currentParsingState = this.current;
            if (!zIsStillNumeric) {
                if (isNumericToAlphaNumericLatch(currentParsingState.getPosition())) {
                    this.current.setAlpha();
                    this.current.incrementPosition(4);
                }
                return new BlockParsedResult();
            }
            DecodedNumeric decodedNumericDecodeNumeric = decodeNumeric(currentParsingState.getPosition());
            this.current.setPosition(decodedNumericDecodeNumeric.getNewPosition());
            if (decodedNumericDecodeNumeric.isFirstDigitFNC1()) {
                boolean zIsSecondDigitFNC1 = decodedNumericDecodeNumeric.isSecondDigitFNC1();
                CurrentParsingState currentParsingState2 = this.current;
                return new BlockParsedResult(zIsSecondDigitFNC1 ? new DecodedInformation(currentParsingState2.getPosition(), this.buffer.toString()) : new DecodedInformation(currentParsingState2.getPosition(), this.buffer.toString(), decodedNumericDecodeNumeric.getSecondDigit()), true);
            }
            this.buffer.append(decodedNumericDecodeNumeric.getFirstDigit());
            if (decodedNumericDecodeNumeric.isSecondDigitFNC1()) {
                return new BlockParsedResult(new DecodedInformation(this.current.getPosition(), this.buffer.toString()), true);
            }
            this.buffer.append(decodedNumericDecodeNumeric.getSecondDigit());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String decodeAllCodes(StringBuilder sb, int i) throws NotFoundException, FormatException {
        String str = null;
        while (true) {
            DecodedInformation decodedInformationDecodeGeneralPurposeField = decodeGeneralPurposeField(i, str);
            String fieldsInGeneralPurpose = FieldParser.parseFieldsInGeneralPurpose(decodedInformationDecodeGeneralPurposeField.getNewString());
            if (fieldsInGeneralPurpose != null) {
                sb.append(fieldsInGeneralPurpose);
            }
            String strValueOf = decodedInformationDecodeGeneralPurposeField.isRemaining() ? String.valueOf(decodedInformationDecodeGeneralPurposeField.getRemainingValue()) : null;
            if (i == decodedInformationDecodeGeneralPurposeField.getNewPosition()) {
                return sb.toString();
            }
            i = decodedInformationDecodeGeneralPurposeField.getNewPosition();
            str = strValueOf;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DecodedInformation decodeGeneralPurposeField(int i, String str) throws FormatException {
        this.buffer.setLength(0);
        if (str != null) {
            this.buffer.append(str);
        }
        this.current.setPosition(i);
        DecodedInformation blocks = parseBlocks();
        return (blocks == null || !blocks.isRemaining()) ? new DecodedInformation(this.current.getPosition(), this.buffer.toString()) : new DecodedInformation(this.current.getPosition(), this.buffer.toString(), blocks.getRemainingValue());
    }

    public int extractNumericValueFromBitArray(int i, int i2) {
        return extractNumericValueFromBitArray(this.information, i, i2);
    }
}
