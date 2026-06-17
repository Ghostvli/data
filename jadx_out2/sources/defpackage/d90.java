package defpackage;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d90 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static jo0 a(ih ihVar, fh1 fh1Var, jo0 jo0Var, int i) {
        if (jo0Var == null) {
            jo0Var = new jo0();
        }
        jo0 jo0Var2 = jo0Var;
        jo0Var2.i((int) Math.ceil(ihVar.o), (int) Math.ceil(ihVar.p), fh1Var.m(), false, i);
        ko0 ko0VarJ = jo0Var2.get();
        if (ko0VarJ != null) {
            ((o) fh1Var).v(ihVar, ko0VarJ.a, 0.0f, 0.0f, true);
            if (fh1Var.isHardwareAccelerated()) {
                ko0VarJ.e(fh1Var.b(), fh1Var.a(), fh1Var.p(), fh1Var.k());
            }
        }
        return jo0Var2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean b(int i, int i2, float[] fArr, float[] fArr2) {
        if (i != i2) {
            return false;
        }
        return i == 1 ? fArr2[0] < fArr[2] : i == 6 && fArr2[2] > fArr[0];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean c(fh1 fh1Var, ih ihVar, ih ihVar2, long j) {
        float[] fArrH = ihVar.h(fh1Var, j);
        float[] fArrH2 = ihVar2.h(fh1Var, j);
        if (fArrH == null || fArrH2 == null) {
            return false;
        }
        return b(ihVar.m(), ihVar2.m(), fArrH, fArrH2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final int d(ih ihVar, ih ihVar2) {
        if (ihVar == ihVar2) {
            return 0;
        }
        if (ihVar == null) {
            return -1;
        }
        if (ihVar2 == null) {
            return 1;
        }
        long j = ihVar.j() - ihVar2.j();
        if (j > 0) {
            return 1;
        }
        if (j < 0) {
            return -1;
        }
        int i = ihVar.r - ihVar2.r;
        return i != 0 ? i < 0 ? -1 : 1 : ihVar.hashCode() - ihVar.hashCode();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void e(ih ihVar, CharSequence charSequence) {
        ihVar.c = charSequence;
        if (TextUtils.isEmpty(charSequence) || !charSequence.toString().contains("/n")) {
            return;
        }
        String[] strArrSplit = String.valueOf(ihVar.c).split("/n", -1);
        if (strArrSplit.length > 1) {
            ihVar.d = strArrSplit;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int f(int i, int i2, int i3) {
        return i * i2 * i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final boolean g(ih ihVar, ih ihVar2) {
        if (ihVar == ihVar2) {
            return false;
        }
        CharSequence charSequence = ihVar.c;
        CharSequence charSequence2 = ihVar2.c;
        if (charSequence == charSequence2) {
            return true;
        }
        return charSequence != null && charSequence.equals(charSequence2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean h(fh1 fh1Var, ih ihVar, ih ihVar2, long j, long j2) {
        int iM = ihVar.m();
        if (iM != ihVar2.m() || ihVar.s()) {
            return false;
        }
        long jB = ihVar2.b() - ihVar.b();
        if (jB <= 0) {
            return true;
        }
        if (Math.abs(jB) >= j || ihVar.w() || ihVar2.w()) {
            return false;
        }
        return iM == 5 || iM == 4 || c(fh1Var, ihVar, ihVar2, j2) || c(fh1Var, ihVar, ihVar2, ihVar.b() + ihVar.f());
    }
}
