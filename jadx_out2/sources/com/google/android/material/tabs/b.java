package com.google.android.material.tabs;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import defpackage.e04;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public final TabLayout a;
    public final ViewPager2 b;
    public final boolean c;
    public final boolean d;
    public final InterfaceC0067b e;
    public RecyclerView.h f;
    public boolean g;
    public c h;
    public TabLayout.d i;
    public RecyclerView.j j;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends RecyclerView.j {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void a() {
            b.this.b();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void b(int i, int i2, Object obj) {
            b.this.b();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void c(int i, int i2) {
            b.this.b();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void d(int i, int i2, int i3) {
            b.this.b();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void e(int i, int i2) {
            b.this.b();
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.tabs.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface InterfaceC0067b {
        void a(TabLayout.g gVar, int i);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c extends ViewPager2.i {
        public final WeakReference a;
        public int b;
        public int c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(TabLayout tabLayout) {
            this.a = new WeakReference(tabLayout);
            d();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void a(int i) {
            this.b = this.c;
            this.c = i;
            TabLayout tabLayout = (TabLayout) this.a.get();
            if (tabLayout != null) {
                tabLayout.T(this.c);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void b(int i, float f, int i2) {
            boolean z;
            TabLayout tabLayout = (TabLayout) this.a.get();
            if (tabLayout != null) {
                int i3 = this.c;
                boolean z2 = true;
                if (i3 != 2 || this.b == 1) {
                    z = true;
                } else {
                    z = true;
                    z2 = false;
                }
                if (i3 == 2 && this.b == 0) {
                    z = false;
                }
                tabLayout.N(i, f, z2, z, false);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void c(int i) {
            TabLayout tabLayout = (TabLayout) this.a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i || i >= tabLayout.getTabCount()) {
                return;
            }
            int i2 = this.c;
            tabLayout.J(tabLayout.z(i), i2 == 0 || (i2 == 2 && this.b == 0));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void d() {
            this.c = 0;
            this.b = 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d implements TabLayout.d {
        public final ViewPager2 a;
        public final boolean b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(ViewPager2 viewPager2, boolean z) {
            this.a = viewPager2;
            this.b = z;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(TabLayout.g gVar) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(TabLayout.g gVar) {
            this.a.j(gVar.g(), this.b);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(TabLayout.g gVar) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public b(TabLayout tabLayout, ViewPager2 viewPager2, boolean z, boolean z2, InterfaceC0067b interfaceC0067b) {
        this.a = tabLayout;
        this.b = viewPager2;
        this.c = z;
        this.d = z2;
        this.e = interfaceC0067b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void a() {
        if (this.g) {
            e04.a("TabLayoutMediator is already attached");
            return;
        }
        RecyclerView.h adapter = this.b.getAdapter();
        this.f = adapter;
        if (adapter == null) {
            e04.a("TabLayoutMediator attached before ViewPager2 has an adapter");
            return;
        }
        this.g = true;
        c cVar = new c(this.a);
        this.h = cVar;
        this.b.g(cVar);
        d dVar = new d(this.b, this.d);
        this.i = dVar;
        this.a.h(dVar);
        if (this.c) {
            a aVar = new a();
            this.j = aVar;
            this.f.D(aVar);
        }
        b();
        this.a.L(this.b.getCurrentItem(), 0.0f, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b() {
        this.a.F();
        RecyclerView.h hVar = this.f;
        if (hVar != null) {
            int iG = hVar.g();
            for (int i = 0; i < iG; i++) {
                TabLayout.g gVarC = this.a.C();
                this.e.a(gVarC, i);
                this.a.j(gVarC, false);
            }
            if (iG > 0) {
                int iMin = Math.min(this.b.getCurrentItem(), this.a.getTabCount() - 1);
                if (iMin != this.a.getSelectedTabPosition()) {
                    TabLayout tabLayout = this.a;
                    tabLayout.I(tabLayout.z(iMin));
                }
            }
        }
    }

    public b(TabLayout tabLayout, ViewPager2 viewPager2, boolean z, InterfaceC0067b interfaceC0067b) {
        this(tabLayout, viewPager2, z, true, interfaceC0067b);
    }

    public b(TabLayout tabLayout, ViewPager2 viewPager2, InterfaceC0067b interfaceC0067b) {
        this(tabLayout, viewPager2, true, interfaceC0067b);
    }
}
