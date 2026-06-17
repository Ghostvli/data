package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.widget.Toolbar;
import defpackage.j8;
import java.util.ArrayList;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class sp4 extends q2 {
    public final ob0 a;
    public final Window.Callback b;
    public final j8.f c;
    public boolean d;
    public boolean e;
    public boolean f;
    public ArrayList g = new ArrayList();
    public final Runnable h = new a();
    public final Toolbar.h i;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            sp4.this.w();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements Toolbar.h {
        public b() {
        }

        @Override // androidx.appcompat.widget.Toolbar.h
        public boolean onMenuItemClick(MenuItem menuItem) {
            return sp4.this.b.onMenuItemSelected(0, menuItem);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class c implements i.a {
        public boolean f;

        public c() {
        }

        @Override // androidx.appcompat.view.menu.i.a
        public void b(androidx.appcompat.view.menu.e eVar, boolean z) {
            if (this.f) {
                return;
            }
            this.f = true;
            sp4.this.a.h();
            sp4.this.b.onPanelClosed(Token.ASSIGN_ADD, eVar);
            this.f = false;
        }

        @Override // androidx.appcompat.view.menu.i.a
        public boolean c(androidx.appcompat.view.menu.e eVar) {
            sp4.this.b.onMenuOpened(Token.ASSIGN_ADD, eVar);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class d implements e.a {
        public d() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(androidx.appcompat.view.menu.e eVar) {
            boolean zB = sp4.this.a.b();
            sp4 sp4Var = sp4.this;
            if (zB) {
                sp4Var.b.onPanelClosed(Token.ASSIGN_ADD, eVar);
            } else if (sp4Var.b.onPreparePanel(0, null, eVar)) {
                sp4.this.b.onMenuOpened(Token.ASSIGN_ADD, eVar);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class e implements j8.f {
        public e() {
        }

        @Override // j8.f
        public boolean a(int i) {
            if (i != 0) {
                return false;
            }
            sp4 sp4Var = sp4.this;
            if (sp4Var.d) {
                return false;
            }
            sp4Var.a.c();
            sp4.this.d = true;
            return false;
        }

        @Override // j8.f
        public View onCreatePanelView(int i) {
            if (i == 0) {
                return new View(sp4.this.a.getContext());
            }
            return null;
        }
    }

    public sp4(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        b bVar = new b();
        this.i = bVar;
        hg3.g(toolbar);
        androidx.appcompat.widget.c cVar = new androidx.appcompat.widget.c(toolbar, false);
        this.a = cVar;
        this.b = (Window.Callback) hg3.g(callback);
        cVar.setWindowCallback(callback);
        toolbar.setOnMenuItemClickListener(bVar);
        cVar.setWindowTitle(charSequence);
        this.c = new e();
    }

    @Override // defpackage.q2
    public boolean f() {
        return this.a.f();
    }

    @Override // defpackage.q2
    public boolean g() {
        if (!this.a.j()) {
            return false;
        }
        this.a.collapseActionView();
        return true;
    }

    @Override // defpackage.q2
    public void h(boolean z) {
        if (z == this.f) {
            return;
        }
        this.f = z;
        if (this.g.size() <= 0) {
            return;
        }
        w82.a(this.g.get(0));
        throw null;
    }

    @Override // defpackage.q2
    public int i() {
        return this.a.t();
    }

    @Override // defpackage.q2
    public Context j() {
        return this.a.getContext();
    }

    @Override // defpackage.q2
    public boolean k() {
        this.a.r().removeCallbacks(this.h);
        l35.Y(this.a.r(), this.h);
        return true;
    }

    @Override // defpackage.q2
    public void l(Configuration configuration) {
        super.l(configuration);
    }

    @Override // defpackage.q2
    public void m() {
        this.a.r().removeCallbacks(this.h);
    }

    @Override // defpackage.q2
    public boolean n(int i, KeyEvent keyEvent) {
        Menu menuV = v();
        if (menuV == null) {
            return false;
        }
        menuV.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuV.performShortcut(i, keyEvent, 0);
    }

    @Override // defpackage.q2
    public boolean o(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            p();
        }
        return true;
    }

    @Override // defpackage.q2
    public boolean p() {
        return this.a.g();
    }

    @Override // defpackage.q2
    public void q(boolean z) {
    }

    @Override // defpackage.q2
    public void r(boolean z) {
        x(z ? 4 : 0, 4);
    }

    @Override // defpackage.q2
    public void s(boolean z) {
    }

    @Override // defpackage.q2
    public void t(CharSequence charSequence) {
        this.a.setWindowTitle(charSequence);
    }

    public final Menu v() {
        if (!this.e) {
            this.a.p(new c(), new d());
            this.e = true;
        }
        return this.a.l();
    }

    public void w() {
        Menu menuV = v();
        androidx.appcompat.view.menu.e eVar = menuV instanceof androidx.appcompat.view.menu.e ? (androidx.appcompat.view.menu.e) menuV : null;
        if (eVar != null) {
            eVar.i0();
        }
        try {
            menuV.clear();
            if (!this.b.onCreatePanelMenu(0, menuV) || !this.b.onPreparePanel(0, null, menuV)) {
                menuV.clear();
            }
            if (eVar != null) {
                eVar.h0();
            }
        } catch (Throwable th) {
            if (eVar != null) {
                eVar.h0();
            }
            throw th;
        }
    }

    public void x(int i, int i2) {
        this.a.k((i & i2) | ((~i2) & this.a.t()));
    }
}
