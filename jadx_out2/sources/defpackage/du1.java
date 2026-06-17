package defpackage;

import defpackage.bl1;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class du1 implements cu1 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static bl1.i d(Object obj, long j) {
        return (bl1.i) vw4.C(obj, j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cu1
    public void a(Object obj, Object obj2, long j) {
        bl1.i iVarD = d(obj, j);
        bl1.i iVarD2 = d(obj2, j);
        int size = iVarD.size();
        int size2 = iVarD2.size();
        if (size > 0 && size2 > 0) {
            if (!iVarD.v()) {
                iVarD = iVarD.a(size2 + size);
            }
            iVarD.addAll(iVarD2);
        }
        if (size > 0) {
            iVarD2 = iVarD;
        }
        vw4.R(obj, j, iVarD2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cu1
    public void b(Object obj, long j) {
        d(obj, j).h();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cu1
    public List c(Object obj, long j) {
        bl1.i iVarD = d(obj, j);
        if (iVarD.v()) {
            return iVarD;
        }
        int size = iVarD.size();
        bl1.i iVarA = iVarD.a(size == 0 ? 10 : size * 2);
        vw4.R(obj, j, iVarA);
        return iVarA;
    }
}
