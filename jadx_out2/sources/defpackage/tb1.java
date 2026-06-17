package defpackage;

import android.util.Pair;
import defpackage.t41;
import defpackage.wt4;
import java.util.Arrays;
import java.util.Collections;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class tb1 implements cr0 {
    public static final double[] r = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    public String a;
    public gr4 b;
    public final sx4 c;
    public final String d;
    public final r73 e;
    public final cx2 f;
    public final boolean[] g;
    public final a h;
    public long i;
    public boolean j;
    public boolean k;
    public long l;
    public long m;
    public long n;
    public long o;
    public boolean p;
    public boolean q;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public static final byte[] e = {0, 0, 1};
        public boolean a;
        public int b;
        public int c;
        public byte[] d;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(int i) {
            this.d = new byte[i];
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a(byte[] bArr, int i, int i2) {
            if (this.a) {
                int i3 = i2 - i;
                byte[] bArr2 = this.d;
                int length = bArr2.length;
                int i4 = this.b;
                if (length < i4 + i3) {
                    this.d = Arrays.copyOf(bArr2, (i4 + i3) * 2);
                }
                System.arraycopy(bArr, i, this.d, this.b, i3);
                this.b += i3;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean b(int i, int i2) {
            if (this.a) {
                int i3 = this.b - i2;
                this.b = i3;
                if (this.c != 0 || i != 181) {
                    this.a = false;
                    return true;
                }
                this.c = i3;
            } else if (i == 179) {
                this.a = true;
            }
            byte[] bArr = e;
            a(bArr, 0, bArr.length);
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void c() {
            this.a = false;
            this.b = 0;
            this.c = 0;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public tb1(sx4 sx4Var, String str) {
        this.c = sx4Var;
        this.d = str;
        this.g = new boolean[4];
        this.h = new a(128);
        if (sx4Var != null) {
            this.f = new cx2(Token.ARROW, 128);
            this.e = new r73();
        } else {
            this.f = null;
            this.e = null;
        }
        this.m = -9223372036854775807L;
        this.o = -9223372036854775807L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair b(a aVar, String str, String str2) {
        float f;
        int i;
        float f2;
        int i2;
        long j;
        byte[] bArrCopyOf = Arrays.copyOf(aVar.d, aVar.b);
        int i3 = bArrCopyOf[4] & 255;
        byte b = bArrCopyOf[5];
        int i4 = (i3 << 4) | ((b & 255) >> 4);
        int i5 = ((b & 15) << 8) | (bArrCopyOf[6] & 255);
        int i6 = (bArrCopyOf[7] & 240) >> 4;
        if (i6 == 2) {
            f = i5 * 4;
            i = i4 * 3;
        } else if (i6 == 3) {
            f = i5 * 16;
            i = i4 * 9;
        } else {
            if (i6 != 4) {
                f2 = 1.0f;
                t41 t41VarQ = new t41.b().k0(str).X(str2).A0("video/mpeg2").H0(i4).i0(i5).v0(f2).l0(Collections.singletonList(bArrCopyOf)).Q();
                i2 = (bArrCopyOf[7] & 15) - 1;
                if (i2 < 0) {
                    double[] dArr = r;
                    if (i2 < dArr.length) {
                        double d = dArr[i2];
                        byte b2 = bArrCopyOf[aVar.c + 9];
                        int i7 = (b2 & 96) >> 5;
                        int i8 = b2 & 31;
                        if (i7 != i8) {
                            d *= (((double) i7) + 1.0d) / ((double) (i8 + 1));
                        }
                        j = (long) (1000000.0d / d);
                    } else {
                        j = 0;
                    }
                }
                return Pair.create(t41VarQ, Long.valueOf(j));
            }
            f = i5 * Token.DOT;
            i = i4 * 100;
        }
        f2 = f / i;
        t41 t41VarQ2 = new t41.b().k0(str).X(str2).A0("video/mpeg2").H0(i4).i0(i5).v0(f2).l0(Collections.singletonList(bArrCopyOf)).Q();
        i2 = (bArrCopyOf[7] & 15) - 1;
        if (i2 < 0) {
        }
        return Pair.create(t41VarQ2, Long.valueOf(j));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0144  */
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
    @Override // defpackage.cr0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(r73 r73Var) {
        int i;
        long j;
        boolean z;
        int i2;
        gg3.q(this.b);
        int iG = r73Var.g();
        int iJ = r73Var.j();
        byte[] bArrF = r73Var.f();
        this.i += (long) r73Var.a();
        this.b.a(r73Var, r73Var.a());
        while (true) {
            int iE = dx2.e(bArrF, iG, iJ, this.g);
            if (iE == iJ) {
                break;
            }
            int i3 = iE + 3;
            int i4 = r73Var.f()[i3] & 255;
            int i5 = iE - iG;
            if (!this.k) {
                if (i5 > 0) {
                    this.h.a(bArrF, iG, iE);
                }
                if (this.h.b(i4, i5 < 0 ? -i5 : 0)) {
                    Pair pairB = b(this.h, (String) gg3.q(this.a), this.d);
                    this.b.g((t41) pairB.first);
                    this.l = ((Long) pairB.second).longValue();
                    this.k = true;
                }
            }
            cx2 cx2Var = this.f;
            if (cx2Var != null) {
                if (i5 > 0) {
                    cx2Var.a(bArrF, iG, iE);
                    i2 = 0;
                } else {
                    i2 = -i5;
                }
                if (this.f.b(i2)) {
                    cx2 cx2Var2 = this.f;
                    ((r73) fy4.l(this.e)).d0(this.f.d, dx2.M(cx2Var2.d, cx2Var2.e));
                    ((sx4) fy4.l(this.c)).b(this.o, this.e);
                }
                if (i4 == 178 && r73Var.f()[iE + 2] == 1) {
                    this.f.e(i4);
                }
            }
            if (i4 == 0 || i4 == 179) {
                int i6 = iJ - iE;
                if (this.q && this.k) {
                    long j2 = this.o;
                    if (j2 != -9223372036854775807L) {
                        i = iJ;
                        this.b.b(j2, this.p ? 1 : 0, ((int) (this.i - this.n)) - i6, i6, null);
                    }
                    if (this.j) {
                        this.n = this.i - ((long) i6);
                        j = this.m;
                        if (j == -9223372036854775807L) {
                        }
                        this.o = j;
                        this.p = false;
                        this.m = -9223372036854775807L;
                        z = true;
                        this.j = true;
                        this.q = i4 == 0 ? z : false;
                    }
                } else {
                    i = iJ;
                    if (this.j || this.q) {
                        this.n = this.i - ((long) i6);
                        j = this.m;
                        if (j == -9223372036854775807L) {
                            long j3 = this.o;
                            j = j3 != -9223372036854775807L ? j3 + this.l : -9223372036854775807L;
                        }
                        this.o = j;
                        this.p = false;
                        this.m = -9223372036854775807L;
                        z = true;
                        this.j = true;
                    } else {
                        z = true;
                    }
                    this.q = i4 == 0 ? z : false;
                }
            } else {
                if (i4 == 184) {
                    this.p = true;
                }
                i = iJ;
            }
            iJ = i;
            iG = i3;
        }
        if (!this.k) {
            this.h.a(bArrF, iG, iJ);
        }
        cx2 cx2Var3 = this.f;
        if (cx2Var3 != null) {
            cx2Var3.a(bArrF, iG, iJ);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cr0
    public void c() {
        dx2.c(this.g);
        this.h.c();
        cx2 cx2Var = this.f;
        if (cx2Var != null) {
            cx2Var.d();
        }
        this.i = 0L;
        this.j = false;
        this.m = -9223372036854775807L;
        this.o = -9223372036854775807L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
    @Override // defpackage.cr0
    public void d(boolean z) {
        gg3.q(this.b);
        if (z) {
            boolean z2 = this.p;
            this.b.b(this.o, z2 ? 1 : 0, (int) (this.i - this.n), 0, null);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cr0
    public void e(long j, int i) {
        this.m = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cr0
    public void f(mz0 mz0Var, wt4.d dVar) {
        dVar.a();
        this.a = dVar.b();
        this.b = mz0Var.e(dVar.c(), 2);
        sx4 sx4Var = this.c;
        if (sx4Var != null) {
            sx4Var.c(mz0Var, dVar);
        }
    }

    public tb1(String str) {
        this(null, str);
    }
}
