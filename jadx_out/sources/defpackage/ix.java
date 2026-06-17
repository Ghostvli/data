package defpackage;

import defpackage.g40;
import java.io.Serializable;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class ix implements g40, Serializable {
    public final g40 f;
    public final g40.b g;

    public ix(g40 g40Var, g40.b bVar) {
        g40Var.getClass();
        bVar.getClass();
        this.f = g40Var;
        this.g = bVar;
    }

    public static String b(String str, g40.b bVar) {
        str.getClass();
        bVar.getClass();
        if (str.length() == 0) {
            return bVar.toString();
        }
        return str + ", " + bVar;
    }

    private final int f() {
        int i = 2;
        while (true) {
            g40 g40Var = this.f;
            this = g40Var instanceof ix ? (ix) g40Var : null;
            if (this == null) {
                return i;
            }
            i++;
        }
    }

    @Override // defpackage.g40
    public g40 B(g40.c cVar) {
        cVar.getClass();
        g40.b bVarA = this.g.a(cVar);
        g40 g40Var = this.f;
        if (bVarA != null) {
            return g40Var;
        }
        g40 g40VarB = g40Var.B(cVar);
        if (g40VarB == this.f) {
            return this;
        }
        bs0 bs0Var = bs0.f;
        g40.b bVar = this.g;
        return g40VarB == bs0Var ? bVar : new ix(g40VarB, bVar);
    }

    @Override // defpackage.g40
    public /* bridge */ g40 N(g40 g40Var) {
        return g40.a.b(this, g40Var);
    }

    @Override // defpackage.g40
    public Object T(Object obj, Function2 function2) {
        function2.getClass();
        return function2.invoke(this.f.T(obj, function2), this.g);
    }

    @Override // defpackage.g40
    public g40.b a(g40.c cVar) {
        cVar.getClass();
        while (true) {
            g40.b bVarA = this.g.a(cVar);
            if (bVarA != null) {
                return bVarA;
            }
            g40 g40Var = this.f;
            if (!(g40Var instanceof ix)) {
                return g40Var.a(cVar);
            }
            this = (ix) g40Var;
        }
    }

    public final boolean d(g40.b bVar) {
        return il1.a(a(bVar.getKey()), bVar);
    }

    public final boolean e(ix ixVar) {
        while (d(ixVar.g)) {
            g40 g40Var = ixVar.f;
            if (!(g40Var instanceof ix)) {
                g40Var.getClass();
                return d((g40.b) g40Var);
            }
            ixVar = (ix) g40Var;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ix)) {
            return false;
        }
        ix ixVar = (ix) obj;
        return ixVar.f() == f() && ixVar.e(this);
    }

    public int hashCode() {
        return this.f.hashCode() + this.g.hashCode();
    }

    public String toString() {
        return "[" + ((String) T("", new Function2() { // from class: hx
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ix.b((String) obj, (g40.b) obj2);
            }
        })) + ']';
    }
}
