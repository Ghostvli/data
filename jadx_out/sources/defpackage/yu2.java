package defpackage;

import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.dv2;
import defpackage.gr4;
import defpackage.ki4;
import defpackage.su2;
import defpackage.t41;
import defpackage.yz3;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.jupnp.support.model.dlna.DLNAProfiles;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class yu2 implements hz0 {
    public static final pz0 G = new pz0() { // from class: uu2
        @Override // defpackage.pz0
        public final hz0[] d() {
            return yu2.i();
        }
    };
    public long A;
    public mz0 B;
    public b[] C;
    public long[][] D;
    public int E;
    public iu2 F;
    public final ki4.a a;
    public final int b;
    public final boolean c;
    public final r73 d;
    public final r73 e;
    public final r73 f;
    public final r73 g;
    public final ArrayDeque h;
    public final c04 i;
    public final List j;
    public xi1 k;
    public int l;
    public int m;
    public long n;
    public int o;
    public r73 p;
    public int q;
    public int r;
    public int s;
    public int t;
    public boolean u;
    public boolean v;
    public boolean w;
    public long x;
    public boolean y;
    public boolean z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements yz3 {
        public final long a;
        public final b[] b;
        public final int c;

        public a(long j, b[] bVarArr, int i) {
            this.a = j;
            this.b = bVarArr;
            this.c = i;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0089  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x008f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public yz3.a b(long r17, int r19) {
            /*
                r16 = this;
                r0 = r16
                r1 = r17
                r3 = r19
                yu2$b[] r4 = r0.b
                int r5 = r4.length
                if (r5 != 0) goto L13
                yz3$a r0 = new yz3$a
                a04 r1 = defpackage.a04.c
                r0.<init>(r1)
                return r0
            L13:
                r5 = -1
                if (r3 == r5) goto L18
                r6 = r3
                goto L1a
            L18:
                int r6 = r0.c
            L1a:
                r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
                r9 = -1
                if (r6 == r5) goto L58
                r4 = r4[r6]
                hr4 r4 = r4.b
                int r6 = defpackage.yu2.l(r4, r1)
                if (r6 != r5) goto L35
                yz3$a r0 = new yz3$a
                a04 r1 = defpackage.a04.c
                r0.<init>(r1)
                return r0
            L35:
                long[] r11 = r4.f
                r12 = r11[r6]
                long[] r11 = r4.c
                r14 = r11[r6]
                int r11 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
                if (r11 >= 0) goto L5e
                int r11 = r4.b
                int r11 = r11 + (-1)
                if (r6 >= r11) goto L5e
                int r1 = r4.b(r1)
                if (r1 == r5) goto L5e
                if (r1 == r6) goto L5e
                long[] r2 = r4.f
                r9 = r2[r1]
                long[] r2 = r4.c
                r1 = r2[r1]
                goto L60
            L58:
                r14 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r12 = r1
            L5e:
                r1 = r9
                r9 = r7
            L60:
                if (r3 != r5) goto L80
                r3 = 0
            L63:
                yu2$b[] r4 = r0.b
                int r5 = r4.length
                if (r3 >= r5) goto L80
                int r5 = r0.c
                if (r3 == r5) goto L7d
                r4 = r4[r3]
                hr4 r4 = r4.b
                long r5 = defpackage.yu2.m(r4, r12, r14)
                int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
                if (r11 == 0) goto L7c
                long r1 = defpackage.yu2.m(r4, r9, r1)
            L7c:
                r14 = r5
            L7d:
                int r3 = r3 + 1
                goto L63
            L80:
                a04 r0 = new a04
                r0.<init>(r12, r14)
                int r3 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
                if (r3 != 0) goto L8f
                yz3$a r1 = new yz3$a
                r1.<init>(r0)
                return r1
            L8f:
                a04 r3 = new a04
                r3.<init>(r9, r1)
                yz3$a r1 = new yz3$a
                r1.<init>(r0, r3)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: yu2.a.b(long, int):yz3$a");
        }

        @Override // defpackage.yz3
        public boolean e() {
            return true;
        }

        @Override // defpackage.yz3
        public yz3.a g(long j) {
            return b(j, -1);
        }

        @Override // defpackage.yz3
        public long i() {
            return this.a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final iq4 a;
        public final hr4 b;
        public final gr4 c;
        public final qt4 d;
        public int e;
        public t41 f;

        public b(iq4 iq4Var, hr4 hr4Var, gr4 gr4Var) {
            this.a = iq4Var;
            this.b = hr4Var;
            this.c = gr4Var;
            this.d = "audio/true-hd".equals(iq4Var.g.p) ? new qt4() : null;
        }
    }

    public yu2(ki4.a aVar, int i) {
        this.a = aVar;
        this.b = i;
        this.c = (i & Buffer.DEFAULT_SIZE) != 0;
        this.k = xi1.u();
        this.l = (i & 4) != 0 ? 3 : 0;
        this.i = new c04();
        this.j = new ArrayList();
        this.g = new r73(16);
        this.h = new ArrayDeque();
        this.d = new r73(dx2.a);
        this.e = new r73(6);
        this.f = new r73();
        this.q = -1;
        this.B = mz0.d;
        this.C = new b[0];
    }

    private void A(long j) {
        while (!this.h.isEmpty() && ((su2.b) this.h.peek()).b == j) {
            su2.b bVar = (su2.b) this.h.pop();
            if (bVar.a == 1836019574) {
                D(bVar);
                this.h.clear();
                this.z = true;
                if (!this.w && !this.c) {
                    this.l = 2;
                }
            } else if (!this.h.isEmpty()) {
                ((su2.b) this.h.peek()).b(bVar);
            }
        }
        if (this.l != 2) {
            r();
        }
    }

    public static int C(r73 r73Var) {
        r73Var.f0(8);
        int iN = n(r73Var.z());
        if (iN != 0) {
            return iN;
        }
        r73Var.g0(4);
        while (r73Var.a() > 0) {
            int iN2 = n(r73Var.z());
            if (iN2 != 0) {
                return iN2;
            }
        }
        return 0;
    }

    private boolean F(jz0 jz0Var) throws r83 {
        su2.b bVar;
        if (this.o == 0) {
            if (!jz0Var.d(this.g.f(), 0, 8, true)) {
                B();
                return false;
            }
            this.o = 8;
            this.g.f0(0);
            this.n = this.g.S();
            this.m = this.g.z();
        }
        long j = this.n;
        if (j == 1) {
            jz0Var.readFully(this.g.f(), 8, 8);
            this.o += 8;
            this.n = this.g.X();
        } else if (j == 0) {
            long length = jz0Var.getLength();
            if (length == -1 && (bVar = (su2.b) this.h.peek()) != null) {
                length = bVar.b;
            }
            if (length != -1) {
                this.n = (length - jz0Var.getPosition()) + ((long) this.o);
            }
        }
        long j2 = this.n;
        int i = this.o;
        if (j2 < i) {
            if (this.m != 1718773093 || i != 8) {
                throw r83.e("Atom size less than header length (unsupported).");
            }
            this.n = i;
        }
        if (J(this.m)) {
            long position = jz0Var.getPosition();
            long j3 = this.n;
            int i2 = this.o;
            long j4 = (position + j3) - ((long) i2);
            if (j3 != i2 && this.m == 1835365473) {
                z(jz0Var);
            }
            this.h.push(new su2.b(this.m, j4));
            if (this.n == this.o) {
                A(j4);
            } else {
                r();
            }
        } else if (K(this.m)) {
            gg3.v(this.o == 8);
            gg3.v(this.n <= 2147483647L);
            r73 r73Var = new r73((int) this.n);
            System.arraycopy(this.g.f(), 0, r73Var.f(), 0, 8);
            this.p = r73Var;
            this.l = 1;
        } else {
            E(jz0Var.getPosition() - ((long) this.o));
            this.p = null;
            this.l = 1;
        }
        return true;
    }

    private static boolean J(int i) {
        return i == 1836019574 || i == 1953653099 || i == 1835297121 || i == 1835626086 || i == 1937007212 || i == 1701082227 || i == 1835365473 || i == 1635284069;
    }

    private static boolean K(int i) {
        return i == 1835296868 || i == 1836476516 || i == 1751411826 || i == 1937011556 || i == 1937011827 || i == 1937011571 || i == 1668576371 || i == 1701606260 || i == 1937011555 || i == 1937011578 || i == 1937013298 || i == 1937007471 || i == 1668232756 || i == 1953196132 || i == 1718909296 || i == 1969517665 || i == 1801812339 || i == 1768715124;
    }

    public static /* synthetic */ iq4 g(iq4 iq4Var) {
        return iq4Var;
    }

    public static /* synthetic */ hz0[] i() {
        return new hz0[]{new yu2(ki4.a.a, 16)};
    }

    public static int n(int i) {
        if (i != 1751476579) {
            return i != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    public static long[][] o(b[] bVarArr) {
        long[][] jArr = new long[bVarArr.length][];
        int[] iArr = new int[bVarArr.length];
        long[] jArr2 = new long[bVarArr.length];
        boolean[] zArr = new boolean[bVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            jArr[i] = new long[bVarArr[i].b.b];
            jArr2[i] = bVarArr[i].b.f[0];
        }
        long j = 0;
        int i2 = 0;
        while (i2 < bVarArr.length) {
            long j2 = Long.MAX_VALUE;
            int i3 = -1;
            for (int i4 = 0; i4 < bVarArr.length; i4++) {
                if (!zArr[i4]) {
                    long j3 = jArr2[i4];
                    if (j3 <= j2) {
                        i3 = i4;
                        j2 = j3;
                    }
                }
            }
            int i5 = iArr[i3];
            long[] jArr3 = jArr[i3];
            jArr3[i5] = j;
            hr4 hr4Var = bVarArr[i3].b;
            j += (long) hr4Var.d[i5];
            int i6 = i5 + 1;
            iArr[i3] = i6;
            if (i6 < jArr3.length) {
                jArr2[i3] = hr4Var.f[i6];
            } else {
                zArr[i3] = true;
                i2++;
            }
        }
        return jArr;
    }

    private boolean p(t41 t41Var) {
        return Objects.equals(t41Var.p, "video/avc") ? (this.b & 32) != 0 : Objects.equals(t41Var.p, "video/hevc") && (this.b & 128) != 0;
    }

    public static int q(int i) {
        int i2 = (i & 1) != 0 ? 32 : 0;
        return (i & 2) != 0 ? i2 | 128 : i2;
    }

    private void r() {
        this.l = 0;
        this.o = 0;
    }

    public static long s(hr4 hr4Var, long j) {
        int i;
        if (!nt2.t(hr4Var.a.g.p)) {
            return -9223372036854775807L;
        }
        int iMin = Math.min(hr4Var.j ? hr4Var.b : hr4Var.h.length, 20);
        gg3.v(j != -9223372036854775807L);
        long jMin = Math.min(j, 10000000L);
        int i2 = -1;
        int i3 = 0;
        for (int i4 = 0; i4 < iMin; i4++) {
            int i5 = hr4Var.j ? i4 : hr4Var.h[i4];
            long j2 = hr4Var.f[i5];
            if (j2 > jMin) {
                break;
            }
            if (j2 >= 0 && (i = hr4Var.d[i5]) > i3) {
                i2 = i5;
                i3 = i;
            }
        }
        if (i2 == -1) {
            return -9223372036854775807L;
        }
        return hr4Var.f[i2];
    }

    public static int v(hr4 hr4Var, long j) {
        int iA = hr4Var.a(j);
        return iA == -1 ? hr4Var.b(j) : iA;
    }

    public static long x(hr4 hr4Var, long j, long j2) {
        int iV = v(hr4Var, j);
        return iV == -1 ? j2 : Math.min(hr4Var.c[iV], j2);
    }

    private void z(jz0 jz0Var) {
        this.f.b0(8);
        jz0Var.s(this.f.f(), 0, 8);
        gl.g(this.f);
        jz0Var.q(this.f.g());
        jz0Var.p();
    }

    public final void B() {
        if (this.E != 2 || (this.b & 2) == 0) {
            return;
        }
        gr4 gr4VarE = this.B.e(0, 4);
        iu2 iu2Var = this.F;
        gr4VarE.g(new t41.b().s0(iu2Var == null ? null : new xs2(iu2Var)).Q());
        this.B.o();
        this.B.u(new yz3.b(-9223372036854775807L));
    }

    public final void D(su2.b bVar) {
        List list;
        xs2 xs2Var;
        xs2 xs2VarI;
        List list2;
        int i;
        xs2 xs2Var2;
        xs2 xs2Var3;
        String str;
        ArrayList arrayList;
        su2.b bVarD = bVar.d(1835365473);
        List arrayList2 = new ArrayList();
        if (bVarD != null) {
            xs2 xs2VarU = gl.u(bVarD);
            if (this.y) {
                gg3.q(xs2VarU);
                y(xs2VarU);
                arrayList2 = t(xs2VarU);
            } else if (L(xs2VarU)) {
                this.w = true;
                return;
            }
            xs2Var = xs2VarU;
            list = arrayList2;
        } else {
            list = arrayList2;
            xs2Var = null;
        }
        ArrayList arrayList3 = new ArrayList();
        boolean z = this.E == 1;
        f91 f91Var = new f91();
        su2.c cVarE = bVar.e(1969517665);
        if (cVarE != null) {
            xs2VarI = gl.I(cVarE);
            f91Var.e(xs2VarI);
        } else {
            xs2VarI = null;
        }
        xs2 xs2Var4 = new xs2(gl.w(((su2.c) gg3.q(bVar.e(1836476516))).b));
        xs2 xs2Var5 = xs2VarI;
        List listH = gl.H(bVar, f91Var, -9223372036854775807L, null, (this.b & 1) != 0, z, new p81() { // from class: tu2
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return yu2.g((iq4) obj);
            }
        }, this.c);
        if (this.y) {
            gg3.w(list.size() == listH.size(), String.format(Locale.US, "The number of auxiliary track types from metadata (%d) is not same as the number of auxiliary tracks (%d)", Integer.valueOf(list.size()), Integer.valueOf(listH.size())));
        }
        String strB = mt2.b(listH);
        int i2 = 0;
        int i3 = 0;
        long j = -9223372036854775807L;
        int size = -1;
        while (i2 < listH.size()) {
            hr4 hr4Var = (hr4) listH.get(i2);
            if (hr4Var.b == 0) {
                list2 = listH;
                i = i3;
                xs2Var2 = xs2Var5;
                xs2Var3 = xs2Var;
                str = strB;
                arrayList = arrayList3;
            } else {
                iq4 iq4Var = hr4Var.a;
                list2 = listH;
                ArrayList arrayList4 = arrayList3;
                i = i3 + 1;
                String str2 = strB;
                b bVar2 = new b(iq4Var, hr4Var, this.B.e(i3, iq4Var.b));
                xs2Var2 = xs2Var5;
                xs2 xs2Var6 = xs2Var;
                long j2 = iq4Var.e;
                if (j2 == -9223372036854775807L) {
                    j2 = hr4Var.i;
                }
                bVar2.c.e(j2);
                long jMax = Math.max(j, j2);
                boolean zEquals = "audio/true-hd".equals(iq4Var.g.p);
                int i4 = hr4Var.e;
                int i5 = zEquals ? i4 * 16 : i4 + 30;
                t41.b bVarB = iq4Var.g.b();
                bVarB.p0(i5);
                if (iq4Var.b == 2) {
                    int i6 = iq4Var.g.f;
                    if ((this.b & 8) != 0) {
                        i6 |= size == -1 ? 1 : 2;
                    }
                    if (this.y) {
                        i6 |= 32768;
                        bVarB.S(((Integer) list.get(i2)).intValue());
                    }
                    bVarB.y0(i6);
                }
                long jS = s(hr4Var, j2);
                xs2 xs2Var7 = jS != -9223372036854775807L ? new xs2(new wn4(jS)) : null;
                gt2.k(iq4Var.b, f91Var, bVarB);
                xs2Var3 = xs2Var6;
                gt2.l(iq4Var.b, xs2Var3, bVarB, iq4Var.g.l, this.j.isEmpty() ? null : new xs2(this.j), xs2Var2, xs2Var4, xs2Var7);
                str = str2;
                bVarB.X(str);
                if (Objects.equals(iq4Var.g.p, DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_MPEG)) {
                    bVar2.f = bVarB.Q();
                } else {
                    bVar2.c.g(bVarB.Q());
                }
                if (iq4Var.b == 2 && size == -1) {
                    size = arrayList4.size();
                }
                arrayList = arrayList4;
                arrayList.add(bVar2);
                j = jMax;
            }
            i2++;
            arrayList3 = arrayList;
            xs2Var = xs2Var3;
            strB = str;
            listH = list2;
            xs2Var5 = xs2Var2;
            i3 = i;
        }
        b[] bVarArr = (b[]) arrayList3.toArray(new b[0]);
        this.C = bVarArr;
        this.D = !this.c ? o(bVarArr) : null;
        this.B.o();
        this.B.u(new a(j, this.C, size));
    }

    public final void E(long j) {
        if (this.m == 1836086884) {
            int i = this.o;
            this.F = new iu2(0L, j, -9223372036854775807L, j + ((long) i), this.n - ((long) i));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean G(defpackage.jz0 r10, defpackage.yf3 r11) {
        /*
            r9 = this;
            long r0 = r9.n
            int r2 = r9.o
            long r2 = (long) r2
            long r0 = r0 - r2
            long r2 = r10.getPosition()
            long r2 = r2 + r0
            r73 r4 = r9.p
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L46
            byte[] r7 = r4.f()
            int r8 = r9.o
            int r0 = (int) r0
            r10.readFully(r7, r8, r0)
            int r10 = r9.m
            r0 = 1718909296(0x66747970, float:2.8862439E23)
            if (r10 != r0) goto L2b
            r9.v = r5
            int r10 = C(r4)
            r9.E = r10
            goto L5e
        L2b:
            java.util.ArrayDeque r10 = r9.h
            boolean r10 = r10.isEmpty()
            if (r10 != 0) goto L5e
            java.util.ArrayDeque r10 = r9.h
            java.lang.Object r10 = r10.peek()
            su2$b r10 = (su2.b) r10
            su2$c r0 = new su2$c
            int r1 = r9.m
            r0.<init>(r1, r4)
            r10.c(r0)
            goto L5e
        L46:
            boolean r4 = r9.v
            if (r4 != 0) goto L53
            int r4 = r9.m
            r7 = 1835295092(0x6d646174, float:4.4175247E27)
            if (r4 != r7) goto L53
            r9.E = r5
        L53:
            r7 = 262144(0x40000, double:1.295163E-318)
            int r4 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r4 >= 0) goto L60
            int r0 = (int) r0
            r10.q(r0)
        L5e:
            r10 = r6
            goto L68
        L60:
            long r7 = r10.getPosition()
            long r7 = r7 + r0
            r11.a = r7
            r10 = r5
        L68:
            r9.A(r2)
            boolean r0 = r9.w
            if (r0 == 0) goto L78
            r9.y = r5
            long r0 = r9.x
            r11.a = r0
            r9.w = r6
            r10 = r5
        L78:
            if (r10 == 0) goto L80
            int r9 = r9.l
            r10 = 2
            if (r9 == r10) goto L80
            return r5
        L80:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yu2.G(jz0, yf3):boolean");
    }

    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v40 */
    public final int H(jz0 jz0Var, yf3 yf3Var) throws r83 {
        gr4.a aVar;
        ?? r2;
        int iP;
        long position = jz0Var.getPosition();
        if (this.q == -1) {
            int iW = w(position);
            this.q = iW;
            if (iW == -1) {
                return -1;
            }
        }
        b bVar = this.C[this.q];
        gr4 gr4Var = bVar.c;
        int i = bVar.e;
        hr4 hr4Var = bVar.b;
        long j = hr4Var.c[i] + this.A;
        int i2 = hr4Var.d[i];
        qt4 qt4Var = bVar.d;
        long j2 = (j - position) + ((long) this.r);
        if (j2 < 0 || j2 >= 262144) {
            yf3Var.a = j;
            return 1;
        }
        if (bVar.a.h == 1) {
            j2 += 8;
            i2 -= 8;
        }
        jz0Var.q((int) j2);
        if (!p(bVar.a.g)) {
            this.u = true;
        }
        iq4 iq4Var = bVar.a;
        if (iq4Var.k == 0) {
            if ("audio/ac4".equals(iq4Var.g.p)) {
                if (this.s == 0) {
                    p1.b(i2, this.f);
                    gr4Var.a(this.f, 7);
                    this.s += 7;
                }
                i2 += 7;
                aVar = null;
            } else if (bVar.f == null || !Objects.equals(bVar.a.g.p, DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_MPEG)) {
                aVar = null;
                if (qt4Var != null) {
                    qt4Var.d(jz0Var);
                }
            } else {
                t41 t41VarQ = bVar.f;
                this.f.b0(4);
                jz0Var.s(this.f.f(), 0, 4);
                jz0Var.p();
                dv2.a aVar2 = new dv2.a();
                gr4 gr4Var2 = bVar.c;
                if (aVar2.a(this.f.z()) && !Objects.equals(t41VarQ.p, aVar2.b)) {
                    t41VarQ = t41VarQ.b().A0((String) gg3.q(aVar2.b)).Q();
                }
                gr4Var2.g(t41VarQ);
                aVar = null;
                bVar.f = null;
            }
            while (true) {
                int i3 = this.s;
                if (i3 >= i2) {
                    break;
                }
                int iD = gr4Var.d(jz0Var, i2 - i3, false);
                this.r += iD;
                this.s += iD;
                this.t -= iD;
            }
        } else {
            byte[] bArrF = this.e.f();
            bArrF[0] = 0;
            bArrF[1] = 0;
            bArrF[2] = 0;
            int i4 = 4 - bVar.a.k;
            i2 += i4;
            while (this.s < i2) {
                int i5 = this.t;
                if (i5 == 0) {
                    iq4 iq4Var2 = bVar.a;
                    int i6 = iq4Var2.k;
                    if (this.u || dx2.p(iq4Var2.g) + i6 > bVar.b.d[i] - this.r) {
                        iP = 0;
                    } else {
                        iP = dx2.p(bVar.a.g);
                        i6 = bVar.a.k + iP;
                    }
                    jz0Var.readFully(bArrF, i4, i6);
                    this.r += i6;
                    this.e.f0(0);
                    int iZ = this.e.z();
                    if (iZ < 0) {
                        throw r83.a("Invalid NAL length", null);
                    }
                    this.t = iZ - iP;
                    this.d.f0(0);
                    gr4Var.a(this.d, 4);
                    this.s += 4;
                    if (iP > 0) {
                        gr4Var.a(this.e, iP);
                        this.s += iP;
                        if (dx2.l(bArrF, 4, iP, bVar.a.g)) {
                            this.u = true;
                        }
                    }
                } else {
                    int iD2 = gr4Var.d(jz0Var, i5, false);
                    this.r += iD2;
                    this.s += iD2;
                    this.t -= iD2;
                }
            }
            aVar = null;
        }
        int i7 = i2;
        hr4 hr4Var2 = bVar.b;
        long j3 = hr4Var2.f[i];
        int i8 = hr4Var2.g[i];
        if (!this.u) {
            i8 |= 67108864;
        }
        int i9 = i8;
        if (qt4Var != null) {
            gr4.a aVar3 = aVar;
            boolean z = false;
            qt4Var.c(gr4Var, j3, i9, i7, 0, null);
            r2 = z;
            if (i + 1 == bVar.b.b) {
                qt4Var.a(gr4Var, aVar3);
                r2 = z;
            }
        } else {
            r2 = 0;
            gr4Var.b(j3, i9, i7, 0, null);
        }
        bVar.e++;
        this.q = -1;
        this.r = r2;
        this.s = r2;
        this.t = r2;
        this.u = r2;
        return r2;
    }

    public final int I(jz0 jz0Var, yf3 yf3Var) throws r83 {
        int iC = this.i.c(jz0Var, yf3Var, this.j);
        if (iC == 1 && yf3Var.a == 0) {
            r();
        }
        return iC;
    }

    public final boolean L(xs2 xs2Var) {
        w62 w62Var;
        if (xs2Var == null || (this.b & 64) == 0 || (w62Var = (w62) xs2Var.h(w62.class, new ig3() { // from class: wu2
            @Override // defpackage.ig3
            public final boolean apply(Object obj) {
                return ((w62) obj).a.equals("auxiliary.tracks.offset");
            }
        })) == null) {
            return false;
        }
        long jX = new r73(w62Var.b).X();
        if (jX <= 0) {
            return false;
        }
        this.x = jX;
        return true;
    }

    public final void M(b bVar, long j) {
        hr4 hr4Var = bVar.b;
        int iA = hr4Var.a(j);
        if (iA == -1) {
            iA = hr4Var.b(j);
        }
        bVar.e = iA;
    }

    @Override // defpackage.hz0
    public void a(long j, long j2) {
        this.h.clear();
        this.o = 0;
        this.q = -1;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = false;
        this.z = false;
        if (j == 0) {
            if (this.l != 3) {
                r();
                return;
            } else {
                this.i.g();
                this.j.clear();
                return;
            }
        }
        for (b bVar : this.C) {
            M(bVar, j2);
            qt4 qt4Var = bVar.d;
            if (qt4Var != null) {
                qt4Var.b();
            }
        }
    }

    @Override // defpackage.hz0
    public void b(mz0 mz0Var) {
        if ((this.b & 16) == 0) {
            mz0Var = new li4(mz0Var, this.a);
        }
        this.B = mz0Var;
    }

    @Override // defpackage.hz0
    public int d(jz0 jz0Var, yf3 yf3Var) {
        if (this.c && this.z) {
            return -1;
        }
        while (true) {
            int i = this.l;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        return H(jz0Var, yf3Var);
                    }
                    if (i == 3) {
                        return I(jz0Var, yf3Var);
                    }
                    z20.a();
                    return 0;
                }
                if (G(jz0Var, yf3Var)) {
                    return 1;
                }
            } else if (!F(jz0Var)) {
                return -1;
            }
        }
    }

    @Override // defpackage.hz0
    public boolean e(jz0 jz0Var) {
        s94 s94VarD = t94.d(jz0Var, (this.b & 2) != 0);
        this.k = s94VarD != null ? xi1.w(s94VarD) : xi1.u();
        return s94VarD == null;
    }

    @Override // defpackage.hz0
    public void release() {
    }

    public final List t(xs2 xs2Var) {
        List listD = ((w62) gg3.q((w62) xs2Var.h(w62.class, new ig3() { // from class: xu2
            @Override // defpackage.ig3
            public final boolean apply(Object obj) {
                return ((w62) obj).a.equals("auxiliary.tracks.map");
            }
        }))).d();
        ArrayList arrayList = new ArrayList(listD.size());
        for (int i = 0; i < listD.size(); i++) {
            int iIntValue = ((Integer) listD.get(i)).intValue();
            int i2 = 1;
            if (iIntValue != 0) {
                if (iIntValue != 1) {
                    i2 = 3;
                    if (iIntValue != 2) {
                        i2 = iIntValue != 3 ? 0 : 4;
                    }
                } else {
                    i2 = 2;
                }
            }
            arrayList.add(Integer.valueOf(i2));
        }
        return arrayList;
    }

    @Override // defpackage.hz0
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public xi1 f() {
        return this.k;
    }

    public final int w(long j) {
        int i = -1;
        int i2 = -1;
        int i3 = 0;
        long j2 = Long.MAX_VALUE;
        boolean z = true;
        long j3 = Long.MAX_VALUE;
        boolean z2 = true;
        long j4 = Long.MAX_VALUE;
        while (true) {
            b[] bVarArr = this.C;
            if (i3 >= bVarArr.length) {
                break;
            }
            b bVar = bVarArr[i3];
            int i4 = bVar.e;
            hr4 hr4Var = bVar.b;
            if (i4 != hr4Var.b) {
                long j5 = hr4Var.c[i4];
                long j6 = ((long[][]) gg3.q(this.D))[i3][i4];
                long j7 = j5 - j;
                boolean z3 = j7 < 0 || j7 >= 262144;
                if ((!z3 && z2) || (z3 == z2 && j7 < j4)) {
                    z2 = z3;
                    j3 = j6;
                    i2 = i3;
                    j4 = j7;
                }
                if (j6 < j2) {
                    z = z3;
                    j2 = j6;
                    i = i3;
                }
            }
            i3++;
        }
        return (j2 == Long.MAX_VALUE || !z || j3 < j2 + 10485760) ? i2 : i;
    }

    public final void y(xs2 xs2Var) {
        w62 w62Var = (w62) xs2Var.h(w62.class, new ig3() { // from class: vu2
            @Override // defpackage.ig3
            public final boolean apply(Object obj) {
                return ((w62) obj).a.equals("auxiliary.tracks.interleaved");
            }
        });
        if (w62Var == null || w62Var.b[0] != 0) {
            return;
        }
        this.A = this.x + 16;
    }
}
