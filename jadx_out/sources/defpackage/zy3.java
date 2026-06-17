package defpackage;

import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Slot;
import org.mozilla.javascript.SlotMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zy3 implements SlotMap.SlotComputer {
    @Override // org.mozilla.javascript.SlotMap.SlotComputer
    public final Slot compute(Object obj, int i, Slot slot) {
        return ScriptableObject.checkSlotRemoval(obj, i, slot);
    }
}
