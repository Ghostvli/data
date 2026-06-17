package org.jupnp.registry;

import org.jupnp.model.ExpirationDetails;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class RegistryItem<K, I> {
    private ExpirationDetails expirationDetails;
    private I item;
    private K key;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public RegistryItem(K k, I i, int i2) {
        this.expirationDetails = new ExpirationDetails();
        this.key = k;
        this.item = i;
        this.expirationDetails = new ExpirationDetails(i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.key.equals(((RegistryItem) obj).key);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ExpirationDetails getExpirationDetails() {
        return this.expirationDetails;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public I getItem() {
        return this.item;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public K getKey() {
        return this.key;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return this.key.hashCode();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "(" + getClass().getSimpleName() + ") " + String.valueOf(getExpirationDetails()) + " KEY: " + String.valueOf(getKey()) + " ITEM: " + String.valueOf(getItem());
    }

    public RegistryItem(K k) {
        this.expirationDetails = new ExpirationDetails();
        this.key = k;
    }
}
