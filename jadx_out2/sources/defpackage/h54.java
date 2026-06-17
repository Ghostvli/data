package defpackage;

import android.graphics.Path;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class h54 extends zh {
    public final b54 i;
    public final Path j;
    public Path k;
    public Path l;
    public List m;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public h54(List list) {
        super(list);
        this.i = new b54();
        this.j = new Path();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.zh
    public boolean p() {
        List list = this.m;
        return (list == null || list.isEmpty()) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: i(Ldr1;F)Ljava/lang/Object; */
    @Override // defpackage.zh
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public Path i(dr1 dr1Var, float f) {
        b54 b54Var = (b54) dr1Var.b;
        b54 b54Var2 = (b54) dr1Var.c;
        this.i.c(b54Var, b54Var2 == null ? b54Var : b54Var2, f);
        b54 b54VarC = this.i;
        List list = this.m;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                b54VarC = ((j54) this.m.get(size)).c(b54VarC);
            }
        }
        ot2.h(b54VarC, this.j);
        if (this.e == null) {
            return this.j;
        }
        if (this.k == null) {
            this.k = new Path();
            this.l = new Path();
        }
        ot2.h(b54Var, this.k);
        if (b54Var2 != null) {
            ot2.h(b54Var2, this.l);
        }
        y22 y22Var = this.e;
        float f2 = dr1Var.g;
        float fFloatValue = dr1Var.h.floatValue();
        Path path = this.k;
        return (Path) y22Var.b(f2, fFloatValue, path, b54Var2 == null ? path : this.l, f, e(), f());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void s(List list) {
        this.m = list;
    }
}
