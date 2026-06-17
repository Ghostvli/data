package com.hierynomus.smbj.session;

import com.hierynomus.smbj.common.SMBRuntimeException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2GuestSigningRequiredException extends SMBRuntimeException {
    public SMB2GuestSigningRequiredException() {
        super("Cannot require message signing when authenticating with a guest account");
    }
}
