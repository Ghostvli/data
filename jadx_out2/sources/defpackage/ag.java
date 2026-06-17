package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import defpackage.zf;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ag {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void a(yf yfVar, View view) {
        b(yfVar, view, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void b(yf yfVar, View view, FrameLayout frameLayout) {
        f(yfVar, view, frameLayout);
        if (yfVar.k() != null) {
            yfVar.k().setForeground(yfVar);
        } else {
            view.getOverlay().add(yfVar);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static SparseArray c(Context context, o73 o73Var) {
        SparseArray sparseArray = new SparseArray(o73Var.size());
        for (int i = 0; i < o73Var.size(); i++) {
            int iKeyAt = o73Var.keyAt(i);
            zf.a aVar = (zf.a) o73Var.valueAt(i);
            sparseArray.put(iKeyAt, aVar != null ? yf.f(context, aVar) : null);
        }
        return sparseArray;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static o73 d(SparseArray sparseArray) {
        o73 o73Var = new o73();
        for (int i = 0; i < sparseArray.size(); i++) {
            int iKeyAt = sparseArray.keyAt(i);
            yf yfVar = (yf) sparseArray.valueAt(i);
            o73Var.put(iKeyAt, yfVar != null ? yfVar.u() : null);
        }
        return o73Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void e(yf yfVar, View view) {
        if (yfVar == null) {
            return;
        }
        if (yfVar.k() != null) {
            yfVar.k().setForeground(null);
        } else {
            view.getOverlay().remove(yfVar);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void f(yf yfVar, View view, FrameLayout frameLayout) {
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        yfVar.setBounds(rect);
        yfVar.Q(view, frameLayout);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void g(Rect rect, float f, float f2, float f3, float f4) {
        rect.set((int) (f - f3), (int) (f2 - f4), (int) (f + f3), (int) (f2 + f4));
    }
}
