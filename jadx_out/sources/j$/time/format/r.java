package j$.time.format;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class r implements e {
    public final j$.time.temporal.p a;
    public final g0 b;
    public final b0 c;
    public volatile j d;

    public r(j$.time.temporal.p pVar, g0 g0Var, b0 b0Var) {
        this.a = pVar;
        this.b = g0Var;
        this.c = b0Var;
    }

    @Override // j$.time.format.e
    public final int H(w wVar, CharSequence charSequence, int i) {
        b0 b0Var = this.c;
        j$.time.temporal.p pVar = this.a;
        int length = charSequence.length();
        if (i < 0 || i > length) {
            throw new IndexOutOfBoundsException();
        }
        boolean z = wVar.c;
        DateTimeFormatter dateTimeFormatter = wVar.a;
        g0 g0Var = z ? this.b : null;
        j$.time.chrono.l lVarD = wVar.d();
        Iterator itE = (lVarD == null || lVarD == j$.time.chrono.s.c) ? b0Var.e(pVar, g0Var, dateTimeFormatter.b) : b0Var.d(lVarD, pVar, g0Var, dateTimeFormatter.b);
        if (itE != null) {
            while (itE.hasNext()) {
                Map.Entry entry = (Map.Entry) itE.next();
                String str = (String) entry.getKey();
                if (wVar.h(str, 0, charSequence, i, str.length())) {
                    return wVar.g(this.a, ((Long) entry.getValue()).longValue(), i, str.length() + i);
                }
            }
            if (pVar == j$.time.temporal.a.ERA && !wVar.c) {
                Iterator it = lVarD.G().iterator();
                while (it.hasNext()) {
                    String string = ((j$.time.chrono.m) it.next()).toString();
                    if (wVar.h(string, 0, charSequence, i, string.length())) {
                        return wVar.g(this.a, r8.getValue(), i, string.length() + i);
                    }
                }
            }
            if (wVar.c) {
                return ~i;
            }
        }
        if (this.d == null) {
            this.d = new j(this.a, 1, 19, f0.NORMAL);
        }
        return this.d.H(wVar, charSequence, i);
    }

    public final String toString() {
        g0 g0Var = g0.FULL;
        g0 g0Var2 = this.b;
        j$.time.temporal.p pVar = this.a;
        if (g0Var2 == g0Var) {
            return "Text(" + pVar + ")";
        }
        return "Text(" + pVar + "," + g0Var2 + ")";
    }

    @Override // j$.time.format.e
    public final boolean u(y yVar, StringBuilder sb) {
        Long lA = yVar.a(this.a);
        DateTimeFormatter dateTimeFormatter = yVar.b;
        if (lA == null) {
            return false;
        }
        j$.time.chrono.l lVar = (j$.time.chrono.l) yVar.a.b(j$.time.temporal.q.b);
        String strC = (lVar == null || lVar == j$.time.chrono.s.c) ? this.c.c(this.a, lA.longValue(), this.b, dateTimeFormatter.b) : this.c.b(lVar, this.a, lA.longValue(), this.b, dateTimeFormatter.b);
        if (strC != null) {
            sb.append(strC);
            return true;
        }
        if (this.d == null) {
            this.d = new j(this.a, 1, 19, f0.NORMAL);
        }
        return this.d.u(yVar, sb);
    }
}
