package org.jupnp.internal.compat.java.beans;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class PropertyChangeEvent {
    private final Object newValue;
    private final Object oldValue;
    private final String propertyName;
    private final Object source;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PropertyChangeEvent(Object obj, String str, Object obj2, Object obj3) {
        this.source = obj;
        this.propertyName = str;
        this.oldValue = obj2;
        this.newValue = obj3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object getNewValue() {
        return this.newValue;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object getOldValue() {
        return this.oldValue;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getPropertyName() {
        return this.propertyName;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object getSource() {
        return this.source;
    }
}
