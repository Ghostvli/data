package org.jupnp.support.model.item;

import java.util.ArrayList;
import java.util.List;
import org.jupnp.support.model.DIDLObject;
import org.jupnp.support.model.DescMeta;
import org.jupnp.support.model.Res;
import org.jupnp.support.model.WriteStatus;
import org.jupnp.support.model.container.Container;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Item extends DIDLObject {
    protected String refID;

    public Item(String str, Container container, String str2, String str3, DIDLObject.Class r17, String str4) {
        this(str, container.getId(), str2, str3, false, null, r17, new ArrayList(), new ArrayList(), new ArrayList(), str4);
    }

    public String getRefID() {
        return this.refID;
    }

    public void setRefID(String str) {
        this.refID = str;
    }

    public Item(Item item) {
        super(item);
        setRefID(item.getRefID());
    }

    public Item(String str, String str2, String str3, String str4, boolean z, WriteStatus writeStatus, DIDLObject.Class r7, List<Res> list, List<DIDLObject.Property<?>> list2, List<DescMeta<?>> list3) {
        super(str, str2, str3, str4, z, writeStatus, r7, list, list2, list3);
    }

    public Item(String str, String str2, String str3, String str4, boolean z, WriteStatus writeStatus, DIDLObject.Class r7, List<Res> list, List<DIDLObject.Property<?>> list2, List<DescMeta<?>> list3, String str5) {
        super(str, str2, str3, str4, z, writeStatus, r7, list, list2, list3);
        this.refID = str5;
    }

    public Item(String str, Container container, String str2, String str3, DIDLObject.Class r16) {
        this(str, container.getId(), str2, str3, false, null, r16, new ArrayList(), new ArrayList(), new ArrayList());
    }

    public Item() {
    }

    public Item(String str, String str2, String str3, String str4, DIDLObject.Class r16) {
        this(str, str2, str3, str4, false, null, r16, new ArrayList(), new ArrayList(), new ArrayList());
    }

    public Item(String str, String str2, String str3, String str4, DIDLObject.Class r17, String str5) {
        this(str, str2, str3, str4, false, null, r17, new ArrayList(), new ArrayList(), new ArrayList(), str5);
    }
}
