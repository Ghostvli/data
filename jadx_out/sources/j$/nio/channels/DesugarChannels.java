package j$.nio.channels;

import j$.desugar.sun.nio.fs.g;
import j$.nio.file.OpenOption;
import j$.nio.file.Path;
import j$.nio.file.attribute.FileAttribute;
import j$.nio.file.p;
import java.nio.channels.FileChannel;
import java.util.Collections;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public class DesugarChannels {
    public static FileChannel open(Path path, OpenOption... openOptionArr) {
        HashSet hashSet = new HashSet();
        Collections.addAll(hashSet, openOptionArr);
        return j$.adapter.a.a ? FileChannel.open(p.u(path), g.k(hashSet), g.w(new FileAttribute[0])) : g.y(path, hashSet);
    }
}
