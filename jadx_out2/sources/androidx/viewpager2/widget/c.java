package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import defpackage.b7;
import defpackage.e04;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends RecyclerView.v {
    public ViewPager2.i a;
    public final ViewPager2 b;
    public final RecyclerView c;
    public final LinearLayoutManager d;
    public int e;
    public int f;
    public a g;
    public int h;
    public int i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public int a;
        public float b;
        public int c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a() {
            this.a = -1;
            this.b = 0.0f;
            this.c = 0;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public c(ViewPager2 viewPager2) {
        this.b = viewPager2;
        RecyclerView recyclerView = viewPager2.o;
        this.c = recyclerView;
        this.d = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.g = new a();
        n();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.v
    public void a(RecyclerView recyclerView, int i) {
        if (!(this.e == 1 && this.f == 1) && i == 1) {
            p(false);
            return;
        }
        if (k() && i == 2) {
            if (this.k) {
                e(2);
                this.j = true;
                return;
            }
            return;
        }
        if (k() && i == 0) {
            q();
            boolean z = this.k;
            a aVar = this.g;
            if (!z) {
                int i2 = aVar.a;
                if (i2 != -1) {
                    c(i2, 0.0f, 0);
                }
            } else if (aVar.c == 0) {
                int i3 = this.h;
                int i4 = aVar.a;
                if (i3 != i4) {
                    d(i4);
                }
            }
            e(0);
            n();
        }
        if (this.e == 2 && i == 0 && this.l) {
            q();
            a aVar2 = this.g;
            if (aVar2.c == 0) {
                int i5 = this.i;
                int i6 = aVar2.a;
                if (i5 != i6) {
                    if (i6 == -1) {
                        i6 = 0;
                    }
                    d(i6);
                }
                e(0);
                n();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    @Override // androidx.recyclerview.widget.RecyclerView.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(RecyclerView recyclerView, int i, int i2) {
        int i3;
        this.k = true;
        q();
        if (this.j) {
            this.j = false;
            if (i2 > 0) {
                a aVar = this.g;
                i3 = aVar.c != 0 ? aVar.a + 1 : this.g.a;
                this.i = i3;
                if (this.h != i3) {
                    d(i3);
                }
            } else {
                if (i2 == 0) {
                    if ((i < 0) == this.b.d()) {
                    }
                }
                this.i = i3;
                if (this.h != i3) {
                }
            }
        } else if (this.e == 0) {
            int i4 = this.g.a;
            if (i4 == -1) {
                i4 = 0;
            }
            d(i4);
        }
        a aVar2 = this.g;
        int i5 = aVar2.a;
        if (i5 == -1) {
            i5 = 0;
        }
        c(i5, aVar2.b, aVar2.c);
        a aVar3 = this.g;
        int i6 = aVar3.a;
        int i7 = this.i;
        if ((i6 == i7 || i7 == -1) && aVar3.c == 0 && this.f != 1) {
            e(0);
            n();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void c(int i, float f, int i2) {
        ViewPager2.i iVar = this.a;
        if (iVar != null) {
            iVar.b(i, f, i2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void d(int i) {
        ViewPager2.i iVar = this.a;
        if (iVar != null) {
            iVar.c(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void e(int i) {
        if ((this.e == 3 && this.f == 0) || this.f == i) {
            return;
        }
        this.f = i;
        ViewPager2.i iVar = this.a;
        if (iVar != null) {
            iVar.a(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int f() {
        return this.d.x2();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public double g() {
        q();
        a aVar = this.g;
        return ((double) aVar.a) + ((double) aVar.b);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int h() {
        return this.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean i() {
        return this.m;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean j() {
        return this.f == 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean k() {
        int i = this.e;
        return i == 1 || i == 4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void l() {
        this.l = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void m(int i, boolean z) {
        this.e = z ? 2 : 3;
        this.m = false;
        boolean z2 = this.i != i;
        this.i = i;
        e(2);
        if (z2) {
            d(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void n() {
        this.e = 0;
        this.f = 0;
        this.g.a();
        this.h = -1;
        this.i = -1;
        this.j = false;
        this.k = false;
        this.m = false;
        this.l = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void o(ViewPager2.i iVar) {
        this.a = iVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void p(boolean z) {
        this.m = z;
        this.e = z ? 4 : 1;
        int i = this.i;
        if (i != -1) {
            this.h = i;
            this.i = -1;
        } else if (this.h == -1) {
            this.h = f();
        }
        e(1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void q() {
        int top;
        a aVar = this.g;
        int iX2 = this.d.x2();
        aVar.a = iX2;
        if (iX2 == -1) {
            aVar.a();
            return;
        }
        View viewD0 = this.d.d0(iX2);
        if (viewD0 == null) {
            aVar.a();
            return;
        }
        int iA0 = this.d.A0(viewD0);
        int iF0 = this.d.F0(viewD0);
        int iI0 = this.d.I0(viewD0);
        int iI02 = this.d.i0(viewD0);
        ViewGroup.LayoutParams layoutParams = viewD0.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            iA0 += marginLayoutParams.leftMargin;
            iF0 += marginLayoutParams.rightMargin;
            iI0 += marginLayoutParams.topMargin;
            iI02 += marginLayoutParams.bottomMargin;
        }
        int height = viewD0.getHeight() + iI0 + iI02;
        int width = viewD0.getWidth() + iA0 + iF0;
        if (this.d.K2() == 0) {
            top = (viewD0.getLeft() - iA0) - this.c.getPaddingLeft();
            if (this.b.d()) {
                top = -top;
            }
            height = width;
        } else {
            top = (viewD0.getTop() - iI0) - this.c.getPaddingTop();
        }
        int i = -top;
        aVar.c = i;
        if (i >= 0) {
            aVar.b = height == 0 ? 0.0f : i / height;
        } else if (new b7(this.d).d()) {
            e04.a("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        } else {
            e04.a(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(aVar.c)));
        }
    }
}
