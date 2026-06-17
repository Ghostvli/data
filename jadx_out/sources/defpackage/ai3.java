package defpackage;

import defpackage.zh3;
import java.util.ArrayList;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ai3 {
    public static zh3 a(byte[] bArr, int i) {
        ArrayList arrayListF;
        r73 r73Var = new r73(bArr);
        try {
            arrayListF = c(r73Var) ? f(r73Var) : e(r73Var);
        } catch (ArrayIndexOutOfBoundsException unused) {
            arrayListF = null;
        }
        if (arrayListF == null) {
            return null;
        }
        int size = arrayListF.size();
        if (size == 1) {
            return new zh3((zh3.a) arrayListF.get(0), i);
        }
        if (size != 2) {
            return null;
        }
        return new zh3((zh3.a) arrayListF.get(0), (zh3.a) arrayListF.get(1), i);
    }

    public static int b(int i) {
        return (-(i & 1)) ^ (i >> 1);
    }

    public static boolean c(r73 r73Var) {
        r73Var.g0(4);
        int iZ = r73Var.z();
        r73Var.f0(0);
        return iZ == 1886547818;
    }

    public static zh3.a d(r73 r73Var) {
        int iZ = r73Var.z();
        zh3.a aVar = null;
        if (iZ > 10000) {
            return null;
        }
        float[] fArr = new float[iZ];
        for (int i = 0; i < iZ; i++) {
            fArr[i] = r73Var.y();
        }
        int iZ2 = r73Var.z();
        if (iZ2 > 32000) {
            return null;
        }
        double d = 2.0d;
        double dLog = Math.log(2.0d);
        int iCeil = (int) Math.ceil(Math.log(((double) iZ) * 2.0d) / dLog);
        q73 q73Var = new q73(r73Var.f());
        int i2 = 8;
        q73Var.p(r73Var.g() * 8);
        float[] fArr2 = new float[iZ2 * 5];
        int[] iArr = new int[5];
        int i3 = 0;
        int i4 = 0;
        while (i3 < iZ2) {
            zh3.a aVar2 = aVar;
            int i5 = 0;
            while (i5 < 5) {
                int iB = iArr[i5] + b(q73Var.h(iCeil));
                if (iB >= iZ || iB < 0) {
                    return aVar2;
                }
                fArr2[i4] = fArr[iB];
                iArr[i5] = iB;
                i5++;
                i4++;
            }
            i3++;
            aVar = aVar2;
        }
        zh3.a aVar3 = aVar;
        q73Var.p((q73Var.e() + 7) & (-8));
        int i6 = 32;
        int iH = q73Var.h(32);
        zh3.b[] bVarArr = new zh3.b[iH];
        int i7 = 0;
        while (i7 < iH) {
            int iH2 = q73Var.h(i2);
            int iH3 = q73Var.h(i2);
            int iH4 = q73Var.h(i6);
            if (iH4 > 128000) {
                return aVar3;
            }
            int i8 = iH;
            int iCeil2 = (int) Math.ceil(Math.log(((double) iZ2) * d) / dLog);
            float[] fArr3 = new float[iH4 * 3];
            float[] fArr4 = new float[iH4 * 2];
            int i9 = 0;
            int i10 = 0;
            while (i9 < iH4) {
                int iB2 = i10 + b(q73Var.h(iCeil2));
                if (iB2 < 0 || iB2 >= iZ2) {
                    return aVar3;
                }
                int i11 = i9 * 3;
                int i12 = iB2 * 5;
                fArr3[i11] = fArr2[i12];
                fArr3[i11 + 1] = fArr2[i12 + 1];
                fArr3[i11 + 2] = fArr2[i12 + 2];
                int i13 = i9 * 2;
                fArr4[i13] = fArr2[i12 + 3];
                fArr4[i13 + 1] = fArr2[i12 + 4];
                i9++;
                i10 = iB2;
            }
            bVarArr[i7] = new zh3.b(iH2, fArr3, fArr4, iH3);
            i7++;
            iH = i8;
            i6 = 32;
            d = 2.0d;
            i2 = 8;
        }
        return new zh3.a(bVarArr);
    }

    public static ArrayList e(r73 r73Var) {
        if (r73Var.Q() != 0) {
            return null;
        }
        r73Var.g0(7);
        int iZ = r73Var.z();
        if (iZ == 1684433976) {
            r73 r73Var2 = new r73();
            Inflater inflater = new Inflater(true);
            try {
                if (!fy4.M0(r73Var, r73Var2, inflater)) {
                    return null;
                }
                inflater.end();
                r73Var = r73Var2;
            } finally {
                inflater.end();
            }
        } else if (iZ != 1918990112) {
            return null;
        }
        return g(r73Var);
    }

    public static ArrayList f(r73 r73Var) {
        int iZ;
        r73Var.g0(8);
        int iG = r73Var.g();
        int iJ = r73Var.j();
        while (iG < iJ && (iZ = r73Var.z() + iG) > iG && iZ <= iJ) {
            int iZ2 = r73Var.z();
            if (iZ2 == 2037673328 || iZ2 == 1836279920) {
                r73Var.e0(iZ);
                return e(r73Var);
            }
            r73Var.f0(iZ);
            iG = iZ;
        }
        return null;
    }

    public static ArrayList g(r73 r73Var) {
        ArrayList arrayList = new ArrayList();
        int iG = r73Var.g();
        int iJ = r73Var.j();
        while (iG < iJ) {
            int iZ = r73Var.z() + iG;
            if (iZ <= iG || iZ > iJ) {
                return null;
            }
            if (r73Var.z() == 1835365224) {
                zh3.a aVarD = d(r73Var);
                if (aVarD == null) {
                    return null;
                }
                arrayList.add(aVarD);
            }
            r73Var.f0(iZ);
            iG = iZ;
        }
        return arrayList;
    }
}
