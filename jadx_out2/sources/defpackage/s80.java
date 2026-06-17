package defpackage;

import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.Danmaku;
import com.github.catvod.utils.Json;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class s80 implements JsonDeserializer {
    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: NOT 
      (wrap:boolean:0x0000: INVOKE (r0v0 com.fongmi.android.tv.bean.Danmaku) VIRTUAL call: com.fongmi.android.tv.bean.Danmaku.isEmpty():boolean A[DONT_GENERATE, MD:():boolean (m), REMOVE, WRAPPED] (LINE:1))
     */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ boolean a(Danmaku danmaku) {
        return !danmaku.isEmpty();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: deserialize(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Ljava/lang/Object; */
    @Override // com.google.gson.JsonDeserializer
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public List deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return (List) (jsonElement.isJsonPrimitive() ? c(jsonElement.getAsString().trim(), type) : (List) App.c().fromJson(jsonElement, type)).stream().filter(new Predicate() { // from class: q80
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return s80.a((Danmaku) obj);
            }
        }).collect(Collectors.toCollection(new dx1()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final List c(String str, Type type) {
        return Json.isArray(str) ? (List) App.c().fromJson(str, type) : av4.a(new Object[]{Danmaku.from(str)});
    }
}
