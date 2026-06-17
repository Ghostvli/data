package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.fongmi.android.tv.bean.Vod;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class pj3 extends RecyclerView.h {
    public final a d;
    public final List e = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void a(Vod vod);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends RecyclerView.g0 {
        public final o4 z;

        public b(o4 o4Var) {
            super(o4Var.getRoot());
            this.z = o4Var;
        }
    }

    public pj3(a aVar) {
        this.d = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(Vod vod, View view) {
        this.d.a(vod);
    }

    public void H(List list) {
        int size = this.e.size();
        this.e.addAll(list);
        r(size, list.size());
    }

    public void I() {
        this.e.clear();
        l();
    }

    public Vod J(int i) {
        return (Vod) this.e.get(i);
    }

    public boolean K() {
        return g() == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public void v(b bVar, int i) {
        final Vod vod = (Vod) this.e.get(i);
        bVar.z.b.setText(vod.getName());
        bVar.z.d.setText(vod.getSiteName());
        bVar.z.c.setText(vod.getRemarks());
        bVar.z.getRoot().setOnClickListener(new View.OnClickListener() { // from class: oj3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.L(vod, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public b x(ViewGroup viewGroup, int i) {
        return new b(o4.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }

    public void O(int i) {
        this.e.remove(i);
        t(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int g() {
        return this.e.size();
    }
}
