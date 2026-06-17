package org.mozilla.javascript;

import defpackage.bo;
import java.util.Iterator;
import java.util.Objects;
import org.mozilla.javascript.SlotMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class EmbeddedSlotMap implements SlotMap {
    private static final int INITIAL_SLOT_SIZE = 4;
    private int count;
    private Slot firstAdded;
    private Slot lastAdded;
    private Slot[] slots;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Iter implements Iterator<Slot> {
        private Slot next;

        public Iter(Slot slot) {
            this.next = slot;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        @Override // java.util.Iterator
        public Slot next() {
            Slot slot = this.next;
            if (slot != null) {
                this.next = slot.orderedNext;
                return slot;
            }
            bo.a();
            return null;
        }
    }

    private static void addKnownAbsentSlot(Slot[] slotArr, Slot slot) {
        int slotIndex = getSlotIndex(slotArr.length, slot.indexOrHash);
        slot.next = slotArr[slotIndex];
        slotArr[slotIndex] = slot;
    }

    private static void copyTable(Slot[] slotArr, Slot[] slotArr2) {
        for (Slot slot : slotArr) {
            while (slot != null) {
                Slot slot2 = slot.next;
                addKnownAbsentSlot(slotArr2, slot);
                slot = slot2;
            }
        }
    }

    private void createNewSlot(Slot slot) {
        int i = this.count;
        if (i == 0) {
            this.slots = new Slot[4];
        }
        int i2 = (i + 1) * 4;
        Slot[] slotArr = this.slots;
        if (i2 > slotArr.length * 3) {
            Slot[] slotArr2 = new Slot[slotArr.length * 2];
            copyTable(slotArr, slotArr2);
            this.slots = slotArr2;
        }
        insertNewSlot(slot);
    }

    private static int getSlotIndex(int i, int i2) {
        return (i - 1) & i2;
    }

    private void insertNewSlot(Slot slot) {
        this.count++;
        Slot slot2 = this.lastAdded;
        if (slot2 != null) {
            slot2.orderedNext = slot;
        }
        if (this.firstAdded == null) {
            this.firstAdded = slot;
        }
        this.lastAdded = slot;
        addKnownAbsentSlot(this.slots, slot);
    }

    private void removeSlot(Slot slot, Slot slot2, int i, Object obj) {
        this.count--;
        if (slot2 == slot) {
            this.slots[i] = slot.next;
        } else {
            slot2.next = slot.next;
        }
        Slot slot3 = this.firstAdded;
        if (slot == slot3) {
            this.firstAdded = slot.orderedNext;
            slot3 = null;
        } else {
            while (true) {
                Slot slot4 = slot3.orderedNext;
                if (slot4 == slot) {
                    break;
                } else {
                    slot3 = slot4;
                }
            }
            slot3.orderedNext = slot.orderedNext;
        }
        if (slot == this.lastAdded) {
            this.lastAdded = slot3;
        }
    }

    @Override // org.mozilla.javascript.SlotMap
    public void add(Slot slot) {
        if (this.slots == null) {
            this.slots = new Slot[4];
        }
        insertNewSlot(slot);
    }

    @Override // org.mozilla.javascript.SlotMap
    public <S extends Slot> S compute(Object obj, int i, SlotMap.SlotComputer<S> slotComputer) {
        int iHashCode = obj != null ? obj.hashCode() : i;
        Slot[] slotArr = this.slots;
        if (slotArr != null) {
            int slotIndex = getSlotIndex(slotArr.length, iHashCode);
            Slot slot = this.slots[slotIndex];
            Slot slot2 = slot;
            while (slot != null && (iHashCode != slot.indexOrHash || !Objects.equals(slot.name, obj))) {
                slot2 = slot;
                slot = slot.next;
            }
            if (slot != null) {
                S s = (S) slotComputer.compute(obj, i, slot);
                if (s == null) {
                    removeSlot(slot, slot2, slotIndex, obj);
                    return s;
                }
                if (!slot.equals(s)) {
                    if (slot2 == slot) {
                        this.slots[slotIndex] = s;
                    } else {
                        slot2.next = s;
                    }
                    s.next = slot.next;
                    Slot slot3 = this.firstAdded;
                    if (slot == slot3) {
                        this.firstAdded = s;
                    } else {
                        while (slot3 != null) {
                            Slot slot4 = slot3.orderedNext;
                            if (slot4 == slot) {
                                break;
                            }
                            slot3 = slot4;
                        }
                        if (slot3 != null) {
                            slot3.orderedNext = s;
                        }
                    }
                    s.orderedNext = slot.orderedNext;
                    if (slot == this.lastAdded) {
                        this.lastAdded = s;
                    }
                }
                return s;
            }
        }
        S s2 = (S) slotComputer.compute(obj, i, null);
        if (s2 != null) {
            createNewSlot(s2);
        }
        return s2;
    }

    @Override // org.mozilla.javascript.SlotMap
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override // java.lang.Iterable
    public Iterator<Slot> iterator() {
        return new Iter(this.firstAdded);
    }

    @Override // org.mozilla.javascript.SlotMap
    public Slot modify(Object obj, int i, int i2) {
        int iHashCode = obj != null ? obj.hashCode() : i;
        Slot[] slotArr = this.slots;
        if (slotArr != null) {
            Slot slot = this.slots[getSlotIndex(slotArr.length, iHashCode)];
            while (slot != null && (iHashCode != slot.indexOrHash || !Objects.equals(slot.name, obj))) {
                slot = slot.next;
            }
            if (slot != null) {
                return slot;
            }
        }
        Slot slot2 = new Slot(obj, i, i2);
        createNewSlot(slot2);
        return slot2;
    }

    @Override // org.mozilla.javascript.SlotMap
    public Slot query(Object obj, int i) {
        if (this.slots == null) {
            return null;
        }
        if (obj != null) {
            i = obj.hashCode();
        }
        for (Slot slot = this.slots[getSlotIndex(this.slots.length, i)]; slot != null; slot = slot.next) {
            if (i == slot.indexOrHash && Objects.equals(slot.name, obj)) {
                return slot;
            }
        }
        return null;
    }

    @Override // org.mozilla.javascript.SlotMap
    public int size() {
        return this.count;
    }
}
