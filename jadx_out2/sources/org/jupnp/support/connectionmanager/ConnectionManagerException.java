package org.jupnp.support.connectionmanager;

import org.jupnp.model.action.ActionException;
import org.jupnp.model.types.ErrorCode;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ConnectionManagerException extends ActionException {
    private static final long serialVersionUID = 4656849940513543654L;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ConnectionManagerException(ConnectionManagerErrorCode connectionManagerErrorCode, String str) {
        super(connectionManagerErrorCode.getCode(), connectionManagerErrorCode.getDescription() + ". " + str + ".");
    }

    public ConnectionManagerException(int i, String str, Throwable th) {
        super(i, str, th);
    }

    public ConnectionManagerException(ErrorCode errorCode, String str) {
        super(errorCode, str);
    }

    public ConnectionManagerException(ErrorCode errorCode) {
        super(errorCode);
    }

    public ConnectionManagerException(int i, String str) {
        super(i, str);
    }

    public ConnectionManagerException(ConnectionManagerErrorCode connectionManagerErrorCode) {
        super(connectionManagerErrorCode.getCode(), connectionManagerErrorCode.getDescription());
    }
}
