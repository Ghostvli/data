package com.fongmi.quickjs.method;

import android.text.TextUtils;
import com.github.catvod.utils.Prefers;
import com.whl.quickjs.wrapper.JSMethod;
import defpackage.yp1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Local {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String getKey(String str, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder("cache_");
        if (TextUtils.isEmpty(str)) {
            str3 = "";
        } else {
            str3 = str + "_";
        }
        sb.append(str3);
        sb.append(str2);
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @JSMethod
    @yp1
    public void delete(String str, String str2) {
        Prefers.remove(getKey(str, str2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @JSMethod
    @yp1
    public String get(String str, String str2) {
        return Prefers.getString(getKey(str, str2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @JSMethod
    @yp1
    public void set(String str, String str2, String str3) {
        Prefers.put(getKey(str, str2), str3);
    }
}
