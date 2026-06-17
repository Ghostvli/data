package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.fongmi.android.tv.bean.Channel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class rr extends RecyclerView.h {
    public final a d;
    public final List e = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        boolean f0(Channel channel);

        void i0(Channel channel);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends RecyclerView.g0 {
        public final z3 z;

        public b(z3 z3Var) {
            super(z3Var.getRoot());
            this.z = z3Var;
        }
    }

    public rr(a aVar) {
        this.d = aVar;
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

    public final /* synthetic */ void K(Channel channel, View view) {
        this.d.i0(channel);
    }

    public final /* synthetic */ boolean L(Channel channel, View view) {
        return this.d.f0(channel);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public void v(b bVar, int i) {
        final Channel channel = (Channel) this.e.get(i);
        channel.loadLogo(bVar.z.b);
        bVar.z.c.setText(channel.getShow());
        bVar.z.d.setText(channel.getNumber());
        bVar.z.getRoot().setSelected(channel.isSelected());
        bVar.z.getRoot().setOnClickListener(new View.OnClickListener() { // from class: pr
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.K(channel, view);
            }
        });
        bVar.z.getRoot().setOnLongClickListener(new View.OnLongClickListener() { // from class: qr
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f.L(channel, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public b x(ViewGroup viewGroup, int i) {
        return new b(z3.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public void C(b bVar) {
        com.bumptech.glide.a.u(bVar.z.b).o(bVar.z.b);
    }

    public void P(Channel channel) {
        int iIndexOf = this.e.indexOf(channel);
        if (iIndexOf == -1) {
            return;
        }
        this.e.remove(iIndexOf);
        t(iIndexOf);
    }

    public int Q(Channel channel) {
        int iIndexOf = this.e.indexOf(channel);
        R(iIndexOf);
        return iIndexOf;
    }

    public void R(int i) {
        if (i == -1) {
            return;
        }
        int i2 = 0;
        while (i2 < this.e.size()) {
            ((Channel) this.e.get(i2)).setSelected(i2 == i);
            i2++;
        }
        p(0, g());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int g() {
        return this.e.size();
    }
}
