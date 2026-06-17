package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.fongmi.android.tv.bean.Config;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class fz extends RecyclerView.h {
    public final a d;
    public List e;
    public boolean f;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void a(Config config);

        void b(Config config);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends RecyclerView.g0 {
        public final b4 z;

        public b(b4 b4Var) {
            super(b4Var.getRoot());
            this.z = b4Var;
        }
    }

    public fz(a aVar) {
        this.d = aVar;
    }

    public fz I(int i) {
        List<Config> all = Config.getAll(i);
        this.e = all;
        if (!all.isEmpty() && !this.f) {
            this.e.remove(0);
        }
        return this;
    }

    public final /* synthetic */ void J(Config config, View view) {
        this.d.b(config);
    }

    public final /* synthetic */ void K(Config config, View view) {
        this.d.a(config);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public void v(b bVar, int i) {
        final Config config = (Config) this.e.get(i);
        bVar.z.c.setText(config.getDesc());
        bVar.z.c.setOnClickListener(new View.OnClickListener() { // from class: dz
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.J(config, view);
            }
        });
        bVar.z.b.setVisibility(this.f ? 8 : 0);
        bVar.z.b.setOnClickListener(new View.OnClickListener() { // from class: ez
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.K(config, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public b x(ViewGroup viewGroup, int i) {
        return new b(b4.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }

    public fz N(boolean z) {
        this.f = z;
        return this;
    }

    public int O(Config config) {
        int iIndexOf = this.e.indexOf(config);
        if (iIndexOf == -1) {
            return -1;
        }
        config.delete();
        this.e.remove(iIndexOf);
        t(iIndexOf);
        return g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int g() {
        return this.e.size();
    }
}
