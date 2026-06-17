package org.jupnp.model.types;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class PragmaType {
    private boolean quote;
    private String token;
    private String value;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PragmaType(String str, String str2, boolean z) {
        this.token = str;
        this.value = str2;
        this.quote = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static PragmaType valueOf(String str) {
        String strSubstring;
        String str2;
        if (str.isEmpty()) {
            throw new InvalidValueException("Can't parse Bytes Range: ".concat(str));
        }
        String[] strArrSplit = str.split("=");
        boolean z = false;
        if (strArrSplit.length > 1) {
            str2 = strArrSplit[0];
            strSubstring = strArrSplit[1];
            if (strSubstring.startsWith("\"") && strSubstring.endsWith("\"")) {
                strSubstring = strSubstring.substring(1, strSubstring.length() - 1);
                z = true;
            }
        } else {
            strSubstring = str;
            str2 = null;
        }
        return new PragmaType(str2, strSubstring, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getString() {
        String str = this.token;
        String str2 = "";
        if (str != null) {
            str2 = "" + str + "=";
        }
        boolean z = this.quote;
        String str3 = this.value;
        if (z) {
            str3 = "\"" + str3 + "\"";
        }
        return str2 + str3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getToken() {
        return this.token;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getValue() {
        return this.value;
    }

    public PragmaType(String str, String str2) {
        this.token = str;
        this.value = str2;
    }

    public PragmaType(String str) {
        this.token = null;
        this.value = str;
    }
}
