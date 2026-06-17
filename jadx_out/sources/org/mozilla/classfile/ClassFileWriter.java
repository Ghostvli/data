package org.mozilla.classfile;

import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.e04;
import defpackage.jl;
import defpackage.kv0;
import defpackage.mu;
import defpackage.nu;
import defpackage.uu4;
import defpackage.zt2;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ClassFileWriter {
    public static final int E;
    public static final int F;
    public static final boolean G;
    public ArrayList A;
    public ArrayList B;
    public String d;
    public kv0[] e;
    public int f;
    public int[] g;
    public int h;
    public int j;
    public org.mozilla.classfile.a k;
    public nu l;
    public int m;
    public int n;
    public int o;
    public int s;
    public int t;
    public int u;
    public int v;
    public int[] w;
    public int x;
    public long[] y;
    public int z;
    public int[] a = null;
    public int b = 0;
    public HashMap c = null;
    public byte[] i = new byte[Buffer.DEFAULT_SIZE];
    public ArrayList p = new ArrayList();
    public ArrayList q = new ArrayList();
    public ArrayList r = new ArrayList();
    public int C = 0;
    public char[] D = new char[64];

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class a {
        public final byte[] a;

        public a(c cVar, Object... objArr) {
            byte[] bArr = new byte[(objArr.length * 2) + 4];
            this.a = bArr;
            ClassFileWriter.y0(ClassFileWriter.this.k.k(cVar), bArr, 0);
            ClassFileWriter.y0(objArr.length, bArr, 2);
            for (int i = 0; i < objArr.length; i++) {
                ClassFileWriter.y0(ClassFileWriter.this.k.f(objArr[i]), this.a, (i * 2) + 4);
            }
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && Arrays.equals(this.a, ((a) obj).a);
        }

        public int hashCode() {
            return ~Arrays.hashCode(this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b extends RuntimeException {
        public b(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c {
        public final byte a;
        public final String b;
        public final String c;
        public final String d;

        public c(byte b, String str, String str2, String str3) {
            this.a = b;
            this.b = str;
            this.c = str2;
            this.d = str3;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a == cVar.a && this.b.equals(cVar.b) && this.c.equals(cVar.c) && this.d.equals(cVar.d);
        }

        public int hashCode() {
            return this.a + (this.b.hashCode() * this.c.hashCode() * this.d.hashCode());
        }

        public String toString() {
            return this.b + "." + this.c + this.d + " (" + ((int) this.a) + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class d {
        public org.mozilla.classfile.b[] g = null;
        public int[] c = null;
        public int[] a = null;
        public org.mozilla.classfile.b[] e = null;
        public byte[] h = null;
        public int b = 0;
        public int d = 0;
        public int f = 0;
        public int i = 0;
        public boolean j = false;

        public d() {
        }

        public final void A(long j) {
            z((int) (j & 16777215));
            long j2 = j >>> 32;
            if (j2 != 0) {
                z((int) (j2 & 16777215));
            }
        }

        public final void B(int i, int i2) {
            int i3 = this.b;
            if (i >= i3) {
                int i4 = i + 1;
                int[] iArr = new int[i4];
                System.arraycopy(this.a, 0, iArr, 0, i3);
                this.a = iArr;
                this.b = i4;
            }
            this.a[i] = i2;
        }

        public final void C() {
            int[] iArrF0 = ClassFileWriter.this.f0();
            this.g[0].i(iArrF0, iArrF0.length, new int[0], 0, ClassFileWriter.this.k);
            this.e = new org.mozilla.classfile.b[]{this.g[0]};
            this.f = 1;
            j();
            for (org.mozilla.classfile.b bVar : this.g) {
                if (!bVar.h()) {
                    w(bVar);
                }
            }
            j();
        }

        public int D(byte[] bArr, int i) {
            int iY0 = ClassFileWriter.y0(this.g.length - 1, bArr, ClassFileWriter.z0(this.i + 2, bArr, i));
            System.arraycopy(this.h, 0, bArr, iY0, this.i);
            return iY0 + this.i;
        }

        public final void E(int[] iArr, int i, int i2) {
            int length = iArr.length - i;
            byte[] bArr = this.h;
            int i3 = this.i;
            int i4 = i3 + 1;
            this.i = i4;
            bArr[i3] = (byte) (i + 251);
            this.i = ClassFileWriter.y0(i2, bArr, i4);
            this.i = L(iArr, length);
        }

        public final void F(int i, int i2) {
            byte[] bArr = this.h;
            int i3 = this.i;
            int i4 = i3 + 1;
            this.i = i4;
            bArr[i3] = (byte) (251 - i);
            this.i = ClassFileWriter.y0(i2, bArr, i4);
        }

        public final void G(int[] iArr, int[] iArr2, int i) {
            byte[] bArr = this.h;
            int i2 = this.i;
            int i3 = i2 + 1;
            this.i = i3;
            bArr[i2] = -1;
            int iY0 = ClassFileWriter.y0(i, bArr, i3);
            this.i = iY0;
            this.i = ClassFileWriter.y0(iArr.length, this.h, iY0);
            K(iArr);
            this.i = ClassFileWriter.y0(iArr2.length, this.h, this.i);
            K(iArr2);
        }

        public final void H(int i) {
            byte[] bArr = this.h;
            if (i <= 63) {
                int i2 = this.i;
                this.i = i2 + 1;
                bArr[i2] = (byte) i;
            } else {
                int i3 = this.i;
                int i4 = i3 + 1;
                this.i = i4;
                bArr[i3] = -5;
                this.i = ClassFileWriter.y0(i, bArr, i4);
            }
        }

        public final void I(int[] iArr, int i) {
            byte[] bArr = this.h;
            if (i <= 63) {
                int i2 = this.i;
                this.i = i2 + 1;
                bArr[i2] = (byte) (i + 64);
            } else {
                int i3 = this.i;
                int i4 = i3 + 1;
                this.i = i4;
                bArr[i3] = -9;
                this.i = ClassFileWriter.y0(i, bArr, i4);
            }
            J(iArr[0]);
        }

        public final int J(int i) {
            int i2 = i & 255;
            byte[] bArr = this.h;
            int i3 = this.i;
            int i4 = i3 + 1;
            this.i = i4;
            bArr[i3] = (byte) i2;
            if (i2 == 7 || i2 == 8) {
                this.i = ClassFileWriter.y0(i >>> 8, bArr, i4);
            }
            return this.i;
        }

        public final int K(int[] iArr) {
            return L(iArr, 0);
        }

        public final int L(int[] iArr, int i) {
            while (i < iArr.length) {
                this.i = J(iArr[i]);
                i++;
            }
            return this.i;
        }

        public final void a(org.mozilla.classfile.b bVar) {
            if (bVar.g()) {
                return;
            }
            bVar.k(true);
            bVar.l(true);
            int i = this.f;
            org.mozilla.classfile.b[] bVarArr = this.e;
            if (i == bVarArr.length) {
                org.mozilla.classfile.b[] bVarArr2 = new org.mozilla.classfile.b[i * 2];
                System.arraycopy(bVarArr, 0, bVarArr2, 0, i);
                this.e = bVarArr2;
            }
            org.mozilla.classfile.b[] bVarArr3 = this.e;
            int i2 = this.f;
            this.f = i2 + 1;
            bVarArr3[i2] = bVar;
        }

        public final void b() {
            this.d = 0;
        }

        public final void c() {
            int[] iArrF = this.g[0].f();
            int iE = -1;
            int i = 1;
            while (true) {
                org.mozilla.classfile.b[] bVarArr = this.g;
                if (i >= bVarArr.length) {
                    return;
                }
                org.mozilla.classfile.b bVar = bVarArr[i];
                int[] iArrF2 = bVar.f();
                int[] iArrD = bVar.d();
                int iE2 = (bVar.e() - iE) - 1;
                if (iArrD.length == 0) {
                    int length = iArrF.length > iArrF2.length ? iArrF2.length : iArrF.length;
                    int iAbs = Math.abs(iArrF.length - iArrF2.length);
                    int i2 = 0;
                    while (i2 < length && iArrF[i2] == iArrF2[i2]) {
                        i2++;
                    }
                    if (i2 == iArrF2.length && iAbs == 0) {
                        H(iE2);
                    } else if (i2 == iArrF2.length && iAbs <= 3) {
                        F(iAbs, iE2);
                    } else if (i2 != iArrF.length || iAbs > 3) {
                        G(iArrF2, iArrD, iE2);
                    } else {
                        E(iArrF2, iAbs, iE2);
                    }
                } else if (iArrD.length != 1) {
                    G(iArrF2, iArrD, iE2);
                } else if (Arrays.equals(iArrF, iArrF2)) {
                    I(iArrD, iE2);
                } else {
                    G(iArrF2, iArrD, iE2);
                }
                iE = bVar.e();
                i++;
                iArrF = iArrF2;
            }
        }

        public int d() {
            this.h = new byte[r()];
            c();
            return this.i + 2;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:125:0x0396  */
        /* JADX WARN: Removed duplicated region for block: B:128:0x03a0  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int e(int r12) {
            /*
                Method dump skipped, instruction units count: 1342
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.mozilla.classfile.ClassFileWriter.d.e(int):int");
        }

        public final void f(int i) {
            int iN = n(i);
            int iH = uu4.h(iN);
            if (iH == 7 || iH == 6 || iH == 8 || iH == 5) {
                z(iN);
                return;
            }
            throw new IllegalStateException("bad local variable type: " + iN + " at index: " + i);
        }

        public final void g(int i) {
            B(i, x());
        }

        public final void h(org.mozilla.classfile.b bVar) {
            int iMax;
            int iMin;
            int i = ClassFileWriter.this.f;
            if (ClassFileWriter.this.f > 1) {
                iMin = Integer.MAX_VALUE;
                iMax = 0;
                for (int i2 = 0; i2 < ClassFileWriter.this.f; i2++) {
                    kv0 kv0Var = ClassFileWriter.this.e[i2];
                    if (bVar.a() >= ClassFileWriter.this.m0(kv0Var.a) && bVar.e() < ClassFileWriter.this.m0(kv0Var.b)) {
                        iMin = Math.min(iMin, i2);
                        iMax = Math.max(iMax, i2 + 1);
                    }
                }
            } else {
                iMax = i;
                iMin = 0;
            }
            int iE = bVar.e();
            int i3 = 0;
            while (iE < bVar.a()) {
                i3 = ClassFileWriter.this.i[iE] & 255;
                int iE2 = e(iE);
                if (u(i3)) {
                    k(m(iE));
                } else if (i3 == 170) {
                    int i4 = iE + 1 + ((~iE) & 3);
                    k(q(p(i4, 4) + iE));
                    int iP = (p(i4 + 8, 4) - p(i4 + 4, 4)) + 1;
                    int i5 = i4 + 12;
                    for (int i6 = 0; i6 < iP; i6++) {
                        k(q(p((i6 * 4) + i5, 4) + iE));
                    }
                }
                for (int i7 = iMin; i7 < iMax; i7++) {
                    kv0 kv0Var2 = ClassFileWriter.this.e[i7];
                    int iM0 = ClassFileWriter.this.m0(kv0Var2.a);
                    int iM02 = ClassFileWriter.this.m0(kv0Var2.b);
                    if (iE >= iM0 && iE < iM02) {
                        org.mozilla.classfile.b bVarQ = q(ClassFileWriter.this.m0(kv0Var2.c));
                        short s = kv0Var2.d;
                        bVarQ.i(this.a, this.b, new int[]{s == 0 ? uu4.a(ClassFileWriter.this.k.a("java/lang/Throwable")) : uu4.a(s)}, 1, ClassFileWriter.this.k);
                        a(bVarQ);
                    }
                }
                iE += iE2;
            }
            if (v(i3)) {
                return;
            }
            int iB = bVar.b() + 1;
            org.mozilla.classfile.b[] bVarArr = this.g;
            if (iB < bVarArr.length) {
                k(bVarArr[iB]);
            }
        }

        public final void i(int i, int i2) {
            x();
            B(i, i2);
        }

        public final void j() {
            while (true) {
                int i = this.f;
                if (i <= 0) {
                    return;
                }
                org.mozilla.classfile.b[] bVarArr = this.e;
                int i2 = i - 1;
                this.f = i2;
                org.mozilla.classfile.b bVar = bVarArr[i2];
                bVar.k(false);
                this.a = bVar.c();
                int[] iArrD = bVar.d();
                this.c = iArrD;
                this.b = this.a.length;
                this.d = iArrD.length;
                h(bVar);
            }
        }

        public final void k(org.mozilla.classfile.b bVar) {
            if (bVar.i(this.a, this.b, this.c, this.d, ClassFileWriter.this.k)) {
                a(bVar);
            }
        }

        public void l() {
            this.g = new org.mozilla.classfile.b[ClassFileWriter.this.b];
            int[] iArrF0 = ClassFileWriter.this.f0();
            int i = 0;
            while (i < ClassFileWriter.this.b) {
                int i2 = ClassFileWriter.this.a[i];
                int i3 = ClassFileWriter.this.b - 1;
                ClassFileWriter classFileWriter = ClassFileWriter.this;
                this.g[i] = new org.mozilla.classfile.b(i, i2, i == i3 ? classFileWriter.j : classFileWriter.a[i + 1], iArrF0);
                i++;
            }
            C();
        }

        public final org.mozilla.classfile.b m(int i) {
            return q(i + ((ClassFileWriter.this.i[i] & 255) == 200 ? p(i + 1, 4) : (short) p(i + 1, 2)));
        }

        public final int n(int i) {
            if (i < this.b) {
                return this.a[i];
            }
            return 0;
        }

        public final int o(int i) {
            return p(i, 1);
        }

        public final int p(int i, int i2) {
            if (i2 > 4) {
                jl.a("bad operand size");
                return 0;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                i3 = (i3 << 8) | (ClassFileWriter.this.i[i + i4] & 255);
            }
            return i3;
        }

        public final org.mozilla.classfile.b q(int i) {
            int iBinarySearch = Arrays.binarySearch(ClassFileWriter.this.a, 0, ClassFileWriter.this.b, i);
            if (iBinarySearch < 0) {
                iBinarySearch = (-iBinarySearch) - 2;
            }
            if (iBinarySearch >= ClassFileWriter.this.b) {
                defpackage.b.a("bad offset: ", i);
                return null;
            }
            org.mozilla.classfile.b bVar = this.g[iBinarySearch];
            if (i >= bVar.e() && i < bVar.a()) {
                return bVar;
            }
            Kit.codeBug();
            return bVar;
        }

        public final int r() {
            return (this.g.length - 1) * ((ClassFileWriter.this.o * 3) + 7 + (ClassFileWriter.this.n * 3));
        }

        public final void s(int i, int i2) {
            t(i, i2, this.a, this.b);
            t(i, i2, this.c, this.d);
        }

        public final void t(int i, int i2, int[] iArr, int i3) {
            for (int i4 = 0; i4 < i3; i4++) {
                if (iArr[i4] == i) {
                    iArr[i4] = i2;
                }
            }
        }

        public final boolean u(int i) {
            switch (i) {
                case Token.SETPROP_OP /* 153 */:
                case Token.SETELEM_OP /* 154 */:
                case Token.LOCAL_BLOCK /* 155 */:
                case Token.SET_REF_OP /* 156 */:
                case Token.DOTDOT /* 157 */:
                case Token.COLONCOLON /* 158 */:
                case Token.XML /* 159 */:
                case 160:
                case Token.XMLATTR /* 161 */:
                case Token.XMLEND /* 162 */:
                case Token.TO_OBJECT /* 163 */:
                case Token.TO_DOUBLE /* 164 */:
                case Token.GET /* 165 */:
                case Token.SET /* 166 */:
                case Token.LET /* 167 */:
                    return true;
                default:
                    switch (i) {
                        case 198:
                        case 199:
                        case 200:
                            return true;
                        default:
                            return false;
                    }
            }
        }

        public final boolean v(int i) {
            if (i == 167 || i == 191 || i == 200 || i == 176 || i == 177) {
                return true;
            }
            switch (i) {
                case 170:
                case Token.ARRAYCOMP /* 171 */:
                case Token.LETEXPR /* 172 */:
                case Token.WITHEXPR /* 173 */:
                case Token.DEBUGGER /* 174 */:
                    return true;
                default:
                    return false;
            }
        }

        public final void w(org.mozilla.classfile.b bVar) {
            int[] iArrC;
            ClassFileWriter classFileWriter;
            int[] iArrC2 = new int[0];
            int[] iArr = {uu4.b("java/lang/Throwable", ClassFileWriter.this.k)};
            int iE = bVar.e();
            int i = 0;
            while (true) {
                if (i >= ClassFileWriter.this.f) {
                    break;
                }
                kv0 kv0Var = ClassFileWriter.this.e[i];
                int iM0 = ClassFileWriter.this.m0(kv0Var.a);
                if (iE > iM0 && iE < ClassFileWriter.this.m0(kv0Var.b)) {
                    org.mozilla.classfile.b bVarQ = q(ClassFileWriter.this.m0(kv0Var.c));
                    iArrC = bVarQ.c();
                    if (bVarQ.h()) {
                        break;
                    } else {
                        iArrC2 = iArrC;
                    }
                } else if (iM0 > iE && iM0 < bVar.a()) {
                    org.mozilla.classfile.b bVarQ2 = q(ClassFileWriter.this.m0(kv0Var.c));
                    if (bVarQ2.h()) {
                        iArrC2 = bVarQ2.c();
                        break;
                    }
                }
                i++;
            }
            iArrC = iArrC2;
            int i2 = 0;
            while (i2 < ClassFileWriter.this.f) {
                kv0 kv0Var2 = ClassFileWriter.this.e[i2];
                if (ClassFileWriter.this.m0(kv0Var2.a) == bVar.e() || ClassFileWriter.this.m0(kv0Var2.c) == bVar.e()) {
                    int i3 = i2 + 1;
                    while (true) {
                        int i4 = ClassFileWriter.this.f;
                        classFileWriter = ClassFileWriter.this;
                        if (i3 >= i4) {
                            break;
                        }
                        classFileWriter.e[i3 - 1] = ClassFileWriter.this.e[i3];
                        i3++;
                    }
                    classFileWriter.f--;
                    i2--;
                }
                i2++;
            }
            bVar.i(iArrC, iArrC.length, iArr, 1, ClassFileWriter.this.k);
            int iA = bVar.a() - 1;
            ClassFileWriter.this.i[iA] = -65;
            for (int iE2 = bVar.e(); iE2 < iA; iE2++) {
                ClassFileWriter.this.i[iE2] = 0;
            }
        }

        public final int x() {
            int[] iArr = this.c;
            int i = this.d - 1;
            this.d = i;
            return iArr[i];
        }

        public final long y() {
            long jX = x();
            return uu4.i((int) jX) ? jX : (jX << 32) | ((long) (x() & 16777215));
        }

        public final void z(int i) {
            int i2 = this.d;
            if (i2 == this.c.length) {
                int[] iArr = new int[Math.max(i2 * 2, 4)];
                System.arraycopy(this.c, 0, iArr, 0, this.d);
                this.c = iArr;
            }
            int[] iArr2 = this.c;
            int i3 = this.d;
            this.d = i3 + 1;
            iArr2[i3] = i;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0077  */
    static {
        /*
            r0 = 1
            r1 = 50
            r2 = 0
            r3 = 48
            java.io.InputStream r4 = B0()     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67
            if (r4 == 0) goto L3e
            r5 = 8
            byte[] r6 = new byte[r5]     // Catch: java.lang.Throwable -> L23
            r7 = r2
        L11:
            if (r7 >= r5) goto L26
            int r8 = 8 - r7
            int r8 = r4.read(r6, r7, r8)     // Catch: java.lang.Throwable -> L23
            if (r8 < 0) goto L1d
            int r7 = r7 + r8
            goto L11
        L1d:
            java.io.IOException r5 = new java.io.IOException     // Catch: java.lang.Throwable -> L23
            r5.<init>()     // Catch: java.lang.Throwable -> L23
            throw r5     // Catch: java.lang.Throwable -> L23
        L23:
            r5 = move-exception
            r7 = r2
            goto L59
        L26:
            r7 = 4
            r7 = r6[r7]     // Catch: java.lang.Throwable -> L23
            int r7 = r7 << r5
            r8 = 5
            r8 = r6[r8]     // Catch: java.lang.Throwable -> L23
            r8 = r8 & 255(0xff, float:3.57E-43)
            r7 = r7 | r8
            r8 = 6
            r8 = r6[r8]     // Catch: java.lang.Throwable -> L3c
            int r5 = r8 << 8
            r8 = 7
            r3 = r6[r8]     // Catch: java.lang.Throwable -> L3c
            r3 = r3 & 255(0xff, float:3.57E-43)
            r3 = r3 | r5
            goto L46
        L3c:
            r5 = move-exception
            goto L59
        L3e:
            java.io.PrintStream r5 = java.lang.System.err     // Catch: java.lang.Throwable -> L23
            java.lang.String r6 = "Warning: Unable to read ClassFileWriter.class, using default bytecode version"
            r5.println(r6)     // Catch: java.lang.Throwable -> L23
            r7 = r2
        L46:
            if (r4 == 0) goto L4e
            r4.close()     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L68
            goto L4e
        L4c:
            r4 = move-exception
            goto L70
        L4e:
            org.mozilla.classfile.ClassFileWriter.F = r7
            org.mozilla.classfile.ClassFileWriter.E = r3
            if (r3 < r1) goto L55
            goto L56
        L55:
            r0 = r2
        L56:
            org.mozilla.classfile.ClassFileWriter.G = r0
            return
        L59:
            if (r4 == 0) goto L63
            r4.close()     // Catch: java.lang.Throwable -> L5f
            goto L63
        L5f:
            r4 = move-exception
            r5.addSuppressed(r4)     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L68
        L63:
            throw r5     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L68
        L64:
            r4 = move-exception
            r7 = r2
            goto L70
        L67:
            r7 = r2
        L68:
            java.lang.AssertionError r4 = new java.lang.AssertionError     // Catch: java.lang.Throwable -> L4c
            java.lang.String r5 = "Can't read ClassFileWriter.class to get bytecode version"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L4c
            throw r4     // Catch: java.lang.Throwable -> L4c
        L70:
            org.mozilla.classfile.ClassFileWriter.F = r7
            org.mozilla.classfile.ClassFileWriter.E = r3
            if (r3 < r1) goto L77
            goto L78
        L77:
            r0 = r2
        L78:
            org.mozilla.classfile.ClassFileWriter.G = r0
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.classfile.ClassFileWriter.<clinit>():void");
    }

    public ClassFileWriter(String str, String str2, String str3) {
        this.d = str;
        org.mozilla.classfile.a aVar = new org.mozilla.classfile.a(this);
        this.k = aVar;
        this.t = aVar.a(str);
        this.u = this.k.a(str2);
        if (str3 != null) {
            this.v = this.k.n(str3);
        }
        this.s = 33;
    }

    public static int A0(long j, byte[] bArr, int i) {
        return z0((int) j, bArr, z0((int) (j >>> 32), bArr, i));
    }

    public static InputStream B0() {
        InputStream resourceAsStream = ClassFileWriter.class.getResourceAsStream("ClassFileWriter.class");
        return resourceAsStream == null ? ClassLoader.getSystemResourceAsStream("org/mozilla/classfile/ClassFileWriter.class") : resourceAsStream;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:21:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ba A[FALL_THROUGH, PHI: r6
      0x00ba: PHI (r6v3 int) = (r6v2 int), (r6v2 int), (r6v2 int), (r6v2 int), (r6v6 int), (r6v2 int), (r6v2 int), (r6v2 int) binds: [B:48:0x00a1, B:49:0x00a3, B:50:0x00a5, B:53:0x00ab, B:59:0x00b8, B:55:0x00af, B:56:0x00b1, B:57:0x00b3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ba A[PHI: r6
      0x00ba: PHI (r6v3 int) = (r6v2 int), (r6v2 int), (r6v2 int), (r6v2 int), (r6v6 int), (r6v2 int), (r6v2 int), (r6v2 int) binds: [B:48:0x00a1, B:49:0x00a3, B:50:0x00a5, B:53:0x00ab, B:59:0x00b8, B:55:0x00af, B:56:0x00b1, B:57:0x00b3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int E0(java.lang.String r17) {
        /*
            Method dump skipped, instruction units count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.classfile.ClassFileWriter.E0(java.lang.String):int");
    }

    public static int F0(int i) {
        if (i == 254 || i == 255) {
            return 0;
        }
        switch (i) {
            case 0:
            case Token.NULL /* 47 */:
            case Token.FALSE /* 49 */:
            case Token.RC /* 95 */:
            case Token.COLON /* 116 */:
            case Token.OR /* 117 */:
            case Token.AND /* 118 */:
            case Token.INC /* 119 */:
            case Token.FOR /* 132 */:
            case Token.CONTINUE /* 134 */:
            case Token.FINALLY /* 138 */:
            case Token.VOID /* 139 */:
            case Token.BLOCK /* 143 */:
            case Token.TARGET /* 145 */:
            case Token.LOOP /* 146 */:
            case Token.EXPR_VOID /* 147 */:
            case Token.LET /* 167 */:
            case Token.SETCONST /* 169 */:
            case Token.METHOD /* 177 */:
            case Token.ARROW /* 178 */:
            case Token.YIELD_STAR /* 179 */:
            case Token.DOTDOTDOT /* 184 */:
            case Token.QUESTION_DOT /* 186 */:
            case 188:
            case 189:
            case 190:
            case 192:
            case 193:
            case 196:
            case 200:
            case 202:
                return 0;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 12:
            case 13:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 23:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case Token.GETPROPNOWARN /* 34 */:
            case 35:
            case 36:
            case Token.SETPROP /* 37 */:
            case Token.SETELEM_SUPER /* 42 */:
            case Token.CALL /* 43 */:
            case Token.NAME /* 44 */:
            case Token.NUMBER /* 45 */:
            case 89:
            case 90:
            case Token.SEMI /* 91 */:
            case Token.BREAK /* 133 */:
            case Token.VAR /* 135 */:
            case 140:
            case Token.EMPTY /* 141 */:
            case Token.CONST /* 168 */:
            case Token.LAST_TOKEN /* 187 */:
            case 197:
            case 201:
                return 1;
            case 9:
            case 10:
            case 14:
            case 15:
            case 20:
            case 22:
            case 24:
            case 30:
            case 31:
            case 32:
            case 33:
            case Token.SETPROP_SUPER /* 38 */:
            case Token.GETELEM /* 39 */:
            case 40:
            case Token.SETELEM /* 41 */:
            case Token.LB /* 92 */:
            case Token.RB /* 93 */:
            case Token.LC /* 94 */:
                return 2;
            case Token.STRING /* 46 */:
            case 48:
            case 50:
            case Token.SHEQ /* 51 */:
            case Token.SHNE /* 52 */:
            case Token.REGEXP /* 53 */:
            case Token.BINDNAME /* 54 */:
            case Token.RETHROW /* 56 */:
            case Token.INSTANCEOF /* 58 */:
            case Token.LOCAL_LOAD /* 59 */:
            case 60:
            case Token.SETVAR /* 61 */:
            case Token.CATCH_SCOPE /* 62 */:
            case Token.ENUM_NEXT /* 67 */:
            case Token.ENUM_ID /* 68 */:
            case Token.THISFN /* 69 */:
            case 70:
            case Token.DEL_REF /* 75 */:
            case Token.REF_CALL /* 76 */:
            case Token.REF_SPECIAL /* 77 */:
            case Token.YIELD /* 78 */:
            case Token.REF_NAME /* 87 */:
            case Token.LP /* 96 */:
            case Token.COMMA /* 98 */:
            case 100:
            case 102:
            case Token.ASSIGN_LOGICAL_AND /* 104 */:
            case Token.ASSIGN_RSH /* 106 */:
            case Token.ASSIGN_ADD /* 108 */:
            case 110:
            case Token.ASSIGN_MOD /* 112 */:
            case 114:
            case 120:
            case Token.DOT /* 121 */:
            case Token.FUNCTION /* 122 */:
            case Token.EXPORT /* 123 */:
            case Token.IMPORT /* 124 */:
            case Token.IF /* 125 */:
            case 126:
            case 128:
            case 130:
            case Token.WITH /* 136 */:
            case Token.CATCH /* 137 */:
            case Token.COMPUTED_PROPERTY /* 142 */:
            case Token.LABEL /* 144 */:
            case Token.JSR /* 149 */:
            case 150:
            case Token.SETPROP_OP /* 153 */:
            case Token.SETELEM_OP /* 154 */:
            case Token.LOCAL_BLOCK /* 155 */:
            case Token.SET_REF_OP /* 156 */:
            case Token.DOTDOT /* 157 */:
            case Token.COLONCOLON /* 158 */:
            case 170:
            case Token.ARRAYCOMP /* 171 */:
            case Token.LETEXPR /* 172 */:
            case Token.DEBUGGER /* 174 */:
            case Token.GENEXPR /* 176 */:
            case 180:
            case Token.TEMPLATE_CHARS /* 181 */:
            case Token.TEMPLATE_LITERAL_SUBST /* 182 */:
            case Token.TAGGED_TEMPLATE_LITERAL /* 183 */:
            case Token.NULLISH_COALESCING /* 185 */:
            case 191:
            case 194:
            case 195:
            case 198:
            case 199:
                return -1;
            case Token.THROW /* 55 */:
            case Token.IN /* 57 */:
            case Token.ENUM_INIT_KEYS /* 63 */:
            case 64:
            case Token.ENUM_INIT_ARRAY /* 65 */:
            case Token.ENUM_INIT_VALUES_IN_ORDER /* 66 */:
            case Token.ARRAYLIT /* 71 */:
            case Token.OBJECTLIT /* 72 */:
            case Token.GET_REF /* 73 */:
            case Token.SET_REF /* 74 */:
            case Token.REF_NS_NAME /* 88 */:
            case Token.RP /* 97 */:
            case 99:
            case 101:
            case 103:
            case Token.ASSIGN_LSH /* 105 */:
            case Token.ASSIGN_URSH /* 107 */:
            case Token.ASSIGN_SUB /* 109 */:
            case Token.ASSIGN_DIV /* 111 */:
            case Token.ASSIGN_EXP /* 113 */:
            case Token.HOOK /* 115 */:
            case 127:
            case Token.DEFAULT /* 129 */:
            case Token.DO /* 131 */:
            case Token.XML /* 159 */:
            case 160:
            case Token.XMLATTR /* 161 */:
            case Token.XMLEND /* 162 */:
            case Token.TO_OBJECT /* 163 */:
            case Token.TO_DOUBLE /* 164 */:
            case Token.GET /* 165 */:
            case Token.SET /* 166 */:
            case Token.WITHEXPR /* 173 */:
            case Token.COMMENT /* 175 */:
                return -2;
            case Token.SUPER /* 79 */:
            case Token.EXP /* 81 */:
            case Token.ESCXMLATTR /* 83 */:
            case Token.ESCXMLTEXT /* 84 */:
            case Token.REF_MEMBER /* 85 */:
            case Token.REF_NS_MEMBER /* 86 */:
            case Token.EXPR_RESULT /* 148 */:
            case Token.TYPEOFNAME /* 151 */:
            case Token.USE_STACK /* 152 */:
                return -3;
            case Token.STRICT_SETNAME /* 80 */:
            case Token.DEFAULTNAMESPACE /* 82 */:
                return -4;
            default:
                defpackage.b.a("Bad opcode: ", i);
                return 0;
        }
    }

    public static char b0(int i) {
        switch (i) {
            case 4:
                return 'Z';
            case 5:
                return 'C';
            case 6:
                return 'F';
            case 7:
                return 'D';
            case 8:
                return 'B';
            case 9:
                return 'S';
            case 10:
                return 'I';
            case 11:
                return 'J';
            default:
                jl.a("bad operand");
                return (char) 0;
        }
    }

    public static void c0(int i) {
        String str;
        if (i < 0) {
            str = "Stack underflow: " + i;
        } else {
            str = "Too big stack: " + i;
        }
        throw new IllegalStateException(str);
    }

    public static String d0(String str) {
        return str.substring(1, str.length() - 1);
    }

    public static String e0(String str) {
        int length = str.length();
        int i = length + 1;
        int i2 = length + 2;
        char[] cArr = new char[i2];
        cArr[0] = 'L';
        cArr[i] = ';';
        str.getChars(0, length, cArr, 1);
        for (int i3 = 1; i3 != i; i3++) {
            if (cArr[i3] == '.') {
                cArr[i3] = '/';
            }
        }
        return new String(cArr, 0, i2);
    }

    public static String g0(String str) {
        char cCharAt = str.charAt(0);
        if (cCharAt == 'F') {
            return str;
        }
        if (cCharAt == 'L') {
            return d0(str);
        }
        if (cCharAt == 'S' || cCharAt == 'V' || cCharAt == 'I' || cCharAt == 'J' || cCharAt == 'Z' || cCharAt == '[') {
            return str;
        }
        switch (cCharAt) {
            case Token.ENUM_INIT_VALUES_IN_ORDER /* 66 */:
            case Token.ENUM_NEXT /* 67 */:
            case Token.ENUM_ID /* 68 */:
                return str;
            default:
                jl.a("bad descriptor:".concat(str));
                return null;
        }
    }

    public static String n0(String str) {
        return str.replace('.', '/');
    }

    public static int w0(int i) {
        if (i == 254 || i == 255) {
            return 0;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case Token.GETPROPNOWARN /* 34 */:
            case 35:
            case 36:
            case Token.SETPROP /* 37 */:
            case Token.SETPROP_SUPER /* 38 */:
            case Token.GETELEM /* 39 */:
            case 40:
            case Token.SETELEM /* 41 */:
            case Token.SETELEM_SUPER /* 42 */:
            case Token.CALL /* 43 */:
            case Token.NAME /* 44 */:
            case Token.NUMBER /* 45 */:
            case Token.STRING /* 46 */:
            case Token.NULL /* 47 */:
            case 48:
            case Token.FALSE /* 49 */:
            case 50:
            case Token.SHEQ /* 51 */:
            case Token.SHNE /* 52 */:
            case Token.REGEXP /* 53 */:
            case Token.LOCAL_LOAD /* 59 */:
            case 60:
            case Token.SETVAR /* 61 */:
            case Token.CATCH_SCOPE /* 62 */:
            case Token.ENUM_INIT_KEYS /* 63 */:
            case 64:
            case Token.ENUM_INIT_ARRAY /* 65 */:
            case Token.ENUM_INIT_VALUES_IN_ORDER /* 66 */:
            case Token.ENUM_NEXT /* 67 */:
            case Token.ENUM_ID /* 68 */:
            case Token.THISFN /* 69 */:
            case 70:
            case Token.ARRAYLIT /* 71 */:
            case Token.OBJECTLIT /* 72 */:
            case Token.GET_REF /* 73 */:
            case Token.SET_REF /* 74 */:
            case Token.DEL_REF /* 75 */:
            case Token.REF_CALL /* 76 */:
            case Token.REF_SPECIAL /* 77 */:
            case Token.YIELD /* 78 */:
            case Token.SUPER /* 79 */:
            case Token.STRICT_SETNAME /* 80 */:
            case Token.EXP /* 81 */:
            case Token.DEFAULTNAMESPACE /* 82 */:
            case Token.ESCXMLATTR /* 83 */:
            case Token.ESCXMLTEXT /* 84 */:
            case Token.REF_MEMBER /* 85 */:
            case Token.REF_NS_MEMBER /* 86 */:
            case Token.REF_NAME /* 87 */:
            case Token.REF_NS_NAME /* 88 */:
            case 89:
            case 90:
            case Token.SEMI /* 91 */:
            case Token.LB /* 92 */:
            case Token.RB /* 93 */:
            case Token.LC /* 94 */:
            case Token.RC /* 95 */:
            case Token.LP /* 96 */:
            case Token.RP /* 97 */:
            case Token.COMMA /* 98 */:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case Token.ASSIGN_LOGICAL_AND /* 104 */:
            case Token.ASSIGN_LSH /* 105 */:
            case Token.ASSIGN_RSH /* 106 */:
            case Token.ASSIGN_URSH /* 107 */:
            case Token.ASSIGN_ADD /* 108 */:
            case Token.ASSIGN_SUB /* 109 */:
            case 110:
            case Token.ASSIGN_DIV /* 111 */:
            case Token.ASSIGN_MOD /* 112 */:
            case Token.ASSIGN_EXP /* 113 */:
            case 114:
            case Token.HOOK /* 115 */:
            case Token.COLON /* 116 */:
            case Token.OR /* 117 */:
            case Token.AND /* 118 */:
            case Token.INC /* 119 */:
            case 120:
            case Token.DOT /* 121 */:
            case Token.FUNCTION /* 122 */:
            case Token.EXPORT /* 123 */:
            case Token.IMPORT /* 124 */:
            case Token.IF /* 125 */:
            case 126:
            case 127:
            case 128:
            case Token.DEFAULT /* 129 */:
            case 130:
            case Token.DO /* 131 */:
            case Token.BREAK /* 133 */:
            case Token.CONTINUE /* 134 */:
            case Token.VAR /* 135 */:
            case Token.WITH /* 136 */:
            case Token.CATCH /* 137 */:
            case Token.FINALLY /* 138 */:
            case Token.VOID /* 139 */:
            case 140:
            case Token.EMPTY /* 141 */:
            case Token.COMPUTED_PROPERTY /* 142 */:
            case Token.BLOCK /* 143 */:
            case Token.LABEL /* 144 */:
            case Token.TARGET /* 145 */:
            case Token.LOOP /* 146 */:
            case Token.EXPR_VOID /* 147 */:
            case Token.EXPR_RESULT /* 148 */:
            case Token.JSR /* 149 */:
            case 150:
            case Token.TYPEOFNAME /* 151 */:
            case Token.USE_STACK /* 152 */:
            case Token.LETEXPR /* 172 */:
            case Token.WITHEXPR /* 173 */:
            case Token.DEBUGGER /* 174 */:
            case Token.COMMENT /* 175 */:
            case Token.GENEXPR /* 176 */:
            case Token.METHOD /* 177 */:
                return 0;
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case Token.BINDNAME /* 54 */:
            case Token.THROW /* 55 */:
            case Token.RETHROW /* 56 */:
            case Token.IN /* 57 */:
            case Token.INSTANCEOF /* 58 */:
            case Token.SETPROP_OP /* 153 */:
            case Token.SETELEM_OP /* 154 */:
            case Token.LOCAL_BLOCK /* 155 */:
            case Token.SET_REF_OP /* 156 */:
            case Token.DOTDOT /* 157 */:
            case Token.COLONCOLON /* 158 */:
            case Token.XML /* 159 */:
            case 160:
            case Token.XMLATTR /* 161 */:
            case Token.XMLEND /* 162 */:
            case Token.TO_OBJECT /* 163 */:
            case Token.TO_DOUBLE /* 164 */:
            case Token.GET /* 165 */:
            case Token.SET /* 166 */:
            case Token.LET /* 167 */:
            case Token.CONST /* 168 */:
            case Token.SETCONST /* 169 */:
            case Token.ARROW /* 178 */:
            case Token.YIELD_STAR /* 179 */:
            case 180:
            case Token.TEMPLATE_CHARS /* 181 */:
            case Token.TEMPLATE_LITERAL_SUBST /* 182 */:
            case Token.TAGGED_TEMPLATE_LITERAL /* 183 */:
            case Token.DOTDOTDOT /* 184 */:
            case Token.NULLISH_COALESCING /* 185 */:
                return 1;
            case Token.FOR /* 132 */:
                return 2;
            case 170:
            case Token.ARRAYCOMP /* 171 */:
                return -1;
            default:
                switch (i) {
                    case Token.LAST_TOKEN /* 187 */:
                    case 188:
                    case 189:
                    case 192:
                    case 193:
                    case 198:
                    case 199:
                    case 200:
                    case 201:
                        return 1;
                    case 190:
                    case 191:
                    case 194:
                    case 195:
                    case 196:
                    case 202:
                        return 0;
                    case 197:
                        return 2;
                    default:
                        defpackage.b.a("Bad opcode: ", i);
                        return 0;
                }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0023 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0024 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int x0(int r3, boolean r4) {
        /*
            Method dump skipped, instruction units count: 450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.classfile.ClassFileWriter.x0(int, boolean):int");
    }

    public static int y0(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >>> 8);
        bArr[i2 + 1] = (byte) i;
        return i2 + 2;
    }

    public static int z0(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >>> 24);
        bArr[i2 + 1] = (byte) (i >>> 16);
        bArr[i2 + 2] = (byte) (i >>> 8);
        bArr[i2 + 3] = (byte) i;
        return i2 + 4;
    }

    public void A(int i) {
        J0(34, 23, i);
    }

    public void B(String str, String str2, short s) {
        this.q.add(new mu(this.k.n(str), this.k.n(str2), s));
    }

    public void C(int i) {
        J0(26, 21, i);
    }

    public void C0(short s) {
        this.m = s;
    }

    public void D(int i) {
        J0(59, 54, i);
    }

    public void D0(int i, int i2, int i3) {
        int i4;
        if (i3 < 0 || (i4 = this.j) < i3) {
            defpackage.b.a("Bad jump target: ", i3);
            return;
        }
        if (i2 < -1) {
            defpackage.b.a("Bad case index: ", i2);
            return;
        }
        int i5 = (~i) & 3;
        int i6 = i2 < 0 ? i + 1 + i5 : i + 1 + i5 + ((i2 + 3) * 4);
        if (i < 0 || ((i4 - 16) - i5) - 1 < i) {
            throw new IllegalArgumentException(i + " is outside a possible range of tableswitch in already generated code");
        }
        byte[] bArr = this.i;
        if ((bArr[i] & 255) != 170) {
            throw new IllegalArgumentException(i + " is not offset of tableswitch statement");
        }
        if (i6 >= 0 && i4 >= i6 + 4) {
            z0(i3 - i, bArr, i6);
        } else {
            throw new b("Too big case index: " + i2);
        }
    }

    public void E(String str) {
        this.r.add(Short.valueOf(this.k.a(str)));
    }

    public void F(int i, String str, String str2, String str3) {
        int iE0 = E0(str3);
        int i2 = iE0 >>> 16;
        int iF0 = this.m + ((short) iE0) + F0(i);
        if (iF0 < 0 || 32767 < iF0) {
            c0(iF0);
        }
        switch (i) {
            case Token.TEMPLATE_LITERAL_SUBST /* 182 */:
            case Token.TAGGED_TEMPLATE_LITERAL /* 183 */:
            case Token.DOTDOTDOT /* 184 */:
            case Token.NULLISH_COALESCING /* 185 */:
                X(i);
                org.mozilla.classfile.a aVar = this.k;
                if (i == 185) {
                    Y(aVar.i(str, str2, str3));
                    X(i2 + 1);
                    X(0);
                } else {
                    Y(aVar.l(str, str2, str3));
                }
                short s = (short) iF0;
                this.m = s;
                if (iF0 > this.n) {
                    this.n = s;
                }
                break;
            default:
                jl.a("bad opcode for method reference");
                break;
        }
    }

    public void G(String str, String str2, c cVar, Object... objArr) {
        if (E < 51) {
            zt2.a("Please build and run with JDK 1.7 for invokedynamic support");
            return;
        }
        int iE0 = this.m + ((short) E0(str2));
        if (iE0 < 0 || 32767 < iE0) {
            c0(iE0);
        }
        a aVar = new a(cVar, objArr);
        if (this.B == null) {
            this.B = new ArrayList();
        }
        int iIndexOf = this.B.indexOf(aVar);
        if (iIndexOf == -1) {
            iIndexOf = this.B.size();
            this.B.add(aVar);
            this.C += aVar.a.length;
        }
        short sJ = this.k.j(str, str2, iIndexOf);
        X(Token.QUESTION_DOT);
        Y(sJ);
        Y(0);
        short s = (short) iE0;
        this.m = s;
        if (iE0 > this.n) {
            this.n = s;
        }
    }

    public void G0(String str, String str2, short s) {
        this.l = new nu(str, this.k.n(str), str2, this.k.n(str2), s);
        this.c = new HashMap();
        this.p.add(this.l);
        V(0);
    }

    public void H(int i) {
        J0(30, 22, i);
    }

    public void H0(int i) {
        d dVar;
        int iY0;
        int iD;
        if (this.l == null) {
            e04.a("No method to stop");
            return;
        }
        i0();
        this.o = i;
        if (G) {
            h0();
            dVar = new d();
            dVar.l();
        } else {
            dVar = null;
        }
        int i2 = this.g != null ? (this.h * 4) + 8 : 0;
        ArrayList arrayList = this.A;
        int size = arrayList != null ? (arrayList.size() * 10) + 8 : 0;
        int i3 = (dVar == null || (iD = dVar.d()) <= 0) ? 0 : iD + 6;
        int i4 = this.j + 16 + (this.f * 8) + 2 + i2 + size + i3;
        if (i4 > 65536) {
            throw new b("generated bytecode for method exceeds 64K limit.");
        }
        byte[] bArr = new byte[i4];
        int iZ0 = z0(this.j, bArr, y0(this.o, bArr, y0(this.n, bArr, z0(i4 - 6, bArr, y0(this.k.n("Code"), bArr, 0)))));
        System.arraycopy(this.i, 0, bArr, iZ0, this.j);
        int i5 = iZ0 + this.j;
        int i6 = this.f;
        if (i6 > 0) {
            iY0 = y0(i6, bArr, i5);
            for (int i7 = 0; i7 < this.f; i7++) {
                kv0 kv0Var = this.e[i7];
                int iM0 = m0(kv0Var.a);
                int iM02 = m0(kv0Var.b);
                int iM03 = m0(kv0Var.c);
                short s = kv0Var.d;
                if (iM0 == -1) {
                    e04.a("start label not defined");
                    return;
                }
                if (iM02 == -1) {
                    e04.a("end label not defined");
                    return;
                } else {
                    if (iM03 == -1) {
                        e04.a("handler label not defined");
                        return;
                    }
                    iY0 = y0(s, bArr, y0(iM03, bArr, y0(iM02, bArr, y0(iM0, bArr, iY0))));
                }
            }
        } else {
            iY0 = y0(0, bArr, i5);
        }
        int i8 = this.g != null ? 1 : 0;
        if (this.A != null) {
            i8++;
        }
        if (i3 > 0) {
            i8++;
        }
        int iY02 = y0(i8, bArr, iY0);
        if (this.g != null) {
            iY02 = y0(this.h, bArr, z0((this.h * 4) + 2, bArr, y0(this.k.n("LineNumberTable"), bArr, iY02)));
            for (int i9 = 0; i9 < this.h; i9++) {
                iY02 = z0(this.g[i9], bArr, iY02);
            }
        }
        if (this.A != null) {
            int iY03 = y0(this.k.n("LocalVariableTable"), bArr, iY02);
            int size2 = this.A.size();
            iY02 = y0(size2, bArr, z0((size2 * 10) + 2, bArr, iY03));
            for (int i10 = 0; i10 < size2; i10++) {
                int[] iArr = (int[]) this.A.get(i10);
                int i11 = iArr[0];
                int i12 = iArr[1];
                int i13 = iArr[2];
                iY02 = y0(iArr[3], bArr, y0(i12, bArr, y0(i11, bArr, y0(this.j - i13, bArr, y0(i13, bArr, iY02)))));
            }
        }
        if (i3 > 0) {
            dVar.D(bArr, y0(this.k.n("StackMapTable"), bArr, iY02));
        }
        this.l.e(bArr);
        this.e = null;
        this.f = 0;
        this.h = 0;
        this.j = 0;
        this.l = null;
        this.n = 0;
        this.m = 0;
        this.x = 0;
        this.z = 0;
        this.A = null;
        this.a = null;
        this.b = 0;
        this.c = null;
    }

    public final void I(int i, int i2) {
        if (i >= 0) {
            jl.a("Bad label, no biscuit");
            return;
        }
        int i3 = i & Integer.MAX_VALUE;
        if (i3 >= this.x) {
            jl.a("Bad label");
            return;
        }
        int i4 = this.z;
        long[] jArr = this.y;
        if (jArr == null || i4 == jArr.length) {
            if (jArr == null) {
                this.y = new long[40];
            } else {
                long[] jArr2 = new long[jArr.length * 2];
                System.arraycopy(jArr, 0, jArr2, 0, i4);
                this.y = jArr2;
            }
        }
        this.z = i4 + 1;
        this.y[i4] = ((long) i2) | (((long) i3) << 32);
    }

    public byte[] I0() {
        short sN;
        int i;
        short sN2;
        if (this.B != null) {
            sN = this.k.n("BootstrapMethods");
            i = 1;
        } else {
            sN = 0;
            i = 0;
        }
        if (this.v != 0) {
            i++;
            sN2 = this.k.n("SourceFile");
        } else {
            sN2 = 0;
        }
        int iP0 = p0();
        byte[] bArr = new byte[iP0];
        int iY0 = y0(this.r.size(), bArr, y0(this.u, bArr, y0(this.t, bArr, y0(this.s, bArr, this.k.u(bArr, y0(E, bArr, y0(F, bArr, z0(-889275714, bArr, 0))))))));
        for (int i2 = 0; i2 < this.r.size(); i2++) {
            iY0 = y0(((Short) this.r.get(i2)).shortValue(), bArr, iY0);
        }
        int iY02 = y0(this.q.size(), bArr, iY0);
        for (int i3 = 0; i3 < this.q.size(); i3++) {
            iY02 = ((mu) this.q.get(i3)).b(bArr, iY02);
        }
        int iY03 = y0(this.p.size(), bArr, iY02);
        for (int i4 = 0; i4 < this.p.size(); i4++) {
            iY03 = ((nu) this.p.get(i4)).f(bArr, iY03);
        }
        int iY04 = y0(i, bArr, iY03);
        if (this.B != null) {
            iY04 = y0(this.B.size(), bArr, z0(this.C + 2, bArr, y0(sN, bArr, iY04)));
            for (int i5 = 0; i5 < this.B.size(); i5++) {
                a aVar = (a) this.B.get(i5);
                byte[] bArr2 = aVar.a;
                System.arraycopy(bArr2, 0, bArr, iY04, bArr2.length);
                iY04 += aVar.a.length;
            }
        }
        if (this.v != 0) {
            iY04 = y0(this.v, bArr, z0(2, bArr, y0(sN2, bArr, iY04)));
        }
        if (iY04 == iP0) {
            return bArr;
        }
        throw new RuntimeException();
    }

    public void J(short s) {
        if (this.l == null) {
            jl.a("No method to stop");
            return;
        }
        int i = this.h;
        if (i == 0) {
            this.g = new int[16];
        } else {
            int[] iArr = this.g;
            if (i == iArr.length) {
                int[] iArr2 = new int[i * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                this.g = iArr2;
            }
        }
        this.g[i] = (this.j << 16) + s;
        this.h = i + 1;
    }

    public final void J0(int i, int i2, int i3) {
        if (i3 == 0) {
            r(i);
            return;
        }
        if (i3 == 1) {
            r(i + 1);
            return;
        }
        if (i3 == 2) {
            r(i + 2);
        } else if (i3 != 3) {
            s(i2, i3);
        } else {
            r(i + 3);
        }
    }

    public void K(double d2) {
        s(20, this.k.b(d2));
    }

    public void L(int i) {
        if (i == 0) {
            r(3);
            return;
        }
        if (i == 1) {
            r(4);
            return;
        }
        if (i == 2) {
            r(5);
            return;
        }
        if (i == 3) {
            r(6);
            return;
        }
        if (i == 4) {
            r(7);
        } else if (i != 5) {
            s(18, this.k.d(i));
        } else {
            r(8);
        }
    }

    public void M(long j) {
        s(20, this.k.e(j));
    }

    public void N(String str) {
        s(18, this.k.g(str));
    }

    public void O() {
        r(42);
    }

    public void P(double d2) {
        if (d2 == 0.0d) {
            r(14);
            if (1.0d / d2 < 0.0d) {
                r(Token.INC);
                return;
            }
            return;
        }
        if (d2 != 1.0d && d2 != -1.0d) {
            K(d2);
            return;
        }
        r(15);
        if (d2 < 0.0d) {
            r(Token.INC);
        }
    }

    public void Q(int i) {
        byte b2 = (byte) i;
        if (b2 != i) {
            short s = (short) i;
            if (s == i) {
                s(17, s);
                return;
            } else {
                L(i);
                return;
            }
        }
        if (i == -1) {
            r(2);
        } else if (i < 0 || i > 5) {
            s(16, b2);
        } else {
            r((byte) (i + 3));
        }
    }

    public void R(long j) {
        int i = (int) j;
        if (i != j) {
            M(j);
        } else {
            Q(i);
            r(Token.BREAK);
        }
    }

    public void S(String str) {
        int length = str.length();
        int i = 0;
        int iR = this.k.r(str, 0, length);
        if (iR == length) {
            N(str);
            return;
        }
        t(Token.LAST_TOKEN, "java/lang/StringBuilder");
        r(89);
        Q(length);
        F(Token.TAGGED_TEMPLATE_LITERAL, "java/lang/StringBuilder", "<init>", "(I)V");
        while (true) {
            r(89);
            N(str.substring(i, iR));
            F(Token.TEMPLATE_LITERAL_SUBST, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            r(87);
            if (iR == length) {
                F(Token.TEMPLATE_LITERAL_SUBST, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
                return;
            } else {
                i = iR;
                iR = this.k.r(str, iR, length);
            }
        }
    }

    public void T(boolean z) {
        r(z ? 4 : 3);
    }

    public final int U(int i) {
        if (this.l == null) {
            jl.a("No method to add to");
            return 0;
        }
        int i2 = this.j;
        int i3 = i + i2;
        byte[] bArr = this.i;
        if (i3 > bArr.length) {
            int length = bArr.length * 2;
            if (i3 > length) {
                length = i3;
            }
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            this.i = bArr2;
        }
        this.j = i3;
        return i2;
    }

    public final void V(int i) {
        if (G) {
            int[] iArr = this.a;
            if (iArr == null) {
                this.a = new int[4];
            } else {
                int length = iArr.length;
                int i2 = this.b;
                if (length == i2) {
                    int[] iArr2 = new int[i2 * 2];
                    System.arraycopy(iArr, 0, iArr2, 0, i2);
                    this.a = iArr2;
                }
            }
            int[] iArr3 = this.a;
            int i3 = this.b;
            this.b = i3 + 1;
            iArr3[i3] = i;
        }
    }

    public int W(int i, int i2) {
        byte[] bArr;
        if (i > i2) {
            throw new b("Bad bounds: " + i + " " + i2);
        }
        int iF0 = this.m + F0(170);
        if (iF0 < 0 || 32767 < iF0) {
            c0(iF0);
        }
        int i3 = (~this.j) & 3;
        int iU = U(i3 + 1 + (((i2 - i) + 4) * 4));
        int i4 = iU + 1;
        this.i[iU] = -86;
        while (true) {
            bArr = this.i;
            if (i3 == 0) {
                break;
            }
            bArr[i4] = 0;
            i3--;
            i4++;
        }
        z0(i2, this.i, z0(i, bArr, i4 + 4));
        short s = (short) iF0;
        this.m = s;
        if (iF0 > this.n) {
            this.n = s;
        }
        return iU;
    }

    public final void X(int i) {
        this.i[U(1)] = (byte) i;
    }

    public final void Y(int i) {
        y0(i, this.i, U(2));
    }

    public void Z(String str, String str2, int i, int i2) {
        int[] iArr = {this.k.n(str), this.k.n(str2), i, i2};
        if (this.A == null) {
            this.A = new ArrayList();
        }
        this.A.add(iArr);
    }

    public void a0(int i) {
        int i2 = this.m + i;
        if (i2 < 0 || 32767 < i2) {
            c0(i2);
        }
        short s = (short) i2;
        this.m = s;
        if (i2 > this.n) {
            this.n = s;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int[] f0() {
        /*
            r10 = this;
            int r0 = r10.o
            int[] r0 = new int[r0]
            nu r1 = r10.l
            short r1 = r1.a()
            r1 = r1 & 8
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L2c
            nu r1 = r10.l
            java.lang.String r1 = r1.b()
            java.lang.String r4 = "<init>"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L23
            r1 = 6
            r0[r3] = r1
        L21:
            r1 = r2
            goto L2d
        L23:
            int r1 = r10.t
            int r1 = defpackage.uu4.a(r1)
            r0[r3] = r1
            goto L21
        L2c:
            r1 = r3
        L2d:
            nu r4 = r10.l
            java.lang.String r4 = r4.c()
            r5 = 40
            int r5 = r4.indexOf(r5)
            r6 = 41
            int r6 = r4.indexOf(r6)
            if (r5 != 0) goto Laf
            if (r6 < 0) goto Laf
            int r5 = r5 + r2
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
        L49:
            if (r5 >= r6) goto Lae
            char r8 = r4.charAt(r5)
            r9 = 70
            if (r8 == r9) goto L85
            r9 = 76
            if (r8 == r9) goto L75
            r9 = 83
            if (r8 == r9) goto L85
            r9 = 73
            if (r8 == r9) goto L85
            r9 = 74
            if (r8 == r9) goto L85
            r9 = 90
            if (r8 == r9) goto L85
            r9 = 91
            if (r8 == r9) goto L6f
            switch(r8) {
                case 66: goto L85;
                case 67: goto L85;
                case 68: goto L85;
                default: goto L6e;
            }
        L6e:
            goto L8e
        L6f:
            r7.append(r9)
            int r5 = r5 + 1
            goto L49
        L75:
            r8 = 59
            int r8 = r4.indexOf(r8, r5)
            int r8 = r8 + r2
            java.lang.String r5 = r4.substring(r5, r8)
            r7.append(r5)
            r5 = r8
            goto L8e
        L85:
            char r8 = r4.charAt(r5)
            r7.append(r8)
            int r5 = r5 + 1
        L8e:
            java.lang.String r8 = r7.toString()
            java.lang.String r8 = g0(r8)
            org.mozilla.classfile.a r9 = r10.k
            int r8 = defpackage.uu4.d(r8, r9)
            int r9 = r1 + 1
            r0[r1] = r8
            boolean r8 = defpackage.uu4.i(r8)
            if (r8 == 0) goto La9
            int r1 = r1 + 2
            goto Laa
        La9:
            r1 = r9
        Laa:
            r7.setLength(r3)
            goto L49
        Lae:
            return r0
        Laf:
            java.lang.String r10 = "bad method type"
            defpackage.jl.a(r10)
            r10 = 0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.classfile.ClassFileWriter.f0():int[]");
    }

    public final void h0() {
        if (G) {
            for (int i = 0; i < this.f; i++) {
                V(m0(this.e[i].c));
            }
            Arrays.sort(this.a, 0, this.b);
            int i2 = this.a[0];
            int i3 = 1;
            for (int i4 = 1; i4 < this.b; i4++) {
                int[] iArr = this.a;
                int i5 = iArr[i4];
                if (i2 != i5) {
                    if (i3 != i4) {
                        iArr[i3] = i5;
                    }
                    i3++;
                    i2 = i5;
                }
            }
            this.b = i3;
            if (this.a[i3 - 1] == this.j) {
                this.b = i3 - 1;
            }
        }
    }

    public final void i0() {
        byte[] bArr = this.i;
        for (int i = 0; i < this.z; i++) {
            long j = this.y[i];
            int i2 = (int) (j >> 32);
            int i3 = (int) j;
            int i4 = this.w[i2];
            if (i4 == -1) {
                zt2.a("unlocated label");
                return;
            }
            V(i4);
            int i5 = i3 - 1;
            this.c.put(Integer.valueOf(i4), Integer.valueOf(i5));
            int i6 = i4 - i5;
            if (((short) i6) != i6) {
                throw new b("Program too complex: too big jump offset");
            }
            bArr[i3] = (byte) (i6 >> 8);
            bArr[i3 + 1] = (byte) i6;
        }
        this.z = 0;
    }

    public final char[] j0(int i) {
        char[] cArr = this.D;
        if (i > cArr.length) {
            int length = cArr.length * 2;
            if (i <= length) {
                i = length;
            }
            this.D = new char[i];
        }
        return this.D;
    }

    public final String k0() {
        return this.d;
    }

    public int l0() {
        return this.j;
    }

    public int m0(int i) {
        if (i >= 0) {
            jl.a("Bad label, no biscuit");
            return 0;
        }
        int i2 = i & Integer.MAX_VALUE;
        if (i2 < this.x) {
            return this.w[i2];
        }
        jl.a("Bad label");
        return 0;
    }

    public int o0() {
        return this.m;
    }

    public final int p0() {
        if (this.v != 0) {
            this.k.n("SourceFile");
        }
        int iS = this.k.s() + 16 + (this.r.size() * 2) + 2;
        for (int i = 0; i < this.q.size(); i++) {
            iS += ((mu) this.q.get(i)).a();
        }
        int iD = iS + 2;
        for (int i2 = 0; i2 < this.p.size(); i2++) {
            iD += ((nu) this.p.get(i2)).d();
        }
        int i3 = iD + 2;
        if (this.v != 0) {
            i3 = iD + 10;
        }
        return this.B != null ? i3 + 8 + this.C : i3;
    }

    public int q() {
        int i = this.x;
        int[] iArr = this.w;
        if (iArr == null || i == iArr.length) {
            if (iArr == null) {
                this.w = new int[32];
            } else {
                int[] iArr2 = new int[iArr.length * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                this.w = iArr2;
            }
        }
        this.x = i + 1;
        this.w[i] = -1;
        return Integer.MIN_VALUE | i;
    }

    public void q0(int i) {
        this.m = 1;
        r0(i);
    }

    public void r(int i) {
        if (w0(i) != 0) {
            jl.a("Unexpected operands");
            return;
        }
        int iF0 = this.m + F0(i);
        if (iF0 < 0 || 32767 < iF0) {
            c0(iF0);
        }
        X(i);
        short s = (short) iF0;
        this.m = s;
        if (iF0 > this.n) {
            this.n = s;
        }
        if (i == 191) {
            V(this.j);
        }
    }

    public void r0(int i) {
        if (i >= 0) {
            jl.a("Bad label, no biscuit");
            return;
        }
        int i2 = i & Integer.MAX_VALUE;
        if (i2 > this.x) {
            jl.a("Bad label");
            return;
        }
        int[] iArr = this.w;
        if (iArr[i2] == -1) {
            iArr[i2] = this.j;
        } else {
            e04.a("Can only mark label once");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0042 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b4 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void s(int r6, int r7) {
        /*
            Method dump skipped, instruction units count: 384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.classfile.ClassFileWriter.s(int, int):void");
    }

    public void s0(int i, int i2) {
        r0(i);
        this.m = i2;
    }

    public void t(int i, String str) {
        int iF0 = this.m + F0(i);
        if (iF0 < 0 || 32767 < iF0) {
            c0(iF0);
        }
        if (i != 187 && i != 189 && i != 192 && i != 193) {
            jl.a("bad opcode for class reference");
            return;
        }
        short sA = this.k.a(str);
        X(i);
        Y(sA);
        short s = (short) iF0;
        this.m = s;
        if (iF0 > this.n) {
            this.n = s;
        }
    }

    public final void t0(int i, int i2) {
        V(this.j);
        this.c.put(Integer.valueOf(this.j), Integer.valueOf(i));
        D0(i, i2, this.j);
    }

    public void u(int i, String str, String str2, String str3) {
        int i2;
        int iF0 = this.m + F0(i);
        char cCharAt = str3.charAt(0);
        int i3 = (cCharAt == 'J' || cCharAt == 'D') ? 2 : 1;
        switch (i) {
            case Token.ARROW /* 178 */:
            case 180:
                i2 = iF0 + i3;
                break;
            case Token.YIELD_STAR /* 179 */:
            case Token.TEMPLATE_CHARS /* 181 */:
                i2 = iF0 - i3;
                break;
            default:
                jl.a("bad opcode for field reference");
                return;
        }
        if (i2 < 0 || 32767 < i2) {
            c0(i2);
        }
        short sH = this.k.h(str, str2, str3);
        X(i);
        Y(sH);
        short s = (short) i2;
        this.m = s;
        if (i2 > this.n) {
            this.n = s;
        }
    }

    public final void u0(int i, int i2, int i3) {
        if (i3 < 0 || i3 > this.n) {
            defpackage.b.a("Bad stack index: ", i3);
            return;
        }
        this.m = (short) i3;
        V(this.j);
        this.c.put(Integer.valueOf(this.j), Integer.valueOf(i));
        D0(i, i2, this.j);
    }

    public void v(int i) {
        J0(42, 25, i);
    }

    public final void v0(int i) {
        V(this.j);
        this.c.put(Integer.valueOf(this.j), Integer.valueOf(i));
        D0(i, -1, this.j);
    }

    public void w(int i) {
        J0(75, 58, i);
    }

    public void x(int i) {
        J0(38, 24, i);
    }

    public void y(int i) {
        J0(71, 57, i);
    }

    public void z(int i, int i2, int i3, String str) {
        if ((i & Integer.MIN_VALUE) != Integer.MIN_VALUE) {
            jl.a("Bad startLabel");
            return;
        }
        if ((i2 & Integer.MIN_VALUE) != Integer.MIN_VALUE) {
            jl.a("Bad endLabel");
            return;
        }
        if ((i3 & Integer.MIN_VALUE) != Integer.MIN_VALUE) {
            jl.a("Bad handlerLabel");
            return;
        }
        kv0 kv0Var = new kv0(i, i2, i3, str == null ? (short) 0 : this.k.a(str));
        int i4 = this.f;
        if (i4 == 0) {
            this.e = new kv0[4];
        } else {
            kv0[] kv0VarArr = this.e;
            if (i4 == kv0VarArr.length) {
                kv0[] kv0VarArr2 = new kv0[i4 * 2];
                System.arraycopy(kv0VarArr, 0, kv0VarArr2, 0, i4);
                this.e = kv0VarArr2;
            }
        }
        this.e[i4] = kv0Var;
        this.f = i4 + 1;
    }
}
