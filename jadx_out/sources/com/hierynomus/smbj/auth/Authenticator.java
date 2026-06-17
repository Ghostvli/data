package com.hierynomus.smbj.auth;

import com.hierynomus.smbj.SmbConfig;
import com.hierynomus.smbj.connection.ConnectionContext;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface Authenticator {
    AuthenticateResponse authenticate(AuthenticationContext authenticationContext, byte[] bArr, ConnectionContext connectionContext);

    void init(SmbConfig smbConfig);

    boolean supports(AuthenticationContext authenticationContext);
}
