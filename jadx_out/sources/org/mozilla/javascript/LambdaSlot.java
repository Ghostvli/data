package org.mozilla.javascript;

import java.util.function.Consumer;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class LambdaSlot extends Slot {
    private static final long serialVersionUID = -3046681698806493052L;
    transient Supplier<Object> getter;
    transient Consumer<Object> setter;

    public LambdaSlot(Object obj, int i) {
        super(obj, i, 0);
    }

    @Override // org.mozilla.javascript.Slot
    public LambdaSlot copySlot() {
        LambdaSlot lambdaSlot = new LambdaSlot(this);
        lambdaSlot.value = this.value;
        lambdaSlot.getter = this.getter;
        lambdaSlot.setter = this.setter;
        lambdaSlot.next = null;
        lambdaSlot.orderedNext = null;
        return lambdaSlot;
    }

    @Override // org.mozilla.javascript.Slot
    public ScriptableObject getPropertyDescriptor(Context context, Scriptable scriptable) {
        ScriptableObject scriptableObject = (ScriptableObject) context.newObject(scriptable);
        Supplier<Object> supplier = this.getter;
        if (supplier != null) {
            scriptableObject.defineProperty(ES6Iterator.VALUE_PROPERTY, supplier.get(), 0);
        } else {
            scriptableObject.defineProperty(ES6Iterator.VALUE_PROPERTY, this.value, 0);
        }
        scriptableObject.setCommonDescriptorProperties(getAttributes(), true);
        return scriptableObject;
    }

    @Override // org.mozilla.javascript.Slot
    public Object getValue(Scriptable scriptable) {
        Supplier<Object> supplier = this.getter;
        return supplier != null ? supplier.get() : super.getValue(scriptable);
    }

    @Override // org.mozilla.javascript.Slot
    public boolean isSetterSlot() {
        return false;
    }

    @Override // org.mozilla.javascript.Slot
    public boolean isValueSlot() {
        return false;
    }

    @Override // org.mozilla.javascript.Slot
    public boolean setValue(Object obj, Scriptable scriptable, Scriptable scriptable2, boolean z) {
        Consumer<Object> consumer = this.setter;
        if (consumer == null) {
            return super.setValue(obj, scriptable, scriptable2, z);
        }
        if (scriptable != scriptable2) {
            return false;
        }
        consumer.accept(obj);
        return true;
    }

    public LambdaSlot(Slot slot) {
        super(slot);
    }
}
