package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.fongmi.android.tv.bean.Live;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class gw1 extends RecyclerView.h {
    public final a d;
    public final List e = lx1.J().P();
    public boolean f;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void a(int i, Live live);

        boolean b(Live live);

        boolean c(Live live);

        void d(int i, Live live);

        void e(Live live);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends RecyclerView.g0 {
        public final k4 z;

        public b(k4 k4Var) {
            super(k4Var.getRoot());
            this.z = k4Var;
        }
    }

    public gw1(a aVar) {
        this.d = aVar;
    }

    public final /* synthetic */ void L(Live live, View view) {
        this.d.e(live);
    }

    public final /* synthetic */ void M(int i, Live live, View view) {
        this.d.d(i, live);
    }

    public final /* synthetic */ void N(int i, Live live, View view) {
        this.d.a(i, live);
    }

    public final /* synthetic */ boolean O(Live live, View view) {
        return this.d.c(live);
    }

    public final /* synthetic */ boolean P(Live live, View view) {
        return this.d.b(live);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void v(b bVar, final int i) {
        final Live live = (Live) this.e.get(i);
        bVar.z.d.setText(live.getName());
        bVar.z.d.setSelected(live.isActivated());
        bVar.z.d.setActivated(live.isActivated());
        bVar.z.b.setImageResource(live.getBootIcon());
        bVar.z.c.setImageResource(live.getPassIcon());
        bVar.z.b.setVisibility(this.f ? 0 : 8);
        bVar.z.c.setVisibility(this.f ? 0 : 8);
        bVar.z.d.setOnClickListener(new View.OnClickListener() { // from class: bw1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.L(live, view);
            }
        });
        bVar.z.b.setOnClickListener(new View.OnClickListener() { // from class: cw1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.M(i, live, view);
            }
        });
        bVar.z.c.setOnClickListener(new View.OnClickListener() { // from class: dw1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.N(i, live, view);
            }
        });
        bVar.z.b.setOnLongClickListener(new View.OnLongClickListener() { // from class: ew1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f.O(live, view);
            }
        });
        bVar.z.c.setOnLongClickListener(new View.OnLongClickListener() { // from class: fw1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f.P(live, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public b x(ViewGroup viewGroup, int i) {
        return new b(k4.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }

    public void S(boolean z) {
        this.f = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int g() {
        return this.e.size();
    }
}
