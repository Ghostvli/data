package org.mozilla.javascript.commonjs.module.provider;

import java.io.Serializable;
import java.util.StringTokenizer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class ParsedContentType implements Serializable {
    private static final long serialVersionUID = 1;
    private final String contentType;
    private final String encoding;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ParsedContentType(String str) {
        String str2;
        String strTrim = null;
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ";");
            if (stringTokenizer.hasMoreTokens()) {
                String strTrim2 = stringTokenizer.nextToken().trim();
                while (true) {
                    if (!stringTokenizer.hasMoreTokens()) {
                        break;
                    }
                    String strTrim3 = stringTokenizer.nextToken().trim();
                    if (strTrim3.startsWith("charset=")) {
                        strTrim = strTrim3.substring(8).trim();
                        int length = strTrim.length();
                        if (length > 0) {
                            strTrim = strTrim.charAt(0) == '\"' ? strTrim.substring(1) : strTrim;
                            int i = length - 1;
                            if (strTrim.charAt(i) == '\"') {
                                strTrim = strTrim.substring(0, i);
                            }
                        }
                    }
                }
                String str3 = strTrim;
                strTrim = strTrim2;
                str2 = str3;
            } else {
                str2 = null;
            }
        }
        this.contentType = strTrim;
        this.encoding = str2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getContentType() {
        return this.contentType;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getEncoding() {
        return this.encoding;
    }
}
