package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.fongmi.android.tv.bean.Site;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class x74 extends RecyclerView.h {
    public final a d;
    public final List e = new ArrayList();
    public boolean f;
    public boolean g;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void a(Site site);

        void b(int i, Site site);

        boolean c(Site site);

        boolean d(Site site);

        void e(int i, Site site);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends RecyclerView.g0 {
        public final t4 z;

        public b(t4 t4Var) {
            super(t4Var.getRoot());
            this.z = t4Var;
        }
    }

    public x74(a aVar) {
        this.d = aVar;
        L();
    }

    private void L() {
        for (Site site : b75.I().Y()) {
            if (!site.isHide()) {
                this.e.add(site);
            }
        }
    }

    public x74 M(boolean z) {
        this.g = z;
        return this;
    }

    public final int N(Site site) {
        return site.isChangeable() ? fl3.s : fl3.r;
    }

    public List O() {
        return this.e;
    }

    public final int P(Site site) {
        return site.isSearchable() ? fl3.t : fl3.r;
    }

    public final /* synthetic */ void Q(Site site, View view) {
        this.d.a(site);
    }

    public final /* synthetic */ void R(int i, Site site, View view) {
        this.d.e(i, site);
    }

    public final /* synthetic */ void S(int i, Site site, View view) {
        this.d.b(i, site);
    }

    public final /* synthetic */ boolean T(Site site, View view) {
        return this.d.d(site);
    }

    public final /* synthetic */ boolean U(Site site, View view) {
        return this.d.c(site);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public void v(b bVar, final int i) {
        final Site site = (Site) this.e.get(i);
        boolean z = !this.f || this.g;
        bVar.z.d.setText(site.getName());
        bVar.z.d.setEnabled(z);
        bVar.z.d.setFocusable(z);
        bVar.z.d.setSelected(z && site.isActivated());
        bVar.z.d.setActivated(z && site.isActivated());
        bVar.z.c.setImageResource(P(site));
        bVar.z.b.setImageResource(N(site));
        bVar.z.c.setVisibility(this.f ? 0 : 8);
        bVar.z.b.setVisibility(this.g ? 0 : 8);
        bVar.z.d.setOnClickListener(new View.OnClickListener() { // from class: s74
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.Q(site, view);
            }
        });
        bVar.z.c.setOnClickListener(new View.OnClickListener() { // from class: t74
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.R(i, site, view);
            }
        });
        bVar.z.b.setOnClickListener(new View.OnClickListener() { // from class: u74
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.S(i, site, view);
            }
        });
        bVar.z.c.setOnLongClickListener(new View.OnLongClickListener() { // from class: v74
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f.T(site, view);
            }
        });
        bVar.z.b.setOnLongClickListener(new View.OnLongClickListener() { // from class: w74
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f.U(site, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public b x(ViewGroup viewGroup, int i) {
        return new b(t4.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }

    public x74 X(boolean z) {
        this.f = z;
        return this;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int g() {
        return this.e.size();
    }
}
