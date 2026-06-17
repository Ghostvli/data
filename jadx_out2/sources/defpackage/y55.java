package defpackage;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.fongmi.android.tv.bean.Style;
import com.fongmi.android.tv.bean.Vod;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class y55 extends rh {
    public final a e;
    public final Style f;
    public final int[] g;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        boolean D(Vod vod);

        void a(Vod vod);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public y55(a aVar, Style style, int[] iArr) {
        this.e = aVar;
        this.f = style;
        this.g = iArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Style Y() {
        return this.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: v(Landroidx/recyclerview/widget/RecyclerView$g0;I)V */
    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public void v(gj gjVar, int i) {
        gjVar.N((Vod) M(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: x(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$g0; */
    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public gj x(ViewGroup viewGroup, int i) {
        return i != 1 ? i != 2 ? new x75(z4.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false), this.e).T(this.g) : new r75(x4.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false), this.e) : new u75(y4.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false), this.e).T(this.g);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: C(Landroidx/recyclerview/widget/RecyclerView$g0;)V */
    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public void C(gj gjVar) {
        gjVar.O();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int i(int i) {
        return this.f.getViewType();
    }
}
