package org.jupnp.protocol.sync;

import defpackage.j02;
import defpackage.n02;
import java.net.URI;
import org.jupnp.UpnpService;
import org.jupnp.binding.xml.DescriptorBindingException;
import org.jupnp.model.message.StreamRequestMessage;
import org.jupnp.model.message.StreamResponseMessage;
import org.jupnp.model.message.UpnpResponse;
import org.jupnp.model.message.header.ContentTypeHeader;
import org.jupnp.model.message.header.ServerHeader;
import org.jupnp.model.message.header.UpnpHeader;
import org.jupnp.model.meta.Icon;
import org.jupnp.model.meta.LocalDevice;
import org.jupnp.model.meta.LocalService;
import org.jupnp.model.resource.DeviceDescriptorResource;
import org.jupnp.model.resource.IconResource;
import org.jupnp.model.resource.Resource;
import org.jupnp.model.resource.ServiceDescriptorResource;
import org.jupnp.protocol.ReceivingSync;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ReceivingRetrieval extends ReceivingSync<StreamRequestMessage, StreamResponseMessage> {
    private final j02 logger;

    public ReceivingRetrieval(UpnpService upnpService, StreamRequestMessage streamRequestMessage) {
        super(upnpService, streamRequestMessage);
        this.logger = n02.k(ReceivingRetrieval.class);
    }

    public StreamResponseMessage createResponse(URI uri, Resource resource) {
        StreamResponseMessage streamResponseMessage;
        try {
            if (DeviceDescriptorResource.class.isAssignableFrom(resource.getClass())) {
                this.logger.h("Found local device matching relative request URI: {}", uri);
                streamResponseMessage = new StreamResponseMessage(getUpnpService().getConfiguration().getDeviceDescriptorBinderUDA10().generate((LocalDevice) resource.getModel(), getRemoteClientInfo(), getUpnpService().getConfiguration().getNamespace()), new ContentTypeHeader(ContentTypeHeader.DEFAULT_CONTENT_TYPE));
            } else if (ServiceDescriptorResource.class.isAssignableFrom(resource.getClass())) {
                this.logger.h("Found local service matching relative request URI: {}", uri);
                streamResponseMessage = new StreamResponseMessage(getUpnpService().getConfiguration().getServiceDescriptorBinderUDA10().generate((LocalService) resource.getModel()), new ContentTypeHeader(ContentTypeHeader.DEFAULT_CONTENT_TYPE));
            } else {
                boolean zIsAssignableFrom = IconResource.class.isAssignableFrom(resource.getClass());
                j02 j02Var = this.logger;
                if (!zIsAssignableFrom) {
                    j02Var.h("Ignoring GET for found local resource: {}", resource);
                    return null;
                }
                j02Var.h("Found local icon matching relative request URI: {}", uri);
                Icon icon = (Icon) resource.getModel();
                streamResponseMessage = new StreamResponseMessage(icon.getData(), icon.getMimeType());
            }
        } catch (DescriptorBindingException e) {
            this.logger.u("Error generating requested device/service descriptor", e);
            streamResponseMessage = new StreamResponseMessage(UpnpResponse.Status.INTERNAL_SERVER_ERROR);
        }
        streamResponseMessage.getHeaders().add(UpnpHeader.Type.SERVER, new ServerHeader());
        return streamResponseMessage;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jupnp.protocol.ReceivingSync
    public StreamResponseMessage executeSync() {
        if (!((StreamRequestMessage) getInputMessage()).hasHostHeader()) {
            this.logger.h("Ignoring message, missing HOST header: {}", getInputMessage());
            return new StreamResponseMessage(new UpnpResponse(UpnpResponse.Status.PRECONDITION_FAILED));
        }
        URI uri = ((StreamRequestMessage) getInputMessage()).getOperation().getURI();
        Resource resource = getUpnpService().getRegistry().getResource(uri);
        if (resource != null || (resource = onResourceNotFound(uri)) != null) {
            return createResponse(uri, resource);
        }
        this.logger.h("No local resource found: {}", getInputMessage());
        return null;
    }

    public Resource onResourceNotFound(URI uri) {
        return null;
    }
}
