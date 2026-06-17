package org.jupnp.support.contentdirectory;

import org.jupnp.model.action.ActionException;
import org.jupnp.model.types.ErrorCode;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ContentDirectoryException extends ActionException {
    private static final long serialVersionUID = 4098130203774699299L;

    public ContentDirectoryException(ContentDirectoryErrorCode contentDirectoryErrorCode, String str) {
        super(contentDirectoryErrorCode.getCode(), contentDirectoryErrorCode.getDescription() + ". " + str + ".");
    }

    public ContentDirectoryException(int i, String str, Throwable th) {
        super(i, str, th);
    }

    public ContentDirectoryException(ErrorCode errorCode, String str) {
        super(errorCode, str);
    }

    public ContentDirectoryException(ErrorCode errorCode) {
        super(errorCode);
    }

    public ContentDirectoryException(int i, String str) {
        super(i, str);
    }

    public ContentDirectoryException(ContentDirectoryErrorCode contentDirectoryErrorCode) {
        super(contentDirectoryErrorCode.getCode(), contentDirectoryErrorCode.getDescription());
    }
}
