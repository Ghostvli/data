package org.jupnp.support.lastchange;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import org.jupnp.model.types.UnsignedIntegerFourBytes;
import org.jupnp.support.lastchange.EventedValue;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Event {
    protected List<InstanceID> instanceIDs;

    public Event() {
        this.instanceIDs = new ArrayList();
    }

    public void clear() {
        this.instanceIDs = new ArrayList();
    }

    public <EV extends EventedValue<?>> EV getEventedValue(UnsignedIntegerFourBytes unsignedIntegerFourBytes, Class<EV> cls) {
        for (InstanceID instanceID : getInstanceIDs()) {
            if (instanceID.getId().equals(unsignedIntegerFourBytes)) {
                Iterator<EventedValue<?>> it = instanceID.getValues().iterator();
                while (it.hasNext()) {
                    EV ev = (EV) it.next();
                    if (ev.getClass().equals(cls)) {
                        return ev;
                    }
                }
            }
        }
        return null;
    }

    public InstanceID getInstanceID(UnsignedIntegerFourBytes unsignedIntegerFourBytes) {
        for (InstanceID instanceID : this.instanceIDs) {
            if (instanceID.getId().equals(unsignedIntegerFourBytes)) {
                return instanceID;
            }
        }
        return null;
    }

    public List<InstanceID> getInstanceIDs() {
        return this.instanceIDs;
    }

    public boolean hasChanges() {
        Iterator<InstanceID> it = this.instanceIDs.iterator();
        while (it.hasNext()) {
            if (!it.next().getValues().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public void setEventedValue(UnsignedIntegerFourBytes unsignedIntegerFourBytes, final EventedValue<?> eventedValue) {
        InstanceID instanceID = null;
        for (InstanceID instanceID2 : getInstanceIDs()) {
            if (instanceID2.getId().equals(unsignedIntegerFourBytes)) {
                instanceID = instanceID2;
            }
        }
        if (instanceID == null) {
            instanceID = new InstanceID(unsignedIntegerFourBytes);
            getInstanceIDs().add(instanceID);
        }
        instanceID.getValues().removeIf(new Predicate() { // from class: tu0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((EventedValue) obj).getClass().equals(eventedValue.getClass());
            }
        });
        instanceID.getValues().add(eventedValue);
    }

    public Event(List<InstanceID> list) {
        new ArrayList();
        this.instanceIDs = list;
    }
}
