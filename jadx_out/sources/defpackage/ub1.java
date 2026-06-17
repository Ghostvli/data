package defpackage;

import defpackage.t41;
import defpackage.wt4;
import java.util.Arrays;
import java.util.Collections;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ub1 implements cr0 {
    public static final float[] m = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};
    public final sx4 a;
    public final String b;
    public final r73 c;
    public final cx2 f;
    public b g;
    public long h;
    public String i;
    public gr4 j;
    public boolean k;
    public final boolean[] d = new boolean[4];
    public final a e = new a(128);
    public long l = -9223372036854775807L;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public static final byte[] f = {0, 0, 1};
        public boolean a;
        public int b;
        public int c;
        public int d;
        public byte[] e;

        public a(int i) {
            this.e = new byte[i];
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.a) {
                int i3 = i2 - i;
                byte[] bArr2 = this.e;
                int length = bArr2.length;
                int i4 = this.c;
                if (length < i4 + i3) {
                    this.e = Arrays.copyOf(bArr2, (i4 + i3) * 2);
                }
                System.arraycopy(bArr, i, this.e, this.c, i3);
                this.c += i3;
            }
        }

        public boolean b(int i, int i2) {
            int i3 = this.b;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                z20.a();
                                return false;
                            }
                            if (i == 179 || i == 181) {
                                this.c -= i2;
                                this.a = false;
                                return true;
                            }
                        } else if ((i & 240) != 32) {
                            xz1.i("H263Reader", "Unexpected start code value");
                            c();
                        } else {
                            this.d = this.c;
                            this.b = 4;
                        }
                    } else if (i > 31) {
                        xz1.i("H263Reader", "Unexpected start code value");
                        c();
                    } else {
                        this.b = 3;
                    }
                } else if (i != 181) {
                    xz1.i("H263Reader", "Unexpected start code value");
                    c();
                } else {
                    this.b = 2;
                }
            } else if (i == 176) {
                this.b = 1;
                this.a = true;
            }
            byte[] bArr = f;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.a = false;
            this.c = 0;
            this.b = 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final gr4 a;
        public boolean b;
        public boolean c;
        public boolean d;
        public int e;
        public int f;
        public long g;
        public long h;

        public b(gr4 gr4Var) {
            this.a = gr4Var;
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.c) {
                int i3 = this.f;
                int i4 = (i + 1) - i3;
                if (i4 >= i2) {
                    this.f = i3 + (i2 - i);
                } else {
                    this.d = ((bArr[i4] & 192) >> 6) == 0;
                    this.c = false;
                }
            }
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
        public void b(long j, int i, boolean z) {
            gg3.v(this.h != -9223372036854775807L);
            if (this.e == 182 && z && this.b) {
                this.a.b(this.h, this.d ? 1 : 0, (int) (j - this.g), i, null);
            }
            if (this.e != 179) {
                this.g = j;
            }
        }

        public void c(int i, long j) {
            this.e = i;
            this.d = false;
            this.b = i == 182 || i == 179;
            this.c = i == 182;
            this.f = 0;
            this.h = j;
        }

        public void d() {
            this.b = false;
            this.c = false;
            this.d = false;
            this.e = -1;
        }
    }

    public ub1(sx4 sx4Var, String str) {
        this.a = sx4Var;
        this.b = str;
        if (sx4Var != null) {
            this.f = new cx2(Token.ARROW, 128);
            this.c = new r73();
        } else {
            this.f = null;
            this.c = null;
        }
    }

    public static t41 b(a aVar, int i, String str, String str2) {
        byte[] bArrCopyOf = Arrays.copyOf(aVar.e, aVar.c);
        q73 q73Var = new q73(bArrCopyOf);
        q73Var.s(i);
        q73Var.s(4);
        q73Var.q();
        q73Var.r(8);
        if (q73Var.g()) {
            q73Var.r(4);
            q73Var.r(3);
        }
        int iH = q73Var.h(4);
        float f = 1.0f;
        if (iH == 15) {
            int iH2 = q73Var.h(8);
            int iH3 = q73Var.h(8);
            if (iH3 == 0) {
                xz1.i("H263Reader", "Invalid aspect ratio");
            } else {
                f = iH2 / iH3;
            }
        } else {
            float[] fArr = m;
            if (iH < fArr.length) {
                f = fArr[iH];
            } else {
                xz1.i("H263Reader", "Invalid aspect ratio");
            }
        }
        if (q73Var.g()) {
            q73Var.r(2);
            q73Var.r(1);
            if (q73Var.g()) {
                q73Var.r(15);
                q73Var.q();
                q73Var.r(15);
                q73Var.q();
                q73Var.r(15);
                q73Var.q();
                q73Var.r(3);
                q73Var.r(11);
                q73Var.q();
                q73Var.r(15);
                q73Var.q();
            }
        }
        if (q73Var.h(2) != 0) {
            xz1.i("H263Reader", "Unhandled video object layer shape");
        }
        q73Var.q();
        int iH4 = q73Var.h(16);
        q73Var.q();
        if (q73Var.g()) {
            if (iH4 == 0) {
                xz1.i("H263Reader", "Invalid vop_increment_time_resolution");
            } else {
                int i2 = 0;
                for (int i3 = iH4 - 1; i3 > 0; i3 >>= 1) {
                    i2++;
                }
                q73Var.r(i2);
            }
        }
        q73Var.q();
        int iH5 = q73Var.h(13);
        q73Var.q();
        int iH6 = q73Var.h(13);
        q73Var.q();
        q73Var.q();
        return new t41.b().k0(str).X(str2).A0("video/mp4v-es").H0(iH5).i0(iH6).v0(f).l0(Collections.singletonList(bArrCopyOf)).Q();
    }

    @Override // defpackage.cr0
    public void a(r73 r73Var) {
        gg3.q(this.g);
        gg3.q(this.j);
        int iG = r73Var.g();
        int iJ = r73Var.j();
        byte[] bArrF = r73Var.f();
        this.h += (long) r73Var.a();
        this.j.a(r73Var, r73Var.a());
        while (true) {
            int iE = dx2.e(bArrF, iG, iJ, this.d);
            if (iE == iJ) {
                break;
            }
            int i = iE + 3;
            int i2 = r73Var.f()[i] & 255;
            int i3 = iE - iG;
            int i4 = 0;
            if (!this.k) {
                if (i3 > 0) {
                    this.e.a(bArrF, iG, iE);
                }
                if (this.e.b(i2, i3 < 0 ? -i3 : 0)) {
                    gr4 gr4Var = this.j;
                    a aVar = this.e;
                    gr4Var.g(b(aVar, aVar.d, (String) gg3.q(this.i), this.b));
                    this.k = true;
                }
            }
            this.g.a(bArrF, iG, iE);
            cx2 cx2Var = this.f;
            if (cx2Var != null) {
                if (i3 > 0) {
                    cx2Var.a(bArrF, iG, iE);
                } else {
                    i4 = -i3;
                }
                if (this.f.b(i4)) {
                    cx2 cx2Var2 = this.f;
                    ((r73) fy4.l(this.c)).d0(this.f.d, dx2.M(cx2Var2.d, cx2Var2.e));
                    ((sx4) fy4.l(this.a)).b(this.l, this.c);
                }
                if (i2 == 178 && r73Var.f()[iE + 2] == 1) {
                    this.f.e(i2);
                }
            }
            int i5 = iJ - iE;
            this.g.b(this.h - ((long) i5), i5, this.k);
            this.g.c(i2, this.l);
            iG = i;
        }
        if (!this.k) {
            this.e.a(bArrF, iG, iJ);
        }
        this.g.a(bArrF, iG, iJ);
        cx2 cx2Var3 = this.f;
        if (cx2Var3 != null) {
            cx2Var3.a(bArrF, iG, iJ);
        }
    }

    @Override // defpackage.cr0
    public void c() {
        dx2.c(this.d);
        this.e.c();
        b bVar = this.g;
        if (bVar != null) {
            bVar.d();
        }
        cx2 cx2Var = this.f;
        if (cx2Var != null) {
            cx2Var.d();
        }
        this.h = 0L;
        this.l = -9223372036854775807L;
    }

    @Override // defpackage.cr0
    public void d(boolean z) {
        gg3.q(this.g);
        if (z) {
            this.g.b(this.h, 0, this.k);
            this.g.d();
        }
    }

    @Override // defpackage.cr0
    public void e(long j, int i) {
        this.l = j;
    }

    @Override // defpackage.cr0
    public void f(mz0 mz0Var, wt4.d dVar) {
        dVar.a();
        this.i = dVar.b();
        gr4 gr4VarE = mz0Var.e(dVar.c(), 2);
        this.j = gr4VarE;
        this.g = new b(gr4VarE);
        sx4 sx4Var = this.a;
        if (sx4Var != null) {
            sx4Var.c(mz0Var, dVar);
        }
    }
}
