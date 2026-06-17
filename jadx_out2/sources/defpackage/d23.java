package defpackage;

import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.i;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class d23 {
    public final e a;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public final List b = new ArrayList();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public d23(e eVar) {
        this.a = eVar;
        f();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int a() {
        return this.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public MenuItem b(int i) {
        return (MenuItem) this.b.get(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int c() {
        return this.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int d() {
        return this.e;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean e(MenuItem menuItem, i iVar, int i) {
        return this.a.P(menuItem, iVar, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f() {
        this.b.clear();
        this.c = 0;
        this.d = 0;
        this.e = 0;
        for (int i = 0; i < this.a.size(); i++) {
            MenuItem item = this.a.getItem(i);
            boolean zHasSubMenu = item.hasSubMenu();
            List list = this.b;
            if (zHasSubMenu) {
                if (!list.isEmpty()) {
                    if (!(this.b.get(r3.size() - 1) instanceof um0) && item.isVisible()) {
                        this.b.add(new um0());
                    }
                }
                this.b.add(item);
                SubMenu subMenu = item.getSubMenu();
                for (int i2 = 0; i2 < subMenu.size(); i2++) {
                    MenuItem item2 = subMenu.getItem(i2);
                    if (!item.isVisible()) {
                        item2.setVisible(false);
                    }
                    this.b.add(item2);
                    this.c++;
                    if (item2.isVisible()) {
                        this.d++;
                    }
                }
                this.b.add(new um0());
            } else {
                list.add(item);
                this.c++;
                if (item.isVisible()) {
                    this.d++;
                    this.e++;
                }
            }
        }
        if (this.b.isEmpty()) {
            return;
        }
        if (this.b.get(r0.size() - 1) instanceof um0) {
            this.b.remove(r7.size() - 1);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int g() {
        return this.b.size();
    }
}
