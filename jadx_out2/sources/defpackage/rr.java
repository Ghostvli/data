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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(z3 z3Var) {
            super(z3Var.getRoot());
            this.z = z3Var;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public rr(a aVar) {
        this.d = aVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void I(List list) {
        this.e.clear();
        this.e.addAll(list);
        l();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void J() {
        this.e.clear();
        l();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void K(Channel channel, View view) {
        this.d.i0(channel);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ boolean L(Channel channel, View view) {
        return this.d.f0(channel);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: v(Landroidx/recyclerview/widget/RecyclerView$g0;I)V */
    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public void v(b bVar, int i) {
        final Channel channel = (Channel) this.e.get(i);
        channel.loadLogo(bVar.z.b);
        bVar.z.c.setText(channel.getShow());
        bVar.z.d.setText(channel.getNumber());
        bVar.z.getRoot().setSelected(channel.isSelected());
        bVar.z.getRoot().setOnClickListener(new View.OnClickListener() { // from class: pr
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.K(channel, view);
            }
        });
        bVar.z.getRoot().setOnLongClickListener(new View.OnLongClickListener() { // from class: qr
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f.L(channel, view);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: x(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$g0; */
    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public b x(ViewGroup viewGroup, int i) {
        return new b(z3.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: C(Landroidx/recyclerview/widget/RecyclerView$g0;)V */
    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public void C(b bVar) {
        com.bumptech.glide.a.u(bVar.z.b).o(bVar.z.b);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void P(Channel channel) {
        int iIndexOf = this.e.indexOf(channel);
        if (iIndexOf == -1) {
            return;
        }
        this.e.remove(iIndexOf);
        t(iIndexOf);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int Q(Channel channel) {
        int iIndexOf = this.e.indexOf(channel);
        R(iIndexOf);
        return iIndexOf;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int g() {
        return this.e.size();
    }
}
