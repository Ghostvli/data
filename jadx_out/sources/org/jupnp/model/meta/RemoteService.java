package org.jupnp.model.meta;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.jupnp.model.ValidationError;
import org.jupnp.model.ValidationException;
import org.jupnp.model.types.ServiceId;
import org.jupnp.model.types.ServiceType;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class RemoteService extends Service<RemoteDevice, RemoteService> {
    private final URI controlURI;
    private final URI descriptorURI;
    private final URI eventSubscriptionURI;

    public RemoteService(ServiceType serviceType, ServiceId serviceId, URI uri, URI uri2, URI uri3, Action<RemoteService>[] actionArr, StateVariable<RemoteService>[] stateVariableArr) throws ValidationException {
        super(serviceType, serviceId, actionArr, stateVariableArr);
        this.descriptorURI = uri;
        this.controlURI = uri2;
        this.eventSubscriptionURI = uri3;
        List<ValidationError> listValidateThis = validateThis();
        if (!listValidateThis.isEmpty()) {
            throw new ValidationException("Validation of device graph failed, call getErrors() on exception", listValidateThis);
        }
    }

    public URI getControlURI() {
        return this.controlURI;
    }

    public URI getDescriptorURI() {
        return this.descriptorURI;
    }

    public URI getEventSubscriptionURI() {
        return this.eventSubscriptionURI;
    }

    @Override // org.jupnp.model.meta.Service
    public Action getQueryStateVariableAction() {
        return new QueryStateVariableAction(this);
    }

    @Override // org.jupnp.model.meta.Service
    public String toString() {
        return "(" + getClass().getSimpleName() + ") Descriptor: " + String.valueOf(getDescriptorURI());
    }

    public List<ValidationError> validateThis() {
        ArrayList arrayList = new ArrayList();
        if (getDescriptorURI() == null) {
            arrayList.add(new ValidationError(getClass(), "descriptorURI", "Descriptor location (SCPDURL) is required"));
        }
        if (getControlURI() == null) {
            arrayList.add(new ValidationError(getClass(), "controlURI", "Control URL is required"));
        }
        if (getEventSubscriptionURI() == null) {
            arrayList.add(new ValidationError(getClass(), "eventSubscriptionURI", "Event subscription URL is required"));
        }
        return arrayList;
    }

    public RemoteService(ServiceType serviceType, ServiceId serviceId, URI uri, URI uri2, URI uri3) {
        this(serviceType, serviceId, uri, uri2, uri3, null, null);
    }
}
