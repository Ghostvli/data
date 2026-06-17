package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.fongmi.android.tv.bean.Keep;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class eq1 extends rh {
    public final a e;
    public int f;
    public int g;
    public boolean h;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void h0(Keep keep);

        boolean v();

        void v0(Keep keep);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends RecyclerView.g0 {
        public final w4 z;

        public b(w4 w4Var) {
            super(w4Var.getRoot());
            this.z = w4Var;
        }
    }

    public eq1(a aVar) {
        this.e = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean b0(View view) {
        return this.e.v();
    }

    @Override // defpackage.rh
    public void K() {
        super.K();
        g0(false);
        Keep.deleteAll();
    }

    public boolean a0() {
        return this.h;
    }

    public final /* synthetic */ void c0(Keep keep, View view) {
        boolean zA0 = a0();
        a aVar = this.e;
        if (zA0) {
            aVar.v0(keep);
        } else {
            aVar.h0(keep);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public void v(b bVar, int i) {
        Keep keep = (Keep) M(i);
        bVar.z.d.setText(keep.getVodName());
        bVar.z.f.setVisibility(8);
        bVar.z.g.setVisibility(0);
        bVar.z.g.setText(keep.getSiteName());
        bVar.z.e.setVisibility(8);
        bVar.z.b.setVisibility(this.h ? 0 : 8);
        si1.h(keep.getVodName(), keep.getVodPic(), bVar.z.c);
        f0(bVar.z.getRoot(), keep);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public b x(ViewGroup viewGroup, int i) {
        b bVar = new b(w4.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
        bVar.z.getRoot().getLayoutParams().width = this.f;
        bVar.z.c.getLayoutParams().height = this.g;
        return bVar;
    }

    public final void f0(View view, final Keep keep) {
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: cq1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                return this.f.b0(view2);
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: dq1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f.c0(keep, view2);
            }
        });
    }

    public void g0(boolean z) {
        this.h = z;
        p(0, g());
    }

    public void h0(int[] iArr) {
        this.f = iArr[0];
        this.g = iArr[1];
    }
}
