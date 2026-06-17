package defpackage;

import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class rh4 {
    public final String a;
    public final ThreadMode b;
    public final Class c;
    public final int d;
    public final boolean e;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public rh4(String str, Class cls, ThreadMode threadMode, int i, boolean z) {
        this.a = str;
        this.b = threadMode;
        this.c = cls;
        this.d = i;
        this.e = z;
    }

    public rh4(String str, Class cls, ThreadMode threadMode) {
        this(str, cls, threadMode, 0, false);
    }
}
