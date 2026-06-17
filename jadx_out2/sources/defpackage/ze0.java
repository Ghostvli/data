package defpackage;

import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ze0 implements jb0 {
    public Collection a;
    public Map b;
    public String c;
    public int d;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ze0(Collection collection, Map map, String str, int i) {
        this.a = collection;
        this.b = map;
        this.c = str;
        this.d = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jb0
    public eb0 a(Map map) {
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        enumMap.putAll(map);
        Map map2 = this.b;
        if (map2 != null) {
            enumMap.putAll(map2);
        }
        Collection collection = this.a;
        if (collection != null) {
            enumMap.put(DecodeHintType.POSSIBLE_FORMATS, collection);
        }
        String str = this.c;
        if (str != null) {
            enumMap.put(DecodeHintType.CHARACTER_SET, str);
        }
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        multiFormatReader.setHints(enumMap);
        int i = this.d;
        return i != 0 ? i != 1 ? i != 2 ? new eb0(multiFormatReader) : new rt2(multiFormatReader) : new ul1(multiFormatReader) : new eb0(multiFormatReader);
    }

    public ze0(Collection collection) {
        this.a = collection;
    }

    public ze0() {
    }
}
