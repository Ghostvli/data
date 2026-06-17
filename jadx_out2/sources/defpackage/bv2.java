package defpackage;

import defpackage.ki4;
import defpackage.p50;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class bv2 implements ki4 {
    public final r73 a = new r73();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static p50 d(r73 r73Var, int i) {
        CharSequence charSequenceR = null;
        p50.b bVarP = null;
        while (i > 0) {
            gg3.e(i >= 8, "Incomplete vtt cue box header found.");
            int iZ = r73Var.z();
            int iZ2 = r73Var.z();
            int i2 = iZ - 8;
            String strO = fy4.O(r73Var.f(), r73Var.g(), i2);
            r73Var.g0(i2);
            i = (i - 8) - i2;
            if (iZ2 == 1937011815) {
                bVarP = b95.p(strO);
            } else if (iZ2 == 1885436268) {
                charSequenceR = b95.r(null, strO.trim(), Collections.EMPTY_LIST);
            }
        }
        if (charSequenceR == null) {
            charSequenceR = "";
        }
        return bVarP != null ? bVarP.o(charSequenceR).a() : b95.m(charSequenceR);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ki4
    public void b(byte[] bArr, int i, int i2, ki4.b bVar, g20 g20Var) {
        this.a.d0(bArr, i2 + i);
        this.a.f0(i);
        ArrayList arrayList = new ArrayList();
        while (this.a.a() > 0) {
            gg3.e(this.a.a() >= 8, "Incomplete Mp4Webvtt Top Level box header found.");
            int iZ = this.a.z();
            int iZ2 = this.a.z();
            r73 r73Var = this.a;
            if (iZ2 == 1987343459) {
                arrayList.add(d(r73Var, iZ - 8));
            } else {
                r73Var.g0(iZ - 8);
            }
        }
        g20Var.accept(new y50(arrayList, -9223372036854775807L, -9223372036854775807L));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ki4
    public int c() {
        return 2;
    }
}
