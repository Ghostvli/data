package com.google.zxing.client.result;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ExpandedProductParsedResult extends ParsedResult {
    public static final String KILOGRAM = "KG";
    public static final String POUND = "LB";
    private final String bestBeforeDate;
    private final String expirationDate;
    private final String lotNumber;
    private final String packagingDate;
    private final String price;
    private final String priceCurrency;
    private final String priceIncrement;
    private final String productID;
    private final String productionDate;
    private final String rawText;
    private final String sscc;
    private final Map<String, String> uncommonAIs;
    private final String weight;
    private final String weightIncrement;
    private final String weightType;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ExpandedProductParsedResult(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Map<String, String> map) {
        super(ParsedResultType.PRODUCT);
        this.rawText = str;
        this.productID = str2;
        this.sscc = str3;
        this.lotNumber = str4;
        this.productionDate = str5;
        this.packagingDate = str6;
        this.bestBeforeDate = str7;
        this.expirationDate = str8;
        this.weight = str9;
        this.weightType = str10;
        this.weightIncrement = str11;
        this.price = str12;
        this.priceIncrement = str13;
        this.priceCurrency = str14;
        this.uncommonAIs = map;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (!(obj instanceof ExpandedProductParsedResult)) {
            return false;
        }
        ExpandedProductParsedResult expandedProductParsedResult = (ExpandedProductParsedResult) obj;
        return Objects.equals(this.productID, expandedProductParsedResult.productID) && Objects.equals(this.sscc, expandedProductParsedResult.sscc) && Objects.equals(this.lotNumber, expandedProductParsedResult.lotNumber) && Objects.equals(this.productionDate, expandedProductParsedResult.productionDate) && Objects.equals(this.bestBeforeDate, expandedProductParsedResult.bestBeforeDate) && Objects.equals(this.expirationDate, expandedProductParsedResult.expirationDate) && Objects.equals(this.weight, expandedProductParsedResult.weight) && Objects.equals(this.weightType, expandedProductParsedResult.weightType) && Objects.equals(this.weightIncrement, expandedProductParsedResult.weightIncrement) && Objects.equals(this.price, expandedProductParsedResult.price) && Objects.equals(this.priceIncrement, expandedProductParsedResult.priceIncrement) && Objects.equals(this.priceCurrency, expandedProductParsedResult.priceCurrency) && Objects.equals(this.uncommonAIs, expandedProductParsedResult.uncommonAIs);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getBestBeforeDate() {
        return this.bestBeforeDate;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        return String.valueOf(this.rawText);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getExpirationDate() {
        return this.expirationDate;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getLotNumber() {
        return this.lotNumber;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getPackagingDate() {
        return this.packagingDate;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getPrice() {
        return this.price;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getPriceCurrency() {
        return this.priceCurrency;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getPriceIncrement() {
        return this.priceIncrement;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getProductID() {
        return this.productID;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getProductionDate() {
        return this.productionDate;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getRawText() {
        return this.rawText;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getSscc() {
        return this.sscc;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Map<String, String> getUncommonAIs() {
        return this.uncommonAIs;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getWeight() {
        return this.weight;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getWeightIncrement() {
        return this.weightIncrement;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getWeightType() {
        return this.weightType;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return Objects.hashCode(this.uncommonAIs) ^ (((((((((((Objects.hashCode(this.productID) ^ Objects.hashCode(this.sscc)) ^ Objects.hashCode(this.lotNumber)) ^ Objects.hashCode(this.productionDate)) ^ Objects.hashCode(this.bestBeforeDate)) ^ Objects.hashCode(this.expirationDate)) ^ Objects.hashCode(this.weight)) ^ Objects.hashCode(this.weightType)) ^ Objects.hashCode(this.weightIncrement)) ^ Objects.hashCode(this.price)) ^ Objects.hashCode(this.priceIncrement)) ^ Objects.hashCode(this.priceCurrency));
    }
}
