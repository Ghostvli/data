package defpackage;

import com.whl.quickjs.wrapper.JSArray;
import com.whl.quickjs.wrapper.JSObject;
import com.whl.quickjs.wrapper.QuickJSContext;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class pm1 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static JSArray a(QuickJSContext quickJSContext, List list) {
        JSArray jSArrayCreateNewJSArray = quickJSContext.createNewJSArray();
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                jSArrayCreateNewJSArray.set(list.get(i), i);
            }
        }
        return jSArrayCreateNewJSArray;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static JSArray b(QuickJSContext quickJSContext, byte[] bArr) {
        JSArray jSArrayCreateNewJSArray = quickJSContext.createNewJSArray();
        if (bArr != null && bArr.length != 0) {
            for (int i = 0; i < bArr.length; i++) {
                jSArrayCreateNewJSArray.set(Integer.valueOf(bArr[i]), i);
            }
        }
        return jSArrayCreateNewJSArray;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static JSObject c(QuickJSContext quickJSContext, Map map) {
        JSObject jSObjectCreateNewJSObject = quickJSContext.createNewJSObject();
        if (map != null && !map.isEmpty()) {
            for (String str : map.keySet()) {
                jSObjectCreateNewJSObject.setProperty(str, (String) map.get(str));
            }
        }
        return jSObjectCreateNewJSObject;
    }
}
