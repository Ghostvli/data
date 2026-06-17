package com.chaquo.python.internal;

import defpackage.f02;
import defpackage.ib3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Common {
    public static final String ABI_COMMON = "common";
    public static final String ASSET_APP = "app";
    public static final String ASSET_BOOTSTRAP = "bootstrap";
    public static final String ASSET_BOOTSTRAP_NATIVE = "bootstrap-native";
    public static final String ASSET_BUILD_JSON = "build.json";
    public static final String ASSET_CACERT = "cacert.pem";
    public static final String ASSET_DIR = "chaquopy";
    public static final String ASSET_REQUIREMENTS = "requirements";
    public static final String ASSET_STDLIB = "stdlib";
    public static final int COMPILE_SDK_VERSION = 36;
    public static final String DEFAULT_PYTHON_VERSION = "3.10";
    public static final String MIN_AGP_VERSION = "7.3.0";
    public static final int MIN_SDK_VERSION = 24;
    public static final Map<String, String> PYTHON_VERSIONS;
    public static List<String> PYTHON_VERSIONS_SHORT;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        PYTHON_VERSIONS = linkedHashMap;
        linkedHashMap.put("3.10.19", "0");
        linkedHashMap.put("3.11.14", "0");
        linkedHashMap.put("3.12.12", "0");
        linkedHashMap.put("3.13.9", "0");
        linkedHashMap.put("3.14.0", "0");
        PYTHON_VERSIONS_SHORT = new ArrayList();
        for (String str : linkedHashMap.keySet()) {
            PYTHON_VERSIONS_SHORT.add(str.substring(0, str.lastIndexOf(46)));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String assetZip(String str, String str2) {
        if (str2 == null) {
            return str + ".imy";
        }
        return str + "-" + str2 + ".imy";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String osName() {
        String property = System.getProperty("os.name");
        String[] strArr = {"linux", "mac", "windows"};
        for (int i = 0; i < 3; i++) {
            String str = strArr[i];
            if (property.toLowerCase(Locale.ENGLISH).startsWith(str)) {
                return str;
            }
        }
        ib3.a("unknown os.name: ", property);
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List<String> supportedAbis(String str) {
        if (!PYTHON_VERSIONS_SHORT.contains(str)) {
            f02.a("Unknown Python version: '", str, "'");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("arm64-v8a");
        arrayList.add("x86_64");
        if (Arrays.asList("3.8", "3.9", DEFAULT_PYTHON_VERSION, "3.11").contains(str)) {
            arrayList.add("armeabi-v7a");
            arrayList.add("x86");
        }
        arrayList.sort(null);
        return arrayList;
    }

    public static String assetZip(String str) {
        return assetZip(str, null);
    }
}
