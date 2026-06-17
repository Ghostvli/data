package j$.nio.file;

import java.net.URI;
import java.security.AccessController;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class i {
    public static final FileSystem a = ((j$.nio.file.spi.c) AccessController.doPrivileged(new h())).j(URI.create("file:///"));
}
