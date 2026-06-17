package org.jupnp.support.avtransport.impl;

import java.net.URI;
import org.jupnp.support.avtransport.impl.state.AbstractState;
import org.jupnp.support.model.SeekMode;
import org.jupnp.util.statemachine.StateMachine;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface AVTransportStateMachine extends StateMachine<AbstractState<?>> {
    void next();

    void pause();

    void play(String str);

    void previous();

    void record();

    void seek(SeekMode seekMode, String str);

    void setNextTransportURI(URI uri, String str);

    void setTransportURI(URI uri, String str);

    void stop();
}
