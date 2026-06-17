package defpackage;

import android.view.View;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class e71 {
    public static final e71 a;
    public static final g71 b;
    public static final g71 c;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        e71 e71Var = new e71();
        a = e71Var;
        b = new f71();
        c = e71Var.b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void a(p51 p51Var, p51 p51Var2, boolean z, la laVar, boolean z2) {
        p51Var.getClass();
        p51Var2.getClass();
        laVar.getClass();
        if (z) {
            p51Var2.X();
        } else {
            p51Var.X();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Move duplicate insns, count: 1 to block B:3:0x000c */
    public static final void c(la laVar, la laVar2) {
        laVar.getClass();
        laVar2.getClass();
        int size = laVar.size();
        while (true) {
            size--;
            if (-1 >= size) {
                return;
            }
            if (!laVar2.containsKey((String) laVar.j(size))) {
                laVar.h(size);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void d(List list, int i) {
        list.getClass();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setVisibility(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final g71 b() {
        try {
            return (g71) i71.class.getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
