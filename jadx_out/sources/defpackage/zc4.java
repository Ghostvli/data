package defpackage;

import android.graphics.PointF;
import defpackage.zh;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class zc4 extends zh {
    public final PointF i;
    public final PointF j;
    public final zh k;
    public final zh l;
    public y22 m;
    public y22 n;

    public zc4(zh zhVar, zh zhVar2) {
        super(Collections.EMPTY_LIST);
        this.i = new PointF();
        this.j = new PointF();
        this.k = zhVar;
        this.l = zhVar2;
        n(f());
    }

    @Override // defpackage.zh
    public void n(float f) {
        this.k.n(f);
        this.l.n(f);
        this.i.set(((Float) this.k.h()).floatValue(), ((Float) this.l.h()).floatValue());
        for (int i = 0; i < this.a.size(); i++) {
            ((zh.b) this.a.get(i)).a();
        }
    }

    @Override // defpackage.zh
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public PointF h() {
        return i(null, 0.0f);
    }

    @Override // defpackage.zh
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public PointF i(dr1 dr1Var, float f) {
        Float f2;
        dr1 dr1VarB;
        dr1 dr1VarB2;
        Float f3 = null;
        if (this.m == null || (dr1VarB2 = this.k.b()) == null) {
            f2 = null;
        } else {
            Float f4 = dr1VarB2.h;
            y22 y22Var = this.m;
            float f5 = dr1VarB2.g;
            f2 = (Float) y22Var.b(f5, f4 == null ? f5 : f4.floatValue(), (Float) dr1VarB2.b, (Float) dr1VarB2.c, this.k.d(), this.k.e(), this.k.f());
        }
        if (this.n != null && (dr1VarB = this.l.b()) != null) {
            Float f6 = dr1VarB.h;
            y22 y22Var2 = this.n;
            float f7 = dr1VarB.g;
            f3 = (Float) y22Var2.b(f7, f6 == null ? f7 : f6.floatValue(), (Float) dr1VarB.b, (Float) dr1VarB.c, this.l.d(), this.l.e(), this.l.f());
        }
        PointF pointF = this.j;
        if (f2 == null) {
            pointF.set(this.i.x, 0.0f);
        } else {
            pointF.set(f2.floatValue(), 0.0f);
        }
        PointF pointF2 = this.j;
        if (f3 == null) {
            pointF2.set(pointF2.x, this.i.y);
        } else {
            pointF2.set(pointF2.x, f3.floatValue());
        }
        return this.j;
    }

    public void t(y22 y22Var) {
        y22 y22Var2 = this.m;
        if (y22Var2 != null) {
            y22Var2.c(null);
        }
        this.m = y22Var;
        if (y22Var != null) {
            y22Var.c(this);
        }
    }

    public void u(y22 y22Var) {
        y22 y22Var2 = this.n;
        if (y22Var2 != null) {
            y22Var2.c(null);
        }
        this.n = y22Var;
        if (y22Var != null) {
            y22Var.c(this);
        }
    }
}
