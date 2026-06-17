package org.jupnp.protocol.async;

import defpackage.j02;
import defpackage.n02;
import java.util.Iterator;
import org.jupnp.UpnpService;
import org.jupnp.model.ValidationError;
import org.jupnp.model.ValidationException;
import org.jupnp.model.message.IncomingDatagramMessage;
import org.jupnp.model.message.UpnpRequest;
import org.jupnp.model.message.discovery.IncomingNotificationRequest;
import org.jupnp.model.meta.RemoteDevice;
import org.jupnp.model.meta.RemoteDeviceIdentity;
import org.jupnp.model.types.UDN;
import org.jupnp.protocol.ReceivingAsync;
import org.jupnp.protocol.RetrieveRemoteDescriptors;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ReceivingNotification extends ReceivingAsync<IncomingNotificationRequest> {
    private final j02 logger;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ReceivingNotification(UpnpService upnpService, IncomingDatagramMessage<UpnpRequest> incomingDatagramMessage) {
        super(upnpService, new IncomingNotificationRequest(incomingDatagramMessage));
        this.logger = n02.k(ReceivingNotification.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.protocol.ReceivingAsync
    public void execute() {
        UDN udn = getInputMessage().getUDN();
        if (udn == null) {
            this.logger.h("Ignoring notification message without UDN: {}", getInputMessage());
            return;
        }
        RemoteDeviceIdentity remoteDeviceIdentity = new RemoteDeviceIdentity(getInputMessage());
        this.logger.h("Received device notification: {}", remoteDeviceIdentity);
        try {
            RemoteDevice remoteDevice = new RemoteDevice(remoteDeviceIdentity);
            if (!getInputMessage().isAliveMessage()) {
                boolean zIsByeByeMessage = getInputMessage().isByeByeMessage();
                j02 j02Var = this.logger;
                if (!zIsByeByeMessage) {
                    j02Var.h("Ignoring unknown notification message: {}", getInputMessage());
                    return;
                }
                j02Var.y("Received device BYEBYE advertisement");
                if (getUpnpService().getRegistry().removeDevice(remoteDevice)) {
                    this.logger.h("Removed remote device from registry: {}", remoteDevice);
                    return;
                }
                return;
            }
            this.logger.h("Received device ALIVE advertisement, descriptor location is: {}", remoteDeviceIdentity.getDescriptorURL());
            if (remoteDeviceIdentity.getDescriptorURL() == null) {
                this.logger.h("Ignoring message without location URL header: {}", getInputMessage());
                return;
            }
            if (remoteDeviceIdentity.getMaxAgeSeconds() == null) {
                this.logger.h("Ignoring message without max-age header: {}", getInputMessage());
            } else if (getUpnpService().getRegistry().update(remoteDeviceIdentity)) {
                this.logger.h("Remote device was already known: {}", udn);
            } else {
                getUpnpService().getConfiguration().getAsyncProtocolExecutor().execute(new RetrieveRemoteDescriptors(getUpnpService(), remoteDevice));
            }
        } catch (ValidationException e) {
            this.logger.d("Validation errors of device during discovery: {}", remoteDeviceIdentity);
            Iterator<ValidationError> it = e.getErrors().iterator();
            while (it.hasNext()) {
                this.logger.warn(it.next().toString());
            }
        }
    }
}
