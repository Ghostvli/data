package com.hierynomus.protocol.transport;

import com.hierynomus.protocol.commons.concurrent.ExceptionWrapper;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class TransportException extends IOException {
    public static final ExceptionWrapper<TransportException> Wrapper = new ExceptionWrapper<TransportException>() { // from class: com.hierynomus.protocol.transport.TransportException.1
        @Override // com.hierynomus.protocol.commons.concurrent.ExceptionWrapper
        public TransportException wrap(Throwable th) {
            return th instanceof TransportException ? (TransportException) th : new TransportException(th);
        }
    };

    public TransportException(Throwable th) {
        super(th);
    }

    public TransportException(String str) {
        super(str);
    }

    public TransportException(String str, Throwable th) {
        super(str, th);
    }
}
