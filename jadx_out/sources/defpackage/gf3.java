package defpackage;

import android.content.Context;
import android.view.PointerIcon;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class gf3 {
    public final PointerIcon a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public static PointerIcon a(Context context, int i) {
            return PointerIcon.getSystemIcon(context, i);
        }
    }

    public gf3(PointerIcon pointerIcon) {
        this.a = pointerIcon;
    }

    public static gf3 b(Context context, int i) {
        return new gf3(a.a(context, i));
    }

    public Object a() {
        return this.a;
    }
}
