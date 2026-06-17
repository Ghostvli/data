package org.jupnp.support.model.container;

import org.jupnp.support.model.DIDLObject;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class StorageFolder extends Container {
    public static final DIDLObject.Class CLASS = new DIDLObject.Class("object.container.storageFolder");

    public StorageFolder(String str, String str2, String str3, String str4, Integer num, Long l) {
        super(str, str2, str3, str4, CLASS, num);
        if (l != null) {
            setStorageUsed(l);
        }
    }

    public Long getStorageUsed() {
        return (Long) getFirstPropertyValue(DIDLObject.Property.UPNP.STORAGE_USED.class);
    }

    public StorageFolder setStorageUsed(Long l) {
        replaceFirstProperty(new DIDLObject.Property.UPNP.STORAGE_USED(l));
        return this;
    }

    public StorageFolder(Container container) {
        super(container);
    }

    public StorageFolder(String str, Container container, String str2, String str3, Integer num, Long l) {
        this(str, container.getId(), str2, str3, num, l);
    }

    public StorageFolder() {
        setClazz(CLASS);
    }
}
