package org.simpleframework.xml.transform;

import org.simpleframework.xml.core.PersistenceException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class TransformException extends PersistenceException {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public TransformException(Throwable th, String str, Object... objArr) {
        super(String.format(str, objArr), th);
    }

    public TransformException(String str, Object... objArr) {
        super(String.format(str, objArr), new Object[0]);
    }
}
