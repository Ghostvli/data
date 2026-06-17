package defpackage;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class rf3 {
    public static final int a = sl3.b;
    public static final int b = sl3.a;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void a(View view) {
        view.getClass();
        Iterator it = b45.a(view).iterator();
        while (it.hasNext()) {
            c((View) it.next()).a();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void b(ViewGroup viewGroup) {
        viewGroup.getClass();
        Iterator it = y35.a(viewGroup).iterator();
        while (it.hasNext()) {
            c((View) it.next()).a();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final sf3 c(View view) {
        int i = a;
        sf3 sf3Var = (sf3) view.getTag(i);
        if (sf3Var != null) {
            return sf3Var;
        }
        sf3 sf3Var2 = new sf3();
        view.setTag(i, sf3Var2);
        return sf3Var2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void d(View view, boolean z) {
        view.getClass();
        view.setTag(b, Boolean.valueOf(z));
    }
}
