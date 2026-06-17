package defpackage;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class gb4 extends RecyclerView.p {
    public final int a;
    public final int b;

    public gb4(int i, int i2) {
        this.b = i;
        this.a = vr3.a(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void e(Rect rect, View view, RecyclerView recyclerView, RecyclerView.c0 c0Var) {
        int i;
        int iL0 = recyclerView.l0(view);
        if (iL0 >= 0 && this.b == -1) {
            rect.left = iL0 == 0 ? 0 : this.a / 2;
            rect.right = iL0 != recyclerView.getAdapter().g() + (-1) ? this.a / 2 : 0;
            return;
        }
        if (iL0 < 0 || (i = this.b) <= 0) {
            rect.left = 0;
            rect.right = 0;
            rect.top = 0;
            rect.bottom = 0;
            return;
        }
        int i2 = iL0 % i;
        int i3 = this.a;
        rect.left = (i2 * i3) / i;
        rect.right = i3 - (((i2 + 1) * i3) / i);
        if (iL0 >= i) {
            rect.top = i3;
        }
    }

    public gb4(int i) {
        this(-1, i);
    }
}
