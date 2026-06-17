package org.jupnp.support.connectionmanager;

import defpackage.j02;
import defpackage.n02;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jupnp.binding.annotations.UpnpAction;
import org.jupnp.binding.annotations.UpnpInputArgument;
import org.jupnp.binding.annotations.UpnpOutputArgument;
import org.jupnp.binding.annotations.UpnpService;
import org.jupnp.binding.annotations.UpnpServiceId;
import org.jupnp.binding.annotations.UpnpServiceType;
import org.jupnp.binding.annotations.UpnpStateVariable;
import org.jupnp.binding.annotations.UpnpStateVariables;
import org.jupnp.internal.compat.java.beans.PropertyChangeSupport;
import org.jupnp.model.ServiceReference;
import org.jupnp.model.types.UnsignedIntegerFourBytes;
import org.jupnp.model.types.csv.CSV;
import org.jupnp.model.types.csv.CSVUnsignedIntegerFourBytes;
import org.jupnp.support.model.ConnectionInfo;
import org.jupnp.support.model.ProtocolInfo;
import org.jupnp.support.model.ProtocolInfos;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
@UpnpService(serviceId = @UpnpServiceId("ConnectionManager"), serviceType = @UpnpServiceType(value = "ConnectionManager", version = 1), stringConvertibleTypes = {ProtocolInfo.class, ProtocolInfos.class, ServiceReference.class})
@UpnpStateVariables({@UpnpStateVariable(datatype = "string", name = "SourceProtocolInfo"), @UpnpStateVariable(datatype = "string", name = "SinkProtocolInfo"), @UpnpStateVariable(datatype = "string", name = "CurrentConnectionIDs"), @UpnpStateVariable(allowedValuesEnum = ConnectionInfo.Status.class, name = "A_ARG_TYPE_ConnectionStatus", sendEvents = false), @UpnpStateVariable(datatype = "string", name = "A_ARG_TYPE_ConnectionManager", sendEvents = false), @UpnpStateVariable(allowedValuesEnum = ConnectionInfo.Direction.class, name = "A_ARG_TYPE_Direction", sendEvents = false), @UpnpStateVariable(datatype = "string", name = "A_ARG_TYPE_ProtocolInfo", sendEvents = false), @UpnpStateVariable(datatype = "i4", name = "A_ARG_TYPE_ConnectionID", sendEvents = false), @UpnpStateVariable(datatype = "i4", name = "A_ARG_TYPE_AVTransportID", sendEvents = false), @UpnpStateVariable(datatype = "i4", name = "A_ARG_TYPE_RcsID", sendEvents = false)})
public class ConnectionManagerService {
    protected final Map<Integer, ConnectionInfo> activeConnections;
    private final j02 logger;
    protected final PropertyChangeSupport propertyChangeSupport;
    protected final ProtocolInfos sinkProtocolInfo;
    protected final ProtocolInfos sourceProtocolInfo;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ConnectionManagerService(PropertyChangeSupport propertyChangeSupport, ProtocolInfos protocolInfos, ProtocolInfos protocolInfos2, ConnectionInfo... connectionInfoArr) {
        this.logger = n02.l(ConnectionManagerService.class.getName());
        this.activeConnections = new ConcurrentHashMap();
        this.propertyChangeSupport = propertyChangeSupport == null ? new PropertyChangeSupport(this) : propertyChangeSupport;
        this.sourceProtocolInfo = protocolInfos;
        this.sinkProtocolInfo = protocolInfos2;
        for (ConnectionInfo connectionInfo : connectionInfoArr) {
            this.activeConnections.put(Integer.valueOf(connectionInfo.getConnectionID()), connectionInfo);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @UpnpAction(out = {@UpnpOutputArgument(name = "ConnectionIDs")})
    public synchronized CSV<UnsignedIntegerFourBytes> getCurrentConnectionIDs() {
        CSVUnsignedIntegerFourBytes cSVUnsignedIntegerFourBytes;
        try {
            cSVUnsignedIntegerFourBytes = new CSVUnsignedIntegerFourBytes();
            Iterator<Integer> it = this.activeConnections.keySet().iterator();
            while (it.hasNext()) {
                cSVUnsignedIntegerFourBytes.add(new UnsignedIntegerFourBytes(it.next().intValue()));
            }
            this.logger.q("Returning current connection IDs: {}", Integer.valueOf(cSVUnsignedIntegerFourBytes.size()));
        } catch (Throwable th) {
            throw th;
        }
        return cSVUnsignedIntegerFourBytes;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @UpnpAction(out = {@UpnpOutputArgument(getterName = "getRcsID", name = "RcsID"), @UpnpOutputArgument(getterName = "getAvTransportID", name = "AVTransportID"), @UpnpOutputArgument(getterName = "getProtocolInfo", name = "ProtocolInfo"), @UpnpOutputArgument(getterName = "getPeerConnectionManager", name = "PeerConnectionManager", stateVariable = "A_ARG_TYPE_ConnectionManager"), @UpnpOutputArgument(getterName = "getPeerConnectionID", name = "PeerConnectionID", stateVariable = "A_ARG_TYPE_ConnectionID"), @UpnpOutputArgument(getterName = "getDirection", name = "Direction"), @UpnpOutputArgument(getterName = "getConnectionStatus", name = "Status", stateVariable = "A_ARG_TYPE_ConnectionStatus")})
    public synchronized ConnectionInfo getCurrentConnectionInfo(@UpnpInputArgument(name = "ConnectionID") int i) {
        ConnectionInfo connectionInfo;
        this.logger.q("Getting connection information of connection ID: {}", Integer.valueOf(i));
        connectionInfo = this.activeConnections.get(Integer.valueOf(i));
        if (connectionInfo == null) {
            throw new ConnectionManagerException(ConnectionManagerErrorCode.INVALID_CONNECTION_REFERENCE, "Non-active connection ID: " + i);
        }
        return connectionInfo;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PropertyChangeSupport getPropertyChangeSupport() {
        return this.propertyChangeSupport;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @UpnpAction(out = {@UpnpOutputArgument(getterName = "getSourceProtocolInfo", name = "Source", stateVariable = "SourceProtocolInfo"), @UpnpOutputArgument(getterName = "getSinkProtocolInfo", name = "Sink", stateVariable = "SinkProtocolInfo")})
    public synchronized void getProtocolInfo() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized ProtocolInfos getSinkProtocolInfo() {
        return this.sinkProtocolInfo;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized ProtocolInfos getSourceProtocolInfo() {
        return this.sourceProtocolInfo;
    }

    public ConnectionManagerService(ProtocolInfos protocolInfos, ProtocolInfos protocolInfos2) {
        this(protocolInfos, protocolInfos2, new ConnectionInfo());
    }

    public ConnectionManagerService(ConnectionInfo... connectionInfoArr) {
        this(null, new ProtocolInfos(new ProtocolInfo[0]), new ProtocolInfos(new ProtocolInfo[0]), connectionInfoArr);
    }

    public ConnectionManagerService(ProtocolInfos protocolInfos, ProtocolInfos protocolInfos2, ConnectionInfo... connectionInfoArr) {
        this(null, protocolInfos, protocolInfos2, connectionInfoArr);
    }

    public ConnectionManagerService() {
        this(new ConnectionInfo());
    }
}
