package org.jupnp.protocol.async;

import defpackage.j02;
import defpackage.n02;
import java.util.Iterator;
import java.util.concurrent.Executor;
import org.jupnp.UpnpService;
import org.jupnp.UpnpServiceConfiguration;
import org.jupnp.model.ValidationError;
import org.jupnp.model.ValidationException;
import org.jupnp.model.message.IncomingDatagramMessage;
import org.jupnp.model.message.UpnpResponse;
import org.jupnp.model.message.discovery.IncomingSearchResponse;
import org.jupnp.model.meta.RemoteDevice;
import org.jupnp.model.meta.RemoteDeviceIdentity;
import org.jupnp.model.types.UDN;
import org.jupnp.protocol.ReceivingAsync;
import org.jupnp.protocol.RetrieveRemoteDescriptors;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ReceivingSearchResponse extends ReceivingAsync<IncomingSearchResponse> {
    private final j02 logger;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ReceivingSearchResponse(UpnpService upnpService, IncomingDatagramMessage<UpnpResponse> incomingDatagramMessage) {
        super(upnpService, new IncomingSearchResponse(incomingDatagramMessage));
        this.logger = n02.k(ReceivingSearchResponse.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.protocol.ReceivingAsync
    public void execute() {
        Executor asyncProtocolExecutor;
        if (!getInputMessage().isSearchResponseMessage()) {
            this.logger.h("Ignoring invalid search response message: {}", getInputMessage());
            return;
        }
        UDN rootDeviceUDN = getInputMessage().getRootDeviceUDN();
        if (rootDeviceUDN == null) {
            this.logger.h("Ignoring search response message without UDN: {}", getInputMessage());
            return;
        }
        RemoteDeviceIdentity remoteDeviceIdentity = new RemoteDeviceIdentity(getInputMessage());
        this.logger.h("Received device search response: {}", remoteDeviceIdentity);
        if (getUpnpService().getRegistry().update(remoteDeviceIdentity)) {
            this.logger.h("Remote device was already known: {}", rootDeviceUDN);
            return;
        }
        try {
            RemoteDevice remoteDevice = new RemoteDevice(remoteDeviceIdentity);
            if (remoteDeviceIdentity.getDescriptorURL() == null) {
                this.logger.h("Ignoring message without location URL header: {}", getInputMessage());
                return;
            }
            if (remoteDeviceIdentity.getMaxAgeSeconds() == null) {
                this.logger.h("Ignoring message without max-age header: {}", getInputMessage());
                return;
            }
            if (RetrieveRemoteDescriptors.isRetrievalInProgress(remoteDevice)) {
                this.logger.h("Skip submitting task, active retrieval for URL already in progress: {}", remoteDevice.getIdentity().getDescriptorURL());
                return;
            }
            UpnpServiceConfiguration configuration = getUpnpService().getConfiguration();
            if (configuration == null || (asyncProtocolExecutor = configuration.getAsyncProtocolExecutor()) == null) {
                return;
            }
            asyncProtocolExecutor.execute(new RetrieveRemoteDescriptors(getUpnpService(), remoteDevice));
        } catch (ValidationException e) {
            this.logger.d("Validation errors of device during discovery: {}", remoteDeviceIdentity);
            Iterator<ValidationError> it = e.getErrors().iterator();
            while (it.hasNext()) {
                this.logger.warn(it.next().toString());
            }
        }
    }
}
