package defpackage;

import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class bz4 extends zh {
    public final Object i;

    public bz4(y22 y22Var, Object obj) {
        super(Collections.EMPTY_LIST);
        o(y22Var);
        this.i = obj;
    }

    @Override // defpackage.zh
    public float c() {
        return 1.0f;
    }

    @Override // defpackage.zh
    public Object h() {
        y22 y22Var = this.e;
        Object obj = this.i;
        return y22Var.b(0.0f, 0.0f, obj, obj, f(), f(), f());
    }

    @Override // defpackage.zh
    public Object i(dr1 dr1Var, float f) {
        return h();
    }

    @Override // defpackage.zh
    public void l() {
        if (this.e != null) {
            super.l();
        }
    }

    @Override // defpackage.zh
    public void n(float f) {
        this.d = f;
    }

    public bz4(y22 y22Var) {
        this(y22Var, null);
    }
}
