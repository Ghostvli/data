package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.fongmi.android.tv.bean.Group;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class mb1 extends RecyclerView.h {
    public final a d;
    public final List e = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void S(Group group);

        void Z(Group group);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends RecyclerView.g0 {
        public final j4 z;

        public b(j4 j4Var) {
            super(j4Var.getRoot());
            this.z = j4Var;
        }
    }

    public mb1(a aVar) {
        this.d = aVar;
    }

    public void H(Group group) {
        this.e.add(group);
        n(g() - 1);
    }

    public void I(List list) {
        this.e.clear();
        this.e.addAll(list);
        l();
    }

    public void J() {
        this.e.clear();
        l();
    }

    public Group K(int i) {
        return (Group) this.e.get(i);
    }

    public int L() {
        for (int i = 0; i < this.e.size(); i++) {
            if (((Group) this.e.get(i)).isSelected()) {
                return i;
            }
        }
        return 0;
    }

    public int M(Group group) {
        return this.e.indexOf(group);
    }

    public final /* synthetic */ void N(Group group, View view) {
        this.d.Z(group);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public void v(b bVar, int i) {
        final Group group = (Group) this.e.get(i);
        bVar.z.b.setText(group.getName());
        bVar.z.getRoot().setSelected(group.isSelected());
        bVar.z.getRoot().setOnClickListener(new View.OnClickListener() { // from class: lb1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.N(group, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public b x(ViewGroup viewGroup, int i) {
        return new b(j4.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }

    public void Q(int i) {
        int i2 = 0;
        while (i2 < this.e.size()) {
            ((Group) this.e.get(i2)).setSelected(i2 == i);
            i2++;
        }
        p(0, g());
        this.d.S((Group) this.e.get(i));
    }

    public void R(Group group) {
        Q(M(group));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int g() {
        return this.e.size();
    }
}
