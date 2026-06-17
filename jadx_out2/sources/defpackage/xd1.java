package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.fongmi.android.tv.bean.History;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class xd1 extends rh {
    public final a e;
    public int f;
    public int g;
    public boolean h = true;
    public boolean i;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void B0(History history);

        void R(History history);

        boolean v();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends RecyclerView.g0 {
        public final w4 z;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(w4 w4Var) {
            super(w4Var.getRoot());
            this.z = w4Var;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public xd1(a aVar) {
        this.e = aVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.rh
    public void K() {
        super.K();
        g0(false);
        History.delete(b75.K());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean a0() {
        return this.i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ boolean b0(View view) {
        return this.e.v();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void c0(History history, View view) {
        boolean zA0 = a0();
        a aVar = this.e;
        if (zA0) {
            aVar.R(history);
        } else {
            aVar.B0(history);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: v(Landroidx/recyclerview/widget/RecyclerView$g0;I)V */
    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public void v(b bVar, int i) {
        History history = (History) M(i);
        boolean zEquals = history.getVodName().equals(history.getVodRemarks());
        bVar.z.d.setText(history.getVodName());
        bVar.z.g.setText(history.getSiteName());
        bVar.z.f.setText(history.getVodRemarks());
        bVar.z.g.setVisibility(history.getSiteVisible());
        bVar.z.e.setMax((int) history.getDuration());
        bVar.z.e.setProgress((int) history.getPosition(), this.h);
        bVar.z.b.setVisibility(!this.i ? 8 : 0);
        bVar.z.f.setVisibility((this.i || zEquals) ? 8 : 0);
        si1.h(history.getVodName(), history.getVodPic(), bVar.z.c);
        f0(bVar.z.getRoot(), history);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: x(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$g0; */
    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public b x(ViewGroup viewGroup, int i) {
        b bVar = new b(w4.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
        bVar.z.getRoot().getLayoutParams().width = this.f;
        bVar.z.c.getLayoutParams().height = this.g;
        return bVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f0(View view, final History history) {
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: vd1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                return this.f.b0(view2);
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: wd1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f.c0(history, view2);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g0(boolean z) {
        this.h = false;
        this.i = z;
        p(0, g());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void h0(int[] iArr) {
        this.f = iArr[0];
        this.g = iArr[1];
    }
}
