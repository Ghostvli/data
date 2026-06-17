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
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(int i, boolean z, int i2) {
            this.a = i;
            this.b = z;
            this.c = i2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public xh1(a aVar) {
        this.a = aVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007c A[PHI: r3
      0x007c: PHI (r3v16 int) = (r3v5 int), (r3v19 int) binds: [B:42:0x0089, B:33:0x0079] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean B(r73 r73Var, int i, int i2, boolean z) {
        int iT;
        long jT;
        int iY;
        int i3;
        int iG = r73Var.g();
        while (true) {
            try {
                boolean z2 = true;
                if (r73Var.a() < i2) {
                    r73Var.f0(iG);
                    return true;
                }
                if (i >= 3) {
                    iT = r73Var.z();
                    jT = r73Var.S();
                    iY = r73Var.Y();
                } else {
                    iT = r73Var.T();
                    jT = r73Var.T();
                    iY = 0;
                }
                if (iT == 0 && jT == 0 && iY == 0) {
                    r73Var.f0(iG);
                    return true;
                }
                if (i == 4 && !z) {
                    if ((8421504 & jT) != 0) {
                        r73Var.f0(iG);
                        return false;
                    }
                    jT = (((jT >> 24) & 255) << 21) | (jT & 255) | (((jT >> 8) & 255) << 7) | (((jT >> 16) & 255) << 14);
                }
                if (i == 4) {
                    i3 = (iY & 64) != 0 ? 1 : 0;
                    if ((iY & 1) == 0) {
                        z2 = false;
                    }
                } else if (i == 3) {
                    i3 = (iY & 32) != 0 ? 1 : 0;
                    if ((iY & 128) == 0) {
                    }
                } else {
                    i3 = 0;
                    z2 = false;
                }
                if (z2) {
                    i3 += 4;
                }
                if (jT < i3) {
                    r73Var.f0(iG);
                    return false;
                }
                if (r73Var.a() < jT) {
                    r73Var.f0(iG);
                    return false;
                }
                r73Var.g0((int) jT);
            } catch (Throwable th) {
                r73Var.f0(iG);
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ boolean c(int i, int i2, int i3, int i4, int i5) {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static byte[] d(byte[] bArr, int i, int i2) {
        return i2 <= i ? fy4.f : Arrays.copyOfRange(bArr, i, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static sj g(r73 r73Var, int i, String str) {
        byte[] bArr = new byte[i];
        r73Var.u(bArr, 0, i);
        return new sj(str, bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:140:0x01ab */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:196:0x010d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:198:0x018f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:202:0x022e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:203:0x01f6 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:94:0x0129 */
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
    */
    public static yh1 k(int i, r73 r73Var, boolean z, int i2, a aVar) throws Throwable {
        int iU;
        int i3;
        ?? r1;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        ?? r8;
        int i4;
        int i5;
        r73 r73Var2;
        Throwable th;
        ?? r12;
        int i6;
        ?? r82;
        ?? r13;
        ?? r122;
        ?? r83;
        ?? r84;
        yh1 yh1VarH;
        yh1 yh1VarJ;
        yh1 yh1VarL;
        int i7 = i;
        int iQ = r73Var.Q();
        int iQ2 = r73Var.Q();
        int iQ3 = r73Var.Q();
        int iQ4 = i7 >= 3 ? r73Var.Q() : 0;
        if (i7 == 4) {
            iU = r73Var.U();
            if (!z) {
                iU = (((iU >> 24) & 255) << 21) | (iU & 255) | (((iU >> 8) & 255) << 7) | (((iU >> 16) & 255) << 14);
            }
        } else {
            iU = i7 == 3 ? r73Var.U() : r73Var.T();
        }
        int iA = iU;
        int iY = i7 >= 3 ? r73Var.Y() : 0;
        if (iQ == 0 && iQ2 == 0 && iQ3 == 0 && iQ4 == 0 && iA == 0 && iY == 0) {
            r73Var.f0(r73Var.j());
            return null;
        }
        int iG = r73Var.g() + iA;
        if (iG > r73Var.j()) {
            xz1.i("Id3Decoder", "Frame size exceeds remaining tag data");
            r73Var.f0(r73Var.j());
            return null;
        }
        if (aVar != null) {
            boolean zA = aVar.a(i7, iQ, iQ2, iQ3, iQ4);
            i7 = i7;
            r1 = iQ;
            i3 = iQ2;
            if (!zA) {
                r73Var.f0(iG);
                return null;
            }
        } else {
            i3 = iQ2;
            r1 = iQ;
        }
        if (i7 == 3) {
            z2 = (iY & 128) != 0;
            boolean z6 = (iY & 64) != 0;
            z5 = false;
            z = z2;
            z3 = (iY & 32) != 0;
            z4 = z6;
        } else if (i7 == 4) {
            boolean z7 = (iY & 64) != 0;
            boolean z8 = (iY & 8) != 0;
            boolean z9 = (iY & 4) != 0;
            boolean z10 = (iY & 2) != 0;
            z = (iY & 1) != 0;
            z3 = z7;
            z2 = z;
            z = z8;
            z4 = z9;
            z5 = z10;
        } else {
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
        }
        if (z || z4) {
            xz1.i("Id3Decoder", "Skipping unsupported compressed or encrypted frame");
            r73Var.f0(iG);
            return null;
        }
        if (z3) {
            iA--;
            r73Var.g0(1);
        }
        if (z2) {
            iA -= 4;
            r73Var.g0(4);
        }
        if (z5) {
            iA = A(r73Var, iA);
        }
        try {
            try {
            } catch (Throwable th2) {
                th = th2;
                r12 = r73Var;
            }
        } catch (Exception e) {
            e = e;
            r8 = r1;
            i4 = i3;
            i5 = iQ4;
            r73Var2 = r73Var;
            i3 = iA;
            th = null;
            i6 = iQ3;
            r13 = r73Var2;
            r82 = r8;
            r13.f0(iG);
            r122 = th;
            r83 = r82;
            if (r122 == 0) {
            }
            return r122;
        } catch (OutOfMemoryError e2) {
            e = e2;
            r8 = r1;
            i4 = i3;
            i5 = iQ4;
            r73Var2 = r73Var;
            i3 = iA;
            th = null;
            i6 = iQ3;
            r13 = r73Var2;
            r82 = r8;
            r13.f0(iG);
            r122 = th;
            r83 = r82;
            if (r122 == 0) {
            }
            return r122;
        }
        if (r1 == 84 && i3 == 88 && iQ3 == 88 && (i7 == 2 || iQ4 == 88)) {
            yh1VarL = s(r73Var, iA);
        } else if (r1 == 84) {
            yh1VarL = q(r73Var, iA, x(i7, r1, i3, iQ3, iQ4));
        } else if (r1 == 87 && i3 == 88 && iQ3 == 88 && (i7 == 2 || iQ4 == 88)) {
            yh1VarL = u(r73Var, iA);
        } else if (r1 == 87) {
            yh1VarL = t(r73Var, iA, x(i7, r1, i3, iQ3, iQ4));
        } else if (r1 == 80 && i3 == 82 && iQ3 == 73 && iQ4 == 86) {
            yh1VarL = o(r73Var, iA);
        } else {
            if (r1 != 71 || i3 != 69 || iQ3 != 79 || (iQ4 != 66 && i7 != 2)) {
                th = null;
                try {
                } catch (Exception e3) {
                    e = e3;
                    r8 = r1;
                    i4 = i3;
                    i5 = iQ4;
                    r73Var2 = r73Var;
                    i3 = iA;
                    i6 = iQ3;
                    r13 = r73Var2;
                    r82 = r8;
                    r13.f0(iG);
                    r122 = th;
                    r83 = r82;
                    if (r122 == 0) {
                    }
                    return r122;
                } catch (OutOfMemoryError e4) {
                    e = e4;
                    r8 = r1;
                    i4 = i3;
                    i5 = iQ4;
                    r73Var2 = r73Var;
                    i3 = iA;
                    i6 = iQ3;
                    r13 = r73Var2;
                    r82 = r8;
                    r13.f0(iG);
                    r122 = th;
                    r83 = r82;
                    if (r122 == 0) {
                    }
                    return r122;
                }
                if (i7 != 2 ? r1 == 65 && i3 == 80 && iQ3 == 73 && iQ4 == 67 : r1 == 80 && i3 == 73 && iQ3 == 67) {
                    yh1VarJ = f(r73Var, iA, i7);
                } else {
                    if (r1 != 67 || i3 != 79 || iQ3 != 77 || (iQ4 != 77 && i7 != 2)) {
                        if (r1 == 67 && i3 == 72 && iQ3 == 65 && iQ4 == 80) {
                            r84 = r1;
                            i4 = i3;
                            i5 = iQ4;
                            i3 = iA;
                            i6 = iQ3;
                            try {
                                yh1VarH = h(r73Var, i3, i7, z, i2, aVar);
                                i7 = i;
                                r1 = r73Var;
                                r1.f0(iG);
                                r122 = yh1VarH;
                                e = th;
                                r83 = r84;
                            } catch (Exception e5) {
                                e = e5;
                                i7 = i;
                                r13 = r73Var;
                                r82 = r84;
                                r13.f0(iG);
                                r122 = th;
                                r83 = r82;
                            } catch (OutOfMemoryError e6) {
                                e = e6;
                                i7 = i;
                                r13 = r73Var;
                                r82 = r84;
                                r13.f0(iG);
                                r122 = th;
                                r83 = r82;
                            } catch (Throwable th3) {
                                th = th3;
                                r12 = r73Var;
                                r12.f0(iG);
                                throw th;
                            }
                        } else {
                            r84 = r1;
                            i4 = i3;
                            i5 = iQ4;
                            i3 = iA;
                            i6 = iQ3;
                            try {
                                if (r84 == 67 && i4 == 84 && i6 == 79 && i5 == 67) {
                                    i7 = i;
                                    r73 r73Var3 = r73Var;
                                    yh1VarH = i(r73Var3, i3, i7, z, i2, aVar);
                                    r1 = r73Var3;
                                } else {
                                    i7 = i;
                                    r73 r73Var4 = r73Var;
                                    if (r84 == 77 && i4 == 76 && i6 == 76 && i5 == 84) {
                                        yh1VarH = n(r73Var4, i3);
                                        r1 = r73Var4;
                                    } else {
                                        yh1VarH = g(r73Var4, i3, x(i7, r84 == true ? 1 : 0, i4, i6, i5));
                                        r1 = r73Var4;
                                    }
                                }
                                r1.f0(iG);
                                r122 = yh1VarH;
                                e = th;
                                r83 = r84;
                            } catch (Exception e7) {
                                e = e7;
                                r13 = r1;
                                r82 = r84;
                                r13.f0(iG);
                                r122 = th;
                                r83 = r82;
                            } catch (OutOfMemoryError e8) {
                                e = e8;
                                r13 = r1;
                                r82 = r84;
                                r13.f0(iG);
                                r122 = th;
                                r83 = r82;
                            } catch (Throwable th4) {
                                th = th4;
                                r12 = r1;
                                r12.f0(iG);
                                throw th;
                            }
                        }
                        if (r122 == 0) {
                            xz1.j("Id3Decoder", "Failed to decode frame: id=" + x(i7, r83, i4, i6, i5) + ", frameSize=" + i3, e);
                        }
                        return r122;
                    }
                    yh1VarJ = j(r73Var, iA);
                }
                r84 = r1;
                i4 = i3;
                i5 = iQ4;
                r1 = r73Var;
                i3 = iA;
                yh1VarH = yh1VarJ;
                r1 = r1;
                i6 = iQ3;
                r1.f0(iG);
                r122 = yh1VarH;
                e = th;
                r83 = r84;
                if (r122 == 0) {
                }
                return r122;
            }
            yh1VarL = l(r73Var, iA);
        }
        r84 = r1;
        i4 = i3;
        i5 = iQ4;
        r1 = r73Var;
        i3 = iA;
        th = null;
        yh1VarH = yh1VarL;
        r1 = r1;
        i6 = iQ3;
        r1.f0(iG);
        r122 = yh1VarH;
        e = th;
        r83 = r84;
        if (r122 == 0) {
        }
        return r122;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static wg3 o(r73 r73Var, int i) {
        byte[] bArr = new byte[i];
        r73Var.u(bArr, 0, i);
        int iZ = z(bArr, 0);
        return new wg3(new String(bArr, 0, iZ, StandardCharsets.ISO_8859_1), d(bArr, iZ + 1, i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String p(byte[] bArr, int i, int i2, Charset charset) {
        return (i2 <= i || i2 > bArr.length) ? "" : new String(bArr, i, i2 - i, charset);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static mx4 t(r73 r73Var, int i, String str) {
        byte[] bArr = new byte[i];
        r73Var.u(bArr, 0, i);
        return new mx4(str, null, new String(bArr, 0, z(bArr, 0), StandardCharsets.ISO_8859_1));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int v(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Charset w(int i) {
        return i != 1 ? i != 2 ? i != 3 ? StandardCharsets.ISO_8859_1 : StandardCharsets.UTF_8 : StandardCharsets.UTF_16BE : StandardCharsets.UTF_16;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String x(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int z(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.c74
    public xs2 b(at2 at2Var, ByteBuffer byteBuffer) {
        return e(byteBuffer.array(), byteBuffer.limit());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
