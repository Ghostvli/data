package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.e04;
import defpackage.ib3;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class e {
    public final b a;
    public View e;
    public int d = 0;
    public final a b = new a();
    public final List c = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public long a = 0;
        public a b;

        public void a(int i) {
            if (i < 64) {
                this.a &= ~(1 << i);
                return;
            }
            a aVar = this.b;
            if (aVar != null) {
                aVar.a(i - 64);
            }
        }

        public int b(int i) {
            a aVar = this.b;
            if (aVar == null) {
                long j = this.a;
                return i >= 64 ? Long.bitCount(j) : Long.bitCount(((1 << i) - 1) & j);
            }
            if (i < 64) {
                return Long.bitCount(((1 << i) - 1) & this.a);
            }
            return aVar.b(i - 64) + Long.bitCount(this.a);
        }

        public final void c() {
            if (this.b == null) {
                this.b = new a();
            }
        }

        public boolean d(int i) {
            if (i < 64) {
                return ((1 << i) & this.a) != 0;
            }
            c();
            return this.b.d(i - 64);
        }

        public void e(int i, boolean z) {
            if (i >= 64) {
                c();
                this.b.e(i - 64, z);
                return;
            }
            long j = this.a;
            boolean z2 = (Long.MIN_VALUE & j) != 0;
            long j2 = (1 << i) - 1;
            this.a = ((j & (~j2)) << 1) | (j & j2);
            if (z) {
                h(i);
            } else {
                a(i);
            }
            if (z2 || this.b != null) {
                c();
                this.b.e(0, z2);
            }
        }

        public boolean f(int i) {
            if (i >= 64) {
                c();
                return this.b.f(i - 64);
            }
            long j = 1 << i;
            long j2 = this.a;
            boolean z = (j2 & j) != 0;
            long j3 = j2 & (~j);
            this.a = j3;
            long j4 = j - 1;
            this.a = (j3 & j4) | Long.rotateRight((~j4) & j3, 1);
            a aVar = this.b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.b.f(0);
            }
            return z;
        }

        public void g() {
            this.a = 0L;
            a aVar = this.b;
            if (aVar != null) {
                aVar.g();
            }
        }

        public void h(int i) {
            if (i < 64) {
                this.a |= 1 << i;
            } else {
                c();
                this.b.h(i - 64);
            }
        }

        public String toString() {
            if (this.b == null) {
                return Long.toBinaryString(this.a);
            }
            return this.b.toString() + "xx" + Long.toBinaryString(this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        View a(int i);

        void b(View view);

        int c();

        void d();

        int e(View view);

        RecyclerView.g0 f(View view);

        void g(int i);

        void h(View view);

        void i(View view, int i);

        void j(int i);

        void k(View view, int i, ViewGroup.LayoutParams layoutParams);
    }

    public e(b bVar) {
        this.a = bVar;
    }

    public void a(View view, int i, boolean z) {
        int iC = i < 0 ? this.a.c() : h(i);
        this.b.e(iC, z);
        if (z) {
            l(view);
        }
        this.a.i(view, iC);
    }

    public void b(View view, boolean z) {
        a(view, -1, z);
    }

    public void c(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int iC = i < 0 ? this.a.c() : h(i);
        this.b.e(iC, z);
        if (z) {
            l(view);
        }
        this.a.k(view, iC, layoutParams);
    }

    public void d(int i) {
        int iH = h(i);
        this.b.f(iH);
        this.a.g(iH);
    }

    public View e(int i) {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) this.c.get(i2);
            RecyclerView.g0 g0VarF = this.a.f(view);
            if (g0VarF.n() == i && !g0VarF.u() && !g0VarF.w()) {
                return view;
            }
        }
        return null;
    }

    public View f(int i) {
        return this.a.a(h(i));
    }

    public int g() {
        return this.a.c() - this.c.size();
    }

    public final int h(int i) {
        if (i < 0) {
            return -1;
        }
        int iC = this.a.c();
        int i2 = i;
        while (i2 < iC) {
            int iB = i - (i2 - this.b.b(i2));
            if (iB == 0) {
                while (this.b.d(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += iB;
        }
        return -1;
    }

    public View i(int i) {
        return this.a.a(i);
    }

    public int j() {
        return this.a.c();
    }

    public void k(View view) {
        int iE = this.a.e(view);
        if (iE < 0) {
            defpackage.c.a("view is not a child, cannot hide ", view);
        } else {
            this.b.h(iE);
            l(view);
        }
    }

    public final void l(View view) {
        this.c.add(view);
        this.a.b(view);
    }

    public int m(View view) {
        int iE = this.a.e(view);
        if (iE == -1 || this.b.d(iE)) {
            return -1;
        }
        return iE - this.b.b(iE);
    }

    public boolean n(View view) {
        return this.c.contains(view);
    }

    public void o() {
        this.b.g();
        int size = this.c.size();
        while (true) {
            size--;
            b bVar = this.a;
            if (size < 0) {
                bVar.d();
                return;
            } else {
                bVar.h((View) this.c.get(size));
                this.c.remove(size);
            }
        }
    }

    public void p(View view) {
        int i = this.d;
        if (i == 1) {
            e04.a("Cannot call removeView(At) within removeView(At)");
            return;
        }
        if (i == 2) {
            e04.a("Cannot call removeView(At) within removeViewIfHidden");
            return;
        }
        try {
            this.d = 1;
            this.e = view;
            int iE = this.a.e(view);
            if (iE < 0) {
                this.d = 0;
                this.e = null;
                return;
            }
            if (this.b.f(iE)) {
                t(view);
            }
            this.a.j(iE);
            this.d = 0;
            this.e = null;
        } catch (Throwable th) {
            this.d = 0;
            this.e = null;
            throw th;
        }
    }

    public void q(int i) {
        int i2 = this.d;
        if (i2 == 1) {
            e04.a("Cannot call removeView(At) within removeView(At)");
            return;
        }
        if (i2 == 2) {
            e04.a("Cannot call removeView(At) within removeViewIfHidden");
            return;
        }
        try {
            int iH = h(i);
            View viewA = this.a.a(iH);
            if (viewA == null) {
                this.d = 0;
                this.e = null;
                return;
            }
            this.d = 1;
            this.e = viewA;
            if (this.b.f(iH)) {
                t(viewA);
            }
            this.a.j(iH);
            this.d = 0;
            this.e = null;
        } catch (Throwable th) {
            this.d = 0;
            this.e = null;
            throw th;
        }
    }

    public boolean r(View view) {
        int i = this.d;
        if (i == 1) {
            if (this.e == view) {
                return false;
            }
            e04.a("Cannot call removeViewIfHidden within removeView(At) for a different view");
            return false;
        }
        if (i == 2) {
            e04.a("Cannot call removeViewIfHidden within removeViewIfHidden");
            return false;
        }
        try {
            this.d = 2;
            int iE = this.a.e(view);
            if (iE == -1) {
                t(view);
                return true;
            }
            if (!this.b.d(iE)) {
                return false;
            }
            this.b.f(iE);
            t(view);
            this.a.j(iE);
            return true;
        } finally {
            this.d = 0;
        }
    }

    public void s(View view) {
        int iE = this.a.e(view);
        if (iE < 0) {
            defpackage.c.a("view is not a child, cannot hide ", view);
        } else if (!this.b.d(iE)) {
            ib3.a("trying to unhide a view that was not hidden", view);
        } else {
            this.b.a(iE);
            t(view);
        }
    }

    public final boolean t(View view) {
        if (!this.c.remove(view)) {
            return false;
        }
        this.a.h(view);
        return true;
    }

    public String toString() {
        return this.b.toString() + ", hidden list:" + this.c.size();
    }
}
