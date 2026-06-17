package com.xunlei.downloadlib.parameter;

import android.util.Base64;
import com.xunlei.downloadlib.android.XLUtil;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class InitParam {
    public String mAppKey = "xzNjAwMQ^^yb==0^852^083dbcff^cee25055f125a2fde";
    public String mAppVersion = "21.01.07.800002";
    public int mPermissionLevel = 1;
    public int mQueryConfOnInit = 0;
    public String mStatCfgSavePath;
    public String mStatSavePath;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public InitParam(String str) {
        this.mStatSavePath = str;
        this.mStatCfgSavePath = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getSoKey() {
        String strReplace = this.mAppKey.split("==")[0].replace('^', '=');
        return XLUtil.generateAppKey("com.android.providers.downloads", Short.parseShort(new String(Base64.decode(strReplace.substring(2, strReplace.length() - 2), 0), StandardCharsets.UTF_8).split(";")[0]), (byte) 1);
    }
}
