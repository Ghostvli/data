package defpackage;

import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class cb0 {
    public final Class a;
    public final List b;
    public final ns3 c;
    public final tf3 d;
    public final String e;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        yr3 a(yr3 yr3Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public cb0(Class cls, Class cls2, Class cls3, List list, ns3 ns3Var, tf3 tf3Var) {
        this.a = cls;
        this.b = list;
        this.c = ns3Var;
        this.d = tf3Var;
        this.e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public yr3 a(com.bumptech.glide.load.data.a aVar, int i, int i2, u63 u63Var, a aVar2) {
        return this.c.a(aVar2.a(b(aVar, i, i2, u63Var)), u63Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final yr3 b(com.bumptech.glide.load.data.a aVar, int i, int i2, u63 u63Var) {
        List list = (List) fg3.e((List) this.d.a());
        try {
            return c(aVar, i, i2, u63Var, list);
        } finally {
            this.d.b(list);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final yr3 c(com.bumptech.glide.load.data.a aVar, int i, int i2, u63 u63Var, List list) throws ja1 {
        int size = this.b.size();
        yr3 yr3VarB = null;
        for (int i3 = 0; i3 < size; i3++) {
            ds3 ds3Var = (ds3) this.b.get(i3);
            try {
                if (ds3Var.a(aVar.a(), u63Var)) {
                    yr3VarB = ds3Var.b(aVar.a(), i, i2, u63Var);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + ds3Var, e);
                }
                list.add(e);
            }
            if (yr3VarB != null) {
                break;
            }
        }
        if (yr3VarB != null) {
            return yr3VarB;
        }
        throw new ja1(this.e, new ArrayList(list));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "DecodePath{ dataClass=" + this.a + ", decoders=" + this.b + ", transcoder=" + this.c + '}';
    }
}
