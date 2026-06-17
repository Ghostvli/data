package defpackage;

import android.util.SparseArray;
import defpackage.t41;
import defpackage.wt4;
import java.util.ArrayList;
import java.util.List;
import okio.internal.Buffer;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class wi0 implements wt4.c {
    public final int a;
    public final List b;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public wi0(int i) {
        this(i, xi1.u());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // wt4.c
    public SparseArray a() {
        return new SparseArray();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0059  */
    @Override // wt4.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public wt4 b(int i, wt4.b bVar) {
        if (i != 2) {
            if (i == 3 || i == 4) {
                return new wa3(new cv2(bVar.b, bVar.a(), "video/mp2t"));
            }
            if (i == 21) {
                return new wa3(new ai1("video/mp2t"));
            }
            if (i == 27) {
                if (f(4)) {
                    return null;
                }
                return new wa3(new vb1(c(bVar), f(1), f(8), "video/mp2t"));
            }
            if (i == 36) {
                return new wa3(new wb1(c(bVar), "video/mp2t"));
            }
            if (i == 45) {
                return new wa3(new ev2("video/mp2t"));
            }
            if (i == 89) {
                return new wa3(new aq0(bVar.d, "video/mp2t"));
            }
            if (i == 172) {
                return new wa3(new o1(bVar.b, bVar.a(), "video/mp2t"));
            }
            if (i == 257) {
                return new wz3(new a93("application/vnd.dvb.ait", "video/mp2t"));
            }
            if (i != 138) {
                if (i == 139) {
                    return new wa3(new qp0(bVar.b, bVar.a(), 5408, "video/mp2t"));
                }
                switch (i) {
                    case 15:
                        if (!f(2)) {
                            break;
                        }
                        break;
                    case 16:
                        break;
                    case 17:
                        if (!f(2)) {
                            break;
                        }
                        break;
                    default:
                        switch (i) {
                            case 128:
                                break;
                            case Token.DEFAULT /* 129 */:
                                break;
                            case 130:
                                if (!f(64)) {
                                }
                                break;
                            default:
                                switch (i) {
                                    case Token.CONTINUE /* 134 */:
                                        if (!f(16)) {
                                            break;
                                        }
                                        break;
                                }
                                break;
                        }
                        break;
                }
                return null;
            }
            return new wa3(new qp0(bVar.b, bVar.a(), Buffer.SEGMENTING_THRESHOLD, "video/mp2t"));
        }
        return new wa3(new tb1(d(bVar), "video/mp2t"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final k04 c(wt4.b bVar) {
        return new k04(e(bVar), "video/mp2t");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final sx4 d(wt4.b bVar) {
        return new sx4(e(bVar), "video/mp2t");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final List e(wt4.b bVar) {
        String str;
        int i;
        if (f(32)) {
            return this.b;
        }
        r73 r73Var = new r73(bVar.e);
        List arrayList = this.b;
        while (r73Var.a() > 0) {
            int iQ = r73Var.Q();
            int iG = r73Var.g() + r73Var.Q();
            if (iQ == 134) {
                arrayList = new ArrayList();
                int iQ2 = r73Var.Q() & 31;
                for (int i2 = 0; i2 < iQ2; i2++) {
                    String strN = r73Var.N(3);
                    int iQ3 = r73Var.Q();
                    boolean z = (iQ3 & 128) != 0;
                    if (z) {
                        i = iQ3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    byte bQ = (byte) r73Var.Q();
                    r73Var.g0(1);
                    arrayList.add(new t41.b().A0(str).o0(strN).R(i).l0(z ? gv.h((bQ & 64) != 0) : null).Q());
                }
            }
            r73Var.f0(iG);
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean f(int i) {
        return (this.a & i) != 0;
    }

    public wi0(int i, List list) {
        this.a = i;
        this.b = list;
    }
}
