package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.fongmi.android.tv.bean.Result;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class fj3 extends RecyclerView.h {
    public final a d;
    public Result e = Result.empty();
    public int f;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void D0(Result result);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends RecyclerView.g0 {
        public final n4 z;

        public b(n4 n4Var) {
            super(n4Var.getRoot());
            this.z = n4Var;
        }
    }

    public fj3(a aVar) {
        this.d = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(int i, View view) {
        M(i);
    }

    public void H(Result result) {
        this.e = result;
        l();
    }

    public int I() {
        return this.f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public void v(b bVar, final int i) {
        bVar.z.b.setText(this.e.getUrl().n(i));
        bVar.z.b.setOnClickListener(new View.OnClickListener() { // from class: ej3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.J(i, view);
            }
        });
        bVar.z.b.setActivated(this.e.getUrl().getPosition() == i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public b x(ViewGroup viewGroup, int i) {
        return new b(n4.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }

    public final void M(int i) {
        this.f = i;
        this.e.getUrl().set(i);
        this.d.D0(this.e);
        p(0, g());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int g() {
        return this.e.getUrl().getValues().size();
    }
}
