package org.jupnp.support.avtransport.impl.state;

import defpackage.j02;
import defpackage.n02;
import java.net.URI;
import org.jupnp.support.avtransport.lastchange.AVTransportVariable;
import org.jupnp.support.model.AVTransport;
import org.jupnp.support.model.TransportAction;
import org.jupnp.support.model.TransportInfo;
import org.jupnp.support.model.TransportState;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class PausedPlay<T extends AVTransport> extends AbstractState<T> {
    private final j02 logger;

    public PausedPlay(T t) {
        super(t);
        this.logger = n02.k(PausedPlay.class);
    }

    @Override // org.jupnp.support.avtransport.impl.state.AbstractState
    public TransportAction[] getCurrentTransportActions() {
        return new TransportAction[]{TransportAction.Stop, TransportAction.Play};
    }

    public void onEntry() {
        this.logger.b("Setting transport state to PAUSED_PLAYBACK");
        T transport = getTransport();
        TransportState transportState = TransportState.PAUSED_PLAYBACK;
        transport.setTransportInfo(new TransportInfo(transportState, getTransport().getTransportInfo().getCurrentTransportStatus(), getTransport().getTransportInfo().getCurrentSpeed()));
        getTransport().getLastChange().setEventedValue(getTransport().getInstanceId(), new AVTransportVariable.TransportState(transportState), new AVTransportVariable.CurrentTransportActions(getCurrentTransportActions()));
    }

    public abstract Class<? extends AbstractState<?>> play(String str);

    public abstract Class<? extends AbstractState<?>> setTransportURI(URI uri, String str);

    public abstract Class<? extends AbstractState<?>> stop();
}
