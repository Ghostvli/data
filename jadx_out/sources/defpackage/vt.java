package defpackage;

import defpackage.yz3;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class vt {
    public final gf a;
    public final gr4 b;
    public final int c;
    public final int d;
    public final long e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public long l;
    public long[] m;
    public int[] n;

    public vt(int i, gf gfVar, gr4 gr4Var) {
        this.a = gfVar;
        int iB = gfVar.b();
        boolean z = true;
        if (iB != 1 && iB != 2) {
            z = false;
        }
        gg3.d(z);
        this.c = d(i, iB == 2 ? 1667497984 : 1651965952);
        this.e = gfVar.a();
        this.b = gr4Var;
        this.d = iB == 2 ? d(i, 1650720768) : -1;
        this.l = -1L;
        this.m = new long[512];
        this.n = new int[512];
        this.f = gfVar.e;
    }

    public static int d(int i, int i2) {
        return (((i % 10) + 48) << 8) | ((i / 10) + 48) | i2;
    }

    public void a() {
        this.i++;
    }

    public void b(long j, boolean z) {
        if (this.l == -1) {
            this.l = j;
        }
        if (z) {
            if (this.k == this.n.length) {
                long[] jArr = this.m;
                this.m = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
                int[] iArr = this.n;
                this.n = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
            }
            long[] jArr2 = this.m;
            int i = this.k;
            jArr2[i] = j;
            this.n[i] = this.j;
            this.k = i + 1;
        }
        this.j++;
    }

    public void c() {
        int i;
        this.m = Arrays.copyOf(this.m, this.k);
        this.n = Arrays.copyOf(this.n, this.k);
        if (!k() || this.a.g == 0 || (i = this.k) <= 0) {
            return;
        }
        this.f = i;
    }

    public final long e(int i) {
        return (this.e * ((long) i)) / ((long) this.f);
    }

    public long f() {
        return e(this.i);
    }

    public long g() {
        return e(1);
    }

    public final a04 h(int i) {
        return new a04(((long) this.n[i]) * g(), this.m[i]);
    }

    public yz3.a i(long j) {
        if (this.k == 0) {
            return new yz3.a(new a04(0L, this.l));
        }
        int iG = (int) (j / g());
        int iJ = fy4.j(this.n, iG, true, true);
        if (this.n[iJ] == iG) {
            return new yz3.a(h(iJ));
        }
        a04 a04VarH = h(iJ);
        int i = iJ + 1;
        return i < this.m.length ? new yz3.a(a04VarH, h(i)) : new yz3.a(a04VarH);
    }

    public boolean j(int i) {
        return this.c == i || this.d == i;
    }

    public boolean k() {
        return (this.c & 1651965952) == 1651965952;
    }

    public boolean l() {
        return Arrays.binarySearch(this.n, this.i) >= 0;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public boolean m(jz0 jz0Var) {
        int i = this.h;
        int iD = i - this.b.d(jz0Var, i, false);
        this.h = iD;
        boolean z = iD == 0;
        if (z) {
            if (this.g > 0) {
                this.b.b(f(), l() ? 1 : 0, this.g, 0, null);
            }
            a();
        }
        return z;
    }

    public void n(int i) {
        this.g = i;
        this.h = i;
    }

    public void o(long j) {
        if (this.k == 0) {
            this.i = 0;
        } else {
            this.i = this.n[fy4.k(this.m, j, true, true)];
        }
    }
}
