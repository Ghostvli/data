package org.jupnp.protocol.async;

import defpackage.j02;
import defpackage.n02;
import org.jupnp.UpnpService;
import org.jupnp.model.meta.LocalDevice;
import org.jupnp.model.types.NotificationSubtype;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SendingNotificationAlive extends SendingNotification {
    private final j02 logger;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SendingNotificationAlive(UpnpService upnpService, LocalDevice localDevice) {
        super(upnpService, localDevice);
        this.logger = n02.k(SendingNotification.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.protocol.async.SendingNotification, org.jupnp.protocol.SendingAsync
    public void execute() {
        this.logger.i("Sending alive messages ({} times) for: {}", Integer.valueOf(getBulkRepeat()), getDevice());
        super.execute();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.protocol.async.SendingNotification
    public NotificationSubtype getNotificationSubtype() {
        return NotificationSubtype.ALIVE;
    }
}
