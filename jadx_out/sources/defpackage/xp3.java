package defpackage;

import defpackage.zp3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class xp3 extends ui1 {
    public static final xp3 o = new xp3();
    public final transient Object j;
    public final transient Object[] k;
    public final transient int l;
    public final transient int m;
    public final transient xp3 n;

    public xp3(Object[] objArr, int i) {
        this.k = objArr;
        this.m = i;
        this.l = 0;
        int iN = i >= 2 ? dj1.n(i) : 0;
        this.j = zp3.r(objArr, i, iN, 0);
        this.n = new xp3(zp3.r(objArr, i, iN, 1), objArr, i, this);
    }

    @Override // defpackage.zi1
    public dj1 d() {
        return new zp3.a(this, this.k, this.l, this.m);
    }

    @Override // defpackage.zi1
    public dj1 e() {
        return new zp3.b(this, new zp3.c(this.k, this.l, this.m));
    }

    @Override // defpackage.zi1, java.util.Map
    public Object get(Object obj) {
        Object objS = zp3.s(this.j, this.k, this.m, this.l, obj);
        if (objS == null) {
            return null;
        }
        return objS;
    }

    @Override // defpackage.zi1
    public boolean h() {
        return false;
    }

    @Override // defpackage.ui1
    public ui1 q() {
        return this.n;
    }

    @Override // java.util.Map
    public int size() {
        return this.m;
    }

    public xp3() {
        this.j = null;
        this.k = new Object[0];
        this.l = 0;
        this.m = 0;
        this.n = this;
    }

    public xp3(Object obj, Object[] objArr, int i, xp3 xp3Var) {
        this.j = obj;
        this.k = objArr;
        this.l = 1;
        this.m = i;
        this.n = xp3Var;
    }
}
