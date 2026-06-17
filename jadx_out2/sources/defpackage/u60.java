package defpackage;

import android.os.Bundle;
import android.text.Spannable;
import android.text.Spanned;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class u60 {
    public static final String a = fy4.N0(0);
    public static final String b = fy4.N0(1);
    public static final String c = fy4.N0(2);
    public static final String d = fy4.N0(3);
    public static final String e = fy4.N0(4);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ArrayList a(Spanned spanned) {
        ArrayList arrayList = new ArrayList();
        for (aw3 aw3Var : (aw3[]) spanned.getSpans(0, spanned.length(), aw3.class)) {
            arrayList.add(b(spanned, aw3Var, 1, aw3Var.b()));
        }
        for (km4 km4Var : (km4[]) spanned.getSpans(0, spanned.length(), km4.class)) {
            arrayList.add(b(spanned, km4Var, 2, km4Var.b()));
        }
        for (sf1 sf1Var : (sf1[]) spanned.getSpans(0, spanned.length(), sf1.class)) {
            arrayList.add(b(spanned, sf1Var, 3, null));
        }
        for (y75 y75Var : (y75[]) spanned.getSpans(0, spanned.length(), y75.class)) {
            arrayList.add(b(spanned, y75Var, 4, y75Var.b()));
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Bundle b(Spanned spanned, Object obj, int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putInt(a, spanned.getSpanStart(obj));
        bundle2.putInt(b, spanned.getSpanEnd(obj));
        bundle2.putInt(c, spanned.getSpanFlags(obj));
        bundle2.putInt(d, i);
        if (bundle != null) {
            bundle2.putBundle(e, bundle);
        }
        return bundle2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void c(Bundle bundle, Spannable spannable) {
        int i = bundle.getInt(a);
        int i2 = bundle.getInt(b);
        int i3 = bundle.getInt(c);
        int i4 = bundle.getInt(d, -1);
        Bundle bundle2 = bundle.getBundle(e);
        if (i4 == 1) {
            spannable.setSpan(aw3.a((Bundle) gg3.q(bundle2)), i, i2, i3);
            return;
        }
        if (i4 == 2) {
            spannable.setSpan(km4.a((Bundle) gg3.q(bundle2)), i, i2, i3);
        } else if (i4 == 3) {
            spannable.setSpan(new sf1(), i, i2, i3);
        } else {
            if (i4 != 4) {
                return;
            }
            spannable.setSpan(y75.a((Bundle) gg3.q(bundle2)), i, i2, i3);
        }
    }
}
