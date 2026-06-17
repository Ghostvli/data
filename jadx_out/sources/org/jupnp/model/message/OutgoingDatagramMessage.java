package org.jupnp.model.message;

import java.net.InetAddress;
import org.jupnp.model.message.UpnpMessage;
import org.jupnp.model.message.UpnpOperation;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class OutgoingDatagramMessage<O extends UpnpOperation> extends UpnpMessage<O> {
    private InetAddress destinationAddress;
    private int destinationPort;
    private UpnpHeaders headers;

    public OutgoingDatagramMessage(O o, InetAddress inetAddress, int i) {
        super(o);
        this.headers = new UpnpHeaders(false);
        this.destinationAddress = inetAddress;
        this.destinationPort = i;
    }

    public InetAddress getDestinationAddress() {
        return this.destinationAddress;
    }

    public int getDestinationPort() {
        return this.destinationPort;
    }

    @Override // org.jupnp.model.message.UpnpMessage
    public UpnpHeaders getHeaders() {
        return this.headers;
    }

    public OutgoingDatagramMessage(O o, UpnpMessage.BodyType bodyType, Object obj, InetAddress inetAddress, int i) {
        super(o, bodyType, obj);
        this.headers = new UpnpHeaders(false);
        this.destinationAddress = inetAddress;
        this.destinationPort = i;
    }
}
