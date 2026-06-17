package defpackage;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ki {
    public final Context a;
    public x64 b;
    public x64 c;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ki(Context context) {
        this.a = context;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof ej4)) {
            return menuItem;
        }
        ej4 ej4Var = (ej4) menuItem;
        if (this.b == null) {
            this.b = new x64();
        }
        MenuItem menuItem2 = (MenuItem) this.b.get(ej4Var);
        if (menuItem2 != null) {
            return menuItem2;
        }
        as2 as2Var = new as2(this.a, ej4Var);
        this.b.put(ej4Var, as2Var);
        return as2Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final SubMenu d(SubMenu subMenu) {
        return subMenu;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void e() {
        x64 x64Var = this.b;
        if (x64Var != null) {
            x64Var.clear();
        }
        x64 x64Var2 = this.c;
        if (x64Var2 != null) {
            x64Var2.clear();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f(int i) {
        if (this.b == null) {
            return;
        }
        int i2 = 0;
        while (i2 < this.b.size()) {
            if (((ej4) this.b.f(i2)).getGroupId() == i) {
                this.b.h(i2);
                i2--;
            }
            i2++;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g(int i) {
        if (this.b == null) {
            return;
        }
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            if (((ej4) this.b.f(i2)).getItemId() == i) {
                this.b.h(i2);
                return;
            }
        }
    }
}
