package j$.io;

import j$.nio.file.Path;
import j$.nio.file.i;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class FileRetargetClass {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Path toPath(File file) {
        return i.a.getPath(file.getPath(), new String[0]);
    }
}
