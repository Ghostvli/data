package com.hierynomus.smbj.common;

import com.hierynomus.protocol.commons.concurrent.ExceptionWrapper;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMBRuntimeException extends RuntimeException {
    public static final ExceptionWrapper<SMBRuntimeException> Wrapper = new ExceptionWrapper<SMBRuntimeException>() { // from class: com.hierynomus.smbj.common.SMBRuntimeException.1
        @Override // com.hierynomus.protocol.commons.concurrent.ExceptionWrapper
        public SMBRuntimeException wrap(Throwable th) {
            return th instanceof SMBRuntimeException ? (SMBRuntimeException) th : new SMBRuntimeException(th);
        }
    };

    public SMBRuntimeException(Throwable th) {
        super(th);
    }

    public SMBRuntimeException(String str) {
        super(str);
    }

    public SMBRuntimeException(String str, Throwable th) {
        super(str, th);
    }
}
