package defpackage;

import defpackage.fn4;
import defpackage.g40;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class ln4 implements fn4 {
    public final Object f;
    public final ThreadLocal g;
    public final g40.c h;

    public ln4(Object obj, ThreadLocal threadLocal) {
        this.f = obj;
        this.g = threadLocal;
        this.h = new nn4(threadLocal);
    }

    @Override // defpackage.g40
    public g40 B(g40.c cVar) {
        return il1.a(getKey(), cVar) ? bs0.f : this;
    }

    @Override // defpackage.g40
    public g40 N(g40 g40Var) {
        return fn4.a.b(this, g40Var);
    }

    @Override // defpackage.fn4
    public void S(g40 g40Var, Object obj) {
        this.g.set(obj);
    }

    @Override // defpackage.g40
    public Object T(Object obj, Function2 function2) {
        return fn4.a.a(this, obj, function2);
    }

    @Override // defpackage.fn4
    public Object W(g40 g40Var) {
        Object obj = this.g.get();
        this.g.set(this.f);
        return obj;
    }

    @Override // g40.b, defpackage.g40
    public g40.b a(g40.c cVar) {
        if (il1.a(getKey(), cVar)) {
            return this;
        }
        return null;
    }

    @Override // g40.b
    public g40.c getKey() {
        return this.h;
    }

    public String toString() {
        return "ThreadLocal(value=" + this.f + ", threadLocal = " + this.g + ')';
    }
}
