package org.jupnp.internal.compat.java.beans;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class PropertyChangeSupport {
    private CopyOnWriteArrayList<PropertyChangeListener> listeners = new CopyOnWriteArrayList<>();
    private Object source;

    public PropertyChangeSupport(Object obj) {
        this.source = obj;
    }

    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        this.listeners.add(propertyChangeListener);
    }

    public void firePropertyChange(String str, Object obj, Object obj2) {
        if (obj == null || obj2 == null || !obj.equals(obj2)) {
            PropertyChangeEvent propertyChangeEvent = new PropertyChangeEvent(this.source, str, obj, obj2);
            Iterator<PropertyChangeListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().propertyChange(propertyChangeEvent);
            }
        }
    }

    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        this.listeners.remove(propertyChangeListener);
    }
}
