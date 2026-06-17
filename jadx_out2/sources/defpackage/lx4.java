package defpackage;

import com.fongmi.android.tv.bean.Url;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class lx4 implements JsonDeserializer {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Url a(JsonArray jsonArray) {
        Url urlCreate = Url.create();
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i2 >= jsonArray.size()) {
                return urlCreate;
            }
            urlCreate.add(jsonArray.get(i).getAsString(), jsonArray.get(i2).getAsString());
            i += 2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: deserialize(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Ljava/lang/Object; */
    @Override // com.google.gson.JsonDeserializer
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Url deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return jsonElement.isJsonArray() ? a(jsonElement.getAsJsonArray()) : jsonElement.isJsonObject() ? Url.objectFrom(jsonElement) : Url.create().add(jsonElement.getAsString());
    }
}
