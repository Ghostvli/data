package org.jupnp.controlpoint;

import defpackage.j02;
import defpackage.n02;
import java.util.concurrent.Future;
import org.jupnp.UpnpServiceConfiguration;
import org.jupnp.controlpoint.event.ExecuteAction;
import org.jupnp.controlpoint.event.Search;
import org.jupnp.model.message.header.MXHeader;
import org.jupnp.model.message.header.STAllHeader;
import org.jupnp.model.message.header.UpnpHeader;
import org.jupnp.protocol.ProtocolFactory;
import org.jupnp.registry.Registry;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ControlPointImpl implements ControlPoint {
    protected UpnpServiceConfiguration configuration;
    private final j02 logger;
    protected ProtocolFactory protocolFactory;
    protected Registry registry;

    public ControlPointImpl(UpnpServiceConfiguration upnpServiceConfiguration, ProtocolFactory protocolFactory, Registry registry) {
        j02 j02VarK = n02.k(ControlPointImpl.class);
        this.logger = j02VarK;
        j02VarK.h("Creating ControlPoint: {}", getClass().getName());
        this.configuration = upnpServiceConfiguration;
        this.protocolFactory = protocolFactory;
        this.registry = registry;
    }

    @Override // org.jupnp.controlpoint.ControlPoint
    public Future execute(ActionCallback actionCallback) {
        this.logger.h("Invoking action in background: {}", actionCallback);
        actionCallback.setControlPoint(this);
        return getConfiguration().getSyncProtocolExecutorService().submit(actionCallback);
    }

    @Override // org.jupnp.controlpoint.ControlPoint
    public UpnpServiceConfiguration getConfiguration() {
        return this.configuration;
    }

    @Override // org.jupnp.controlpoint.ControlPoint
    public ProtocolFactory getProtocolFactory() {
        return this.protocolFactory;
    }

    @Override // org.jupnp.controlpoint.ControlPoint
    public Registry getRegistry() {
        return this.registry;
    }

    @Override // org.jupnp.controlpoint.ControlPoint
    public void search(UpnpHeader upnpHeader, int i) {
        this.logger.h("Sending asynchronous search for: {}", upnpHeader.getString());
        getConfiguration().getAsyncProtocolExecutor().execute(getProtocolFactory().createSendingSearch(upnpHeader, i));
    }

    public void execute(ExecuteAction executeAction) {
        execute(executeAction.getCallback());
    }

    @Override // org.jupnp.controlpoint.ControlPoint
    public void execute(SubscriptionCallback subscriptionCallback) {
        this.logger.h("Invoking subscription in background: {}", subscriptionCallback);
        subscriptionCallback.setControlPoint(this);
        getConfiguration().getSyncProtocolExecutorService().execute(subscriptionCallback);
    }

    public ControlPointImpl() {
        this.logger = n02.k(ControlPointImpl.class);
    }

    @Override // org.jupnp.controlpoint.ControlPoint
    public void search() {
        search(new STAllHeader(), MXHeader.DEFAULT_VALUE.intValue());
    }

    @Override // org.jupnp.controlpoint.ControlPoint
    public void search(UpnpHeader upnpHeader) {
        search(upnpHeader, MXHeader.DEFAULT_VALUE.intValue());
    }

    @Override // org.jupnp.controlpoint.ControlPoint
    public void search(int i) {
        search(new STAllHeader(), i);
    }

    public void search(Search search) {
        search(search.getSearchType(), search.getMxSeconds());
    }
}
