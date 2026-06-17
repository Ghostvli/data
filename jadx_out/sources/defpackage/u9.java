package defpackage;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class u9 extends c74 {
    public static xs2 c(q73 q73Var) {
        q73Var.r(12);
        int iD = (q73Var.d() + q73Var.h(12)) - 4;
        q73Var.r(44);
        q73Var.s(q73Var.h(12));
        q73Var.r(16);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String strL = null;
            if (q73Var.d() >= iD) {
                break;
            }
            q73Var.r(48);
            int iH = q73Var.h(8);
            q73Var.r(4);
            int iD2 = q73Var.d() + q73Var.h(12);
            String strL2 = null;
            while (q73Var.d() < iD2) {
                int iH2 = q73Var.h(8);
                int iH3 = q73Var.h(8);
                int iD3 = q73Var.d() + iH3;
                if (iH2 == 2) {
                    int iH4 = q73Var.h(16);
                    q73Var.r(8);
                    if (iH4 == 3) {
                        while (q73Var.d() < iD3) {
                            strL = q73Var.l(q73Var.h(8), StandardCharsets.US_ASCII);
                            int iH5 = q73Var.h(8);
                            for (int i = 0; i < iH5; i++) {
                                q73Var.s(q73Var.h(8));
                            }
                        }
                    }
                } else if (iH2 == 21) {
                    strL2 = q73Var.l(iH3, StandardCharsets.US_ASCII);
                }
                q73Var.p(iD3 * 8);
            }
            q73Var.p(iD2 * 8);
            if (strL != null && strL2 != null) {
                arrayList.add(new t9(iH, strL.concat(strL2)));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new xs2(arrayList);
    }

    @Override // defpackage.c74
    public xs2 b(at2 at2Var, ByteBuffer byteBuffer) {
        if (byteBuffer.get() == 116) {
            return c(new q73(byteBuffer.array(), byteBuffer.limit()));
        }
        return null;
    }
}
