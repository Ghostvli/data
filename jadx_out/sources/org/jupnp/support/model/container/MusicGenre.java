package org.jupnp.support.model.container;

import org.jupnp.support.model.DIDLObject;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class MusicGenre extends GenreContainer {
    public static final DIDLObject.Class CLASS = new DIDLObject.Class("object.container.genre.musicGenre");

    public MusicGenre() {
        setClazz(CLASS);
    }

    public MusicGenre(Container container) {
        super(container);
    }

    public MusicGenre(String str, Container container, String str2, String str3, Integer num) {
        this(str, container.getId(), str2, str3, num);
    }

    public MusicGenre(String str, String str2, String str3, String str4, Integer num) {
        super(str, str2, str3, str4, num);
        setClazz(CLASS);
    }
}
