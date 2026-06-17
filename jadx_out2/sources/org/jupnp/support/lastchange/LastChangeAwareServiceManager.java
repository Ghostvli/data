package org.jupnp.support.lastchange;

import java.util.ArrayList;
import java.util.Collection;
import org.jupnp.model.DefaultServiceManager;
import org.jupnp.model.meta.LocalService;
import org.jupnp.model.meta.StateVariable;
import org.jupnp.model.state.StateVariableValue;
import org.jupnp.model.types.UnsignedIntegerFourBytes;
import org.jupnp.support.lastchange.LastChangeDelegator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class LastChangeAwareServiceManager<T extends LastChangeDelegator> extends DefaultServiceManager<T> {
    protected final LastChangeParser lastChangeParser;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public LastChangeAwareServiceManager(LocalService<T> localService, Class<T> cls, LastChangeParser lastChangeParser) {
        super(localService, cls);
        this.lastChangeParser = lastChangeParser;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void fireLastChange() {
        lock();
        try {
            getImplementation().getLastChange().fire(getPropertyChangeSupport());
        } finally {
            unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public LastChangeParser getLastChangeParser() {
        return this.lastChangeParser;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.model.DefaultServiceManager
    public Collection<StateVariableValue> readInitialEventedStateVariableValues() {
        LastChange lastChange = new LastChange(getLastChangeParser());
        UnsignedIntegerFourBytes[] currentInstanceIds = getImplementation().getCurrentInstanceIds();
        if (currentInstanceIds.length > 0) {
            for (UnsignedIntegerFourBytes unsignedIntegerFourBytes : currentInstanceIds) {
                getImplementation().appendCurrentState(lastChange, unsignedIntegerFourBytes);
            }
        } else {
            getImplementation().appendCurrentState(lastChange, new UnsignedIntegerFourBytes(0L));
        }
        StateVariable<LocalService> stateVariable = getService().getStateVariable("LastChange");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new StateVariableValue(stateVariable, lastChange.toString()));
        return arrayList;
    }

    public LastChangeAwareServiceManager(LocalService<T> localService, LastChangeParser lastChangeParser) {
        this(localService, null, lastChangeParser);
    }
}
