package org.jupnp.protocol;

import org.jupnp.UpnpService;
import org.jupnp.model.message.StreamRequestMessage;
import org.jupnp.model.message.StreamResponseMessage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SendingSync<IN extends StreamRequestMessage, OUT extends StreamResponseMessage> extends SendingAsync {
    private final IN inputMessage;
    protected OUT outputMessage;

    public SendingSync(UpnpService upnpService, IN in) {
        super(upnpService);
        this.inputMessage = in;
    }

    @Override // org.jupnp.protocol.SendingAsync
    public final void execute() {
        this.outputMessage = (OUT) executeSync();
    }

    public abstract OUT executeSync();

    public IN getInputMessage() {
        return this.inputMessage;
    }

    public OUT getOutputMessage() {
        return this.outputMessage;
    }

    @Override // org.jupnp.protocol.SendingAsync
    public String toString() {
        return "(" + getClass().getSimpleName() + ")";
    }
}
