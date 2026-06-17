package defpackage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class m45 extends CoordinatorLayout.c {
    public n45 f;
    public int g;
    public int h;

    public m45() {
        this.g = 0;
        this.h = 0;
    }

    public int K() {
        n45 n45Var = this.f;
        if (n45Var != null) {
            return n45Var.b();
        }
        return 0;
    }

    public void L(CoordinatorLayout coordinatorLayout, View view, int i) {
        coordinatorLayout.I(view, i);
    }

    public boolean M(int i) {
        n45 n45Var = this.f;
        if (n45Var != null) {
            return n45Var.e(i);
        }
        this.g = i;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean r(CoordinatorLayout coordinatorLayout, View view, int i) {
        L(coordinatorLayout, view, i);
        if (this.f == null) {
            this.f = new n45(view);
        }
        this.f.c();
        this.f.a();
        int i2 = this.g;
        if (i2 != 0) {
            this.f.e(i2);
            this.g = 0;
        }
        int i3 = this.h;
        if (i3 == 0) {
            return true;
        }
        this.f.d(i3);
        this.h = 0;
        return true;
    }

    public m45(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = 0;
        this.h = 0;
    }
}
