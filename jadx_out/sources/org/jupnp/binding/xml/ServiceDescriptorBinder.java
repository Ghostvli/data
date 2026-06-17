package org.jupnp.binding.xml;

import org.jupnp.model.meta.Service;
import org.w3c.dom.Document;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface ServiceDescriptorBinder {
    Document buildDOM(Service service);

    <T extends Service> T describe(T t, String str);

    <T extends Service> T describe(T t, Document document);

    String generate(Service service);
}
