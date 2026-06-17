package com.hierynomus.smbj.paths;

import com.hierynomus.mssmb2.SMB2Packet;
import com.hierynomus.smbj.common.SmbPath;
import com.hierynomus.smbj.session.Session;
import com.hierynomus.smbj.share.StatusHandler;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface PathResolver {
    public static final PathResolver LOCAL = new PathResolver() { // from class: com.hierynomus.smbj.paths.PathResolver.1
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.smbj.paths.PathResolver
        public <T> T resolve(Session session, SMB2Packet sMB2Packet, SmbPath smbPath, ResolveAction<T> resolveAction) {
            return resolveAction.apply(smbPath);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.smbj.paths.PathResolver
        public StatusHandler statusHandler() {
            return StatusHandler.SUCCESS;
        }

        @Override // com.hierynomus.smbj.paths.PathResolver
        public <T> T resolve(Session session, SmbPath smbPath, ResolveAction<T> resolveAction) {
            return resolveAction.apply(smbPath);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface ResolveAction<T> {
        T apply(SmbPath smbPath);
    }

    <T> T resolve(Session session, SMB2Packet sMB2Packet, SmbPath smbPath, ResolveAction<T> resolveAction);

    <T> T resolve(Session session, SmbPath smbPath, ResolveAction<T> resolveAction);

    StatusHandler statusHandler();
}
