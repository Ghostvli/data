package defpackage;

import com.fongmi.android.tv.bean.Filter;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class f11 implements JsonDeserializer {
    @Override // com.google.gson.JsonDeserializer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LinkedHashMap deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        if (asJsonObject != null) {
            for (Map.Entry<String, JsonElement> entry : asJsonObject.entrySet()) {
                ArrayList arrayList = new ArrayList();
                JsonElement jsonElement2 = asJsonObject.get(entry.getKey());
                if (jsonElement2.isJsonObject()) {
                    arrayList.add(Filter.objectFrom(jsonElement2).check().trans());
                } else {
                    Iterator<JsonElement> it = jsonElement2.getAsJsonArray().iterator();
                    while (it.hasNext()) {
                        arrayList.add(Filter.objectFrom(it.next()).check().trans());
                    }
                }
                linkedHashMap.put(entry.getKey(), arrayList);
            }
        }
        return linkedHashMap;
    }
}
