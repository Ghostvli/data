package defpackage;

import defpackage.l42;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class o42 implements n42 {
    public static int i(int i, Object obj, Object obj2) {
        m42 m42Var = (m42) obj;
        w82.a(obj2);
        if (m42Var.isEmpty()) {
            return 0;
        }
        Iterator it = m42Var.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    public static m42 j(Object obj, Object obj2) {
        m42 m42VarK = (m42) obj;
        m42 m42Var = (m42) obj2;
        if (!m42Var.isEmpty()) {
            if (!m42VarK.h()) {
                m42VarK = m42VarK.k();
            }
            m42VarK.j(m42Var);
        }
        return m42VarK;
    }

    @Override // defpackage.n42
    public Object a(Object obj, Object obj2) {
        return j(obj, obj2);
    }

    @Override // defpackage.n42
    public Object b(Object obj) {
        ((m42) obj).i();
        return obj;
    }

    @Override // defpackage.n42
    public l42.a c(Object obj) {
        w82.a(obj);
        throw null;
    }

    @Override // defpackage.n42
    public Map d(Object obj) {
        return (m42) obj;
    }

    @Override // defpackage.n42
    public Object e(Object obj) {
        return m42.d().k();
    }

    @Override // defpackage.n42
    public int f(int i, Object obj, Object obj2) {
        return i(i, obj, obj2);
    }

    @Override // defpackage.n42
    public boolean g(Object obj) {
        return !((m42) obj).h();
    }

    @Override // defpackage.n42
    public Map h(Object obj) {
        return (m42) obj;
    }
}
