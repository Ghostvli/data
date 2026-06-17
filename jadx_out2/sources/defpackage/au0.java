package defpackage;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.fongmi.android.tv.bean.Episode;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class au0 extends RecyclerView.h {
    public final a d;
    public final List e;
    public final int f;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void E(Episode episode);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public au0(a aVar, int i, ArrayList arrayList) {
        this.d = aVar;
        this.f = i;
        this.e = arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void G(List list) {
        this.e.clear();
        this.e.addAll(list);
        l();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Episode H() {
        return (Episode) this.e.get(K());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List I() {
        return this.e;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Episode J() {
        int iK = K();
        int iG = g() - 1;
        int i = iK + 1;
        if (i <= iG) {
            iG = i;
        }
        return (Episode) this.e.get(iG);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int K() {
        for (int i = 0; i < this.e.size(); i++) {
            if (((Episode) this.e.get(i)).isActivated()) {
                return i;
            }
        }
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Episode L() {
        int iK = K() - 1;
        if (iK < 0) {
            iK = 0;
        }
        return (Episode) this.e.get(iK);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean M() {
        return g() == 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: v(Landroidx/recyclerview/widget/RecyclerView$g0;I)V */
    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public void v(th thVar, int i) {
        thVar.N((Episode) this.e.get(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: x(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$g0; */
    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public th x(ViewGroup viewGroup, int i) {
        return i == 0 ? new iu0(g4.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false), this.d) : new gu0(f4.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false), this.d);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int g() {
        return this.e.size();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int i(int i) {
        return this.f;
    }

    public au0(a aVar, int i) {
        this(aVar, i, new ArrayList());
    }
}
