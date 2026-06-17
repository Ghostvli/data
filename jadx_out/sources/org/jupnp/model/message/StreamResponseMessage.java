package org.jupnp.model.message;

import org.jupnp.model.message.UpnpMessage;
import org.jupnp.model.message.UpnpResponse;
import org.jupnp.model.message.header.ContentTypeHeader;
import org.jupnp.model.message.header.UpnpHeader;
import org.jupnp.util.MimeType;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class StreamResponseMessage extends UpnpMessage<UpnpResponse> {
    public StreamResponseMessage(String str) {
        super(new UpnpResponse(UpnpResponse.Status.OK), UpnpMessage.BodyType.STRING, str);
    }

    public StreamResponseMessage(UpnpResponse.Status status) {
        super(new UpnpResponse(status));
    }

    public StreamResponseMessage(UpnpResponse upnpResponse) {
        super(upnpResponse);
    }

    public StreamResponseMessage(UpnpResponse upnpResponse, String str) {
        super(upnpResponse, UpnpMessage.BodyType.STRING, str);
    }

    public StreamResponseMessage(StreamResponseMessage streamResponseMessage) {
        super(streamResponseMessage);
    }

    public StreamResponseMessage(UpnpResponse upnpResponse, byte[] bArr) {
        super(upnpResponse, UpnpMessage.BodyType.BYTES, bArr);
    }

    public StreamResponseMessage(byte[] bArr) {
        super(new UpnpResponse(UpnpResponse.Status.OK), UpnpMessage.BodyType.BYTES, bArr);
    }

    public StreamResponseMessage(String str, ContentTypeHeader contentTypeHeader) {
        this(str);
        getHeaders().add(UpnpHeader.Type.CONTENT_TYPE, contentTypeHeader);
    }

    public StreamResponseMessage(String str, MimeType mimeType) {
        this(str, new ContentTypeHeader(mimeType));
    }

    public StreamResponseMessage(byte[] bArr, ContentTypeHeader contentTypeHeader) {
        this(bArr);
        getHeaders().add(UpnpHeader.Type.CONTENT_TYPE, contentTypeHeader);
    }

    public StreamResponseMessage(byte[] bArr, MimeType mimeType) {
        this(bArr, new ContentTypeHeader(mimeType));
    }
}
