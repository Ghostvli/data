package org.jupnp.transport.spi;

import defpackage.j02;
import defpackage.n02;
import org.jupnp.model.message.StreamRequestMessage;
import org.jupnp.model.message.StreamResponseMessage;
import org.jupnp.model.message.UpnpResponse;
import org.jupnp.protocol.ProtocolCreationException;
import org.jupnp.protocol.ProtocolFactory;
import org.jupnp.protocol.ReceivingSync;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class UpnpStream implements Runnable {
    private final j02 logger = n02.k(UpnpStream.class);
    protected final ProtocolFactory protocolFactory;
    protected ReceivingSync syncProtocol;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public UpnpStream(ProtocolFactory protocolFactory) {
        this.protocolFactory = protocolFactory;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ProtocolFactory getProtocolFactory() {
        return this.protocolFactory;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public StreamResponseMessage process(StreamRequestMessage streamRequestMessage) {
        this.logger.h("Processing stream request message: {}", streamRequestMessage);
        try {
            ReceivingSync receivingSyncCreateReceivingSync = getProtocolFactory().createReceivingSync(streamRequestMessage);
            this.syncProtocol = receivingSyncCreateReceivingSync;
            this.logger.h("Running protocol for synchronous message processing: {}", receivingSyncCreateReceivingSync);
            this.syncProtocol.run();
            StreamResponseMessage outputMessage = this.syncProtocol.getOutputMessage();
            j02 j02Var = this.logger;
            if (outputMessage == null) {
                j02Var.y("Protocol did not return any response message");
                return null;
            }
            j02Var.h("Protocol returned response: {}", outputMessage);
            return outputMessage;
        } catch (ProtocolCreationException e) {
            this.logger.u("Processing stream request failed", e);
            return new StreamResponseMessage(UpnpResponse.Status.NOT_IMPLEMENTED);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void responseException(Throwable th) {
        ReceivingSync receivingSync = this.syncProtocol;
        if (receivingSync != null) {
            receivingSync.responseException(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void responseSent(StreamResponseMessage streamResponseMessage) {
        ReceivingSync receivingSync = this.syncProtocol;
        if (receivingSync != null) {
            receivingSync.responseSent(streamResponseMessage);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "(" + getClass().getSimpleName() + ")";
    }
}
