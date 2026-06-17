package j$.nio.file;

import java.nio.file.WatchKey;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d0 {
    public final /* synthetic */ WatchKey a;

    public /* synthetic */ d0(WatchKey watchKey) {
        this.a = watchKey;
    }

    public static /* synthetic */ d0 a(WatchKey watchKey) {
        if (watchKey == null) {
            return null;
        }
        return new d0(watchKey);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        WatchKey watchKey = this.a;
        if (obj instanceof d0) {
            obj = ((d0) obj).a;
        }
        return watchKey.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }
}
