package defpackage;

import com.bumptech.glide.load.data.a;
import defpackage.cb0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class uy1 {
    public final Class a;
    public final tf3 b;
    public final List c;
    public final String d;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public uy1(Class cls, Class cls2, Class cls3, List list, tf3 tf3Var) {
        this.a = cls;
        this.b = tf3Var;
        this.c = (List) fg3.d(list);
        this.d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public yr3 a(a aVar, u63 u63Var, int i, int i2, cb0.a aVar2) {
        List list = (List) fg3.e((List) this.b.a());
        try {
            return b(aVar, u63Var, i, i2, aVar2, list);
        } finally {
            this.b.b(list);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final yr3 b(a aVar, u63 u63Var, int i, int i2, cb0.a aVar2, List list) throws ja1 {
        int size = this.c.size();
        yr3 yr3VarA = null;
        for (int i3 = 0; i3 < size; i3++) {
            try {
                yr3VarA = ((cb0) this.c.get(i3)).a(aVar, i, i2, u63Var, aVar2);
            } catch (ja1 e) {
                list.add(e);
            }
            if (yr3VarA != null) {
                break;
            }
        }
        if (yr3VarA != null) {
            return yr3VarA;
        }
        throw new ja1(this.d, new ArrayList(list));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.c.toArray()) + '}';
    }
}
