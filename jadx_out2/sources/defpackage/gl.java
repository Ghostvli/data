package defpackage;

import android.util.Pair;
import com.hierynomus.msdtyp.FileTime;
import defpackage.bx;
import defpackage.dx2;
import defpackage.k;
import defpackage.su2;
import defpackage.t41;
import defpackage.v11;
import defpackage.xs2;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.jupnp.support.model.dlna.DLNAProfiles;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class gl {
    public static final byte[] a = fy4.F0("OpusHead");

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final long a;
        public final long b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(long j, long j2) {
            this.a = j;
            this.b = j2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final int a;
        public int b;
        public int c;
        public long d;
        public final boolean e;
        public final r73 f;
        public final r73 g;
        public int h;
        public int i;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(r73 r73Var, r73 r73Var2, boolean z) throws r83 {
            this.g = r73Var;
            this.f = r73Var2;
            this.e = z;
            r73Var2.f0(12);
            this.a = r73Var2.U();
            r73Var.f0(12);
            this.i = r73Var.U();
            nz0.a(r73Var.z() == 1, "first_chunk must be 1");
            this.b = -1;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean a() {
            int i = this.b + 1;
            this.b = i;
            if (i == this.a) {
                return false;
            }
            boolean z = this.e;
            r73 r73Var = this.f;
            this.d = z ? r73Var.X() : r73Var.S();
            if (this.b == this.h) {
                this.c = this.g.U();
                this.g.g0(4);
                int i2 = this.i - 1;
                this.i = i2;
                this.h = i2 > 0 ? this.g.U() - 1 : -1;
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c {
        public final String a;
        public final byte[] b;
        public final long c;
        public final long d;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(String str, byte[] bArr, long j, long j2) {
            this.a = str;
            this.b = bArr;
            this.c = j;
            this.d = j2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d {
        public final g a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(g gVar) {
            this.a = gVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e {
        public final long a;
        public final long b;
        public final String c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(long j, long j2, String str) {
            this.a = j;
            this.b = j2;
            this.c = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface f {
        int a();

        int b();

        int c();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class g {
        public final boolean a;
        public final boolean b;
        public final boolean c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public g(boolean z, boolean z2, boolean z3) {
            this.a = z;
            this.b = z2;
            this.c = z3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class h {
        public final yq4[] a;
        public t41 b;
        public int c;
        public int d = 0;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public h(int i) {
            this.a = new yq4[i];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class i implements f {
        public final int a;
        public final int b;
        public final r73 c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public i(su2.c cVar, t41 t41Var) {
            r73 r73Var = cVar.b;
            this.c = r73Var;
            r73Var.f0(12);
            int iU = r73Var.U();
            if ("audio/raw".equals(t41Var.p)) {
                int iU0 = fy4.u0(t41Var.J, t41Var.H);
                if (iU % iU0 != 0) {
                    xz1.i("BoxParsers", "Audio sample size mismatch. stsd sample size: " + iU0 + ", stsz sample size: " + iU);
                    iU = iU0;
                }
            }
            this.a = iU == 0 ? -1 : iU;
            this.b = r73Var.U();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // gl.f
        public int a() {
            return this.a;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // gl.f
        public int b() {
            return this.b;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // gl.f
        public int c() {
            int i = this.a;
            return i == -1 ? this.c.U() : i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class j implements f {
        public final r73 a;
        public final int b;
        public final int c;
        public int d;
        public int e;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public j(su2.c cVar) {
            r73 r73Var = cVar.b;
            this.a = r73Var;
            r73Var.f0(12);
            this.c = r73Var.U() & 255;
            this.b = r73Var.U();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // gl.f
        public int a() {
            return -1;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // gl.f
        public int b() {
            return this.b;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // gl.f
        public int c() {
            int i = this.c;
            if (i == 8) {
                return this.a.Q();
            }
            if (i == 16) {
                return this.a.Y();
            }
            int i2 = this.d;
            this.d = i2 + 1;
            if (i2 % 2 != 0) {
                return this.e & 15;
            }
            int iQ = this.a.Q();
            this.e = iQ;
            return (iQ & 240) >> 4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class k {
        public final int a;
        public final long b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public k(int i, long j, int i2, int i3, int i4, int i5) {
            this.a = i;
            this.b = j;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class l {
        public final d a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public l(d dVar) {
            this.a = dVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean b() {
            d dVar = this.a;
            return dVar != null && dVar.a.a && this.a.a.b;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static yq4 A(r73 r73Var, int i2, int i3, String str) {
        int i4;
        int i5;
        int i6 = i2 + 8;
        while (true) {
            byte[] bArr = null;
            if (i6 - i2 >= i3) {
                return null;
            }
            r73Var.f0(i6);
            int iZ = r73Var.z();
            if (r73Var.z() == 1952804451) {
                int iQ = q(r73Var.z());
                r73Var.g0(1);
                if (iQ == 0) {
                    r73Var.g0(1);
                    i5 = 0;
                    i4 = 0;
                } else {
                    int iQ2 = r73Var.Q();
                    i4 = iQ2 & 15;
                    i5 = (iQ2 & 240) >> 4;
                }
                boolean z = r73Var.Q() == 1;
                int iQ3 = r73Var.Q();
                byte[] bArr2 = new byte[16];
                r73Var.u(bArr2, 0, 16);
                if (z && iQ3 == 0) {
                    int iQ4 = r73Var.Q();
                    bArr = new byte[iQ4];
                    r73Var.u(bArr, 0, iQ4);
                }
                return new yq4(z, str, iQ3, bArr2, i5, i4, bArr);
            }
            i6 += iZ;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:342:0x01e9 */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x020c, code lost:
    
        r4 = r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0187  */
    /* JADX WARN: Type inference failed for: r26v2 */
    /* JADX WARN: Type inference failed for: r26v3 */
    /* JADX WARN: Type inference failed for: r26v4 */
    /* JADX WARN: Type inference failed for: r26v7, types: [boolean] */
    /* JADX WARN: Type inference failed for: r26v8 */
    /* JADX WARN: Type inference failed for: r29v0 */
    /* JADX WARN: Type inference failed for: r29v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r29v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static hr4 B(iq4 iq4Var, su2.b bVar, f91 f91Var, boolean z) throws r83 {
        f jVar;
        boolean z2;
        int iU;
        int iU2;
        int iU3;
        int i2;
        int i3;
        long[] jArr;
        int[] iArrCopyOf;
        ArrayList arrayList;
        int[] iArr;
        int i4;
        int length;
        long[] jArr2;
        long j2;
        int i5;
        int[] iArr2;
        long j3;
        int i6;
        ArrayList arrayList2;
        long j4;
        long[] jArr3;
        long j5;
        int[] iArr3;
        int[] iArr4;
        long[] jArr4;
        int i7;
        int i8;
        int i9;
        int i10;
        long jU1;
        iq4 iq4VarA = iq4Var;
        su2.c cVarE = bVar.e(1937011578);
        if (cVarE != null) {
            jVar = new i(cVarE, iq4VarA.g);
        } else {
            su2.c cVarE2 = bVar.e(1937013298);
            if (cVarE2 == null) {
                throw r83.a("Track has no sample table size information", null);
            }
            jVar = new j(cVarE2);
        }
        int iB = jVar.b();
        if (iB == 0) {
            return new hr4(iq4VarA, new long[0], new int[0], 0, new long[0], new int[0], new int[0], false, 0L, 0);
        }
        if (iq4VarA.b == 2) {
            long j6 = iq4VarA.f;
            if (j6 > 0) {
                iq4VarA = iq4VarA.a(iq4VarA.g.b().g0(iB / (j6 / 1000000.0f)).Q());
            }
        }
        su2.c cVarE3 = bVar.e(1937007471);
        if (cVarE3 == null) {
            cVarE3 = (su2.c) gg3.q(bVar.e(1668232756));
            z2 = true;
        } else {
            z2 = false;
        }
        r73 r73Var = cVarE3.b;
        r73 r73Var2 = ((su2.c) gg3.q(bVar.e(1937011555))).b;
        r73 r73Var3 = ((su2.c) gg3.q(bVar.e(1937011827))).b;
        su2.c cVarE4 = bVar.e(1937011571);
        r73 r73Var4 = cVarE4 != null ? cVarE4.b : null;
        su2.c cVarE5 = bVar.e(1668576371);
        r73 r73Var5 = cVarE5 != null ? cVarE5.b : null;
        b bVar2 = new b(r73Var2, r73Var, z2);
        r73Var3.f0(12);
        int iU4 = r73Var3.U() - 1;
        int iU5 = r73Var3.U();
        int iU6 = r73Var3.U();
        if (r73Var5 != null) {
            r73Var5.f0(12);
            iU = r73Var5.U();
        } else {
            iU = 0;
        }
        if (r73Var4 != null) {
            r73Var4.f0(12);
            iU2 = r73Var4.U();
            if (iU2 <= 0) {
                iU3 = -1;
                i2 = 1;
                r73Var4 = null;
                int iA = jVar.a();
                String str = iq4VarA.g.p;
                i3 = (iA == -1 && ("audio/raw".equals(str) || "audio/g711-mlaw".equals(str) || "audio/g711-alaw".equals(str)) && iU4 == 0 && iU == 0 && iU2 == 0) ? i2 : 0;
                ArrayList arrayList3 = new ArrayList();
                ?? r29 = r73Var4 != null ? i2 : 0;
                if (i3 == 0) {
                    int i11 = bVar2.a;
                    long[] jArr5 = new long[i11];
                    int[] iArr5 = new int[i11];
                    while (bVar2.a()) {
                        int i12 = bVar2.b;
                        jArr5[i12] = bVar2.d;
                        iArr5[i12] = bVar2.c;
                    }
                    v11.b bVarA = v11.a(iA, jArr5, iArr5, iU6);
                    long[] jArr6 = z ? new long[0] : bVarA.a;
                    int[] iArr6 = z ? new int[0] : bVarA.b;
                    jArr = z ? new long[0] : bVarA.d;
                    iArrCopyOf = z ? new int[0] : bVarA.e;
                    int i13 = bVarA.c;
                    long j7 = bVarA.f;
                    j2 = bVarA.g;
                    length = bVarA.a.length;
                    jArr2 = jArr6;
                    iArr2 = iArr6;
                    arrayList = arrayList3;
                    i5 = i13;
                    j3 = j7;
                } else {
                    long[] jArr7 = z ? new long[0] : new long[iB];
                    r73 r73Var6 = r73Var5;
                    int[] iArrCopyOf2 = z ? new int[0] : new int[iB];
                    f fVar = jVar;
                    jArr = z ? new long[0] : new long[iB];
                    int i14 = iU2;
                    iArrCopyOf = z ? new int[0] : new int[iB];
                    int i15 = iU3;
                    int i16 = iU;
                    int iU7 = i15;
                    int i17 = iU4;
                    r73 r73Var7 = r73Var4;
                    long j8 = 0;
                    long j9 = 0;
                    int i18 = i14;
                    int i19 = 0;
                    int i20 = 0;
                    int iZ = 0;
                    int i21 = 0;
                    int iU8 = 0;
                    long j10 = 0;
                    while (true) {
                        if (i20 >= iB) {
                            arrayList = arrayList3;
                            break;
                        }
                        long j11 = j9;
                        ?? A = i2;
                        while (i21 == 0) {
                            A = bVar2.a();
                            if (A == 0) {
                                break;
                            }
                            ArrayList arrayList4 = arrayList3;
                            long j12 = bVar2.d;
                            i21 = bVar2.c;
                            j11 = j12;
                            arrayList3 = arrayList4;
                            iU6 = iU6;
                            iB = iB;
                            A = A;
                        }
                        int i22 = iB;
                        arrayList = arrayList3;
                        int i23 = iU6;
                        if (A == 0) {
                            xz1.i("BoxParsers", "Unexpected end of chunk data");
                            if (z) {
                                iArr = iArrCopyOf2;
                                iB = i20;
                            } else {
                                long[] jArrCopyOf = Arrays.copyOf(jArr7, i20);
                                iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i20);
                                long[] jArrCopyOf2 = Arrays.copyOf(jArr, i20);
                                jArr7 = jArrCopyOf;
                                iArrCopyOf = Arrays.copyOf(iArrCopyOf, i20);
                                iB = i20;
                                jArr = jArrCopyOf2;
                            }
                        } else {
                            if (r73Var6 != null) {
                                while (iU8 == 0 && i16 > 0) {
                                    iU8 = r73Var6.U();
                                    iZ = r73Var6.z();
                                    i16--;
                                }
                                iU8--;
                            }
                            int iC = fVar.c();
                            long j13 = iC;
                            j8 += j13;
                            if (iC > i19) {
                                i19 = iC;
                            }
                            if (z) {
                                i6 = i19;
                            } else {
                                jArr7[i20] = j11;
                                iArrCopyOf2[i20] = iC;
                                i6 = i19;
                                jArr[i20] = j10 + ((long) iZ);
                                iArrCopyOf[i20] = r73Var7 == null ? i2 : 0;
                                if (i20 == iU7) {
                                    iArrCopyOf[i20] = i2;
                                    arrayList2 = arrayList;
                                    arrayList2.add(Integer.valueOf(i20));
                                }
                                if (r73Var7 != null && i20 == iU7 && i18 - 1 > 0) {
                                    iU7 = ((r73) gg3.q(r73Var7)).U() - 1;
                                }
                                ArrayList arrayList5 = arrayList2;
                                b bVar3 = bVar2;
                                int iZ2 = i23;
                                j10 += (long) iZ2;
                                iU5--;
                                if (iU5 != 0 && i17 > 0) {
                                    i17--;
                                    iU5 = r73Var3.U();
                                    iZ2 = r73Var3.z();
                                }
                                long j14 = j11 + j13;
                                i21--;
                                i20++;
                                iU6 = iZ2;
                                i19 = i6;
                                arrayList3 = arrayList5;
                                bVar2 = bVar3;
                                j9 = j14;
                                iB = i22;
                            }
                            arrayList2 = arrayList;
                            if (r73Var7 != null) {
                                iU7 = ((r73) gg3.q(r73Var7)).U() - 1;
                            }
                            ArrayList arrayList52 = arrayList2;
                            b bVar32 = bVar2;
                            int iZ22 = i23;
                            j10 += (long) iZ22;
                            iU5--;
                            if (iU5 != 0) {
                            }
                            long j142 = j11 + j13;
                            i21--;
                            i20++;
                            iU6 = iZ22;
                            i19 = i6;
                            arrayList3 = arrayList52;
                            bVar2 = bVar32;
                            j9 = j142;
                            iB = i22;
                        }
                    }
                    int i24 = i21;
                    long j15 = j10 + ((long) iZ);
                    if (r73Var6 != null) {
                        for (int i25 = i16; i25 > 0; i25--) {
                            if (r73Var6.U() != 0) {
                                i4 = 0;
                                break;
                            }
                            r73Var6.z();
                        }
                        i4 = i2;
                        if (i18 == 0 || iU5 != 0 || i24 != 0 || i17 != 0 || iU8 != 0 || i4 == 0) {
                            StringBuilder sb = new StringBuilder("Inconsistent stbl box for track ");
                            sb.append(iq4VarA.a);
                            sb.append(": remainingSynchronizationSamples ");
                            sb.append(i18);
                            sb.append(", remainingSamplesAtTimestampDelta ");
                            sb.append(iU5);
                            sb.append(", remainingSamplesInChunk ");
                            sb.append(i24);
                            sb.append(", remainingTimestampDeltaChanges ");
                            sb.append(i17);
                            sb.append(", remainingSamplesAtTimestampOffset ");
                            sb.append(iU8);
                            sb.append(i4 != 0 ? ", ctts invalid" : "");
                            xz1.i("BoxParsers", sb.toString());
                        }
                        length = iB;
                        jArr2 = jArr7;
                        j2 = j8;
                        i5 = i19;
                        iArr2 = iArr;
                        j3 = j15;
                    } else {
                        i4 = i2;
                        if (i18 == 0) {
                            StringBuilder sb2 = new StringBuilder("Inconsistent stbl box for track ");
                            sb2.append(iq4VarA.a);
                            sb2.append(": remainingSynchronizationSamples ");
                            sb2.append(i18);
                            sb2.append(", remainingSamplesAtTimestampDelta ");
                            sb2.append(iU5);
                            sb2.append(", remainingSamplesInChunk ");
                            sb2.append(i24);
                            sb2.append(", remainingTimestampDeltaChanges ");
                            sb2.append(i17);
                            sb2.append(", remainingSamplesAtTimestampOffset ");
                            sb2.append(iU8);
                            sb2.append(i4 != 0 ? ", ctts invalid" : "");
                            xz1.i("BoxParsers", sb2.toString());
                            length = iB;
                            jArr2 = jArr7;
                            j2 = j8;
                            i5 = i19;
                            iArr2 = iArr;
                            j3 = j15;
                        }
                    }
                }
                long[] jArr8 = jArr;
                j4 = iq4VarA.f;
                if (j4 > 0) {
                    long jX1 = fy4.x1(j2 * 8, 1000000L, j4, RoundingMode.HALF_DOWN);
                    if (jX1 > 0 && jX1 < 2147483647L) {
                        iq4VarA = iq4VarA.a(iq4VarA.g.b().T((int) jX1).Q());
                    }
                }
                long jU12 = fy4.u1(j3, 1000000L, iq4VarA.c);
                int[] iArrN = ll1.n(arrayList);
                jArr3 = iq4VarA.i;
                if (jArr3 != null) {
                    if (!z) {
                        fy4.w1(jArr8, 1000000L, iq4VarA.c);
                    }
                    return new hr4(iq4VarA, jArr2, iArr2, i5, jArr8, iArrCopyOf, iArrN, r29, jU12, length);
                }
                iq4 iq4Var2 = iq4VarA;
                ArrayList arrayList6 = arrayList;
                int[] iArr7 = iArrCopyOf;
                if (z) {
                    long[] jArr9 = (long[]) gg3.q(iq4Var2.j);
                    long[] jArr10 = iq4Var2.i;
                    if (jArr10.length == i2 && jArr10[0] == 0) {
                        jU1 = fy4.u1(j3 - jArr9[0], 1000000L, iq4Var2.c);
                    } else {
                        long j16 = 0;
                        int i26 = 0;
                        while (true) {
                            long[] jArr11 = iq4Var2.i;
                            if (i26 >= jArr11.length) {
                                break;
                            }
                            if (jArr9[i26] != -1) {
                                j16 += jArr11[i26];
                            }
                            i26++;
                        }
                        jU1 = fy4.u1(j16, 1000000L, iq4Var2.d);
                    }
                    return new hr4(iq4Var2, jArr2, iArr2, i5, jArr8, iArr7, iArrN, r29, jU1, length);
                }
                if (jArr3.length == 1 && iq4Var2.b == 1 && jArr8.length >= 2) {
                    long j17 = ((long[]) gg3.q(iq4Var2.j))[0];
                    j5 = -1;
                    long jU13 = fy4.u1(iq4Var2.i[0], iq4Var2.c, iq4Var2.d) + j17;
                    if (b(jArr8, j3, j17, jU13)) {
                        long jMax = Math.max(0L, j3 - jU13);
                        long jU14 = fy4.u1(j17 - jArr8[0], iq4Var2.g.I, iq4Var2.c);
                        long jU15 = fy4.u1(jMax, iq4Var2.g.I, iq4Var2.c);
                        if ((jU14 != 0 || jU15 != 0) && jU14 <= 2147483647L && jU15 <= 2147483647L) {
                            f91Var.a = (int) jU14;
                            f91Var.b = (int) jU15;
                            fy4.w1(jArr8, 1000000L, iq4Var2.c);
                            return new hr4(iq4Var2, jArr2, iArr2, i5, jArr8, iArr7, iArrN, r29, fy4.u1(iq4Var2.i[0], 1000000L, iq4Var2.d), length);
                        }
                    }
                } else {
                    j5 = -1;
                }
                long[] jArr12 = iq4Var2.i;
                if (jArr12.length == 1 && jArr12[0] == 0) {
                    long j18 = ((long[]) gg3.q(iq4Var2.j))[0];
                    for (int i27 = 0; i27 < jArr8.length; i27++) {
                        jArr8[i27] = fy4.u1(jArr8[i27] - j18, 1000000L, iq4Var2.c);
                    }
                    return new hr4(iq4Var2, jArr2, iArr2, i5, jArr8, iArr7, iArrN, r29, fy4.u1(j3 - j18, 1000000L, iq4Var2.c), length);
                }
                long[] jArr13 = jArr2;
                int[] iArr8 = iArr2;
                int i28 = length;
                boolean z3 = iq4Var2.b == 1;
                int[] iArr9 = new int[jArr12.length];
                int[] iArr10 = new int[jArr12.length];
                long[] jArr14 = (long[]) gg3.q(iq4Var2.j);
                int i29 = 0;
                boolean z4 = false;
                int i30 = 0;
                int i31 = 0;
                while (true) {
                    long[] jArr15 = iq4Var2.i;
                    iArr3 = iArr10;
                    if (i29 >= jArr15.length) {
                        break;
                    }
                    ArrayList arrayList7 = arrayList6;
                    long j19 = jArr14[i29];
                    if (j19 != j5) {
                        long j20 = jArr15[i29];
                        iArr4 = iArr9;
                        jArr4 = jArr14;
                        long jU16 = fy4.u1(j20, iq4Var2.c, iq4Var2.d) + j19;
                        i7 = i29;
                        iArr4[i7] = fy4.k(jArr8, j19, true, true);
                        int iG = fy4.g(jArr8, jU16, z3, false);
                        int i32 = iG - 1;
                        int i33 = 0;
                        while (true) {
                            i8 = i32;
                            if (iG >= jArr8.length) {
                                break;
                            }
                            if (jArr8[iG] < jU16) {
                                i32 = iG;
                            } else {
                                i33++;
                                if (i33 > iq4Var2.g.r) {
                                    break;
                                }
                                i32 = i8;
                            }
                            iG++;
                        }
                        iArr3[i7] = i8 + 1;
                        int i34 = iArr4[i7];
                        while (true) {
                            i9 = iArr4[i7];
                            if (i9 <= 0) {
                                i10 = 1;
                                break;
                            }
                            i10 = 1;
                            if ((iArr7[i9] & 1) != 0) {
                                break;
                            }
                            iArr4[i7] = i9 - 1;
                        }
                        if (i9 == 0 && (iArr7[0] & i10) == 0) {
                            iArr4[i7] = i34;
                            while (true) {
                                int i35 = iArr4[i7];
                                if (i35 >= iArr3[i7] || (iArr7[i35] & i10) != 0) {
                                    break;
                                }
                                iArr4[i7] = i35 + 1;
                                i10 = 1;
                            }
                        }
                        int i36 = iArr3[i7];
                        int i37 = iArr4[i7];
                        i30 += i36 - i37;
                        boolean z5 = i31 != i37;
                        i31 = i36;
                        z4 = z5 | z4;
                    } else {
                        iArr4 = iArr9;
                        jArr4 = jArr14;
                        i7 = i29;
                    }
                    i29 = i7 + 1;
                    jArr14 = jArr4;
                    iArr9 = iArr4;
                    iArr10 = iArr3;
                    arrayList6 = arrayList7;
                }
                ArrayList arrayList8 = arrayList6;
                int[] iArr11 = iArr9;
                boolean z6 = false;
                boolean z7 = (i30 != i28) | z4;
                long[] jArr16 = z7 ? new long[i30] : jArr13;
                int[] iArr12 = z7 ? new int[i30] : iArr8;
                int i38 = z7 ? 0 : i5;
                int[] iArr13 = z7 ? new int[i30] : iArr7;
                ArrayList arrayList9 = z7 ? new ArrayList() : arrayList8;
                long[] jArr17 = new long[i30];
                int i39 = i38;
                int i40 = 0;
                int i41 = 0;
                long j21 = 0;
                while (i40 < iq4Var2.i.length) {
                    long j22 = iq4Var2.j[i40];
                    int i42 = iArr11[i40];
                    int i43 = iArr3[i40];
                    boolean z8 = z7;
                    if (z7) {
                        int i44 = i43 - i42;
                        System.arraycopy(jArr13, i42, jArr16, i41, i44);
                        System.arraycopy(iArr8, i42, iArr12, i41, i44);
                        System.arraycopy(iArr7, i42, iArr13, i41, i44);
                    }
                    int i45 = i39;
                    while (i42 < i43) {
                        int[] iArr14 = iArr12;
                        long[] jArr18 = jArr13;
                        long jU17 = fy4.u1(j21, 1000000L, iq4Var2.d);
                        long jU18 = fy4.u1(jArr8[i42] - j22, 1000000L, iq4Var2.c);
                        if (jU18 < 0) {
                            z6 = true;
                        }
                        jArr17[i41] = jU17 + jU18;
                        if (z8 && iArr14[i41] > i45) {
                            i45 = iArr8[i42];
                        }
                        if (z8 && r29 == 0 && (iArr13[i41] & 1) != 0) {
                            arrayList9.add(Integer.valueOf(i41));
                        }
                        i41++;
                        i42++;
                        jArr13 = jArr18;
                        iArr12 = iArr14;
                    }
                    j21 += iq4Var2.i[i40];
                    i40++;
                    i39 = i45;
                    iArr12 = iArr12;
                    z7 = z8;
                }
                return new hr4(z6 ? iq4Var2.a(iq4Var2.g.b().h0(true).Q()) : iq4Var2, jArr16, iArr12, i39, jArr17, iArr13, ll1.n(arrayList9), r29, fy4.u1(j21, 1000000L, iq4Var2.d), jArr16.length);
            }
            iU3 = r73Var4.U() - 1;
        } else {
            iU2 = 0;
            iU3 = -1;
        }
        i2 = 1;
        int iA2 = jVar.a();
        String str2 = iq4VarA.g.p;
        if (iA2 == -1) {
        }
        ArrayList arrayList32 = new ArrayList();
        if (r73Var4 != null) {
        }
        if (i3 == 0) {
        }
        long[] jArr82 = jArr;
        j4 = iq4VarA.f;
        if (j4 > 0) {
        }
        long jU122 = fy4.u1(j3, 1000000L, iq4VarA.c);
        int[] iArrN2 = ll1.n(arrayList);
        jArr3 = iq4VarA.i;
        if (jArr3 != null) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static d C(r73 r73Var, int i2, int i3) throws r83 {
        r73Var.f0(i2 + 8);
        int iG = r73Var.g();
        while (iG - i2 < i3) {
            r73Var.f0(iG);
            int iZ = r73Var.z();
            nz0.a(iZ > 0, "childAtomSize must be positive");
            if (r73Var.z() == 1937011305) {
                r73Var.g0(4);
                int iQ = r73Var.Q();
                return new d(new g((iQ & 1) == 1, (iQ & 2) == 2, (iQ & 8) == 8));
            }
            iG += iZ;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static h D(r73 r73Var, k kVar, String str, oo0 oo0Var, boolean z) throws r83 {
        r73Var.f0(12);
        int iZ = r73Var.z();
        h hVar = new h(iZ);
        for (int i2 = 0; i2 < iZ; i2++) {
            int iG = r73Var.g();
            int iZ2 = r73Var.z();
            nz0.a(iZ2 > 0, "childAtomSize must be positive");
            int iZ3 = r73Var.z();
            if (iZ3 == 1635148593 || iZ3 == 1635148595 || iZ3 == 1701733238 || iZ3 == 1831958048 || iZ3 == 1836070006 || iZ3 == 1752589105 || iZ3 == 1751479857 || iZ3 == 1987470129 || iZ3 == 1987471665 || iZ3 == 1932670515 || iZ3 == 1211250227 || iZ3 == 1748121139 || iZ3 == 1987063864 || iZ3 == 1987063865 || iZ3 == 1635135537 || iZ3 == 1685479798 || iZ3 == 1685479729 || iZ3 == 1685481573 || iZ3 == 1685481521 || iZ3 == 1634760241 || iZ3 == 1684108849) {
                L(r73Var, iZ3, iG, iZ2, kVar.a, str, kVar.d, oo0Var, hVar, i2);
            } else if (iZ3 == 1836069985 || iZ3 == 1701733217 || iZ3 == 1633889587 || iZ3 == 1700998451 || iZ3 == 1633889588 || iZ3 == 1835823201 || iZ3 == 1685353315 || iZ3 == 1685353317 || iZ3 == 1685353320 || iZ3 == 1685353324 || iZ3 == 1685353336 || iZ3 == 1935764850 || iZ3 == 1935767394 || iZ3 == 1819304813 || iZ3 == 1936684916 || iZ3 == 1953984371 || iZ3 == 778924082 || iZ3 == 778924083 || iZ3 == 1835557169 || iZ3 == 1835560241 || iZ3 == 1634492771 || iZ3 == 1634492791 || iZ3 == 1970037111 || iZ3 == 1332770163 || iZ3 == 1716281667 || iZ3 == 1767992678 || iZ3 == 1768973165 || iZ3 == 1718641517) {
                i(r73Var, iZ3, iG, iZ2, kVar.a, str, z, oo0Var, hVar, i2);
            } else if (iZ3 == 1414810956 || iZ3 == 1954034535 || iZ3 == 2004251764 || iZ3 == 1937010800 || iZ3 == 1664495672 || iZ3 == 1836070003) {
                h hVar2 = hVar;
                E(r73Var, iZ3, iG, iZ2, kVar, str, hVar2);
                hVar = hVar2;
            } else if (iZ3 == 1835365492) {
                v(r73Var, iZ3, iG, kVar.a, hVar);
            } else if (iZ3 == 1667329389) {
                hVar.b = new t41.b().j0(kVar.a).A0("application/x-camera-motion").Q();
            }
            r73Var.f0(iG + iZ2);
        }
        return hVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void E(r73 r73Var, int i2, int i3, int i4, k kVar, String str, h hVar) {
        r73Var.f0(i3 + 16);
        String str2 = "application/ttml+xml";
        xi1 xi1VarW = null;
        long j2 = Long.MAX_VALUE;
        if (i2 != 1414810956) {
            if (i2 == 1954034535) {
                int i5 = i4 - 16;
                byte[] bArr = new byte[i5];
                r73Var.u(bArr, 0, i5);
                xi1VarW = xi1.w(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i2 == 2004251764) {
                str2 = "application/x-mp4-vtt";
            } else if (i2 == 1937010800) {
                j2 = 0;
            } else if (i2 == 1664495672) {
                hVar.d = 1;
                str2 = "application/x-mp4-cea-608";
            } else {
                if (i2 != 1836070003) {
                    z20.a();
                    return;
                }
                int iG = r73Var.g();
                r73Var.g0(4);
                if (r73Var.z() == 1702061171) {
                    c cVarN = n(r73Var, iG);
                    if (cVarN.b == null || cVarN.b.length != 64) {
                        return;
                    }
                    xi1VarW = xi1.w(fy4.F0(d(cVarN.b, kVar.e, kVar.f)));
                    str2 = "application/vobsub";
                } else {
                    str2 = null;
                }
            }
        }
        if (str2 != null) {
            hVar.b = new t41.b().j0(kVar.a).A0(str2).o0(str).E0(j2).l0(xi1VarW).Q();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static k F(r73 r73Var) {
        long j2;
        r73Var.f0(8);
        int iQ = q(r73Var.z());
        r73Var.g0(iQ == 0 ? 8 : 16);
        int iZ = r73Var.z();
        r73Var.g0(4);
        int iG = r73Var.g();
        int i2 = iQ == 0 ? 4 : 8;
        int i3 = 0;
        while (true) {
            j2 = -9223372036854775807L;
            if (i3 >= i2) {
                r73Var.g0(i2);
                break;
            }
            if (r73Var.f()[iG + i3] != -1) {
                long jS = iQ == 0 ? r73Var.S() : r73Var.X();
                if (jS != 0) {
                    j2 = jS;
                }
            } else {
                i3++;
            }
        }
        r73Var.g0(10);
        int i4 = 0;
        long j3 = j2;
        int iY = r73Var.Y();
        r73Var.g0(4);
        int iZ2 = r73Var.z();
        int iZ3 = r73Var.z();
        r73Var.g0(4);
        int iZ4 = r73Var.z();
        int iZ5 = r73Var.z();
        if (iZ2 == 0 && iZ3 == 65536 && ((iZ4 == -65536 || iZ4 == 65536) && iZ5 == 0)) {
            i4 = 90;
        } else if (iZ2 == 0 && iZ3 == -65536 && ((iZ4 == 65536 || iZ4 == -65536) && iZ5 == 0)) {
            i4 = 270;
        } else if ((iZ2 == -65536 || iZ2 == 65536) && iZ3 == 0 && iZ4 == 0 && iZ5 == -65536) {
            i4 = 180;
        }
        int i5 = i4;
        r73Var.g0(16);
        short sM = r73Var.M();
        r73Var.g0(2);
        return new k(iZ, j3, iY, i5, sM, r73Var.M());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static iq4 G(su2.b bVar, su2.c cVar, long j2, oo0 oo0Var, boolean z, boolean z2) throws r83 {
        long[] jArr;
        long[] jArr2;
        t41 t41VarQ;
        su2.b bVarD;
        Pair pairM;
        su2.b bVar2 = (su2.b) gg3.q(bVar.d(1835297121));
        int iF = f(r(((su2.c) gg3.q(bVar2.e(1751411826))).b));
        if (iF == -1) {
            return null;
        }
        k kVarF = F(((su2.c) gg3.q(bVar.e(1953196132))).b);
        long j3 = j2 == -9223372036854775807L ? kVarF.b : j2;
        long j4 = w(cVar.b).c;
        long jU1 = j3 != -9223372036854775807L ? fy4.u1(j3, 1000000L, j4) : -9223372036854775807L;
        su2.b bVar3 = (su2.b) gg3.q(((su2.b) gg3.q(bVar2.d(1835626086))).d(1937007212));
        e eVarT = t(((su2.c) gg3.q(bVar2.e(1835296868))).b);
        su2.c cVarE = bVar3.e(1937011556);
        if (cVarE == null) {
            xz1.i("BoxParsers", "Ignoring track where sample table (stbl) box is missing a sample description (stsd).");
            return null;
        }
        h hVarD = D(cVarE.b, kVarF, eVarT.c, oo0Var, z2);
        if (z || (bVarD = bVar.d(1701082227)) == null || (pairM = m(bVarD)) == null) {
            jArr = null;
            jArr2 = null;
        } else {
            long[] jArr3 = (long[]) pairM.first;
            jArr2 = (long[]) pairM.second;
            jArr = jArr3;
        }
        if (hVarD.b == null) {
            return null;
        }
        if (kVarF.c != 0) {
            ru2 ru2Var = new ru2(kVarF.c);
            t41.b bVarB = hVarD.b.b();
            xs2 xs2Var = hVarD.b.l;
            t41VarQ = bVarB.s0(xs2Var != null ? xs2Var.a(ru2Var) : new xs2(ru2Var)).Q();
        } else {
            t41VarQ = hVarD.b;
        }
        return new iq4(kVarF.a, iF, eVarT.a, j4, jU1, eVarT.b, t41VarQ, hVarD.d, hVarD.a, hVarD.c, jArr, jArr2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List H(su2.b bVar, f91 f91Var, long j2, oo0 oo0Var, boolean z, boolean z2, p81 p81Var, boolean z3) {
        iq4 iq4Var;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < bVar.d.size(); i2++) {
            su2.b bVar2 = (su2.b) bVar.d.get(i2);
            if (bVar2.a == 1953653099 && (iq4Var = (iq4) p81Var.apply(G(bVar2, (su2.c) gg3.q(bVar.e(1836476516)), j2, oo0Var, z, z2))) != null) {
                arrayList.add(B(iq4Var, (su2.b) gg3.q(((su2.b) gg3.q(((su2.b) gg3.q(bVar2.d(1835297121))).d(1835626086))).d(1937007212)), f91Var, z3));
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static xs2 I(su2.c cVar) {
        r73 r73Var = cVar.b;
        r73Var.f0(8);
        xs2 xs2Var = new xs2(new xs2.a[0]);
        while (r73Var.a() >= 8) {
            int iG = r73Var.g();
            int iZ = r73Var.z();
            int iZ2 = r73Var.z();
            if (iZ2 == 1835365473) {
                r73Var.f0(iG);
                xs2Var = xs2Var.b(J(r73Var, iG + iZ));
            } else if (iZ2 == 1936553057) {
                r73Var.f0(iG);
                xs2Var = xs2Var.b(p94.b(r73Var, iG + iZ));
            } else if (iZ2 == -1451722374) {
                xs2Var = xs2Var.b(M(r73Var));
            }
            r73Var.f0(iG + iZ);
        }
        return xs2Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static xs2 J(r73 r73Var, int i2) {
        r73Var.g0(8);
        g(r73Var);
        while (r73Var.g() < i2) {
            int iG = r73Var.g();
            int iZ = r73Var.z();
            if (r73Var.z() == 1768715124) {
                r73Var.f0(iG);
                return s(r73Var, iG + iZ);
            }
            r73Var.f0(iG + iZ);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static l K(r73 r73Var, int i2, int i3) throws r83 {
        r73Var.f0(i2 + 8);
        int iG = r73Var.g();
        d dVarC = null;
        while (iG - i2 < i3) {
            r73Var.f0(iG);
            int iZ = r73Var.z();
            nz0.a(iZ > 0, "childAtomSize must be positive");
            if (r73Var.z() == 1702454643) {
                dVarC = C(r73Var, iG, iZ);
            }
            iG += iZ;
        }
        if (dVarC == null) {
            return null;
        }
        return new l(dVarC);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0540  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void L(r73 r73Var, int i2, int i3, int i4, int i5, String str, int i6, oo0 oo0Var, h hVar, int i7) throws r83 {
        oo0 oo0Var2;
        int i8;
        List list;
        int i9;
        int i10;
        int i11;
        int i12;
        byte[] bArr;
        String str2;
        int i13;
        bn0 bn0Var;
        String str3;
        String str4;
        int i14;
        String str5;
        int iK;
        int i15;
        oo0 oo0Var3;
        int i16;
        List list2;
        String str6;
        int i17;
        int i18;
        int i19;
        int i20;
        dx2.k kVar;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25 = i3;
        int i26 = i4;
        oo0 oo0VarS = oo0Var;
        h hVar2 = hVar;
        r73Var.f0(i25 + 16);
        r73Var.g0(16);
        int iY = r73Var.Y();
        int iY2 = r73Var.Y();
        r73Var.g0(50);
        int iG = r73Var.g();
        int iIntValue = i2;
        if (iIntValue == 1701733238) {
            Pair pairZ = z(r73Var, i25, i26);
            if (pairZ != null) {
                iIntValue = ((Integer) pairZ.first).intValue();
                oo0VarS = oo0VarS == null ? null : oo0VarS.s(((yq4) pairZ.second).b);
                hVar2.a[i7] = (yq4) pairZ.second;
            }
            r73Var.f0(iG);
        }
        String str7 = DLNAProfiles.DLNAMimeTypes.MIME_VIDEO_3GP;
        String str8 = iIntValue == 1831958048 ? DLNAProfiles.DLNAMimeTypes.MIME_VIDEO_MPEG : iIntValue == 1211250227 ? DLNAProfiles.DLNAMimeTypes.MIME_VIDEO_3GP : null;
        float fX = 1.0f;
        int i27 = 8;
        int i28 = 8;
        ByteBuffer byteBuffer = null;
        bn0 bn0VarA = null;
        List listW = null;
        String strF = null;
        byte[] bArrY = null;
        int i29 = -1;
        int i30 = -1;
        int i31 = -1;
        int i32 = -1;
        int i33 = -1;
        int i34 = -1;
        int i35 = -1;
        int iL = -1;
        a aVarK = null;
        c cVarN = null;
        dx2.k kVar2 = null;
        boolean z = false;
        while (true) {
            if (iG - i25 >= i26) {
                oo0Var2 = oo0VarS;
                i8 = i27;
                list = listW;
                i9 = i29;
                i10 = i34;
                i11 = i35;
                i12 = iL;
                bArr = null;
                str2 = str8;
                i13 = i28;
                bn0Var = bn0VarA;
                break;
            }
            r73Var.f0(iG);
            int iG2 = r73Var.g();
            int iZ = r73Var.z();
            if (iZ == 0 && r73Var.g() - i3 == i26) {
                oo0Var2 = oo0VarS;
                i8 = i27;
                bn0Var = bn0VarA;
                list = listW;
                i9 = i29;
                i10 = i34;
                i11 = i35;
                i12 = iL;
                bArr = null;
                str2 = str8;
                i13 = i28;
                break;
            }
            nz0.a(iZ > 0, "childAtomSize must be positive");
            int iZ2 = r73Var.z();
            if (iZ2 == 1635148611) {
                nz0.a(str8 == null, null);
                r73Var.f0(iG2 + 8);
                cf cfVarB = cf.b(r73Var);
                List list3 = cfVarB.a;
                hVar2.c = cfVarB.b;
                if (!z) {
                    fX = cfVarB.k;
                }
                String str9 = cfVarB.l;
                int i36 = cfVarB.j;
                int i37 = cfVarB.g;
                int i38 = cfVarB.h;
                listW = list3;
                int i39 = cfVarB.i;
                int i40 = cfVarB.e;
                oo0Var3 = oo0VarS;
                i14 = iG;
                i17 = iIntValue;
                str5 = str7;
                iK = i37;
                i15 = i38;
                iL = i39;
                str6 = "video/avc";
                i28 = cfVarB.f;
                strF = str9;
                i30 = i36;
                kVar = kVar2;
                i16 = i40;
            } else {
                i14 = iG;
                if (iZ2 == 1752589123) {
                    nz0.a(str8 == null, null);
                    r73Var.f0(iG2 + 8);
                    hd1 hd1VarA = hd1.a(r73Var);
                    List list4 = hd1VarA.a;
                    hVar2.c = hd1VarA.b;
                    if (!z) {
                        fX = hd1VarA.n;
                    }
                    int i41 = hd1VarA.o;
                    int i42 = hd1VarA.c;
                    String str10 = hd1VarA.p;
                    int i43 = hd1VarA.m;
                    listW = list4;
                    if (i43 != -1) {
                        i29 = i43;
                    }
                    int i44 = hd1VarA.f;
                    int i45 = hd1VarA.g;
                    int i46 = hd1VarA.j;
                    int i47 = hd1VarA.k;
                    int i48 = hd1VarA.l;
                    int i49 = hd1VarA.h;
                    int i50 = hd1VarA.i;
                    kVar = hd1VarA.q;
                    oo0Var3 = oo0VarS;
                    str6 = "video/hevc";
                    i17 = iIntValue;
                    str5 = str7;
                    iK = i46;
                    i15 = i47;
                    iL = i48;
                    i16 = i49;
                    i30 = i41;
                    i31 = i42;
                    i33 = i45;
                    i32 = i44;
                    i28 = i50;
                    strF = str10;
                } else {
                    str5 = str7;
                    if (iZ2 == 1818785347) {
                        nz0.a("video/hevc".equals(str8), "lhvC must follow hvcC atom");
                        dx2.k kVar3 = kVar2;
                        nz0.a(kVar3 != null && kVar3.b.size() >= 2, "must have at least two layers");
                        r73Var.f0(iG2 + 8);
                        hd1 hd1VarC = hd1.c(r73Var, (dx2.k) gg3.q(kVar3));
                        nz0.a(hVar2.c == hd1VarC.b, "nalUnitLengthFieldLength must be same for both hvcC and lhvC atoms");
                        int i51 = hd1VarC.j;
                        int i52 = i34;
                        if (i51 != -1) {
                            nz0.a(i52 == i51, "colorSpace must be the same for both views");
                        }
                        int i53 = hd1VarC.k;
                        int i54 = i35;
                        if (i53 != -1) {
                            nz0.a(i54 == i53, "colorRange must be the same for both views");
                        }
                        int i55 = hd1VarC.l;
                        if (i55 != -1) {
                            int i56 = iL;
                            i23 = i56;
                            nz0.a(i56 == i55, "colorTransfer must be the same for both views");
                        } else {
                            i23 = iL;
                        }
                        nz0.a(i27 == hd1VarC.h, "bitdepthLuma must be the same for both views");
                        nz0.a(i28 == hd1VarC.i, "bitdepthChroma must be the same for both views");
                        List listK = listW;
                        if (listK != null) {
                            listK = xi1.m().j(listK).j(hd1VarC.a).k();
                            i24 = i52;
                        } else {
                            i24 = i52;
                            nz0.a(false, "initializationData must be already set from hvcC atom");
                        }
                        oo0Var3 = oo0VarS;
                        i16 = i27;
                        str6 = "video/mv-hevc";
                        i17 = iIntValue;
                        i15 = i54;
                        iK = i24;
                        iL = i23;
                        strF = hd1VarC.p;
                        kVar = kVar3;
                        listW = listK;
                    } else {
                        List listL = listW;
                        iK = i34;
                        i15 = i35;
                        int i57 = iL;
                        dx2.k kVar4 = kVar2;
                        if (iZ2 == 1987470147) {
                            nz0.a(str8 == null, null);
                            r73Var.f0(iG2 + 8);
                            e85 e85VarA = e85.a(r73Var);
                            List list5 = e85VarA.a;
                            hVar2.c = e85VarA.b;
                            String str11 = e85VarA.c;
                            i28 = e85VarA.d;
                            i16 = i28;
                            kVar = kVar4;
                            oo0Var3 = oo0VarS;
                            listW = list5;
                            strF = str11;
                            str6 = "video/vvc";
                            i17 = iIntValue;
                            iL = i57;
                            i30 = 16;
                        } else if (iZ2 == 1986361461) {
                            l lVarK = K(r73Var, iG2, iZ);
                            if (lVarK == null || lVarK.a == null) {
                                i22 = i29;
                                i29 = i22;
                                kVar = kVar4;
                                oo0Var3 = oo0VarS;
                                i16 = i27;
                                listW = listL;
                                str6 = str8;
                                i17 = iIntValue;
                                iL = i57;
                            } else if (kVar4 == null || kVar4.b.size() < 2) {
                                i22 = i29;
                                if (i22 == -1) {
                                    i29 = lVarK.a.a.c ? 5 : 4;
                                } else {
                                    i29 = i22;
                                }
                                kVar = kVar4;
                                oo0Var3 = oo0VarS;
                                i16 = i27;
                                listW = listL;
                                str6 = str8;
                                i17 = iIntValue;
                                iL = i57;
                            } else {
                                nz0.a(lVarK.b(), "both eye views must be marked as available");
                                nz0.a(!lVarK.a.a.c, "for MV-HEVC, eye_views_reversed must be set to false");
                                i22 = i29;
                                i29 = i22;
                                kVar = kVar4;
                                oo0Var3 = oo0VarS;
                                i16 = i27;
                                listW = listL;
                                str6 = str8;
                                i17 = iIntValue;
                                iL = i57;
                            }
                        } else {
                            int i58 = i29;
                            if (iZ2 == 1685480259 || iZ2 == 1685485123 || iZ2 == 1685485379) {
                                oo0Var3 = oo0VarS;
                                i16 = i27;
                                list2 = listL;
                                str6 = str8;
                                i17 = iIntValue;
                                i18 = i28;
                                i19 = iK;
                                i20 = i57;
                                bn0VarA = bn0.a(r73Var);
                            } else if (iZ2 == 1987076931) {
                                nz0.a(str8 == null, null);
                                String str12 = iIntValue == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                                r73Var.f0(iG2 + 12);
                                byte bQ = (byte) r73Var.Q();
                                byte bQ2 = (byte) r73Var.Q();
                                int iQ = r73Var.Q();
                                i28 = iQ >> 4;
                                i17 = iIntValue;
                                byte b2 = (byte) ((iQ >> 1) & 7);
                                if (str12.equals("video/x-vnd.on2.vp9")) {
                                    listL = gv.l(bQ, bQ2, (byte) i28, b2);
                                }
                                boolean z2 = (iQ & 1) != 0;
                                int iQ2 = r73Var.Q();
                                int iQ3 = r73Var.Q();
                                int iK2 = bx.k(iQ2);
                                int i59 = z2 ? 1 : 2;
                                iL = bx.l(iQ3);
                                oo0Var3 = oo0VarS;
                                i16 = i28;
                                i15 = i59;
                                iK = iK2;
                                str6 = str12;
                                listW = listL;
                                kVar = kVar4;
                                i29 = i58;
                            } else {
                                i17 = iIntValue;
                                if (iZ2 == 1635135811) {
                                    int i60 = iZ - 8;
                                    byte[] bArr2 = new byte[i60];
                                    r73Var.u(bArr2, 0, i60);
                                    listW = xi1.w(bArr2);
                                    r73Var.f0(iG2 + 8);
                                    bx bxVarJ = j(r73Var);
                                    int i61 = bxVarJ.e;
                                    int i62 = bxVarJ.f;
                                    int i63 = bxVarJ.a;
                                    int i64 = bxVarJ.b;
                                    iL = bxVarJ.c;
                                    i16 = i61;
                                    oo0Var3 = oo0VarS;
                                    i28 = i62;
                                    iK = i63;
                                    i15 = i64;
                                    str6 = "video/av01";
                                    kVar = kVar4;
                                } else if (iZ2 == 1668050025) {
                                    ByteBuffer byteBufferA = byteBuffer == null ? a() : byteBuffer;
                                    byteBufferA.position(21);
                                    byteBufferA.putShort(r73Var.M());
                                    byteBufferA.putShort(r73Var.M());
                                    byteBuffer = byteBufferA;
                                    oo0Var3 = oo0VarS;
                                    i16 = i27;
                                    listW = listL;
                                    str6 = str8;
                                    kVar = kVar4;
                                    iL = i57;
                                } else if (iZ2 == 1835295606) {
                                    ByteBuffer byteBufferA2 = byteBuffer == null ? a() : byteBuffer;
                                    short sM = r73Var.M();
                                    short sM2 = r73Var.M();
                                    short sM3 = r73Var.M();
                                    str6 = str8;
                                    short sM4 = r73Var.M();
                                    short sM5 = r73Var.M();
                                    int i65 = i28;
                                    short sM6 = r73Var.M();
                                    i16 = i27;
                                    short sM7 = r73Var.M();
                                    oo0Var3 = oo0VarS;
                                    short sM8 = r73Var.M();
                                    long jS = r73Var.S();
                                    long jS2 = r73Var.S();
                                    byteBufferA2.position(1);
                                    byteBufferA2.putShort(sM5);
                                    byteBufferA2.putShort(sM6);
                                    byteBufferA2.putShort(sM);
                                    byteBufferA2.putShort(sM2);
                                    byteBufferA2.putShort(sM3);
                                    byteBufferA2.putShort(sM4);
                                    byteBufferA2.putShort(sM7);
                                    byteBufferA2.putShort(sM8);
                                    byteBufferA2.putShort((short) (jS / 10000));
                                    byteBufferA2.putShort((short) (jS2 / 10000));
                                    byteBuffer = byteBufferA2;
                                    kVar = kVar4;
                                    i28 = i65;
                                    iL = i57;
                                    listW = listL;
                                } else {
                                    oo0Var3 = oo0VarS;
                                    i16 = i27;
                                    list2 = listL;
                                    str6 = str8;
                                    i18 = i28;
                                    if (iZ2 == 1681012275) {
                                        nz0.a(str6 == null, null);
                                        kVar = kVar4;
                                        i28 = i18;
                                        str6 = str5;
                                    } else if (iZ2 == 1702061171) {
                                        nz0.a(str6 == null, null);
                                        cVarN = n(r73Var, iG2);
                                        String str13 = cVarN.a;
                                        byte[] bArr3 = cVarN.b;
                                        listW = bArr3 != null ? xi1.w(bArr3) : list2;
                                        str6 = str13;
                                        kVar = kVar4;
                                        i28 = i18;
                                        iL = i57;
                                        i29 = i58;
                                    } else {
                                        if (iZ2 == 1651798644) {
                                            aVarK = k(r73Var, iG2);
                                        } else {
                                            if (iZ2 == 1885434736) {
                                                fX = x(r73Var, iG2);
                                                kVar = kVar4;
                                                i28 = i18;
                                                iL = i57;
                                                listW = list2;
                                                z = true;
                                            } else if (iZ2 == 1937126244) {
                                                bArrY = y(r73Var, iG2, iZ);
                                            } else if (iZ2 == 1936995172) {
                                                int iQ4 = r73Var.Q();
                                                r73Var.g0(3);
                                                if (iQ4 != 0) {
                                                    i21 = i58;
                                                    kVar = kVar4;
                                                    i28 = i18;
                                                    iL = i57;
                                                    listW = list2;
                                                    i29 = i21;
                                                } else {
                                                    int iQ5 = r73Var.Q();
                                                    if (iQ5 != 0) {
                                                        i21 = 1;
                                                        if (iQ5 != 1) {
                                                            if (iQ5 == 2) {
                                                                i21 = 2;
                                                            } else if (iQ5 == 3) {
                                                                i21 = 3;
                                                            }
                                                        }
                                                    } else {
                                                        i21 = 0;
                                                    }
                                                    kVar = kVar4;
                                                    i28 = i18;
                                                    iL = i57;
                                                    listW = list2;
                                                    i29 = i21;
                                                }
                                            } else {
                                                if (iZ2 == 1634760259) {
                                                    int i66 = iZ - 12;
                                                    byte[] bArr4 = new byte[i66];
                                                    r73Var.f0(iG2 + 12);
                                                    r73Var.u(bArr4, 0, i66);
                                                    strF = gv.f(bArr4);
                                                    listW = xi1.w(bArr4);
                                                    bx bxVarH = h(new r73(bArr4));
                                                    int i67 = bxVarH.e;
                                                    int i68 = bxVarH.f;
                                                    int i69 = bxVarH.a;
                                                    int i70 = bxVarH.b;
                                                    iL = bxVarH.c;
                                                    i16 = i67;
                                                    i28 = i68;
                                                    iK = i69;
                                                    i15 = i70;
                                                    str6 = "video/apv";
                                                    kVar = kVar4;
                                                } else {
                                                    i19 = iK;
                                                    if (iZ2 == 1668246642) {
                                                        i20 = i57;
                                                        if (i19 == -1 && i20 == -1) {
                                                            int iZ3 = r73Var.z();
                                                            if (iZ3 == 1852009592 || iZ3 == 1852009571) {
                                                                int iY3 = r73Var.Y();
                                                                int iY4 = r73Var.Y();
                                                                r73Var.g0(2);
                                                                boolean z3 = iZ == 19 && (r73Var.Q() & 128) != 0;
                                                                iK = bx.k(iY3);
                                                                i15 = z3 ? 1 : 2;
                                                                kVar = kVar4;
                                                                i28 = i18;
                                                                listW = list2;
                                                                iL = bx.l(iY4);
                                                            } else {
                                                                xz1.i("BoxParsers", "Unsupported color type: " + su2.a(iZ3));
                                                            }
                                                        }
                                                    } else {
                                                        i20 = i57;
                                                    }
                                                }
                                            }
                                            i29 = i58;
                                        }
                                        kVar = kVar4;
                                        i28 = i18;
                                    }
                                    iL = i57;
                                    listW = list2;
                                    i29 = i58;
                                }
                                i29 = i58;
                            }
                            iK = i19;
                            i28 = i18;
                            listW = list2;
                            iL = i20;
                            kVar = kVar4;
                            i29 = i58;
                        }
                        iG = i14 + iZ;
                        i26 = i4;
                        hVar2 = hVar;
                        str8 = str6;
                        iIntValue = i17;
                        i27 = i16;
                        str7 = str5;
                        i34 = iK;
                        i35 = i15;
                        oo0VarS = oo0Var3;
                        kVar2 = kVar;
                        i25 = i3;
                    }
                }
            }
            iG = i14 + iZ;
            i26 = i4;
            hVar2 = hVar;
            str8 = str6;
            iIntValue = i17;
            i27 = i16;
            str7 = str5;
            i34 = iK;
            i35 = i15;
            oo0VarS = oo0Var3;
            kVar2 = kVar;
            i25 = i3;
        }
        if (bn0Var != null) {
            str3 = bn0Var.c;
            str4 = "video/dolby-vision";
        } else {
            str3 = strF;
            str4 = str2;
        }
        if (str4 == null) {
            return;
        }
        t41.b bVarW = new t41.b().j0(i5).A0(str4).V(str3).H0(iY).i0(iY2).c0(i32).b0(i33).v0(fX).z0(i6).x0(bArrY).D0(i9).l0(list).q0(i30).r0(i31).d0(oo0Var2).o0(str).W(new bx.b().d(i10).c(i11).e(i12).f(byteBuffer != null ? byteBuffer.array() : bArr).g(i8).b(i13).a());
        if (aVarK != null) {
            bVarW.T(ll1.m(aVarK.a)).u0(ll1.m(aVarK.b));
        } else if (cVarN != null) {
            bVarW.T(ll1.m(cVarN.c)).u0(ll1.m(cVarN.d));
        }
        hVar.b = bVarW.Q();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static xs2 M(r73 r73Var) {
        short sM = r73Var.M();
        r73Var.g0(2);
        String strN = r73Var.N(sM);
        int iMax = Math.max(strN.lastIndexOf(43), strN.lastIndexOf(45));
        try {
            return new xs2(new zu2(Float.parseFloat(strN.substring(0, iMax)), Float.parseFloat(strN.substring(iMax, strN.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int N(int i2) {
        int i3 = (i2 >> 16) & 255;
        int i4 = ((i2 >> 8) & 255) - 128;
        int i5 = ((i4 * 14075) / FileTime.NANO100_TO_MILLI) + i3;
        int i6 = (i2 & 255) - 128;
        int i7 = (i3 - ((i6 * 3455) / FileTime.NANO100_TO_MILLI)) - ((i4 * 7169) / FileTime.NANO100_TO_MILLI);
        return fy4.s(i3 + ((i6 * 17790) / FileTime.NANO100_TO_MILLI), 0, 255) | (fy4.s(i5, 0, 255) << 16) | (fy4.s(i7, 0, 255) << 8);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ByteBuffer a() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean b(long[] jArr, long j2, long j3, long j4) {
        int length = jArr.length - 1;
        return jArr[0] <= j3 && j3 < jArr[fy4.s(4, 0, length)] && jArr[fy4.s(jArr.length - 4, 0, length)] < j4 && j4 <= j2 + 2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int c(r73 r73Var, int i2, int i3, int i4) throws r83 {
        int iG = r73Var.g();
        nz0.a(iG >= i3, null);
        while (iG - i3 < i4) {
            r73Var.f0(iG);
            int iZ = r73Var.z();
            nz0.a(iZ > 0, "childAtomSize must be positive");
            if (r73Var.z() == i2) {
                return iG;
            }
            iG += iZ;
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String d(byte[] bArr, int i2, int i3) {
        gg3.v(bArr.length == 64);
        ArrayList arrayList = new ArrayList(16);
        for (int i4 = 0; i4 < bArr.length - 3; i4 += 4) {
            arrayList.add(String.format("%06x", Integer.valueOf(N(ll1.i(bArr[i4], bArr[i4 + 1], bArr[i4 + 2], bArr[i4 + 3])))));
        }
        return "size: " + i2 + "x" + i3 + "\npalette: " + wn1.h(", ").e(arrayList) + "\n";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String e(int i2) {
        char[] cArr = {(char) (((i2 >> 10) & 31) + 96), (char) (((i2 >> 5) & 31) + 96), (char) ((i2 & 31) + 96)};
        for (int i3 = 0; i3 < 3; i3++) {
            char c2 = cArr[i3];
            if (c2 < 'a' || c2 > 'z') {
                return null;
            }
        }
        return new String(cArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int f(int i2) {
        if (i2 == 1936684398) {
            return 1;
        }
        if (i2 == 1986618469) {
            return 2;
        }
        if (i2 == 1952807028 || i2 == 1935832172 || i2 == 1937072756 || i2 == 1668047728 || i2 == 1937072752) {
            return 3;
        }
        return i2 == 1835365473 ? 5 : -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void g(r73 r73Var) {
        int iG = r73Var.g();
        r73Var.g0(4);
        if (r73Var.z() != 1751411826) {
            iG += 4;
        }
        r73Var.f0(iG);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static bx h(r73 r73Var) {
        bx.b bVar = new bx.b();
        q73 q73Var = new q73(r73Var.f());
        q73Var.p(r73Var.g() * 8);
        q73Var.s(1);
        int iH = q73Var.h(8);
        for (int i2 = 0; i2 < iH; i2++) {
            q73Var.s(1);
            int iH2 = q73Var.h(8);
            for (int i3 = 0; i3 < iH2; i3++) {
                q73Var.r(6);
                boolean zG = q73Var.g();
                q73Var.q();
                q73Var.s(11);
                q73Var.r(4);
                int iH3 = q73Var.h(4) + 8;
                bVar.g(iH3);
                bVar.b(iH3);
                q73Var.s(1);
                if (zG) {
                    int iH4 = q73Var.h(8);
                    int iH5 = q73Var.h(8);
                    q73Var.s(1);
                    bVar.d(bx.k(iH4)).c(q73Var.g() ? 1 : 2).e(bx.l(iH5));
                }
            }
        }
        return bVar.a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x03aa A[PHI: r2 r8 r9 r11 r16 r23
      0x03aa: PHI (r2v17 java.util.List) = (r2v2 java.util.List), (r2v2 java.util.List), (r2v16 java.util.List), (r2v2 java.util.List), (r2v26 java.util.List) binds: [B:241:0x045c, B:243:0x046a, B:246:0x0474, B:234:0x0420, B:207:0x037a] A[DONT_GENERATE, DONT_INLINE]
      0x03aa: PHI (r8v11 int) = (r8v8 int), (r8v8 int), (r8v8 int), (r8v8 int), (r8v15 int) binds: [B:241:0x045c, B:243:0x046a, B:246:0x0474, B:234:0x0420, B:207:0x037a] A[DONT_GENERATE, DONT_INLINE]
      0x03aa: PHI (r9v8 int) = (r9v5 int), (r9v5 int), (r9v5 int), (r9v5 int), (r9v10 int) binds: [B:241:0x045c, B:243:0x046a, B:246:0x0474, B:234:0x0420, B:207:0x037a] A[DONT_GENERATE, DONT_INLINE]
      0x03aa: PHI (r11v11 java.lang.String) = 
      (r11v9 java.lang.String)
      (r11v10 java.lang.String)
      (r11v10 java.lang.String)
      (r11v12 java.lang.String)
      (r11v9 java.lang.String)
     binds: [B:241:0x045c, B:243:0x046a, B:246:0x0474, B:234:0x0420, B:207:0x037a] A[DONT_GENERATE, DONT_INLINE]
      0x03aa: PHI (r16v3 gl$c) = (r16v1 gl$c), (r16v2 gl$c), (r16v2 gl$c), (r16v1 gl$c), (r16v1 gl$c) binds: [B:241:0x045c, B:243:0x046a, B:246:0x0474, B:234:0x0420, B:207:0x037a] A[DONT_GENERATE, DONT_INLINE]
      0x03aa: PHI (r23v2 int) = (r23v1 int), (r23v1 int), (r23v1 int), (r23v3 int), (r23v4 int) binds: [B:241:0x045c, B:243:0x046a, B:246:0x0474, B:234:0x0420, B:207:0x037a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x015a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void i(r73 r73Var, int i2, int i3, int i4, int i5, String str, boolean z, oo0 oo0Var, h hVar, int i6) throws r83 {
        int iY;
        int iY2;
        int iR;
        int iZ;
        int i7;
        int i8;
        String str2;
        int i9;
        String str3;
        String str4;
        String str5;
        String str6;
        int iS0;
        int i10;
        int iIntValue = i2;
        int i11 = i4;
        oo0 oo0VarS = oo0Var;
        r73Var.f0(i3 + 16);
        if (z) {
            iY = r73Var.Y();
            r73Var.g0(6);
        } else {
            r73Var.g0(8);
            iY = 0;
        }
        if (iY == 0 || iY == 1) {
            iY2 = r73Var.Y();
            r73Var.g0(6);
            iR = r73Var.R();
            r73Var.f0(r73Var.g() - 4);
            iZ = r73Var.z();
            i7 = 2;
            if (iY == 1) {
                r73Var.g0(16);
            }
            i8 = -1;
        } else {
            if (iY != 2) {
                return;
            }
            r73Var.g0(16);
            iR = (int) Math.round(r73Var.x());
            int iU = r73Var.U();
            r73Var.g0(4);
            int iU2 = r73Var.U();
            int iU3 = r73Var.U();
            boolean z2 = (iU3 & 1) != 0;
            boolean z3 = (iU3 & 2) != 0;
            if (z2) {
                if (!z3 && iU2 == 32) {
                    i8 = 4;
                }
                r73Var.g0(8);
                iY2 = iU;
                i7 = 2;
                iZ = 0;
            } else {
                i8 = iU2 == 8 ? 3 : iU2 == 16 ? z3 ? 268435456 : 2 : iU2 == 24 ? z3 ? 1342177280 : 21 : iU2 == 32 ? z3 ? 1610612736 : 22 : -1;
                r73Var.g0(8);
                iY2 = iU;
                i7 = 2;
                iZ = 0;
            }
        }
        if (iIntValue == 1767992678) {
            iR = -1;
            iY2 = -1;
        } else {
            if (iIntValue != 1935764850) {
                iR = iIntValue == 1935767394 ? 16000 : 8000;
            }
            iY2 = 1;
        }
        int iG = r73Var.g();
        if (iIntValue == 1701733217) {
            Pair pairZ = z(r73Var, i3, i11);
            if (pairZ != null) {
                iIntValue = ((Integer) pairZ.first).intValue();
                oo0VarS = oo0VarS == null ? null : oo0VarS.s(((yq4) pairZ.second).b);
                hVar.a[i6] = (yq4) pairZ.second;
            }
            r73Var.f0(iG);
        }
        String str7 = "audio/mhm1";
        if (iIntValue == 1633889587) {
            str2 = "audio/ac3";
        } else if (iIntValue == 1700998451) {
            str2 = "audio/eac3";
        } else if (iIntValue == 1633889588) {
            str2 = "audio/ac4";
        } else if (iIntValue == 1685353315) {
            str2 = "audio/vnd.dts";
        } else if (iIntValue == 1685353320 || iIntValue == 1685353324) {
            str2 = "audio/vnd.dts.hd";
        } else if (iIntValue == 1685353317) {
            str2 = "audio/vnd.dts.hd;profile=lbr";
        } else if (iIntValue == 1685353336) {
            str2 = "audio/vnd.dts.uhd;profile=p2";
        } else if (iIntValue == 1935764850) {
            str2 = DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_3GP;
        } else {
            if (iIntValue != 1935767394) {
                if (iIntValue != 1936684916) {
                    if (iIntValue == 1953984371) {
                        str3 = "audio/raw";
                        i9 = 268435456;
                    } else if (iIntValue == 1819304813) {
                        i9 = i8 == -1 ? i7 : i8;
                        str3 = "audio/raw";
                    } else if (iIntValue == 778924082 || iIntValue == 778924083) {
                        str2 = DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_MPEG;
                    } else if (iIntValue == 1835557169) {
                        str2 = "audio/mha1";
                    } else if (iIntValue == 1835560241) {
                        i9 = i8;
                        str3 = "audio/mhm1";
                    } else if (iIntValue == 1634492771) {
                        str2 = "audio/alac";
                    } else if (iIntValue == 1634492791) {
                        str2 = "audio/g711-alaw";
                    } else if (iIntValue == 1970037111) {
                        str2 = "audio/g711-mlaw";
                    } else if (iIntValue == 1332770163) {
                        str2 = "audio/opus";
                    } else if (iIntValue == 1716281667) {
                        str2 = "audio/flac";
                    } else if (iIntValue == 1835823201) {
                        str2 = "audio/true-hd";
                    } else if (iIntValue == 1767992678) {
                        str2 = "audio/iamf";
                    } else {
                        i9 = i8;
                        str3 = null;
                    }
                }
                int iR0 = i9;
                List listE = null;
                String str8 = null;
                c cVarN = null;
                a aVarK = null;
                while (iG - i3 < i11) {
                    r73Var.f0(iG);
                    int iZ2 = r73Var.z();
                    String str9 = str8;
                    nz0.a(iZ2 > 0, "childAtomSize must be positive");
                    int iZ3 = r73Var.z();
                    if (iZ3 == 1835557187) {
                        r73Var.f0(iG + 8);
                        r73Var.g0(1);
                        int iQ = r73Var.Q();
                        r73Var.g0(1);
                        String str10 = Objects.equals(str3, str7) ? String.format("mhm1.%02X", Integer.valueOf(iQ)) : String.format("mha1.%02X", Integer.valueOf(iQ));
                        int iY3 = r73Var.Y();
                        str9 = str10;
                        byte[] bArr = new byte[iY3];
                        str4 = str7;
                        r73Var.u(bArr, 0, iY3);
                        listE = listE == null ? xi1.w(bArr) : xi1.x(bArr, (byte[]) listE.get(0));
                    } else {
                        str4 = str7;
                        if (iZ3 == 1835557200) {
                            r73Var.f0(iG + 8);
                            int iQ2 = r73Var.Q();
                            if (iQ2 > 0) {
                                byte[] bArr2 = new byte[iQ2];
                                r73Var.u(bArr2, 0, iQ2);
                                listE = listE == null ? xi1.w(bArr2) : xi1.x((byte[]) listE.get(0), bArr2);
                            }
                        } else {
                            if (iZ3 == 1702061171 || (z && iZ3 == 2002876005)) {
                                int iC = iZ3 == 1702061171 ? iG : c(r73Var, 1702061171, iG, iZ2);
                                if (iC != -1) {
                                    cVarN = n(r73Var, iC);
                                    str3 = cVarN.a;
                                    byte[] bArr3 = cVarN.b;
                                    if (bArr3 == null) {
                                        str6 = str9;
                                    } else if ("audio/vorbis".equals(str3)) {
                                        listE = d85.e(bArr3);
                                        str6 = str9;
                                    } else {
                                        if ("audio/mp4a-latm".equals(str3)) {
                                            k.b bVarF = defpackage.k.f(bArr3);
                                            iR = bVarF.a;
                                            iY2 = bVarF.b;
                                            str5 = bVarF.c;
                                        } else {
                                            str5 = str9;
                                        }
                                        xi1 xi1VarW = xi1.w(bArr3);
                                        str6 = str5;
                                        listE = xi1VarW;
                                    }
                                }
                            } else if (iZ3 == 1651798644) {
                                aVarK = k(r73Var, iG);
                            } else {
                                if (iZ3 == 1684103987) {
                                    r73Var.f0(iG + 8);
                                    hVar.b = l1.d(r73Var, Integer.toString(i5), str, oo0VarS);
                                } else if (iZ3 == 1684366131) {
                                    r73Var.f0(iG + 8);
                                    hVar.b = l1.h(r73Var, Integer.toString(i5), str, oo0VarS);
                                } else if (iZ3 == 1684103988) {
                                    r73Var.f0(iG + 8);
                                    hVar.b = p1.e(r73Var, Integer.toString(i5), str, oo0VarS);
                                } else if (iZ3 == 1684892784) {
                                    if (iZ <= 0) {
                                        throw r83.a("Invalid sample rate for Dolby TrueHD MLP stream: " + iZ, null);
                                    }
                                    str6 = str9;
                                    iR = iZ;
                                    iY2 = i7;
                                } else if (iZ3 == 1684305011 || iZ3 == 1969517683) {
                                    hVar.b = new t41.b().j0(i5).A0(str3).U(iY2).B0(iR).d0(oo0VarS).o0(str).Q();
                                    str6 = str9;
                                } else if (iZ3 == 1682927731) {
                                    int i12 = iZ2 - 8;
                                    byte[] bArr4 = a;
                                    byte[] bArrCopyOf = Arrays.copyOf(bArr4, bArr4.length + i12);
                                    r73Var.f0(iG + 8);
                                    r73Var.u(bArrCopyOf, bArr4.length, i12);
                                    listE = w63.a(bArrCopyOf);
                                } else if (iZ3 == 1684425825) {
                                    byte[] bArr5 = new byte[iZ2 - 8];
                                    bArr5[0] = 102;
                                    bArr5[1] = 76;
                                    bArr5[i7] = 97;
                                    bArr5[3] = 67;
                                    r73Var.f0(iG + 12);
                                    r73Var.u(bArr5, 4, iZ2 - 12);
                                    listE = xi1.w(bArr5);
                                } else {
                                    if (iZ3 == 1634492771) {
                                        int i13 = iZ2 - 12;
                                        byte[] bArr6 = new byte[i13];
                                        r73Var.f0(iG + 12);
                                        r73Var.u(bArr6, 0, i13);
                                        int[] iArrF = gv.F(bArr6);
                                        int i14 = iArrF[0];
                                        iY2 = iArrF[1];
                                        iR = i14;
                                        iR0 = fy4.r0(iArrF[i7]);
                                        listE = xi1.w(bArr6);
                                    } else if (iZ3 == 1767990114) {
                                        r73Var.f0(iG + 9);
                                        int iV = r73Var.V();
                                        byte[] bArr7 = new byte[iV];
                                        r73Var.u(bArr7, 0, iV);
                                        String strJ = gv.j(bArr7);
                                        xi1 xi1VarW2 = xi1.w(bArr7);
                                        str6 = strJ;
                                        listE = xi1VarW2;
                                    } else if (iZ3 == 1885564227) {
                                        r73Var.f0(iG + 12);
                                        ByteOrder byteOrder = (r73Var.Q() & 1) != 0 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;
                                        int iQ3 = r73Var.Q();
                                        if (iIntValue == 1768973165) {
                                            iS0 = fy4.s0(iQ3, byteOrder);
                                            i10 = -1;
                                        } else {
                                            iS0 = (iIntValue == 1718641517 && iQ3 == 32 && byteOrder.equals(ByteOrder.LITTLE_ENDIAN)) ? 4 : iR0;
                                            i10 = -1;
                                        }
                                        iR0 = iS0;
                                        if (iS0 != i10) {
                                            str3 = "audio/raw";
                                        }
                                    }
                                    str6 = str9;
                                }
                                str6 = str9;
                            }
                            iG += iZ2;
                            str7 = str4;
                            str8 = str6;
                            i11 = i4;
                        }
                    }
                    str6 = str9;
                    iG += iZ2;
                    str7 = str4;
                    str8 = str6;
                    i11 = i4;
                }
                String str11 = str8;
                if (hVar.b == null || str3 == null) {
                }
                t41.b bVarO0 = new t41.b().j0(i5).A0(str3).V(str11).U(iY2).B0(iR).t0(iR0).l0(listE).d0(oo0VarS).o0(str);
                if (cVarN != null) {
                    bVarO0.T(ll1.m(cVarN.c)).u0(ll1.m(cVarN.d));
                } else if (aVarK != null) {
                    bVarO0.T(ll1.m(aVarK.a)).u0(ll1.m(aVarK.b));
                }
                hVar.b = bVarO0.Q();
                return;
            }
            str2 = "audio/amr-wb";
        }
        String str12 = str2;
        i9 = i8;
        str3 = str12;
        int iR02 = i9;
        List listE2 = null;
        String str82 = null;
        c cVarN2 = null;
        a aVarK2 = null;
        while (iG - i3 < i11) {
        }
        String str112 = str82;
        if (hVar.b == null) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static bx j(r73 r73Var) {
        bx.b bVar = new bx.b();
        q73 q73Var = new q73(r73Var.f());
        q73Var.p(r73Var.g() * 8);
        q73Var.s(1);
        int iH = q73Var.h(3);
        q73Var.r(6);
        boolean zG = q73Var.g();
        boolean zG2 = q73Var.g();
        if (iH == 2 && zG) {
            bVar.g(zG2 ? 12 : 10);
            bVar.b(zG2 ? 12 : 10);
        } else if (iH <= 2) {
            bVar.g(zG ? 10 : 8);
            bVar.b(zG ? 10 : 8);
        }
        q73Var.r(13);
        q73Var.q();
        int iH2 = q73Var.h(4);
        if (iH2 != 1) {
            xz1.g("BoxParsers", "Unsupported obu_type: " + iH2);
            return bVar.a();
        }
        if (q73Var.g()) {
            xz1.g("BoxParsers", "Unsupported obu_extension_flag");
            return bVar.a();
        }
        boolean zG3 = q73Var.g();
        q73Var.q();
        if (zG3 && q73Var.h(8) > 127) {
            xz1.g("BoxParsers", "Excessive obu_size");
            return bVar.a();
        }
        int iH3 = q73Var.h(3);
        q73Var.q();
        if (q73Var.g()) {
            xz1.g("BoxParsers", "Unsupported reduced_still_picture_header");
            return bVar.a();
        }
        if (q73Var.g()) {
            xz1.g("BoxParsers", "Unsupported timing_info_present_flag");
            return bVar.a();
        }
        if (q73Var.g()) {
            xz1.g("BoxParsers", "Unsupported initial_display_delay_present_flag");
            return bVar.a();
        }
        int iH4 = q73Var.h(5);
        boolean z = false;
        for (int i2 = 0; i2 <= iH4; i2++) {
            q73Var.r(12);
            if (q73Var.h(5) > 7) {
                q73Var.q();
            }
        }
        int iH5 = q73Var.h(4);
        int iH6 = q73Var.h(4);
        q73Var.r(iH5 + 1);
        q73Var.r(iH6 + 1);
        if (q73Var.g()) {
            q73Var.r(7);
        }
        q73Var.r(7);
        boolean zG4 = q73Var.g();
        if (zG4) {
            q73Var.r(2);
        }
        if ((q73Var.g() ? 2 : q73Var.h(1)) > 0 && !q73Var.g()) {
            q73Var.r(1);
        }
        if (zG4) {
            q73Var.r(3);
        }
        q73Var.r(3);
        boolean zG5 = q73Var.g();
        if (iH3 == 2 && zG5) {
            q73Var.q();
        }
        if (iH3 != 1 && q73Var.g()) {
            z = true;
        }
        if (q73Var.g()) {
            int iH7 = q73Var.h(8);
            int iH8 = q73Var.h(8);
            bVar.d(bx.k(iH7)).c(((z || iH7 != 1 || iH8 != 13 || q73Var.h(8) != 0) ? q73Var.h(1) : 1) != 1 ? 2 : 1).e(bx.l(iH8));
        }
        return bVar.a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static a k(r73 r73Var, int i2) {
        r73Var.f0(i2 + 8);
        r73Var.g0(4);
        return new a(r73Var.S(), r73Var.S());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Pair l(r73 r73Var, int i2, int i3) throws r83 {
        int i4 = i2 + 8;
        int i5 = -1;
        int i6 = 0;
        String strN = null;
        Integer numValueOf = null;
        while (i4 - i2 < i3) {
            r73Var.f0(i4);
            int iZ = r73Var.z();
            int iZ2 = r73Var.z();
            if (iZ2 == 1718775137) {
                numValueOf = Integer.valueOf(r73Var.z());
            } else if (iZ2 == 1935894637) {
                r73Var.g0(4);
                strN = r73Var.N(4);
            } else if (iZ2 == 1935894633) {
                i5 = i4;
                i6 = iZ;
            }
            i4 += iZ;
        }
        if (!"cenc".equals(strN) && !"cbc1".equals(strN) && !"cens".equals(strN) && !"cbcs".equals(strN)) {
            return null;
        }
        nz0.a(numValueOf != null, "frma atom is mandatory");
        nz0.a(i5 != -1, "schi atom is mandatory");
        yq4 yq4VarA = A(r73Var, i5, i6, strN);
        nz0.a(yq4VarA != null, "tenc atom is mandatory");
        return Pair.create(numValueOf, (yq4) fy4.l(yq4VarA));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Pair m(su2.b bVar) {
        su2.c cVarE = bVar.e(1701606260);
        if (cVarE == null) {
            return null;
        }
        r73 r73Var = cVarE.b;
        r73Var.f0(8);
        int iQ = q(r73Var.z());
        int iU = r73Var.U();
        long[] jArr = new long[iU];
        long[] jArr2 = new long[iU];
        for (int i2 = 0; i2 < iU; i2++) {
            jArr[i2] = iQ == 1 ? r73Var.X() : r73Var.S();
            jArr2[i2] = iQ == 1 ? r73Var.J() : r73Var.z();
            if (r73Var.M() != 1) {
                jl.a("Unsupported media rate.");
                return null;
            }
            r73Var.g0(2);
        }
        return Pair.create(jArr, jArr2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static c n(r73 r73Var, int i2) {
        r73Var.f0(i2 + 12);
        r73Var.g0(1);
        o(r73Var);
        r73Var.g0(2);
        int iQ = r73Var.Q();
        if ((iQ & 128) != 0) {
            r73Var.g0(2);
        }
        if ((iQ & 64) != 0) {
            r73Var.g0(r73Var.Q());
        }
        if ((iQ & 32) != 0) {
            r73Var.g0(2);
        }
        r73Var.g0(1);
        o(r73Var);
        String strH = nt2.h(r73Var.Q());
        if (DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_MPEG.equals(strH) || "audio/vnd.dts".equals(strH) || "audio/vnd.dts.hd".equals(strH)) {
            return new c(strH, null, -1L, -1L);
        }
        r73Var.g0(4);
        long jS = r73Var.S();
        long jS2 = r73Var.S();
        r73Var.g0(1);
        int iO = o(r73Var);
        long j2 = jS2;
        byte[] bArr = new byte[iO];
        r73Var.u(bArr, 0, iO);
        if (j2 <= 0) {
            j2 = -1;
        }
        return new c(strH, bArr, j2, jS > 0 ? jS : -1L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int o(r73 r73Var) {
        int iQ = r73Var.Q();
        int i2 = iQ & 127;
        while ((iQ & 128) == 128) {
            iQ = r73Var.Q();
            i2 = (i2 << 7) | (iQ & 127);
        }
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int p(int i2) {
        return i2 & 16777215;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int q(int i2) {
        return (i2 >> 24) & 255;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int r(r73 r73Var) {
        r73Var.f0(16);
        return r73Var.z();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static xs2 s(r73 r73Var, int i2) {
        r73Var.g0(8);
        ArrayList arrayList = new ArrayList();
        while (r73Var.g() < i2) {
            xs2.a aVarC = gt2.c(r73Var);
            if (aVarC != null) {
                arrayList.add(aVarC);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new xs2(arrayList);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static e t(r73 r73Var) {
        long j2;
        r73Var.f0(8);
        int iQ = q(r73Var.z());
        r73Var.g0(iQ == 0 ? 8 : 16);
        long jS = r73Var.S();
        int iG = r73Var.g();
        int i2 = iQ == 0 ? 4 : 8;
        int i3 = 0;
        while (true) {
            j2 = -9223372036854775807L;
            if (i3 >= i2) {
                r73Var.g0(i2);
                break;
            }
            if (r73Var.f()[iG + i3] != -1) {
                long jS2 = iQ == 0 ? r73Var.S() : r73Var.X();
                if (jS2 != 0) {
                    long jU1 = fy4.u1(jS2, 1000000L, jS);
                    jS = jS;
                    j2 = jU1;
                }
            } else {
                i3++;
            }
        }
        return new e(jS, j2, e(r73Var.Y()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static xs2 u(su2.b bVar) {
        su2.c cVarE = bVar.e(1751411826);
        su2.c cVarE2 = bVar.e(1801812339);
        su2.c cVarE3 = bVar.e(1768715124);
        if (cVarE == null || cVarE2 == null || cVarE3 == null || r(cVarE.b) != 1835299937) {
            return null;
        }
        r73 r73Var = cVarE2.b;
        r73Var.f0(12);
        int iZ = r73Var.z();
        String[] strArr = new String[iZ];
        for (int i2 = 0; i2 < iZ; i2++) {
            int iZ2 = r73Var.z();
            r73Var.g0(4);
            strArr[i2] = r73Var.N(iZ2 - 8);
        }
        r73 r73Var2 = cVarE3.b;
        r73Var2.f0(8);
        ArrayList arrayList = new ArrayList();
        while (r73Var2.a() > 8) {
            int iG = r73Var2.g();
            int iZ3 = r73Var2.z();
            int iZ4 = r73Var2.z() - 1;
            if (iZ4 < 0 || iZ4 >= iZ) {
                xz1.i("BoxParsers", "Skipped metadata with unknown key index: " + iZ4);
            } else {
                w62 w62VarH = gt2.h(r73Var2, iG + iZ3, strArr[iZ4]);
                if (w62VarH != null) {
                    arrayList.add(w62VarH);
                }
            }
            r73Var2.f0(iG + iZ3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new xs2(arrayList);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void v(r73 r73Var, int i2, int i3, int i4, h hVar) {
        r73Var.f0(i3 + 16);
        if (i2 == 1835365492) {
            r73Var.K();
            String strK = r73Var.K();
            if (strK != null) {
                hVar.b = new t41.b().j0(i4).A0(strK).Q();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static av2 w(r73 r73Var) {
        long J;
        long J2;
        r73Var.f0(8);
        if (q(r73Var.z()) == 0) {
            J = r73Var.S();
            J2 = r73Var.S();
        } else {
            J = r73Var.J();
            J2 = r73Var.J();
        }
        return new av2(J, J2, r73Var.S());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static float x(r73 r73Var, int i2) {
        r73Var.f0(i2 + 8);
        return r73Var.U() / r73Var.U();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static byte[] y(r73 r73Var, int i2, int i3) {
        int i4 = i2 + 8;
        while (i4 - i2 < i3) {
            r73Var.f0(i4);
            int iZ = r73Var.z();
            if (r73Var.z() == 1886547818) {
                return Arrays.copyOfRange(r73Var.f(), i4, iZ + i4);
            }
            i4 += iZ;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Pair z(r73 r73Var, int i2, int i3) throws r83 {
        Pair pairL;
        int iG = r73Var.g();
        while (iG - i2 < i3) {
            r73Var.f0(iG);
            int iZ = r73Var.z();
            nz0.a(iZ > 0, "childAtomSize must be positive");
            if (r73Var.z() == 1936289382 && (pairL = l(r73Var, iG, iZ)) != null) {
                return pairL;
            }
            iG += iZ;
        }
        return null;
    }
}
