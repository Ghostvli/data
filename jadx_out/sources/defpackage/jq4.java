package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.fongmi.android.tv.bean.Track;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class jq4 extends RecyclerView.h {
    public final a d;
    public final List e = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void m(Track track);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends RecyclerView.g0 implements View.OnClickListener {
        public final u4 z;

        public b(u4 u4Var) {
            super(u4Var.getRoot());
            this.z = u4Var;
            this.f.setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            jq4.this.d.m(((Track) jq4.this.e.get(n())).toggle());
        }
    }

    public jq4(a aVar) {
        this.d = aVar;
    }

    public jq4 I(List list) {
        this.e.addAll(list);
        l();
        return this;
    }

    public int J() {
        for (int i = 0; i < this.e.size(); i++) {
            if (((Track) this.e.get(i)).isSelected()) {
                return i;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public void v(b bVar, int i) {
        Track track = (Track) this.e.get(i);
        bVar.z.b.setText(track.getName());
        bVar.z.b.setActivated(track.isSelected());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public b x(ViewGroup viewGroup, int i) {
        return new b(u4.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int g() {
        return this.e.size();
    }
}
