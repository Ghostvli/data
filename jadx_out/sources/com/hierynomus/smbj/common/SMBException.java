package com.hierynomus.smbj.common;

import com.hierynomus.protocol.commons.concurrent.ExceptionWrapper;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMBException extends IOException {
    public static final ExceptionWrapper<SMBException> Wrapper = new ExceptionWrapper<SMBException>() { // from class: com.hierynomus.smbj.common.SMBException.1
        @Override // com.hierynomus.protocol.commons.concurrent.ExceptionWrapper
        public SMBException wrap(Throwable th) {
            return th instanceof SMBException ? (SMBException) th : new SMBException(th);
        }
    };

    public SMBException(String str) {
        super(str);
    }

    public SMBException(Throwable th) {
        super(th);
    }
}
