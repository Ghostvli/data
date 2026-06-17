package defpackage;

import defpackage.xi1;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import org.jupnp.support.model.dlna.DLNAProfiles;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class xh1 extends c74 {
    public static final a b = new a() { // from class: wh1
        @Override // xh1.a
        public final boolean a(int i, int i2, int i3, int i4, int i5) {
            return xh1.c(i, i2, i3, i4, i5);
        }
    };
    public final a a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        boolean a(int i, int i2, int i3, int i4, int i5);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final int a;
        public final boolean b;
        public final int c;

        public b(int i, boolean z, int i2) {
            this.a = i;
            this.b = z;
            this.c = i2;
        }
    }

    public xh1(a aVar) {
        this.a = aVar;
    }

    public static int A(r73 r73Var, int i) {
        byte[] bArrF = r73Var.f();
        int iG = r73Var.g();
        int i2 = iG;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= iG + i) {
                return i;
            }
            if ((bArrF[i2] & 255) == 255 && bArrF[i3] == 0) {
                System.arraycopy(bArrF, i2 + 2, bArrF, i3, (i - (i2 - iG)) - 2);
                i--;
            }
            i2 = i3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x007c A[PHI: r3
      0x007c: PHI (r3v16 int) = (r3v5 int), (r3v19 int) binds: [B:42:0x0089, B:33:0x0079] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean B(defpackage.r73 r18, int r19, int r20, boolean r21) {
        /*
            r1 = r18
            r0 = r19
            int r2 = r1.g()
        L8:
            int r3 = r1.a()     // Catch: java.lang.Throwable -> L22
            r4 = 1
            r5 = r20
            if (r3 < r5) goto Lae
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L25
            int r7 = r1.z()     // Catch: java.lang.Throwable -> L22
            long r8 = r1.S()     // Catch: java.lang.Throwable -> L22
            int r10 = r1.Y()     // Catch: java.lang.Throwable -> L22
            goto L2f
        L22:
            r0 = move-exception
            goto Lb2
        L25:
            int r7 = r1.T()     // Catch: java.lang.Throwable -> L22
            int r8 = r1.T()     // Catch: java.lang.Throwable -> L22
            long r8 = (long) r8
            r10 = r6
        L2f:
            r11 = 0
            if (r7 != 0) goto L3d
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L3d
            if (r10 != 0) goto L3d
            r1.f0(r2)
            return r4
        L3d:
            r7 = 4
            if (r0 != r7) goto L6e
            if (r21 != 0) goto L6e
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r11 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r11 == 0) goto L4e
            r1.f0(r2)
            return r6
        L4e:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 16
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 14
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 24
            long r8 = r8 >> r15
            long r8 = r8 & r11
            r11 = 21
            long r8 = r8 << r11
            long r8 = r8 | r13
        L6e:
            if (r0 != r7) goto L7e
            r3 = r10 & 64
            if (r3 == 0) goto L76
            r3 = r4
            goto L77
        L76:
            r3 = r6
        L77:
            r7 = r10 & 1
            if (r7 == 0) goto L7c
            goto L8e
        L7c:
            r4 = r6
            goto L8e
        L7e:
            if (r0 != r3) goto L8c
            r3 = r10 & 32
            if (r3 == 0) goto L86
            r3 = r4
            goto L87
        L86:
            r3 = r6
        L87:
            r7 = r10 & 128(0x80, float:1.8E-43)
            if (r7 == 0) goto L7c
            goto L8e
        L8c:
            r3 = r6
            r4 = r3
        L8e:
            if (r4 == 0) goto L92
            int r3 = r3 + 4
        L92:
            long r3 = (long) r3
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 >= 0) goto L9b
            r1.f0(r2)
            return r6
        L9b:
            int r3 = r1.a()     // Catch: java.lang.Throwable -> L22
            long r3 = (long) r3
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 >= 0) goto La8
            r1.f0(r2)
            return r6
        La8:
            int r3 = (int) r8
            r1.g0(r3)     // Catch: java.lang.Throwable -> L22
            goto L8
        Lae:
            r1.f0(r2)
            return r4
        Lb2:
            r1.f0(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xh1.B(r73, int, int, boolean):boolean");
    }

    public static /* synthetic */ boolean c(int i, int i2, int i3, int i4, int i5) {
        return false;
    }

    public static byte[] d(byte[] bArr, int i, int i2) {
        return i2 <= i ? fy4.f : Arrays.copyOfRange(bArr, i, i2);
    }

    public static t7 f(r73 r73Var, int i, int i2) {
        int iZ;
        String strConcat;
        int iQ = r73Var.Q();
        Charset charsetW = w(iQ);
        int i3 = i - 1;
        byte[] bArr = new byte[i3];
        r73Var.u(bArr, 0, i3);
        if (i2 == 2) {
            strConcat = "image/" + xa.f(new String(bArr, 0, 3, StandardCharsets.ISO_8859_1));
            if ("image/jpg".equals(strConcat)) {
                strConcat = DLNAProfiles.DLNAMimeTypes.MIME_IMAGE_JPEG;
            }
            iZ = 2;
        } else {
            iZ = z(bArr, 0);
            String strF = xa.f(new String(bArr, 0, iZ, StandardCharsets.ISO_8859_1));
            strConcat = strF.indexOf(47) == -1 ? "image/".concat(strF) : strF;
        }
        int i4 = bArr[iZ + 1] & 255;
        int i5 = iZ + 2;
        int iY = y(bArr, i5, iQ);
        return new t7(strConcat, new String(bArr, i5, iY - i5, charsetW), i4, d(bArr, iY + v(iQ), i3));
    }

    public static sj g(r73 r73Var, int i, String str) {
        byte[] bArr = new byte[i];
        r73Var.u(bArr, 0, i);
        return new sj(str, bArr);
    }

    public static js h(r73 r73Var, int i, int i2, boolean z, int i3, a aVar) throws Throwable {
        int iG = r73Var.g();
        int iZ = z(r73Var.f(), iG);
        String str = new String(r73Var.f(), iG, iZ - iG, StandardCharsets.ISO_8859_1);
        r73Var.f0(iZ + 1);
        int iZ2 = r73Var.z();
        int iZ3 = r73Var.z();
        long jS = r73Var.S();
        if (jS == 4294967295L) {
            jS = -1;
        }
        long jS2 = r73Var.S();
        long j = jS2 == 4294967295L ? -1L : jS2;
        ArrayList arrayList = new ArrayList();
        int i4 = iG + i;
        while (r73Var.g() < i4) {
            yh1 yh1VarK = k(i2, r73Var, z, i3, aVar);
            if (yh1VarK != null) {
                arrayList.add(yh1VarK);
            }
        }
        return new js(str, iZ2, iZ3, jS, j, (yh1[]) arrayList.toArray(new yh1[0]));
    }

    public static ks i(r73 r73Var, int i, int i2, boolean z, int i3, a aVar) throws Throwable {
        int iG = r73Var.g();
        int iZ = z(r73Var.f(), iG);
        String str = new String(r73Var.f(), iG, iZ - iG, StandardCharsets.ISO_8859_1);
        r73Var.f0(iZ + 1);
        int iQ = r73Var.Q();
        boolean z2 = (iQ & 2) != 0;
        boolean z3 = (iQ & 1) != 0;
        int iQ2 = r73Var.Q();
        String[] strArr = new String[iQ2];
        for (int i4 = 0; i4 < iQ2; i4++) {
            int iG2 = r73Var.g();
            int iZ2 = z(r73Var.f(), iG2);
            strArr[i4] = new String(r73Var.f(), iG2, iZ2 - iG2, StandardCharsets.ISO_8859_1);
            r73Var.f0(iZ2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i5 = iG + i;
        while (r73Var.g() < i5) {
            yh1 yh1VarK = k(i2, r73Var, z, i3, aVar);
            if (yh1VarK != null) {
                arrayList.add(yh1VarK);
            }
        }
        return new ks(str, z2, z3, strArr, (yh1[]) arrayList.toArray(new yh1[0]));
    }

    public static mx j(r73 r73Var, int i) {
        if (i < 4) {
            return null;
        }
        int iQ = r73Var.Q();
        Charset charsetW = w(iQ);
        byte[] bArr = new byte[3];
        r73Var.u(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i2 = i - 4;
        byte[] bArr2 = new byte[i2];
        r73Var.u(bArr2, 0, i2);
        int iY = y(bArr2, 0, iQ);
        String str2 = new String(bArr2, 0, iY, charsetW);
        int iV = iY + v(iQ);
        return new mx(str, str2, p(bArr2, iV, y(bArr2, iV, iQ), charsetW));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0240  */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2, types: [yh1] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10, types: [r73] */
    /* JADX WARN: Type inference failed for: r1v11, types: [r73] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29, types: [r73] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12, types: [int] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.yh1 k(int r19, defpackage.r73 r20, boolean r21, int r22, xh1.a r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 615
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xh1.k(int, r73, boolean, int, xh1$a):yh1");
    }

    public static m91 l(r73 r73Var, int i) {
        int iQ = r73Var.Q();
        Charset charsetW = w(iQ);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        r73Var.u(bArr, 0, i2);
        int iZ = z(bArr, 0);
        String strU = nt2.u(new String(bArr, 0, iZ, StandardCharsets.ISO_8859_1));
        int i3 = iZ + 1;
        int iY = y(bArr, i3, iQ);
        String strP = p(bArr, i3, iY, charsetW);
        int iV = iY + v(iQ);
        int iY2 = y(bArr, iV, iQ);
        return new m91(strU, strP, p(bArr, iV, iY2, charsetW), d(bArr, iY2 + v(iQ), i2));
    }

    public static b m(r73 r73Var) {
        if (r73Var.a() < 10) {
            xz1.i("Id3Decoder", "Data too short to be an ID3 tag");
            return null;
        }
        int iT = r73Var.T();
        if (iT != 4801587) {
            xz1.i("Id3Decoder", "Unexpected first three bytes of ID3 tag header: 0x".concat(String.format("%06X", Integer.valueOf(iT))));
            return null;
        }
        int iQ = r73Var.Q();
        r73Var.g0(1);
        int iQ2 = r73Var.Q();
        int iP = r73Var.P();
        if (iQ == 2) {
            if ((iQ2 & 64) != 0) {
                xz1.i("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (iQ == 3) {
            if ((iQ2 & 64) != 0) {
                int iZ = r73Var.z();
                r73Var.g0(iZ);
                iP -= iZ + 4;
            }
        } else {
            if (iQ != 4) {
                xz1.i("Id3Decoder", "Skipped ID3 tag with unsupported majorVersion=" + iQ);
                return null;
            }
            if ((iQ2 & 64) != 0) {
                int iP2 = r73Var.P();
                r73Var.g0(iP2 - 4);
                iP -= iP2;
            }
            if ((iQ2 & 16) != 0) {
                iP -= 10;
            }
        }
        return new b(iQ, iQ < 4 && (iQ2 & 128) != 0, iP);
    }

    public static st2 n(r73 r73Var, int i) {
        int iY = r73Var.Y();
        int iT = r73Var.T();
        int iT2 = r73Var.T();
        int iQ = r73Var.Q();
        int iQ2 = r73Var.Q();
        q73 q73Var = new q73();
        q73Var.m(r73Var);
        int i2 = ((i - 10) * 8) / (iQ + iQ2);
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int iH = q73Var.h(iQ);
            int iH2 = q73Var.h(iQ2);
            iArr[i3] = iH;
            iArr2[i3] = iH2;
        }
        return new st2(iY, iT, iT2, iArr, iArr2);
    }

    public static wg3 o(r73 r73Var, int i) {
        byte[] bArr = new byte[i];
        r73Var.u(bArr, 0, i);
        int iZ = z(bArr, 0);
        return new wg3(new String(bArr, 0, iZ, StandardCharsets.ISO_8859_1), d(bArr, iZ + 1, i));
    }

    public static String p(byte[] bArr, int i, int i2, Charset charset) {
        return (i2 <= i || i2 > bArr.length) ? "" : new String(bArr, i, i2 - i, charset);
    }

    public static mm4 q(r73 r73Var, int i, String str) {
        if (i < 1) {
            return null;
        }
        int iQ = r73Var.Q();
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        r73Var.u(bArr, 0, i2);
        return new mm4(str, null, r(bArr, iQ, 0));
    }

    public static xi1 r(byte[] bArr, int i, int i2) {
        if (i2 >= bArr.length) {
            return xi1.w("");
        }
        xi1.a aVarM = xi1.m();
        int iY = y(bArr, i2, i);
        while (i2 < iY) {
            aVarM.a(new String(bArr, i2, iY - i2, w(i)));
            i2 = v(i) + iY;
            iY = y(bArr, i2, i);
        }
        xi1 xi1VarK = aVarM.k();
        return xi1VarK.isEmpty() ? xi1.w("") : xi1VarK;
    }

    public static mm4 s(r73 r73Var, int i) {
        if (i < 1) {
            return null;
        }
        int iQ = r73Var.Q();
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        r73Var.u(bArr, 0, i2);
        int iY = y(bArr, 0, iQ);
        return new mm4("TXXX", new String(bArr, 0, iY, w(iQ)), r(bArr, iQ, iY + v(iQ)));
    }

    public static mx4 t(r73 r73Var, int i, String str) {
        byte[] bArr = new byte[i];
        r73Var.u(bArr, 0, i);
        return new mx4(str, null, new String(bArr, 0, z(bArr, 0), StandardCharsets.ISO_8859_1));
    }

    public static mx4 u(r73 r73Var, int i) {
        if (i < 1) {
            return null;
        }
        int iQ = r73Var.Q();
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        r73Var.u(bArr, 0, i2);
        int iY = y(bArr, 0, iQ);
        String str = new String(bArr, 0, iY, w(iQ));
        int iV = iY + v(iQ);
        return new mx4("WXXX", str, p(bArr, iV, z(bArr, iV), StandardCharsets.ISO_8859_1));
    }

    public static int v(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    public static Charset w(int i) {
        return i != 1 ? i != 2 ? i != 3 ? StandardCharsets.ISO_8859_1 : StandardCharsets.UTF_8 : StandardCharsets.UTF_16BE : StandardCharsets.UTF_16;
    }

    public static String x(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    public static int y(byte[] bArr, int i, int i2) {
        int iZ = z(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return iZ;
        }
        while (iZ < bArr.length - 1) {
            if ((iZ - i) % 2 == 0 && bArr[iZ + 1] == 0) {
                return iZ;
            }
            iZ = z(bArr, iZ + 1);
        }
        return bArr.length;
    }

    public static int z(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    @Override // defpackage.c74
    public xs2 b(at2 at2Var, ByteBuffer byteBuffer) {
        return e(byteBuffer.array(), byteBuffer.limit());
    }

    public xs2 e(byte[] bArr, int i) throws Throwable {
        ArrayList arrayList = new ArrayList();
        r73 r73Var = new r73(bArr, i);
        b bVarM = m(r73Var);
        if (bVarM == null) {
            return null;
        }
        int iG = r73Var.g();
        int i2 = bVarM.a == 2 ? 6 : 10;
        int iA = bVarM.c;
        if (bVarM.b) {
            iA = A(r73Var, bVarM.c);
        }
        r73Var.e0(iG + iA);
        boolean z = false;
        if (!B(r73Var, bVarM.a, i2, false)) {
            if (bVarM.a != 4 || !B(r73Var, 4, i2, true)) {
                xz1.i("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + bVarM.a);
                return null;
            }
            z = true;
        }
        while (r73Var.a() >= i2) {
            yh1 yh1VarK = k(bVarM.a, r73Var, z, i2, this.a);
            if (yh1VarK != null) {
                arrayList.add(yh1VarK);
            }
        }
        return new xs2(arrayList);
    }

    public xh1() {
        this(null);
    }
}
