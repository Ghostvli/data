package com.hierynomus.utils;

import com.hierynomus.protocol.commons.Charsets;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Strings {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean isNotBlank(String str) {
        return (str == null || str.trim().isEmpty()) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String join(List<String> list, char c) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                sb.append(c);
            }
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static byte[] nullTerminatedBytes(String str) {
        byte[] bArr = new byte[str.length() + 1];
        System.arraycopy(str.getBytes(Charsets.US_ASCII), 0, bArr, 0, str.length());
        return bArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List<String> split(String str, char c) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int iIndexOf = str.indexOf(c, i);
            if (iIndexOf == -1) {
                arrayList.add(str.substring(i));
                return arrayList;
            }
            arrayList.add(str.substring(i, iIndexOf));
            i = iIndexOf + 1;
        }
    }
}
