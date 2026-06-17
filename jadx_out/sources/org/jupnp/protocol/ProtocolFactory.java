package org.jupnp.protocol;

import java.net.URL;
import org.jupnp.UpnpService;
import org.jupnp.model.action.ActionInvocation;
import org.jupnp.model.gena.LocalGENASubscription;
import org.jupnp.model.gena.RemoteGENASubscription;
import org.jupnp.model.message.IncomingDatagramMessage;
import org.jupnp.model.message.StreamRequestMessage;
import org.jupnp.model.message.header.UpnpHeader;
import org.jupnp.model.meta.LocalDevice;
import org.jupnp.protocol.async.SendingNotificationAlive;
import org.jupnp.protocol.async.SendingNotificationByebye;
import org.jupnp.protocol.async.SendingSearch;
import org.jupnp.protocol.sync.SendingAction;
import org.jupnp.protocol.sync.SendingEvent;
import org.jupnp.protocol.sync.SendingRenewal;
import org.jupnp.protocol.sync.SendingSubscribe;
import org.jupnp.protocol.sync.SendingUnsubscribe;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface ProtocolFactory {
    ReceivingAsync createReceivingAsync(IncomingDatagramMessage incomingDatagramMessage);

    ReceivingSync createReceivingSync(StreamRequestMessage streamRequestMessage);

    SendingAction createSendingAction(ActionInvocation actionInvocation, URL url);

    SendingEvent createSendingEvent(LocalGENASubscription localGENASubscription);

    SendingNotificationAlive createSendingNotificationAlive(LocalDevice localDevice);

    SendingNotificationByebye createSendingNotificationByebye(LocalDevice localDevice);

    SendingRenewal createSendingRenewal(RemoteGENASubscription remoteGENASubscription);

    SendingSearch createSendingSearch(UpnpHeader upnpHeader, int i);

    SendingSubscribe createSendingSubscribe(RemoteGENASubscription remoteGENASubscription);

    SendingUnsubscribe createSendingUnsubscribe(RemoteGENASubscription remoteGENASubscription);

    UpnpService getUpnpService();
}
