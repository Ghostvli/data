package defpackage;

import defpackage.aa5;
import defpackage.b01;
import defpackage.es1;
import defpackage.ha;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class vs2 implements py3 {
    public final rs2 a;
    public final lw4 b;
    public final boolean c;
    public final yy0 d;

    public vs2(lw4 lw4Var, yy0 yy0Var, rs2 rs2Var) {
        this.b = lw4Var;
        this.c = yy0Var.e(rs2Var);
        this.d = yy0Var;
        this.a = rs2Var;
    }

    private int j(lw4 lw4Var, Object obj) {
        return lw4Var.i(lw4Var.g(obj));
    }

    private void k(lw4 lw4Var, yy0 yy0Var, Object obj, io3 io3Var, xy0 xy0Var) throws Throwable {
        lw4 lw4Var2;
        Object objF = lw4Var.f(obj);
        b01 b01VarD = yy0Var.d(obj);
        while (io3Var.A() != Integer.MAX_VALUE) {
            try {
                vs2 vs2Var = this;
                lw4Var2 = lw4Var;
                yy0 yy0Var2 = yy0Var;
                io3 io3Var2 = io3Var;
                xy0 xy0Var2 = xy0Var;
                try {
                    if (!vs2Var.m(io3Var2, xy0Var2, yy0Var2, b01VarD, lw4Var2, objF)) {
                        lw4Var2.o(obj, objF);
                        return;
                    }
                    this = vs2Var;
                    io3Var = io3Var2;
                    xy0Var = xy0Var2;
                    yy0Var = yy0Var2;
                    lw4Var = lw4Var2;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    lw4Var2.o(obj, objF);
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
                lw4Var2 = lw4Var;
            }
        }
        lw4Var.o(obj, objF);
    }

    public static vs2 l(lw4 lw4Var, yy0 yy0Var, rs2 rs2Var) {
        return new vs2(lw4Var, yy0Var, rs2Var);
    }

    @Override // defpackage.py3
    public void a(Object obj, Object obj2) {
        sy3.K(this.b, obj, obj2);
        if (this.c) {
            sy3.I(this.d, obj, obj2);
        }
    }

    @Override // defpackage.py3
    public void b(Object obj) {
        this.b.j(obj);
        this.d.f(obj);
    }

    @Override // defpackage.py3
    public final boolean c(Object obj) {
        return this.d.c(obj).g();
    }

    @Override // defpackage.py3
    public void d(Object obj, io3 io3Var, xy0 xy0Var) throws Throwable {
        k(this.b, this.d, obj, io3Var, xy0Var);
    }

    @Override // defpackage.py3
    public void e(Object obj, byte[] bArr, int i, int i2, ha.a aVar) {
        i91 i91Var = (i91) obj;
        if (i91Var.unknownFields == mw4.c()) {
            i91Var.unknownFields = mw4.o();
        }
        w82.a(obj);
        throw null;
    }

    @Override // defpackage.py3
    public boolean f(Object obj, Object obj2) {
        if (!this.b.g(obj).equals(this.b.g(obj2))) {
            return false;
        }
        if (this.c) {
            return this.d.c(obj).equals(this.d.c(obj2));
        }
        return true;
    }

    @Override // defpackage.py3
    public void g(Object obj, ha5 ha5Var) {
        Iterator itH = this.d.c(obj).h();
        while (itH.hasNext()) {
            Map.Entry entry = (Map.Entry) itH.next();
            b01.a aVar = (b01.a) entry.getKey();
            if (aVar.s() != aa5.c.MESSAGE || aVar.c() || aVar.u()) {
                e04.a("Found invalid MessageSet item.");
                return;
            } else {
                if (entry instanceof es1.a) {
                    aVar.d();
                    ((es1.a) entry).a();
                    throw null;
                }
                ha5Var.d(aVar.d(), entry.getValue());
            }
        }
        n(this.b, obj, ha5Var);
    }

    @Override // defpackage.py3
    public int h(Object obj) {
        int iJ = j(this.b, obj);
        return this.c ? iJ + this.d.c(obj).d() : iJ;
    }

    @Override // defpackage.py3
    public int i(Object obj) {
        int iHashCode = this.b.g(obj).hashCode();
        return this.c ? (iHashCode * 53) + this.d.c(obj).hashCode() : iHashCode;
    }

    public final boolean m(io3 io3Var, xy0 xy0Var, yy0 yy0Var, b01 b01Var, lw4 lw4Var, Object obj) throws ol1 {
        int iA = io3Var.a();
        int iP = 0;
        if (iA != aa5.a) {
            if (aa5.b(iA) != 2) {
                return io3Var.G();
            }
            Object objB = yy0Var.b(xy0Var, this.a, aa5.a(iA));
            if (objB == null) {
                return lw4Var.m(obj, io3Var, 0);
            }
            yy0Var.h(io3Var, objB, xy0Var, b01Var);
            return true;
        }
        Object objB2 = null;
        hn hnVarD = null;
        while (io3Var.A() != Integer.MAX_VALUE) {
            int iA2 = io3Var.a();
            if (iA2 != aa5.c) {
                if (iA2 != aa5.d) {
                    if (iA2 == aa5.b || !io3Var.G()) {
                        break;
                    }
                } else if (objB2 != null) {
                    yy0Var.h(io3Var, objB2, xy0Var, b01Var);
                } else {
                    hnVarD = io3Var.D();
                }
            } else {
                iP = io3Var.p();
                objB2 = yy0Var.b(xy0Var, this.a, iP);
            }
        }
        if (io3Var.a() != aa5.b) {
            throw ol1.b();
        }
        if (hnVarD != null) {
            if (objB2 != null) {
                yy0Var.i(hnVarD, objB2, xy0Var, b01Var);
            } else {
                lw4Var.d(obj, iP, hnVarD);
            }
        }
        return true;
    }

    public final void n(lw4 lw4Var, Object obj, ha5 ha5Var) {
        lw4Var.s(lw4Var.g(obj), ha5Var);
    }

    @Override // defpackage.py3
    public Object newInstance() {
        rs2 rs2Var = this.a;
        return rs2Var instanceof i91 ? ((i91) rs2Var).newMutableInstance() : rs2Var.newBuilderForType().buildPartial();
    }
}
