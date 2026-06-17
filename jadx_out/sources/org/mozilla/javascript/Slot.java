package org.mozilla.javascript;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Slot implements Serializable {
    private static final long serialVersionUID = -6090581677123995491L;
    private short attributes;
    int indexOrHash;
    Object name;
    transient Slot next;
    transient Slot orderedNext;
    Object value;

    public Slot(Slot slot) {
        this.name = slot.name;
        this.indexOrHash = slot.indexOrHash;
        this.attributes = slot.attributes;
        this.value = slot.value;
        this.next = slot.next;
        this.orderedNext = slot.orderedNext;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        Object obj = this.name;
        if (obj != null) {
            this.indexOrHash = obj.hashCode();
        }
    }

    public Slot copySlot() {
        Slot slot = new Slot(this);
        slot.next = null;
        slot.orderedNext = null;
        return slot;
    }

    public int getAttributes() {
        return this.attributes;
    }

    public Function getGetterFunction(String str, Scriptable scriptable) {
        return null;
    }

    public ScriptableObject getPropertyDescriptor(Context context, Scriptable scriptable) {
        return ScriptableObject.buildDataDescriptor(scriptable, this.value, this.attributes);
    }

    public Function getSetterFunction(String str, Scriptable scriptable) {
        return null;
    }

    public Object getValue(Scriptable scriptable) {
        return this.value;
    }

    public boolean isSameGetterFunction(Object obj) {
        return false;
    }

    public boolean isSameSetterFunction(Object obj) {
        return false;
    }

    public boolean isSetterSlot() {
        return false;
    }

    public boolean isValueSlot() {
        return true;
    }

    public void setAttributes(int i) {
        ScriptableObject.checkValidAttributes(i);
        this.attributes = (short) i;
    }

    public boolean setValue(Object obj, Scriptable scriptable, Scriptable scriptable2, boolean z) {
        if ((this.attributes & 1) != 0) {
            if (z) {
                throw ScriptRuntime.typeErrorById("msg.modify.readonly", this.name);
            }
            return true;
        }
        if (scriptable != scriptable2) {
            return false;
        }
        this.value = obj;
        return true;
    }

    public void throwNoSetterException(Scriptable scriptable, Object obj) {
        String str;
        Context context = Context.getContext();
        if (context.isStrictMode() || context.hasFeature(11)) {
            if (this.name != null) {
                str = "[" + scriptable.getClassName() + "]." + String.valueOf(this.name);
            } else {
                str = "";
            }
            throw ScriptRuntime.typeErrorById("msg.set.prop.no.setter", str, Context.toString(obj));
        }
    }

    public Slot(Object obj, int i, int i2) {
        this.name = obj;
        this.indexOrHash = obj != null ? obj.hashCode() : i;
        this.attributes = (short) i2;
    }

    public final boolean setValue(Object obj, Scriptable scriptable, Scriptable scriptable2) {
        return setValue(obj, scriptable, scriptable2, Context.isCurrentContextStrict());
    }
}
