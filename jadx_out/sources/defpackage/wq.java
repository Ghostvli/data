package defpackage;

import com.fongmi.android.tv.bean.Config;
import com.fongmi.android.tv.bean.Device;
import com.fongmi.android.tv.bean.History;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class wq extends to3 {
    public final Config a;
    public final Device b;
    public final History c;

    public wq(Config config, Device device, History history) {
        this.a = config;
        this.b = device;
        this.c = history;
    }

    private /* synthetic */ boolean a(Object obj) {
        if (!(obj instanceof wq)) {
            return false;
        }
        wq wqVar = (wq) obj;
        return Objects.equals(this.a, wqVar.a) && Objects.equals(this.b, wqVar.b) && Objects.equals(this.c, wqVar.c);
    }

    private /* synthetic */ Object[] b() {
        return new Object[]{this.a, this.b, this.c};
    }

    public static void f(Config config, Device device, History history) {
        uu0.d().l(new wq(config, device, history));
    }

    public Config c() {
        return this.a;
    }

    public Device d() {
        return this.b;
    }

    public History e() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        return a(obj);
    }

    public final int hashCode() {
        return vq.a(this.a, this.b, this.c);
    }

    public final String toString() {
        return yq.a(b(), wq.class, "a;b;c");
    }
}
