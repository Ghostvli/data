package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class er0 extends t33 {
    public er0() {
    }

    public er0 g(String str, String str2) {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            ((br0) it.next()).h0(str, str2);
        }
        return this;
    }

    public String j(String str) {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            br0 br0Var = (br0) it.next();
            if (br0Var.w(str)) {
                return br0Var.e(str);
            }
        }
        return "";
    }

    @Override // java.util.ArrayList
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public er0 clone() {
        er0 er0Var = new er0(size());
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            er0Var.add(((br0) it.next()).clone());
        }
        return er0Var;
    }

    public br0 l() {
        return (br0) super.b();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public br0 remove(int i) {
        return (br0) super.remove(i);
    }

    @Override // defpackage.t33
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public er0 e() {
        super.e();
        return this;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public br0 set(int i, br0 br0Var) {
        return (br0) super.set(i, br0Var);
    }

    public String p() {
        return (String) stream().map(new dr0()).collect(fg4.s(" "));
    }

    public er0(int i) {
        super(i);
    }
}
