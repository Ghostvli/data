package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class ja3 {
    public static final List d = new ArrayList();
    public Object a;
    public sh4 b;
    public ja3 c;

    public ja3(Object obj, sh4 sh4Var) {
        this.a = obj;
        this.b = sh4Var;
    }

    public static ja3 a(sh4 sh4Var, Object obj) {
        List list = d;
        synchronized (list) {
            try {
                int size = list.size();
                if (size <= 0) {
                    return new ja3(obj, sh4Var);
                }
                ja3 ja3Var = (ja3) list.remove(size - 1);
                ja3Var.a = obj;
                ja3Var.b = sh4Var;
                ja3Var.c = null;
                return ja3Var;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void b(ja3 ja3Var) {
        ja3Var.a = null;
        ja3Var.b = null;
        ja3Var.c = null;
        List list = d;
        synchronized (list) {
            try {
                if (list.size() < 10000) {
                    list.add(ja3Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
