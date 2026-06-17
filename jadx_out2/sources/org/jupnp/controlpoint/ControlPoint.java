package org.jupnp.controlpoint;

import java.util.concurrent.Future;
import org.jupnp.UpnpServiceConfiguration;
import org.jupnp.model.message.header.UpnpHeader;
import org.jupnp.protocol.ProtocolFactory;
import org.jupnp.registry.Registry;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface ControlPoint {
    Future execute(ActionCallback actionCallback);

    void execute(SubscriptionCallback subscriptionCallback);

    UpnpServiceConfiguration getConfiguration();

    ProtocolFactory getProtocolFactory();

    Registry getRegistry();

    void search();

    void search(int i);

    void search(UpnpHeader upnpHeader);

    void search(UpnpHeader upnpHeader, int i);
}
