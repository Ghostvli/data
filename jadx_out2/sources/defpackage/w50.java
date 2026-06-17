package defpackage;

import android.os.Bundle;
import defpackage.xi1;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class w50 {
    public static final x63 c = x63.d().f(new p81() { // from class: t50
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.p81
        public final Object apply(Object obj) {
            return Integer.valueOf(((p50) obj).r);
        }
    });
    public static final w50 d = new w50(xi1.u(), 0);
    public static final String e = fy4.N0(0);
    public static final String f = fy4.N0(1);
    public final xi1 a;
    public final long b;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public w50(List list, long j) {
        this.a = xi1.E(c, list);
        this.b = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static xi1 b(List list) {
        xi1.a aVarM = xi1.m();
        for (int i = 0; i < list.size(); i++) {
            if (((p50) list.get(i)).d == null) {
                aVarM.a((p50) list.get(i));
            }
        }
        return aVarM.k();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static w50 c(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(e);
        return new w50(parcelableArrayList == null ? xi1.u() : fm.d(new v50(), parcelableArrayList), bundle.getLong(f));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Bundle d() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(e, fm.h(b(this.a), new p81() { // from class: u50
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return ((p50) obj).c();
            }
        }));
        bundle.putLong(f, this.b);
        return bundle;
    }
}
