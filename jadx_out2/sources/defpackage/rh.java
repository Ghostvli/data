package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.d;
import j$.util.stream.Stream$EL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class rh extends RecyclerView.h {
    public final d d = new d(this, new xh());

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void a(boolean z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void G() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void I(List list) {
        J(list, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void J(List list, Runnable runnable) {
        ArrayList arrayList = new ArrayList(N());
        arrayList.addAll(list);
        T(arrayList, runnable);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void K() {
        L(null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void L(Runnable runnable) {
        T(new ArrayList(), runnable);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public nl0 M(int i) {
        return (nl0) this.d.a().get(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List N() {
        return this.d.a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean O(List list, List list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            nl0 nl0Var = (nl0) list.get(i);
            nl0 nl0Var2 = (nl0) list2.get(i);
            if (!nl0Var.isSameItem(nl0Var2) || !nl0Var.isSameContent(nl0Var2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void P(nl0 nl0Var) {
        Q(nl0Var, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Q(nl0 nl0Var, Runnable runnable) {
        ArrayList arrayList = new ArrayList(N());
        if (arrayList.remove(nl0Var)) {
            T(arrayList, runnable);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void R(List list) {
        T(list, new Runnable() { // from class: ph
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                rh.G();
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void S(List list, final a aVar) {
        List listN = N();
        List list2 = (List) oh.a(list, new dx1());
        if (O(listN, list2)) {
            aVar.a(false);
        } else {
            this.d.d(list2, new Runnable() { // from class: qh
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    aVar.a(true);
                }
            });
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void T(List list, Runnable runnable) {
        this.d.d((List) oh.a(list, new dx1()), runnable);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void U(nl0 nl0Var) {
        V(nl0Var, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void V(nl0 nl0Var, Runnable runnable) {
        T(Stream$EL.toList(Stream.concat(N().stream(), Stream.of(nl0Var)).distinct().sorted()), runnable);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void W(List list) {
        X(list, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void X(List list, Runnable runnable) {
        T(Stream$EL.toList(Stream.concat(N().stream(), list.stream()).distinct().sorted()), runnable);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int g() {
        return this.d.a().size();
    }
}
