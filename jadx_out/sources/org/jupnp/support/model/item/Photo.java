package org.jupnp.support.model.item;

import org.jupnp.support.model.DIDLObject;
import org.jupnp.support.model.Res;
import org.jupnp.support.model.container.Container;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Photo extends ImageItem {
    public static final DIDLObject.Class CLASS = new DIDLObject.Class("object.item.imageItem.photo");

    public Photo(String str, String str2, String str3, String str4, String str5, Res... resArr) {
        super(str, str2, str3, str4, resArr);
        setClazz(CLASS);
        if (str5 != null) {
            setAlbum(str5);
        }
    }

    public String getAlbum() {
        return (String) getFirstPropertyValue(DIDLObject.Property.UPNP.ALBUM.class);
    }

    public Photo setAlbum(String str) {
        replaceFirstProperty(new DIDLObject.Property.UPNP.ALBUM(str));
        return this;
    }

    public Photo(Item item) {
        super(item);
    }

    public Photo(String str, Container container, String str2, String str3, String str4, Res... resArr) {
        this(str, container.getId(), str2, str3, str4, resArr);
    }

    public Photo() {
        setClazz(CLASS);
    }
}
