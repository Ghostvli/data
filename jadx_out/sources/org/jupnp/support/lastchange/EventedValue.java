package org.jupnp.support.lastchange;

import defpackage.wg1;
import java.util.Map;
import org.jupnp.model.types.Datatype;
import org.jupnp.model.types.InvalidValueException;
import org.jupnp.support.shared.AbstractMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class EventedValue<V> {
    protected final V value;

    public EventedValue(Map.Entry<String, String>[] entryArr) {
        try {
            this.value = valueOf(entryArr);
        } catch (InvalidValueException e) {
            wg1.a(e);
            throw null;
        }
    }

    public Map.Entry<String, String>[] getAttributes() {
        return new Map.Entry[]{new AbstractMap.SimpleEntry("val", toString())};
    }

    public abstract Datatype getDatatype();

    public String getName() {
        return getClass().getSimpleName();
    }

    public V getValue() {
        return this.value;
    }

    public String toString() {
        return getDatatype().getString(getValue());
    }

    public V valueOf(Map.Entry<String, String>[] entryArr) {
        V vValueOf = null;
        for (Map.Entry<String, String> entry : entryArr) {
            if (entry.getKey().equals("val")) {
                vValueOf = valueOf(entry.getValue());
            }
        }
        return vValueOf;
    }

    public EventedValue(V v) {
        this.value = v;
    }

    public V valueOf(String str) {
        return (V) getDatatype().valueOf(str);
    }
}
