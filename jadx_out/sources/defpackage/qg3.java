package defpackage;

import android.graphics.Rect;
import android.util.Log;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class qg3 {
    public static final String a = "qg3";

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Comparator {
        public final /* synthetic */ c94 f;

        public a(c94 c94Var) {
            this.f = c94Var;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c94 c94Var, c94 c94Var2) {
            return Float.compare(qg3.this.c(c94Var2, this.f), qg3.this.c(c94Var, this.f));
        }
    }

    public List a(List list, c94 c94Var) {
        if (c94Var == null) {
            return list;
        }
        Collections.sort(list, new a(c94Var));
        return list;
    }

    public c94 b(List list, c94 c94Var) {
        List listA = a(list, c94Var);
        String str = a;
        Log.i(str, "Viewfinder size: " + c94Var);
        Log.i(str, "Preview in order of preference: " + listA);
        return (c94) listA.get(0);
    }

    public abstract float c(c94 c94Var, c94 c94Var2);

    public abstract Rect d(c94 c94Var, c94 c94Var2);
}
