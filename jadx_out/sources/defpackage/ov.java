package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.fongmi.android.tv.bean.Collect;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ov extends rh {
    public final a e;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void h(int i, Collect collect);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends RecyclerView.g0 {
        public final a4 z;

        public b(a4 a4Var) {
            super(a4Var.getRoot());
            this.z = a4Var;
        }
    }

    public ov(a aVar) {
        this.e = aVar;
    }

    public void Z(List list) {
        if (g() == 0) {
            return;
        }
        ((Collect) M(0)).getList().addAll(list);
    }

    public Collect a0() {
        return (Collect) N().get(b0());
    }

    public int b0() {
        for (int i = 0; i < g(); i++) {
            if (((Collect) M(i)).isActivated()) {
                return i;
            }
        }
        return 0;
    }

    public final /* synthetic */ void c0(int i, Collect collect, View view) {
        this.e.h(i, collect);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public void v(b bVar, final int i) {
        final Collect collect = (Collect) M(i);
        bVar.z.b.setSelected(collect.isActivated());
        bVar.z.b.setActivated(collect.isActivated());
        bVar.z.b.setText(collect.getSite().getName());
        bVar.z.b.setOnClickListener(new View.OnClickListener() { // from class: nv
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.c0(i, collect, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public b x(ViewGroup viewGroup, int i) {
        return new b(a4.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }

    public void f0(int i) {
        int i2 = 0;
        while (i2 < g()) {
            ((Collect) M(i2)).setActivated(i2 == i);
            i2++;
        }
        p(0, g());
    }
}
