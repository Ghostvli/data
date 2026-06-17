package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;
import defpackage.ho1;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractExpandedDecoder {
    private final GeneralAppIdDecoder generalDecoder;
    private final BitArray information;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AbstractExpandedDecoder(BitArray bitArray) {
        this.information = bitArray;
        this.generalDecoder = new GeneralAppIdDecoder(bitArray);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static AbstractExpandedDecoder createDecoder(BitArray bitArray) {
        if (bitArray.get(1)) {
            return new AI01AndOtherAIs(bitArray);
        }
        if (!bitArray.get(2)) {
            return new AnyAIDecoder(bitArray);
        }
        int iExtractNumericValueFromBitArray = GeneralAppIdDecoder.extractNumericValueFromBitArray(bitArray, 1, 4);
        if (iExtractNumericValueFromBitArray == 4) {
            return new AI013103decoder(bitArray);
        }
        if (iExtractNumericValueFromBitArray == 5) {
            return new AI01320xDecoder(bitArray);
        }
        int iExtractNumericValueFromBitArray2 = GeneralAppIdDecoder.extractNumericValueFromBitArray(bitArray, 1, 5);
        if (iExtractNumericValueFromBitArray2 == 12) {
            return new AI01392xDecoder(bitArray);
        }
        if (iExtractNumericValueFromBitArray2 == 13) {
            return new AI01393xDecoder(bitArray);
        }
        switch (GeneralAppIdDecoder.extractNumericValueFromBitArray(bitArray, 1, 7)) {
            case Token.RETHROW /* 56 */:
                return new AI013x0x1xDecoder(bitArray, "310", "11");
            case Token.IN /* 57 */:
                return new AI013x0x1xDecoder(bitArray, "320", "11");
            case Token.INSTANCEOF /* 58 */:
                return new AI013x0x1xDecoder(bitArray, "310", "13");
            case Token.LOCAL_LOAD /* 59 */:
                return new AI013x0x1xDecoder(bitArray, "320", "13");
            case 60:
                return new AI013x0x1xDecoder(bitArray, "310", "15");
            case Token.SETVAR /* 61 */:
                return new AI013x0x1xDecoder(bitArray, "320", "15");
            case Token.CATCH_SCOPE /* 62 */:
                return new AI013x0x1xDecoder(bitArray, "310", "17");
            case Token.ENUM_INIT_KEYS /* 63 */:
                return new AI013x0x1xDecoder(bitArray, "320", "17");
            default:
                ho1.a("unknown decoder: ", bitArray);
                return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final GeneralAppIdDecoder getGeneralDecoder() {
        return this.generalDecoder;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final BitArray getInformation() {
        return this.information;
    }

    public abstract String parseInformation();
}
