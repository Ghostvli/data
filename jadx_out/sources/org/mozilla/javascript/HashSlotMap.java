package org.mozilla.javascript;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.function.BiFunction;
import org.mozilla.javascript.HashSlotMap;
import org.mozilla.javascript.Slot;
import org.mozilla.javascript.SlotMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class HashSlotMap implements SlotMap {
    private final LinkedHashMap<Object, Slot> map;

    public HashSlotMap(SlotMap slotMap) {
        this.map = new LinkedHashMap<>(slotMap.size());
        Iterator<Slot> it = slotMap.iterator();
        while (it.hasNext()) {
            add(it.next().copySlot());
        }
    }

    public static /* synthetic */ Slot b(Object obj, int i, int i2, Object obj2) {
        return new Slot(obj, i, i2);
    }

    private Object makeKey(Slot slot) {
        Object obj = slot.name;
        return obj == null ? String.valueOf(slot.indexOrHash) : obj;
    }

    @Override // org.mozilla.javascript.SlotMap
    public void add(Slot slot) {
        this.map.put(makeKey(slot), slot);
    }

    @Override // org.mozilla.javascript.SlotMap
    public <S extends Slot> S compute(final Object obj, final int i, final SlotMap.SlotComputer<S> slotComputer) {
        return (S) this.map.compute(makeKey(obj, i), new BiFunction() { // from class: sc1
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj2, Object obj3) {
                return slotComputer.compute(obj, i, (Slot) obj3);
            }
        });
    }

    @Override // org.mozilla.javascript.SlotMap
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<Slot> iterator() {
        return this.map.values().iterator();
    }

    @Override // org.mozilla.javascript.SlotMap
    public Slot modify(final Object obj, final int i, final int i2) {
        return this.map.computeIfAbsent(makeKey(obj, i), new java.util.function.Function() { // from class: tc1
            @Override // java.util.function.Function
            public final Object apply(Object obj2) {
                return HashSlotMap.b(obj, i, i2, obj2);
            }
        });
    }

    @Override // org.mozilla.javascript.SlotMap
    public Slot query(Object obj, int i) {
        return this.map.get(makeKey(obj, i));
    }

    @Override // org.mozilla.javascript.SlotMap
    public int size() {
        return this.map.size();
    }

    private Object makeKey(Object obj, int i) {
        return obj == null ? String.valueOf(i) : obj;
    }

    public HashSlotMap() {
        this.map = new LinkedHashMap<>();
    }
}
