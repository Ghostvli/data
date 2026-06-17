package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class t94 {
    public static final int[] a = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean a(int i, boolean z) {
        if ((i >>> 8) == 3368816) {
            return true;
        }
        if (i == 1751476579 && z) {
            return true;
        }
        for (int i2 : a) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static s94 b(jz0 jz0Var) {
        return c(jz0Var, true, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r12v14, resolved type: int[] */
    /* JADX DEBUG: Multi-variable search result rejected for r12v15, resolved type: int[] */
    /* JADX DEBUG: Multi-variable search result rejected for r12v19, resolved type: int[] */
    /* JADX DEBUG: Multi-variable search result rejected for r12v20, resolved type: int[] */
    /* JADX WARN: Multi-variable type inference failed */
    public static s94 c(jz0 jz0Var, boolean z, boolean z2) {
        s94 s94Var;
        int i;
        long j;
        int i2;
        long J;
        int i3;
        int i4;
        long j2;
        int i5;
        boolean z3;
        int[] iArr;
        long length = jz0Var.getLength();
        long j3 = -1;
        int i6 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
        long j4 = 4096;
        if (i6 != 0 && length <= 4096) {
            j4 = length;
        }
        int i7 = (int) j4;
        r73 r73Var = new r73(64);
        int i8 = 0;
        int i9 = 0;
        boolean z4 = false;
        while (i9 < i7) {
            r73Var.b0(8);
            if (!jz0Var.j(r73Var.f(), i8, 8, true)) {
                break;
            }
            long jS = r73Var.S();
            int iZ = r73Var.z();
            if (jS == 1) {
                j = j3;
                jz0Var.s(r73Var.f(), 8, 8);
                i4 = 16;
                r73Var.e0(16);
                i2 = i9;
                J = r73Var.J();
                i3 = i6;
            } else {
                j = j3;
                if (jS == 0) {
                    long length2 = jz0Var.getLength();
                    if (length2 != j) {
                        jS = (length2 - jz0Var.k()) + 8;
                    }
                }
                long j5 = jS;
                i2 = i9;
                J = j5;
                i3 = i6;
                i4 = 8;
            }
            long j6 = i4;
            if (J < j6) {
                s94Var = null;
                if (iZ != 1718773093 || i4 != 8) {
                    return new tb(iZ, J, i4);
                }
                J = j6;
            } else {
                s94Var = null;
            }
            int i10 = i2 + i4;
            if (iZ == 1836019574 || iZ == 1970628964) {
                i7 += (int) J;
                if (i3 != 0 && i7 > length) {
                    i7 = (int) length;
                }
                if (iZ == 1836019574) {
                    i9 = i10;
                    i6 = i3;
                    j3 = j;
                    i8 = 0;
                }
            }
            if (iZ != 1953653099 && iZ != 1835297121 && iZ != 1835626086) {
                if (iZ != 1836019558 && iZ != 1836475768) {
                    if (iZ == 1835295092) {
                        z4 = true;
                    }
                    if (iZ != 1937007212 || J <= 1000000) {
                        j2 = length;
                        if ((((long) i10) + J) - j6 < i7) {
                            int i11 = (int) (J - j6);
                            i9 = i10 + i11;
                            if (iZ != 1718909296) {
                                i5 = 0;
                                if (i11 != 0) {
                                    jz0Var.m(i11);
                                }
                            } else {
                                if (i11 < 8) {
                                    return new tb(iZ, i11, 8);
                                }
                                r73Var.b0(i11);
                                i5 = 0;
                                jz0Var.s(r73Var.f(), 0, i11);
                                int iZ2 = r73Var.z();
                                if (a(iZ2, z2)) {
                                    z4 = true;
                                }
                                r73Var.g0(4);
                                int iA = r73Var.a() / 4;
                                if (!z4 && iA > 0) {
                                    int[] iArr2 = new int[iA];
                                    int i12 = 0;
                                    while (true) {
                                        if (i12 >= iA) {
                                            z3 = z4;
                                            iArr = iArr2;
                                            break;
                                        }
                                        int iZ3 = r73Var.z();
                                        iArr2[i12] = iZ3;
                                        if (a(iZ3, z2)) {
                                            z3 = true;
                                            iArr = iArr2;
                                            break;
                                        }
                                        i12++;
                                    }
                                } else {
                                    z3 = z4;
                                    iArr = s94Var;
                                }
                                if (!z3) {
                                    return new yw4(iZ2, iArr);
                                }
                                z4 = z3;
                            }
                        }
                    }
                    i = 0;
                    break;
                }
                i = 1;
                break;
            }
            j2 = length;
            i5 = 0;
            i9 = i10;
            i8 = i5;
            i6 = i3;
            j3 = j;
            length = j2;
        }
        s94Var = null;
        i = i8;
        return !z4 ? c33.a : z != i ? i != 0 ? ij1.b : ij1.c : s94Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static s94 d(jz0 jz0Var, boolean z) {
        return c(jz0Var, false, z);
    }
}
