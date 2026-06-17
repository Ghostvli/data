package defpackage;

import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class xx {
    public final Object a;
    public final np b;
    public final Function3 c;
    public final Object d;
    public final Throwable e;

    public /* synthetic */ xx(Object obj, np npVar, Function3 function3, Object obj2, Throwable th, int i, we0 we0Var) {
        this(obj, (i & 2) != 0 ? null : npVar, (i & 4) != 0 ? null : function3, (i & 8) != 0 ? null : obj2, (i & 16) != 0 ? null : th);
    }

    public static /* synthetic */ xx b(xx xxVar, Object obj, np npVar, Function3 function3, Object obj2, Throwable th, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = xxVar.a;
        }
        if ((i & 2) != 0) {
            npVar = xxVar.b;
        }
        if ((i & 4) != 0) {
            function3 = xxVar.c;
        }
        if ((i & 8) != 0) {
            obj2 = xxVar.d;
        }
        if ((i & 16) != 0) {
            th = xxVar.e;
        }
        Throwable th2 = th;
        Function3 function32 = function3;
        return xxVar.a(obj, npVar, function32, obj2, th2);
    }

    public final xx a(Object obj, np npVar, Function3 function3, Object obj2, Throwable th) {
        return new xx(obj, npVar, function3, obj2, th);
    }

    public final boolean c() {
        return this.e != null;
    }

    public final void d(sp spVar, Throwable th) {
        np npVar = this.b;
        if (npVar != null) {
            spVar.p(npVar, th);
        }
        Function3 function3 = this.c;
        if (function3 != null) {
            spVar.q(function3, th, this.a);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xx)) {
            return false;
        }
        xx xxVar = (xx) obj;
        return il1.a(this.a, xxVar.a) && il1.a(this.b, xxVar.b) && il1.a(this.c, xxVar.c) && il1.a(this.d, xxVar.d) && il1.a(this.e, xxVar.e);
    }

    public int hashCode() {
        Object obj = this.a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        np npVar = this.b;
        int iHashCode2 = (iHashCode + (npVar == null ? 0 : npVar.hashCode())) * 31;
        Function3 function3 = this.c;
        int iHashCode3 = (iHashCode2 + (function3 == null ? 0 : function3.hashCode())) * 31;
        Object obj2 = this.d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.a + ", cancelHandler=" + this.b + ", onCancellation=" + this.c + ", idempotentResume=" + this.d + ", cancelCause=" + this.e + ')';
    }

    public xx(Object obj, np npVar, Function3 function3, Object obj2, Throwable th) {
        this.a = obj;
        this.b = npVar;
        this.c = function3;
        this.d = obj2;
        this.e = th;
    }
}
