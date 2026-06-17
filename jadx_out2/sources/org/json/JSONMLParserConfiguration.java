package org.json;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class JSONMLParserConfiguration extends ParserConfiguration {
    public static final int DEFAULT_MAXIMUM_NESTING_DEPTH = 512;
    public static final JSONMLParserConfiguration ORIGINAL = new JSONMLParserConfiguration();
    public static final JSONMLParserConfiguration KEEP_STRINGS = new JSONMLParserConfiguration().withKeepStrings(true);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public JSONMLParserConfiguration() {
        this.maxNestingDepth = 512;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: clone()Ljava/lang/Object; */
    /* JADX DEBUG: Method merged with bridge method: clone()Lorg/json/ParserConfiguration; */
    @Override // org.json.ParserConfiguration
    public JSONMLParserConfiguration clone() {
        return new JSONMLParserConfiguration(this.keepStrings, this.maxNestingDepth);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: withKeepStrings(Z)Lorg/json/ParserConfiguration; */
    @Override // org.json.ParserConfiguration
    public JSONMLParserConfiguration withKeepStrings(boolean z) {
        return (JSONMLParserConfiguration) super.withKeepStrings(z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: withMaxNestingDepth(I)Lorg/json/ParserConfiguration; */
    @Override // org.json.ParserConfiguration
    public JSONMLParserConfiguration withMaxNestingDepth(int i) {
        return (JSONMLParserConfiguration) super.withMaxNestingDepth(i);
    }

    public JSONMLParserConfiguration(boolean z, int i) {
        super(z, i);
    }
}
