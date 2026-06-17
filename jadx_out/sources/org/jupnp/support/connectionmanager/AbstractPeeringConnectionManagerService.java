package org.jupnp.support.connectionmanager;

import defpackage.j02;
import defpackage.n02;
import org.jupnp.binding.annotations.UpnpAction;
import org.jupnp.binding.annotations.UpnpInputArgument;
import org.jupnp.binding.annotations.UpnpOutputArgument;
import org.jupnp.controlpoint.ControlPoint;
import org.jupnp.internal.compat.java.beans.PropertyChangeSupport;
import org.jupnp.model.ServiceReference;
import org.jupnp.model.action.ActionInvocation;
import org.jupnp.model.message.UpnpResponse;
import org.jupnp.model.meta.Service;
import org.jupnp.model.types.ErrorCode;
import org.jupnp.model.types.UnsignedIntegerFourBytes;
import org.jupnp.model.types.csv.CSV;
import org.jupnp.support.connectionmanager.callback.ConnectionComplete;
import org.jupnp.support.connectionmanager.callback.PrepareForConnection;
import org.jupnp.support.model.ConnectionInfo;
import org.jupnp.support.model.ProtocolInfo;
import org.jupnp.support.model.ProtocolInfos;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractPeeringConnectionManagerService extends ConnectionManagerService {
    private final j02 logger;

    public AbstractPeeringConnectionManagerService(ConnectionInfo... connectionInfoArr) {
        super(connectionInfoArr);
        this.logger = n02.k(AbstractPeeringConnectionManagerService.class);
    }

    public abstract void closeConnection(ConnectionInfo connectionInfo);

    public synchronized void closeConnectionWithPeer(ControlPoint controlPoint, Service<?, ?> service, final ConnectionInfo connectionInfo) throws Throwable {
        try {
            try {
                this.logger.f("Closing connection ID {} with peer: {}", Integer.valueOf(connectionInfo.getConnectionID()), service);
                new ConnectionComplete(this, service, controlPoint, connectionInfo.getPeerConnectionID()) { // from class: org.jupnp.support.connectionmanager.AbstractPeeringConnectionManagerService.2
                    final /* synthetic */ AbstractPeeringConnectionManagerService this$0;

                    {
                        this.this$0 = this;
                    }

                    @Override // org.jupnp.controlpoint.ActionCallback
                    public void failure(ActionInvocation actionInvocation, UpnpResponse upnpResponse, String str) {
                        this.this$0.peerFailure(actionInvocation, upnpResponse, str);
                    }

                    @Override // org.jupnp.controlpoint.ActionCallback
                    public void success(ActionInvocation actionInvocation) {
                        this.this$0.removeConnection(connectionInfo.getConnectionID());
                    }
                }.run();
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    @UpnpAction
    public synchronized void connectionComplete(@UpnpInputArgument(name = "ConnectionID", stateVariable = "A_ARG_TYPE_ConnectionID") int i) {
        ConnectionInfo currentConnectionInfo = getCurrentConnectionInfo(i);
        this.logger.q("Closing connection ID {}", Integer.valueOf(i));
        closeConnection(currentConnectionInfo);
        removeConnection(i);
    }

    public abstract ConnectionInfo createConnection(int i, int i2, ServiceReference serviceReference, ConnectionInfo.Direction direction, ProtocolInfo protocolInfo);

    public synchronized int createConnectionWithPeer(ServiceReference serviceReference, ControlPoint controlPoint, final Service<?, ?> service, final ProtocolInfo protocolInfo, final ConnectionInfo.Direction direction) {
        final int newConnectionId;
        newConnectionId = getNewConnectionId();
        this.logger.f("Creating new connection ID {} with peer: {}", Integer.valueOf(newConnectionId), service);
        final boolean[] zArr = new boolean[1];
        new PrepareForConnection(this, service, controlPoint, protocolInfo, serviceReference, newConnectionId, direction) { // from class: org.jupnp.support.connectionmanager.AbstractPeeringConnectionManagerService.1
            final /* synthetic */ AbstractPeeringConnectionManagerService this$0;

            {
                this.this$0 = this;
            }

            @Override // org.jupnp.controlpoint.ActionCallback
            public void failure(ActionInvocation actionInvocation, UpnpResponse upnpResponse, String str) {
                this.this$0.peerFailure(actionInvocation, upnpResponse, str);
                zArr[0] = true;
            }

            @Override // org.jupnp.support.connectionmanager.callback.PrepareForConnection
            public void received(ActionInvocation<?> actionInvocation, int i, int i2, int i3) {
                this.this$0.storeConnection(new ConnectionInfo(newConnectionId, i2, i3, protocolInfo, service.getReference(), i, direction.getOpposite(), ConnectionInfo.Status.OK));
            }
        }.run();
        if (zArr[0]) {
            newConnectionId = -1;
        }
        return newConnectionId;
    }

    public synchronized int getNewConnectionId() {
        int iIntValue;
        iIntValue = -1;
        for (Integer num : this.activeConnections.keySet()) {
            if (num.intValue() > iIntValue) {
                iIntValue = num.intValue();
            }
        }
        return iIntValue + 1;
    }

    public abstract void peerFailure(ActionInvocation<?> actionInvocation, UpnpResponse upnpResponse, String str);

    @UpnpAction(out = {@UpnpOutputArgument(getterName = "getConnectionID", name = "ConnectionID", stateVariable = "A_ARG_TYPE_ConnectionID"), @UpnpOutputArgument(getterName = "getAvTransportID", name = "AVTransportID", stateVariable = "A_ARG_TYPE_AVTransportID"), @UpnpOutputArgument(getterName = "getRcsID", name = "RcsID", stateVariable = "A_ARG_TYPE_RcsID")})
    public synchronized ConnectionInfo prepareForConnection(@UpnpInputArgument(name = "RemoteProtocolInfo", stateVariable = "A_ARG_TYPE_ProtocolInfo") ProtocolInfo protocolInfo, @UpnpInputArgument(name = "PeerConnectionManager", stateVariable = "A_ARG_TYPE_ConnectionManager") ServiceReference serviceReference, @UpnpInputArgument(name = "PeerConnectionID", stateVariable = "A_ARG_TYPE_ConnectionID") int i, @UpnpInputArgument(name = "Direction", stateVariable = "A_ARG_TYPE_Direction") String str) throws Throwable {
        try {
            int newConnectionId = getNewConnectionId();
            try {
                try {
                    ConnectionInfo.Direction directionValueOf = ConnectionInfo.Direction.valueOf(str);
                    this.logger.f("Preparing for connection with local new ID {} and peer connection ID: {}", Integer.valueOf(newConnectionId), Integer.valueOf(i));
                    ConnectionInfo connectionInfoCreateConnection = createConnection(newConnectionId, i, serviceReference, directionValueOf, protocolInfo);
                    storeConnection(connectionInfoCreateConnection);
                    return connectionInfoCreateConnection;
                } catch (Exception unused) {
                    throw new ConnectionManagerException(ErrorCode.ARGUMENT_VALUE_INVALID, "Unsupported direction: " + str);
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public synchronized void removeConnection(int i) {
        CSV<UnsignedIntegerFourBytes> currentConnectionIDs = getCurrentConnectionIDs();
        this.activeConnections.remove(Integer.valueOf(i));
        this.logger.q("Connection removed, firing event: {}", Integer.valueOf(i));
        getPropertyChangeSupport().firePropertyChange("CurrentConnectionIDs", currentConnectionIDs, getCurrentConnectionIDs());
    }

    public synchronized void storeConnection(ConnectionInfo connectionInfo) {
        CSV<UnsignedIntegerFourBytes> currentConnectionIDs = getCurrentConnectionIDs();
        this.activeConnections.put(Integer.valueOf(connectionInfo.getConnectionID()), connectionInfo);
        this.logger.q("Connection stored, firing event: {}", Integer.valueOf(connectionInfo.getConnectionID()));
        getPropertyChangeSupport().firePropertyChange("CurrentConnectionIDs", currentConnectionIDs, getCurrentConnectionIDs());
    }

    public AbstractPeeringConnectionManagerService(ProtocolInfos protocolInfos, ProtocolInfos protocolInfos2, ConnectionInfo... connectionInfoArr) {
        super(protocolInfos, protocolInfos2, connectionInfoArr);
        this.logger = n02.k(AbstractPeeringConnectionManagerService.class);
    }

    public AbstractPeeringConnectionManagerService(PropertyChangeSupport propertyChangeSupport, ProtocolInfos protocolInfos, ProtocolInfos protocolInfos2, ConnectionInfo... connectionInfoArr) {
        super(propertyChangeSupport, protocolInfos, protocolInfos2, connectionInfoArr);
        this.logger = n02.k(AbstractPeeringConnectionManagerService.class);
    }

    public synchronized void closeConnectionWithPeer(ControlPoint controlPoint, Service<?, ?> service, int i) {
        closeConnectionWithPeer(controlPoint, service, getCurrentConnectionInfo(i));
    }
}
