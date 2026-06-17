package org.jupnp.model.gena;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.jupnp.internal.compat.java.beans.PropertyChangeSupport;
import org.jupnp.model.Location;
import org.jupnp.model.Namespace;
import org.jupnp.model.NetworkAddress;
import org.jupnp.model.UnsupportedDataException;
import org.jupnp.model.message.UpnpResponse;
import org.jupnp.model.meta.RemoteService;
import org.jupnp.model.state.StateVariableValue;
import org.jupnp.model.types.UnsignedIntegerFourBytes;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class RemoteGENASubscription extends GENASubscription<RemoteService> {
    protected PropertyChangeSupport propertyChangeSupport;

    public RemoteGENASubscription(RemoteService remoteService, int i) {
        super(remoteService, i);
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public synchronized void end(CancelReason cancelReason, UpnpResponse upnpResponse) {
        ended(cancelReason, upnpResponse);
    }

    public abstract void ended(CancelReason cancelReason, UpnpResponse upnpResponse);

    public synchronized void establish() {
        established();
    }

    public abstract void eventsMissed(int i);

    public synchronized void fail(UpnpResponse upnpResponse) {
        failed(upnpResponse);
    }

    public abstract void failed(UpnpResponse upnpResponse);

    public List<URL> getEventCallbackURLs(List<NetworkAddress> list, Namespace namespace) {
        ArrayList arrayList = new ArrayList();
        Iterator<NetworkAddress> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new Location(it.next(), namespace.getEventCallbackPathString(getService())).getURL());
        }
        return arrayList;
    }

    public URL getEventSubscriptionURL() {
        return getService().getDevice().normalizeURI(getService().getEventSubscriptionURI());
    }

    public abstract void invalidMessage(UnsupportedDataException unsupportedDataException);

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public synchronized void receive(UnsignedIntegerFourBytes unsignedIntegerFourBytes, Collection<StateVariableValue> collection) {
        if (this.currentSequence != null) {
            if (this.currentSequence.getValue().equals(Long.valueOf(this.currentSequence.getBits().getMaxValue())) && unsignedIntegerFourBytes.getValue().longValue() == 1) {
                System.err.println("TODO: HANDLE ROLLOVER");
                return;
            } else {
                if (this.currentSequence.getValue().longValue() >= unsignedIntegerFourBytes.getValue().longValue()) {
                    return;
                }
                int iLongValue = (int) (unsignedIntegerFourBytes.getValue().longValue() - (this.currentSequence.getValue().longValue() + 1));
                if (iLongValue != 0) {
                    eventsMissed(iLongValue);
                }
            }
        }
        this.currentSequence = unsignedIntegerFourBytes;
        for (StateVariableValue stateVariableValue : collection) {
            this.currentValues.put(stateVariableValue.getStateVariable().getName(), (StateVariableValue<S>) stateVariableValue);
        }
        eventReceived();
    }

    @Override // org.jupnp.model.gena.GENASubscription
    public String toString() {
        return "(SID: " + getSubscriptionId() + ") " + String.valueOf(getService());
    }
}
