package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.fongmi.android.tv.bean.Vod;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class hz3 extends rh {
    public final a e;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void a(Vod vod);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends RecyclerView.g0 {
        public final q4 z;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(q4 q4Var) {
            super(q4Var.getRoot());
            this.z = q4Var;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public hz3(a aVar) {
        this.e = aVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void Z(Vod vod, View view) {
        this.e.a(vod);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: v(Landroidx/recyclerview/widget/RecyclerView$g0;I)V */
    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public void v(b bVar, int i) {
        final Vod vod = (Vod) M(i);
        bVar.z.c.setText(vod.getName());
        bVar.z.e.setText(vod.getSiteName());
        bVar.z.d.setText(vod.getRemarks());
        bVar.z.e.setVisibility(vod.getSiteVisible());
        bVar.z.d.setVisibility(vod.getRemarkVisible());
        bVar.z.getRoot().setOnClickListener(new View.OnClickListener() { // from class: gz3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.Z(vod, view);
            }
        });
        si1.h(vod.getName(), vod.getPic(), bVar.z.b);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: x(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$g0; */
    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public b x(ViewGroup viewGroup, int i) {
        return new b(q4.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: C(Landroidx/recyclerview/widget/RecyclerView$g0;)V */
    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public void C(b bVar) {
        com.bumptech.glide.a.u(bVar.z.b).o(bVar.z.b);
    }
}
