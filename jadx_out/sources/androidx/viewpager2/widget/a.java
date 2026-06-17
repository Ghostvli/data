package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends ViewPager2.i {
    public final List a;

    public a(int i) {
        this.a = new ArrayList(i);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void a(int i) {
        try {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((ViewPager2.i) it.next()).a(i);
            }
        } catch (ConcurrentModificationException e) {
            f(e);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void b(int i, float f, int i2) {
        try {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((ViewPager2.i) it.next()).b(i, f, i2);
            }
        } catch (ConcurrentModificationException e) {
            f(e);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void c(int i) {
        try {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((ViewPager2.i) it.next()).c(i);
            }
        } catch (ConcurrentModificationException e) {
            f(e);
        }
    }

    public void d(ViewPager2.i iVar) {
        this.a.add(iVar);
    }

    public void e(ViewPager2.i iVar) {
        this.a.remove(iVar);
    }

    public final void f(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }
}
