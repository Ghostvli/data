package org.jupnp.binding.staging;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jupnp.model.meta.Action;
import org.jupnp.model.meta.Device;
import org.jupnp.model.meta.Service;
import org.jupnp.model.meta.StateVariable;
import org.jupnp.model.types.ServiceId;
import org.jupnp.model.types.ServiceType;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class MutableService {
    public URI controlURI;
    public URI descriptorURI;
    public URI eventSubscriptionURI;
    public ServiceId serviceId;
    public ServiceType serviceType;
    public List<MutableAction> actions = new ArrayList();
    public List<MutableStateVariable> stateVariables = new ArrayList();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Service build(Device device) {
        return device.newInstance(this.serviceType, this.serviceId, this.descriptorURI, this.controlURI, this.eventSubscriptionURI, createActions(), createStateVariables());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Action[] createActions() {
        Action[] actionArr = new Action[this.actions.size()];
        Iterator<MutableAction> it = this.actions.iterator();
        int i = 0;
        while (it.hasNext()) {
            actionArr[i] = it.next().build();
            i++;
        }
        return actionArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public StateVariable[] createStateVariables() {
        StateVariable[] stateVariableArr = new StateVariable[this.stateVariables.size()];
        Iterator<MutableStateVariable> it = this.stateVariables.iterator();
        int i = 0;
        while (it.hasNext()) {
            stateVariableArr[i] = it.next().build();
            i++;
        }
        return stateVariableArr;
    }
}
