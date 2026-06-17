package com.github.catvod.utils;

import android.util.Base64;
import defpackage.ye1;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Auth {
    private static final Pattern DIGEST = Pattern.compile("(\\w+)=(?:\"([^\"]*)\"|([^,\\s\"]+))");

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String basic(String str) {
        if (!str.contains(":")) {
            str = str.concat(":");
        }
        return "Basic " + Base64.encodeToString(str.getBytes(StandardCharsets.UTF_8), 2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static String buildHeader(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("username=\"" + str + "\"");
        arrayList.add("realm=\"" + str2 + "\"");
        arrayList.add("nonce=\"" + str3 + "\"");
        arrayList.add("uri=\"" + str4 + "\"");
        boolean zIsEmpty = str7.isEmpty();
        if (!zIsEmpty) {
            arrayList.add("cnonce=\"" + str6 + "\"");
        }
        if (!zIsEmpty) {
            arrayList.add("nc=" + str5);
        }
        if (!zIsEmpty) {
            arrayList.add("qop=".concat(str7));
        }
        arrayList.add("response=\"" + str8 + "\"");
        if (str9 != null) {
            arrayList.add("opaque=\"" + str9 + "\"");
        }
        return "Digest " + ye1.a(", ", arrayList);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String digest(String str, String str2, Request request) {
        Map<String, String> digest = parseDigest(str2.substring(7));
        String[] strArrSplit = str.split(":", 2);
        String str3 = strArrSplit[0];
        String str4 = strArrSplit.length > 1 ? strArrSplit[1] : "";
        String orDefault = digest.getOrDefault("realm", "");
        String orDefault2 = digest.getOrDefault("nonce", "");
        String str5 = digest.get("opaque");
        String strDigestUri = digestUri(request);
        String strSelectQop = selectQop(digest.get("qop"));
        String strNewCnonce = newCnonce();
        return buildHeader(str3, orDefault, orDefault2, strDigestUri, "00000001", strNewCnonce, strSelectQop, digestResponse(Util.md5(str3 + ":" + orDefault + ":" + str4), Util.md5(request.method() + ":" + strDigestUri), orDefault2, "00000001", strNewCnonce, strSelectQop), str5);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static String digestResponse(String str, String str2, String str3, String str4, String str5, String str6) {
        String str7;
        if (str6.isEmpty()) {
            str7 = str + ":" + str3 + ":" + str2;
        } else {
            str7 = str + ":" + str3 + ":" + str4 + ":" + str5 + ":" + str6 + ":" + str2;
        }
        return Util.md5(str7);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static String digestUri(Request request) {
        String strEncodedQuery = request.url().encodedQuery();
        String strEncodedPath = request.url().encodedPath();
        if (strEncodedQuery == null) {
            return strEncodedPath;
        }
        return strEncodedPath + "?" + strEncodedQuery;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static String newCnonce() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Map<String, String> parseDigest(String str) {
        HashMap map = new HashMap();
        Matcher matcher = DIGEST.matcher(str.trim());
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            String strGroup2 = matcher.group(matcher.group(2) == null ? 3 : 2);
            if (strGroup2 != null) {
                map.put(strGroup, strGroup2.trim());
            }
        }
        return map;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static String selectQop(String str) {
        if (str != null && !str.isEmpty()) {
            for (String str2 : str.split(",")) {
                if ("auth".equalsIgnoreCase(str2.trim())) {
                    return "auth";
                }
            }
        }
        return "";
    }
}
