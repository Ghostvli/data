package org.jupnp.transport.spi;

import org.jupnp.model.action.ActionInvocation;
import org.jupnp.model.message.control.ActionRequestMessage;
import org.jupnp.model.message.control.ActionResponseMessage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface SOAPActionProcessor {
    void readBody(ActionRequestMessage actionRequestMessage, ActionInvocation actionInvocation);

    void readBody(ActionResponseMessage actionResponseMessage, ActionInvocation actionInvocation);

    void writeBody(ActionRequestMessage actionRequestMessage, ActionInvocation actionInvocation);

    void writeBody(ActionResponseMessage actionResponseMessage, ActionInvocation actionInvocation);
}
