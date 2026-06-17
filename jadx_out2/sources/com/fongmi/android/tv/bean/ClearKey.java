package com.fongmi.android.tv.bean;

import com.fongmi.android.tv.App;
import com.github.catvod.utils.Util;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ClearKey {

    @SerializedName("keys")
    private List<Keys> keys;

    @SerializedName("type")
    private String type;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Keys {

        @SerializedName("k")
        private String k;

        @SerializedName("kid")
        private String kid;

        @SerializedName("kty")
        private String kty = "oct";

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Keys(String str, String str2) {
            this.kid = str;
            this.k = str2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void addKeys(String str) {
        for (String str2 : str.split(",")) {
            String[] strArrSplit = str2.split(":");
            this.keys.add(new Keys(Util.base64(Util.hex2byte(strArrSplit[0].trim()), 11).replace("=", ""), Util.base64(Util.hex2byte(strArrSplit[1].trim()), 11).replace("=", "")));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ClearKey get(String str) {
        ClearKey clearKey = new ClearKey();
        clearKey.keys = new ArrayList();
        clearKey.type = "temporary";
        clearKey.addKeys(str);
        return clearKey;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ClearKey objectFrom(String str) throws Exception {
        ClearKey clearKey = (ClearKey) App.c().fromJson(str, ClearKey.class);
        if (clearKey.keys != null) {
            return clearKey;
        }
        throw new Exception();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return App.c().toJson(this);
    }
}
