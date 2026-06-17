package defpackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.a;
import com.google.android.material.carousel.b;
import com.google.android.material.carousel.c;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class xv2 extends a {
    public static final int[] d = {1};
    public static final int[] e = {1, 0};
    public int c = 0;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.google.android.material.carousel.a
    public c g(iq iqVar, View view) {
        boolean z;
        int iD = iqVar.d();
        if (iqVar.z()) {
            iD = iqVar.a();
        }
        RecyclerView.r rVar = (RecyclerView.r) view.getLayoutParams();
        float f = ((ViewGroup.MarginLayoutParams) rVar).topMargin + ((ViewGroup.MarginLayoutParams) rVar).bottomMargin;
        float measuredHeight = view.getMeasuredHeight();
        if (iqVar.z()) {
            f = ((ViewGroup.MarginLayoutParams) rVar).leftMargin + ((ViewGroup.MarginLayoutParams) rVar).rightMargin;
            measuredHeight = view.getMeasuredWidth();
        }
        float fD = d() + f;
        float fMax = Math.max(c() + f, fD);
        float f2 = iD;
        float fMin = Math.min(measuredHeight + f, f2);
        float fA = r62.a((measuredHeight / 3.0f) + f, fD + f, fMax + f);
        float f3 = (fMin + fA) / 2.0f;
        int[] iArrA = d;
        float f4 = 2.0f * fD;
        if (f2 <= f4) {
            iArrA = new int[]{0};
        }
        int[] iArrA2 = e;
        if (iqVar.r() == 1) {
            iArrA = a.a(iArrA);
            iArrA2 = a.a(iArrA2);
        }
        int[] iArr = iArrA2;
        int[] iArr2 = iArrA;
        float f5 = f;
        int iMax = (int) Math.max(1.0d, Math.floor(((f2 - (b.i(iArr) * f3)) - (b.i(iArr2) * fMax)) / fMin));
        int iCeil = (int) Math.ceil(f2 / fMin);
        int i = (iCeil - iMax) + 1;
        int[] iArr3 = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr3[i2] = iCeil - i2;
        }
        ea eaVarC = ea.c(f2, fA, fD, fMax, iArr2, f3, iArr, fMin, iArr3);
        this.c = eaVarC.e();
        boolean zI = i(eaVarC, iqVar.v());
        int i3 = eaVarC.d;
        if (i3 == 0 && eaVarC.c == 0 && f2 > f4) {
            eaVarC.c = 1;
            z = true;
        } else {
            z = zI;
        }
        if (z) {
            eaVarC = ea.c(f2, fA, fD, fMax, new int[]{eaVarC.c}, f3, new int[]{i3}, fMin, new int[]{eaVarC.g});
        }
        return b.d(view.getContext(), f5, iD, eaVarC, iqVar.r());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.google.android.material.carousel.a
    public boolean h(iq iqVar, int i) {
        if (i >= this.c || iqVar.v() < this.c) {
            return i >= this.c && iqVar.v() < this.c;
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean i(ea eaVar, int i) {
        int iE = eaVar.e() - i;
        boolean z = iE > 0 && (eaVar.c > 0 || eaVar.d > 1);
        while (iE > 0) {
            int i2 = eaVar.c;
            if (i2 > 0) {
                eaVar.c = i2 - 1;
            } else {
                int i3 = eaVar.d;
                if (i3 > 1) {
                    eaVar.d = i3 - 1;
                }
            }
            iE--;
        }
        return z;
    }
}
