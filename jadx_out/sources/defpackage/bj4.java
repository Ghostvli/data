package defpackage;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import defpackage.v2;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class bj4 extends ActionMode {
    public final Context a;
    public final v2 b;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a implements v2.a {
        public final ActionMode.Callback a;
        public final Context b;
        public final ArrayList c = new ArrayList();
        public final x64 d = new x64();

        public a(Context context, ActionMode.Callback callback) {
            this.b = context;
            this.a = callback;
        }

        @Override // v2.a
        public boolean a(v2 v2Var, MenuItem menuItem) {
            return this.a.onActionItemClicked(e(v2Var), new as2(this.b, (ej4) menuItem));
        }

        @Override // v2.a
        public void b(v2 v2Var) {
            this.a.onDestroyActionMode(e(v2Var));
        }

        @Override // v2.a
        public boolean c(v2 v2Var, Menu menu) {
            return this.a.onCreateActionMode(e(v2Var), f(menu));
        }

        @Override // v2.a
        public boolean d(v2 v2Var, Menu menu) {
            return this.a.onPrepareActionMode(e(v2Var), f(menu));
        }

        public ActionMode e(v2 v2Var) {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                bj4 bj4Var = (bj4) this.c.get(i);
                if (bj4Var != null && bj4Var.b == v2Var) {
                    return bj4Var;
                }
            }
            bj4 bj4Var2 = new bj4(this.b, v2Var);
            this.c.add(bj4Var2);
            return bj4Var2;
        }

        public final Menu f(Menu menu) {
            Menu menu2 = (Menu) this.d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            es2 es2Var = new es2(this.b, (cj4) menu);
            this.d.put(menu, es2Var);
            return es2Var;
        }
    }

    public bj4(Context context, v2 v2Var) {
        this.a = context;
        this.b = v2Var;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.b.c();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.b.d();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new es2(this.a, (cj4) this.b.e());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.b.g();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.b.h();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.b.i();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.b.j();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.b.k();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.b.l();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.b.m(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.b.p(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.b.r(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.b.s(z);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.b.n(i);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.b.q(i);
    }
}
