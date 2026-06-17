package defpackage;

import defpackage.no4;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class bf3 extends v {
    public final int h;
    public final int i;
    public final int[] j;
    public final int[] k;
    public final no4[] l;
    public final Object[] m;
    public final HashMap n;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends i51 {
        public final no4.d f;

        public a(no4 no4Var) {
            super(no4Var);
            this.f = new no4.d();
        }

        @Override // defpackage.i51, defpackage.no4
        public no4.b m(int i, no4.b bVar, boolean z) {
            no4.b bVarM = super.m(i, bVar, z);
            if (super.t(bVarM.c, this.f).g()) {
                bVarM.v(bVar.a, bVar.b, bVar.c, bVar.d, bVar.e, x3.g, true);
                return bVarM;
            }
            bVarM.f = true;
            return bVarM;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bf3(no4[] no4VarArr, Object[] objArr, o64 o64Var) {
        super(false, o64Var);
        int i = 0;
        int length = no4VarArr.length;
        this.l = no4VarArr;
        this.j = new int[length];
        this.k = new int[length];
        this.m = objArr;
        this.n = new HashMap();
        int length2 = no4VarArr.length;
        int iV = 0;
        int iO = 0;
        int i2 = 0;
        while (i < length2) {
            no4 no4Var = no4VarArr[i];
            this.l[i2] = no4Var;
            this.k[i2] = iV;
            this.j[i2] = iO;
            iV += no4Var.v();
            iO += this.l[i2].o();
            this.n.put(objArr[i2], Integer.valueOf(i2));
            i++;
            i2++;
        }
        this.h = iV;
        this.i = iO;
    }

    public static no4[] N(Collection collection) {
        no4[] no4VarArr = new no4[collection.size()];
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            no4VarArr[i] = ((uq2) it.next()).b();
            i++;
        }
        return no4VarArr;
    }

    public static Object[] O(Collection collection) {
        Object[] objArr = new Object[collection.size()];
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            objArr[i] = ((uq2) it.next()).a();
            i++;
        }
        return objArr;
    }

    @Override // defpackage.v
    public int A(int i) {
        return fy4.j(this.j, i + 1, false, false);
    }

    @Override // defpackage.v
    public int B(int i) {
        return fy4.j(this.k, i + 1, false, false);
    }

    @Override // defpackage.v
    public Object E(int i) {
        return this.m[i];
    }

    @Override // defpackage.v
    public int G(int i) {
        return this.j[i];
    }

    @Override // defpackage.v
    public int H(int i) {
        return this.k[i];
    }

    @Override // defpackage.v
    public no4 K(int i) {
        return this.l[i];
    }

    public bf3 L(o64 o64Var) {
        no4[] no4VarArr = new no4[this.l.length];
        int i = 0;
        while (true) {
            no4[] no4VarArr2 = this.l;
            if (i >= no4VarArr2.length) {
                return new bf3(no4VarArr, this.m, o64Var);
            }
            no4VarArr[i] = new a(no4VarArr2[i]);
            i++;
        }
    }

    public List M() {
        return Arrays.asList(this.l);
    }

    @Override // defpackage.no4
    public int o() {
        return this.i;
    }

    @Override // defpackage.no4
    public int v() {
        return this.h;
    }

    @Override // defpackage.v
    public int z(Object obj) {
        Integer num = (Integer) this.n.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public bf3(Collection collection, o64 o64Var) {
        this(N(collection), O(collection), o64Var);
    }
}
