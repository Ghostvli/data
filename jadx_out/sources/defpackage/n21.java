package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.fongmi.android.tv.bean.Episode;
import com.fongmi.android.tv.bean.Flag;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class n21 extends RecyclerView.h {
    public final a d;
    public final List e = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void O0(Flag flag);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends RecyclerView.g0 {
        public final i4 z;

        public b(i4 i4Var) {
            super(i4Var.getRoot());
            this.z = i4Var;
        }
    }

    public n21(a aVar) {
        this.d = aVar;
    }

    public void H(Flag flag) {
        this.e.add(flag);
        n(this.e.size() - 1);
    }

    public void I(List list) {
        this.e.clear();
        this.e.addAll(list);
        l();
    }

    public Flag J(int i) {
        return (Flag) this.e.get(i);
    }

    public Flag K() {
        return (Flag) this.e.get(M());
    }

    public List L() {
        return this.e;
    }

    public int M() {
        for (int i = 0; i < this.e.size(); i++) {
            if (((Flag) this.e.get(i)).isActivated()) {
                return i;
            }
        }
        return 0;
    }

    public boolean N() {
        return g() == 0;
    }

    public final /* synthetic */ void O(Flag flag, View view) {
        this.d.O0(flag);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public void v(b bVar, int i) {
        final Flag flag = (Flag) this.e.get(i);
        bVar.z.b.setText(flag.getShow());
        bVar.z.b.setActivated(flag.isActivated());
        bVar.z.b.setOnClickListener(new View.OnClickListener() { // from class: m21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.O(flag, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public b x(ViewGroup viewGroup, int i) {
        return new b(i4.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }

    public void R() {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            Collections.reverse(((Flag) it.next()).getEpisodes());
        }
    }

    public void S(Flag flag) {
        if (!this.e.contains(flag)) {
            flag.setFlag(((Flag) this.e.get(0)).getFlag());
        }
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((Flag) it.next()).setActivated(flag);
        }
        p(0, g());
    }

    public void T(Episode episode) {
        for (Flag flag : this.e) {
            flag.toggle(flag.isActivated(), episode);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int g() {
        return this.e.size();
    }
}
