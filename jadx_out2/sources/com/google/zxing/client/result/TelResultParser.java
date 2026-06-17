package com.google.zxing.client.result;

import com.google.zxing.Result;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class TelResultParser extends ResultParser {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: parse(Lcom/google/zxing/Result;)Lcom/google/zxing/client/result/ParsedResult; */
    @Override // com.google.zxing.client.result.ResultParser
    public TelParsedResult parse(Result result) {
        String massagedText = ResultParser.getMassagedText(result);
        if (!massagedText.startsWith("tel:") && !massagedText.startsWith("TEL:")) {
            return null;
        }
        String strConcat = massagedText.startsWith("TEL:") ? "tel:".concat(massagedText.substring(4)) : massagedText;
        int iIndexOf = massagedText.indexOf(63, 4);
        return new TelParsedResult(iIndexOf < 0 ? massagedText.substring(4) : massagedText.substring(4, iIndexOf), strConcat, null);
    }
}
