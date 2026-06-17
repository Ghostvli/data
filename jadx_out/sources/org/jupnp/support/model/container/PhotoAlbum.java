package org.jupnp.support.model.container;

import java.util.ArrayList;
import java.util.List;
import org.jupnp.support.model.DIDLObject;
import org.jupnp.support.model.item.Item;
import org.jupnp.support.model.item.Photo;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class PhotoAlbum extends Album {
    public static final DIDLObject.Class CLASS = new DIDLObject.Class("object.container.album.photoAlbum");

    public PhotoAlbum(String str, Container container, String str2, String str3, Integer num) {
        this(str, container.getId(), str2, str3, num, new ArrayList());
    }

    public void addPhotos(Photo[] photoArr) {
        if (photoArr != null) {
            for (Photo photo : photoArr) {
                photo.setAlbum(getTitle());
                addItem(photo);
            }
        }
    }

    public Photo[] getPhotos() {
        ArrayList arrayList = new ArrayList();
        for (Item item : getItems()) {
            if (item instanceof Photo) {
                arrayList.add((Photo) item);
            }
        }
        return (Photo[]) arrayList.toArray(new Photo[arrayList.size()]);
    }

    public PhotoAlbum(Container container) {
        super(container);
    }

    public PhotoAlbum() {
        setClazz(CLASS);
    }

    public PhotoAlbum(String str, Container container, String str2, String str3, Integer num, List<Photo> list) {
        this(str, container.getId(), str2, str3, num, list);
    }

    public PhotoAlbum(String str, String str2, String str3, String str4, Integer num) {
        this(str, str2, str3, str4, num, new ArrayList());
    }

    public void addPhotos(List<Photo> list) {
        addPhotos((Photo[]) list.toArray(new Photo[list.size()]));
    }

    public PhotoAlbum(String str, String str2, String str3, String str4, Integer num, List<Photo> list) {
        super(str, str2, str3, str4, num);
        setClazz(CLASS);
        addPhotos(list);
    }
}
