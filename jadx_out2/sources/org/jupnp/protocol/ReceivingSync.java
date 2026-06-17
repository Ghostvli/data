package org.jupnp.protocol;

import defpackage.j02;
import defpackage.n02;
import org.jupnp.UpnpService;
import org.jupnp.model.message.StreamRequestMessage;
import org.jupnp.model.message.StreamResponseMessage;
import org.jupnp.model.profile.RemoteClientInfo;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ReceivingSync<IN extends StreamRequestMessage, OUT extends StreamResponseMessage> extends ReceivingAsync<IN> {
    private final j02 logger;
    protected OUT outputMessage;
    protected final RemoteClientInfo remoteClientInfo;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ReceivingSync(UpnpService upnpService, IN in) {
        super(upnpService, in);
        this.logger = n02.k(UpnpService.class);
        this.remoteClientInfo = new RemoteClientInfo(in);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.protocol.ReceivingAsync
    public final void execute() {
        OUT out = (OUT) executeSync();
        this.outputMessage = out;
        if (out == null || getRemoteClientInfo().getExtraResponseHeaders().isEmpty()) {
            return;
        }
        this.logger.h("Setting extra headers on response message: {}", Integer.valueOf(getRemoteClientInfo().getExtraResponseHeaders().size()));
        this.outputMessage.getHeaders().putAll(getRemoteClientInfo().getExtraResponseHeaders());
    }

    public abstract OUT executeSync();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public OUT getOutputMessage() {
        return this.outputMessage;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public RemoteClientInfo getRemoteClientInfo() {
        return this.remoteClientInfo;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void responseException(Throwable th) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void responseSent(StreamResponseMessage streamResponseMessage) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.protocol.ReceivingAsync
    public String toString() {
        return "(" + getClass().getSimpleName() + ")";
    }
}
