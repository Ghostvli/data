package com.github.catvod.utils;

import android.text.TextUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Json {
    public static boolean isArray(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            new JSONArray(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isEmpty(JsonObject jsonObject, String str) {
        if (!jsonObject.has(str)) {
            return true;
        }
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement.isJsonNull()) {
            return true;
        }
        if (jsonElement.isJsonArray()) {
            return jsonElement.getAsJsonArray().isEmpty();
        }
        if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isString()) {
            return jsonElement.getAsString().trim().isEmpty();
        }
        return true;
    }

    public static boolean isObj(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            new JSONObject(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static JsonElement parse(String str) {
        try {
            return JsonParser.parseString(str);
        } catch (Throwable unused) {
            return new JsonObject();
        }
    }

    public static List<JsonElement> safeListElement(JsonObject jsonObject, String str) {
        ArrayList arrayList = new ArrayList();
        if (jsonObject.has(str)) {
            if (jsonObject.get(str).isJsonObject()) {
                arrayList.add(jsonObject.get(str).getAsJsonObject());
                return arrayList;
            }
            Iterator<JsonElement> it = jsonObject.getAsJsonArray(str).iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getAsJsonObject());
            }
        }
        return arrayList;
    }

    public static List<String> safeListString(JsonObject jsonObject, String str) {
        ArrayList arrayList = new ArrayList();
        if (jsonObject.has(str)) {
            if (jsonObject.get(str).isJsonObject()) {
                arrayList.add(safeString(jsonObject, str));
                return arrayList;
            }
            Iterator<JsonElement> it = jsonObject.getAsJsonArray(str).iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getAsString());
            }
        }
        return arrayList;
    }

    public static JsonObject safeObject(JsonElement jsonElement) {
        try {
            if (jsonElement.isJsonPrimitive()) {
                jsonElement = parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
            return jsonElement.getAsJsonObject();
        } catch (Exception unused) {
            return new JsonObject();
        }
    }

    public static String safeString(JsonObject jsonObject, String str) {
        try {
            return jsonObject.getAsJsonPrimitive(str).getAsString().trim();
        } catch (Exception unused) {
            return "";
        }
    }

    public static Map<String, String> toMap(JsonElement jsonElement) {
        HashMap map = new HashMap();
        JsonObject jsonObjectSafeObject = safeObject(jsonElement);
        for (Map.Entry<String, JsonElement> entry : jsonObjectSafeObject.entrySet()) {
            map.put(entry.getKey(), safeString(jsonObjectSafeObject, entry.getKey()));
        }
        return map;
    }

    public static Map<String, String> toMap(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return toMap(parse(str));
    }
}
