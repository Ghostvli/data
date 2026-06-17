package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.fongmi.android.tv.bean.EpgData;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class kt0 extends RecyclerView.h {
    public final a d;
    public final List e = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void I0(EpgData epgData);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends RecyclerView.g0 {
        public final e4 z;

        public b(e4 e4Var) {
            super(e4Var.getRoot());
            this.z = e4Var;
        }
    }

    public kt0(a aVar) {
        this.d = aVar;
    }

    public void H(List list) {
        this.e.clear();
        this.e.addAll(list);
        l();
    }

    public void I() {
        this.e.clear();
        l();
    }

    public final /* synthetic */ void J(EpgData epgData, View view) {
        if (epgData.isFuture()) {
            return;
        }
        this.d.I0(epgData);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public void v(b bVar, int i) {
        final EpgData epgData = (EpgData) this.e.get(i);
        bVar.z.b.setText(epgData.getTime());
        bVar.z.c.setText(epgData.getTitle());
        bVar.z.getRoot().setSelected(epgData.isSelected());
        bVar.z.getRoot().setOnClickListener(new View.OnClickListener() { // from class: jt0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.J(epgData, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public b x(ViewGroup viewGroup, int i) {
        return new b(e4.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }

    public void M(int i) {
        int i2 = 0;
        while (i2 < this.e.size()) {
            ((EpgData) this.e.get(i2)).setSelected(i2 == i);
            i2++;
        }
        p(0, g());
    }

    public void N(EpgData epgData) {
        M(this.e.indexOf(epgData));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int g() {
        return this.e.size();
    }
}
