package defpackage;

import android.content.res.Configuration;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class db3 {
    public final boolean a;
    public Configuration b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public db3(boolean z, Configuration configuration) {
        this(z);
        configuration.getClass();
        this.b = configuration;
    }

    public final boolean a() {
        return this.a;
    }

    public db3(boolean z) {
        this.a = z;
    }
}
